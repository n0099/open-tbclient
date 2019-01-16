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
    private View dJf;
    private ShareSuccessReplyToServerModel ebd;
    public PersonPostModel gBo;
    private int gKA;
    private int gKo;
    private d gKq;
    private h gKt;
    private FrameLayout gKu;
    private com.baidu.tieba.post.a.a gKv;
    private boolean gKw;
    private a gKx;
    private b gKy;
    private com.baidu.tbadk.core.view.k mPullView;
    private String mUid;
    private String gKs = PhoneUtils.CPUInfo.FEATURE_COMMON;
    private boolean mHasMore = false;
    private boolean gKp = true;
    private boolean gKz = true;
    private boolean bfy = false;
    private CustomMessageListener gBp = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.post.PersonThreadFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && PersonThreadFragment.this.gKv != null) {
                PersonThreadFragment.this.gKv.uy((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gBq = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.post.PersonThreadFragment.2
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
                if (com.baidu.adp.lib.util.j.kV() && PersonThreadFragment.this.bfy) {
                    PersonThreadFragment.this.btV();
                    PersonThreadFragment.this.gKx.ayv();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.a(PersonThreadFragment.this.dJf, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kV());
                } else {
                    BdListViewHelper.a(PersonThreadFragment.this.dJf, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.mNetworkChangedMessageListener);
        this.gBo = new PersonPostModel(getPageContext(), getUniqueId(), this, true, PersonPostModel.FROM_PERSON_POST);
        this.gBo.setUniqueId(getUniqueId());
        this.ebd = new ShareSuccessReplyToServerModel();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(e.h.person_thread_fragment, viewGroup, false);
        this.gKu = (FrameLayout) inflate.findViewById(e.g.root_view);
        this.gKt = new h(getActivity(), inflate);
        if (this.gKt.btY() == null) {
            this.gKt.b(this.gKq);
        }
        if (this.gKt.gKD != null) {
            al.j(this.gKt.gKD, e.d.cp_bg_line_d);
        }
        String string2 = getArguments().getString("thread_type_key");
        if (!ao.isEmpty(string2)) {
            this.gKs = string2;
        }
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(e.j.to_be_an_liver), new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonThreadFragment.this.btR();
            }
        });
        int dimension = (int) getResources().getDimension(e.C0210e.ds102);
        String str = "";
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension);
        if (this.gKs.equals("photolive")) {
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
                btS();
            }
        } else {
            string = getArguments().getString("key_empty_view_text");
            bVar = null;
        }
        this.gKt.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.aE(string, str), bVar);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.gBp);
        registerListener(this.gBq);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        if (this.gKs.equals("photolive")) {
            this.gKA = 33;
        }
        this.gKv = new com.baidu.tieba.post.a.a(getPageContext(), this.gKt.gKD);
        this.gKt.btX().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                CardPersonDynamicThreadData cardPersonDynamicThreadData;
                if (i >= 0 && PersonThreadFragment.this.gKv != null && i < v.H(PersonThreadFragment.this.gBo.threadList) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) PersonThreadFragment.this.gKv.gzZ.getItem(i)) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonThreadFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.threadId), String.valueOf(cardPersonDynamicThreadData.postId), "person_page", 18005)));
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.k(getPageContext());
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.post.PersonThreadFragment.5
            @Override // com.baidu.tbadk.core.view.j.b
            public void bI(boolean z) {
                if (PersonThreadFragment.this.gBo != null) {
                    PersonThreadFragment.this.gKp = true;
                    if (!com.baidu.adp.lib.util.j.kK()) {
                        if (PersonThreadFragment.this.gKt != null) {
                            PersonThreadFragment.this.gKt.N(PersonThreadFragment.this.getString(e.j.neterror), true);
                            return;
                        }
                        return;
                    }
                    PersonThreadFragment.this.btU();
                }
            }
        });
        this.gKt.gKD.setPullRefresh(this.mPullView);
        if (TbadkCoreApplication.isMyLive) {
            this.dJf = BdListViewHelper.a(getActivity(), this.gKt.gKD, BdListViewHelper.HeadType.DEFAULT);
            BdListViewHelper.a(this.dJf, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kV());
        } else {
            this.dJf = BdListViewHelper.a(getActivity(), this.gKt.gKD, BdListViewHelper.HeadType.HASTAB);
            BdListViewHelper.a(this.dJf, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.gKt.gKD.setOnSrollToBottomListener(this);
        this.gKx = new a(getBaseFragmentActivity());
        this.gKt.gKD.setNextPage(this.gKx);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            btV();
            this.gKx.ayv();
            this.bfy = true;
            return;
        }
        this.gKx.mJ(false);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
    public void b(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null && this.gBo != null) {
            if (z) {
                this.gBo.threadList.clear();
            }
            ArrayList<com.baidu.adp.widget.ListView.h> arrayList = personPostModel.threadList;
            if (personPostModel.view_card_num > 0 && this.gKz) {
                v.a(arrayList, personPostModel.view_card_num - 1, new com.baidu.tieba.personPolymeric.c.j());
                this.gKz = false;
            }
            if (this.gBo.threadList.isEmpty()) {
                com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) v.d(arrayList, 0);
                if (hVar instanceof CardPersonDynamicThreadData) {
                    ((CardPersonDynamicThreadData) hVar).dcp = true;
                } else if (hVar instanceof com.baidu.tieba.personPolymeric.c.j) {
                    ((com.baidu.tieba.personPolymeric.c.j) hVar).dcp = true;
                }
            }
            this.gBo.threadList.addAll(arrayList);
            PersonPostModel.mergeDynamicThreadByTime(this.gBo.threadList);
        }
        if (this.gKy != null) {
            this.gKy.mG(personPostModel.isShowRecycleBinRedTip);
        }
        a(personPostModel, z);
        this.gKv.C(this.gBo.threadList);
        this.gKv.notifyDataSetChanged();
    }

    /* loaded from: classes3.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private BaseFragmentActivity bDk;
        private View bfU;
        private int bgColor = e.d.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View ano = null;
        private int mSkinType = 3;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.bDk = null;
            this.bDk = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View oH() {
            this.ano = LayoutInflater.from(this.bDk.getPageContext().getContext()).inflate(e.h.new_pb_list_more, (ViewGroup) null);
            this.mTextView = (TextView) this.ano.findViewById(e.g.pb_more_text);
            this.bfU = this.ano.findViewById(e.g.pb_more_view);
            al.j(this.ano, this.bgColor);
            al.j(this.bfU, this.bgColor);
            this.bfU.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.ano.findViewById(e.g.progress);
            fv(TbadkCoreApplication.getInst().getSkinType());
            al.h(this.mTextView, e.d.common_color_10039);
            this.bfU.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.bDk.getPageContext().getPageActivity(), e.C0210e.ds120)));
            return this.ano;
        }

        public void fv(int i) {
            this.bDk.getLayoutMode().onModeChanged(this.bfU);
        }

        @SuppressLint({"ResourceAsColor"})
        public void ey(int i) {
            if (this.mSkinType != i) {
                al.h(this.mTextView, e.d.common_color_10039);
                al.e(this.ano, this.bgColor, i);
                al.e(this.bfU, this.bgColor, i);
                this.mSkinType = i;
            }
        }

        public void ayv() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.bDk.getPageContext().getPageActivity().getText(e.j.loading));
            this.bfU.setVisibility(0);
        }

        public void btW() {
            al.j(this.ano, e.d.cp_bg_line_c);
        }

        public void mJ(boolean z) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.bfU.setVisibility(0);
                    this.mTextView.setText(this.bDk.getResources().getString(e.j.list_no_more));
                    return;
                }
                this.bfU.setVisibility(0);
                this.mTextView.setText(this.bDk.getResources().getString(e.j.load_more));
            }
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.ano);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.gKt.mNoDataView != null) {
                this.gKt.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.ey(i);
            }
            if (this.gKv != null) {
                this.gKv.notifyDataSetChanged();
            }
            if (this.gKx != null) {
                this.gKx.ey(i);
            }
            al.j(this.gKt.gKD, e.d.cp_bg_line_d);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.gKt.mNoDataView != null) {
            this.gKt.mNoDataView.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.gKt.mNoDataView != null) {
            this.gKt.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.gKv != null) {
            this.gKv.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.gBo != null) {
            this.gBo.cancelLoadData();
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
            if (i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.gKv != null && this.gBo != null && v.H(this.gBo.threadList) > 0) {
                int H = v.H(this.gBo.threadList);
                int i3 = 0;
                while (true) {
                    if (i3 >= H) {
                        z = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) v.d(this.gBo.threadList, i3);
                    if ((hVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) hVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.threadId))) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (z && intent.getIntExtra("type", -1) == 0) {
                    v.e(this.gBo.threadList, i3);
                    this.gKv.notifyDataSetChanged();
                }
            }
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.ebd != null) {
                    this.ebd.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.post.PersonThreadFragment.6
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void Jo() {
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
        if (!this.gKw) {
            this.gKt.gKD.startPullRefresh();
            this.gKw = true;
        }
    }

    public h btQ() {
        return this.gKt;
    }

    @Override // com.baidu.tieba.post.c
    public void btK() {
        if (this.gKt != null && this.gKt.gKD != null) {
            this.gKt.gKD.startPullRefresh();
        }
    }

    public void a(d dVar) {
        this.gKq = dVar;
    }

    public void a(b bVar) {
        this.gKy = bVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
    public void a(PersonPostModel personPostModel, boolean z) {
        this.bfy = false;
        if (isAdded()) {
            this.gKt.gKD.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            this.gKt.gKD.setEmptyView(null);
            if (personPostModel != null || this.gKp) {
                if (personPostModel == null || (personPostModel.threadList.size() == 0 && this.gKp && StringUtils.isNull(personPostModel.getErrorString()))) {
                    mI(true);
                    return;
                }
                if (personPostModel.threadList.size() == 0 && this.gKp) {
                    mI(true);
                } else {
                    mI(false);
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
                    this.gKo = 0;
                    this.gKp = false;
                }
                this.gKx.mJ(this.mHasMore);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016221));
            }
        }
    }

    private void mI(boolean z) {
        this.gKt.gKD.removeHeaderView(this.gKt.mNoDataView);
        if (z) {
            this.gKt.mNoDataView.setVisibility(0);
            this.gKt.gKD.addHeaderView(this.gKt.mNoDataView);
            this.gKx.getView().setVisibility(8);
            return;
        }
        this.gKx.getView().setVisibility(0);
        this.gKx.btW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btR() {
        TiebaStatic.log("c10491");
        btT();
        com.baidu.tbadk.d.a.b(getBaseFragmentActivity()).a(1, this);
    }

    private void btS() {
        btT();
        com.baidu.tbadk.d.a.b(getBaseFragmentActivity()).b(this);
    }

    private void btT() {
        com.baidu.tbadk.d.a.b(getBaseFragmentActivity()).a(true, true, true, this);
    }

    public void btU() {
        if (this.gBo != null) {
            this.gBo.fetchPost(getPageContext(), this, true, this.mUid, true, this.gKA, false, true);
            this.gKz = true;
        }
    }

    public void btV() {
        if (this.gBo != null) {
            this.gBo.fetchPost(getPageContext(), this, false, this.mUid, true, false, true);
        }
    }
}
