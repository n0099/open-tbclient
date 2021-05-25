package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import d.a.n0.k3.h.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class BackgroundListModel extends BdBaseModel<BackgroundListActivity> {

    /* renamed from: e  reason: collision with root package name */
    public BackgroundListActivity f21082e;

    /* renamed from: f  reason: collision with root package name */
    public e f21083f;

    /* renamed from: g  reason: collision with root package name */
    public List<DressItemData> f21084g;

    /* renamed from: h  reason: collision with root package name */
    public List<DressItemData> f21085h;

    /* renamed from: i  reason: collision with root package name */
    public DressItemData f21086i;
    public c j;
    public boolean n;
    public int k = 0;
    public boolean l = true;
    public boolean m = false;
    public d.a.c.c.g.a o = new a(CmdConfigHttp.CMD_PERSONAL_BACKGROUND_LIST, 309021);
    public d.a.c.c.g.a p = new b(CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, 309022);

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
            boolean z = responsedMessage instanceof BackgroundListHttpResponseMessage;
            if (z || (responsedMessage instanceof BackgroundListSocketResponseMessage)) {
                if (responsedMessage.getError() == 0) {
                    if (z) {
                        BackgroundListHttpResponseMessage backgroundListHttpResponseMessage = (BackgroundListHttpResponseMessage) responsedMessage;
                        BackgroundListModel.this.f21083f = backgroundListHttpResponseMessage.getRecommand();
                        BackgroundListModel.this.f21084g = backgroundListHttpResponseMessage.getBackgroundList();
                        BackgroundListModel.this.l = backgroundListHttpResponseMessage.hasMore();
                        BackgroundListModel.this.m = backgroundListHttpResponseMessage.getIsDefault();
                    } else if (responsedMessage instanceof BackgroundListSocketResponseMessage) {
                        BackgroundListSocketResponseMessage backgroundListSocketResponseMessage = (BackgroundListSocketResponseMessage) responsedMessage;
                        BackgroundListModel.this.f21083f = backgroundListSocketResponseMessage.getRecommand();
                        BackgroundListModel.this.f21084g = backgroundListSocketResponseMessage.getBackgroundList();
                        BackgroundListModel.this.l = backgroundListSocketResponseMessage.hasMore();
                        BackgroundListModel.this.m = backgroundListSocketResponseMessage.getIsDefault();
                    }
                    if (BackgroundListModel.this.f21085h == null) {
                        BackgroundListModel.this.f21085h = new ArrayList();
                        BackgroundListModel.this.f21085h.add(BackgroundListModel.this.f21086i);
                    }
                    if (BackgroundListModel.this.k == 1) {
                        BackgroundListModel.this.f21085h.clear();
                        BackgroundListModel.this.f21085h.add(BackgroundListModel.this.f21086i);
                    }
                    if (BackgroundListModel.this.f21084g != null) {
                        BackgroundListModel.this.f21085h.addAll(BackgroundListModel.this.f21084g);
                    }
                } else {
                    BackgroundListModel.u(BackgroundListModel.this);
                }
                if (BackgroundListModel.this.j != null) {
                    BackgroundListModel.this.K();
                    BackgroundListModel.this.j.a(responsedMessage.getError(), responsedMessage.getErrorString(), BackgroundListModel.this.f21083f, BackgroundListModel.this.f21085h);
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
            DressItemData J;
            DressItemData J2;
            if (responsedMessage == null) {
                return;
            }
            if ((responsedMessage instanceof BackgroundSetHttpResponseMessage) || (responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                BackgroundSetRequestMessage backgroundSetRequestMessage = (BackgroundSetRequestMessage) responsedMessage.getmOrginalMessage().getExtra();
                int propId = backgroundSetRequestMessage.getPropId();
                if (responsedMessage.getError() == 0) {
                    if (propId == BackgroundListModel.this.f21082e.getPropId() && (J = BackgroundListModel.this.J(propId)) != null) {
                        TiebaStatic.log(new StatisticItem("c10286").param("obj_id", propId).param("obj_type", J.getFreeUserLevel()));
                    }
                    d.a.m0.r.d0.b j = d.a.m0.r.d0.b.j();
                    j.v("current_used_personal_background_" + TbadkCoreApplication.getCurrentAccount(), propId);
                    BackgroundListModel.this.P(propId);
                    BackgroundListModel.this.j.a(responsedMessage.getError(), responsedMessage.getErrorString(), BackgroundListModel.this.f21083f, BackgroundListModel.this.f21085h);
                } else if (responsedMessage.getError() == 2270014) {
                } else {
                    int i2 = d.a.n0.k3.c.f56958b;
                    if (responsedMessage.getError() == d.a.n0.k3.c.f56959c) {
                        i2 = d.a.n0.k3.c.f56957a;
                    }
                    boolean fromDetail = backgroundSetRequestMessage.getFromDetail();
                    if (fromDetail) {
                        return;
                    }
                    if ((backgroundSetRequestMessage.getRequestUniqueId() == null || backgroundSetRequestMessage.getRequestUniqueId() == BackgroundListModel.this.getUniqueId()) && propId == BackgroundListModel.this.f21082e.getPropId() && (J2 = BackgroundListModel.this.J(propId)) != null) {
                        BackgroundListModel.this.O(i2, responsedMessage.getErrorString(), J2, fromDetail);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(int i2, String str, e eVar, List<DressItemData> list);
    }

    public BackgroundListModel(BackgroundListActivity backgroundListActivity) {
        this.f21082e = backgroundListActivity;
        DressItemData dressItemData = new DressItemData();
        this.f21086i = dressItemData;
        dressItemData.setPropsId(0);
        this.f21086i.setTitle(TbadkCoreApplication.getInst().getString(R.string.default_background));
        ArrayList arrayList = new ArrayList();
        this.f21085h = arrayList;
        arrayList.add(this.f21086i);
        this.n = backgroundListActivity.getIntent().getBooleanExtra(IntentConfig.MEMBER_BUY_SHOW, false);
        registerTask();
        registerListener(this.o);
        M();
        registerListener(this.p);
    }

    public static /* synthetic */ int u(BackgroundListModel backgroundListModel) {
        int i2 = backgroundListModel.k;
        backgroundListModel.k = i2 - 1;
        return i2;
    }

    public final DressItemData J(int i2) {
        List<DressItemData> list = this.f21085h;
        if (list != null && list.size() > 0) {
            for (DressItemData dressItemData : this.f21085h) {
                if (dressItemData != null && dressItemData.getPropsId() == i2) {
                    return dressItemData;
                }
            }
        }
        return null;
    }

    public final void K() {
        DressItemData J;
        if (!this.m || (J = J(0)) == null) {
            return;
        }
        J.setInUse(true);
    }

    public boolean L() {
        return this.n;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        BackgroundListRequestMessage backgroundListRequestMessage = new BackgroundListRequestMessage();
        this.k = 1;
        backgroundListRequestMessage.setPn(1);
        backgroundListRequestMessage.setRn(9);
        sendMessage(backgroundListRequestMessage);
        return false;
    }

    public final void M() {
        d.a.n0.e3.d0.a.h(309022, BackgroundSetSocketResponseMessage.class, false, false);
        d.a.n0.e3.d0.a.c(309022, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
    }

    public void N(c cVar) {
        this.j = cVar;
    }

    public void O(int i2, String str, DressItemData dressItemData, boolean z) {
        int i3 = (dressItemData == null || dressItemData.getFreeUserLevel() != 101) ? 0 : 9;
        if (StringUtils.isNull(str)) {
            return;
        }
        if (i2 == d.a.n0.k3.c.f56957a) {
            d.a.n0.k3.b.d(this.f21082e.getPageContext(), z ? 4 : 2, str, i3, MemberPayStatistic.REFER_PAGE_ALL_BACKGROUND, MemberPayStatistic.CLICK_ZONE_OPENDE_BUTTON);
        } else if (i2 == d.a.n0.k3.c.f56958b) {
            d.a.n0.k3.b.c(this.f21082e.getPageContext(), z ? 4 : 2, str, i3);
        }
    }

    public final void P(int i2) {
        List<DressItemData> list = this.f21085h;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (DressItemData dressItemData : this.f21085h) {
            if (dressItemData != null) {
                if (dressItemData.getPropsId() == i2) {
                    dressItemData.setInUse(true);
                } else {
                    dressItemData.setInUse(false);
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.o);
        MessageManager.getInstance().unRegisterListener(this.p);
    }

    public final void registerTask() {
        d.a.n0.e3.d0.a.h(309021, BackgroundListSocketResponseMessage.class, false, false);
        d.a.n0.e3.d0.a.c(309021, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_LIST, TbConfig.PERSONAL_BACKGROUND_LIST_PAGE, BackgroundListHttpResponseMessage.class, false, false, false, false);
    }

    public void s() {
        if (this.l) {
            this.k++;
            BackgroundListRequestMessage backgroundListRequestMessage = new BackgroundListRequestMessage();
            backgroundListRequestMessage.setPn(this.k);
            backgroundListRequestMessage.setRn(9);
            sendMessage(backgroundListRequestMessage);
        }
    }
}
