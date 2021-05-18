package com.baidu.tieba.themeCenter.dressCenter;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.k0.j3.h.d;
import d.a.k0.j3.h.e;
import java.util.List;
/* loaded from: classes5.dex */
public class DressupCenterModel extends BdBaseModel<DressupCenterModel> {

    /* renamed from: e  reason: collision with root package name */
    public List<d> f21223e;

    /* renamed from: f  reason: collision with root package name */
    public e f21224f;

    /* renamed from: g  reason: collision with root package name */
    public List<d.a.k0.j3.h.a> f21225g;

    /* renamed from: h  reason: collision with root package name */
    public b f21226h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f21227i;
    public d.a.c.c.g.a j = new a(CmdConfigHttp.CMD_DRESSUP_CENTER, 309001);

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
            boolean z = responsedMessage instanceof DressupCenterHttpResponseMessage;
            if (z || (responsedMessage instanceof DressupCenterSocketResponseMessage)) {
                if (responsedMessage.getError() != 0) {
                    if (DressupCenterModel.this.f21226h != null) {
                        DressupCenterModel.this.f21226h.a(responsedMessage.getError(), responsedMessage.getErrorString(), DressupCenterModel.this.f21225g, DressupCenterModel.this.f21224f, DressupCenterModel.this.f21223e);
                        return;
                    }
                    return;
                }
                if (z) {
                    DressupCenterHttpResponseMessage dressupCenterHttpResponseMessage = (DressupCenterHttpResponseMessage) responsedMessage;
                    DressupCenterModel.this.f21223e = dressupCenterHttpResponseMessage.getThemeList();
                    DressupCenterModel.this.f21224f = dressupCenterHttpResponseMessage.getRecommand();
                    DressupCenterModel.this.f21225g = dressupCenterHttpResponseMessage.getThemeCarouselList();
                } else if (responsedMessage instanceof DressupCenterSocketResponseMessage) {
                    DressupCenterSocketResponseMessage dressupCenterSocketResponseMessage = (DressupCenterSocketResponseMessage) responsedMessage;
                    DressupCenterModel.this.f21223e = dressupCenterSocketResponseMessage.getThemeList();
                    DressupCenterModel.this.f21224f = dressupCenterSocketResponseMessage.getRecommand();
                    DressupCenterModel.this.f21225g = dressupCenterSocketResponseMessage.getThemeCarouselList();
                }
                if (DressupCenterModel.this.f21226h != null) {
                    DressupCenterModel.this.f21226h.a(responsedMessage.getError(), responsedMessage.getErrorString(), DressupCenterModel.this.f21225g, DressupCenterModel.this.f21224f, DressupCenterModel.this.f21223e);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i2, String str, List<d.a.k0.j3.h.a> list, e eVar, List<d> list2);
    }

    public DressupCenterModel(DressupCenterActivity dressupCenterActivity) {
        this.f21227i = dressupCenterActivity.getIntent().getBooleanExtra(IntentConfig.MEMBER_BUY_SHOW, false);
        registerTask();
        registerListener(this.j);
    }

    public void A(b bVar) {
        this.f21226h = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        sendMessage(new DressupCenterRequestMessage());
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.j);
    }

    public final void registerTask() {
        d.a.k0.d3.d0.a.h(309001, DressupCenterSocketResponseMessage.class, false, false);
        d.a.k0.d3.d0.a.c(309001, CmdConfigHttp.CMD_DRESSUP_CENTER, TbConfig.DRESSUP_CENTER_PAGE, DressupCenterHttpResponseMessage.class, false, false, false, false);
    }

    public boolean z() {
        return this.f21227i;
    }
}
