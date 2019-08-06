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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.e.b;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class PersonThreadFragment extends BaseFragment implements BdListView.e, b.a, PersonPostModel.a, PersonPostModel.b, c {
    private ShareSuccessReplyToServerModel fKB;
    private View frM;
    private int iBC;
    private d iBE;
    private h iBH;
    private FrameLayout iBI;
    private com.baidu.tieba.post.a.a iBJ;
    private boolean iBK;
    private a iBL;
    private b iBM;
    private int iBO;
    public PersonPostModel irn;
    private com.baidu.tbadk.core.view.i mPullView;
    private String mUid;
    private String iBG = PhoneUtils.CPUInfo.FEATURE_COMMON;
    private boolean mHasMore = false;
    private boolean iBD = true;
    private boolean iBN = true;
    private boolean cyP = false;
    private CustomMessageListener iro = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.post.PersonThreadFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && PersonThreadFragment.this.iBJ != null) {
                PersonThreadFragment.this.iBJ.Dj((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener irp = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.post.PersonThreadFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.adp.lib.util.l.showToast(PersonThreadFragment.this.getActivity(), (int) R.string.thread_has_hide);
            }
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.post.PersonThreadFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (com.baidu.adp.lib.util.j.kc() && PersonThreadFragment.this.cyP) {
                    PersonThreadFragment.this.cfT();
                    PersonThreadFragment.this.iBL.biD();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.a(PersonThreadFragment.this.frM, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kc());
                } else {
                    BdListViewHelper.a(PersonThreadFragment.this.frM, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.mNetworkChangedMessageListener);
        this.irn = new PersonPostModel(getPageContext(), getUniqueId(), this, true, PersonPostModel.FROM_PERSON_POST);
        this.irn.setUniqueId(getUniqueId());
        this.fKB = new ShareSuccessReplyToServerModel();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_thread_fragment, viewGroup, false);
        this.iBI = (FrameLayout) inflate.findViewById(R.id.root_view);
        this.iBH = new h(getActivity(), inflate);
        if (this.iBH.cfW() == null) {
            this.iBH.b(this.iBE);
        }
        if (this.iBH.iBR != null) {
            am.l(this.iBH.iBR, R.color.cp_bg_line_d);
        }
        String string2 = getArguments().getString("thread_type_key");
        if (!aq.isEmpty(string2)) {
            this.iBG = string2;
        }
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(R.string.to_be_an_liver), new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonThreadFragment.this.cfP();
            }
        });
        int dimension = (int) getResources().getDimension(R.dimen.ds102);
        String str = "";
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension);
        if (this.iBG.equals("photolive")) {
            int i = com.baidu.tbadk.core.sharedPref.b.ahQ().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1);
            if (i == 0) {
                str = getPageContext().getResources().getString(R.string.to_live_to_god);
                string = getPageContext().getResources().getString(R.string.user_not_liver);
                a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_10, dimension, -1, -1);
                bVar = NoDataViewFactory.b.a(aVar);
            } else {
                string = getPageContext().getResources().getString(R.string.person_post_lv_empty_host);
                bVar = null;
            }
            if (i < 0) {
                cfQ();
            }
        } else {
            string = getArguments().getString("key_empty_view_text");
            bVar = null;
        }
        this.iBH.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.bX(string, str), bVar);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.iro);
        registerListener(this.irp);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        if (this.iBG.equals("photolive")) {
            this.iBO = 33;
        }
        this.iBJ = new com.baidu.tieba.post.a.a(getPageContext(), this.iBH.iBR);
        this.iBH.cfV().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                CardPersonDynamicThreadData cardPersonDynamicThreadData;
                if (i >= 0 && PersonThreadFragment.this.iBJ != null && i < v.Z(PersonThreadFragment.this.irn.threadList) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) PersonThreadFragment.this.iBJ.ipY.getItem(i)) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonThreadFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.threadId), String.valueOf(cardPersonDynamicThreadData.postId), "person_page", 18005)));
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.i(getPageContext());
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.post.PersonThreadFragment.5
            @Override // com.baidu.tbadk.core.view.h.c
            public void er(boolean z) {
                if (PersonThreadFragment.this.irn != null) {
                    PersonThreadFragment.this.iBD = true;
                    if (!com.baidu.adp.lib.util.j.jQ()) {
                        if (PersonThreadFragment.this.iBH != null) {
                            PersonThreadFragment.this.iBH.an(PersonThreadFragment.this.getString(R.string.neterror), true);
                            return;
                        }
                        return;
                    }
                    PersonThreadFragment.this.cfS();
                }
            }
        });
        this.iBH.iBR.setPullRefresh(this.mPullView);
        if (TbadkCoreApplication.isMyLive) {
            this.frM = BdListViewHelper.a(getActivity(), this.iBH.iBR, BdListViewHelper.HeadType.DEFAULT);
            BdListViewHelper.a(this.frM, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kc());
        } else {
            this.frM = BdListViewHelper.a(getActivity(), this.iBH.iBR, BdListViewHelper.HeadType.HASTAB);
            BdListViewHelper.a(this.frM, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.iBH.iBR.setOnSrollToBottomListener(this);
        this.iBL = new a(getBaseFragmentActivity());
        this.iBH.iBR.setNextPage(this.iBL);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            cfT();
            this.iBL.biD();
            this.cyP = true;
            return;
        }
        this.iBL.qm(false);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
    public void b(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null && this.irn != null) {
            if (z) {
                this.irn.threadList.clear();
            }
            ArrayList<com.baidu.adp.widget.ListView.m> arrayList = personPostModel.threadList;
            if (personPostModel.view_card_num > 0 && this.iBN) {
                v.a(arrayList, personPostModel.view_card_num - 1, new com.baidu.tieba.personPolymeric.c.j());
                this.iBN = false;
            }
            if (this.irn.threadList.isEmpty()) {
                com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) v.c(arrayList, 0);
                if (mVar instanceof CardPersonDynamicThreadData) {
                    ((CardPersonDynamicThreadData) mVar).eGR = true;
                } else if (mVar instanceof com.baidu.tieba.personPolymeric.c.j) {
                    ((com.baidu.tieba.personPolymeric.c.j) mVar).eGR = true;
                }
            }
            this.irn.threadList.addAll(arrayList);
            PersonPostModel.mergeDynamicThreadByTime(this.irn.threadList);
        }
        if (this.iBM != null) {
            this.iBM.qj(personPostModel.isShowRecycleBinRedTip);
        }
        a(personPostModel, z);
        this.iBJ.I(this.irn.threadList);
        this.iBJ.notifyDataSetChanged();
    }

    /* loaded from: classes6.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private BaseFragmentActivity cYi;
        private View czl;
        private int bgColor = R.color.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;
        private int mSkinType = 3;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.cYi = null;
            this.cYi = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View nZ() {
            this.mRoot = LayoutInflater.from(this.cYi.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.czl = this.mRoot.findViewById(R.id.pb_more_view);
            am.l(this.mRoot, this.bgColor);
            am.l(this.czl, this.bgColor);
            this.czl.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            ka(TbadkCoreApplication.getInst().getSkinType());
            am.j(this.mTextView, R.color.common_color_10039);
            this.czl.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.g(this.cYi.getPageContext().getPageActivity(), R.dimen.ds120)));
            return this.mRoot;
        }

        public void ka(int i) {
            this.cYi.getLayoutMode().onModeChanged(this.czl);
        }

        @SuppressLint({"ResourceAsColor"})
        public void iV(int i) {
            if (this.mSkinType != i) {
                am.j(this.mTextView, R.color.common_color_10039);
                am.h(this.mRoot, this.bgColor, i);
                am.h(this.czl, this.bgColor, i);
                this.mSkinType = i;
            }
        }

        public void biD() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.cYi.getPageContext().getPageActivity().getText(R.string.loading));
            this.czl.setVisibility(0);
        }

        public void cfU() {
            am.l(this.mRoot, R.color.cp_bg_line_c);
        }

        public void qm(boolean z) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.czl.setVisibility(0);
                    this.mTextView.setText(this.cYi.getResources().getString(R.string.list_no_more));
                    return;
                }
                this.czl.setVisibility(0);
                this.mTextView.setText(this.cYi.getResources().getString(R.string.load_more));
            }
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.mRoot);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.iBH.mNoDataView != null) {
                this.iBH.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.iV(i);
            }
            if (this.iBJ != null) {
                this.iBJ.notifyDataSetChanged();
            }
            if (this.iBL != null) {
                this.iBL.iV(i);
            }
            am.l(this.iBH.iBR, R.color.cp_bg_line_d);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.iBH.mNoDataView != null) {
            this.iBH.mNoDataView.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.iBH.mNoDataView != null) {
            this.iBH.mNoDataView.akw();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        cfN();
        if (this.iBJ != null) {
            this.iBJ.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.irn != null) {
            this.irn.cancelLoadData();
        }
        try {
            com.baidu.tbadk.e.a.Ki();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        BdAsyncTask.removeAllTask(SetPrivacyModel.UNIQUE_ID_SET_PRIVACY_TASK);
        BdAsyncTask.removeAllTask(ForumManageModel.UNIQUE_ID_DEL_POST_TASK);
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.coreExtra.c.e shareItem;
        String stringExtra;
        boolean z;
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.iBJ != null && this.irn != null && v.Z(this.irn.threadList) > 0) {
                int Z = v.Z(this.irn.threadList);
                int i3 = 0;
                while (true) {
                    if (i3 >= Z) {
                        z = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) v.c(this.irn.threadList, i3);
                    if ((mVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) mVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.threadId))) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (z && intent.getIntExtra("type", -1) == 0) {
                    v.d(this.irn.threadList, i3);
                    this.iBJ.notifyDataSetChanged();
                }
            }
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.fKB != null) {
                    this.fKB.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.post.PersonThreadFragment.6
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void aoP() {
                        }

                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void a(final CustomDialogData customDialogData) {
                            com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.post.PersonThreadFragment.6.1
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

    public void cfN() {
        if (!this.iBK) {
            this.iBH.iBR.startPullRefresh();
            this.iBK = true;
        }
    }

    public h cfO() {
        return this.iBH;
    }

    @Override // com.baidu.tieba.post.c
    public void cfI() {
        if (this.iBH != null && this.iBH.iBR != null) {
            this.iBH.iBR.startPullRefresh();
        }
    }

    public void a(d dVar) {
        this.iBE = dVar;
    }

    public void a(b bVar) {
        this.iBM = bVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
    public void a(PersonPostModel personPostModel, boolean z) {
        this.cyP = false;
        if (isAdded()) {
            this.iBH.iBR.completePullRefreshPostDelayed(0L);
            this.iBH.iBR.setEmptyView(null);
            if (personPostModel != null || this.iBD) {
                if (personPostModel == null || (personPostModel.threadList.size() == 0 && this.iBD && StringUtils.isNull(personPostModel.getErrorString()))) {
                    ql(true);
                    return;
                }
                if (personPostModel.threadList.size() == 0 && this.iBD) {
                    ql(true);
                } else {
                    ql(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(getActivity(), personPostModel.getErrorString());
                }
                this.mHasMore = !v.aa(personPostModel.threadList);
                if (z) {
                    if (personPostModel.threadList.size() < 20) {
                        this.mHasMore = false;
                    } else {
                        this.mHasMore = true;
                    }
                    this.iBC = 0;
                    this.iBD = false;
                }
                this.iBL.qm(this.mHasMore);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016221));
            }
        }
    }

    private void ql(boolean z) {
        this.iBH.iBR.removeHeaderView(this.iBH.mNoDataView);
        if (z) {
            this.iBH.mNoDataView.setVisibility(0);
            this.iBH.iBR.addHeaderView(this.iBH.mNoDataView);
            this.iBL.getView().setVisibility(8);
            return;
        }
        this.iBL.getView().setVisibility(0);
        this.iBL.cfU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfP() {
        TiebaStatic.log("c10491");
        cfR();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(1, this);
    }

    private void cfQ() {
        cfR();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).b(this);
    }

    private void cfR() {
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(true, true, true, this);
    }

    public void cfS() {
        if (this.irn != null) {
            this.irn.fetchPost(getPageContext(), this, true, this.mUid, true, this.iBO, false, true);
            this.iBN = true;
        }
    }

    public void cfT() {
        if (this.irn != null) {
            this.irn.fetchPost(getPageContext(), this, false, this.mUid, true, false, true);
        }
    }
}
