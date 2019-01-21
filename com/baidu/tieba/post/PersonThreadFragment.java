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
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.d.b;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.e;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class PersonThreadFragment extends BaseFragment implements BdListView.e, b.a, PersonPostModel.a, PersonPostModel.b, c {
    private View dJg;
    private ShareSuccessReplyToServerModel ebe;
    public PersonPostModel gBp;
    private int gKB;
    private int gKp;
    private d gKr;
    private h gKu;
    private FrameLayout gKv;
    private com.baidu.tieba.post.a.a gKw;
    private boolean gKx;
    private a gKy;
    private b gKz;
    private com.baidu.tbadk.core.view.k mPullView;
    private String mUid;
    private String gKt = PhoneUtils.CPUInfo.FEATURE_COMMON;
    private boolean mHasMore = false;
    private boolean gKq = true;
    private boolean gKA = true;
    private boolean bfz = false;
    private CustomMessageListener gBq = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.post.PersonThreadFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && PersonThreadFragment.this.gKw != null) {
                PersonThreadFragment.this.gKw.uy((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gBr = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.post.PersonThreadFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.adp.lib.util.l.showToast(PersonThreadFragment.this.getActivity(), e.j.thread_has_hide);
            }
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.post.PersonThreadFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (com.baidu.adp.lib.util.j.kV() && PersonThreadFragment.this.bfz) {
                    PersonThreadFragment.this.btV();
                    PersonThreadFragment.this.gKy.ayv();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.a(PersonThreadFragment.this.dJg, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kV());
                } else {
                    BdListViewHelper.a(PersonThreadFragment.this.dJg, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.mNetworkChangedMessageListener);
        this.gBp = new PersonPostModel(getPageContext(), getUniqueId(), this, true, PersonPostModel.FROM_PERSON_POST);
        this.gBp.setUniqueId(getUniqueId());
        this.ebe = new ShareSuccessReplyToServerModel();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(e.h.person_thread_fragment, viewGroup, false);
        this.gKv = (FrameLayout) inflate.findViewById(e.g.root_view);
        this.gKu = new h(getActivity(), inflate);
        if (this.gKu.btY() == null) {
            this.gKu.b(this.gKr);
        }
        if (this.gKu.gKE != null) {
            al.j(this.gKu.gKE, e.d.cp_bg_line_d);
        }
        String string2 = getArguments().getString("thread_type_key");
        if (!ao.isEmpty(string2)) {
            this.gKt = string2;
        }
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(e.j.to_be_an_liver), new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonThreadFragment.this.btR();
            }
        });
        int dimension = (int) getResources().getDimension(e.C0210e.ds102);
        String str = "";
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension);
        if (this.gKt.equals("photolive")) {
            int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1);
            if (i == 0) {
                str = getPageContext().getResources().getString(e.j.to_live_to_god);
                string = getPageContext().getResources().getString(e.j.user_not_liver);
                a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, e.f.go_to_live_pic, dimension, -1, -1);
                bVar = NoDataViewFactory.b.a(aVar);
            } else {
                string = getPageContext().getResources().getString(e.j.person_post_lv_empty_host);
                bVar = null;
            }
            if (i < 0) {
                btS();
            }
        } else {
            string = getArguments().getString("key_empty_view_text");
            bVar = null;
        }
        this.gKu.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.aE(string, str), bVar);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.gBq);
        registerListener(this.gBr);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        if (this.gKt.equals("photolive")) {
            this.gKB = 33;
        }
        this.gKw = new com.baidu.tieba.post.a.a(getPageContext(), this.gKu.gKE);
        this.gKu.btX().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                CardPersonDynamicThreadData cardPersonDynamicThreadData;
                if (i >= 0 && PersonThreadFragment.this.gKw != null && i < v.H(PersonThreadFragment.this.gBp.threadList) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) PersonThreadFragment.this.gKw.gAa.getItem(i)) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonThreadFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.threadId), String.valueOf(cardPersonDynamicThreadData.postId), "person_page", 18005)));
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.k(getPageContext());
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.post.PersonThreadFragment.5
            @Override // com.baidu.tbadk.core.view.j.b
            public void bI(boolean z) {
                if (PersonThreadFragment.this.gBp != null) {
                    PersonThreadFragment.this.gKq = true;
                    if (!com.baidu.adp.lib.util.j.kK()) {
                        if (PersonThreadFragment.this.gKu != null) {
                            PersonThreadFragment.this.gKu.N(PersonThreadFragment.this.getString(e.j.neterror), true);
                            return;
                        }
                        return;
                    }
                    PersonThreadFragment.this.btU();
                }
            }
        });
        this.gKu.gKE.setPullRefresh(this.mPullView);
        if (TbadkCoreApplication.isMyLive) {
            this.dJg = BdListViewHelper.a(getActivity(), this.gKu.gKE, BdListViewHelper.HeadType.DEFAULT);
            BdListViewHelper.a(this.dJg, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kV());
        } else {
            this.dJg = BdListViewHelper.a(getActivity(), this.gKu.gKE, BdListViewHelper.HeadType.HASTAB);
            BdListViewHelper.a(this.dJg, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.gKu.gKE.setOnSrollToBottomListener(this);
        this.gKy = new a(getBaseFragmentActivity());
        this.gKu.gKE.setNextPage(this.gKy);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            btV();
            this.gKy.ayv();
            this.bfz = true;
            return;
        }
        this.gKy.mJ(false);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
    public void b(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null && this.gBp != null) {
            if (z) {
                this.gBp.threadList.clear();
            }
            ArrayList<com.baidu.adp.widget.ListView.h> arrayList = personPostModel.threadList;
            if (personPostModel.view_card_num > 0 && this.gKA) {
                v.a(arrayList, personPostModel.view_card_num - 1, new com.baidu.tieba.personPolymeric.c.j());
                this.gKA = false;
            }
            if (this.gBp.threadList.isEmpty()) {
                com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) v.d(arrayList, 0);
                if (hVar instanceof CardPersonDynamicThreadData) {
                    ((CardPersonDynamicThreadData) hVar).dcq = true;
                } else if (hVar instanceof com.baidu.tieba.personPolymeric.c.j) {
                    ((com.baidu.tieba.personPolymeric.c.j) hVar).dcq = true;
                }
            }
            this.gBp.threadList.addAll(arrayList);
            PersonPostModel.mergeDynamicThreadByTime(this.gBp.threadList);
        }
        if (this.gKz != null) {
            this.gKz.mG(personPostModel.isShowRecycleBinRedTip);
        }
        a(personPostModel, z);
        this.gKw.C(this.gBp.threadList);
        this.gKw.notifyDataSetChanged();
    }

    /* loaded from: classes3.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private BaseFragmentActivity bDl;
        private View bfV;
        private int bgColor = e.d.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View anp = null;
        private int mSkinType = 3;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.bDl = null;
            this.bDl = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View oH() {
            this.anp = LayoutInflater.from(this.bDl.getPageContext().getContext()).inflate(e.h.new_pb_list_more, (ViewGroup) null);
            this.mTextView = (TextView) this.anp.findViewById(e.g.pb_more_text);
            this.bfV = this.anp.findViewById(e.g.pb_more_view);
            al.j(this.anp, this.bgColor);
            al.j(this.bfV, this.bgColor);
            this.bfV.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.anp.findViewById(e.g.progress);
            fv(TbadkCoreApplication.getInst().getSkinType());
            al.h(this.mTextView, e.d.common_color_10039);
            this.bfV.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.bDl.getPageContext().getPageActivity(), e.C0210e.ds120)));
            return this.anp;
        }

        public void fv(int i) {
            this.bDl.getLayoutMode().onModeChanged(this.bfV);
        }

        @SuppressLint({"ResourceAsColor"})
        public void ey(int i) {
            if (this.mSkinType != i) {
                al.h(this.mTextView, e.d.common_color_10039);
                al.e(this.anp, this.bgColor, i);
                al.e(this.bfV, this.bgColor, i);
                this.mSkinType = i;
            }
        }

        public void ayv() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.bDl.getPageContext().getPageActivity().getText(e.j.loading));
            this.bfV.setVisibility(0);
        }

        public void btW() {
            al.j(this.anp, e.d.cp_bg_line_c);
        }

        public void mJ(boolean z) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.bfV.setVisibility(0);
                    this.mTextView.setText(this.bDl.getResources().getString(e.j.list_no_more));
                    return;
                }
                this.bfV.setVisibility(0);
                this.mTextView.setText(this.bDl.getResources().getString(e.j.load_more));
            }
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.anp);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.gKu.mNoDataView != null) {
                this.gKu.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.ey(i);
            }
            if (this.gKw != null) {
                this.gKw.notifyDataSetChanged();
            }
            if (this.gKy != null) {
                this.gKy.ey(i);
            }
            al.j(this.gKu.gKE, e.d.cp_bg_line_d);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.gKu.mNoDataView != null) {
            this.gKu.mNoDataView.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.gKu.mNoDataView != null) {
            this.gKu.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.gKw != null) {
            this.gKw.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.gBp != null) {
            this.gBp.cancelLoadData();
        }
        try {
            com.baidu.tbadk.d.a.resetAll();
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
            if (i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.gKw != null && this.gBp != null && v.H(this.gBp.threadList) > 0) {
                int H = v.H(this.gBp.threadList);
                int i3 = 0;
                while (true) {
                    if (i3 >= H) {
                        z = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) v.d(this.gBp.threadList, i3);
                    if ((hVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) hVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.threadId))) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (z && intent.getIntExtra("type", -1) == 0) {
                    v.e(this.gBp.threadList, i3);
                    this.gKw.notifyDataSetChanged();
                }
            }
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.ebe != null) {
                    this.ebe.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.post.PersonThreadFragment.6
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void Jo() {
                        }

                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void a(final CustomDialogData customDialogData) {
                            com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.post.PersonThreadFragment.6.1
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
        if (!this.gKx) {
            this.gKu.gKE.startPullRefresh();
            this.gKx = true;
        }
    }

    public h btQ() {
        return this.gKu;
    }

    @Override // com.baidu.tieba.post.c
    public void btK() {
        if (this.gKu != null && this.gKu.gKE != null) {
            this.gKu.gKE.startPullRefresh();
        }
    }

    public void a(d dVar) {
        this.gKr = dVar;
    }

    public void a(b bVar) {
        this.gKz = bVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
    public void a(PersonPostModel personPostModel, boolean z) {
        this.bfz = false;
        if (isAdded()) {
            this.gKu.gKE.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            this.gKu.gKE.setEmptyView(null);
            if (personPostModel != null || this.gKq) {
                if (personPostModel == null || (personPostModel.threadList.size() == 0 && this.gKq && StringUtils.isNull(personPostModel.getErrorString()))) {
                    mI(true);
                    return;
                }
                if (personPostModel.threadList.size() == 0 && this.gKq) {
                    mI(true);
                } else {
                    mI(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(getActivity(), personPostModel.getErrorString());
                }
                this.mHasMore = !v.I(personPostModel.threadList);
                if (z) {
                    if (personPostModel.threadList.size() < 20) {
                        this.mHasMore = false;
                    } else {
                        this.mHasMore = true;
                    }
                    this.gKp = 0;
                    this.gKq = false;
                }
                this.gKy.mJ(this.mHasMore);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016221));
            }
        }
    }

    private void mI(boolean z) {
        this.gKu.gKE.removeHeaderView(this.gKu.mNoDataView);
        if (z) {
            this.gKu.mNoDataView.setVisibility(0);
            this.gKu.gKE.addHeaderView(this.gKu.mNoDataView);
            this.gKy.getView().setVisibility(8);
            return;
        }
        this.gKy.getView().setVisibility(0);
        this.gKy.btW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btR() {
        TiebaStatic.log("c10491");
        btT();
        com.baidu.tbadk.d.a.b(getBaseFragmentActivity()).a(1, this);
    }

    private void btS() {
        btT();
        com.baidu.tbadk.d.a.b(getBaseFragmentActivity()).b(this);
    }

    private void btT() {
        com.baidu.tbadk.d.a.b(getBaseFragmentActivity()).a(true, true, true, this);
    }

    public void btU() {
        if (this.gBp != null) {
            this.gBp.fetchPost(getPageContext(), this, true, this.mUid, true, this.gKB, false, true);
            this.gKA = true;
        }
    }

    public void btV() {
        if (this.gBp != null) {
            this.gBp.fetchPost(getPageContext(), this, false, this.mUid, true, false, true);
        }
    }
}
