package com.baidu.tieba.w;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.coreExtra.data.ab;
import com.baidu.tieba.w.b;
import java.io.File;
/* loaded from: classes.dex */
public class c {
    private String kHk;
    private String mVideoPath;
    private boolean isLoading = false;
    private b.a kHj = new b.a() { // from class: com.baidu.tieba.w.c.1
        @Override // com.baidu.tieba.w.b.a
        public void c(boolean z, String str, String str2) {
            c.this.isLoading = false;
            if (z) {
                c.this.mVideoPath = str;
                com.baidu.tbadk.core.sharedPref.b.aFB().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_PATH, c.this.mVideoPath);
                c.this.kHk = str2;
                com.baidu.tbadk.core.sharedPref.b.aFB().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_URL, c.this.kHk);
            }
        }
    };
    private CustomMessageListener cLF = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.w.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String string = com.baidu.tbadk.core.sharedPref.b.aFB().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, "");
                ab abVar = new ab();
                abVar.parseJson(string);
                c.this.setVideoUrl(abVar.aJF());
            }
        }
    };

    public c() {
        init();
    }

    private void init() {
        this.isLoading = false;
        this.kHk = com.baidu.tbadk.core.sharedPref.b.aFB().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_URL, null);
        this.mVideoPath = com.baidu.tbadk.core.sharedPref.b.aFB().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_PATH, null);
        MessageManager.getInstance().registerListener(this.cLF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoUrl(String str) {
        if ((com.baidu.tbadk.core.sharedPref.b.aFB().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1) && !this.isLoading && KJ(str)) {
            KI(str);
        }
    }

    private void KI(String str) {
        this.isLoading = true;
        new b(getPath(), str, this.kHj).execute(new Void[0]);
    }

    public boolean cTn() {
        if (this.isLoading || aq.isEmpty(getVideoPath())) {
            return false;
        }
        if (!new File(getVideoPath()).exists()) {
            this.mVideoPath = null;
            com.baidu.tbadk.core.sharedPref.b.aFB().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_PATH, this.mVideoPath);
            this.kHk = null;
            com.baidu.tbadk.core.sharedPref.b.aFB().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_URL, this.kHk);
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
            com.baidu.tbadk.core.sharedPref.b.aFB().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_PATH, this.mVideoPath);
            this.kHk = null;
            com.baidu.tbadk.core.sharedPref.b.aFB().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_URL, this.kHk);
        }
    }

    private boolean KJ(String str) {
        return (aq.isEmpty(str) || str.equals(this.kHk)) ? false : true;
    }

    private String getPath() {
        return TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + "/videosplash";
    }
}
