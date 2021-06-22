package com.baidu.tieba.themeCenter.card.setCard;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.o0.k3.c;
import tbclient.T;
/* loaded from: classes5.dex */
public class SetPersonalCardModel extends BdBaseModel<BaseActivity<T>> {
    public static final int TYPE_DELETE_USE = 2;
    public static final int TYPE_SET_USE = 1;

    /* renamed from: e  reason: collision with root package name */
    public long f21304e;

    /* renamed from: f  reason: collision with root package name */
    public int f21305f;

    /* renamed from: i  reason: collision with root package name */
    public b f21308i;

    /* renamed from: g  reason: collision with root package name */
    public boolean f21306g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f21307h = false;
    public d.a.c.c.g.a j = new a(CmdConfigHttp.CMD_SET_PERSONAL_CARD, 309345);

    /* loaded from: classes5.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            SetPersonalCardModel.this.f21307h = false;
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof SetPersonalCardHttpResponse;
            if (z || (responsedMessage instanceof SetPersonalCardSocketResponse)) {
                if (responsedMessage.getError() == 0) {
                    SetPersonalCardModel.this.D(true);
                } else {
                    SetPersonalCardModel.this.D(false);
                }
                if (z) {
                    SetPersonalCardHttpResponse setPersonalCardHttpResponse = (SetPersonalCardHttpResponse) responsedMessage;
                    SetPersonalCardModel.this.setCardId(setPersonalCardHttpResponse.getCardId());
                    SetPersonalCardModel.this.setType(setPersonalCardHttpResponse.getType());
                } else if (responsedMessage instanceof SetPersonalCardSocketResponse) {
                    SetPersonalCardSocketResponse setPersonalCardSocketResponse = (SetPersonalCardSocketResponse) responsedMessage;
                    SetPersonalCardModel.this.setCardId(setPersonalCardSocketResponse.getCardId());
                    SetPersonalCardModel.this.setType(setPersonalCardSocketResponse.getType());
                }
                if (SetPersonalCardModel.this.f21308i != null) {
                    int i2 = c.f60772b;
                    if (responsedMessage.getError() == c.f60773c) {
                        i2 = c.f60771a;
                    }
                    SetPersonalCardModel.this.f21308i.a(SetPersonalCardModel.this.f21306g, SetPersonalCardModel.this.f21304e, SetPersonalCardModel.this.f21305f, responsedMessage.getErrorString(), i2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(boolean z, long j, int i2, String str, int i3);
    }

    public SetPersonalCardModel() {
        d.a.o0.e3.d0.a.h(309345, SetPersonalCardSocketResponse.class, false, false);
        d.a.o0.e3.d0.a.c(309345, CmdConfigHttp.CMD_SET_PERSONAL_CARD, TbConfig.SET_PERSONAL_CARD, SetPersonalCardHttpResponse.class, false, false, false, false);
        registerListener(this.j);
    }

    public void B(b bVar) {
        this.f21308i = bVar;
    }

    public void C(long j, int i2) {
        if (this.f21307h) {
            return;
        }
        this.f21307h = true;
        SetPersonalCardRequest setPersonalCardRequest = new SetPersonalCardRequest();
        setPersonalCardRequest.setCardId(j);
        setPersonalCardRequest.setType(i2);
        sendMessage(setPersonalCardRequest);
    }

    public void D(boolean z) {
        this.f21306g = z;
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
        MessageManager.getInstance().unRegisterListener(this.j);
    }

    public void setCardId(long j) {
        this.f21304e = j;
    }

    public void setType(int i2) {
        this.f21305f = i2;
    }
}
