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
import d.a.o0.k3.h.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class BackgroundListModel extends BdBaseModel<BackgroundListActivity> {

    /* renamed from: e  reason: collision with root package name */
    public BackgroundListActivity f21242e;

    /* renamed from: f  reason: collision with root package name */
    public e f21243f;

    /* renamed from: g  reason: collision with root package name */
    public List<DressItemData> f21244g;

    /* renamed from: h  reason: collision with root package name */
    public List<DressItemData> f21245h;

    /* renamed from: i  reason: collision with root package name */
    public DressItemData f21246i;
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
                        BackgroundListModel.this.f21243f = backgroundListHttpResponseMessage.getRecommand();
                        BackgroundListModel.this.f21244g = backgroundListHttpResponseMessage.getBackgroundList();
                        BackgroundListModel.this.l = backgroundListHttpResponseMessage.hasMore();
                        BackgroundListModel.this.m = backgroundListHttpResponseMessage.getIsDefault();
                    } else if (responsedMessage instanceof BackgroundListSocketResponseMessage) {
                        BackgroundListSocketResponseMessage backgroundListSocketResponseMessage = (BackgroundListSocketResponseMessage) responsedMessage;
                        BackgroundListModel.this.f21243f = backgroundListSocketResponseMessage.getRecommand();
                        BackgroundListModel.this.f21244g = backgroundListSocketResponseMessage.getBackgroundList();
                        BackgroundListModel.this.l = backgroundListSocketResponseMessage.hasMore();
                        BackgroundListModel.this.m = backgroundListSocketResponseMessage.getIsDefault();
                    }
                    if (BackgroundListModel.this.f21245h == null) {
                        BackgroundListModel.this.f21245h = new ArrayList();
                        BackgroundListModel.this.f21245h.add(BackgroundListModel.this.f21246i);
                    }
                    if (BackgroundListModel.this.k == 1) {
                        BackgroundListModel.this.f21245h.clear();
                        BackgroundListModel.this.f21245h.add(BackgroundListModel.this.f21246i);
                    }
                    if (BackgroundListModel.this.f21244g != null) {
                        BackgroundListModel.this.f21245h.addAll(BackgroundListModel.this.f21244g);
                    }
                } else {
                    BackgroundListModel.y(BackgroundListModel.this);
                }
                if (BackgroundListModel.this.j != null) {
                    BackgroundListModel.this.O();
                    BackgroundListModel.this.j.a(responsedMessage.getError(), responsedMessage.getErrorString(), BackgroundListModel.this.f21243f, BackgroundListModel.this.f21245h);
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
            DressItemData N;
            DressItemData N2;
            if (responsedMessage == null) {
                return;
            }
            if ((responsedMessage instanceof BackgroundSetHttpResponseMessage) || (responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                BackgroundSetRequestMessage backgroundSetRequestMessage = (BackgroundSetRequestMessage) responsedMessage.getmOrginalMessage().getExtra();
                int propId = backgroundSetRequestMessage.getPropId();
                if (responsedMessage.getError() == 0) {
                    if (propId == BackgroundListModel.this.f21242e.getPropId() && (N = BackgroundListModel.this.N(propId)) != null) {
                        TiebaStatic.log(new StatisticItem("c10286").param("obj_id", propId).param("obj_type", N.getFreeUserLevel()));
                    }
                    d.a.n0.r.d0.b j = d.a.n0.r.d0.b.j();
                    j.v("current_used_personal_background_" + TbadkCoreApplication.getCurrentAccount(), propId);
                    BackgroundListModel.this.T(propId);
                    BackgroundListModel.this.j.a(responsedMessage.getError(), responsedMessage.getErrorString(), BackgroundListModel.this.f21243f, BackgroundListModel.this.f21245h);
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
                    if ((backgroundSetRequestMessage.getRequestUniqueId() == null || backgroundSetRequestMessage.getRequestUniqueId() == BackgroundListModel.this.getUniqueId()) && propId == BackgroundListModel.this.f21242e.getPropId() && (N2 = BackgroundListModel.this.N(propId)) != null) {
                        BackgroundListModel.this.S(i2, responsedMessage.getErrorString(), N2, fromDetail);
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
        this.f21242e = backgroundListActivity;
        DressItemData dressItemData = new DressItemData();
        this.f21246i = dressItemData;
        dressItemData.setPropsId(0);
        this.f21246i.setTitle(TbadkCoreApplication.getInst().getString(R.string.default_background));
        ArrayList arrayList = new ArrayList();
        this.f21245h = arrayList;
        arrayList.add(this.f21246i);
        this.n = backgroundListActivity.getIntent().getBooleanExtra(IntentConfig.MEMBER_BUY_SHOW, false);
        registerTask();
        registerListener(this.o);
        Q();
        registerListener(this.p);
    }

    public static /* synthetic */ int y(BackgroundListModel backgroundListModel) {
        int i2 = backgroundListModel.k;
        backgroundListModel.k = i2 - 1;
        return i2;
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

    public final DressItemData N(int i2) {
        List<DressItemData> list = this.f21245h;
        if (list != null && list.size() > 0) {
            for (DressItemData dressItemData : this.f21245h) {
                if (dressItemData != null && dressItemData.getPropsId() == i2) {
                    return dressItemData;
                }
            }
        }
        return null;
    }

    public final void O() {
        DressItemData N;
        if (!this.m || (N = N(0)) == null) {
            return;
        }
        N.setInUse(true);
    }

    public boolean P() {
        return this.n;
    }

    public final void Q() {
        d.a.o0.e3.d0.a.h(309022, BackgroundSetSocketResponseMessage.class, false, false);
        d.a.o0.e3.d0.a.c(309022, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
    }

    public void R(c cVar) {
        this.j = cVar;
    }

    public void S(int i2, String str, DressItemData dressItemData, boolean z) {
        int i3 = (dressItemData == null || dressItemData.getFreeUserLevel() != 101) ? 0 : 9;
        if (StringUtils.isNull(str)) {
            return;
        }
        if (i2 == d.a.o0.k3.c.f60771a) {
            d.a.o0.k3.b.d(this.f21242e.getPageContext(), z ? 4 : 2, str, i3, MemberPayStatistic.REFER_PAGE_ALL_BACKGROUND, MemberPayStatistic.CLICK_ZONE_OPENDE_BUTTON);
        } else if (i2 == d.a.o0.k3.c.f60772b) {
            d.a.o0.k3.b.c(this.f21242e.getPageContext(), z ? 4 : 2, str, i3);
        }
    }

    public final void T(int i2) {
        List<DressItemData> list = this.f21245h;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (DressItemData dressItemData : this.f21245h) {
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
        d.a.o0.e3.d0.a.h(309021, BackgroundListSocketResponseMessage.class, false, false);
        d.a.o0.e3.d0.a.c(309021, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_LIST, TbConfig.PERSONAL_BACKGROUND_LIST_PAGE, BackgroundListHttpResponseMessage.class, false, false, false, false);
    }

    public void w() {
        if (this.l) {
            this.k++;
            BackgroundListRequestMessage backgroundListRequestMessage = new BackgroundListRequestMessage();
            backgroundListRequestMessage.setPn(this.k);
            backgroundListRequestMessage.setRn(9);
            sendMessage(backgroundListRequestMessage);
        }
    }
}
