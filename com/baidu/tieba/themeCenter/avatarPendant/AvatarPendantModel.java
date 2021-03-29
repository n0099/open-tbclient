package com.baidu.tieba.themeCenter.avatarPendant;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.i0.i3.h.e;
import java.util.List;
/* loaded from: classes5.dex */
public class AvatarPendantModel extends BdBaseModel<AvatarPendantActivity> {

    /* renamed from: e  reason: collision with root package name */
    public b f21579e;

    /* renamed from: f  reason: collision with root package name */
    public e f21580f;

    /* renamed from: g  reason: collision with root package name */
    public List<d.b.i0.i3.d.a> f21581g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.b.c.g.a f21582h;

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
            boolean z = responsedMessage instanceof AvatarPendantListSocketResponseMessage;
            if (z || (responsedMessage instanceof AvatarPendantListHttpResponseMessage)) {
                if (z) {
                    AvatarPendantListSocketResponseMessage avatarPendantListSocketResponseMessage = (AvatarPendantListSocketResponseMessage) responsedMessage;
                    AvatarPendantModel.this.f21581g = avatarPendantListSocketResponseMessage.getAvatarPendantListList();
                    AvatarPendantModel.this.f21580f = avatarPendantListSocketResponseMessage.getRecommand();
                } else if (responsedMessage instanceof AvatarPendantListHttpResponseMessage) {
                    AvatarPendantListHttpResponseMessage avatarPendantListHttpResponseMessage = (AvatarPendantListHttpResponseMessage) responsedMessage;
                    AvatarPendantModel.this.f21581g = avatarPendantListHttpResponseMessage.getAvatarPendantListList();
                    AvatarPendantModel.this.f21580f = avatarPendantListHttpResponseMessage.getRecommand();
                }
                if (AvatarPendantModel.this.f21579e != null) {
                    AvatarPendantModel.this.f21579e.a(responsedMessage.getError(), responsedMessage.getErrorString(), AvatarPendantModel.this.f21580f, AvatarPendantModel.this.f21581g);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i, String str, e eVar, List<d.b.i0.i3.d.a> list);
    }

    public AvatarPendantModel(AvatarPendantActivity avatarPendantActivity) {
        super(avatarPendantActivity.getPageContext());
        this.f21582h = new a(CmdConfigHttp.CMD_AVATAR_PENDANT_LIST, 309371);
        registerTask();
        registerListener(this.f21582h);
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
        d.b.i0.c3.d0.a.h(309371, AvatarPendantListSocketResponseMessage.class, false, false);
        d.b.i0.c3.d0.a.c(309371, CmdConfigHttp.CMD_AVATAR_PENDANT_LIST, TbConfig.AVATAR_PENDANT, AvatarPendantListHttpResponseMessage.class, true, true, true, true);
    }

    public List<d.b.i0.i3.d.a> x() {
        return this.f21581g;
    }

    public void y() {
        MessageManager.getInstance().unRegisterListener(this.f21582h);
    }

    public void z(b bVar) {
        this.f21579e = bVar;
    }
}
