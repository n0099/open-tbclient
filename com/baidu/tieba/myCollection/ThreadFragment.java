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
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import d.b.h0.r.f0.f;
import d.b.h0.r.s.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class ThreadFragment extends CollectFragment implements View.OnClickListener, f.g, BdListView.p {
    public ArrayList<MarkData> j;
    public MarkData k;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.w1.g.a f18766g = null;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.w1.f f18767h = null;
    public int i = -1;
    public final CustomMessageListener l = new e(2000994);
    public final CustomMessageListener m = new f(2001115);
    public final AntiHelper.k n = new g();

    /* loaded from: classes3.dex */
    public class a implements a.e {
        public a() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
            ThreadFragment.this.f18767h.v(ThreadFragment.this.f18766g.q());
            ThreadFragment.this.f18766g.w(Boolean.TRUE);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.b.i0.w1.d {
        public b() {
        }

        @Override // d.b.i0.w1.d
        public void a(Object... objArr) {
            try {
                if (((Integer) objArr[0]).intValue() == 0) {
                    ThreadFragment.this.f18767h.c();
                    if (objArr[1] != null && (objArr[1] instanceof String)) {
                        r3 = (String) objArr[1];
                    }
                    ThreadFragment.this.f18767h.e(r3, ThreadFragment.this.f18766g, ((Boolean) objArr[2]).booleanValue());
                    ThreadFragment.this.j = ThreadFragment.this.f18766g.n();
                    ThreadFragment threadFragment = ThreadFragment.this;
                    if (ThreadFragment.this.j != null && !ThreadFragment.this.j.isEmpty()) {
                        r0 = true;
                    }
                    threadFragment.f12811e = r0;
                } else if (((Integer) objArr[0]).intValue() == 3) {
                    ThreadFragment.this.f18767h.c();
                    ThreadFragment.this.f18767h.e((objArr[1] == null || !(objArr[1] instanceof String)) ? null : (String) objArr[1], null, false);
                    ThreadFragment.this.f18767h.p(ThreadFragment.this.f18766g, false);
                    ThreadFragment.this.f12811e = false;
                } else if (((Integer) objArr[0]).intValue() == 1) {
                    boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                    ThreadFragment.this.f18767h.f(booleanValue, objArr[2] != null ? (String) objArr[2] : null, objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false);
                    if (booleanValue) {
                        ThreadFragment.this.f18767h.v(ThreadFragment.this.f18766g.q());
                        ThreadFragment.this.f18766g.w(Boolean.TRUE);
                    }
                } else if (((Integer) objArr[0]).intValue() == 2) {
                    ThreadFragment.this.f18767h.d(objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false, objArr[2] != null ? (String) objArr[2] : null, ThreadFragment.this.f18766g);
                    ThreadFragment.this.j = ThreadFragment.this.f18766g.n();
                    ThreadFragment threadFragment2 = ThreadFragment.this;
                    if (ThreadFragment.this.j != null && !ThreadFragment.this.j.isEmpty()) {
                        r0 = true;
                    }
                    threadFragment2.f12811e = r0;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                BdLog.d(e2.getMessage());
            }
            ThreadFragment.this.H0(1);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof Bundle) {
                Bundle bundle = (Bundle) customResponsedMessage.getData();
                if (bundle.getInt("fragment_type", -1) == ThreadFragment.this.E0()) {
                    ThreadFragment.this.f18767h.a(bundle.getBoolean("is_edit_state", false));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            d.b.i0.w1.c.c("c14066", ((Boolean) customResponsedMessage.getData()).booleanValue(), ThreadFragment.this.k);
        }
    }

    /* loaded from: classes3.dex */
    public class e extends CustomMessageListener {
        public e(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (!j.z()) {
                    ThreadFragment.this.f18767h.j();
                    ThreadFragment.this.f18767h.c();
                    ThreadFragment.this.f18767h.r(false);
                    ThreadFragment.this.f18767h.b(false);
                    return;
                }
                ThreadFragment.this.f18766g.w(Boolean.FALSE);
                ThreadFragment.this.f18767h.b(true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends CustomMessageListener {
        public f(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage.a data = ((UpdateAttentionMessage) customResponsedMessage).getData();
                if (ThreadFragment.this.j == null || data == null) {
                    return;
                }
                if (data.k != null && AntiHelper.t(ThreadFragment.this.getActivity(), data.k, ThreadFragment.this.n) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                }
                if (data.f13354a) {
                    Iterator it = ThreadFragment.this.j.iterator();
                    while (it.hasNext()) {
                        MarkData markData = (MarkData) it.next();
                        if (markData != null && StringHelper.equals(markData.getUesrId(), data.f13356c)) {
                            markData.metaData.setIsLike(data.f13357d);
                            markData.setLikeInPage(data.f13357d);
                        }
                    }
                    if (data.f13357d) {
                        l.K(ThreadFragment.this.getPageContext().getPageActivity(), R.string.attention_success);
                    }
                    ThreadFragment.this.f18767h.m();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements AntiHelper.k {
        public g() {
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d.b.h0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.b.h0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
        }
    }

    public static final ThreadFragment T0() {
        return new ThreadFragment();
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public int E0() {
        return 1;
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public boolean F0() {
        ArrayList<MarkData> arrayList = this.j;
        return arrayList == null || arrayList.isEmpty();
    }

    public final void U0() {
        registerListener(new c(2022208));
    }

    public final void V0() {
        registerListener(new d(2921531));
    }

    public final void W0(MarkData markData) {
        d.b.i0.w1.g.a aVar;
        if (markData == null || (aVar = this.f18766g) == null) {
            return;
        }
        int o = aVar.o();
        int w = d.b.h0.s.d.b.g0().w();
        TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "my_favorite_content", "is_redpoint", markData.getNewCounts() > 0 ? 1 : 0, new Object[0]);
        if (markData.getNewCounts() > 0) {
            if (w > 0) {
                d.b.h0.s.d.b.g0().a0(w - 1);
            } else {
                d.b.h0.s.d.b.g0().a0(0);
            }
            if (o > 0) {
                this.f18766g.C(o - 1);
            } else {
                this.f18766g.C(0);
            }
        }
        markData.setNewCounts(0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        d.b.i0.w1.g.a aVar;
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            if (i2 != 1 || 17001 != i || (aVar = this.f18766g) == null || this.f18767h == null) {
                return;
            }
            int count = ListUtils.getCount(aVar.n());
            int i3 = this.i;
            if (count <= i3 || i3 < 0) {
                return;
            }
            this.f18766g.n().remove(this.i);
            this.f18767h.m();
            this.f18767h.p(this.f18766g, false);
        } else if (17001 == i) {
            MarkData markData = (MarkData) intent.getSerializableExtra("mark");
            d.b.i0.w1.g.a aVar2 = this.f18766g;
            if (aVar2 == null || markData == null || this.f18767h == null) {
                return;
            }
            int count2 = ListUtils.getCount(aVar2.n());
            int i4 = this.i;
            if (count2 <= i4 || i4 < 0) {
                return;
            }
            this.f18766g.n().get(this.i).setPostId(markData.getPostId());
            this.f18766g.n().get(this.i).setHostMode(markData.getHostMode());
            this.f18766g.n().get(this.i).setSequence(markData.getSequence());
            this.f18767h.m();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        d.b.i0.w1.f fVar = this.f18767h;
        if (fVar != null) {
            fVar.n(i);
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
        if (view.getId() == this.f18767h.g(isShareThread)) {
            BdListView bdListView = this.f18767h.f63672c;
            if (bdListView != null && !bdListView.C()) {
                return;
            }
            this.f18767h.u();
            if (!this.f18766g.D(intValue)) {
                this.f18767h.j();
            }
            d.b.i0.w1.c.b("c14069", markData);
        } else if (view.getId() == this.f18767h.i(isShareThread)) {
            this.f18767h.l(markData);
            statisticItem.param("obj_locate", 1);
            d.b.i0.w1.c.b("c14064", markData);
        } else if (view.getId() == this.f18767h.h(isShareThread)) {
            statisticItem.param("obj_locate", 3);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createMarkCfg(markData.getThreadId(), markData.getPostId(), markData.getHostMode(), markData.getSequence().booleanValue(), null, 17001)));
            d.b.i0.w1.c.b("c14063", markData);
            W0(markData);
        }
        statisticItem.param("tid", markData.getId());
        statisticItem.param("obj_id", markData.getUesrId());
        TiebaStatic.log(statisticItem);
        super.onClick(view);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        U0();
        registerListener(this.l);
        registerListener(this.m);
        V0();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.edit_mark_activity, (ViewGroup) null);
        this.f18766g = new d.b.i0.w1.g.a();
        d.b.i0.w1.f fVar = new d.b.i0.w1.f(this, inflate);
        this.f18767h = fVar;
        fVar.q(new a());
        this.f18767h.b(j.z());
        this.f18766g.A(new b());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.f18767h.o();
        this.f18766g.s();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.f18766g.n().size()) {
            this.i = i;
            MarkData markData = this.f18766g.n().get(i);
            MarkData markData2 = this.j.get(i);
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
                        l.K(getPageContext().getPageActivity(), R.string.manga_plugin_not_install_tip);
                    }
                } else {
                    PbActivityConfig createMarkCfg = new PbActivityConfig(getPageContext().getPageActivity()).createMarkCfg(markData.getThreadId(), markData.getPostId(), markData.getHostMode(), markData.getSequence().booleanValue(), null, 17001);
                    createMarkCfg.setStartFrom(10);
                    createMarkCfg.setJumpToCommentArea(true);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createMarkCfg));
                    d.b.i0.w1.c.b("c14063", markData2);
                }
            }
            W0(markData2);
            markData2.setRedTipShow(false);
        }
        super.onItemClick(adapterView, view, i, j);
    }

    @Override // d.b.h0.r.f0.f.g
    public void onListPullRefresh(boolean z) {
        d.b.i0.w1.g.a aVar = this.f18766g;
        if (aVar == null || this.f18767h == null) {
            return;
        }
        aVar.z();
        this.f18767h.r(true);
        this.f18766g.w(Boolean.FALSE);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        d.b.i0.w1.f fVar = this.f18767h;
        if (fVar != null) {
            fVar.w(this.j);
            ArrayList<MarkData> arrayList = this.j;
            this.f12811e = (arrayList == null || arrayList.isEmpty()) ? false : true;
            H0(1);
            refresh();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        d.b.i0.w1.g.a aVar;
        if (this.f18767h == null || (aVar = this.f18766g) == null || !aVar.r()) {
            return;
        }
        this.f18767h.v(this.f18766g.q());
        this.f18766g.w(Boolean.FALSE);
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.f18767h.x();
    }

    public final void refresh() {
        if (this.f18766g.m() == 0) {
            this.f18767h.v(this.f18766g.q());
        }
    }
}
