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
    private ShareSuccessReplyToServerModel fEO;
    private View fmn;
    public PersonPostModel ijN;
    private int iud;
    private d iuf;
    private h iui;
    private FrameLayout iuj;
    private com.baidu.tieba.post.a.a iuk;
    private boolean iul;
    private a ium;
    private b iun;
    private int iup;
    private com.baidu.tbadk.core.view.i mPullView;
    private String mUid;
    private String iuh = PhoneUtils.CPUInfo.FEATURE_COMMON;
    private boolean mHasMore = false;
    private boolean iue = true;
    private boolean iuo = true;
    private boolean cxs = false;
    private CustomMessageListener ijO = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.post.PersonThreadFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && PersonThreadFragment.this.iuk != null) {
                PersonThreadFragment.this.iuk.Ct((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener ijP = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.post.PersonThreadFragment.2
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
                    PersonThreadFragment.this.ccG();
                    PersonThreadFragment.this.ium.bgq();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.a(PersonThreadFragment.this.fmn, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.jS());
                } else {
                    BdListViewHelper.a(PersonThreadFragment.this.fmn, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.mNetworkChangedMessageListener);
        this.ijN = new PersonPostModel(getPageContext(), getUniqueId(), this, true, PersonPostModel.FROM_PERSON_POST);
        this.ijN.setUniqueId(getUniqueId());
        this.fEO = new ShareSuccessReplyToServerModel();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_thread_fragment, viewGroup, false);
        this.iuj = (FrameLayout) inflate.findViewById(R.id.root_view);
        this.iui = new h(getActivity(), inflate);
        if (this.iui.ccJ() == null) {
            this.iui.b(this.iuf);
        }
        if (this.iui.ius != null) {
            al.l(this.iui.ius, R.color.cp_bg_line_d);
        }
        String string2 = getArguments().getString("thread_type_key");
        if (!ap.isEmpty(string2)) {
            this.iuh = string2;
        }
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(R.string.to_be_an_liver), new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonThreadFragment.this.ccC();
            }
        });
        int dimension = (int) getResources().getDimension(R.dimen.ds102);
        String str = "";
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension);
        if (this.iuh.equals("photolive")) {
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
                ccD();
            }
        } else {
            string = getArguments().getString("key_empty_view_text");
            bVar = null;
        }
        this.iui.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.bW(string, str), bVar);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.ijO);
        registerListener(this.ijP);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        if (this.iuh.equals("photolive")) {
            this.iup = 33;
        }
        this.iuk = new com.baidu.tieba.post.a.a(getPageContext(), this.iui.ius);
        this.iui.ccI().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                CardPersonDynamicThreadData cardPersonDynamicThreadData;
                if (i >= 0 && PersonThreadFragment.this.iuk != null && i < v.Z(PersonThreadFragment.this.ijN.threadList) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) PersonThreadFragment.this.iuk.iiy.getItem(i)) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonThreadFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.threadId), String.valueOf(cardPersonDynamicThreadData.postId), "person_page", 18005)));
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.i(getPageContext());
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.post.PersonThreadFragment.5
            @Override // com.baidu.tbadk.core.view.h.c
            public void en(boolean z) {
                if (PersonThreadFragment.this.ijN != null) {
                    PersonThreadFragment.this.iue = true;
                    if (!com.baidu.adp.lib.util.j.jG()) {
                        if (PersonThreadFragment.this.iui != null) {
                            PersonThreadFragment.this.iui.aj(PersonThreadFragment.this.getString(R.string.neterror), true);
                            return;
                        }
                        return;
                    }
                    PersonThreadFragment.this.ccF();
                }
            }
        });
        this.iui.ius.setPullRefresh(this.mPullView);
        if (TbadkCoreApplication.isMyLive) {
            this.fmn = BdListViewHelper.a(getActivity(), this.iui.ius, BdListViewHelper.HeadType.DEFAULT);
            BdListViewHelper.a(this.fmn, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.jS());
        } else {
            this.fmn = BdListViewHelper.a(getActivity(), this.iui.ius, BdListViewHelper.HeadType.HASTAB);
            BdListViewHelper.a(this.fmn, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.iui.ius.setOnSrollToBottomListener(this);
        this.ium = new a(getBaseFragmentActivity());
        this.iui.ius.setNextPage(this.ium);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            ccG();
            this.ium.bgq();
            this.cxs = true;
            return;
        }
        this.ium.pW(false);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
    public void b(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null && this.ijN != null) {
            if (z) {
                this.ijN.threadList.clear();
            }
            ArrayList<com.baidu.adp.widget.ListView.m> arrayList = personPostModel.threadList;
            if (personPostModel.view_card_num > 0 && this.iuo) {
                v.a(arrayList, personPostModel.view_card_num - 1, new com.baidu.tieba.personPolymeric.c.j());
                this.iuo = false;
            }
            if (this.ijN.threadList.isEmpty()) {
                com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) v.c(arrayList, 0);
                if (mVar instanceof CardPersonDynamicThreadData) {
                    ((CardPersonDynamicThreadData) mVar).eBN = true;
                } else if (mVar instanceof com.baidu.tieba.personPolymeric.c.j) {
                    ((com.baidu.tieba.personPolymeric.c.j) mVar).eBN = true;
                }
            }
            this.ijN.threadList.addAll(arrayList);
            PersonPostModel.mergeDynamicThreadByTime(this.ijN.threadList);
        }
        if (this.iun != null) {
            this.iun.pT(personPostModel.isShowRecycleBinRedTip);
        }
        a(personPostModel, z);
        this.iuk.I(this.ijN.threadList);
        this.iuk.notifyDataSetChanged();
    }

    /* loaded from: classes6.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private BaseFragmentActivity cWD;
        private View cxO;
        private int bgColor = R.color.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View bBg = null;
        private int mSkinType = 3;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.cWD = null;
            this.cWD = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View nG() {
            this.bBg = LayoutInflater.from(this.cWD.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mTextView = (TextView) this.bBg.findViewById(R.id.pb_more_text);
            this.cxO = this.bBg.findViewById(R.id.pb_more_view);
            al.l(this.bBg, this.bgColor);
            al.l(this.cxO, this.bgColor);
            this.cxO.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.bBg.findViewById(R.id.progress);
            jT(TbadkCoreApplication.getInst().getSkinType());
            al.j(this.mTextView, R.color.common_color_10039);
            this.cxO.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.g(this.cWD.getPageContext().getPageActivity(), R.dimen.ds120)));
            return this.bBg;
        }

        public void jT(int i) {
            this.cWD.getLayoutMode().onModeChanged(this.cxO);
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

        public void bgq() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.cWD.getPageContext().getPageActivity().getText(R.string.loading));
            this.cxO.setVisibility(0);
        }

        public void ccH() {
            al.l(this.bBg, R.color.cp_bg_line_c);
        }

        public void pW(boolean z) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.cxO.setVisibility(0);
                    this.mTextView.setText(this.cWD.getResources().getString(R.string.list_no_more));
                    return;
                }
                this.cxO.setVisibility(0);
                this.mTextView.setText(this.cWD.getResources().getString(R.string.load_more));
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
            if (this.iui.mNoDataView != null) {
                this.iui.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.iP(i);
            }
            if (this.iuk != null) {
                this.iuk.notifyDataSetChanged();
            }
            if (this.ium != null) {
                this.ium.iP(i);
            }
            al.l(this.iui.ius, R.color.cp_bg_line_d);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.iui.mNoDataView != null) {
            this.iui.mNoDataView.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.iui.mNoDataView != null) {
            this.iui.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.iuk != null) {
            this.iuk.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.ijN != null) {
            this.ijN.cancelLoadData();
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
            if (i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.iuk != null && this.ijN != null && v.Z(this.ijN.threadList) > 0) {
                int Z = v.Z(this.ijN.threadList);
                int i3 = 0;
                while (true) {
                    if (i3 >= Z) {
                        z = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) v.c(this.ijN.threadList, i3);
                    if ((mVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) mVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.threadId))) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (z && intent.getIntExtra("type", -1) == 0) {
                    v.d(this.ijN.threadList, i3);
                    this.iuk.notifyDataSetChanged();
                }
            }
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.fEO != null) {
                    this.fEO.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.post.PersonThreadFragment.6
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
        if (!this.iul) {
            this.iui.ius.startPullRefresh();
            this.iul = true;
        }
    }

    public h ccB() {
        return this.iui;
    }

    @Override // com.baidu.tieba.post.c
    public void ccw() {
        if (this.iui != null && this.iui.ius != null) {
            this.iui.ius.startPullRefresh();
        }
    }

    public void a(d dVar) {
        this.iuf = dVar;
    }

    public void a(b bVar) {
        this.iun = bVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
    public void a(PersonPostModel personPostModel, boolean z) {
        this.cxs = false;
        if (isAdded()) {
            this.iui.ius.completePullRefreshPostDelayed(0L);
            this.iui.ius.setEmptyView(null);
            if (personPostModel != null || this.iue) {
                if (personPostModel == null || (personPostModel.threadList.size() == 0 && this.iue && StringUtils.isNull(personPostModel.getErrorString()))) {
                    pV(true);
                    return;
                }
                if (personPostModel.threadList.size() == 0 && this.iue) {
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
                    this.iud = 0;
                    this.iue = false;
                }
                this.ium.pW(this.mHasMore);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016221));
            }
        }
    }

    private void pV(boolean z) {
        this.iui.ius.removeHeaderView(this.iui.mNoDataView);
        if (z) {
            this.iui.mNoDataView.setVisibility(0);
            this.iui.ius.addHeaderView(this.iui.mNoDataView);
            this.ium.getView().setVisibility(8);
            return;
        }
        this.ium.getView().setVisibility(0);
        this.ium.ccH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccC() {
        TiebaStatic.log("c10491");
        ccE();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(1, this);
    }

    private void ccD() {
        ccE();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).b(this);
    }

    private void ccE() {
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(true, true, true, this);
    }

    public void ccF() {
        if (this.ijN != null) {
            this.ijN.fetchPost(getPageContext(), this, true, this.mUid, true, this.iup, false, true);
            this.iuo = true;
        }
    }

    public void ccG() {
        if (this.ijN != null) {
            this.ijN.fetchPost(getPageContext(), this, false, this.mUid, true, false, true);
        }
    }
}
