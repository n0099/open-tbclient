package com.baidu.tieba.post;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.write.write.WriteActivity;
import d.a.c.e.p.j;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.m0.i.b;
import d.a.m0.r.f0.f;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class PersonThreadFragment extends BaseFragment implements PersonPostModel.d, b.a, PersonPostModel.c, BdListView.p, d.a.n0.n2.c {

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.n2.h f20099f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f20100g;

    /* renamed from: h  reason: collision with root package name */
    public View f20101h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.n2.n.a f20102i;
    public PersonPostModel j;
    public boolean k;
    public String l;
    public d.a.m0.r.f0.g m;
    public h n;
    public d.a.n0.n2.d p;
    public d.a.n0.n2.b q;
    public int u;
    public ShareSuccessReplyToServerModel v;

    /* renamed from: e  reason: collision with root package name */
    public String f20098e = "common";
    public boolean o = false;
    public boolean r = true;
    public boolean s = true;
    public boolean t = false;
    public CustomMessageListener w = new a(2016557);
    public CustomMessageListener x = new b(2016558);
    public final CustomMessageListener y = new g(2000994);

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String) || PersonThreadFragment.this.f20102i == null) {
                return;
            }
            PersonThreadFragment.this.f20102i.c((String) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                l.L(PersonThreadFragment.this.getActivity(), R.string.thread_has_hide);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PersonThreadFragment.this.T0();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements AdapterView.OnItemClickListener {
        public d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            CardPersonDynamicThreadData cardPersonDynamicThreadData;
            if (i2 >= 0 && PersonThreadFragment.this.f20102i != null && i2 < ListUtils.getCount(PersonThreadFragment.this.j.threadList) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) PersonThreadFragment.this.f20102i.f61417a.z(i2)) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonThreadFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.f14333f), String.valueOf(cardPersonDynamicThreadData.f14334g), "person_page", 18005).setThreadData(cardPersonDynamicThreadData.r)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements f.g {
        public e() {
        }

        @Override // d.a.m0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            PersonThreadFragment personThreadFragment = PersonThreadFragment.this;
            if (personThreadFragment.j != null) {
                personThreadFragment.r = true;
                if (!j.A()) {
                    if (PersonThreadFragment.this.f20099f != null) {
                        PersonThreadFragment.this.f20099f.i(PersonThreadFragment.this.getString(R.string.neterror), true);
                        return;
                    }
                    return;
                }
                PersonThreadFragment.this.O0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements ShareSuccessReplyToServerModel.b {

        /* loaded from: classes5.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomDialogData f20109e;

            public a(CustomDialogData customDialogData) {
                this.f20109e = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (PersonThreadFragment.this.getPageContext().getPageActivity() != null) {
                    d.a.n0.e2.j.c.a(PersonThreadFragment.this.getPageContext(), this.f20109e).show();
                }
            }
        }

        public f() {
        }

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void a() {
        }

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void b(CustomDialogData customDialogData) {
            d.a.c.e.m.e.a().postDelayed(new a(customDialogData), 1000L);
        }
    }

    /* loaded from: classes5.dex */
    public class g extends CustomMessageListener {
        public g(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (j.z() && PersonThreadFragment.this.t) {
                    PersonThreadFragment.this.P0();
                    PersonThreadFragment.this.n.f();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.c(PersonThreadFragment.this.f20101h, BdListViewHelper.HeadType.DEFAULT, j.z());
                } else {
                    BdListViewHelper.c(PersonThreadFragment.this.f20101h, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class h extends d.a.c.k.e.b {

        /* renamed from: g  reason: collision with root package name */
        public BaseFragmentActivity f20113g;
        public View l;

        /* renamed from: f  reason: collision with root package name */
        public int f20112f = R.color.CAM_X0201;

        /* renamed from: h  reason: collision with root package name */
        public TextView f20114h = null;

        /* renamed from: i  reason: collision with root package name */
        public ProgressBar f20115i = null;
        public View.OnClickListener j = null;
        public View k = null;
        public int m = 3;

        public h(BaseFragmentActivity baseFragmentActivity) {
            this.f20113g = null;
            this.f20113g = baseFragmentActivity;
        }

        @Override // d.a.c.k.e.b
        public View a() {
            View inflate = LayoutInflater.from(this.f20113g.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.k = inflate;
            this.f20114h = (TextView) inflate.findViewById(R.id.pb_more_text);
            this.l = this.k.findViewById(R.id.pb_more_view);
            SkinManager.setBackgroundColor(this.k, this.f20112f);
            SkinManager.setBackgroundColor(this.l, this.f20112f);
            this.l.setVisibility(8);
            this.f20115i = (ProgressBar) this.k.findViewById(R.id.progress);
            h(TbadkCoreApplication.getInst().getSkinType());
            SkinManager.setViewTextColor(this.f20114h, R.color.common_color_10039);
            this.l.setLayoutParams(new LinearLayout.LayoutParams(-1, l.g(this.f20113g.getPageContext().getPageActivity(), R.dimen.ds120)));
            return this.k;
        }

        @Override // d.a.c.k.e.b
        public void c() {
            View.OnClickListener onClickListener = this.j;
            if (onClickListener != null) {
                onClickListener.onClick(this.k);
            }
        }

        public void d() {
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
        }

        @SuppressLint({"ResourceAsColor"})
        public void e(int i2) {
            if (this.m != i2) {
                SkinManager.setViewTextColor(this.f20114h, R.color.common_color_10039);
                SkinManager.setBackgroundColor(this.k, this.f20112f, i2);
                SkinManager.setBackgroundColor(this.l, this.f20112f, i2);
                this.m = i2;
            }
        }

        public void f() {
            this.f20115i.setVisibility(0);
            this.f20114h.setText(this.f20113g.getPageContext().getPageActivity().getText(R.string.loading));
            this.l.setVisibility(0);
        }

        public void g(boolean z) {
            ProgressBar progressBar = this.f20115i;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            if (this.f20114h != null) {
                if (!z) {
                    this.l.setVisibility(0);
                    this.f20114h.setText(this.f20113g.getResources().getString(R.string.list_no_more));
                    return;
                }
                this.l.setVisibility(0);
                this.f20114h.setText(this.f20113g.getResources().getString(R.string.load_more));
            }
        }

        public void h(int i2) {
            this.f20113g.getLayoutMode().j(this.l);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.c
    public void M(PersonPostModel personPostModel, boolean z) {
        PersonPostModel personPostModel2;
        if (personPostModel != null && (personPostModel2 = this.j) != null) {
            if (z) {
                personPostModel2.threadList.clear();
            }
            ArrayList<n> arrayList = personPostModel.threadList;
            if (personPostModel.view_card_num > 0 && this.s) {
                ListUtils.add(arrayList, personPostModel.view_card_num - 1, new d.a.n0.j2.e.j());
                this.s = false;
            }
            if (this.j.threadList.isEmpty()) {
                n nVar = (n) ListUtils.getItem(arrayList, 0);
                if (nVar instanceof CardPersonDynamicThreadData) {
                    ((CardPersonDynamicThreadData) nVar).G = true;
                } else if (nVar instanceof d.a.n0.j2.e.j) {
                    ((d.a.n0.j2.e.j) nVar).f60110e = true;
                }
            }
            this.j.threadList.addAll(arrayList);
            PersonPostModel.mergeDynamicThreadByTime(this.j.threadList);
        }
        d.a.n0.n2.b bVar = this.q;
        if (bVar != null) {
            bVar.showRecycleBinRedTip(personPostModel.isShowRecycleBinRedTip);
        }
        T(personPostModel, z);
        this.f20102i.d(this.j.threadList);
        this.f20102i.b();
    }

    public final void N0(boolean z) {
        d.a.n0.n2.h hVar = this.f20099f;
        hVar.f61395c.removeHeaderView(hVar.f61396d);
        if (z) {
            this.f20099f.f61396d.setVisibility(0);
            d.a.n0.n2.h hVar2 = this.f20099f;
            hVar2.f61395c.addHeaderView(hVar2.f61396d);
            this.n.b().setVisibility(8);
            return;
        }
        this.n.b().setVisibility(0);
        this.n.d();
    }

    public void O0() {
        PersonPostModel personPostModel = this.j;
        if (personPostModel != null) {
            personPostModel.fetchPost(getPageContext(), this, true, this.l, true, this.u, false, true, null);
            this.s = true;
        }
    }

    public void P0() {
        PersonPostModel personPostModel = this.j;
        if (personPostModel != null) {
            personPostModel.fetchPost(getPageContext(), this, false, this.l, true, false, true, null);
        }
    }

    public d.a.n0.n2.h Q0() {
        return this.f20099f;
    }

    public final void R0() {
        d.a.m0.i.a.a(getBaseFragmentActivity()).e(true, true, true, this);
    }

    public void S0() {
        if (this.k) {
            return;
        }
        this.f20099f.f61395c.F();
        this.k = true;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.d
    public void T(PersonPostModel personPostModel, boolean z) {
        this.t = false;
        if (isAdded()) {
            this.f20099f.f61395c.A(0L);
            this.f20099f.f61395c.setEmptyView(null);
            if (personPostModel != null || this.r) {
                if (personPostModel != null && (personPostModel.threadList.size() != 0 || !this.r || !StringUtils.isNull(personPostModel.getErrorString()))) {
                    if (personPostModel.threadList.size() == 0 && this.r) {
                        N0(true);
                    } else {
                        N0(false);
                    }
                    if (personPostModel.getErrorCode() != 0) {
                        l.M(getActivity(), personPostModel.getErrorString());
                    }
                    this.o = !ListUtils.isEmpty(personPostModel.threadList);
                    if (z) {
                        if (personPostModel.threadList.size() < 20) {
                            this.o = false;
                        } else {
                            this.o = true;
                        }
                        this.r = false;
                    }
                    this.n.g(this.o);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016221));
                    return;
                }
                N0(true);
            }
        }
    }

    public final void T0() {
        TiebaStatic.log(TbadkCoreStatisticKey.MYLIVE_TO_BE_ANCHOR);
        R0();
        d.a.m0.i.a.a(getBaseFragmentActivity()).g(1, this);
    }

    public final void U0() {
        R0();
        d.a.m0.i.a.a(getBaseFragmentActivity()).f(this);
    }

    public void V0(d.a.n0.n2.b bVar) {
        this.q = bVar;
    }

    public void W0(d.a.n0.n2.d dVar) {
        this.p = dVar;
    }

    @Override // d.a.n0.n2.c
    public void b0() {
        BdTypeListView bdTypeListView;
        d.a.n0.n2.h hVar = this.f20099f;
        if (hVar == null || (bdTypeListView = hVar.f61395c) == null) {
            return;
        }
        bdTypeListView.F();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.w);
        registerListener(this.x);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        ShareItem shareItem;
        String str;
        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel;
        String stringExtra;
        PersonPostModel personPostModel;
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1) {
            if (i2 == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.f20102i != null && (personPostModel = this.j) != null && ListUtils.getCount(personPostModel.threadList) > 0) {
                int count = ListUtils.getCount(this.j.threadList);
                boolean z = false;
                int i4 = 0;
                while (true) {
                    if (i4 >= count) {
                        break;
                    }
                    n nVar = (n) ListUtils.getItem(this.j.threadList, i4);
                    if ((nVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) nVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.f14333f))) {
                        z = true;
                        break;
                    }
                    i4++;
                }
                if (z && intent.getIntExtra("type", -1) == 0) {
                    ListUtils.remove(this.j.threadList, i4);
                    this.f20102i.b();
                }
            }
            if (i2 == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra != 1 || (shareItem = TbadkCoreApplication.getInst().getShareItem()) == null || (str = shareItem.t) == null || (shareSuccessReplyToServerModel = this.v) == null) {
                    return;
                }
                shareSuccessReplyToServerModel.w(str, intExtra2, new f());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        if (isAdded()) {
            NoDataView noDataView = this.f20099f.f61396d;
            if (noDataView != null) {
                noDataView.d(getPageContext());
            }
            d.a.m0.r.f0.g gVar = this.m;
            if (gVar != null) {
                gVar.I(i2);
            }
            d.a.n0.n2.n.a aVar = this.f20102i;
            if (aVar != null) {
                aVar.b();
            }
            h hVar = this.n;
            if (hVar != null) {
                hVar.e(i2);
            }
            SkinManager.setBackgroundColor(this.f20099f.f61395c, R.color.CAM_X0201);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.y);
        PersonPostModel personPostModel = new PersonPostModel(getPageContext(), getUniqueId(), this, true, PersonPostModel.FROM_PERSON_POST);
        this.j = personPostModel;
        personPostModel.setUniqueId(getUniqueId());
        this.v = new ShareSuccessReplyToServerModel();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.c cVar;
        NoDataViewFactory.d dVar;
        String str;
        String string2;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_thread_fragment, viewGroup, false);
        this.f20100g = (FrameLayout) inflate.findViewById(R.id.root_view);
        d.a.n0.n2.h hVar = new d.a.n0.n2.h(getActivity(), inflate);
        this.f20099f = hVar;
        if (hVar.g() == null) {
            this.f20099f.h(this.p);
        }
        BdTypeListView bdTypeListView = this.f20099f.f61395c;
        if (bdTypeListView != null) {
            SkinManager.setBackgroundColor(bdTypeListView, R.color.CAM_X0201);
        }
        String string3 = getArguments().getString("thread_type_key");
        if (!k.isEmpty(string3)) {
            this.f20098e = string3;
        }
        NoDataViewFactory.b bVar = new NoDataViewFactory.b(getString(R.string.to_be_an_liver), new c());
        int dimension = (int) getResources().getDimension(R.dimen.ds102);
        String str2 = "";
        NoDataViewFactory.d b2 = NoDataViewFactory.d.b(NoDataViewFactory.ImgType.SINGALL, dimension);
        if (this.f20098e.equals(WriteActivity.PHOTO_LIVE_DRAFT_KEY)) {
            int k = d.a.m0.r.d0.b.j().k(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1);
            if (k == 0) {
                string2 = getPageContext().getResources().getString(R.string.to_live_to_god);
                str = getPageContext().getResources().getString(R.string.user_not_liver);
                dVar = NoDataViewFactory.d.c(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_06, dimension, -1, -1);
                cVar = NoDataViewFactory.c.a(bVar);
            } else {
                dVar = b2;
                str = "";
                string2 = getPageContext().getResources().getString(R.string.person_post_lv_empty_host);
                cVar = null;
            }
            if (k < 0) {
                U0();
            }
            String str3 = str;
            b2 = dVar;
            string = string2;
            str2 = str3;
        } else {
            string = getArguments().getString(PersonPostActivity.KEY_EMPTYVIEW_TXT);
            cVar = null;
        }
        this.f20099f.f61396d = NoDataViewFactory.a(getActivity(), null, b2, NoDataViewFactory.e.d(str2, string), cVar);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        PersonPostModel personPostModel = this.j;
        if (personPostModel != null) {
            personPostModel.cancelLoadData();
        }
        try {
            d.a.m0.i.a.h();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        BdAsyncTask.removeAllTask(SetPrivacyModel.UNIQUE_ID_SET_PRIVACY_TASK);
        BdAsyncTask.removeAllTask(ForumManageModel.UNIQUE_ID_DEL_POST_TASK);
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        S0();
        d.a.n0.n2.n.a aVar = this.f20102i;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        if (this.o) {
            P0();
            this.n.f();
            this.t = true;
            return;
        }
        this.n.g(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        NoDataView noDataView = this.f20099f.f61396d;
        if (noDataView != null) {
            noDataView.d(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        NoDataView noDataView = this.f20099f.f61396d;
        if (noDataView != null) {
            noDataView.e();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.l = getArguments().getString("key_uid");
        if (this.f20098e.equals(WriteActivity.PHOTO_LIVE_DRAFT_KEY)) {
            this.u = 33;
        }
        this.f20102i = new d.a.n0.n2.n.a(getPageContext(), this.f20099f.f61395c);
        this.f20099f.f().setOnItemClickListener(new d());
        d.a.m0.r.f0.g gVar = new d.a.m0.r.f0.g(getPageContext());
        this.m = gVar;
        gVar.a(new e());
        this.f20099f.f61395c.setPullRefresh(this.m);
        if (TbadkCoreApplication.isMyLive) {
            View d2 = BdListViewHelper.d(getActivity(), this.f20099f.f61395c, BdListViewHelper.HeadType.DEFAULT);
            this.f20101h = d2;
            BdListViewHelper.c(d2, BdListViewHelper.HeadType.DEFAULT, j.z());
        } else {
            View d3 = BdListViewHelper.d(getActivity(), this.f20099f.f61395c, BdListViewHelper.HeadType.HASTAB);
            this.f20101h = d3;
            BdListViewHelper.c(d3, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.f20099f.f61395c.setOnSrollToBottomListener(this);
        h hVar = new h(getBaseFragmentActivity());
        this.n = hVar;
        this.f20099f.f61395c.setNextPage(hVar);
    }
}
