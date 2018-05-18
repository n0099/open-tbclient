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
import com.baidu.fsg.base.utils.PhoneUtils;
import com.baidu.tbadk.c.b;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.e;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.d;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class PersonThreadFragment extends BaseFragment implements BdListView.e, b.a, PersonPostModel.a, PersonPostModel.b, c {
    private View cWe;
    private ShareSuccessReplyToServerModel dmp;
    public PersonPostModel fKx;
    private boolean fTA;
    private a fTB;
    private b fTC;
    private int fTE;
    private int fTs;
    private d fTu;
    private h fTx;
    private FrameLayout fTy;
    private com.baidu.tieba.post.a.a fTz;
    private com.baidu.tbadk.core.view.f mPullView;
    private String mUid;
    private String fTw = PhoneUtils.CPUInfo.FEATURE_COMMON;
    private boolean mHasMore = false;
    private boolean fTt = true;
    private boolean fTD = true;
    private boolean aJm = false;
    private CustomMessageListener fKy = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.post.PersonThreadFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && PersonThreadFragment.this.fTz != null) {
                PersonThreadFragment.this.fTz.rD((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener fKz = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.post.PersonThreadFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.adp.lib.util.l.showToast(PersonThreadFragment.this.getActivity(), d.k.thread_has_hide);
            }
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.post.PersonThreadFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (com.baidu.adp.lib.util.j.gP() && PersonThreadFragment.this.aJm) {
                    PersonThreadFragment.this.bhz();
                    PersonThreadFragment.this.fTB.amO();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.a(PersonThreadFragment.this.cWe, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.gP());
                } else {
                    BdListViewHelper.a(PersonThreadFragment.this.cWe, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.mNetworkChangedMessageListener);
        this.fKx = new PersonPostModel(getPageContext(), getUniqueId(), this, true, PersonPostModel.FROM_PERSON_POST);
        this.fKx.setUniqueId(getUniqueId());
        this.dmp = new ShareSuccessReplyToServerModel();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(d.i.person_thread_fragment, viewGroup, false);
        this.fTy = (FrameLayout) inflate.findViewById(d.g.root_view);
        this.fTx = new h(getActivity(), inflate);
        if (this.fTx.bhC() == null) {
            this.fTx.b(this.fTu);
        }
        if (this.fTx.fTH != null) {
            ak.j(this.fTx.fTH, d.C0126d.cp_bg_line_d);
        }
        String string2 = getArguments().getString("thread_type_key");
        if (!an.isEmpty(string2)) {
            this.fTw = string2;
        }
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(d.k.to_be_an_liver), new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PersonThreadFragment.this.bhv();
            }
        });
        int dimension = (int) getResources().getDimension(d.e.ds102);
        String str = "";
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension);
        if (this.fTw.equals("photolive")) {
            int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1);
            if (i == 0) {
                str = getPageContext().getResources().getString(d.k.to_live_to_god);
                string = getPageContext().getResources().getString(d.k.user_not_liver);
                a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.go_to_live_pic, dimension, -1, -1);
                bVar = NoDataViewFactory.b.a(aVar);
            } else {
                string = getPageContext().getResources().getString(d.k.person_post_lv_empty_host);
                bVar = null;
            }
            if (i < 0) {
                bhw();
            }
        } else {
            string = getArguments().getString("key_empty_view_text");
            bVar = null;
        }
        this.fTx.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.af(string, str), bVar);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.fKy);
        registerListener(this.fKz);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        if (this.fTw.equals("photolive")) {
            this.fTE = 33;
        }
        this.fTz = new com.baidu.tieba.post.a.a(getPageContext(), this.fTx.fTH);
        this.fTx.bhB().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view3, int i, long j) {
                CardPersonDynamicThreadData cardPersonDynamicThreadData;
                if (i >= 0 && PersonThreadFragment.this.fTz != null && i < v.v(PersonThreadFragment.this.fKx.threadList) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) PersonThreadFragment.this.fTz.fJi.getItem(i)) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonThreadFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.threadId), String.valueOf(cardPersonDynamicThreadData.postId), "person_page", 18005)));
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.f(getPageContext());
        this.mPullView.a(new e.b() { // from class: com.baidu.tieba.post.PersonThreadFragment.5
            @Override // com.baidu.tbadk.core.view.e.b
            public void aO(boolean z) {
                if (PersonThreadFragment.this.fKx != null) {
                    PersonThreadFragment.this.fTt = true;
                    if (!com.baidu.adp.lib.util.j.gD()) {
                        if (PersonThreadFragment.this.fTx != null) {
                            PersonThreadFragment.this.fTx.E(PersonThreadFragment.this.getString(d.k.neterror), true);
                            return;
                        }
                        return;
                    }
                    PersonThreadFragment.this.bhy();
                }
            }
        });
        this.fTx.fTH.setPullRefresh(this.mPullView);
        if (TbadkCoreApplication.isMyLive) {
            this.cWe = BdListViewHelper.a(getActivity(), this.fTx.fTH, BdListViewHelper.HeadType.DEFAULT);
            BdListViewHelper.a(this.cWe, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.gP());
        } else {
            this.cWe = BdListViewHelper.a(getActivity(), this.fTx.fTH, BdListViewHelper.HeadType.HASTAB);
            BdListViewHelper.a(this.cWe, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.fTx.fTH.setOnSrollToBottomListener(this);
        this.fTB = new a(getBaseFragmentActivity());
        this.fTx.fTH.setNextPage(this.fTB);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            bhz();
            this.fTB.amO();
            this.aJm = true;
            return;
        }
        this.fTB.lA(false);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
    public void b(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null && this.fKx != null) {
            if (z) {
                this.fKx.threadList.clear();
            }
            ArrayList<com.baidu.adp.widget.ListView.h> arrayList = personPostModel.threadList;
            if (personPostModel.view_card_num > 0 && this.fTD) {
                v.a(arrayList, personPostModel.view_card_num - 1, new com.baidu.tieba.personPolymeric.c.j());
                this.fTD = false;
            }
            if (this.fKx.threadList.isEmpty()) {
                com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) v.c(arrayList, 0);
                if (hVar instanceof CardPersonDynamicThreadData) {
                    ((CardPersonDynamicThreadData) hVar).ctO = true;
                } else if (hVar instanceof com.baidu.tieba.personPolymeric.c.j) {
                    ((com.baidu.tieba.personPolymeric.c.j) hVar).ctO = true;
                }
            }
            this.fKx.threadList.addAll(arrayList);
            PersonPostModel.mergeDynamicThreadByTime(this.fKx.threadList);
        }
        if (this.fTC != null) {
            this.fTC.lx(personPostModel.isShowRecycleBinRedTip);
        }
        a(personPostModel, z);
        this.fTz.z(this.fKx.threadList);
        this.fTz.notifyDataSetChanged();
    }

    /* loaded from: classes3.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private View aJI;
        private BaseFragmentActivity beb;
        private int bgColor = d.C0126d.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View Th = null;
        private int mSkinType = 3;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.beb = null;
            this.beb = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View kz() {
            this.Th = LayoutInflater.from(this.beb.getPageContext().getContext()).inflate(d.i.new_pb_list_more, (ViewGroup) null);
            this.mTextView = (TextView) this.Th.findViewById(d.g.pb_more_text);
            this.aJI = this.Th.findViewById(d.g.pb_more_view);
            ak.j(this.Th, this.bgColor);
            ak.j(this.aJI, this.bgColor);
            this.aJI.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.Th.findViewById(d.g.progress);
            eq(TbadkCoreApplication.getInst().getSkinType());
            ak.h(this.mTextView, d.C0126d.common_color_10039);
            this.aJI.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.e(this.beb.getPageContext().getPageActivity(), d.e.ds120)));
            return this.Th;
        }

        public void eq(int i) {
            this.beb.getLayoutMode().u(this.aJI);
        }

        @SuppressLint({"ResourceAsColor"})
        public void dw(int i) {
            if (this.mSkinType != i) {
                ak.h(this.mTextView, d.C0126d.common_color_10039);
                ak.e(this.Th, this.bgColor, i);
                ak.e(this.aJI, this.bgColor, i);
                this.mSkinType = i;
            }
        }

        public void amO() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.beb.getPageContext().getPageActivity().getText(d.k.loading));
            this.aJI.setVisibility(0);
        }

        public void bhA() {
            ak.j(this.Th, d.C0126d.cp_bg_line_c);
        }

        public void lA(boolean z) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.aJI.setVisibility(0);
                    this.mTextView.setText(this.beb.getResources().getString(d.k.list_no_more));
                    return;
                }
                this.aJI.setVisibility(0);
                this.mTextView.setText(this.beb.getResources().getString(d.k.load_more));
            }
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.Th);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.fTx.mNoDataView != null) {
                this.fTx.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.dw(i);
            }
            if (this.fTz != null) {
                this.fTz.notifyDataSetChanged();
            }
            if (this.fTB != null) {
                this.fTB.dw(i);
            }
            ak.j(this.fTx.fTH, d.C0126d.cp_bg_line_d);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.fTx.mNoDataView != null) {
            this.fTx.mNoDataView.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.fTx.mNoDataView != null) {
            this.fTx.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.fTz != null) {
            this.fTz.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.fKx != null) {
            this.fKx.cancelLoadData();
        }
        try {
            com.baidu.tbadk.c.a.resetAll();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        BdAsyncTask.removeAllTask(SetPrivacyModel.UNIQUE_ID_SET_PRIVACY_TASK);
        BdAsyncTask.removeAllTask(ForumManageModel.UNIQUE_ID_DEL_POST_TASK);
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.coreExtra.c.d shareItem;
        String stringExtra;
        boolean z;
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.fTz != null && this.fKx != null && v.v(this.fKx.threadList) > 0) {
                int v = v.v(this.fKx.threadList);
                int i3 = 0;
                while (true) {
                    if (i3 >= v) {
                        z = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) v.c(this.fKx.threadList, i3);
                    if ((hVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) hVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.threadId))) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (z && intent.getIntExtra("type", -1) == 0) {
                    v.d(this.fKx.threadList, i3);
                    this.fTz.notifyDataSetChanged();
                }
            }
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.dmp != null) {
                    this.dmp.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.post.PersonThreadFragment.6
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void AD() {
                        }

                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void a(final CustomDialogData customDialogData) {
                            com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.post.PersonThreadFragment.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PersonThreadFragment.this.getPageContext().getPageActivity() != null) {
                                        com.baidu.tieba.pb.interactionpopupwindow.c.a(PersonThreadFragment.this.getPageContext(), customDialogData).show();
                                    }
                                }
                            }, 1000L);
                        }
                    });
                }
            }
        }
    }

    public void onActive() {
        if (!this.fTA) {
            this.fTx.fTH.startPullRefresh();
            this.fTA = true;
        }
    }

    public h bhu() {
        return this.fTx;
    }

    @Override // com.baidu.tieba.post.c
    public void bho() {
        if (this.fTx != null && this.fTx.fTH != null) {
            this.fTx.fTH.startPullRefresh();
        }
    }

    public void a(d dVar) {
        this.fTu = dVar;
    }

    public void a(b bVar) {
        this.fTC = bVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
    public void a(PersonPostModel personPostModel, boolean z) {
        this.aJm = false;
        if (isAdded()) {
            this.fTx.fTH.completePullRefreshPostDelayed(2000L);
            this.fTx.fTH.setEmptyView(null);
            if (personPostModel != null || this.fTt) {
                if (personPostModel == null || (personPostModel.threadList.size() == 0 && this.fTt && StringUtils.isNull(personPostModel.getErrorString()))) {
                    lz(true);
                    return;
                }
                if (personPostModel.threadList.size() == 0 && this.fTt) {
                    lz(true);
                } else {
                    lz(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(getActivity(), personPostModel.getErrorString());
                }
                this.mHasMore = !v.w(personPostModel.threadList);
                if (z) {
                    if (personPostModel.threadList.size() < 20) {
                        this.mHasMore = false;
                    } else {
                        this.mHasMore = true;
                    }
                    this.fTs = 0;
                    this.fTt = false;
                }
                this.fTB.lA(this.mHasMore);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016221));
            }
        }
    }

    private void lz(boolean z) {
        this.fTx.fTH.removeHeaderView(this.fTx.mNoDataView);
        if (z) {
            this.fTx.mNoDataView.setVisibility(0);
            this.fTx.fTH.addHeaderView(this.fTx.mNoDataView);
            this.fTB.getView().setVisibility(8);
            return;
        }
        this.fTB.getView().setVisibility(0);
        this.fTB.bhA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhv() {
        TiebaStatic.log("c10491");
        bhx();
        com.baidu.tbadk.c.a.b(getBaseFragmentActivity()).a(1, this);
    }

    private void bhw() {
        bhx();
        com.baidu.tbadk.c.a.b(getBaseFragmentActivity()).b(this);
    }

    private void bhx() {
        com.baidu.tbadk.c.a.b(getBaseFragmentActivity()).a(true, true, true, this);
    }

    public void bhy() {
        if (this.fKx != null) {
            this.fKx.fetchPost(getPageContext(), this, true, this.mUid, true, this.fTE, false, true);
            this.fTD = true;
        }
    }

    public void bhz() {
        if (this.fKx != null) {
            this.fKx.fetchPost(getPageContext(), this, false, this.mUid, true, false, true);
        }
    }
}
