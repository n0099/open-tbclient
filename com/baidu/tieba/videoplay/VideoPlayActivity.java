package com.baidu.tieba.videoplay;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.fluency.BdTracesManager;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.dj;
import com.baidu.tieba.ej;
import com.baidu.tieba.n9;
import com.baidu.tieba.ql4;
import com.baidu.tieba.rl4;
import com.baidu.tieba.un5;
import com.baidu.tieba.vi5;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.danmu.DanmuProgressManager;
import com.baidu.tieba.videoplay.fragment.VideoMiddleFragment;
import com.baidu.tieba.wu6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class VideoPlayActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public boolean b;
    public List<VideoItemData> c;
    public VideoMiddleFragment d;
    public un5 e;
    public boolean f;
    public Rect g;
    public String h;

    public VideoPlayActivity() {
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
        this.b = false;
        this.f = false;
    }

    public final void M0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_ENTER_VIDEO_PAGE);
            if (TextUtils.isEmpty(this.a)) {
                statisticItem.param("obj_type", "1");
            } else {
                statisticItem.param("obj_type", "2");
                statisticItem.param("obj_id", this.a);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public Rect N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.g : (Rect) invokeV.objValue;
    }

    public String O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.h : (String) invokeV.objValue;
    }

    public final void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.c = (List) getIntent().getSerializableExtra("video_list");
            this.a = getIntent().getStringExtra("key_nid");
        }
    }

    public final void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (ListUtils.isEmpty(this.c) && !ListUtils.isEmpty(VideoPlayActivityConfig.bigDataList)) {
                ArrayList arrayList = new ArrayList();
                this.c = arrayList;
                arrayList.addAll(VideoPlayActivityConfig.bigDataList);
            }
            if (ListUtils.isEmpty(this.c)) {
                ej.M(this, R.string.net_error);
                finish();
                return;
            }
            List<VideoItemData> list = this.c;
            if (list != null && list.size() > 0 && this.c.get(0) != null) {
                this.h = this.c.get(0).thread_id;
            }
            if (getIntent() != null && !dj.isEmpty(VideoPlayActivityConfig.VIDEO_VIEW_RECT)) {
                this.g = (Rect) getIntent().getParcelableExtra(VideoPlayActivityConfig.VIDEO_VIEW_RECT);
            }
            VideoMiddleFragment videoMiddleFragment = new VideoMiddleFragment();
            this.d = videoMiddleFragment;
            videoMiddleFragment.R1(getUniqueId());
            this.d.setArguments(getIntent().getExtras());
            this.d.S1(this.c);
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.add(R.id.obfuscated_res_0x7f092594, this.d);
            beginTransaction.commitAllowingStateLoss();
            getSupportFragmentManager().executePendingTransactions();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.b) {
                sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
            if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                TbSingleton.getInstance().setIsJumpFromVideoMiddleView(true);
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, intent) == null) || vi5.c(i, i2, intent)) {
            return;
        }
        super.onActivityResult(i, i2, intent);
        VideoMiddleFragment videoMiddleFragment = this.d;
        if (videoMiddleFragment != null) {
            videoMiddleFragment.W0(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        VideoMiddleFragment videoMiddleFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i) == null) || (videoMiddleFragment = this.d) == null) {
            return;
        }
        videoMiddleFragment.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !n9.g().i("MainTabActivity")) {
                this.b = true;
            }
            if (this.b) {
                setIsAddSwipeBackLayout(false);
            }
            super.onCreate(bundle);
            BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(VideoPlayActivityConfig.KEY_FPS_VIDEO_HOME_PAGE);
            BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(VideoPlayActivityConfig.KEY_FPS_VIDEO_FRS_PAGE);
            setContentView(R.layout.obfuscated_res_0x7f0d08df);
            this.e = new un5(getPageContext(), "client_videomiddle");
            R0();
            S0();
            addNoAdjustSoftInputHeightListener();
            if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                setActivityBgTransparent();
            }
            M0();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDestroy();
            DanmuProgressManager.b.a().b();
            un5 un5Var = this.e;
            if (un5Var != null) {
                un5Var.h();
            }
            if (UbsABTestHelper.isVideoAdDrawABTestA()) {
                wu6.m().d("6061002332-203360688");
            }
            if (UbsABTestHelper.isVideoAdDrawABTestB()) {
                wu6.m().c(wu6.s());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048588, this, i, keyEvent)) == null) {
            if (i == 4) {
                VideoMiddleFragment videoMiddleFragment = this.d;
                if (videoMiddleFragment != null) {
                    if (videoMiddleFragment.h1()) {
                        return false;
                    }
                    this.d.y0();
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
            if (this.f != z) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921645, Boolean.valueOf(z)));
                this.f = z;
            }
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
            VideoMiddleFragment videoMiddleFragment = this.d;
            if (videoMiddleFragment != null) {
                videoMiddleFragment.setPrimary(false);
                this.d.setUserVisibleHint(false);
            }
            rl4.w().E();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onResume();
            VideoMiddleFragment videoMiddleFragment = this.d;
            if (videoMiddleFragment != null) {
                videoMiddleFragment.setPrimary(true);
                this.d.setUserVisibleHint(true);
                rl4.w().P(ql4.c0, this.d.E0());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void setIsAddSwipeBackLayout(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || this.mSwipeBackLayout == null) {
            return;
        }
        if (this.b) {
            super.setIsAddSwipeBackLayout(false);
            this.mSwipeBackLayout.setSwipeBackEnabled(false);
        } else {
            super.setIsAddSwipeBackLayout(z);
            this.mSwipeBackLayout.setSwipeBackEnabled(z);
        }
        if (TbadkCoreApplication.IS_SUPPORT_SWIPEBACK) {
            return;
        }
        this.mSwipeBackLayout.setSwipeBackEnabled(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean shouldChangeStatusBarIconAndTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? "712" : (String) invokeV.objValue;
    }
}
