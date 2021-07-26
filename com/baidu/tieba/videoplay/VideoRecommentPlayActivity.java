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
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.fragment.VideoVerticalPageFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.p0.a.c;
import d.a.p0.a.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class VideoRecommentPlayActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FROM_VIDEO_PLAY = "nani_midpage";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isFromBjhPb;
    public ImageView mBackImage;
    public VideoVerticalPageFragment mFragment;
    public String mFrom;
    public String mFromPage;
    public boolean mIsFromSchema;
    public d.a.q0.h.a mNEGFeedBackManager;
    public String mNid;
    public String mSourceFrom;
    public long mStartTime;
    public CustomMessageListener mSuspendedViewAnimationListener;
    public List<VideoItemData> mVideoDataList;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoRecommentPlayActivity f21993a;

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
            this.f21993a = videoRecommentPlayActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUniqueId tag;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getOrginalMessage() == null || (tag = customResponsedMessage.getOrginalMessage().getTag()) == null || this.f21993a.getUniqueId().getId() != tag.getId() || !(customResponsedMessage.getData() instanceof Float)) {
                return;
            }
            float floatValue = ((Float) customResponsedMessage.getData()).floatValue();
            if (floatValue < 0.0f || floatValue > 1.0f) {
                return;
            }
            this.f21993a.mBackImage.setAlpha(floatValue);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoRecommentPlayActivity f21994e;

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
            this.f21994e = videoRecommentPlayActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21994e.finish();
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
        this.mStartTime = 0L;
        this.mIsFromSchema = false;
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

    private void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            if (ListUtils.isEmpty(this.mVideoDataList) && !ListUtils.isEmpty(VideoPlayActivityConfig.bigDataList)) {
                ArrayList arrayList = new ArrayList();
                this.mVideoDataList = arrayList;
                arrayList.addAll(VideoPlayActivityConfig.bigDataList);
            }
            if (ListUtils.isEmpty(this.mVideoDataList)) {
                l.L(this, R.string.net_error);
                finish();
                return;
            }
            VideoVerticalPageFragment videoVerticalPageFragment = new VideoVerticalPageFragment(getUniqueId(), null, 0, 5);
            this.mFragment = videoVerticalPageFragment;
            videoVerticalPageFragment.setArguments(getIntent().getExtras());
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.add(R.id.video_vertical_root, this.mFragment);
            beginTransaction.commitAllowingStateLoss();
            getSupportFragmentManager().executePendingTransactions();
            ImageView imageView = new ImageView(getPageContext().getPageActivity());
            this.mBackImage = imageView;
            imageView.setOnClickListener(new b(this));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.tbds104), UtilHelper.getDimenPixelSize(R.dimen.tbds104));
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds59);
            layoutParams.leftMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            addContentView(this.mBackImage, layoutParams);
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
            VideoVerticalPageFragment videoVerticalPageFragment = this.mFragment;
            if (videoVerticalPageFragment != null) {
                videoVerticalPageFragment.r0(i2, i3, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            WebPManager.setPureDrawable(this.mBackImage, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
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
            if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !d.a.d.a.b.f().h("MainTabActivity")) {
                this.mIsFromSchema = true;
            }
            if (this.mIsFromSchema) {
                setIsAddSwipeBackLayout(false);
            }
            super.onCreate(bundle);
            this.mStartTime = System.currentTimeMillis();
            setContentView(R.layout.video_play_activity);
            this.mNEGFeedBackManager = new d.a.q0.h.a(getPageContext(), "client_videomiddle");
            initData();
            initFragment();
            addGlobalLayoutListener();
            adjustResizeForSoftInput();
            doEnterStatistic();
            registerListener(this.mSuspendedViewAnimationListener);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            d.a.q0.h.a aVar = this.mNEGFeedBackManager;
            if (aVar != null) {
                aVar.h();
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
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                VideoVerticalPageFragment videoVerticalPageFragment = this.mFragment;
                if (videoVerticalPageFragment != null) {
                    if (videoVerticalPageFragment.E0()) {
                        return false;
                    }
                    this.mFragment.Z();
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
            d.y().E();
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
                d.y().P(c.Z, this.mFragment.d0());
            }
        }
    }
}
