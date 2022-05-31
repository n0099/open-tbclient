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
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.danmu.DanmuProgressManager;
import com.baidu.tieba.videoplay.fragment.VideoMiddleFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dd5;
import com.repackage.fh5;
import com.repackage.ki;
import com.repackage.kp6;
import com.repackage.lh4;
import com.repackage.li;
import com.repackage.mh4;
import com.repackage.x8;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class VideoPlayActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FROM_VIDEO_PLAY = "nani_midpage";
    public transient /* synthetic */ FieldHolder $fh;
    public VideoMiddleFragment mFragment;
    public boolean mIsFromSchema;
    public boolean mLastKeyBoardVisible;
    public fh5 mNEGFeedBackManager;
    public String mNid;
    public Rect mRect;
    public String mTid;
    public List<VideoItemData> mVideoDataList;

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
        this.mIsFromSchema = false;
        this.mLastKeyBoardVisible = false;
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
                li.N(this, R.string.obfuscated_res_0x7f0f0c30);
                finish();
                return;
            }
            List<VideoItemData> list = this.mVideoDataList;
            if (list != null && list.size() > 0 && this.mVideoDataList.get(0) != null) {
                this.mTid = this.mVideoDataList.get(0).thread_id;
            }
            if (getIntent() != null && !ki.isEmpty(VideoPlayActivityConfig.VIDEO_VIEW_RECT)) {
                this.mRect = (Rect) getIntent().getParcelableExtra(VideoPlayActivityConfig.VIDEO_VIEW_RECT);
            }
            VideoMiddleFragment videoMiddleFragment = new VideoMiddleFragment();
            this.mFragment = videoMiddleFragment;
            videoMiddleFragment.b1(getUniqueId());
            this.mFragment.setArguments(getIntent().getExtras());
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.add(R.id.obfuscated_res_0x7f092371, this.mFragment);
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
            if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                TbSingleton.getInstance().setIsJumpFromVideoMiddleView(true);
            }
            super.finish();
        }
    }

    public Rect getStartCardRect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mRect : (Rect) invokeV.objValue;
    }

    public String getStartCardTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mTid : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048581, this, i, i2, intent) == null) || dd5.c(i, i2, intent)) {
            return;
        }
        super.onActivityResult(i, i2, intent);
        VideoMiddleFragment videoMiddleFragment = this.mFragment;
        if (videoMiddleFragment != null) {
            videoMiddleFragment.o0(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        VideoMiddleFragment videoMiddleFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i) == null) || (videoMiddleFragment = this.mFragment) == null) {
            return;
        }
        videoMiddleFragment.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !x8.g().i("MainTabActivity")) {
                this.mIsFromSchema = true;
            }
            if (this.mIsFromSchema) {
                setIsAddSwipeBackLayout(false);
            }
            super.onCreate(bundle);
            BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(VideoPlayActivityConfig.KEY_FPS_VIDEO_HOME_PAGE);
            BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(VideoPlayActivityConfig.KEY_FPS_VIDEO_FRS_PAGE);
            setContentView(R.layout.obfuscated_res_0x7f0d086c);
            this.mNEGFeedBackManager = new fh5(getPageContext(), "client_videomiddle");
            initData();
            initFragment();
            addNoAdjustSoftInputHeightListener();
            if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                setActivityBgTransparent();
            }
            doEnterStatistic();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDestroy();
            DanmuProgressManager.b.a().b();
            fh5 fh5Var = this.mNEGFeedBackManager;
            if (fh5Var != null) {
                fh5Var.h();
            }
            if (UbsABTestHelper.isVideoAdDrawABTestA()) {
                kp6.j().d("6061002332-203360688");
            }
            if (UbsABTestHelper.isVideoAdDrawABTestB()) {
                kp6.j().c("6061002410-390177882");
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i, keyEvent)) == null) {
            if (i == 4) {
                VideoMiddleFragment videoMiddleFragment = this.mFragment;
                if (videoMiddleFragment != null) {
                    if (videoMiddleFragment.w0()) {
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
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            super.onKeyboardVisibilityChanged(z);
            if (this.mLastKeyBoardVisible != z) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921645, Boolean.valueOf(z)));
                this.mLastKeyBoardVisible = z;
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
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onPause();
            VideoMiddleFragment videoMiddleFragment = this.mFragment;
            if (videoMiddleFragment != null) {
                videoMiddleFragment.setPrimary(false);
                this.mFragment.setUserVisibleHint(false);
            }
            mh4.x().F();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onResume();
            VideoMiddleFragment videoMiddleFragment = this.mFragment;
            if (videoMiddleFragment != null) {
                videoMiddleFragment.setPrimary(true);
                this.mFragment.setUserVisibleHint(true);
                mh4.x().Q(lh4.a0, this.mFragment.Y());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean shouldChangeStatusBarIconAndTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
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
}
