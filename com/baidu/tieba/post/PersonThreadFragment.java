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
import com.baidu.adp.widget.ListView.o;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.e.b;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class PersonThreadFragment extends BaseFragment implements BdListView.e, b.a, PersonPostModel.a, PersonPostModel.b, c {
    private int aLM;
    private ShareSuccessReplyToServerModel hEF;
    private View hkI;
    private d kFf;
    private h kFi;
    private FrameLayout kFj;
    private com.baidu.tieba.post.a.a kFk;
    private boolean kFl;
    private a kFm;
    private b kFn;
    private int kFp;
    public PersonPostModel ktf;
    private com.baidu.tbadk.core.view.g mPullView;
    private String mUid;
    private String kFh = "common";
    private boolean mHasMore = false;
    private boolean kFe = true;
    private boolean kFo = true;
    private boolean eqP = false;
    private CustomMessageListener kFq = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD) { // from class: com.baidu.tieba.post.PersonThreadFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && PersonThreadFragment.this.kFk != null) {
                PersonThreadFragment.this.kFk.KJ((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener kFr = new CustomMessageListener(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE) { // from class: com.baidu.tieba.post.PersonThreadFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.adp.lib.util.l.showToast(PersonThreadFragment.this.getActivity(), (int) R.string.thread_has_hide);
            }
        }
    };
    private final CustomMessageListener dyW = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.post.PersonThreadFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && PersonThreadFragment.this.eqP) {
                    PersonThreadFragment.this.cSy();
                    PersonThreadFragment.this.kFm.bSj();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.a(PersonThreadFragment.this.hkI, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
                } else {
                    BdListViewHelper.a(PersonThreadFragment.this.hkI, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.dyW);
        this.ktf = new PersonPostModel(getPageContext(), getUniqueId(), this, true, PersonPostModel.FROM_PERSON_POST);
        this.ktf.setUniqueId(getUniqueId());
        this.hEF = new ShareSuccessReplyToServerModel();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_thread_fragment, viewGroup, false);
        this.kFj = (FrameLayout) inflate.findViewById(R.id.root_view);
        this.kFi = new h(getActivity(), inflate);
        if (this.kFi.cSB() == null) {
            this.kFi.b(this.kFf);
        }
        if (this.kFi.kFu != null) {
            am.setBackgroundColor(this.kFi.kFu, R.color.cp_bg_line_d);
        }
        String string2 = getArguments().getString("thread_type_key");
        if (!aq.isEmpty(string2)) {
            this.kFh = string2;
        }
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(R.string.to_be_an_liver), new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonThreadFragment.this.cSu();
            }
        });
        int dimension = (int) getResources().getDimension(R.dimen.ds102);
        String str = "";
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, dimension);
        if (this.kFh.equals("photolive")) {
            int i = com.baidu.tbadk.core.sharedPref.b.aTX().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PHOTOLIVE_HOSTLEVEL, -1);
            if (i == 0) {
                string = getPageContext().getResources().getString(R.string.to_live_to_god);
                str = getPageContext().getResources().getString(R.string.user_not_liver);
                a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_06, dimension, -1, -1);
                bVar = NoDataViewFactory.b.a(aVar);
            } else {
                string = getPageContext().getResources().getString(R.string.person_post_lv_empty_host);
                bVar = null;
            }
            if (i < 0) {
                cSv();
            }
        } else {
            string = getArguments().getString("key_empty_view_text");
            bVar = null;
        }
        this.kFi.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.dj(str, string), bVar);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.kFq);
        registerListener(this.kFr);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        if (this.kFh.equals("photolive")) {
            this.kFp = 33;
        }
        this.kFk = new com.baidu.tieba.post.a.a(getPageContext(), this.kFi.kFu);
        this.kFi.cSA().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                CardPersonDynamicThreadData cardPersonDynamicThreadData;
                if (i >= 0 && PersonThreadFragment.this.kFk != null && i < v.getCount(PersonThreadFragment.this.ktf.threadList) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) PersonThreadFragment.this.kFk.kry.getItem(i)) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PersonThreadFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.threadId), String.valueOf(cardPersonDynamicThreadData.postId), "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB).setThreadData(cardPersonDynamicThreadData.dEA)));
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.g(getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.post.PersonThreadFragment.5
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonThreadFragment.this.ktf != null) {
                    PersonThreadFragment.this.kFe = true;
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        if (PersonThreadFragment.this.kFi != null) {
                            PersonThreadFragment.this.kFi.aG(PersonThreadFragment.this.getString(R.string.neterror), true);
                            return;
                        }
                        return;
                    }
                    PersonThreadFragment.this.cSx();
                }
            }
        });
        this.kFi.kFu.setPullRefresh(this.mPullView);
        if (TbadkCoreApplication.isMyLive) {
            this.hkI = BdListViewHelper.a(getActivity(), this.kFi.kFu, BdListViewHelper.HeadType.DEFAULT);
            BdListViewHelper.a(this.hkI, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        } else {
            this.hkI = BdListViewHelper.a(getActivity(), this.kFi.kFu, BdListViewHelper.HeadType.HASTAB);
            BdListViewHelper.a(this.hkI, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.kFi.kFu.setOnSrollToBottomListener(this);
        this.kFm = new a(getBaseFragmentActivity());
        this.kFi.kFu.setNextPage(this.kFm);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            cSy();
            this.kFm.bSj();
            this.eqP = true;
            return;
        }
        this.kFm.tD(false);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
    public void b(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null && this.ktf != null) {
            if (z) {
                this.ktf.threadList.clear();
            }
            ArrayList<o> arrayList = personPostModel.threadList;
            if (personPostModel.view_card_num > 0 && this.kFo) {
                v.add(arrayList, personPostModel.view_card_num - 1, new com.baidu.tieba.personPolymeric.c.j());
                this.kFo = false;
            }
            if (this.ktf.threadList.isEmpty()) {
                o oVar = (o) v.getItem(arrayList, 0);
                if (oVar instanceof CardPersonDynamicThreadData) {
                    ((CardPersonDynamicThreadData) oVar).gIv = true;
                } else if (oVar instanceof com.baidu.tieba.personPolymeric.c.j) {
                    ((com.baidu.tieba.personPolymeric.c.j) oVar).gIv = true;
                }
            }
            this.ktf.threadList.addAll(arrayList);
            PersonPostModel.mergeDynamicThreadByTime(this.ktf.threadList);
        }
        if (this.kFn != null) {
            this.kFn.tA(personPostModel.isShowRecycleBinRedTip);
        }
        a(personPostModel, z);
        this.kFk.T(this.ktf.threadList);
        this.kFk.notifyDataSetChanged();
    }

    /* loaded from: classes11.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private BaseFragmentActivity ePD;
        private View erl;
        private int bgColor = R.color.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;
        private int mSkinType = 3;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.ePD = null;
            this.ePD = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View createView() {
            this.mRoot = LayoutInflater.from(this.ePD.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.erl = this.mRoot.findViewById(R.id.pb_more_view);
            am.setBackgroundColor(this.mRoot, this.bgColor);
            am.setBackgroundColor(this.erl, this.bgColor);
            this.erl.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            mW(TbadkCoreApplication.getInst().getSkinType());
            am.setViewTextColor(this.mTextView, (int) R.color.common_color_10039);
            this.erl.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.ePD.getPageContext().getPageActivity(), R.dimen.ds120)));
            return this.mRoot;
        }

        public void mW(int i) {
            this.ePD.getLayoutMode().onModeChanged(this.erl);
        }

        @SuppressLint({"ResourceAsColor"})
        public void changeSkin(int i) {
            if (this.mSkinType != i) {
                am.setViewTextColor(this.mTextView, (int) R.color.common_color_10039);
                am.setBackgroundColor(this.mRoot, this.bgColor, i);
                am.setBackgroundColor(this.erl, this.bgColor, i);
                this.mSkinType = i;
            }
        }

        public void bSj() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.ePD.getPageContext().getPageActivity().getText(R.string.loading));
            this.erl.setVisibility(0);
        }

        public void cSz() {
            am.setBackgroundColor(this.mRoot, R.color.cp_bg_line_c);
        }

        public void tD(boolean z) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.erl.setVisibility(0);
                    this.mTextView.setText(this.ePD.getResources().getString(R.string.list_no_more));
                    return;
                }
                this.erl.setVisibility(0);
                this.mTextView.setText(this.ePD.getResources().getString(R.string.load_more));
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
            if (this.kFi.mNoDataView != null) {
                this.kFi.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.kFk != null) {
                this.kFk.notifyDataSetChanged();
            }
            if (this.kFm != null) {
                this.kFm.changeSkin(i);
            }
            am.setBackgroundColor(this.kFi.kFu, R.color.cp_bg_line_d);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.kFi.mNoDataView != null) {
            this.kFi.mNoDataView.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.kFi.mNoDataView != null) {
            this.kFi.mNoDataView.aWa();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.kFk != null) {
            this.kFk.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.ktf != null) {
            this.ktf.cancelLoadData();
        }
        try {
            com.baidu.tbadk.e.a.resetAll();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        BdAsyncTask.removeAllTask(SetPrivacyModel.UNIQUE_ID_SET_PRIVACY_TASK);
        BdAsyncTask.removeAllTask(ForumManageModel.UNIQUE_ID_DEL_POST_TASK);
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        ShareItem shareItem;
        String stringExtra;
        boolean z;
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.kFk != null && this.ktf != null && v.getCount(this.ktf.threadList) > 0) {
                int count = v.getCount(this.ktf.threadList);
                int i3 = 0;
                while (true) {
                    if (i3 >= count) {
                        z = false;
                        break;
                    }
                    o oVar = (o) v.getItem(this.ktf.threadList, i3);
                    if ((oVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) oVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.threadId))) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (z && intent.getIntExtra("type", -1) == 0) {
                    v.remove(this.ktf.threadList, i3);
                    this.kFk.notifyDataSetChanged();
                }
            }
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.hEF != null) {
                    this.hEF.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.post.PersonThreadFragment.6
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void bas() {
                        }

                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void a(final CustomDialogData customDialogData) {
                            com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.post.PersonThreadFragment.6.1
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
        if (!this.kFl) {
            this.kFi.kFu.startPullRefresh();
            this.kFl = true;
        }
    }

    public h cSt() {
        return this.kFi;
    }

    @Override // com.baidu.tieba.post.c
    public void cSo() {
        if (this.kFi != null && this.kFi.kFu != null) {
            this.kFi.kFu.startPullRefresh();
        }
    }

    public void a(d dVar) {
        this.kFf = dVar;
    }

    public void a(b bVar) {
        this.kFn = bVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
    public void a(PersonPostModel personPostModel, boolean z) {
        this.eqP = false;
        if (isAdded()) {
            this.kFi.kFu.completePullRefreshPostDelayed(0L);
            this.kFi.kFu.setEmptyView(null);
            if (personPostModel != null || this.kFe) {
                if (personPostModel == null || (personPostModel.threadList.size() == 0 && this.kFe && StringUtils.isNull(personPostModel.getErrorString()))) {
                    tC(true);
                    return;
                }
                if (personPostModel.threadList.size() == 0 && this.kFe) {
                    tC(true);
                } else {
                    tC(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(getActivity(), personPostModel.getErrorString());
                }
                this.mHasMore = !v.isEmpty(personPostModel.threadList);
                if (z) {
                    if (personPostModel.threadList.size() < 20) {
                        this.mHasMore = false;
                    } else {
                        this.mHasMore = true;
                    }
                    this.aLM = 0;
                    this.kFe = false;
                }
                this.kFm.tD(this.mHasMore);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MYLIVE_TAB_EDIT_ENABLE));
            }
        }
    }

    private void tC(boolean z) {
        this.kFi.kFu.removeHeaderView(this.kFi.mNoDataView);
        if (z) {
            this.kFi.mNoDataView.setVisibility(0);
            this.kFi.kFu.addHeaderView(this.kFi.mNoDataView);
            this.kFm.getView().setVisibility(8);
            return;
        }
        this.kFm.getView().setVisibility(0);
        this.kFm.cSz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSu() {
        TiebaStatic.log(TbadkCoreStatisticKey.MYLIVE_TO_BE_ANCHOR);
        cSw();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(1, this);
    }

    private void cSv() {
        cSw();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).b(this);
    }

    private void cSw() {
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(true, true, true, this);
    }

    public void cSx() {
        if (this.ktf != null) {
            this.ktf.fetchPost(getPageContext(), this, true, this.mUid, true, this.kFp, false, true, null);
            this.kFo = true;
        }
    }

    public void cSy() {
        if (this.ktf != null) {
            this.ktf.fetchPost(getPageContext(), this, false, this.mUid, true, false, true, null);
        }
    }
}
