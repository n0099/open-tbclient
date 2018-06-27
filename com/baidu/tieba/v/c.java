package com.baidu.tieba.v;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tieba.v.b;
import java.io.File;
/* loaded from: classes.dex */
public class c {
    private String bmV;
    private String hmZ;
    private boolean isLoading = false;
    private b.a hmY = new b.a() { // from class: com.baidu.tieba.v.c.1
        @Override // com.baidu.tieba.v.b.a
        public void b(boolean z, String str, String str2) {
            c.this.isLoading = false;
            if (z) {
                c.this.bmV = str;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_path", c.this.bmV);
                c.this.hmZ = str2;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_url", c.this.hmZ);
            }
        }
    };
    private CustomMessageListener acM = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.v.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", "");
                u uVar = new u();
                uVar.parseJson(string);
                c.this.setVideoUrl(uVar.CE());
            }
        }
    };

    public c() {
        init();
    }

    private void init() {
        this.isLoading = false;
        this.hmZ = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_url", null);
        this.bmV = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_path", null);
        MessageManager.getInstance().registerListener(this.acM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoUrl(String str) {
        if ((com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1) && !this.isLoading && vo(str)) {
            vn(str);
        }
    }

    private void vn(String str) {
        this.isLoading = true;
        new b(getPath(), str, this.hmY).execute(new Void[0]);
    }

    public boolean bFy() {
        if (this.isLoading || ap.isEmpty(getVideoPath())) {
            return false;
        }
        if (!new File(getVideoPath()).exists()) {
            this.bmV = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_path", this.bmV);
            this.hmZ = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_url", this.hmZ);
            return false;
        }
        return true;
    }

    public String getVideoPath() {
        return this.bmV;
    }

    public void bFz() {
        if (!ap.isEmpty(getPath())) {
            l.r(new File(getPath()));
            this.bmV = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_path", this.bmV);
            this.hmZ = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_url", this.hmZ);
        }
    }

    private boolean vo(String str) {
        return (ap.isEmpty(str) || str.equals(this.hmZ)) ? false : true;
    }

    private String getPath() {
        return TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + "/videosplash";
    }
}
