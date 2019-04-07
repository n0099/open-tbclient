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
import com.baidu.pass.biometrics.base.utils.PhoneUtils;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.e.b;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.d;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class PersonThreadFragment extends BaseFragment implements BdListView.e, b.a, PersonPostModel.a, PersonPostModel.b, c {
    private View eWi;
    private ShareSuccessReplyToServerModel fot;
    public PersonPostModel hRa;
    private d ibA;
    private h ibD;
    private FrameLayout ibE;
    private com.baidu.tieba.post.a.a ibF;
    private boolean ibG;
    private a ibH;
    private b ibI;
    private int ibK;
    private int iby;
    private com.baidu.tbadk.core.view.i mPullView;
    private String mUid;
    private String ibC = PhoneUtils.CPUInfo.FEATURE_COMMON;
    private boolean mHasMore = false;
    private boolean ibz = true;
    private boolean ibJ = true;
    private boolean cpk = false;
    private CustomMessageListener hRb = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.post.PersonThreadFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && PersonThreadFragment.this.ibF != null) {
                PersonThreadFragment.this.ibF.Bb((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener hRc = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.post.PersonThreadFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.adp.lib.util.l.showToast(PersonThreadFragment.this.getActivity(), d.j.thread_has_hide);
            }
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.post.PersonThreadFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (com.baidu.adp.lib.util.j.kY() && PersonThreadFragment.this.cpk) {
                    PersonThreadFragment.this.bUG();
                    PersonThreadFragment.this.ibH.aYW();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.a(PersonThreadFragment.this.eWi, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kY());
                } else {
                    BdListViewHelper.a(PersonThreadFragment.this.eWi, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.mNetworkChangedMessageListener);
        this.hRa = new PersonPostModel(getPageContext(), getUniqueId(), this, true, PersonPostModel.FROM_PERSON_POST);
        this.hRa.setUniqueId(getUniqueId());
        this.fot = new ShareSuccessReplyToServerModel();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.person_thread_fragment, viewGroup, false);
        this.ibE = (FrameLayout) inflate.findViewById(d.g.root_view);
        this.ibD = new h(getActivity(), inflate);
        if (this.ibD.bUJ() == null) {
            this.ibD.b(this.ibA);
        }
        if (this.ibD.ibN != null) {
            al.l(this.ibD.ibN, d.C0277d.cp_bg_line_d);
        }
        String string2 = getArguments().getString("thread_type_key");
        if (!ap.isEmpty(string2)) {
            this.ibC = string2;
        }
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(d.j.to_be_an_liver), new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonThreadFragment.this.bUC();
            }
        });
        int dimension = (int) getResources().getDimension(d.e.ds102);
        String str = "";
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension);
        if (this.ibC.equals("photolive")) {
            int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1);
            if (i == 0) {
                str = getPageContext().getResources().getString(d.j.to_live_to_god);
                string = getPageContext().getResources().getString(d.j.user_not_liver);
                a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.new_pic_emotion_10, dimension, -1, -1);
                bVar = NoDataViewFactory.b.a(aVar);
            } else {
                string = getPageContext().getResources().getString(d.j.person_post_lv_empty_host);
                bVar = null;
            }
            if (i < 0) {
                bUD();
            }
        } else {
            string = getArguments().getString("key_empty_view_text");
            bVar = null;
        }
        this.ibD.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.bM(string, str), bVar);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.hRb);
        registerListener(this.hRc);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        if (this.ibC.equals("photolive")) {
            this.ibK = 33;
        }
        this.ibF = new com.baidu.tieba.post.a.a(getPageContext(), this.ibD.ibN);
        this.ibD.bUI().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                CardPersonDynamicThreadData cardPersonDynamicThreadData;
                if (i >= 0 && PersonThreadFragment.this.ibF != null && i < v.S(PersonThreadFragment.this.hRa.threadList) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) PersonThreadFragment.this.ibF.hPL.getItem(i)) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonThreadFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.threadId), String.valueOf(cardPersonDynamicThreadData.postId), "person_page", 18005)));
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.i(getPageContext());
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.post.PersonThreadFragment.5
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                if (PersonThreadFragment.this.hRa != null) {
                    PersonThreadFragment.this.ibz = true;
                    if (!com.baidu.adp.lib.util.j.kM()) {
                        if (PersonThreadFragment.this.ibD != null) {
                            PersonThreadFragment.this.ibD.ah(PersonThreadFragment.this.getString(d.j.neterror), true);
                            return;
                        }
                        return;
                    }
                    PersonThreadFragment.this.bUF();
                }
            }
        });
        this.ibD.ibN.setPullRefresh(this.mPullView);
        if (TbadkCoreApplication.isMyLive) {
            this.eWi = BdListViewHelper.a(getActivity(), this.ibD.ibN, BdListViewHelper.HeadType.DEFAULT);
            BdListViewHelper.a(this.eWi, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kY());
        } else {
            this.eWi = BdListViewHelper.a(getActivity(), this.ibD.ibN, BdListViewHelper.HeadType.HASTAB);
            BdListViewHelper.a(this.eWi, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.ibD.ibN.setOnSrollToBottomListener(this);
        this.ibH = new a(getBaseFragmentActivity());
        this.ibD.ibN.setNextPage(this.ibH);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            bUG();
            this.ibH.aYW();
            this.cpk = true;
            return;
        }
        this.ibH.pi(false);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
    public void b(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null && this.hRa != null) {
            if (z) {
                this.hRa.threadList.clear();
            }
            ArrayList<com.baidu.adp.widget.ListView.m> arrayList = personPostModel.threadList;
            if (personPostModel.view_card_num > 0 && this.ibJ) {
                v.a(arrayList, personPostModel.view_card_num - 1, new com.baidu.tieba.personPolymeric.c.j());
                this.ibJ = false;
            }
            if (this.hRa.threadList.isEmpty()) {
                com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) v.c(arrayList, 0);
                if (mVar instanceof CardPersonDynamicThreadData) {
                    ((CardPersonDynamicThreadData) mVar).elZ = true;
                } else if (mVar instanceof com.baidu.tieba.personPolymeric.c.j) {
                    ((com.baidu.tieba.personPolymeric.c.j) mVar).elZ = true;
                }
            }
            this.hRa.threadList.addAll(arrayList);
            PersonPostModel.mergeDynamicThreadByTime(this.hRa.threadList);
        }
        if (this.ibI != null) {
            this.ibI.pf(personPostModel.isShowRecycleBinRedTip);
        }
        a(personPostModel, z);
        this.ibF.F(this.hRa.threadList);
        this.ibF.notifyDataSetChanged();
    }

    /* loaded from: classes6.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private BaseFragmentActivity cOr;
        private View cpH;
        private int bgColor = d.C0277d.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View bub = null;
        private int mSkinType = 3;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.cOr = null;
            this.cOr = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View oM() {
            this.bub = LayoutInflater.from(this.cOr.getPageContext().getContext()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
            this.mTextView = (TextView) this.bub.findViewById(d.g.pb_more_text);
            this.cpH = this.bub.findViewById(d.g.pb_more_view);
            al.l(this.bub, this.bgColor);
            al.l(this.cpH, this.bgColor);
            this.cpH.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.bub.findViewById(d.g.progress);
            jf(TbadkCoreApplication.getInst().getSkinType());
            al.j(this.mTextView, d.C0277d.common_color_10039);
            this.cpH.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.cOr.getPageContext().getPageActivity(), d.e.ds120)));
            return this.bub;
        }

        public void jf(int i) {
            this.cOr.getLayoutMode().onModeChanged(this.cpH);
        }

        @SuppressLint({"ResourceAsColor"})
        public void ib(int i) {
            if (this.mSkinType != i) {
                al.j(this.mTextView, d.C0277d.common_color_10039);
                al.f(this.bub, this.bgColor, i);
                al.f(this.cpH, this.bgColor, i);
                this.mSkinType = i;
            }
        }

        public void aYW() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.cOr.getPageContext().getPageActivity().getText(d.j.loading));
            this.cpH.setVisibility(0);
        }

        public void bUH() {
            al.l(this.bub, d.C0277d.cp_bg_line_c);
        }

        public void pi(boolean z) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.cpH.setVisibility(0);
                    this.mTextView.setText(this.cOr.getResources().getString(d.j.list_no_more));
                    return;
                }
                this.cpH.setVisibility(0);
                this.mTextView.setText(this.cOr.getResources().getString(d.j.load_more));
            }
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.bub);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.ibD.mNoDataView != null) {
                this.ibD.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.ib(i);
            }
            if (this.ibF != null) {
                this.ibF.notifyDataSetChanged();
            }
            if (this.ibH != null) {
                this.ibH.ib(i);
            }
            al.l(this.ibD.ibN, d.C0277d.cp_bg_line_d);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.ibD.mNoDataView != null) {
            this.ibD.mNoDataView.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.ibD.mNoDataView != null) {
            this.ibD.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.ibF != null) {
            this.ibF.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.hRa != null) {
            this.hRa.cancelLoadData();
        }
        try {
            com.baidu.tbadk.e.a.Hf();
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
            if (i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.ibF != null && this.hRa != null && v.S(this.hRa.threadList) > 0) {
                int S = v.S(this.hRa.threadList);
                int i3 = 0;
                while (true) {
                    if (i3 >= S) {
                        z = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) v.c(this.hRa.threadList, i3);
                    if ((mVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) mVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.threadId))) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (z && intent.getIntExtra("type", -1) == 0) {
                    v.d(this.hRa.threadList, i3);
                    this.ibF.notifyDataSetChanged();
                }
            }
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.fot != null) {
                    this.fot.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.post.PersonThreadFragment.6
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void aiH() {
                        }

                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void a(final CustomDialogData customDialogData) {
                            com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.post.PersonThreadFragment.6.1
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
        if (!this.ibG) {
            this.ibD.ibN.startPullRefresh();
            this.ibG = true;
        }
    }

    public h bUB() {
        return this.ibD;
    }

    @Override // com.baidu.tieba.post.c
    public void bUv() {
        if (this.ibD != null && this.ibD.ibN != null) {
            this.ibD.ibN.startPullRefresh();
        }
    }

    public void a(d dVar) {
        this.ibA = dVar;
    }

    public void a(b bVar) {
        this.ibI = bVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
    public void a(PersonPostModel personPostModel, boolean z) {
        this.cpk = false;
        if (isAdded()) {
            this.ibD.ibN.completePullRefreshPostDelayed(0L);
            this.ibD.ibN.setEmptyView(null);
            if (personPostModel != null || this.ibz) {
                if (personPostModel == null || (personPostModel.threadList.size() == 0 && this.ibz && StringUtils.isNull(personPostModel.getErrorString()))) {
                    ph(true);
                    return;
                }
                if (personPostModel.threadList.size() == 0 && this.ibz) {
                    ph(true);
                } else {
                    ph(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(getActivity(), personPostModel.getErrorString());
                }
                this.mHasMore = !v.T(personPostModel.threadList);
                if (z) {
                    if (personPostModel.threadList.size() < 20) {
                        this.mHasMore = false;
                    } else {
                        this.mHasMore = true;
                    }
                    this.iby = 0;
                    this.ibz = false;
                }
                this.ibH.pi(this.mHasMore);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016221));
            }
        }
    }

    private void ph(boolean z) {
        this.ibD.ibN.removeHeaderView(this.ibD.mNoDataView);
        if (z) {
            this.ibD.mNoDataView.setVisibility(0);
            this.ibD.ibN.addHeaderView(this.ibD.mNoDataView);
            this.ibH.getView().setVisibility(8);
            return;
        }
        this.ibH.getView().setVisibility(0);
        this.ibH.bUH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUC() {
        TiebaStatic.log("c10491");
        bUE();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(1, this);
    }

    private void bUD() {
        bUE();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).b(this);
    }

    private void bUE() {
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(true, true, true, this);
    }

    public void bUF() {
        if (this.hRa != null) {
            this.hRa.fetchPost(getPageContext(), this, true, this.mUid, true, this.ibK, false, true);
            this.ibJ = true;
        }
    }

    public void bUG() {
        if (this.hRa != null) {
            this.hRa.fetchPost(getPageContext(), this, false, this.mUid, true, false, true);
        }
    }
}
