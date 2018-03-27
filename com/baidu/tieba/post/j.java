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
import com.baidu.tbadk.b.b;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.d;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class j extends BaseFragment implements BdListView.e, b.a, PersonPostModel.a, PersonPostModel.b, c {
    private View dCo;
    private ShareSuccessReplyToServerModel dQX;
    public PersonPostModel goU;
    private int gxD;
    private d gxF;
    private k gxI;
    private FrameLayout gxJ;
    private com.baidu.tieba.post.a.a gxK;
    private boolean gxL;
    private a gxM;
    private b gxN;
    private int gxP;
    private com.baidu.tbadk.core.view.k mPullView;
    private String mUid;
    private String gxH = PhoneUtils.CPUInfo.FEATURE_COMMON;
    private boolean mHasMore = false;
    private boolean gxE = true;
    private boolean gxO = true;
    private boolean byP = false;
    private CustomMessageListener goV = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.post.j.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && j.this.gxK != null) {
                j.this.gxK.ru((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener goW = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.post.j.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.adp.lib.util.l.showToast(j.this.getActivity(), d.j.thread_has_hide);
            }
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.post.j.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (com.baidu.adp.lib.util.j.oJ() && j.this.byP) {
                    j.this.bmt();
                    j.this.gxM.asz();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.a(j.this.dCo, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.oJ());
                } else {
                    BdListViewHelper.a(j.this.dCo, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.mNetworkChangedMessageListener);
        this.goU = new PersonPostModel(getPageContext(), getUniqueId(), this, true, PersonPostModel.FROM_PERSON_POST);
        this.goU.setUniqueId(getUniqueId());
        this.dQX = new ShareSuccessReplyToServerModel();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.person_thread_fragment, viewGroup, false);
        this.gxJ = (FrameLayout) inflate.findViewById(d.g.root_view);
        this.gxI = new k(getActivity(), inflate);
        if (this.gxI.bmw() == null) {
            this.gxI.b(this.gxF);
        }
        if (this.gxI.gxS != null) {
            aj.t(this.gxI.gxS, d.C0141d.cp_bg_line_d);
        }
        String string2 = getArguments().getString("thread_type_key");
        if (!am.isEmpty(string2)) {
            this.gxH = string2;
        }
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(d.j.to_be_an_liver), new View.OnClickListener() { // from class: com.baidu.tieba.post.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.bmp();
            }
        });
        int dimension = (int) getResources().getDimension(d.e.ds102);
        String str = "";
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension);
        if (this.gxH.equals("photolive")) {
            int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1);
            if (i == 0) {
                str = getPageContext().getResources().getString(d.j.to_live_to_god);
                string = getPageContext().getResources().getString(d.j.user_not_liver);
                a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.go_to_live_pic, dimension, -1, -1);
                bVar = NoDataViewFactory.b.a(aVar);
            } else {
                string = getPageContext().getResources().getString(d.j.person_post_lv_empty_host);
                bVar = null;
            }
            if (i < 0) {
                bmq();
            }
        } else {
            string = getArguments().getString("key_empty_view_text");
            bVar = null;
        }
        this.gxI.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.ae(string, str), bVar);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.goV);
        registerListener(this.goW);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        if (this.gxH.equals("photolive")) {
            this.gxP = 33;
        }
        this.gxK = new com.baidu.tieba.post.a.a(getPageContext(), this.gxI.gxS);
        this.gxI.bmv().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.j.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                CardPersonDynamicThreadData cardPersonDynamicThreadData;
                if (i >= 0 && j.this.gxK != null && i < v.D(j.this.goU.threadList) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) j.this.gxK.gnH.getItem(i)) != null) {
                    if (cardPersonDynamicThreadData.daB == 33) {
                        TiebaStatic.log("c10254");
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PhotoLiveActivityConfig.a(j.this.getActivity(), String.valueOf(cardPersonDynamicThreadData.threadId)).cP(String.valueOf(cardPersonDynamicThreadData.postId)).eC(18005).xD()));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(j.this.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.threadId), String.valueOf(cardPersonDynamicThreadData.postId), "person_page", 18005)));
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.k(getPageContext());
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.post.j.5
            @Override // com.baidu.tbadk.core.view.j.b
            public void bw(boolean z) {
                if (j.this.goU != null) {
                    j.this.gxE = true;
                    if (!com.baidu.adp.lib.util.j.ox()) {
                        if (j.this.gxI != null) {
                            j.this.gxI.H(j.this.getString(d.j.neterror), true);
                            return;
                        }
                        return;
                    }
                    j.this.bms();
                }
            }
        });
        this.gxI.gxS.setPullRefresh(this.mPullView);
        if (TbadkCoreApplication.isMyLive) {
            this.dCo = BdListViewHelper.a(getActivity(), this.gxI.gxS, BdListViewHelper.HeadType.DEFAULT);
            BdListViewHelper.a(this.dCo, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.oJ());
        } else {
            this.dCo = BdListViewHelper.a(getActivity(), this.gxI.gxS, BdListViewHelper.HeadType.HASTAB);
            BdListViewHelper.a(this.dCo, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.gxI.gxS.setOnSrollToBottomListener(this);
        this.gxM = new a(getBaseFragmentActivity());
        this.gxI.gxS.setNextPage(this.gxM);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            bmt();
            this.gxM.asz();
            this.byP = true;
            return;
        }
        this.gxM.lZ(false);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
    public void b(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null && this.goU != null) {
            if (z) {
                this.goU.threadList.clear();
            }
            ArrayList<com.baidu.adp.widget.ListView.i> arrayList = personPostModel.threadList;
            if (personPostModel.view_card_num > 0 && this.gxO) {
                v.a(arrayList, personPostModel.view_card_num - 1, new com.baidu.tieba.personPolymeric.c.j());
                this.gxO = false;
            }
            if (this.goU.threadList.isEmpty()) {
                com.baidu.adp.widget.ListView.i iVar = (com.baidu.adp.widget.ListView.i) v.f(arrayList, 0);
                if (iVar instanceof CardPersonDynamicThreadData) {
                    ((CardPersonDynamicThreadData) iVar).daP = true;
                } else if (iVar instanceof com.baidu.tieba.personPolymeric.c.j) {
                    ((com.baidu.tieba.personPolymeric.c.j) iVar).daP = true;
                }
            }
            this.goU.threadList.addAll(arrayList);
            PersonPostModel.mergeDynamicThreadByTime(this.goU.threadList);
        }
        if (this.gxN != null) {
            this.gxN.lW(personPostModel.isShowRecycleBinRedTip);
        }
        a(personPostModel, z);
        this.gxK.A(this.goU.threadList);
        this.gxK.notifyDataSetChanged();
    }

    /* loaded from: classes3.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private BaseFragmentActivity bTX;
        private View bzl;
        private int bgColor = d.C0141d.cp_bg_line_d;
        private TextView ry = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View aHT = null;
        private int mSkinType = 3;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.bTX = null;
            this.bTX = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View st() {
            this.aHT = LayoutInflater.from(this.bTX.getPageContext().getContext()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
            this.ry = (TextView) this.aHT.findViewById(d.g.pb_more_text);
            this.bzl = this.aHT.findViewById(d.g.pb_more_view);
            aj.t(this.aHT, this.bgColor);
            aj.t(this.bzl, this.bgColor);
            this.bzl.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.aHT.findViewById(d.g.progress);
            hr(TbadkCoreApplication.getInst().getSkinType());
            aj.r(this.ry, d.C0141d.common_color_10039);
            this.bzl.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.t(this.bTX.getPageContext().getPageActivity(), d.e.ds120)));
            return this.aHT;
        }

        public void hr(int i) {
            this.bTX.getLayoutMode().aM(this.bzl);
        }

        @SuppressLint({"ResourceAsColor"})
        public void gx(int i) {
            if (this.mSkinType != i) {
                aj.r(this.ry, d.C0141d.common_color_10039);
                aj.g(this.aHT, this.bgColor, i);
                aj.g(this.bzl, this.bgColor, i);
                this.mSkinType = i;
            }
        }

        public void asz() {
            this.mProgressBar.setVisibility(0);
            this.ry.setText(this.bTX.getPageContext().getPageActivity().getText(d.j.loading));
            this.bzl.setVisibility(0);
        }

        public void bmu() {
            aj.t(this.aHT, d.C0141d.cp_bg_line_c);
        }

        public void lZ(boolean z) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.ry != null) {
                if (!z) {
                    this.bzl.setVisibility(0);
                    this.ry.setText(this.bTX.getResources().getString(d.j.list_no_more));
                    return;
                }
                this.bzl.setVisibility(0);
                this.ry.setText(this.bTX.getResources().getString(d.j.load_more));
            }
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.aHT);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.gxI.mNoDataView != null) {
                this.gxI.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.gx(i);
            }
            if (this.gxK != null) {
                this.gxK.notifyDataSetChanged();
            }
            if (this.gxM != null) {
                this.gxM.gx(i);
            }
            aj.t(this.gxI.gxS, d.C0141d.cp_bg_line_d);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.gxI.mNoDataView != null) {
            this.gxI.mNoDataView.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.gxI.mNoDataView != null) {
            this.gxI.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.gxK != null) {
            this.gxK.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.goU != null) {
            this.goU.cancelLoadData();
        }
        try {
            com.baidu.tbadk.b.a.wh();
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
            if (i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.gxK != null && this.goU != null && v.D(this.goU.threadList) > 0) {
                int D = v.D(this.goU.threadList);
                int i3 = 0;
                while (true) {
                    if (i3 >= D) {
                        z = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.i iVar = (com.baidu.adp.widget.ListView.i) v.f(this.goU.threadList, i3);
                    if ((iVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) iVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.threadId))) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (z && intent.getIntExtra("type", -1) == 0) {
                    v.g(this.goU.threadList, i3);
                    this.gxK.notifyDataSetChanged();
                }
            }
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.dQX != null) {
                    this.dQX.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.post.j.6
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void HR() {
                        }

                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void a(final CustomDialogData customDialogData) {
                            com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.post.j.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (j.this.getPageContext().getPageActivity() != null) {
                                        com.baidu.tieba.pb.interactionpopupwindow.c.a(j.this.getPageContext(), customDialogData).show();
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
        if (!this.gxL) {
            this.gxI.gxS.startPullRefresh();
            this.gxL = true;
        }
    }

    public k bmo() {
        return this.gxI;
    }

    @Override // com.baidu.tieba.post.c
    public void bmi() {
        if (this.gxI != null && this.gxI.gxS != null) {
            this.gxI.gxS.startPullRefresh();
        }
    }

    public void a(d dVar) {
        this.gxF = dVar;
    }

    public void a(b bVar) {
        this.gxN = bVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
    public void a(PersonPostModel personPostModel, boolean z) {
        this.byP = false;
        if (isAdded()) {
            this.gxI.gxS.completePullRefreshPostDelayed(2000L);
            this.gxI.gxS.setEmptyView(null);
            if (personPostModel != null || this.gxE) {
                if (personPostModel == null || (personPostModel.threadList.size() == 0 && this.gxE && StringUtils.isNull(personPostModel.getErrorString()))) {
                    lY(true);
                    return;
                }
                if (personPostModel.threadList.size() == 0 && this.gxE) {
                    lY(true);
                } else {
                    lY(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(getActivity(), personPostModel.getErrorString());
                }
                this.mHasMore = !v.E(personPostModel.threadList);
                if (z) {
                    if (personPostModel.threadList.size() < 20) {
                        this.mHasMore = false;
                    } else {
                        this.mHasMore = true;
                    }
                    this.gxD = 0;
                    this.gxE = false;
                }
                this.gxM.lZ(this.mHasMore);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016221));
            }
        }
    }

    private void lY(boolean z) {
        this.gxI.gxS.removeHeaderView(this.gxI.mNoDataView);
        if (z) {
            this.gxI.mNoDataView.setVisibility(0);
            this.gxI.gxS.addHeaderView(this.gxI.mNoDataView);
            this.gxM.getView().setVisibility(8);
            return;
        }
        this.gxM.getView().setVisibility(0);
        this.gxM.bmu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmp() {
        TiebaStatic.log("c10491");
        bmr();
        com.baidu.tbadk.b.a.b(getBaseFragmentActivity()).a(1, this);
    }

    private void bmq() {
        bmr();
        com.baidu.tbadk.b.a.b(getBaseFragmentActivity()).b(this);
    }

    private void bmr() {
        com.baidu.tbadk.b.a.b(getBaseFragmentActivity()).a(true, true, true, this);
    }

    public void bms() {
        if (this.goU != null) {
            this.goU.fetchPost(getPageContext(), this, true, this.mUid, true, this.gxP, false, true);
            this.gxO = true;
        }
    }

    public void bmt() {
        if (this.goU != null) {
            this.goU.fetchPost(getPageContext(), this, false, this.mUid, true, false, true);
        }
    }
}
