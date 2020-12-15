package com.baidu.tieba.x;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.coreExtra.data.ai;
import com.baidu.tieba.x.b;
import java.io.File;
/* loaded from: classes.dex */
public class c {
    private String mVideoPath;
    private String nNq;
    private boolean isLoading = false;
    private b.a nNp = new b.a() { // from class: com.baidu.tieba.x.c.1
        @Override // com.baidu.tieba.x.b.a
        public void b(boolean z, String str, String str2) {
            c.this.isLoading = false;
            if (z) {
                c.this.mVideoPath = str;
                com.baidu.tbadk.core.sharedPref.b.bsO().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_PATH, c.this.mVideoPath);
                c.this.nNq = str2;
                com.baidu.tbadk.core.sharedPref.b.bsO().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_URL, c.this.nNq);
            }
        }
    };
    private CustomMessageListener eCA = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.x.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String string = com.baidu.tbadk.core.sharedPref.b.bsO().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, "");
                ai aiVar = new ai();
                aiVar.parseJson(string);
                c.this.setVideoUrl(aiVar.bxN());
            }
        }
    };

    public c() {
        init();
    }

    private void init() {
        this.isLoading = false;
        this.nNq = com.baidu.tbadk.core.sharedPref.b.bsO().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_URL, null);
        this.mVideoPath = com.baidu.tbadk.core.sharedPref.b.bsO().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_PATH, null);
        MessageManager.getInstance().registerListener(this.eCA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoUrl(String str) {
        if ((com.baidu.tbadk.core.sharedPref.b.bsO().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1) && !this.isLoading && Vs(str)) {
            Vr(str);
        }
    }

    private void Vr(String str) {
        this.isLoading = true;
        new b(getPath(), str, this.nNp).execute(new Void[0]);
    }

    public boolean dXM() {
        if (this.isLoading || au.isEmpty(getVideoPath())) {
            return false;
        }
        if (!new File(getVideoPath()).exists()) {
            this.mVideoPath = null;
            com.baidu.tbadk.core.sharedPref.b.bsO().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_PATH, this.mVideoPath);
            this.nNq = null;
            com.baidu.tbadk.core.sharedPref.b.bsO().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_URL, this.nNq);
            return false;
        }
        return true;
    }

    public String getVideoPath() {
        return this.mVideoPath;
    }

    public void dXN() {
        if (!au.isEmpty(getPath())) {
            n.deleteFileOrDir(new File(getPath()));
            this.mVideoPath = null;
            com.baidu.tbadk.core.sharedPref.b.bsO().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_PATH, this.mVideoPath);
            this.nNq = null;
            com.baidu.tbadk.core.sharedPref.b.bsO().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_URL, this.nNq);
        }
    }

    private boolean Vs(String str) {
        return (au.isEmpty(str) || str.equals(this.nNq)) ? false : true;
    }

    private String getPath() {
        return TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + "/videosplash";
    }
}
