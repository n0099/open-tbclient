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
import com.baidu.adp.widget.ListView.q;
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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.e.b;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import java.util.ArrayList;
/* loaded from: classes18.dex */
public class PersonThreadFragment extends BaseFragment implements BdListView.e, b.a, PersonPostModel.a, PersonPostModel.b, c {
    private int aPN;
    private View hCD;
    private ShareSuccessReplyToServerModel hXM;
    public PersonPostModel kWa;
    private b lgA;
    private int lgC;
    private d lgs;
    private h lgv;
    private FrameLayout lgw;
    private com.baidu.tieba.post.a.a lgx;
    private boolean lgy;
    private a lgz;
    private com.baidu.tbadk.core.view.g mPullView;
    private String mUid;
    private String lgu = "common";
    private boolean mHasMore = false;
    private boolean lgr = true;
    private boolean lgB = true;
    private boolean eFX = false;
    private CustomMessageListener lgD = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD) { // from class: com.baidu.tieba.post.PersonThreadFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && PersonThreadFragment.this.lgx != null) {
                PersonThreadFragment.this.lgx.LS((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener lgE = new CustomMessageListener(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE) { // from class: com.baidu.tieba.post.PersonThreadFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.adp.lib.util.l.showToast(PersonThreadFragment.this.getActivity(), R.string.thread_has_hide);
            }
        }
    };
    private final CustomMessageListener dLm = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.post.PersonThreadFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && PersonThreadFragment.this.eFX) {
                    PersonThreadFragment.this.cZW();
                    PersonThreadFragment.this.lgz.bYz();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.a(PersonThreadFragment.this.hCD, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
                } else {
                    BdListViewHelper.a(PersonThreadFragment.this.hCD, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.dLm);
        this.kWa = new PersonPostModel(getPageContext(), getUniqueId(), this, true, PersonPostModel.FROM_PERSON_POST);
        this.kWa.setUniqueId(getUniqueId());
        this.hXM = new ShareSuccessReplyToServerModel();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_thread_fragment, viewGroup, false);
        this.lgw = (FrameLayout) inflate.findViewById(R.id.root_view);
        this.lgv = new h(getActivity(), inflate);
        if (this.lgv.cZZ() == null) {
            this.lgv.b(this.lgs);
        }
        if (this.lgv.lgH != null) {
            ao.setBackgroundColor(this.lgv.lgH, R.color.cp_bg_line_d);
        }
        String string2 = getArguments().getString("thread_type_key");
        if (!as.isEmpty(string2)) {
            this.lgu = string2;
        }
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(R.string.to_be_an_liver), new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonThreadFragment.this.cZS();
            }
        });
        int dimension = (int) getResources().getDimension(R.dimen.ds102);
        String str = "";
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, dimension);
        if (this.lgu.equals("photolive")) {
            int i = com.baidu.tbadk.core.sharedPref.b.aZP().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PHOTOLIVE_HOSTLEVEL, -1);
            if (i == 0) {
                string = getPageContext().getResources().getString(R.string.to_live_to_god);
                str = getPageContext().getResources().getString(R.string.user_not_liver);
                a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_06, dimension, -1, -1);
                bVar = NoDataViewFactory.b.a(aVar);
            } else {
                string = getPageContext().getResources().getString(R.string.person_post_lv_empty_host);
                bVar = null;
            }
            if (i < 0) {
                cZT();
            }
        } else {
            string = getArguments().getString("key_empty_view_text");
            bVar = null;
        }
        this.lgv.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.m31do(str, string), bVar);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.lgD);
        registerListener(this.lgE);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        if (this.lgu.equals("photolive")) {
            this.lgC = 33;
        }
        this.lgx = new com.baidu.tieba.post.a.a(getPageContext(), this.lgv.lgH);
        this.lgv.cZY().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                CardPersonDynamicThreadData cardPersonDynamicThreadData;
                if (i >= 0 && PersonThreadFragment.this.lgx != null && i < x.getCount(PersonThreadFragment.this.kWa.threadList) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) PersonThreadFragment.this.lgx.kUv.getItem(i)) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PersonThreadFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.threadId), String.valueOf(cardPersonDynamicThreadData.postId), "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB).setThreadData(cardPersonDynamicThreadData.dLK)));
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.g(getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.post.PersonThreadFragment.5
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonThreadFragment.this.kWa != null) {
                    PersonThreadFragment.this.lgr = true;
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        if (PersonThreadFragment.this.lgv != null) {
                            PersonThreadFragment.this.lgv.aG(PersonThreadFragment.this.getString(R.string.neterror), true);
                            return;
                        }
                        return;
                    }
                    PersonThreadFragment.this.cZV();
                }
            }
        });
        this.lgv.lgH.setPullRefresh(this.mPullView);
        if (TbadkCoreApplication.isMyLive) {
            this.hCD = BdListViewHelper.a(getActivity(), this.lgv.lgH, BdListViewHelper.HeadType.DEFAULT);
            BdListViewHelper.a(this.hCD, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        } else {
            this.hCD = BdListViewHelper.a(getActivity(), this.lgv.lgH, BdListViewHelper.HeadType.HASTAB);
            BdListViewHelper.a(this.hCD, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.lgv.lgH.setOnSrollToBottomListener(this);
        this.lgz = new a(getBaseFragmentActivity());
        this.lgv.lgH.setNextPage(this.lgz);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            cZW();
            this.lgz.bYz();
            this.eFX = true;
            return;
        }
        this.lgz.uw(false);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
    public void b(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null && this.kWa != null) {
            if (z) {
                this.kWa.threadList.clear();
            }
            ArrayList<q> arrayList = personPostModel.threadList;
            if (personPostModel.view_card_num > 0 && this.lgB) {
                x.add(arrayList, personPostModel.view_card_num - 1, new com.baidu.tieba.personPolymeric.c.j());
                this.lgB = false;
            }
            if (this.kWa.threadList.isEmpty()) {
                q qVar = (q) x.getItem(arrayList, 0);
                if (qVar instanceof CardPersonDynamicThreadData) {
                    ((CardPersonDynamicThreadData) qVar).haZ = true;
                } else if (qVar instanceof com.baidu.tieba.personPolymeric.c.j) {
                    ((com.baidu.tieba.personPolymeric.c.j) qVar).haZ = true;
                }
            }
            this.kWa.threadList.addAll(arrayList);
            PersonPostModel.mergeDynamicThreadByTime(this.kWa.threadList);
        }
        if (this.lgA != null) {
            this.lgA.ut(personPostModel.isShowRecycleBinRedTip);
        }
        a(personPostModel, z);
        this.lgx.U(this.kWa.threadList);
        this.lgx.notifyDataSetChanged();
    }

    /* loaded from: classes18.dex */
    public static class a extends com.baidu.adp.widget.ListView.c {
        private View eGt;
        private BaseFragmentActivity feq;
        private int bgColor = R.color.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;
        private int mSkinType = 3;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.feq = null;
            this.feq = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.c
        public View createView() {
            this.mRoot = LayoutInflater.from(this.feq.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.eGt = this.mRoot.findViewById(R.id.pb_more_view);
            ao.setBackgroundColor(this.mRoot, this.bgColor);
            ao.setBackgroundColor(this.eGt, this.bgColor);
            this.eGt.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            nI(TbadkCoreApplication.getInst().getSkinType());
            ao.setViewTextColor(this.mTextView, R.color.common_color_10039);
            this.eGt.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.feq.getPageContext().getPageActivity(), R.dimen.ds120)));
            return this.mRoot;
        }

        public void nI(int i) {
            this.feq.getLayoutMode().onModeChanged(this.eGt);
        }

        @SuppressLint({"ResourceAsColor"})
        public void changeSkin(int i) {
            if (this.mSkinType != i) {
                ao.setViewTextColor(this.mTextView, R.color.common_color_10039);
                ao.setBackgroundColor(this.mRoot, this.bgColor, i);
                ao.setBackgroundColor(this.eGt, this.bgColor, i);
                this.mSkinType = i;
            }
        }

        public void bYz() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.feq.getPageContext().getPageActivity().getText(R.string.loading));
            this.eGt.setVisibility(0);
        }

        public void cZX() {
            ao.setBackgroundColor(this.mRoot, R.color.cp_bg_line_c);
        }

        public void uw(boolean z) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.eGt.setVisibility(0);
                    this.mTextView.setText(this.feq.getResources().getString(R.string.list_no_more));
                    return;
                }
                this.eGt.setVisibility(0);
                this.mTextView.setText(this.feq.getResources().getString(R.string.load_more));
            }
        }

        @Override // com.baidu.adp.widget.ListView.c
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
            if (this.lgv.mNoDataView != null) {
                this.lgv.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.lgx != null) {
                this.lgx.notifyDataSetChanged();
            }
            if (this.lgz != null) {
                this.lgz.changeSkin(i);
            }
            ao.setBackgroundColor(this.lgv.lgH, R.color.cp_bg_line_d);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.lgv.mNoDataView != null) {
            this.lgv.mNoDataView.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.lgv.mNoDataView != null) {
            this.lgv.mNoDataView.bbU();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.lgx != null) {
            this.lgx.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.kWa != null) {
            this.kWa.cancelLoadData();
        }
        try {
            com.baidu.tbadk.e.a.resetAll();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        BdAsyncTask.removeAllTask(SetPrivacyModel.UNIQUE_ID_SET_PRIVACY_TASK);
        BdAsyncTask.removeAllTask(ForumManageModel.UNIQUE_ID_DEL_POST_TASK);
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        ShareItem shareItem;
        String stringExtra;
        boolean z;
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.lgx != null && this.kWa != null && x.getCount(this.kWa.threadList) > 0) {
                int count = x.getCount(this.kWa.threadList);
                int i3 = 0;
                while (true) {
                    if (i3 >= count) {
                        z = false;
                        break;
                    }
                    q qVar = (q) x.getItem(this.kWa.threadList, i3);
                    if ((qVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) qVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.threadId))) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (z && intent.getIntExtra("type", -1) == 0) {
                    x.remove(this.kWa.threadList, i3);
                    this.lgx.notifyDataSetChanged();
                }
            }
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.hXM != null) {
                    this.hXM.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.post.PersonThreadFragment.6
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void bgn() {
                        }

                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void a(final CustomDialogData customDialogData) {
                            com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.post.PersonThreadFragment.6.1
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
        if (!this.lgy) {
            this.lgv.lgH.startPullRefresh();
            this.lgy = true;
        }
    }

    public h cZR() {
        return this.lgv;
    }

    @Override // com.baidu.tieba.post.c
    public void cZM() {
        if (this.lgv != null && this.lgv.lgH != null) {
            this.lgv.lgH.startPullRefresh();
        }
    }

    public void a(d dVar) {
        this.lgs = dVar;
    }

    public void a(b bVar) {
        this.lgA = bVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
    public void a(PersonPostModel personPostModel, boolean z) {
        this.eFX = false;
        if (isAdded()) {
            this.lgv.lgH.completePullRefreshPostDelayed(0L);
            this.lgv.lgH.setEmptyView(null);
            if (personPostModel != null || this.lgr) {
                if (personPostModel == null || (personPostModel.threadList.size() == 0 && this.lgr && StringUtils.isNull(personPostModel.getErrorString()))) {
                    uv(true);
                    return;
                }
                if (personPostModel.threadList.size() == 0 && this.lgr) {
                    uv(true);
                } else {
                    uv(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(getActivity(), personPostModel.getErrorString());
                }
                this.mHasMore = !x.isEmpty(personPostModel.threadList);
                if (z) {
                    if (personPostModel.threadList.size() < 20) {
                        this.mHasMore = false;
                    } else {
                        this.mHasMore = true;
                    }
                    this.aPN = 0;
                    this.lgr = false;
                }
                this.lgz.uw(this.mHasMore);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MYLIVE_TAB_EDIT_ENABLE));
            }
        }
    }

    private void uv(boolean z) {
        this.lgv.lgH.removeHeaderView(this.lgv.mNoDataView);
        if (z) {
            this.lgv.mNoDataView.setVisibility(0);
            this.lgv.lgH.addHeaderView(this.lgv.mNoDataView);
            this.lgz.getView().setVisibility(8);
            return;
        }
        this.lgz.getView().setVisibility(0);
        this.lgz.cZX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZS() {
        TiebaStatic.log(TbadkCoreStatisticKey.MYLIVE_TO_BE_ANCHOR);
        cZU();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(1, this);
    }

    private void cZT() {
        cZU();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).b(this);
    }

    private void cZU() {
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(true, true, true, this);
    }

    public void cZV() {
        if (this.kWa != null) {
            this.kWa.fetchPost(getPageContext(), this, true, this.mUid, true, this.lgC, false, true, null);
            this.lgB = true;
        }
    }

    public void cZW() {
        if (this.kWa != null) {
            this.kWa.fetchPost(getPageContext(), this, false, this.mUid, true, false, true, null);
        }
    }
}
