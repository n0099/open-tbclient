package com.baidu.tieba.themeCenter.avatarPendant;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import tbclient.T;
/* loaded from: classes9.dex */
public class SetAvatarPendantModel extends BdBaseModel<BaseActivity<T>> {
    public static final int TYPE_SET_USE = 1;
    private int freeUseLevel;
    private a nBd;
    private long pendantId;
    private boolean nBc = false;
    private com.baidu.adp.framework.listener.a jaH = new com.baidu.adp.framework.listener.a(1003179, CmdConfigSocket.CMD_SET_PENDANT) { // from class: com.baidu.tieba.themeCenter.avatarPendant.SetAvatarPendantModel.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof SetPendantHttpResponse) || (responsedMessage instanceof SetPendantSocketResponse)) {
                    if (responsedMessage.getError() == 0) {
                        SetAvatarPendantModel.this.yC(true);
                    } else {
                        SetAvatarPendantModel.this.yC(false);
                    }
                    if (responsedMessage instanceof SetPendantHttpResponse) {
                        SetPendantHttpResponse setPendantHttpResponse = (SetPendantHttpResponse) responsedMessage;
                        SetAvatarPendantModel.this.hE(setPendantHttpResponse.getPendantId());
                        SetAvatarPendantModel.this.freeUseLevel = setPendantHttpResponse.getFreeUseLevel();
                    } else if (responsedMessage instanceof SetPendantSocketResponse) {
                        SetPendantSocketResponse setPendantSocketResponse = (SetPendantSocketResponse) responsedMessage;
                        SetAvatarPendantModel.this.hE(setPendantSocketResponse.getPendantId());
                        SetAvatarPendantModel.this.freeUseLevel = setPendantSocketResponse.getFreeUseLevel();
                    }
                    if (SetAvatarPendantModel.this.nBd != null) {
                        int i = com.baidu.tieba.themeCenter.c.nAx;
                        if (responsedMessage.getError() == com.baidu.tieba.themeCenter.c.nAy) {
                            i = com.baidu.tieba.themeCenter.c.nAw;
                        }
                        SetAvatarPendantModel.this.nBd.a(SetAvatarPendantModel.this.nBc, SetAvatarPendantModel.this.pendantId, SetAvatarPendantModel.this.freeUseLevel, responsedMessage.getErrorString(), i);
                    }
                }
            }
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void a(boolean z, long j, int i, String str, int i2);
    }

    public SetAvatarPendantModel() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_SET_PENDANT, SetPendantSocketResponse.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_SET_PENDANT, 1003179, TbConfig.SET_PENDANT, SetPendantHttpResponse.class, true, true, true, true);
        registerListener(this.jaH);
    }

    public void i(long j, int i, int i2) {
        SetPendantRequest setPendantRequest = new SetPendantRequest();
        setPendantRequest.setPendantId(j);
        setPendantRequest.setType(i);
        setPendantRequest.setFreeUseLevel(i2);
        MessageManager.getInstance().sendMessage(setPendantRequest);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jaH);
    }

    public void hE(long j) {
        this.pendantId = j;
    }

    public void yC(boolean z) {
        this.nBc = z;
    }

    public void a(a aVar) {
        this.nBd = aVar;
    }
}
