package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.os.IBinder;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.ae;
/* loaded from: classes.dex */
public class ReaderPbService extends BdBaseService {
    private boolean isAlive;
    private ae mReaderManager;
    private af mReaderModel;
    private String postId;
    private String threadId;
    private BdUniqueId mTagId = BdUniqueId.gen();
    private CustomMessageListener mPassDataListener = new CustomMessageListener(CmdConfigCustom.CMD_TTS_TRANSFOR_PBDATA) { // from class: com.baidu.tieba.pb.pb.main.ReaderPbService.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ad)) {
                ad adVar = (ad) customResponsedMessage.getData();
                BdUniqueId bdUniqueId = adVar.tag;
                if (bdUniqueId != null && ReaderPbService.this.mTagId.getId() != bdUniqueId.getId()) {
                    ReaderPbService.this.releasePbReaderModel();
                    ReaderPbService.this.releaseReadManager();
                    ReaderPbService.this.mTagId = bdUniqueId;
                    ReaderPbService.this.mReaderManager = new ae();
                    ReaderPbService.this.mReaderModel = new af();
                    ReaderPbService.this.mReaderModel.n(ReaderPbService.this.mTagId);
                    ReaderPbService.this.mReaderManager.a(ReaderPbService.this.mRefreshCallback);
                    ReaderPbService.this.mReaderModel.b(ReaderPbService.this.mLoadDataCallback);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_READER_TAG_CHANGED, ReaderPbService.this.mTagId));
                }
                ReaderPbService.this.threadId = adVar.threadId;
                ReaderPbService.this.postId = adVar.postId;
                ReaderPbService.this.isAlive = adVar.isAlive;
                ReaderPbService.this.setReadModel(adVar);
                if (adVar.ePd >= 0) {
                    ReaderPbService.this.mReaderManager.b(adVar.pbData, adVar.isSquence, adVar.loadType, adVar.ePc);
                    ReaderPbService.this.mReaderManager.ePe = adVar.ePe;
                    ReaderPbService.this.mReaderManager.B(adVar.ePd, adVar.ePf);
                } else if (adVar.ePd == -2) {
                    ReaderPbService.this.mReaderManager.a(adVar.pbData, adVar.isSquence, adVar.loadType, adVar.ePc, false);
                } else {
                    ReaderPbService.this.mReaderManager.b(adVar.pbData, adVar.isSquence, adVar.loadType, adVar.ePc);
                }
            }
        }
    };
    private CustomMessageListener menuOptionListener = new CustomMessageListener(CmdConfigCustom.CMD_TTS_MENU_OPTION) { // from class: com.baidu.tieba.pb.pb.main.ReaderPbService.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (intValue == 1) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10833").aa("obj_locate", "1"));
                    ReaderPbService.this.mRefreshCallback.bk(ReaderPbService.this.mReaderManager.ePd, ReaderPbService.this.mReaderManager.aTe());
                } else if (intValue == 2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10833").aa("obj_locate", "2"));
                    ReaderPbService.this.mRefreshCallback.aTh();
                }
            }
        }
    };
    private CustomMessageListener audioPowerChangeListener = new CustomMessageListener(CmdConfigCustom.CMD_TTS_CHANGE_PB_POWER) { // from class: com.baidu.tieba.pb.pb.main.ReaderPbService.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ad)) {
                ad adVar = (ad) customResponsedMessage.getData();
                BdUniqueId bdUniqueId = adVar.tag;
                if (bdUniqueId != null && ReaderPbService.this.mTagId.getId() != bdUniqueId.getId()) {
                    ReaderPbService.this.mTagId = bdUniqueId;
                    ReaderPbService.this.mReaderModel.n(ReaderPbService.this.mTagId);
                }
                ReaderPbService.this.threadId = adVar.threadId;
                ReaderPbService.this.postId = adVar.postId;
                ReaderPbService.this.isAlive = adVar.isAlive;
                ReaderPbService.this.setReadModel(adVar);
                if (adVar.ePd >= 0) {
                    ReaderPbService.this.mReaderManager.a(adVar.pbData, adVar.isSquence, adVar.loadType, adVar.ePc, false);
                    int aTd = ReaderPbService.this.mReaderManager.aTd();
                    if (aTd == 1 || aTd == 3) {
                        ReaderPbService.this.mReaderManager.pq(0);
                    } else {
                        ReaderPbService.this.mReaderManager.pq(1);
                    }
                    ReaderPbService.this.mReaderManager.B(adVar.ePd, adVar.ePf);
                    return;
                }
                ReaderPbService.this.mReaderManager.a(adVar.pbData, adVar.isSquence, adVar.loadType, adVar.ePc, true);
            }
        }
    };
    private ae.a mRefreshCallback = new ae.a() { // from class: com.baidu.tieba.pb.pb.main.ReaderPbService.4
        @Override // com.baidu.tieba.pb.pb.main.ae.a
        public void aTg() {
            if (!ReaderPbService.this.isAlive) {
                if (ReaderPbService.this.mReaderModel != null && ReaderPbService.this.mReaderModel != null) {
                    ReaderPbService.this.mReaderModel.pC(ReaderPbService.this.threadId);
                    return;
                }
                return;
            }
            com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
            aVar.tag = ReaderPbService.this.mTagId;
            aVar.eYF = 0;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
        }

        @Override // com.baidu.tieba.pb.pb.main.ae.a
        public void aTh() {
            if (!ReaderPbService.this.isAlive) {
                if (ReaderPbService.this.mReaderModel != null) {
                    ReaderPbService.this.mReaderModel.aTi();
                    return;
                }
                return;
            }
            com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
            aVar.tag = ReaderPbService.this.mTagId;
            aVar.eYF = 1;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
        }

        @Override // com.baidu.tieba.pb.pb.main.ae.a
        public void bk(int i, int i2) {
            if (ReaderPbService.this.isAlive) {
                com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
                aVar.tag = ReaderPbService.this.mTagId;
                aVar.eYF = 2;
                aVar.eYG = ReaderPbService.this.mReaderManager.ePd;
                aVar.eYH = ReaderPbService.this.mReaderManager.aTe();
                String str = "";
                if (ReaderPbService.this.mReaderManager.aTf() != null) {
                    str = ReaderPbService.this.mReaderManager.aTf().getId();
                }
                aVar.postId = str;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
                return;
            }
            String str2 = "";
            if (ReaderPbService.this.mReaderManager.aTf() != null) {
                str2 = ReaderPbService.this.mReaderManager.aTf().getId();
            }
            boolean z = ReaderPbService.this.mReaderManager.ePi;
            boolean z2 = ReaderPbService.this.mReaderManager.isSquence;
            int i3 = ReaderPbService.this.mReaderManager.ePd;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(ReaderPbService.this);
            pbActivityConfig.createReaderServiceCfg(ReaderPbService.this.threadId, str2, i3, z, z2, null);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        }
    };
    private PbModel.a mLoadDataCallback = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.ReaderPbService.5
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void c(com.baidu.tieba.pb.data.f fVar) {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            if (!ReaderPbService.this.isAlive && ReaderPbService.this.mReaderManager != null && ReaderPbService.this.mReaderModel != null) {
                ReaderPbService.this.mReaderManager.b(ReaderPbService.this.mReaderModel.getPbData(), ReaderPbService.this.mReaderModel.aTj(), i2, ReaderPbService.this.mReaderModel.aTk());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void setReadModel(ad adVar) {
        if (adVar != null) {
            if (this.mReaderModel == null) {
                this.mReaderModel = new af();
                this.mReaderModel.n(this.mTagId);
                this.mReaderModel.b(this.mLoadDataCallback);
            }
            this.mReaderModel.setPbData(adVar.pbData);
            this.mReaderModel.jB(adVar.eGI);
            this.mReaderModel.setHostMode(adVar.ePc);
            this.mReaderModel.jA(adVar.isSquence);
            this.mReaderModel.setThreadId(this.threadId);
            this.mReaderModel.setPostId(this.postId);
            this.mReaderModel.jC(this.isAlive);
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
