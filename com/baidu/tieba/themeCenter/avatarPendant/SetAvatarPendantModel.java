package com.baidu.tieba.themeCenter.avatarPendant;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.j0.j3.c;
import tbclient.T;
/* loaded from: classes5.dex */
public class SetAvatarPendantModel extends BdBaseModel<BaseActivity<T>> {
    public static final int TYPE_SET_USE = 1;

    /* renamed from: e  reason: collision with root package name */
    public long f21282e;

    /* renamed from: f  reason: collision with root package name */
    public int f21283f;

    /* renamed from: h  reason: collision with root package name */
    public b f21285h;

    /* renamed from: g  reason: collision with root package name */
    public boolean f21284g = false;
    public d.b.c.c.g.a i = new a(CmdConfigHttp.CMD_SET_PENDANT, 309412);

    /* loaded from: classes5.dex */
    public class a extends d.b.c.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
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
                    SetAvatarPendantModel.this.f21283f = setPendantHttpResponse.getFreeUseLevel();
                } else if (responsedMessage instanceof SetPendantSocketResponse) {
                    SetPendantSocketResponse setPendantSocketResponse = (SetPendantSocketResponse) responsedMessage;
                    SetAvatarPendantModel.this.y(setPendantSocketResponse.getPendantId());
                    SetAvatarPendantModel.this.f21283f = setPendantSocketResponse.getFreeUseLevel();
                }
                if (SetAvatarPendantModel.this.f21285h != null) {
                    int i = c.f58088b;
                    if (responsedMessage.getError() == c.f58089c) {
                        i = c.f58087a;
                    }
                    SetAvatarPendantModel.this.f21285h.onSetPendantCallback(SetAvatarPendantModel.this.f21284g, SetAvatarPendantModel.this.f21282e, SetAvatarPendantModel.this.f21283f, responsedMessage.getErrorString(), i);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void onSetPendantCallback(boolean z, long j, int i, String str, int i2);
    }

    public SetAvatarPendantModel() {
        d.b.j0.d3.d0.a.h(309412, SetPendantSocketResponse.class, false, false);
        d.b.j0.d3.d0.a.c(309412, CmdConfigHttp.CMD_SET_PENDANT, TbConfig.SET_PENDANT, SetPendantHttpResponse.class, true, true, true, true);
        registerListener(this.i);
    }

    public void A(boolean z) {
        this.f21284g = z;
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
        MessageManager.getInstance().unRegisterListener(this.i);
    }

    public void x(long j, int i, int i2) {
        SetPendantRequest setPendantRequest = new SetPendantRequest();
        setPendantRequest.setPendantId(j);
        setPendantRequest.setType(i);
        setPendantRequest.setFreeUseLevel(i2);
        MessageManager.getInstance().sendMessage(setPendantRequest);
    }

    public void y(long j) {
        this.f21282e = j;
    }

    public void z(b bVar) {
        this.f21285h = bVar;
    }
}
