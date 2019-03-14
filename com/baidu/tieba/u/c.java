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
    private String akM;
    private String jha;
    private boolean isLoading = false;
    private b.a jgZ = new b.a() { // from class: com.baidu.tieba.u.c.1
        @Override // com.baidu.tieba.u.b.a
        public void b(boolean z, String str, String str2) {
            c.this.isLoading = false;
            if (z) {
                c.this.akM = str;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_path", c.this.akM);
                c.this.jha = str2;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_url", c.this.jha);
            }
        }
    };
    private CustomMessageListener bvt = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.u.c.2
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
        this.jha = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_url", null);
        this.akM = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_path", null);
        MessageManager.getInstance().registerListener(this.bvt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoUrl(String str) {
        if ((com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1) && !this.isLoading && Ef(str)) {
            Ee(str);
        }
    }

    private void Ee(String str) {
        this.isLoading = true;
        new b(getPath(), str, this.jgZ).execute(new Void[0]);
    }

    public boolean cmT() {
        if (this.isLoading || ap.isEmpty(getVideoPath())) {
            return false;
        }
        if (!new File(getVideoPath()).exists()) {
            this.akM = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_path", this.akM);
            this.jha = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_url", this.jha);
            return false;
        }
        return true;
    }

    public String getVideoPath() {
        return this.akM;
    }

    public void cmU() {
        if (!ap.isEmpty(getPath())) {
            m.G(new File(getPath()));
            this.akM = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_path", this.akM);
            this.jha = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_url", this.jha);
        }
    }

    private boolean Ef(String str) {
        return (ap.isEmpty(str) || str.equals(this.jha)) ? false : true;
    }

    private String getPath() {
        return TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + "/videosplash";
    }
}
