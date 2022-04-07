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
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
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
import com.repackage.ae7;
import com.repackage.bc7;
import com.repackage.fa8;
import com.repackage.jc7;
import com.repackage.kd5;
import com.repackage.nd7;
import com.repackage.tc7;
import com.repackage.ud7;
import com.repackage.uj8;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import org.json.JSONObject;
import tbclient.Lego.DataRes;
/* loaded from: classes3.dex */
public class LegoListActivity extends BaseFragmentActivity implements SwipeBackLayout.c, VoiceManager.j, bc7 {
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
    public nd7 mFloatVideoContainer;
    public boolean mIsResumed;
    public CustomMessageListener mShowComponentViewListener;
    public VoiceManager mVoiceManager;
    public RelativeLayout navi_landingpage;
    public jc7 navigationBarViewHolder;
    public String nextPage;
    public long pageId;
    public int pageType;
    public String params;
    public String preLoad;
    public int rn;
    public WeakReference<Context> weakContext;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoListActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(LegoListActivity legoListActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListActivity, Integer.valueOf(i)};
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
            this.a = legoListActivity;
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
                this.a.showFloatButton(jSONObject);
                this.a.showBottomCard(jSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ LegoListActivity b;

        public b(LegoListActivity legoListActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = legoListActivity;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || TextUtils.isEmpty(this.a)) {
                return;
            }
            uj8.c(this.b.getPageContext(), this.a);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoListActivity a;

        public c(LegoListActivity legoListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = legoListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                LegoListActivity legoListActivity = this.a;
                if (view2 == legoListActivity.navigationBarViewHolder.e) {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                tc7.h();
                ICardInfo j = tc7.j(optJSONObject);
                if (j != null && j.isValid()) {
                    this.mBottomView.b((BaseCardView) tc7.h().a(getPageContext(), j, 5), j);
                    this.mBottomView.setVisibility(0);
                    this.mBottomView.setIsShow(true);
                    if (this.legoListFragment != null) {
                        this.legoListFragment.z1(this.mBottomView);
                        return;
                    }
                    return;
                }
                this.mBottomView.setVisibility(8);
                this.mBottomView.setIsShow(false);
                if (this.legoListFragment != null) {
                    this.legoListFragment.z1(null);
                }
            } catch (CardParseException e) {
                e.printStackTrace();
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
        this.floatBtn.K(optString, 10, false);
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
                return legoListFragment.h1();
            }
            return null;
        }
        return (BaseAdapter) invokeV.objValue;
    }

    @Override // com.repackage.bc7
    public nd7 getFloatVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mFloatVideoContainer : (nd7) invokeV.objValue;
    }

    @Override // com.repackage.bc7
    public LegoListFragment getLegoListFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.legoListFragment : (LegoListFragment) invokeV.objValue;
    }

    @Override // com.repackage.bc7
    public ud7 getPlaySwitchController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            LegoListFragment legoListFragment = this.legoListFragment;
            if (legoListFragment != null) {
                return legoListFragment.k1();
            }
            return null;
        }
        return (ud7) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, voiceModel)) == null) {
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
                legoListFragment.f1();
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.navigationBarViewHolder.a.onChangeSkinType(getPageContext(), i);
            if (this.pageType == 1) {
                LegoTabFragment legoTabFragment = this.legoTabFragment;
                if (legoTabFragment != null) {
                    legoTabFragment.onChangeSkinType(i);
                    return;
                }
                return;
            }
            LegoListFragment legoListFragment = this.legoListFragment;
            if (legoListFragment != null) {
                legoListFragment.onChangeSkinType(i);
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
                if (legoBottomView2 != null && legoBottomView2.e()) {
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
            setContentView(R.layout.obfuscated_res_0x7f0d04ef);
            registerListener(this.mShowComponentViewListener);
            ae7 ae7Var = new ae7();
            ae7Var.a = this.pageId;
            ae7Var.b = this.itemId;
            ae7Var.d = this.rn;
            ae7Var.e = this.params;
            ae7Var.b();
            VoiceManager voiceManager = getVoiceManager();
            this.mVoiceManager = voiceManager;
            voiceManager.onCreate(getPageContext());
            this.navigationBarViewHolder = new jc7(this);
            this.floatBtn = (TbImageView) findViewById(R.id.obfuscated_res_0x7f0909cb);
            this.mBottomView = (LegoBottomView) findViewById(R.id.obfuscated_res_0x7f091221);
            this.navi_landingpage = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0914fa);
            nd7 nd7Var = new nd7(getPageContext(), findViewById(R.id.obfuscated_res_0x7f0911d0));
            this.mFloatVideoContainer = nd7Var;
            nd7Var.E0(this);
            this.mFloatVideoContainer.j0();
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            if (this.pageType == 1) {
                LegoTabFragment legoTabFragment = new LegoTabFragment();
                this.legoTabFragment = legoTabFragment;
                legoTabFragment.U0(this.navigationBarViewHolder);
                this.legoTabFragment.V0(this.pageId);
                this.legoTabFragment.T0(this.itemId);
                this.legoTabFragment.setPrimary(true);
                beginTransaction.replace(R.id.obfuscated_res_0x7f0909c4, this.legoTabFragment);
            } else {
                LegoListFragment.n1();
                LegoListFragment legoListFragment = new LegoListFragment();
                this.legoListFragment = legoListFragment;
                legoListFragment.y1(this.navigationBarViewHolder);
                this.legoListFragment.w1(this.navi_landingpage);
                this.legoListFragment.s1(this.mFloatVideoContainer);
                this.legoListFragment.B1(this.pageId);
                this.legoListFragment.v1(this.itemId);
                this.legoListFragment.u1(this.isImmersive);
                this.legoListFragment.setPrimary(true);
                this.legoListFragment.A1(this.nextPage);
                this.legoListFragment.r1(this.animationInfo, this.preLoad);
                this.legoListFragment.t1(this.hasAnimation);
                this.legoListFragment.x1(this.isLandingPage);
                this.legoListFragment.setFrom(this.isFrom);
                beginTransaction.replace(R.id.obfuscated_res_0x7f0909c4, this.legoListFragment);
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
            nd7 nd7Var = this.mFloatVideoContainer;
            if (nd7Var != null) {
                nd7Var.V();
            }
            VoiceManager voiceManager = getVoiceManager();
            this.mVoiceManager = voiceManager;
            voiceManager.onDestory(getPageContext());
            this.animationInfo = null;
            LegoBottomView legoBottomView = this.mBottomView;
            if (legoBottomView != null) {
                legoBottomView.c();
                this.mBottomView = null;
            }
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        nd7 nd7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048590, this, i, keyEvent)) == null) {
            if (i == 4 && (nd7Var = this.mFloatVideoContainer) != null && nd7Var.m0() && !this.mFloatVideoContainer.e0()) {
                this.mFloatVideoContainer.Q0();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
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
            fa8.q().l().a(this.pageId, this.itemId, this.isFrom, System.currentTimeMillis() - this.lastResumeTime);
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
            kd5.f(weakReference, true);
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
            kd5.f(this.weakContext, false);
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048596, this, i, i2) == null) && this.hasAnimation && !TextUtils.isEmpty(this.animationInfo)) {
            super.overridePendingTransition(0, R.anim.obfuscated_res_0x7f01008d);
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
