package com.baidu.tieba.themeCenter.avatarPendant;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.n0.k3.h.e;
import java.util.List;
/* loaded from: classes5.dex */
public class AvatarPendantModel extends BdBaseModel<AvatarPendantActivity> {

    /* renamed from: e  reason: collision with root package name */
    public b f21126e;

    /* renamed from: f  reason: collision with root package name */
    public e f21127f;

    /* renamed from: g  reason: collision with root package name */
    public List<d.a.n0.k3.d.a> f21128g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.c.g.a f21129h;

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
            boolean z = responsedMessage instanceof AvatarPendantListSocketResponseMessage;
            if (z || (responsedMessage instanceof AvatarPendantListHttpResponseMessage)) {
                if (z) {
                    AvatarPendantListSocketResponseMessage avatarPendantListSocketResponseMessage = (AvatarPendantListSocketResponseMessage) responsedMessage;
                    AvatarPendantModel.this.f21128g = avatarPendantListSocketResponseMessage.getAvatarPendantListList();
                    AvatarPendantModel.this.f21127f = avatarPendantListSocketResponseMessage.getRecommand();
                } else if (responsedMessage instanceof AvatarPendantListHttpResponseMessage) {
                    AvatarPendantListHttpResponseMessage avatarPendantListHttpResponseMessage = (AvatarPendantListHttpResponseMessage) responsedMessage;
                    AvatarPendantModel.this.f21128g = avatarPendantListHttpResponseMessage.getAvatarPendantListList();
                    AvatarPendantModel.this.f21127f = avatarPendantListHttpResponseMessage.getRecommand();
                }
                if (AvatarPendantModel.this.f21126e != null) {
                    AvatarPendantModel.this.f21126e.a(responsedMessage.getError(), responsedMessage.getErrorString(), AvatarPendantModel.this.f21127f, AvatarPendantModel.this.f21128g);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i2, String str, e eVar, List<d.a.n0.k3.d.a> list);
    }

    public AvatarPendantModel(AvatarPendantActivity avatarPendantActivity) {
        super(avatarPendantActivity.getPageContext());
        this.f21129h = new a(CmdConfigHttp.CMD_AVATAR_PENDANT_LIST, 309371);
        registerTask();
        registerListener(this.f21129h);
    }

    public List<d.a.n0.k3.d.a> B() {
        return this.f21128g;
    }

    public void C() {
        MessageManager.getInstance().unRegisterListener(this.f21129h);
    }

    public void D(b bVar) {
        this.f21126e = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        sendMessage(new AvatarPendantListRequestMessage());
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public final void registerTask() {
        d.a.n0.e3.d0.a.h(309371, AvatarPendantListSocketResponseMessage.class, false, false);
        d.a.n0.e3.d0.a.c(309371, CmdConfigHttp.CMD_AVATAR_PENDANT_LIST, TbConfig.AVATAR_PENDANT, AvatarPendantListHttpResponseMessage.class, true, true, true, true);
    }
}
