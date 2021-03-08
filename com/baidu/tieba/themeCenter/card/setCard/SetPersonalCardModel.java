package com.baidu.tieba.themeCenter.card.setCard;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.themeCenter.c;
import tbclient.T;
/* loaded from: classes8.dex */
public class SetPersonalCardModel extends BdBaseModel<BaseActivity<T>> {
    public static final int TYPE_DELETE_USE = 2;
    public static final int TYPE_SET_USE = 1;
    private long cardId;
    private a nLp;
    private int type;
    private boolean nIO = false;
    private boolean isLoading = false;
    private com.baidu.adp.framework.listener.a jdE = new com.baidu.adp.framework.listener.a(1003095, CmdConfigSocket.CMD_SET_PERSONAL_CARD) { // from class: com.baidu.tieba.themeCenter.card.setCard.SetPersonalCardModel.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            SetPersonalCardModel.this.isLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof SetPersonalCardHttpResponse) || (responsedMessage instanceof SetPersonalCardSocketResponse)) {
                    if (responsedMessage.getError() == 0) {
                        SetPersonalCardModel.this.yQ(true);
                    } else {
                        SetPersonalCardModel.this.yQ(false);
                    }
                    if (responsedMessage instanceof SetPersonalCardHttpResponse) {
                        SetPersonalCardHttpResponse setPersonalCardHttpResponse = (SetPersonalCardHttpResponse) responsedMessage;
                        SetPersonalCardModel.this.setCardId(setPersonalCardHttpResponse.getCardId());
                        SetPersonalCardModel.this.setType(setPersonalCardHttpResponse.getType());
                    } else if (responsedMessage instanceof SetPersonalCardSocketResponse) {
                        SetPersonalCardSocketResponse setPersonalCardSocketResponse = (SetPersonalCardSocketResponse) responsedMessage;
                        SetPersonalCardModel.this.setCardId(setPersonalCardSocketResponse.getCardId());
                        SetPersonalCardModel.this.setType(setPersonalCardSocketResponse.getType());
                    }
                    if (SetPersonalCardModel.this.nLp != null) {
                        int i = c.nIj;
                        if (responsedMessage.getError() == c.nIk) {
                            i = c.nIi;
                        }
                        SetPersonalCardModel.this.nLp.b(SetPersonalCardModel.this.nIO, SetPersonalCardModel.this.cardId, SetPersonalCardModel.this.type, responsedMessage.getErrorString(), i);
                    }
                }
            }
        }
    };

    /* loaded from: classes8.dex */
    public interface a {
        void b(boolean z, long j, int i, String str, int i2);
    }

    public SetPersonalCardModel() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_SET_PERSONAL_CARD, SetPersonalCardSocketResponse.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_SET_PERSONAL_CARD, 1003095, TbConfig.SET_PERSONAL_CARD, SetPersonalCardHttpResponse.class, false, false, false, false);
        registerListener(this.jdE);
    }

    public void J(long j, int i) {
        if (!this.isLoading) {
            this.isLoading = true;
            SetPersonalCardRequest setPersonalCardRequest = new SetPersonalCardRequest();
            setPersonalCardRequest.setCardId(j);
            setPersonalCardRequest.setType(i);
            sendMessage(setPersonalCardRequest);
        }
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

    public void setCardId(long j) {
        this.cardId = j;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void yQ(boolean z) {
        this.nIO = z;
    }

    public void a(a aVar) {
        this.nLp = aVar;
    }
}
