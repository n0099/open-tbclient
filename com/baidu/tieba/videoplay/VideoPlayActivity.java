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
import com.baidu.tieba.du4;
import com.baidu.tieba.eu4;
import com.baidu.tieba.g46;
import com.baidu.tieba.g9;
import com.baidu.tieba.hy5;
import com.baidu.tieba.jp6;
import com.baidu.tieba.ss7;
import com.baidu.tieba.ui;
import com.baidu.tieba.vi;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.danmu.DanmuProgressManager;
import com.baidu.tieba.videoplay.fragment.VideoMiddleFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class VideoPlayActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public boolean b;
    public List<VideoItemData> c;
    public VideoMiddleFragment d;
    public g46 e;
    public boolean f;
    public Rect g;
    public String h;

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean shouldChangeStatusBarIconAndTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? "712" : (String) invokeV.objValue;
    }

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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            DanmuProgressManager.b.a().b();
            g46 g46Var = this.e;
            if (g46Var != null) {
                g46Var.h();
            }
            ss7.m().c(ss7.s());
            jp6.a();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onPause();
            VideoMiddleFragment videoMiddleFragment = this.d;
            if (videoMiddleFragment != null) {
                videoMiddleFragment.setPrimary(false);
                this.d.setUserVisibleHint(false);
            }
            eu4.w().E();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onResume();
            VideoMiddleFragment videoMiddleFragment = this.d;
            if (videoMiddleFragment != null) {
                videoMiddleFragment.setPrimary(true);
                this.d.setUserVisibleHint(true);
                eu4.w().Q(du4.c0, this.d.m());
            }
        }
    }

    public Rect u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.g;
        }
        return (Rect) invokeV.objValue;
    }

    public String v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public final void w1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.c = (List) getIntent().getSerializableExtra("video_list");
            this.a = getIntent().getStringExtra("key_nid");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.b) {
                sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
            if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                TbSingleton.getInstance().setIsJumpFromVideoMiddleView(true);
            }
            super.finish();
        }
    }

    public final void t1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIIL(1048579, this, i, i2, intent) != null) || hy5.c(i, i2, intent)) {
            return;
        }
        super.onActivityResult(i, i2, intent);
        VideoMiddleFragment videoMiddleFragment = this.d;
        if (videoMiddleFragment != null) {
            videoMiddleFragment.p(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        VideoMiddleFragment videoMiddleFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && (videoMiddleFragment = this.d) != null) {
            videoMiddleFragment.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !g9.f().h("MainTabActivity")) {
                this.b = true;
            }
            if (this.b) {
                setIsAddSwipeBackLayout(false);
            }
            super.onCreate(bundle);
            BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(VideoPlayActivityConfig.KEY_FPS_VIDEO_HOME_PAGE);
            BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(VideoPlayActivityConfig.KEY_FPS_VIDEO_FRS_PAGE);
            setContentView(R.layout.obfuscated_res_0x7f0d09aa);
            this.e = new g46(getPageContext(), "client_videomiddle");
            w1();
            x1();
            addNoAdjustSoftInputHeightListener();
            if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                setActivityBgTransparent();
            }
            t1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            super.onKeyboardVisibilityChanged(z);
            if (this.f != z) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921645, Boolean.valueOf(z)));
                this.f = z;
            }
            if (Build.VERSION.SDK_INT >= 16 && !z && getActivity() != null && getActivity().getWindow() != null && getActivity().getWindow().getDecorView() != null && !TbSingleton.getInstance().isNotchScreen(this) && !TbSingleton.getInstance().isCutoutScreen(this)) {
                getActivity().getWindow().getDecorView().setSystemUiVisibility(getActivity().getWindow().getDecorView().getSystemUiVisibility() | 4);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048583, this, i, keyEvent)) == null) {
            if (i == 4) {
                VideoMiddleFragment videoMiddleFragment = this.d;
                if (videoMiddleFragment != null) {
                    if (videoMiddleFragment.r()) {
                        return false;
                    }
                    this.d.L0();
                }
                finish();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void setIsAddSwipeBackLayout(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048587, this, z) != null) || this.mSwipeBackLayout == null) {
            return;
        }
        if (this.b) {
            super.setIsAddSwipeBackLayout(false);
            this.mSwipeBackLayout.setSwipeBackEnabled(false);
        } else {
            super.setIsAddSwipeBackLayout(z);
            this.mSwipeBackLayout.setSwipeBackEnabled(z);
        }
        if (!TbadkCoreApplication.IS_SUPPORT_SWIPEBACK) {
            this.mSwipeBackLayout.setSwipeBackEnabled(false);
        }
    }

    public final void x1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (ListUtils.isEmpty(this.c) && !ListUtils.isEmpty(VideoPlayActivityConfig.bigDataList)) {
                ArrayList arrayList = new ArrayList();
                this.c = arrayList;
                arrayList.addAll(VideoPlayActivityConfig.bigDataList);
            }
            if (ListUtils.isEmpty(this.c)) {
                vi.P(this, R.string.obfuscated_res_0x7f0f0dec);
                finish();
                return;
            }
            List<VideoItemData> list = this.c;
            if (list != null && list.size() > 0 && this.c.get(0) != null) {
                this.h = this.c.get(0).thread_id;
            }
            if (getIntent() != null && !ui.isEmpty(VideoPlayActivityConfig.VIDEO_VIEW_RECT)) {
                this.g = (Rect) getIntent().getParcelableExtra(VideoPlayActivityConfig.VIDEO_VIEW_RECT);
            }
            VideoMiddleFragment videoMiddleFragment = new VideoMiddleFragment();
            this.d = videoMiddleFragment;
            videoMiddleFragment.Y1(getUniqueId());
            this.d.setArguments(getIntent().getExtras());
            this.d.Z1(this.c);
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.add(R.id.obfuscated_res_0x7f092859, this.d);
            beginTransaction.commitAllowingStateLoss();
            getSupportFragmentManager().executePendingTransactions();
        }
    }
}
