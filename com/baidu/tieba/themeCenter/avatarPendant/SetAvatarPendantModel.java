package com.baidu.tieba.themeCenter.avatarPendant;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import tbclient.T;
/* loaded from: classes8.dex */
public class SetAvatarPendantModel extends BdBaseModel<BaseActivity<T>> {
    public static final int TYPE_SET_USE = 1;
    private int freeUseLevel;
    private a nIP;
    private long pendantId;
    private boolean nIO = false;
    private com.baidu.adp.framework.listener.a jdE = new com.baidu.adp.framework.listener.a(1003179, CmdConfigSocket.CMD_SET_PENDANT) { // from class: com.baidu.tieba.themeCenter.avatarPendant.SetAvatarPendantModel.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof SetPendantHttpResponse) || (responsedMessage instanceof SetPendantSocketResponse)) {
                    if (responsedMessage.getError() == 0) {
                        SetAvatarPendantModel.this.yQ(true);
                    } else {
                        SetAvatarPendantModel.this.yQ(false);
                    }
                    if (responsedMessage instanceof SetPendantHttpResponse) {
                        SetPendantHttpResponse setPendantHttpResponse = (SetPendantHttpResponse) responsedMessage;
                        SetAvatarPendantModel.this.hJ(setPendantHttpResponse.getPendantId());
                        SetAvatarPendantModel.this.freeUseLevel = setPendantHttpResponse.getFreeUseLevel();
                    } else if (responsedMessage instanceof SetPendantSocketResponse) {
                        SetPendantSocketResponse setPendantSocketResponse = (SetPendantSocketResponse) responsedMessage;
                        SetAvatarPendantModel.this.hJ(setPendantSocketResponse.getPendantId());
                        SetAvatarPendantModel.this.freeUseLevel = setPendantSocketResponse.getFreeUseLevel();
                    }
                    if (SetAvatarPendantModel.this.nIP != null) {
                        int i = com.baidu.tieba.themeCenter.c.nIj;
                        if (responsedMessage.getError() == com.baidu.tieba.themeCenter.c.nIk) {
                            i = com.baidu.tieba.themeCenter.c.nIi;
                        }
                        SetAvatarPendantModel.this.nIP.a(SetAvatarPendantModel.this.nIO, SetAvatarPendantModel.this.pendantId, SetAvatarPendantModel.this.freeUseLevel, responsedMessage.getErrorString(), i);
                    }
                }
            }
        }
    };

    /* loaded from: classes8.dex */
    public interface a {
        void a(boolean z, long j, int i, String str, int i2);
    }

    public SetAvatarPendantModel() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_SET_PENDANT, SetPendantSocketResponse.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_SET_PENDANT, 1003179, TbConfig.SET_PENDANT, SetPendantHttpResponse.class, true, true, true, true);
        registerListener(this.jdE);
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
        MessageManager.getInstance().unRegisterListener(this.jdE);
    }

    public void hJ(long j) {
        this.pendantId = j;
    }

    public void yQ(boolean z) {
        this.nIO = z;
    }

    public void a(a aVar) {
        this.nIP = aVar;
    }
}
