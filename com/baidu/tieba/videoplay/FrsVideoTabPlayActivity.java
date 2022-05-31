package com.baidu.tieba.videoplay;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.fluency.BdTracesManager;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsVideoTabPlayActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.danmu.DanmuProgressManager;
import com.baidu.tieba.videoplay.fragment.VideoVerticalPageFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.fh5;
import com.repackage.ki;
import com.repackage.lh4;
import com.repackage.li;
import com.repackage.mh4;
import com.repackage.wq4;
import com.repackage.x8;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsVideoTabPlayActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isFromBjhPb;
    public View mBackView;
    public String mFid;
    public String mFname;
    public VideoVerticalPageFragment mFragment;
    public String mFrom;
    public String mFromPage;
    public boolean mIsFromSchema;
    public fh5 mNEGFeedBackManager;
    public NavigationBar mNavigationBar;
    public String mNid;
    public Rect mRect;
    public String mSourceFrom;
    public long mStartTime;
    public CustomMessageListener mSuspendedViewAnimationListener;
    public String mTid;
    public TextView mTitleView;
    public List<VideoItemData> mVideoDataList;
    public int mVideoIndex;
    public CustomMessageListener mVideoVerticalPageBackGroundListener;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsVideoTabPlayActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FrsVideoTabPlayActivity frsVideoTabPlayActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsVideoTabPlayActivity, Integer.valueOf(i)};
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
            this.a = frsVideoTabPlayActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUniqueId tag;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getOrginalMessage() == null || (tag = customResponsedMessage.getOrginalMessage().getTag()) == null || this.a.getUniqueId().getId() != tag.getId() || !(customResponsedMessage.getData() instanceof Float)) {
                return;
            }
            float floatValue = ((Float) customResponsedMessage.getData()).floatValue();
            if (floatValue < 0.0f || floatValue > 1.0f) {
                return;
            }
            this.a.mNavigationBar.setAlpha(floatValue);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsVideoTabPlayActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(FrsVideoTabPlayActivity frsVideoTabPlayActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsVideoTabPlayActivity, Integer.valueOf(i)};
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
            this.a = frsVideoTabPlayActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (customResponsedMessage == null && customResponsedMessage.getData() == null) {
                    return;
                }
                if (customResponsedMessage.getData() instanceof Boolean ? ((Boolean) customResponsedMessage.getData()).booleanValue() : true) {
                    this.a.getActivity().getWindow().setBackgroundDrawable(new ColorDrawable(this.a.getResources().getColor(R.color.CAM_X0611)));
                    if (this.a.mTitleView != null) {
                        this.a.mTitleView.setVisibility(0);
                    }
                    if (this.a.mBackView != null) {
                        this.a.mBackView.setVisibility(0);
                        return;
                    }
                    return;
                }
                this.a.getActivity().getWindow().setBackgroundDrawable(null);
                if (this.a.mTitleView != null) {
                    this.a.mTitleView.setVisibility(8);
                }
                if (this.a.mBackView != null) {
                    this.a.mBackView.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsVideoTabPlayActivity a;

        public c(FrsVideoTabPlayActivity frsVideoTabPlayActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsVideoTabPlayActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsVideoTabPlayActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921612));
                } else {
                    this.a.finish();
                }
            }
        }
    }

    public FrsVideoTabPlayActivity() {
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
        this.mStartTime = 0L;
        this.mIsFromSchema = false;
        this.mSuspendedViewAnimationListener = new a(this, 2921594);
        this.mVideoVerticalPageBackGroundListener = new b(this, 2921665);
    }

    private void doEnterStatistic() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_ENTER_VIDEO_PAGE);
            if (TextUtils.isEmpty(this.mNid)) {
                statisticItem.param("obj_type", "1");
                statisticItem.param("obj_source", "4");
                statisticItem.param("fid", this.mFid);
                statisticItem.param("fname", this.mFname);
            } else {
                statisticItem.param("obj_type", "2");
                statisticItem.param("obj_id", this.mNid);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    private int getVideoCurrentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) ? isFromFrsTop() ? 20 : 7 : invokeV.intValue;
    }

    private void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.mVideoDataList = (List) getIntent().getSerializableExtra("video_list");
            this.mFrom = getIntent().getStringExtra("page_from");
            this.mFromPage = getIntent().getStringExtra("from");
            this.mSourceFrom = getIntent().getStringExtra("source_from");
            this.isFromBjhPb = getIntent().getBooleanExtra("is_from_bjh_pb", false);
            this.mNid = getIntent().getStringExtra("key_nid");
            this.mFid = getIntent().getStringExtra("forum_id");
        }
    }

    private void initFragment() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            List<VideoItemData> videoTabListByFid = FrsVideoTabPlayActivityConfig.getVideoTabListByFid(this.mFid);
            if (ListUtils.isEmpty(this.mVideoDataList) && !ListUtils.isEmpty(videoTabListByFid)) {
                ArrayList arrayList = new ArrayList();
                this.mVideoDataList = arrayList;
                arrayList.addAll(videoTabListByFid);
            }
            if (ListUtils.isEmpty(this.mVideoDataList)) {
                li.N(this, R.string.obfuscated_res_0x7f0f0c30);
                finish();
                return;
            }
            if (getIntent() != null && getIntent().getExtras() != null && !ki.isEmpty("video_index")) {
                this.mVideoIndex = getIntent().getExtras().getInt("video_index");
            }
            List<VideoItemData> list = this.mVideoDataList;
            if (list != null) {
                int size = list.size();
                int i = this.mVideoIndex;
                if (size > i && this.mVideoDataList.get(i) != null) {
                    this.mTid = this.mVideoDataList.get(this.mVideoIndex).thread_id;
                }
            }
            if (getIntent() != null && !ki.isEmpty("video_cover_rect")) {
                this.mRect = (Rect) getIntent().getParcelableExtra("video_cover_rect");
            }
            this.mFname = this.mVideoDataList.get(0).forum_name;
            VideoVerticalPageFragment videoVerticalPageFragment = new VideoVerticalPageFragment(getUniqueId(), null, 0, getVideoCurrentType());
            this.mFragment = videoVerticalPageFragment;
            videoVerticalPageFragment.setArguments(getIntent().getExtras());
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.add(R.id.obfuscated_res_0x7f092371, this.mFragment);
            beginTransaction.commitAllowingStateLoss();
            getSupportFragmentManager().executePendingTransactions();
            this.mNavigationBar = new NavigationBar(this);
            int k = li.k(this);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            int dimenPixelSize2 = (int) ((k - (((dimenPixelSize + UtilHelper.getDimenPixelSize(R.dimen.tbds104)) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X013)) * 2)) / (UtilHelper.getDimenPixelSize(R.dimen.T_X05) * 0.5f));
            TextView textView = new TextView(this);
            this.mTitleView = textView;
            textView.setGravity(17);
            TextView textView2 = this.mTitleView;
            textView2.setText(StringHelper.cutChineseAndEnglishWithEmoji(this.mFname, dimenPixelSize2, StringHelper.STRING_MORE) + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02d3));
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.mTitleView, (View.OnClickListener) null);
            View addSystemImageButton = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mBackView = addSystemImageButton;
            addSystemImageButton.setOnClickListener(new c(this));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, UtilHelper.getDimenPixelSize(R.dimen.tbds104));
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds26);
            layoutParams.leftMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X002);
            layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X002);
            addContentView(this.mNavigationBar, layoutParams);
        }
    }

    private boolean isFromFrsTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? TextUtils.equals(this.mFrom, FrsVideoTabPlayActivityConfig.FROM_FRS_VIDEO_TOP) : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.mIsFromSchema) {
                sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
            if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                TbSingleton.getInstance().setIsJumpFromVideoMiddleView(true);
            }
            VideoVerticalPageFragment videoVerticalPageFragment = this.mFragment;
            if (videoVerticalPageFragment != null && videoVerticalPageFragment.T0() != null && this.mFragment.T0().longValue() != 0 && this.mFragment.S0() != null && !this.mFragment.T0().equals(this.mFragment.S0()) && !this.mFrom.equals(FrsVideoTabPlayActivityConfig.FROM_FRS_VIDEO_TOP)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921630, this.mFragment.T0()));
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.repackage.f75
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "a093" : (String) invokeV.objValue;
    }

    public Rect getStartCardRect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mRect : (Rect) invokeV.objValue;
    }

    public String getStartCardTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mTid : (String) invokeV.objValue;
    }

    public int getVideoIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mVideoIndex : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048583, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            VideoVerticalPageFragment videoVerticalPageFragment = this.mFragment;
            if (videoVerticalPageFragment != null) {
                videoVerticalPageFragment.o0(i, i2, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            NavigationBar navigationBar = this.mNavigationBar;
            if (navigationBar != null && this.mTitleView != null) {
                navigationBar.setBackgroundResource(R.drawable.obfuscated_res_0x7f081233);
                wq4 d = wq4.d(this.mTitleView);
                d.A(R.string.F_X01);
                d.v(R.color.CAM_X0101);
                d.z(R.dimen.T_X05);
                if (this.mNavigationBar.getBackImageView() != null) {
                    WebPManager.setPureDrawable(this.mNavigationBar.getBackImageView(), R.drawable.obfuscated_res_0x7f0809eb, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
                }
            }
            if (!UtilHelper.isFlyMeOs()) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this);
            }
            VideoVerticalPageFragment videoVerticalPageFragment = this.mFragment;
            if (videoVerticalPageFragment != null) {
                videoVerticalPageFragment.onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (configuration.orientation == 2) {
                this.mNavigationBar.setVisibility(8);
            } else {
                this.mNavigationBar.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            if (getIntent() != null) {
                if (getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !x8.g().i("MainTabActivity")) {
                    this.mIsFromSchema = true;
                }
                this.mFrom = getIntent().getStringExtra("from");
            }
            if (this.mIsFromSchema) {
                setIsAddSwipeBackLayout(false);
            }
            super.onCreate(bundle);
            BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(FrsVideoTabPlayActivityConfig.KEY_FPS_MIDDLE_VIDEO);
            this.mStartTime = System.currentTimeMillis();
            setContentView(R.layout.obfuscated_res_0x7f0d086c);
            this.mNEGFeedBackManager = new fh5(getPageContext(), "client_videomiddle");
            initData();
            initFragment();
            addNoAdjustSoftInputHeightListener();
            if (UbsABTestHelper.isFeedVideoImmersionTransition() && !FrsVideoTabPlayActivityConfig.FROM_FRS_VIDEO_TOP.equals(this.mFrom)) {
                setActivityBgTransparent();
                TextView textView = this.mTitleView;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                View view2 = this.mBackView;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
            }
            doEnterStatistic();
            registerListener(this.mSuspendedViewAnimationListener);
            registerListener(this.mVideoVerticalPageBackGroundListener);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDestroy();
            DanmuProgressManager.b.a().b();
            fh5 fh5Var = this.mNEGFeedBackManager;
            if (fh5Var != null) {
                fh5Var.h();
            }
            String str = TextUtils.isEmpty(this.mNid) ? "0" : "1";
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            if ("from_nani_video".equals(this.mFrom)) {
                String str2 = "a002";
                if (!"index".equals(this.mSourceFrom)) {
                    if ("concern_tab".equals(this.mSourceFrom)) {
                        str2 = "a038";
                    } else if ("frs".equals(this.mSourceFrom)) {
                        str2 = "a006";
                    } else {
                        "homepage".equals(this.mSourceFrom);
                    }
                }
                if (this.isFromBjhPb) {
                    TiebaStatic.log(new StatisticItem("stime").param("obj_type", "a023").param(TiebaStatic.Params.OBJ_DURATION, currentTimeMillis).param("obj_source", str2).param(TiebaStatic.Params.IS_VERTICAL, "1").param("is_dynamic", str).param("obj_location", this.mFromPage));
                    return;
                } else {
                    TiebaStatic.log(new StatisticItem("stime").param("obj_type", "a023").param(TiebaStatic.Params.OBJ_DURATION, currentTimeMillis).param("obj_source", str2).param("is_dynamic", str).param(TiebaStatic.Params.IS_VERTICAL, "1"));
                    return;
                }
            }
            TiebaStatic.log(new StatisticItem("stime").param("obj_type", "a023").param(TiebaStatic.Params.OBJ_DURATION, currentTimeMillis).param("is_dynamic", str).param("obj_source", "a020"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048588, this, i, keyEvent)) == null) {
            if (i == 4) {
                VideoVerticalPageFragment videoVerticalPageFragment = this.mFragment;
                if (videoVerticalPageFragment != null) {
                    if (videoVerticalPageFragment.w0()) {
                        return false;
                    }
                    this.mFragment.U();
                }
                finish();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            super.onKeyboardVisibilityChanged(z);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921645, Boolean.valueOf(z)));
            if (Build.VERSION.SDK_INT < 16 || z || getActivity() == null || getActivity().getWindow() == null || getActivity().getWindow().getDecorView() == null || TbSingleton.getInstance().isNotchScreen(this) || TbSingleton.getInstance().isCutoutScreen(this)) {
                return;
            }
            getActivity().getWindow().getDecorView().setSystemUiVisibility(getActivity().getWindow().getDecorView().getSystemUiVisibility() | 4);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onPause();
            VideoVerticalPageFragment videoVerticalPageFragment = this.mFragment;
            if (videoVerticalPageFragment != null) {
                videoVerticalPageFragment.setPrimary(false);
                this.mFragment.setUserVisibleHint(false);
            }
            mh4.x().F();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onResume();
            VideoVerticalPageFragment videoVerticalPageFragment = this.mFragment;
            if (videoVerticalPageFragment != null) {
                videoVerticalPageFragment.setPrimary(true);
                this.mFragment.setUserVisibleHint(true);
                mh4.x().Q(lh4.a0, this.mFragment.Y());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? "712" : (String) invokeV.objValue;
    }
}
