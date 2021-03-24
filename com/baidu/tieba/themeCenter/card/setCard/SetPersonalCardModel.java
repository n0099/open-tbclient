package com.baidu.tieba.themeCenter.card.setCard;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.i0.i3.c;
import tbclient.T;
/* loaded from: classes5.dex */
public class SetPersonalCardModel extends BdBaseModel<BaseActivity<T>> {
    public static final int TYPE_DELETE_USE = 2;
    public static final int TYPE_SET_USE = 1;

    /* renamed from: e  reason: collision with root package name */
    public long f21663e;

    /* renamed from: f  reason: collision with root package name */
    public int f21664f;
    public b i;

    /* renamed from: g  reason: collision with root package name */
    public boolean f21665g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f21666h = false;
    public d.b.b.c.g.a j = new a(CmdConfigHttp.CMD_SET_PERSONAL_CARD, 309345);

    /* loaded from: classes5.dex */
    public class a extends d.b.b.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            SetPersonalCardModel.this.f21666h = false;
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof SetPersonalCardHttpResponse;
            if (z || (responsedMessage instanceof SetPersonalCardSocketResponse)) {
                if (responsedMessage.getError() == 0) {
                    SetPersonalCardModel.this.z(true);
                } else {
                    SetPersonalCardModel.this.z(false);
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
                if (SetPersonalCardModel.this.i != null) {
                    int i = c.f56219b;
                    if (responsedMessage.getError() == c.f56220c) {
                        i = c.f56218a;
                    }
                    SetPersonalCardModel.this.i.a(SetPersonalCardModel.this.f21665g, SetPersonalCardModel.this.f21663e, SetPersonalCardModel.this.f21664f, responsedMessage.getErrorString(), i);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(boolean z, long j, int i, String str, int i2);
    }

    public SetPersonalCardModel() {
        d.b.i0.c3.d0.a.h(309345, SetPersonalCardSocketResponse.class, false, false);
        d.b.i0.c3.d0.a.c(309345, CmdConfigHttp.CMD_SET_PERSONAL_CARD, TbConfig.SET_PERSONAL_CARD, SetPersonalCardHttpResponse.class, false, false, false, false);
        registerListener(this.j);
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
        this.f21663e = j;
    }

    public void setType(int i) {
        this.f21664f = i;
    }

    public void x(b bVar) {
        this.i = bVar;
    }

    public void y(long j, int i) {
        if (this.f21666h) {
            return;
        }
        this.f21666h = true;
        SetPersonalCardRequest setPersonalCardRequest = new SetPersonalCardRequest();
        setPersonalCardRequest.setCardId(j);
        setPersonalCardRequest.setType(i);
        sendMessage(setPersonalCardRequest);
    }

    public void z(boolean z) {
        this.f21665g = z;
    }
}
