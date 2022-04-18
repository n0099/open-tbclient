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
import com.repackage.ni4;
import com.repackage.oi;
import com.repackage.oi4;
import com.repackage.sh5;
import com.repackage.x8;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class VideoRecommentPlayActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FROM_VIDEO_PLAY = "nani_midpage";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isFinishExecuted;
    public ImageView mBackImage;
    public VideoVerticalPageFragment mFragment;
    public String mFrom;
    public boolean mIsFromSchema;
    public sh5 mNEGFeedBackManager;
    public String mNid;
    public CustomMessageListener mSuspendedViewAnimationListener;
    public List<VideoItemData> mVideoDataList;

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
            this.a.mBackImage.setAlpha(floatValue);
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

    private void doPageFromStatistic() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_FROM_OUTSIDE);
            if (!ListUtils.isEmpty(this.mVideoDataList)) {
                VideoItemData videoItemData = this.mVideoDataList.get(0);
                statisticItem.param("tid", videoItemData == null ? "" : videoItemData.thread_id);
            }
            if (isFromAtPage()) {
                statisticItem.param("obj_source", 6);
            } else if (isFromAgreePage()) {
                statisticItem.param("obj_source", 7);
            } else if (isFromReplyPage()) {
                statisticItem.param("obj_source", 8);
            } else if (isFromLink()) {
                statisticItem.param("obj_source", 9);
            } else if (isFromCreateCenter()) {
                statisticItem.param("obj_source", 10);
            } else if (isFromWorkManagement()) {
                statisticItem.param("obj_source", 11);
            } else if (isFromOfficalVideo()) {
                statisticItem.param("obj_source", 12);
            } else if (VideoRecommentPlayActivityConfig.FROM_MY_THREADS.equals(this.mFrom)) {
                statisticItem.param("obj_source", 13);
            } else if (VideoRecommentPlayActivityConfig.FROM_COLLECTION.equals(this.mFrom)) {
                statisticItem.param("obj_source", 14);
            } else if (VideoRecommentPlayActivityConfig.FROM_HISTORY.equals(this.mFrom)) {
                statisticItem.param("obj_source", 15);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    private int getVideoCurrentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (isFromPersonalPage()) {
                return 6;
            }
            if (isFromVideoHotTopic()) {
                return 8;
            }
            if (isFromPbVideo()) {
                return 9;
            }
            if (isFromAtPage()) {
                return 10;
            }
            if (isFromAgreePage()) {
                return 11;
            }
            if (isFromReplyPage()) {
                return 12;
            }
            if (isFromLink()) {
                return 13;
            }
            if (isFromCreateCenter()) {
                return 18;
            }
            if (isFromWorkManagement()) {
                return 19;
            }
            if (isFromOfficalVideo()) {
                return 14;
            }
            if (isFromMyThread()) {
                return 15;
            }
            if (isFromCollection()) {
                return 16;
            }
            return isFromHistory() ? 17 : 5;
        }
        return invokeV.intValue;
    }

    private void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.mVideoDataList = (List) getIntent().getSerializableExtra("video_list");
            this.mNid = getIntent().getStringExtra("key_nid");
        }
    }

    private void initFragment() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            if (ListUtils.isEmpty(this.mVideoDataList) && !ListUtils.isEmpty(VideoPlayActivityConfig.bigDataList)) {
                ArrayList arrayList = new ArrayList();
                this.mVideoDataList = arrayList;
                arrayList.addAll(VideoPlayActivityConfig.bigDataList);
            }
            if (ListUtils.isEmpty(this.mVideoDataList)) {
                oi.M(this, R.string.obfuscated_res_0x7f0f0c14);
                finish();
                return;
            }
            VideoVerticalPageFragment videoVerticalPageFragment = new VideoVerticalPageFragment(getUniqueId(), null, 0, getVideoCurrentType());
            this.mFragment = videoVerticalPageFragment;
            videoVerticalPageFragment.setArguments(getIntent().getExtras());
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.add(R.id.obfuscated_res_0x7f09237a, this.mFragment);
            beginTransaction.commitAllowingStateLoss();
            getSupportFragmentManager().executePendingTransactions();
            ImageView imageView = new ImageView(getPageContext().getPageActivity());
            this.mBackImage = imageView;
            imageView.setOnClickListener(new b(this));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.tbds104), UtilHelper.getDimenPixelSize(R.dimen.tbds104));
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
            layoutParams.leftMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
            addContentView(this.mBackImage, layoutParams);
        }
    }

    private boolean isFromAgreePage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? TextUtils.equals(this.mFrom, VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE) : invokeV.booleanValue;
    }

    private boolean isFromAtPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? TextUtils.equals(this.mFrom, VideoRecommentPlayActivityConfig.FROM_AT_PAGE) : invokeV.booleanValue;
    }

    private boolean isFromCollection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) ? TextUtils.equals(this.mFrom, VideoRecommentPlayActivityConfig.FROM_COLLECTION) : invokeV.booleanValue;
    }

    private boolean isFromCreateCenter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? TextUtils.equals(this.mFrom, VideoRecommentPlayActivityConfig.FROM_CREATE_CENTER) : invokeV.booleanValue;
    }

    private boolean isFromHistory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) ? TextUtils.equals(this.mFrom, VideoRecommentPlayActivityConfig.FROM_HISTORY) : invokeV.booleanValue;
    }

    private boolean isFromLink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) ? TextUtils.equals(this.mFrom, VideoRecommentPlayActivityConfig.FROM_LINK_PAGE) : invokeV.booleanValue;
    }

    private boolean isFromMyThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) ? TextUtils.equals(this.mFrom, VideoRecommentPlayActivityConfig.FROM_MY_THREADS) : invokeV.booleanValue;
    }

    private boolean isFromOfficalVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) ? TextUtils.equals(this.mFrom, VideoRecommentPlayActivityConfig.FROM_OFFICAL_VIDEO) : invokeV.booleanValue;
    }

    private boolean isFromPbVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) ? TextUtils.equals(this.mFrom, VideoRecommentPlayActivityConfig.FROM_PB_VIDEO_SCHEME) : invokeV.booleanValue;
    }

    private boolean isFromPersonalPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) ? TextUtils.equals(this.mFrom, VideoRecommentPlayActivityConfig.FROM_PERSONAL_PAGE) : invokeV.booleanValue;
    }

    private boolean isFromReplyPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) ? TextUtils.equals(this.mFrom, VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE) : invokeV.booleanValue;
    }

    private boolean isFromVideoHotTopic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) ? TextUtils.equals(this.mFrom, VideoRecommentPlayActivityConfig.FROM_VIDEO_HOT_TOPIC) : invokeV.booleanValue;
    }

    private boolean isFromWorkManagement() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) ? TextUtils.equals(this.mFrom, VideoRecommentPlayActivityConfig.FROM_WORK_MANAGEMENT) : invokeV.booleanValue;
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
        if (isFromPersonalPage() || isFromVideoHotTopic() || isFromPbVideo() || isFromAtPage() || isFromAgreePage() || isFromReplyPage() || isFromLink() || isFromCreateCenter() || isFromWorkManagement() || isFromOfficalVideo() || isFromMyThread() || isFromCollection() || isFromHistory()) {
            OnActivityFinishListener.l(getPageContext(), null);
        }
        if (this.mIsFromSchema) {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        }
        super.finish();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            VideoVerticalPageFragment videoVerticalPageFragment = this.mFragment;
            if (videoVerticalPageFragment != null) {
                videoVerticalPageFragment.m0(i, i2, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            WebPManager.setPureDrawable(this.mBackImage, R.drawable.obfuscated_res_0x7f0809c7, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
            VideoVerticalPageFragment videoVerticalPageFragment = this.mFragment;
            if (videoVerticalPageFragment != null) {
                videoVerticalPageFragment.onChangeSkinType(i);
            }
            UtilHelper.changeStatusBarIconAndTextColor(true, this);
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
                if (getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !x8.f().h("MainTabActivity")) {
                    this.mIsFromSchema = true;
                }
                this.mFrom = getIntent().getStringExtra("from");
            }
            if (this.mIsFromSchema) {
                setIsAddSwipeBackLayout(false);
            }
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0883);
            this.mNEGFeedBackManager = new sh5(getPageContext(), "client_videomiddle");
            initData();
            initFragment();
            addNoAdjustSoftInputHeightListener();
            if (!isFromPersonalPage() && !isFromVideoHotTopic() && !isFromPbVideo() && !isFromAtPage() && !isFromAgreePage() && !isFromReplyPage() && !isFromLink() && !isFromCreateCenter() && !isFromWorkManagement() && !isFromOfficalVideo() && !isFromMyThread() && !isFromCollection() && !isFromHistory() && getWindow() != null) {
                getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.CAM_X0611)));
            }
            doEnterStatistic();
            doPageFromStatistic();
            registerListener(this.mSuspendedViewAnimationListener);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            DanmuProgressManager.b.a().b();
            sh5 sh5Var = this.mNEGFeedBackManager;
            if (sh5Var != null) {
                sh5Var.h();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, keyEvent)) == null) {
            if (i == 4) {
                VideoVerticalPageFragment videoVerticalPageFragment = this.mFragment;
                if (videoVerticalPageFragment != null) {
                    if (videoVerticalPageFragment.u0()) {
                        return false;
                    }
                    this.mFragment.T();
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
            oi4.y().G();
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
                oi4.y().R(ni4.a0, this.mFragment.X());
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
