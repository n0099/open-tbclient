package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.InterestGuideActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.PbCommentFloatActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.WriteTipBubbleController;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.mutiprocess.prePageKey.PrePageKeyEvent;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.switchs.PbLoadingViewOptimizeSwitch;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tieba.R;
import com.baidu.tieba.cv6;
import com.baidu.tieba.cz7;
import com.baidu.tieba.dh;
import com.baidu.tieba.di0;
import com.baidu.tieba.dj;
import com.baidu.tieba.dv6;
import com.baidu.tieba.eh6;
import com.baidu.tieba.ei0;
import com.baidu.tieba.ej;
import com.baidu.tieba.ex4;
import com.baidu.tieba.funAd.http.FunAdRecordHttpMessage;
import com.baidu.tieba.fx4;
import com.baidu.tieba.gh;
import com.baidu.tieba.gz7;
import com.baidu.tieba.hg8;
import com.baidu.tieba.iu8;
import com.baidu.tieba.j75;
import com.baidu.tieba.jv7;
import com.baidu.tieba.k35;
import com.baidu.tieba.n9;
import com.baidu.tieba.na5;
import com.baidu.tieba.nx7;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.q08;
import com.baidu.tieba.s08;
import com.baidu.tieba.t28;
import com.baidu.tieba.un5;
import com.baidu.tieba.vh5;
import com.baidu.tieba.wu6;
import com.baidu.tieba.ww7;
import com.baidu.tieba.xc5;
import com.baidu.tieba.xh5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public abstract class AbsPbActivity extends BaseFragmentActivity implements ww7<PbActivity>, VoiceManager.j, ex4, di0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbModel a;
    public VideoPbViewModel b;
    public Fragment c;
    public final q08 d;
    public final s08 e;
    public View f;
    public boolean g;
    public VoiceManager h;
    public boolean i;
    public boolean j;
    public nx7 k;
    public gz7 l;
    public un5 m;
    public iu8 n;
    @Nullable
    public TiePlusEventController o;
    public boolean p;
    public wu6.h q;
    public final ei0 r;
    public long s;
    public Uri t;
    public PbModel.h u;

    /* loaded from: classes5.dex */
    public class a implements PbModel.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsPbActivity a;

        /* renamed from: com.baidu.tieba.pb.pb.main.AbsPbActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0376a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ a b;

            public RunnableC0376a(a aVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Fragment fragment = this.b.a.c;
                    if ((fragment instanceof PbFragment) && ((PbFragment) fragment).P5() != null && ((PbFragment) this.b.a.c).P5().E0() != null) {
                        AbsPbActivity absPbActivity = this.b.a;
                        absPbActivity.q1(((PbFragment) absPbActivity.c).P5().E0(), ((PbFragment) this.b.a.c).L5(), this.a);
                        this.b.a.p = true;
                        return;
                    }
                    Fragment fragment2 = this.b.a.c;
                    if (!(fragment2 instanceof AbsVideoPbFragment) || ((AbsVideoPbFragment) fragment2).G3() == null) {
                        return;
                    }
                    AbsPbActivity absPbActivity2 = this.b.a;
                    absPbActivity2.q1(((AbsVideoPbFragment) absPbActivity2.c).G3(), ((AbsVideoPbFragment) this.b.a.c).V3(), this.a);
                    this.b.a.p = true;
                }
            }
        }

        public a(AbsPbActivity absPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absPbActivity;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), responsedMessage, Boolean.valueOf(z2), Long.valueOf(j)}) == null) {
                Fragment c1 = this.a.c1();
                if (c1 instanceof t28) {
                    t28 t28Var = (t28) c1;
                    if (t28Var.B0() != null) {
                        t28Var.B0().a(i, z, responsedMessage, z2, j);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void b(jv7 jv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jv7Var) == null) {
                Fragment c1 = this.a.c1();
                if (c1 instanceof t28) {
                    t28 t28Var = (t28) c1;
                    if (t28Var.B0() != null) {
                        t28Var.B0().b(jv7Var);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, jv7 jv7Var, String str, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), jv7Var, str, Integer.valueOf(i4)}) == null) {
                this.a.t1(jv7Var);
                this.a.b.y(this.a.a.I1());
                this.a.b.v(false);
                if (!PbLoadingViewOptimizeSwitch.isSwitchOn()) {
                    AbsPbActivity absPbActivity = this.a;
                    absPbActivity.hideLoadingView(absPbActivity.f);
                }
                if (z) {
                    if (jv7Var != null) {
                        AbsPbActivity absPbActivity2 = this.a;
                        absPbActivity2.hideNetRefreshView(absPbActivity2.f);
                    }
                } else if (!this.a.g && !this.a.a.F2()) {
                    AbsPbActivity absPbActivity3 = this.a;
                    absPbActivity3.showNetRefreshView(absPbActivity3.f, this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c58, str, Integer.valueOf(i)), null, null, true, this.a.getNetRefreshListener());
                    AbsPbActivity absPbActivity4 = this.a;
                    absPbActivity4.setNetRefreshViewEmotionMarginTop(ej.f(absPbActivity4.getActivity(), R.dimen.obfuscated_res_0x7f0702aa));
                }
                Fragment c1 = this.a.c1();
                if (c1 == null) {
                    if (z) {
                        this.a.b.s(jv7Var, 3);
                        PbModel pbModel = this.a.a;
                        if (pbModel != null) {
                            pbModel.cancelLoadData();
                            this.a.a.P3(jv7Var);
                        }
                        AbsPbActivity absPbActivity5 = this.a;
                        if (absPbActivity5.c == null) {
                            absPbActivity5.b1(jv7Var);
                        }
                    } else if (PbLoadingViewOptimizeSwitch.isSwitchOn()) {
                        AbsPbActivity absPbActivity6 = this.a;
                        absPbActivity6.hideLoadingView(absPbActivity6.f);
                    }
                } else if (c1 instanceof t28) {
                    t28 t28Var = (t28) c1;
                    if (t28Var.B0() != null) {
                        t28Var.B0().c(z, i, i2, i3, jv7Var, str, i4);
                    }
                }
                String stringExtra = this.a.getIntent().getStringExtra("key_open_editor_tips");
                if (TextUtils.isEmpty(stringExtra) || this.a.p) {
                    return;
                }
                gh.a().postDelayed(new RunnableC0376a(this, stringExtra), 100L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsPbActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AbsPbActivity absPbActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absPbActivity, Integer.valueOf(i)};
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
            this.a = absPbActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getOrginalMessage().getTag() == this.a.getUniqueId()) {
                PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage;
                jv7 pbData = pbPageReadLocalResponseMessage.getPbData();
                if (pbData == null) {
                    this.a.g = false;
                    return;
                }
                ThreadData O = pbData.O();
                if (O != null) {
                    this.a.a.d1(O);
                }
                this.a.g = true;
                this.a.b.v(false);
                Fragment c1 = this.a.c1();
                if (c1 == null) {
                    this.a.b.s(pbData, 2);
                    AbsPbActivity absPbActivity = this.a;
                    if (absPbActivity.c == null) {
                        absPbActivity.b1(pbData);
                    }
                } else if (c1 instanceof PbFragment) {
                    this.a.a.Z2(pbData, pbPageReadLocalResponseMessage.getUpdateType(), pbPageReadLocalResponseMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements WriteTipBubbleController.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ j75 b;
        public final /* synthetic */ AbsPbActivity c;

        public c(AbsPbActivity absPbActivity, View view2, j75 j75Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absPbActivity, view2, j75Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = absPbActivity;
            this.a = view2;
            this.b = j75Var;
        }

        @Override // com.baidu.tbadk.core.dialog.WriteTipBubbleController.b
        public void a(View view2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, str) == null) {
                this.a.performClick();
                this.b.i();
                this.b.s().i().setText(str);
                Editable text = this.b.s().i().getText();
                if (TextUtils.isEmpty(text)) {
                    return;
                }
                this.b.s().i().setSelection(text.length());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements wu6.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsPbActivity a;

        public d(AbsPbActivity absPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absPbActivity;
        }

        @Override // com.baidu.tieba.wu6.h
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                Fragment fragment = this.a.c;
                if (fragment instanceof PbFragment) {
                    PbFragment pbFragment = (PbFragment) fragment;
                    if (pbFragment.P5() != null && pbFragment.P5().D0() != null) {
                        pbFragment.P5().D0().E0();
                    }
                }
                FunAdRecordHttpMessage.uploadRequestRecord("a005", "0", this.a.a.S1().Q(), this.a.a.S1().m(), null);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a005").param("obj_locate", 0).param(TiebaStatic.Params.RESOURCE_ID, i).param("obj_param1", "1"));
            }
        }

        @Override // com.baidu.tieba.wu6.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                FunAdRecordHttpMessage.uploadRequestRecord("a005", "1", this.a.a.S1().Q(), this.a.a.S1().m(), "0");
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a005").param("obj_locate", 1).param(TiebaStatic.Params.RESOURCE_ID, 0).param("obj_param1", "1"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ArrayList<String> a;
        public ConcurrentHashMap<String, ImageUrlData> b;
        public String c;
        public String d;
        public String e;
        public String f;
        public boolean g;
        public boolean h;
        public String i;
        public int j;

        public e() {
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
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = false;
            this.i = "";
            this.j = 0;
        }
    }

    public AbsPbActivity() {
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
        this.d = new q08(this);
        this.e = new s08(getPageContext());
        this.i = false;
        this.j = false;
        this.r = new ei0();
        this.u = new a(this);
    }

    @Override // com.baidu.tieba.ww7
    public boolean F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            PbModel pbModel = this.a;
            return pbModel != null && pbModel.K2(str);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ex4
    public String L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null) {
                return pbModel.m2();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ww7
    public int T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null || pbModel.S1() == null) {
                return 0;
            }
            return this.a.S1().W();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.di0
    @NonNull
    public ei0 U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.r : (ei0) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ww7
    public String X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null) {
                return pbModel.r1();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public Fragment a1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if ("video_pb_fragment_tag".equals(str)) {
                return new VideoPbFragment();
            }
            return PbFragment.E6();
        }
        return (Fragment) invokeL.objValue;
    }

    public final void b1(jv7 jv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jv7Var) == null) {
            String h1 = h1(jv7Var);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            if (supportFragmentManager.findFragmentByTag(h1) == null) {
                this.c = a1(h1);
                supportFragmentManager.beginTransaction().add(R.id.obfuscated_res_0x7f0906d3, this.c, h1).commitAllowingStateLoss();
            }
        }
    }

    public Fragment c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            List<Fragment> fragments = getSupportFragmentManager().getFragments();
            if (ListUtils.isEmpty(fragments)) {
                return null;
            }
            return fragments.get(0);
        }
        return (Fragment) invokeV.objValue;
    }

    public abstract int d1();

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, motionEvent)) == null) {
            this.r.a(motionEvent);
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i e1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (getIntent().getParcelableExtra("video_origin_area") == null && !this.i && !this.j) {
                super.enterExitAnimation();
            } else {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            }
        }
    }

    public long f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.s : invokeV.longValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        gz7 gz7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (!TbSingleton.getInstance().isNeedShowInterestGuide() && (gz7Var = this.l) != null) {
                gz7Var.a(this.a);
            }
            Fragment c1 = c1();
            if (c1 instanceof t28) {
                ((t28) c1).finish();
            } else {
                super.finish();
            }
            nx7 nx7Var = this.k;
            if (nx7Var == null || nx7Var.b(this.a)) {
                return;
            }
            if (this.i || this.j) {
                if (TbSingleton.getInstance().isNeedShowInterestGuide()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new InterestGuideActivityConfig(this)));
                } else {
                    sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
                }
            }
        }
    }

    @Override // com.baidu.tieba.ex4
    public String g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null) {
                return pbModel.getForumId();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tieba.uc5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? "a005" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean getGpuSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? TbadkCoreApplication.getInst().isGpuOpen() : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public xc5 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            xc5 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                PbModel pbModel = this.a;
                if (pbModel != null) {
                    if (pbModel.S1() != null) {
                        ThreadData O = this.a.S1().O();
                        pageStayDurationItem.u(O.getNid());
                        if (O.isNormalThreadType()) {
                            pageStayDurationItem.t = "1";
                        } else if (O.isVideoThreadType()) {
                            pageStayDurationItem.t = "2";
                        } else {
                            pageStayDurationItem.t = "3";
                        }
                    }
                    pageStayDurationItem.C(dh.g(this.a.m2(), 0L));
                    if (this.a.S1() != null && this.a.S1().O() != null) {
                        pageStayDurationItem.u(this.a.S1().O().getNid());
                        pageStayDurationItem.B(this.a.S1().O().getThreadType());
                    }
                }
                if (!dj.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    pageStayDurationItem.z(TbadkCoreApplication.getInst().getTaskId());
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                    pageStayDurationItem.q(TbadkCoreApplication.getInst().getAdAdSense().k);
                }
                Fragment c1 = c1();
                if (c1 instanceof PbFragment) {
                    int i = ((PbFragment) c1).r1;
                    if (i == 2) {
                        pageStayDurationItem.v("a002");
                    } else if (i == 1) {
                        pageStayDurationItem.v("a038");
                    } else if (i == 3) {
                        pageStayDurationItem.v("a006");
                    }
                }
                if (!StringUtils.isNull(this.a.mTopicId)) {
                    pageStayDurationItem.D(this.a.mTopicId);
                } else {
                    Uri uri = this.t;
                    if (uri != null && vh5.b(uri).booleanValue()) {
                        pageStayDurationItem.D(vh5.d(this.t.toString()));
                    }
                }
                if (!StringUtils.isNull(this.a.mTopicSubjectName)) {
                    pageStayDurationItem.E(this.a.mTopicSubjectName);
                } else {
                    Uri uri2 = this.t;
                    if (uri2 != null && vh5.b(uri2).booleanValue()) {
                        pageStayDurationItem.E("hottopic_detail_hybrid");
                    }
                }
            }
            return pageStayDurationItem;
        }
        return (xc5) invokeV.objValue;
    }

    public View getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f : (View) invokeV.objValue;
    }

    public final String h1(jv7 jv7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, jv7Var)) == null) ? (jv7Var == null || !jv7Var.u0()) ? "pb_fragment_tag" : "video_pb_fragment_tag" : (String) invokeL.objValue;
    }

    public abstract int i1();

    public PbModel j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.a : (PbModel) invokeV.objValue;
    }

    public abstract int k1();

    @NonNull
    public TiePlusEventController l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            xh5.b(this.o);
            return this.o;
        }
        return (TiePlusEventController) invokeV.objValue;
    }

    public final void m1() {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (intent = getIntent()) == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("target_scheme");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        UrlSchemaHelper.goToNewPageByScheme(stringExtra);
    }

    public final void n1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bundle) == null) {
            this.b.a(this.a);
            cz7.b().p(this.a.e1(), this.a.B1());
            registerListener(new b(this, 2004003));
            if (!this.a.X2()) {
                this.a.T2();
            }
            if (this.a.F2()) {
                jv7 c1 = this.a.c1(eh6.a());
                if (c1 != null) {
                    if (this.a.S1() != null) {
                        this.a.S1().N0(c1.O());
                    }
                    c1.B0(3);
                    if (c1() == null) {
                        this.b.s(c1, 1);
                        if (this.c == null) {
                            b1(c1);
                        }
                    }
                }
                if (i1() == 0) {
                    this.b.v(false);
                } else {
                    showLoadingView(findViewById(R.id.obfuscated_res_0x7f0906d3), true);
                    this.b.v(true);
                }
            } else {
                showLoadingView(findViewById(R.id.obfuscated_res_0x7f0906d3), true);
                this.b.v(true);
            }
            if (ej.D() && !TbadkCoreApplication.getInst().syncHasFinish) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
            }
            r1();
            s1();
        }
    }

    public final void o1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bundle) == null) {
            if (bundle != null) {
                this.a = new PbModel(this, bundle, this.u);
            } else {
                this.a = new PbModel(this, getIntent(), this.u);
            }
            setForceInterceptStimeStat(this.a.w2());
            this.a.E3(k1());
            this.a.s3(i1());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048604, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            Fragment c1 = c1();
            if (c1 != null) {
                c1.onActivityResult(i, i2, intent);
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.onBackPressed();
            Fragment c1 = c1();
            if (c1 instanceof PbFragment) {
                ((PbFragment) c1).F6();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            Fragment c1 = c1();
            if (c1 instanceof BaseFragment) {
                ((BaseFragment) c1).onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int intExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bundle) == null) {
            this.s = System.currentTimeMillis();
            initUniqueId();
            p1();
            o1(bundle);
            boolean z = true;
            if (!n9.g().i("MainTabActivity")) {
                if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null) {
                    this.i = true;
                } else if (j1().R1() == 7) {
                    this.j = true;
                }
            }
            if (this.i || this.j) {
                setIsAddSwipeBackLayout(false);
            }
            super.onCreate(bundle);
            m1();
            setContentView(d1());
            this.f = findViewById(R.id.obfuscated_res_0x7f0906d3);
            adjustResizeForSoftInput();
            addGlobalLayoutListener();
            n1(bundle);
            VoiceManager voiceManager = new VoiceManager();
            this.h = voiceManager;
            voiceManager.onCreate(getPageContext());
            this.k = new nx7(getPageContext());
            this.l = new gz7(getPageContext());
            this.m = new un5(getPageContext(), "client_pb_live");
            this.n = new iu8(getPageContext(), getUniqueId());
            if (this.o == null) {
                if (getIntent() == null || ((intExtra = getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_VIDEO_PAGE_TYPE, 0)) != 1 && intExtra != 2 && intExtra != 3 && intExtra != 4 && intExtra != 5)) {
                    z = false;
                }
                if (z) {
                    this.o = new TiePlusEventController(this, TiePlusStat.Locate.VIDEO_MIDDLE_COMMENT);
                } else {
                    this.o = new TiePlusEventController(this, TiePlusStat.Locate.PB);
                }
            }
            getLifecycle().addObserver(this.o);
            if (this.a != null) {
                fx4.d(this.a.m2() + "_onCreate_" + System.currentTimeMillis());
            }
            k35.b(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            super.onDestroy();
            VoiceManager voiceManager = this.h;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            un5 un5Var = this.m;
            if (un5Var != null) {
                un5Var.h();
            }
            iu8 iu8Var = this.n;
            if (iu8Var != null) {
                iu8Var.l();
            }
            TbPageExtraHelper.setPrePageKey(getCurrentPageKey());
            na5.i(new PrePageKeyEvent(getCurrentPageKey()));
            if (this.q != null) {
                this.q = null;
            }
            if (this.o != null) {
                getLifecycle().removeObserver(this.o);
            }
            this.c = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048609, this, i, keyEvent)) == null) {
            Fragment c1 = c1();
            if (c1 instanceof PbFragment) {
                if (((PbFragment) c1).G6(i, keyEvent)) {
                    return true;
                }
            } else if ((c1 instanceof AbsVideoPbFragment) && ((AbsVideoPbFragment) c1).I4(i, keyEvent)) {
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            super.onKeyboardVisibilityChanged(z);
            Fragment c1 = c1();
            if (c1 instanceof AbsVideoPbFragment) {
                ((AbsVideoPbFragment) c1).J4(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            super.onNetRefreshButtonClicked();
            if (this.a != null) {
                this.b.v(true);
                showLoadingView(this.f);
                this.a.T2();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            super.onPause();
            VoiceManager voiceManager = this.h;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
            TiePlusEventController tiePlusEventController = this.o;
            if (tiePlusEventController != null) {
                tiePlusEventController.onPause();
            }
            SpeedStatsManager.getInstance().setStatsFlag(-1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048613, this, i, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            super.onResume();
            if (this.a != null) {
                cz7.b().p(this.a.e1(), this.a.B1());
            }
            VoiceManager voiceManager = this.h;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            TiePlusEventController tiePlusEventController = this.o;
            if (tiePlusEventController != null) {
                tiePlusEventController.onResume();
            }
            Fragment fragment = this.c;
            if (fragment instanceof BaseFragment) {
                ((BaseFragment) fragment).setPrimary(true);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            PbModel pbModel = this.a;
            if (pbModel != null) {
                pbModel.n3(bundle);
            }
            VoiceManager voiceManager = this.h;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onScreenShot(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            super.onScreenShot(str);
            PbModel pbModel = this.a;
            if (pbModel == null || pbModel.S1() == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_SCREEN_SHOT);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", this.a.m2());
            statisticItem.param("fid", this.a.S1().m());
            statisticItem.param("obj_type", 3);
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.h;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            super.onStop();
            VoiceManager voiceManager = this.h;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            Fragment fragment = this.c;
            if (fragment instanceof BaseFragment) {
                ((BaseFragment) fragment).setPrimary(false);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            super.onWindowFocusChanged(z);
            Fragment fragment = this.c;
            if (fragment instanceof AbsVideoPbFragment) {
                ((AbsVideoPbFragment) fragment).M4(z);
            }
        }
    }

    public final void p1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(this).get(VideoPbViewModel.class);
            this.b = videoPbViewModel;
            videoPbViewModel.l(getIntent());
        }
    }

    public final void q1(View view2, j75 j75Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048621, this, view2, j75Var, str) == null) {
            new WriteTipBubbleController(getPageContext(), new c(this, view2, j75Var)).d(view2, getString(R.string.obfuscated_res_0x7f0f0d0e), str, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_PB_REPLY);
        }
    }

    public final void r1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            boolean z = true;
            if (((TbadkCoreApplication.getCurrentAccountInfo() == null || TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() != 1) ? false : false) || !UbsABTestHelper.isPbPageBannerFunAdSdkTest()) {
                return;
            }
            Activity f = n9.g().f(0);
            if (this.q == null) {
                this.q = new d(this);
            }
            FunAdRecordHttpMessage.uploadRequestRecord("a005", null, this.a.S1().Q(), this.a.S1().m(), null);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("tid", this.a.S1().Q()).param("fid", this.a.S1().m()).param("obj_type", "a005").param("obj_param1", "1"));
            String d2 = cv6.e().d("pb_banner");
            wu6 m = wu6.m();
            if (f == null) {
                f = this;
            }
            m.x(f, d2, this.q, wu6.b("pb", UbsABTestHelper.isPbPageBannerFunAdSdkTest() ? "1" : "0"));
        }
    }

    public final void s1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048623, this) == null) && !dv6.f() && UbsABTestHelper.isPbCommentFunAdABTest()) {
            wu6 m = wu6.m();
            String f = wu6.f();
            wu6.g b2 = wu6.b("pb", UbsABTestHelper.isPbPageBannerFunAdSdkTest() ? "1" : "0");
            PbModel pbModel = this.a;
            String Q = (pbModel == null || pbModel.S1() == null) ? "" : this.a.S1().Q();
            PbModel pbModel2 = this.a;
            m.L(this, f, b2, Q, (pbModel2 == null || pbModel2.S1() == null) ? "" : this.a.S1().m());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean shouldChangeStatusBarIconAndTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? !(this.c instanceof AbsVideoPbFragment) : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.h : (VoiceManager) invokeV.objValue;
    }

    public final void t1(jv7 jv7Var) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048626, this, jv7Var) == null) || jv7Var == null || jv7Var.l() == null || (intent = getIntent()) == null) {
            return;
        }
        Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
        this.t = uri;
        hg8.d().g(uri, jv7Var.l().getId());
    }

    @Override // com.baidu.tieba.ww7
    public boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null) {
                return false;
            }
            return pbModel.J2();
        }
        return invokeV.booleanValue;
    }

    public void u1(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048628, this, str) == null) || str == null || this.n == null) {
            return;
        }
        this.n.n(dh.g(str, 0L));
    }

    public void v1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            super.finish();
        }
    }

    @Override // com.baidu.tieba.ww7
    public q08 z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.d : (q08) invokeV.objValue;
    }
}
