package com.baidu.tieba.themeCenter.card.detail;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes5.dex */
public class PersonalCardDetailModel extends BdBaseModel<PersonalCardDetailActivity> {

    /* renamed from: e  reason: collision with root package name */
    public d.a.k0.j3.a f21212e;

    /* renamed from: f  reason: collision with root package name */
    public b f21213f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.c.g.a f21214g = new a(CmdConfigHttp.CMD_GET_CARD_DETAIL, 309333);

    /* loaded from: classes5.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof PersonalCardDetailHttpReponse;
            if (z || (responsedMessage instanceof PersonalCardDetailSocketReponse)) {
                if (z) {
                    PersonalCardDetailModel.this.f21212e = ((PersonalCardDetailHttpReponse) responsedMessage).getCardData();
                } else if (responsedMessage instanceof PersonalCardDetailSocketReponse) {
                    PersonalCardDetailModel.this.f21212e = ((PersonalCardDetailSocketReponse) responsedMessage).getCardData();
                }
                if (PersonalCardDetailModel.this.f21213f != null) {
                    PersonalCardDetailModel.this.f21213f.a(responsedMessage.getError(), responsedMessage.getErrorString(), PersonalCardDetailModel.this.f21212e);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i2, String str, d.a.k0.j3.a aVar);
    }

    public PersonalCardDetailModel() {
        d.a.k0.d3.d0.a.h(309333, PersonalCardDetailSocketReponse.class, false, false);
        d.a.k0.d3.d0.a.c(309333, CmdConfigHttp.CMD_GET_CARD_DETAIL, TbConfig.GET_CARD_DETAIL, PersonalCardDetailHttpReponse.class, false, false, false, false);
        registerListener(this.f21214g);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.f21214g);
    }

    public void v(long j) {
        PersonalCardDetailRequest personalCardDetailRequest = new PersonalCardDetailRequest();
        personalCardDetailRequest.setCardId(j);
        sendMessage(personalCardDetailRequest);
    }

    public void w(b bVar) {
        this.f21213f = bVar;
    }
}
