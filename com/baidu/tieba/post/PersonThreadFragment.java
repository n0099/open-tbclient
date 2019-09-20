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
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
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
    private ShareSuccessReplyToServerModel fMq;
    private View ftz;
    private int iDU;
    private d iDW;
    private h iDZ;
    private FrameLayout iEa;
    private com.baidu.tieba.post.a.a iEb;
    private boolean iEc;
    private a iEd;
    private b iEe;
    private int iEg;
    public PersonPostModel itm;
    private com.baidu.tbadk.core.view.i mPullView;
    private String mUid;
    private String iDY = "common";
    private boolean mHasMore = false;
    private boolean iDV = true;
    private boolean iEf = true;
    private boolean czL = false;
    private CustomMessageListener itn = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.post.PersonThreadFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && PersonThreadFragment.this.iEb != null) {
                PersonThreadFragment.this.iEb.DI((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener ito = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.post.PersonThreadFragment.2
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
                if (com.baidu.adp.lib.util.j.kc() && PersonThreadFragment.this.czL) {
                    PersonThreadFragment.this.cgH();
                    PersonThreadFragment.this.iEd.bjo();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.a(PersonThreadFragment.this.ftz, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kc());
                } else {
                    BdListViewHelper.a(PersonThreadFragment.this.ftz, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.mNetworkChangedMessageListener);
        this.itm = new PersonPostModel(getPageContext(), getUniqueId(), this, true, PersonPostModel.FROM_PERSON_POST);
        this.itm.setUniqueId(getUniqueId());
        this.fMq = new ShareSuccessReplyToServerModel();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_thread_fragment, viewGroup, false);
        this.iEa = (FrameLayout) inflate.findViewById(R.id.root_view);
        this.iDZ = new h(getActivity(), inflate);
        if (this.iDZ.cgK() == null) {
            this.iDZ.b(this.iDW);
        }
        if (this.iDZ.iEj != null) {
            am.l(this.iDZ.iEj, R.color.cp_bg_line_d);
        }
        String string2 = getArguments().getString("thread_type_key");
        if (!aq.isEmpty(string2)) {
            this.iDY = string2;
        }
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(R.string.to_be_an_liver), new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonThreadFragment.this.cgD();
            }
        });
        int dimension = (int) getResources().getDimension(R.dimen.ds102);
        String str = "";
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension);
        if (this.iDY.equals("photolive")) {
            int i = com.baidu.tbadk.core.sharedPref.b.ahU().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1);
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
                cgE();
            }
        } else {
            string = getArguments().getString("key_empty_view_text");
            bVar = null;
        }
        this.iDZ.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.bX(string, str), bVar);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.itn);
        registerListener(this.ito);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        if (this.iDY.equals("photolive")) {
            this.iEg = 33;
        }
        this.iEb = new com.baidu.tieba.post.a.a(getPageContext(), this.iDZ.iEj);
        this.iDZ.cgJ().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                CardPersonDynamicThreadData cardPersonDynamicThreadData;
                if (i >= 0 && PersonThreadFragment.this.iEb != null && i < v.Z(PersonThreadFragment.this.itm.threadList) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) PersonThreadFragment.this.iEb.irX.getItem(i)) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonThreadFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.threadId), String.valueOf(cardPersonDynamicThreadData.postId), "person_page", 18005)));
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.i(getPageContext());
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.post.PersonThreadFragment.5
            @Override // com.baidu.tbadk.core.view.h.c
            public void eu(boolean z) {
                if (PersonThreadFragment.this.itm != null) {
                    PersonThreadFragment.this.iDV = true;
                    if (!com.baidu.adp.lib.util.j.jQ()) {
                        if (PersonThreadFragment.this.iDZ != null) {
                            PersonThreadFragment.this.iDZ.an(PersonThreadFragment.this.getString(R.string.neterror), true);
                            return;
                        }
                        return;
                    }
                    PersonThreadFragment.this.cgG();
                }
            }
        });
        this.iDZ.iEj.setPullRefresh(this.mPullView);
        if (TbadkCoreApplication.isMyLive) {
            this.ftz = BdListViewHelper.a(getActivity(), this.iDZ.iEj, BdListViewHelper.HeadType.DEFAULT);
            BdListViewHelper.a(this.ftz, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kc());
        } else {
            this.ftz = BdListViewHelper.a(getActivity(), this.iDZ.iEj, BdListViewHelper.HeadType.HASTAB);
            BdListViewHelper.a(this.ftz, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.iDZ.iEj.setOnSrollToBottomListener(this);
        this.iEd = new a(getBaseFragmentActivity());
        this.iDZ.iEj.setNextPage(this.iEd);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            cgH();
            this.iEd.bjo();
            this.czL = true;
            return;
        }
        this.iEd.qp(false);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
    public void b(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null && this.itm != null) {
            if (z) {
                this.itm.threadList.clear();
            }
            ArrayList<com.baidu.adp.widget.ListView.m> arrayList = personPostModel.threadList;
            if (personPostModel.view_card_num > 0 && this.iEf) {
                v.a(arrayList, personPostModel.view_card_num - 1, new com.baidu.tieba.personPolymeric.c.j());
                this.iEf = false;
            }
            if (this.itm.threadList.isEmpty()) {
                com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) v.c(arrayList, 0);
                if (mVar instanceof CardPersonDynamicThreadData) {
                    ((CardPersonDynamicThreadData) mVar).eIA = true;
                } else if (mVar instanceof com.baidu.tieba.personPolymeric.c.j) {
                    ((com.baidu.tieba.personPolymeric.c.j) mVar).eIA = true;
                }
            }
            this.itm.threadList.addAll(arrayList);
            PersonPostModel.mergeDynamicThreadByTime(this.itm.threadList);
        }
        if (this.iEe != null) {
            this.iEe.qm(personPostModel.isShowRecycleBinRedTip);
        }
        a(personPostModel, z);
        this.iEb.I(this.itm.threadList);
        this.iEb.notifyDataSetChanged();
    }

    /* loaded from: classes6.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private View cAh;
        private BaseFragmentActivity cZT;
        private int bgColor = R.color.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;
        private int mSkinType = 3;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.cZT = null;
            this.cZT = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View nZ() {
            this.mRoot = LayoutInflater.from(this.cZT.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.cAh = this.mRoot.findViewById(R.id.pb_more_view);
            am.l(this.mRoot, this.bgColor);
            am.l(this.cAh, this.bgColor);
            this.cAh.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            kd(TbadkCoreApplication.getInst().getSkinType());
            am.j(this.mTextView, R.color.common_color_10039);
            this.cAh.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.g(this.cZT.getPageContext().getPageActivity(), R.dimen.ds120)));
            return this.mRoot;
        }

        public void kd(int i) {
            this.cZT.getLayoutMode().onModeChanged(this.cAh);
        }

        @SuppressLint({"ResourceAsColor"})
        public void iY(int i) {
            if (this.mSkinType != i) {
                am.j(this.mTextView, R.color.common_color_10039);
                am.h(this.mRoot, this.bgColor, i);
                am.h(this.cAh, this.bgColor, i);
                this.mSkinType = i;
            }
        }

        public void bjo() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.cZT.getPageContext().getPageActivity().getText(R.string.loading));
            this.cAh.setVisibility(0);
        }

        public void cgI() {
            am.l(this.mRoot, R.color.cp_bg_line_c);
        }

        public void qp(boolean z) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.cAh.setVisibility(0);
                    this.mTextView.setText(this.cZT.getResources().getString(R.string.list_no_more));
                    return;
                }
                this.cAh.setVisibility(0);
                this.mTextView.setText(this.cZT.getResources().getString(R.string.load_more));
            }
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.mRoot);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.iDZ.mNoDataView != null) {
                this.iDZ.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.iY(i);
            }
            if (this.iEb != null) {
                this.iEb.notifyDataSetChanged();
            }
            if (this.iEd != null) {
                this.iEd.iY(i);
            }
            am.l(this.iDZ.iEj, R.color.cp_bg_line_d);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.iDZ.mNoDataView != null) {
            this.iDZ.mNoDataView.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.iDZ.mNoDataView != null) {
            this.iDZ.mNoDataView.akI();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        cgB();
        if (this.iEb != null) {
            this.iEb.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.itm != null) {
            this.itm.cancelLoadData();
        }
        try {
            com.baidu.tbadk.e.a.Km();
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
            if (i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.iEb != null && this.itm != null && v.Z(this.itm.threadList) > 0) {
                int Z = v.Z(this.itm.threadList);
                int i3 = 0;
                while (true) {
                    if (i3 >= Z) {
                        z = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) v.c(this.itm.threadList, i3);
                    if ((mVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) mVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.threadId))) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (z && intent.getIntExtra("type", -1) == 0) {
                    v.d(this.itm.threadList, i3);
                    this.iEb.notifyDataSetChanged();
                }
            }
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.fMq != null) {
                    this.fMq.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.post.PersonThreadFragment.6
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void apb() {
                        }

                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void a(final CustomDialogData customDialogData) {
                            com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.post.PersonThreadFragment.6.1
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

    public void cgB() {
        if (!this.iEc) {
            this.iDZ.iEj.startPullRefresh();
            this.iEc = true;
        }
    }

    public h cgC() {
        return this.iDZ;
    }

    @Override // com.baidu.tieba.post.c
    public void cgw() {
        if (this.iDZ != null && this.iDZ.iEj != null) {
            this.iDZ.iEj.startPullRefresh();
        }
    }

    public void a(d dVar) {
        this.iDW = dVar;
    }

    public void a(b bVar) {
        this.iEe = bVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
    public void a(PersonPostModel personPostModel, boolean z) {
        this.czL = false;
        if (isAdded()) {
            this.iDZ.iEj.completePullRefreshPostDelayed(0L);
            this.iDZ.iEj.setEmptyView(null);
            if (personPostModel != null || this.iDV) {
                if (personPostModel == null || (personPostModel.threadList.size() == 0 && this.iDV && StringUtils.isNull(personPostModel.getErrorString()))) {
                    qo(true);
                    return;
                }
                if (personPostModel.threadList.size() == 0 && this.iDV) {
                    qo(true);
                } else {
                    qo(false);
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
                    this.iDU = 0;
                    this.iDV = false;
                }
                this.iEd.qp(this.mHasMore);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016221));
            }
        }
    }

    private void qo(boolean z) {
        this.iDZ.iEj.removeHeaderView(this.iDZ.mNoDataView);
        if (z) {
            this.iDZ.mNoDataView.setVisibility(0);
            this.iDZ.iEj.addHeaderView(this.iDZ.mNoDataView);
            this.iEd.getView().setVisibility(8);
            return;
        }
        this.iEd.getView().setVisibility(0);
        this.iEd.cgI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgD() {
        TiebaStatic.log("c10491");
        cgF();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(1, this);
    }

    private void cgE() {
        cgF();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).b(this);
    }

    private void cgF() {
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(true, true, true, this);
    }

    public void cgG() {
        if (this.itm != null) {
            this.itm.fetchPost(getPageContext(), this, true, this.mUid, true, this.iEg, false, true);
            this.iEf = true;
        }
    }

    public void cgH() {
        if (this.itm != null) {
            this.itm.fetchPost(getPageContext(), this, false, this.mUid, true, false, true);
        }
    }
}
