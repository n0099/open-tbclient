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
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class PersonThreadFragment extends BaseFragment implements BdListView.e, b.a, PersonPostModel.a, PersonPostModel.b, c {
    private ShareSuccessReplyToServerModel fEP;
    private View fmo;
    public PersonPostModel ijQ;
    private int iug;
    private d iui;
    private h iul;
    private FrameLayout ium;
    private com.baidu.tieba.post.a.a iun;
    private boolean iuo;
    private a iup;
    private b iuq;
    private int ius;
    private com.baidu.tbadk.core.view.i mPullView;
    private String mUid;
    private String iuk = PhoneUtils.CPUInfo.FEATURE_COMMON;
    private boolean mHasMore = false;
    private boolean iuh = true;
    private boolean iur = true;
    private boolean cxs = false;
    private CustomMessageListener ijR = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.post.PersonThreadFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && PersonThreadFragment.this.iun != null) {
                PersonThreadFragment.this.iun.Ct((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener ijS = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.post.PersonThreadFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.adp.lib.util.l.showToast(PersonThreadFragment.this.getActivity(), (int) R.string.thread_has_hide);
            }
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.post.PersonThreadFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (com.baidu.adp.lib.util.j.jS() && PersonThreadFragment.this.cxs) {
                    PersonThreadFragment.this.ccJ();
                    PersonThreadFragment.this.iup.bgt();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.a(PersonThreadFragment.this.fmo, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.jS());
                } else {
                    BdListViewHelper.a(PersonThreadFragment.this.fmo, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.mNetworkChangedMessageListener);
        this.ijQ = new PersonPostModel(getPageContext(), getUniqueId(), this, true, PersonPostModel.FROM_PERSON_POST);
        this.ijQ.setUniqueId(getUniqueId());
        this.fEP = new ShareSuccessReplyToServerModel();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_thread_fragment, viewGroup, false);
        this.ium = (FrameLayout) inflate.findViewById(R.id.root_view);
        this.iul = new h(getActivity(), inflate);
        if (this.iul.ccM() == null) {
            this.iul.b(this.iui);
        }
        if (this.iul.iuv != null) {
            al.l(this.iul.iuv, R.color.cp_bg_line_d);
        }
        String string2 = getArguments().getString("thread_type_key");
        if (!ap.isEmpty(string2)) {
            this.iuk = string2;
        }
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(R.string.to_be_an_liver), new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonThreadFragment.this.ccF();
            }
        });
        int dimension = (int) getResources().getDimension(R.dimen.ds102);
        String str = "";
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension);
        if (this.iuk.equals("photolive")) {
            int i = com.baidu.tbadk.core.sharedPref.b.agM().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1);
            if (i == 0) {
                str = getPageContext().getResources().getString(R.string.to_live_to_god);
                string = getPageContext().getResources().getString(R.string.user_not_liver);
                a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_10, dimension, -1, -1);
                bVar = NoDataViewFactory.b.a(aVar);
            } else {
                string = getPageContext().getResources().getString(R.string.person_post_lv_empty_host);
                bVar = null;
            }
            if (i < 0) {
                ccG();
            }
        } else {
            string = getArguments().getString("key_empty_view_text");
            bVar = null;
        }
        this.iul.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.bW(string, str), bVar);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.ijR);
        registerListener(this.ijS);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        if (this.iuk.equals("photolive")) {
            this.ius = 33;
        }
        this.iun = new com.baidu.tieba.post.a.a(getPageContext(), this.iul.iuv);
        this.iul.ccL().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                CardPersonDynamicThreadData cardPersonDynamicThreadData;
                if (i >= 0 && PersonThreadFragment.this.iun != null && i < v.Z(PersonThreadFragment.this.ijQ.threadList) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) PersonThreadFragment.this.iun.iiB.getItem(i)) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonThreadFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.threadId), String.valueOf(cardPersonDynamicThreadData.postId), "person_page", 18005)));
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.i(getPageContext());
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.post.PersonThreadFragment.5
            @Override // com.baidu.tbadk.core.view.h.c
            public void en(boolean z) {
                if (PersonThreadFragment.this.ijQ != null) {
                    PersonThreadFragment.this.iuh = true;
                    if (!com.baidu.adp.lib.util.j.jG()) {
                        if (PersonThreadFragment.this.iul != null) {
                            PersonThreadFragment.this.iul.aj(PersonThreadFragment.this.getString(R.string.neterror), true);
                            return;
                        }
                        return;
                    }
                    PersonThreadFragment.this.ccI();
                }
            }
        });
        this.iul.iuv.setPullRefresh(this.mPullView);
        if (TbadkCoreApplication.isMyLive) {
            this.fmo = BdListViewHelper.a(getActivity(), this.iul.iuv, BdListViewHelper.HeadType.DEFAULT);
            BdListViewHelper.a(this.fmo, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.jS());
        } else {
            this.fmo = BdListViewHelper.a(getActivity(), this.iul.iuv, BdListViewHelper.HeadType.HASTAB);
            BdListViewHelper.a(this.fmo, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.iul.iuv.setOnSrollToBottomListener(this);
        this.iup = new a(getBaseFragmentActivity());
        this.iul.iuv.setNextPage(this.iup);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            ccJ();
            this.iup.bgt();
            this.cxs = true;
            return;
        }
        this.iup.pW(false);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
    public void b(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null && this.ijQ != null) {
            if (z) {
                this.ijQ.threadList.clear();
            }
            ArrayList<com.baidu.adp.widget.ListView.m> arrayList = personPostModel.threadList;
            if (personPostModel.view_card_num > 0 && this.iur) {
                v.a(arrayList, personPostModel.view_card_num - 1, new com.baidu.tieba.personPolymeric.c.j());
                this.iur = false;
            }
            if (this.ijQ.threadList.isEmpty()) {
                com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) v.c(arrayList, 0);
                if (mVar instanceof CardPersonDynamicThreadData) {
                    ((CardPersonDynamicThreadData) mVar).eBO = true;
                } else if (mVar instanceof com.baidu.tieba.personPolymeric.c.j) {
                    ((com.baidu.tieba.personPolymeric.c.j) mVar).eBO = true;
                }
            }
            this.ijQ.threadList.addAll(arrayList);
            PersonPostModel.mergeDynamicThreadByTime(this.ijQ.threadList);
        }
        if (this.iuq != null) {
            this.iuq.pT(personPostModel.isShowRecycleBinRedTip);
        }
        a(personPostModel, z);
        this.iun.I(this.ijQ.threadList);
        this.iun.notifyDataSetChanged();
    }

    /* loaded from: classes6.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private BaseFragmentActivity cWE;
        private View cxO;
        private int bgColor = R.color.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View bBg = null;
        private int mSkinType = 3;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.cWE = null;
            this.cWE = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View nG() {
            this.bBg = LayoutInflater.from(this.cWE.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mTextView = (TextView) this.bBg.findViewById(R.id.pb_more_text);
            this.cxO = this.bBg.findViewById(R.id.pb_more_view);
            al.l(this.bBg, this.bgColor);
            al.l(this.cxO, this.bgColor);
            this.cxO.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.bBg.findViewById(R.id.progress);
            jT(TbadkCoreApplication.getInst().getSkinType());
            al.j(this.mTextView, R.color.common_color_10039);
            this.cxO.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.g(this.cWE.getPageContext().getPageActivity(), R.dimen.ds120)));
            return this.bBg;
        }

        public void jT(int i) {
            this.cWE.getLayoutMode().onModeChanged(this.cxO);
        }

        @SuppressLint({"ResourceAsColor"})
        public void iP(int i) {
            if (this.mSkinType != i) {
                al.j(this.mTextView, R.color.common_color_10039);
                al.h(this.bBg, this.bgColor, i);
                al.h(this.cxO, this.bgColor, i);
                this.mSkinType = i;
            }
        }

        public void bgt() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.cWE.getPageContext().getPageActivity().getText(R.string.loading));
            this.cxO.setVisibility(0);
        }

        public void ccK() {
            al.l(this.bBg, R.color.cp_bg_line_c);
        }

        public void pW(boolean z) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.cxO.setVisibility(0);
                    this.mTextView.setText(this.cWE.getResources().getString(R.string.list_no_more));
                    return;
                }
                this.cxO.setVisibility(0);
                this.mTextView.setText(this.cWE.getResources().getString(R.string.load_more));
            }
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.bBg);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.iul.mNoDataView != null) {
                this.iul.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.iP(i);
            }
            if (this.iun != null) {
                this.iun.notifyDataSetChanged();
            }
            if (this.iup != null) {
                this.iup.iP(i);
            }
            al.l(this.iul.iuv, R.color.cp_bg_line_d);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.iul.mNoDataView != null) {
            this.iul.mNoDataView.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.iul.mNoDataView != null) {
            this.iul.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.iun != null) {
            this.iun.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.ijQ != null) {
            this.ijQ.cancelLoadData();
        }
        try {
            com.baidu.tbadk.e.a.Jv();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        BdAsyncTask.removeAllTask(SetPrivacyModel.UNIQUE_ID_SET_PRIVACY_TASK);
        BdAsyncTask.removeAllTask(ForumManageModel.UNIQUE_ID_DEL_POST_TASK);
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.coreExtra.c.e shareItem;
        String stringExtra;
        boolean z;
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.iun != null && this.ijQ != null && v.Z(this.ijQ.threadList) > 0) {
                int Z = v.Z(this.ijQ.threadList);
                int i3 = 0;
                while (true) {
                    if (i3 >= Z) {
                        z = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) v.c(this.ijQ.threadList, i3);
                    if ((mVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) mVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.threadId))) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (z && intent.getIntExtra("type", -1) == 0) {
                    v.d(this.ijQ.threadList, i3);
                    this.iun.notifyDataSetChanged();
                }
            }
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.fEP != null) {
                    this.fEP.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.post.PersonThreadFragment.6
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void anI() {
                        }

                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void a(final CustomDialogData customDialogData) {
                            com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.post.PersonThreadFragment.6.1
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
        if (!this.iuo) {
            this.iul.iuv.startPullRefresh();
            this.iuo = true;
        }
    }

    public h ccE() {
        return this.iul;
    }

    @Override // com.baidu.tieba.post.c
    public void ccz() {
        if (this.iul != null && this.iul.iuv != null) {
            this.iul.iuv.startPullRefresh();
        }
    }

    public void a(d dVar) {
        this.iui = dVar;
    }

    public void a(b bVar) {
        this.iuq = bVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
    public void a(PersonPostModel personPostModel, boolean z) {
        this.cxs = false;
        if (isAdded()) {
            this.iul.iuv.completePullRefreshPostDelayed(0L);
            this.iul.iuv.setEmptyView(null);
            if (personPostModel != null || this.iuh) {
                if (personPostModel == null || (personPostModel.threadList.size() == 0 && this.iuh && StringUtils.isNull(personPostModel.getErrorString()))) {
                    pV(true);
                    return;
                }
                if (personPostModel.threadList.size() == 0 && this.iuh) {
                    pV(true);
                } else {
                    pV(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(getActivity(), personPostModel.getErrorString());
                }
                this.mHasMore = !v.aa(personPostModel.threadList);
                if (z) {
                    if (personPostModel.threadList.size() < 20) {
                        this.mHasMore = false;
                    } else {
                        this.mHasMore = true;
                    }
                    this.iug = 0;
                    this.iuh = false;
                }
                this.iup.pW(this.mHasMore);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016221));
            }
        }
    }

    private void pV(boolean z) {
        this.iul.iuv.removeHeaderView(this.iul.mNoDataView);
        if (z) {
            this.iul.mNoDataView.setVisibility(0);
            this.iul.iuv.addHeaderView(this.iul.mNoDataView);
            this.iup.getView().setVisibility(8);
            return;
        }
        this.iup.getView().setVisibility(0);
        this.iup.ccK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccF() {
        TiebaStatic.log("c10491");
        ccH();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(1, this);
    }

    private void ccG() {
        ccH();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).b(this);
    }

    private void ccH() {
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(true, true, true, this);
    }

    public void ccI() {
        if (this.ijQ != null) {
            this.ijQ.fetchPost(getPageContext(), this, true, this.mUid, true, this.ius, false, true);
            this.iur = true;
        }
    }

    public void ccJ() {
        if (this.ijQ != null) {
            this.ijQ.fetchPost(getPageContext(), this, false, this.mUid, true, false, true);
        }
    }
}
