package com.baidu.tieba.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.data.PullMessageData;
import com.baidu.tieba.pb.PbActivity;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.TiebaLog;
import java.util.Date;
import java.util.Random;
/* loaded from: classes.dex */
public class MessagePullService extends Service {
    private static final String MESSAGE_ID = "message_id";
    private Handler mHandler;
    private MsgAsyncTask task = null;
    private PullMessageData mData = null;
    private Runnable pullRunnable = new Runnable() { // from class: com.baidu.tieba.service.MessagePullService.1
        @Override // java.lang.Runnable
        public void run() {
            MessagePullService.this.pullMessage();
            MessagePullService.this.mHandler.removeCallbacks(MessagePullService.this.pullRunnable);
            MessagePullService.this.mHandler.postDelayed(MessagePullService.this.pullRunnable, Config.PULL_MESSAGE_INTERVAL.longValue());
        }
    };

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mData = new PullMessageData();
        this.mHandler = new Handler();
        Random mRandom = new Random(System.currentTimeMillis());
        TiebaLog.i(getClass().getName(), "onCreate", "Create message service");
        if (TiebaApplication.app.isPromotedMessageOn()) {
            this.mHandler.removeCallbacks(this.pullRunnable);
            this.mHandler.postDelayed(this.pullRunnable, mRandom.nextLong() % Config.PULL_MESSAGE_INTERVAL.longValue());
            return;
        }
        stopSelf();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacks(this.pullRunnable);
        if (this.task != null) {
            this.task.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pullMessage() {
        if (this.task != null) {
            this.task.cancel();
        }
        this.task = new MsgAsyncTask(this, null);
        this.task.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class MsgAsyncTask extends AsyncTask<String, Integer, String> {
        NetWork mNetWork;

        private MsgAsyncTask() {
            this.mNetWork = null;
        }

        /* synthetic */ MsgAsyncTask(MessagePullService messagePullService, MsgAsyncTask msgAsyncTask) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(String... params) {
            TiebaLog.i(getClass().getName(), "doBackGround", "pull message...");
            try {
                this.mNetWork = new NetWork("http://c.tieba.baidu.com/c/m/getmsg");
                this.mNetWork.addPostData(MessagePullService.MESSAGE_ID, String.valueOf(TiebaApplication.app.getMessageID()));
                String data = this.mNetWork.postNetData();
                return data;
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "doBackground", ex.toString());
                return null;
            }
        }

        public void cancel() {
            MessagePullService.this.task = null;
            if (this.mNetWork != null) {
                this.mNetWork.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String result) {
            super.onPostExecute((MsgAsyncTask) result);
            if (this.mNetWork.isNetSuccess()) {
                TiebaLog.i(getClass().getName(), "onPostExecute", "result=" + result);
                if (this.mNetWork.isRequestSuccess()) {
                    MessagePullService.this.mData.parserJson(result);
                    if (MessagePullService.this.mData.getMessageID() > TiebaApplication.app.getMessageID()) {
                        TiebaApplication.app.setMessageID(MessagePullService.this.mData.getMessageID());
                        MessagePullService.showNotification(MessagePullService.this, MessagePullService.this.mData);
                    }
                }
            }
            MessagePullService.this.task = null;
        }
    }

    static void showNotification(Context context, PullMessageData message) {
        Intent intent;
        Date current = new Date(System.currentTimeMillis());
        int hour = current.getHours();
        if ((hour < 0 || hour > 7) && hour < 23) {
            NotificationManager nm = (NotificationManager) context.getSystemService("notification");
            String tickerText = message.getContent();
            String url = message.getLink();
            if (TiebaApplication.app.isPromotedMessageOn()) {
                Notification notif = new Notification(R.drawable.icon, tickerText, System.currentTimeMillis());
                if (url != null && url.length() > 0) {
                    if (url.startsWith("http:")) {
                        String id = url.substring(url.lastIndexOf("/") + 1);
                        intent = new Intent(context, PbActivity.class);
                        intent.putExtra("id", id);
                        intent.putExtra("sequence", true);
                        intent.putExtra("is_message_pv", true);
                        intent.putExtra("hostMode", false);
                        intent.putExtra(PbActivity.MESSAGE_PUSH_ENTRY, true);
                        intent.setFlags(268435456);
                    } else if (url.equals("tab://1")) {
                        intent = new Intent(context, MainTabActivity.class);
                        intent.putExtra("is_message_pv", true);
                        intent.putExtra(MainTabActivity.KEY_REFRESH, true);
                        intent.putExtra(MainTabActivity.KEY_CLOSE_DIALOG, true);
                        intent.putExtra(MainTabActivity.GOTO_TYPE, MainTabActivity.GOTO_RECOMMEND);
                        intent.setFlags(603979776);
                    } else {
                        return;
                    }
                    PendingIntent contentIntent = PendingIntent.getActivity(context, 0, intent, 134217728);
                    String from = context.getString(R.string.app_name);
                    notif.icon = R.drawable.icon;
                    notif.setLatestEventInfo(context, from, tickerText, contentIntent);
                    notif.defaults = -1;
                    notif.defaults &= -3;
                    notif.flags |= 16;
                    notif.audioStreamType = 5;
                    nm.notify(11, notif);
                }
            }
        }
    }
}
