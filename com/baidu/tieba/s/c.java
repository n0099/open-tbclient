package com.baidu.tieba.s;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tieba.s.b;
import java.io.File;
/* loaded from: classes.dex */
public class c {
    private String bdm;
    private String gXs;
    private boolean isLoading = false;
    private b.a gXr = new b.a() { // from class: com.baidu.tieba.s.c.1
        @Override // com.baidu.tieba.s.b.a
        public void b(boolean z, String str, String str2) {
            c.this.isLoading = false;
            if (z) {
                c.this.bdm = str;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_path", c.this.bdm);
                c.this.gXs = str2;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_url", c.this.gXs);
            }
        }
    };
    private CustomMessageListener UJ = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.s.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", "");
                u uVar = new u();
                uVar.parseJson(string);
                c.this.setVideoUrl(uVar.yM());
            }
        }
    };

    public c() {
        init();
    }

    private void init() {
        this.isLoading = false;
        this.gXs = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_url", null);
        this.bdm = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_path", null);
        MessageManager.getInstance().registerListener(this.UJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoUrl(String str) {
        if ((com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1) && !this.isLoading && uy(str)) {
            ux(str);
        }
    }

    private void ux(String str) {
        this.isLoading = true;
        new b(getPath(), str, this.gXr).execute(new Void[0]);
    }

    public boolean bzT() {
        if (this.isLoading || an.isEmpty(getVideoPath())) {
            return false;
        }
        if (!new File(getVideoPath()).exists()) {
            this.bdm = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_path", this.bdm);
            this.gXs = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_url", this.gXs);
            return false;
        }
        return true;
    }

    public String getVideoPath() {
        return this.bdm;
    }

    public void bzU() {
        if (!an.isEmpty(getPath())) {
            k.r(new File(getPath()));
            this.bdm = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_path", this.bdm);
            this.gXs = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_url", this.gXs);
        }
    }

    private boolean uy(String str) {
        return (an.isEmpty(str) || str.equals(this.gXs)) ? false : true;
    }

    private String getPath() {
        return TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + "/videosplash";
    }
}
