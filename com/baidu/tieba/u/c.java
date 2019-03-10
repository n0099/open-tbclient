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
    private String akL;
    private String jhi;
    private boolean isLoading = false;
    private b.a jhh = new b.a() { // from class: com.baidu.tieba.u.c.1
        @Override // com.baidu.tieba.u.b.a
        public void b(boolean z, String str, String str2) {
            c.this.isLoading = false;
            if (z) {
                c.this.akL = str;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_path", c.this.akL);
                c.this.jhi = str2;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_url", c.this.jhi);
            }
        }
    };
    private CustomMessageListener bvr = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.u.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", "");
                y yVar = new y();
                yVar.parseJson(string);
                c.this.setVideoUrl(yVar.agG());
            }
        }
    };

    public c() {
        init();
    }

    private void init() {
        this.isLoading = false;
        this.jhi = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_url", null);
        this.akL = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_path", null);
        MessageManager.getInstance().registerListener(this.bvr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoUrl(String str) {
        if ((com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1) && !this.isLoading && Eh(str)) {
            Eg(str);
        }
    }

    private void Eg(String str) {
        this.isLoading = true;
        new b(getPath(), str, this.jhh).execute(new Void[0]);
    }

    public boolean cmQ() {
        if (this.isLoading || ap.isEmpty(getVideoPath())) {
            return false;
        }
        if (!new File(getVideoPath()).exists()) {
            this.akL = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_path", this.akL);
            this.jhi = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_url", this.jhi);
            return false;
        }
        return true;
    }

    public String getVideoPath() {
        return this.akL;
    }

    public void cmR() {
        if (!ap.isEmpty(getPath())) {
            m.G(new File(getPath()));
            this.akL = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_path", this.akL);
            this.jhi = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_url", this.jhi);
        }
    }

    private boolean Eh(String str) {
        return (ap.isEmpty(str) || str.equals(this.jhi)) ? false : true;
    }

    private String getPath() {
        return TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + "/videosplash";
    }
}
