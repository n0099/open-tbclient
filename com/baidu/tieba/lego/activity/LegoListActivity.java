package com.baidu.tieba.lego.activity;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
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
import com.baidu.tieba.bl7;
import com.baidu.tieba.jl7;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.view.BaseCardView;
import com.baidu.tieba.lego.view.LegoBottomView;
import com.baidu.tieba.lr8;
import com.baidu.tieba.mm7;
import com.baidu.tieba.rm7;
import com.baidu.tieba.tl7;
import com.baidu.tieba.wk5;
import com.baidu.tieba.xm7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import org.json.JSONObject;
import tbclient.Lego.DataRes;
/* loaded from: classes5.dex */
public class LegoListActivity extends BaseFragmentActivity implements SwipeBackLayout.c, VoiceManager.j, bl7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LegoListFragment a;
    public LegoTabFragment b;
    public jl7 c;
    public RelativeLayout d;
    public long e;
    public int f;
    public String g;
    public boolean h;
    public boolean i;
    public boolean j;
    public int k;
    public String l;
    public TbImageView m;
    public String n;
    public String o;
    public String p;
    public String q;
    public WeakReference<Context> r;
    public mm7 s;
    public LegoBottomView t;
    public CustomMessageListener u;
    public final View.OnClickListener v;
    public VoiceManager w;

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i b1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                if (customResponsedMessage.getData() instanceof DataRes) {
                    str = ((DataRes) customResponsedMessage.getData()).page_info;
                } else if (customResponsedMessage.getData() instanceof String) {
                    str = (String) customResponsedMessage.getData();
                } else {
                    str = "";
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.a.P0(jSONObject);
                    this.a.O0(jSONObject);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || TextUtils.isEmpty(this.a)) {
                return;
            }
            lr8.c(this.b.getPageContext(), this.a);
        }
    }

    /* loaded from: classes5.dex */
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
                if (view2 == legoListActivity.c.e) {
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
        this.e = 0L;
        this.f = 1;
        this.g = "";
        this.h = false;
        this.i = false;
        this.j = false;
        this.r = null;
        this.t = null;
        this.u = new a(this, 2016455);
        this.v = new c(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        mm7 mm7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048589, this, i, keyEvent)) == null) {
            if (i == 4 && (mm7Var = this.s) != null && mm7Var.k0() && !this.s.c0()) {
                this.s.O0();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048595, this, i, i2) == null) && this.i && !TextUtils.isEmpty(this.n)) {
            super.overridePendingTransition(0, R.anim.obfuscated_res_0x7f010093);
        }
    }

    @Override // com.baidu.tieba.bl7
    public rm7 B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            LegoListFragment legoListFragment = this.a;
            if (legoListFragment != null) {
                return legoListFragment.g2();
            }
            return null;
        }
        return (rm7) invokeV.objValue;
    }

    @Override // com.baidu.adp.widget.SwipeBackLayout.c
    public void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setSwipeBackEnabled(false);
        }
    }

    @Override // com.baidu.tieba.bl7
    public mm7 R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.s;
        }
        return (mm7) invokeV.objValue;
    }

    @Override // com.baidu.adp.widget.SwipeBackLayout.c
    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setSwipeBackEnabled(true);
        }
    }

    @Override // com.baidu.tieba.bl7
    public LegoListFragment c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.a;
        }
        return (LegoListFragment) invokeV.objValue;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        LegoListFragment legoListFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.i && !TextUtils.isEmpty(this.n) && (legoListFragment = this.a) != null) {
                legoListFragment.b2();
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onPause();
            VoiceManager r0 = r0();
            this.w = r0;
            r0.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onResume();
            VoiceManager r0 = r0();
            this.w = r0;
            r0.onResume(getPageContext());
            System.currentTimeMillis();
            WeakReference<Context> weakReference = new WeakReference<>(TbadkCoreApplication.getInst());
            this.r = weakReference;
            wk5.e(weakReference, true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onStart();
            VoiceManager r0 = r0();
            this.w = r0;
            r0.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onStop();
            VoiceManager r0 = r0();
            this.w = r0;
            if (r0 != null) {
                r0.onStop(getPageContext());
            }
            wk5.e(this.r, false);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.w == null) {
                this.w = VoiceManager.instance();
            }
            return this.w;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public final void O0(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("bottom_card");
                if (optJSONObject == null) {
                    return;
                }
                tl7.h();
                ICardInfo j = tl7.j(optJSONObject);
                if (j != null && j.isValid()) {
                    this.t.b((BaseCardView) tl7.h().a(getPageContext(), j, 5), j);
                    this.t.setVisibility(0);
                    this.t.setIsShow(true);
                    if (this.a != null) {
                        this.a.v2(this.t);
                        return;
                    }
                    return;
                }
                this.t.setVisibility(8);
                this.t.setIsShow(false);
                if (this.a != null) {
                    this.a.v2(null);
                }
            } catch (CardParseException e) {
                e.printStackTrace();
            }
        }
    }

    public final void P0(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, jSONObject) != null) || (optJSONObject = jSONObject.optJSONObject("float_btn")) == null) {
            return;
        }
        String optString = optJSONObject.optString("icon_url");
        String optString2 = optJSONObject.optString("icon_url_night");
        String optString3 = optJSONObject.optString("scheme");
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            optString = optString2;
        }
        this.m.setVisibility(0);
        this.m.K(optString, 10, false);
        this.m.setOnClickListener(new b(this, optString3));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            this.s.l0(this, configuration);
            if (configuration.orientation == 2 && this.s.k0()) {
                LegoBottomView legoBottomView = this.t;
                if (legoBottomView != null) {
                    legoBottomView.setIsVideoLandscape(true);
                    this.t.setVisibility(8);
                }
            } else {
                LegoBottomView legoBottomView2 = this.t;
                if (legoBottomView2 != null && legoBottomView2.e()) {
                    this.t.setIsVideoLandscape(false);
                    this.t.setVisibility(0);
                }
            }
            LegoListFragment legoListFragment = this.a;
            if (legoListFragment != null) {
                legoListFragment.onConfigurationChanged(configuration);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.c.a.onChangeSkinType(getPageContext(), i);
            if (this.f == 1) {
                LegoTabFragment legoTabFragment = this.b;
                if (legoTabFragment != null) {
                    legoTabFragment.onChangeSkinType(i);
                    return;
                }
                return;
            }
            LegoListFragment legoListFragment = this.a;
            if (legoListFragment != null) {
                legoListFragment.onChangeSkinType(i);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            VoiceManager r0 = r0();
            this.w = r0;
            if (r0 != null) {
                r0.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            Window window = getWindow();
            if (window != null) {
                window.setSoftInputMode(32);
            }
            if (getIntent() != null) {
                this.f = getIntent().getIntExtra("page_type", 1);
                this.e = getIntent().getLongExtra(LegoListActivityConfig.PAGE_ID, 0L);
                if (getIntent().hasExtra("item_id")) {
                    this.g = getIntent().getStringExtra("item_id");
                }
                boolean z3 = false;
                if (getIntent().getIntExtra(LegoListActivityConfig.IS_IMMERSIVE, 0) == 1) {
                    z = true;
                } else {
                    z = false;
                }
                this.h = z;
                if (getIntent().getIntExtra(LegoListActivityConfig.IS_LANDINGPAGE, 0) == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.j = z2;
                if (getIntent().getIntExtra(LegoListActivityConfig.HAS_ANIMATION, 0) == 1) {
                    z3 = true;
                }
                this.i = z3;
                this.k = getIntent().getIntExtra("rn", 30);
                if (getIntent().hasExtra("params")) {
                    this.l = getIntent().getStringExtra("params");
                }
                this.o = getIntent().getStringExtra(LegoListActivityConfig.NEXT_PAGE);
                String stringExtra = getIntent().getStringExtra(LegoListActivityConfig.ANIMATION_INFO);
                this.n = stringExtra;
                if (!TextUtils.isEmpty(stringExtra)) {
                    this.n = URLDecoder.decode(this.n);
                }
                if (!TextUtils.isEmpty(this.o)) {
                    this.o = URLDecoder.decode(this.o);
                }
                String stringExtra2 = getIntent().getStringExtra(LegoListActivityConfig.PRE_LOAD);
                this.p = stringExtra2;
                if (!TextUtils.isEmpty(stringExtra2)) {
                    this.p = URLDecoder.decode(this.p);
                }
                this.q = getIntent().getStringExtra("source");
            }
            super.setHideStatusImmersiveStyle(this.h);
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d053b);
            registerListener(this.u);
            xm7 xm7Var = new xm7();
            xm7Var.a = this.e;
            xm7Var.b = this.g;
            xm7Var.d = this.k;
            xm7Var.e = this.l;
            xm7Var.b();
            VoiceManager r0 = r0();
            this.w = r0;
            r0.onCreate(getPageContext());
            this.c = new jl7(this);
            this.m = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090a24);
            this.t = (LegoBottomView) findViewById(R.id.obfuscated_res_0x7f091373);
            this.d = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0916d9);
            mm7 mm7Var = new mm7(getPageContext(), findViewById(R.id.obfuscated_res_0x7f091320));
            this.s = mm7Var;
            mm7Var.C0(this);
            this.s.h0();
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            if (this.f == 1) {
                LegoTabFragment legoTabFragment = new LegoTabFragment();
                this.b = legoTabFragment;
                legoTabFragment.Q1(this.c);
                this.b.R1(this.e);
                this.b.P1(this.g);
                this.b.setPrimary(true);
                beginTransaction.replace(R.id.obfuscated_res_0x7f090a1a, this.b);
            } else {
                LegoListFragment.j2();
                LegoListFragment legoListFragment = new LegoListFragment();
                this.a = legoListFragment;
                legoListFragment.u2(this.c);
                this.a.s2(this.d);
                this.a.o2(this.s);
                this.a.x2(this.e);
                this.a.r2(this.g);
                this.a.q2(this.h);
                this.a.setPrimary(true);
                this.a.w2(this.o);
                this.a.n2(this.n, this.p);
                this.a.p2(this.i);
                this.a.t2(this.j);
                this.a.setFrom(this.q);
                beginTransaction.replace(R.id.obfuscated_res_0x7f090a1a, this.a);
            }
            if (this.h) {
                this.c.d();
            }
            beginTransaction.commitAllowingStateLoss();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            mm7 mm7Var = this.s;
            if (mm7Var != null) {
                mm7Var.T();
            }
            VoiceManager r0 = r0();
            this.w = r0;
            r0.onDestory(getPageContext());
            this.n = null;
            LegoBottomView legoBottomView = this.t;
            if (legoBottomView != null) {
                legoBottomView.c();
                this.t = null;
            }
            super.onDestroy();
        }
    }
}
