package com.baidu.tieba.themeCenter.avatarPendant;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.n0.k3.c;
import tbclient.T;
/* loaded from: classes5.dex */
public class SetAvatarPendantModel extends BdBaseModel<BaseActivity<T>> {
    public static final int TYPE_SET_USE = 1;

    /* renamed from: e  reason: collision with root package name */
    public long f21059e;

    /* renamed from: f  reason: collision with root package name */
    public int f21060f;

    /* renamed from: h  reason: collision with root package name */
    public b f21062h;

    /* renamed from: g  reason: collision with root package name */
    public boolean f21061g = false;

    /* renamed from: i  reason: collision with root package name */
    public d.a.c.c.g.a f21063i = new a(CmdConfigHttp.CMD_SET_PENDANT, 309412);

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
            boolean z = responsedMessage instanceof SetPendantHttpResponse;
            if (z || (responsedMessage instanceof SetPendantSocketResponse)) {
                if (responsedMessage.getError() == 0) {
                    SetAvatarPendantModel.this.A(true);
                } else {
                    SetAvatarPendantModel.this.A(false);
                }
                if (z) {
                    SetPendantHttpResponse setPendantHttpResponse = (SetPendantHttpResponse) responsedMessage;
                    SetAvatarPendantModel.this.y(setPendantHttpResponse.getPendantId());
                    SetAvatarPendantModel.this.f21060f = setPendantHttpResponse.getFreeUseLevel();
                } else if (responsedMessage instanceof SetPendantSocketResponse) {
                    SetPendantSocketResponse setPendantSocketResponse = (SetPendantSocketResponse) responsedMessage;
                    SetAvatarPendantModel.this.y(setPendantSocketResponse.getPendantId());
                    SetAvatarPendantModel.this.f21060f = setPendantSocketResponse.getFreeUseLevel();
                }
                if (SetAvatarPendantModel.this.f21062h != null) {
                    int i2 = c.f56958b;
                    if (responsedMessage.getError() == c.f56959c) {
                        i2 = c.f56957a;
                    }
                    SetAvatarPendantModel.this.f21062h.onSetPendantCallback(SetAvatarPendantModel.this.f21061g, SetAvatarPendantModel.this.f21059e, SetAvatarPendantModel.this.f21060f, responsedMessage.getErrorString(), i2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void onSetPendantCallback(boolean z, long j, int i2, String str, int i3);
    }

    public SetAvatarPendantModel() {
        d.a.n0.e3.d0.a.h(309412, SetPendantSocketResponse.class, false, false);
        d.a.n0.e3.d0.a.c(309412, CmdConfigHttp.CMD_SET_PENDANT, TbConfig.SET_PENDANT, SetPendantHttpResponse.class, true, true, true, true);
        registerListener(this.f21063i);
    }

    public void A(boolean z) {
        this.f21061g = z;
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
        MessageManager.getInstance().unRegisterListener(this.f21063i);
    }

    public void x(long j, int i2, int i3) {
        SetPendantRequest setPendantRequest = new SetPendantRequest();
        setPendantRequest.setPendantId(j);
        setPendantRequest.setType(i2);
        setPendantRequest.setFreeUseLevel(i3);
        MessageManager.getInstance().sendMessage(setPendantRequest);
    }

    public void y(long j) {
        this.f21059e = j;
    }

    public void z(b bVar) {
        this.f21062h = bVar;
    }
}
