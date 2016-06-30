package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.os.IBinder;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.dg;
import com.baidu.tieba.pb.pb.main.eg;
/* loaded from: classes.dex */
public class ReaderPbService extends BdBaseService {
    private boolean isAlive;
    private eg mReaderManager;
    private ej mReaderModel;
    private String postId;
    private String threadId;
    private BdUniqueId mTagId = BdUniqueId.gen();
    private CustomMessageListener mPassDataListener = new gc(this, CmdConfigCustom.CMD_TTS_TRANSFOR_PBDATA);
    private CustomMessageListener menuOptionListener = new gd(this, CmdConfigCustom.CMD_TTS_MENU_OPTION);
    private CustomMessageListener audioPowerChangeListener = new ge(this, CmdConfigCustom.CMD_TTS_CHANGE_PB_POWER);
    private eg.a mRefreshCallback = new gf(this);
    private dg.a mLoadDataCallback = new gg(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void setReadModel(ef efVar) {
        if (efVar != null) {
            if (this.mReaderModel == null) {
                this.mReaderModel = new ej();
                this.mReaderModel.p(this.mTagId);
                this.mReaderModel.b(this.mLoadDataCallback);
            }
            this.mReaderModel.setPbData(efVar.pbData);
            this.mReaderModel.hG(efVar.dMr);
            this.mReaderModel.setHostMode(efVar.dSS);
            this.mReaderModel.hF(efVar.isSquence);
            this.mReaderModel.setThreadId(this.threadId);
            this.mReaderModel.setPostId(this.postId);
            this.mReaderModel.hH(this.isAlive);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public void onCreate() {
        super.onCreate();
        MessageManager.getInstance().registerListener(this.mPassDataListener);
        MessageManager.getInstance().registerListener(this.menuOptionListener);
        MessageManager.getInstance().registerListener(this.audioPowerChangeListener);
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.mPassDataListener);
        MessageManager.getInstance().unRegisterListener(this.menuOptionListener);
        MessageManager.getInstance().unRegisterListener(this.audioPowerChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseReadManager() {
        if (this.mReaderManager != null) {
            this.mReaderManager.clearData();
            this.mReaderManager.destroy();
            this.mReaderManager = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releasePbReaderModel() {
        if (this.mReaderModel != null) {
            this.mReaderModel.onDestroy();
            this.mReaderModel = null;
        }
    }
}
