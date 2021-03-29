package com.baidu.tieba.write.transmit;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.AlaWriteShareInBarActivityConfig;
import com.baidu.tbadk.core.atomData.ForumSearchActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.atomData.TransmitPostEditActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.write.share.ShareSdkView;
import d.b.b.e.p.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class SelectForumActivity extends BaseActivity<SelectForumActivity> {
    public d.b.i0.u3.r.b mAdapter;
    public View mBackView;
    public BaijiahaoData mBaijiahaoData;
    public d.b.i0.u3.q.a mCheckCallback;
    public d.b.i0.u3.q.b mCheckManager;
    public d.b.i0.u3.q.c mCheckResponseData;
    public FrameLayout mContentView;
    public View mDivider;
    public ImageView mIconSearch;
    public BdListView mListView;
    public String mMoreForumImg;
    public String mMoreForumTitle;
    public String mMoreForumUrl;
    public NavigationBar mNavigationBar;
    public OriginalThreadInfo.ShareInfo mOriginalThread;
    public int mPrivateThread;
    public View mRootView;
    public LinearLayout mSearchLayout;
    public TextView mTextViewSearch;
    public TextView mTitleView;
    public d.b.i0.u3.q.f mTransferSaveManager;
    public String mTransmitOriginThreadComment;
    public String mTransmitThreadAuthorNameShow;
    public List<TransmitForumData> mDataList = new ArrayList();
    public int mFrom = 0;
    public long mLiveId = -1;
    public CustomMessageListener mForumDataLoadedListener = new a(2016563);
    public View.OnClickListener mOnClickListener = new e();
    public AdapterView.OnItemClickListener mOnItemClickListener = new f();

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof ArrayList)) {
                return;
            }
            SelectForumActivity.this.mDataList.clear();
            SelectForumActivity.this.mDataList.addAll((ArrayList) customResponsedMessage.getData());
            if (SelectForumActivity.this.mAdapter != null) {
                SelectForumActivity selectForumActivity = SelectForumActivity.this;
                selectForumActivity.hideLoadingView(selectForumActivity.mContentView);
                SelectForumActivity.this.mAdapter.b(SelectForumActivity.this.mDataList);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d.b.i0.u3.q.a {
        public b() {
        }

        @Override // d.b.i0.u3.q.a
        public void a(d.b.i0.u3.q.c cVar, int i, String str) {
            if (cVar == null) {
                SelectForumActivity selectForumActivity = SelectForumActivity.this;
                selectForumActivity.hideLoadingView(selectForumActivity.mContentView);
                SelectForumActivity.this.showToast(str);
                Intent intent = new Intent();
                intent.putExtra(PmsConstant.Statistic.STATISTIC_ERRCODE, i);
                SelectForumActivity.this.setResult(1008, intent);
                SelectForumActivity.this.finish();
                return;
            }
            if (SelectForumActivity.this.mCheckResponseData != null) {
                SelectForumActivity.this.mCheckResponseData.f61669c = cVar.f61669c;
                SelectForumActivity.this.mCheckResponseData.f61670d = cVar.f61670d;
            }
            d.b.i0.b0.f.b().h();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements d.b.i0.u3.q.e {
        public c() {
        }

        @Override // d.b.i0.u3.q.e
        public void a(d.b.i0.u3.q.d dVar) {
            if (dVar == null) {
                SelectForumActivity selectForumActivity = SelectForumActivity.this;
                selectForumActivity.showToast(selectForumActivity.getString(R.string.share_sdk_share_faild_default));
                Intent intent = new Intent();
                intent.putExtra(PmsConstant.Statistic.STATISTIC_ERRCODE, -2113);
                SelectForumActivity.this.setResult(1008, intent);
            } else {
                ErrorData errorData = dVar.f61675a;
                if (errorData != null && errorData.getError_code() != 0) {
                    SelectForumActivity.this.showToast(dVar.f61675a.getError_msg());
                    Intent intent2 = new Intent();
                    intent2.putExtra(PmsConstant.Statistic.STATISTIC_ERRCODE, dVar.f61675a.getError_code());
                    SelectForumActivity.this.setResult(1008, intent2);
                } else {
                    TiebaStatic.log(new StatisticItem("c13278").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", dVar.f61676b).param("tid", dVar.f61677c));
                    SelectForumActivity.this.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(SelectForumActivity.this).createNormalCfg(SelectForumActivity.this.mCheckResponseData.f61672f, "")));
                }
            }
            SelectForumActivity.this.finish();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ShareSdkView.c {
        public d() {
        }

        @Override // com.baidu.tieba.write.share.ShareSdkView.c
        public void a(String str) {
            if (SelectForumActivity.this.mCheckResponseData != null) {
                SelectForumActivity.this.mCheckResponseData.m = str;
            }
            if (SelectForumActivity.this.mTransferSaveManager != null) {
                SelectForumActivity.this.mTransferSaveManager.d(SelectForumActivity.this.mCheckResponseData);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == null) {
                return;
            }
            if (view.getId() != SelectForumActivity.this.mBackView.getId()) {
                if ((view.getId() == SelectForumActivity.this.mIconSearch.getId() || view.getId() == SelectForumActivity.this.mTextViewSearch.getId()) && ViewHelper.checkUpIsLogin(SelectForumActivity.this)) {
                    if (SelectForumActivity.this.mCheckResponseData != null) {
                        TiebaStatic.log(new StatisticItem("c13276").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", 2));
                    } else {
                        TiebaStatic.log(new StatisticItem("c13276").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", 1));
                    }
                    SelectForumActivity.this.forumClickStatistics(1);
                    ForumSearchActivityConfig forumSearchActivityConfig = new ForumSearchActivityConfig(SelectForumActivity.this.getPageContext().getPageActivity());
                    forumSearchActivityConfig.setFrom(SelectForumActivity.this.mFrom);
                    forumSearchActivityConfig.setLiveId(SelectForumActivity.this.mLiveId);
                    forumSearchActivityConfig.setBaijiahaoData(SelectForumActivity.this.mBaijiahaoData);
                    forumSearchActivityConfig.setOriginalThread(SelectForumActivity.this.mOriginalThread);
                    forumSearchActivityConfig.setTransmitOriginThreadComment(SelectForumActivity.this.mTransmitOriginThreadComment);
                    forumSearchActivityConfig.setTransmitThreadAuthorNameShow(SelectForumActivity.this.mTransmitThreadAuthorNameShow);
                    forumSearchActivityConfig.setRequestCode(25019);
                    forumSearchActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                    forumSearchActivityConfig.setMoreForumImg(SelectForumActivity.this.mMoreForumImg);
                    forumSearchActivityConfig.setMoreForumUrl(SelectForumActivity.this.mMoreForumUrl);
                    forumSearchActivityConfig.setMoreForumTitle(SelectForumActivity.this.mMoreForumTitle);
                    SelectForumActivity.this.sendMessage(new CustomMessage(2002001, forumSearchActivityConfig));
                    return;
                }
                return;
            }
            SelectForumActivity.this.setResult(0);
            SelectForumActivity.this.finish();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements AdapterView.OnItemClickListener {
        public f() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TransmitForumData transmitForumData = (TransmitForumData) SelectForumActivity.this.mDataList.get(i);
            if (transmitForumData != null) {
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                arrayList.add(transmitForumData);
                if (SelectForumActivity.this.mCheckResponseData != null) {
                    SelectForumActivity.this.mCheckResponseData.f61671e = String.valueOf(transmitForumData.forumId);
                    SelectForumActivity.this.mCheckResponseData.f61672f = transmitForumData.forumName;
                    SelectForumActivity.this.addShareSdkView(AddFriendActivityConfig.TYPE_FOCUS);
                } else if (SelectForumActivity.this.mFrom != 1 || SelectForumActivity.this.mLiveId <= 0) {
                    if (SelectForumActivity.this.mFrom != 2) {
                        if (SelectForumActivity.this.mFrom == 4) {
                            if (WriteActivityConfig.isAsyncWriting()) {
                                return;
                            }
                            SelectForumActivity selectForumActivity = SelectForumActivity.this;
                            selectForumActivity.jumpToForumShareEditActivity(transmitForumData, selectForumActivity.mPrivateThread);
                            SelectForumActivity.this.finish();
                            return;
                        }
                        Intent intent = new Intent();
                        intent.putParcelableArrayListExtra(SelectForumActivityConfig.KEY_OUTPUT_FORUM_LIST, arrayList);
                        SelectForumActivity.this.setResult(-1, intent);
                        SelectForumActivity.this.finish();
                        return;
                    }
                    SelectForumActivity selectForumActivity2 = SelectForumActivity.this;
                    selectForumActivity2.jumpToTransmitPostEditActivity(transmitForumData, selectForumActivity2.mPrivateThread);
                    SelectForumActivity.this.forumClickStatistics(2);
                    SelectForumActivity.this.finish();
                } else {
                    SelectForumActivity.this.jumpToAlaShareInBar(arrayList);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addShareSdkView(String str) {
        if (this.mCheckResponseData == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c13277").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", str));
        ShareSdkView shareSdkView = new ShareSdkView(this);
        shareSdkView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        shareSdkView.setOnShareListener(new d());
        ((ViewGroup) this.mRootView).addView(shareSdkView);
        shareSdkView.setData(this.mCheckResponseData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void forumClickStatistics(int i) {
        TiebaStatic.log(new StatisticItem("c12610").param("obj_locate", i));
    }

    private FrsTabInfoData getTabInfoData(TransmitForumData transmitForumData) {
        if (transmitForumData == null || ListUtils.isEmpty(transmitForumData.tabItemDatas)) {
            return null;
        }
        ArrayList arrayList = new ArrayList(transmitForumData.tabItemDatas.size());
        Iterator<FrsTabItemData> it = transmitForumData.tabItemDatas.iterator();
        while (it.hasNext()) {
            FrsTabItemData next = it.next();
            if (next != null && next.isGeneralTab == 1) {
                arrayList.add(next);
            }
        }
        if (ListUtils.isEmpty(arrayList)) {
            return null;
        }
        FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
        frsTabInfoData.tabList = arrayList;
        frsTabInfoData.selectedTabId = -1;
        return frsTabInfoData;
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            Uri data = intent.getData();
            String scheme = data != null ? data.getScheme() : null;
            if (!StringUtils.isNull(scheme) && "tieba".equals(scheme)) {
                TiebaStatic.log(new StatisticItem("c13275").param("uid", TbadkCoreApplication.getCurrentAccount()));
                try {
                    Class.forName("com.baidu.tieba.enterForum.home.CoreSearchRequestStatic");
                    Class.forName("d.b.i0.i0.h.a");
                } catch (Exception unused) {
                }
                this.mFrom = 3;
                d.b.i0.u3.q.c cVar = new d.b.i0.u3.q.c();
                this.mCheckResponseData = cVar;
                cVar.f61667a = intent.getStringExtra("appkey");
                this.mCheckResponseData.f61668b = intent.getStringExtra(SelectForumActivityConfig.KEY_APPLETSKEY);
                this.mCheckResponseData.i = intent.getStringExtra("image");
                this.mCheckResponseData.f61673g = intent.getStringExtra("title");
                this.mCheckResponseData.f61674h = intent.getStringExtra("desc");
                this.mCheckResponseData.k = intent.getStringExtra("link");
                this.mCheckResponseData.l = intent.getStringExtra(SelectForumActivityConfig.KEY_SHARE_APPLETS_LINK);
                this.mCheckManager = new d.b.i0.u3.q.b(getUniqueId());
                b bVar = new b();
                this.mCheckCallback = bVar;
                this.mCheckManager.e(bVar);
                d.b.i0.u3.q.f fVar = new d.b.i0.u3.q.f(getUniqueId());
                this.mTransferSaveManager = fVar;
                fVar.c(new c());
                return;
            }
            ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("KEY_INTPUT_FORUM_LIST");
            if (ListUtils.getCount(parcelableArrayListExtra) > 0) {
                this.mDataList.addAll(parcelableArrayListExtra);
            }
            this.mFrom = intent.getIntExtra(SelectForumActivityConfig.EXTRA_KEY_FROM, 0);
            this.mLiveId = intent.getLongExtra("extra_key_live_id", -1L);
            this.mPrivateThread = intent.getIntExtra(SelectForumActivityConfig.EXTRA_KEY_PRIVATE_THREAD, 0);
            this.mBaijiahaoData = (BaijiahaoData) intent.getSerializableExtra(SelectForumActivityConfig.EXTRA_KEY_BAIJIAHAO_DATA);
            this.mOriginalThread = (OriginalThreadInfo.ShareInfo) intent.getSerializableExtra(SelectForumActivityConfig.EXTRA_KEY_ORIGINAL_THREAD);
            this.mTransmitOriginThreadComment = intent.getStringExtra(SelectForumActivityConfig.EXTRA_KEY_TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.mTransmitThreadAuthorNameShow = intent.getStringExtra(SelectForumActivityConfig.EXTRA_KEY_TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            this.mMoreForumImg = intent.getStringExtra("more_forum_img");
            this.mMoreForumUrl = intent.getStringExtra("more_forum_url");
            this.mMoreForumTitle = intent.getStringExtra("more_forum_title");
        }
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_view);
        this.mContentView = (FrameLayout) findViewById(R.id.transmit_content_layout);
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar = navigationBar;
        TextView addTextButton = navigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(R.string.cancel));
        this.mBackView = addTextButton;
        if (addTextButton.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBackView.getLayoutParams();
            layoutParams.leftMargin = l.g(getActivity(), R.dimen.ds10);
            this.mBackView.setLayoutParams(layoutParams);
        }
        this.mTitleView = this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.select_share_forum_bar));
        this.mBackView.setOnClickListener(this.mOnClickListener);
        this.mSearchLayout = (LinearLayout) findViewById(R.id.layout_search);
        ImageView imageView = (ImageView) findViewById(R.id.icon_search);
        this.mIconSearch = imageView;
        imageView.setOnClickListener(this.mOnClickListener);
        TextView textView = (TextView) findViewById(R.id.textview_search);
        this.mTextViewSearch = textView;
        textView.setOnClickListener(this.mOnClickListener);
        this.mDivider = findViewById(R.id.view_divider);
        BdListView bdListView = (BdListView) findViewById(R.id.trasmit_grid_view);
        this.mListView = bdListView;
        bdListView.setOnItemClickListener(this.mOnItemClickListener);
        d.b.i0.u3.r.b bVar = new d.b.i0.u3.r.b(getActivity());
        this.mAdapter = bVar;
        this.mListView.setAdapter((ListAdapter) bVar);
        this.mAdapter.b(this.mDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpToAlaShareInBar(ArrayList<TransmitForumData> arrayList) {
        AlaWriteShareInBarActivityConfig alaWriteShareInBarActivityConfig = new AlaWriteShareInBarActivityConfig(getPageContext().getPageActivity(), arrayList, String.valueOf(this.mLiveId));
        alaWriteShareInBarActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        alaWriteShareInBarActivityConfig.setRequestCode(25038);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, alaWriteShareInBarActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpToForumShareEditActivity(TransmitForumData transmitForumData, int i) {
        String str;
        String str2;
        if (transmitForumData != null) {
            str = String.valueOf(transmitForumData.forumId);
            str2 = transmitForumData.forumName;
        } else {
            str = "0";
            str2 = null;
        }
        WriteActivityConfig.newInstance(getPageContext().getPageActivity()).setType(9).setFrom(WriteActivityConfig.FROM_FORUM_SHARE).setForumId(str).setForumName(str2).setPrivateThread(i).send();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpToTransmitPostEditActivity(TransmitForumData transmitForumData, int i) {
        String str;
        String str2;
        if (transmitForumData != null) {
            str = String.valueOf(transmitForumData.forumId);
            str2 = transmitForumData.forumName;
        } else {
            str = null;
            str2 = null;
        }
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(getPageContext().getPageActivity(), 9, str, str2, null, null, 13011, null, null, null, this.mOriginalThread);
        transmitPostEditActivityConfig.setCallFrom("2");
        transmitPostEditActivityConfig.setPrivateThread(i);
        transmitPostEditActivityConfig.setBaijiahaoData(this.mBaijiahaoData);
        transmitPostEditActivityConfig.setTransmitOriginThreadComment(this.mTransmitOriginThreadComment);
        transmitPostEditActivityConfig.setTransmitThreadAuthorNameShow(this.mTransmitThreadAuthorNameShow);
        transmitPostEditActivityConfig.setFrsTabInfo(getTabInfoData(transmitForumData));
        sendMessage(new CustomMessage(2002001, transmitPostEditActivityConfig));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25038) {
            finish();
        } else if (i2 == -1 && i == 25019) {
            d.b.i0.u3.q.c cVar = this.mCheckResponseData;
            if (cVar != null && intent != null) {
                cVar.f61671e = intent.getStringExtra(SelectForumActivityConfig.SELECT_FORUM_ID);
                this.mCheckResponseData.f61672f = intent.getStringExtra(SelectForumActivityConfig.SELECT_FORUM_NAME);
                addShareSdkView("search");
                return;
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        SkinManager.setViewTextColor(this.mBackView, R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.mTitleView, R.color.CAM_X0105);
        SkinManager.setBackgroundColor(this.mSearchLayout, R.color.CAM_X0205);
        SkinManager.setViewTextColor(this.mTextViewSearch, R.color.CAM_X0109);
        SkinManager.setImageResource(this.mIconSearch, R.drawable.icon_post_search_n);
        SkinManager.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.mDivider, R.color.CAM_X0204);
        this.mAdapter.c(i);
        this.mListView.setSelector(SkinManager.getDrawable(R.drawable.selector_select_forum_item));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.select_forum_activity);
        initData();
        initView();
        registerListener(this.mForumDataLoadedListener);
        if (this.mCheckResponseData != null) {
            showLoadingView(this.mContentView);
        }
        ViewHelper.checkUpIsLogin(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mCheckManager != null && TbadkCoreApplication.isLogin() && ListUtils.isEmpty(this.mDataList)) {
            d.b.i0.u3.q.c cVar = this.mCheckResponseData;
            if (cVar != null) {
                this.mCheckManager.d(cVar.f61667a, cVar.f61668b);
                return;
            }
            return;
        }
        hideLoadingView(this.mContentView);
    }
}
