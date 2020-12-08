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
    private View iPY;
    private ShareSuccessReplyToServerModel joK;
    private d mBY;
    private h mCb;
    private FrameLayout mCc;
    private com.baidu.tieba.post.a.a mCd;
    private boolean mCe;
    private a mCf;
    private b mCg;
    private int mCi;
    private com.baidu.tbadk.core.view.g mPullView;
    private String mUid;
    public PersonPostModel mrg;
    private String mCa = "common";
    private boolean mHasMore = false;
    private boolean mBX = true;
    private boolean mCh = true;
    private boolean fAV = false;
    private CustomMessageListener mCj = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD) { // from class: com.baidu.tieba.post.PersonThreadFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && PersonThreadFragment.this.mCd != null) {
                PersonThreadFragment.this.mCd.Rv((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener mCk = new CustomMessageListener(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE) { // from class: com.baidu.tieba.post.PersonThreadFragment.2
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
                    PersonThreadFragment.this.dCV();
                    PersonThreadFragment.this.mCf.czh();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.a(PersonThreadFragment.this.iPY, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
                } else {
                    BdListViewHelper.a(PersonThreadFragment.this.iPY, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.mNetworkChangedMessageListener);
        this.mrg = new PersonPostModel(getPageContext(), getUniqueId(), this, true, PersonPostModel.FROM_PERSON_POST);
        this.mrg.setUniqueId(getUniqueId());
        this.joK = new ShareSuccessReplyToServerModel();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_thread_fragment, viewGroup, false);
        this.mCc = (FrameLayout) inflate.findViewById(R.id.root_view);
        this.mCb = new h(getActivity(), inflate);
        if (this.mCb.dCY() == null) {
            this.mCb.b(this.mBY);
        }
        if (this.mCb.mCn != null) {
            ap.setBackgroundColor(this.mCb.mCn, R.color.CAM_X0201);
        }
        String string2 = getArguments().getString("thread_type_key");
        if (!au.isEmpty(string2)) {
            this.mCa = string2;
        }
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(R.string.to_be_an_liver), new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonThreadFragment.this.dCR();
            }
        });
        int dimension = (int) getResources().getDimension(R.dimen.ds102);
        String str = "";
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, dimension);
        if (this.mCa.equals("photolive")) {
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
                dCS();
            }
        } else {
            string = getArguments().getString("key_empty_view_text");
            bVar = null;
        }
        this.mCb.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.dZ(str, string), bVar);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.mCj);
        registerListener(this.mCk);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        if (this.mCa.equals("photolive")) {
            this.mCi = 33;
        }
        this.mCd = new com.baidu.tieba.post.a.a(getPageContext(), this.mCb.mCn);
        this.mCb.dCX().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                CardPersonDynamicThreadData cardPersonDynamicThreadData;
                if (i >= 0 && PersonThreadFragment.this.mCd != null && i < y.getCount(PersonThreadFragment.this.mrg.threadList) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) PersonThreadFragment.this.mCd.mpB.getItem(i)) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PersonThreadFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.threadId), String.valueOf(cardPersonDynamicThreadData.postId), "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB).setThreadData(cardPersonDynamicThreadData.eCR)));
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.g(getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.post.PersonThreadFragment.5
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonThreadFragment.this.mrg != null) {
                    PersonThreadFragment.this.mBX = true;
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        if (PersonThreadFragment.this.mCb != null) {
                            PersonThreadFragment.this.mCb.aR(PersonThreadFragment.this.getString(R.string.neterror), true);
                            return;
                        }
                        return;
                    }
                    PersonThreadFragment.this.dCU();
                }
            }
        });
        this.mCb.mCn.setPullRefresh(this.mPullView);
        if (TbadkCoreApplication.isMyLive) {
            this.iPY = BdListViewHelper.a(getActivity(), this.mCb.mCn, BdListViewHelper.HeadType.DEFAULT);
            BdListViewHelper.a(this.iPY, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        } else {
            this.iPY = BdListViewHelper.a(getActivity(), this.mCb.mCn, BdListViewHelper.HeadType.HASTAB);
            BdListViewHelper.a(this.iPY, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.mCb.mCn.setOnSrollToBottomListener(this);
        this.mCf = new a(getBaseFragmentActivity());
        this.mCb.mCn.setNextPage(this.mCf);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            dCV();
            this.mCf.czh();
            this.fAV = true;
            return;
        }
        this.mCf.xg(false);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
    public void b(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null && this.mrg != null) {
            if (z) {
                this.mrg.threadList.clear();
            }
            ArrayList<q> arrayList = personPostModel.threadList;
            if (personPostModel.view_card_num > 0 && this.mCh) {
                y.add(arrayList, personPostModel.view_card_num - 1, new com.baidu.tieba.personPolymeric.c.j());
                this.mCh = false;
            }
            if (this.mrg.threadList.isEmpty()) {
                q qVar = (q) y.getItem(arrayList, 0);
                if (qVar instanceof CardPersonDynamicThreadData) {
                    ((CardPersonDynamicThreadData) qVar).ioa = true;
                } else if (qVar instanceof com.baidu.tieba.personPolymeric.c.j) {
                    ((com.baidu.tieba.personPolymeric.c.j) qVar).ioa = true;
                }
            }
            this.mrg.threadList.addAll(arrayList);
            PersonPostModel.mergeDynamicThreadByTime(this.mrg.threadList);
        }
        if (this.mCg != null) {
            this.mCg.xd(personPostModel.isShowRecycleBinRedTip);
        }
        a(personPostModel, z);
        this.mCd.ab(this.mrg.threadList);
        this.mCd.notifyDataSetChanged();
    }

    /* loaded from: classes24.dex */
    public static class a extends com.baidu.adp.widget.ListView.c {
        private View fBr;
        private BaseFragmentActivity gbm;
        private int bgColor = R.color.CAM_X0201;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;
        private int mSkinType = 3;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.gbm = null;
            this.gbm = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.c
        public View createView() {
            this.mRoot = LayoutInflater.from(this.gbm.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.fBr = this.mRoot.findViewById(R.id.pb_more_view);
            ap.setBackgroundColor(this.mRoot, this.bgColor);
            ap.setBackgroundColor(this.fBr, this.bgColor);
            this.fBr.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            rY(TbadkCoreApplication.getInst().getSkinType());
            ap.setViewTextColor(this.mTextView, (int) R.color.common_color_10039);
            this.fBr.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.gbm.getPageContext().getPageActivity(), R.dimen.ds120)));
            return this.mRoot;
        }

        public void rY(int i) {
            this.gbm.getLayoutMode().onModeChanged(this.fBr);
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

        public void czh() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.gbm.getPageContext().getPageActivity().getText(R.string.loading));
            this.fBr.setVisibility(0);
        }

        public void dCW() {
            ap.setBackgroundColor(this.mRoot, R.color.CAM_X0204);
        }

        public void xg(boolean z) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.fBr.setVisibility(0);
                    this.mTextView.setText(this.gbm.getResources().getString(R.string.list_no_more));
                    return;
                }
                this.fBr.setVisibility(0);
                this.mTextView.setText(this.gbm.getResources().getString(R.string.load_more));
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
            if (this.mCb.mNoDataView != null) {
                this.mCb.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.mCd != null) {
                this.mCd.notifyDataSetChanged();
            }
            if (this.mCf != null) {
                this.mCf.changeSkin(i);
            }
            ap.setBackgroundColor(this.mCb.mCn, R.color.CAM_X0201);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.mCb.mNoDataView != null) {
            this.mCb.mNoDataView.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.mCb.mNoDataView != null) {
            this.mCb.mNoDataView.bvb();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.mCd != null) {
            this.mCd.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.mrg != null) {
            this.mrg.cancelLoadData();
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
            if (i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.mCd != null && this.mrg != null && y.getCount(this.mrg.threadList) > 0) {
                int count = y.getCount(this.mrg.threadList);
                int i3 = 0;
                while (true) {
                    if (i3 >= count) {
                        z = false;
                        break;
                    }
                    q qVar = (q) y.getItem(this.mrg.threadList, i3);
                    if ((qVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) qVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.threadId))) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (z && intent.getIntExtra("type", -1) == 0) {
                    y.remove(this.mrg.threadList, i3);
                    this.mCd.notifyDataSetChanged();
                }
            }
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.joK != null) {
                    this.joK.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.post.PersonThreadFragment.6
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
        if (!this.mCe) {
            this.mCb.mCn.startPullRefresh();
            this.mCe = true;
        }
    }

    public h dCQ() {
        return this.mCb;
    }

    @Override // com.baidu.tieba.post.c
    public void dCL() {
        if (this.mCb != null && this.mCb.mCn != null) {
            this.mCb.mCn.startPullRefresh();
        }
    }

    public void a(d dVar) {
        this.mBY = dVar;
    }

    public void a(b bVar) {
        this.mCg = bVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
    public void a(PersonPostModel personPostModel, boolean z) {
        this.fAV = false;
        if (isAdded()) {
            this.mCb.mCn.completePullRefreshPostDelayed(0L);
            this.mCb.mCn.setEmptyView(null);
            if (personPostModel != null || this.mBX) {
                if (personPostModel == null || (personPostModel.threadList.size() == 0 && this.mBX && StringUtils.isNull(personPostModel.getErrorString()))) {
                    xf(true);
                    return;
                }
                if (personPostModel.threadList.size() == 0 && this.mBX) {
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
                    this.mBX = false;
                }
                this.mCf.xg(this.mHasMore);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MYLIVE_TAB_EDIT_ENABLE));
            }
        }
    }

    private void xf(boolean z) {
        this.mCb.mCn.removeHeaderView(this.mCb.mNoDataView);
        if (z) {
            this.mCb.mNoDataView.setVisibility(0);
            this.mCb.mCn.addHeaderView(this.mCb.mNoDataView);
            this.mCf.getView().setVisibility(8);
            return;
        }
        this.mCf.getView().setVisibility(0);
        this.mCf.dCW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCR() {
        TiebaStatic.log(TbadkCoreStatisticKey.MYLIVE_TO_BE_ANCHOR);
        dCT();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(1, this);
    }

    private void dCS() {
        dCT();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).b(this);
    }

    private void dCT() {
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(true, true, true, this);
    }

    public void dCU() {
        if (this.mrg != null) {
            this.mrg.fetchPost(getPageContext(), this, true, this.mUid, true, this.mCi, false, true, null);
            this.mCh = true;
        }
    }

    public void dCV() {
        if (this.mrg != null) {
            this.mrg.fetchPost(getPageContext(), this, false, this.mUid, true, false, true, null);
        }
    }
}
