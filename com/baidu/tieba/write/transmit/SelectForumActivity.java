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
import d.a.c.e.p.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class SelectForumActivity extends BaseActivity<SelectForumActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.s0.a4.q.b mAdapter;
    public View mBackView;
    public BaijiahaoData mBaijiahaoData;
    public d.a.s0.a4.p.a mCheckCallback;
    public d.a.s0.a4.p.b mCheckManager;
    public d.a.s0.a4.p.c mCheckResponseData;
    public FrameLayout mContentView;
    public List<TransmitForumData> mDataList;
    public View mDivider;
    public CustomMessageListener mForumDataLoadedListener;
    public int mFrom;
    public ImageView mIconSearch;
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
    public d.a.s0.a4.p.f mTransferSaveManager;
    public String mTransmitOriginThreadComment;
    public String mTransmitThreadAuthorNameShow;
    public String mYyAnchorBdUid;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SelectForumActivity f22553a;

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
            this.f22553a = selectForumActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof ArrayList)) {
                return;
            }
            this.f22553a.mDataList.clear();
            this.f22553a.mDataList.addAll((ArrayList) customResponsedMessage.getData());
            if (this.f22553a.mAdapter != null) {
                SelectForumActivity selectForumActivity = this.f22553a;
                selectForumActivity.hideLoadingView(selectForumActivity.mContentView);
                this.f22553a.mAdapter.b(this.f22553a.mDataList);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d.a.s0.a4.p.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SelectForumActivity f22554a;

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
            this.f22554a = selectForumActivity;
        }

        @Override // d.a.s0.a4.p.a
        public void a(d.a.s0.a4.p.c cVar, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, cVar, i2, str) == null) {
                if (cVar == null) {
                    SelectForumActivity selectForumActivity = this.f22554a;
                    selectForumActivity.hideLoadingView(selectForumActivity.mContentView);
                    this.f22554a.showToast(str);
                    Intent intent = new Intent();
                    intent.putExtra(PmsConstant.Statistic.STATISTIC_ERRCODE, i2);
                    this.f22554a.setResult(1008, intent);
                    this.f22554a.finish();
                    return;
                }
                if (this.f22554a.mCheckResponseData != null) {
                    this.f22554a.mCheckResponseData.f57535c = cVar.f57535c;
                    this.f22554a.mCheckResponseData.f57536d = cVar.f57536d;
                }
                d.a.s0.e0.f.b().h();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements d.a.s0.a4.p.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SelectForumActivity f22555a;

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
            this.f22555a = selectForumActivity;
        }

        @Override // d.a.s0.a4.p.e
        public void a(d.a.s0.a4.p.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
                if (dVar == null) {
                    SelectForumActivity selectForumActivity = this.f22555a;
                    selectForumActivity.showToast(selectForumActivity.getString(R.string.share_sdk_share_faild_default));
                    Intent intent = new Intent();
                    intent.putExtra(PmsConstant.Statistic.STATISTIC_ERRCODE, -2113);
                    this.f22555a.setResult(1008, intent);
                } else {
                    ErrorData errorData = dVar.f57542a;
                    if (errorData != null && errorData.getError_code() != 0) {
                        this.f22555a.showToast(dVar.f57542a.getError_msg());
                        Intent intent2 = new Intent();
                        intent2.putExtra(PmsConstant.Statistic.STATISTIC_ERRCODE, dVar.f57542a.getError_code());
                        this.f22555a.setResult(1008, intent2);
                    } else {
                        TiebaStatic.log(new StatisticItem("c13278").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", dVar.f57543b).param("tid", dVar.f57544c));
                        this.f22555a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f22555a).createNormalCfg(this.f22555a.mCheckResponseData.f57538f, "")));
                    }
                }
                this.f22555a.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ShareSdkView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SelectForumActivity f22556a;

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
            this.f22556a = selectForumActivity;
        }

        @Override // com.baidu.tieba.write.share.ShareSdkView.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.f22556a.mCheckResponseData != null) {
                    this.f22556a.mCheckResponseData.m = str;
                }
                if (this.f22556a.mTransferSaveManager != null) {
                    this.f22556a.mTransferSaveManager.d(this.f22556a.mCheckResponseData);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectForumActivity f22557e;

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
            this.f22557e = selectForumActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            if (view.getId() != this.f22557e.mBackView.getId()) {
                if ((view.getId() == this.f22557e.mIconSearch.getId() || view.getId() == this.f22557e.mTextViewSearch.getId()) && ViewHelper.checkUpIsLogin(this.f22557e)) {
                    if (this.f22557e.mCheckResponseData != null) {
                        TiebaStatic.log(new StatisticItem("c13276").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", 2));
                    } else {
                        TiebaStatic.log(new StatisticItem("c13276").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", 1));
                    }
                    this.f22557e.forumClickStatistics(1);
                    ForumSearchActivityConfig forumSearchActivityConfig = new ForumSearchActivityConfig(this.f22557e.getPageContext().getPageActivity());
                    forumSearchActivityConfig.setFrom(this.f22557e.mFrom);
                    forumSearchActivityConfig.setLiveId(this.f22557e.mLiveId);
                    forumSearchActivityConfig.setYyAnchorBdUid(this.f22557e.mYyAnchorBdUid);
                    forumSearchActivityConfig.setBaijiahaoData(this.f22557e.mBaijiahaoData);
                    forumSearchActivityConfig.setOriginalThread(this.f22557e.mOriginalThread);
                    forumSearchActivityConfig.setTransmitOriginThreadComment(this.f22557e.mTransmitOriginThreadComment);
                    forumSearchActivityConfig.setTransmitThreadAuthorNameShow(this.f22557e.mTransmitThreadAuthorNameShow);
                    forumSearchActivityConfig.setRequestCode(25019);
                    forumSearchActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                    forumSearchActivityConfig.setMoreForumImg(this.f22557e.mMoreForumImg);
                    forumSearchActivityConfig.setMoreForumUrl(this.f22557e.mMoreForumUrl);
                    forumSearchActivityConfig.setMoreForumTitle(this.f22557e.mMoreForumTitle);
                    this.f22557e.sendMessage(new CustomMessage(2002001, forumSearchActivityConfig));
                    return;
                }
                return;
            }
            this.f22557e.setResult(0);
            this.f22557e.finish();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectForumActivity f22558e;

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
            this.f22558e = selectForumActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            TransmitForumData transmitForumData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || (transmitForumData = (TransmitForumData) this.f22558e.mDataList.get(i2)) == null) {
                return;
            }
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            arrayList.add(transmitForumData);
            if (this.f22558e.mCheckResponseData != null) {
                this.f22558e.mCheckResponseData.f57537e = String.valueOf(transmitForumData.forumId);
                this.f22558e.mCheckResponseData.f57538f = transmitForumData.forumName;
                this.f22558e.addShareSdkView(AddFriendActivityConfig.TYPE_FOCUS);
            } else if (this.f22558e.mFrom != 1 || (this.f22558e.mLiveId <= 0 && TextUtils.isEmpty(this.f22558e.mYyAnchorBdUid))) {
                if (this.f22558e.mFrom != 2) {
                    if (this.f22558e.mFrom == 4) {
                        if (WriteActivityConfig.isAsyncWriting()) {
                            return;
                        }
                        SelectForumActivity selectForumActivity = this.f22558e;
                        selectForumActivity.jumpToForumShareEditActivity(transmitForumData, selectForumActivity.mPrivateThread);
                        this.f22558e.finish();
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putParcelableArrayListExtra(SelectForumActivityConfig.KEY_OUTPUT_FORUM_LIST, arrayList);
                    this.f22558e.setResult(-1, intent);
                    this.f22558e.finish();
                    return;
                }
                SelectForumActivity selectForumActivity2 = this.f22558e;
                selectForumActivity2.jumpToTransmitPostEditActivity(transmitForumData, selectForumActivity2.mPrivateThread);
                this.f22558e.forumClickStatistics(2);
                this.f22558e.finish();
            } else {
                this.f22558e.jumpToAlaShareInBar(arrayList);
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
        if (!StringUtils.isNull(scheme) && "tieba".equals(scheme)) {
            TiebaStatic.log(new StatisticItem("c13275").param("uid", TbadkCoreApplication.getCurrentAccount()));
            try {
                Class.forName("com.baidu.tieba.enterForum.home.CoreSearchRequestStatic");
                Class.forName("d.a.s0.l0.h.a");
            } catch (Exception unused) {
            }
            this.mFrom = 3;
            d.a.s0.a4.p.c cVar = new d.a.s0.a4.p.c();
            this.mCheckResponseData = cVar;
            cVar.f57533a = intent.getStringExtra("appkey");
            this.mCheckResponseData.f57534b = intent.getStringExtra(SelectForumActivityConfig.KEY_APPLETSKEY);
            this.mCheckResponseData.f57541i = intent.getStringExtra("image");
            this.mCheckResponseData.f57539g = intent.getStringExtra("title");
            this.mCheckResponseData.f57540h = intent.getStringExtra("desc");
            this.mCheckResponseData.k = intent.getStringExtra("link");
            this.mCheckResponseData.l = intent.getStringExtra(SelectForumActivityConfig.KEY_SHARE_APPLETS_LINK);
            this.mCheckManager = new d.a.s0.a4.p.b(getUniqueId());
            b bVar = new b(this);
            this.mCheckCallback = bVar;
            this.mCheckManager.e(bVar);
            d.a.s0.a4.p.f fVar = new d.a.s0.a4.p.f(getUniqueId());
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
            d.a.s0.a4.q.b bVar = new d.a.s0.a4.q.b(getActivity());
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
            TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(getPageContext().getPageActivity(), 9, str, str2, null, null, 13011, null, null, null, this.mOriginalThread);
            transmitPostEditActivityConfig.setCallFrom("2");
            transmitPostEditActivityConfig.setPrivateThread(i2);
            transmitPostEditActivityConfig.setBaijiahaoData(this.mBaijiahaoData);
            transmitPostEditActivityConfig.setTransmitOriginThreadComment(this.mTransmitOriginThreadComment);
            transmitPostEditActivityConfig.setTransmitThreadAuthorNameShow(this.mTransmitThreadAuthorNameShow);
            transmitPostEditActivityConfig.setFrsTabInfo(getTabInfoData(transmitForumData));
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
                d.a.s0.a4.p.c cVar = this.mCheckResponseData;
                if (cVar != null && intent != null) {
                    cVar.f57537e = intent.getStringExtra(SelectForumActivityConfig.SELECT_FORUM_ID);
                    this.mCheckResponseData.f57538f = intent.getStringExtra(SelectForumActivityConfig.SELECT_FORUM_NAME);
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
                d.a.s0.a4.p.c cVar = this.mCheckResponseData;
                if (cVar != null) {
                    this.mCheckManager.d(cVar.f57533a, cVar.f57534b);
                    return;
                }
                return;
            }
            hideLoadingView(this.mContentView);
        }
    }
}
