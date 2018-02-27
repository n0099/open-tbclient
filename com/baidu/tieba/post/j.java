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
    private View dCl;
    private ShareSuccessReplyToServerModel dQS;
    public PersonPostModel goE;
    private int gxn;
    private d gxp;
    private k gxs;
    private FrameLayout gxt;
    private com.baidu.tieba.post.a.a gxu;
    private boolean gxv;
    private a gxw;
    private b gxx;
    private int gxz;
    private com.baidu.tbadk.core.view.k mPullView;
    private String mUid;
    private String gxr = PhoneUtils.CPUInfo.FEATURE_COMMON;
    private boolean mHasMore = false;
    private boolean gxo = true;
    private boolean gxy = true;
    private boolean byM = false;
    private CustomMessageListener goF = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.post.j.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && j.this.gxu != null) {
                j.this.gxu.ru((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener goG = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.post.j.2
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
                if (com.baidu.adp.lib.util.j.oJ() && j.this.byM) {
                    j.this.bms();
                    j.this.gxw.asy();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.a(j.this.dCl, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.oJ());
                } else {
                    BdListViewHelper.a(j.this.dCl, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.mNetworkChangedMessageListener);
        this.goE = new PersonPostModel(getPageContext(), getUniqueId(), this, true, PersonPostModel.FROM_PERSON_POST);
        this.goE.setUniqueId(getUniqueId());
        this.dQS = new ShareSuccessReplyToServerModel();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.person_thread_fragment, viewGroup, false);
        this.gxt = (FrameLayout) inflate.findViewById(d.g.root_view);
        this.gxs = new k(getActivity(), inflate);
        if (this.gxs.bmv() == null) {
            this.gxs.b(this.gxp);
        }
        if (this.gxs.gxC != null) {
            aj.t(this.gxs.gxC, d.C0141d.cp_bg_line_d);
        }
        String string2 = getArguments().getString("thread_type_key");
        if (!am.isEmpty(string2)) {
            this.gxr = string2;
        }
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(d.j.to_be_an_liver), new View.OnClickListener() { // from class: com.baidu.tieba.post.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.bmo();
            }
        });
        int dimension = (int) getResources().getDimension(d.e.ds102);
        String str = "";
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension);
        if (this.gxr.equals("photolive")) {
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
                bmp();
            }
        } else {
            string = getArguments().getString("key_empty_view_text");
            bVar = null;
        }
        this.gxs.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.ae(string, str), bVar);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.goF);
        registerListener(this.goG);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        if (this.gxr.equals("photolive")) {
            this.gxz = 33;
        }
        this.gxu = new com.baidu.tieba.post.a.a(getPageContext(), this.gxs.gxC);
        this.gxs.bmu().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.j.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                CardPersonDynamicThreadData cardPersonDynamicThreadData;
                if (i >= 0 && j.this.gxu != null && i < v.D(j.this.goE.threadList) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) j.this.gxu.gnr.getItem(i)) != null) {
                    if (cardPersonDynamicThreadData.dax == 33) {
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
                if (j.this.goE != null) {
                    j.this.gxo = true;
                    if (!com.baidu.adp.lib.util.j.ox()) {
                        if (j.this.gxs != null) {
                            j.this.gxs.H(j.this.getString(d.j.neterror), true);
                            return;
                        }
                        return;
                    }
                    j.this.bmr();
                }
            }
        });
        this.gxs.gxC.setPullRefresh(this.mPullView);
        if (TbadkCoreApplication.isMyLive) {
            this.dCl = BdListViewHelper.a(getActivity(), this.gxs.gxC, BdListViewHelper.HeadType.DEFAULT);
            BdListViewHelper.a(this.dCl, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.oJ());
        } else {
            this.dCl = BdListViewHelper.a(getActivity(), this.gxs.gxC, BdListViewHelper.HeadType.HASTAB);
            BdListViewHelper.a(this.dCl, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.gxs.gxC.setOnSrollToBottomListener(this);
        this.gxw = new a(getBaseFragmentActivity());
        this.gxs.gxC.setNextPage(this.gxw);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            bms();
            this.gxw.asy();
            this.byM = true;
            return;
        }
        this.gxw.lU(false);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
    public void b(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null && this.goE != null) {
            if (z) {
                this.goE.threadList.clear();
            }
            ArrayList<com.baidu.adp.widget.ListView.i> arrayList = personPostModel.threadList;
            if (personPostModel.view_card_num > 0 && this.gxy) {
                v.a(arrayList, personPostModel.view_card_num - 1, new com.baidu.tieba.personPolymeric.c.j());
                this.gxy = false;
            }
            if (this.goE.threadList.isEmpty()) {
                com.baidu.adp.widget.ListView.i iVar = (com.baidu.adp.widget.ListView.i) v.f(arrayList, 0);
                if (iVar instanceof CardPersonDynamicThreadData) {
                    ((CardPersonDynamicThreadData) iVar).daM = true;
                } else if (iVar instanceof com.baidu.tieba.personPolymeric.c.j) {
                    ((com.baidu.tieba.personPolymeric.c.j) iVar).daM = true;
                }
            }
            this.goE.threadList.addAll(arrayList);
            PersonPostModel.mergeDynamicThreadByTime(this.goE.threadList);
        }
        if (this.gxx != null) {
            this.gxx.lR(personPostModel.isShowRecycleBinRedTip);
        }
        a(personPostModel, z);
        this.gxu.A(this.goE.threadList);
        this.gxu.notifyDataSetChanged();
    }

    /* loaded from: classes3.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private BaseFragmentActivity bTU;
        private View bzi;
        private int bgColor = d.C0141d.cp_bg_line_d;
        private TextView ry = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View aHS = null;
        private int mSkinType = 3;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.bTU = null;
            this.bTU = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View st() {
            this.aHS = LayoutInflater.from(this.bTU.getPageContext().getContext()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
            this.ry = (TextView) this.aHS.findViewById(d.g.pb_more_text);
            this.bzi = this.aHS.findViewById(d.g.pb_more_view);
            aj.t(this.aHS, this.bgColor);
            aj.t(this.bzi, this.bgColor);
            this.bzi.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.aHS.findViewById(d.g.progress);
            hr(TbadkCoreApplication.getInst().getSkinType());
            aj.r(this.ry, d.C0141d.common_color_10039);
            this.bzi.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.t(this.bTU.getPageContext().getPageActivity(), d.e.ds120)));
            return this.aHS;
        }

        public void hr(int i) {
            this.bTU.getLayoutMode().aM(this.bzi);
        }

        @SuppressLint({"ResourceAsColor"})
        public void gx(int i) {
            if (this.mSkinType != i) {
                aj.r(this.ry, d.C0141d.common_color_10039);
                aj.g(this.aHS, this.bgColor, i);
                aj.g(this.bzi, this.bgColor, i);
                this.mSkinType = i;
            }
        }

        public void asy() {
            this.mProgressBar.setVisibility(0);
            this.ry.setText(this.bTU.getPageContext().getPageActivity().getText(d.j.loading));
            this.bzi.setVisibility(0);
        }

        public void bmt() {
            aj.t(this.aHS, d.C0141d.cp_bg_line_c);
        }

        public void lU(boolean z) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.ry != null) {
                if (!z) {
                    this.bzi.setVisibility(0);
                    this.ry.setText(this.bTU.getResources().getString(d.j.list_no_more));
                    return;
                }
                this.bzi.setVisibility(0);
                this.ry.setText(this.bTU.getResources().getString(d.j.load_more));
            }
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.aHS);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.gxs.mNoDataView != null) {
                this.gxs.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.gx(i);
            }
            if (this.gxu != null) {
                this.gxu.notifyDataSetChanged();
            }
            if (this.gxw != null) {
                this.gxw.gx(i);
            }
            aj.t(this.gxs.gxC, d.C0141d.cp_bg_line_d);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.gxs.mNoDataView != null) {
            this.gxs.mNoDataView.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.gxs.mNoDataView != null) {
            this.gxs.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.gxu != null) {
            this.gxu.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.goE != null) {
            this.goE.cancelLoadData();
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
            if (i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.gxu != null && this.goE != null && v.D(this.goE.threadList) > 0) {
                int D = v.D(this.goE.threadList);
                int i3 = 0;
                while (true) {
                    if (i3 >= D) {
                        z = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.i iVar = (com.baidu.adp.widget.ListView.i) v.f(this.goE.threadList, i3);
                    if ((iVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) iVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.threadId))) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (z && intent.getIntExtra("type", -1) == 0) {
                    v.g(this.goE.threadList, i3);
                    this.gxu.notifyDataSetChanged();
                }
            }
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.dQS != null) {
                    this.dQS.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.post.j.6
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void HQ() {
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
        if (!this.gxv) {
            this.gxs.gxC.startPullRefresh();
            this.gxv = true;
        }
    }

    public k bmn() {
        return this.gxs;
    }

    @Override // com.baidu.tieba.post.c
    public void bmh() {
        if (this.gxs != null && this.gxs.gxC != null) {
            this.gxs.gxC.startPullRefresh();
        }
    }

    public void a(d dVar) {
        this.gxp = dVar;
    }

    public void a(b bVar) {
        this.gxx = bVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
    public void a(PersonPostModel personPostModel, boolean z) {
        this.byM = false;
        if (isAdded()) {
            this.gxs.gxC.completePullRefreshPostDelayed(2000L);
            this.gxs.gxC.setEmptyView(null);
            if (personPostModel != null || this.gxo) {
                if (personPostModel == null || (personPostModel.threadList.size() == 0 && this.gxo && StringUtils.isNull(personPostModel.getErrorString()))) {
                    lT(true);
                    return;
                }
                if (personPostModel.threadList.size() == 0 && this.gxo) {
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
                    this.gxn = 0;
                    this.gxo = false;
                }
                this.gxw.lU(this.mHasMore);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016221));
            }
        }
    }

    private void lT(boolean z) {
        this.gxs.gxC.removeHeaderView(this.gxs.mNoDataView);
        if (z) {
            this.gxs.mNoDataView.setVisibility(0);
            this.gxs.gxC.addHeaderView(this.gxs.mNoDataView);
            this.gxw.getView().setVisibility(8);
            return;
        }
        this.gxw.getView().setVisibility(0);
        this.gxw.bmt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmo() {
        TiebaStatic.log("c10491");
        bmq();
        com.baidu.tbadk.b.a.b(getBaseFragmentActivity()).a(1, this);
    }

    private void bmp() {
        bmq();
        com.baidu.tbadk.b.a.b(getBaseFragmentActivity()).b(this);
    }

    private void bmq() {
        com.baidu.tbadk.b.a.b(getBaseFragmentActivity()).a(true, true, true, this);
    }

    public void bmr() {
        if (this.goE != null) {
            this.goE.fetchPost(getPageContext(), this, true, this.mUid, true, this.gxz, false, true);
            this.gxy = true;
        }
    }

    public void bms() {
        if (this.goE != null) {
            this.goE.fetchPost(getPageContext(), this, false, this.mUid, true, false, true);
        }
    }
}
