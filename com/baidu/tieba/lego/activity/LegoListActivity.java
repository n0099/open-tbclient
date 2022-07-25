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
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.view.BaseCardView;
import com.baidu.tieba.lego.view.LegoBottomView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cc7;
import com.repackage.kc7;
import com.repackage.nd7;
import com.repackage.nh8;
import com.repackage.pe5;
import com.repackage.sd7;
import com.repackage.uc7;
import com.repackage.yd7;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import org.json.JSONObject;
import tbclient.Lego.DataRes;
/* loaded from: classes3.dex */
public class LegoListActivity extends BaseFragmentActivity implements SwipeBackLayout.c, VoiceManager.j, cc7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LegoListFragment a;
    public LegoTabFragment b;
    public kc7 c;
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
    public nd7 s;
    public LegoBottomView t;
    public CustomMessageListener u;
    public final View.OnClickListener v;
    public VoiceManager w;

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
                this.a.s0(jSONObject);
                this.a.p0(jSONObject);
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
            nh8.c(this.b.getPageContext(), this.a);
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

    @Override // com.baidu.adp.widget.SwipeBackLayout.c
    public void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setSwipeBackEnabled(false);
        }
    }

    @Override // com.baidu.adp.widget.SwipeBackLayout.c
    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setSwipeBackEnabled(true);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i f1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.repackage.cc7
    public sd7 g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            LegoListFragment legoListFragment = this.a;
            if (legoListFragment != null) {
                return legoListFragment.c2();
            }
            return null;
        }
        return (sd7) invokeV.objValue;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        LegoListFragment legoListFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.i && !TextUtils.isEmpty(this.n) && (legoListFragment = this.a) != null) {
                legoListFragment.X1();
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, configuration) == null) {
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            Window window = getWindow();
            if (window != null) {
                window.setSoftInputMode(32);
            }
            if (getIntent() != null) {
                this.f = getIntent().getIntExtra("page_type", 1);
                this.e = getIntent().getLongExtra("page_id", 0L);
                if (getIntent().hasExtra("item_id")) {
                    this.g = getIntent().getStringExtra("item_id");
                }
                this.h = getIntent().getIntExtra(LegoListActivityConfig.IS_IMMERSIVE, 0) == 1;
                this.j = getIntent().getIntExtra(LegoListActivityConfig.IS_LANDINGPAGE, 0) == 1;
                this.i = getIntent().getIntExtra(LegoListActivityConfig.HAS_ANIMATION, 0) == 1;
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
            setContentView(R.layout.obfuscated_res_0x7f0d04fd);
            registerListener(this.u);
            yd7 yd7Var = new yd7();
            yd7Var.a = this.e;
            yd7Var.b = this.g;
            yd7Var.d = this.k;
            yd7Var.e = this.l;
            yd7Var.b();
            VoiceManager u0 = u0();
            this.w = u0;
            u0.onCreate(getPageContext());
            this.c = new kc7(this);
            this.m = (TbImageView) findViewById(R.id.obfuscated_res_0x7f09099d);
            this.t = (LegoBottomView) findViewById(R.id.obfuscated_res_0x7f091263);
            this.d = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09154f);
            nd7 nd7Var = new nd7(getPageContext(), findViewById(R.id.obfuscated_res_0x7f091214));
            this.s = nd7Var;
            nd7Var.C0(this);
            this.s.h0();
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            if (this.f == 1) {
                LegoTabFragment legoTabFragment = new LegoTabFragment();
                this.b = legoTabFragment;
                legoTabFragment.M1(this.c);
                this.b.N1(this.e);
                this.b.L1(this.g);
                this.b.setPrimary(true);
                beginTransaction.replace(R.id.obfuscated_res_0x7f090996, this.b);
            } else {
                LegoListFragment.f2();
                LegoListFragment legoListFragment = new LegoListFragment();
                this.a = legoListFragment;
                legoListFragment.q2(this.c);
                this.a.o2(this.d);
                this.a.k2(this.s);
                this.a.t2(this.e);
                this.a.n2(this.g);
                this.a.m2(this.h);
                this.a.setPrimary(true);
                this.a.s2(this.o);
                this.a.j2(this.n, this.p);
                this.a.l2(this.i);
                this.a.p2(this.j);
                this.a.setFrom(this.q);
                beginTransaction.replace(R.id.obfuscated_res_0x7f090996, this.a);
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
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            nd7 nd7Var = this.s;
            if (nd7Var != null) {
                nd7Var.T();
            }
            VoiceManager u0 = u0();
            this.w = u0;
            u0.onDestory(getPageContext());
            this.n = null;
            LegoBottomView legoBottomView = this.t;
            if (legoBottomView != null) {
                legoBottomView.c();
                this.t = null;
            }
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        nd7 nd7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i, keyEvent)) == null) {
            if (i == 4 && (nd7Var = this.s) != null && nd7Var.k0() && !this.s.c0()) {
                this.s.O0();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onPause();
            VoiceManager u0 = u0();
            this.w = u0;
            u0.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
            VoiceManager u0 = u0();
            this.w = u0;
            u0.onResume(getPageContext());
            System.currentTimeMillis();
            WeakReference<Context> weakReference = new WeakReference<>(TbadkCoreApplication.getInst());
            this.r = weakReference;
            pe5.e(weakReference, true);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            VoiceManager u0 = u0();
            this.w = u0;
            if (u0 != null) {
                u0.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onStart();
            VoiceManager u0 = u0();
            this.w = u0;
            u0.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onStop();
            VoiceManager u0 = u0();
            this.w = u0;
            if (u0 != null) {
                u0.onStop(getPageContext());
            }
            pe5.e(this.r, false);
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048591, this, i, i2) == null) && this.i && !TextUtils.isEmpty(this.n)) {
            super.overridePendingTransition(0, R.anim.obfuscated_res_0x7f01008f);
        }
    }

    public final void p0(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, jSONObject) == null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("bottom_card");
                if (optJSONObject == null) {
                    return;
                }
                uc7.h();
                ICardInfo j = uc7.j(optJSONObject);
                if (j != null && j.isValid()) {
                    this.t.b((BaseCardView) uc7.h().a(getPageContext(), j, 5), j);
                    this.t.setVisibility(0);
                    this.t.setIsShow(true);
                    if (this.a != null) {
                        this.a.r2(this.t);
                        return;
                    }
                    return;
                }
                this.t.setVisibility(8);
                this.t.setIsShow(false);
                if (this.a != null) {
                    this.a.r2(null);
                }
            } catch (CardParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.repackage.cc7
    public nd7 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.s : (nd7) invokeV.objValue;
    }

    public final void s0(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, jSONObject) == null) || (optJSONObject = jSONObject.optJSONObject("float_btn")) == null) {
            return;
        }
        String optString = optJSONObject.optString("icon_url");
        String optString2 = optJSONObject.optString("icon_url_night");
        String optString3 = optJSONObject.optString("scheme");
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            optString = optString2;
        }
        this.m.setVisibility(0);
        this.m.J(optString, 10, false);
        this.m.setOnClickListener(new b(this, optString3));
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.w == null) {
                this.w = VoiceManager.instance();
            }
            return this.w;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.repackage.cc7
    public LegoListFragment v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.a : (LegoListFragment) invokeV.objValue;
    }
}
