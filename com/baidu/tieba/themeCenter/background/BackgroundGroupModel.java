package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.o0.k3.h.e;
import java.util.List;
/* loaded from: classes5.dex */
public class BackgroundGroupModel extends BdBaseModel<BackgroundGroupActivity> {

    /* renamed from: e  reason: collision with root package name */
    public BackgroundGroupActivity f21226e;

    /* renamed from: f  reason: collision with root package name */
    public e f21227f;

    /* renamed from: g  reason: collision with root package name */
    public List<d.a.o0.k3.e.b> f21228g;

    /* renamed from: h  reason: collision with root package name */
    public c f21229h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f21230i;
    public d.a.c.c.g.a j;
    public d.a.c.c.g.a k;

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
            boolean z = responsedMessage instanceof BackgroundGroupHttpResponseMessage;
            if (z || (responsedMessage instanceof BackgroundGroupSocketResponseMessage)) {
                if (responsedMessage.getError() != 0) {
                    if (BackgroundGroupModel.this.f21229h != null) {
                        BackgroundGroupModel.this.f21229h.a(responsedMessage.getError(), responsedMessage.getErrorString(), BackgroundGroupModel.this.f21227f, BackgroundGroupModel.this.f21228g);
                        return;
                    }
                    return;
                }
                if (z) {
                    BackgroundGroupHttpResponseMessage backgroundGroupHttpResponseMessage = (BackgroundGroupHttpResponseMessage) responsedMessage;
                    BackgroundGroupModel.this.f21227f = backgroundGroupHttpResponseMessage.getRecommand();
                    BackgroundGroupModel.this.f21228g = backgroundGroupHttpResponseMessage.getGroupList();
                } else if (responsedMessage instanceof BackgroundGroupSocketResponseMessage) {
                    BackgroundGroupSocketResponseMessage backgroundGroupSocketResponseMessage = (BackgroundGroupSocketResponseMessage) responsedMessage;
                    BackgroundGroupModel.this.f21227f = backgroundGroupSocketResponseMessage.getRecommand();
                    BackgroundGroupModel.this.f21228g = backgroundGroupSocketResponseMessage.getGroupList();
                }
                if (BackgroundGroupModel.this.f21229h != null) {
                    BackgroundGroupModel.this.f21229h.a(responsedMessage.getError(), responsedMessage.getErrorString(), BackgroundGroupModel.this.f21227f, BackgroundGroupModel.this.f21228g);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends d.a.c.c.g.a {
        public b(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            DressItemData E;
            DressItemData E2;
            if (responsedMessage == null) {
                return;
            }
            if ((responsedMessage instanceof BackgroundSetHttpResponseMessage) || (responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                BackgroundSetRequestMessage backgroundSetRequestMessage = (BackgroundSetRequestMessage) responsedMessage.getmOrginalMessage().getExtra();
                int propId = backgroundSetRequestMessage.getPropId();
                if (responsedMessage.getError() == 0) {
                    if (propId == BackgroundGroupModel.this.f21226e.getPropId() && (E = BackgroundGroupModel.this.E(propId)) != null) {
                        TiebaStatic.log(new StatisticItem("c10286").param("obj_id", propId).param("obj_type", E.getFreeUserLevel()));
                    }
                    d.a.n0.r.d0.b j = d.a.n0.r.d0.b.j();
                    j.v("current_used_personal_background_" + TbadkCoreApplication.getCurrentAccount(), propId);
                    BackgroundGroupModel.this.K(propId);
                    BackgroundGroupModel.this.f21229h.a(responsedMessage.getError(), responsedMessage.getErrorString(), BackgroundGroupModel.this.f21227f, BackgroundGroupModel.this.f21228g);
                } else if (responsedMessage.getError() == 2270014) {
                } else {
                    int i2 = d.a.o0.k3.c.f60772b;
                    if (responsedMessage.getError() == d.a.o0.k3.c.f60773c) {
                        i2 = d.a.o0.k3.c.f60771a;
                    }
                    boolean fromDetail = backgroundSetRequestMessage.getFromDetail();
                    if (fromDetail) {
                        return;
                    }
                    if ((backgroundSetRequestMessage.getRequestUniqueId() == null || backgroundSetRequestMessage.getRequestUniqueId() == BackgroundGroupModel.this.getUniqueId()) && propId == BackgroundGroupModel.this.f21226e.getPropId() && (E2 = BackgroundGroupModel.this.E(propId)) != null) {
                        BackgroundGroupModel.this.J(i2, responsedMessage.getErrorString(), E2, fromDetail);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(int i2, String str, e eVar, List<d.a.o0.k3.e.b> list);
    }

    public BackgroundGroupModel(BackgroundGroupActivity backgroundGroupActivity) {
        super(backgroundGroupActivity.getPageContext());
        this.j = new a(CmdConfigHttp.CMD_PERSONAL_BACKGROUND_GROUP, 309020);
        this.k = new b(CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, 309022);
        this.f21226e = backgroundGroupActivity;
        this.f21230i = backgroundGroupActivity.getIntent().getBooleanExtra(IntentConfig.MEMBER_BUY_SHOW, false);
        G();
        registerListener(this.j);
        H();
        registerListener(this.k);
    }

    public final DressItemData E(int i2) {
        List<d.a.o0.k3.e.b> list = this.f21228g;
        if (list != null && list.size() > 0) {
            for (d.a.o0.k3.e.b bVar : this.f21228g) {
                if (bVar != null && bVar.a() != null) {
                    for (DressItemData dressItemData : bVar.a()) {
                        if (dressItemData != null && dressItemData.getPropsId() == i2) {
                            return dressItemData;
                        }
                    }
                    continue;
                }
            }
        }
        return null;
    }

    public boolean F() {
        return this.f21230i;
    }

    public final void G() {
        d.a.o0.e3.d0.a.h(309020, BackgroundGroupSocketResponseMessage.class, false, false);
        d.a.o0.e3.d0.a.c(309020, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_GROUP, TbConfig.PERSONAL_BACKGROUND_GROUP_PAGE, BackgroundGroupHttpResponseMessage.class, false, false, false, false);
    }

    public final void H() {
        d.a.o0.e3.d0.a.h(309022, BackgroundSetSocketResponseMessage.class, false, false);
        d.a.o0.e3.d0.a.c(309022, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
    }

    public void I(c cVar) {
        this.f21229h = cVar;
    }

    public void J(int i2, String str, DressItemData dressItemData, boolean z) {
        int i3 = (dressItemData == null || dressItemData.getFreeUserLevel() != 101) ? 0 : 9;
        if (StringUtils.isNull(str)) {
            return;
        }
        if (i2 == d.a.o0.k3.c.f60771a) {
            d.a.o0.k3.b.d(this.f21226e.getPageContext(), z ? 4 : 2, str, i3, MemberPayStatistic.REFER_PAGE_PERSONALITY_BACKGROUND, MemberPayStatistic.CLICK_ZONE_OPENDE_BUTTON);
        } else if (i2 == d.a.o0.k3.c.f60772b) {
            d.a.o0.k3.b.c(this.f21226e.getPageContext(), z ? 4 : 2, str, i3);
        }
    }

    public final void K(int i2) {
        List<d.a.o0.k3.e.b> list = this.f21228g;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (d.a.o0.k3.e.b bVar : this.f21228g) {
            if (bVar != null && bVar.a() != null) {
                for (DressItemData dressItemData : bVar.a()) {
                    if (dressItemData != null) {
                        if (dressItemData.getPropsId() == i2) {
                            dressItemData.setInUse(true);
                        } else {
                            dressItemData.setInUse(false);
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        sendMessage(new BackgroundGroupRequestMessage());
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
