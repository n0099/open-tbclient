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
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
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
    private ShareSuccessReplyToServerModel fKT;
    private View frV;
    private d iBB;
    private h iBE;
    private FrameLayout iBF;
    private com.baidu.tieba.post.a.a iBG;
    private boolean iBH;
    private a iBI;
    private b iBJ;
    private int iBL;
    private int iBz;
    public PersonPostModel iqV;
    private com.baidu.tbadk.core.view.i mPullView;
    private String mUid;
    private String iBD = "common";
    private boolean mHasMore = false;
    private boolean iBA = true;
    private boolean iBK = true;
    private boolean cKn = false;
    private CustomMessageListener iqW = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD) { // from class: com.baidu.tieba.post.PersonThreadFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && PersonThreadFragment.this.iBG != null) {
                PersonThreadFragment.this.iBG.Cb((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener iqX = new CustomMessageListener(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE) { // from class: com.baidu.tieba.post.PersonThreadFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.adp.lib.util.l.showToast(PersonThreadFragment.this.getActivity(), (int) R.string.thread_has_hide);
            }
        }
    };
    private final CustomMessageListener bUR = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.post.PersonThreadFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && PersonThreadFragment.this.cKn) {
                    PersonThreadFragment.this.cdF();
                    PersonThreadFragment.this.iBI.bhf();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.a(PersonThreadFragment.this.frV, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
                } else {
                    BdListViewHelper.a(PersonThreadFragment.this.frV, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.bUR);
        this.iqV = new PersonPostModel(getPageContext(), getUniqueId(), this, true, PersonPostModel.FROM_PERSON_POST);
        this.iqV.setUniqueId(getUniqueId());
        this.fKT = new ShareSuccessReplyToServerModel();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_thread_fragment, viewGroup, false);
        this.iBF = (FrameLayout) inflate.findViewById(R.id.root_view);
        this.iBE = new h(getActivity(), inflate);
        if (this.iBE.cdI() == null) {
            this.iBE.b(this.iBB);
        }
        if (this.iBE.iBO != null) {
            am.setBackgroundColor(this.iBE.iBO, R.color.cp_bg_line_d);
        }
        String string2 = getArguments().getString("thread_type_key");
        if (!aq.isEmpty(string2)) {
            this.iBD = string2;
        }
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(R.string.to_be_an_liver), new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonThreadFragment.this.cdB();
            }
        });
        int dimension = (int) getResources().getDimension(R.dimen.ds102);
        String str = "";
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension);
        if (this.iBD.equals("photolive")) {
            int i = com.baidu.tbadk.core.sharedPref.b.alP().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PHOTOLIVE_HOSTLEVEL, -1);
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
                cdC();
            }
        } else {
            string = getArguments().getString("key_empty_view_text");
            bVar = null;
        }
        this.iBE.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.bU(string, str), bVar);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.iqW);
        registerListener(this.iqX);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        if (this.iBD.equals("photolive")) {
            this.iBL = 33;
        }
        this.iBG = new com.baidu.tieba.post.a.a(getPageContext(), this.iBE.iBO);
        this.iBE.cdH().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                CardPersonDynamicThreadData cardPersonDynamicThreadData;
                if (i >= 0 && PersonThreadFragment.this.iBG != null && i < v.getCount(PersonThreadFragment.this.iqV.threadList) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) PersonThreadFragment.this.iBG.ipG.getItem(i)) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PersonThreadFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.threadId), String.valueOf(cardPersonDynamicThreadData.postId), "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB)));
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.i(getPageContext());
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.post.PersonThreadFragment.5
            @Override // com.baidu.tbadk.core.view.h.c
            public void onListPullRefresh(boolean z) {
                if (PersonThreadFragment.this.iqV != null) {
                    PersonThreadFragment.this.iBA = true;
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        if (PersonThreadFragment.this.iBE != null) {
                            PersonThreadFragment.this.iBE.aj(PersonThreadFragment.this.getString(R.string.neterror), true);
                            return;
                        }
                        return;
                    }
                    PersonThreadFragment.this.cdE();
                }
            }
        });
        this.iBE.iBO.setPullRefresh(this.mPullView);
        if (TbadkCoreApplication.isMyLive) {
            this.frV = BdListViewHelper.a(getActivity(), this.iBE.iBO, BdListViewHelper.HeadType.DEFAULT);
            BdListViewHelper.a(this.frV, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        } else {
            this.frV = BdListViewHelper.a(getActivity(), this.iBE.iBO, BdListViewHelper.HeadType.HASTAB);
            BdListViewHelper.a(this.frV, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.iBE.iBO.setOnSrollToBottomListener(this);
        this.iBI = new a(getBaseFragmentActivity());
        this.iBE.iBO.setNextPage(this.iBI);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            cdF();
            this.iBI.bhf();
            this.cKn = true;
            return;
        }
        this.iBI.pW(false);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
    public void b(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null && this.iqV != null) {
            if (z) {
                this.iqV.threadList.clear();
            }
            ArrayList<com.baidu.adp.widget.ListView.m> arrayList = personPostModel.threadList;
            if (personPostModel.view_card_num > 0 && this.iBK) {
                v.add(arrayList, personPostModel.view_card_num - 1, new com.baidu.tieba.personPolymeric.c.j());
                this.iBK = false;
            }
            if (this.iqV.threadList.isEmpty()) {
                com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) v.getItem(arrayList, 0);
                if (mVar instanceof CardPersonDynamicThreadData) {
                    ((CardPersonDynamicThreadData) mVar).eQo = true;
                } else if (mVar instanceof com.baidu.tieba.personPolymeric.c.j) {
                    ((com.baidu.tieba.personPolymeric.c.j) mVar).eQo = true;
                }
            }
            this.iqV.threadList.addAll(arrayList);
            PersonPostModel.mergeDynamicThreadByTime(this.iqV.threadList);
        }
        if (this.iBJ != null) {
            this.iBJ.pT(personPostModel.isShowRecycleBinRedTip);
        }
        a(personPostModel, z);
        this.iBG.K(this.iqV.threadList);
        this.iBG.notifyDataSetChanged();
    }

    /* loaded from: classes6.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private View cKJ;
        private BaseFragmentActivity diB;
        private int bgColor = R.color.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;
        private int mSkinType = 3;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.diB = null;
            this.diB = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View createView() {
            this.mRoot = LayoutInflater.from(this.diB.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.cKJ = this.mRoot.findViewById(R.id.pb_more_view);
            am.setBackgroundColor(this.mRoot, this.bgColor);
            am.setBackgroundColor(this.cKJ, this.bgColor);
            this.cKJ.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            jz(TbadkCoreApplication.getInst().getSkinType());
            am.setViewTextColor(this.mTextView, (int) R.color.common_color_10039);
            this.cKJ.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.diB.getPageContext().getPageActivity(), R.dimen.ds120)));
            return this.mRoot;
        }

        public void jz(int i) {
            this.diB.getLayoutMode().onModeChanged(this.cKJ);
        }

        @SuppressLint({"ResourceAsColor"})
        public void changeSkin(int i) {
            if (this.mSkinType != i) {
                am.setViewTextColor(this.mTextView, (int) R.color.common_color_10039);
                am.setBackgroundColor(this.mRoot, this.bgColor, i);
                am.setBackgroundColor(this.cKJ, this.bgColor, i);
                this.mSkinType = i;
            }
        }

        public void bhf() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.diB.getPageContext().getPageActivity().getText(R.string.loading));
            this.cKJ.setVisibility(0);
        }

        public void cdG() {
            am.setBackgroundColor(this.mRoot, R.color.cp_bg_line_c);
        }

        public void pW(boolean z) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.cKJ.setVisibility(0);
                    this.mTextView.setText(this.diB.getResources().getString(R.string.list_no_more));
                    return;
                }
                this.cKJ.setVisibility(0);
                this.mTextView.setText(this.diB.getResources().getString(R.string.load_more));
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
            if (this.iBE.mNoDataView != null) {
                this.iBE.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.iBG != null) {
                this.iBG.notifyDataSetChanged();
            }
            if (this.iBI != null) {
                this.iBI.changeSkin(i);
            }
            am.setBackgroundColor(this.iBE.iBO, R.color.cp_bg_line_d);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.iBE.mNoDataView != null) {
            this.iBE.mNoDataView.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.iBE.mNoDataView != null) {
            this.iBE.mNoDataView.anE();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        cdz();
        if (this.iBG != null) {
            this.iBG.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.iqV != null) {
            this.iqV.cancelLoadData();
        }
        try {
            com.baidu.tbadk.e.a.Pg();
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
            if (i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.iBG != null && this.iqV != null && v.getCount(this.iqV.threadList) > 0) {
                int count = v.getCount(this.iqV.threadList);
                int i3 = 0;
                while (true) {
                    if (i3 >= count) {
                        z = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) v.getItem(this.iqV.threadList, i3);
                    if ((mVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) mVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.threadId))) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (z && intent.getIntExtra("type", -1) == 0) {
                    v.remove(this.iqV.threadList, i3);
                    this.iBG.notifyDataSetChanged();
                }
            }
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.fKT != null) {
                    this.fKT.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.post.PersonThreadFragment.6
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void arw() {
                        }

                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void a(final CustomDialogData customDialogData) {
                            com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.post.PersonThreadFragment.6.1
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

    public void cdz() {
        if (!this.iBH) {
            this.iBE.iBO.startPullRefresh();
            this.iBH = true;
        }
    }

    public h cdA() {
        return this.iBE;
    }

    @Override // com.baidu.tieba.post.c
    public void cdu() {
        if (this.iBE != null && this.iBE.iBO != null) {
            this.iBE.iBO.startPullRefresh();
        }
    }

    public void a(d dVar) {
        this.iBB = dVar;
    }

    public void a(b bVar) {
        this.iBJ = bVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
    public void a(PersonPostModel personPostModel, boolean z) {
        this.cKn = false;
        if (isAdded()) {
            this.iBE.iBO.completePullRefreshPostDelayed(0L);
            this.iBE.iBO.setEmptyView(null);
            if (personPostModel != null || this.iBA) {
                if (personPostModel == null || (personPostModel.threadList.size() == 0 && this.iBA && StringUtils.isNull(personPostModel.getErrorString()))) {
                    pV(true);
                    return;
                }
                if (personPostModel.threadList.size() == 0 && this.iBA) {
                    pV(true);
                } else {
                    pV(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(getActivity(), personPostModel.getErrorString());
                }
                this.mHasMore = !v.isEmpty(personPostModel.threadList);
                if (z) {
                    if (personPostModel.threadList.size() < 20) {
                        this.mHasMore = false;
                    } else {
                        this.mHasMore = true;
                    }
                    this.iBz = 0;
                    this.iBA = false;
                }
                this.iBI.pW(this.mHasMore);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MYLIVE_TAB_EDIT_ENABLE));
            }
        }
    }

    private void pV(boolean z) {
        this.iBE.iBO.removeHeaderView(this.iBE.mNoDataView);
        if (z) {
            this.iBE.mNoDataView.setVisibility(0);
            this.iBE.iBO.addHeaderView(this.iBE.mNoDataView);
            this.iBI.getView().setVisibility(8);
            return;
        }
        this.iBI.getView().setVisibility(0);
        this.iBI.cdG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdB() {
        TiebaStatic.log(TbadkCoreStatisticKey.MYLIVE_TO_BE_ANCHOR);
        cdD();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(1, this);
    }

    private void cdC() {
        cdD();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).b(this);
    }

    private void cdD() {
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(true, true, true, this);
    }

    public void cdE() {
        if (this.iqV != null) {
            this.iqV.fetchPost(getPageContext(), this, true, this.mUid, true, this.iBL, false, true);
            this.iBK = true;
        }
    }

    public void cdF() {
        if (this.iqV != null) {
            this.iqV.fetchPost(getPageContext(), this, false, this.mUid, true, false, true);
        }
    }
}
