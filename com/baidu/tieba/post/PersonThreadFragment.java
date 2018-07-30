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
import com.baidu.tbadk.d.b;
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
    private ShareSuccessReplyToServerModel dBy;
    private View djY;
    public PersonPostModel gal;
    private int gjj;
    private d gjl;
    private h gjo;
    private FrameLayout gjp;
    private com.baidu.tieba.post.a.a gjq;
    private boolean gjr;
    private a gjs;
    private b gjt;
    private int gjv;
    private com.baidu.tbadk.core.view.h mPullView;
    private String mUid;
    private String gjn = PhoneUtils.CPUInfo.FEATURE_COMMON;
    private boolean mHasMore = false;
    private boolean gjk = true;
    private boolean gju = true;
    private boolean aSJ = false;
    private CustomMessageListener gam = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.post.PersonThreadFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && PersonThreadFragment.this.gjq != null) {
                PersonThreadFragment.this.gjq.sn((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gan = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.post.PersonThreadFragment.2
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
                if (com.baidu.adp.lib.util.j.jE() && PersonThreadFragment.this.aSJ) {
                    PersonThreadFragment.this.blu();
                    PersonThreadFragment.this.gjs.aqP();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.a(PersonThreadFragment.this.djY, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.jE());
                } else {
                    BdListViewHelper.a(PersonThreadFragment.this.djY, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.mNetworkChangedMessageListener);
        this.gal = new PersonPostModel(getPageContext(), getUniqueId(), this, true, PersonPostModel.FROM_PERSON_POST);
        this.gal.setUniqueId(getUniqueId());
        this.dBy = new ShareSuccessReplyToServerModel();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.person_thread_fragment, viewGroup, false);
        this.gjp = (FrameLayout) inflate.findViewById(d.g.root_view);
        this.gjo = new h(getActivity(), inflate);
        if (this.gjo.blx() == null) {
            this.gjo.b(this.gjl);
        }
        if (this.gjo.gjy != null) {
            am.j(this.gjo.gjy, d.C0140d.cp_bg_line_d);
        }
        String string2 = getArguments().getString("thread_type_key");
        if (!ap.isEmpty(string2)) {
            this.gjn = string2;
        }
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(d.j.to_be_an_liver), new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonThreadFragment.this.blq();
            }
        });
        int dimension = (int) getResources().getDimension(d.e.ds102);
        String str = "";
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension);
        if (this.gjn.equals("photolive")) {
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
                blr();
            }
        } else {
            string = getArguments().getString("key_empty_view_text");
            bVar = null;
        }
        this.gjo.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.ah(string, str), bVar);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.gam);
        registerListener(this.gan);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        if (this.gjn.equals("photolive")) {
            this.gjv = 33;
        }
        this.gjq = new com.baidu.tieba.post.a.a(getPageContext(), this.gjo.gjy);
        this.gjo.blw().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                CardPersonDynamicThreadData cardPersonDynamicThreadData;
                if (i >= 0 && PersonThreadFragment.this.gjq != null && i < w.y(PersonThreadFragment.this.gal.threadList) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) PersonThreadFragment.this.gjq.fYW.getItem(i)) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonThreadFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.threadId), String.valueOf(cardPersonDynamicThreadData.postId), "person_page", 18005)));
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.h(getPageContext());
        this.mPullView.a(new g.b() { // from class: com.baidu.tieba.post.PersonThreadFragment.5
            @Override // com.baidu.tbadk.core.view.g.b
            public void aS(boolean z) {
                if (PersonThreadFragment.this.gal != null) {
                    PersonThreadFragment.this.gjk = true;
                    if (!com.baidu.adp.lib.util.j.js()) {
                        if (PersonThreadFragment.this.gjo != null) {
                            PersonThreadFragment.this.gjo.E(PersonThreadFragment.this.getString(d.j.neterror), true);
                            return;
                        }
                        return;
                    }
                    PersonThreadFragment.this.blt();
                }
            }
        });
        this.gjo.gjy.setPullRefresh(this.mPullView);
        if (TbadkCoreApplication.isMyLive) {
            this.djY = BdListViewHelper.a(getActivity(), this.gjo.gjy, BdListViewHelper.HeadType.DEFAULT);
            BdListViewHelper.a(this.djY, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.jE());
        } else {
            this.djY = BdListViewHelper.a(getActivity(), this.gjo.gjy, BdListViewHelper.HeadType.HASTAB);
            BdListViewHelper.a(this.djY, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.gjo.gjy.setOnSrollToBottomListener(this);
        this.gjs = new a(getBaseFragmentActivity());
        this.gjo.gjy.setNextPage(this.gjs);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            blu();
            this.gjs.aqP();
            this.aSJ = true;
            return;
        }
        this.gjs.lB(false);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
    public void b(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null && this.gal != null) {
            if (z) {
                this.gal.threadList.clear();
            }
            ArrayList<com.baidu.adp.widget.ListView.h> arrayList = personPostModel.threadList;
            if (personPostModel.view_card_num > 0 && this.gju) {
                w.a(arrayList, personPostModel.view_card_num - 1, new com.baidu.tieba.personPolymeric.c.j());
                this.gju = false;
            }
            if (this.gal.threadList.isEmpty()) {
                com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) w.d(arrayList, 0);
                if (hVar instanceof CardPersonDynamicThreadData) {
                    ((CardPersonDynamicThreadData) hVar).cCR = true;
                } else if (hVar instanceof com.baidu.tieba.personPolymeric.c.j) {
                    ((com.baidu.tieba.personPolymeric.c.j) hVar).cCR = true;
                }
            }
            this.gal.threadList.addAll(arrayList);
            PersonPostModel.mergeDynamicThreadByTime(this.gal.threadList);
        }
        if (this.gjt != null) {
            this.gjt.ly(personPostModel.isShowRecycleBinRedTip);
        }
        a(personPostModel, z);
        this.gjq.C(this.gal.threadList);
        this.gjq.notifyDataSetChanged();
    }

    /* loaded from: classes3.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private View aTf;
        private BaseFragmentActivity boq;
        private int bgColor = d.C0140d.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View aaV = null;
        private int mSkinType = 3;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.boq = null;
            this.boq = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View np() {
            this.aaV = LayoutInflater.from(this.boq.getPageContext().getContext()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
            this.mTextView = (TextView) this.aaV.findViewById(d.g.pb_more_text);
            this.aTf = this.aaV.findViewById(d.g.pb_more_view);
            am.j(this.aaV, this.bgColor);
            am.j(this.aTf, this.bgColor);
            this.aTf.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.aaV.findViewById(d.g.progress);
            ey(TbadkCoreApplication.getInst().getSkinType());
            am.h(this.mTextView, d.C0140d.common_color_10039);
            this.aTf.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.f(this.boq.getPageContext().getPageActivity(), d.e.ds120)));
            return this.aaV;
        }

        public void ey(int i) {
            this.boq.getLayoutMode().onModeChanged(this.aTf);
        }

        @SuppressLint({"ResourceAsColor"})
        public void dC(int i) {
            if (this.mSkinType != i) {
                am.h(this.mTextView, d.C0140d.common_color_10039);
                am.e(this.aaV, this.bgColor, i);
                am.e(this.aTf, this.bgColor, i);
                this.mSkinType = i;
            }
        }

        public void aqP() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.boq.getPageContext().getPageActivity().getText(d.j.loading));
            this.aTf.setVisibility(0);
        }

        public void blv() {
            am.j(this.aaV, d.C0140d.cp_bg_line_c);
        }

        public void lB(boolean z) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.aTf.setVisibility(0);
                    this.mTextView.setText(this.boq.getResources().getString(d.j.list_no_more));
                    return;
                }
                this.aTf.setVisibility(0);
                this.mTextView.setText(this.boq.getResources().getString(d.j.load_more));
            }
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.aaV);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.gjo.mNoDataView != null) {
                this.gjo.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.dC(i);
            }
            if (this.gjq != null) {
                this.gjq.notifyDataSetChanged();
            }
            if (this.gjs != null) {
                this.gjs.dC(i);
            }
            am.j(this.gjo.gjy, d.C0140d.cp_bg_line_d);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.gjo.mNoDataView != null) {
            this.gjo.mNoDataView.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.gjo.mNoDataView != null) {
            this.gjo.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.gjq != null) {
            this.gjq.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.gal != null) {
            this.gal.cancelLoadData();
        }
        try {
            com.baidu.tbadk.d.a.rX();
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
            if (i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.gjq != null && this.gal != null && w.y(this.gal.threadList) > 0) {
                int y = w.y(this.gal.threadList);
                int i3 = 0;
                while (true) {
                    if (i3 >= y) {
                        z = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) w.d(this.gal.threadList, i3);
                    if ((hVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) hVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.threadId))) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (z && intent.getIntExtra("type", -1) == 0) {
                    w.e(this.gal.threadList, i3);
                    this.gjq.notifyDataSetChanged();
                }
            }
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.dBy != null) {
                    this.dBy.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.post.PersonThreadFragment.6
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void Es() {
                        }

                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void a(final CustomDialogData customDialogData) {
                            com.baidu.adp.lib.g.e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.post.PersonThreadFragment.6.1
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
        if (!this.gjr) {
            this.gjo.gjy.startPullRefresh();
            this.gjr = true;
        }
    }

    public h blp() {
        return this.gjo;
    }

    @Override // com.baidu.tieba.post.c
    public void blj() {
        if (this.gjo != null && this.gjo.gjy != null) {
            this.gjo.gjy.startPullRefresh();
        }
    }

    public void a(d dVar) {
        this.gjl = dVar;
    }

    public void a(b bVar) {
        this.gjt = bVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
    public void a(PersonPostModel personPostModel, boolean z) {
        this.aSJ = false;
        if (isAdded()) {
            this.gjo.gjy.completePullRefreshPostDelayed(2000L);
            this.gjo.gjy.setEmptyView(null);
            if (personPostModel != null || this.gjk) {
                if (personPostModel == null || (personPostModel.threadList.size() == 0 && this.gjk && StringUtils.isNull(personPostModel.getErrorString()))) {
                    lA(true);
                    return;
                }
                if (personPostModel.threadList.size() == 0 && this.gjk) {
                    lA(true);
                } else {
                    lA(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(getActivity(), personPostModel.getErrorString());
                }
                this.mHasMore = !w.z(personPostModel.threadList);
                if (z) {
                    if (personPostModel.threadList.size() < 20) {
                        this.mHasMore = false;
                    } else {
                        this.mHasMore = true;
                    }
                    this.gjj = 0;
                    this.gjk = false;
                }
                this.gjs.lB(this.mHasMore);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016221));
            }
        }
    }

    private void lA(boolean z) {
        this.gjo.gjy.removeHeaderView(this.gjo.mNoDataView);
        if (z) {
            this.gjo.mNoDataView.setVisibility(0);
            this.gjo.gjy.addHeaderView(this.gjo.mNoDataView);
            this.gjs.getView().setVisibility(8);
            return;
        }
        this.gjs.getView().setVisibility(0);
        this.gjs.blv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blq() {
        TiebaStatic.log("c10491");
        bls();
        com.baidu.tbadk.d.a.b(getBaseFragmentActivity()).a(1, this);
    }

    private void blr() {
        bls();
        com.baidu.tbadk.d.a.b(getBaseFragmentActivity()).b(this);
    }

    private void bls() {
        com.baidu.tbadk.d.a.b(getBaseFragmentActivity()).a(true, true, true, this);
    }

    public void blt() {
        if (this.gal != null) {
            this.gal.fetchPost(getPageContext(), this, true, this.mUid, true, this.gjv, false, true);
            this.gju = true;
        }
    }

    public void blu() {
        if (this.gal != null) {
            this.gal.fetchPost(getPageContext(), this, false, this.mUid, true, false, true);
        }
    }
}
