package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes9.dex */
public class BackgroundPreviewModel extends BdBaseModel<BackgroundPreviewModel> {
    private com.baidu.adp.framework.listener.a jaH = new com.baidu.adp.framework.listener.a(1003035, CmdConfigSocket.CMD_PERSONAL_BACKGROUND_GET) { // from class: com.baidu.tieba.themeCenter.background.BackgroundPreviewModel.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof BackgroundGetHttpResponseMessage) || (responsedMessage instanceof BackgroundGetSocketResponseMessage)) {
                    if (responsedMessage.getError() == 0) {
                        if (responsedMessage instanceof BackgroundGetHttpResponseMessage) {
                            BackgroundPreviewModel.this.mBgItem = ((BackgroundGetHttpResponseMessage) responsedMessage).getBgItem();
                        } else if (responsedMessage instanceof BackgroundGetSocketResponseMessage) {
                            BackgroundPreviewModel.this.mBgItem = ((BackgroundGetSocketResponseMessage) responsedMessage).getBgItem();
                        }
                    }
                    if (BackgroundPreviewModel.this.nCg != null) {
                        if (BackgroundPreviewModel.this.mBgItem != null) {
                            BackgroundPreviewModel.this.mBgItem.setPropsId(BackgroundPreviewModel.this.nBB);
                            BackgroundPreviewModel.this.mBgItem.setInUse(BackgroundPreviewModel.this.nBV == 1);
                        }
                        BackgroundPreviewModel.this.nCg.a(responsedMessage.getError(), responsedMessage.getErrorString(), BackgroundPreviewModel.this.mBgItem);
                    }
                }
            }
        }
    };
    private DressItemData mBgItem;
    private int nBB;
    private int nBV;
    private a nCg;

    /* loaded from: classes9.dex */
    public interface a {
        void a(int i, String str, DressItemData dressItemData);
    }

    public BackgroundPreviewModel(int i, int i2) {
        this.nBB = i;
        this.nBV = i2;
        registerTask();
        registerListener(this.jaH);
    }

    private void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_PERSONAL_BACKGROUND_GET, BackgroundGetSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_PERSONAL_BACKGROUND_GET, 1003035, TbConfig.PERSONAL_BACKGROUND_GET, BackgroundGetHttpResponseMessage.class, false, false, false, false);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        BackgroundGetRequestMessage backgroundGetRequestMessage = new BackgroundGetRequestMessage();
        backgroundGetRequestMessage.setPropId(this.nBB);
        sendMessage(backgroundGetRequestMessage);
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void a(a aVar) {
        this.nCg = aVar;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.jaH);
    }
}
