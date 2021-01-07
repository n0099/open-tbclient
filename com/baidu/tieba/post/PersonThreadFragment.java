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
import com.baidu.adp.widget.ListView.n;
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
import com.baidu.tbadk.core.util.at;
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
/* loaded from: classes8.dex */
public class PersonThreadFragment extends BaseFragment implements BdListView.e, b.a, PersonPostModel.a, PersonPostModel.b, c {
    private int bhu;
    private ShareSuccessReplyToServerModel jBj;
    private View jcm;
    private int mHB;
    private d mHq;
    private h mHu;
    private FrameLayout mHv;
    private com.baidu.tieba.post.a.a mHw;
    private boolean mHx;
    private a mHy;
    private b mHz;
    private com.baidu.tbadk.core.view.g mPullView;
    private String mUid;
    public PersonPostModel mwv;
    private String mHt = "common";
    private boolean mHasMore = false;
    private boolean mHp = true;
    private boolean mHA = true;
    private boolean fKB = false;
    private CustomMessageListener mHC = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD) { // from class: com.baidu.tieba.post.PersonThreadFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && PersonThreadFragment.this.mHw != null) {
                PersonThreadFragment.this.mHw.Ra((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener mHD = new CustomMessageListener(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE) { // from class: com.baidu.tieba.post.PersonThreadFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.adp.lib.util.l.showToast(PersonThreadFragment.this.getActivity(), R.string.thread_has_hide);
            }
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.post.PersonThreadFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && PersonThreadFragment.this.fKB) {
                    PersonThreadFragment.this.dCM();
                    PersonThreadFragment.this.mHy.cCc();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.a(PersonThreadFragment.this.jcm, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
                } else {
                    BdListViewHelper.a(PersonThreadFragment.this.jcm, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.mNetworkChangedMessageListener);
        this.mwv = new PersonPostModel(getPageContext(), getUniqueId(), this, true, PersonPostModel.FROM_PERSON_POST);
        this.mwv.setUniqueId(getUniqueId());
        this.jBj = new ShareSuccessReplyToServerModel();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_thread_fragment, viewGroup, false);
        this.mHv = (FrameLayout) inflate.findViewById(R.id.root_view);
        this.mHu = new h(getActivity(), inflate);
        if (this.mHu.dCP() == null) {
            this.mHu.b(this.mHq);
        }
        if (this.mHu.mHG != null) {
            ao.setBackgroundColor(this.mHu.mHG, R.color.CAM_X0201);
        }
        String string2 = getArguments().getString("thread_type_key");
        if (!at.isEmpty(string2)) {
            this.mHt = string2;
        }
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(R.string.to_be_an_liver), new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonThreadFragment.this.dCI();
            }
        });
        int dimension = (int) getResources().getDimension(R.dimen.ds102);
        String str = "";
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, dimension);
        if (this.mHt.equals("photolive")) {
            int i = com.baidu.tbadk.core.sharedPref.b.bvr().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PHOTOLIVE_HOSTLEVEL, -1);
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
                dCJ();
            }
        } else {
            string = getArguments().getString("key_empty_view_text");
            bVar = null;
        }
        this.mHu.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.dY(str, string), bVar);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.mHC);
        registerListener(this.mHD);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        if (this.mHt.equals("photolive")) {
            this.mHB = 33;
        }
        this.mHw = new com.baidu.tieba.post.a.a(getPageContext(), this.mHu.mHG);
        this.mHu.dCO().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                CardPersonDynamicThreadData cardPersonDynamicThreadData;
                if (i >= 0 && PersonThreadFragment.this.mHw != null && i < x.getCount(PersonThreadFragment.this.mwv.threadList) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) PersonThreadFragment.this.mHw.muP.getItem(i)) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PersonThreadFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.threadId), String.valueOf(cardPersonDynamicThreadData.postId), "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB).setThreadData(cardPersonDynamicThreadData.eMv)));
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.g(getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.post.PersonThreadFragment.5
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonThreadFragment.this.mwv != null) {
                    PersonThreadFragment.this.mHp = true;
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        if (PersonThreadFragment.this.mHu != null) {
                            PersonThreadFragment.this.mHu.aR(PersonThreadFragment.this.getString(R.string.neterror), true);
                            return;
                        }
                        return;
                    }
                    PersonThreadFragment.this.dCL();
                }
            }
        });
        this.mHu.mHG.setPullRefresh(this.mPullView);
        if (TbadkCoreApplication.isMyLive) {
            this.jcm = BdListViewHelper.a(getActivity(), this.mHu.mHG, BdListViewHelper.HeadType.DEFAULT);
            BdListViewHelper.a(this.jcm, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        } else {
            this.jcm = BdListViewHelper.a(getActivity(), this.mHu.mHG, BdListViewHelper.HeadType.HASTAB);
            BdListViewHelper.a(this.jcm, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.mHu.mHG.setOnSrollToBottomListener(this);
        this.mHy = new a(getBaseFragmentActivity());
        this.mHu.mHG.setNextPage(this.mHy);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            dCM();
            this.mHy.cCc();
            this.fKB = true;
            return;
        }
        this.mHy.xh(false);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
    public void b(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null && this.mwv != null) {
            if (z) {
                this.mwv.threadList.clear();
            }
            ArrayList<n> arrayList = personPostModel.threadList;
            if (personPostModel.view_card_num > 0 && this.mHA) {
                x.add(arrayList, personPostModel.view_card_num - 1, new com.baidu.tieba.personPolymeric.c.j());
                this.mHA = false;
            }
            if (this.mwv.threadList.isEmpty()) {
                n nVar = (n) x.getItem(arrayList, 0);
                if (nVar instanceof CardPersonDynamicThreadData) {
                    ((CardPersonDynamicThreadData) nVar).iAw = true;
                } else if (nVar instanceof com.baidu.tieba.personPolymeric.c.j) {
                    ((com.baidu.tieba.personPolymeric.c.j) nVar).iAw = true;
                }
            }
            this.mwv.threadList.addAll(arrayList);
            PersonPostModel.mergeDynamicThreadByTime(this.mwv.threadList);
        }
        if (this.mHz != null) {
            this.mHz.xe(personPostModel.isShowRecycleBinRedTip);
        }
        a(personPostModel, z);
        this.mHw.ab(this.mwv.threadList);
        this.mHw.notifyDataSetChanged();
    }

    /* loaded from: classes8.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private View fKX;
        private BaseFragmentActivity gkF;
        private int bgColor = R.color.CAM_X0201;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;
        private int mSkinType = 3;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.gkF = null;
            this.gkF = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View createView() {
            this.mRoot = LayoutInflater.from(this.gkF.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.fKX = this.mRoot.findViewById(R.id.pb_more_view);
            ao.setBackgroundColor(this.mRoot, this.bgColor);
            ao.setBackgroundColor(this.fKX, this.bgColor);
            this.fKX.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            sk(TbadkCoreApplication.getInst().getSkinType());
            ao.setViewTextColor(this.mTextView, R.color.common_color_10039);
            this.fKX.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.gkF.getPageContext().getPageActivity(), R.dimen.ds120)));
            return this.mRoot;
        }

        public void sk(int i) {
            this.gkF.getLayoutMode().onModeChanged(this.fKX);
        }

        @SuppressLint({"ResourceAsColor"})
        public void changeSkin(int i) {
            if (this.mSkinType != i) {
                ao.setViewTextColor(this.mTextView, R.color.common_color_10039);
                ao.setBackgroundColor(this.mRoot, this.bgColor, i);
                ao.setBackgroundColor(this.fKX, this.bgColor, i);
                this.mSkinType = i;
            }
        }

        public void cCc() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.gkF.getPageContext().getPageActivity().getText(R.string.loading));
            this.fKX.setVisibility(0);
        }

        public void dCN() {
            ao.setBackgroundColor(this.mRoot, R.color.CAM_X0204);
        }

        public void xh(boolean z) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.fKX.setVisibility(0);
                    this.mTextView.setText(this.gkF.getResources().getString(R.string.list_no_more));
                    return;
                }
                this.fKX.setVisibility(0);
                this.mTextView.setText(this.gkF.getResources().getString(R.string.load_more));
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
            if (this.mHu.mNoDataView != null) {
                this.mHu.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.mHw != null) {
                this.mHw.notifyDataSetChanged();
            }
            if (this.mHy != null) {
                this.mHy.changeSkin(i);
            }
            ao.setBackgroundColor(this.mHu.mHG, R.color.CAM_X0201);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.mHu.mNoDataView != null) {
            this.mHu.mNoDataView.e(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.mHu.mNoDataView != null) {
            this.mHu.mNoDataView.bxx();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.mHw != null) {
            this.mHw.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        if (this.mwv != null) {
            this.mwv.cancelLoadData();
        }
        try {
            com.baidu.tbadk.e.a.aKt();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        BdAsyncTask.removeAllTask(SetPrivacyModel.UNIQUE_ID_SET_PRIVACY_TASK);
        BdAsyncTask.removeAllTask(ForumManageModel.UNIQUE_ID_DEL_POST_TASK);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        ShareItem shareItem;
        String stringExtra;
        boolean z;
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.mHw != null && this.mwv != null && x.getCount(this.mwv.threadList) > 0) {
                int count = x.getCount(this.mwv.threadList);
                int i3 = 0;
                while (true) {
                    if (i3 >= count) {
                        z = false;
                        break;
                    }
                    n nVar = (n) x.getItem(this.mwv.threadList, i3);
                    if ((nVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) nVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.threadId))) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (z && intent.getIntExtra("type", -1) == 0) {
                    x.remove(this.mwv.threadList, i3);
                    this.mHw.notifyDataSetChanged();
                }
            }
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.jBj != null) {
                    this.jBj.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.post.PersonThreadFragment.6
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void bCh() {
                        }

                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void a(final CustomDialogData customDialogData) {
                            com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.post.PersonThreadFragment.6.1
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
        if (!this.mHx) {
            this.mHu.mHG.startPullRefresh();
            this.mHx = true;
        }
    }

    public h dCH() {
        return this.mHu;
    }

    @Override // com.baidu.tieba.post.c
    public void dCC() {
        if (this.mHu != null && this.mHu.mHG != null) {
            this.mHu.mHG.startPullRefresh();
        }
    }

    public void a(d dVar) {
        this.mHq = dVar;
    }

    public void a(b bVar) {
        this.mHz = bVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
    public void a(PersonPostModel personPostModel, boolean z) {
        this.fKB = false;
        if (isAdded()) {
            this.mHu.mHG.completePullRefreshPostDelayed(0L);
            this.mHu.mHG.setEmptyView(null);
            if (personPostModel != null || this.mHp) {
                if (personPostModel == null || (personPostModel.threadList.size() == 0 && this.mHp && StringUtils.isNull(personPostModel.getErrorString()))) {
                    xg(true);
                    return;
                }
                if (personPostModel.threadList.size() == 0 && this.mHp) {
                    xg(true);
                } else {
                    xg(false);
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
                    this.bhu = 0;
                    this.mHp = false;
                }
                this.mHy.xh(this.mHasMore);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MYLIVE_TAB_EDIT_ENABLE));
            }
        }
    }

    private void xg(boolean z) {
        this.mHu.mHG.removeHeaderView(this.mHu.mNoDataView);
        if (z) {
            this.mHu.mNoDataView.setVisibility(0);
            this.mHu.mHG.addHeaderView(this.mHu.mNoDataView);
            this.mHy.getView().setVisibility(8);
            return;
        }
        this.mHy.getView().setVisibility(0);
        this.mHy.dCN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCI() {
        TiebaStatic.log(TbadkCoreStatisticKey.MYLIVE_TO_BE_ANCHOR);
        dCK();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(1, this);
    }

    private void dCJ() {
        dCK();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).b(this);
    }

    private void dCK() {
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(true, true, true, this);
    }

    public void dCL() {
        if (this.mwv != null) {
            this.mwv.fetchPost(getPageContext(), this, true, this.mUid, true, this.mHB, false, true, null);
            this.mHA = true;
        }
    }

    public void dCM() {
        if (this.mwv != null) {
            this.mwv.fetchPost(getPageContext(), this, false, this.mUid, true, false, true, null);
        }
    }
}
