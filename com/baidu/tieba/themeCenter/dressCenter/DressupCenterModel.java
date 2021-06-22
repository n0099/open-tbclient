package com.baidu.tieba.themeCenter.dressCenter;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.o0.k3.h.d;
import d.a.o0.k3.h.e;
import java.util.List;
/* loaded from: classes5.dex */
public class DressupCenterModel extends BdBaseModel<DressupCenterModel> {

    /* renamed from: e  reason: collision with root package name */
    public List<d> f21311e;

    /* renamed from: f  reason: collision with root package name */
    public e f21312f;

    /* renamed from: g  reason: collision with root package name */
    public List<d.a.o0.k3.h.a> f21313g;

    /* renamed from: h  reason: collision with root package name */
    public b f21314h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f21315i;
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
                    if (DressupCenterModel.this.f21314h != null) {
                        DressupCenterModel.this.f21314h.a(responsedMessage.getError(), responsedMessage.getErrorString(), DressupCenterModel.this.f21313g, DressupCenterModel.this.f21312f, DressupCenterModel.this.f21311e);
                        return;
                    }
                    return;
                }
                if (z) {
                    DressupCenterHttpResponseMessage dressupCenterHttpResponseMessage = (DressupCenterHttpResponseMessage) responsedMessage;
                    DressupCenterModel.this.f21311e = dressupCenterHttpResponseMessage.getThemeList();
                    DressupCenterModel.this.f21312f = dressupCenterHttpResponseMessage.getRecommand();
                    DressupCenterModel.this.f21313g = dressupCenterHttpResponseMessage.getThemeCarouselList();
                } else if (responsedMessage instanceof DressupCenterSocketResponseMessage) {
                    DressupCenterSocketResponseMessage dressupCenterSocketResponseMessage = (DressupCenterSocketResponseMessage) responsedMessage;
                    DressupCenterModel.this.f21311e = dressupCenterSocketResponseMessage.getThemeList();
                    DressupCenterModel.this.f21312f = dressupCenterSocketResponseMessage.getRecommand();
                    DressupCenterModel.this.f21313g = dressupCenterSocketResponseMessage.getThemeCarouselList();
                }
                if (DressupCenterModel.this.f21314h != null) {
                    DressupCenterModel.this.f21314h.a(responsedMessage.getError(), responsedMessage.getErrorString(), DressupCenterModel.this.f21313g, DressupCenterModel.this.f21312f, DressupCenterModel.this.f21311e);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i2, String str, List<d.a.o0.k3.h.a> list, e eVar, List<d> list2);
    }

    public DressupCenterModel(DressupCenterActivity dressupCenterActivity) {
        this.f21315i = dressupCenterActivity.getIntent().getBooleanExtra(IntentConfig.MEMBER_BUY_SHOW, false);
        registerTask();
        registerListener(this.j);
    }

    public boolean D() {
        return this.f21315i;
    }

    public void E(b bVar) {
        this.f21314h = bVar;
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
        d.a.o0.e3.d0.a.h(309001, DressupCenterSocketResponseMessage.class, false, false);
        d.a.o0.e3.d0.a.c(309001, CmdConfigHttp.CMD_DRESSUP_CENTER, TbConfig.DRESSUP_CENTER_PAGE, DressupCenterHttpResponseMessage.class, false, false, false, false);
    }
}
