package com.baidu.tieba.u;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tieba.u.b;
import java.io.File;
/* loaded from: classes.dex */
public class c {
    private String hEX;
    private String mVideoPath;
    private boolean isLoading = false;
    private b.a hEW = new b.a() { // from class: com.baidu.tieba.u.c.1
        @Override // com.baidu.tieba.u.b.a
        public void a(boolean z, String str, String str2) {
            c.this.isLoading = false;
            if (z) {
                c.this.mVideoPath = str;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_path", c.this.mVideoPath);
                c.this.hEX = str2;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_url", c.this.hEX);
            }
        }
    };
    private CustomMessageListener akD = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.u.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", "");
                x xVar = new x();
                xVar.parseJson(string);
                c.this.setVideoUrl(xVar.FU());
            }
        }
    };

    public c() {
        init();
    }

    private void init() {
        this.isLoading = false;
        this.hEX = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_url", null);
        this.mVideoPath = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_path", null);
        MessageManager.getInstance().registerListener(this.akD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoUrl(String str) {
        if ((com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1) && !this.isLoading && wI(str)) {
            wH(str);
        }
    }

    private void wH(String str) {
        this.isLoading = true;
        new b(getPath(), str, this.hEW).execute(new Void[0]);
    }

    public boolean bJN() {
        if (this.isLoading || ao.isEmpty(getVideoPath())) {
            return false;
        }
        if (!new File(getVideoPath()).exists()) {
            this.mVideoPath = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_path", this.mVideoPath);
            this.hEX = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_url", this.hEX);
            return false;
        }
        return true;
    }

    public String getVideoPath() {
        return this.mVideoPath;
    }

    public void bJO() {
        if (!ao.isEmpty(getPath())) {
            l.x(new File(getPath()));
            this.mVideoPath = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_path", this.mVideoPath);
            this.hEX = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_url", this.hEX);
        }
    }

    private boolean wI(String str) {
        return (ao.isEmpty(str) || str.equals(this.hEX)) ? false : true;
    }

    private String getPath() {
        return TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + "/videosplash";
    }
}
