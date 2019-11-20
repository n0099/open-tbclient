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
    private String aFg;
    private String jIz;
    private boolean isLoading = false;
    private b.a jIy = new b.a() { // from class: com.baidu.tieba.u.c.1
        @Override // com.baidu.tieba.u.b.a
        public void b(boolean z, String str, String str2) {
            c.this.isLoading = false;
            if (z) {
                c.this.aFg = str;
                com.baidu.tbadk.core.sharedPref.b.alP().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_PATH, c.this.aFg);
                c.this.jIz = str2;
                com.baidu.tbadk.core.sharedPref.b.alP().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_URL, c.this.jIz);
            }
        }
    };
    private CustomMessageListener bVa = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.u.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String string = com.baidu.tbadk.core.sharedPref.b.alP().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, "");
                z zVar = new z();
                zVar.parseJson(string);
                c.this.setVideoUrl(zVar.apu());
            }
        }
    };

    public c() {
        init();
    }

    private void init() {
        this.isLoading = false;
        this.jIz = com.baidu.tbadk.core.sharedPref.b.alP().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_URL, null);
        this.aFg = com.baidu.tbadk.core.sharedPref.b.alP().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_PATH, null);
        MessageManager.getInstance().registerListener(this.bVa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoUrl(String str) {
        if ((com.baidu.tbadk.core.sharedPref.b.alP().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1) && !this.isLoading && Fu(str)) {
            Ft(str);
        }
    }

    private void Ft(String str) {
        this.isLoading = true;
        new b(getPath(), str, this.jIy).execute(new Void[0]);
    }

    public boolean cwH() {
        if (this.isLoading || aq.isEmpty(getVideoPath())) {
            return false;
        }
        if (!new File(getVideoPath()).exists()) {
            this.aFg = null;
            com.baidu.tbadk.core.sharedPref.b.alP().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_PATH, this.aFg);
            this.jIz = null;
            com.baidu.tbadk.core.sharedPref.b.alP().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_URL, this.jIz);
            return false;
        }
        return true;
    }

    public String getVideoPath() {
        return this.aFg;
    }

    public void cwI() {
        if (!aq.isEmpty(getPath())) {
            m.deleteFileOrDir(new File(getPath()));
            this.aFg = null;
            com.baidu.tbadk.core.sharedPref.b.alP().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_PATH, this.aFg);
            this.jIz = null;
            com.baidu.tbadk.core.sharedPref.b.alP().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_URL, this.jIz);
        }
    }

    private boolean Fu(String str) {
        return (aq.isEmpty(str) || str.equals(this.jIz)) ? false : true;
    }

    private String getPath() {
        return TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + "/videosplash";
    }
}
