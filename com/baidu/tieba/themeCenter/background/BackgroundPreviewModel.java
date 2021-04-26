package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes5.dex */
public class BackgroundPreviewModel extends BdBaseModel<BackgroundPreviewModel> {

    /* renamed from: e  reason: collision with root package name */
    public DressItemData f21918e;

    /* renamed from: f  reason: collision with root package name */
    public int f21919f;

    /* renamed from: g  reason: collision with root package name */
    public int f21920g;

    /* renamed from: h  reason: collision with root package name */
    public b f21921h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.c.c.g.a f21922i = new a(CmdConfigHttp.CMD_PERSONAL_BACKGROUND_GET, 309023);

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
            boolean z = responsedMessage instanceof BackgroundGetHttpResponseMessage;
            if (z || (responsedMessage instanceof BackgroundGetSocketResponseMessage)) {
                if (responsedMessage.getError() == 0) {
                    if (z) {
                        BackgroundPreviewModel.this.f21918e = ((BackgroundGetHttpResponseMessage) responsedMessage).getBgItem();
                    } else if (responsedMessage instanceof BackgroundGetSocketResponseMessage) {
                        BackgroundPreviewModel.this.f21918e = ((BackgroundGetSocketResponseMessage) responsedMessage).getBgItem();
                    }
                }
                if (BackgroundPreviewModel.this.f21921h != null) {
                    if (BackgroundPreviewModel.this.f21918e != null) {
                        BackgroundPreviewModel.this.f21918e.setPropsId(BackgroundPreviewModel.this.f21919f);
                        BackgroundPreviewModel.this.f21918e.setInUse(BackgroundPreviewModel.this.f21920g == 1);
                    }
                    BackgroundPreviewModel.this.f21921h.a(responsedMessage.getError(), responsedMessage.getErrorString(), BackgroundPreviewModel.this.f21918e);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i2, String str, DressItemData dressItemData);
    }

    public BackgroundPreviewModel(int i2, int i3) {
        this.f21919f = i2;
        this.f21920g = i3;
        registerTask();
        registerListener(this.f21922i);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        BackgroundGetRequestMessage backgroundGetRequestMessage = new BackgroundGetRequestMessage();
        backgroundGetRequestMessage.setPropId(this.f21919f);
        sendMessage(backgroundGetRequestMessage);
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.f21922i);
    }

    public final void registerTask() {
        d.a.j0.d3.d0.a.h(309023, BackgroundGetSocketResponseMessage.class, false, false);
        d.a.j0.d3.d0.a.c(309023, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_GET, TbConfig.PERSONAL_BACKGROUND_GET, BackgroundGetHttpResponseMessage.class, false, false, false, false);
    }

    public void x(b bVar) {
        this.f21921h = bVar;
    }
}
