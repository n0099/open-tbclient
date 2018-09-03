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
import com.baidu.tieba.f;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class PersonThreadFragment extends BaseFragment implements BdListView.e, b.a, PersonPostModel.a, PersonPostModel.b, c {
    private ShareSuccessReplyToServerModel dBv;
    private View djW;
    public PersonPostModel gal;
    private int gji;
    private d gjk;
    private h gjn;
    private FrameLayout gjo;
    private com.baidu.tieba.post.a.a gjp;
    private boolean gjq;
    private a gjr;
    private b gjs;
    private int gju;
    private com.baidu.tbadk.core.view.h mPullView;
    private String mUid;
    private String gjm = PhoneUtils.CPUInfo.FEATURE_COMMON;
    private boolean mHasMore = false;
    private boolean gjj = true;
    private boolean gjt = true;
    private boolean aSJ = false;
    private CustomMessageListener gam = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.post.PersonThreadFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && PersonThreadFragment.this.gjp != null) {
                PersonThreadFragment.this.gjp.sq((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gan = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.post.PersonThreadFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.adp.lib.util.l.showToast(PersonThreadFragment.this.getActivity(), f.j.thread_has_hide);
            }
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.post.PersonThreadFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (com.baidu.adp.lib.util.j.jE() && PersonThreadFragment.this.aSJ) {
                    PersonThreadFragment.this.blr();
                    PersonThreadFragment.this.gjr.aqP();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.a(PersonThreadFragment.this.djW, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.jE());
                } else {
                    BdListViewHelper.a(PersonThreadFragment.this.djW, BdListViewHelper.HeadType.HASTAB, true);
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
        this.dBv = new ShareSuccessReplyToServerModel();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(f.h.person_thread_fragment, viewGroup, false);
        this.gjo = (FrameLayout) inflate.findViewById(f.g.root_view);
        this.gjn = new h(getActivity(), inflate);
        if (this.gjn.blu() == null) {
            this.gjn.b(this.gjk);
        }
        if (this.gjn.gjx != null) {
            am.j(this.gjn.gjx, f.d.cp_bg_line_d);
        }
        String string2 = getArguments().getString("thread_type_key");
        if (!ap.isEmpty(string2)) {
            this.gjm = string2;
        }
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(f.j.to_be_an_liver), new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonThreadFragment.this.bln();
            }
        });
        int dimension = (int) getResources().getDimension(f.e.ds102);
        String str = "";
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension);
        if (this.gjm.equals("photolive")) {
            int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1);
            if (i == 0) {
                str = getPageContext().getResources().getString(f.j.to_live_to_god);
                string = getPageContext().getResources().getString(f.j.user_not_liver);
                a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, f.C0146f.go_to_live_pic, dimension, -1, -1);
                bVar = NoDataViewFactory.b.a(aVar);
            } else {
                string = getPageContext().getResources().getString(f.j.person_post_lv_empty_host);
                bVar = null;
            }
            if (i < 0) {
                blo();
            }
        } else {
            string = getArguments().getString("key_empty_view_text");
            bVar = null;
        }
        this.gjn.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.ag(string, str), bVar);
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
        if (this.gjm.equals("photolive")) {
            this.gju = 33;
        }
        this.gjp = new com.baidu.tieba.post.a.a(getPageContext(), this.gjn.gjx);
        this.gjn.blt().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                CardPersonDynamicThreadData cardPersonDynamicThreadData;
                if (i >= 0 && PersonThreadFragment.this.gjp != null && i < w.y(PersonThreadFragment.this.gal.threadList) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) PersonThreadFragment.this.gjp.fYW.getItem(i)) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonThreadFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.threadId), String.valueOf(cardPersonDynamicThreadData.postId), "person_page", 18005)));
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.h(getPageContext());
        this.mPullView.a(new g.b() { // from class: com.baidu.tieba.post.PersonThreadFragment.5
            @Override // com.baidu.tbadk.core.view.g.b
            public void aT(boolean z) {
                if (PersonThreadFragment.this.gal != null) {
                    PersonThreadFragment.this.gjj = true;
                    if (!com.baidu.adp.lib.util.j.js()) {
                        if (PersonThreadFragment.this.gjn != null) {
                            PersonThreadFragment.this.gjn.E(PersonThreadFragment.this.getString(f.j.neterror), true);
                            return;
                        }
                        return;
                    }
                    PersonThreadFragment.this.blq();
                }
            }
        });
        this.gjn.gjx.setPullRefresh(this.mPullView);
        if (TbadkCoreApplication.isMyLive) {
            this.djW = BdListViewHelper.a(getActivity(), this.gjn.gjx, BdListViewHelper.HeadType.DEFAULT);
            BdListViewHelper.a(this.djW, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.jE());
        } else {
            this.djW = BdListViewHelper.a(getActivity(), this.gjn.gjx, BdListViewHelper.HeadType.HASTAB);
            BdListViewHelper.a(this.djW, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.gjn.gjx.setOnSrollToBottomListener(this);
        this.gjr = new a(getBaseFragmentActivity());
        this.gjn.gjx.setNextPage(this.gjr);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            blr();
            this.gjr.aqP();
            this.aSJ = true;
            return;
        }
        this.gjr.lB(false);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
    public void b(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null && this.gal != null) {
            if (z) {
                this.gal.threadList.clear();
            }
            ArrayList<com.baidu.adp.widget.ListView.h> arrayList = personPostModel.threadList;
            if (personPostModel.view_card_num > 0 && this.gjt) {
                w.a(arrayList, personPostModel.view_card_num - 1, new com.baidu.tieba.personPolymeric.c.j());
                this.gjt = false;
            }
            if (this.gal.threadList.isEmpty()) {
                com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) w.d(arrayList, 0);
                if (hVar instanceof CardPersonDynamicThreadData) {
                    ((CardPersonDynamicThreadData) hVar).cCO = true;
                } else if (hVar instanceof com.baidu.tieba.personPolymeric.c.j) {
                    ((com.baidu.tieba.personPolymeric.c.j) hVar).cCO = true;
                }
            }
            this.gal.threadList.addAll(arrayList);
            PersonPostModel.mergeDynamicThreadByTime(this.gal.threadList);
        }
        if (this.gjs != null) {
            this.gjs.ly(personPostModel.isShowRecycleBinRedTip);
        }
        a(personPostModel, z);
        this.gjp.C(this.gal.threadList);
        this.gjp.notifyDataSetChanged();
    }

    /* loaded from: classes3.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private View aTf;
        private BaseFragmentActivity bos;
        private int bgColor = f.d.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View aaW = null;
        private int mSkinType = 3;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.bos = null;
            this.bos = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View np() {
            this.aaW = LayoutInflater.from(this.bos.getPageContext().getContext()).inflate(f.h.new_pb_list_more, (ViewGroup) null);
            this.mTextView = (TextView) this.aaW.findViewById(f.g.pb_more_text);
            this.aTf = this.aaW.findViewById(f.g.pb_more_view);
            am.j(this.aaW, this.bgColor);
            am.j(this.aTf, this.bgColor);
            this.aTf.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.aaW.findViewById(f.g.progress);
            ex(TbadkCoreApplication.getInst().getSkinType());
            am.h(this.mTextView, f.d.common_color_10039);
            this.aTf.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.f(this.bos.getPageContext().getPageActivity(), f.e.ds120)));
            return this.aaW;
        }

        public void ex(int i) {
            this.bos.getLayoutMode().onModeChanged(this.aTf);
        }

        @SuppressLint({"ResourceAsColor"})
        public void dB(int i) {
            if (this.mSkinType != i) {
                am.h(this.mTextView, f.d.common_color_10039);
                am.e(this.aaW, this.bgColor, i);
                am.e(this.aTf, this.bgColor, i);
                this.mSkinType = i;
            }
        }

        public void aqP() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.bos.getPageContext().getPageActivity().getText(f.j.loading));
            this.aTf.setVisibility(0);
        }

        public void bls() {
            am.j(this.aaW, f.d.cp_bg_line_c);
        }

        public void lB(boolean z) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.aTf.setVisibility(0);
                    this.mTextView.setText(this.bos.getResources().getString(f.j.list_no_more));
                    return;
                }
                this.aTf.setVisibility(0);
                this.mTextView.setText(this.bos.getResources().getString(f.j.load_more));
            }
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.aaW);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.gjn.mNoDataView != null) {
                this.gjn.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.dB(i);
            }
            if (this.gjp != null) {
                this.gjp.notifyDataSetChanged();
            }
            if (this.gjr != null) {
                this.gjr.dB(i);
            }
            am.j(this.gjn.gjx, f.d.cp_bg_line_d);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.gjn.mNoDataView != null) {
            this.gjn.mNoDataView.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.gjn.mNoDataView != null) {
            this.gjn.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.gjp != null) {
            this.gjp.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.gal != null) {
            this.gal.cancelLoadData();
        }
        try {
            com.baidu.tbadk.d.a.rV();
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
            if (i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.gjp != null && this.gal != null && w.y(this.gal.threadList) > 0) {
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
                    this.gjp.notifyDataSetChanged();
                }
            }
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.dBv != null) {
                    this.dBv.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.post.PersonThreadFragment.6
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
        if (!this.gjq) {
            this.gjn.gjx.startPullRefresh();
            this.gjq = true;
        }
    }

    public h blm() {
        return this.gjn;
    }

    @Override // com.baidu.tieba.post.c
    public void blg() {
        if (this.gjn != null && this.gjn.gjx != null) {
            this.gjn.gjx.startPullRefresh();
        }
    }

    public void a(d dVar) {
        this.gjk = dVar;
    }

    public void a(b bVar) {
        this.gjs = bVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
    public void a(PersonPostModel personPostModel, boolean z) {
        this.aSJ = false;
        if (isAdded()) {
            this.gjn.gjx.completePullRefreshPostDelayed(2000L);
            this.gjn.gjx.setEmptyView(null);
            if (personPostModel != null || this.gjj) {
                if (personPostModel == null || (personPostModel.threadList.size() == 0 && this.gjj && StringUtils.isNull(personPostModel.getErrorString()))) {
                    lA(true);
                    return;
                }
                if (personPostModel.threadList.size() == 0 && this.gjj) {
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
                    this.gji = 0;
                    this.gjj = false;
                }
                this.gjr.lB(this.mHasMore);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016221));
            }
        }
    }

    private void lA(boolean z) {
        this.gjn.gjx.removeHeaderView(this.gjn.mNoDataView);
        if (z) {
            this.gjn.mNoDataView.setVisibility(0);
            this.gjn.gjx.addHeaderView(this.gjn.mNoDataView);
            this.gjr.getView().setVisibility(8);
            return;
        }
        this.gjr.getView().setVisibility(0);
        this.gjr.bls();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bln() {
        TiebaStatic.log("c10491");
        blp();
        com.baidu.tbadk.d.a.b(getBaseFragmentActivity()).a(1, this);
    }

    private void blo() {
        blp();
        com.baidu.tbadk.d.a.b(getBaseFragmentActivity()).b(this);
    }

    private void blp() {
        com.baidu.tbadk.d.a.b(getBaseFragmentActivity()).a(true, true, true, this);
    }

    public void blq() {
        if (this.gal != null) {
            this.gal.fetchPost(getPageContext(), this, true, this.mUid, true, this.gju, false, true);
            this.gjt = true;
        }
    }

    public void blr() {
        if (this.gal != null) {
            this.gal.fetchPost(getPageContext(), this, false, this.mUid, true, false, true);
        }
    }
}
