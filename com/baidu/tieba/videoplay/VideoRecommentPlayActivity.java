package com.baidu.tieba.videoplay;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.util.OnActivityFinishListener;
import com.baidu.tieba.R;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.danmu.DanmuProgressManager;
import com.baidu.tieba.videoplay.fragment.VideoVerticalPageFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cj4;
import com.repackage.dj4;
import com.repackage.qi;
import com.repackage.sk5;
import com.repackage.z8;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class VideoRecommentPlayActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public boolean c;
    public List<VideoItemData> d;
    public VideoVerticalPageFragment e;
    public ImageView f;
    public sk5 g;
    public boolean h;
    public CustomMessageListener i;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoRecommentPlayActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(VideoRecommentPlayActivity videoRecommentPlayActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoRecommentPlayActivity, Integer.valueOf(i)};
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
            this.a = videoRecommentPlayActivity;
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
            this.a.f.setAlpha(floatValue);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoRecommentPlayActivity a;

        public b(VideoRecommentPlayActivity videoRecommentPlayActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoRecommentPlayActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoRecommentPlayActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.finish();
            }
        }
    }

    public VideoRecommentPlayActivity() {
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
        this.c = false;
        this.h = false;
        this.i = new a(this, 2921594);
    }

    public final void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_ENTER_VIDEO_PAGE);
            if (TextUtils.isEmpty(this.b)) {
                statisticItem.param("obj_type", "1");
            } else {
                statisticItem.param("obj_type", "2");
                statisticItem.param("obj_id", this.b);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_FROM_OUTSIDE);
            if (!ListUtils.isEmpty(this.d)) {
                VideoItemData videoItemData = this.d.get(0);
                statisticItem.param("tid", videoItemData == null ? "" : videoItemData.thread_id);
            }
            if (N0()) {
                statisticItem.param("obj_source", 6);
            } else if (M0()) {
                statisticItem.param("obj_source", 7);
            } else if (a1()) {
                statisticItem.param("obj_source", 8);
            } else if (T0()) {
                statisticItem.param("obj_source", 9);
            } else if (P0()) {
                statisticItem.param("obj_source", 10);
            } else if (c1()) {
                statisticItem.param("obj_source", 11);
            } else if (V0()) {
                statisticItem.param("obj_source", 12);
            } else if (VideoRecommentPlayActivityConfig.FROM_MY_THREADS.equals(this.a)) {
                statisticItem.param("obj_source", 13);
            } else if (VideoRecommentPlayActivityConfig.FROM_COLLECTION.equals(this.a)) {
                statisticItem.param("obj_source", 14);
            } else if (VideoRecommentPlayActivityConfig.FROM_HISTORY.equals(this.a)) {
                statisticItem.param("obj_source", 15);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final int G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (Z0()) {
                return 6;
            }
            if (b1()) {
                return 8;
            }
            if (W0()) {
                return 9;
            }
            if (N0()) {
                return 10;
            }
            if (M0()) {
                return 11;
            }
            if (a1()) {
                return 12;
            }
            if (T0()) {
                return 13;
            }
            if (P0()) {
                return 18;
            }
            if (c1()) {
                return 19;
            }
            if (V0()) {
                return 14;
            }
            if (U0()) {
                return 15;
            }
            if (O0()) {
                return 16;
            }
            return S0() ? 17 : 5;
        }
        return invokeV.intValue;
    }

    public final void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.d = (List) getIntent().getSerializableExtra("video_list");
            this.b = getIntent().getStringExtra("key_nid");
        }
    }

    public final void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (ListUtils.isEmpty(this.d) && !ListUtils.isEmpty(VideoPlayActivityConfig.bigDataList)) {
                ArrayList arrayList = new ArrayList();
                this.d = arrayList;
                arrayList.addAll(VideoPlayActivityConfig.bigDataList);
            }
            if (ListUtils.isEmpty(this.d)) {
                qi.N(this, R.string.obfuscated_res_0x7f0f0c39);
                finish();
                return;
            }
            VideoVerticalPageFragment videoVerticalPageFragment = new VideoVerticalPageFragment(getUniqueId(), null, 0, G0());
            this.e = videoVerticalPageFragment;
            videoVerticalPageFragment.setArguments(getIntent().getExtras());
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.add(R.id.obfuscated_res_0x7f09252a, this.e);
            beginTransaction.commitAllowingStateLoss();
            getSupportFragmentManager().executePendingTransactions();
            ImageView imageView = new ImageView(getPageContext().getPageActivity());
            this.f = imageView;
            imageView.setOnClickListener(new b(this));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.tbds104), UtilHelper.getDimenPixelSize(R.dimen.tbds104));
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
            layoutParams.leftMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
            addContentView(this.f, layoutParams);
        }
    }

    public final boolean M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? TextUtils.equals(this.a, VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE) : invokeV.booleanValue;
    }

    public final boolean N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? TextUtils.equals(this.a, VideoRecommentPlayActivityConfig.FROM_AT_PAGE) : invokeV.booleanValue;
    }

    public final boolean O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? TextUtils.equals(this.a, VideoRecommentPlayActivityConfig.FROM_COLLECTION) : invokeV.booleanValue;
    }

    public final boolean P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? TextUtils.equals(this.a, VideoRecommentPlayActivityConfig.FROM_CREATE_CENTER) : invokeV.booleanValue;
    }

    public final boolean S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? TextUtils.equals(this.a, VideoRecommentPlayActivityConfig.FROM_HISTORY) : invokeV.booleanValue;
    }

    public final boolean T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? TextUtils.equals(this.a, VideoRecommentPlayActivityConfig.FROM_LINK_PAGE) : invokeV.booleanValue;
    }

    public final boolean U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? TextUtils.equals(this.a, VideoRecommentPlayActivityConfig.FROM_MY_THREADS) : invokeV.booleanValue;
    }

    public final boolean V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? TextUtils.equals(this.a, VideoRecommentPlayActivityConfig.FROM_OFFICAL_VIDEO) : invokeV.booleanValue;
    }

    public final boolean W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? TextUtils.equals(this.a, VideoRecommentPlayActivityConfig.FROM_PB_VIDEO_SCHEME) : invokeV.booleanValue;
    }

    public final boolean Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? TextUtils.equals(this.a, VideoRecommentPlayActivityConfig.FROM_PERSONAL_PAGE) : invokeV.booleanValue;
    }

    public final boolean a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? TextUtils.equals(this.a, VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE) : invokeV.booleanValue;
    }

    public final boolean b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? TextUtils.equals(this.a, VideoRecommentPlayActivityConfig.FROM_VIDEO_HOT_TOPIC) : invokeV.booleanValue;
    }

    public final boolean c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? TextUtils.equals(this.a, VideoRecommentPlayActivityConfig.FROM_WORK_MANAGEMENT) : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || this.h) {
            return;
        }
        this.h = true;
        if (Z0() || b1() || W0() || N0() || M0() || a1() || T0() || P0() || c1() || V0() || U0() || O0() || S0()) {
            OnActivityFinishListener.k(getPageContext(), null);
        }
        if (this.c) {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        }
        super.finish();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048597, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            VideoVerticalPageFragment videoVerticalPageFragment = this.e;
            if (videoVerticalPageFragment != null) {
                videoVerticalPageFragment.Z0(i, i2, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            WebPManager.setPureDrawable(this.f, R.drawable.obfuscated_res_0x7f080a01, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
            VideoVerticalPageFragment videoVerticalPageFragment = this.e;
            if (videoVerticalPageFragment != null) {
                videoVerticalPageFragment.onChangeSkinType(i);
            }
            UtilHelper.changeStatusBarIconAndTextColor(true, this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (configuration.orientation == 2) {
                this.f.setVisibility(8);
            } else {
                this.f.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bundle) == null) {
            if (getIntent() != null) {
                if (getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !z8.g().i("MainTabActivity")) {
                    this.c = true;
                }
                this.a = getIntent().getStringExtra("from");
            }
            if (this.c) {
                setIsAddSwipeBackLayout(false);
            }
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d08be);
            this.g = new sk5(getPageContext(), "client_videomiddle");
            K0();
            L0();
            addNoAdjustSoftInputHeightListener();
            if (!Z0() && !b1() && !W0() && !N0() && !M0() && !a1() && !T0() && !P0() && !c1() && !V0() && !U0() && !O0() && !S0() && getWindow() != null) {
                getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.CAM_X0611)));
            }
            E0();
            F0();
            registerListener(this.i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onDestroy();
            DanmuProgressManager.b.a().b();
            sk5 sk5Var = this.g;
            if (sk5Var != null) {
                sk5Var.h();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048602, this, i, keyEvent)) == null) {
            if (i == 4) {
                VideoVerticalPageFragment videoVerticalPageFragment = this.e;
                if (videoVerticalPageFragment != null) {
                    if (videoVerticalPageFragment.i1()) {
                        return false;
                    }
                    this.e.B0();
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
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onPause();
            VideoVerticalPageFragment videoVerticalPageFragment = this.e;
            if (videoVerticalPageFragment != null) {
                videoVerticalPageFragment.setPrimary(false);
                this.e.setUserVisibleHint(false);
            }
            dj4.w().E();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.onResume();
            VideoVerticalPageFragment videoVerticalPageFragment = this.e;
            if (videoVerticalPageFragment != null) {
                videoVerticalPageFragment.setPrimary(true);
                this.e.setUserVisibleHint(true);
                dj4.w().P(cj4.c0, this.e.F0());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? "712" : (String) invokeV.objValue;
    }
}
