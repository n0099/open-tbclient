package com.baidu.tieba.v;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tieba.v.b;
import java.io.File;
/* loaded from: classes.dex */
public class c {
    private String blw;
    private String hiU;
    private boolean isLoading = false;
    private b.a hiT = new b.a() { // from class: com.baidu.tieba.v.c.1
        @Override // com.baidu.tieba.v.b.a
        public void b(boolean z, String str, String str2) {
            c.this.isLoading = false;
            if (z) {
                c.this.blw = str;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_path", c.this.blw);
                c.this.hiU = str2;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_url", c.this.hiU);
            }
        }
    };
    private CustomMessageListener acJ = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.v.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", "");
                u uVar = new u();
                uVar.parseJson(string);
                c.this.setVideoUrl(uVar.Cm());
            }
        }
    };

    public c() {
        init();
    }

    private void init() {
        this.isLoading = false;
        this.hiU = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_url", null);
        this.blw = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_path", null);
        MessageManager.getInstance().registerListener(this.acJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoUrl(String str) {
        if ((com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1) && !this.isLoading && vs(str)) {
            vr(str);
        }
    }

    private void vr(String str) {
        this.isLoading = true;
        new b(getPath(), str, this.hiT).execute(new Void[0]);
    }

    public boolean bEY() {
        if (this.isLoading || ao.isEmpty(getVideoPath())) {
            return false;
        }
        if (!new File(getVideoPath()).exists()) {
            this.blw = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_path", this.blw);
            this.hiU = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_url", this.hiU);
            return false;
        }
        return true;
    }

    public String getVideoPath() {
        return this.blw;
    }

    public void bEZ() {
        if (!ao.isEmpty(getPath())) {
            l.r(new File(getPath()));
            this.blw = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_path", this.blw);
            this.hiU = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_url", this.hiU);
        }
    }

    private boolean vs(String str) {
        return (ao.isEmpty(str) || str.equals(this.hiU)) ? false : true;
    }

    private String getPath() {
        return TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + "/videosplash";
    }
}
