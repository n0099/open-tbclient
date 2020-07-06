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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
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
/* loaded from: classes11.dex */
public class PersonThreadFragment extends BaseFragment implements BdListView.e, b.a, PersonPostModel.a, PersonPostModel.b, c {
    private int aOs;
    private ShareSuccessReplyToServerModel hRN;
    private View hwP;
    public PersonPostModel kNc;
    private d kZb;
    private h kZe;
    private FrameLayout kZf;
    private com.baidu.tieba.post.a.a kZg;
    private boolean kZh;
    private a kZi;
    private b kZj;
    private int kZl;
    private com.baidu.tbadk.core.view.g mPullView;
    private String mUid;
    private String kZd = "common";
    private boolean mHasMore = false;
    private boolean kZa = true;
    private boolean kZk = true;
    private boolean ezH = false;
    private CustomMessageListener kZm = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD) { // from class: com.baidu.tieba.post.PersonThreadFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && PersonThreadFragment.this.kZg != null) {
                PersonThreadFragment.this.kZg.Lk((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener kZn = new CustomMessageListener(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE) { // from class: com.baidu.tieba.post.PersonThreadFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.adp.lib.util.l.showToast(PersonThreadFragment.this.getActivity(), (int) R.string.thread_has_hide);
            }
        }
    };
    private final CustomMessageListener dFp = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.post.PersonThreadFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && PersonThreadFragment.this.ezH) {
                    PersonThreadFragment.this.cWP();
                    PersonThreadFragment.this.kZi.bVg();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.a(PersonThreadFragment.this.hwP, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
                } else {
                    BdListViewHelper.a(PersonThreadFragment.this.hwP, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.dFp);
        this.kNc = new PersonPostModel(getPageContext(), getUniqueId(), this, true, PersonPostModel.FROM_PERSON_POST);
        this.kNc.setUniqueId(getUniqueId());
        this.hRN = new ShareSuccessReplyToServerModel();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_thread_fragment, viewGroup, false);
        this.kZf = (FrameLayout) inflate.findViewById(R.id.root_view);
        this.kZe = new h(getActivity(), inflate);
        if (this.kZe.cWS() == null) {
            this.kZe.b(this.kZb);
        }
        if (this.kZe.kZq != null) {
            an.setBackgroundColor(this.kZe.kZq, R.color.cp_bg_line_d);
        }
        String string2 = getArguments().getString("thread_type_key");
        if (!ar.isEmpty(string2)) {
            this.kZd = string2;
        }
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(R.string.to_be_an_liver), new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonThreadFragment.this.cWL();
            }
        });
        int dimension = (int) getResources().getDimension(R.dimen.ds102);
        String str = "";
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, dimension);
        if (this.kZd.equals("photolive")) {
            int i = com.baidu.tbadk.core.sharedPref.b.aVP().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PHOTOLIVE_HOSTLEVEL, -1);
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
                cWM();
            }
        } else {
            string = getArguments().getString("key_empty_view_text");
            bVar = null;
        }
        this.kZe.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.dm(str, string), bVar);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.kZm);
        registerListener(this.kZn);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        if (this.kZd.equals("photolive")) {
            this.kZl = 33;
        }
        this.kZg = new com.baidu.tieba.post.a.a(getPageContext(), this.kZe.kZq);
        this.kZe.cWR().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                CardPersonDynamicThreadData cardPersonDynamicThreadData;
                if (i >= 0 && PersonThreadFragment.this.kZg != null && i < w.getCount(PersonThreadFragment.this.kNc.threadList) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) PersonThreadFragment.this.kZg.kLv.getItem(i)) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PersonThreadFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.threadId), String.valueOf(cardPersonDynamicThreadData.postId), "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB).setThreadData(cardPersonDynamicThreadData.dLi)));
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.g(getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.post.PersonThreadFragment.5
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonThreadFragment.this.kNc != null) {
                    PersonThreadFragment.this.kZa = true;
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        if (PersonThreadFragment.this.kZe != null) {
                            PersonThreadFragment.this.kZe.aI(PersonThreadFragment.this.getString(R.string.neterror), true);
                            return;
                        }
                        return;
                    }
                    PersonThreadFragment.this.cWO();
                }
            }
        });
        this.kZe.kZq.setPullRefresh(this.mPullView);
        if (TbadkCoreApplication.isMyLive) {
            this.hwP = BdListViewHelper.a(getActivity(), this.kZe.kZq, BdListViewHelper.HeadType.DEFAULT);
            BdListViewHelper.a(this.hwP, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        } else {
            this.hwP = BdListViewHelper.a(getActivity(), this.kZe.kZq, BdListViewHelper.HeadType.HASTAB);
            BdListViewHelper.a(this.hwP, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.kZe.kZq.setOnSrollToBottomListener(this);
        this.kZi = new a(getBaseFragmentActivity());
        this.kZe.kZq.setNextPage(this.kZi);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            cWP();
            this.kZi.bVg();
            this.ezH = true;
            return;
        }
        this.kZi.tS(false);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
    public void b(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null && this.kNc != null) {
            if (z) {
                this.kNc.threadList.clear();
            }
            ArrayList<q> arrayList = personPostModel.threadList;
            if (personPostModel.view_card_num > 0 && this.kZk) {
                w.add(arrayList, personPostModel.view_card_num - 1, new com.baidu.tieba.personPolymeric.c.j());
                this.kZk = false;
            }
            if (this.kNc.threadList.isEmpty()) {
                q qVar = (q) w.getItem(arrayList, 0);
                if (qVar instanceof CardPersonDynamicThreadData) {
                    ((CardPersonDynamicThreadData) qVar).gVv = true;
                } else if (qVar instanceof com.baidu.tieba.personPolymeric.c.j) {
                    ((com.baidu.tieba.personPolymeric.c.j) qVar).gVv = true;
                }
            }
            this.kNc.threadList.addAll(arrayList);
            PersonPostModel.mergeDynamicThreadByTime(this.kNc.threadList);
        }
        if (this.kZj != null) {
            this.kZj.tP(personPostModel.isShowRecycleBinRedTip);
        }
        a(personPostModel, z);
        this.kZg.T(this.kNc.threadList);
        this.kZg.notifyDataSetChanged();
    }

    /* loaded from: classes11.dex */
    public static class a extends com.baidu.adp.widget.ListView.c {
        private View eAd;
        private BaseFragmentActivity eZO;
        private int bgColor = R.color.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;
        private int mSkinType = 3;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.eZO = null;
            this.eZO = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.c
        public View createView() {
            this.mRoot = LayoutInflater.from(this.eZO.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.eAd = this.mRoot.findViewById(R.id.pb_more_view);
            an.setBackgroundColor(this.mRoot, this.bgColor);
            an.setBackgroundColor(this.eAd, this.bgColor);
            this.eAd.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            nq(TbadkCoreApplication.getInst().getSkinType());
            an.setViewTextColor(this.mTextView, (int) R.color.common_color_10039);
            this.eAd.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.eZO.getPageContext().getPageActivity(), R.dimen.ds120)));
            return this.mRoot;
        }

        public void nq(int i) {
            this.eZO.getLayoutMode().onModeChanged(this.eAd);
        }

        @SuppressLint({"ResourceAsColor"})
        public void changeSkin(int i) {
            if (this.mSkinType != i) {
                an.setViewTextColor(this.mTextView, (int) R.color.common_color_10039);
                an.setBackgroundColor(this.mRoot, this.bgColor, i);
                an.setBackgroundColor(this.eAd, this.bgColor, i);
                this.mSkinType = i;
            }
        }

        public void bVg() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.eZO.getPageContext().getPageActivity().getText(R.string.loading));
            this.eAd.setVisibility(0);
        }

        public void cWQ() {
            an.setBackgroundColor(this.mRoot, R.color.cp_bg_line_c);
        }

        public void tS(boolean z) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.eAd.setVisibility(0);
                    this.mTextView.setText(this.eZO.getResources().getString(R.string.list_no_more));
                    return;
                }
                this.eAd.setVisibility(0);
                this.mTextView.setText(this.eZO.getResources().getString(R.string.load_more));
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
            if (this.kZe.mNoDataView != null) {
                this.kZe.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.kZg != null) {
                this.kZg.notifyDataSetChanged();
            }
            if (this.kZi != null) {
                this.kZi.changeSkin(i);
            }
            an.setBackgroundColor(this.kZe.kZq, R.color.cp_bg_line_d);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.kZe.mNoDataView != null) {
            this.kZe.mNoDataView.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.kZe.mNoDataView != null) {
            this.kZe.mNoDataView.aXU();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.kZg != null) {
            this.kZg.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.kNc != null) {
            this.kNc.cancelLoadData();
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
            if (i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.kZg != null && this.kNc != null && w.getCount(this.kNc.threadList) > 0) {
                int count = w.getCount(this.kNc.threadList);
                int i3 = 0;
                while (true) {
                    if (i3 >= count) {
                        z = false;
                        break;
                    }
                    q qVar = (q) w.getItem(this.kNc.threadList, i3);
                    if ((qVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) qVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.threadId))) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (z && intent.getIntExtra("type", -1) == 0) {
                    w.remove(this.kNc.threadList, i3);
                    this.kZg.notifyDataSetChanged();
                }
            }
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.hRN != null) {
                    this.hRN.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.post.PersonThreadFragment.6
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void bcu() {
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
        if (!this.kZh) {
            this.kZe.kZq.startPullRefresh();
            this.kZh = true;
        }
    }

    public h cWK() {
        return this.kZe;
    }

    @Override // com.baidu.tieba.post.c
    public void cWF() {
        if (this.kZe != null && this.kZe.kZq != null) {
            this.kZe.kZq.startPullRefresh();
        }
    }

    public void a(d dVar) {
        this.kZb = dVar;
    }

    public void a(b bVar) {
        this.kZj = bVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
    public void a(PersonPostModel personPostModel, boolean z) {
        this.ezH = false;
        if (isAdded()) {
            this.kZe.kZq.completePullRefreshPostDelayed(0L);
            this.kZe.kZq.setEmptyView(null);
            if (personPostModel != null || this.kZa) {
                if (personPostModel == null || (personPostModel.threadList.size() == 0 && this.kZa && StringUtils.isNull(personPostModel.getErrorString()))) {
                    tR(true);
                    return;
                }
                if (personPostModel.threadList.size() == 0 && this.kZa) {
                    tR(true);
                } else {
                    tR(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(getActivity(), personPostModel.getErrorString());
                }
                this.mHasMore = !w.isEmpty(personPostModel.threadList);
                if (z) {
                    if (personPostModel.threadList.size() < 20) {
                        this.mHasMore = false;
                    } else {
                        this.mHasMore = true;
                    }
                    this.aOs = 0;
                    this.kZa = false;
                }
                this.kZi.tS(this.mHasMore);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MYLIVE_TAB_EDIT_ENABLE));
            }
        }
    }

    private void tR(boolean z) {
        this.kZe.kZq.removeHeaderView(this.kZe.mNoDataView);
        if (z) {
            this.kZe.mNoDataView.setVisibility(0);
            this.kZe.kZq.addHeaderView(this.kZe.mNoDataView);
            this.kZi.getView().setVisibility(8);
            return;
        }
        this.kZi.getView().setVisibility(0);
        this.kZi.cWQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWL() {
        TiebaStatic.log(TbadkCoreStatisticKey.MYLIVE_TO_BE_ANCHOR);
        cWN();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(1, this);
    }

    private void cWM() {
        cWN();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).b(this);
    }

    private void cWN() {
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(true, true, true, this);
    }

    public void cWO() {
        if (this.kNc != null) {
            this.kNc.fetchPost(getPageContext(), this, true, this.mUid, true, this.kZl, false, true, null);
            this.kZk = true;
        }
    }

    public void cWP() {
        if (this.kNc != null) {
            this.kNc.fetchPost(getPageContext(), this, false, this.mUid, true, false, true, null);
        }
    }
}
