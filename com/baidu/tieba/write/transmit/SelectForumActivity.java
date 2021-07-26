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
import d.a.d.e.p.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class SelectForumActivity extends BaseActivity<SelectForumActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.q0.a4.q.b mAdapter;
    public View mBackView;
    public BaijiahaoData mBaijiahaoData;
    public d.a.q0.a4.p.a mCheckCallback;
    public d.a.q0.a4.p.b mCheckManager;
    public d.a.q0.a4.p.c mCheckResponseData;
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
    public d.a.q0.a4.p.f mTransferSaveManager;
    public String mTransmitOriginThreadComment;
    public String mTransmitThreadAuthorNameShow;
    public String mYyAnchorBdUid;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SelectForumActivity f22770a;

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
            this.f22770a = selectForumActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof ArrayList)) {
                return;
            }
            this.f22770a.mDataList.clear();
            this.f22770a.mDataList.addAll((ArrayList) customResponsedMessage.getData());
            if (this.f22770a.mAdapter != null) {
                SelectForumActivity selectForumActivity = this.f22770a;
                selectForumActivity.hideLoadingView(selectForumActivity.mContentView);
                this.f22770a.mAdapter.b(this.f22770a.mDataList);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.q0.a4.p.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SelectForumActivity f22771a;

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
            this.f22771a = selectForumActivity;
        }

        @Override // d.a.q0.a4.p.a
        public void a(d.a.q0.a4.p.c cVar, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, cVar, i2, str) == null) {
                if (cVar == null) {
                    SelectForumActivity selectForumActivity = this.f22771a;
                    selectForumActivity.hideLoadingView(selectForumActivity.mContentView);
                    this.f22771a.showToast(str);
                    Intent intent = new Intent();
                    intent.putExtra(PmsConstant.Statistic.STATISTIC_ERRCODE, i2);
                    this.f22771a.setResult(1008, intent);
                    this.f22771a.finish();
                    return;
                }
                if (this.f22771a.mCheckResponseData != null) {
                    this.f22771a.mCheckResponseData.f54824c = cVar.f54824c;
                    this.f22771a.mCheckResponseData.f54825d = cVar.f54825d;
                }
                d.a.q0.e0.f.b().h();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.a.q0.a4.p.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SelectForumActivity f22772a;

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
            this.f22772a = selectForumActivity;
        }

        @Override // d.a.q0.a4.p.e
        public void a(d.a.q0.a4.p.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
                if (dVar == null) {
                    SelectForumActivity selectForumActivity = this.f22772a;
                    selectForumActivity.showToast(selectForumActivity.getString(R.string.share_sdk_share_faild_default));
                    Intent intent = new Intent();
                    intent.putExtra(PmsConstant.Statistic.STATISTIC_ERRCODE, -2113);
                    this.f22772a.setResult(1008, intent);
                } else {
                    ErrorData errorData = dVar.f54831a;
                    if (errorData != null && errorData.getError_code() != 0) {
                        this.f22772a.showToast(dVar.f54831a.getError_msg());
                        Intent intent2 = new Intent();
                        intent2.putExtra(PmsConstant.Statistic.STATISTIC_ERRCODE, dVar.f54831a.getError_code());
                        this.f22772a.setResult(1008, intent2);
                    } else {
                        TiebaStatic.log(new StatisticItem("c13278").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", dVar.f54832b).param("tid", dVar.f54833c));
                        this.f22772a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f22772a).createNormalCfg(this.f22772a.mCheckResponseData.f54827f, "")));
                    }
                }
                this.f22772a.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements ShareSdkView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SelectForumActivity f22773a;

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
            this.f22773a = selectForumActivity;
        }

        @Override // com.baidu.tieba.write.share.ShareSdkView.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.f22773a.mCheckResponseData != null) {
                    this.f22773a.mCheckResponseData.m = str;
                }
                if (this.f22773a.mTransferSaveManager != null) {
                    this.f22773a.mTransferSaveManager.d(this.f22773a.mCheckResponseData);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectForumActivity f22774e;

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
            this.f22774e = selectForumActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            if (view.getId() != this.f22774e.mBackView.getId()) {
                if ((view.getId() == this.f22774e.mIconSearch.getId() || view.getId() == this.f22774e.mTextViewSearch.getId()) && ViewHelper.checkUpIsLogin(this.f22774e)) {
                    if (this.f22774e.mCheckResponseData != null) {
                        TiebaStatic.log(new StatisticItem("c13276").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", 2));
                    } else {
                        TiebaStatic.log(new StatisticItem("c13276").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", 1));
                    }
                    this.f22774e.forumClickStatistics(1);
                    ForumSearchActivityConfig forumSearchActivityConfig = new ForumSearchActivityConfig(this.f22774e.getPageContext().getPageActivity());
                    forumSearchActivityConfig.setFrom(this.f22774e.mFrom);
                    forumSearchActivityConfig.setLiveId(this.f22774e.mLiveId);
                    forumSearchActivityConfig.setYyAnchorBdUid(this.f22774e.mYyAnchorBdUid);
                    forumSearchActivityConfig.setBaijiahaoData(this.f22774e.mBaijiahaoData);
                    forumSearchActivityConfig.setOriginalThread(this.f22774e.mOriginalThread);
                    forumSearchActivityConfig.setTransmitOriginThreadComment(this.f22774e.mTransmitOriginThreadComment);
                    forumSearchActivityConfig.setTransmitThreadAuthorNameShow(this.f22774e.mTransmitThreadAuthorNameShow);
                    forumSearchActivityConfig.setRequestCode(25019);
                    forumSearchActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                    forumSearchActivityConfig.setMoreForumImg(this.f22774e.mMoreForumImg);
                    forumSearchActivityConfig.setMoreForumUrl(this.f22774e.mMoreForumUrl);
                    forumSearchActivityConfig.setMoreForumTitle(this.f22774e.mMoreForumTitle);
                    this.f22774e.sendMessage(new CustomMessage(2002001, forumSearchActivityConfig));
                    return;
                }
                return;
            }
            this.f22774e.setResult(0);
            this.f22774e.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectForumActivity f22775e;

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
            this.f22775e = selectForumActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            TransmitForumData transmitForumData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || (transmitForumData = (TransmitForumData) this.f22775e.mDataList.get(i2)) == null) {
                return;
            }
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            arrayList.add(transmitForumData);
            if (this.f22775e.mCheckResponseData != null) {
                this.f22775e.mCheckResponseData.f54826e = String.valueOf(transmitForumData.forumId);
                this.f22775e.mCheckResponseData.f54827f = transmitForumData.forumName;
                this.f22775e.addShareSdkView(AddFriendActivityConfig.TYPE_FOCUS);
            } else if (this.f22775e.mFrom != 1 || (this.f22775e.mLiveId <= 0 && TextUtils.isEmpty(this.f22775e.mYyAnchorBdUid))) {
                if (this.f22775e.mFrom != 2) {
                    if (this.f22775e.mFrom == 4) {
                        if (WriteActivityConfig.isAsyncWriting()) {
                            return;
                        }
                        SelectForumActivity selectForumActivity = this.f22775e;
                        selectForumActivity.jumpToForumShareEditActivity(transmitForumData, selectForumActivity.mPrivateThread);
                        this.f22775e.finish();
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putParcelableArrayListExtra(SelectForumActivityConfig.KEY_OUTPUT_FORUM_LIST, arrayList);
                    this.f22775e.setResult(-1, intent);
                    this.f22775e.finish();
                    return;
                }
                SelectForumActivity selectForumActivity2 = this.f22775e;
                selectForumActivity2.jumpToTransmitPostEditActivity(transmitForumData, selectForumActivity2.mPrivateThread);
                this.f22775e.forumClickStatistics(2);
                this.f22775e.finish();
            } else {
                this.f22775e.jumpToAlaShareInBar(arrayList);
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
                Class.forName("d.a.q0.l0.h.a");
            } catch (Exception unused) {
            }
            this.mFrom = 3;
            d.a.q0.a4.p.c cVar = new d.a.q0.a4.p.c();
            this.mCheckResponseData = cVar;
            cVar.f54822a = intent.getStringExtra("appkey");
            this.mCheckResponseData.f54823b = intent.getStringExtra(SelectForumActivityConfig.KEY_APPLETSKEY);
            this.mCheckResponseData.f54830i = intent.getStringExtra("image");
            this.mCheckResponseData.f54828g = intent.getStringExtra("title");
            this.mCheckResponseData.f54829h = intent.getStringExtra("desc");
            this.mCheckResponseData.k = intent.getStringExtra("link");
            this.mCheckResponseData.l = intent.getStringExtra(SelectForumActivityConfig.KEY_SHARE_APPLETS_LINK);
            this.mCheckManager = new d.a.q0.a4.p.b(getUniqueId());
            b bVar = new b(this);
            this.mCheckCallback = bVar;
            this.mCheckManager.e(bVar);
            d.a.q0.a4.p.f fVar = new d.a.q0.a4.p.f(getUniqueId());
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
            d.a.q0.a4.q.b bVar = new d.a.q0.a4.q.b(getActivity());
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
                d.a.q0.a4.p.c cVar = this.mCheckResponseData;
                if (cVar != null && intent != null) {
                    cVar.f54826e = intent.getStringExtra(SelectForumActivityConfig.SELECT_FORUM_ID);
                    this.mCheckResponseData.f54827f = intent.getStringExtra(SelectForumActivityConfig.SELECT_FORUM_NAME);
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
                d.a.q0.a4.p.c cVar = this.mCheckResponseData;
                if (cVar != null) {
                    this.mCheckManager.d(cVar.f54822a, cVar.f54823b);
                    return;
                }
                return;
            }
            hideLoadingView(this.mContentView);
        }
    }
}
