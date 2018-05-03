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
    private View cUX;
    private ShareSuccessReplyToServerModel dli;
    public PersonPostModel fJr;
    private int fSm;
    private d fSo;
    private h fSr;
    private FrameLayout fSs;
    private com.baidu.tieba.post.a.a fSt;
    private boolean fSu;
    private a fSv;
    private b fSw;
    private int fSy;
    private com.baidu.tbadk.core.view.f mPullView;
    private String mUid;
    private String fSq = PhoneUtils.CPUInfo.FEATURE_COMMON;
    private boolean mHasMore = false;
    private boolean fSn = true;
    private boolean fSx = true;
    private boolean aJl = false;
    private CustomMessageListener fJs = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.post.PersonThreadFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && PersonThreadFragment.this.fSt != null) {
                PersonThreadFragment.this.fSt.rA((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener fJt = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.post.PersonThreadFragment.2
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
                if (com.baidu.adp.lib.util.j.gP() && PersonThreadFragment.this.aJl) {
                    PersonThreadFragment.this.bhz();
                    PersonThreadFragment.this.fSv.amP();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.a(PersonThreadFragment.this.cUX, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.gP());
                } else {
                    BdListViewHelper.a(PersonThreadFragment.this.cUX, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.mNetworkChangedMessageListener);
        this.fJr = new PersonPostModel(getPageContext(), getUniqueId(), this, true, PersonPostModel.FROM_PERSON_POST);
        this.fJr.setUniqueId(getUniqueId());
        this.dli = new ShareSuccessReplyToServerModel();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(d.i.person_thread_fragment, viewGroup, false);
        this.fSs = (FrameLayout) inflate.findViewById(d.g.root_view);
        this.fSr = new h(getActivity(), inflate);
        if (this.fSr.bhC() == null) {
            this.fSr.b(this.fSo);
        }
        if (this.fSr.fSB != null) {
            ak.j(this.fSr.fSB, d.C0126d.cp_bg_line_d);
        }
        String string2 = getArguments().getString("thread_type_key");
        if (!an.isEmpty(string2)) {
            this.fSq = string2;
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
        if (this.fSq.equals("photolive")) {
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
        this.fSr.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.af(string, str), bVar);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.fJs);
        registerListener(this.fJt);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        if (this.fSq.equals("photolive")) {
            this.fSy = 33;
        }
        this.fSt = new com.baidu.tieba.post.a.a(getPageContext(), this.fSr.fSB);
        this.fSr.bhB().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view3, int i, long j) {
                CardPersonDynamicThreadData cardPersonDynamicThreadData;
                if (i >= 0 && PersonThreadFragment.this.fSt != null && i < v.v(PersonThreadFragment.this.fJr.threadList) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) PersonThreadFragment.this.fSt.fIc.getItem(i)) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonThreadFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.threadId), String.valueOf(cardPersonDynamicThreadData.postId), "person_page", 18005)));
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.f(getPageContext());
        this.mPullView.a(new e.b() { // from class: com.baidu.tieba.post.PersonThreadFragment.5
            @Override // com.baidu.tbadk.core.view.e.b
            public void aO(boolean z) {
                if (PersonThreadFragment.this.fJr != null) {
                    PersonThreadFragment.this.fSn = true;
                    if (!com.baidu.adp.lib.util.j.gD()) {
                        if (PersonThreadFragment.this.fSr != null) {
                            PersonThreadFragment.this.fSr.E(PersonThreadFragment.this.getString(d.k.neterror), true);
                            return;
                        }
                        return;
                    }
                    PersonThreadFragment.this.bhy();
                }
            }
        });
        this.fSr.fSB.setPullRefresh(this.mPullView);
        if (TbadkCoreApplication.isMyLive) {
            this.cUX = BdListViewHelper.a(getActivity(), this.fSr.fSB, BdListViewHelper.HeadType.DEFAULT);
            BdListViewHelper.a(this.cUX, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.gP());
        } else {
            this.cUX = BdListViewHelper.a(getActivity(), this.fSr.fSB, BdListViewHelper.HeadType.HASTAB);
            BdListViewHelper.a(this.cUX, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.fSr.fSB.setOnSrollToBottomListener(this);
        this.fSv = new a(getBaseFragmentActivity());
        this.fSr.fSB.setNextPage(this.fSv);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            bhz();
            this.fSv.amP();
            this.aJl = true;
            return;
        }
        this.fSv.lz(false);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
    public void b(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null && this.fJr != null) {
            if (z) {
                this.fJr.threadList.clear();
            }
            ArrayList<com.baidu.adp.widget.ListView.h> arrayList = personPostModel.threadList;
            if (personPostModel.view_card_num > 0 && this.fSx) {
                v.a(arrayList, personPostModel.view_card_num - 1, new com.baidu.tieba.personPolymeric.c.j());
                this.fSx = false;
            }
            if (this.fJr.threadList.isEmpty()) {
                com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) v.c(arrayList, 0);
                if (hVar instanceof CardPersonDynamicThreadData) {
                    ((CardPersonDynamicThreadData) hVar).csE = true;
                } else if (hVar instanceof com.baidu.tieba.personPolymeric.c.j) {
                    ((com.baidu.tieba.personPolymeric.c.j) hVar).csE = true;
                }
            }
            this.fJr.threadList.addAll(arrayList);
            PersonPostModel.mergeDynamicThreadByTime(this.fJr.threadList);
        }
        if (this.fSw != null) {
            this.fSw.lw(personPostModel.isShowRecycleBinRedTip);
        }
        a(personPostModel, z);
        this.fSt.z(this.fJr.threadList);
        this.fSt.notifyDataSetChanged();
    }

    /* loaded from: classes3.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private View aJH;
        private BaseFragmentActivity bea;
        private int bgColor = d.C0126d.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View Tl = null;
        private int mSkinType = 3;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.bea = null;
            this.bea = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View kA() {
            this.Tl = LayoutInflater.from(this.bea.getPageContext().getContext()).inflate(d.i.new_pb_list_more, (ViewGroup) null);
            this.mTextView = (TextView) this.Tl.findViewById(d.g.pb_more_text);
            this.aJH = this.Tl.findViewById(d.g.pb_more_view);
            ak.j(this.Tl, this.bgColor);
            ak.j(this.aJH, this.bgColor);
            this.aJH.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.Tl.findViewById(d.g.progress);
            ep(TbadkCoreApplication.getInst().getSkinType());
            ak.h(this.mTextView, d.C0126d.common_color_10039);
            this.aJH.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.e(this.bea.getPageContext().getPageActivity(), d.e.ds120)));
            return this.Tl;
        }

        public void ep(int i) {
            this.bea.getLayoutMode().u(this.aJH);
        }

        @SuppressLint({"ResourceAsColor"})
        public void dv(int i) {
            if (this.mSkinType != i) {
                ak.h(this.mTextView, d.C0126d.common_color_10039);
                ak.e(this.Tl, this.bgColor, i);
                ak.e(this.aJH, this.bgColor, i);
                this.mSkinType = i;
            }
        }

        public void amP() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.bea.getPageContext().getPageActivity().getText(d.k.loading));
            this.aJH.setVisibility(0);
        }

        public void bhA() {
            ak.j(this.Tl, d.C0126d.cp_bg_line_c);
        }

        public void lz(boolean z) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.aJH.setVisibility(0);
                    this.mTextView.setText(this.bea.getResources().getString(d.k.list_no_more));
                    return;
                }
                this.aJH.setVisibility(0);
                this.mTextView.setText(this.bea.getResources().getString(d.k.load_more));
            }
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.Tl);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.fSr.mNoDataView != null) {
                this.fSr.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.dv(i);
            }
            if (this.fSt != null) {
                this.fSt.notifyDataSetChanged();
            }
            if (this.fSv != null) {
                this.fSv.dv(i);
            }
            ak.j(this.fSr.fSB, d.C0126d.cp_bg_line_d);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.fSr.mNoDataView != null) {
            this.fSr.mNoDataView.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.fSr.mNoDataView != null) {
            this.fSr.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.fSt != null) {
            this.fSt.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.fJr != null) {
            this.fJr.cancelLoadData();
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
            if (i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.fSt != null && this.fJr != null && v.v(this.fJr.threadList) > 0) {
                int v = v.v(this.fJr.threadList);
                int i3 = 0;
                while (true) {
                    if (i3 >= v) {
                        z = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) v.c(this.fJr.threadList, i3);
                    if ((hVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) hVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.threadId))) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (z && intent.getIntExtra("type", -1) == 0) {
                    v.d(this.fJr.threadList, i3);
                    this.fSt.notifyDataSetChanged();
                }
            }
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.dli != null) {
                    this.dli.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.post.PersonThreadFragment.6
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void AF() {
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
        if (!this.fSu) {
            this.fSr.fSB.startPullRefresh();
            this.fSu = true;
        }
    }

    public h bhu() {
        return this.fSr;
    }

    @Override // com.baidu.tieba.post.c
    public void bho() {
        if (this.fSr != null && this.fSr.fSB != null) {
            this.fSr.fSB.startPullRefresh();
        }
    }

    public void a(d dVar) {
        this.fSo = dVar;
    }

    public void a(b bVar) {
        this.fSw = bVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
    public void a(PersonPostModel personPostModel, boolean z) {
        this.aJl = false;
        if (isAdded()) {
            this.fSr.fSB.completePullRefreshPostDelayed(2000L);
            this.fSr.fSB.setEmptyView(null);
            if (personPostModel != null || this.fSn) {
                if (personPostModel == null || (personPostModel.threadList.size() == 0 && this.fSn && StringUtils.isNull(personPostModel.getErrorString()))) {
                    ly(true);
                    return;
                }
                if (personPostModel.threadList.size() == 0 && this.fSn) {
                    ly(true);
                } else {
                    ly(false);
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
                    this.fSm = 0;
                    this.fSn = false;
                }
                this.fSv.lz(this.mHasMore);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016221));
            }
        }
    }

    private void ly(boolean z) {
        this.fSr.fSB.removeHeaderView(this.fSr.mNoDataView);
        if (z) {
            this.fSr.mNoDataView.setVisibility(0);
            this.fSr.fSB.addHeaderView(this.fSr.mNoDataView);
            this.fSv.getView().setVisibility(8);
            return;
        }
        this.fSv.getView().setVisibility(0);
        this.fSv.bhA();
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
        if (this.fJr != null) {
            this.fJr.fetchPost(getPageContext(), this, true, this.mUid, true, this.fSy, false, true);
            this.fSx = true;
        }
    }

    public void bhz() {
        if (this.fJr != null) {
            this.fJr.fetchPost(getPageContext(), this, false, this.mUid, true, false, true);
        }
    }
}
