package com.baidu.tieba.w;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.coreExtra.data.ae;
import com.baidu.tieba.w.b;
import java.io.File;
/* loaded from: classes.dex */
public class c {
    private String mVideoPath;
    private String mgW;
    private boolean isLoading = false;
    private b.a mgV = new b.a() { // from class: com.baidu.tieba.w.c.1
        @Override // com.baidu.tieba.w.b.a
        public void c(boolean z, String str, String str2) {
            c.this.isLoading = false;
            if (z) {
                c.this.mVideoPath = str;
                com.baidu.tbadk.core.sharedPref.b.aVP().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_PATH, c.this.mVideoPath);
                c.this.mgW = str2;
                com.baidu.tbadk.core.sharedPref.b.aVP().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_URL, c.this.mgW);
            }
        }
    };
    private CustomMessageListener dFw = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.w.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String string = com.baidu.tbadk.core.sharedPref.b.aVP().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, "");
                ae aeVar = new ae();
                aeVar.parseJson(string);
                c.this.setVideoUrl(aeVar.bat());
            }
        }
    };

    public c() {
        init();
    }

    private void init() {
        this.isLoading = false;
        this.mgW = com.baidu.tbadk.core.sharedPref.b.aVP().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_URL, null);
        this.mVideoPath = com.baidu.tbadk.core.sharedPref.b.aVP().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_PATH, null);
        MessageManager.getInstance().registerListener(this.dFw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoUrl(String str) {
        if ((com.baidu.tbadk.core.sharedPref.b.aVP().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1) && !this.isLoading && OI(str)) {
            OH(str);
        }
    }

    private void OH(String str) {
        this.isLoading = true;
        new b(getPath(), str, this.mgV).execute(new Void[0]);
    }

    public boolean dqo() {
        if (this.isLoading || ar.isEmpty(getVideoPath())) {
            return false;
        }
        if (!new File(getVideoPath()).exists()) {
            this.mVideoPath = null;
            com.baidu.tbadk.core.sharedPref.b.aVP().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_PATH, this.mVideoPath);
            this.mgW = null;
            com.baidu.tbadk.core.sharedPref.b.aVP().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_URL, this.mgW);
            return false;
        }
        return true;
    }

    public String getVideoPath() {
        return this.mVideoPath;
    }

    public void dqp() {
        if (!ar.isEmpty(getPath())) {
            n.deleteFileOrDir(new File(getPath()));
            this.mVideoPath = null;
            com.baidu.tbadk.core.sharedPref.b.aVP().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_PATH, this.mVideoPath);
            this.mgW = null;
            com.baidu.tbadk.core.sharedPref.b.aVP().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_URL, this.mgW);
        }
    }

    private boolean OI(String str) {
        return (ar.isEmpty(str) || str.equals(this.mgW)) ? false : true;
    }

    private String getPath() {
        return TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + "/videosplash";
    }
}
