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
    private View dCx;
    private ShareSuccessReplyToServerModel dRe;
    public PersonPostModel goP;
    private d gxA;
    private k gxD;
    private FrameLayout gxE;
    private com.baidu.tieba.post.a.a gxF;
    private boolean gxG;
    private a gxH;
    private b gxI;
    private int gxK;
    private int gxy;
    private com.baidu.tbadk.core.view.k mPullView;
    private String mUid;
    private String gxC = PhoneUtils.CPUInfo.FEATURE_COMMON;
    private boolean mHasMore = false;
    private boolean gxz = true;
    private boolean gxJ = true;
    private boolean byZ = false;
    private CustomMessageListener goQ = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.post.j.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && j.this.gxF != null) {
                j.this.gxF.ru((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener goR = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.post.j.2
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
                if (com.baidu.adp.lib.util.j.oJ() && j.this.byZ) {
                    j.this.bmt();
                    j.this.gxH.asz();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.a(j.this.dCx, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.oJ());
                } else {
                    BdListViewHelper.a(j.this.dCx, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.mNetworkChangedMessageListener);
        this.goP = new PersonPostModel(getPageContext(), getUniqueId(), this, true, PersonPostModel.FROM_PERSON_POST);
        this.goP.setUniqueId(getUniqueId());
        this.dRe = new ShareSuccessReplyToServerModel();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.person_thread_fragment, viewGroup, false);
        this.gxE = (FrameLayout) inflate.findViewById(d.g.root_view);
        this.gxD = new k(getActivity(), inflate);
        if (this.gxD.bmw() == null) {
            this.gxD.b(this.gxA);
        }
        if (this.gxD.gxN != null) {
            aj.t(this.gxD.gxN, d.C0140d.cp_bg_line_d);
        }
        String string2 = getArguments().getString("thread_type_key");
        if (!am.isEmpty(string2)) {
            this.gxC = string2;
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
        if (this.gxC.equals("photolive")) {
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
        this.gxD.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.ae(string, str), bVar);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.goQ);
        registerListener(this.goR);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        if (this.gxC.equals("photolive")) {
            this.gxK = 33;
        }
        this.gxF = new com.baidu.tieba.post.a.a(getPageContext(), this.gxD.gxN);
        this.gxD.bmv().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.j.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                CardPersonDynamicThreadData cardPersonDynamicThreadData;
                if (i >= 0 && j.this.gxF != null && i < v.D(j.this.goP.threadList) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) j.this.gxF.gnC.getItem(i)) != null) {
                    if (cardPersonDynamicThreadData.daK == 33) {
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
                if (j.this.goP != null) {
                    j.this.gxz = true;
                    if (!com.baidu.adp.lib.util.j.ox()) {
                        if (j.this.gxD != null) {
                            j.this.gxD.I(j.this.getString(d.j.neterror), true);
                            return;
                        }
                        return;
                    }
                    j.this.bms();
                }
            }
        });
        this.gxD.gxN.setPullRefresh(this.mPullView);
        if (TbadkCoreApplication.isMyLive) {
            this.dCx = BdListViewHelper.a(getActivity(), this.gxD.gxN, BdListViewHelper.HeadType.DEFAULT);
            BdListViewHelper.a(this.dCx, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.oJ());
        } else {
            this.dCx = BdListViewHelper.a(getActivity(), this.gxD.gxN, BdListViewHelper.HeadType.HASTAB);
            BdListViewHelper.a(this.dCx, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.gxD.gxN.setOnSrollToBottomListener(this);
        this.gxH = new a(getBaseFragmentActivity());
        this.gxD.gxN.setNextPage(this.gxH);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            bmt();
            this.gxH.asz();
            this.byZ = true;
            return;
        }
        this.gxH.lU(false);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
    public void b(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null && this.goP != null) {
            if (z) {
                this.goP.threadList.clear();
            }
            ArrayList<com.baidu.adp.widget.ListView.i> arrayList = personPostModel.threadList;
            if (personPostModel.view_card_num > 0 && this.gxJ) {
                v.a(arrayList, personPostModel.view_card_num - 1, new com.baidu.tieba.personPolymeric.c.j());
                this.gxJ = false;
            }
            if (this.goP.threadList.isEmpty()) {
                com.baidu.adp.widget.ListView.i iVar = (com.baidu.adp.widget.ListView.i) v.f(arrayList, 0);
                if (iVar instanceof CardPersonDynamicThreadData) {
                    ((CardPersonDynamicThreadData) iVar).daY = true;
                } else if (iVar instanceof com.baidu.tieba.personPolymeric.c.j) {
                    ((com.baidu.tieba.personPolymeric.c.j) iVar).daY = true;
                }
            }
            this.goP.threadList.addAll(arrayList);
            PersonPostModel.mergeDynamicThreadByTime(this.goP.threadList);
        }
        if (this.gxI != null) {
            this.gxI.lR(personPostModel.isShowRecycleBinRedTip);
        }
        a(personPostModel, z);
        this.gxF.A(this.goP.threadList);
        this.gxF.notifyDataSetChanged();
    }

    /* loaded from: classes3.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private BaseFragmentActivity bUg;
        private View bzv;
        private int bgColor = d.C0140d.cp_bg_line_d;
        private TextView rz = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View aId = null;
        private int mSkinType = 3;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.bUg = null;
            this.bUg = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View st() {
            this.aId = LayoutInflater.from(this.bUg.getPageContext().getContext()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
            this.rz = (TextView) this.aId.findViewById(d.g.pb_more_text);
            this.bzv = this.aId.findViewById(d.g.pb_more_view);
            aj.t(this.aId, this.bgColor);
            aj.t(this.bzv, this.bgColor);
            this.bzv.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.aId.findViewById(d.g.progress);
            hr(TbadkCoreApplication.getInst().getSkinType());
            aj.r(this.rz, d.C0140d.common_color_10039);
            this.bzv.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.t(this.bUg.getPageContext().getPageActivity(), d.e.ds120)));
            return this.aId;
        }

        public void hr(int i) {
            this.bUg.getLayoutMode().aM(this.bzv);
        }

        @SuppressLint({"ResourceAsColor"})
        public void gx(int i) {
            if (this.mSkinType != i) {
                aj.r(this.rz, d.C0140d.common_color_10039);
                aj.g(this.aId, this.bgColor, i);
                aj.g(this.bzv, this.bgColor, i);
                this.mSkinType = i;
            }
        }

        public void asz() {
            this.mProgressBar.setVisibility(0);
            this.rz.setText(this.bUg.getPageContext().getPageActivity().getText(d.j.loading));
            this.bzv.setVisibility(0);
        }

        public void bmu() {
            aj.t(this.aId, d.C0140d.cp_bg_line_c);
        }

        public void lU(boolean z) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.rz != null) {
                if (!z) {
                    this.bzv.setVisibility(0);
                    this.rz.setText(this.bUg.getResources().getString(d.j.list_no_more));
                    return;
                }
                this.bzv.setVisibility(0);
                this.rz.setText(this.bUg.getResources().getString(d.j.load_more));
            }
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.aId);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.gxD.mNoDataView != null) {
                this.gxD.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.gx(i);
            }
            if (this.gxF != null) {
                this.gxF.notifyDataSetChanged();
            }
            if (this.gxH != null) {
                this.gxH.gx(i);
            }
            aj.t(this.gxD.gxN, d.C0140d.cp_bg_line_d);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.gxD.mNoDataView != null) {
            this.gxD.mNoDataView.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.gxD.mNoDataView != null) {
            this.gxD.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.gxF != null) {
            this.gxF.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.goP != null) {
            this.goP.cancelLoadData();
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
            if (i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.gxF != null && this.goP != null && v.D(this.goP.threadList) > 0) {
                int D = v.D(this.goP.threadList);
                int i3 = 0;
                while (true) {
                    if (i3 >= D) {
                        z = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.i iVar = (com.baidu.adp.widget.ListView.i) v.f(this.goP.threadList, i3);
                    if ((iVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) iVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.threadId))) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (z && intent.getIntExtra("type", -1) == 0) {
                    v.g(this.goP.threadList, i3);
                    this.gxF.notifyDataSetChanged();
                }
            }
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.dRe != null) {
                    this.dRe.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.post.j.6
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
        if (!this.gxG) {
            this.gxD.gxN.startPullRefresh();
            this.gxG = true;
        }
    }

    public k bmo() {
        return this.gxD;
    }

    @Override // com.baidu.tieba.post.c
    public void bmi() {
        if (this.gxD != null && this.gxD.gxN != null) {
            this.gxD.gxN.startPullRefresh();
        }
    }

    public void a(d dVar) {
        this.gxA = dVar;
    }

    public void a(b bVar) {
        this.gxI = bVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
    public void a(PersonPostModel personPostModel, boolean z) {
        this.byZ = false;
        if (isAdded()) {
            this.gxD.gxN.completePullRefreshPostDelayed(2000L);
            this.gxD.gxN.setEmptyView(null);
            if (personPostModel != null || this.gxz) {
                if (personPostModel == null || (personPostModel.threadList.size() == 0 && this.gxz && StringUtils.isNull(personPostModel.getErrorString()))) {
                    lT(true);
                    return;
                }
                if (personPostModel.threadList.size() == 0 && this.gxz) {
                    lT(true);
                } else {
                    lT(false);
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
                    this.gxy = 0;
                    this.gxz = false;
                }
                this.gxH.lU(this.mHasMore);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016221));
            }
        }
    }

    private void lT(boolean z) {
        this.gxD.gxN.removeHeaderView(this.gxD.mNoDataView);
        if (z) {
            this.gxD.mNoDataView.setVisibility(0);
            this.gxD.gxN.addHeaderView(this.gxD.mNoDataView);
            this.gxH.getView().setVisibility(8);
            return;
        }
        this.gxH.getView().setVisibility(0);
        this.gxH.bmu();
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
        if (this.goP != null) {
            this.goP.fetchPost(getPageContext(), this, true, this.mUid, true, this.gxK, false, true);
            this.gxJ = true;
        }
    }

    public void bmt() {
        if (this.goP != null) {
            this.goP.fetchPost(getPageContext(), this, false, this.mUid, true, false, true);
        }
    }
}
