package com.baidu.tieba.themeCenter.card.detail;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes9.dex */
public class PersonalCardDetailModel extends BdBaseModel<PersonalCardDetailActivity> {
    private com.baidu.adp.framework.listener.a lkm = new com.baidu.adp.framework.listener.a(1003094, CmdConfigSocket.CMD_GET_CARD_DETAIL) { // from class: com.baidu.tieba.themeCenter.card.detail.PersonalCardDetailModel.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof PersonalCardDetailHttpReponse) || (responsedMessage instanceof PersonalCardDetailSocketReponse)) {
                    if (responsedMessage instanceof PersonalCardDetailHttpReponse) {
                        PersonalCardDetailModel.this.nDh = ((PersonalCardDetailHttpReponse) responsedMessage).getCardData();
                    } else if (responsedMessage instanceof PersonalCardDetailSocketReponse) {
                        PersonalCardDetailModel.this.nDh = ((PersonalCardDetailSocketReponse) responsedMessage).getCardData();
                    }
                    if (PersonalCardDetailModel.this.nDp != null) {
                        PersonalCardDetailModel.this.nDp.b(responsedMessage.getError(), responsedMessage.getErrorString(), PersonalCardDetailModel.this.nDh);
                    }
                }
            }
        }
    };
    private com.baidu.tieba.themeCenter.a nDh;
    private a nDp;

    /* loaded from: classes9.dex */
    public interface a {
        void b(int i, String str, com.baidu.tieba.themeCenter.a aVar);
    }

    public PersonalCardDetailModel() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_CARD_DETAIL, PersonalCardDetailSocketReponse.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_CARD_DETAIL, 1003094, TbConfig.GET_CARD_DETAIL, PersonalCardDetailHttpReponse.class, false, false, false, false);
        registerListener(this.lkm);
    }

    public void hu(long j) {
        PersonalCardDetailRequest personalCardDetailRequest = new PersonalCardDetailRequest();
        personalCardDetailRequest.setCardId(j);
        sendMessage(personalCardDetailRequest);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.lkm);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void a(a aVar) {
        this.nDp = aVar;
    }
}
