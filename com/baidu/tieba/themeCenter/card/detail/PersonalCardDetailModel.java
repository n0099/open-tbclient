package com.baidu.tieba.themeCenter.card.detail;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes5.dex */
public class PersonalCardDetailModel extends BdBaseModel<PersonalCardDetailActivity> {

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.i3.a f21660e;

    /* renamed from: f  reason: collision with root package name */
    public b f21661f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.b.c.g.a f21662g = new a(CmdConfigHttp.CMD_GET_CARD_DETAIL, 309333);

    /* loaded from: classes5.dex */
    public class a extends d.b.b.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof PersonalCardDetailHttpReponse;
            if (z || (responsedMessage instanceof PersonalCardDetailSocketReponse)) {
                if (z) {
                    PersonalCardDetailModel.this.f21660e = ((PersonalCardDetailHttpReponse) responsedMessage).getCardData();
                } else if (responsedMessage instanceof PersonalCardDetailSocketReponse) {
                    PersonalCardDetailModel.this.f21660e = ((PersonalCardDetailSocketReponse) responsedMessage).getCardData();
                }
                if (PersonalCardDetailModel.this.f21661f != null) {
                    PersonalCardDetailModel.this.f21661f.a(responsedMessage.getError(), responsedMessage.getErrorString(), PersonalCardDetailModel.this.f21660e);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i, String str, d.b.i0.i3.a aVar);
    }

    public PersonalCardDetailModel() {
        d.b.i0.c3.d0.a.h(309333, PersonalCardDetailSocketReponse.class, false, false);
        d.b.i0.c3.d0.a.c(309333, CmdConfigHttp.CMD_GET_CARD_DETAIL, TbConfig.GET_CARD_DETAIL, PersonalCardDetailHttpReponse.class, false, false, false, false);
        registerListener(this.f21662g);
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
        MessageManager.getInstance().unRegisterListener(this.f21662g);
    }

    public void v(long j) {
        PersonalCardDetailRequest personalCardDetailRequest = new PersonalCardDetailRequest();
        personalCardDetailRequest.setCardId(j);
        sendMessage(personalCardDetailRequest);
    }

    public void w(b bVar) {
        this.f21661f = bVar;
    }
}
