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
    private ShareSuccessReplyToServerModel fLK;
    private View fsM;
    private b iCA;
    private int iCC;
    private int iCq;
    private d iCs;
    private h iCv;
    private FrameLayout iCw;
    private com.baidu.tieba.post.a.a iCx;
    private boolean iCy;
    private a iCz;
    public PersonPostModel irM;
    private com.baidu.tbadk.core.view.i mPullView;
    private String mUid;
    private String iCu = "common";
    private boolean mHasMore = false;
    private boolean iCr = true;
    private boolean iCB = true;
    private boolean cLe = false;
    private CustomMessageListener irN = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD) { // from class: com.baidu.tieba.post.PersonThreadFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && PersonThreadFragment.this.iCx != null) {
                PersonThreadFragment.this.iCx.Cb((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener irO = new CustomMessageListener(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE) { // from class: com.baidu.tieba.post.PersonThreadFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.adp.lib.util.l.showToast(PersonThreadFragment.this.getActivity(), (int) R.string.thread_has_hide);
            }
        }
    };
    private final CustomMessageListener bVI = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.post.PersonThreadFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && PersonThreadFragment.this.cLe) {
                    PersonThreadFragment.this.cdH();
                    PersonThreadFragment.this.iCz.bhh();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.a(PersonThreadFragment.this.fsM, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
                } else {
                    BdListViewHelper.a(PersonThreadFragment.this.fsM, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.bVI);
        this.irM = new PersonPostModel(getPageContext(), getUniqueId(), this, true, PersonPostModel.FROM_PERSON_POST);
        this.irM.setUniqueId(getUniqueId());
        this.fLK = new ShareSuccessReplyToServerModel();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_thread_fragment, viewGroup, false);
        this.iCw = (FrameLayout) inflate.findViewById(R.id.root_view);
        this.iCv = new h(getActivity(), inflate);
        if (this.iCv.cdK() == null) {
            this.iCv.b(this.iCs);
        }
        if (this.iCv.iCF != null) {
            am.setBackgroundColor(this.iCv.iCF, R.color.cp_bg_line_d);
        }
        String string2 = getArguments().getString("thread_type_key");
        if (!aq.isEmpty(string2)) {
            this.iCu = string2;
        }
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(R.string.to_be_an_liver), new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonThreadFragment.this.cdD();
            }
        });
        int dimension = (int) getResources().getDimension(R.dimen.ds102);
        String str = "";
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension);
        if (this.iCu.equals("photolive")) {
            int i = com.baidu.tbadk.core.sharedPref.b.alR().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PHOTOLIVE_HOSTLEVEL, -1);
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
                cdE();
            }
        } else {
            string = getArguments().getString("key_empty_view_text");
            bVar = null;
        }
        this.iCv.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.bU(string, str), bVar);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.irN);
        registerListener(this.irO);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        if (this.iCu.equals("photolive")) {
            this.iCC = 33;
        }
        this.iCx = new com.baidu.tieba.post.a.a(getPageContext(), this.iCv.iCF);
        this.iCv.cdJ().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                CardPersonDynamicThreadData cardPersonDynamicThreadData;
                if (i >= 0 && PersonThreadFragment.this.iCx != null && i < v.getCount(PersonThreadFragment.this.irM.threadList) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) PersonThreadFragment.this.iCx.iqx.getItem(i)) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PersonThreadFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.threadId), String.valueOf(cardPersonDynamicThreadData.postId), "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB)));
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.i(getPageContext());
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.post.PersonThreadFragment.5
            @Override // com.baidu.tbadk.core.view.h.c
            public void onListPullRefresh(boolean z) {
                if (PersonThreadFragment.this.irM != null) {
                    PersonThreadFragment.this.iCr = true;
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        if (PersonThreadFragment.this.iCv != null) {
                            PersonThreadFragment.this.iCv.aj(PersonThreadFragment.this.getString(R.string.neterror), true);
                            return;
                        }
                        return;
                    }
                    PersonThreadFragment.this.cdG();
                }
            }
        });
        this.iCv.iCF.setPullRefresh(this.mPullView);
        if (TbadkCoreApplication.isMyLive) {
            this.fsM = BdListViewHelper.a(getActivity(), this.iCv.iCF, BdListViewHelper.HeadType.DEFAULT);
            BdListViewHelper.a(this.fsM, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        } else {
            this.fsM = BdListViewHelper.a(getActivity(), this.iCv.iCF, BdListViewHelper.HeadType.HASTAB);
            BdListViewHelper.a(this.fsM, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.iCv.iCF.setOnSrollToBottomListener(this);
        this.iCz = new a(getBaseFragmentActivity());
        this.iCv.iCF.setNextPage(this.iCz);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            cdH();
            this.iCz.bhh();
            this.cLe = true;
            return;
        }
        this.iCz.pW(false);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
    public void b(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null && this.irM != null) {
            if (z) {
                this.irM.threadList.clear();
            }
            ArrayList<com.baidu.adp.widget.ListView.m> arrayList = personPostModel.threadList;
            if (personPostModel.view_card_num > 0 && this.iCB) {
                v.add(arrayList, personPostModel.view_card_num - 1, new com.baidu.tieba.personPolymeric.c.j());
                this.iCB = false;
            }
            if (this.irM.threadList.isEmpty()) {
                com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) v.getItem(arrayList, 0);
                if (mVar instanceof CardPersonDynamicThreadData) {
                    ((CardPersonDynamicThreadData) mVar).eRf = true;
                } else if (mVar instanceof com.baidu.tieba.personPolymeric.c.j) {
                    ((com.baidu.tieba.personPolymeric.c.j) mVar).eRf = true;
                }
            }
            this.irM.threadList.addAll(arrayList);
            PersonPostModel.mergeDynamicThreadByTime(this.irM.threadList);
        }
        if (this.iCA != null) {
            this.iCA.pT(personPostModel.isShowRecycleBinRedTip);
        }
        a(personPostModel, z);
        this.iCx.K(this.irM.threadList);
        this.iCx.notifyDataSetChanged();
    }

    /* loaded from: classes6.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private View cLA;
        private BaseFragmentActivity djs;
        private int bgColor = R.color.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;
        private int mSkinType = 3;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.djs = null;
            this.djs = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View createView() {
            this.mRoot = LayoutInflater.from(this.djs.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.cLA = this.mRoot.findViewById(R.id.pb_more_view);
            am.setBackgroundColor(this.mRoot, this.bgColor);
            am.setBackgroundColor(this.cLA, this.bgColor);
            this.cLA.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            jA(TbadkCoreApplication.getInst().getSkinType());
            am.setViewTextColor(this.mTextView, (int) R.color.common_color_10039);
            this.cLA.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.djs.getPageContext().getPageActivity(), R.dimen.ds120)));
            return this.mRoot;
        }

        public void jA(int i) {
            this.djs.getLayoutMode().onModeChanged(this.cLA);
        }

        @SuppressLint({"ResourceAsColor"})
        public void changeSkin(int i) {
            if (this.mSkinType != i) {
                am.setViewTextColor(this.mTextView, (int) R.color.common_color_10039);
                am.setBackgroundColor(this.mRoot, this.bgColor, i);
                am.setBackgroundColor(this.cLA, this.bgColor, i);
                this.mSkinType = i;
            }
        }

        public void bhh() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.djs.getPageContext().getPageActivity().getText(R.string.loading));
            this.cLA.setVisibility(0);
        }

        public void cdI() {
            am.setBackgroundColor(this.mRoot, R.color.cp_bg_line_c);
        }

        public void pW(boolean z) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.cLA.setVisibility(0);
                    this.mTextView.setText(this.djs.getResources().getString(R.string.list_no_more));
                    return;
                }
                this.cLA.setVisibility(0);
                this.mTextView.setText(this.djs.getResources().getString(R.string.load_more));
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
            if (this.iCv.mNoDataView != null) {
                this.iCv.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.iCx != null) {
                this.iCx.notifyDataSetChanged();
            }
            if (this.iCz != null) {
                this.iCz.changeSkin(i);
            }
            am.setBackgroundColor(this.iCv.iCF, R.color.cp_bg_line_d);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.iCv.mNoDataView != null) {
            this.iCv.mNoDataView.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.iCv.mNoDataView != null) {
            this.iCv.mNoDataView.anG();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        cdB();
        if (this.iCx != null) {
            this.iCx.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.irM != null) {
            this.irM.cancelLoadData();
        }
        try {
            com.baidu.tbadk.e.a.Pf();
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
            if (i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.iCx != null && this.irM != null && v.getCount(this.irM.threadList) > 0) {
                int count = v.getCount(this.irM.threadList);
                int i3 = 0;
                while (true) {
                    if (i3 >= count) {
                        z = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) v.getItem(this.irM.threadList, i3);
                    if ((mVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) mVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.threadId))) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (z && intent.getIntExtra("type", -1) == 0) {
                    v.remove(this.irM.threadList, i3);
                    this.iCx.notifyDataSetChanged();
                }
            }
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.fLK != null) {
                    this.fLK.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.post.PersonThreadFragment.6
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void ary() {
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

    public void cdB() {
        if (!this.iCy) {
            this.iCv.iCF.startPullRefresh();
            this.iCy = true;
        }
    }

    public h cdC() {
        return this.iCv;
    }

    @Override // com.baidu.tieba.post.c
    public void cdw() {
        if (this.iCv != null && this.iCv.iCF != null) {
            this.iCv.iCF.startPullRefresh();
        }
    }

    public void a(d dVar) {
        this.iCs = dVar;
    }

    public void a(b bVar) {
        this.iCA = bVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
    public void a(PersonPostModel personPostModel, boolean z) {
        this.cLe = false;
        if (isAdded()) {
            this.iCv.iCF.completePullRefreshPostDelayed(0L);
            this.iCv.iCF.setEmptyView(null);
            if (personPostModel != null || this.iCr) {
                if (personPostModel == null || (personPostModel.threadList.size() == 0 && this.iCr && StringUtils.isNull(personPostModel.getErrorString()))) {
                    pV(true);
                    return;
                }
                if (personPostModel.threadList.size() == 0 && this.iCr) {
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
                    this.iCq = 0;
                    this.iCr = false;
                }
                this.iCz.pW(this.mHasMore);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MYLIVE_TAB_EDIT_ENABLE));
            }
        }
    }

    private void pV(boolean z) {
        this.iCv.iCF.removeHeaderView(this.iCv.mNoDataView);
        if (z) {
            this.iCv.mNoDataView.setVisibility(0);
            this.iCv.iCF.addHeaderView(this.iCv.mNoDataView);
            this.iCz.getView().setVisibility(8);
            return;
        }
        this.iCz.getView().setVisibility(0);
        this.iCz.cdI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdD() {
        TiebaStatic.log(TbadkCoreStatisticKey.MYLIVE_TO_BE_ANCHOR);
        cdF();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(1, this);
    }

    private void cdE() {
        cdF();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).b(this);
    }

    private void cdF() {
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(true, true, true, this);
    }

    public void cdG() {
        if (this.irM != null) {
            this.irM.fetchPost(getPageContext(), this, true, this.mUid, true, this.iCC, false, true);
            this.iCB = true;
        }
    }

    public void cdH() {
        if (this.irM != null) {
            this.irM.fetchPost(getPageContext(), this, false, this.mUid, true, false, true);
        }
    }
}
