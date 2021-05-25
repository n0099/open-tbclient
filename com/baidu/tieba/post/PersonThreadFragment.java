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
import d.a.c.j.e.n;
import d.a.m0.i.b;
import d.a.m0.r.f0.f;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class PersonThreadFragment extends BaseFragment implements PersonPostModel.d, b.a, PersonPostModel.c, BdListView.p, d.a.n0.n2.c {

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.n2.h f20022f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f20023g;

    /* renamed from: h  reason: collision with root package name */
    public View f20024h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.n2.n.a f20025i;
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
    public String f20021e = "common";
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
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String) || PersonThreadFragment.this.f20025i == null) {
                return;
            }
            PersonThreadFragment.this.f20025i.c((String) customResponsedMessage.getData());
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
            PersonThreadFragment.this.Q0();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements AdapterView.OnItemClickListener {
        public d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            CardPersonDynamicThreadData cardPersonDynamicThreadData;
            if (i2 >= 0 && PersonThreadFragment.this.f20025i != null && i2 < ListUtils.getCount(PersonThreadFragment.this.j.threadList) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) PersonThreadFragment.this.f20025i.f57728a.y(i2)) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonThreadFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.f14276f), String.valueOf(cardPersonDynamicThreadData.f14277g), "person_page", 18005).setThreadData(cardPersonDynamicThreadData.r)));
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
                    if (PersonThreadFragment.this.f20022f != null) {
                        PersonThreadFragment.this.f20022f.i(PersonThreadFragment.this.getString(R.string.neterror), true);
                        return;
                    }
                    return;
                }
                PersonThreadFragment.this.L0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements ShareSuccessReplyToServerModel.b {

        /* loaded from: classes5.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomDialogData f20032e;

            public a(CustomDialogData customDialogData) {
                this.f20032e = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (PersonThreadFragment.this.getPageContext().getPageActivity() != null) {
                    d.a.n0.e2.j.c.a(PersonThreadFragment.this.getPageContext(), this.f20032e).show();
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
                    PersonThreadFragment.this.M0();
                    PersonThreadFragment.this.n.f();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.c(PersonThreadFragment.this.f20024h, BdListViewHelper.HeadType.DEFAULT, j.z());
                } else {
                    BdListViewHelper.c(PersonThreadFragment.this.f20024h, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class h extends d.a.c.j.e.b {

        /* renamed from: g  reason: collision with root package name */
        public BaseFragmentActivity f20036g;
        public View l;

        /* renamed from: f  reason: collision with root package name */
        public int f20035f = R.color.CAM_X0201;

        /* renamed from: h  reason: collision with root package name */
        public TextView f20037h = null;

        /* renamed from: i  reason: collision with root package name */
        public ProgressBar f20038i = null;
        public View.OnClickListener j = null;
        public View k = null;
        public int m = 3;

        public h(BaseFragmentActivity baseFragmentActivity) {
            this.f20036g = null;
            this.f20036g = baseFragmentActivity;
        }

        @Override // d.a.c.j.e.b
        public View a() {
            View inflate = LayoutInflater.from(this.f20036g.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.k = inflate;
            this.f20037h = (TextView) inflate.findViewById(R.id.pb_more_text);
            this.l = this.k.findViewById(R.id.pb_more_view);
            SkinManager.setBackgroundColor(this.k, this.f20035f);
            SkinManager.setBackgroundColor(this.l, this.f20035f);
            this.l.setVisibility(8);
            this.f20038i = (ProgressBar) this.k.findViewById(R.id.progress);
            h(TbadkCoreApplication.getInst().getSkinType());
            SkinManager.setViewTextColor(this.f20037h, R.color.common_color_10039);
            this.l.setLayoutParams(new LinearLayout.LayoutParams(-1, l.g(this.f20036g.getPageContext().getPageActivity(), R.dimen.ds120)));
            return this.k;
        }

        @Override // d.a.c.j.e.b
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
                SkinManager.setViewTextColor(this.f20037h, R.color.common_color_10039);
                SkinManager.setBackgroundColor(this.k, this.f20035f, i2);
                SkinManager.setBackgroundColor(this.l, this.f20035f, i2);
                this.m = i2;
            }
        }

        public void f() {
            this.f20038i.setVisibility(0);
            this.f20037h.setText(this.f20036g.getPageContext().getPageActivity().getText(R.string.loading));
            this.l.setVisibility(0);
        }

        public void g(boolean z) {
            ProgressBar progressBar = this.f20038i;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            if (this.f20037h != null) {
                if (!z) {
                    this.l.setVisibility(0);
                    this.f20037h.setText(this.f20036g.getResources().getString(R.string.list_no_more));
                    return;
                }
                this.l.setVisibility(0);
                this.f20037h.setText(this.f20036g.getResources().getString(R.string.load_more));
            }
        }

        public void h(int i2) {
            this.f20036g.getLayoutMode().j(this.l);
        }
    }

    public final void K0(boolean z) {
        d.a.n0.n2.h hVar = this.f20022f;
        hVar.f57706c.removeHeaderView(hVar.f57707d);
        if (z) {
            this.f20022f.f57707d.setVisibility(0);
            d.a.n0.n2.h hVar2 = this.f20022f;
            hVar2.f57706c.addHeaderView(hVar2.f57707d);
            this.n.b().setVisibility(8);
            return;
        }
        this.n.b().setVisibility(0);
        this.n.d();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.c
    public void L(PersonPostModel personPostModel, boolean z) {
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
                    ((d.a.n0.j2.e.j) nVar).f56421e = true;
                }
            }
            this.j.threadList.addAll(arrayList);
            PersonPostModel.mergeDynamicThreadByTime(this.j.threadList);
        }
        d.a.n0.n2.b bVar = this.q;
        if (bVar != null) {
            bVar.showRecycleBinRedTip(personPostModel.isShowRecycleBinRedTip);
        }
        R(personPostModel, z);
        this.f20025i.d(this.j.threadList);
        this.f20025i.b();
    }

    public void L0() {
        PersonPostModel personPostModel = this.j;
        if (personPostModel != null) {
            personPostModel.fetchPost(getPageContext(), this, true, this.l, true, this.u, false, true, null);
            this.s = true;
        }
    }

    public void M0() {
        PersonPostModel personPostModel = this.j;
        if (personPostModel != null) {
            personPostModel.fetchPost(getPageContext(), this, false, this.l, true, false, true, null);
        }
    }

    public d.a.n0.n2.h N0() {
        return this.f20022f;
    }

    public final void O0() {
        d.a.m0.i.a.a(getBaseFragmentActivity()).e(true, true, true, this);
    }

    public void P0() {
        if (this.k) {
            return;
        }
        this.f20022f.f57706c.F();
        this.k = true;
    }

    public final void Q0() {
        TiebaStatic.log(TbadkCoreStatisticKey.MYLIVE_TO_BE_ANCHOR);
        O0();
        d.a.m0.i.a.a(getBaseFragmentActivity()).g(1, this);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.d
    public void R(PersonPostModel personPostModel, boolean z) {
        this.t = false;
        if (isAdded()) {
            this.f20022f.f57706c.A(0L);
            this.f20022f.f57706c.setEmptyView(null);
            if (personPostModel != null || this.r) {
                if (personPostModel != null && (personPostModel.threadList.size() != 0 || !this.r || !StringUtils.isNull(personPostModel.getErrorString()))) {
                    if (personPostModel.threadList.size() == 0 && this.r) {
                        K0(true);
                    } else {
                        K0(false);
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
                K0(true);
            }
        }
    }

    public final void R0() {
        O0();
        d.a.m0.i.a.a(getBaseFragmentActivity()).f(this);
    }

    public void S0(d.a.n0.n2.b bVar) {
        this.q = bVar;
    }

    public void T0(d.a.n0.n2.d dVar) {
        this.p = dVar;
    }

    @Override // d.a.n0.n2.c
    public void Y() {
        BdTypeListView bdTypeListView;
        d.a.n0.n2.h hVar = this.f20022f;
        if (hVar == null || (bdTypeListView = hVar.f57706c) == null) {
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
            if (i2 == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.f20025i != null && (personPostModel = this.j) != null && ListUtils.getCount(personPostModel.threadList) > 0) {
                int count = ListUtils.getCount(this.j.threadList);
                boolean z = false;
                int i4 = 0;
                while (true) {
                    if (i4 >= count) {
                        break;
                    }
                    n nVar = (n) ListUtils.getItem(this.j.threadList, i4);
                    if ((nVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) nVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.f14276f))) {
                        z = true;
                        break;
                    }
                    i4++;
                }
                if (z && intent.getIntExtra("type", -1) == 0) {
                    ListUtils.remove(this.j.threadList, i4);
                    this.f20025i.b();
                }
            }
            if (i2 == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra != 1 || (shareItem = TbadkCoreApplication.getInst().getShareItem()) == null || (str = shareItem.t) == null || (shareSuccessReplyToServerModel = this.v) == null) {
                    return;
                }
                shareSuccessReplyToServerModel.s(str, intExtra2, new f());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        if (isAdded()) {
            NoDataView noDataView = this.f20022f.f57707d;
            if (noDataView != null) {
                noDataView.d(getPageContext());
            }
            d.a.m0.r.f0.g gVar = this.m;
            if (gVar != null) {
                gVar.I(i2);
            }
            d.a.n0.n2.n.a aVar = this.f20025i;
            if (aVar != null) {
                aVar.b();
            }
            h hVar = this.n;
            if (hVar != null) {
                hVar.e(i2);
            }
            SkinManager.setBackgroundColor(this.f20022f.f57706c, R.color.CAM_X0201);
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
        this.f20023g = (FrameLayout) inflate.findViewById(R.id.root_view);
        d.a.n0.n2.h hVar = new d.a.n0.n2.h(getActivity(), inflate);
        this.f20022f = hVar;
        if (hVar.g() == null) {
            this.f20022f.h(this.p);
        }
        BdTypeListView bdTypeListView = this.f20022f.f57706c;
        if (bdTypeListView != null) {
            SkinManager.setBackgroundColor(bdTypeListView, R.color.CAM_X0201);
        }
        String string3 = getArguments().getString("thread_type_key");
        if (!k.isEmpty(string3)) {
            this.f20021e = string3;
        }
        NoDataViewFactory.b bVar = new NoDataViewFactory.b(getString(R.string.to_be_an_liver), new c());
        int dimension = (int) getResources().getDimension(R.dimen.ds102);
        String str2 = "";
        NoDataViewFactory.d b2 = NoDataViewFactory.d.b(NoDataViewFactory.ImgType.SINGALL, dimension);
        if (this.f20021e.equals(WriteActivity.PHOTO_LIVE_DRAFT_KEY)) {
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
                R0();
            }
            String str3 = str;
            b2 = dVar;
            string = string2;
            str2 = str3;
        } else {
            string = getArguments().getString(PersonPostActivity.KEY_EMPTYVIEW_TXT);
            cVar = null;
        }
        this.f20022f.f57707d = NoDataViewFactory.a(getActivity(), null, b2, NoDataViewFactory.e.d(str2, string), cVar);
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
        P0();
        d.a.n0.n2.n.a aVar = this.f20025i;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        if (this.o) {
            M0();
            this.n.f();
            this.t = true;
            return;
        }
        this.n.g(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        NoDataView noDataView = this.f20022f.f57707d;
        if (noDataView != null) {
            noDataView.d(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        NoDataView noDataView = this.f20022f.f57707d;
        if (noDataView != null) {
            noDataView.e();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.l = getArguments().getString("key_uid");
        if (this.f20021e.equals(WriteActivity.PHOTO_LIVE_DRAFT_KEY)) {
            this.u = 33;
        }
        this.f20025i = new d.a.n0.n2.n.a(getPageContext(), this.f20022f.f57706c);
        this.f20022f.f().setOnItemClickListener(new d());
        d.a.m0.r.f0.g gVar = new d.a.m0.r.f0.g(getPageContext());
        this.m = gVar;
        gVar.a(new e());
        this.f20022f.f57706c.setPullRefresh(this.m);
        if (TbadkCoreApplication.isMyLive) {
            View d2 = BdListViewHelper.d(getActivity(), this.f20022f.f57706c, BdListViewHelper.HeadType.DEFAULT);
            this.f20024h = d2;
            BdListViewHelper.c(d2, BdListViewHelper.HeadType.DEFAULT, j.z());
        } else {
            View d3 = BdListViewHelper.d(getActivity(), this.f20022f.f57706c, BdListViewHelper.HeadType.HASTAB);
            this.f20024h = d3;
            BdListViewHelper.c(d3, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.f20022f.f57706c.setOnSrollToBottomListener(this);
        h hVar = new h(getBaseFragmentActivity());
        this.n = hVar;
        this.f20022f.f57706c.setNextPage(hVar);
    }
}
