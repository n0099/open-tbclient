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
    private String bdl;
    private String gWo;
    private boolean isLoading = false;
    private b.a gWn = new b.a() { // from class: com.baidu.tieba.s.c.1
        @Override // com.baidu.tieba.s.b.a
        public void b(boolean z, String str, String str2) {
            c.this.isLoading = false;
            if (z) {
                c.this.bdl = str;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_path", c.this.bdl);
                c.this.gWo = str2;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_url", c.this.gWo);
            }
        }
    };
    private CustomMessageListener UN = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.s.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", "");
                u uVar = new u();
                uVar.parseJson(string);
                c.this.setVideoUrl(uVar.yN());
            }
        }
    };

    public c() {
        init();
    }

    private void init() {
        this.isLoading = false;
        this.gWo = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_url", null);
        this.bdl = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_path", null);
        MessageManager.getInstance().registerListener(this.UN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoUrl(String str) {
        if ((com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1) && !this.isLoading && uv(str)) {
            uu(str);
        }
    }

    private void uu(String str) {
        this.isLoading = true;
        new b(getPath(), str, this.gWn).execute(new Void[0]);
    }

    public boolean bzV() {
        if (this.isLoading || an.isEmpty(getVideoPath())) {
            return false;
        }
        if (!new File(getVideoPath()).exists()) {
            this.bdl = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_path", this.bdl);
            this.gWo = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_url", this.gWo);
            return false;
        }
        return true;
    }

    public String getVideoPath() {
        return this.bdl;
    }

    public void bzW() {
        if (!an.isEmpty(getPath())) {
            k.r(new File(getPath()));
            this.bdl = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_path", this.bdl);
            this.gWo = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_url", this.gWo);
        }
    }

    private boolean uv(String str) {
        return (an.isEmpty(str) || str.equals(this.gWo)) ? false : true;
    }

    private String getPath() {
        return TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + "/videosplash";
    }
}
