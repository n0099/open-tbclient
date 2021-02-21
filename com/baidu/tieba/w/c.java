package com.baidu.tieba.w;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.coreExtra.data.ai;
import com.baidu.tieba.w.b;
import java.io.File;
/* loaded from: classes.dex */
public class c {
    private String mVideoPath;
    private String nWx;
    private boolean isLoading = false;
    private b.a nWw = new b.a() { // from class: com.baidu.tieba.w.c.1
        @Override // com.baidu.tieba.w.b.a
        public void b(boolean z, String str, String str2) {
            c.this.isLoading = false;
            if (z) {
                c.this.mVideoPath = str;
                com.baidu.tbadk.core.sharedPref.b.brQ().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_PATH, c.this.mVideoPath);
                c.this.nWx = str2;
                com.baidu.tbadk.core.sharedPref.b.brQ().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_URL, c.this.nWx);
            }
        }
    };
    private CustomMessageListener eJz = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.w.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String string = com.baidu.tbadk.core.sharedPref.b.brQ().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, "");
                ai aiVar = new ai();
                aiVar.parseJson(string);
                c.this.setVideoUrl(aiVar.bwG());
            }
        }
    };

    public c() {
        init();
    }

    private void init() {
        this.isLoading = false;
        this.nWx = com.baidu.tbadk.core.sharedPref.b.brQ().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_URL, null);
        this.mVideoPath = com.baidu.tbadk.core.sharedPref.b.brQ().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_PATH, null);
        MessageManager.getInstance().registerListener(this.eJz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoUrl(String str) {
        if ((com.baidu.tbadk.core.sharedPref.b.brQ().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1) && !this.isLoading && UY(str)) {
            UX(str);
        }
    }

    private void UX(String str) {
        this.isLoading = true;
        new b(getPath(), str, this.nWw).execute(new Void[0]);
    }

    public boolean dVS() {
        if (this.isLoading || au.isEmpty(getVideoPath())) {
            return false;
        }
        if (!new File(getVideoPath()).exists()) {
            this.mVideoPath = null;
            com.baidu.tbadk.core.sharedPref.b.brQ().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_PATH, this.mVideoPath);
            this.nWx = null;
            com.baidu.tbadk.core.sharedPref.b.brQ().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_URL, this.nWx);
            return false;
        }
        return true;
    }

    public String getVideoPath() {
        return this.mVideoPath;
    }

    public void dVT() {
        if (!au.isEmpty(getPath())) {
            o.deleteFileOrDir(new File(getPath()));
            this.mVideoPath = null;
            com.baidu.tbadk.core.sharedPref.b.brQ().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_PATH, this.mVideoPath);
            this.nWx = null;
            com.baidu.tbadk.core.sharedPref.b.brQ().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_URL, this.nWx);
        }
    }

    private boolean UY(String str) {
        return (au.isEmpty(str) || str.equals(this.nWx)) ? false : true;
    }

    private String getPath() {
        return TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + "/videosplash";
    }
}
