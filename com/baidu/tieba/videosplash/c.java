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
    private String bTf;
    private String hzw;
    private boolean isLoading = false;
    private b.a hzv = new b.a() { // from class: com.baidu.tieba.videosplash.c.1
        @Override // com.baidu.tieba.videosplash.b.a
        public void b(boolean z, String str, String str2) {
            c.this.isLoading = false;
            if (z) {
                c.this.bTf = str;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_path", c.this.bTf);
                c.this.hzw = str2;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_url", c.this.hzw);
            }
        }
    };
    private CustomMessageListener aJr = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.videosplash.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", "");
                u uVar = new u();
                uVar.parseJson(string);
                c.this.setVideoUrl(uVar.FZ());
            }
        }
    };

    public c() {
        init();
    }

    private void init() {
        this.isLoading = false;
        this.hzw = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_url", null);
        this.bTf = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_path", null);
        MessageManager.getInstance().registerListener(this.aJr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoUrl(String str) {
        if ((com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1) && !this.isLoading && ui(str)) {
            uh(str);
        }
    }

    private void uh(String str) {
        this.isLoading = true;
        new b(getPath(), str, this.hzv).execute(new Void[0]);
    }

    public boolean bED() {
        if (this.isLoading || am.isEmpty(getVideoPath())) {
            return false;
        }
        if (!new File(getVideoPath()).exists()) {
            this.bTf = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_path", this.bTf);
            this.hzw = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_url", this.hzw);
            return false;
        }
        return true;
    }

    public String getVideoPath() {
        return this.bTf;
    }

    public void bEE() {
        if (!am.isEmpty(getPath())) {
            k.s(new File(getPath()));
            this.bTf = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_path", this.bTf);
            this.hzw = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_url", this.hzw);
        }
    }

    private boolean ui(String str) {
        return (am.isEmpty(str) || str.equals(this.hzw)) ? false : true;
    }

    private String getPath() {
        return TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + "/videosplash";
    }
}
