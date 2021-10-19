package com.baidu.tieba.lego.activity;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentTransaction;
import c.a.q0.d1.s0;
import c.a.r0.k3.w;
import c.a.r0.q1.j;
import c.a.r0.q1.o.l.m;
import c.a.r0.q1.p.e;
import c.a.r0.z2.y;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.view.BaseCardView;
import com.baidu.tieba.lego.view.LegoBottomView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import org.json.JSONObject;
import tbclient.Lego.DataRes;
/* loaded from: classes7.dex */
public class LegoListActivity extends BaseFragmentActivity implements SwipeBackLayout.c, VoiceManager.j, c.a.r0.q1.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String animationInfo;
    public TbImageView floatBtn;
    public boolean hasAnimation;
    public String isFrom;
    public boolean isImmersive;
    public boolean isLandingPage;
    public String itemId;
    public long lastResumeTime;
    public LegoListFragment legoListFragment;
    public LegoTabFragment legoTabFragment;
    public LegoBottomView mBottomView;
    public final View.OnClickListener mCommonOnClickListener;
    public c.a.r0.q1.o.l.c mFloatVideoContainer;
    public boolean mIsResumed;
    public CustomMessageListener mShowComponentViewListener;
    public VoiceManager mVoiceManager;
    public RelativeLayout navi_landingpage;
    public j navigationBarViewHolder;
    public String nextPage;
    public long pageId;
    public int pageType;
    public String params;
    public String preLoad;
    public int rn;
    public WeakReference<Context> weakContext;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoListActivity f53803a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(LegoListActivity legoListActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListActivity, Integer.valueOf(i2)};
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
            this.f53803a = legoListActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String str;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getData() instanceof DataRes) {
                str = ((DataRes) customResponsedMessage.getData()).page_info;
            } else {
                str = customResponsedMessage.getData() instanceof String ? (String) customResponsedMessage.getData() : "";
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f53803a.showFloatButton(jSONObject);
                this.f53803a.showBottomCard(jSONObject);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f53804e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ LegoListActivity f53805f;

        public b(LegoListActivity legoListActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53805f = legoListActivity;
            this.f53804e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f53804e)) {
                return;
            }
            w.c(this.f53805f.getPageContext(), this.f53804e);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoListActivity f53806e;

        public c(LegoListActivity legoListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53806e = legoListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                LegoListActivity legoListActivity = this.f53806e;
                if (view == legoListActivity.navigationBarViewHolder.f23695e) {
                    legoListActivity.finish();
                }
            }
        }
    }

    public LegoListActivity() {
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
        this.pageId = 0L;
        this.pageType = 1;
        this.itemId = "";
        this.isImmersive = false;
        this.hasAnimation = false;
        this.isLandingPage = false;
        this.weakContext = null;
        this.mIsResumed = false;
        this.mBottomView = null;
        this.mShowComponentViewListener = new a(this, 2016455);
        this.mCommonOnClickListener = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showBottomCard(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, jSONObject) == null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("bottom_card");
                if (optJSONObject == null) {
                    return;
                }
                c.a.r0.q1.o.b.h();
                ICardInfo j2 = c.a.r0.q1.o.b.j(optJSONObject);
                if (j2 != null && j2.isValid()) {
                    this.mBottomView.addComponentView((BaseCardView) c.a.r0.q1.o.b.h().a(getPageContext(), j2, 5), j2);
                    this.mBottomView.setVisibility(0);
                    this.mBottomView.setIsShow(true);
                    if (this.legoListFragment != null) {
                        this.legoListFragment.setOnScrollCallbackListener(this.mBottomView);
                        return;
                    }
                    return;
                }
                this.mBottomView.setVisibility(8);
                this.mBottomView.setIsShow(false);
                if (this.legoListFragment != null) {
                    this.legoListFragment.setOnScrollCallbackListener(null);
                }
            } catch (CardParseException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showFloatButton(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, jSONObject) == null) || (optJSONObject = jSONObject.optJSONObject("float_btn")) == null) {
            return;
        }
        String optString = optJSONObject.optString("icon_url");
        String optString2 = optJSONObject.optString("icon_url_night");
        String optString3 = optJSONObject.optString("scheme");
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            optString = optString2;
        }
        this.floatBtn.setVisibility(0);
        this.floatBtn.startLoad(optString, 10, false);
        this.floatBtn.setOnClickListener(new b(this, optString3));
    }

    @Override // com.baidu.adp.widget.SwipeBackLayout.c
    public void disableSwipeBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setSwipeBackEnabled(false);
        }
    }

    @Override // com.baidu.adp.widget.SwipeBackLayout.c
    public void enableSwipeBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setSwipeBackEnabled(true);
        }
    }

    public BaseAdapter getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            LegoListFragment legoListFragment = this.legoListFragment;
            if (legoListFragment != null) {
                return legoListFragment.getAdapter();
            }
            return null;
        }
        return (BaseAdapter) invokeV.objValue;
    }

    @Override // c.a.r0.q1.b
    public c.a.r0.q1.o.l.c getFloatVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mFloatVideoContainer : (c.a.r0.q1.o.l.c) invokeV.objValue;
    }

    @Override // c.a.r0.q1.b
    public LegoListFragment getLegoListFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.legoListFragment : (LegoListFragment) invokeV.objValue;
    }

    @Override // c.a.r0.q1.b
    public m getPlaySwitchController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            LegoListFragment legoListFragment = this.legoListFragment;
            if (legoListFragment != null) {
                return legoListFragment.getPlaySwitchController();
            }
            return null;
        }
        return (m) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, voiceData$VoiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.mVoiceManager == null) {
                this.mVoiceManager = VoiceManager.instance();
            }
            return this.mVoiceManager;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public boolean isActivityResumed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mIsResumed : invokeV.booleanValue;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        LegoListFragment legoListFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.hasAnimation && !TextUtils.isEmpty(this.animationInfo) && (legoListFragment = this.legoListFragment) != null) {
                legoListFragment.endAnimation();
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.navigationBarViewHolder.f23691a.onChangeSkinType(getPageContext(), i2);
            if (this.pageType == 1) {
                LegoTabFragment legoTabFragment = this.legoTabFragment;
                if (legoTabFragment != null) {
                    legoTabFragment.onChangeSkinType(i2);
                    return;
                }
                return;
            }
            LegoListFragment legoListFragment = this.legoListFragment;
            if (legoListFragment != null) {
                legoListFragment.onChangeSkinType(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            this.mFloatVideoContainer.n0(this, configuration);
            if (configuration.orientation == 2 && this.mFloatVideoContainer.m0()) {
                LegoBottomView legoBottomView = this.mBottomView;
                if (legoBottomView != null) {
                    legoBottomView.setIsVideoLandscape(true);
                    this.mBottomView.setVisibility(8);
                }
            } else {
                LegoBottomView legoBottomView2 = this.mBottomView;
                if (legoBottomView2 != null && legoBottomView2.isShow()) {
                    this.mBottomView.setIsVideoLandscape(false);
                    this.mBottomView.setVisibility(0);
                }
            }
            LegoListFragment legoListFragment = this.legoListFragment;
            if (legoListFragment != null) {
                legoListFragment.onConfigurationChanged(configuration);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            Window window = getWindow();
            if (window != null) {
                window.setSoftInputMode(32);
            }
            if (getIntent() != null) {
                this.pageType = getIntent().getIntExtra("page_type", 1);
                this.pageId = getIntent().getLongExtra("page_id", 0L);
                if (getIntent().hasExtra("item_id")) {
                    this.itemId = getIntent().getStringExtra("item_id");
                }
                this.isImmersive = getIntent().getIntExtra(LegoListActivityConfig.IS_IMMERSIVE, 0) == 1;
                this.isLandingPage = getIntent().getIntExtra(LegoListActivityConfig.IS_LANDINGPAGE, 0) == 1;
                this.hasAnimation = getIntent().getIntExtra(LegoListActivityConfig.HAS_ANIMATION, 0) == 1;
                this.rn = getIntent().getIntExtra("rn", 30);
                if (getIntent().hasExtra("params")) {
                    this.params = getIntent().getStringExtra("params");
                }
                this.nextPage = getIntent().getStringExtra(LegoListActivityConfig.NEXT_PAGE);
                String stringExtra = getIntent().getStringExtra(LegoListActivityConfig.ANIMATION_INFO);
                this.animationInfo = stringExtra;
                if (!TextUtils.isEmpty(stringExtra)) {
                    this.animationInfo = URLDecoder.decode(this.animationInfo);
                }
                if (!TextUtils.isEmpty(this.nextPage)) {
                    this.nextPage = URLDecoder.decode(this.nextPage);
                }
                String stringExtra2 = getIntent().getStringExtra(LegoListActivityConfig.PRE_LOAD);
                this.preLoad = stringExtra2;
                if (!TextUtils.isEmpty(stringExtra2)) {
                    this.preLoad = URLDecoder.decode(this.preLoad);
                }
                this.isFrom = getIntent().getStringExtra("source");
            }
            super.setHideStatusImmersiveStyle(this.isImmersive);
            super.onCreate(bundle);
            setContentView(R.layout.lego_list_activity);
            registerListener(this.mShowComponentViewListener);
            e eVar = new e();
            eVar.f23853a = this.pageId;
            eVar.f23854b = this.itemId;
            eVar.f23856d = this.rn;
            eVar.f23857e = this.params;
            eVar.b();
            VoiceManager voiceManager = getVoiceManager();
            this.mVoiceManager = voiceManager;
            voiceManager.onCreate(getPageContext());
            this.navigationBarViewHolder = new j(this);
            this.floatBtn = (TbImageView) findViewById(R.id.float_btn);
            this.mBottomView = (LegoBottomView) findViewById(R.id.lego_bottom_view);
            this.navi_landingpage = (RelativeLayout) findViewById(R.id.navi_landingpage);
            c.a.r0.q1.o.l.c cVar = new c.a.r0.q1.o.l.c(getPageContext(), findViewById(R.id.layout_float_video));
            this.mFloatVideoContainer = cVar;
            cVar.E0(this);
            this.mFloatVideoContainer.j0();
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            if (this.pageType == 1) {
                LegoTabFragment legoTabFragment = new LegoTabFragment();
                this.legoTabFragment = legoTabFragment;
                legoTabFragment.setNavigationBarViewHolder(this.navigationBarViewHolder);
                this.legoTabFragment.setPageId(this.pageId);
                this.legoTabFragment.setItemId(this.itemId);
                this.legoTabFragment.setPrimary(true);
                beginTransaction.replace(R.id.fl_lego, this.legoTabFragment);
            } else {
                LegoListFragment.initHasShown();
                LegoListFragment legoListFragment = new LegoListFragment();
                this.legoListFragment = legoListFragment;
                legoListFragment.setNavigationBarViewHolder(this.navigationBarViewHolder);
                this.legoListFragment.setLandingNavi(this.navi_landingpage);
                this.legoListFragment.setFloatVideoContainer(this.mFloatVideoContainer);
                this.legoListFragment.setPageId(this.pageId);
                this.legoListFragment.setItemId(this.itemId);
                this.legoListFragment.setImmersive(this.isImmersive);
                this.legoListFragment.setPrimary(true);
                this.legoListFragment.setPageData(this.nextPage);
                this.legoListFragment.setAnimationInfo(this.animationInfo, this.preLoad);
                this.legoListFragment.setHasAnimation(this.hasAnimation);
                this.legoListFragment.setLandingPage(this.isLandingPage);
                this.legoListFragment.setFrom(this.isFrom);
                beginTransaction.replace(R.id.fl_lego, this.legoListFragment);
            }
            if (this.isImmersive) {
                this.navigationBarViewHolder.d();
            }
            beginTransaction.commitAllowingStateLoss();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            c.a.r0.q1.o.l.c cVar = this.mFloatVideoContainer;
            if (cVar != null) {
                cVar.V();
            }
            VoiceManager voiceManager = getVoiceManager();
            this.mVoiceManager = voiceManager;
            voiceManager.onDestory(getPageContext());
            this.animationInfo = null;
            LegoBottomView legoBottomView = this.mBottomView;
            if (legoBottomView != null) {
                legoBottomView.destory();
                this.mBottomView = null;
            }
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        c.a.r0.q1.o.l.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048590, this, i2, keyEvent)) == null) {
            if (i2 == 4 && (cVar = this.mFloatVideoContainer) != null && cVar.m0() && !this.mFloatVideoContainer.e0()) {
                this.mFloatVideoContainer.Q0();
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onPause();
            this.mIsResumed = false;
            VoiceManager voiceManager = getVoiceManager();
            this.mVoiceManager = voiceManager;
            voiceManager.onPause(getPageContext());
            if (this.lastResumeTime == 0 || !this.isLandingPage) {
                return;
            }
            y.o().l().a(this.pageId, this.itemId, this.isFrom, System.currentTimeMillis() - this.lastResumeTime);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onResume();
            this.mIsResumed = true;
            VoiceManager voiceManager = getVoiceManager();
            this.mVoiceManager = voiceManager;
            voiceManager.onResume(getPageContext());
            this.lastResumeTime = System.currentTimeMillis();
            WeakReference<Context> weakReference = new WeakReference<>(TbadkCoreApplication.getInst());
            this.weakContext = weakReference;
            s0.f(weakReference, true);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            VoiceManager voiceManager = getVoiceManager();
            this.mVoiceManager = voiceManager;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onStart();
            VoiceManager voiceManager = getVoiceManager();
            this.mVoiceManager = voiceManager;
            voiceManager.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onStop();
            VoiceManager voiceManager = getVoiceManager();
            this.mVoiceManager = voiceManager;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            s0.f(this.weakContext, false);
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048596, this, i2, i3) == null) && this.hasAnimation && !TextUtils.isEmpty(this.animationInfo)) {
            super.overridePendingTransition(0, R.anim.landingpage_quit);
        }
    }

    public void stopVoice() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            VoiceManager voiceManager = getVoiceManager();
            this.mVoiceManager = voiceManager;
            voiceManager.stopPlay();
        }
    }
}
