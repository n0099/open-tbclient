package com.baidu.tieba.v;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.coreExtra.data.y;
import com.baidu.tieba.v.b;
import java.io.File;
/* loaded from: classes.dex */
public class c {
    private String hQA;
    private String mVideoPath;
    private boolean isLoading = false;
    private b.a hQz = new b.a() { // from class: com.baidu.tieba.v.c.1
        @Override // com.baidu.tieba.v.b.a
        public void a(boolean z, String str, String str2) {
            c.this.isLoading = false;
            if (z) {
                c.this.mVideoPath = str;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_path", c.this.mVideoPath);
                c.this.hQA = str2;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_url", c.this.hQA);
            }
        }
    };
    private CustomMessageListener aoH = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.v.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", "");
                y yVar = new y();
                yVar.parseJson(string);
                c.this.setVideoUrl(yVar.Hn());
            }
        }
    };

    public c() {
        init();
    }

    private void init() {
        this.isLoading = false;
        this.hQA = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_url", null);
        this.mVideoPath = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_path", null);
        MessageManager.getInstance().registerListener(this.aoH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoUrl(String str) {
        if ((com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1) && !this.isLoading && xE(str)) {
            xD(str);
        }
    }

    private void xD(String str) {
        this.isLoading = true;
        new b(getPath(), str, this.hQz).execute(new Void[0]);
    }

    public boolean bNp() {
        if (this.isLoading || ao.isEmpty(getVideoPath())) {
            return false;
        }
        if (!new File(getVideoPath()).exists()) {
            this.mVideoPath = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_path", this.mVideoPath);
            this.hQA = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_url", this.hQA);
            return false;
        }
        return true;
    }

    public String getVideoPath() {
        return this.mVideoPath;
    }

    public void bNq() {
        if (!ao.isEmpty(getPath())) {
            l.y(new File(getPath()));
            this.mVideoPath = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_path", this.mVideoPath);
            this.hQA = null;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_url", this.hQA);
        }
    }

    private boolean xE(String str) {
        return (ao.isEmpty(str) || str.equals(this.hQA)) ? false : true;
    }

    private String getPath() {
        return TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + "/videosplash";
    }
}
