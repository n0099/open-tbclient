package com.baidu.tieba.videoplay;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentTransaction;
import c.a.d.f.p.m;
import c.a.s0.l4.c;
import c.a.s0.l4.d;
import c.a.s0.l4.e;
import c.a.s0.l4.f;
import c.a.s0.l4.g;
import c.a.s0.l4.i;
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
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.danmu.DanmuProgressManager;
import com.baidu.tieba.videoplay.fragment.VideoVerticalPageFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class VideoRecommentPlayActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FROM_VIDEO_PLAY = "nani_midpage";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isFinishExecuted;
    public ImageView mBackImage;
    public VideoVerticalPageFragment mFragment;
    public String mFrom;
    public boolean mIsFromSchema;
    public c.a.s0.k.a mNEGFeedBackManager;
    public String mNid;
    public CustomMessageListener mSuspendedViewAnimationListener;
    public List<VideoItemData> mVideoDataList;

    /* loaded from: classes12.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoRecommentPlayActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(VideoRecommentPlayActivity videoRecommentPlayActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoRecommentPlayActivity, Integer.valueOf(i2)};
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
            this.a.mBackImage.setAlpha(floatValue);
        }
    }

    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoRecommentPlayActivity f50511e;

        public b(VideoRecommentPlayActivity videoRecommentPlayActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoRecommentPlayActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50511e = videoRecommentPlayActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f50511e.finish();
            }
        }
    }

    public VideoRecommentPlayActivity() {
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
        this.mIsFromSchema = false;
        this.isFinishExecuted = false;
        this.mSuspendedViewAnimationListener = new a(this, 2921594);
    }

    private void doEnterStatistic() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
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

    private int getVideoCurrentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            if (isFromPersonalPage()) {
                return 6;
            }
            if (isFromVideoHotTopic()) {
                return 8;
            }
            return isFromPbVideo() ? 9 : 5;
        }
        return invokeV.intValue;
    }

    private void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.mVideoDataList = (List) getIntent().getSerializableExtra("video_list");
            this.mNid = getIntent().getStringExtra("key_nid");
        }
    }

    private void initFragment() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            if (ListUtils.isEmpty(this.mVideoDataList) && !ListUtils.isEmpty(VideoPlayActivityConfig.bigDataList)) {
                ArrayList arrayList = new ArrayList();
                this.mVideoDataList = arrayList;
                arrayList.addAll(VideoPlayActivityConfig.bigDataList);
            }
            if (ListUtils.isEmpty(this.mVideoDataList)) {
                m.L(this, i.net_error);
                finish();
                return;
            }
            VideoVerticalPageFragment videoVerticalPageFragment = new VideoVerticalPageFragment(getUniqueId(), null, 0, getVideoCurrentType());
            this.mFragment = videoVerticalPageFragment;
            videoVerticalPageFragment.setArguments(getIntent().getExtras());
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.add(f.video_vertical_root, this.mFragment);
            beginTransaction.commitAllowingStateLoss();
            getSupportFragmentManager().executePendingTransactions();
            ImageView imageView = new ImageView(getPageContext().getPageActivity());
            this.mBackImage = imageView;
            imageView.setOnClickListener(new b(this));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(UtilHelper.getDimenPixelSize(d.tbds104), UtilHelper.getDimenPixelSize(d.tbds104));
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(d.tbds120);
            layoutParams.leftMargin = UtilHelper.getDimenPixelSize(d.M_W_X007);
            addContentView(this.mBackImage, layoutParams);
        }
    }

    private boolean isFromPbVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) ? TextUtils.equals(this.mFrom, VideoRecommentPlayActivityConfig.FROM_PB_VIDEO_SCHEME) : invokeV.booleanValue;
    }

    private boolean isFromPersonalPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? TextUtils.equals(this.mFrom, VideoRecommentPlayActivityConfig.FROM_PERSONAL_PAGE) : invokeV.booleanValue;
    }

    private boolean isFromVideoHotTopic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? TextUtils.equals(this.mFrom, VideoRecommentPlayActivityConfig.FROM_VIDEO_HOT_TOPIC) : invokeV.booleanValue;
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.isFinishExecuted) {
            return;
        }
        this.isFinishExecuted = true;
        if (isFromPersonalPage() || isFromVideoHotTopic() || isFromPbVideo()) {
            OnActivityFinishListener.sendMessage(getPageContext(), (Object) null);
        }
        if (this.mIsFromSchema) {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        }
        super.finish();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            VideoVerticalPageFragment videoVerticalPageFragment = this.mFragment;
            if (videoVerticalPageFragment != null) {
                videoVerticalPageFragment.handleActivityResult(i2, i3, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            WebPManager.setPureDrawable(this.mBackImage, e.icon_pure_topbar_return40, c.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
            VideoVerticalPageFragment videoVerticalPageFragment = this.mFragment;
            if (videoVerticalPageFragment != null) {
                videoVerticalPageFragment.onChangeSkinType(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (configuration.orientation == 2) {
                this.mBackImage.setVisibility(8);
            } else {
                this.mBackImage.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            if (getIntent() != null) {
                if (getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !c.a.d.a.b.g().i("MainTabActivity")) {
                    this.mIsFromSchema = true;
                }
                this.mFrom = getIntent().getStringExtra("from");
            }
            if (this.mIsFromSchema) {
                setIsAddSwipeBackLayout(false);
            }
            super.onCreate(bundle);
            setContentView(g.video_play_activity);
            this.mNEGFeedBackManager = new c.a.s0.k.a(getPageContext(), "client_videomiddle");
            initData();
            initFragment();
            addNoAdjustSoftInputHeightListener();
            doEnterStatistic();
            registerListener(this.mSuspendedViewAnimationListener);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            DanmuProgressManager.f50527b.a().b();
            c.a.s0.k.a aVar = this.mNEGFeedBackManager;
            if (aVar != null) {
                aVar.h();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                VideoVerticalPageFragment videoVerticalPageFragment = this.mFragment;
                if (videoVerticalPageFragment != null) {
                    if (videoVerticalPageFragment.handleBackPress()) {
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
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onPause();
            VideoVerticalPageFragment videoVerticalPageFragment = this.mFragment;
            if (videoVerticalPageFragment != null) {
                videoVerticalPageFragment.setPrimary(false);
                this.mFragment.setUserVisibleHint(false);
            }
            c.a.r0.a.d.y().G();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
            VideoVerticalPageFragment videoVerticalPageFragment = this.mFragment;
            if (videoVerticalPageFragment != null) {
                videoVerticalPageFragment.setPrimary(true);
                this.mFragment.setUserVisibleHint(true);
                c.a.r0.a.d.y().R(c.a.r0.a.c.a0, this.mFragment.getMissionTid());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? "712" : (String) invokeV.objValue;
    }
}
