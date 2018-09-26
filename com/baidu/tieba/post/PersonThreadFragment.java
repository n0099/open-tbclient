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
    private ShareSuccessReplyToServerModel dId;
    private View dpP;
    public PersonPostModel ghC;
    private int gqA;
    private d gqC;
    private h gqF;
    private FrameLayout gqG;
    private com.baidu.tieba.post.a.a gqH;
    private boolean gqI;
    private a gqJ;
    private b gqK;
    private int gqM;
    private com.baidu.tbadk.core.view.k mPullView;
    private String mUid;
    private String gqE = PhoneUtils.CPUInfo.FEATURE_COMMON;
    private boolean mHasMore = false;
    private boolean gqB = true;
    private boolean gqL = true;
    private boolean aVY = false;
    private CustomMessageListener ghD = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.post.PersonThreadFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && PersonThreadFragment.this.gqH != null) {
                PersonThreadFragment.this.gqH.sY((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener ghE = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.post.PersonThreadFragment.2
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
                if (com.baidu.adp.lib.util.j.kK() && PersonThreadFragment.this.aVY) {
                    PersonThreadFragment.this.bnX();
                    PersonThreadFragment.this.gqJ.asD();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.a(PersonThreadFragment.this.dpP, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kK());
                } else {
                    BdListViewHelper.a(PersonThreadFragment.this.dpP, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.mNetworkChangedMessageListener);
        this.ghC = new PersonPostModel(getPageContext(), getUniqueId(), this, true, PersonPostModel.FROM_PERSON_POST);
        this.ghC.setUniqueId(getUniqueId());
        this.dId = new ShareSuccessReplyToServerModel();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(e.h.person_thread_fragment, viewGroup, false);
        this.gqG = (FrameLayout) inflate.findViewById(e.g.root_view);
        this.gqF = new h(getActivity(), inflate);
        if (this.gqF.boa() == null) {
            this.gqF.b(this.gqC);
        }
        if (this.gqF.gqP != null) {
            al.j(this.gqF.gqP, e.d.cp_bg_line_d);
        }
        String string2 = getArguments().getString("thread_type_key");
        if (!ao.isEmpty(string2)) {
            this.gqE = string2;
        }
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(e.j.to_be_an_liver), new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonThreadFragment.this.bnT();
            }
        });
        int dimension = (int) getResources().getDimension(e.C0141e.ds102);
        String str = "";
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension);
        if (this.gqE.equals("photolive")) {
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
                bnU();
            }
        } else {
            string = getArguments().getString("key_empty_view_text");
            bVar = null;
        }
        this.gqF.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.ao(string, str), bVar);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.ghD);
        registerListener(this.ghE);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        if (this.gqE.equals("photolive")) {
            this.gqM = 33;
        }
        this.gqH = new com.baidu.tieba.post.a.a(getPageContext(), this.gqF.gqP);
        this.gqF.bnZ().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                CardPersonDynamicThreadData cardPersonDynamicThreadData;
                if (i >= 0 && PersonThreadFragment.this.gqH != null && i < v.y(PersonThreadFragment.this.ghC.threadList) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) PersonThreadFragment.this.gqH.ggn.getItem(i)) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonThreadFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.threadId), String.valueOf(cardPersonDynamicThreadData.postId), "person_page", 18005)));
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.k(getPageContext());
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.post.PersonThreadFragment.5
            @Override // com.baidu.tbadk.core.view.j.b
            public void bf(boolean z) {
                if (PersonThreadFragment.this.ghC != null) {
                    PersonThreadFragment.this.gqB = true;
                    if (!com.baidu.adp.lib.util.j.ky()) {
                        if (PersonThreadFragment.this.gqF != null) {
                            PersonThreadFragment.this.gqF.F(PersonThreadFragment.this.getString(e.j.neterror), true);
                            return;
                        }
                        return;
                    }
                    PersonThreadFragment.this.bnW();
                }
            }
        });
        this.gqF.gqP.setPullRefresh(this.mPullView);
        if (TbadkCoreApplication.isMyLive) {
            this.dpP = BdListViewHelper.a(getActivity(), this.gqF.gqP, BdListViewHelper.HeadType.DEFAULT);
            BdListViewHelper.a(this.dpP, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kK());
        } else {
            this.dpP = BdListViewHelper.a(getActivity(), this.gqF.gqP, BdListViewHelper.HeadType.HASTAB);
            BdListViewHelper.a(this.dpP, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.gqF.gqP.setOnSrollToBottomListener(this);
        this.gqJ = new a(getBaseFragmentActivity());
        this.gqF.gqP.setNextPage(this.gqJ);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            bnX();
            this.gqJ.asD();
            this.aVY = true;
            return;
        }
        this.gqJ.ma(false);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
    public void b(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null && this.ghC != null) {
            if (z) {
                this.ghC.threadList.clear();
            }
            ArrayList<com.baidu.adp.widget.ListView.h> arrayList = personPostModel.threadList;
            if (personPostModel.view_card_num > 0 && this.gqL) {
                v.a(arrayList, personPostModel.view_card_num - 1, new com.baidu.tieba.personPolymeric.c.j());
                this.gqL = false;
            }
            if (this.ghC.threadList.isEmpty()) {
                com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) v.d(arrayList, 0);
                if (hVar instanceof CardPersonDynamicThreadData) {
                    ((CardPersonDynamicThreadData) hVar).cIF = true;
                } else if (hVar instanceof com.baidu.tieba.personPolymeric.c.j) {
                    ((com.baidu.tieba.personPolymeric.c.j) hVar).cIF = true;
                }
            }
            this.ghC.threadList.addAll(arrayList);
            PersonPostModel.mergeDynamicThreadByTime(this.ghC.threadList);
        }
        if (this.gqK != null) {
            this.gqK.lX(personPostModel.isShowRecycleBinRedTip);
        }
        a(personPostModel, z);
        this.gqH.C(this.ghC.threadList);
        this.gqH.notifyDataSetChanged();
    }

    /* loaded from: classes3.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private View aWu;
        private BaseFragmentActivity bui;
        private int bgColor = e.d.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View adA = null;
        private int mSkinType = 3;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.bui = null;
            this.bui = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View ov() {
            this.adA = LayoutInflater.from(this.bui.getPageContext().getContext()).inflate(e.h.new_pb_list_more, (ViewGroup) null);
            this.mTextView = (TextView) this.adA.findViewById(e.g.pb_more_text);
            this.aWu = this.adA.findViewById(e.g.pb_more_view);
            al.j(this.adA, this.bgColor);
            al.j(this.aWu, this.bgColor);
            this.aWu.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.adA.findViewById(e.g.progress);
            eJ(TbadkCoreApplication.getInst().getSkinType());
            al.h(this.mTextView, e.d.common_color_10039);
            this.aWu.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.bui.getPageContext().getPageActivity(), e.C0141e.ds120)));
            return this.adA;
        }

        public void eJ(int i) {
            this.bui.getLayoutMode().onModeChanged(this.aWu);
        }

        @SuppressLint({"ResourceAsColor"})
        public void dM(int i) {
            if (this.mSkinType != i) {
                al.h(this.mTextView, e.d.common_color_10039);
                al.e(this.adA, this.bgColor, i);
                al.e(this.aWu, this.bgColor, i);
                this.mSkinType = i;
            }
        }

        public void asD() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.bui.getPageContext().getPageActivity().getText(e.j.loading));
            this.aWu.setVisibility(0);
        }

        public void bnY() {
            al.j(this.adA, e.d.cp_bg_line_c);
        }

        public void ma(boolean z) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.aWu.setVisibility(0);
                    this.mTextView.setText(this.bui.getResources().getString(e.j.list_no_more));
                    return;
                }
                this.aWu.setVisibility(0);
                this.mTextView.setText(this.bui.getResources().getString(e.j.load_more));
            }
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.adA);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.gqF.mNoDataView != null) {
                this.gqF.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.dM(i);
            }
            if (this.gqH != null) {
                this.gqH.notifyDataSetChanged();
            }
            if (this.gqJ != null) {
                this.gqJ.dM(i);
            }
            al.j(this.gqF.gqP, e.d.cp_bg_line_d);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.gqF.mNoDataView != null) {
            this.gqF.mNoDataView.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.gqF.mNoDataView != null) {
            this.gqF.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.gqH != null) {
            this.gqH.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.ghC != null) {
            this.ghC.cancelLoadData();
        }
        try {
            com.baidu.tbadk.d.a.tb();
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
            if (i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.gqH != null && this.ghC != null && v.y(this.ghC.threadList) > 0) {
                int y = v.y(this.ghC.threadList);
                int i3 = 0;
                while (true) {
                    if (i3 >= y) {
                        z = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) v.d(this.ghC.threadList, i3);
                    if ((hVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) hVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.threadId))) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (z && intent.getIntExtra("type", -1) == 0) {
                    v.e(this.ghC.threadList, i3);
                    this.gqH.notifyDataSetChanged();
                }
            }
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.dId != null) {
                    this.dId.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.post.PersonThreadFragment.6
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void FH() {
                        }

                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void a(final CustomDialogData customDialogData) {
                            com.baidu.adp.lib.g.e.jt().postDelayed(new Runnable() { // from class: com.baidu.tieba.post.PersonThreadFragment.6.1
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
        if (!this.gqI) {
            this.gqF.gqP.startPullRefresh();
            this.gqI = true;
        }
    }

    public h bnS() {
        return this.gqF;
    }

    @Override // com.baidu.tieba.post.c
    public void bnM() {
        if (this.gqF != null && this.gqF.gqP != null) {
            this.gqF.gqP.startPullRefresh();
        }
    }

    public void a(d dVar) {
        this.gqC = dVar;
    }

    public void a(b bVar) {
        this.gqK = bVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
    public void a(PersonPostModel personPostModel, boolean z) {
        this.aVY = false;
        if (isAdded()) {
            this.gqF.gqP.completePullRefreshPostDelayed(2000L);
            this.gqF.gqP.setEmptyView(null);
            if (personPostModel != null || this.gqB) {
                if (personPostModel == null || (personPostModel.threadList.size() == 0 && this.gqB && StringUtils.isNull(personPostModel.getErrorString()))) {
                    lZ(true);
                    return;
                }
                if (personPostModel.threadList.size() == 0 && this.gqB) {
                    lZ(true);
                } else {
                    lZ(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(getActivity(), personPostModel.getErrorString());
                }
                this.mHasMore = !v.z(personPostModel.threadList);
                if (z) {
                    if (personPostModel.threadList.size() < 20) {
                        this.mHasMore = false;
                    } else {
                        this.mHasMore = true;
                    }
                    this.gqA = 0;
                    this.gqB = false;
                }
                this.gqJ.ma(this.mHasMore);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016221));
            }
        }
    }

    private void lZ(boolean z) {
        this.gqF.gqP.removeHeaderView(this.gqF.mNoDataView);
        if (z) {
            this.gqF.mNoDataView.setVisibility(0);
            this.gqF.gqP.addHeaderView(this.gqF.mNoDataView);
            this.gqJ.getView().setVisibility(8);
            return;
        }
        this.gqJ.getView().setVisibility(0);
        this.gqJ.bnY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnT() {
        TiebaStatic.log("c10491");
        bnV();
        com.baidu.tbadk.d.a.b(getBaseFragmentActivity()).a(1, this);
    }

    private void bnU() {
        bnV();
        com.baidu.tbadk.d.a.b(getBaseFragmentActivity()).b(this);
    }

    private void bnV() {
        com.baidu.tbadk.d.a.b(getBaseFragmentActivity()).a(true, true, true, this);
    }

    public void bnW() {
        if (this.ghC != null) {
            this.ghC.fetchPost(getPageContext(), this, true, this.mUid, true, this.gqM, false, true);
            this.gqL = true;
        }
    }

    public void bnX() {
        if (this.ghC != null) {
            this.ghC.fetchPost(getPageContext(), this, false, this.mUid, true, false, true);
        }
    }
}
