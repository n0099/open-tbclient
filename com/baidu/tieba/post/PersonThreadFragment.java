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
/* loaded from: classes7.dex */
public class PersonThreadFragment extends BaseFragment implements BdListView.e, b.a, PersonPostModel.a, PersonPostModel.b, c {
    private int bcD;
    private View iXF;
    private ShareSuccessReplyToServerModel jwD;
    private d mCI;
    private h mCM;
    private FrameLayout mCN;
    private com.baidu.tieba.post.a.a mCO;
    private boolean mCP;
    private a mCQ;
    private b mCR;
    private int mCT;
    private com.baidu.tbadk.core.view.g mPullView;
    private String mUid;
    public PersonPostModel mrQ;
    private String mCL = "common";
    private boolean mHasMore = false;
    private boolean mCH = true;
    private boolean mCS = true;
    private boolean fFU = false;
    private CustomMessageListener mCU = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD) { // from class: com.baidu.tieba.post.PersonThreadFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && PersonThreadFragment.this.mCO != null) {
                PersonThreadFragment.this.mCO.PS((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener mCV = new CustomMessageListener(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE) { // from class: com.baidu.tieba.post.PersonThreadFragment.2
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
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && PersonThreadFragment.this.fFU) {
                    PersonThreadFragment.this.dyU();
                    PersonThreadFragment.this.mCQ.cyk();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.a(PersonThreadFragment.this.iXF, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
                } else {
                    BdListViewHelper.a(PersonThreadFragment.this.iXF, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.mNetworkChangedMessageListener);
        this.mrQ = new PersonPostModel(getPageContext(), getUniqueId(), this, true, PersonPostModel.FROM_PERSON_POST);
        this.mrQ.setUniqueId(getUniqueId());
        this.jwD = new ShareSuccessReplyToServerModel();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_thread_fragment, viewGroup, false);
        this.mCN = (FrameLayout) inflate.findViewById(R.id.root_view);
        this.mCM = new h(getActivity(), inflate);
        if (this.mCM.dyX() == null) {
            this.mCM.b(this.mCI);
        }
        if (this.mCM.mCY != null) {
            ao.setBackgroundColor(this.mCM.mCY, R.color.CAM_X0201);
        }
        String string2 = getArguments().getString("thread_type_key");
        if (!at.isEmpty(string2)) {
            this.mCL = string2;
        }
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(R.string.to_be_an_liver), new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonThreadFragment.this.dyQ();
            }
        });
        int dimension = (int) getResources().getDimension(R.dimen.ds102);
        String str = "";
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, dimension);
        if (this.mCL.equals("photolive")) {
            int i = com.baidu.tbadk.core.sharedPref.b.brx().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PHOTOLIVE_HOSTLEVEL, -1);
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
                dyR();
            }
        } else {
            string = getArguments().getString("key_empty_view_text");
            bVar = null;
        }
        this.mCM.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.dX(str, string), bVar);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.mCU);
        registerListener(this.mCV);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        if (this.mCL.equals("photolive")) {
            this.mCT = 33;
        }
        this.mCO = new com.baidu.tieba.post.a.a(getPageContext(), this.mCM.mCY);
        this.mCM.dyW().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                CardPersonDynamicThreadData cardPersonDynamicThreadData;
                if (i >= 0 && PersonThreadFragment.this.mCO != null && i < x.getCount(PersonThreadFragment.this.mrQ.threadList) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) PersonThreadFragment.this.mCO.mqk.getItem(i)) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PersonThreadFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.threadId), String.valueOf(cardPersonDynamicThreadData.postId), "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB).setThreadData(cardPersonDynamicThreadData.eHK)));
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.g(getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.post.PersonThreadFragment.5
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonThreadFragment.this.mrQ != null) {
                    PersonThreadFragment.this.mCH = true;
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        if (PersonThreadFragment.this.mCM != null) {
                            PersonThreadFragment.this.mCM.aR(PersonThreadFragment.this.getString(R.string.neterror), true);
                            return;
                        }
                        return;
                    }
                    PersonThreadFragment.this.dyT();
                }
            }
        });
        this.mCM.mCY.setPullRefresh(this.mPullView);
        if (TbadkCoreApplication.isMyLive) {
            this.iXF = BdListViewHelper.a(getActivity(), this.mCM.mCY, BdListViewHelper.HeadType.DEFAULT);
            BdListViewHelper.a(this.iXF, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        } else {
            this.iXF = BdListViewHelper.a(getActivity(), this.mCM.mCY, BdListViewHelper.HeadType.HASTAB);
            BdListViewHelper.a(this.iXF, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.mCM.mCY.setOnSrollToBottomListener(this);
        this.mCQ = new a(getBaseFragmentActivity());
        this.mCM.mCY.setNextPage(this.mCQ);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            dyU();
            this.mCQ.cyk();
            this.fFU = true;
            return;
        }
        this.mCQ.xd(false);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
    public void b(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null && this.mrQ != null) {
            if (z) {
                this.mrQ.threadList.clear();
            }
            ArrayList<n> arrayList = personPostModel.threadList;
            if (personPostModel.view_card_num > 0 && this.mCS) {
                x.add(arrayList, personPostModel.view_card_num - 1, new com.baidu.tieba.personPolymeric.c.j());
                this.mCS = false;
            }
            if (this.mrQ.threadList.isEmpty()) {
                n nVar = (n) x.getItem(arrayList, 0);
                if (nVar instanceof CardPersonDynamicThreadData) {
                    ((CardPersonDynamicThreadData) nVar).ivP = true;
                } else if (nVar instanceof com.baidu.tieba.personPolymeric.c.j) {
                    ((com.baidu.tieba.personPolymeric.c.j) nVar).ivP = true;
                }
            }
            this.mrQ.threadList.addAll(arrayList);
            PersonPostModel.mergeDynamicThreadByTime(this.mrQ.threadList);
        }
        if (this.mCR != null) {
            this.mCR.xa(personPostModel.isShowRecycleBinRedTip);
        }
        a(personPostModel, z);
        this.mCO.W(this.mrQ.threadList);
        this.mCO.notifyDataSetChanged();
    }

    /* loaded from: classes7.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private View fGq;
        private BaseFragmentActivity gfX;
        private int bgColor = R.color.CAM_X0201;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;
        private int mSkinType = 3;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.gfX = null;
            this.gfX = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View createView() {
            this.mRoot = LayoutInflater.from(this.gfX.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.fGq = this.mRoot.findViewById(R.id.pb_more_view);
            ao.setBackgroundColor(this.mRoot, this.bgColor);
            ao.setBackgroundColor(this.fGq, this.bgColor);
            this.fGq.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            qE(TbadkCoreApplication.getInst().getSkinType());
            ao.setViewTextColor(this.mTextView, R.color.common_color_10039);
            this.fGq.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.gfX.getPageContext().getPageActivity(), R.dimen.ds120)));
            return this.mRoot;
        }

        public void qE(int i) {
            this.gfX.getLayoutMode().onModeChanged(this.fGq);
        }

        @SuppressLint({"ResourceAsColor"})
        public void changeSkin(int i) {
            if (this.mSkinType != i) {
                ao.setViewTextColor(this.mTextView, R.color.common_color_10039);
                ao.setBackgroundColor(this.mRoot, this.bgColor, i);
                ao.setBackgroundColor(this.fGq, this.bgColor, i);
                this.mSkinType = i;
            }
        }

        public void cyk() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.gfX.getPageContext().getPageActivity().getText(R.string.loading));
            this.fGq.setVisibility(0);
        }

        public void dyV() {
            ao.setBackgroundColor(this.mRoot, R.color.CAM_X0204);
        }

        public void xd(boolean z) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.fGq.setVisibility(0);
                    this.mTextView.setText(this.gfX.getResources().getString(R.string.list_no_more));
                    return;
                }
                this.fGq.setVisibility(0);
                this.mTextView.setText(this.gfX.getResources().getString(R.string.load_more));
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
            if (this.mCM.mNoDataView != null) {
                this.mCM.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.mCO != null) {
                this.mCO.notifyDataSetChanged();
            }
            if (this.mCQ != null) {
                this.mCQ.changeSkin(i);
            }
            ao.setBackgroundColor(this.mCM.mCY, R.color.CAM_X0201);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.mCM.mNoDataView != null) {
            this.mCM.mNoDataView.e(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.mCM.mNoDataView != null) {
            this.mCM.mNoDataView.btD();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.mCO != null) {
            this.mCO.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        if (this.mrQ != null) {
            this.mrQ.cancelLoadData();
        }
        try {
            com.baidu.tbadk.e.a.aGz();
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
            if (i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.mCO != null && this.mrQ != null && x.getCount(this.mrQ.threadList) > 0) {
                int count = x.getCount(this.mrQ.threadList);
                int i3 = 0;
                while (true) {
                    if (i3 >= count) {
                        z = false;
                        break;
                    }
                    n nVar = (n) x.getItem(this.mrQ.threadList, i3);
                    if ((nVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) nVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.threadId))) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (z && intent.getIntExtra("type", -1) == 0) {
                    x.remove(this.mrQ.threadList, i3);
                    this.mCO.notifyDataSetChanged();
                }
            }
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.jwD != null) {
                    this.jwD.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.post.PersonThreadFragment.6
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void byn() {
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
        if (!this.mCP) {
            this.mCM.mCY.startPullRefresh();
            this.mCP = true;
        }
    }

    public h dyP() {
        return this.mCM;
    }

    @Override // com.baidu.tieba.post.c
    public void dyK() {
        if (this.mCM != null && this.mCM.mCY != null) {
            this.mCM.mCY.startPullRefresh();
        }
    }

    public void a(d dVar) {
        this.mCI = dVar;
    }

    public void a(b bVar) {
        this.mCR = bVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
    public void a(PersonPostModel personPostModel, boolean z) {
        this.fFU = false;
        if (isAdded()) {
            this.mCM.mCY.completePullRefreshPostDelayed(0L);
            this.mCM.mCY.setEmptyView(null);
            if (personPostModel != null || this.mCH) {
                if (personPostModel == null || (personPostModel.threadList.size() == 0 && this.mCH && StringUtils.isNull(personPostModel.getErrorString()))) {
                    xc(true);
                    return;
                }
                if (personPostModel.threadList.size() == 0 && this.mCH) {
                    xc(true);
                } else {
                    xc(false);
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
                    this.bcD = 0;
                    this.mCH = false;
                }
                this.mCQ.xd(this.mHasMore);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MYLIVE_TAB_EDIT_ENABLE));
            }
        }
    }

    private void xc(boolean z) {
        this.mCM.mCY.removeHeaderView(this.mCM.mNoDataView);
        if (z) {
            this.mCM.mNoDataView.setVisibility(0);
            this.mCM.mCY.addHeaderView(this.mCM.mNoDataView);
            this.mCQ.getView().setVisibility(8);
            return;
        }
        this.mCQ.getView().setVisibility(0);
        this.mCQ.dyV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyQ() {
        TiebaStatic.log(TbadkCoreStatisticKey.MYLIVE_TO_BE_ANCHOR);
        dyS();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(1, this);
    }

    private void dyR() {
        dyS();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).b(this);
    }

    private void dyS() {
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(true, true, true, this);
    }

    public void dyT() {
        if (this.mrQ != null) {
            this.mrQ.fetchPost(getPageContext(), this, true, this.mUid, true, this.mCT, false, true, null);
            this.mCS = true;
        }
    }

    public void dyU() {
        if (this.mrQ != null) {
            this.mrQ.fetchPost(getPageContext(), this, false, this.mUid, true, false, true, null);
        }
    }
}
