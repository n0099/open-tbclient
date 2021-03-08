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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
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
    private int bhn;
    private ShareSuccessReplyToServerModel jEg;
    private View jfj;
    public PersonPostModel mDk;
    private d mOh;
    private h mOl;
    private FrameLayout mOm;
    private com.baidu.tieba.post.a.a mOn;
    private boolean mOo;
    private a mOp;
    private b mOq;
    private int mOs;
    private com.baidu.tbadk.core.view.g mPullView;
    private String mUid;
    private String mOk = "common";
    private boolean mHasMore = false;
    private boolean mOg = true;
    private boolean mOr = true;
    private boolean fJF = false;
    private CustomMessageListener mOt = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD) { // from class: com.baidu.tieba.post.PersonThreadFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && PersonThreadFragment.this.mOn != null) {
                PersonThreadFragment.this.mOn.QR((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener mOu = new CustomMessageListener(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE) { // from class: com.baidu.tieba.post.PersonThreadFragment.2
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
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && PersonThreadFragment.this.fJF) {
                    PersonThreadFragment.this.dBt();
                    PersonThreadFragment.this.mOp.czI();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.a(PersonThreadFragment.this.jfj, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
                } else {
                    BdListViewHelper.a(PersonThreadFragment.this.jfj, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.mNetworkChangedMessageListener);
        this.mDk = new PersonPostModel(getPageContext(), getUniqueId(), this, true, PersonPostModel.FROM_PERSON_POST);
        this.mDk.setUniqueId(getUniqueId());
        this.jEg = new ShareSuccessReplyToServerModel();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_thread_fragment, viewGroup, false);
        this.mOm = (FrameLayout) inflate.findViewById(R.id.root_view);
        this.mOl = new h(getActivity(), inflate);
        if (this.mOl.dBw() == null) {
            this.mOl.b(this.mOh);
        }
        if (this.mOl.mOx != null) {
            ap.setBackgroundColor(this.mOl.mOx, R.color.CAM_X0201);
        }
        String string2 = getArguments().getString("thread_type_key");
        if (!au.isEmpty(string2)) {
            this.mOk = string2;
        }
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(R.string.to_be_an_liver), new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonThreadFragment.this.dBp();
            }
        });
        int dimension = (int) getResources().getDimension(R.dimen.ds102);
        String str = "";
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, dimension);
        if (this.mOk.equals("photolive")) {
            int i = com.baidu.tbadk.core.sharedPref.b.brR().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PHOTOLIVE_HOSTLEVEL, -1);
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
                dBq();
            }
        } else {
            string = getArguments().getString("key_empty_view_text");
            bVar = null;
        }
        this.mOl.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.dS(str, string), bVar);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.mOt);
        registerListener(this.mOu);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        if (this.mOk.equals("photolive")) {
            this.mOs = 33;
        }
        this.mOn = new com.baidu.tieba.post.a.a(getPageContext(), this.mOl.mOx);
        this.mOl.dBv().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                CardPersonDynamicThreadData cardPersonDynamicThreadData;
                if (i >= 0 && PersonThreadFragment.this.mOn != null && i < y.getCount(PersonThreadFragment.this.mDk.threadList) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) PersonThreadFragment.this.mOn.mBC.getItem(i)) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PersonThreadFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.threadId), String.valueOf(cardPersonDynamicThreadData.postId), "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB).setThreadData(cardPersonDynamicThreadData.eLr)));
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.g(getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.post.PersonThreadFragment.5
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonThreadFragment.this.mDk != null) {
                    PersonThreadFragment.this.mOg = true;
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        if (PersonThreadFragment.this.mOl != null) {
                            PersonThreadFragment.this.mOl.aQ(PersonThreadFragment.this.getString(R.string.neterror), true);
                            return;
                        }
                        return;
                    }
                    PersonThreadFragment.this.dBs();
                }
            }
        });
        this.mOl.mOx.setPullRefresh(this.mPullView);
        if (TbadkCoreApplication.isMyLive) {
            this.jfj = BdListViewHelper.a(getActivity(), this.mOl.mOx, BdListViewHelper.HeadType.DEFAULT);
            BdListViewHelper.a(this.jfj, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        } else {
            this.jfj = BdListViewHelper.a(getActivity(), this.mOl.mOx, BdListViewHelper.HeadType.HASTAB);
            BdListViewHelper.a(this.jfj, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.mOl.mOx.setOnSrollToBottomListener(this);
        this.mOp = new a(getBaseFragmentActivity());
        this.mOl.mOx.setNextPage(this.mOp);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            dBt();
            this.mOp.czI();
            this.fJF = true;
            return;
        }
        this.mOp.xv(false);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
    public void b(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null && this.mDk != null) {
            if (z) {
                this.mDk.threadList.clear();
            }
            ArrayList<n> arrayList = personPostModel.threadList;
            if (personPostModel.view_card_num > 0 && this.mOr) {
                y.add(arrayList, personPostModel.view_card_num - 1, new com.baidu.tieba.personPolymeric.c.j());
                this.mOr = false;
            }
            if (this.mDk.threadList.isEmpty()) {
                n nVar = (n) y.getItem(arrayList, 0);
                if (nVar instanceof CardPersonDynamicThreadData) {
                    ((CardPersonDynamicThreadData) nVar).iDw = true;
                } else if (nVar instanceof com.baidu.tieba.personPolymeric.c.j) {
                    ((com.baidu.tieba.personPolymeric.c.j) nVar).iDw = true;
                }
            }
            this.mDk.threadList.addAll(arrayList);
            PersonPostModel.mergeDynamicThreadByTime(this.mDk.threadList);
        }
        if (this.mOq != null) {
            this.mOq.xs(personPostModel.isShowRecycleBinRedTip);
        }
        a(personPostModel, z);
        this.mOn.V(this.mDk.threadList);
        this.mOn.notifyDataSetChanged();
    }

    /* loaded from: classes7.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private View fKb;
        private BaseFragmentActivity gke;
        private int bgColor = R.color.CAM_X0201;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;
        private int mSkinType = 3;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.gke = null;
            this.gke = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View createView() {
            this.mRoot = LayoutInflater.from(this.gke.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.fKb = this.mRoot.findViewById(R.id.pb_more_view);
            ap.setBackgroundColor(this.mRoot, this.bgColor);
            ap.setBackgroundColor(this.fKb, this.bgColor);
            this.fKb.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            qK(TbadkCoreApplication.getInst().getSkinType());
            ap.setViewTextColor(this.mTextView, R.color.common_color_10039);
            this.fKb.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.gke.getPageContext().getPageActivity(), R.dimen.ds120)));
            return this.mRoot;
        }

        public void qK(int i) {
            this.gke.getLayoutMode().onModeChanged(this.fKb);
        }

        @SuppressLint({"ResourceAsColor"})
        public void changeSkin(int i) {
            if (this.mSkinType != i) {
                ap.setViewTextColor(this.mTextView, R.color.common_color_10039);
                ap.setBackgroundColor(this.mRoot, this.bgColor, i);
                ap.setBackgroundColor(this.fKb, this.bgColor, i);
                this.mSkinType = i;
            }
        }

        public void czI() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.gke.getPageContext().getPageActivity().getText(R.string.loading));
            this.fKb.setVisibility(0);
        }

        public void dBu() {
            ap.setBackgroundColor(this.mRoot, R.color.CAM_X0204);
        }

        public void xv(boolean z) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.fKb.setVisibility(0);
                    this.mTextView.setText(this.gke.getResources().getString(R.string.list_no_more));
                    return;
                }
                this.fKb.setVisibility(0);
                this.mTextView.setText(this.gke.getResources().getString(R.string.load_more));
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
            if (this.mOl.mNoDataView != null) {
                this.mOl.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.mOn != null) {
                this.mOn.notifyDataSetChanged();
            }
            if (this.mOp != null) {
                this.mOp.changeSkin(i);
            }
            ap.setBackgroundColor(this.mOl.mOx, R.color.CAM_X0201);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.mOl.mNoDataView != null) {
            this.mOl.mNoDataView.e(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.mOl.mNoDataView != null) {
            this.mOl.mNoDataView.bua();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.mOn != null) {
            this.mOn.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        if (this.mDk != null) {
            this.mDk.cancelLoadData();
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

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        ShareItem shareItem;
        String stringExtra;
        boolean z;
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.mOn != null && this.mDk != null && y.getCount(this.mDk.threadList) > 0) {
                int count = y.getCount(this.mDk.threadList);
                int i3 = 0;
                while (true) {
                    if (i3 >= count) {
                        z = false;
                        break;
                    }
                    n nVar = (n) y.getItem(this.mDk.threadList, i3);
                    if ((nVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) nVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.threadId))) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (z && intent.getIntExtra("type", -1) == 0) {
                    y.remove(this.mDk.threadList, i3);
                    this.mOn.notifyDataSetChanged();
                }
            }
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.jEg != null) {
                    this.jEg.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.post.PersonThreadFragment.6
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void byI() {
                        }

                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void a(final CustomDialogData customDialogData) {
                            com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.post.PersonThreadFragment.6.1
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
        if (!this.mOo) {
            this.mOl.mOx.startPullRefresh();
            this.mOo = true;
        }
    }

    public h dBo() {
        return this.mOl;
    }

    @Override // com.baidu.tieba.post.c
    public void dBj() {
        if (this.mOl != null && this.mOl.mOx != null) {
            this.mOl.mOx.startPullRefresh();
        }
    }

    public void a(d dVar) {
        this.mOh = dVar;
    }

    public void a(b bVar) {
        this.mOq = bVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
    public void a(PersonPostModel personPostModel, boolean z) {
        this.fJF = false;
        if (isAdded()) {
            this.mOl.mOx.completePullRefreshPostDelayed(0L);
            this.mOl.mOx.setEmptyView(null);
            if (personPostModel != null || this.mOg) {
                if (personPostModel == null || (personPostModel.threadList.size() == 0 && this.mOg && StringUtils.isNull(personPostModel.getErrorString()))) {
                    xu(true);
                    return;
                }
                if (personPostModel.threadList.size() == 0 && this.mOg) {
                    xu(true);
                } else {
                    xu(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(getActivity(), personPostModel.getErrorString());
                }
                this.mHasMore = !y.isEmpty(personPostModel.threadList);
                if (z) {
                    if (personPostModel.threadList.size() < 20) {
                        this.mHasMore = false;
                    } else {
                        this.mHasMore = true;
                    }
                    this.bhn = 0;
                    this.mOg = false;
                }
                this.mOp.xv(this.mHasMore);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MYLIVE_TAB_EDIT_ENABLE));
            }
        }
    }

    private void xu(boolean z) {
        this.mOl.mOx.removeHeaderView(this.mOl.mNoDataView);
        if (z) {
            this.mOl.mNoDataView.setVisibility(0);
            this.mOl.mOx.addHeaderView(this.mOl.mNoDataView);
            this.mOp.getView().setVisibility(8);
            return;
        }
        this.mOp.getView().setVisibility(0);
        this.mOp.dBu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBp() {
        TiebaStatic.log(TbadkCoreStatisticKey.MYLIVE_TO_BE_ANCHOR);
        dBr();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(1, this);
    }

    private void dBq() {
        dBr();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).b(this);
    }

    private void dBr() {
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(true, true, true, this);
    }

    public void dBs() {
        if (this.mDk != null) {
            this.mDk.fetchPost(getPageContext(), this, true, this.mUid, true, this.mOs, false, true, null);
            this.mOr = true;
        }
    }

    public void dBt() {
        if (this.mDk != null) {
            this.mDk.fetchPost(getPageContext(), this, false, this.mUid, true, false, true, null);
        }
    }
}
