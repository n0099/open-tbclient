package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.os.IBinder;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.cw;
import com.baidu.tieba.pb.pb.main.dz;
/* loaded from: classes.dex */
public class ReaderPbService extends BdBaseService {
    private boolean isAlive;
    private dz mReaderManager;
    private ec mReaderModel;
    private String postId;
    private String threadId;
    private BdUniqueId mTagId = BdUniqueId.gen();
    private CustomMessageListener mPassDataListener = new fv(this, CmdConfigCustom.CMD_TTS_TRANSFOR_PBDATA);
    private CustomMessageListener menuOptionListener = new fw(this, CmdConfigCustom.CMD_TTS_MENU_OPTION);
    private CustomMessageListener audioPowerChangeListener = new fx(this, CmdConfigCustom.CMD_TTS_CHANGE_PB_POWER);
    private dz.a mRefreshCallback = new fy(this);
    private cw.a mLoadDataCallback = new fz(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void setReadModel(dy dyVar) {
        if (dyVar != null) {
            if (this.mReaderModel == null) {
                this.mReaderModel = new ec();
                this.mReaderModel.m(this.mTagId);
                this.mReaderModel.b(this.mLoadDataCallback);
            }
            this.mReaderModel.setPbData(dyVar.pbData);
            this.mReaderModel.gN(dyVar.dfy);
            this.mReaderModel.setHostMode(dyVar.dmB);
            this.mReaderModel.gM(dyVar.isSquence);
            this.mReaderModel.setThreadId(this.threadId);
            this.mReaderModel.setPostId(this.postId);
            this.mReaderModel.gO(this.isAlive);
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
