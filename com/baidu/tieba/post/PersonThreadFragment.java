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
    private int baQ;
    private ShareSuccessReplyToServerModel iId;
    private View ilX;
    public PersonPostModel lKn;
    private d lVd;
    private h lVg;
    private FrameLayout lVh;
    private com.baidu.tieba.post.a.a lVi;
    private boolean lVj;
    private a lVk;
    private b lVl;
    private int lVn;
    private com.baidu.tbadk.core.view.g mPullView;
    private String mUid;
    private String lVf = "common";
    private boolean mHasMore = false;
    private boolean lVc = true;
    private boolean lVm = true;
    private boolean ffG = false;
    private CustomMessageListener lVo = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD) { // from class: com.baidu.tieba.post.PersonThreadFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && PersonThreadFragment.this.lVi != null) {
                PersonThreadFragment.this.lVi.Qc((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener lVp = new CustomMessageListener(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE) { // from class: com.baidu.tieba.post.PersonThreadFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.adp.lib.util.l.showToast(PersonThreadFragment.this.getActivity(), R.string.thread_has_hide);
            }
        }
    };
    private final CustomMessageListener eiK = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.post.PersonThreadFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && PersonThreadFragment.this.ffG) {
                    PersonThreadFragment.this.dsv();
                    PersonThreadFragment.this.lVk.cpH();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.a(PersonThreadFragment.this.ilX, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
                } else {
                    BdListViewHelper.a(PersonThreadFragment.this.ilX, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.eiK);
        this.lKn = new PersonPostModel(getPageContext(), getUniqueId(), this, true, PersonPostModel.FROM_PERSON_POST);
        this.lKn.setUniqueId(getUniqueId());
        this.iId = new ShareSuccessReplyToServerModel();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_thread_fragment, viewGroup, false);
        this.lVh = (FrameLayout) inflate.findViewById(R.id.root_view);
        this.lVg = new h(getActivity(), inflate);
        if (this.lVg.dsy() == null) {
            this.lVg.b(this.lVd);
        }
        if (this.lVg.lVs != null) {
            ap.setBackgroundColor(this.lVg.lVs, R.color.cp_bg_line_d);
        }
        String string2 = getArguments().getString("thread_type_key");
        if (!at.isEmpty(string2)) {
            this.lVf = string2;
        }
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(R.string.to_be_an_liver), new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonThreadFragment.this.dsr();
            }
        });
        int dimension = (int) getResources().getDimension(R.dimen.ds102);
        String str = "";
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, dimension);
        if (this.lVf.equals("photolive")) {
            int i = com.baidu.tbadk.core.sharedPref.b.blO().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PHOTOLIVE_HOSTLEVEL, -1);
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
                dss();
            }
        } else {
            string = getArguments().getString("key_empty_view_text");
            bVar = null;
        }
        this.lVg.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.dL(str, string), bVar);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.lVo);
        registerListener(this.lVp);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        if (this.lVf.equals("photolive")) {
            this.lVn = 33;
        }
        this.lVi = new com.baidu.tieba.post.a.a(getPageContext(), this.lVg.lVs);
        this.lVg.dsx().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                CardPersonDynamicThreadData cardPersonDynamicThreadData;
                if (i >= 0 && PersonThreadFragment.this.lVi != null && i < y.getCount(PersonThreadFragment.this.lKn.threadList) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) PersonThreadFragment.this.lVi.lII.getItem(i)) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PersonThreadFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.threadId), String.valueOf(cardPersonDynamicThreadData.postId), "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB).setThreadData(cardPersonDynamicThreadData.eji)));
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.g(getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.post.PersonThreadFragment.5
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonThreadFragment.this.lKn != null) {
                    PersonThreadFragment.this.lVc = true;
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        if (PersonThreadFragment.this.lVg != null) {
                            PersonThreadFragment.this.lVg.aO(PersonThreadFragment.this.getString(R.string.neterror), true);
                            return;
                        }
                        return;
                    }
                    PersonThreadFragment.this.dsu();
                }
            }
        });
        this.lVg.lVs.setPullRefresh(this.mPullView);
        if (TbadkCoreApplication.isMyLive) {
            this.ilX = BdListViewHelper.a(getActivity(), this.lVg.lVs, BdListViewHelper.HeadType.DEFAULT);
            BdListViewHelper.a(this.ilX, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        } else {
            this.ilX = BdListViewHelper.a(getActivity(), this.lVg.lVs, BdListViewHelper.HeadType.HASTAB);
            BdListViewHelper.a(this.ilX, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.lVg.lVs.setOnSrollToBottomListener(this);
        this.lVk = new a(getBaseFragmentActivity());
        this.lVg.lVs.setNextPage(this.lVk);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            dsv();
            this.lVk.cpH();
            this.ffG = true;
            return;
        }
        this.lVk.vZ(false);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
    public void b(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null && this.lKn != null) {
            if (z) {
                this.lKn.threadList.clear();
            }
            ArrayList<q> arrayList = personPostModel.threadList;
            if (personPostModel.view_card_num > 0 && this.lVm) {
                y.add(arrayList, personPostModel.view_card_num - 1, new com.baidu.tieba.personPolymeric.c.j());
                this.lVm = false;
            }
            if (this.lKn.threadList.isEmpty()) {
                q qVar = (q) y.getItem(arrayList, 0);
                if (qVar instanceof CardPersonDynamicThreadData) {
                    ((CardPersonDynamicThreadData) qVar).hJT = true;
                } else if (qVar instanceof com.baidu.tieba.personPolymeric.c.j) {
                    ((com.baidu.tieba.personPolymeric.c.j) qVar).hJT = true;
                }
            }
            this.lKn.threadList.addAll(arrayList);
            PersonPostModel.mergeDynamicThreadByTime(this.lKn.threadList);
        }
        if (this.lVl != null) {
            this.lVl.vW(personPostModel.isShowRecycleBinRedTip);
        }
        a(personPostModel, z);
        this.lVi.aa(this.lKn.threadList);
        this.lVi.notifyDataSetChanged();
    }

    /* loaded from: classes24.dex */
    public static class a extends com.baidu.adp.widget.ListView.c {
        private BaseFragmentActivity fFk;
        private View fgc;
        private int bgColor = R.color.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;
        private int mSkinType = 3;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.fFk = null;
            this.fFk = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.c
        public View createView() {
            this.mRoot = LayoutInflater.from(this.fFk.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.fgc = this.mRoot.findViewById(R.id.pb_more_view);
            ap.setBackgroundColor(this.mRoot, this.bgColor);
            ap.setBackgroundColor(this.fgc, this.bgColor);
            this.fgc.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            qE(TbadkCoreApplication.getInst().getSkinType());
            ap.setViewTextColor(this.mTextView, R.color.common_color_10039);
            this.fgc.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.fFk.getPageContext().getPageActivity(), R.dimen.ds120)));
            return this.mRoot;
        }

        public void qE(int i) {
            this.fFk.getLayoutMode().onModeChanged(this.fgc);
        }

        @SuppressLint({"ResourceAsColor"})
        public void changeSkin(int i) {
            if (this.mSkinType != i) {
                ap.setViewTextColor(this.mTextView, R.color.common_color_10039);
                ap.setBackgroundColor(this.mRoot, this.bgColor, i);
                ap.setBackgroundColor(this.fgc, this.bgColor, i);
                this.mSkinType = i;
            }
        }

        public void cpH() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.fFk.getPageContext().getPageActivity().getText(R.string.loading));
            this.fgc.setVisibility(0);
        }

        public void dsw() {
            ap.setBackgroundColor(this.mRoot, R.color.cp_bg_line_c);
        }

        public void vZ(boolean z) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.fgc.setVisibility(0);
                    this.mTextView.setText(this.fFk.getResources().getString(R.string.list_no_more));
                    return;
                }
                this.fgc.setVisibility(0);
                this.mTextView.setText(this.fFk.getResources().getString(R.string.load_more));
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
            if (this.lVg.mNoDataView != null) {
                this.lVg.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.lVi != null) {
                this.lVi.notifyDataSetChanged();
            }
            if (this.lVk != null) {
                this.lVk.changeSkin(i);
            }
            ap.setBackgroundColor(this.lVg.lVs, R.color.cp_bg_line_d);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.lVg.mNoDataView != null) {
            this.lVg.mNoDataView.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.lVg.mNoDataView != null) {
            this.lVg.mNoDataView.bnV();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.lVi != null) {
            this.lVi.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.lKn != null) {
            this.lKn.cancelLoadData();
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
            if (i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.lVi != null && this.lKn != null && y.getCount(this.lKn.threadList) > 0) {
                int count = y.getCount(this.lKn.threadList);
                int i3 = 0;
                while (true) {
                    if (i3 >= count) {
                        z = false;
                        break;
                    }
                    q qVar = (q) y.getItem(this.lKn.threadList, i3);
                    if ((qVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) qVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.threadId))) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (z && intent.getIntExtra("type", -1) == 0) {
                    y.remove(this.lKn.threadList, i3);
                    this.lVi.notifyDataSetChanged();
                }
            }
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.iId != null) {
                    this.iId.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.post.PersonThreadFragment.6
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void bsD() {
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
        if (!this.lVj) {
            this.lVg.lVs.startPullRefresh();
            this.lVj = true;
        }
    }

    public h dsq() {
        return this.lVg;
    }

    @Override // com.baidu.tieba.post.c
    public void dsl() {
        if (this.lVg != null && this.lVg.lVs != null) {
            this.lVg.lVs.startPullRefresh();
        }
    }

    public void a(d dVar) {
        this.lVd = dVar;
    }

    public void a(b bVar) {
        this.lVl = bVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
    public void a(PersonPostModel personPostModel, boolean z) {
        this.ffG = false;
        if (isAdded()) {
            this.lVg.lVs.completePullRefreshPostDelayed(0L);
            this.lVg.lVs.setEmptyView(null);
            if (personPostModel != null || this.lVc) {
                if (personPostModel == null || (personPostModel.threadList.size() == 0 && this.lVc && StringUtils.isNull(personPostModel.getErrorString()))) {
                    vY(true);
                    return;
                }
                if (personPostModel.threadList.size() == 0 && this.lVc) {
                    vY(true);
                } else {
                    vY(false);
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
                    this.baQ = 0;
                    this.lVc = false;
                }
                this.lVk.vZ(this.mHasMore);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MYLIVE_TAB_EDIT_ENABLE));
            }
        }
    }

    private void vY(boolean z) {
        this.lVg.lVs.removeHeaderView(this.lVg.mNoDataView);
        if (z) {
            this.lVg.mNoDataView.setVisibility(0);
            this.lVg.lVs.addHeaderView(this.lVg.mNoDataView);
            this.lVk.getView().setVisibility(8);
            return;
        }
        this.lVk.getView().setVisibility(0);
        this.lVk.dsw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dsr() {
        TiebaStatic.log(TbadkCoreStatisticKey.MYLIVE_TO_BE_ANCHOR);
        dst();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(1, this);
    }

    private void dss() {
        dst();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).b(this);
    }

    private void dst() {
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(true, true, true, this);
    }

    public void dsu() {
        if (this.lKn != null) {
            this.lKn.fetchPost(getPageContext(), this, true, this.mUid, true, this.lVn, false, true, null);
            this.lVm = true;
        }
    }

    public void dsv() {
        if (this.lKn != null) {
            this.lKn.fetchPost(getPageContext(), this, false, this.mUid, true, false, true, null);
        }
    }
}
