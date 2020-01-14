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
import com.baidu.tbadk.core.view.g;
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
/* loaded from: classes9.dex */
public class PersonThreadFragment extends BaseFragment implements BdListView.e, b.a, PersonPostModel.a, PersonPostModel.b, c {
    private int ali;
    private ShareSuccessReplyToServerModel gCs;
    private View gjB;
    public PersonPostModel jni;
    private int jzA;
    private d jzq;
    private h jzt;
    private FrameLayout jzu;
    private com.baidu.tieba.post.a.a jzv;
    private boolean jzw;
    private a jzx;
    private b jzy;
    private com.baidu.tbadk.core.view.h mPullView;
    private String mUid;
    private String jzs = "common";
    private boolean mHasMore = false;
    private boolean jzp = true;
    private boolean jzz = true;
    private boolean dyq = false;
    private CustomMessageListener jzB = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD) { // from class: com.baidu.tieba.post.PersonThreadFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && PersonThreadFragment.this.jzv != null) {
                PersonThreadFragment.this.jzv.GX((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener jzC = new CustomMessageListener(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE) { // from class: com.baidu.tieba.post.PersonThreadFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.adp.lib.util.l.showToast(PersonThreadFragment.this.getActivity(), (int) R.string.thread_has_hide);
            }
        }
    };
    private final CustomMessageListener cHu = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.post.PersonThreadFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && PersonThreadFragment.this.dyq) {
                    PersonThreadFragment.this.cyH();
                    PersonThreadFragment.this.jzx.bzC();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.a(PersonThreadFragment.this.gjB, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
                } else {
                    BdListViewHelper.a(PersonThreadFragment.this.gjB, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.cHu);
        this.jni = new PersonPostModel(getPageContext(), getUniqueId(), this, true, PersonPostModel.FROM_PERSON_POST);
        this.jni.setUniqueId(getUniqueId());
        this.gCs = new ShareSuccessReplyToServerModel();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_thread_fragment, viewGroup, false);
        this.jzu = (FrameLayout) inflate.findViewById(R.id.root_view);
        this.jzt = new h(getActivity(), inflate);
        if (this.jzt.cyK() == null) {
            this.jzt.b(this.jzq);
        }
        if (this.jzt.jzF != null) {
            am.setBackgroundColor(this.jzt.jzF, R.color.cp_bg_line_d);
        }
        String string2 = getArguments().getString("thread_type_key");
        if (!aq.isEmpty(string2)) {
            this.jzs = string2;
        }
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(R.string.to_be_an_liver), new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonThreadFragment.this.cyD();
            }
        });
        int dimension = (int) getResources().getDimension(R.dimen.ds102);
        String str = "";
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, dimension);
        if (this.jzs.equals("photolive")) {
            int i = com.baidu.tbadk.core.sharedPref.b.aDr().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PHOTOLIVE_HOSTLEVEL, -1);
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
                cyE();
            }
        } else {
            string = getArguments().getString("key_empty_view_text");
            bVar = null;
        }
        this.jzt.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.cr(str, string), bVar);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.jzB);
        registerListener(this.jzC);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        if (this.jzs.equals("photolive")) {
            this.jzA = 33;
        }
        this.jzv = new com.baidu.tieba.post.a.a(getPageContext(), this.jzt.jzF);
        this.jzt.cyJ().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonThreadFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                CardPersonDynamicThreadData cardPersonDynamicThreadData;
                if (i >= 0 && PersonThreadFragment.this.jzv != null && i < v.getCount(PersonThreadFragment.this.jni.threadList) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) PersonThreadFragment.this.jzv.jlA.getItem(i)) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PersonThreadFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.threadId), String.valueOf(cardPersonDynamicThreadData.postId), "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB).setThreadData(cardPersonDynamicThreadData.cNb)));
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.h(getPageContext());
        this.mPullView.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.post.PersonThreadFragment.5
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (PersonThreadFragment.this.jni != null) {
                    PersonThreadFragment.this.jzp = true;
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        if (PersonThreadFragment.this.jzt != null) {
                            PersonThreadFragment.this.jzt.an(PersonThreadFragment.this.getString(R.string.neterror), true);
                            return;
                        }
                        return;
                    }
                    PersonThreadFragment.this.cyG();
                }
            }
        });
        this.jzt.jzF.setPullRefresh(this.mPullView);
        if (TbadkCoreApplication.isMyLive) {
            this.gjB = BdListViewHelper.a(getActivity(), this.jzt.jzF, BdListViewHelper.HeadType.DEFAULT);
            BdListViewHelper.a(this.gjB, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        } else {
            this.gjB = BdListViewHelper.a(getActivity(), this.jzt.jzF, BdListViewHelper.HeadType.HASTAB);
            BdListViewHelper.a(this.gjB, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.jzt.jzF.setOnSrollToBottomListener(this);
        this.jzx = new a(getBaseFragmentActivity());
        this.jzt.jzF.setNextPage(this.jzx);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            cyH();
            this.jzx.bzC();
            this.dyq = true;
            return;
        }
        this.jzx.rS(false);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
    public void b(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null && this.jni != null) {
            if (z) {
                this.jni.threadList.clear();
            }
            ArrayList<com.baidu.adp.widget.ListView.m> arrayList = personPostModel.threadList;
            if (personPostModel.view_card_num > 0 && this.jzz) {
                v.add(arrayList, personPostModel.view_card_num - 1, new com.baidu.tieba.personPolymeric.c.j());
                this.jzz = false;
            }
            if (this.jni.threadList.isEmpty()) {
                com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) v.getItem(arrayList, 0);
                if (mVar instanceof CardPersonDynamicThreadData) {
                    ((CardPersonDynamicThreadData) mVar).fLt = true;
                } else if (mVar instanceof com.baidu.tieba.personPolymeric.c.j) {
                    ((com.baidu.tieba.personPolymeric.c.j) mVar).fLt = true;
                }
            }
            this.jni.threadList.addAll(arrayList);
            PersonPostModel.mergeDynamicThreadByTime(this.jni.threadList);
        }
        if (this.jzy != null) {
            this.jzy.rP(personPostModel.isShowRecycleBinRedTip);
        }
        a(personPostModel, z);
        this.jzv.Q(this.jni.threadList);
        this.jzv.notifyDataSetChanged();
    }

    /* loaded from: classes9.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private BaseFragmentActivity dWt;
        private View dyM;
        private int bgColor = R.color.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;
        private int mSkinType = 3;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.dWt = null;
            this.dWt = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View createView() {
            this.mRoot = LayoutInflater.from(this.dWt.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.dyM = this.mRoot.findViewById(R.id.pb_more_view);
            am.setBackgroundColor(this.mRoot, this.bgColor);
            am.setBackgroundColor(this.dyM, this.bgColor);
            this.dyM.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            lM(TbadkCoreApplication.getInst().getSkinType());
            am.setViewTextColor(this.mTextView, (int) R.color.common_color_10039);
            this.dyM.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.dWt.getPageContext().getPageActivity(), R.dimen.ds120)));
            return this.mRoot;
        }

        public void lM(int i) {
            this.dWt.getLayoutMode().onModeChanged(this.dyM);
        }

        @SuppressLint({"ResourceAsColor"})
        public void changeSkin(int i) {
            if (this.mSkinType != i) {
                am.setViewTextColor(this.mTextView, (int) R.color.common_color_10039);
                am.setBackgroundColor(this.mRoot, this.bgColor, i);
                am.setBackgroundColor(this.dyM, this.bgColor, i);
                this.mSkinType = i;
            }
        }

        public void bzC() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.dWt.getPageContext().getPageActivity().getText(R.string.loading));
            this.dyM.setVisibility(0);
        }

        public void cyI() {
            am.setBackgroundColor(this.mRoot, R.color.cp_bg_line_c);
        }

        public void rS(boolean z) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.dyM.setVisibility(0);
                    this.mTextView.setText(this.dWt.getResources().getString(R.string.list_no_more));
                    return;
                }
                this.dyM.setVisibility(0);
                this.mTextView.setText(this.dWt.getResources().getString(R.string.load_more));
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
            if (this.jzt.mNoDataView != null) {
                this.jzt.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.jzv != null) {
                this.jzv.notifyDataSetChanged();
            }
            if (this.jzx != null) {
                this.jzx.changeSkin(i);
            }
            am.setBackgroundColor(this.jzt.jzF, R.color.cp_bg_line_d);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.jzt.mNoDataView != null) {
            this.jzt.mNoDataView.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.jzt.mNoDataView != null) {
            this.jzt.mNoDataView.aFn();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.jzv != null) {
            this.jzv.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.jni != null) {
            this.jni.cancelLoadData();
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
            if (i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.jzv != null && this.jni != null && v.getCount(this.jni.threadList) > 0) {
                int count = v.getCount(this.jni.threadList);
                int i3 = 0;
                while (true) {
                    if (i3 >= count) {
                        z = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) v.getItem(this.jni.threadList, i3);
                    if ((mVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) mVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.threadId))) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (z && intent.getIntExtra("type", -1) == 0) {
                    v.remove(this.jni.threadList, i3);
                    this.jzv.notifyDataSetChanged();
                }
            }
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.gCs != null) {
                    this.gCs.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.post.PersonThreadFragment.6
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void aJp() {
                        }

                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void a(final CustomDialogData customDialogData) {
                            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.post.PersonThreadFragment.6.1
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
        if (!this.jzw) {
            this.jzt.jzF.startPullRefresh();
            this.jzw = true;
        }
    }

    public h cyC() {
        return this.jzt;
    }

    @Override // com.baidu.tieba.post.c
    public void cyy() {
        if (this.jzt != null && this.jzt.jzF != null) {
            this.jzt.jzF.startPullRefresh();
        }
    }

    public void a(d dVar) {
        this.jzq = dVar;
    }

    public void a(b bVar) {
        this.jzy = bVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
    public void a(PersonPostModel personPostModel, boolean z) {
        this.dyq = false;
        if (isAdded()) {
            this.jzt.jzF.completePullRefreshPostDelayed(0L);
            this.jzt.jzF.setEmptyView(null);
            if (personPostModel != null || this.jzp) {
                if (personPostModel == null || (personPostModel.threadList.size() == 0 && this.jzp && StringUtils.isNull(personPostModel.getErrorString()))) {
                    rR(true);
                    return;
                }
                if (personPostModel.threadList.size() == 0 && this.jzp) {
                    rR(true);
                } else {
                    rR(false);
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
                    this.ali = 0;
                    this.jzp = false;
                }
                this.jzx.rS(this.mHasMore);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MYLIVE_TAB_EDIT_ENABLE));
            }
        }
    }

    private void rR(boolean z) {
        this.jzt.jzF.removeHeaderView(this.jzt.mNoDataView);
        if (z) {
            this.jzt.mNoDataView.setVisibility(0);
            this.jzt.jzF.addHeaderView(this.jzt.mNoDataView);
            this.jzx.getView().setVisibility(8);
            return;
        }
        this.jzx.getView().setVisibility(0);
        this.jzx.cyI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyD() {
        TiebaStatic.log(TbadkCoreStatisticKey.MYLIVE_TO_BE_ANCHOR);
        cyF();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(1, this);
    }

    private void cyE() {
        cyF();
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).b(this);
    }

    private void cyF() {
        com.baidu.tbadk.e.a.b(getBaseFragmentActivity()).a(true, true, true, this);
    }

    public void cyG() {
        if (this.jni != null) {
            this.jni.fetchPost(getPageContext(), this, true, this.mUid, true, this.jzA, false, true, null);
            this.jzz = true;
        }
    }

    public void cyH() {
        if (this.jni != null) {
            this.jni.fetchPost(getPageContext(), this, false, this.mUid, true, false, true, null);
        }
    }
}
