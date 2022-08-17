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
import com.repackage.cj4;
import com.repackage.dj4;
import com.repackage.ms4;
import com.repackage.pi;
import com.repackage.qi;
import com.repackage.sk5;
import com.repackage.z8;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsVideoTabPlayActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public long d;
    public boolean e;
    public String f;
    public String g;
    public String h;
    public Rect i;
    public String j;
    public View k;
    public int l;
    public boolean m;
    public List<VideoItemData> n;
    public VideoVerticalPageFragment o;
    public NavigationBar p;
    public TextView q;
    public sk5 r;
    public CustomMessageListener s;
    public CustomMessageListener t;

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
            this.a.p.setAlpha(floatValue);
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            if (customResponsedMessage.getData() instanceof Boolean ? ((Boolean) customResponsedMessage.getData()).booleanValue() : true) {
                this.a.getActivity().getWindow().setBackgroundDrawable(new ColorDrawable(this.a.getResources().getColor(R.color.CAM_X0611)));
                if (this.a.q != null) {
                    this.a.q.setVisibility(0);
                }
                if (this.a.k != null) {
                    this.a.k.setVisibility(0);
                    return;
                }
                return;
            }
            this.a.getActivity().getWindow().setBackgroundDrawable(null);
            if (this.a.q != null) {
                this.a.q.setVisibility(8);
            }
            if (this.a.k != null) {
                this.a.k.setVisibility(8);
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
        this.d = 0L;
        this.m = false;
        this.s = new a(this, 2921594);
        this.t = new b(this, 2921665);
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_ENTER_VIDEO_PAGE);
            if (TextUtils.isEmpty(this.f)) {
                statisticItem.param("obj_type", "1");
                statisticItem.param("obj_source", "4");
                statisticItem.param("fid", this.g);
                statisticItem.param("fname", this.h);
            } else {
                statisticItem.param("obj_type", "2");
                statisticItem.param("obj_id", this.f);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public Rect K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.i : (Rect) invokeV.objValue;
    }

    public String L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    public final int M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? S0() ? 20 : 7 : invokeV.intValue;
    }

    public int N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.l : invokeV.intValue;
    }

    public final void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.n = (List) getIntent().getSerializableExtra("video_list");
            this.a = getIntent().getStringExtra("page_from");
            this.b = getIntent().getStringExtra("from");
            this.c = getIntent().getStringExtra("source_from");
            this.e = getIntent().getBooleanExtra("is_from_bjh_pb", false);
            this.f = getIntent().getStringExtra("key_nid");
            this.g = getIntent().getStringExtra("forum_id");
        }
    }

    public final void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            List<VideoItemData> videoTabListByFid = FrsVideoTabPlayActivityConfig.getVideoTabListByFid(this.g);
            if (ListUtils.isEmpty(this.n) && !ListUtils.isEmpty(videoTabListByFid)) {
                ArrayList arrayList = new ArrayList();
                this.n = arrayList;
                arrayList.addAll(videoTabListByFid);
            }
            if (ListUtils.isEmpty(this.n)) {
                qi.M(this, R.string.obfuscated_res_0x7f0f0c3a);
                finish();
                return;
            }
            if (getIntent() != null && getIntent().getExtras() != null && !pi.isEmpty("video_index")) {
                this.l = getIntent().getExtras().getInt("video_index");
            }
            List<VideoItemData> list = this.n;
            if (list != null) {
                int size = list.size();
                int i = this.l;
                if (size > i && this.n.get(i) != null) {
                    this.j = this.n.get(this.l).thread_id;
                }
            }
            if (getIntent() != null && !pi.isEmpty("video_cover_rect")) {
                this.i = (Rect) getIntent().getParcelableExtra("video_cover_rect");
            }
            this.h = this.n.get(0).forum_name;
            VideoVerticalPageFragment videoVerticalPageFragment = new VideoVerticalPageFragment(getUniqueId(), null, 0, M0());
            this.o = videoVerticalPageFragment;
            videoVerticalPageFragment.setArguments(getIntent().getExtras());
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.add(R.id.obfuscated_res_0x7f09252b, this.o);
            beginTransaction.commitAllowingStateLoss();
            getSupportFragmentManager().executePendingTransactions();
            this.p = new NavigationBar(this);
            int k = qi.k(this);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            int dimenPixelSize2 = (int) ((k - (((dimenPixelSize + UtilHelper.getDimenPixelSize(R.dimen.tbds104)) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X013)) * 2)) / (UtilHelper.getDimenPixelSize(R.dimen.T_X05) * 0.5f));
            TextView textView = new TextView(this);
            this.q = textView;
            textView.setGravity(17);
            TextView textView2 = this.q;
            textView2.setText(StringHelper.cutChineseAndEnglishWithEmoji(this.h, dimenPixelSize2, StringHelper.STRING_MORE) + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02db));
            this.p.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.q, (View.OnClickListener) null);
            View addSystemImageButton = this.p.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.k = addSystemImageButton;
            addSystemImageButton.setOnClickListener(new c(this));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, UtilHelper.getDimenPixelSize(R.dimen.tbds104));
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds26);
            layoutParams.leftMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X002);
            layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X002);
            addContentView(this.p, layoutParams);
        }
    }

    public final boolean S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? TextUtils.equals(this.a, FrsVideoTabPlayActivityConfig.FROM_FRS_VIDEO_TOP) : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.m) {
                sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
            if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                TbSingleton.getInstance().setIsJumpFromVideoMiddleView(true);
            }
            VideoVerticalPageFragment videoVerticalPageFragment = this.o;
            if (videoVerticalPageFragment != null && videoVerticalPageFragment.H1() != null && this.o.H1().longValue() != 0 && this.o.G1() != null && !this.o.H1().equals(this.o.G1()) && !this.a.equals(FrsVideoTabPlayActivityConfig.FROM_FRS_VIDEO_TOP)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921630, this.o.H1()));
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.repackage.u95
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? "a093" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048588, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            VideoVerticalPageFragment videoVerticalPageFragment = this.o;
            if (videoVerticalPageFragment != null) {
                videoVerticalPageFragment.Z0(i, i2, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            NavigationBar navigationBar = this.p;
            if (navigationBar != null && this.q != null) {
                navigationBar.setBackgroundResource(R.drawable.obfuscated_res_0x7f081210);
                ms4 d = ms4.d(this.q);
                d.A(R.string.F_X01);
                d.v(R.color.CAM_X0101);
                d.z(R.dimen.T_X05);
                if (this.p.getBackImageView() != null) {
                    WebPManager.setPureDrawable(this.p.getBackImageView(), R.drawable.obfuscated_res_0x7f080a02, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
                }
            }
            if (!UtilHelper.isFlyMeOs()) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this);
            }
            VideoVerticalPageFragment videoVerticalPageFragment = this.o;
            if (videoVerticalPageFragment != null) {
                videoVerticalPageFragment.onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (configuration.orientation == 2) {
                this.p.setVisibility(8);
            } else {
                this.p.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
            if (getIntent() != null) {
                if (getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !z8.g().i("MainTabActivity")) {
                    this.m = true;
                }
                this.a = getIntent().getStringExtra("from");
            }
            if (this.m) {
                setIsAddSwipeBackLayout(false);
            }
            super.onCreate(bundle);
            BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(FrsVideoTabPlayActivityConfig.KEY_FPS_MIDDLE_VIDEO);
            this.d = System.currentTimeMillis();
            setContentView(R.layout.obfuscated_res_0x7f0d08be);
            this.r = new sk5(getPageContext(), "client_videomiddle");
            O0();
            P0();
            addNoAdjustSoftInputHeightListener();
            if (UbsABTestHelper.isFeedVideoImmersionTransition() && !FrsVideoTabPlayActivityConfig.FROM_FRS_VIDEO_TOP.equals(this.a)) {
                setActivityBgTransparent();
                TextView textView = this.q;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                View view2 = this.k;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
            }
            G0();
            registerListener(this.s);
            registerListener(this.t);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDestroy();
            DanmuProgressManager.b.a().b();
            sk5 sk5Var = this.r;
            if (sk5Var != null) {
                sk5Var.h();
            }
            String str = TextUtils.isEmpty(this.f) ? "0" : "1";
            long currentTimeMillis = System.currentTimeMillis() - this.d;
            if ("from_nani_video".equals(this.a)) {
                String str2 = "a002";
                if (!"index".equals(this.c)) {
                    if ("concern_tab".equals(this.c)) {
                        str2 = "a038";
                    } else if ("frs".equals(this.c)) {
                        str2 = "a006";
                    } else {
                        "homepage".equals(this.c);
                    }
                }
                if (this.e) {
                    TiebaStatic.log(new StatisticItem("stime").param("obj_type", "a023").param(TiebaStatic.Params.OBJ_DURATION, currentTimeMillis).param("obj_source", str2).param(TiebaStatic.Params.IS_VERTICAL, "1").param("is_dynamic", str).param("obj_location", this.b));
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
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048593, this, i, keyEvent)) == null) {
            if (i == 4) {
                VideoVerticalPageFragment videoVerticalPageFragment = this.o;
                if (videoVerticalPageFragment != null) {
                    if (videoVerticalPageFragment.i1()) {
                        return false;
                    }
                    this.o.B0();
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
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onPause();
            VideoVerticalPageFragment videoVerticalPageFragment = this.o;
            if (videoVerticalPageFragment != null) {
                videoVerticalPageFragment.setPrimary(false);
                this.o.setUserVisibleHint(false);
            }
            dj4.w().E();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onResume();
            VideoVerticalPageFragment videoVerticalPageFragment = this.o;
            if (videoVerticalPageFragment != null) {
                videoVerticalPageFragment.setPrimary(true);
                this.o.setUserVisibleHint(true);
                dj4.w().P(cj4.c0, this.o.F0());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? "712" : (String) invokeV.objValue;
    }
}
