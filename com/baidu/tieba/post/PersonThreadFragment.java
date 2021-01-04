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
    private b mHA;
    private int mHC;
    private d mHr;
    private h mHv;
    private FrameLayout mHw;
    private com.baidu.tieba.post.a.a mHx;
    private boolean mHy;
    private a mHz;
    private com.baidu.tbadk.core.view.g mPullView;
    private String mUid;
    public PersonPostModel mww;
    private String mHu = "common";
    private boolean mHasMore = false;
    private boolean mHq = true;
    private boolean mHB = true;
    private boolean fKB = false;
    private CustomMessageListener mHD = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD) { // from class: com.baidu.tieba.post.PersonThreadFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && PersonThreadFragment.this.mHx != null) {
                PersonThreadFragment.this.mHx.Rb((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener mHE = new CustomMessageListener(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE) { // from class: com.baidu.tieba.post.PersonThreadFragment.2
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
                    PersonThreadFragment.this.dCL();
                    PersonThreadFragment.this.mHz.cCb();
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
        this.mww = new PersonPostModel(getPageContext(), getUniqueId(), this, true, PersonPostModel.FROM_PERSON_POST);
        this.mww.setUniqueId(getUniqueId());
        this.jBj = new ShareSuccessReplyToServerModel();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_thread_fragment, viewGroup, false);
        this.mHw = (FrameLayout) inflate.findViewById(R.id.root_view);
        this.mHv = new h(getActivity(), inflate);
        if (this.mHv.dCO() == null) {
            this.mHv.b(this.mHr);
        }
        if (this.mHv.mHH != null) {
            ao.setBackgroundColor(this.mHv.mHH, R.color.CAM_X0201);
        }
        String string2 = getArguments().getString("thread_type_key");
        if (!at.isEmpty(string2)) {
            this.mHu = string2;
        }
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(R.string.to_be_an_liver), new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonThreadFragment.this.dCH();
            }
        });
        int dimension = (int) getResources().getDimension(R.dimen.ds102);
        String str = "";
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, dimension);
        if (this.mHu.equals("photolive")) {
            int i = com.baidu.tbadk.core.sharedPref.b.bvq().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PHOTOLIVE_HOSTLEVEL, -1);
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
                dCI();
            }
        } else {
            string = getArguments().getString("key_empty_view_text");
            bVar = null;
        }
        this.mHv.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.dY(str, string), bVar);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.mHD);
        registerListener(this.mHE);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        if (this.mHu.equals("photolive")) {
            this.mHC = 33;
        }
        this.mHx = new com.baidu.tieba.post.a.a(getPageContext(), this.mHv.mHH);
        this.mHv.dCN().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                CardPersonDynamicThreadData cardPersonDynamicThreadData;
                if (i >= 0 && PersonThreadFragment.this.mHx != null && i < x.getCount(PersonThreadFragment.this.mww.threadList) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) PersonThreadFragment.this.mHx.muQ.getItem(i)) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PersonThreadFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.threadId), String.valueOf(cardPersonDynamicThreadData.postId), "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB).setThreadData(cardPersonDynamicThreadData.eMv)));
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.g(getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.post.PersonThreadFragment.5
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonThreadFragment.this.mww != null) {
                    PersonThreadFragment.this.mHq = true;
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        if (PersonThreadFragment.this.mHv != null) {
                            PersonThreadFragment.this.mHv.aR(PersonThreadFragment.this.getString(R.string.neterror), true);
                            return;
                        }
                        return;
                    }
                    PersonThreadFragment.this.dCK();
                }
            }
        });
        this.mHv.mHH.setPullRefresh(this.mPullView);
        if (TbadkCoreApplication.isMyLive) {
            this.jcm = BdListViewHelper.a(getActivity(), this.mHv.mHH, BdListViewHelper.HeadType.DEFAULT);
            BdListViewHelper.a(this.jcm, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        } else {
            this.jcm = BdListViewHelper.a(getActivity(), this.mHv.mHH, BdListViewHelper.HeadType.HASTAB);
            BdListViewHelper.a(this.jcm, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.mHv.mHH.setOnSrollToBottomListener(this);
        this.mHz = new a(getBaseFragmentActivity());
        this.mHv.mHH.setNextPage(this.mHz);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            dCL();
            this.mHz.cCb();
            this.fKB = true;
            return;
        }
        this.mHz.xh(false);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
    public void b(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null && this.mww != null) {
            if (z) {
                this.mww.threadList.clear();
            }
            ArrayList<n> arrayList = personPostModel.threadList;
            if (personPostModel.view_card_num > 0 && this.mHB) {
                x.add(arrayList, personPostModel.view_card_num - 1, new com.baidu.tieba.personPolymeric.c.j());
                this.mHB = false;
            }
            if (this.mww.threadList.isEmpty()) {
                n nVar = (n) x.getItem(arrayList, 0);
                if (nVar instanceof CardPersonDynamicThreadData) {
                    ((CardPersonDynamicThreadData) nVar).iAw = true;
                } else if (nVar instanceof com.baidu.tieba.personPolymeric.c.j) {
                    ((com.baidu.tieba.personPolymeric.c.j) nVar).iAw = true;
                }
            }
            this.mww.threadList.addAll(arrayList);
            PersonPostModel.mergeDynamicThreadByTime(this.mww.threadList);
        }
        if (this.mHA != null) {
            this.mHA.xe(personPostModel.isShowRecycleBinRedTip);
        }
        a(personPostModel, z);
        this.mHx.ab(this.mww.threadList);
        this.mHx.notifyDataSetChanged();
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

        public void cCb() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.gkF.getPageContext().getPageActivity().getText(R.string.loading));
            this.fKX.setVisibility(0);
        }

        public void dCM() {
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
            if (this.mHv.mNoDataView != null) {
                this.mHv.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.mHx != null) {
                this.mHx.notifyDataSetChanged();
            }
            if (this.mHz != null) {
                this.mHz.changeSkin(i);
            }
            ao.setBackgroundColor(this.mHv.mHH, R.color.CAM_X0201);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.mHv.mNoDataView != null) {
            this.mHv.mNoDataView.e(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.mHv.mNoDataView != null) {
            this.mHv.mNoDataView.bxw();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.mHx != null) {
            this.mHx.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        if (this.mww != null) {
            this.mww.cancelLoadData();
        }
        try {
            com.baidu.tbadk.e.a.aKs();
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
            if (i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.mHx != null && this.mww != null && x.getCount(this.mww.threadList) > 0) {
                int count = x.getCount(this.mww.threadList);
                int i3 = 0;
                while (true) {
                    if (i3 >= count) {
                        z = false;
                        break;
                    }
                    n nVar = (n) x.getItem(this.mww.threadList, i3);
                    if ((nVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) nVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.threadId))) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (z && intent.getIntExtra("type", -1) == 0) {
                    x.remove(this.mww.threadList, i3);
                    this.mHx.notifyDataSetChanged();
                }
            }
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.jBj != null) {
                    this.jBj.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.post.PersonThreadFragment.6
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void bCg() {
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
        if (!this.mHy) {
            this.mHv.mHH.startPullRefresh();
            this.mHy = true;
        }
    }

    public h dCG() {
        return this.mHv;
    }

    @Override // com.baidu.tieba.post.c
    public void dCB() {
        if (this.mHv != null && this.mHv.mHH != null) {
            this.mHv.mHH.startPullRefresh();
        }
    }

    public void a(d dVar) {
        this.mHr = dVar;
    }

    public void a(b bVar) {
        this.mHA = bVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
    public void a(PersonPostModel personPostModel, boolean z) {
        this.fKB = false;
        if (isAdded()) {
            this.mHv.mHH.completePullRefreshPostDelayed(0L);
            this.mHv.mHH.setEmptyView(null);
            if (personPostModel != null || this.mHq) {
                if (personPostModel == null || (personPostModel.threadList.size() == 0 && this.mHq && StringUtils.isNull(personPostModel.getErrorString()))) {
                    xg(true);
                    return;
                }
                if (personPostModel.threadList.size() == 0 && this.mHq) {
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
                    this.mHq = false;
                }
                this.mHz.xh(this.mHasMore);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MYLIVE_TAB_EDIT_ENABLE));
            }
        }
    }

    private void xg(boolean z) {
        this.mHv.mHH.removeHeaderView(this.mHv.mNoDataView);
        if (z) {
            this.mHv.mNoDataView.setVisibility(0);
            this.mHv.mHH.addHeaderView(this.mHv.mNoDataView);
            this.mHz.getView().setVisibility(8);
            return;
        }
        this.mHz.getView().setVisibility(0);
        this.mHz.dCM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCH() {
        TiebaStatic.log(TbadkCoreStatisticKey.MYLIVE_TO_BE_ANCHOR);
        dCJ();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(1, this);
    }

    private void dCI() {
        dCJ();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).b(this);
    }

    private void dCJ() {
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(true, true, true, this);
    }

    public void dCK() {
        if (this.mww != null) {
            this.mww.fetchPost(getPageContext(), this, true, this.mUid, true, this.mHC, false, true, null);
            this.mHB = true;
        }
    }

    public void dCL() {
        if (this.mww != null) {
            this.mww.fetchPost(getPageContext(), this, false, this.mUid, true, false, true, null);
        }
    }
}
