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
import com.baidu.adp.base.BdActivityStack;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
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
import com.baidu.tbadk.mutiprocess.MutiProcessManager;
import com.baidu.tbadk.mutiprocess.prePageKey.PrePageKeyEvent;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.pageStayDuration.PageStayDurationItem;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tieba.R;
import com.baidu.tieba.cx9;
import com.baidu.tieba.ds9;
import com.baidu.tieba.funAd.http.FunAdRecordHttpMessage;
import com.baidu.tieba.g1a;
import com.baidu.tieba.i45;
import com.baidu.tieba.j0b;
import com.baidu.tieba.j45;
import com.baidu.tieba.jv9;
import com.baidu.tieba.ke0;
import com.baidu.tieba.le0;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.nb5;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.q58;
import com.baidu.tieba.qd;
import com.baidu.tieba.qp7;
import com.baidu.tieba.qt5;
import com.baidu.tieba.qu9;
import com.baidu.tieba.so5;
import com.baidu.tieba.sy9;
import com.baidu.tieba.t06;
import com.baidu.tieba.tt5;
import com.baidu.tieba.ug5;
import com.baidu.tieba.uy9;
import com.baidu.tieba.w58;
import com.baidu.tieba.x58;
import com.baidu.tieba.zha;
import com.baidu.tieba.zw9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
/* loaded from: classes7.dex */
public abstract class AbsPbActivity extends BaseFragmentActivity implements qu9<PbActivity>, VoiceManager.j, i45, ke0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbModel a;
    public Fragment b;
    public final sy9 c;
    public final uy9 d;
    public View e;
    public boolean f;
    public VoiceManager g;
    public boolean h;
    public boolean i;
    public jv9 j;
    public cx9 k;
    public t06 l;
    public j0b m;
    @Nullable
    public TiePlusEventController n;
    public boolean o;
    public q58.g p;
    public final le0 q;
    public long r;
    public Uri s;
    public PbModel.h t;

    public String D1(ds9 ds9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ds9Var)) == null) ? "pb_fragment_tag" : (String) invokeL.objValue;
    }

    public abstract int E1();

    public abstract int G1();

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.IPlayView J1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? "a005" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    public abstract int z1();

    /* loaded from: classes7.dex */
    public class a implements PbModel.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsPbActivity a;

        /* renamed from: com.baidu.tieba.pb.pb.main.AbsPbActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0447a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ a b;

            public RunnableC0447a(a aVar, String str) {
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
                    if ((fragment instanceof PbFragment) && ((PbFragment) fragment).W6() != null && ((PbFragment) this.b.a.b).W6().W0() != null) {
                        AbsPbActivity absPbActivity = this.b.a;
                        absPbActivity.P1(((PbFragment) absPbActivity.b).W6().W0(), ((PbFragment) this.b.a.b).T6(), this.a);
                        this.b.a.o = true;
                        return;
                    }
                    Fragment fragment2 = this.b.a.b;
                    if ((fragment2 instanceof AbsVideoPbFragment) && ((AbsVideoPbFragment) fragment2).Z3() != null) {
                        AbsPbActivity absPbActivity2 = this.b.a;
                        absPbActivity2.P1(((AbsVideoPbFragment) absPbActivity2.b).Z3(), ((AbsVideoPbFragment) this.b.a.b).m4(), this.a);
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
        public void b(ds9 ds9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ds9Var) == null) {
                Fragment y1 = this.a.y1();
                if (y1 instanceof g1a) {
                    g1a g1aVar = (g1a) y1;
                    if (g1aVar.m1() != null) {
                        g1aVar.m1().b(ds9Var);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), responsedMessage, Boolean.valueOf(z2), Long.valueOf(j)}) == null) {
                Fragment y1 = this.a.y1();
                if (y1 instanceof g1a) {
                    g1a g1aVar = (g1a) y1;
                    if (g1aVar.m1() != null) {
                        g1aVar.m1().a(i, z, responsedMessage, z2, j);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, ds9 ds9Var, String str, int i4, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), ds9Var, str, Integer.valueOf(i4), Boolean.valueOf(z2)}) == null) {
                this.a.T1(ds9Var);
                this.a.y1();
                if (!z) {
                    if (!this.a.f && !this.a.a.j2()) {
                        AbsPbActivity absPbActivity = this.a;
                        absPbActivity.showNetRefreshView(absPbActivity.e, this.a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), null, null, true, this.a.getNetRefreshListener());
                        so5.a.a(this.a.getUniqueId(), new Pair<>(PushMessageHelper.ERROR_TYPE, "pb_page"), new Pair<>("error_info", "pb page net error3"));
                        AbsPbActivity absPbActivity2 = this.a;
                        absPbActivity2.setNetRefreshViewEmotionMarginTop(BdUtilHelper.getDimens(absPbActivity2.getActivity(), R.dimen.obfuscated_res_0x7f0703c8));
                    }
                } else if (ds9Var != null) {
                    AbsPbActivity absPbActivity3 = this.a;
                    absPbActivity3.hideNetRefreshView(absPbActivity3.e);
                    so5.a.h(this.a.getUniqueId());
                }
                Fragment y1 = this.a.y1();
                if (y1 == null) {
                    if (z) {
                        PbModel pbModel = this.a.a;
                        if (pbModel != null) {
                            pbModel.cancelLoadData();
                            this.a.a.s3(ds9Var);
                        }
                        AbsPbActivity absPbActivity4 = this.a;
                        if (absPbActivity4.b == null) {
                            absPbActivity4.x1(ds9Var);
                        }
                    } else {
                        AbsPbActivity absPbActivity5 = this.a;
                        absPbActivity5.hideLoadingView(absPbActivity5.e);
                    }
                } else if (y1 instanceof g1a) {
                    g1a g1aVar = (g1a) y1;
                    if (g1aVar.m1() != null) {
                        g1aVar.m1().c(z, i, i2, i3, ds9Var, str, i4, z2);
                    }
                }
                String stringExtra = this.a.getIntent().getStringExtra("key_open_editor_tips");
                if (!TextUtils.isEmpty(stringExtra) && !this.a.o) {
                    SafeHandler.getInst().postDelayed(new RunnableC0447a(this, stringExtra), 100L);
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
            ds9 pbData = pbPageReadLocalResponseMessage.getPbData();
            if (pbData == null) {
                this.a.f = false;
                return;
            }
            ThreadData O = pbData.O();
            O.setForum_name(pbData.m());
            if (O != null) {
                this.a.a.E0(O);
            }
            this.a.f = true;
            Fragment y1 = this.a.y1();
            if (y1 == null) {
                this.a.a.s3(pbData);
                AbsPbActivity absPbActivity = this.a;
                if (absPbActivity.b == null) {
                    absPbActivity.x1(pbData);
                }
            } else if (y1 instanceof PbFragment) {
                this.a.a.z2(pbData, pbPageReadLocalResponseMessage.getUpdateType(), pbPageReadLocalResponseMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements WriteTipBubbleController.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ ug5 b;
        public final /* synthetic */ AbsPbActivity c;

        public c(AbsPbActivity absPbActivity, View view2, ug5 ug5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absPbActivity, view2, ug5Var};
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
            this.b = ug5Var;
        }

        @Override // com.baidu.tbadk.core.dialog.WriteTipBubbleController.b
        public void a(View view2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, str) == null) {
                this.a.performClick();
                this.b.l();
                this.b.v().k().setText(str);
                Editable text = this.b.v().k().getText();
                if (!TextUtils.isEmpty(text)) {
                    this.b.v().k().setSelection(text.length());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements q58.g {
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

        @Override // com.baidu.tieba.q58.g
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                Fragment fragment = this.a.b;
                if (fragment instanceof PbFragment) {
                    PbFragment pbFragment = (PbFragment) fragment;
                    if (pbFragment.W6() != null && pbFragment.W6().T0() != null) {
                        pbFragment.W6().T0().M0();
                    }
                }
                FunAdRecordHttpMessage.uploadRequestRecord("a005", "0", this.a.a.t1().Q(), this.a.a.t1().l(), null);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a005").param("obj_locate", 0).param("resource_id", i).param("obj_param1", "1"));
            }
        }

        @Override // com.baidu.tieba.q58.g
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                FunAdRecordHttpMessage.uploadRequestRecord("a005", "1", this.a.a.t1().Q(), this.a.a.t1().l(), "0");
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
        this.c = new sy9(this);
        this.d = new uy9(getPageContext());
        this.h = false;
        this.i = false;
        this.q = new le0();
        this.t = new a(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            super.onDestroy();
            VoiceManager voiceManager = this.g;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            t06 t06Var = this.l;
            if (t06Var != null) {
                t06Var.h();
            }
            j0b j0bVar = this.m;
            if (j0bVar != null) {
                j0bVar.l();
            }
            TbPageExtraHelper.setPrePageKey(getCurrentPageKey());
            MutiProcessManager.publishEvent(new PrePageKeyEvent(getCurrentPageKey()));
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
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            super.onResume();
            if (this.a != null) {
                zw9.b().n(this.a.F0(), this.a.c1());
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
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048613, this, i, keyEvent)) == null) {
            Fragment y1 = y1();
            if ((y1 instanceof PbFragment) && ((PbFragment) y1).onKeyDown(i, keyEvent)) {
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public void U1(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, str) == null) && str != null && this.m != null) {
            this.m.n(JavaTypesHelper.toLong(str, 0L));
        }
    }

    @Override // com.baidu.tieba.qu9
    public boolean X(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.n2(str)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, motionEvent)) == null) {
            this.q.a(motionEvent);
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            Fragment y1 = y1();
            if (y1 instanceof BaseFragment) {
                ((BaseFragment) y1).onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            super.onKeyboardVisibilityChanged(z);
            Fragment y1 = y1();
            if (y1 instanceof AbsVideoPbFragment) {
                ((AbsVideoPbFragment) y1).onKeyboardVisibilityChanged(z);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            PbModel pbModel = this.a;
            if (pbModel != null) {
                pbModel.P2(bundle);
            }
            VoiceManager voiceManager = this.g;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    public Fragment w1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, str)) == null) {
            return PbFragment.O7();
        }
        return (Fragment) invokeL.objValue;
    }

    @Override // com.baidu.tieba.qu9
    public String A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null) {
                return pbModel.S0();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public long B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.r;
        }
        return invokeV.longValue;
    }

    public PbModel F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return (PbModel) invokeV.objValue;
    }

    @NonNull
    public TiePlusEventController K1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            tt5.b(this.n);
            return this.n;
        }
        return (TiePlusEventController) invokeV.objValue;
    }

    public final void L1() {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (intent = getIntent()) != null) {
            String stringExtra = intent.getStringExtra("target_scheme");
            if (!TextUtils.isEmpty(stringExtra)) {
                UrlSchemaHelper.goToNewPageByScheme(stringExtra);
            }
        }
    }

    @Override // com.baidu.tieba.ke0
    @NonNull
    public le0 M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.q;
        }
        return (le0) invokeV.objValue;
    }

    public void V1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.g;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qu9
    public boolean Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null) {
                return false;
            }
            return pbModel.m2();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (getIntent().getParcelableExtra("video_origin_area") == null && !this.h && !this.i) {
                super.enterExitAnimation();
            } else {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean getGpuSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return TbadkCoreApplication.getInst().isGpuOpen();
        }
        return invokeV.booleanValue;
    }

    public View getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.e;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qu9
    public sy9 h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.c;
        }
        return (sy9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i45
    public String i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null) {
                return pbModel.getForumId();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i45
    public String k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null) {
                return pbModel.N1();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            super.onBackPressed();
            Fragment y1 = y1();
            if (y1 instanceof PbFragment) {
                ((PbFragment) y1).P7();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            super.onNetRefreshButtonClicked();
            if (this.a != null) {
                showLoadingView(this.e);
                this.a.u2();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean shouldChangeStatusBarIconAndTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return !(this.b instanceof AbsVideoPbFragment);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.qu9
    public int v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.t1() != null) {
                return this.a.t1().W();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public Fragment y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            List<Fragment> fragments = getSupportFragmentManager().getFragments();
            if (!ListUtils.isEmpty(fragments)) {
                return fragments.get(0);
            }
            return null;
        }
        return (Fragment) invokeV.objValue;
    }

    public final void N1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            zw9.b().n(this.a.F0(), this.a.c1());
            registerListener(new b(this, 2004003));
            if (!this.a.y2()) {
                this.a.u2();
            }
            if (this.a.j2()) {
                ds9 D0 = this.a.D0(qp7.b());
                if (D0 != null) {
                    if (this.a.t1() != null) {
                        this.a.t1().S0(D0.O());
                    }
                    D0.F0(3);
                    if (y1() == null) {
                        this.a.s3(D0);
                        if (this.b == null) {
                            x1(D0);
                        }
                    }
                }
                if (E1() != 0) {
                    showLoadingView(findViewById(R.id.obfuscated_res_0x7f0907db), true);
                }
            } else {
                showLoadingView(findViewById(R.id.obfuscated_res_0x7f0907db), true);
            }
            if (BdUtilHelper.isNetOk() && !TbadkCoreApplication.getInst().syncHasFinish) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
            }
            Q1();
            S1();
        }
    }

    public final void O1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            if (bundle != null) {
                this.a = new PbModel(this, bundle, this.t);
            } else {
                this.a = new PbModel(this, getIntent(), this.t);
            }
            setForceInterceptStimeStat(this.a.a2());
            this.a.g3(G1());
            this.a.U2(E1());
        }
    }

    public final void T1(ds9 ds9Var) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, ds9Var) != null) || ds9Var == null || ds9Var.k() == null || (intent = getIntent()) == null) {
            return;
        }
        Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
        this.s = uri;
        zha.d().g(uri, ds9Var.k().getId());
    }

    public void x1(ds9 ds9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, ds9Var) == null) {
            String D1 = D1(ds9Var);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            if (supportFragmentManager.findFragmentByTag(D1) == null) {
                this.b = w1(D1);
                supportFragmentManager.beginTransaction().add(R.id.obfuscated_res_0x7f0907db, this.b, D1).commitAllowingStateLoss();
            }
        }
    }

    public final void P1(View view2, ug5 ug5Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, view2, ug5Var, str) == null) {
            new WriteTipBubbleController(getPageContext(), new c(this, view2, ug5Var)).d(view2, getString(R.string.obfuscated_res_0x7f0f0f28), str, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_PB_REPLY);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048608, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            Fragment y1 = y1();
            if (y1 != null) {
                y1.onActivityResult(i, i2, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048617, this, i, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0010, code lost:
        if (r0.getMemberCloseAdVipClose() == 1) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Q1() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                z = true;
            }
            z = false;
            if (!z && UbsABTestHelper.isPbPageBannerFunAdSdkTest()) {
                Activity indexActivtiy = BdActivityStack.getInst().getIndexActivtiy(0);
                if (this.p == null) {
                    this.p = new d(this);
                }
                FunAdRecordHttpMessage.uploadRequestRecord("a005", null, this.a.t1().Q(), this.a.t1().l(), null);
                String str = "1";
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("tid", this.a.t1().Q()).param("fid", this.a.t1().l()).param("obj_type", "a005").param("obj_param1", "1"));
                String d2 = w58.e().d("pb_banner");
                q58 m = q58.m();
                if (indexActivtiy == null) {
                    indexActivtiy = this;
                }
                q58.g gVar = this.p;
                if (!UbsABTestHelper.isPbPageBannerFunAdSdkTest()) {
                    str = "0";
                }
                m.x(indexActivtiy, d2, gVar, q58.b("pb", str));
            }
        }
    }

    public final void S1() {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && !x58.f() && UbsABTestHelper.isPbCommentFunAdABTest()) {
            q58 m = q58.m();
            String f = q58.f();
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest()) {
                str = "1";
            } else {
                str = "0";
            }
            q58.f b2 = q58.b("pb", str);
            PbModel pbModel = this.a;
            if (pbModel == null || pbModel.t1() == null) {
                str2 = "";
            } else {
                str2 = this.a.t1().Q();
            }
            PbModel pbModel2 = this.a;
            if (pbModel2 == null || pbModel2.t1() == null) {
                str3 = "";
            } else {
                str3 = this.a.t1().l();
            }
            m.K(this, f, b2, str2, str3);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        cx9 cx9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (!TbSingleton.getInstance().isNeedShowInterestGuide() && (cx9Var = this.k) != null) {
                cx9Var.a(this.a);
            }
            Fragment y1 = y1();
            if (y1 instanceof g1a) {
                ((g1a) y1).finish();
            } else {
                super.finish();
            }
            jv9 jv9Var = this.j;
            if (jv9Var != null && !jv9Var.b(this.a)) {
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public PageStayDurationItem getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            PageStayDurationItem pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                PbModel pbModel = this.a;
                if (pbModel != null) {
                    if (pbModel.t1() != null) {
                        ThreadData O = this.a.t1().O();
                        pageStayDurationItem.setNid(O.getNid());
                        if (O.isNormalThreadType()) {
                            pageStayDurationItem.resourceType = "1";
                        } else if (O.isVideoThreadType()) {
                            pageStayDurationItem.resourceType = "2";
                        } else {
                            pageStayDurationItem.resourceType = "3";
                        }
                    }
                    pageStayDurationItem.setTid(JavaTypesHelper.toLong(this.a.N1(), 0L));
                    if (this.a.t1() != null && this.a.t1().O() != null) {
                        pageStayDurationItem.setNid(this.a.t1().O().getNid());
                        pageStayDurationItem.setThreadType(this.a.t1().O().getThreadType());
                    }
                }
                if (!qd.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                    pageStayDurationItem.setAbTag(TbadkCoreApplication.getInst().getAdAdSense().k);
                }
                Fragment y1 = y1();
                if (y1 instanceof PbFragment) {
                    int i = ((PbFragment) y1).u1;
                    if (i == 2) {
                        pageStayDurationItem.setObjLocation("a002");
                    } else if (i == 1) {
                        pageStayDurationItem.setObjLocation("a038");
                    } else if (i == 3) {
                        pageStayDurationItem.setObjLocation("a006");
                    }
                }
                if (!StringUtils.isNull(this.a.mTopicId)) {
                    pageStayDurationItem.setTopicId(this.a.mTopicId);
                } else {
                    Uri uri = this.s;
                    if (uri != null && qt5.b(uri).booleanValue()) {
                        pageStayDurationItem.setTopicId(qt5.e(this.s.toString()));
                    }
                }
                if (!StringUtils.isNull(this.a.mTopicSubjectName)) {
                    pageStayDurationItem.setTopicSubjectName(this.a.mTopicSubjectName);
                } else {
                    Uri uri2 = this.s;
                    if (uri2 != null && qt5.b(uri2).booleanValue()) {
                        pageStayDurationItem.setTopicSubjectName("hottopic_detail_hybrid");
                    }
                }
            }
            return pageStayDurationItem;
        }
        return (PageStayDurationItem) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int intExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, bundle) == null) {
            this.r = System.currentTimeMillis();
            initUniqueId();
            O1(bundle);
            boolean z = true;
            if (!BdActivityStack.getInst().isActivityExist("MainTabActivity")) {
                if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null) {
                    this.h = true;
                } else if (F1().s1() == 7) {
                    this.i = true;
                }
            }
            if (this.h || this.i) {
                setIsAddSwipeBackLayout(false);
            }
            super.onCreate(bundle);
            L1();
            setContentView(z1());
            this.e = findViewById(R.id.obfuscated_res_0x7f0907db);
            adjustResizeForSoftInput();
            addGlobalLayoutListener();
            N1(bundle);
            VoiceManager voiceManager = new VoiceManager();
            this.g = voiceManager;
            voiceManager.onCreate(getPageContext());
            this.j = new jv9(getPageContext());
            this.k = new cx9(getPageContext());
            this.l = new t06(getPageContext(), "client_pb_live");
            this.m = new j0b(getPageContext(), getUniqueId());
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
                j45.d(this.a.N1() + "_onCreate_" + System.currentTimeMillis());
                TbLog activityLog = ActivityLog.getInstance();
                activityLog.i("PB", "onCreate:" + this.a.N1());
            }
            nb5.b(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onScreenShot(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            super.onScreenShot(str);
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.t1() != null) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_SCREEN_SHOT);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("tid", this.a.N1());
                statisticItem.param("fid", this.a.t1().l());
                statisticItem.param("obj_type", 3);
                TiebaStatic.log(statisticItem);
            }
        }
    }
}
