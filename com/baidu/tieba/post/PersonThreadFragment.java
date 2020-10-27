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
import com.baidu.tbadk.core.util.at;
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
    private int bcd;
    private ShareSuccessReplyToServerModel iUz;
    private View iyv;
    public PersonPostModel lWJ;
    private com.baidu.tbadk.core.view.g mPullView;
    private String mUid;
    private d mhC;
    private h mhF;
    private FrameLayout mhG;
    private com.baidu.tieba.post.a.a mhH;
    private boolean mhI;
    private a mhJ;
    private b mhK;
    private int mhM;
    private String mhE = "common";
    private boolean mHasMore = false;
    private boolean mhB = true;
    private boolean mhL = true;
    private boolean fof = false;
    private CustomMessageListener mhN = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD) { // from class: com.baidu.tieba.post.PersonThreadFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && PersonThreadFragment.this.mhH != null) {
                PersonThreadFragment.this.mhH.QA((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener mhO = new CustomMessageListener(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE) { // from class: com.baidu.tieba.post.PersonThreadFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.adp.lib.util.l.showToast(PersonThreadFragment.this.getActivity(), R.string.thread_has_hide);
            }
        }
    };
    private final CustomMessageListener eri = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.post.PersonThreadFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && PersonThreadFragment.this.fof) {
                    PersonThreadFragment.this.dvC();
                    PersonThreadFragment.this.mhJ.csO();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.a(PersonThreadFragment.this.iyv, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
                } else {
                    BdListViewHelper.a(PersonThreadFragment.this.iyv, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.eri);
        this.lWJ = new PersonPostModel(getPageContext(), getUniqueId(), this, true, PersonPostModel.FROM_PERSON_POST);
        this.lWJ.setUniqueId(getUniqueId());
        this.iUz = new ShareSuccessReplyToServerModel();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_thread_fragment, viewGroup, false);
        this.mhG = (FrameLayout) inflate.findViewById(R.id.root_view);
        this.mhF = new h(getActivity(), inflate);
        if (this.mhF.dvF() == null) {
            this.mhF.b(this.mhC);
        }
        if (this.mhF.mhR != null) {
            ap.setBackgroundColor(this.mhF.mhR, R.color.cp_bg_line_d);
        }
        String string2 = getArguments().getString("thread_type_key");
        if (!at.isEmpty(string2)) {
            this.mhE = string2;
        }
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(R.string.to_be_an_liver), new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonThreadFragment.this.dvy();
            }
        });
        int dimension = (int) getResources().getDimension(R.dimen.ds102);
        String str = "";
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, dimension);
        if (this.mhE.equals("photolive")) {
            int i = com.baidu.tbadk.core.sharedPref.b.bnH().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PHOTOLIVE_HOSTLEVEL, -1);
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
                dvz();
            }
        } else {
            string = getArguments().getString("key_empty_view_text");
            bVar = null;
        }
        this.mhF.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.dS(str, string), bVar);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.mhN);
        registerListener(this.mhO);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        if (this.mhE.equals("photolive")) {
            this.mhM = 33;
        }
        this.mhH = new com.baidu.tieba.post.a.a(getPageContext(), this.mhF.mhR);
        this.mhF.dvE().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                CardPersonDynamicThreadData cardPersonDynamicThreadData;
                if (i >= 0 && PersonThreadFragment.this.mhH != null && i < y.getCount(PersonThreadFragment.this.lWJ.threadList) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) PersonThreadFragment.this.mhH.lVe.getItem(i)) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PersonThreadFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.threadId), String.valueOf(cardPersonDynamicThreadData.postId), "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB).setThreadData(cardPersonDynamicThreadData.erH)));
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.g(getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.post.PersonThreadFragment.5
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonThreadFragment.this.lWJ != null) {
                    PersonThreadFragment.this.mhB = true;
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        if (PersonThreadFragment.this.mhF != null) {
                            PersonThreadFragment.this.mhF.aQ(PersonThreadFragment.this.getString(R.string.neterror), true);
                            return;
                        }
                        return;
                    }
                    PersonThreadFragment.this.dvB();
                }
            }
        });
        this.mhF.mhR.setPullRefresh(this.mPullView);
        if (TbadkCoreApplication.isMyLive) {
            this.iyv = BdListViewHelper.a(getActivity(), this.mhF.mhR, BdListViewHelper.HeadType.DEFAULT);
            BdListViewHelper.a(this.iyv, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        } else {
            this.iyv = BdListViewHelper.a(getActivity(), this.mhF.mhR, BdListViewHelper.HeadType.HASTAB);
            BdListViewHelper.a(this.iyv, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.mhF.mhR.setOnSrollToBottomListener(this);
        this.mhJ = new a(getBaseFragmentActivity());
        this.mhF.mhR.setNextPage(this.mhJ);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            dvC();
            this.mhJ.csO();
            this.fof = true;
            return;
        }
        this.mhJ.wq(false);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
    public void b(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null && this.lWJ != null) {
            if (z) {
                this.lWJ.threadList.clear();
            }
            ArrayList<q> arrayList = personPostModel.threadList;
            if (personPostModel.view_card_num > 0 && this.mhL) {
                y.add(arrayList, personPostModel.view_card_num - 1, new com.baidu.tieba.personPolymeric.c.j());
                this.mhL = false;
            }
            if (this.lWJ.threadList.isEmpty()) {
                q qVar = (q) y.getItem(arrayList, 0);
                if (qVar instanceof CardPersonDynamicThreadData) {
                    ((CardPersonDynamicThreadData) qVar).hWq = true;
                } else if (qVar instanceof com.baidu.tieba.personPolymeric.c.j) {
                    ((com.baidu.tieba.personPolymeric.c.j) qVar).hWq = true;
                }
            }
            this.lWJ.threadList.addAll(arrayList);
            PersonPostModel.mergeDynamicThreadByTime(this.lWJ.threadList);
        }
        if (this.mhK != null) {
            this.mhK.wn(personPostModel.isShowRecycleBinRedTip);
        }
        a(personPostModel, z);
        this.mhH.aa(this.lWJ.threadList);
        this.mhH.notifyDataSetChanged();
    }

    /* loaded from: classes24.dex */
    public static class a extends com.baidu.adp.widget.ListView.c {
        private BaseFragmentActivity fNF;
        private View foB;
        private int bgColor = R.color.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;
        private int mSkinType = 3;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.fNF = null;
            this.fNF = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.c
        public View createView() {
            this.mRoot = LayoutInflater.from(this.fNF.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.foB = this.mRoot.findViewById(R.id.pb_more_view);
            ap.setBackgroundColor(this.mRoot, this.bgColor);
            ap.setBackgroundColor(this.foB, this.bgColor);
            this.foB.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            qP(TbadkCoreApplication.getInst().getSkinType());
            ap.setViewTextColor(this.mTextView, R.color.common_color_10039);
            this.foB.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.fNF.getPageContext().getPageActivity(), R.dimen.ds120)));
            return this.mRoot;
        }

        public void qP(int i) {
            this.fNF.getLayoutMode().onModeChanged(this.foB);
        }

        @SuppressLint({"ResourceAsColor"})
        public void changeSkin(int i) {
            if (this.mSkinType != i) {
                ap.setViewTextColor(this.mTextView, R.color.common_color_10039);
                ap.setBackgroundColor(this.mRoot, this.bgColor, i);
                ap.setBackgroundColor(this.foB, this.bgColor, i);
                this.mSkinType = i;
            }
        }

        public void csO() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.fNF.getPageContext().getPageActivity().getText(R.string.loading));
            this.foB.setVisibility(0);
        }

        public void dvD() {
            ap.setBackgroundColor(this.mRoot, R.color.cp_bg_line_c);
        }

        public void wq(boolean z) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.foB.setVisibility(0);
                    this.mTextView.setText(this.fNF.getResources().getString(R.string.list_no_more));
                    return;
                }
                this.foB.setVisibility(0);
                this.mTextView.setText(this.fNF.getResources().getString(R.string.load_more));
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
            if (this.mhF.mNoDataView != null) {
                this.mhF.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.mhH != null) {
                this.mhH.notifyDataSetChanged();
            }
            if (this.mhJ != null) {
                this.mhJ.changeSkin(i);
            }
            ap.setBackgroundColor(this.mhF.mhR, R.color.cp_bg_line_d);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.mhF.mNoDataView != null) {
            this.mhF.mNoDataView.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.mhF.mNoDataView != null) {
            this.mhF.mNoDataView.bpO();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.mhH != null) {
            this.mhH.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.lWJ != null) {
            this.lWJ.cancelLoadData();
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
            if (i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.mhH != null && this.lWJ != null && y.getCount(this.lWJ.threadList) > 0) {
                int count = y.getCount(this.lWJ.threadList);
                int i3 = 0;
                while (true) {
                    if (i3 >= count) {
                        z = false;
                        break;
                    }
                    q qVar = (q) y.getItem(this.lWJ.threadList, i3);
                    if ((qVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) qVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.threadId))) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (z && intent.getIntExtra("type", -1) == 0) {
                    y.remove(this.lWJ.threadList, i3);
                    this.mhH.notifyDataSetChanged();
                }
            }
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.iUz != null) {
                    this.iUz.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.post.PersonThreadFragment.6
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void buw() {
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
        if (!this.mhI) {
            this.mhF.mhR.startPullRefresh();
            this.mhI = true;
        }
    }

    public h dvx() {
        return this.mhF;
    }

    @Override // com.baidu.tieba.post.c
    public void dvs() {
        if (this.mhF != null && this.mhF.mhR != null) {
            this.mhF.mhR.startPullRefresh();
        }
    }

    public void a(d dVar) {
        this.mhC = dVar;
    }

    public void a(b bVar) {
        this.mhK = bVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
    public void a(PersonPostModel personPostModel, boolean z) {
        this.fof = false;
        if (isAdded()) {
            this.mhF.mhR.completePullRefreshPostDelayed(0L);
            this.mhF.mhR.setEmptyView(null);
            if (personPostModel != null || this.mhB) {
                if (personPostModel == null || (personPostModel.threadList.size() == 0 && this.mhB && StringUtils.isNull(personPostModel.getErrorString()))) {
                    wp(true);
                    return;
                }
                if (personPostModel.threadList.size() == 0 && this.mhB) {
                    wp(true);
                } else {
                    wp(false);
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
                    this.bcd = 0;
                    this.mhB = false;
                }
                this.mhJ.wq(this.mHasMore);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MYLIVE_TAB_EDIT_ENABLE));
            }
        }
    }

    private void wp(boolean z) {
        this.mhF.mhR.removeHeaderView(this.mhF.mNoDataView);
        if (z) {
            this.mhF.mNoDataView.setVisibility(0);
            this.mhF.mhR.addHeaderView(this.mhF.mNoDataView);
            this.mhJ.getView().setVisibility(8);
            return;
        }
        this.mhJ.getView().setVisibility(0);
        this.mhJ.dvD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvy() {
        TiebaStatic.log(TbadkCoreStatisticKey.MYLIVE_TO_BE_ANCHOR);
        dvA();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(1, this);
    }

    private void dvz() {
        dvA();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).b(this);
    }

    private void dvA() {
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(true, true, true, this);
    }

    public void dvB() {
        if (this.lWJ != null) {
            this.lWJ.fetchPost(getPageContext(), this, true, this.mUid, true, this.mhM, false, true, null);
            this.mhL = true;
        }
    }

    public void dvC() {
        if (this.lWJ != null) {
            this.lWJ.fetchPost(getPageContext(), this, false, this.mUid, true, false, true, null);
        }
    }
}
