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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.f;
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
    private View dfr;
    private ShareSuccessReplyToServerModel dvD;
    public PersonPostModel fVS;
    private int geH;
    private d geJ;
    private h geM;
    private FrameLayout geN;
    private com.baidu.tieba.post.a.a geO;
    private boolean geP;
    private a geQ;
    private b geR;
    private int geT;
    private com.baidu.tbadk.core.view.g mPullView;
    private String mUid;
    private String geL = PhoneUtils.CPUInfo.FEATURE_COMMON;
    private boolean mHasMore = false;
    private boolean geI = true;
    private boolean geS = true;
    private boolean aRN = false;
    private CustomMessageListener fVT = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.post.PersonThreadFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && PersonThreadFragment.this.geO != null) {
                PersonThreadFragment.this.geO.sv((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener fVU = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.post.PersonThreadFragment.2
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
                if (com.baidu.adp.lib.util.j.jD() && PersonThreadFragment.this.aRN) {
                    PersonThreadFragment.this.bmx();
                    PersonThreadFragment.this.geQ.aqU();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.a(PersonThreadFragment.this.dfr, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.jD());
                } else {
                    BdListViewHelper.a(PersonThreadFragment.this.dfr, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.mNetworkChangedMessageListener);
        this.fVS = new PersonPostModel(getPageContext(), getUniqueId(), this, true, PersonPostModel.FROM_PERSON_POST);
        this.fVS.setUniqueId(getUniqueId());
        this.dvD = new ShareSuccessReplyToServerModel();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(d.i.person_thread_fragment, viewGroup, false);
        this.geN = (FrameLayout) inflate.findViewById(d.g.root_view);
        this.geM = new h(getActivity(), inflate);
        if (this.geM.bmA() == null) {
            this.geM.b(this.geJ);
        }
        if (this.geM.geW != null) {
            al.j(this.geM.geW, d.C0141d.cp_bg_line_d);
        }
        String string2 = getArguments().getString("thread_type_key");
        if (!ao.isEmpty(string2)) {
            this.geL = string2;
        }
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(d.k.to_be_an_liver), new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonThreadFragment.this.bmt();
            }
        });
        int dimension = (int) getResources().getDimension(d.e.ds102);
        String str = "";
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension);
        if (this.geL.equals("photolive")) {
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
                bmu();
            }
        } else {
            string = getArguments().getString("key_empty_view_text");
            bVar = null;
        }
        this.geM.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.aj(string, str), bVar);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.fVT);
        registerListener(this.fVU);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        if (this.geL.equals("photolive")) {
            this.geT = 33;
        }
        this.geO = new com.baidu.tieba.post.a.a(getPageContext(), this.geM.geW);
        this.geM.bmz().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                CardPersonDynamicThreadData cardPersonDynamicThreadData;
                if (i >= 0 && PersonThreadFragment.this.geO != null && i < w.y(PersonThreadFragment.this.fVS.threadList) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) PersonThreadFragment.this.geO.fUD.getItem(i)) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonThreadFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.threadId), String.valueOf(cardPersonDynamicThreadData.postId), "person_page", 18005)));
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.g(getPageContext());
        this.mPullView.a(new f.b() { // from class: com.baidu.tieba.post.PersonThreadFragment.5
            @Override // com.baidu.tbadk.core.view.f.b
            public void aS(boolean z) {
                if (PersonThreadFragment.this.fVS != null) {
                    PersonThreadFragment.this.geI = true;
                    if (!com.baidu.adp.lib.util.j.jr()) {
                        if (PersonThreadFragment.this.geM != null) {
                            PersonThreadFragment.this.geM.E(PersonThreadFragment.this.getString(d.k.neterror), true);
                            return;
                        }
                        return;
                    }
                    PersonThreadFragment.this.bmw();
                }
            }
        });
        this.geM.geW.setPullRefresh(this.mPullView);
        if (TbadkCoreApplication.isMyLive) {
            this.dfr = BdListViewHelper.a(getActivity(), this.geM.geW, BdListViewHelper.HeadType.DEFAULT);
            BdListViewHelper.a(this.dfr, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.jD());
        } else {
            this.dfr = BdListViewHelper.a(getActivity(), this.geM.geW, BdListViewHelper.HeadType.HASTAB);
            BdListViewHelper.a(this.dfr, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.geM.geW.setOnSrollToBottomListener(this);
        this.geQ = new a(getBaseFragmentActivity());
        this.geM.geW.setNextPage(this.geQ);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            bmx();
            this.geQ.aqU();
            this.aRN = true;
            return;
        }
        this.geQ.lG(false);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
    public void b(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null && this.fVS != null) {
            if (z) {
                this.fVS.threadList.clear();
            }
            ArrayList<com.baidu.adp.widget.ListView.h> arrayList = personPostModel.threadList;
            if (personPostModel.view_card_num > 0 && this.geS) {
                w.a(arrayList, personPostModel.view_card_num - 1, new com.baidu.tieba.personPolymeric.c.j());
                this.geS = false;
            }
            if (this.fVS.threadList.isEmpty()) {
                com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) w.c(arrayList, 0);
                if (hVar instanceof CardPersonDynamicThreadData) {
                    ((CardPersonDynamicThreadData) hVar).cCs = true;
                } else if (hVar instanceof com.baidu.tieba.personPolymeric.c.j) {
                    ((com.baidu.tieba.personPolymeric.c.j) hVar).cCs = true;
                }
            }
            this.fVS.threadList.addAll(arrayList);
            PersonPostModel.mergeDynamicThreadByTime(this.fVS.threadList);
        }
        if (this.geR != null) {
            this.geR.lD(personPostModel.isShowRecycleBinRedTip);
        }
        a(personPostModel, z);
        this.geO.y(this.fVS.threadList);
        this.geO.notifyDataSetChanged();
    }

    /* loaded from: classes3.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private View aSj;
        private BaseFragmentActivity bml;
        private int bgColor = d.C0141d.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View abp = null;
        private int mSkinType = 3;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.bml = null;
            this.bml = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View nn() {
            this.abp = LayoutInflater.from(this.bml.getPageContext().getContext()).inflate(d.i.new_pb_list_more, (ViewGroup) null);
            this.mTextView = (TextView) this.abp.findViewById(d.g.pb_more_text);
            this.aSj = this.abp.findViewById(d.g.pb_more_view);
            al.j(this.abp, this.bgColor);
            al.j(this.aSj, this.bgColor);
            this.aSj.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.abp.findViewById(d.g.progress);
            eu(TbadkCoreApplication.getInst().getSkinType());
            al.h(this.mTextView, d.C0141d.common_color_10039);
            this.aSj.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.e(this.bml.getPageContext().getPageActivity(), d.e.ds120)));
            return this.abp;
        }

        public void eu(int i) {
            this.bml.getLayoutMode().onModeChanged(this.aSj);
        }

        @SuppressLint({"ResourceAsColor"})
        public void dy(int i) {
            if (this.mSkinType != i) {
                al.h(this.mTextView, d.C0141d.common_color_10039);
                al.e(this.abp, this.bgColor, i);
                al.e(this.aSj, this.bgColor, i);
                this.mSkinType = i;
            }
        }

        public void aqU() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.bml.getPageContext().getPageActivity().getText(d.k.loading));
            this.aSj.setVisibility(0);
        }

        public void bmy() {
            al.j(this.abp, d.C0141d.cp_bg_line_c);
        }

        public void lG(boolean z) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.aSj.setVisibility(0);
                    this.mTextView.setText(this.bml.getResources().getString(d.k.list_no_more));
                    return;
                }
                this.aSj.setVisibility(0);
                this.mTextView.setText(this.bml.getResources().getString(d.k.load_more));
            }
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.abp);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.geM.mNoDataView != null) {
                this.geM.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.dy(i);
            }
            if (this.geO != null) {
                this.geO.notifyDataSetChanged();
            }
            if (this.geQ != null) {
                this.geQ.dy(i);
            }
            al.j(this.geM.geW, d.C0141d.cp_bg_line_d);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.geM.mNoDataView != null) {
            this.geM.mNoDataView.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.geM.mNoDataView != null) {
            this.geM.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.geO != null) {
            this.geO.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.fVS != null) {
            this.fVS.cancelLoadData();
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
            if (i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.geO != null && this.fVS != null && w.y(this.fVS.threadList) > 0) {
                int y = w.y(this.fVS.threadList);
                int i3 = 0;
                while (true) {
                    if (i3 >= y) {
                        z = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) w.c(this.fVS.threadList, i3);
                    if ((hVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) hVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.threadId))) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (z && intent.getIntExtra("type", -1) == 0) {
                    w.d(this.fVS.threadList, i3);
                    this.geO.notifyDataSetChanged();
                }
            }
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.dvD != null) {
                    this.dvD.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.post.PersonThreadFragment.6
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void Ee() {
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
        if (!this.geP) {
            this.geM.geW.startPullRefresh();
            this.geP = true;
        }
    }

    public h bms() {
        return this.geM;
    }

    @Override // com.baidu.tieba.post.c
    public void bmm() {
        if (this.geM != null && this.geM.geW != null) {
            this.geM.geW.startPullRefresh();
        }
    }

    public void a(d dVar) {
        this.geJ = dVar;
    }

    public void a(b bVar) {
        this.geR = bVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
    public void a(PersonPostModel personPostModel, boolean z) {
        this.aRN = false;
        if (isAdded()) {
            this.geM.geW.completePullRefreshPostDelayed(2000L);
            this.geM.geW.setEmptyView(null);
            if (personPostModel != null || this.geI) {
                if (personPostModel == null || (personPostModel.threadList.size() == 0 && this.geI && StringUtils.isNull(personPostModel.getErrorString()))) {
                    lF(true);
                    return;
                }
                if (personPostModel.threadList.size() == 0 && this.geI) {
                    lF(true);
                } else {
                    lF(false);
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
                    this.geH = 0;
                    this.geI = false;
                }
                this.geQ.lG(this.mHasMore);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016221));
            }
        }
    }

    private void lF(boolean z) {
        this.geM.geW.removeHeaderView(this.geM.mNoDataView);
        if (z) {
            this.geM.mNoDataView.setVisibility(0);
            this.geM.geW.addHeaderView(this.geM.mNoDataView);
            this.geQ.getView().setVisibility(8);
            return;
        }
        this.geQ.getView().setVisibility(0);
        this.geQ.bmy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmt() {
        TiebaStatic.log("c10491");
        bmv();
        com.baidu.tbadk.c.a.b(getBaseFragmentActivity()).a(1, this);
    }

    private void bmu() {
        bmv();
        com.baidu.tbadk.c.a.b(getBaseFragmentActivity()).b(this);
    }

    private void bmv() {
        com.baidu.tbadk.c.a.b(getBaseFragmentActivity()).a(true, true, true, this);
    }

    public void bmw() {
        if (this.fVS != null) {
            this.fVS.fetchPost(getPageContext(), this, true, this.mUid, true, this.geT, false, true);
            this.geS = true;
        }
    }

    public void bmx() {
        if (this.fVS != null) {
            this.fVS.fetchPost(getPageContext(), this, false, this.mUid, true, false, true);
        }
    }
}
