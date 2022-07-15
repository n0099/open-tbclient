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
import com.baidu.tieba.funAd.http.FunAdRecordHttpMessage;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dd6;
import com.repackage.ep8;
import com.repackage.fj5;
import com.repackage.fr6;
import com.repackage.fv7;
import com.repackage.gr6;
import com.repackage.jr7;
import com.repackage.jv7;
import com.repackage.lg0;
import com.repackage.mg0;
import com.repackage.n35;
import com.repackage.ng;
import com.repackage.nt4;
import com.repackage.oi;
import com.repackage.oz4;
import com.repackage.pi;
import com.repackage.qg;
import com.repackage.qt7;
import com.repackage.qy7;
import com.repackage.r65;
import com.repackage.rw7;
import com.repackage.tw7;
import com.repackage.ub8;
import com.repackage.ws7;
import com.repackage.xd5;
import com.repackage.y85;
import com.repackage.z8;
import com.repackage.zq6;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public abstract class AbsPbActivity extends BaseFragmentActivity implements ws7<PbActivity>, VoiceManager.j, nt4, lg0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbModel a;
    public VideoPbViewModel b;
    public Fragment c;
    public final rw7 d;
    public final tw7 e;
    public View f;
    public boolean g;
    public VoiceManager h;
    public boolean i;
    public boolean j;
    public qt7 k;
    public jv7 l;
    public fj5 m;
    public ep8 n;
    @Nullable
    public TiePlusEventController o;
    public boolean p;
    public zq6.h q;
    public final mg0 r;
    public long s;
    public PbModel.h t;

    /* loaded from: classes3.dex */
    public class a implements PbModel.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsPbActivity a;

        /* renamed from: com.baidu.tieba.pb.pb.main.AbsPbActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0231a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ a b;

            public RunnableC0231a(a aVar, String str) {
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
                    if ((fragment instanceof PbFragment) && ((PbFragment) fragment).O5() != null && ((PbFragment) this.b.a.c).O5().B0() != null) {
                        AbsPbActivity absPbActivity = this.b.a;
                        absPbActivity.W0(((PbFragment) absPbActivity.c).O5().B0(), ((PbFragment) this.b.a.c).K5(), this.a);
                        this.b.a.p = true;
                        return;
                    }
                    Fragment fragment2 = this.b.a.c;
                    if (!(fragment2 instanceof AbsVideoPbFragment) || ((AbsVideoPbFragment) fragment2).J3() == null) {
                        return;
                    }
                    AbsPbActivity absPbActivity2 = this.b.a;
                    absPbActivity2.W0(((AbsVideoPbFragment) absPbActivity2.c).J3(), ((AbsVideoPbFragment) this.b.a.c).Y3(), this.a);
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
                Fragment E0 = this.a.E0();
                if (E0 instanceof qy7) {
                    qy7 qy7Var = (qy7) E0;
                    if (qy7Var.D0() != null) {
                        qy7Var.D0().a(i, z, responsedMessage, z2, j);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void b(jr7 jr7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jr7Var) == null) {
                Fragment E0 = this.a.E0();
                if (E0 instanceof qy7) {
                    qy7 qy7Var = (qy7) E0;
                    if (qy7Var.D0() != null) {
                        qy7Var.D0().b(jr7Var);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, jr7 jr7Var, String str, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), jr7Var, str, Integer.valueOf(i4)}) == null) {
                this.a.b1(jr7Var);
                this.a.b.y(this.a.a.H1());
                this.a.b.v(false);
                if (!PbLoadingViewOptimizeSwitch.isSwitchOn()) {
                    AbsPbActivity absPbActivity = this.a;
                    absPbActivity.hideLoadingView(absPbActivity.f);
                }
                if (z) {
                    if (jr7Var != null) {
                        AbsPbActivity absPbActivity2 = this.a;
                        absPbActivity2.hideNetRefreshView(absPbActivity2.f);
                    }
                } else if (!this.a.g && !this.a.a.C2()) {
                    AbsPbActivity absPbActivity3 = this.a;
                    absPbActivity3.showNetRefreshView(absPbActivity3.f, this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c2a, str, Integer.valueOf(i)), null, null, true, this.a.getNetRefreshListener());
                    AbsPbActivity absPbActivity4 = this.a;
                    absPbActivity4.setNetRefreshViewEmotionMarginTop(pi.f(absPbActivity4.getActivity(), R.dimen.obfuscated_res_0x7f0702ac));
                }
                Fragment E0 = this.a.E0();
                if (E0 == null) {
                    if (z) {
                        this.a.b.s(jr7Var, 3);
                        PbModel pbModel = this.a.a;
                        if (pbModel != null) {
                            pbModel.cancelLoadData();
                            this.a.a.M3(jr7Var);
                        }
                        AbsPbActivity absPbActivity5 = this.a;
                        if (absPbActivity5.c == null) {
                            absPbActivity5.D0(jr7Var);
                        }
                    } else if (PbLoadingViewOptimizeSwitch.isSwitchOn()) {
                        AbsPbActivity absPbActivity6 = this.a;
                        absPbActivity6.hideLoadingView(absPbActivity6.f);
                    }
                } else if (E0 instanceof qy7) {
                    qy7 qy7Var = (qy7) E0;
                    if (qy7Var.D0() != null) {
                        qy7Var.D0().c(z, i, i2, i3, jr7Var, str, i4);
                    }
                }
                String stringExtra = this.a.getIntent().getStringExtra("key_open_editor_tips");
                if (TextUtils.isEmpty(stringExtra) || this.a.p) {
                    return;
                }
                qg.a().postDelayed(new RunnableC0231a(this, stringExtra), 100L);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                jr7 pbData = pbPageReadLocalResponseMessage.getPbData();
                if (pbData == null) {
                    this.a.g = false;
                    return;
                }
                ThreadData O = pbData.O();
                if (O != null) {
                    this.a.a.c1(O);
                }
                this.a.g = true;
                this.a.b.v(false);
                Fragment E0 = this.a.E0();
                if (E0 == null) {
                    this.a.b.s(pbData, 2);
                    AbsPbActivity absPbActivity = this.a;
                    if (absPbActivity.c == null) {
                        absPbActivity.D0(pbData);
                    }
                } else if (E0 instanceof PbFragment) {
                    this.a.a.W2(pbData, pbPageReadLocalResponseMessage.getUpdateType(), pbPageReadLocalResponseMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements WriteTipBubbleController.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ n35 b;
        public final /* synthetic */ AbsPbActivity c;

        public c(AbsPbActivity absPbActivity, View view2, n35 n35Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absPbActivity, view2, n35Var};
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
            this.b = n35Var;
        }

        @Override // com.baidu.tbadk.core.dialog.WriteTipBubbleController.b
        public void a(View view2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, str) == null) {
                this.a.performClick();
                this.b.l();
                this.b.v().i().setText(str);
                Editable text = this.b.v().i().getText();
                if (TextUtils.isEmpty(text)) {
                    return;
                }
                this.b.v().i().setSelection(text.length());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements zq6.h {
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

        @Override // com.repackage.zq6.h
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                Fragment fragment = this.a.c;
                if (fragment instanceof PbFragment) {
                    PbFragment pbFragment = (PbFragment) fragment;
                    if (pbFragment.O5() != null && pbFragment.O5().A0() != null) {
                        pbFragment.O5().A0().A0();
                    }
                }
                FunAdRecordHttpMessage.uploadRequestRecord("a005", "0", this.a.a.R1().Q(), this.a.a.R1().m(), null);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a005").param("obj_locate", 0).param(TiebaStatic.Params.RESOURCE_ID, i).param("obj_param1", "1"));
            }
        }

        @Override // com.repackage.zq6.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                FunAdRecordHttpMessage.uploadRequestRecord("a005", "1", this.a.a.R1().Q(), this.a.a.R1().m(), "0");
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a005").param("obj_locate", 1).param(TiebaStatic.Params.RESOURCE_ID, 0).param("obj_param1", "1"));
            }
        }
    }

    /* loaded from: classes3.dex */
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
        this.d = new rw7(this);
        this.e = new tw7(getPageContext());
        this.i = false;
        this.j = false;
        this.r = new mg0();
        this.t = new a(this);
    }

    @Override // com.repackage.ws7
    public rw7 A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.d : (rw7) invokeV.objValue;
    }

    public Fragment C0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if ("video_pb_fragment_tag".equals(str)) {
                return new VideoPbFragment();
            }
            return PbFragment.B6();
        }
        return (Fragment) invokeL.objValue;
    }

    public final void D0(jr7 jr7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jr7Var) == null) {
            String H0 = H0(jr7Var);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            if (supportFragmentManager.findFragmentByTag(H0) == null) {
                this.c = C0(H0);
                supportFragmentManager.beginTransaction().add(R.id.obfuscated_res_0x7f0906a0, this.c, H0).commitAllowingStateLoss();
            }
        }
    }

    public Fragment E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<Fragment> fragments = getSupportFragmentManager().getFragments();
            if (ListUtils.isEmpty(fragments)) {
                return null;
            }
            return fragments.get(0);
        }
        return (Fragment) invokeV.objValue;
    }

    public abstract int F0();

    @Override // com.repackage.ws7
    public boolean G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            PbModel pbModel = this.a;
            return pbModel != null && pbModel.H2(str);
        }
        return invokeL.booleanValue;
    }

    public long G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.s : invokeV.longValue;
    }

    public final String H0(jr7 jr7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, jr7Var)) == null) ? (jr7Var == null || !jr7Var.r0()) ? "pb_fragment_tag" : "video_pb_fragment_tag" : (String) invokeL.objValue;
    }

    public abstract int L0();

    public PbModel M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.a : (PbModel) invokeV.objValue;
    }

    public View N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f : (View) invokeV.objValue;
    }

    public abstract int O0();

    @NonNull
    public TiePlusEventController P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            xd5.b(this.o);
            return this.o;
        }
        return (TiePlusEventController) invokeV.objValue;
    }

    public final void Q0() {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (intent = getIntent()) == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("target_scheme");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        UrlSchemaHelper.goToNewPageByScheme(stringExtra);
    }

    @Override // com.repackage.ws7
    public int T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null || pbModel.R1() == null) {
                return 0;
            }
            return this.a.R1().V();
        }
        return invokeV.intValue;
    }

    public final void T0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
            this.b.a(this.a);
            fv7.b().p(this.a.d1(), this.a.A1());
            registerListener(new b(this, 2004003));
            if (!this.a.U2()) {
                this.a.Q2();
            }
            if (this.a.C2()) {
                jr7 b1 = this.a.b1(dd6.a());
                if (b1 != null) {
                    if (this.a.R1() != null) {
                        this.a.R1().K0(b1.O());
                    }
                    b1.y0(3);
                    if (E0() == null) {
                        this.b.s(b1, 1);
                        if (this.c == null) {
                            D0(b1);
                        }
                    }
                }
                if (L0() == 0) {
                    this.b.v(false);
                } else {
                    showLoadingView(findViewById(R.id.obfuscated_res_0x7f0906a0), true);
                    this.b.v(true);
                }
            } else {
                showLoadingView(findViewById(R.id.obfuscated_res_0x7f0906a0), true);
                this.b.v(true);
            }
            if (pi.D() && !TbadkCoreApplication.getInst().syncHasFinish) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
            }
            X0();
            a1();
        }
    }

    @Override // com.repackage.lg0
    @NonNull
    public mg0 U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.r : (mg0) invokeV.objValue;
    }

    public final void U0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            if (bundle != null) {
                this.a = new PbModel(this, bundle, this.t);
            } else {
                this.a = new PbModel(this, getIntent(), this.t);
            }
            setForceInterceptStimeStat(this.a.t2());
            this.a.B3(O0());
            this.a.p3(L0());
        }
    }

    public final void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(this).get(VideoPbViewModel.class);
            this.b = videoPbViewModel;
            videoPbViewModel.l(getIntent());
        }
    }

    public final void W0(View view2, n35 n35Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048595, this, view2, n35Var, str) == null) {
            new WriteTipBubbleController(getPageContext(), new c(this, view2, n35Var)).d(view2, getString(R.string.obfuscated_res_0x7f0f0cde), str, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_PB_REPLY);
        }
    }

    public final void X0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            boolean z = true;
            if (((TbadkCoreApplication.getCurrentAccountInfo() == null || TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() != 1) ? false : false) || !UbsABTestHelper.isPbPageBannerFunAdSdkTest()) {
                return;
            }
            Activity f = z8.g().f(0);
            if (this.q == null) {
                this.q = new d(this);
            }
            FunAdRecordHttpMessage.uploadRequestRecord("a005", null, this.a.R1().Q(), this.a.R1().m(), null);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("tid", this.a.R1().Q()).param("fid", this.a.R1().m()).param("obj_type", "a005").param("obj_param1", "1"));
            String d2 = fr6.e().d("pb_banner");
            zq6 m = zq6.m();
            if (f == null) {
                f = this;
            }
            m.y(f, d2, this.q, zq6.b("pb", UbsABTestHelper.isPbPageBannerFunAdSdkTest() ? "1" : "0"));
        }
    }

    @Override // com.repackage.ws7
    public String Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null) {
                return pbModel.q1();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public final void a1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && !gr6.f() && UbsABTestHelper.isPbCommentFunAdABTest()) {
            zq6 m = zq6.m();
            String f = zq6.f();
            zq6.g b2 = zq6.b("pb", UbsABTestHelper.isPbPageBannerFunAdSdkTest() ? "1" : "0");
            PbModel pbModel = this.a;
            String Q = (pbModel == null || pbModel.R1() == null) ? "" : this.a.R1().Q();
            PbModel pbModel2 = this.a;
            m.M(this, f, b2, Q, (pbModel2 == null || pbModel2.R1() == null) ? "" : this.a.R1().m());
        }
    }

    public final void b1(jr7 jr7Var) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, jr7Var) == null) || jr7Var == null || jr7Var.l() == null || (intent = getIntent()) == null) {
            return;
        }
        ub8.d().g((Uri) intent.getParcelableExtra(IntentConfig.KEY_URI), jr7Var.l().getId());
    }

    public void c1(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, str) == null) || str == null || this.n == null) {
            return;
        }
        this.n.n(ng.g(str, 0L));
    }

    public void d1() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (voiceManager = this.h) == null) {
            return;
        }
        voiceManager.stopPlay();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, motionEvent)) == null) {
            this.r.a(motionEvent);
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void e1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (getIntent().getParcelableExtra("video_origin_area") == null && !this.i && !this.j) {
                super.enterExitAnimation();
            } else {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i f1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        jv7 jv7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            if (!TbSingleton.getInstance().isNeedShowInterestGuide() && (jv7Var = this.l) != null) {
                jv7Var.a(this.a);
            }
            Fragment E0 = E0();
            if (E0 instanceof qy7) {
                ((qy7) E0).finish();
            } else {
                super.finish();
            }
            qt7 qt7Var = this.k;
            if (qt7Var == null || qt7Var.b(this.a)) {
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.repackage.v85
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? "a005" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean getGpuSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? TbadkCoreApplication.getInst().isGpuOpen() : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public y85 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            y85 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                PbModel pbModel = this.a;
                if (pbModel != null) {
                    if (pbModel.R1() != null) {
                        ThreadData O = this.a.R1().O();
                        pageStayDurationItem.u(O.getNid());
                        if (O.isNormalThreadType()) {
                            pageStayDurationItem.t = "1";
                        } else if (O.isVideoThreadType()) {
                            pageStayDurationItem.t = "2";
                        } else {
                            pageStayDurationItem.t = "3";
                        }
                    }
                    pageStayDurationItem.C(ng.g(this.a.j2(), 0L));
                    if (this.a.R1() != null && this.a.R1().O() != null) {
                        pageStayDurationItem.u(this.a.R1().O().getNid());
                        pageStayDurationItem.B(this.a.R1().O().getThreadType());
                    }
                }
                if (!oi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    pageStayDurationItem.z(TbadkCoreApplication.getInst().getTaskId());
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                    pageStayDurationItem.q(TbadkCoreApplication.getInst().getAdAdSense().k);
                }
                Fragment E0 = E0();
                if (E0 instanceof PbFragment) {
                    int i = ((PbFragment) E0).t1;
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
                }
                if (!StringUtils.isNull(this.a.mTopicSubjectName)) {
                    pageStayDurationItem.E(this.a.mTopicSubjectName);
                }
            }
            return pageStayDurationItem;
        }
        return (y85) invokeV.objValue;
    }

    @Override // com.repackage.nt4
    public String m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null) {
                return pbModel.j2();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048612, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            Fragment E0 = E0();
            if (E0 != null) {
                E0.onActivityResult(i, i2, intent);
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.onBackPressed();
            Fragment E0 = E0();
            if (E0 instanceof PbFragment) {
                ((PbFragment) E0).C6();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            Fragment E0 = E0();
            if (E0 instanceof BaseFragment) {
                ((BaseFragment) E0).onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int intExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, bundle) == null) {
            this.s = System.currentTimeMillis();
            initUniqueId();
            V0();
            U0(bundle);
            boolean z = true;
            if (!z8.g().i("MainTabActivity")) {
                if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null) {
                    this.i = true;
                } else if (M0().Q1() == 7) {
                    this.j = true;
                }
            }
            if (this.i || this.j) {
                setIsAddSwipeBackLayout(false);
            }
            super.onCreate(bundle);
            Q0();
            setContentView(F0());
            this.f = findViewById(R.id.obfuscated_res_0x7f0906a0);
            adjustResizeForSoftInput();
            addGlobalLayoutListener();
            T0(bundle);
            VoiceManager voiceManager = new VoiceManager();
            this.h = voiceManager;
            voiceManager.onCreate(getPageContext());
            this.k = new qt7(getPageContext());
            this.l = new jv7(getPageContext());
            this.m = new fj5(getPageContext(), "client_pb_live");
            this.n = new ep8(getPageContext(), getUniqueId());
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
            oz4.b(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            super.onDestroy();
            VoiceManager voiceManager = this.h;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            fj5 fj5Var = this.m;
            if (fj5Var != null) {
                fj5Var.h();
            }
            ep8 ep8Var = this.n;
            if (ep8Var != null) {
                ep8Var.l();
            }
            TbPageExtraHelper.setPrePageKey(getCurrentPageKey());
            r65.i(new PrePageKeyEvent(getCurrentPageKey()));
            if (this.q != null) {
                this.q = null;
            }
            if (this.o != null) {
                getLifecycle().removeObserver(this.o);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048617, this, i, keyEvent)) == null) {
            Fragment E0 = E0();
            if (E0 instanceof PbFragment) {
                if (((PbFragment) E0).D6(i, keyEvent)) {
                    return true;
                }
            } else if ((E0 instanceof AbsVideoPbFragment) && ((AbsVideoPbFragment) E0).M4(i, keyEvent)) {
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            super.onKeyboardVisibilityChanged(z);
            Fragment E0 = E0();
            if (E0 instanceof AbsVideoPbFragment) {
                ((AbsVideoPbFragment) E0).N4(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            super.onNetRefreshButtonClicked();
            if (this.a != null) {
                this.b.v(true);
                showLoadingView(this.f);
                this.a.Q2();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
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
        if (interceptable == null || interceptable.invokeILL(1048621, this, i, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i, strArr, iArr);
            if (i == 0) {
                Fragment fragment = this.c;
                if ((fragment instanceof PbFragment) && ((PbFragment) fragment).K5() != null) {
                    ((PbFragment) this.c).K5().z0();
                    return;
                }
                Fragment fragment2 = this.c;
                if (!(fragment2 instanceof AbsVideoPbFragment) || ((AbsVideoPbFragment) fragment2).Y3() == null) {
                    return;
                }
                ((AbsVideoPbFragment) this.c).Y3().z0();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            super.onResume();
            if (this.a != null) {
                fv7.b().p(this.a.d1(), this.a.A1());
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
        if (interceptable == null || interceptable.invokeL(1048623, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            PbModel pbModel = this.a;
            if (pbModel != null) {
                pbModel.k3(bundle);
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
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            super.onScreenShot(str);
            PbModel pbModel = this.a;
            if (pbModel == null || pbModel.R1() == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_SCREEN_SHOT);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", this.a.j2());
            statisticItem.param("fid", this.a.R1().m());
            statisticItem.param("obj_type", 3);
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            super.onWindowFocusChanged(z);
            Fragment fragment = this.c;
            if (fragment instanceof AbsVideoPbFragment) {
                ((AbsVideoPbFragment) fragment).Q4(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean shouldChangeStatusBarIconAndTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? !(this.c instanceof AbsVideoPbFragment) : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.h : (VoiceManager) invokeV.objValue;
    }

    @Override // com.repackage.ws7
    public boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null) {
                return false;
            }
            return pbModel.G2();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.nt4
    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null) {
                return pbModel.getForumId();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }
}
