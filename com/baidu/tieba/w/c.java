package com.baidu.tieba.w;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.coreExtra.data.ai;
import com.baidu.tieba.w.b;
import java.io.File;
/* loaded from: classes.dex */
public class c {
    private String mQf;
    private String mVideoPath;
    private boolean isLoading = false;
    private b.a mQe = new b.a() { // from class: com.baidu.tieba.w.c.1
        @Override // com.baidu.tieba.w.b.a
        public void b(boolean z, String str, String str2) {
            c.this.isLoading = false;
            if (z) {
                c.this.mVideoPath = str;
                com.baidu.tbadk.core.sharedPref.b.bjf().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_PATH, c.this.mVideoPath);
                c.this.mQf = str2;
                com.baidu.tbadk.core.sharedPref.b.bjf().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_URL, c.this.mQf);
            }
        }
    };
    private CustomMessageListener dWP = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.w.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String string = com.baidu.tbadk.core.sharedPref.b.bjf().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, "");
                ai aiVar = new ai();
                aiVar.parseJson(string);
                c.this.setVideoUrl(aiVar.bnU());
            }
        }
    };

    public c() {
        init();
    }

    private void init() {
        this.isLoading = false;
        this.mQf = com.baidu.tbadk.core.sharedPref.b.bjf().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_URL, null);
        this.mVideoPath = com.baidu.tbadk.core.sharedPref.b.bjf().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_PATH, null);
        MessageManager.getInstance().registerListener(this.dWP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoUrl(String str) {
        if ((com.baidu.tbadk.core.sharedPref.b.bjf().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1) && !this.isLoading && SO(str)) {
            SN(str);
        }
    }

    private void SN(String str) {
        this.isLoading = true;
        new b(getPath(), str, this.mQe).execute(new Void[0]);
    }

    public boolean dIW() {
        if (this.isLoading || at.isEmpty(getVideoPath())) {
            return false;
        }
        if (!new File(getVideoPath()).exists()) {
            this.mVideoPath = null;
            com.baidu.tbadk.core.sharedPref.b.bjf().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_PATH, this.mVideoPath);
            this.mQf = null;
            com.baidu.tbadk.core.sharedPref.b.bjf().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_URL, this.mQf);
            return false;
        }
        return true;
    }

    public String getVideoPath() {
        return this.mVideoPath;
    }

    public void dIX() {
        if (!at.isEmpty(getPath())) {
            n.deleteFileOrDir(new File(getPath()));
            this.mVideoPath = null;
            com.baidu.tbadk.core.sharedPref.b.bjf().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_PATH, this.mVideoPath);
            this.mQf = null;
            com.baidu.tbadk.core.sharedPref.b.bjf().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_URL, this.mQf);
        }
    }

    private boolean SO(String str) {
        return (at.isEmpty(str) || str.equals(this.mQf)) ? false : true;
    }

    private String getPath() {
        return TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + "/videosplash";
    }
}
