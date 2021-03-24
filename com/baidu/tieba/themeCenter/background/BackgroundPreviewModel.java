package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes5.dex */
public class BackgroundPreviewModel extends BdBaseModel<BackgroundPreviewModel> {

    /* renamed from: e  reason: collision with root package name */
    public DressItemData f21616e;

    /* renamed from: f  reason: collision with root package name */
    public int f21617f;

    /* renamed from: g  reason: collision with root package name */
    public int f21618g;

    /* renamed from: h  reason: collision with root package name */
    public b f21619h;
    public d.b.b.c.g.a i = new a(CmdConfigHttp.CMD_PERSONAL_BACKGROUND_GET, 309023);

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
            boolean z = responsedMessage instanceof BackgroundGetHttpResponseMessage;
            if (z || (responsedMessage instanceof BackgroundGetSocketResponseMessage)) {
                if (responsedMessage.getError() == 0) {
                    if (z) {
                        BackgroundPreviewModel.this.f21616e = ((BackgroundGetHttpResponseMessage) responsedMessage).getBgItem();
                    } else if (responsedMessage instanceof BackgroundGetSocketResponseMessage) {
                        BackgroundPreviewModel.this.f21616e = ((BackgroundGetSocketResponseMessage) responsedMessage).getBgItem();
                    }
                }
                if (BackgroundPreviewModel.this.f21619h != null) {
                    if (BackgroundPreviewModel.this.f21616e != null) {
                        BackgroundPreviewModel.this.f21616e.setPropsId(BackgroundPreviewModel.this.f21617f);
                        BackgroundPreviewModel.this.f21616e.setInUse(BackgroundPreviewModel.this.f21618g == 1);
                    }
                    BackgroundPreviewModel.this.f21619h.a(responsedMessage.getError(), responsedMessage.getErrorString(), BackgroundPreviewModel.this.f21616e);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i, String str, DressItemData dressItemData);
    }

    public BackgroundPreviewModel(int i, int i2) {
        this.f21617f = i;
        this.f21618g = i2;
        registerTask();
        registerListener(this.i);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        BackgroundGetRequestMessage backgroundGetRequestMessage = new BackgroundGetRequestMessage();
        backgroundGetRequestMessage.setPropId(this.f21617f);
        sendMessage(backgroundGetRequestMessage);
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.i);
    }

    public final void registerTask() {
        d.b.i0.c3.d0.a.h(309023, BackgroundGetSocketResponseMessage.class, false, false);
        d.b.i0.c3.d0.a.c(309023, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_GET, TbConfig.PERSONAL_BACKGROUND_GET, BackgroundGetHttpResponseMessage.class, false, false, false, false);
    }

    public void x(b bVar) {
        this.f21619h = bVar;
    }
}
