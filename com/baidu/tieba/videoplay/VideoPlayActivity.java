package com.baidu.tieba.videoplay;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentTransaction;
import b.a.e.a.b;
import b.a.e.e.p.l;
import b.a.q0.a.c;
import b.a.q0.b.d;
import b.a.r0.b4.f;
import b.a.r0.b4.g;
import b.a.r0.b4.i;
import b.a.r0.j.a;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.fluency.BdTracesManager;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.fragment.VideoMiddleFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class VideoPlayActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FROM_VIDEO_PLAY = "nani_midpage";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isFromBjhPb;
    public VideoMiddleFragment mFragment;
    public String mFrom;
    public String mFromPage;
    public boolean mIsFromSchema;
    public a mNEGFeedBackManager;
    public String mNid;
    public String mSourceFrom;
    public long mStartTime;
    public List<VideoItemData> mVideoDataList;

    public VideoPlayActivity() {
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
        this.mStartTime = 0L;
        this.mIsFromSchema = false;
    }

    private void doEnterStatistic() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_ENTER_VIDEO_PAGE);
            if (TextUtils.isEmpty(this.mNid)) {
                statisticItem.param("obj_type", "1");
            } else {
                statisticItem.param("obj_type", "2");
                statisticItem.param("obj_id", this.mNid);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    private void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.mVideoDataList = (List) getIntent().getSerializableExtra("video_list");
            this.mFrom = getIntent().getStringExtra("page_from");
            this.mFromPage = getIntent().getStringExtra("from");
            this.mSourceFrom = getIntent().getStringExtra("source_from");
            this.isFromBjhPb = getIntent().getBooleanExtra("is_from_bjh_pb", false);
            this.mNid = getIntent().getStringExtra("key_nid");
        }
    }

    private void initFragment() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            if (ListUtils.isEmpty(this.mVideoDataList) && !ListUtils.isEmpty(VideoPlayActivityConfig.bigDataList)) {
                ArrayList arrayList = new ArrayList();
                this.mVideoDataList = arrayList;
                arrayList.addAll(VideoPlayActivityConfig.bigDataList);
            }
            if (ListUtils.isEmpty(this.mVideoDataList)) {
                l.L(this, i.net_error);
                finish();
                return;
            }
            VideoMiddleFragment videoMiddleFragment = new VideoMiddleFragment();
            this.mFragment = videoMiddleFragment;
            videoMiddleFragment.setActivityPageUniqueId(getUniqueId());
            this.mFragment.setArguments(getIntent().getExtras());
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.add(f.video_vertical_root, this.mFragment);
            beginTransaction.commitAllowingStateLoss();
            getSupportFragmentManager().executePendingTransactions();
        }
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
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            VideoMiddleFragment videoMiddleFragment = this.mFragment;
            if (videoMiddleFragment != null) {
                videoMiddleFragment.handleActivityResult(i2, i3, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !b.g().i("MainTabActivity")) {
                this.mIsFromSchema = true;
            }
            if (this.mIsFromSchema) {
                setIsAddSwipeBackLayout(false);
            }
            super.onCreate(bundle);
            BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(VideoPlayActivityConfig.KEY_FPS_VIDEO_HOME_PAGE);
            BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(VideoPlayActivityConfig.KEY_FPS_VIDEO_FRS_PAGE);
            this.mStartTime = System.currentTimeMillis();
            setContentView(g.video_play_activity);
            this.mNEGFeedBackManager = new a(getPageContext(), "client_videomiddle");
            initData();
            initFragment();
            addGlobalLayoutListener();
            adjustResizeForSoftInput();
            doEnterStatistic();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            a aVar = this.mNEGFeedBackManager;
            if (aVar != null) {
                aVar.h();
            }
            if (d.Y()) {
                b.a.r0.y0.a.i().d("6061002332-203360688");
            }
            if (d.Z()) {
                b.a.r0.y0.a.i().c("6061002410-390177882");
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048583, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                VideoMiddleFragment videoMiddleFragment = this.mFragment;
                if (videoMiddleFragment != null) {
                    if (videoMiddleFragment.handleBackPress()) {
                        return false;
                    }
                    this.mFragment.handleIndexMessage();
                }
                finish();
                return false;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            super.onKeyboardVisibilityChanged(z);
            if (Build.VERSION.SDK_INT < 16 || z || getActivity() == null || getActivity().getWindow() == null || getActivity().getWindow().getDecorView() == null || TbSingleton.getInstance().isNotchScreen(this) || TbSingleton.getInstance().isCutoutScreen(this)) {
                return;
            }
            getActivity().getWindow().getDecorView().setSystemUiVisibility(getActivity().getWindow().getDecorView().getSystemUiVisibility() | 4);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onPause();
            VideoMiddleFragment videoMiddleFragment = this.mFragment;
            if (videoMiddleFragment != null) {
                videoMiddleFragment.setPrimary(false);
                this.mFragment.setUserVisibleHint(false);
            }
            b.a.q0.a.d.y().E();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onResume();
            VideoMiddleFragment videoMiddleFragment = this.mFragment;
            if (videoMiddleFragment != null) {
                videoMiddleFragment.setPrimary(true);
                this.mFragment.setUserVisibleHint(true);
                b.a.q0.a.d.y().P(c.Z, this.mFragment.getMissionTid());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean shouldChangeStatusBarIconAndTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
