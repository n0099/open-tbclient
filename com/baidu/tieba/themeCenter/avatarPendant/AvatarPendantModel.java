package com.baidu.tieba.themeCenter.avatarPendant;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.j0.j3.h.e;
import java.util.List;
/* loaded from: classes5.dex */
public class AvatarPendantModel extends BdBaseModel<AvatarPendantActivity> {

    /* renamed from: e  reason: collision with root package name */
    public b f21272e;

    /* renamed from: f  reason: collision with root package name */
    public e f21273f;

    /* renamed from: g  reason: collision with root package name */
    public List<d.b.j0.j3.d.a> f21274g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.c.c.g.a f21275h;

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
            boolean z = responsedMessage instanceof AvatarPendantListSocketResponseMessage;
            if (z || (responsedMessage instanceof AvatarPendantListHttpResponseMessage)) {
                if (z) {
                    AvatarPendantListSocketResponseMessage avatarPendantListSocketResponseMessage = (AvatarPendantListSocketResponseMessage) responsedMessage;
                    AvatarPendantModel.this.f21274g = avatarPendantListSocketResponseMessage.getAvatarPendantListList();
                    AvatarPendantModel.this.f21273f = avatarPendantListSocketResponseMessage.getRecommand();
                } else if (responsedMessage instanceof AvatarPendantListHttpResponseMessage) {
                    AvatarPendantListHttpResponseMessage avatarPendantListHttpResponseMessage = (AvatarPendantListHttpResponseMessage) responsedMessage;
                    AvatarPendantModel.this.f21274g = avatarPendantListHttpResponseMessage.getAvatarPendantListList();
                    AvatarPendantModel.this.f21273f = avatarPendantListHttpResponseMessage.getRecommand();
                }
                if (AvatarPendantModel.this.f21272e != null) {
                    AvatarPendantModel.this.f21272e.a(responsedMessage.getError(), responsedMessage.getErrorString(), AvatarPendantModel.this.f21273f, AvatarPendantModel.this.f21274g);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i, String str, e eVar, List<d.b.j0.j3.d.a> list);
    }

    public AvatarPendantModel(AvatarPendantActivity avatarPendantActivity) {
        super(avatarPendantActivity.getPageContext());
        this.f21275h = new a(CmdConfigHttp.CMD_AVATAR_PENDANT_LIST, 309371);
        registerTask();
        registerListener(this.f21275h);
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
        d.b.j0.d3.d0.a.h(309371, AvatarPendantListSocketResponseMessage.class, false, false);
        d.b.j0.d3.d0.a.c(309371, CmdConfigHttp.CMD_AVATAR_PENDANT_LIST, TbConfig.AVATAR_PENDANT, AvatarPendantListHttpResponseMessage.class, true, true, true, true);
    }

    public List<d.b.j0.j3.d.a> x() {
        return this.f21274g;
    }

    public void y() {
        MessageManager.getInstance().unRegisterListener(this.f21275h);
    }

    public void z(b bVar) {
        this.f21272e = bVar;
    }
}
