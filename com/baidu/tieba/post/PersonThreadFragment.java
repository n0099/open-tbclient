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
    public PersonPostModel gpe;
    private int gyc;
    private d gye;
    private h gyh;
    private FrameLayout gyi;
    private com.baidu.tieba.post.a.a gyj;
    private boolean gyk;
    private a gyl;
    private b gym;
    private int gyo;
    private com.baidu.tbadk.core.view.k mPullView;
    private String mUid;
    private String gyg = PhoneUtils.CPUInfo.FEATURE_COMMON;
    private boolean mHasMore = false;
    private boolean gyd = true;
    private boolean gyn = true;
    private boolean bay = false;
    private CustomMessageListener gpf = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.post.PersonThreadFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && PersonThreadFragment.this.gyj != null) {
                PersonThreadFragment.this.gyj.ty((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gpg = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.post.PersonThreadFragment.2
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
                    PersonThreadFragment.this.gyl.awa();
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
        this.gpe = new PersonPostModel(getPageContext(), getUniqueId(), this, true, PersonPostModel.FROM_PERSON_POST);
        this.gpe.setUniqueId(getUniqueId());
        this.dQb = new ShareSuccessReplyToServerModel();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(e.h.person_thread_fragment, viewGroup, false);
        this.gyi = (FrameLayout) inflate.findViewById(e.g.root_view);
        this.gyh = new h(getActivity(), inflate);
        if (this.gyh.brp() == null) {
            this.gyh.b(this.gye);
        }
        if (this.gyh.gyr != null) {
            al.j(this.gyh.gyr, e.d.cp_bg_line_d);
        }
        String string2 = getArguments().getString("thread_type_key");
        if (!ao.isEmpty(string2)) {
            this.gyg = string2;
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
        if (this.gyg.equals("photolive")) {
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
        this.gyh.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.aA(string, str), bVar);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.gpf);
        registerListener(this.gpg);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        if (this.gyg.equals("photolive")) {
            this.gyo = 33;
        }
        this.gyj = new com.baidu.tieba.post.a.a(getPageContext(), this.gyh.gyr);
        this.gyh.bro().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                CardPersonDynamicThreadData cardPersonDynamicThreadData;
                if (i >= 0 && PersonThreadFragment.this.gyj != null && i < v.I(PersonThreadFragment.this.gpe.threadList) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) PersonThreadFragment.this.gyj.gnP.getItem(i)) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonThreadFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.threadId), String.valueOf(cardPersonDynamicThreadData.postId), "person_page", 18005)));
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.k(getPageContext());
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.post.PersonThreadFragment.5
            @Override // com.baidu.tbadk.core.view.j.b
            public void bp(boolean z) {
                if (PersonThreadFragment.this.gpe != null) {
                    PersonThreadFragment.this.gyd = true;
                    if (!com.baidu.adp.lib.util.j.kM()) {
                        if (PersonThreadFragment.this.gyh != null) {
                            PersonThreadFragment.this.gyh.M(PersonThreadFragment.this.getString(e.j.neterror), true);
                            return;
                        }
                        return;
                    }
                    PersonThreadFragment.this.brl();
                }
            }
        });
        this.gyh.gyr.setPullRefresh(this.mPullView);
        if (TbadkCoreApplication.isMyLive) {
            this.dxR = BdListViewHelper.a(getActivity(), this.gyh.gyr, BdListViewHelper.HeadType.DEFAULT);
            BdListViewHelper.a(this.dxR, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kX());
        } else {
            this.dxR = BdListViewHelper.a(getActivity(), this.gyh.gyr, BdListViewHelper.HeadType.HASTAB);
            BdListViewHelper.a(this.dxR, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.gyh.gyr.setOnSrollToBottomListener(this);
        this.gyl = new a(getBaseFragmentActivity());
        this.gyh.gyr.setNextPage(this.gyl);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            brm();
            this.gyl.awa();
            this.bay = true;
            return;
        }
        this.gyl.ms(false);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
    public void b(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null && this.gpe != null) {
            if (z) {
                this.gpe.threadList.clear();
            }
            ArrayList<com.baidu.adp.widget.ListView.h> arrayList = personPostModel.threadList;
            if (personPostModel.view_card_num > 0 && this.gyn) {
                v.a(arrayList, personPostModel.view_card_num - 1, new com.baidu.tieba.personPolymeric.c.j());
                this.gyn = false;
            }
            if (this.gpe.threadList.isEmpty()) {
                com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) v.d(arrayList, 0);
                if (hVar instanceof CardPersonDynamicThreadData) {
                    ((CardPersonDynamicThreadData) hVar).cQY = true;
                } else if (hVar instanceof com.baidu.tieba.personPolymeric.c.j) {
                    ((com.baidu.tieba.personPolymeric.c.j) hVar).cQY = true;
                }
            }
            this.gpe.threadList.addAll(arrayList);
            PersonPostModel.mergeDynamicThreadByTime(this.gpe.threadList);
        }
        if (this.gym != null) {
            this.gym.mp(personPostModel.isShowRecycleBinRedTip);
        }
        a(personPostModel, z);
        this.gyj.C(this.gpe.threadList);
        this.gyj.notifyDataSetChanged();
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

        public void awa() {
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
            if (this.gyh.mNoDataView != null) {
                this.gyh.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.dW(i);
            }
            if (this.gyj != null) {
                this.gyj.notifyDataSetChanged();
            }
            if (this.gyl != null) {
                this.gyl.dW(i);
            }
            al.j(this.gyh.gyr, e.d.cp_bg_line_d);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.gyh.mNoDataView != null) {
            this.gyh.mNoDataView.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.gyh.mNoDataView != null) {
            this.gyh.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.gyj != null) {
            this.gyj.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.gpe != null) {
            this.gpe.cancelLoadData();
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
            if (i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.gyj != null && this.gpe != null && v.I(this.gpe.threadList) > 0) {
                int I = v.I(this.gpe.threadList);
                int i3 = 0;
                while (true) {
                    if (i3 >= I) {
                        z = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) v.d(this.gpe.threadList, i3);
                    if ((hVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) hVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.threadId))) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (z && intent.getIntExtra("type", -1) == 0) {
                    v.e(this.gpe.threadList, i3);
                    this.gyj.notifyDataSetChanged();
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
        if (!this.gyk) {
            this.gyh.gyr.startPullRefresh();
            this.gyk = true;
        }
    }

    public h brh() {
        return this.gyh;
    }

    @Override // com.baidu.tieba.post.c
    public void brb() {
        if (this.gyh != null && this.gyh.gyr != null) {
            this.gyh.gyr.startPullRefresh();
        }
    }

    public void a(d dVar) {
        this.gye = dVar;
    }

    public void a(b bVar) {
        this.gym = bVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
    public void a(PersonPostModel personPostModel, boolean z) {
        this.bay = false;
        if (isAdded()) {
            this.gyh.gyr.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            this.gyh.gyr.setEmptyView(null);
            if (personPostModel != null || this.gyd) {
                if (personPostModel == null || (personPostModel.threadList.size() == 0 && this.gyd && StringUtils.isNull(personPostModel.getErrorString()))) {
                    mr(true);
                    return;
                }
                if (personPostModel.threadList.size() == 0 && this.gyd) {
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
                    this.gyc = 0;
                    this.gyd = false;
                }
                this.gyl.ms(this.mHasMore);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016221));
            }
        }
    }

    private void mr(boolean z) {
        this.gyh.gyr.removeHeaderView(this.gyh.mNoDataView);
        if (z) {
            this.gyh.mNoDataView.setVisibility(0);
            this.gyh.gyr.addHeaderView(this.gyh.mNoDataView);
            this.gyl.getView().setVisibility(8);
            return;
        }
        this.gyl.getView().setVisibility(0);
        this.gyl.brn();
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
        if (this.gpe != null) {
            this.gpe.fetchPost(getPageContext(), this, true, this.mUid, true, this.gyo, false, true);
            this.gyn = true;
        }
    }

    public void brm() {
        if (this.gpe != null) {
            this.gpe.fetchPost(getPageContext(), this, false, this.mUid, true, false, true);
        }
    }
}
