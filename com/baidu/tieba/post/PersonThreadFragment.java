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
    private ShareSuccessReplyToServerModel dQb;
    private View dxR;
    public PersonPostModel gpd;
    private int gyb;
    private d gyd;
    private h gyg;
    private FrameLayout gyh;
    private com.baidu.tieba.post.a.a gyi;
    private boolean gyj;
    private a gyk;
    private b gyl;
    private int gyn;
    private com.baidu.tbadk.core.view.k mPullView;
    private String mUid;
    private String gyf = PhoneUtils.CPUInfo.FEATURE_COMMON;
    private boolean mHasMore = false;
    private boolean gyc = true;
    private boolean gym = true;
    private boolean bay = false;
    private CustomMessageListener gpe = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.post.PersonThreadFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && PersonThreadFragment.this.gyi != null) {
                PersonThreadFragment.this.gyi.ty((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gpf = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.post.PersonThreadFragment.2
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
                if (com.baidu.adp.lib.util.j.kX() && PersonThreadFragment.this.bay) {
                    PersonThreadFragment.this.brm();
                    PersonThreadFragment.this.gyk.avZ();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.a(PersonThreadFragment.this.dxR, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kX());
                } else {
                    BdListViewHelper.a(PersonThreadFragment.this.dxR, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.mNetworkChangedMessageListener);
        this.gpd = new PersonPostModel(getPageContext(), getUniqueId(), this, true, PersonPostModel.FROM_PERSON_POST);
        this.gpd.setUniqueId(getUniqueId());
        this.dQb = new ShareSuccessReplyToServerModel();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(e.h.person_thread_fragment, viewGroup, false);
        this.gyh = (FrameLayout) inflate.findViewById(e.g.root_view);
        this.gyg = new h(getActivity(), inflate);
        if (this.gyg.brp() == null) {
            this.gyg.b(this.gyd);
        }
        if (this.gyg.gyq != null) {
            al.j(this.gyg.gyq, e.d.cp_bg_line_d);
        }
        String string2 = getArguments().getString("thread_type_key");
        if (!ao.isEmpty(string2)) {
            this.gyf = string2;
        }
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(e.j.to_be_an_liver), new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonThreadFragment.this.bri();
            }
        });
        int dimension = (int) getResources().getDimension(e.C0175e.ds102);
        String str = "";
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension);
        if (this.gyf.equals("photolive")) {
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
                brj();
            }
        } else {
            string = getArguments().getString("key_empty_view_text");
            bVar = null;
        }
        this.gyg.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.aA(string, str), bVar);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.gpe);
        registerListener(this.gpf);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        if (this.gyf.equals("photolive")) {
            this.gyn = 33;
        }
        this.gyi = new com.baidu.tieba.post.a.a(getPageContext(), this.gyg.gyq);
        this.gyg.bro().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                CardPersonDynamicThreadData cardPersonDynamicThreadData;
                if (i >= 0 && PersonThreadFragment.this.gyi != null && i < v.I(PersonThreadFragment.this.gpd.threadList) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) PersonThreadFragment.this.gyi.gnO.getItem(i)) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonThreadFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.threadId), String.valueOf(cardPersonDynamicThreadData.postId), "person_page", 18005)));
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.k(getPageContext());
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.post.PersonThreadFragment.5
            @Override // com.baidu.tbadk.core.view.j.b
            public void bp(boolean z) {
                if (PersonThreadFragment.this.gpd != null) {
                    PersonThreadFragment.this.gyc = true;
                    if (!com.baidu.adp.lib.util.j.kM()) {
                        if (PersonThreadFragment.this.gyg != null) {
                            PersonThreadFragment.this.gyg.M(PersonThreadFragment.this.getString(e.j.neterror), true);
                            return;
                        }
                        return;
                    }
                    PersonThreadFragment.this.brl();
                }
            }
        });
        this.gyg.gyq.setPullRefresh(this.mPullView);
        if (TbadkCoreApplication.isMyLive) {
            this.dxR = BdListViewHelper.a(getActivity(), this.gyg.gyq, BdListViewHelper.HeadType.DEFAULT);
            BdListViewHelper.a(this.dxR, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kX());
        } else {
            this.dxR = BdListViewHelper.a(getActivity(), this.gyg.gyq, BdListViewHelper.HeadType.HASTAB);
            BdListViewHelper.a(this.dxR, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.gyg.gyq.setOnSrollToBottomListener(this);
        this.gyk = new a(getBaseFragmentActivity());
        this.gyg.gyq.setNextPage(this.gyk);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            brm();
            this.gyk.avZ();
            this.bay = true;
            return;
        }
        this.gyk.ms(false);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
    public void b(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null && this.gpd != null) {
            if (z) {
                this.gpd.threadList.clear();
            }
            ArrayList<com.baidu.adp.widget.ListView.h> arrayList = personPostModel.threadList;
            if (personPostModel.view_card_num > 0 && this.gym) {
                v.a(arrayList, personPostModel.view_card_num - 1, new com.baidu.tieba.personPolymeric.c.j());
                this.gym = false;
            }
            if (this.gpd.threadList.isEmpty()) {
                com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) v.d(arrayList, 0);
                if (hVar instanceof CardPersonDynamicThreadData) {
                    ((CardPersonDynamicThreadData) hVar).cQY = true;
                } else if (hVar instanceof com.baidu.tieba.personPolymeric.c.j) {
                    ((com.baidu.tieba.personPolymeric.c.j) hVar).cQY = true;
                }
            }
            this.gpd.threadList.addAll(arrayList);
            PersonPostModel.mergeDynamicThreadByTime(this.gpd.threadList);
        }
        if (this.gyl != null) {
            this.gyl.mp(personPostModel.isShowRecycleBinRedTip);
        }
        a(personPostModel, z);
        this.gyi.C(this.gpd.threadList);
        this.gyi.notifyDataSetChanged();
    }

    /* loaded from: classes3.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private View baU;
        private BaseFragmentActivity bym;
        private int bgColor = e.d.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View aix = null;
        private int mSkinType = 3;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.bym = null;
            this.bym = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View oG() {
            this.aix = LayoutInflater.from(this.bym.getPageContext().getContext()).inflate(e.h.new_pb_list_more, (ViewGroup) null);
            this.mTextView = (TextView) this.aix.findViewById(e.g.pb_more_text);
            this.baU = this.aix.findViewById(e.g.pb_more_view);
            al.j(this.aix, this.bgColor);
            al.j(this.baU, this.bgColor);
            this.baU.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.aix.findViewById(e.g.progress);
            eS(TbadkCoreApplication.getInst().getSkinType());
            al.h(this.mTextView, e.d.common_color_10039);
            this.baU.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.bym.getPageContext().getPageActivity(), e.C0175e.ds120)));
            return this.aix;
        }

        public void eS(int i) {
            this.bym.getLayoutMode().onModeChanged(this.baU);
        }

        @SuppressLint({"ResourceAsColor"})
        public void dW(int i) {
            if (this.mSkinType != i) {
                al.h(this.mTextView, e.d.common_color_10039);
                al.e(this.aix, this.bgColor, i);
                al.e(this.baU, this.bgColor, i);
                this.mSkinType = i;
            }
        }

        public void avZ() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.bym.getPageContext().getPageActivity().getText(e.j.loading));
            this.baU.setVisibility(0);
        }

        public void brn() {
            al.j(this.aix, e.d.cp_bg_line_c);
        }

        public void ms(boolean z) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.baU.setVisibility(0);
                    this.mTextView.setText(this.bym.getResources().getString(e.j.list_no_more));
                    return;
                }
                this.baU.setVisibility(0);
                this.mTextView.setText(this.bym.getResources().getString(e.j.load_more));
            }
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.aix);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.gyg.mNoDataView != null) {
                this.gyg.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.dW(i);
            }
            if (this.gyi != null) {
                this.gyi.notifyDataSetChanged();
            }
            if (this.gyk != null) {
                this.gyk.dW(i);
            }
            al.j(this.gyg.gyq, e.d.cp_bg_line_d);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.gyg.mNoDataView != null) {
            this.gyg.mNoDataView.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.gyg.mNoDataView != null) {
            this.gyg.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.gyi != null) {
            this.gyi.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.gpd != null) {
            this.gpd.cancelLoadData();
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
            if (i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.gyi != null && this.gpd != null && v.I(this.gpd.threadList) > 0) {
                int I = v.I(this.gpd.threadList);
                int i3 = 0;
                while (true) {
                    if (i3 >= I) {
                        z = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) v.d(this.gpd.threadList, i3);
                    if ((hVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) hVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.threadId))) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (z && intent.getIntExtra("type", -1) == 0) {
                    v.e(this.gpd.threadList, i3);
                    this.gyi.notifyDataSetChanged();
                }
            }
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.dQb != null) {
                    this.dQb.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.post.PersonThreadFragment.6
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void HI() {
                        }

                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void a(final CustomDialogData customDialogData) {
                            com.baidu.adp.lib.g.e.jI().postDelayed(new Runnable() { // from class: com.baidu.tieba.post.PersonThreadFragment.6.1
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
        if (!this.gyj) {
            this.gyg.gyq.startPullRefresh();
            this.gyj = true;
        }
    }

    public h brh() {
        return this.gyg;
    }

    @Override // com.baidu.tieba.post.c
    public void brb() {
        if (this.gyg != null && this.gyg.gyq != null) {
            this.gyg.gyq.startPullRefresh();
        }
    }

    public void a(d dVar) {
        this.gyd = dVar;
    }

    public void a(b bVar) {
        this.gyl = bVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
    public void a(PersonPostModel personPostModel, boolean z) {
        this.bay = false;
        if (isAdded()) {
            this.gyg.gyq.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            this.gyg.gyq.setEmptyView(null);
            if (personPostModel != null || this.gyc) {
                if (personPostModel == null || (personPostModel.threadList.size() == 0 && this.gyc && StringUtils.isNull(personPostModel.getErrorString()))) {
                    mr(true);
                    return;
                }
                if (personPostModel.threadList.size() == 0 && this.gyc) {
                    mr(true);
                } else {
                    mr(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(getActivity(), personPostModel.getErrorString());
                }
                this.mHasMore = !v.J(personPostModel.threadList);
                if (z) {
                    if (personPostModel.threadList.size() < 20) {
                        this.mHasMore = false;
                    } else {
                        this.mHasMore = true;
                    }
                    this.gyb = 0;
                    this.gyc = false;
                }
                this.gyk.ms(this.mHasMore);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016221));
            }
        }
    }

    private void mr(boolean z) {
        this.gyg.gyq.removeHeaderView(this.gyg.mNoDataView);
        if (z) {
            this.gyg.mNoDataView.setVisibility(0);
            this.gyg.gyq.addHeaderView(this.gyg.mNoDataView);
            this.gyk.getView().setVisibility(8);
            return;
        }
        this.gyk.getView().setVisibility(0);
        this.gyk.brn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bri() {
        TiebaStatic.log("c10491");
        brk();
        com.baidu.tbadk.d.a.b(getBaseFragmentActivity()).a(1, this);
    }

    private void brj() {
        brk();
        com.baidu.tbadk.d.a.b(getBaseFragmentActivity()).b(this);
    }

    private void brk() {
        com.baidu.tbadk.d.a.b(getBaseFragmentActivity()).a(true, true, true, this);
    }

    public void brl() {
        if (this.gpd != null) {
            this.gpd.fetchPost(getPageContext(), this, true, this.mUid, true, this.gyn, false, true);
            this.gym = true;
        }
    }

    public void brm() {
        if (this.gpd != null) {
            this.gpd.fetchPost(getPageContext(), this, false, this.mUid, true, false, true);
        }
    }
}
