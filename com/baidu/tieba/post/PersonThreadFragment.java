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
import com.baidu.pass.biometrics.base.utils.PhoneUtils;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.e.b;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.d;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class PersonThreadFragment extends BaseFragment implements BdListView.e, b.a, PersonPostModel.a, PersonPostModel.b, c {
    private View eWw;
    private ShareSuccessReplyToServerModel foH;
    public PersonPostModel hRo;
    private int ibM;
    private d ibO;
    private h ibR;
    private FrameLayout ibS;
    private com.baidu.tieba.post.a.a ibT;
    private boolean ibU;
    private a ibV;
    private b ibW;
    private int ibY;
    private com.baidu.tbadk.core.view.i mPullView;
    private String mUid;
    private String ibQ = PhoneUtils.CPUInfo.FEATURE_COMMON;
    private boolean mHasMore = false;
    private boolean ibN = true;
    private boolean ibX = true;
    private boolean cpi = false;
    private CustomMessageListener hRp = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.post.PersonThreadFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && PersonThreadFragment.this.ibT != null) {
                PersonThreadFragment.this.ibT.Bc((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener hRq = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.post.PersonThreadFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.adp.lib.util.l.showToast(PersonThreadFragment.this.getActivity(), d.j.thread_has_hide);
            }
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.post.PersonThreadFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (com.baidu.adp.lib.util.j.kY() && PersonThreadFragment.this.cpi) {
                    PersonThreadFragment.this.bUK();
                    PersonThreadFragment.this.ibV.aYZ();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.a(PersonThreadFragment.this.eWw, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kY());
                } else {
                    BdListViewHelper.a(PersonThreadFragment.this.eWw, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.mNetworkChangedMessageListener);
        this.hRo = new PersonPostModel(getPageContext(), getUniqueId(), this, true, PersonPostModel.FROM_PERSON_POST);
        this.hRo.setUniqueId(getUniqueId());
        this.foH = new ShareSuccessReplyToServerModel();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.person_thread_fragment, viewGroup, false);
        this.ibS = (FrameLayout) inflate.findViewById(d.g.root_view);
        this.ibR = new h(getActivity(), inflate);
        if (this.ibR.bUN() == null) {
            this.ibR.b(this.ibO);
        }
        if (this.ibR.icb != null) {
            al.l(this.ibR.icb, d.C0277d.cp_bg_line_d);
        }
        String string2 = getArguments().getString("thread_type_key");
        if (!ap.isEmpty(string2)) {
            this.ibQ = string2;
        }
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(d.j.to_be_an_liver), new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonThreadFragment.this.bUG();
            }
        });
        int dimension = (int) getResources().getDimension(d.e.ds102);
        String str = "";
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension);
        if (this.ibQ.equals("photolive")) {
            int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1);
            if (i == 0) {
                str = getPageContext().getResources().getString(d.j.to_live_to_god);
                string = getPageContext().getResources().getString(d.j.user_not_liver);
                a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.new_pic_emotion_10, dimension, -1, -1);
                bVar = NoDataViewFactory.b.a(aVar);
            } else {
                string = getPageContext().getResources().getString(d.j.person_post_lv_empty_host);
                bVar = null;
            }
            if (i < 0) {
                bUH();
            }
        } else {
            string = getArguments().getString("key_empty_view_text");
            bVar = null;
        }
        this.ibR.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.bM(string, str), bVar);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.hRp);
        registerListener(this.hRq);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        if (this.ibQ.equals("photolive")) {
            this.ibY = 33;
        }
        this.ibT = new com.baidu.tieba.post.a.a(getPageContext(), this.ibR.icb);
        this.ibR.bUM().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                CardPersonDynamicThreadData cardPersonDynamicThreadData;
                if (i >= 0 && PersonThreadFragment.this.ibT != null && i < v.S(PersonThreadFragment.this.hRo.threadList) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) PersonThreadFragment.this.ibT.hPZ.getItem(i)) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonThreadFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.threadId), String.valueOf(cardPersonDynamicThreadData.postId), "person_page", 18005)));
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.i(getPageContext());
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.post.PersonThreadFragment.5
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                if (PersonThreadFragment.this.hRo != null) {
                    PersonThreadFragment.this.ibN = true;
                    if (!com.baidu.adp.lib.util.j.kM()) {
                        if (PersonThreadFragment.this.ibR != null) {
                            PersonThreadFragment.this.ibR.ah(PersonThreadFragment.this.getString(d.j.neterror), true);
                            return;
                        }
                        return;
                    }
                    PersonThreadFragment.this.bUJ();
                }
            }
        });
        this.ibR.icb.setPullRefresh(this.mPullView);
        if (TbadkCoreApplication.isMyLive) {
            this.eWw = BdListViewHelper.a(getActivity(), this.ibR.icb, BdListViewHelper.HeadType.DEFAULT);
            BdListViewHelper.a(this.eWw, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kY());
        } else {
            this.eWw = BdListViewHelper.a(getActivity(), this.ibR.icb, BdListViewHelper.HeadType.HASTAB);
            BdListViewHelper.a(this.eWw, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.ibR.icb.setOnSrollToBottomListener(this);
        this.ibV = new a(getBaseFragmentActivity());
        this.ibR.icb.setNextPage(this.ibV);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            bUK();
            this.ibV.aYZ();
            this.cpi = true;
            return;
        }
        this.ibV.pi(false);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
    public void b(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null && this.hRo != null) {
            if (z) {
                this.hRo.threadList.clear();
            }
            ArrayList<com.baidu.adp.widget.ListView.m> arrayList = personPostModel.threadList;
            if (personPostModel.view_card_num > 0 && this.ibX) {
                v.a(arrayList, personPostModel.view_card_num - 1, new com.baidu.tieba.personPolymeric.c.j());
                this.ibX = false;
            }
            if (this.hRo.threadList.isEmpty()) {
                com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) v.c(arrayList, 0);
                if (mVar instanceof CardPersonDynamicThreadData) {
                    ((CardPersonDynamicThreadData) mVar).emn = true;
                } else if (mVar instanceof com.baidu.tieba.personPolymeric.c.j) {
                    ((com.baidu.tieba.personPolymeric.c.j) mVar).emn = true;
                }
            }
            this.hRo.threadList.addAll(arrayList);
            PersonPostModel.mergeDynamicThreadByTime(this.hRo.threadList);
        }
        if (this.ibW != null) {
            this.ibW.pf(personPostModel.isShowRecycleBinRedTip);
        }
        a(personPostModel, z);
        this.ibT.F(this.hRo.threadList);
        this.ibT.notifyDataSetChanged();
    }

    /* loaded from: classes6.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private BaseFragmentActivity cOp;
        private View cpF;
        private int bgColor = d.C0277d.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View btY = null;
        private int mSkinType = 3;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.cOp = null;
            this.cOp = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View oM() {
            this.btY = LayoutInflater.from(this.cOp.getPageContext().getContext()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
            this.mTextView = (TextView) this.btY.findViewById(d.g.pb_more_text);
            this.cpF = this.btY.findViewById(d.g.pb_more_view);
            al.l(this.btY, this.bgColor);
            al.l(this.cpF, this.bgColor);
            this.cpF.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.btY.findViewById(d.g.progress);
            jg(TbadkCoreApplication.getInst().getSkinType());
            al.j(this.mTextView, d.C0277d.common_color_10039);
            this.cpF.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.cOp.getPageContext().getPageActivity(), d.e.ds120)));
            return this.btY;
        }

        public void jg(int i) {
            this.cOp.getLayoutMode().onModeChanged(this.cpF);
        }

        @SuppressLint({"ResourceAsColor"})
        public void ic(int i) {
            if (this.mSkinType != i) {
                al.j(this.mTextView, d.C0277d.common_color_10039);
                al.f(this.btY, this.bgColor, i);
                al.f(this.cpF, this.bgColor, i);
                this.mSkinType = i;
            }
        }

        public void aYZ() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.cOp.getPageContext().getPageActivity().getText(d.j.loading));
            this.cpF.setVisibility(0);
        }

        public void bUL() {
            al.l(this.btY, d.C0277d.cp_bg_line_c);
        }

        public void pi(boolean z) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.cpF.setVisibility(0);
                    this.mTextView.setText(this.cOp.getResources().getString(d.j.list_no_more));
                    return;
                }
                this.cpF.setVisibility(0);
                this.mTextView.setText(this.cOp.getResources().getString(d.j.load_more));
            }
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.btY);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.ibR.mNoDataView != null) {
                this.ibR.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.ic(i);
            }
            if (this.ibT != null) {
                this.ibT.notifyDataSetChanged();
            }
            if (this.ibV != null) {
                this.ibV.ic(i);
            }
            al.l(this.ibR.icb, d.C0277d.cp_bg_line_d);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.ibR.mNoDataView != null) {
            this.ibR.mNoDataView.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.ibR.mNoDataView != null) {
            this.ibR.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.ibT != null) {
            this.ibT.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.hRo != null) {
            this.hRo.cancelLoadData();
        }
        try {
            com.baidu.tbadk.e.a.Hh();
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
            if (i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.ibT != null && this.hRo != null && v.S(this.hRo.threadList) > 0) {
                int S = v.S(this.hRo.threadList);
                int i3 = 0;
                while (true) {
                    if (i3 >= S) {
                        z = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) v.c(this.hRo.threadList, i3);
                    if ((mVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) mVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.threadId))) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (z && intent.getIntExtra("type", -1) == 0) {
                    v.d(this.hRo.threadList, i3);
                    this.ibT.notifyDataSetChanged();
                }
            }
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.foH != null) {
                    this.foH.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.post.PersonThreadFragment.6
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void aiK() {
                        }

                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void a(final CustomDialogData customDialogData) {
                            com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.post.PersonThreadFragment.6.1
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
        if (!this.ibU) {
            this.ibR.icb.startPullRefresh();
            this.ibU = true;
        }
    }

    public h bUF() {
        return this.ibR;
    }

    @Override // com.baidu.tieba.post.c
    public void bUz() {
        if (this.ibR != null && this.ibR.icb != null) {
            this.ibR.icb.startPullRefresh();
        }
    }

    public void a(d dVar) {
        this.ibO = dVar;
    }

    public void a(b bVar) {
        this.ibW = bVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
    public void a(PersonPostModel personPostModel, boolean z) {
        this.cpi = false;
        if (isAdded()) {
            this.ibR.icb.completePullRefreshPostDelayed(0L);
            this.ibR.icb.setEmptyView(null);
            if (personPostModel != null || this.ibN) {
                if (personPostModel == null || (personPostModel.threadList.size() == 0 && this.ibN && StringUtils.isNull(personPostModel.getErrorString()))) {
                    ph(true);
                    return;
                }
                if (personPostModel.threadList.size() == 0 && this.ibN) {
                    ph(true);
                } else {
                    ph(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(getActivity(), personPostModel.getErrorString());
                }
                this.mHasMore = !v.T(personPostModel.threadList);
                if (z) {
                    if (personPostModel.threadList.size() < 20) {
                        this.mHasMore = false;
                    } else {
                        this.mHasMore = true;
                    }
                    this.ibM = 0;
                    this.ibN = false;
                }
                this.ibV.pi(this.mHasMore);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016221));
            }
        }
    }

    private void ph(boolean z) {
        this.ibR.icb.removeHeaderView(this.ibR.mNoDataView);
        if (z) {
            this.ibR.mNoDataView.setVisibility(0);
            this.ibR.icb.addHeaderView(this.ibR.mNoDataView);
            this.ibV.getView().setVisibility(8);
            return;
        }
        this.ibV.getView().setVisibility(0);
        this.ibV.bUL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUG() {
        TiebaStatic.log("c10491");
        bUI();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(1, this);
    }

    private void bUH() {
        bUI();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).b(this);
    }

    private void bUI() {
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(true, true, true, this);
    }

    public void bUJ() {
        if (this.hRo != null) {
            this.hRo.fetchPost(getPageContext(), this, true, this.mUid, true, this.ibY, false, true);
            this.ibX = true;
        }
    }

    public void bUK() {
        if (this.hRo != null) {
            this.hRo.fetchPost(getPageContext(), this, false, this.mUid, true, false, true);
        }
    }
}
