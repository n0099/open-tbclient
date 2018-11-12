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
import com.baidu.fsg.base.utils.PhoneUtils;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.d.b;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.e;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class PersonThreadFragment extends BaseFragment implements BdListView.e, b.a, PersonPostModel.a, PersonPostModel.b, c {
    private ShareSuccessReplyToServerModel dRe;
    private View dzj;
    public PersonPostModel gqD;
    private int gzD;
    private d gzF;
    private h gzI;
    private FrameLayout gzJ;
    private com.baidu.tieba.post.a.a gzK;
    private boolean gzL;
    private a gzM;
    private b gzN;
    private int gzP;
    private com.baidu.tbadk.core.view.k mPullView;
    private String mUid;
    private String gzH = PhoneUtils.CPUInfo.FEATURE_COMMON;
    private boolean mHasMore = false;
    private boolean gzE = true;
    private boolean gzO = true;
    private boolean bbl = false;
    private CustomMessageListener gqE = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.post.PersonThreadFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && PersonThreadFragment.this.gzK != null) {
                PersonThreadFragment.this.gzK.tD((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gqF = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.post.PersonThreadFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.adp.lib.util.l.showToast(PersonThreadFragment.this.getActivity(), e.j.thread_has_hide);
            }
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.post.PersonThreadFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (com.baidu.adp.lib.util.j.kV() && PersonThreadFragment.this.bbl) {
                    PersonThreadFragment.this.bqI();
                    PersonThreadFragment.this.gzM.avy();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.a(PersonThreadFragment.this.dzj, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kV());
                } else {
                    BdListViewHelper.a(PersonThreadFragment.this.dzj, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.mNetworkChangedMessageListener);
        this.gqD = new PersonPostModel(getPageContext(), getUniqueId(), this, true, PersonPostModel.FROM_PERSON_POST);
        this.gqD.setUniqueId(getUniqueId());
        this.dRe = new ShareSuccessReplyToServerModel();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(e.h.person_thread_fragment, viewGroup, false);
        this.gzJ = (FrameLayout) inflate.findViewById(e.g.root_view);
        this.gzI = new h(getActivity(), inflate);
        if (this.gzI.bqL() == null) {
            this.gzI.b(this.gzF);
        }
        if (this.gzI.gzS != null) {
            al.j(this.gzI.gzS, e.d.cp_bg_line_d);
        }
        String string2 = getArguments().getString("thread_type_key");
        if (!ao.isEmpty(string2)) {
            this.gzH = string2;
        }
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(e.j.to_be_an_liver), new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonThreadFragment.this.bqE();
            }
        });
        int dimension = (int) getResources().getDimension(e.C0200e.ds102);
        String str = "";
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension);
        if (this.gzH.equals("photolive")) {
            int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1);
            if (i == 0) {
                str = getPageContext().getResources().getString(e.j.to_live_to_god);
                string = getPageContext().getResources().getString(e.j.user_not_liver);
                a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, e.f.go_to_live_pic, dimension, -1, -1);
                bVar = NoDataViewFactory.b.a(aVar);
            } else {
                string = getPageContext().getResources().getString(e.j.person_post_lv_empty_host);
                bVar = null;
            }
            if (i < 0) {
                bqF();
            }
        } else {
            string = getArguments().getString("key_empty_view_text");
            bVar = null;
        }
        this.gzI.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.aA(string, str), bVar);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.gqE);
        registerListener(this.gqF);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        if (this.gzH.equals("photolive")) {
            this.gzP = 33;
        }
        this.gzK = new com.baidu.tieba.post.a.a(getPageContext(), this.gzI.gzS);
        this.gzI.bqK().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                CardPersonDynamicThreadData cardPersonDynamicThreadData;
                if (i >= 0 && PersonThreadFragment.this.gzK != null && i < v.H(PersonThreadFragment.this.gqD.threadList) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) PersonThreadFragment.this.gzK.gpo.getItem(i)) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonThreadFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.threadId), String.valueOf(cardPersonDynamicThreadData.postId), "person_page", 18005)));
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.k(getPageContext());
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.post.PersonThreadFragment.5
            @Override // com.baidu.tbadk.core.view.j.b
            public void bG(boolean z) {
                if (PersonThreadFragment.this.gqD != null) {
                    PersonThreadFragment.this.gzE = true;
                    if (!com.baidu.adp.lib.util.j.kK()) {
                        if (PersonThreadFragment.this.gzI != null) {
                            PersonThreadFragment.this.gzI.M(PersonThreadFragment.this.getString(e.j.neterror), true);
                            return;
                        }
                        return;
                    }
                    PersonThreadFragment.this.bqH();
                }
            }
        });
        this.gzI.gzS.setPullRefresh(this.mPullView);
        if (TbadkCoreApplication.isMyLive) {
            this.dzj = BdListViewHelper.a(getActivity(), this.gzI.gzS, BdListViewHelper.HeadType.DEFAULT);
            BdListViewHelper.a(this.dzj, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kV());
        } else {
            this.dzj = BdListViewHelper.a(getActivity(), this.gzI.gzS, BdListViewHelper.HeadType.HASTAB);
            BdListViewHelper.a(this.dzj, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.gzI.gzS.setOnSrollToBottomListener(this);
        this.gzM = new a(getBaseFragmentActivity());
        this.gzI.gzS.setNextPage(this.gzM);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            bqI();
            this.gzM.avy();
            this.bbl = true;
            return;
        }
        this.gzM.mD(false);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
    public void b(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null && this.gqD != null) {
            if (z) {
                this.gqD.threadList.clear();
            }
            ArrayList<com.baidu.adp.widget.ListView.h> arrayList = personPostModel.threadList;
            if (personPostModel.view_card_num > 0 && this.gzO) {
                v.a(arrayList, personPostModel.view_card_num - 1, new com.baidu.tieba.personPolymeric.c.j());
                this.gzO = false;
            }
            if (this.gqD.threadList.isEmpty()) {
                com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) v.d(arrayList, 0);
                if (hVar instanceof CardPersonDynamicThreadData) {
                    ((CardPersonDynamicThreadData) hVar).cSe = true;
                } else if (hVar instanceof com.baidu.tieba.personPolymeric.c.j) {
                    ((com.baidu.tieba.personPolymeric.c.j) hVar).cSe = true;
                }
            }
            this.gqD.threadList.addAll(arrayList);
            PersonPostModel.mergeDynamicThreadByTime(this.gqD.threadList);
        }
        if (this.gzN != null) {
            this.gzN.mA(personPostModel.isShowRecycleBinRedTip);
        }
        a(personPostModel, z);
        this.gzK.C(this.gqD.threadList);
        this.gzK.notifyDataSetChanged();
    }

    /* loaded from: classes3.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private View bbH;
        private BaseFragmentActivity byX;
        private int bgColor = e.d.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View ajk = null;
        private int mSkinType = 3;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.byX = null;
            this.byX = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View oE() {
            this.ajk = LayoutInflater.from(this.byX.getPageContext().getContext()).inflate(e.h.new_pb_list_more, (ViewGroup) null);
            this.mTextView = (TextView) this.ajk.findViewById(e.g.pb_more_text);
            this.bbH = this.ajk.findViewById(e.g.pb_more_view);
            al.j(this.ajk, this.bgColor);
            al.j(this.bbH, this.bgColor);
            this.bbH.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.ajk.findViewById(e.g.progress);
            fg(TbadkCoreApplication.getInst().getSkinType());
            al.h(this.mTextView, e.d.common_color_10039);
            this.bbH.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.byX.getPageContext().getPageActivity(), e.C0200e.ds120)));
            return this.ajk;
        }

        public void fg(int i) {
            this.byX.getLayoutMode().onModeChanged(this.bbH);
        }

        @SuppressLint({"ResourceAsColor"})
        public void ek(int i) {
            if (this.mSkinType != i) {
                al.h(this.mTextView, e.d.common_color_10039);
                al.e(this.ajk, this.bgColor, i);
                al.e(this.bbH, this.bgColor, i);
                this.mSkinType = i;
            }
        }

        public void avy() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.byX.getPageContext().getPageActivity().getText(e.j.loading));
            this.bbH.setVisibility(0);
        }

        public void bqJ() {
            al.j(this.ajk, e.d.cp_bg_line_c);
        }

        public void mD(boolean z) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.bbH.setVisibility(0);
                    this.mTextView.setText(this.byX.getResources().getString(e.j.list_no_more));
                    return;
                }
                this.bbH.setVisibility(0);
                this.mTextView.setText(this.byX.getResources().getString(e.j.load_more));
            }
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.ajk);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.gzI.mNoDataView != null) {
                this.gzI.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.ek(i);
            }
            if (this.gzK != null) {
                this.gzK.notifyDataSetChanged();
            }
            if (this.gzM != null) {
                this.gzM.ek(i);
            }
            al.j(this.gzI.gzS, e.d.cp_bg_line_d);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.gzI.mNoDataView != null) {
            this.gzI.mNoDataView.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.gzI.mNoDataView != null) {
            this.gzI.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.gzK != null) {
            this.gzK.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.gqD != null) {
            this.gqD.cancelLoadData();
        }
        try {
            com.baidu.tbadk.d.a.resetAll();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        BdAsyncTask.removeAllTask(SetPrivacyModel.UNIQUE_ID_SET_PRIVACY_TASK);
        BdAsyncTask.removeAllTask(ForumManageModel.UNIQUE_ID_DEL_POST_TASK);
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.coreExtra.c.d shareItem;
        String stringExtra;
        boolean z;
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.gzK != null && this.gqD != null && v.H(this.gqD.threadList) > 0) {
                int H = v.H(this.gqD.threadList);
                int i3 = 0;
                while (true) {
                    if (i3 >= H) {
                        z = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) v.d(this.gqD.threadList, i3);
                    if ((hVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) hVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.threadId))) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (z && intent.getIntExtra("type", -1) == 0) {
                    v.e(this.gqD.threadList, i3);
                    this.gzK.notifyDataSetChanged();
                }
            }
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.dRe != null) {
                    this.dRe.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.post.PersonThreadFragment.6
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void HU() {
                        }

                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void a(final CustomDialogData customDialogData) {
                            com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.post.PersonThreadFragment.6.1
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
        if (!this.gzL) {
            this.gzI.gzS.startPullRefresh();
            this.gzL = true;
        }
    }

    public h bqD() {
        return this.gzI;
    }

    @Override // com.baidu.tieba.post.c
    public void bqx() {
        if (this.gzI != null && this.gzI.gzS != null) {
            this.gzI.gzS.startPullRefresh();
        }
    }

    public void a(d dVar) {
        this.gzF = dVar;
    }

    public void a(b bVar) {
        this.gzN = bVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
    public void a(PersonPostModel personPostModel, boolean z) {
        this.bbl = false;
        if (isAdded()) {
            this.gzI.gzS.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            this.gzI.gzS.setEmptyView(null);
            if (personPostModel != null || this.gzE) {
                if (personPostModel == null || (personPostModel.threadList.size() == 0 && this.gzE && StringUtils.isNull(personPostModel.getErrorString()))) {
                    mC(true);
                    return;
                }
                if (personPostModel.threadList.size() == 0 && this.gzE) {
                    mC(true);
                } else {
                    mC(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(getActivity(), personPostModel.getErrorString());
                }
                this.mHasMore = !v.I(personPostModel.threadList);
                if (z) {
                    if (personPostModel.threadList.size() < 20) {
                        this.mHasMore = false;
                    } else {
                        this.mHasMore = true;
                    }
                    this.gzD = 0;
                    this.gzE = false;
                }
                this.gzM.mD(this.mHasMore);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016221));
            }
        }
    }

    private void mC(boolean z) {
        this.gzI.gzS.removeHeaderView(this.gzI.mNoDataView);
        if (z) {
            this.gzI.mNoDataView.setVisibility(0);
            this.gzI.gzS.addHeaderView(this.gzI.mNoDataView);
            this.gzM.getView().setVisibility(8);
            return;
        }
        this.gzM.getView().setVisibility(0);
        this.gzM.bqJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqE() {
        TiebaStatic.log("c10491");
        bqG();
        com.baidu.tbadk.d.a.b(getBaseFragmentActivity()).a(1, this);
    }

    private void bqF() {
        bqG();
        com.baidu.tbadk.d.a.b(getBaseFragmentActivity()).b(this);
    }

    private void bqG() {
        com.baidu.tbadk.d.a.b(getBaseFragmentActivity()).a(true, true, true, this);
    }

    public void bqH() {
        if (this.gqD != null) {
            this.gqD.fetchPost(getPageContext(), this, true, this.mUid, true, this.gzP, false, true);
            this.gzO = true;
        }
    }

    public void bqI() {
        if (this.gqD != null) {
            this.gqD.fetchPost(getPageContext(), this, false, this.mUid, true, false, true);
        }
    }
}
