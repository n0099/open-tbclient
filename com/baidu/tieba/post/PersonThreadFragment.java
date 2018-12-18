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
    private View dFI;
    private ShareSuccessReplyToServerModel dXG;
    private com.baidu.tieba.post.a.a gGA;
    private boolean gGB;
    private a gGC;
    private b gGD;
    private int gGF;
    private int gGt;
    private d gGv;
    private h gGy;
    private FrameLayout gGz;
    public PersonPostModel gxt;
    private com.baidu.tbadk.core.view.k mPullView;
    private String mUid;
    private String gGx = PhoneUtils.CPUInfo.FEATURE_COMMON;
    private boolean mHasMore = false;
    private boolean gGu = true;
    private boolean gGE = true;
    private boolean beK = false;
    private CustomMessageListener gxu = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.post.PersonThreadFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && PersonThreadFragment.this.gGA != null) {
                PersonThreadFragment.this.gGA.uf((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gxv = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.post.PersonThreadFragment.2
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
                if (com.baidu.adp.lib.util.j.kV() && PersonThreadFragment.this.beK) {
                    PersonThreadFragment.this.bsA();
                    PersonThreadFragment.this.gGC.axj();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.a(PersonThreadFragment.this.dFI, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kV());
                } else {
                    BdListViewHelper.a(PersonThreadFragment.this.dFI, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.mNetworkChangedMessageListener);
        this.gxt = new PersonPostModel(getPageContext(), getUniqueId(), this, true, PersonPostModel.FROM_PERSON_POST);
        this.gxt.setUniqueId(getUniqueId());
        this.dXG = new ShareSuccessReplyToServerModel();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(e.h.person_thread_fragment, viewGroup, false);
        this.gGz = (FrameLayout) inflate.findViewById(e.g.root_view);
        this.gGy = new h(getActivity(), inflate);
        if (this.gGy.bsD() == null) {
            this.gGy.b(this.gGv);
        }
        if (this.gGy.gGI != null) {
            al.j(this.gGy.gGI, e.d.cp_bg_line_d);
        }
        String string2 = getArguments().getString("thread_type_key");
        if (!ao.isEmpty(string2)) {
            this.gGx = string2;
        }
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(e.j.to_be_an_liver), new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonThreadFragment.this.bsw();
            }
        });
        int dimension = (int) getResources().getDimension(e.C0210e.ds102);
        String str = "";
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension);
        if (this.gGx.equals("photolive")) {
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
                bsx();
            }
        } else {
            string = getArguments().getString("key_empty_view_text");
            bVar = null;
        }
        this.gGy.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.aD(string, str), bVar);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.gxu);
        registerListener(this.gxv);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        if (this.gGx.equals("photolive")) {
            this.gGF = 33;
        }
        this.gGA = new com.baidu.tieba.post.a.a(getPageContext(), this.gGy.gGI);
        this.gGy.bsC().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                CardPersonDynamicThreadData cardPersonDynamicThreadData;
                if (i >= 0 && PersonThreadFragment.this.gGA != null && i < v.H(PersonThreadFragment.this.gxt.threadList) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) PersonThreadFragment.this.gGA.gwe.getItem(i)) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonThreadFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.threadId), String.valueOf(cardPersonDynamicThreadData.postId), "person_page", 18005)));
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.k(getPageContext());
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.post.PersonThreadFragment.5
            @Override // com.baidu.tbadk.core.view.j.b
            public void bH(boolean z) {
                if (PersonThreadFragment.this.gxt != null) {
                    PersonThreadFragment.this.gGu = true;
                    if (!com.baidu.adp.lib.util.j.kK()) {
                        if (PersonThreadFragment.this.gGy != null) {
                            PersonThreadFragment.this.gGy.O(PersonThreadFragment.this.getString(e.j.neterror), true);
                            return;
                        }
                        return;
                    }
                    PersonThreadFragment.this.bsz();
                }
            }
        });
        this.gGy.gGI.setPullRefresh(this.mPullView);
        if (TbadkCoreApplication.isMyLive) {
            this.dFI = BdListViewHelper.a(getActivity(), this.gGy.gGI, BdListViewHelper.HeadType.DEFAULT);
            BdListViewHelper.a(this.dFI, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kV());
        } else {
            this.dFI = BdListViewHelper.a(getActivity(), this.gGy.gGI, BdListViewHelper.HeadType.HASTAB);
            BdListViewHelper.a(this.dFI, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.gGy.gGI.setOnSrollToBottomListener(this);
        this.gGC = new a(getBaseFragmentActivity());
        this.gGy.gGI.setNextPage(this.gGC);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            bsA();
            this.gGC.axj();
            this.beK = true;
            return;
        }
        this.gGC.mG(false);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
    public void b(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null && this.gxt != null) {
            if (z) {
                this.gxt.threadList.clear();
            }
            ArrayList<com.baidu.adp.widget.ListView.h> arrayList = personPostModel.threadList;
            if (personPostModel.view_card_num > 0 && this.gGE) {
                v.a(arrayList, personPostModel.view_card_num - 1, new com.baidu.tieba.personPolymeric.c.j());
                this.gGE = false;
            }
            if (this.gxt.threadList.isEmpty()) {
                com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) v.d(arrayList, 0);
                if (hVar instanceof CardPersonDynamicThreadData) {
                    ((CardPersonDynamicThreadData) hVar).cYL = true;
                } else if (hVar instanceof com.baidu.tieba.personPolymeric.c.j) {
                    ((com.baidu.tieba.personPolymeric.c.j) hVar).cYL = true;
                }
            }
            this.gxt.threadList.addAll(arrayList);
            PersonPostModel.mergeDynamicThreadByTime(this.gxt.threadList);
        }
        if (this.gGD != null) {
            this.gGD.mD(personPostModel.isShowRecycleBinRedTip);
        }
        a(personPostModel, z);
        this.gGA.C(this.gxt.threadList);
        this.gGA.notifyDataSetChanged();
    }

    /* loaded from: classes3.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private BaseFragmentActivity bCu;
        private View bfh;
        private int bgColor = e.d.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View amM = null;
        private int mSkinType = 3;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.bCu = null;
            this.bCu = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View oD() {
            this.amM = LayoutInflater.from(this.bCu.getPageContext().getContext()).inflate(e.h.new_pb_list_more, (ViewGroup) null);
            this.mTextView = (TextView) this.amM.findViewById(e.g.pb_more_text);
            this.bfh = this.amM.findViewById(e.g.pb_more_view);
            al.j(this.amM, this.bgColor);
            al.j(this.bfh, this.bgColor);
            this.bfh.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.amM.findViewById(e.g.progress);
            fu(TbadkCoreApplication.getInst().getSkinType());
            al.h(this.mTextView, e.d.common_color_10039);
            this.bfh.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.bCu.getPageContext().getPageActivity(), e.C0210e.ds120)));
            return this.amM;
        }

        public void fu(int i) {
            this.bCu.getLayoutMode().onModeChanged(this.bfh);
        }

        @SuppressLint({"ResourceAsColor"})
        public void ey(int i) {
            if (this.mSkinType != i) {
                al.h(this.mTextView, e.d.common_color_10039);
                al.e(this.amM, this.bgColor, i);
                al.e(this.bfh, this.bgColor, i);
                this.mSkinType = i;
            }
        }

        public void axj() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.bCu.getPageContext().getPageActivity().getText(e.j.loading));
            this.bfh.setVisibility(0);
        }

        public void bsB() {
            al.j(this.amM, e.d.cp_bg_line_c);
        }

        public void mG(boolean z) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.bfh.setVisibility(0);
                    this.mTextView.setText(this.bCu.getResources().getString(e.j.list_no_more));
                    return;
                }
                this.bfh.setVisibility(0);
                this.mTextView.setText(this.bCu.getResources().getString(e.j.load_more));
            }
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.amM);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.gGy.mNoDataView != null) {
                this.gGy.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.ey(i);
            }
            if (this.gGA != null) {
                this.gGA.notifyDataSetChanged();
            }
            if (this.gGC != null) {
                this.gGC.ey(i);
            }
            al.j(this.gGy.gGI, e.d.cp_bg_line_d);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.gGy.mNoDataView != null) {
            this.gGy.mNoDataView.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.gGy.mNoDataView != null) {
            this.gGy.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.gGA != null) {
            this.gGA.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.gxt != null) {
            this.gxt.cancelLoadData();
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
            if (i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.gGA != null && this.gxt != null && v.H(this.gxt.threadList) > 0) {
                int H = v.H(this.gxt.threadList);
                int i3 = 0;
                while (true) {
                    if (i3 >= H) {
                        z = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) v.d(this.gxt.threadList, i3);
                    if ((hVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) hVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.threadId))) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (z && intent.getIntExtra("type", -1) == 0) {
                    v.e(this.gxt.threadList, i3);
                    this.gGA.notifyDataSetChanged();
                }
            }
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.dXG != null) {
                    this.dXG.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.post.PersonThreadFragment.6
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void IY() {
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
        if (!this.gGB) {
            this.gGy.gGI.startPullRefresh();
            this.gGB = true;
        }
    }

    public h bsv() {
        return this.gGy;
    }

    @Override // com.baidu.tieba.post.c
    public void bsp() {
        if (this.gGy != null && this.gGy.gGI != null) {
            this.gGy.gGI.startPullRefresh();
        }
    }

    public void a(d dVar) {
        this.gGv = dVar;
    }

    public void a(b bVar) {
        this.gGD = bVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
    public void a(PersonPostModel personPostModel, boolean z) {
        this.beK = false;
        if (isAdded()) {
            this.gGy.gGI.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            this.gGy.gGI.setEmptyView(null);
            if (personPostModel != null || this.gGu) {
                if (personPostModel == null || (personPostModel.threadList.size() == 0 && this.gGu && StringUtils.isNull(personPostModel.getErrorString()))) {
                    mF(true);
                    return;
                }
                if (personPostModel.threadList.size() == 0 && this.gGu) {
                    mF(true);
                } else {
                    mF(false);
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
                    this.gGt = 0;
                    this.gGu = false;
                }
                this.gGC.mG(this.mHasMore);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016221));
            }
        }
    }

    private void mF(boolean z) {
        this.gGy.gGI.removeHeaderView(this.gGy.mNoDataView);
        if (z) {
            this.gGy.mNoDataView.setVisibility(0);
            this.gGy.gGI.addHeaderView(this.gGy.mNoDataView);
            this.gGC.getView().setVisibility(8);
            return;
        }
        this.gGC.getView().setVisibility(0);
        this.gGC.bsB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsw() {
        TiebaStatic.log("c10491");
        bsy();
        com.baidu.tbadk.d.a.b(getBaseFragmentActivity()).a(1, this);
    }

    private void bsx() {
        bsy();
        com.baidu.tbadk.d.a.b(getBaseFragmentActivity()).b(this);
    }

    private void bsy() {
        com.baidu.tbadk.d.a.b(getBaseFragmentActivity()).a(true, true, true, this);
    }

    public void bsz() {
        if (this.gxt != null) {
            this.gxt.fetchPost(getPageContext(), this, true, this.mUid, true, this.gGF, false, true);
            this.gGE = true;
        }
    }

    public void bsA() {
        if (this.gxt != null) {
            this.gxt.fetchPost(getPageContext(), this, false, this.mUid, true, false, true);
        }
    }
}
