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
/* loaded from: classes24.dex */
public class PersonThreadFragment extends BaseFragment implements BdListView.e, b.a, PersonPostModel.a, PersonPostModel.b, c {
    private int bfL;
    private View iQa;
    private ShareSuccessReplyToServerModel joM;
    private d mCa;
    private h mCd;
    private FrameLayout mCe;
    private com.baidu.tieba.post.a.a mCf;
    private boolean mCg;
    private a mCh;
    private b mCi;
    private int mCk;
    private com.baidu.tbadk.core.view.g mPullView;
    private String mUid;
    public PersonPostModel mri;
    private String mCc = "common";
    private boolean mHasMore = false;
    private boolean mBZ = true;
    private boolean mCj = true;
    private boolean fAV = false;
    private CustomMessageListener mCl = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD) { // from class: com.baidu.tieba.post.PersonThreadFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && PersonThreadFragment.this.mCf != null) {
                PersonThreadFragment.this.mCf.Rv((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener mCm = new CustomMessageListener(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE) { // from class: com.baidu.tieba.post.PersonThreadFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.adp.lib.util.l.showToast(PersonThreadFragment.this.getActivity(), (int) R.string.thread_has_hide);
            }
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.post.PersonThreadFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && PersonThreadFragment.this.fAV) {
                    PersonThreadFragment.this.dCW();
                    PersonThreadFragment.this.mCh.czi();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.a(PersonThreadFragment.this.iQa, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
                } else {
                    BdListViewHelper.a(PersonThreadFragment.this.iQa, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.mNetworkChangedMessageListener);
        this.mri = new PersonPostModel(getPageContext(), getUniqueId(), this, true, PersonPostModel.FROM_PERSON_POST);
        this.mri.setUniqueId(getUniqueId());
        this.joM = new ShareSuccessReplyToServerModel();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_thread_fragment, viewGroup, false);
        this.mCe = (FrameLayout) inflate.findViewById(R.id.root_view);
        this.mCd = new h(getActivity(), inflate);
        if (this.mCd.dCZ() == null) {
            this.mCd.b(this.mCa);
        }
        if (this.mCd.mCp != null) {
            ap.setBackgroundColor(this.mCd.mCp, R.color.CAM_X0201);
        }
        String string2 = getArguments().getString("thread_type_key");
        if (!au.isEmpty(string2)) {
            this.mCc = string2;
        }
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(R.string.to_be_an_liver), new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonThreadFragment.this.dCS();
            }
        });
        int dimension = (int) getResources().getDimension(R.dimen.ds102);
        String str = "";
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, dimension);
        if (this.mCc.equals("photolive")) {
            int i = com.baidu.tbadk.core.sharedPref.b.bsO().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PHOTOLIVE_HOSTLEVEL, -1);
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
                dCT();
            }
        } else {
            string = getArguments().getString("key_empty_view_text");
            bVar = null;
        }
        this.mCd.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.dZ(str, string), bVar);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.mCl);
        registerListener(this.mCm);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        if (this.mCc.equals("photolive")) {
            this.mCk = 33;
        }
        this.mCf = new com.baidu.tieba.post.a.a(getPageContext(), this.mCd.mCp);
        this.mCd.dCY().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                CardPersonDynamicThreadData cardPersonDynamicThreadData;
                if (i >= 0 && PersonThreadFragment.this.mCf != null && i < y.getCount(PersonThreadFragment.this.mri.threadList) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) PersonThreadFragment.this.mCf.mpD.getItem(i)) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PersonThreadFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.threadId), String.valueOf(cardPersonDynamicThreadData.postId), "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB).setThreadData(cardPersonDynamicThreadData.eCR)));
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.g(getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.post.PersonThreadFragment.5
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonThreadFragment.this.mri != null) {
                    PersonThreadFragment.this.mBZ = true;
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        if (PersonThreadFragment.this.mCd != null) {
                            PersonThreadFragment.this.mCd.aR(PersonThreadFragment.this.getString(R.string.neterror), true);
                            return;
                        }
                        return;
                    }
                    PersonThreadFragment.this.dCV();
                }
            }
        });
        this.mCd.mCp.setPullRefresh(this.mPullView);
        if (TbadkCoreApplication.isMyLive) {
            this.iQa = BdListViewHelper.a(getActivity(), this.mCd.mCp, BdListViewHelper.HeadType.DEFAULT);
            BdListViewHelper.a(this.iQa, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        } else {
            this.iQa = BdListViewHelper.a(getActivity(), this.mCd.mCp, BdListViewHelper.HeadType.HASTAB);
            BdListViewHelper.a(this.iQa, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.mCd.mCp.setOnSrollToBottomListener(this);
        this.mCh = new a(getBaseFragmentActivity());
        this.mCd.mCp.setNextPage(this.mCh);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            dCW();
            this.mCh.czi();
            this.fAV = true;
            return;
        }
        this.mCh.xg(false);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
    public void b(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null && this.mri != null) {
            if (z) {
                this.mri.threadList.clear();
            }
            ArrayList<q> arrayList = personPostModel.threadList;
            if (personPostModel.view_card_num > 0 && this.mCj) {
                y.add(arrayList, personPostModel.view_card_num - 1, new com.baidu.tieba.personPolymeric.c.j());
                this.mCj = false;
            }
            if (this.mri.threadList.isEmpty()) {
                q qVar = (q) y.getItem(arrayList, 0);
                if (qVar instanceof CardPersonDynamicThreadData) {
                    ((CardPersonDynamicThreadData) qVar).ioc = true;
                } else if (qVar instanceof com.baidu.tieba.personPolymeric.c.j) {
                    ((com.baidu.tieba.personPolymeric.c.j) qVar).ioc = true;
                }
            }
            this.mri.threadList.addAll(arrayList);
            PersonPostModel.mergeDynamicThreadByTime(this.mri.threadList);
        }
        if (this.mCi != null) {
            this.mCi.xd(personPostModel.isShowRecycleBinRedTip);
        }
        a(personPostModel, z);
        this.mCf.ab(this.mri.threadList);
        this.mCf.notifyDataSetChanged();
    }

    /* loaded from: classes24.dex */
    public static class a extends com.baidu.adp.widget.ListView.c {
        private View fBr;
        private BaseFragmentActivity gbo;
        private int bgColor = R.color.CAM_X0201;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;
        private int mSkinType = 3;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.gbo = null;
            this.gbo = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.c
        public View createView() {
            this.mRoot = LayoutInflater.from(this.gbo.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.fBr = this.mRoot.findViewById(R.id.pb_more_view);
            ap.setBackgroundColor(this.mRoot, this.bgColor);
            ap.setBackgroundColor(this.fBr, this.bgColor);
            this.fBr.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            rY(TbadkCoreApplication.getInst().getSkinType());
            ap.setViewTextColor(this.mTextView, (int) R.color.common_color_10039);
            this.fBr.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.gbo.getPageContext().getPageActivity(), R.dimen.ds120)));
            return this.mRoot;
        }

        public void rY(int i) {
            this.gbo.getLayoutMode().onModeChanged(this.fBr);
        }

        @SuppressLint({"ResourceAsColor"})
        public void changeSkin(int i) {
            if (this.mSkinType != i) {
                ap.setViewTextColor(this.mTextView, (int) R.color.common_color_10039);
                ap.setBackgroundColor(this.mRoot, this.bgColor, i);
                ap.setBackgroundColor(this.fBr, this.bgColor, i);
                this.mSkinType = i;
            }
        }

        public void czi() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.gbo.getPageContext().getPageActivity().getText(R.string.loading));
            this.fBr.setVisibility(0);
        }

        public void dCX() {
            ap.setBackgroundColor(this.mRoot, R.color.CAM_X0204);
        }

        public void xg(boolean z) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.fBr.setVisibility(0);
                    this.mTextView.setText(this.gbo.getResources().getString(R.string.list_no_more));
                    return;
                }
                this.fBr.setVisibility(0);
                this.mTextView.setText(this.gbo.getResources().getString(R.string.load_more));
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
            if (this.mCd.mNoDataView != null) {
                this.mCd.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.mCf != null) {
                this.mCf.notifyDataSetChanged();
            }
            if (this.mCh != null) {
                this.mCh.changeSkin(i);
            }
            ap.setBackgroundColor(this.mCd.mCp, R.color.CAM_X0201);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.mCd.mNoDataView != null) {
            this.mCd.mNoDataView.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.mCd.mNoDataView != null) {
            this.mCd.mNoDataView.bvb();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.mCf != null) {
            this.mCf.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.mri != null) {
            this.mri.cancelLoadData();
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
            if (i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.mCf != null && this.mri != null && y.getCount(this.mri.threadList) > 0) {
                int count = y.getCount(this.mri.threadList);
                int i3 = 0;
                while (true) {
                    if (i3 >= count) {
                        z = false;
                        break;
                    }
                    q qVar = (q) y.getItem(this.mri.threadList, i3);
                    if ((qVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) qVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.threadId))) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (z && intent.getIntExtra("type", -1) == 0) {
                    y.remove(this.mri.threadList, i3);
                    this.mCf.notifyDataSetChanged();
                }
            }
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.joM != null) {
                    this.joM.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.post.PersonThreadFragment.6
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void bzM() {
                        }

                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void a(final CustomDialogData customDialogData) {
                            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.post.PersonThreadFragment.6.1
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
        if (!this.mCg) {
            this.mCd.mCp.startPullRefresh();
            this.mCg = true;
        }
    }

    public h dCR() {
        return this.mCd;
    }

    @Override // com.baidu.tieba.post.c
    public void dCM() {
        if (this.mCd != null && this.mCd.mCp != null) {
            this.mCd.mCp.startPullRefresh();
        }
    }

    public void a(d dVar) {
        this.mCa = dVar;
    }

    public void a(b bVar) {
        this.mCi = bVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
    public void a(PersonPostModel personPostModel, boolean z) {
        this.fAV = false;
        if (isAdded()) {
            this.mCd.mCp.completePullRefreshPostDelayed(0L);
            this.mCd.mCp.setEmptyView(null);
            if (personPostModel != null || this.mBZ) {
                if (personPostModel == null || (personPostModel.threadList.size() == 0 && this.mBZ && StringUtils.isNull(personPostModel.getErrorString()))) {
                    xf(true);
                    return;
                }
                if (personPostModel.threadList.size() == 0 && this.mBZ) {
                    xf(true);
                } else {
                    xf(false);
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
                    this.bfL = 0;
                    this.mBZ = false;
                }
                this.mCh.xg(this.mHasMore);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MYLIVE_TAB_EDIT_ENABLE));
            }
        }
    }

    private void xf(boolean z) {
        this.mCd.mCp.removeHeaderView(this.mCd.mNoDataView);
        if (z) {
            this.mCd.mNoDataView.setVisibility(0);
            this.mCd.mCp.addHeaderView(this.mCd.mNoDataView);
            this.mCh.getView().setVisibility(8);
            return;
        }
        this.mCh.getView().setVisibility(0);
        this.mCh.dCX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCS() {
        TiebaStatic.log(TbadkCoreStatisticKey.MYLIVE_TO_BE_ANCHOR);
        dCU();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(1, this);
    }

    private void dCT() {
        dCU();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).b(this);
    }

    private void dCU() {
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(true, true, true, this);
    }

    public void dCV() {
        if (this.mri != null) {
            this.mri.fetchPost(getPageContext(), this, true, this.mUid, true, this.mCk, false, true, null);
            this.mCj = true;
        }
    }

    public void dCW() {
        if (this.mri != null) {
            this.mri.fetchPost(getPageContext(), this, false, this.mUid, true, false, true, null);
        }
    }
}
