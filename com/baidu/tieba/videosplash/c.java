package com.baidu.tieba.videosplash;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tieba.videosplash.b;
import java.io.File;
/* loaded from: classes.dex */
public class c {
    private String bTi;
    private String hzU;
    private boolean isLoading = false;
    private b.a hzT = new b.a() { // from class: com.baidu.tieba.videosplash.c.1
        @Override // com.baidu.tieba.videosplash.b.a
        public void b(boolean z, String str, String str2) {
            c.this.isLoading = false;
            if (z) {
                c.this.bTi = str;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_path", c.this.bTi);
                c.this.hzU = str2;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_url", c.this.hzU);
            }
        }
    };
    private CustomMessageListener aJs = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.videosplash.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", "");
                u uVar = new u();
                uVar.parseJson(string);
                c.this.setVideoUrl(uVar.Ga());
            }
        }
    };

    public c() {
        init();
    }

    private void init() {
        this.isLoading = false;
        this.hzU = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_url", null);
        this.bTi = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_path", null);
        MessageManager.getInstance().registerListener(this.aJs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoUrl(String str) {
        if ((com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1) && !this.isLoading && ui(str)) {
            uh(str);
        }
    }

    private void uh(String str) {
        this.isLoading = true;
        new b(getPath(), str, this.hzT).execute(new Void[0]);
    }

    public boolean bEI() {
        if (this.isLoading || am.isEmpty(getVideoPath())) {
            return false;
        }
        if (!new File(getVideoPath()).exists()) {
            this.bTi = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_path", this.bTi);
            this.hzU = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_url", this.hzU);
            return false;
        }
        return true;
    }

    public String getVideoPath() {
        return this.bTi;
    }

    public void bEJ() {
        if (!am.isEmpty(getPath())) {
            k.s(new File(getPath()));
            this.bTi = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_path", this.bTi);
            this.hzU = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_url", this.hzU);
        }
    }

    private boolean ui(String str) {
        return (am.isEmpty(str) || str.equals(this.hzU)) ? false : true;
    }

    private String getPath() {
        return TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + "/videosplash";
    }
}
