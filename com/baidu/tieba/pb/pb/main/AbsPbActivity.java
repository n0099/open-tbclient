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
import com.baidu.tbadk.core.data.AccountData;
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
import com.baidu.tieba.c35;
import com.baidu.tieba.d35;
import com.baidu.tieba.dm8;
import com.baidu.tieba.funAd.http.FunAdRecordHttpMessage;
import com.baidu.tieba.fw6;
import com.baidu.tieba.ga7;
import com.baidu.tieba.gg;
import com.baidu.tieba.gi;
import com.baidu.tieba.hi;
import com.baidu.tieba.hm8;
import com.baidu.tieba.ik5;
import com.baidu.tieba.jg;
import com.baidu.tieba.ki8;
import com.baidu.tieba.kw5;
import com.baidu.tieba.lh0;
import com.baidu.tieba.m35;
import com.baidu.tieba.m95;
import com.baidu.tieba.ma7;
import com.baidu.tieba.mh0;
import com.baidu.tieba.mp5;
import com.baidu.tieba.na7;
import com.baidu.tieba.o39;
import com.baidu.tieba.od5;
import com.baidu.tieba.oj9;
import com.baidu.tieba.ok8;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.pp5;
import com.baidu.tieba.tn8;
import com.baidu.tieba.vh5;
import com.baidu.tieba.vn8;
import com.baidu.tieba.w8;
import com.baidu.tieba.wp8;
import com.baidu.tieba.xj8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public abstract class AbsPbActivity extends BaseFragmentActivity implements xj8<PbActivity>, VoiceManager.j, c35, lh0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbModel a;
    public VideoPbViewModel b;
    public Fragment c;
    public final tn8 d;
    public final vn8 e;
    public View f;
    public boolean g;
    public VoiceManager h;
    public boolean i;
    public boolean j;
    public ok8 k;
    public hm8 l;
    public kw5 m;
    public oj9 n;
    @Nullable
    public TiePlusEventController o;
    public boolean p;
    public ga7.h q;
    public final mh0 r;
    public long s;
    public Uri t;
    public PbModel.h u;

    public abstract int G1();

    public abstract int J1();

    public abstract int L1();

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i e1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tieba.fk5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? "a005" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    /* loaded from: classes5.dex */
    public class a implements PbModel.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsPbActivity a;

        /* renamed from: com.baidu.tieba.pb.pb.main.AbsPbActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0381a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ a b;

            public RunnableC0381a(a aVar, String str) {
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
                    if ((fragment instanceof PbFragment) && ((PbFragment) fragment).M5() != null && ((PbFragment) this.b.a.c).M5().K0() != null) {
                        AbsPbActivity absPbActivity = this.b.a;
                        absPbActivity.R1(((PbFragment) absPbActivity.c).M5().K0(), ((PbFragment) this.b.a.c).J5(), this.a);
                        this.b.a.p = true;
                        return;
                    }
                    Fragment fragment2 = this.b.a.c;
                    if ((fragment2 instanceof AbsVideoPbFragment) && ((AbsVideoPbFragment) fragment2).T3() != null) {
                        AbsPbActivity absPbActivity2 = this.b.a;
                        absPbActivity2.R1(((AbsVideoPbFragment) absPbActivity2.c).T3(), ((AbsVideoPbFragment) this.b.a.c).i4(), this.a);
                        this.b.a.p = true;
                    }
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
        public void b(ki8 ki8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ki8Var) == null) {
                Fragment F1 = this.a.F1();
                if (F1 instanceof wp8) {
                    wp8 wp8Var = (wp8) F1;
                    if (wp8Var.F0() != null) {
                        wp8Var.F0().b(ki8Var);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), responsedMessage, Boolean.valueOf(z2), Long.valueOf(j)}) == null) {
                Fragment F1 = this.a.F1();
                if (F1 instanceof wp8) {
                    wp8 wp8Var = (wp8) F1;
                    if (wp8Var.F0() != null) {
                        wp8Var.F0().a(i, z, responsedMessage, z2, j);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, ki8 ki8Var, String str, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), ki8Var, str, Integer.valueOf(i4)}) == null) {
                this.a.U1(ki8Var);
                this.a.b.y(this.a.a.m1());
                this.a.b.v(false);
                if (!PbLoadingViewOptimizeSwitch.isSwitchOn()) {
                    AbsPbActivity absPbActivity = this.a;
                    absPbActivity.hideLoadingView(absPbActivity.f);
                }
                if (!z) {
                    if (!this.a.g && !this.a.a.n2()) {
                        AbsPbActivity absPbActivity2 = this.a;
                        absPbActivity2.showNetRefreshView(absPbActivity2.f, this.a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), null, null, true, this.a.getNetRefreshListener());
                        AbsPbActivity absPbActivity3 = this.a;
                        absPbActivity3.setNetRefreshViewEmotionMarginTop(hi.g(absPbActivity3.getActivity(), R.dimen.obfuscated_res_0x7f0702ab));
                    }
                } else if (ki8Var != null) {
                    AbsPbActivity absPbActivity4 = this.a;
                    absPbActivity4.hideNetRefreshView(absPbActivity4.f);
                }
                Fragment F1 = this.a.F1();
                if (F1 == null) {
                    if (z) {
                        this.a.b.s(ki8Var, 3);
                        PbModel pbModel = this.a.a;
                        if (pbModel != null) {
                            pbModel.cancelLoadData();
                            this.a.a.y3(ki8Var);
                        }
                        AbsPbActivity absPbActivity5 = this.a;
                        if (absPbActivity5.c == null) {
                            absPbActivity5.E1(ki8Var);
                        }
                    } else if (PbLoadingViewOptimizeSwitch.isSwitchOn()) {
                        AbsPbActivity absPbActivity6 = this.a;
                        absPbActivity6.hideLoadingView(absPbActivity6.f);
                    }
                } else if (F1 instanceof wp8) {
                    wp8 wp8Var = (wp8) F1;
                    if (wp8Var.F0() != null) {
                        wp8Var.F0().c(z, i, i2, i3, ki8Var, str, i4);
                        if (m35.m().n(m35.q("key_reaction_guide_show_number_pb"), 0) == 3 && ki8Var != null && ki8Var.H().size() <= 1) {
                            String s = m35.m().s(m35.q("key_reaction_guide_show_pb_strategy"), "");
                            if (s.length() >= 2) {
                                s = s.substring(0, s.length() - 2);
                            }
                            m35.m().B(m35.q("key_reaction_guide_show_pb_strategy"), s);
                        }
                    }
                }
                String stringExtra = this.a.getIntent().getStringExtra("key_open_editor_tips");
                if (!TextUtils.isEmpty(stringExtra) && !this.a.p) {
                    jg.a().postDelayed(new RunnableC0381a(this, stringExtra), 100L);
                }
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage.getOrginalMessage().getTag() != this.a.getUniqueId()) {
                return;
            }
            PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage;
            ki8 pbData = pbPageReadLocalResponseMessage.getPbData();
            if (pbData == null) {
                this.a.g = false;
                return;
            }
            ThreadData Q = pbData.Q();
            if (Q != null) {
                this.a.a.H0(Q);
            }
            this.a.g = true;
            this.a.b.v(false);
            Fragment F1 = this.a.F1();
            if (F1 == null) {
                this.a.b.s(pbData, 2);
                AbsPbActivity absPbActivity = this.a;
                if (absPbActivity.c == null) {
                    absPbActivity.E1(pbData);
                }
            } else if (F1 instanceof PbFragment) {
                this.a.a.H2(pbData, pbPageReadLocalResponseMessage.getUpdateType(), pbPageReadLocalResponseMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements WriteTipBubbleController.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ od5 b;
        public final /* synthetic */ AbsPbActivity c;

        public c(AbsPbActivity absPbActivity, View view2, od5 od5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absPbActivity, view2, od5Var};
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
            this.b = od5Var;
        }

        @Override // com.baidu.tbadk.core.dialog.WriteTipBubbleController.b
        public void a(View view2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, str) == null) {
                this.a.performClick();
                this.b.j();
                this.b.s().i().setText(str);
                Editable text = this.b.s().i().getText();
                if (!TextUtils.isEmpty(text)) {
                    this.b.s().i().setSelection(text.length());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ga7.h {
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

        @Override // com.baidu.tieba.ga7.h
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                Fragment fragment = this.a.c;
                if (fragment instanceof PbFragment) {
                    PbFragment pbFragment = (PbFragment) fragment;
                    if (pbFragment.M5() != null && pbFragment.M5().J0() != null) {
                        pbFragment.M5().J0().E0();
                    }
                }
                FunAdRecordHttpMessage.uploadRequestRecord("a005", "0", this.a.a.w1().S(), this.a.a.w1().m(), null);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a005").param("obj_locate", 0).param("resource_id", i).param("obj_param1", "1"));
            }
        }

        @Override // com.baidu.tieba.ga7.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                FunAdRecordHttpMessage.uploadRequestRecord("a005", "1", this.a.a.w1().S(), this.a.a.w1().m(), "0");
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a005").param("obj_locate", 1).param("resource_id", 0).param("obj_param1", "1"));
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
        this.d = new tn8(this);
        this.e = new vn8(getPageContext());
        this.i = false;
        this.j = false;
        this.r = new mh0();
        this.u = new a(this);
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
            kw5 kw5Var = this.m;
            if (kw5Var != null) {
                kw5Var.h();
            }
            oj9 oj9Var = this.n;
            if (oj9Var != null) {
                oj9Var.l();
            }
            TbPageExtraHelper.setPrePageKey(getCurrentPageKey());
            vh5.i(new PrePageKeyEvent(getCurrentPageKey()));
            if (this.q != null) {
                this.q = null;
            }
            if (this.o != null) {
                getLifecycle().removeObserver(this.o);
            }
            this.c = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            super.onResume();
            if (this.a != null) {
                dm8.b().p(this.a.I0(), this.a.f1());
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

    public Fragment C1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if ("video_pb_fragment_tag".equals(str)) {
                return new VideoPbFragment();
            }
            return PbFragment.u6();
        }
        return (Fragment) invokeL.objValue;
    }

    @Override // com.baidu.tieba.xj8
    public boolean G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.s2(str)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final String I1(ki8 ki8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, ki8Var)) == null) {
            if (ki8Var != null && ki8Var.y0()) {
                return "video_pb_fragment_tag";
            }
            return "pb_fragment_tag";
        }
        return (String) invokeL.objValue;
    }

    public void V1(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, str) == null) && str != null && this.n != null) {
            this.n.n(gg.g(str, 0L));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, motionEvent)) == null) {
            this.r.a(motionEvent);
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            Fragment F1 = F1();
            if (F1 instanceof BaseFragment) {
                ((BaseFragment) F1).onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            super.onKeyboardVisibilityChanged(z);
            Fragment F1 = F1();
            if (F1 instanceof AbsVideoPbFragment) {
                ((AbsVideoPbFragment) F1).onKeyboardVisibilityChanged(z);
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
                pbModel.W2(bundle);
            }
            VoiceManager voiceManager = this.h;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            super.onWindowFocusChanged(z);
            Fragment fragment = this.c;
            if (fragment instanceof AbsVideoPbFragment) {
                ((AbsVideoPbFragment) fragment).X4(z);
            }
        }
    }

    public final void E1(ki8 ki8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ki8Var) == null) {
            String I1 = I1(ki8Var);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            if (supportFragmentManager.findFragmentByTag(I1) == null) {
                this.c = C1(I1);
                supportFragmentManager.beginTransaction().add(R.id.obfuscated_res_0x7f09076e, this.c, I1).commitAllowingStateLoss();
            }
        }
    }

    public final void P1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            if (bundle != null) {
                this.a = new PbModel(this, bundle, this.u);
            } else {
                this.a = new PbModel(this, getIntent(), this.u);
            }
            setForceInterceptStimeStat(this.a.d2());
            this.a.n3(L1());
            this.a.b3(J1());
        }
    }

    public final void U1(ki8 ki8Var) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048595, this, ki8Var) != null) || ki8Var == null || ki8Var.l() == null || (intent = getIntent()) == null) {
            return;
        }
        Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
        this.t = uri;
        o39.d().g(uri, ki8Var.l().getId());
    }

    public Fragment F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<Fragment> fragments = getSupportFragmentManager().getFragments();
            if (!ListUtils.isEmpty(fragments)) {
                return fragments.get(0);
            }
            return null;
        }
        return (Fragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xj8
    public tn8 H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.d;
        }
        return (tn8) invokeV.objValue;
    }

    public long H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.s;
        }
        return invokeV.longValue;
    }

    public PbModel K1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.a;
        }
        return (PbModel) invokeV.objValue;
    }

    @NonNull
    public TiePlusEventController M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            pp5.b(this.o);
            return this.o;
        }
        return (TiePlusEventController) invokeV.objValue;
    }

    public final void N1() {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (intent = getIntent()) != null) {
            String stringExtra = intent.getStringExtra("target_scheme");
            if (!TextUtils.isEmpty(stringExtra)) {
                UrlSchemaHelper.goToNewPageByScheme(stringExtra);
            }
        }
    }

    public final void Q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(this).get(VideoPbViewModel.class);
            this.b = videoPbViewModel;
            videoPbViewModel.l(getIntent());
        }
    }

    public void W1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.finish();
        }
    }

    @Override // com.baidu.tieba.xj8
    public String X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null) {
                return pbModel.V0();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xj8
    public int c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.w1() != null) {
                return this.a.w1().Y();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (getIntent().getParcelableExtra("video_origin_area") == null && !this.i && !this.j) {
                super.enterExitAnimation();
            } else {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            }
        }
    }

    @Override // com.baidu.tieba.lh0
    @NonNull
    public mh0 f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.r;
        }
        return (mh0) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean getGpuSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return TbadkCoreApplication.getInst().isGpuOpen();
        }
        return invokeV.booleanValue;
    }

    public View getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            super.onBackPressed();
            Fragment F1 = F1();
            if (F1 instanceof PbFragment) {
                ((PbFragment) F1).v6();
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
                this.a.B2();
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
                voiceManager.onPause();
            }
            TiePlusEventController tiePlusEventController = this.o;
            if (tiePlusEventController != null) {
                tiePlusEventController.onPause();
            }
            SpeedStatsManager.getInstance().setStatsFlag(-1);
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

    @Override // com.baidu.tieba.c35
    public String p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null) {
                return pbModel.Q1();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean shouldChangeStatusBarIconAndTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            if (this.c instanceof AbsVideoPbFragment) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.c35
    public String v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null) {
                return pbModel.getForumId();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.h;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xj8
    public boolean x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null) {
                return false;
            }
            return pbModel.r2();
        }
        return invokeV.booleanValue;
    }

    public final void O1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            this.b.a(this.a);
            dm8.b().p(this.a.I0(), this.a.f1());
            registerListener(new b(this, 2004003));
            if (!this.a.F2()) {
                this.a.B2();
            }
            if (this.a.n2()) {
                ki8 G0 = this.a.G0(fw6.a());
                if (G0 != null) {
                    if (this.a.w1() != null) {
                        this.a.w1().R0(G0.Q());
                    }
                    G0.F0(3);
                    if (F1() == null) {
                        this.b.s(G0, 1);
                        if (this.c == null) {
                            E1(G0);
                        }
                    }
                }
                if (J1() == 0) {
                    this.b.v(false);
                } else {
                    showLoadingView(findViewById(R.id.obfuscated_res_0x7f09076e), true);
                    this.b.v(true);
                }
            } else {
                showLoadingView(findViewById(R.id.obfuscated_res_0x7f09076e), true);
                this.b.v(true);
            }
            if (hi.F() && !TbadkCoreApplication.getInst().syncHasFinish) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
            }
            S1();
            T1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int intExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, bundle) == null) {
            this.s = System.currentTimeMillis();
            initUniqueId();
            Q1();
            P1(bundle);
            boolean z = true;
            if (!w8.f().h("MainTabActivity")) {
                if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null) {
                    this.i = true;
                } else if (K1().v1() == 7) {
                    this.j = true;
                }
            }
            if (this.i || this.j) {
                setIsAddSwipeBackLayout(false);
            }
            super.onCreate(bundle);
            N1();
            setContentView(G1());
            this.f = findViewById(R.id.obfuscated_res_0x7f09076e);
            adjustResizeForSoftInput();
            addGlobalLayoutListener();
            O1(bundle);
            VoiceManager voiceManager = new VoiceManager();
            this.h = voiceManager;
            voiceManager.onCreate(getPageContext());
            this.k = new ok8(getPageContext());
            this.l = new hm8(getPageContext());
            this.m = new kw5(getPageContext(), "client_pb_live");
            this.n = new oj9(getPageContext(), getUniqueId());
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
                d35.d(this.a.Q1() + "_onCreate_" + System.currentTimeMillis());
            }
            m95.b(false);
        }
    }

    public final void R1(View view2, od5 od5Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048592, this, view2, od5Var, str) == null) {
            new WriteTipBubbleController(getPageContext(), new c(this, view2, od5Var)).d(view2, getString(R.string.obfuscated_res_0x7f0f0dd8), str, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_PB_REPLY);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048610, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            Fragment F1 = F1();
            if (F1 != null) {
                F1.onActivityResult(i, i2, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048619, this, i, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0010, code lost:
        if (r0.getMemberCloseAdVipClose() == 1) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void S1() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                z = true;
            }
            z = false;
            if (!z && UbsABTestHelper.isPbPageBannerFunAdSdkTest()) {
                Activity e2 = w8.f().e(0);
                if (this.q == null) {
                    this.q = new d(this);
                }
                FunAdRecordHttpMessage.uploadRequestRecord("a005", null, this.a.w1().S(), this.a.w1().m(), null);
                String str = "1";
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("tid", this.a.w1().S()).param("fid", this.a.w1().m()).param("obj_type", "a005").param("obj_param1", "1"));
                String d2 = ma7.e().d("pb_banner");
                ga7 m = ga7.m();
                if (e2 == null) {
                    e2 = this;
                }
                ga7.h hVar = this.q;
                if (!UbsABTestHelper.isPbPageBannerFunAdSdkTest()) {
                    str = "0";
                }
                m.x(e2, d2, hVar, ga7.b("pb", str));
            }
        }
    }

    public final void T1() {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && !na7.f() && UbsABTestHelper.isPbCommentFunAdABTest()) {
            ga7 m = ga7.m();
            String f = ga7.f();
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest()) {
                str = "1";
            } else {
                str = "0";
            }
            ga7.g b2 = ga7.b("pb", str);
            PbModel pbModel = this.a;
            if (pbModel == null || pbModel.w1() == null) {
                str2 = "";
            } else {
                str2 = this.a.w1().S();
            }
            PbModel pbModel2 = this.a;
            if (pbModel2 == null || pbModel2.w1() == null) {
                str3 = "";
            } else {
                str3 = this.a.w1().m();
            }
            m.L(this, f, b2, str2, str3);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        hm8 hm8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (!TbSingleton.getInstance().isNeedShowInterestGuide() && (hm8Var = this.l) != null) {
                hm8Var.a(this.a);
            }
            Fragment F1 = F1();
            if (F1 instanceof wp8) {
                ((wp8) F1).finish();
            } else {
                super.finish();
            }
            ok8 ok8Var = this.k;
            if (ok8Var != null && !ok8Var.b(this.a)) {
                if (this.i || this.j) {
                    if (TbSingleton.getInstance().isNeedShowInterestGuide()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new InterestGuideActivityConfig(this)));
                    } else {
                        sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public ik5 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            ik5 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                PbModel pbModel = this.a;
                if (pbModel != null) {
                    if (pbModel.w1() != null) {
                        ThreadData Q = this.a.w1().Q();
                        pageStayDurationItem.u(Q.getNid());
                        if (Q.isNormalThreadType()) {
                            pageStayDurationItem.t = "1";
                        } else if (Q.isVideoThreadType()) {
                            pageStayDurationItem.t = "2";
                        } else {
                            pageStayDurationItem.t = "3";
                        }
                    }
                    pageStayDurationItem.C(gg.g(this.a.Q1(), 0L));
                    if (this.a.w1() != null && this.a.w1().Q() != null) {
                        pageStayDurationItem.u(this.a.w1().Q().getNid());
                        pageStayDurationItem.B(this.a.w1().Q().getThreadType());
                    }
                }
                if (!gi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    pageStayDurationItem.z(TbadkCoreApplication.getInst().getTaskId());
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                    pageStayDurationItem.q(TbadkCoreApplication.getInst().getAdAdSense().k);
                }
                Fragment F1 = F1();
                if (F1 instanceof PbFragment) {
                    int i = ((PbFragment) F1).r1;
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
                    if (uri != null && mp5.b(uri).booleanValue()) {
                        pageStayDurationItem.D(mp5.d(this.t.toString()));
                    }
                }
                if (!StringUtils.isNull(this.a.mTopicSubjectName)) {
                    pageStayDurationItem.E(this.a.mTopicSubjectName);
                } else {
                    Uri uri2 = this.t;
                    if (uri2 != null && mp5.b(uri2).booleanValue()) {
                        pageStayDurationItem.E("hottopic_detail_hybrid");
                    }
                }
            }
            return pageStayDurationItem;
        }
        return (ik5) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048615, this, i, keyEvent)) == null) {
            Fragment F1 = F1();
            if (F1 instanceof PbFragment) {
                if (((PbFragment) F1).onKeyDown(i, keyEvent)) {
                    return true;
                }
            } else if ((F1 instanceof AbsVideoPbFragment) && ((AbsVideoPbFragment) F1).onKeyDown(i, keyEvent)) {
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onScreenShot(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            super.onScreenShot(str);
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.w1() != null) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_SCREEN_SHOT);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("tid", this.a.Q1());
                statisticItem.param("fid", this.a.w1().m());
                statisticItem.param("obj_type", 3);
                TiebaStatic.log(statisticItem);
            }
        }
    }
}
