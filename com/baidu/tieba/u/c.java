package com.baidu.tieba.u;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tieba.u.b;
import java.io.File;
/* loaded from: classes.dex */
public class c {
    private String bnB;
    private String hoh;
    private boolean isLoading = false;
    private b.a hog = new b.a() { // from class: com.baidu.tieba.u.c.1
        @Override // com.baidu.tieba.u.b.a
        public void b(boolean z, String str, String str2) {
            c.this.isLoading = false;
            if (z) {
                c.this.bnB = str;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_path", c.this.bnB);
                c.this.hoh = str2;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_url", c.this.hoh);
            }
        }
    };
    private CustomMessageListener acq = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.u.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", "");
                u uVar = new u();
                uVar.parseJson(string);
                c.this.setVideoUrl(uVar.Cw());
            }
        }
    };

    public c() {
        init();
    }

    private void init() {
        this.isLoading = false;
        this.hoh = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_url", null);
        this.bnB = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_path", null);
        MessageManager.getInstance().registerListener(this.acq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoUrl(String str) {
        if ((com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1) && !this.isLoading && vp(str)) {
            vo(str);
        }
    }

    private void vo(String str) {
        this.isLoading = true;
        new b(getPath(), str, this.hog).execute(new Void[0]);
    }

    public boolean bEj() {
        if (this.isLoading || ap.isEmpty(getVideoPath())) {
            return false;
        }
        if (!new File(getVideoPath()).exists()) {
            this.bnB = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_path", this.bnB);
            this.hoh = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_url", this.hoh);
            return false;
        }
        return true;
    }

    public String getVideoPath() {
        return this.bnB;
    }

    public void bEk() {
        if (!ap.isEmpty(getPath())) {
            l.r(new File(getPath()));
            this.bnB = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_path", this.bnB);
            this.hoh = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_url", this.hoh);
        }
    }

    private boolean vp(String str) {
        return (ap.isEmpty(str) || str.equals(this.hoh)) ? false : true;
    }

    private String getPath() {
        return TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + "/videosplash";
    }
}
