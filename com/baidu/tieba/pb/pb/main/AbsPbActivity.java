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
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.tieba.a18;
import com.baidu.tieba.al5;
import com.baidu.tieba.az7;
import com.baidu.tieba.df5;
import com.baidu.tieba.df6;
import com.baidu.tieba.ea5;
import com.baidu.tieba.es8;
import com.baidu.tieba.ft6;
import com.baidu.tieba.funAd.http.FunAdRecordHttpMessage;
import com.baidu.tieba.gt6;
import com.baidu.tieba.ig0;
import com.baidu.tieba.jg0;
import com.baidu.tieba.ju4;
import com.baidu.tieba.jx7;
import com.baidu.tieba.ku4;
import com.baidu.tieba.le8;
import com.baidu.tieba.mt7;
import com.baidu.tieba.nx7;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.pg;
import com.baidu.tieba.q05;
import com.baidu.tieba.q45;
import com.baidu.tieba.qi;
import com.baidu.tieba.ri;
import com.baidu.tieba.sg;
import com.baidu.tieba.u75;
import com.baidu.tieba.vv7;
import com.baidu.tieba.yy7;
import com.baidu.tieba.z8;
import com.baidu.tieba.zs6;
import com.baidu.tieba.zu7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public abstract class AbsPbActivity extends BaseFragmentActivity implements zu7<PbActivity>, VoiceManager.j, ju4, ig0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbModel a;
    public VideoPbViewModel b;
    public Fragment c;
    public final yy7 d;
    public final az7 e;
    public View f;
    public boolean g;
    public VoiceManager h;
    public boolean i;
    public boolean j;
    public vv7 k;
    public nx7 l;
    public al5 m;
    public es8 n;
    @Nullable
    public TiePlusEventController o;
    public boolean p;
    public zs6.h q;
    public final jg0 r;
    public long s;
    public PbModel.h t;

    /* loaded from: classes5.dex */
    public class a implements PbModel.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsPbActivity a;

        /* renamed from: com.baidu.tieba.pb.pb.main.AbsPbActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0360a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ a b;

            public RunnableC0360a(a aVar, String str) {
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
                    if ((fragment instanceof PbFragment) && ((PbFragment) fragment).S5() != null && ((PbFragment) this.b.a.c).S5().B0() != null) {
                        AbsPbActivity absPbActivity = this.b.a;
                        absPbActivity.k1(((PbFragment) absPbActivity.c).S5().B0(), ((PbFragment) this.b.a.c).O5(), this.a);
                        this.b.a.p = true;
                        return;
                    }
                    Fragment fragment2 = this.b.a.c;
                    if (!(fragment2 instanceof AbsVideoPbFragment) || ((AbsVideoPbFragment) fragment2).I3() == null) {
                        return;
                    }
                    AbsPbActivity absPbActivity2 = this.b.a;
                    absPbActivity2.k1(((AbsVideoPbFragment) absPbActivity2.c).I3(), ((AbsVideoPbFragment) this.b.a.c).X3(), this.a);
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
                Fragment U0 = this.a.U0();
                if (U0 instanceof a18) {
                    a18 a18Var = (a18) U0;
                    if (a18Var.C0() != null) {
                        a18Var.C0().a(i, z, responsedMessage, z2, j);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void b(mt7 mt7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mt7Var) == null) {
                Fragment U0 = this.a.U0();
                if (U0 instanceof a18) {
                    a18 a18Var = (a18) U0;
                    if (a18Var.C0() != null) {
                        a18Var.C0().b(mt7Var);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, mt7 mt7Var, String str, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), mt7Var, str, Integer.valueOf(i4)}) == null) {
                this.a.n1(mt7Var);
                this.a.b.y(this.a.a.I1());
                this.a.b.v(false);
                if (!PbLoadingViewOptimizeSwitch.isSwitchOn()) {
                    AbsPbActivity absPbActivity = this.a;
                    absPbActivity.hideLoadingView(absPbActivity.f);
                }
                if (z) {
                    if (mt7Var != null) {
                        AbsPbActivity absPbActivity2 = this.a;
                        absPbActivity2.hideNetRefreshView(absPbActivity2.f);
                    }
                } else if (!this.a.g && !this.a.a.F2()) {
                    AbsPbActivity absPbActivity3 = this.a;
                    absPbActivity3.showNetRefreshView(absPbActivity3.f, this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c3f, str, Integer.valueOf(i)), null, null, true, this.a.getNetRefreshListener());
                    AbsPbActivity absPbActivity4 = this.a;
                    absPbActivity4.setNetRefreshViewEmotionMarginTop(ri.f(absPbActivity4.getActivity(), R.dimen.obfuscated_res_0x7f0702aa));
                }
                Fragment U0 = this.a.U0();
                if (U0 == null) {
                    if (z) {
                        this.a.b.s(mt7Var, 3);
                        PbModel pbModel = this.a.a;
                        if (pbModel != null) {
                            pbModel.cancelLoadData();
                            this.a.a.P3(mt7Var);
                        }
                        AbsPbActivity absPbActivity5 = this.a;
                        if (absPbActivity5.c == null) {
                            absPbActivity5.T0(mt7Var);
                        }
                    } else if (PbLoadingViewOptimizeSwitch.isSwitchOn()) {
                        AbsPbActivity absPbActivity6 = this.a;
                        absPbActivity6.hideLoadingView(absPbActivity6.f);
                    }
                } else if (U0 instanceof a18) {
                    a18 a18Var = (a18) U0;
                    if (a18Var.C0() != null) {
                        a18Var.C0().c(z, i, i2, i3, mt7Var, str, i4);
                    }
                }
                String stringExtra = this.a.getIntent().getStringExtra("key_open_editor_tips");
                if (TextUtils.isEmpty(stringExtra) || this.a.p) {
                    return;
                }
                sg.a().postDelayed(new RunnableC0360a(this, stringExtra), 100L);
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
                mt7 pbData = pbPageReadLocalResponseMessage.getPbData();
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
                Fragment U0 = this.a.U0();
                if (U0 == null) {
                    this.a.b.s(pbData, 2);
                    AbsPbActivity absPbActivity = this.a;
                    if (absPbActivity.c == null) {
                        absPbActivity.T0(pbData);
                    }
                } else if (U0 instanceof PbFragment) {
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
        public final /* synthetic */ q45 b;
        public final /* synthetic */ AbsPbActivity c;

        public c(AbsPbActivity absPbActivity, View view2, q45 q45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absPbActivity, view2, q45Var};
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
            this.b = q45Var;
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

    /* loaded from: classes5.dex */
    public class d implements zs6.h {
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

        @Override // com.baidu.tieba.zs6.h
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                Fragment fragment = this.a.c;
                if (fragment instanceof PbFragment) {
                    PbFragment pbFragment = (PbFragment) fragment;
                    if (pbFragment.S5() != null && pbFragment.S5().A0() != null) {
                        pbFragment.S5().A0().E0();
                    }
                }
                FunAdRecordHttpMessage.uploadRequestRecord("a005", "0", this.a.a.S1().Q(), this.a.a.S1().m(), null);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a005").param("obj_locate", 0).param(TiebaStatic.Params.RESOURCE_ID, i).param("obj_param1", "1"));
            }
        }

        @Override // com.baidu.tieba.zs6.h
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
        this.d = new yy7(this);
        this.e = new az7(getPageContext());
        this.i = false;
        this.j = false;
        this.r = new jg0();
        this.t = new a(this);
    }

    @Override // com.baidu.tieba.ju4
    public String C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null) {
                return pbModel.m2();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zu7
    public boolean E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            PbModel pbModel = this.a;
            return pbModel != null && pbModel.K2(str);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ig0
    @NonNull
    public jg0 P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.r : (jg0) invokeV.objValue;
    }

    public Fragment S0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if ("video_pb_fragment_tag".equals(str)) {
                return new VideoPbFragment();
            }
            return PbFragment.H6();
        }
        return (Fragment) invokeL.objValue;
    }

    @Override // com.baidu.tieba.zu7
    public int T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null || pbModel.S1() == null) {
                return 0;
            }
            return this.a.S1().W();
        }
        return invokeV.intValue;
    }

    public final void T0(mt7 mt7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, mt7Var) == null) {
            String Z0 = Z0(mt7Var);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            if (supportFragmentManager.findFragmentByTag(Z0) == null) {
                this.c = S0(Z0);
                supportFragmentManager.beginTransaction().add(R.id.obfuscated_res_0x7f0906bd, this.c, Z0).commitAllowingStateLoss();
            }
        }
    }

    public Fragment U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            List<Fragment> fragments = getSupportFragmentManager().getFragments();
            if (ListUtils.isEmpty(fragments)) {
                return null;
            }
            return fragments.get(0);
        }
        return (Fragment) invokeV.objValue;
    }

    public abstract int V0();

    public long W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.s : invokeV.longValue;
    }

    @Override // com.baidu.tieba.ju4
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null) {
                return pbModel.getForumId();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zu7
    public String X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null) {
                return pbModel.r1();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public final String Z0(mt7 mt7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, mt7Var)) == null) ? (mt7Var == null || !mt7Var.u0()) ? "pb_fragment_tag" : "video_pb_fragment_tag" : (String) invokeL.objValue;
    }

    public abstract int a1();

    public PbModel b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.a : (PbModel) invokeV.objValue;
    }

    public abstract int c1();

    @NonNull
    public TiePlusEventController d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            df5.b(this.o);
            return this.o;
        }
        return (TiePlusEventController) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, motionEvent)) == null) {
            this.r.a(motionEvent);
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i e1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (getIntent().getParcelableExtra("video_origin_area") == null && !this.i && !this.j) {
                super.enterExitAnimation();
            } else {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            }
        }
    }

    public final void f1() {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (intent = getIntent()) == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("target_scheme");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        UrlSchemaHelper.goToNewPageByScheme(stringExtra);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        nx7 nx7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (!TbSingleton.getInstance().isNeedShowInterestGuide() && (nx7Var = this.l) != null) {
                nx7Var.a(this.a);
            }
            Fragment U0 = U0();
            if (U0 instanceof a18) {
                ((a18) U0).finish();
            } else {
                super.finish();
            }
            vv7 vv7Var = this.k;
            if (vv7Var == null || vv7Var.b(this.a)) {
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tieba.ba5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? "a005" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean getGpuSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? TbadkCoreApplication.getInst().isGpuOpen() : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public ea5 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            ea5 pageStayDurationItem = super.getPageStayDurationItem();
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
                    pageStayDurationItem.C(pg.g(this.a.m2(), 0L));
                    if (this.a.S1() != null && this.a.S1().O() != null) {
                        pageStayDurationItem.u(this.a.S1().O().getNid());
                        pageStayDurationItem.B(this.a.S1().O().getThreadType());
                    }
                }
                if (!qi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    pageStayDurationItem.z(TbadkCoreApplication.getInst().getTaskId());
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                    pageStayDurationItem.q(TbadkCoreApplication.getInst().getAdAdSense().k);
                }
                Fragment U0 = U0();
                if (U0 instanceof PbFragment) {
                    int i = ((PbFragment) U0).u1;
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
        return (ea5) invokeV.objValue;
    }

    public View getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f : (View) invokeV.objValue;
    }

    public final void h1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bundle) == null) {
            this.b.a(this.a);
            jx7.b().p(this.a.e1(), this.a.B1());
            registerListener(new b(this, 2004003));
            if (!this.a.X2()) {
                this.a.T2();
            }
            if (this.a.F2()) {
                mt7 c1 = this.a.c1(df6.a());
                if (c1 != null) {
                    if (this.a.S1() != null) {
                        this.a.S1().N0(c1.O());
                    }
                    c1.B0(3);
                    if (U0() == null) {
                        this.b.s(c1, 1);
                        if (this.c == null) {
                            T0(c1);
                        }
                    }
                }
                if (a1() == 0) {
                    this.b.v(false);
                } else {
                    showLoadingView(findViewById(R.id.obfuscated_res_0x7f0906bd), true);
                    this.b.v(true);
                }
            } else {
                showLoadingView(findViewById(R.id.obfuscated_res_0x7f0906bd), true);
                this.b.v(true);
            }
            if (ri.D() && !TbadkCoreApplication.getInst().syncHasFinish) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
            }
            l1();
            m1();
        }
    }

    public final void i1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bundle) == null) {
            if (bundle != null) {
                this.a = new PbModel(this, bundle, this.t);
            } else {
                this.a = new PbModel(this, getIntent(), this.t);
            }
            setForceInterceptStimeStat(this.a.w2());
            this.a.E3(c1());
            this.a.s3(a1());
        }
    }

    public final void j1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(this).get(VideoPbViewModel.class);
            this.b = videoPbViewModel;
            videoPbViewModel.l(getIntent());
        }
    }

    public final void k1(View view2, q45 q45Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048605, this, view2, q45Var, str) == null) {
            new WriteTipBubbleController(getPageContext(), new c(this, view2, q45Var)).d(view2, getString(R.string.obfuscated_res_0x7f0f0cf4), str, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_PB_REPLY);
        }
    }

    public final void l1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            boolean z = true;
            if (((TbadkCoreApplication.getCurrentAccountInfo() == null || TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() != 1) ? false : false) || !UbsABTestHelper.isPbPageBannerFunAdSdkTest()) {
                return;
            }
            Activity f = z8.g().f(0);
            if (this.q == null) {
                this.q = new d(this);
            }
            FunAdRecordHttpMessage.uploadRequestRecord("a005", null, this.a.S1().Q(), this.a.S1().m(), null);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("tid", this.a.S1().Q()).param("fid", this.a.S1().m()).param("obj_type", "a005").param("obj_param1", "1"));
            String d2 = ft6.e().d("pb_banner");
            zs6 m = zs6.m();
            if (f == null) {
                f = this;
            }
            m.x(f, d2, this.q, zs6.b("pb", UbsABTestHelper.isPbPageBannerFunAdSdkTest() ? "1" : "0"));
        }
    }

    public final void m1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && !gt6.f() && UbsABTestHelper.isPbCommentFunAdABTest()) {
            zs6 m = zs6.m();
            String f = zs6.f();
            zs6.g b2 = zs6.b("pb", UbsABTestHelper.isPbPageBannerFunAdSdkTest() ? "1" : "0");
            PbModel pbModel = this.a;
            String Q = (pbModel == null || pbModel.S1() == null) ? "" : this.a.S1().Q();
            PbModel pbModel2 = this.a;
            m.L(this, f, b2, Q, (pbModel2 == null || pbModel2.S1() == null) ? "" : this.a.S1().m());
        }
    }

    public final void n1(mt7 mt7Var) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, mt7Var) == null) || mt7Var == null || mt7Var.l() == null || (intent = getIntent()) == null) {
            return;
        }
        le8.d().g((Uri) intent.getParcelableExtra(IntentConfig.KEY_URI), mt7Var.l().getId());
    }

    public void o1(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, str) == null) || str == null || this.n == null) {
            return;
        }
        this.n.n(pg.g(str, 0L));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048610, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            Fragment U0 = U0();
            if (U0 != null) {
                U0.onActivityResult(i, i2, intent);
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            super.onBackPressed();
            Fragment U0 = U0();
            if (U0 instanceof PbFragment) {
                ((PbFragment) U0).I6();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            Fragment U0 = U0();
            if (U0 instanceof BaseFragment) {
                ((BaseFragment) U0).onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int intExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, bundle) == null) {
            this.s = System.currentTimeMillis();
            initUniqueId();
            j1();
            i1(bundle);
            boolean z = true;
            if (!z8.g().i("MainTabActivity")) {
                if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null) {
                    this.i = true;
                } else if (b1().R1() == 7) {
                    this.j = true;
                }
            }
            if (this.i || this.j) {
                setIsAddSwipeBackLayout(false);
            }
            super.onCreate(bundle);
            f1();
            setContentView(V0());
            this.f = findViewById(R.id.obfuscated_res_0x7f0906bd);
            adjustResizeForSoftInput();
            addGlobalLayoutListener();
            h1(bundle);
            VoiceManager voiceManager = new VoiceManager();
            this.h = voiceManager;
            voiceManager.onCreate(getPageContext());
            this.k = new vv7(getPageContext());
            this.l = new nx7(getPageContext());
            this.m = new al5(getPageContext(), "client_pb_live");
            this.n = new es8(getPageContext(), getUniqueId());
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
                ku4.d(this.a.m2() + "_onCreate_" + System.currentTimeMillis());
            }
            q05.b(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            super.onDestroy();
            VoiceManager voiceManager = this.h;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            al5 al5Var = this.m;
            if (al5Var != null) {
                al5Var.h();
            }
            es8 es8Var = this.n;
            if (es8Var != null) {
                es8Var.l();
            }
            TbPageExtraHelper.setPrePageKey(getCurrentPageKey());
            u75.i(new PrePageKeyEvent(getCurrentPageKey()));
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
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048615, this, i, keyEvent)) == null) {
            Fragment U0 = U0();
            if (U0 instanceof PbFragment) {
                if (((PbFragment) U0).J6(i, keyEvent)) {
                    return true;
                }
            } else if ((U0 instanceof AbsVideoPbFragment) && ((AbsVideoPbFragment) U0).L4(i, keyEvent)) {
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            super.onKeyboardVisibilityChanged(z);
            Fragment U0 = U0();
            if (U0 instanceof AbsVideoPbFragment) {
                ((AbsVideoPbFragment) U0).M4(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
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
        if (interceptable == null || interceptable.invokeILL(1048619, this, i, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i, strArr, iArr);
            if (i == 0) {
                Fragment fragment = this.c;
                if ((fragment instanceof PbFragment) && ((PbFragment) fragment).O5() != null) {
                    ((PbFragment) this.c).O5().z0();
                    return;
                }
                Fragment fragment2 = this.c;
                if (!(fragment2 instanceof AbsVideoPbFragment) || ((AbsVideoPbFragment) fragment2).X3() == null) {
                    return;
                }
                ((AbsVideoPbFragment) this.c).X3().z0();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            super.onResume();
            if (this.a != null) {
                jx7.b().p(this.a.e1(), this.a.B1());
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
        if (interceptable == null || interceptable.invokeL(1048621, this, bundle) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            super.onWindowFocusChanged(z);
            Fragment fragment = this.c;
            if (fragment instanceof AbsVideoPbFragment) {
                ((AbsVideoPbFragment) fragment).P4(z);
            }
        }
    }

    public void p1() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048626, this) == null) || (voiceManager = this.h) == null) {
            return;
        }
        voiceManager.stopPlay();
    }

    public void q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean shouldChangeStatusBarIconAndTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? !(this.c instanceof AbsVideoPbFragment) : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.h : (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zu7
    public boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null) {
                return false;
            }
            return pbModel.J2();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.zu7
    public yy7 z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.d : (yy7) invokeV.objValue;
    }
}
