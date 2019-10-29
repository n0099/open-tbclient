package com.baidu.tieba.u;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.coreExtra.data.z;
import com.baidu.tieba.u.b;
import java.io.File;
/* loaded from: classes.dex */
public class c {
    private String aFy;
    private String jJq;
    private boolean isLoading = false;
    private b.a jJp = new b.a() { // from class: com.baidu.tieba.u.c.1
        @Override // com.baidu.tieba.u.b.a
        public void b(boolean z, String str, String str2) {
            c.this.isLoading = false;
            if (z) {
                c.this.aFy = str;
                com.baidu.tbadk.core.sharedPref.b.alR().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_PATH, c.this.aFy);
                c.this.jJq = str2;
                com.baidu.tbadk.core.sharedPref.b.alR().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_URL, c.this.jJq);
            }
        }
    };
    private CustomMessageListener bVR = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.u.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String string = com.baidu.tbadk.core.sharedPref.b.alR().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, "");
                z zVar = new z();
                zVar.parseJson(string);
                c.this.setVideoUrl(zVar.apw());
            }
        }
    };

    public c() {
        init();
    }

    private void init() {
        this.isLoading = false;
        this.jJq = com.baidu.tbadk.core.sharedPref.b.alR().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_URL, null);
        this.aFy = com.baidu.tbadk.core.sharedPref.b.alR().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_PATH, null);
        MessageManager.getInstance().registerListener(this.bVR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoUrl(String str) {
        if ((com.baidu.tbadk.core.sharedPref.b.alR().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1) && !this.isLoading && Fu(str)) {
            Ft(str);
        }
    }

    private void Ft(String str) {
        this.isLoading = true;
        new b(getPath(), str, this.jJp).execute(new Void[0]);
    }

    public boolean cwJ() {
        if (this.isLoading || aq.isEmpty(getVideoPath())) {
            return false;
        }
        if (!new File(getVideoPath()).exists()) {
            this.aFy = null;
            com.baidu.tbadk.core.sharedPref.b.alR().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_PATH, this.aFy);
            this.jJq = null;
            com.baidu.tbadk.core.sharedPref.b.alR().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_URL, this.jJq);
            return false;
        }
        return true;
    }

    public String getVideoPath() {
        return this.aFy;
    }

    public void cwK() {
        if (!aq.isEmpty(getPath())) {
            m.deleteFileOrDir(new File(getPath()));
            this.aFy = null;
            com.baidu.tbadk.core.sharedPref.b.alR().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_PATH, this.aFy);
            this.jJq = null;
            com.baidu.tbadk.core.sharedPref.b.alR().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_URL, this.jJq);
        }
    }

    private boolean Fu(String str) {
        return (aq.isEmpty(str) || str.equals(this.jJq)) ? false : true;
    }

    private String getPath() {
        return TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + "/videosplash";
    }
}
