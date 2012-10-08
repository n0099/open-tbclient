package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.data.MessageData;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.TiebaLog;
/* loaded from: classes.dex */
public class TiebaMessageService extends Service {
    private static final int MESSAGE_GET_MESSAGE = 1;
    private MsgAsyncTask mAsyncTask = null;
    private MessageData mData = null;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.service.TiebaMessageService.1
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (msg.what != 1) {
                return;
            }
            TiebaMessageService.this.getMsg();
            long frequency = TiebaApplication.app.getMsgFrequency();
            if (frequency > 0) {
                TiebaMessageService.this.mHandler.sendEmptyMessageDelayed(1, 1000 * frequency);
            } else {
                TiebaMessageService.this.stopSelf();
            }
        }
    };

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeMessages(1);
        if (this.mAsyncTask != null) {
            this.mAsyncTask.cancel();
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        if (!TiebaApplication.IS_APP_RUNNING || !TiebaApplication.app.isMsgRemindOn()) {
            stopSelf();
            return;
        }
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessageDelayed(1, 3000L);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getMsg() {
        try {
            if (TiebaApplication.getCurrentAccount() != null && TiebaApplication.getCurrentAccountName() != null) {
                if (this.mAsyncTask != null) {
                    this.mAsyncTask.cancel();
                }
                this.mAsyncTask = new MsgAsyncTask();
                this.mAsyncTask.execute(new String[0]);
            }
        } catch (Exception e) {
            TiebaLog.e(getClass().getName(), "getMsg", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void broadcastMsg() {
        if (this.mData != null && this.mData.getReplyme() >= 0 && this.mData.getAtme() >= 0 && this.mData.getFans() >= 0) {
            if (!TiebaApplication.app.isMsgReplymeOn()) {
                this.mData.setReplyme(0L);
            }
            if (!TiebaApplication.app.isMsgAtmeOn()) {
                this.mData.setAtme(0L);
            }
            if (!TiebaApplication.app.isMsgFansOn()) {
                this.mData.setFans(0L);
            }
            Intent intent = new Intent(Config.BROADCAST_SERVICE);
            intent.putExtra(Config.BROADCAST_RELAY_ME_NUM, this.mData.getReplyme());
            intent.putExtra(Config.BROADCAST_AT_ME_NUM, this.mData.getAtme());
            intent.putExtra(Config.BROADCAST_FANS_NUM, this.mData.getFans());
            sendBroadcast(intent);
            TiebaLog.i(getClass().getName(), "broadcastMsg", "sendBroadcast: " + String.format("%d %d %d", Long.valueOf(this.mData.getReplyme()), Long.valueOf(this.mData.getAtme()), Long.valueOf(this.mData.getFans())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class MsgAsyncTask extends AsyncTask<String, Integer, MessageData> {
        NetWork mNetWork = null;

        public MsgAsyncTask() {
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public MessageData doInBackground(String... arg0) {
            MessageData data = null;
            try {
            } catch (Exception e) {
                ex = e;
            }
            if (!TiebaApplication.app.isMsgRemindOn()) {
                return null;
            }
            this.mNetWork = new NetWork("http://c.tieba.baidu.com/c/s/msg");
            String ret = this.mNetWork.postNetData();
            if (this.mNetWork.isRequestSuccess()) {
                MessageData data2 = new MessageData();
                try {
                    data2.parserJson(ret);
                    data = data2;
                } catch (Exception e2) {
                    ex = e2;
                    data = data2;
                    TiebaLog.e(getClass().getName(), "doInBackground", ex.getMessage());
                    return data;
                }
            }
            return data;
        }

        public void cancel() {
            TiebaMessageService.this.mAsyncTask = null;
            if (this.mNetWork != null) {
                this.mNetWork.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(MessageData result) {
            try {
                super.onPostExecute((MsgAsyncTask) result);
                TiebaMessageService.this.mAsyncTask = null;
                if (result != null) {
                    TiebaMessageService.this.mData = result;
                    TiebaMessageService.this.broadcastMsg();
                }
            } catch (Exception e) {
                TiebaLog.e(getClass().getName(), "onPostExecute", e.getMessage());
            }
        }
    }
}
