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
/* loaded from: classes18.dex */
public class PersonThreadFragment extends BaseFragment implements BdListView.e, b.a, PersonPostModel.a, PersonPostModel.b, c {
    private int aVb;
    private View hPS;
    private ShareSuccessReplyToServerModel ilV;
    public PersonPostModel llT;
    private d lwN;
    private h lwQ;
    private FrameLayout lwR;
    private com.baidu.tieba.post.a.a lwS;
    private boolean lwT;
    private a lwU;
    private b lwV;
    private int lwX;
    private com.baidu.tbadk.core.view.g mPullView;
    private String mUid;
    private String lwP = "common";
    private boolean mHasMore = false;
    private boolean lwM = true;
    private boolean lwW = true;
    private boolean eQD = false;
    private CustomMessageListener lwY = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD) { // from class: com.baidu.tieba.post.PersonThreadFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && PersonThreadFragment.this.lwS != null) {
                PersonThreadFragment.this.lwS.OL((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener lwZ = new CustomMessageListener(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE) { // from class: com.baidu.tieba.post.PersonThreadFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.adp.lib.util.l.showToast(PersonThreadFragment.this.getActivity(), R.string.thread_has_hide);
            }
        }
    };
    private final CustomMessageListener dUu = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.post.PersonThreadFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && PersonThreadFragment.this.eQD) {
                    PersonThreadFragment.this.dla();
                    PersonThreadFragment.this.lwU.ciV();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.a(PersonThreadFragment.this.hPS, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
                } else {
                    BdListViewHelper.a(PersonThreadFragment.this.hPS, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.dUu);
        this.llT = new PersonPostModel(getPageContext(), getUniqueId(), this, true, PersonPostModel.FROM_PERSON_POST);
        this.llT.setUniqueId(getUniqueId());
        this.ilV = new ShareSuccessReplyToServerModel();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_thread_fragment, viewGroup, false);
        this.lwR = (FrameLayout) inflate.findViewById(R.id.root_view);
        this.lwQ = new h(getActivity(), inflate);
        if (this.lwQ.dld() == null) {
            this.lwQ.b(this.lwN);
        }
        if (this.lwQ.lxc != null) {
            ap.setBackgroundColor(this.lwQ.lxc, R.color.cp_bg_line_d);
        }
        String string2 = getArguments().getString("thread_type_key");
        if (!at.isEmpty(string2)) {
            this.lwP = string2;
        }
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(R.string.to_be_an_liver), new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonThreadFragment.this.dkW();
            }
        });
        int dimension = (int) getResources().getDimension(R.dimen.ds102);
        String str = "";
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, dimension);
        if (this.lwP.equals("photolive")) {
            int i = com.baidu.tbadk.core.sharedPref.b.bik().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PHOTOLIVE_HOSTLEVEL, -1);
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
                dkX();
            }
        } else {
            string = getArguments().getString("key_empty_view_text");
            bVar = null;
        }
        this.lwQ.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.dE(str, string), bVar);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.lwY);
        registerListener(this.lwZ);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        if (this.lwP.equals("photolive")) {
            this.lwX = 33;
        }
        this.lwS = new com.baidu.tieba.post.a.a(getPageContext(), this.lwQ.lxc);
        this.lwQ.dlc().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                CardPersonDynamicThreadData cardPersonDynamicThreadData;
                if (i >= 0 && PersonThreadFragment.this.lwS != null && i < y.getCount(PersonThreadFragment.this.llT.threadList) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) PersonThreadFragment.this.lwS.lko.getItem(i)) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PersonThreadFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.threadId), String.valueOf(cardPersonDynamicThreadData.postId), "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB).setThreadData(cardPersonDynamicThreadData.dUS)));
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.g(getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.post.PersonThreadFragment.5
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonThreadFragment.this.llT != null) {
                    PersonThreadFragment.this.lwM = true;
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        if (PersonThreadFragment.this.lwQ != null) {
                            PersonThreadFragment.this.lwQ.aK(PersonThreadFragment.this.getString(R.string.neterror), true);
                            return;
                        }
                        return;
                    }
                    PersonThreadFragment.this.dkZ();
                }
            }
        });
        this.lwQ.lxc.setPullRefresh(this.mPullView);
        if (TbadkCoreApplication.isMyLive) {
            this.hPS = BdListViewHelper.a(getActivity(), this.lwQ.lxc, BdListViewHelper.HeadType.DEFAULT);
            BdListViewHelper.a(this.hPS, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        } else {
            this.hPS = BdListViewHelper.a(getActivity(), this.lwQ.lxc, BdListViewHelper.HeadType.HASTAB);
            BdListViewHelper.a(this.hPS, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.lwQ.lxc.setOnSrollToBottomListener(this);
        this.lwU = new a(getBaseFragmentActivity());
        this.lwQ.lxc.setNextPage(this.lwU);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            dla();
            this.lwU.ciV();
            this.eQD = true;
            return;
        }
        this.lwU.vi(false);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
    public void b(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null && this.llT != null) {
            if (z) {
                this.llT.threadList.clear();
            }
            ArrayList<q> arrayList = personPostModel.threadList;
            if (personPostModel.view_card_num > 0 && this.lwW) {
                y.add(arrayList, personPostModel.view_card_num - 1, new com.baidu.tieba.personPolymeric.c.j());
                this.lwW = false;
            }
            if (this.llT.threadList.isEmpty()) {
                q qVar = (q) y.getItem(arrayList, 0);
                if (qVar instanceof CardPersonDynamicThreadData) {
                    ((CardPersonDynamicThreadData) qVar).hnQ = true;
                } else if (qVar instanceof com.baidu.tieba.personPolymeric.c.j) {
                    ((com.baidu.tieba.personPolymeric.c.j) qVar).hnQ = true;
                }
            }
            this.llT.threadList.addAll(arrayList);
            PersonPostModel.mergeDynamicThreadByTime(this.llT.threadList);
        }
        if (this.lwV != null) {
            this.lwV.vf(personPostModel.isShowRecycleBinRedTip);
        }
        a(personPostModel, z);
        this.lwS.aa(this.llT.threadList);
        this.lwS.notifyDataSetChanged();
    }

    /* loaded from: classes18.dex */
    public static class a extends com.baidu.adp.widget.ListView.c {
        private View eQZ;
        private BaseFragmentActivity fpJ;
        private int bgColor = R.color.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;
        private int mSkinType = 3;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.fpJ = null;
            this.fpJ = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.c
        public View createView() {
            this.mRoot = LayoutInflater.from(this.fpJ.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.eQZ = this.mRoot.findViewById(R.id.pb_more_view);
            ap.setBackgroundColor(this.mRoot, this.bgColor);
            ap.setBackgroundColor(this.eQZ, this.bgColor);
            this.eQZ.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            pT(TbadkCoreApplication.getInst().getSkinType());
            ap.setViewTextColor(this.mTextView, R.color.common_color_10039);
            this.eQZ.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.fpJ.getPageContext().getPageActivity(), R.dimen.ds120)));
            return this.mRoot;
        }

        public void pT(int i) {
            this.fpJ.getLayoutMode().onModeChanged(this.eQZ);
        }

        @SuppressLint({"ResourceAsColor"})
        public void changeSkin(int i) {
            if (this.mSkinType != i) {
                ap.setViewTextColor(this.mTextView, R.color.common_color_10039);
                ap.setBackgroundColor(this.mRoot, this.bgColor, i);
                ap.setBackgroundColor(this.eQZ, this.bgColor, i);
                this.mSkinType = i;
            }
        }

        public void ciV() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.fpJ.getPageContext().getPageActivity().getText(R.string.loading));
            this.eQZ.setVisibility(0);
        }

        public void dlb() {
            ap.setBackgroundColor(this.mRoot, R.color.cp_bg_line_c);
        }

        public void vi(boolean z) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.eQZ.setVisibility(0);
                    this.mTextView.setText(this.fpJ.getResources().getString(R.string.list_no_more));
                    return;
                }
                this.eQZ.setVisibility(0);
                this.mTextView.setText(this.fpJ.getResources().getString(R.string.load_more));
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
            if (this.lwQ.mNoDataView != null) {
                this.lwQ.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.lwS != null) {
                this.lwS.notifyDataSetChanged();
            }
            if (this.lwU != null) {
                this.lwU.changeSkin(i);
            }
            ap.setBackgroundColor(this.lwQ.lxc, R.color.cp_bg_line_d);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.lwQ.mNoDataView != null) {
            this.lwQ.mNoDataView.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.lwQ.mNoDataView != null) {
            this.lwQ.mNoDataView.bkq();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.lwS != null) {
            this.lwS.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.llT != null) {
            this.llT.cancelLoadData();
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
            if (i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.lwS != null && this.llT != null && y.getCount(this.llT.threadList) > 0) {
                int count = y.getCount(this.llT.threadList);
                int i3 = 0;
                while (true) {
                    if (i3 >= count) {
                        z = false;
                        break;
                    }
                    q qVar = (q) y.getItem(this.llT.threadList, i3);
                    if ((qVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) qVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.threadId))) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (z && intent.getIntExtra("type", -1) == 0) {
                    y.remove(this.llT.threadList, i3);
                    this.lwS.notifyDataSetChanged();
                }
            }
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.ilV != null) {
                    this.ilV.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.post.PersonThreadFragment.6
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void boY() {
                        }

                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void a(final CustomDialogData customDialogData) {
                            com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.post.PersonThreadFragment.6.1
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
        if (!this.lwT) {
            this.lwQ.lxc.startPullRefresh();
            this.lwT = true;
        }
    }

    public h dkV() {
        return this.lwQ;
    }

    @Override // com.baidu.tieba.post.c
    public void dkQ() {
        if (this.lwQ != null && this.lwQ.lxc != null) {
            this.lwQ.lxc.startPullRefresh();
        }
    }

    public void a(d dVar) {
        this.lwN = dVar;
    }

    public void a(b bVar) {
        this.lwV = bVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
    public void a(PersonPostModel personPostModel, boolean z) {
        this.eQD = false;
        if (isAdded()) {
            this.lwQ.lxc.completePullRefreshPostDelayed(0L);
            this.lwQ.lxc.setEmptyView(null);
            if (personPostModel != null || this.lwM) {
                if (personPostModel == null || (personPostModel.threadList.size() == 0 && this.lwM && StringUtils.isNull(personPostModel.getErrorString()))) {
                    vh(true);
                    return;
                }
                if (personPostModel.threadList.size() == 0 && this.lwM) {
                    vh(true);
                } else {
                    vh(false);
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
                    this.aVb = 0;
                    this.lwM = false;
                }
                this.lwU.vi(this.mHasMore);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MYLIVE_TAB_EDIT_ENABLE));
            }
        }
    }

    private void vh(boolean z) {
        this.lwQ.lxc.removeHeaderView(this.lwQ.mNoDataView);
        if (z) {
            this.lwQ.mNoDataView.setVisibility(0);
            this.lwQ.lxc.addHeaderView(this.lwQ.mNoDataView);
            this.lwU.getView().setVisibility(8);
            return;
        }
        this.lwU.getView().setVisibility(0);
        this.lwU.dlb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkW() {
        TiebaStatic.log(TbadkCoreStatisticKey.MYLIVE_TO_BE_ANCHOR);
        dkY();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(1, this);
    }

    private void dkX() {
        dkY();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).b(this);
    }

    private void dkY() {
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(true, true, true, this);
    }

    public void dkZ() {
        if (this.llT != null) {
            this.llT.fetchPost(getPageContext(), this, true, this.mUid, true, this.lwX, false, true, null);
            this.lwW = true;
        }
    }

    public void dla() {
        if (this.llT != null) {
            this.llT.fetchPost(getPageContext(), this, false, this.mUid, true, false, true, null);
        }
    }
}
