package com.baidu.tieba.w;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.coreExtra.data.ae;
import com.baidu.tieba.w.b;
import java.io.File;
/* loaded from: classes.dex */
public class c {
    private String mVideoPath;
    private String mol;
    private boolean isLoading = false;
    private b.a mok = new b.a() { // from class: com.baidu.tieba.w.c.1
        @Override // com.baidu.tieba.w.b.a
        public void c(boolean z, String str, String str2) {
            c.this.isLoading = false;
            if (z) {
                c.this.mVideoPath = str;
                com.baidu.tbadk.core.sharedPref.b.aZP().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_PATH, c.this.mVideoPath);
                c.this.mol = str2;
                com.baidu.tbadk.core.sharedPref.b.aZP().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_URL, c.this.mol);
            }
        }
    };
    private CustomMessageListener dLt = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.w.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String string = com.baidu.tbadk.core.sharedPref.b.aZP().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, "");
                ae aeVar = new ae();
                aeVar.parseJson(string);
                c.this.setVideoUrl(aeVar.beq());
            }
        }
    };

    public c() {
        init();
    }

    private void init() {
        this.isLoading = false;
        this.mol = com.baidu.tbadk.core.sharedPref.b.aZP().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_URL, null);
        this.mVideoPath = com.baidu.tbadk.core.sharedPref.b.aZP().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_PATH, null);
        MessageManager.getInstance().registerListener(this.dLt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoUrl(String str) {
        if ((com.baidu.tbadk.core.sharedPref.b.aZP().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1) && !this.isLoading && Pq(str)) {
            Pp(str);
        }
    }

    private void Pp(String str) {
        this.isLoading = true;
        new b(getPath(), str, this.mok).execute(new Void[0]);
    }

    public boolean dtx() {
        if (this.isLoading || as.isEmpty(getVideoPath())) {
            return false;
        }
        if (!new File(getVideoPath()).exists()) {
            this.mVideoPath = null;
            com.baidu.tbadk.core.sharedPref.b.aZP().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_PATH, this.mVideoPath);
            this.mol = null;
            com.baidu.tbadk.core.sharedPref.b.aZP().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_URL, this.mol);
            return false;
        }
        return true;
    }

    public String getVideoPath() {
        return this.mVideoPath;
    }

    public void dty() {
        if (!as.isEmpty(getPath())) {
            n.deleteFileOrDir(new File(getPath()));
            this.mVideoPath = null;
            com.baidu.tbadk.core.sharedPref.b.aZP().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_PATH, this.mVideoPath);
            this.mol = null;
            com.baidu.tbadk.core.sharedPref.b.aZP().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_URL, this.mol);
        }
    }

    private boolean Pq(String str) {
        return (as.isEmpty(str) || str.equals(this.mol)) ? false : true;
    }

    private String getPath() {
        return TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + "/videosplash";
    }
}
