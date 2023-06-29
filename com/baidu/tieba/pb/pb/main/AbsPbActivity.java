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
import com.baidu.tbadk.core.log.ActivityLog;
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
import com.baidu.tieba.eg5;
import com.baidu.tieba.ew8;
import com.baidu.tieba.fb9;
import com.baidu.tieba.fca;
import com.baidu.tieba.fs5;
import com.baidu.tieba.ft7;
import com.baidu.tieba.funAd.http.FunAdRecordHttpMessage;
import com.baidu.tieba.fv9;
import com.baidu.tieba.h9;
import com.baidu.tieba.h95;
import com.baidu.tieba.hk5;
import com.baidu.tieba.i95;
import com.baidu.tieba.ix5;
import com.baidu.tieba.je9;
import com.baidu.tieba.le9;
import com.baidu.tieba.lt7;
import com.baidu.tieba.lx5;
import com.baidu.tieba.ma9;
import com.baidu.tieba.mt7;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.q46;
import com.baidu.tieba.r95;
import com.baidu.tieba.sj0;
import com.baidu.tieba.sp5;
import com.baidu.tieba.tc9;
import com.baidu.tieba.td7;
import com.baidu.tieba.tj0;
import com.baidu.tieba.u89;
import com.baidu.tieba.vg;
import com.baidu.tieba.vg9;
import com.baidu.tieba.wc9;
import com.baidu.tieba.wi;
import com.baidu.tieba.xi;
import com.baidu.tieba.yg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public abstract class AbsPbActivity extends BaseFragmentActivity implements ma9<PbActivity>, VoiceManager.j, h95, sj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbModel a;
    public Fragment b;
    public final je9 c;
    public final le9 d;
    public View e;
    public boolean f;
    public VoiceManager g;
    public boolean h;
    public boolean i;
    public fb9 j;
    public wc9 k;
    public q46 l;
    public fca m;
    @Nullable
    public TiePlusEventController n;
    public boolean o;
    public ft7.g p;
    public final tj0 q;
    public long r;
    public Uri s;
    public PbModel.h t;

    public abstract int F1();

    public String I1(u89 u89Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, u89Var)) == null) ? "pb_fragment_tag" : (String) invokeL.objValue;
    }

    public abstract int J1();

    public abstract int L1();

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i f1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tieba.cs5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? "a005" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    /* loaded from: classes7.dex */
    public class a implements PbModel.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsPbActivity a;

        /* renamed from: com.baidu.tieba.pb.pb.main.AbsPbActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0444a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ a b;

            public RunnableC0444a(a aVar, String str) {
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
                    Fragment fragment = this.b.a.b;
                    if ((fragment instanceof PbFragment) && ((PbFragment) fragment).L5() != null && ((PbFragment) this.b.a.b).L5().H0() != null) {
                        AbsPbActivity absPbActivity = this.b.a;
                        absPbActivity.Q1(((PbFragment) absPbActivity.b).L5().H0(), ((PbFragment) this.b.a.b).I5(), this.a);
                        this.b.a.o = true;
                        return;
                    }
                    Fragment fragment2 = this.b.a.b;
                    if ((fragment2 instanceof AbsVideoPbFragment) && ((AbsVideoPbFragment) fragment2).n3() != null) {
                        AbsPbActivity absPbActivity2 = this.b.a;
                        absPbActivity2.Q1(((AbsVideoPbFragment) absPbActivity2.b).n3(), ((AbsVideoPbFragment) this.b.a.b).A3(), this.a);
                        this.b.a.o = true;
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
        public void b(u89 u89Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u89Var) == null) {
                Fragment E1 = this.a.E1();
                if (E1 instanceof vg9) {
                    vg9 vg9Var = (vg9) E1;
                    if (vg9Var.M0() != null) {
                        vg9Var.M0().b(u89Var);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), responsedMessage, Boolean.valueOf(z2), Long.valueOf(j)}) == null) {
                Fragment E1 = this.a.E1();
                if (E1 instanceof vg9) {
                    vg9 vg9Var = (vg9) E1;
                    if (vg9Var.M0() != null) {
                        vg9Var.M0().a(i, z, responsedMessage, z2, j);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, u89 u89Var, String str, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), u89Var, str, Integer.valueOf(i4)}) == null) {
                this.a.T1(u89Var);
                if (!PbLoadingViewOptimizeSwitch.isSwitchOn()) {
                    AbsPbActivity absPbActivity = this.a;
                    absPbActivity.hideLoadingView(absPbActivity.e);
                }
                if (!z) {
                    if (!this.a.f && !this.a.a.n2()) {
                        AbsPbActivity absPbActivity2 = this.a;
                        absPbActivity2.showNetRefreshView(absPbActivity2.e, this.a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), null, null, true, this.a.getNetRefreshListener());
                        AbsPbActivity absPbActivity3 = this.a;
                        absPbActivity3.setNetRefreshViewEmotionMarginTop(xi.g(absPbActivity3.getActivity(), R.dimen.obfuscated_res_0x7f0703c2));
                    }
                } else if (u89Var != null) {
                    AbsPbActivity absPbActivity4 = this.a;
                    absPbActivity4.hideNetRefreshView(absPbActivity4.e);
                }
                Fragment E1 = this.a.E1();
                if (E1 == null) {
                    if (z) {
                        PbModel pbModel = this.a.a;
                        if (pbModel != null) {
                            pbModel.cancelLoadData();
                            this.a.a.v3(u89Var);
                        }
                        AbsPbActivity absPbActivity5 = this.a;
                        if (absPbActivity5.b == null) {
                            absPbActivity5.D1(u89Var);
                        }
                    } else if (PbLoadingViewOptimizeSwitch.isSwitchOn()) {
                        AbsPbActivity absPbActivity6 = this.a;
                        absPbActivity6.hideLoadingView(absPbActivity6.e);
                    }
                } else if (E1 instanceof vg9) {
                    vg9 vg9Var = (vg9) E1;
                    if (vg9Var.M0() != null) {
                        vg9Var.M0().c(z, i, i2, i3, u89Var, str, i4);
                        if (r95.p().q(r95.t("key_reaction_guide_show_number_pb"), 0) == 3 && u89Var != null && u89Var.F().size() <= 1) {
                            String w = r95.p().w(r95.t("key_reaction_guide_show_pb_strategy"), "");
                            if (w.length() >= 2) {
                                w = w.substring(0, w.length() - 2);
                            }
                            r95.p().J(r95.t("key_reaction_guide_show_pb_strategy"), w);
                        }
                    }
                }
                String stringExtra = this.a.getIntent().getStringExtra("key_open_editor_tips");
                if (!TextUtils.isEmpty(stringExtra) && !this.a.o) {
                    yg.a().postDelayed(new RunnableC0444a(this, stringExtra), 100L);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
            u89 pbData = pbPageReadLocalResponseMessage.getPbData();
            if (pbData != null) {
                ThreadData N = pbData.N();
                if (N != null) {
                    this.a.a.K0(N);
                }
                this.a.f = true;
                Fragment E1 = this.a.E1();
                if (E1 == null) {
                    this.a.a.v3(pbData);
                    AbsPbActivity absPbActivity = this.a;
                    if (absPbActivity.b == null) {
                        absPbActivity.D1(pbData);
                        return;
                    }
                    return;
                } else if (E1 instanceof PbFragment) {
                    this.a.a.D2(pbData, pbPageReadLocalResponseMessage.getUpdateType(), pbPageReadLocalResponseMessage.getErrorString());
                    return;
                } else {
                    return;
                }
            }
            this.a.f = false;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements WriteTipBubbleController.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ hk5 b;
        public final /* synthetic */ AbsPbActivity c;

        public c(AbsPbActivity absPbActivity, View view2, hk5 hk5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absPbActivity, view2, hk5Var};
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
            this.b = hk5Var;
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

    /* loaded from: classes7.dex */
    public class d implements ft7.g {
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

        @Override // com.baidu.tieba.ft7.g
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                Fragment fragment = this.a.b;
                if (fragment instanceof PbFragment) {
                    PbFragment pbFragment = (PbFragment) fragment;
                    if (pbFragment.L5() != null && pbFragment.L5().F0() != null) {
                        pbFragment.L5().F0().M0();
                    }
                }
                FunAdRecordHttpMessage.uploadRequestRecord("a005", "0", this.a.a.y1().P(), this.a.a.y1().l(), null);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a005").param("obj_locate", 0).param("resource_id", i).param("obj_param1", "1"));
            }
        }

        @Override // com.baidu.tieba.ft7.g
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                FunAdRecordHttpMessage.uploadRequestRecord("a005", "1", this.a.a.y1().P(), this.a.a.y1().l(), "0");
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a005").param("obj_locate", 1).param("resource_id", 0).param("obj_param1", "1"));
            }
        }
    }

    /* loaded from: classes7.dex */
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
        this.c = new je9(this);
        this.d = new le9(getPageContext());
        this.h = false;
        this.i = false;
        this.q = new tj0();
        this.t = new a(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.onDestroy();
            VoiceManager voiceManager = this.g;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            q46 q46Var = this.l;
            if (q46Var != null) {
                q46Var.h();
            }
            fca fcaVar = this.m;
            if (fcaVar != null) {
                fcaVar.l();
            }
            TbPageExtraHelper.setPrePageKey(getCurrentPageKey());
            sp5.i(new PrePageKeyEvent(getCurrentPageKey()));
            if (this.p != null) {
                this.p = null;
            }
            if (this.n != null) {
                getLifecycle().removeObserver(this.n);
            }
            this.b = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            super.onResume();
            if (this.a != null) {
                tc9.b().n(this.a.L0(), this.a.h1());
            }
            VoiceManager voiceManager = this.g;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            TiePlusEventController tiePlusEventController = this.n;
            if (tiePlusEventController != null) {
                tiePlusEventController.onResume();
            }
            Fragment fragment = this.b;
            if (fragment instanceof BaseFragment) {
                ((BaseFragment) fragment).setPrimary(true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048614, this, i, keyEvent)) == null) {
            Fragment E1 = E1();
            if ((E1 instanceof PbFragment) && ((PbFragment) E1).onKeyDown(i, keyEvent)) {
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public Fragment C1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return PbFragment.q6();
        }
        return (Fragment) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ma9
    public boolean G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.r2(str)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void U1(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, str) == null) && str != null && this.m != null) {
            this.m.n(vg.g(str, 0L));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, motionEvent)) == null) {
            this.q.a(motionEvent);
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            Fragment E1 = E1();
            if (E1 instanceof BaseFragment) {
                ((BaseFragment) E1).onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            super.onKeyboardVisibilityChanged(z);
            Fragment E1 = E1();
            if (E1 instanceof AbsVideoPbFragment) {
                ((AbsVideoPbFragment) E1).onKeyboardVisibilityChanged(z);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            PbModel pbModel = this.a;
            if (pbModel != null) {
                pbModel.S2(bundle);
            }
            VoiceManager voiceManager = this.g;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    public void D1(u89 u89Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u89Var) == null) {
            String I1 = I1(u89Var);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            if (supportFragmentManager.findFragmentByTag(I1) == null) {
                this.b = C1(I1);
                supportFragmentManager.beginTransaction().add(R.id.obfuscated_res_0x7f0907a1, this.b, I1).commitAllowingStateLoss();
            }
        }
    }

    public final void P1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            if (bundle != null) {
                this.a = new PbModel(this, bundle, this.t);
            } else {
                this.a = new PbModel(this, getIntent(), this.t);
            }
            setForceInterceptStimeStat(this.a.e2());
            this.a.j3(L1());
            this.a.X2(J1());
        }
    }

    public final void T1(u89 u89Var) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048594, this, u89Var) != null) || u89Var == null || u89Var.k() == null || (intent = getIntent()) == null) {
            return;
        }
        Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
        this.s = uri;
        fv9.d().g(uri, u89Var.k().getId());
    }

    public Fragment E1() {
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

    public long H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.r;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.ma9
    public je9 I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.c;
        }
        return (je9) invokeV.objValue;
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
            lx5.b(this.n);
            return this.n;
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

    public void V1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.finish();
        }
    }

    @Override // com.baidu.tieba.ma9
    public String X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null) {
                return pbModel.X0();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ma9
    public int c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.y1() != null) {
                return this.a.y1().V();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (getIntent().getParcelableExtra("video_origin_area") == null && !this.h && !this.i) {
                super.enterExitAnimation();
            } else {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            }
        }
    }

    @Override // com.baidu.tieba.sj0
    @NonNull
    public tj0 f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.q;
        }
        return (tj0) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean getGpuSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return TbadkCoreApplication.getInst().isGpuOpen();
        }
        return invokeV.booleanValue;
    }

    public View getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.e;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            super.onBackPressed();
            Fragment E1 = E1();
            if (E1 instanceof PbFragment) {
                ((PbFragment) E1).r6();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            super.onNetRefreshButtonClicked();
            if (this.a != null) {
                showLoadingView(this.e);
                this.a.y2();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            super.onPause();
            VoiceManager voiceManager = this.g;
            if (voiceManager != null) {
                voiceManager.onPause();
            }
            TiePlusEventController tiePlusEventController = this.n;
            if (tiePlusEventController != null) {
                tiePlusEventController.onPause();
            }
            SpeedStatsManager.getInstance().setStatsFlag(-1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.g;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            super.onStop();
            VoiceManager voiceManager = this.g;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            Fragment fragment = this.b;
            if (fragment instanceof BaseFragment) {
                ((BaseFragment) fragment).setPrimary(false);
            }
        }
    }

    @Override // com.baidu.tieba.h95
    public String r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null) {
                return pbModel.R1();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean shouldChangeStatusBarIconAndTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return !(this.b instanceof AbsVideoPbFragment);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.h95
    public String w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null) {
                return pbModel.getForumId();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.g;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ma9
    public boolean z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null) {
                return false;
            }
            return pbModel.q2();
        }
        return invokeV.booleanValue;
    }

    public final void O1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            tc9.b().n(this.a.L0(), this.a.h1());
            registerListener(new b(this, 2004003));
            if (!this.a.C2()) {
                this.a.y2();
            }
            if (this.a.n2()) {
                u89 J0 = this.a.J0(td7.a());
                if (J0 != null) {
                    if (this.a.y1() != null) {
                        this.a.y1().P0(J0.N());
                    }
                    J0.D0(3);
                    if (E1() == null) {
                        this.a.v3(J0);
                        if (this.b == null) {
                            D1(J0);
                        }
                    }
                }
                if (J1() != 0) {
                    showLoadingView(findViewById(R.id.obfuscated_res_0x7f0907a1), true);
                }
            } else {
                showLoadingView(findViewById(R.id.obfuscated_res_0x7f0907a1), true);
            }
            if (xi.F() && !TbadkCoreApplication.getInst().syncHasFinish) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
            }
            R1();
            S1();
        }
    }

    public final void Q1(View view2, hk5 hk5Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, view2, hk5Var, str) == null) {
            new WriteTipBubbleController(getPageContext(), new c(this, view2, hk5Var)).d(view2, getString(R.string.obfuscated_res_0x7f0f0ed3), str, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_PB_REPLY);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048609, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            Fragment E1 = E1();
            if (E1 != null) {
                E1.onActivityResult(i, i2, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048618, this, i, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0010, code lost:
        if (r0.getMemberCloseAdVipClose() == 1) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void R1() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                z = true;
            }
            z = false;
            if (!z && UbsABTestHelper.isPbPageBannerFunAdSdkTest()) {
                Activity e2 = h9.f().e(0);
                if (this.p == null) {
                    this.p = new d(this);
                }
                FunAdRecordHttpMessage.uploadRequestRecord("a005", null, this.a.y1().P(), this.a.y1().l(), null);
                String str = "1";
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("tid", this.a.y1().P()).param("fid", this.a.y1().l()).param("obj_type", "a005").param("obj_param1", "1"));
                String d2 = lt7.e().d("pb_banner");
                ft7 m = ft7.m();
                if (e2 == null) {
                    e2 = this;
                }
                ft7.g gVar = this.p;
                if (!UbsABTestHelper.isPbPageBannerFunAdSdkTest()) {
                    str = "0";
                }
                m.x(e2, d2, gVar, ft7.b("pb", str));
            }
        }
    }

    public final void S1() {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && !mt7.f() && UbsABTestHelper.isPbCommentFunAdABTest()) {
            ft7 m = ft7.m();
            String f = ft7.f();
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest()) {
                str = "1";
            } else {
                str = "0";
            }
            ft7.f b2 = ft7.b("pb", str);
            PbModel pbModel = this.a;
            if (pbModel == null || pbModel.y1() == null) {
                str2 = "";
            } else {
                str2 = this.a.y1().P();
            }
            PbModel pbModel2 = this.a;
            if (pbModel2 == null || pbModel2.y1() == null) {
                str3 = "";
            } else {
                str3 = this.a.y1().l();
            }
            m.K(this, f, b2, str2, str3);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        wc9 wc9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            if (!TbSingleton.getInstance().isNeedShowInterestGuide() && (wc9Var = this.k) != null) {
                wc9Var.a(this.a);
            }
            Fragment E1 = E1();
            if (E1 instanceof vg9) {
                ((vg9) E1).finish();
            } else {
                super.finish();
            }
            fb9 fb9Var = this.j;
            if (fb9Var != null && !fb9Var.b(this.a)) {
                if (this.h || this.i) {
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
    public fs5 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            fs5 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                PbModel pbModel = this.a;
                if (pbModel != null) {
                    if (pbModel.y1() != null) {
                        ThreadData N = this.a.y1().N();
                        pageStayDurationItem.u(N.getNid());
                        if (N.isNormalThreadType()) {
                            pageStayDurationItem.t = "1";
                        } else if (N.isVideoThreadType()) {
                            pageStayDurationItem.t = "2";
                        } else {
                            pageStayDurationItem.t = "3";
                        }
                    }
                    pageStayDurationItem.C(vg.g(this.a.R1(), 0L));
                    if (this.a.y1() != null && this.a.y1().N() != null) {
                        pageStayDurationItem.u(this.a.y1().N().getNid());
                        pageStayDurationItem.B(this.a.y1().N().getThreadType());
                    }
                }
                if (!wi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    pageStayDurationItem.z(TbadkCoreApplication.getInst().getTaskId());
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                    pageStayDurationItem.q(TbadkCoreApplication.getInst().getAdAdSense().k);
                }
                Fragment E1 = E1();
                if (E1 instanceof PbFragment) {
                    int i = ((PbFragment) E1).s1;
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
                    Uri uri = this.s;
                    if (uri != null && ix5.b(uri).booleanValue()) {
                        pageStayDurationItem.D(ix5.e(this.s.toString()));
                    }
                }
                if (!StringUtils.isNull(this.a.mTopicSubjectName)) {
                    pageStayDurationItem.E(this.a.mTopicSubjectName);
                } else {
                    Uri uri2 = this.s;
                    if (uri2 != null && ix5.b(uri2).booleanValue()) {
                        pageStayDurationItem.E("hottopic_detail_hybrid");
                    }
                }
            }
            return pageStayDurationItem;
        }
        return (fs5) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int intExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, bundle) == null) {
            this.r = System.currentTimeMillis();
            initUniqueId();
            P1(bundle);
            boolean z = true;
            if (!h9.f().h("MainTabActivity")) {
                if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null) {
                    this.h = true;
                } else if (K1().x1() == 7) {
                    this.i = true;
                }
            }
            if (this.h || this.i) {
                setIsAddSwipeBackLayout(false);
            }
            super.onCreate(bundle);
            N1();
            setContentView(F1());
            this.e = findViewById(R.id.obfuscated_res_0x7f0907a1);
            adjustResizeForSoftInput();
            addGlobalLayoutListener();
            O1(bundle);
            VoiceManager voiceManager = new VoiceManager();
            this.g = voiceManager;
            voiceManager.onCreate(getPageContext());
            this.j = new fb9(getPageContext());
            this.k = new wc9(getPageContext());
            this.l = new q46(getPageContext(), "client_pb_live");
            this.m = new fca(getPageContext(), getUniqueId());
            if (this.n == null) {
                if (getIntent() == null || ((intExtra = getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_VIDEO_PAGE_TYPE, 0)) != 1 && intExtra != 2 && intExtra != 3 && intExtra != 4 && intExtra != 5)) {
                    z = false;
                }
                if (z) {
                    this.n = new TiePlusEventController(this, TiePlusStat.Locate.VIDEO_MIDDLE_COMMENT);
                } else {
                    this.n = new TiePlusEventController(this, TiePlusStat.Locate.PB);
                }
            }
            getLifecycle().addObserver(this.n);
            if (this.a != null) {
                i95.d(this.a.R1() + "_onCreate_" + System.currentTimeMillis());
                ew8 activityLog = ActivityLog.getInstance();
                activityLog.c("PB", "onCreate:" + this.a.R1());
            }
            eg5.b(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onScreenShot(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, str) == null) {
            super.onScreenShot(str);
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.y1() != null) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_SCREEN_SHOT);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("tid", this.a.R1());
                statisticItem.param("fid", this.a.y1().l());
                statisticItem.param("obj_type", 3);
                TiebaStatic.log(statisticItem);
            }
        }
    }
}
