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
import d.b.j0.j3.h.e;
import java.util.List;
/* loaded from: classes5.dex */
public class BackgroundGroupModel extends BdBaseModel<BackgroundGroupActivity> {

    /* renamed from: e  reason: collision with root package name */
    public BackgroundGroupActivity f21288e;

    /* renamed from: f  reason: collision with root package name */
    public e f21289f;

    /* renamed from: g  reason: collision with root package name */
    public List<d.b.j0.j3.e.b> f21290g;

    /* renamed from: h  reason: collision with root package name */
    public c f21291h;
    public boolean i;
    public d.b.c.c.g.a j;
    public d.b.c.c.g.a k;

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
            boolean z = responsedMessage instanceof BackgroundGroupHttpResponseMessage;
            if (z || (responsedMessage instanceof BackgroundGroupSocketResponseMessage)) {
                if (responsedMessage.getError() != 0) {
                    if (BackgroundGroupModel.this.f21291h != null) {
                        BackgroundGroupModel.this.f21291h.a(responsedMessage.getError(), responsedMessage.getErrorString(), BackgroundGroupModel.this.f21289f, BackgroundGroupModel.this.f21290g);
                        return;
                    }
                    return;
                }
                if (z) {
                    BackgroundGroupHttpResponseMessage backgroundGroupHttpResponseMessage = (BackgroundGroupHttpResponseMessage) responsedMessage;
                    BackgroundGroupModel.this.f21289f = backgroundGroupHttpResponseMessage.getRecommand();
                    BackgroundGroupModel.this.f21290g = backgroundGroupHttpResponseMessage.getGroupList();
                } else if (responsedMessage instanceof BackgroundGroupSocketResponseMessage) {
                    BackgroundGroupSocketResponseMessage backgroundGroupSocketResponseMessage = (BackgroundGroupSocketResponseMessage) responsedMessage;
                    BackgroundGroupModel.this.f21289f = backgroundGroupSocketResponseMessage.getRecommand();
                    BackgroundGroupModel.this.f21290g = backgroundGroupSocketResponseMessage.getGroupList();
                }
                if (BackgroundGroupModel.this.f21291h != null) {
                    BackgroundGroupModel.this.f21291h.a(responsedMessage.getError(), responsedMessage.getErrorString(), BackgroundGroupModel.this.f21289f, BackgroundGroupModel.this.f21290g);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends d.b.c.c.g.a {
        public b(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            DressItemData A;
            DressItemData A2;
            if (responsedMessage == null) {
                return;
            }
            if ((responsedMessage instanceof BackgroundSetHttpResponseMessage) || (responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                BackgroundSetRequestMessage backgroundSetRequestMessage = (BackgroundSetRequestMessage) responsedMessage.getmOrginalMessage().getExtra();
                int propId = backgroundSetRequestMessage.getPropId();
                if (responsedMessage.getError() == 0) {
                    if (propId == BackgroundGroupModel.this.f21288e.getPropId() && (A = BackgroundGroupModel.this.A(propId)) != null) {
                        TiebaStatic.log(new StatisticItem("c10286").param("obj_id", propId).param("obj_type", A.getFreeUserLevel()));
                    }
                    d.b.i0.r.d0.b j = d.b.i0.r.d0.b.j();
                    j.v("current_used_personal_background_" + TbadkCoreApplication.getCurrentAccount(), propId);
                    BackgroundGroupModel.this.G(propId);
                    BackgroundGroupModel.this.f21291h.a(responsedMessage.getError(), responsedMessage.getErrorString(), BackgroundGroupModel.this.f21289f, BackgroundGroupModel.this.f21290g);
                } else if (responsedMessage.getError() == 2270014) {
                } else {
                    int i = d.b.j0.j3.c.f58088b;
                    if (responsedMessage.getError() == d.b.j0.j3.c.f58089c) {
                        i = d.b.j0.j3.c.f58087a;
                    }
                    boolean fromDetail = backgroundSetRequestMessage.getFromDetail();
                    if (fromDetail) {
                        return;
                    }
                    if ((backgroundSetRequestMessage.getRequestUniqueId() == null || backgroundSetRequestMessage.getRequestUniqueId() == BackgroundGroupModel.this.getUniqueId()) && propId == BackgroundGroupModel.this.f21288e.getPropId() && (A2 = BackgroundGroupModel.this.A(propId)) != null) {
                        BackgroundGroupModel.this.F(i, responsedMessage.getErrorString(), A2, fromDetail);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(int i, String str, e eVar, List<d.b.j0.j3.e.b> list);
    }

    public BackgroundGroupModel(BackgroundGroupActivity backgroundGroupActivity) {
        super(backgroundGroupActivity.getPageContext());
        this.j = new a(CmdConfigHttp.CMD_PERSONAL_BACKGROUND_GROUP, 309020);
        this.k = new b(CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, 309022);
        this.f21288e = backgroundGroupActivity;
        this.i = backgroundGroupActivity.getIntent().getBooleanExtra(IntentConfig.MEMBER_BUY_SHOW, false);
        C();
        registerListener(this.j);
        D();
        registerListener(this.k);
    }

    public final DressItemData A(int i) {
        List<d.b.j0.j3.e.b> list = this.f21290g;
        if (list != null && list.size() > 0) {
            for (d.b.j0.j3.e.b bVar : this.f21290g) {
                if (bVar != null && bVar.a() != null) {
                    for (DressItemData dressItemData : bVar.a()) {
                        if (dressItemData != null && dressItemData.getPropsId() == i) {
                            return dressItemData;
                        }
                    }
                    continue;
                }
            }
        }
        return null;
    }

    public boolean B() {
        return this.i;
    }

    public final void C() {
        d.b.j0.d3.d0.a.h(309020, BackgroundGroupSocketResponseMessage.class, false, false);
        d.b.j0.d3.d0.a.c(309020, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_GROUP, TbConfig.PERSONAL_BACKGROUND_GROUP_PAGE, BackgroundGroupHttpResponseMessage.class, false, false, false, false);
    }

    public final void D() {
        d.b.j0.d3.d0.a.h(309022, BackgroundSetSocketResponseMessage.class, false, false);
        d.b.j0.d3.d0.a.c(309022, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
    }

    public void E(c cVar) {
        this.f21291h = cVar;
    }

    public void F(int i, String str, DressItemData dressItemData, boolean z) {
        int i2 = (dressItemData == null || dressItemData.getFreeUserLevel() != 101) ? 0 : 9;
        if (StringUtils.isNull(str)) {
            return;
        }
        if (i == d.b.j0.j3.c.f58087a) {
            d.b.j0.j3.b.d(this.f21288e.getPageContext(), z ? 4 : 2, str, i2, MemberPayStatistic.REFER_PAGE_PERSONALITY_BACKGROUND, MemberPayStatistic.CLICK_ZONE_OPENDE_BUTTON);
        } else if (i == d.b.j0.j3.c.f58088b) {
            d.b.j0.j3.b.c(this.f21288e.getPageContext(), z ? 4 : 2, str, i2);
        }
    }

    public final void G(int i) {
        List<d.b.j0.j3.e.b> list = this.f21290g;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (d.b.j0.j3.e.b bVar : this.f21290g) {
            if (bVar != null && bVar.a() != null) {
                for (DressItemData dressItemData : bVar.a()) {
                    if (dressItemData != null) {
                        if (dressItemData.getPropsId() == i) {
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
