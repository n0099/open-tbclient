package com.baidu.tieba.myCollection;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.collectTab.CollectFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.m0.r.f0.f;
import d.a.m0.r.s.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class ThreadFragment extends CollectFragment implements View.OnClickListener, f.g, BdListView.p {
    public ArrayList<MarkData> j;
    public MarkData k;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.x1.g.a f18410g = null;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.x1.f f18411h = null;

    /* renamed from: i  reason: collision with root package name */
    public int f18412i = -1;
    public final CustomMessageListener l = new e(2000994);
    public final CustomMessageListener m = new f(2001115);
    public final AntiHelper.k n = new g();

    /* loaded from: classes3.dex */
    public class a implements a.e {
        public a() {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            aVar.dismiss();
            ThreadFragment.this.f18411h.v(ThreadFragment.this.f18410g.q());
            ThreadFragment.this.f18410g.w(Boolean.TRUE);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.a.n0.x1.d {
        public b() {
        }

        @Override // d.a.n0.x1.d
        public void a(Object... objArr) {
            try {
                if (((Integer) objArr[0]).intValue() == 0) {
                    ThreadFragment.this.f18411h.c();
                    if (objArr[1] != null && (objArr[1] instanceof String)) {
                        r3 = (String) objArr[1];
                    }
                    ThreadFragment.this.f18411h.e(r3, ThreadFragment.this.f18410g, ((Boolean) objArr[2]).booleanValue());
                    ThreadFragment.this.j = ThreadFragment.this.f18410g.n();
                    ThreadFragment threadFragment = ThreadFragment.this;
                    if (ThreadFragment.this.j != null && !ThreadFragment.this.j.isEmpty()) {
                        r0 = true;
                    }
                    threadFragment.f11979e = r0;
                } else if (((Integer) objArr[0]).intValue() == 3) {
                    ThreadFragment.this.f18411h.c();
                    ThreadFragment.this.f18411h.e((objArr[1] == null || !(objArr[1] instanceof String)) ? null : (String) objArr[1], null, false);
                    ThreadFragment.this.f18411h.p(ThreadFragment.this.f18410g, false);
                    ThreadFragment.this.f11979e = false;
                } else if (((Integer) objArr[0]).intValue() == 1) {
                    boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                    ThreadFragment.this.f18411h.f(booleanValue, objArr[2] != null ? (String) objArr[2] : null, objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false);
                    if (booleanValue) {
                        ThreadFragment.this.f18411h.v(ThreadFragment.this.f18410g.q());
                        ThreadFragment.this.f18410g.w(Boolean.TRUE);
                    }
                } else if (((Integer) objArr[0]).intValue() == 2) {
                    ThreadFragment.this.f18411h.d(objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false, objArr[2] != null ? (String) objArr[2] : null, ThreadFragment.this.f18410g);
                    ThreadFragment.this.j = ThreadFragment.this.f18410g.n();
                    ThreadFragment threadFragment2 = ThreadFragment.this;
                    if (ThreadFragment.this.j != null && !ThreadFragment.this.j.isEmpty()) {
                        r0 = true;
                    }
                    threadFragment2.f11979e = r0;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                BdLog.d(e2.getMessage());
            }
            ThreadFragment.this.G0(1);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof Bundle) {
                Bundle bundle = (Bundle) customResponsedMessage.getData();
                if (bundle.getInt("fragment_type", -1) == ThreadFragment.this.D0()) {
                    ThreadFragment.this.f18411h.a(bundle.getBoolean("is_edit_state", false));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            d.a.n0.x1.c.c("c14066", ((Boolean) customResponsedMessage.getData()).booleanValue(), ThreadFragment.this.k);
        }
    }

    /* loaded from: classes3.dex */
    public class e extends CustomMessageListener {
        public e(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (!j.z()) {
                    ThreadFragment.this.f18411h.j();
                    ThreadFragment.this.f18411h.c();
                    ThreadFragment.this.f18411h.r(false);
                    ThreadFragment.this.f18411h.b(false);
                    return;
                }
                ThreadFragment.this.f18410g.w(Boolean.FALSE);
                ThreadFragment.this.f18411h.b(true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends CustomMessageListener {
        public f(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage.a data = ((UpdateAttentionMessage) customResponsedMessage).getData();
                if (ThreadFragment.this.j == null || data == null) {
                    return;
                }
                if (data.l != null && AntiHelper.t(ThreadFragment.this.getActivity(), data.l, ThreadFragment.this.n) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                }
                if (data.f12574a) {
                    Iterator it = ThreadFragment.this.j.iterator();
                    while (it.hasNext()) {
                        MarkData markData = (MarkData) it.next();
                        if (markData != null && StringHelper.equals(markData.getUesrId(), data.f12576c)) {
                            markData.metaData.setIsLike(data.f12577d);
                            markData.setLikeInPage(data.f12577d);
                        }
                    }
                    if (data.f12577d) {
                        l.L(ThreadFragment.this.getPageContext().getPageActivity(), R.string.attention_success);
                    }
                    ThreadFragment.this.f18411h.m();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements AntiHelper.k {
        public g() {
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d.a.m0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.a.m0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
        }
    }

    public static final ThreadFragment S0() {
        return new ThreadFragment();
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public int D0() {
        return 1;
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public boolean E0() {
        ArrayList<MarkData> arrayList = this.j;
        return arrayList == null || arrayList.isEmpty();
    }

    public final void T0() {
        registerListener(new c(2022208));
    }

    public final void U0() {
        registerListener(new d(2921531));
    }

    public final void V0(MarkData markData) {
        d.a.n0.x1.g.a aVar;
        if (markData == null || (aVar = this.f18410g) == null) {
            return;
        }
        int o = aVar.o();
        int w = d.a.m0.s.d.b.g0().w();
        TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "my_favorite_content", "is_redpoint", markData.getNewCounts() > 0 ? 1 : 0, new Object[0]);
        if (markData.getNewCounts() > 0) {
            if (w > 0) {
                d.a.m0.s.d.b.g0().a0(w - 1);
            } else {
                d.a.m0.s.d.b.g0().a0(0);
            }
            if (o > 0) {
                this.f18410g.C(o - 1);
            } else {
                this.f18410g.C(0);
            }
        }
        markData.setNewCounts(0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        d.a.n0.x1.g.a aVar;
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            if (i3 != 1 || 17001 != i2 || (aVar = this.f18410g) == null || this.f18411h == null) {
                return;
            }
            int count = ListUtils.getCount(aVar.n());
            int i4 = this.f18412i;
            if (count <= i4 || i4 < 0) {
                return;
            }
            this.f18410g.n().remove(this.f18412i);
            this.f18411h.m();
            this.f18411h.p(this.f18410g, false);
        } else if (17001 == i2) {
            MarkData markData = (MarkData) intent.getSerializableExtra("mark");
            d.a.n0.x1.g.a aVar2 = this.f18410g;
            if (aVar2 == null || markData == null || this.f18411h == null) {
                return;
            }
            int count2 = ListUtils.getCount(aVar2.n());
            int i5 = this.f18412i;
            if (count2 <= i5 || i5 < 0) {
                return;
            }
            this.f18410g.n().get(this.f18412i).setPostId(markData.getPostId());
            this.f18410g.n().get(this.f18412i).setHostMode(markData.getHostMode());
            this.f18410g.n().get(this.f18412i).setSequence(markData.getSequence());
            this.f18411h.m();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        d.a.n0.x1.f fVar = this.f18411h;
        if (fVar != null) {
            fVar.n(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        MarkData markData = (MarkData) ListUtils.getItem(this.j, intValue);
        this.k = markData;
        if (markData == null) {
            return;
        }
        boolean isShareThread = markData.isShareThread();
        StatisticItem statisticItem = new StatisticItem("c12529");
        if (view.getId() == this.f18411h.g(isShareThread)) {
            BdListView bdListView = this.f18411h.f63255c;
            if (bdListView != null && !bdListView.C()) {
                return;
            }
            this.f18411h.u();
            if (!this.f18410g.D(intValue)) {
                this.f18411h.j();
            }
            d.a.n0.x1.c.b("c14069", markData);
        } else if (view.getId() == this.f18411h.i(isShareThread)) {
            this.f18411h.l(markData);
            statisticItem.param("obj_locate", 1);
            d.a.n0.x1.c.b("c14064", markData);
        } else if (view.getId() == this.f18411h.h(isShareThread)) {
            statisticItem.param("obj_locate", 3);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createMarkCfg(markData.getThreadId(), markData.getPostId(), markData.getHostMode(), markData.getSequence().booleanValue(), null, 17001)));
            d.a.n0.x1.c.b("c14063", markData);
            V0(markData);
        }
        statisticItem.param("tid", markData.getId());
        statisticItem.param("obj_id", markData.getUesrId());
        TiebaStatic.log(statisticItem);
        super.onClick(view);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        T0();
        registerListener(this.l);
        registerListener(this.m);
        U0();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.edit_mark_activity, (ViewGroup) null);
        this.f18410g = new d.a.n0.x1.g.a();
        d.a.n0.x1.f fVar = new d.a.n0.x1.f(this, inflate);
        this.f18411h = fVar;
        fVar.q(new a());
        this.f18411h.b(j.z());
        this.f18410g.A(new b());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.f18411h.o();
        this.f18410g.s();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        if (i2 >= 0 && i2 < this.f18410g.n().size()) {
            this.f18412i = i2;
            MarkData markData = this.f18410g.n().get(i2);
            MarkData markData2 = this.j.get(i2);
            this.k = markData2;
            StatisticItem statisticItem = new StatisticItem("c12529");
            statisticItem.param("obj_locate", 2);
            statisticItem.param("tid", markData2.getId());
            statisticItem.param("obj_id", markData2.getUesrId());
            TiebaStatic.log(statisticItem);
            if (markData != null) {
                if (markData.isManga()) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(MangaBrowserActivityConfig.class)) {
                        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                            ViewHelper.skipToLoginActivity(getPageContext().getPageActivity());
                        } else {
                            sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), markData.getCartoonId(), markData.getChapterId(), 3)));
                        }
                    } else {
                        l.L(getPageContext().getPageActivity(), R.string.manga_plugin_not_install_tip);
                    }
                } else {
                    PbActivityConfig createMarkCfg = new PbActivityConfig(getPageContext().getPageActivity()).createMarkCfg(markData.getThreadId(), markData.getPostId(), markData.getHostMode(), markData.getSequence().booleanValue(), null, 17001);
                    createMarkCfg.setStartFrom(10);
                    createMarkCfg.setJumpToCommentArea(true);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createMarkCfg));
                    d.a.n0.x1.c.b("c14063", markData2);
                }
            }
            V0(markData2);
            markData2.setRedTipShow(false);
        }
        super.onItemClick(adapterView, view, i2, j);
    }

    @Override // d.a.m0.r.f0.f.g
    public void onListPullRefresh(boolean z) {
        d.a.n0.x1.g.a aVar = this.f18410g;
        if (aVar == null || this.f18411h == null) {
            return;
        }
        aVar.z();
        this.f18411h.r(true);
        this.f18410g.w(Boolean.FALSE);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        d.a.n0.x1.f fVar = this.f18411h;
        if (fVar != null) {
            fVar.w(this.j);
            ArrayList<MarkData> arrayList = this.j;
            this.f11979e = (arrayList == null || arrayList.isEmpty()) ? false : true;
            G0(1);
            refresh();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        d.a.n0.x1.g.a aVar;
        if (this.f18411h == null || (aVar = this.f18410g) == null || !aVar.r()) {
            return;
        }
        this.f18411h.v(this.f18410g.q());
        this.f18410g.w(Boolean.FALSE);
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.f18411h.x();
    }

    public final void refresh() {
        if (this.f18410g.m() == 0) {
            this.f18411h.v(this.f18410g.q());
        }
    }
}
