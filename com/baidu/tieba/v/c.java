package com.baidu.tieba.v;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.coreExtra.data.aa;
import com.baidu.tieba.v.b;
import java.io.File;
/* loaded from: classes.dex */
public class c {
    private String kGk;
    private String mVideoPath;
    private boolean isLoading = false;
    private b.a kGj = new b.a() { // from class: com.baidu.tieba.v.c.1
        @Override // com.baidu.tieba.v.b.a
        public void c(boolean z, String str, String str2) {
            c.this.isLoading = false;
            if (z) {
                c.this.mVideoPath = str;
                com.baidu.tbadk.core.sharedPref.b.aDr().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_PATH, c.this.mVideoPath);
                c.this.kGk = str2;
                com.baidu.tbadk.core.sharedPref.b.aDr().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_URL, c.this.kGk);
            }
        }
    };
    private CustomMessageListener cHC = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.v.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String string = com.baidu.tbadk.core.sharedPref.b.aDr().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, "");
                aa aaVar = new aa();
                aaVar.parseJson(string);
                c.this.setVideoUrl(aaVar.aHm());
            }
        }
    };

    public c() {
        init();
    }

    private void init() {
        this.isLoading = false;
        this.kGk = com.baidu.tbadk.core.sharedPref.b.aDr().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_URL, null);
        this.mVideoPath = com.baidu.tbadk.core.sharedPref.b.aDr().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_PATH, null);
        MessageManager.getInstance().registerListener(this.cHC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoUrl(String str) {
        if ((com.baidu.tbadk.core.sharedPref.b.aDr().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1) && !this.isLoading && Kw(str)) {
            Kv(str);
        }
    }

    private void Kv(String str) {
        this.isLoading = true;
        new b(getPath(), str, this.kGj).execute(new Void[0]);
    }

    public boolean cRQ() {
        if (this.isLoading || aq.isEmpty(getVideoPath())) {
            return false;
        }
        if (!new File(getVideoPath()).exists()) {
            this.mVideoPath = null;
            com.baidu.tbadk.core.sharedPref.b.aDr().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_PATH, this.mVideoPath);
            this.kGk = null;
            com.baidu.tbadk.core.sharedPref.b.aDr().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_URL, this.kGk);
            return false;
        }
        return true;
    }

    public String getVideoPath() {
        return this.mVideoPath;
    }

    public void deleteVideo() {
        if (!aq.isEmpty(getPath())) {
            m.deleteFileOrDir(new File(getPath()));
            this.mVideoPath = null;
            com.baidu.tbadk.core.sharedPref.b.aDr().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_PATH, this.mVideoPath);
            this.kGk = null;
            com.baidu.tbadk.core.sharedPref.b.aDr().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_URL, this.kGk);
        }
    }

    private boolean Kw(String str) {
        return (aq.isEmpty(str) || str.equals(this.kGk)) ? false : true;
    }

    private String getPath() {
        return TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + "/videosplash";
    }
}
