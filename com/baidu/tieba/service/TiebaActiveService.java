package com.baidu.tieba.service;

import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
/* loaded from: classes.dex */
public class TiebaActiveService extends BdBaseService {
    private static final int ACTIVE_FAIL = 1;
    private static final int ACTIVE_SUCC = 2;
    private m mActiveTask = null;
    private int mHaveRetry = 0;
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new l(this);

    private String getChannelByShare() {
        return com.baidu.tbadk.core.sharedPref.b.og().getString("channel_id", null);
    }

    private void saveChannelToShare(String str) {
        if (str != null && str.length() > 0) {
            com.baidu.tbadk.core.sharedPref.b.og().putString("channel_id", str);
        }
    }

    private String getChannelyFile() {
        String str = null;
        try {
            File cj = com.baidu.tbadk.core.util.s.cj(TbConfig.CHANNEL_FILE);
            if (cj != null) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(cj));
                str = bufferedReader.readLine();
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            TiebaStatic.file(e, "TiebaActiveService.getChannelyFile");
        }
        return str;
    }

    private void saveChannelToFile(String str) {
        if (str != null && str.length() > 0) {
            try {
                File cl = com.baidu.tbadk.core.util.s.cl(TbConfig.CHANNEL_FILE);
                if (cl != null) {
                    FileWriter fileWriter = new FileWriter(cl);
                    fileWriter.append((CharSequence) str);
                    fileWriter.flush();
                    fileWriter.close();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaStatic.file(e, "TiebaActiveService.saveChannelToFile");
            }
        }
    }

    private boolean isActived() {
        try {
            String channelByShare = getChannelByShare();
            if (channelByShare == null) {
                String channelyFile = getChannelyFile();
                if (channelyFile != null && channelyFile.length() > 0) {
                    saveChannelToShare(channelyFile);
                } else {
                    if ("aishide" != 0 && "aishide".length() > 0) {
                        saveChannelToShare("aishide");
                        saveChannelToFile("aishide");
                    }
                    return false;
                }
            } else {
                saveChannelToFile(channelByShare);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return true;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (isActived() && com.baidu.tbadk.core.sharedPref.b.og().getInt("active", 2) != 1) {
            stopSelf();
        } else {
            sendActive();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.mActiveTask != null) {
            this.mActiveTask.cancel();
        }
        this.mHaveRetry = 11;
        this.mHandler.removeCallbacks(this.mRunnable);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendActive() {
        if (this.mActiveTask != null) {
            this.mActiveTask.cancel();
        }
        this.mActiveTask = new m(this, null);
        this.mActiveTask.execute(new String[0]);
    }
}
