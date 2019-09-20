package com.baidu.tieba.u;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.coreExtra.data.z;
import com.baidu.tieba.u.b;
import java.io.File;
/* loaded from: classes.dex */
public class c {
    private String amf;
    private String jJy;
    private boolean isLoading = false;
    private b.a jJx = new b.a() { // from class: com.baidu.tieba.u.c.1
        @Override // com.baidu.tieba.u.b.a
        public void b(boolean z, String str, String str2) {
            c.this.isLoading = false;
            if (z) {
                c.this.amf = str;
                com.baidu.tbadk.core.sharedPref.b.ahU().putString("key_video_splash_path", c.this.amf);
                c.this.jJy = str2;
                com.baidu.tbadk.core.sharedPref.b.ahU().putString("key_video_splash_url", c.this.jJy);
            }
        }
    };
    private CustomMessageListener bDW = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.u.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String string = com.baidu.tbadk.core.sharedPref.b.ahU().getString("key_video_splash_config", "");
                z zVar = new z();
                zVar.parseJson(string);
                c.this.setVideoUrl(zVar.amV());
            }
        }
    };

    public c() {
        init();
    }

    private void init() {
        this.isLoading = false;
        this.jJy = com.baidu.tbadk.core.sharedPref.b.ahU().getString("key_video_splash_url", null);
        this.amf = com.baidu.tbadk.core.sharedPref.b.ahU().getString("key_video_splash_path", null);
        MessageManager.getInstance().registerListener(this.bDW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoUrl(String str) {
        if ((com.baidu.tbadk.core.sharedPref.b.ahU().getInt("key_video_splash_switch", 0) == 1) && !this.isLoading && GS(str)) {
            GR(str);
        }
    }

    private void GR(String str) {
        this.isLoading = true;
        new b(getPath(), str, this.jJx).execute(new Void[0]);
    }

    public boolean cyU() {
        if (this.isLoading || aq.isEmpty(getVideoPath())) {
            return false;
        }
        if (!new File(getVideoPath()).exists()) {
            this.amf = null;
            com.baidu.tbadk.core.sharedPref.b.ahU().putString("key_video_splash_path", this.amf);
            this.jJy = null;
            com.baidu.tbadk.core.sharedPref.b.ahU().putString("key_video_splash_url", this.jJy);
            return false;
        }
        return true;
    }

    public String getVideoPath() {
        return this.amf;
    }

    public void cyV() {
        if (!aq.isEmpty(getPath())) {
            m.A(new File(getPath()));
            this.amf = null;
            com.baidu.tbadk.core.sharedPref.b.ahU().putString("key_video_splash_path", this.amf);
            this.jJy = null;
            com.baidu.tbadk.core.sharedPref.b.ahU().putString("key_video_splash_url", this.jJy);
        }
    }

    private boolean GS(String str) {
        return (aq.isEmpty(str) || str.equals(this.jJy)) ? false : true;
    }

    private String getPath() {
        return TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + "/videosplash";
    }
}
