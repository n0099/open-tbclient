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
    private View eWj;
    private ShareSuccessReplyToServerModel fot;
    public PersonPostModel hRb;
    private d ibB;
    private h ibE;
    private FrameLayout ibF;
    private com.baidu.tieba.post.a.a ibG;
    private boolean ibH;
    private a ibI;
    private b ibJ;
    private int ibL;
    private int ibz;
    private com.baidu.tbadk.core.view.i mPullView;
    private String mUid;
    private String ibD = PhoneUtils.CPUInfo.FEATURE_COMMON;
    private boolean mHasMore = false;
    private boolean ibA = true;
    private boolean ibK = true;
    private boolean cpl = false;
    private CustomMessageListener hRc = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.post.PersonThreadFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && PersonThreadFragment.this.ibG != null) {
                PersonThreadFragment.this.ibG.Bb((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener hRd = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.post.PersonThreadFragment.2
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
                if (com.baidu.adp.lib.util.j.kY() && PersonThreadFragment.this.cpl) {
                    PersonThreadFragment.this.bUG();
                    PersonThreadFragment.this.ibI.aYW();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.a(PersonThreadFragment.this.eWj, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kY());
                } else {
                    BdListViewHelper.a(PersonThreadFragment.this.eWj, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.mNetworkChangedMessageListener);
        this.hRb = new PersonPostModel(getPageContext(), getUniqueId(), this, true, PersonPostModel.FROM_PERSON_POST);
        this.hRb.setUniqueId(getUniqueId());
        this.fot = new ShareSuccessReplyToServerModel();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.person_thread_fragment, viewGroup, false);
        this.ibF = (FrameLayout) inflate.findViewById(d.g.root_view);
        this.ibE = new h(getActivity(), inflate);
        if (this.ibE.bUJ() == null) {
            this.ibE.b(this.ibB);
        }
        if (this.ibE.ibO != null) {
            al.l(this.ibE.ibO, d.C0277d.cp_bg_line_d);
        }
        String string2 = getArguments().getString("thread_type_key");
        if (!ap.isEmpty(string2)) {
            this.ibD = string2;
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
        if (this.ibD.equals("photolive")) {
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
        this.ibE.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.bM(string, str), bVar);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.hRc);
        registerListener(this.hRd);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        if (this.ibD.equals("photolive")) {
            this.ibL = 33;
        }
        this.ibG = new com.baidu.tieba.post.a.a(getPageContext(), this.ibE.ibO);
        this.ibE.bUI().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                CardPersonDynamicThreadData cardPersonDynamicThreadData;
                if (i >= 0 && PersonThreadFragment.this.ibG != null && i < v.S(PersonThreadFragment.this.hRb.threadList) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) PersonThreadFragment.this.ibG.hPM.getItem(i)) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonThreadFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.threadId), String.valueOf(cardPersonDynamicThreadData.postId), "person_page", 18005)));
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.i(getPageContext());
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.post.PersonThreadFragment.5
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                if (PersonThreadFragment.this.hRb != null) {
                    PersonThreadFragment.this.ibA = true;
                    if (!com.baidu.adp.lib.util.j.kM()) {
                        if (PersonThreadFragment.this.ibE != null) {
                            PersonThreadFragment.this.ibE.ah(PersonThreadFragment.this.getString(d.j.neterror), true);
                            return;
                        }
                        return;
                    }
                    PersonThreadFragment.this.bUF();
                }
            }
        });
        this.ibE.ibO.setPullRefresh(this.mPullView);
        if (TbadkCoreApplication.isMyLive) {
            this.eWj = BdListViewHelper.a(getActivity(), this.ibE.ibO, BdListViewHelper.HeadType.DEFAULT);
            BdListViewHelper.a(this.eWj, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kY());
        } else {
            this.eWj = BdListViewHelper.a(getActivity(), this.ibE.ibO, BdListViewHelper.HeadType.HASTAB);
            BdListViewHelper.a(this.eWj, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.ibE.ibO.setOnSrollToBottomListener(this);
        this.ibI = new a(getBaseFragmentActivity());
        this.ibE.ibO.setNextPage(this.ibI);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            bUG();
            this.ibI.aYW();
            this.cpl = true;
            return;
        }
        this.ibI.pi(false);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
    public void b(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null && this.hRb != null) {
            if (z) {
                this.hRb.threadList.clear();
            }
            ArrayList<com.baidu.adp.widget.ListView.m> arrayList = personPostModel.threadList;
            if (personPostModel.view_card_num > 0 && this.ibK) {
                v.a(arrayList, personPostModel.view_card_num - 1, new com.baidu.tieba.personPolymeric.c.j());
                this.ibK = false;
            }
            if (this.hRb.threadList.isEmpty()) {
                com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) v.c(arrayList, 0);
                if (mVar instanceof CardPersonDynamicThreadData) {
                    ((CardPersonDynamicThreadData) mVar).ema = true;
                } else if (mVar instanceof com.baidu.tieba.personPolymeric.c.j) {
                    ((com.baidu.tieba.personPolymeric.c.j) mVar).ema = true;
                }
            }
            this.hRb.threadList.addAll(arrayList);
            PersonPostModel.mergeDynamicThreadByTime(this.hRb.threadList);
        }
        if (this.ibJ != null) {
            this.ibJ.pf(personPostModel.isShowRecycleBinRedTip);
        }
        a(personPostModel, z);
        this.ibG.F(this.hRb.threadList);
        this.ibG.notifyDataSetChanged();
    }

    /* loaded from: classes6.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private BaseFragmentActivity cOs;
        private View cpI;
        private int bgColor = d.C0277d.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View buc = null;
        private int mSkinType = 3;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.cOs = null;
            this.cOs = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View oM() {
            this.buc = LayoutInflater.from(this.cOs.getPageContext().getContext()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
            this.mTextView = (TextView) this.buc.findViewById(d.g.pb_more_text);
            this.cpI = this.buc.findViewById(d.g.pb_more_view);
            al.l(this.buc, this.bgColor);
            al.l(this.cpI, this.bgColor);
            this.cpI.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.buc.findViewById(d.g.progress);
            jf(TbadkCoreApplication.getInst().getSkinType());
            al.j(this.mTextView, d.C0277d.common_color_10039);
            this.cpI.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.cOs.getPageContext().getPageActivity(), d.e.ds120)));
            return this.buc;
        }

        public void jf(int i) {
            this.cOs.getLayoutMode().onModeChanged(this.cpI);
        }

        @SuppressLint({"ResourceAsColor"})
        public void ib(int i) {
            if (this.mSkinType != i) {
                al.j(this.mTextView, d.C0277d.common_color_10039);
                al.f(this.buc, this.bgColor, i);
                al.f(this.cpI, this.bgColor, i);
                this.mSkinType = i;
            }
        }

        public void aYW() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.cOs.getPageContext().getPageActivity().getText(d.j.loading));
            this.cpI.setVisibility(0);
        }

        public void bUH() {
            al.l(this.buc, d.C0277d.cp_bg_line_c);
        }

        public void pi(boolean z) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.cpI.setVisibility(0);
                    this.mTextView.setText(this.cOs.getResources().getString(d.j.list_no_more));
                    return;
                }
                this.cpI.setVisibility(0);
                this.mTextView.setText(this.cOs.getResources().getString(d.j.load_more));
            }
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.buc);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.ibE.mNoDataView != null) {
                this.ibE.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.ib(i);
            }
            if (this.ibG != null) {
                this.ibG.notifyDataSetChanged();
            }
            if (this.ibI != null) {
                this.ibI.ib(i);
            }
            al.l(this.ibE.ibO, d.C0277d.cp_bg_line_d);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.ibE.mNoDataView != null) {
            this.ibE.mNoDataView.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.ibE.mNoDataView != null) {
            this.ibE.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.ibG != null) {
            this.ibG.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.hRb != null) {
            this.hRb.cancelLoadData();
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
            if (i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.ibG != null && this.hRb != null && v.S(this.hRb.threadList) > 0) {
                int S = v.S(this.hRb.threadList);
                int i3 = 0;
                while (true) {
                    if (i3 >= S) {
                        z = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) v.c(this.hRb.threadList, i3);
                    if ((mVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) mVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.threadId))) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (z && intent.getIntExtra("type", -1) == 0) {
                    v.d(this.hRb.threadList, i3);
                    this.ibG.notifyDataSetChanged();
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
        if (!this.ibH) {
            this.ibE.ibO.startPullRefresh();
            this.ibH = true;
        }
    }

    public h bUB() {
        return this.ibE;
    }

    @Override // com.baidu.tieba.post.c
    public void bUv() {
        if (this.ibE != null && this.ibE.ibO != null) {
            this.ibE.ibO.startPullRefresh();
        }
    }

    public void a(d dVar) {
        this.ibB = dVar;
    }

    public void a(b bVar) {
        this.ibJ = bVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
    public void a(PersonPostModel personPostModel, boolean z) {
        this.cpl = false;
        if (isAdded()) {
            this.ibE.ibO.completePullRefreshPostDelayed(0L);
            this.ibE.ibO.setEmptyView(null);
            if (personPostModel != null || this.ibA) {
                if (personPostModel == null || (personPostModel.threadList.size() == 0 && this.ibA && StringUtils.isNull(personPostModel.getErrorString()))) {
                    ph(true);
                    return;
                }
                if (personPostModel.threadList.size() == 0 && this.ibA) {
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
                    this.ibz = 0;
                    this.ibA = false;
                }
                this.ibI.pi(this.mHasMore);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016221));
            }
        }
    }

    private void ph(boolean z) {
        this.ibE.ibO.removeHeaderView(this.ibE.mNoDataView);
        if (z) {
            this.ibE.mNoDataView.setVisibility(0);
            this.ibE.ibO.addHeaderView(this.ibE.mNoDataView);
            this.ibI.getView().setVisibility(8);
            return;
        }
        this.ibI.getView().setVisibility(0);
        this.ibI.bUH();
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
        if (this.hRb != null) {
            this.hRb.fetchPost(getPageContext(), this, true, this.mUid, true, this.ibL, false, true);
            this.ibK = true;
        }
    }

    public void bUG() {
        if (this.hRb != null) {
            this.hRb.fetchPost(getPageContext(), this, false, this.mUid, true, false, true);
        }
    }
}
