package com.baidu.tieba.themeCenter.dressCenter;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.b.i0.i3.h.d;
import d.b.i0.i3.h.e;
import java.util.List;
/* loaded from: classes5.dex */
public class DressupCenterModel extends BdBaseModel<DressupCenterModel> {

    /* renamed from: e  reason: collision with root package name */
    public List<d> f21669e;

    /* renamed from: f  reason: collision with root package name */
    public e f21670f;

    /* renamed from: g  reason: collision with root package name */
    public List<d.b.i0.i3.h.a> f21671g;

    /* renamed from: h  reason: collision with root package name */
    public b f21672h;
    public boolean i;
    public d.b.b.c.g.a j = new a(CmdConfigHttp.CMD_DRESSUP_CENTER, 309001);

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
            boolean z = responsedMessage instanceof DressupCenterHttpResponseMessage;
            if (z || (responsedMessage instanceof DressupCenterSocketResponseMessage)) {
                if (responsedMessage.getError() != 0) {
                    if (DressupCenterModel.this.f21672h != null) {
                        DressupCenterModel.this.f21672h.a(responsedMessage.getError(), responsedMessage.getErrorString(), DressupCenterModel.this.f21671g, DressupCenterModel.this.f21670f, DressupCenterModel.this.f21669e);
                        return;
                    }
                    return;
                }
                if (z) {
                    DressupCenterHttpResponseMessage dressupCenterHttpResponseMessage = (DressupCenterHttpResponseMessage) responsedMessage;
                    DressupCenterModel.this.f21669e = dressupCenterHttpResponseMessage.getThemeList();
                    DressupCenterModel.this.f21670f = dressupCenterHttpResponseMessage.getRecommand();
                    DressupCenterModel.this.f21671g = dressupCenterHttpResponseMessage.getThemeCarouselList();
                } else if (responsedMessage instanceof DressupCenterSocketResponseMessage) {
                    DressupCenterSocketResponseMessage dressupCenterSocketResponseMessage = (DressupCenterSocketResponseMessage) responsedMessage;
                    DressupCenterModel.this.f21669e = dressupCenterSocketResponseMessage.getThemeList();
                    DressupCenterModel.this.f21670f = dressupCenterSocketResponseMessage.getRecommand();
                    DressupCenterModel.this.f21671g = dressupCenterSocketResponseMessage.getThemeCarouselList();
                }
                if (DressupCenterModel.this.f21672h != null) {
                    DressupCenterModel.this.f21672h.a(responsedMessage.getError(), responsedMessage.getErrorString(), DressupCenterModel.this.f21671g, DressupCenterModel.this.f21670f, DressupCenterModel.this.f21669e);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i, String str, List<d.b.i0.i3.h.a> list, e eVar, List<d> list2);
    }

    public DressupCenterModel(DressupCenterActivity dressupCenterActivity) {
        this.i = dressupCenterActivity.getIntent().getBooleanExtra(IntentConfig.MEMBER_BUY_SHOW, false);
        registerTask();
        registerListener(this.j);
    }

    public void A(b bVar) {
        this.f21672h = bVar;
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
        d.b.i0.c3.d0.a.h(309001, DressupCenterSocketResponseMessage.class, false, false);
        d.b.i0.c3.d0.a.c(309001, CmdConfigHttp.CMD_DRESSUP_CENTER, TbConfig.DRESSUP_CENTER_PAGE, DressupCenterHttpResponseMessage.class, false, false, false, false);
    }

    public boolean z() {
        return this.i;
    }
}
