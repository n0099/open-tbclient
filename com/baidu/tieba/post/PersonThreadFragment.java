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
    private ShareSuccessReplyToServerModel fJN;
    private View frm;
    private d iAA;
    private h iAD;
    private FrameLayout iAE;
    private com.baidu.tieba.post.a.a iAF;
    private boolean iAG;
    private a iAH;
    private b iAI;
    private int iAK;
    private int iAy;
    public PersonPostModel iqj;
    private com.baidu.tbadk.core.view.i mPullView;
    private String mUid;
    private String iAC = PhoneUtils.CPUInfo.FEATURE_COMMON;
    private boolean mHasMore = false;
    private boolean iAz = true;
    private boolean iAJ = true;
    private boolean cyI = false;
    private CustomMessageListener iqk = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.post.PersonThreadFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && PersonThreadFragment.this.iAF != null) {
                PersonThreadFragment.this.iAF.Di((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener iql = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.post.PersonThreadFragment.2
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
                if (com.baidu.adp.lib.util.j.kc() && PersonThreadFragment.this.cyI) {
                    PersonThreadFragment.this.cfB();
                    PersonThreadFragment.this.iAH.biw();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.a(PersonThreadFragment.this.frm, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kc());
                } else {
                    BdListViewHelper.a(PersonThreadFragment.this.frm, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.mNetworkChangedMessageListener);
        this.iqj = new PersonPostModel(getPageContext(), getUniqueId(), this, true, PersonPostModel.FROM_PERSON_POST);
        this.iqj.setUniqueId(getUniqueId());
        this.fJN = new ShareSuccessReplyToServerModel();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_thread_fragment, viewGroup, false);
        this.iAE = (FrameLayout) inflate.findViewById(R.id.root_view);
        this.iAD = new h(getActivity(), inflate);
        if (this.iAD.cfE() == null) {
            this.iAD.b(this.iAA);
        }
        if (this.iAD.iAN != null) {
            am.l(this.iAD.iAN, R.color.cp_bg_line_d);
        }
        String string2 = getArguments().getString("thread_type_key");
        if (!aq.isEmpty(string2)) {
            this.iAC = string2;
        }
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(R.string.to_be_an_liver), new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonThreadFragment.this.cfx();
            }
        });
        int dimension = (int) getResources().getDimension(R.dimen.ds102);
        String str = "";
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension);
        if (this.iAC.equals("photolive")) {
            int i = com.baidu.tbadk.core.sharedPref.b.ahO().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1);
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
                cfy();
            }
        } else {
            string = getArguments().getString("key_empty_view_text");
            bVar = null;
        }
        this.iAD.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.bX(string, str), bVar);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.iqk);
        registerListener(this.iql);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        if (this.iAC.equals("photolive")) {
            this.iAK = 33;
        }
        this.iAF = new com.baidu.tieba.post.a.a(getPageContext(), this.iAD.iAN);
        this.iAD.cfD().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                CardPersonDynamicThreadData cardPersonDynamicThreadData;
                if (i >= 0 && PersonThreadFragment.this.iAF != null && i < v.Z(PersonThreadFragment.this.iqj.threadList) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) PersonThreadFragment.this.iAF.ioU.getItem(i)) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonThreadFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.threadId), String.valueOf(cardPersonDynamicThreadData.postId), "person_page", 18005)));
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.i(getPageContext());
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.post.PersonThreadFragment.5
            @Override // com.baidu.tbadk.core.view.h.c
            public void er(boolean z) {
                if (PersonThreadFragment.this.iqj != null) {
                    PersonThreadFragment.this.iAz = true;
                    if (!com.baidu.adp.lib.util.j.jQ()) {
                        if (PersonThreadFragment.this.iAD != null) {
                            PersonThreadFragment.this.iAD.an(PersonThreadFragment.this.getString(R.string.neterror), true);
                            return;
                        }
                        return;
                    }
                    PersonThreadFragment.this.cfA();
                }
            }
        });
        this.iAD.iAN.setPullRefresh(this.mPullView);
        if (TbadkCoreApplication.isMyLive) {
            this.frm = BdListViewHelper.a(getActivity(), this.iAD.iAN, BdListViewHelper.HeadType.DEFAULT);
            BdListViewHelper.a(this.frm, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kc());
        } else {
            this.frm = BdListViewHelper.a(getActivity(), this.iAD.iAN, BdListViewHelper.HeadType.HASTAB);
            BdListViewHelper.a(this.frm, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.iAD.iAN.setOnSrollToBottomListener(this);
        this.iAH = new a(getBaseFragmentActivity());
        this.iAD.iAN.setNextPage(this.iAH);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            cfB();
            this.iAH.biw();
            this.cyI = true;
            return;
        }
        this.iAH.ql(false);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
    public void b(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null && this.iqj != null) {
            if (z) {
                this.iqj.threadList.clear();
            }
            ArrayList<com.baidu.adp.widget.ListView.m> arrayList = personPostModel.threadList;
            if (personPostModel.view_card_num > 0 && this.iAJ) {
                v.a(arrayList, personPostModel.view_card_num - 1, new com.baidu.tieba.personPolymeric.c.j());
                this.iAJ = false;
            }
            if (this.iqj.threadList.isEmpty()) {
                com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) v.c(arrayList, 0);
                if (mVar instanceof CardPersonDynamicThreadData) {
                    ((CardPersonDynamicThreadData) mVar).eGK = true;
                } else if (mVar instanceof com.baidu.tieba.personPolymeric.c.j) {
                    ((com.baidu.tieba.personPolymeric.c.j) mVar).eGK = true;
                }
            }
            this.iqj.threadList.addAll(arrayList);
            PersonPostModel.mergeDynamicThreadByTime(this.iqj.threadList);
        }
        if (this.iAI != null) {
            this.iAI.qi(personPostModel.isShowRecycleBinRedTip);
        }
        a(personPostModel, z);
        this.iAF.I(this.iqj.threadList);
        this.iAF.notifyDataSetChanged();
    }

    /* loaded from: classes6.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private BaseFragmentActivity cYb;
        private View cze;
        private int bgColor = R.color.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;
        private int mSkinType = 3;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.cYb = null;
            this.cYb = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View nZ() {
            this.mRoot = LayoutInflater.from(this.cYb.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.cze = this.mRoot.findViewById(R.id.pb_more_view);
            am.l(this.mRoot, this.bgColor);
            am.l(this.cze, this.bgColor);
            this.cze.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            jZ(TbadkCoreApplication.getInst().getSkinType());
            am.j(this.mTextView, R.color.common_color_10039);
            this.cze.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.g(this.cYb.getPageContext().getPageActivity(), R.dimen.ds120)));
            return this.mRoot;
        }

        public void jZ(int i) {
            this.cYb.getLayoutMode().onModeChanged(this.cze);
        }

        @SuppressLint({"ResourceAsColor"})
        public void iV(int i) {
            if (this.mSkinType != i) {
                am.j(this.mTextView, R.color.common_color_10039);
                am.h(this.mRoot, this.bgColor, i);
                am.h(this.cze, this.bgColor, i);
                this.mSkinType = i;
            }
        }

        public void biw() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.cYb.getPageContext().getPageActivity().getText(R.string.loading));
            this.cze.setVisibility(0);
        }

        public void cfC() {
            am.l(this.mRoot, R.color.cp_bg_line_c);
        }

        public void ql(boolean z) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.cze.setVisibility(0);
                    this.mTextView.setText(this.cYb.getResources().getString(R.string.list_no_more));
                    return;
                }
                this.cze.setVisibility(0);
                this.mTextView.setText(this.cYb.getResources().getString(R.string.load_more));
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
            if (this.iAD.mNoDataView != null) {
                this.iAD.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.iV(i);
            }
            if (this.iAF != null) {
                this.iAF.notifyDataSetChanged();
            }
            if (this.iAH != null) {
                this.iAH.iV(i);
            }
            am.l(this.iAD.iAN, R.color.cp_bg_line_d);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.iAD.mNoDataView != null) {
            this.iAD.mNoDataView.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.iAD.mNoDataView != null) {
            this.iAD.mNoDataView.aku();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        cfv();
        if (this.iAF != null) {
            this.iAF.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.iqj != null) {
            this.iqj.cancelLoadData();
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
            if (i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.iAF != null && this.iqj != null && v.Z(this.iqj.threadList) > 0) {
                int Z = v.Z(this.iqj.threadList);
                int i3 = 0;
                while (true) {
                    if (i3 >= Z) {
                        z = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) v.c(this.iqj.threadList, i3);
                    if ((mVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) mVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.threadId))) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (z && intent.getIntExtra("type", -1) == 0) {
                    v.d(this.iqj.threadList, i3);
                    this.iAF.notifyDataSetChanged();
                }
            }
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.fJN != null) {
                    this.fJN.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.post.PersonThreadFragment.6
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void aoN() {
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

    public void cfv() {
        if (!this.iAG) {
            this.iAD.iAN.startPullRefresh();
            this.iAG = true;
        }
    }

    public h cfw() {
        return this.iAD;
    }

    @Override // com.baidu.tieba.post.c
    public void cfq() {
        if (this.iAD != null && this.iAD.iAN != null) {
            this.iAD.iAN.startPullRefresh();
        }
    }

    public void a(d dVar) {
        this.iAA = dVar;
    }

    public void a(b bVar) {
        this.iAI = bVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
    public void a(PersonPostModel personPostModel, boolean z) {
        this.cyI = false;
        if (isAdded()) {
            this.iAD.iAN.completePullRefreshPostDelayed(0L);
            this.iAD.iAN.setEmptyView(null);
            if (personPostModel != null || this.iAz) {
                if (personPostModel == null || (personPostModel.threadList.size() == 0 && this.iAz && StringUtils.isNull(personPostModel.getErrorString()))) {
                    qk(true);
                    return;
                }
                if (personPostModel.threadList.size() == 0 && this.iAz) {
                    qk(true);
                } else {
                    qk(false);
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
                    this.iAy = 0;
                    this.iAz = false;
                }
                this.iAH.ql(this.mHasMore);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016221));
            }
        }
    }

    private void qk(boolean z) {
        this.iAD.iAN.removeHeaderView(this.iAD.mNoDataView);
        if (z) {
            this.iAD.mNoDataView.setVisibility(0);
            this.iAD.iAN.addHeaderView(this.iAD.mNoDataView);
            this.iAH.getView().setVisibility(8);
            return;
        }
        this.iAH.getView().setVisibility(0);
        this.iAH.cfC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfx() {
        TiebaStatic.log("c10491");
        cfz();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(1, this);
    }

    private void cfy() {
        cfz();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).b(this);
    }

    private void cfz() {
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(true, true, true, this);
    }

    public void cfA() {
        if (this.iqj != null) {
            this.iqj.fetchPost(getPageContext(), this, true, this.mUid, true, this.iAK, false, true);
            this.iAJ = true;
        }
    }

    public void cfB() {
        if (this.iqj != null) {
            this.iqj.fetchPost(getPageContext(), this, false, this.mUid, true, false, true);
        }
    }
}
