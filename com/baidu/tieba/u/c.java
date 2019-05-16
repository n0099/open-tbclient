package com.baidu.tieba.u;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.coreExtra.data.y;
import com.baidu.tieba.u.b;
import java.io.File;
/* loaded from: classes.dex */
public class c {
    private String ald;
    private String jzJ;
    private boolean isLoading = false;
    private b.a jzI = new b.a() { // from class: com.baidu.tieba.u.c.1
        @Override // com.baidu.tieba.u.b.a
        public void b(boolean z, String str, String str2) {
            c.this.isLoading = false;
            if (z) {
                c.this.ald = str;
                com.baidu.tbadk.core.sharedPref.b.agM().putString("key_video_splash_path", c.this.ald);
                c.this.jzJ = str2;
                com.baidu.tbadk.core.sharedPref.b.agM().putString("key_video_splash_url", c.this.jzJ);
            }
        }
    };
    private CustomMessageListener bCA = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.u.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String string = com.baidu.tbadk.core.sharedPref.b.agM().getString("key_video_splash_config", "");
                y yVar = new y();
                yVar.parseJson(string);
                c.this.setVideoUrl(yVar.alC());
            }
        }
    };

    public c() {
        init();
    }

    private void init() {
        this.isLoading = false;
        this.jzJ = com.baidu.tbadk.core.sharedPref.b.agM().getString("key_video_splash_url", null);
        this.ald = com.baidu.tbadk.core.sharedPref.b.agM().getString("key_video_splash_path", null);
        MessageManager.getInstance().registerListener(this.bCA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoUrl(String str) {
        if ((com.baidu.tbadk.core.sharedPref.b.agM().getInt("key_video_splash_switch", 0) == 1) && !this.isLoading && FA(str)) {
            Fz(str);
        }
    }

    private void Fz(String str) {
        this.isLoading = true;
        new b(getPath(), str, this.jzI).execute(new Void[0]);
    }

    public boolean cuU() {
        if (this.isLoading || ap.isEmpty(getVideoPath())) {
            return false;
        }
        if (!new File(getVideoPath()).exists()) {
            this.ald = null;
            com.baidu.tbadk.core.sharedPref.b.agM().putString("key_video_splash_path", this.ald);
            this.jzJ = null;
            com.baidu.tbadk.core.sharedPref.b.agM().putString("key_video_splash_url", this.jzJ);
            return false;
        }
        return true;
    }

    public String getVideoPath() {
        return this.ald;
    }

    public void cuV() {
        if (!ap.isEmpty(getPath())) {
            m.A(new File(getPath()));
            this.ald = null;
            com.baidu.tbadk.core.sharedPref.b.agM().putString("key_video_splash_path", this.ald);
            this.jzJ = null;
            com.baidu.tbadk.core.sharedPref.b.agM().putString("key_video_splash_url", this.jzJ);
        }
    }

    private boolean FA(String str) {
        return (ap.isEmpty(str) || str.equals(this.jzJ)) ? false : true;
    }

    private String getPath() {
        return TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + "/videosplash";
    }
}
