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
import com.kuaishou.weapon.un.w0;
import com.repackage.ay5;
import com.repackage.bw8;
import com.repackage.cw8;
import com.repackage.dw8;
import com.repackage.ew8;
import com.repackage.fw8;
import com.repackage.gw8;
import com.repackage.hw8;
import com.repackage.li;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class SelectForumActivity extends BaseActivity<SelectForumActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hw8 mAdapter;
    public View mBackView;
    public BaijiahaoData mBaijiahaoData;
    public bw8 mCheckCallback;
    public cw8 mCheckManager;
    public dw8 mCheckResponseData;
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
    public gw8 mTransferSaveManager;
    public String mTransmitOriginThreadComment;
    public String mTransmitThreadAuthorNameShow;
    public String mYyAnchorBdUid;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectForumActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SelectForumActivity selectForumActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectForumActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    /* loaded from: classes4.dex */
    public class b implements bw8 {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectForumActivity;
        }

        @Override // com.repackage.bw8
        public void a(dw8 dw8Var, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, dw8Var, i, str) == null) {
                if (dw8Var == null) {
                    SelectForumActivity selectForumActivity = this.a;
                    selectForumActivity.hideLoadingView(selectForumActivity.mContentView);
                    this.a.showToast(str);
                    Intent intent = new Intent();
                    intent.putExtra(PmsConstant.Statistic.STATISTIC_ERRCODE, i);
                    this.a.setResult(1008, intent);
                    this.a.finish();
                    return;
                }
                if (this.a.mCheckResponseData != null) {
                    this.a.mCheckResponseData.c = dw8Var.c;
                    this.a.mCheckResponseData.d = dw8Var.d;
                }
                ay5.c().i();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements fw8 {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectForumActivity;
        }

        @Override // com.repackage.fw8
        public void a(ew8 ew8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ew8Var) == null) {
                if (ew8Var == null) {
                    SelectForumActivity selectForumActivity = this.a;
                    selectForumActivity.showToast(selectForumActivity.getString(R.string.obfuscated_res_0x7f0f116a));
                    Intent intent = new Intent();
                    intent.putExtra(PmsConstant.Statistic.STATISTIC_ERRCODE, -2113);
                    this.a.setResult(1008, intent);
                } else {
                    ErrorData errorData = ew8Var.a;
                    if (errorData != null && errorData.getError_code() != 0) {
                        this.a.showToast(ew8Var.a.getError_msg());
                        Intent intent2 = new Intent();
                        intent2.putExtra(PmsConstant.Statistic.STATISTIC_ERRCODE, ew8Var.a.getError_code());
                        this.a.setResult(1008, intent2);
                    } else {
                        TiebaStatic.log(new StatisticItem("c13278").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", ew8Var.b).param("tid", ew8Var.c));
                        this.a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a).createNormalCfg(this.a.mCheckResponseData.f, "")));
                    }
                }
                this.a.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectForumActivity a;

        public e(SelectForumActivity selectForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectForumActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null) {
                return;
            }
            if (view2.getId() != this.a.mBackView.getId()) {
                if ((view2.getId() == this.a.mIconSearch.getId() || view2.getId() == this.a.mTextViewSearch.getId()) && ViewHelper.checkUpIsLogin(this.a)) {
                    if (this.a.mCheckResponseData != null) {
                        TiebaStatic.log(new StatisticItem("c13276").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", 2));
                    } else {
                        TiebaStatic.log(new StatisticItem("c13276").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", 1));
                    }
                    this.a.forumClickStatistics(1);
                    ForumSearchActivityConfig forumSearchActivityConfig = new ForumSearchActivityConfig(this.a.getPageContext().getPageActivity());
                    forumSearchActivityConfig.setFrom(this.a.mFrom);
                    forumSearchActivityConfig.setLiveId(this.a.mLiveId);
                    forumSearchActivityConfig.setYyAnchorBdUid(this.a.mYyAnchorBdUid);
                    forumSearchActivityConfig.setBaijiahaoData(this.a.mBaijiahaoData);
                    forumSearchActivityConfig.setOriginalThread(this.a.mOriginalThread);
                    forumSearchActivityConfig.setTransmitOriginThreadComment(this.a.mTransmitOriginThreadComment);
                    forumSearchActivityConfig.setTransmitThreadAuthorNameShow(this.a.mTransmitThreadAuthorNameShow);
                    forumSearchActivityConfig.setRequestCode(25019);
                    forumSearchActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                    forumSearchActivityConfig.setMoreForumImg(this.a.mMoreForumImg);
                    forumSearchActivityConfig.setMoreForumUrl(this.a.mMoreForumUrl);
                    forumSearchActivityConfig.setMoreForumTitle(this.a.mMoreForumTitle);
                    this.a.sendMessage(new CustomMessage(2002001, forumSearchActivityConfig));
                    return;
                }
                return;
            }
            this.a.setResult(0);
            this.a.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectForumActivity a;

        public f(SelectForumActivity selectForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectForumActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            TransmitForumData transmitForumData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || (transmitForumData = (TransmitForumData) this.a.mDataList.get(i)) == null) {
                return;
            }
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            arrayList.add(transmitForumData);
            if (this.a.mCheckResponseData != null) {
                this.a.mCheckResponseData.e = String.valueOf(transmitForumData.forumId);
                this.a.mCheckResponseData.f = transmitForumData.forumName;
                this.a.addShareSdkView(AddFriendActivityConfig.TYPE_FOCUS);
            } else if (this.a.mFrom != 1 || (this.a.mLiveId <= 0 && TextUtils.isEmpty(this.a.mYyAnchorBdUid))) {
                if (this.a.mFrom != 2) {
                    if (this.a.mFrom == 4) {
                        if (WriteActivityConfig.isAsyncWriting()) {
                            return;
                        }
                        SelectForumActivity selectForumActivity = this.a;
                        selectForumActivity.jumpToForumShareEditActivity(transmitForumData, selectForumActivity.mPrivateThread);
                        this.a.finish();
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putParcelableArrayListExtra(SelectForumActivityConfig.KEY_OUTPUT_FORUM_LIST, arrayList);
                    this.a.setResult(-1, intent);
                    this.a.finish();
                    return;
                }
                SelectForumActivity selectForumActivity2 = this.a;
                selectForumActivity2.jumpToTransmitPostEditActivity(transmitForumData, selectForumActivity2.mPrivateThread);
                this.a.forumClickStatistics(2);
                this.a.finish();
            } else {
                this.a.jumpToAlaShareInBar(arrayList);
            }
        }
    }

    public SelectForumActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
    public void forumClickStatistics(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65562, this, i) == null) {
            TiebaStatic.log(new StatisticItem("c12610").param("obj_locate", i));
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
                Class.forName("com.repackage.n36");
            } catch (Exception unused) {
            }
            this.mFrom = 3;
            dw8 dw8Var = new dw8();
            this.mCheckResponseData = dw8Var;
            dw8Var.a = intent.getStringExtra("appkey");
            this.mCheckResponseData.b = intent.getStringExtra(SelectForumActivityConfig.KEY_APPLETSKEY);
            this.mCheckResponseData.i = intent.getStringExtra("image");
            this.mCheckResponseData.g = intent.getStringExtra("title");
            this.mCheckResponseData.h = intent.getStringExtra("desc");
            this.mCheckResponseData.k = intent.getStringExtra("link");
            this.mCheckResponseData.l = intent.getStringExtra(SelectForumActivityConfig.KEY_SHARE_APPLETS_LINK);
            this.mCheckManager = new cw8(getUniqueId());
            b bVar = new b(this);
            this.mCheckCallback = bVar;
            this.mCheckManager.e(bVar);
            gw8 gw8Var = new gw8(getUniqueId());
            this.mTransferSaveManager = gw8Var;
            gw8Var.c(new c(this));
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
            this.mRootView = findViewById(R.id.obfuscated_res_0x7f091adb);
            this.mContentView = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f09212e);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0923a2);
            this.mNavigationBar = navigationBar;
            TextView addTextButton = navigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(R.string.obfuscated_res_0x7f0f0376));
            this.mBackView = addTextButton;
            if (addTextButton.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBackView.getLayoutParams();
                layoutParams.leftMargin = li.f(getActivity(), R.dimen.obfuscated_res_0x7f070234);
                this.mBackView.setLayoutParams(layoutParams);
            }
            this.mTitleView = this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.obfuscated_res_0x7f0f10fc));
            this.mBackView.setOnClickListener(this.mOnClickListener);
            this.mSearchLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0911bc);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f090dd4);
            this.mIconSearch = imageView;
            imageView.setOnClickListener(this.mOnClickListener);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f091f5c);
            this.mTextViewSearch = textView;
            textView.setOnClickListener(this.mOnClickListener);
            this.mDivider = findViewById(R.id.obfuscated_res_0x7f09238f);
            BdListView bdListView = (BdListView) findViewById(R.id.obfuscated_res_0x7f092130);
            this.mListView = bdListView;
            bdListView.setOnItemClickListener(this.mOnItemClickListener);
            hw8 hw8Var = new hw8(getActivity());
            this.mAdapter = hw8Var;
            this.mListView.setAdapter((ListAdapter) hw8Var);
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
    public void jumpToForumShareEditActivity(TransmitForumData transmitForumData, int i) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65567, this, transmitForumData, i) == null) {
            if (transmitForumData != null) {
                str = String.valueOf(transmitForumData.forumId);
                str2 = transmitForumData.forumName;
            } else {
                str = "0";
                str2 = null;
            }
            WriteActivityConfig.newInstance(getPageContext().getPageActivity()).setType(9).setFrom(WriteActivityConfig.FROM_FORUM_SHARE).setForumId(str).setMoreForumTitle(this.mMoreForumTitle).setMoreForumUrl(this.mMoreForumUrl).setMoreForumImg(this.mMoreForumImg).setForumName(str2).setPrivateThread(i).send();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpToTransmitPostEditActivity(TransmitForumData transmitForumData, int i) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65568, this, transmitForumData, i) == null) {
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
            transmitPostEditActivityConfig.setPrivateThread(i);
            transmitPostEditActivityConfig.setBaijiahaoData(this.mBaijiahaoData);
            transmitPostEditActivityConfig.setTransmitOriginThreadComment(this.mTransmitOriginThreadComment);
            transmitPostEditActivityConfig.setTransmitThreadAuthorNameShow(this.mTransmitThreadAuthorNameShow);
            transmitPostEditActivityConfig.setFrsTabInfo(getTabInfoData(transmitForumData));
            transmitPostEditActivityConfig.setIsShare(this.mIsFromShare);
            sendMessage(new CustomMessage(2002001, transmitPostEditActivityConfig));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i == 25038) {
                setResult(-1, intent);
                finish();
            } else if (i2 == -1 && i == 25019) {
                dw8 dw8Var = this.mCheckResponseData;
                if (dw8Var != null && intent != null) {
                    dw8Var.e = intent.getStringExtra(SelectForumActivityConfig.SELECT_FORUM_ID);
                    this.mCheckResponseData.f = intent.getStringExtra(SelectForumActivityConfig.SELECT_FORUM_NAME);
                    addShareSdkView("search");
                    return;
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            SkinManager.setViewTextColor(this.mBackView, (int) R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.mTitleView, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.mSearchLayout, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.mTextViewSearch, (int) R.color.CAM_X0109);
            SkinManager.setImageResource(this.mIconSearch, R.drawable.icon_post_search_n);
            SkinManager.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.mDivider, R.color.CAM_X0204);
            this.mAdapter.c(i);
            this.mListView.setSelector(SkinManager.getDrawable(R.drawable.selector_select_forum_item));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0741);
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
                dw8 dw8Var = this.mCheckResponseData;
                if (dw8Var != null) {
                    this.mCheckManager.d(dw8Var.a, dw8Var.b);
                    return;
                }
                return;
            }
            hideLoadingView(this.mContentView);
        }
    }
}
