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
import com.baidu.tbadk.c.b;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.g;
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
public class PersonThreadFragment extends BaseFragment implements BdListView.e, b.a, PersonPostModel.a, PersonPostModel.b, c {
    private View dhi;
    private ShareSuccessReplyToServerModel dyM;
    public PersonPostModel fZU;
    private int giI;
    private d giK;
    private h giN;
    private FrameLayout giO;
    private com.baidu.tieba.post.a.a giP;
    private boolean giQ;
    private a giR;
    private b giS;
    private int giU;
    private com.baidu.tbadk.core.view.h mPullView;
    private String mUid;
    private String giM = PhoneUtils.CPUInfo.FEATURE_COMMON;
    private boolean mHasMore = false;
    private boolean giJ = true;
    private boolean giT = true;
    private boolean aSJ = false;
    private CustomMessageListener fZV = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.post.PersonThreadFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && PersonThreadFragment.this.giP != null) {
                PersonThreadFragment.this.giP.su((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener fZW = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.post.PersonThreadFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.adp.lib.util.l.showToast(PersonThreadFragment.this.getActivity(), d.k.thread_has_hide);
            }
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.post.PersonThreadFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (com.baidu.adp.lib.util.j.jD() && PersonThreadFragment.this.aSJ) {
                    PersonThreadFragment.this.bnb();
                    PersonThreadFragment.this.giR.aqp();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.a(PersonThreadFragment.this.dhi, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.jD());
                } else {
                    BdListViewHelper.a(PersonThreadFragment.this.dhi, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.mNetworkChangedMessageListener);
        this.fZU = new PersonPostModel(getPageContext(), getUniqueId(), this, true, PersonPostModel.FROM_PERSON_POST);
        this.fZU.setUniqueId(getUniqueId());
        this.dyM = new ShareSuccessReplyToServerModel();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(d.i.person_thread_fragment, viewGroup, false);
        this.giO = (FrameLayout) inflate.findViewById(d.g.root_view);
        this.giN = new h(getActivity(), inflate);
        if (this.giN.bne() == null) {
            this.giN.b(this.giK);
        }
        if (this.giN.giX != null) {
            am.j(this.giN.giX, d.C0142d.cp_bg_line_d);
        }
        String string2 = getArguments().getString("thread_type_key");
        if (!ap.isEmpty(string2)) {
            this.giM = string2;
        }
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(d.k.to_be_an_liver), new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonThreadFragment.this.bmX();
            }
        });
        int dimension = (int) getResources().getDimension(d.e.ds102);
        String str = "";
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension);
        if (this.giM.equals("photolive")) {
            int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1);
            if (i == 0) {
                str = getPageContext().getResources().getString(d.k.to_live_to_god);
                string = getPageContext().getResources().getString(d.k.user_not_liver);
                a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.go_to_live_pic, dimension, -1, -1);
                bVar = NoDataViewFactory.b.a(aVar);
            } else {
                string = getPageContext().getResources().getString(d.k.person_post_lv_empty_host);
                bVar = null;
            }
            if (i < 0) {
                bmY();
            }
        } else {
            string = getArguments().getString("key_empty_view_text");
            bVar = null;
        }
        this.giN.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.aj(string, str), bVar);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.fZV);
        registerListener(this.fZW);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        if (this.giM.equals("photolive")) {
            this.giU = 33;
        }
        this.giP = new com.baidu.tieba.post.a.a(getPageContext(), this.giN.giX);
        this.giN.bnd().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                CardPersonDynamicThreadData cardPersonDynamicThreadData;
                if (i >= 0 && PersonThreadFragment.this.giP != null && i < w.z(PersonThreadFragment.this.fZU.threadList) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) PersonThreadFragment.this.giP.fYF.getItem(i)) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonThreadFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.threadId), String.valueOf(cardPersonDynamicThreadData.postId), "person_page", 18005)));
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.h(getPageContext());
        this.mPullView.a(new g.b() { // from class: com.baidu.tieba.post.PersonThreadFragment.5
            @Override // com.baidu.tbadk.core.view.g.b
            public void aU(boolean z) {
                if (PersonThreadFragment.this.fZU != null) {
                    PersonThreadFragment.this.giJ = true;
                    if (!com.baidu.adp.lib.util.j.jr()) {
                        if (PersonThreadFragment.this.giN != null) {
                            PersonThreadFragment.this.giN.F(PersonThreadFragment.this.getString(d.k.neterror), true);
                            return;
                        }
                        return;
                    }
                    PersonThreadFragment.this.bna();
                }
            }
        });
        this.giN.giX.setPullRefresh(this.mPullView);
        if (TbadkCoreApplication.isMyLive) {
            this.dhi = BdListViewHelper.a(getActivity(), this.giN.giX, BdListViewHelper.HeadType.DEFAULT);
            BdListViewHelper.a(this.dhi, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.jD());
        } else {
            this.dhi = BdListViewHelper.a(getActivity(), this.giN.giX, BdListViewHelper.HeadType.HASTAB);
            BdListViewHelper.a(this.dhi, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.giN.giX.setOnSrollToBottomListener(this);
        this.giR = new a(getBaseFragmentActivity());
        this.giN.giX.setNextPage(this.giR);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            bnb();
            this.giR.aqp();
            this.aSJ = true;
            return;
        }
        this.giR.lQ(false);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
    public void b(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null && this.fZU != null) {
            if (z) {
                this.fZU.threadList.clear();
            }
            ArrayList<com.baidu.adp.widget.ListView.h> arrayList = personPostModel.threadList;
            if (personPostModel.view_card_num > 0 && this.giT) {
                w.a(arrayList, personPostModel.view_card_num - 1, new com.baidu.tieba.personPolymeric.c.j());
                this.giT = false;
            }
            if (this.fZU.threadList.isEmpty()) {
                com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) w.d(arrayList, 0);
                if (hVar instanceof CardPersonDynamicThreadData) {
                    ((CardPersonDynamicThreadData) hVar).cAm = true;
                } else if (hVar instanceof com.baidu.tieba.personPolymeric.c.j) {
                    ((com.baidu.tieba.personPolymeric.c.j) hVar).cAm = true;
                }
            }
            this.fZU.threadList.addAll(arrayList);
            PersonPostModel.mergeDynamicThreadByTime(this.fZU.threadList);
        }
        if (this.giS != null) {
            this.giS.lN(personPostModel.isShowRecycleBinRedTip);
        }
        a(personPostModel, z);
        this.giP.C(this.fZU.threadList);
        this.giP.notifyDataSetChanged();
    }

    /* loaded from: classes3.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private View aTf;
        private BaseFragmentActivity bnK;
        private int bgColor = d.C0142d.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View abt = null;
        private int mSkinType = 3;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.bnK = null;
            this.bnK = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View nn() {
            this.abt = LayoutInflater.from(this.bnK.getPageContext().getContext()).inflate(d.i.new_pb_list_more, (ViewGroup) null);
            this.mTextView = (TextView) this.abt.findViewById(d.g.pb_more_text);
            this.aTf = this.abt.findViewById(d.g.pb_more_view);
            am.j(this.abt, this.bgColor);
            am.j(this.aTf, this.bgColor);
            this.aTf.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.abt.findViewById(d.g.progress);
            ev(TbadkCoreApplication.getInst().getSkinType());
            am.h(this.mTextView, d.C0142d.common_color_10039);
            this.aTf.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.e(this.bnK.getPageContext().getPageActivity(), d.e.ds120)));
            return this.abt;
        }

        public void ev(int i) {
            this.bnK.getLayoutMode().onModeChanged(this.aTf);
        }

        @SuppressLint({"ResourceAsColor"})
        public void dz(int i) {
            if (this.mSkinType != i) {
                am.h(this.mTextView, d.C0142d.common_color_10039);
                am.e(this.abt, this.bgColor, i);
                am.e(this.aTf, this.bgColor, i);
                this.mSkinType = i;
            }
        }

        public void aqp() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.bnK.getPageContext().getPageActivity().getText(d.k.loading));
            this.aTf.setVisibility(0);
        }

        public void bnc() {
            am.j(this.abt, d.C0142d.cp_bg_line_c);
        }

        public void lQ(boolean z) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.aTf.setVisibility(0);
                    this.mTextView.setText(this.bnK.getResources().getString(d.k.list_no_more));
                    return;
                }
                this.aTf.setVisibility(0);
                this.mTextView.setText(this.bnK.getResources().getString(d.k.load_more));
            }
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.abt);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.giN.mNoDataView != null) {
                this.giN.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.dz(i);
            }
            if (this.giP != null) {
                this.giP.notifyDataSetChanged();
            }
            if (this.giR != null) {
                this.giR.dz(i);
            }
            am.j(this.giN.giX, d.C0142d.cp_bg_line_d);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.giN.mNoDataView != null) {
            this.giN.mNoDataView.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.giN.mNoDataView != null) {
            this.giN.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.giP != null) {
            this.giP.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.fZU != null) {
            this.fZU.cancelLoadData();
        }
        try {
            com.baidu.tbadk.c.a.resetAll();
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
            if (i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.giP != null && this.fZU != null && w.z(this.fZU.threadList) > 0) {
                int z2 = w.z(this.fZU.threadList);
                int i3 = 0;
                while (true) {
                    if (i3 >= z2) {
                        z = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) w.d(this.fZU.threadList, i3);
                    if ((hVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) hVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.threadId))) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (z && intent.getIntExtra("type", -1) == 0) {
                    w.e(this.fZU.threadList, i3);
                    this.giP.notifyDataSetChanged();
                }
            }
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.dyM != null) {
                    this.dyM.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.post.PersonThreadFragment.6
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void Ew() {
                        }

                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void a(final CustomDialogData customDialogData) {
                            com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.post.PersonThreadFragment.6.1
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
        if (!this.giQ) {
            this.giN.giX.startPullRefresh();
            this.giQ = true;
        }
    }

    public h bmW() {
        return this.giN;
    }

    @Override // com.baidu.tieba.post.c
    public void bmQ() {
        if (this.giN != null && this.giN.giX != null) {
            this.giN.giX.startPullRefresh();
        }
    }

    public void a(d dVar) {
        this.giK = dVar;
    }

    public void a(b bVar) {
        this.giS = bVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
    public void a(PersonPostModel personPostModel, boolean z) {
        this.aSJ = false;
        if (isAdded()) {
            this.giN.giX.completePullRefreshPostDelayed(2000L);
            this.giN.giX.setEmptyView(null);
            if (personPostModel != null || this.giJ) {
                if (personPostModel == null || (personPostModel.threadList.size() == 0 && this.giJ && StringUtils.isNull(personPostModel.getErrorString()))) {
                    lP(true);
                    return;
                }
                if (personPostModel.threadList.size() == 0 && this.giJ) {
                    lP(true);
                } else {
                    lP(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(getActivity(), personPostModel.getErrorString());
                }
                this.mHasMore = !w.A(personPostModel.threadList);
                if (z) {
                    if (personPostModel.threadList.size() < 20) {
                        this.mHasMore = false;
                    } else {
                        this.mHasMore = true;
                    }
                    this.giI = 0;
                    this.giJ = false;
                }
                this.giR.lQ(this.mHasMore);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016221));
            }
        }
    }

    private void lP(boolean z) {
        this.giN.giX.removeHeaderView(this.giN.mNoDataView);
        if (z) {
            this.giN.mNoDataView.setVisibility(0);
            this.giN.giX.addHeaderView(this.giN.mNoDataView);
            this.giR.getView().setVisibility(8);
            return;
        }
        this.giR.getView().setVisibility(0);
        this.giR.bnc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmX() {
        TiebaStatic.log("c10491");
        bmZ();
        com.baidu.tbadk.c.a.b(getBaseFragmentActivity()).a(1, this);
    }

    private void bmY() {
        bmZ();
        com.baidu.tbadk.c.a.b(getBaseFragmentActivity()).b(this);
    }

    private void bmZ() {
        com.baidu.tbadk.c.a.b(getBaseFragmentActivity()).a(true, true, true, this);
    }

    public void bna() {
        if (this.fZU != null) {
            this.fZU.fetchPost(getPageContext(), this, true, this.mUid, true, this.giU, false, true);
            this.giT = true;
        }
    }

    public void bnb() {
        if (this.fZU != null) {
            this.fZU.fetchPost(getPageContext(), this, false, this.mUid, true, false, true);
        }
    }
}
