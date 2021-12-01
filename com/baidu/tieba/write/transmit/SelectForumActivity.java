package com.baidu.tieba.write.transmit;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.l;
import c.a.r0.k0.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.w0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes11.dex */
public class SelectForumActivity extends BaseActivity<SelectForumActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.l4.q.b mAdapter;
    public View mBackView;
    public BaijiahaoData mBaijiahaoData;
    public c.a.r0.l4.p.a mCheckCallback;
    public c.a.r0.l4.p.b mCheckManager;
    public c.a.r0.l4.p.c mCheckResponseData;
    public FrameLayout mContentView;
    public List<TransmitForumData> mDataList;
    public View mDivider;
    public CustomMessageListener mForumDataLoadedListener;
    public int mFrom;
    public ImageView mIconSearch;
    public boolean mIsFromShare;
    public BdListView mListView;
    public long mLiveId;
    public String mMoreForumImg;
    public String mMoreForumTitle;
    public String mMoreForumUrl;
    public NavigationBar mNavigationBar;
    public View.OnClickListener mOnClickListener;
    public AdapterView.OnItemClickListener mOnItemClickListener;
    public OriginalThreadInfo.ShareInfo mOriginalThread;
    public int mPrivateThread;
    public View mRootView;
    public LinearLayout mSearchLayout;
    public TextView mTextViewSearch;
    public TextView mTitleView;
    public String mTopicId;
    public c.a.r0.l4.p.f mTransferSaveManager;
    public String mTransmitOriginThreadComment;
    public String mTransmitThreadAuthorNameShow;
    public String mYyAnchorBdUid;

    /* loaded from: classes11.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectForumActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SelectForumActivity selectForumActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectForumActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectForumActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof ArrayList)) {
                return;
            }
            this.a.mDataList.clear();
            this.a.mDataList.addAll((ArrayList) customResponsedMessage.getData());
            if (this.a.mAdapter != null) {
                SelectForumActivity selectForumActivity = this.a;
                selectForumActivity.hideLoadingView(selectForumActivity.mContentView);
                this.a.mAdapter.b(this.a.mDataList);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements c.a.r0.l4.p.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectForumActivity a;

        public b(SelectForumActivity selectForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectForumActivity;
        }

        @Override // c.a.r0.l4.p.a
        public void a(c.a.r0.l4.p.c cVar, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, cVar, i2, str) == null) {
                if (cVar == null) {
                    SelectForumActivity selectForumActivity = this.a;
                    selectForumActivity.hideLoadingView(selectForumActivity.mContentView);
                    this.a.showToast(str);
                    Intent intent = new Intent();
                    intent.putExtra(PmsConstant.Statistic.STATISTIC_ERRCODE, i2);
                    this.a.setResult(1008, intent);
                    this.a.finish();
                    return;
                }
                if (this.a.mCheckResponseData != null) {
                    this.a.mCheckResponseData.f19580c = cVar.f19580c;
                    this.a.mCheckResponseData.f19581d = cVar.f19581d;
                }
                h.c().i();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class c implements c.a.r0.l4.p.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectForumActivity a;

        public c(SelectForumActivity selectForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectForumActivity;
        }

        @Override // c.a.r0.l4.p.e
        public void a(c.a.r0.l4.p.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
                if (dVar == null) {
                    SelectForumActivity selectForumActivity = this.a;
                    selectForumActivity.showToast(selectForumActivity.getString(R.string.share_sdk_share_faild_default));
                    Intent intent = new Intent();
                    intent.putExtra(PmsConstant.Statistic.STATISTIC_ERRCODE, -2113);
                    this.a.setResult(1008, intent);
                } else {
                    ErrorData errorData = dVar.a;
                    if (errorData != null && errorData.getError_code() != 0) {
                        this.a.showToast(dVar.a.getError_msg());
                        Intent intent2 = new Intent();
                        intent2.putExtra(PmsConstant.Statistic.STATISTIC_ERRCODE, dVar.a.getError_code());
                        this.a.setResult(1008, intent2);
                    } else {
                        TiebaStatic.log(new StatisticItem("c13278").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", dVar.f19589b).param("tid", dVar.f19590c));
                        this.a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a).createNormalCfg(this.a.mCheckResponseData.f19583f, "")));
                    }
                }
                this.a.finish();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class d implements ShareSdkView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectForumActivity a;

        public d(SelectForumActivity selectForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectForumActivity;
        }

        @Override // com.baidu.tieba.write.share.ShareSdkView.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.a.mCheckResponseData != null) {
                    this.a.mCheckResponseData.m = str;
                }
                if (this.a.mTransferSaveManager != null) {
                    this.a.mTransferSaveManager.d(this.a.mCheckResponseData);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectForumActivity f50845e;

        public e(SelectForumActivity selectForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50845e = selectForumActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            if (view.getId() != this.f50845e.mBackView.getId()) {
                if ((view.getId() == this.f50845e.mIconSearch.getId() || view.getId() == this.f50845e.mTextViewSearch.getId()) && ViewHelper.checkUpIsLogin(this.f50845e)) {
                    if (this.f50845e.mCheckResponseData != null) {
                        TiebaStatic.log(new StatisticItem("c13276").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", 2));
                    } else {
                        TiebaStatic.log(new StatisticItem("c13276").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", 1));
                    }
                    this.f50845e.forumClickStatistics(1);
                    ForumSearchActivityConfig forumSearchActivityConfig = new ForumSearchActivityConfig(this.f50845e.getPageContext().getPageActivity());
                    forumSearchActivityConfig.setFrom(this.f50845e.mFrom);
                    forumSearchActivityConfig.setLiveId(this.f50845e.mLiveId);
                    forumSearchActivityConfig.setYyAnchorBdUid(this.f50845e.mYyAnchorBdUid);
                    forumSearchActivityConfig.setBaijiahaoData(this.f50845e.mBaijiahaoData);
                    forumSearchActivityConfig.setOriginalThread(this.f50845e.mOriginalThread);
                    forumSearchActivityConfig.setTransmitOriginThreadComment(this.f50845e.mTransmitOriginThreadComment);
                    forumSearchActivityConfig.setTransmitThreadAuthorNameShow(this.f50845e.mTransmitThreadAuthorNameShow);
                    forumSearchActivityConfig.setRequestCode(25019);
                    forumSearchActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                    forumSearchActivityConfig.setMoreForumImg(this.f50845e.mMoreForumImg);
                    forumSearchActivityConfig.setMoreForumUrl(this.f50845e.mMoreForumUrl);
                    forumSearchActivityConfig.setMoreForumTitle(this.f50845e.mMoreForumTitle);
                    this.f50845e.sendMessage(new CustomMessage(2002001, forumSearchActivityConfig));
                    return;
                }
                return;
            }
            this.f50845e.setResult(0);
            this.f50845e.finish();
        }
    }

    /* loaded from: classes11.dex */
    public class f implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectForumActivity f50846e;

        public f(SelectForumActivity selectForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50846e = selectForumActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            TransmitForumData transmitForumData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (transmitForumData = (TransmitForumData) this.f50846e.mDataList.get(i2)) == null) {
                return;
            }
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            arrayList.add(transmitForumData);
            if (this.f50846e.mCheckResponseData != null) {
                this.f50846e.mCheckResponseData.f19582e = String.valueOf(transmitForumData.forumId);
                this.f50846e.mCheckResponseData.f19583f = transmitForumData.forumName;
                this.f50846e.addShareSdkView(AddFriendActivityConfig.TYPE_FOCUS);
            } else if (this.f50846e.mFrom != 1 || (this.f50846e.mLiveId <= 0 && TextUtils.isEmpty(this.f50846e.mYyAnchorBdUid))) {
                if (this.f50846e.mFrom != 2) {
                    if (this.f50846e.mFrom == 4) {
                        if (WriteActivityConfig.isAsyncWriting()) {
                            return;
                        }
                        SelectForumActivity selectForumActivity = this.f50846e;
                        selectForumActivity.jumpToForumShareEditActivity(transmitForumData, selectForumActivity.mPrivateThread);
                        this.f50846e.finish();
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putParcelableArrayListExtra(SelectForumActivityConfig.KEY_OUTPUT_FORUM_LIST, arrayList);
                    this.f50846e.setResult(-1, intent);
                    this.f50846e.finish();
                    return;
                }
                SelectForumActivity selectForumActivity2 = this.f50846e;
                selectForumActivity2.jumpToTransmitPostEditActivity(transmitForumData, selectForumActivity2.mPrivateThread);
                this.f50846e.forumClickStatistics(2);
                this.f50846e.finish();
            } else {
                this.f50846e.jumpToAlaShareInBar(arrayList);
            }
        }
    }

    public SelectForumActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDataList = new ArrayList();
        this.mFrom = 0;
        this.mLiveId = -1L;
        this.mIsFromShare = false;
        this.mForumDataLoadedListener = new a(this, 2016563);
        this.mOnClickListener = new e(this);
        this.mOnItemClickListener = new f(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addShareSdkView(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65561, this, str) == null) || this.mCheckResponseData == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c13277").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", str));
        ShareSdkView shareSdkView = new ShareSdkView(this);
        shareSdkView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        shareSdkView.setOnShareListener(new d(this));
        ((ViewGroup) this.mRootView).addView(shareSdkView);
        shareSdkView.setData(this.mCheckResponseData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void forumClickStatistics(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65562, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c12610").param("obj_locate", i2));
        }
    }

    private FrsTabInfoData getTabInfoData(TransmitForumData transmitForumData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, this, transmitForumData)) == null) {
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
        return (FrsTabInfoData) invokeL.objValue;
    }

    private void initData() {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65564, this) == null) || (intent = getIntent()) == null) {
            return;
        }
        Uri data = intent.getData();
        String scheme = data != null ? data.getScheme() : null;
        this.mTopicId = intent.getStringExtra("topic_id");
        this.mIsFromShare = intent.getBooleanExtra("from_share", false);
        if (!StringUtils.isNull(scheme) && "tieba".equals(scheme)) {
            TiebaStatic.log(new StatisticItem("c13275").param("uid", TbadkCoreApplication.getCurrentAccount()));
            try {
                Class.forName("com.baidu.tieba.enterForum.home.CoreSearchRequestStatic");
                Class.forName("c.a.r0.u0.h.a");
            } catch (Exception unused) {
            }
            this.mFrom = 3;
            c.a.r0.l4.p.c cVar = new c.a.r0.l4.p.c();
            this.mCheckResponseData = cVar;
            cVar.a = intent.getStringExtra("appkey");
            this.mCheckResponseData.f19579b = intent.getStringExtra(SelectForumActivityConfig.KEY_APPLETSKEY);
            this.mCheckResponseData.f19586i = intent.getStringExtra("image");
            this.mCheckResponseData.f19584g = intent.getStringExtra("title");
            this.mCheckResponseData.f19585h = intent.getStringExtra("desc");
            this.mCheckResponseData.f19588k = intent.getStringExtra("link");
            this.mCheckResponseData.l = intent.getStringExtra(SelectForumActivityConfig.KEY_SHARE_APPLETS_LINK);
            this.mCheckManager = new c.a.r0.l4.p.b(getUniqueId());
            b bVar = new b(this);
            this.mCheckCallback = bVar;
            this.mCheckManager.e(bVar);
            c.a.r0.l4.p.f fVar = new c.a.r0.l4.p.f(getUniqueId());
            this.mTransferSaveManager = fVar;
            fVar.c(new c(this));
            return;
        }
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("KEY_INTPUT_FORUM_LIST");
        if (ListUtils.getCount(parcelableArrayListExtra) > 0) {
            this.mDataList.addAll(parcelableArrayListExtra);
        }
        this.mFrom = intent.getIntExtra(SelectForumActivityConfig.EXTRA_KEY_FROM, 0);
        this.mLiveId = intent.getLongExtra("extra_key_live_id", -1L);
        this.mYyAnchorBdUid = intent.getStringExtra("extra_key_yy_anchor_bduid");
        this.mPrivateThread = intent.getIntExtra(SelectForumActivityConfig.EXTRA_KEY_PRIVATE_THREAD, 0);
        this.mBaijiahaoData = (BaijiahaoData) intent.getSerializableExtra(SelectForumActivityConfig.EXTRA_KEY_BAIJIAHAO_DATA);
        this.mOriginalThread = (OriginalThreadInfo.ShareInfo) intent.getSerializableExtra(SelectForumActivityConfig.EXTRA_KEY_ORIGINAL_THREAD);
        this.mTransmitOriginThreadComment = intent.getStringExtra(SelectForumActivityConfig.EXTRA_KEY_TRANSMIT_ORIGIN_THREAD_CONTENT);
        this.mTransmitThreadAuthorNameShow = intent.getStringExtra(SelectForumActivityConfig.EXTRA_KEY_TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
        this.mMoreForumImg = intent.getStringExtra("more_forum_img");
        this.mMoreForumUrl = intent.getStringExtra("more_forum_url");
        this.mMoreForumTitle = intent.getStringExtra("more_forum_title");
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, this) == null) {
            this.mRootView = findViewById(R.id.root_view);
            this.mContentView = (FrameLayout) findViewById(R.id.transmit_content_layout);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.mNavigationBar = navigationBar;
            TextView addTextButton = navigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(R.string.cancel));
            this.mBackView = addTextButton;
            if (addTextButton.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBackView.getLayoutParams();
                layoutParams.leftMargin = l.f(getActivity(), R.dimen.ds10);
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
            c.a.r0.l4.q.b bVar = new c.a.r0.l4.q.b(getActivity());
            this.mAdapter = bVar;
            this.mListView.setAdapter((ListAdapter) bVar);
            this.mAdapter.b(this.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpToAlaShareInBar(ArrayList<TransmitForumData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, this, arrayList) == null) {
            AlaWriteShareInBarActivityConfig alaWriteShareInBarActivityConfig = new AlaWriteShareInBarActivityConfig(getPageContext().getPageActivity(), arrayList, String.valueOf(this.mLiveId), this.mYyAnchorBdUid);
            alaWriteShareInBarActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            alaWriteShareInBarActivityConfig.setRequestCode(25038);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, alaWriteShareInBarActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpToForumShareEditActivity(TransmitForumData transmitForumData, int i2) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65567, this, transmitForumData, i2) == null) {
            if (transmitForumData != null) {
                str = String.valueOf(transmitForumData.forumId);
                str2 = transmitForumData.forumName;
            } else {
                str = "0";
                str2 = null;
            }
            WriteActivityConfig.newInstance(getPageContext().getPageActivity()).setType(9).setFrom(WriteActivityConfig.FROM_FORUM_SHARE).setForumId(str).setForumName(str2).setPrivateThread(i2).send();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpToTransmitPostEditActivity(TransmitForumData transmitForumData, int i2) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65568, this, transmitForumData, i2) == null) {
            if (transmitForumData != null) {
                str = String.valueOf(transmitForumData.forumId);
                str2 = transmitForumData.forumName;
            } else {
                str = null;
                str2 = null;
            }
            TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(getPageContext().getPageActivity(), 9, str, str2, null, null, w0.B6, null, null, null, this.mOriginalThread);
            transmitPostEditActivityConfig.setTopicId(this.mTopicId);
            transmitPostEditActivityConfig.setCallFrom("2");
            transmitPostEditActivityConfig.setPrivateThread(i2);
            transmitPostEditActivityConfig.setBaijiahaoData(this.mBaijiahaoData);
            transmitPostEditActivityConfig.setTransmitOriginThreadComment(this.mTransmitOriginThreadComment);
            transmitPostEditActivityConfig.setTransmitThreadAuthorNameShow(this.mTransmitThreadAuthorNameShow);
            transmitPostEditActivityConfig.setFrsTabInfo(getTabInfoData(transmitForumData));
            transmitPostEditActivityConfig.setIsShare(this.mIsFromShare);
            sendMessage(new CustomMessage(2002001, transmitPostEditActivityConfig));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 == 25038) {
                setResult(-1, intent);
                finish();
            } else if (i3 == -1 && i2 == 25019) {
                c.a.r0.l4.p.c cVar = this.mCheckResponseData;
                if (cVar != null && intent != null) {
                    cVar.f19582e = intent.getStringExtra(SelectForumActivityConfig.SELECT_FORUM_ID);
                    this.mCheckResponseData.f19583f = intent.getStringExtra(SelectForumActivityConfig.SELECT_FORUM_NAME);
                    addShareSdkView("search");
                    return;
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            SkinManager.setViewTextColor(this.mBackView, R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.mTitleView, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.mSearchLayout, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.mTextViewSearch, R.color.CAM_X0109);
            SkinManager.setImageResource(this.mIconSearch, R.drawable.icon_post_search_n);
            SkinManager.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.mDivider, R.color.CAM_X0204);
            this.mAdapter.c(i2);
            this.mListView.setSelector(SkinManager.getDrawable(R.drawable.selector_select_forum_item));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
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
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onResume();
            if (this.mCheckManager != null && TbadkCoreApplication.isLogin() && ListUtils.isEmpty(this.mDataList)) {
                c.a.r0.l4.p.c cVar = this.mCheckResponseData;
                if (cVar != null) {
                    this.mCheckManager.d(cVar.a, cVar.f19579b);
                    return;
                }
                return;
            }
            hideLoadingView(this.mContentView);
        }
    }
}
