package com.baidu.tieba.themeCenter.avatarPendant;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.j0.j3.h.e;
import java.util.List;
/* loaded from: classes5.dex */
public class AvatarPendantModel extends BdBaseModel<AvatarPendantActivity> {

    /* renamed from: e  reason: collision with root package name */
    public b f21875e;

    /* renamed from: f  reason: collision with root package name */
    public e f21876f;

    /* renamed from: g  reason: collision with root package name */
    public List<d.a.j0.j3.d.a> f21877g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.c.g.a f21878h;

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
                    AvatarPendantModel.this.f21877g = avatarPendantListSocketResponseMessage.getAvatarPendantListList();
                    AvatarPendantModel.this.f21876f = avatarPendantListSocketResponseMessage.getRecommand();
                } else if (responsedMessage instanceof AvatarPendantListHttpResponseMessage) {
                    AvatarPendantListHttpResponseMessage avatarPendantListHttpResponseMessage = (AvatarPendantListHttpResponseMessage) responsedMessage;
                    AvatarPendantModel.this.f21877g = avatarPendantListHttpResponseMessage.getAvatarPendantListList();
                    AvatarPendantModel.this.f21876f = avatarPendantListHttpResponseMessage.getRecommand();
                }
                if (AvatarPendantModel.this.f21875e != null) {
                    AvatarPendantModel.this.f21875e.a(responsedMessage.getError(), responsedMessage.getErrorString(), AvatarPendantModel.this.f21876f, AvatarPendantModel.this.f21877g);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i2, String str, e eVar, List<d.a.j0.j3.d.a> list);
    }

    public AvatarPendantModel(AvatarPendantActivity avatarPendantActivity) {
        super(avatarPendantActivity.getPageContext());
        this.f21878h = new a(CmdConfigHttp.CMD_AVATAR_PENDANT_LIST, 309371);
        registerTask();
        registerListener(this.f21878h);
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
        d.a.j0.d3.d0.a.h(309371, AvatarPendantListSocketResponseMessage.class, false, false);
        d.a.j0.d3.d0.a.c(309371, CmdConfigHttp.CMD_AVATAR_PENDANT_LIST, TbConfig.AVATAR_PENDANT, AvatarPendantListHttpResponseMessage.class, true, true, true, true);
    }

    public List<d.a.j0.j3.d.a> x() {
        return this.f21877g;
    }

    public void y() {
        MessageManager.getInstance().unRegisterListener(this.f21878h);
    }

    public void z(b bVar) {
        this.f21875e = bVar;
    }
}
