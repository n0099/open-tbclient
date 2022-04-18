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
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.mutiprocess.prePageKey.PrePageKeyEvent;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.switchs.PbLoadingViewOptimizeSwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbMemeImageView;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tieba.R;
import com.baidu.tieba.funAd.http.FunAdRecordHttpMessage;
import com.baidu.tieba.pb.PbPageRequestMessage;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bs7;
import com.repackage.bs8;
import com.repackage.cw7;
import com.repackage.es6;
import com.repackage.ju7;
import com.repackage.jz7;
import com.repackage.ks6;
import com.repackage.kx7;
import com.repackage.ld6;
import com.repackage.lh0;
import com.repackage.ls6;
import com.repackage.lt4;
import com.repackage.lt7;
import com.repackage.m25;
import com.repackage.mg;
import com.repackage.mh0;
import com.repackage.mx7;
import com.repackage.ni;
import com.repackage.o55;
import com.repackage.oi;
import com.repackage.ot7;
import com.repackage.pg;
import com.repackage.sh5;
import com.repackage.ty4;
import com.repackage.uc5;
import com.repackage.vd8;
import com.repackage.x8;
import com.repackage.y75;
import com.repackage.yv7;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public abstract class AbsPbActivity extends BaseFragmentActivity implements ot7<PbActivity>, VoiceManager.j, lt4, lh0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PB_FRAGMENT_TAG = "pb_fragment_tag";
    public static final String VIDEO_PB_FRAGMENT_TAG = "video_pb_fragment_tag";
    public transient /* synthetic */ FieldHolder $fh;
    public long createTime;
    public boolean hasRemindedEditorTips;
    public es6.h loadListener;
    public ju7 mBackController;
    public Fragment mCurrentFragment;
    public final kx7 mEvent;
    public boolean mIsFromSchema;
    public boolean mIsHasCache;
    public sh5 mNEGFeedBackManager;
    public PbModel mPbModel;
    public cw7 mPbToHomeUpdateController;
    public final mx7 mPostShareController;
    public View mRootView;
    public bs8 mUserBlockController;
    public VideoPbViewModel mVideoPbViewModel;
    public VoiceManager mVoiceManager;
    public PbModel.g onLoadPbDataCallback;
    @Nullable
    public TiePlusEventController tiePlusEventController;
    public final mh0 touchInfoCollector;

    /* loaded from: classes3.dex */
    public class a implements PbModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsPbActivity a;

        /* renamed from: com.baidu.tieba.pb.pb.main.AbsPbActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0222a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ a b;

            public RunnableC0222a(a aVar, String str) {
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
                    Fragment fragment = this.b.a.mCurrentFragment;
                    if ((fragment instanceof PbFragment) && ((PbFragment) fragment).P4() != null && ((PbFragment) this.b.a.mCurrentFragment).P4().v0() != null) {
                        AbsPbActivity absPbActivity = this.b.a;
                        absPbActivity.isShowDeleteResumeEditorTips(((PbFragment) absPbActivity.mCurrentFragment).P4().v0(), ((PbFragment) this.b.a.mCurrentFragment).L4(), this.a);
                        this.b.a.hasRemindedEditorTips = true;
                        return;
                    }
                    Fragment fragment2 = this.b.a.mCurrentFragment;
                    if (!(fragment2 instanceof AbsVideoPbFragment) || ((AbsVideoPbFragment) fragment2).P2() == null) {
                        return;
                    }
                    AbsPbActivity absPbActivity2 = this.b.a;
                    absPbActivity2.isShowDeleteResumeEditorTips(((AbsVideoPbFragment) absPbActivity2.mCurrentFragment).P2(), ((AbsVideoPbFragment) this.b.a.mCurrentFragment).e3(), this.a);
                    this.b.a.hasRemindedEditorTips = true;
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

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), responsedMessage, Boolean.valueOf(z2), Long.valueOf(j)}) == null) {
                Fragment findFragment = this.a.findFragment();
                if (findFragment instanceof jz7) {
                    jz7 jz7Var = (jz7) findFragment;
                    if (jz7Var.U() != null) {
                        jz7Var.U().a(i, z, responsedMessage, z2, j);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void b(bs7 bs7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bs7Var) == null) {
                Fragment findFragment = this.a.findFragment();
                if (findFragment instanceof jz7) {
                    jz7 jz7Var = (jz7) findFragment;
                    if (jz7Var.U() != null) {
                        jz7Var.U().b(bs7Var);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void c(boolean z, int i, int i2, int i3, bs7 bs7Var, String str, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), bs7Var, str, Integer.valueOf(i4)}) == null) {
                this.a.saveSearchRecForumParams(bs7Var);
                this.a.mVideoPbViewModel.y(this.a.mPbModel.J0());
                this.a.mVideoPbViewModel.v(false);
                if (!PbLoadingViewOptimizeSwitch.isSwitchOn()) {
                    AbsPbActivity absPbActivity = this.a;
                    absPbActivity.hideLoadingView(absPbActivity.mRootView);
                }
                if (z) {
                    if (bs7Var != null) {
                        AbsPbActivity absPbActivity2 = this.a;
                        absPbActivity2.hideNetRefreshView(absPbActivity2.mRootView);
                    }
                } else if (!this.a.mIsHasCache && !this.a.mPbModel.E1()) {
                    AbsPbActivity absPbActivity3 = this.a;
                    absPbActivity3.showNetRefreshView(absPbActivity3.mRootView, this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c16, str, Integer.valueOf(i)), null, null, true, this.a.getNetRefreshListener());
                    AbsPbActivity absPbActivity4 = this.a;
                    absPbActivity4.setNetRefreshViewEmotionMarginTop(oi.f(absPbActivity4.getActivity(), R.dimen.obfuscated_res_0x7f0702ad));
                }
                Fragment findFragment = this.a.findFragment();
                if (findFragment == null) {
                    if (z) {
                        this.a.mVideoPbViewModel.s(bs7Var, 3);
                        PbModel pbModel = this.a.mPbModel;
                        if (pbModel != null) {
                            pbModel.cancelLoadData();
                            this.a.mPbModel.O2(bs7Var);
                        }
                        AbsPbActivity absPbActivity5 = this.a;
                        if (absPbActivity5.mCurrentFragment == null) {
                            absPbActivity5.fillFragment(bs7Var);
                        }
                    }
                } else if (findFragment instanceof jz7) {
                    jz7 jz7Var = (jz7) findFragment;
                    if (jz7Var.U() != null) {
                        jz7Var.U().c(z, i, i2, i3, bs7Var, str, i4);
                    }
                }
                String stringExtra = this.a.getIntent().getStringExtra("key_open_editor_tips");
                if (TextUtils.isEmpty(stringExtra) || this.a.hasRemindedEditorTips) {
                    return;
                }
                pg.a().postDelayed(new RunnableC0222a(this, stringExtra), 100L);
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
                bs7 pbData = pbPageReadLocalResponseMessage.getPbData();
                if (pbData == null) {
                    this.a.mIsHasCache = false;
                    if (lt7.a().e() && TbSingleton.getInstance().pushPbResMsg != null && (TbSingleton.getInstance().pushPbResMsg.getOrginalMessage().getSelf() instanceof PbPageRequestMessage) && ((PbPageRequestMessage) TbSingleton.getInstance().pushPbResMsg.getOrginalMessage().getSelf()).get_kz() == mg.g(this.a.mPbModel.b, 0L)) {
                        MessageManager.getInstance().dispatchResponsedMessage(TbSingleton.getInstance().pushPbResMsg);
                        TbSingleton.getInstance().pushPbResMsg = null;
                        return;
                    }
                    return;
                }
                ThreadData O = pbData.O();
                if (O != null) {
                    this.a.mPbModel.e0(O);
                }
                this.a.mIsHasCache = true;
                this.a.mVideoPbViewModel.v(false);
                Fragment findFragment = this.a.findFragment();
                if (findFragment == null) {
                    this.a.mVideoPbViewModel.s(pbData, 2);
                    AbsPbActivity absPbActivity = this.a;
                    if (absPbActivity.mCurrentFragment == null) {
                        absPbActivity.fillFragment(pbData);
                    }
                } else if (findFragment instanceof PbFragment) {
                    this.a.mPbModel.Y1(pbData, pbPageReadLocalResponseMessage.getUpdateType(), pbPageReadLocalResponseMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements WriteTipBubbleController.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ m25 b;
        public final /* synthetic */ AbsPbActivity c;

        public c(AbsPbActivity absPbActivity, View view2, m25 m25Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absPbActivity, view2, m25Var};
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
            this.b = m25Var;
        }

        @Override // com.baidu.tbadk.core.dialog.WriteTipBubbleController.b
        public void a(View view2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, str) == null) {
                this.a.performClick();
                this.b.l();
                this.b.v().h().setText(str);
                Editable text = this.b.v().h().getText();
                if (TextUtils.isEmpty(text)) {
                    return;
                }
                this.b.v().h().setSelection(text.length());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements es6.h {
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

        @Override // com.repackage.es6.h
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                Fragment fragment = this.a.mCurrentFragment;
                if (fragment instanceof PbFragment) {
                    PbFragment pbFragment = (PbFragment) fragment;
                    if (pbFragment.P4() != null && pbFragment.P4().u0() != null) {
                        pbFragment.P4().u0().C0();
                    }
                }
                FunAdRecordHttpMessage.uploadRequestRecord("a005", "0", this.a.mPbModel.T0().Q(), this.a.mPbModel.T0().m(), null);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a005").param("obj_locate", 0).param(TiebaStatic.Params.RESOURCE_ID, i).param("obj_param1", "1"));
            }
        }

        @Override // com.repackage.es6.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                FunAdRecordHttpMessage.uploadRequestRecord("a005", "1", this.a.mPbModel.T0().Q(), this.a.mPbModel.T0().m(), "0");
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
        this.mEvent = new kx7(this);
        this.mPostShareController = new mx7(getPageContext());
        this.mIsFromSchema = false;
        this.touchInfoCollector = new mh0();
        this.onLoadPbDataCallback = new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fillFragment(bs7 bs7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, bs7Var) == null) {
            String fragmentTag = getFragmentTag(bs7Var);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            if (supportFragmentManager.findFragmentByTag(fragmentTag) == null) {
                this.mCurrentFragment = createFragment(fragmentTag);
                supportFragmentManager.beginTransaction().add(R.id.obfuscated_res_0x7f0906d2, this.mCurrentFragment, fragmentTag).commitAllowingStateLoss();
            }
        }
    }

    private String getFragmentTag(bs7 bs7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, this, bs7Var)) == null) ? (bs7Var == null || !bs7Var.r0()) ? PB_FRAGMENT_TAG : VIDEO_PB_FRAGMENT_TAG : (String) invokeL.objValue;
    }

    private void initData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, bundle) == null) {
            this.mVideoPbViewModel.a(this.mPbModel);
            yv7.b().p(this.mPbModel.f0(), this.mPbModel.C0());
            registerListener(new b(this, 2004003));
            if (!this.mPbModel.W1()) {
                this.mPbModel.S1();
            }
            if (this.mPbModel.E1()) {
                bs7 d0 = this.mPbModel.d0(ld6.a());
                if (d0 != null) {
                    if (this.mPbModel.T0() != null) {
                        this.mPbModel.T0().K0(d0.O());
                    }
                    d0.y0(3);
                    if (findFragment() == null) {
                        this.mVideoPbViewModel.s(d0, 1);
                        if (this.mCurrentFragment == null) {
                            fillFragment(d0);
                        }
                    }
                }
                if (getImmersionVideoCommentSource() == 0) {
                    this.mVideoPbViewModel.v(false);
                } else {
                    showLoadingView(findViewById(R.id.obfuscated_res_0x7f0906d2), true);
                    this.mVideoPbViewModel.v(true);
                }
            } else {
                showLoadingView(findViewById(R.id.obfuscated_res_0x7f0906d2), true);
                this.mVideoPbViewModel.v(true);
            }
            if (oi.C() && !TbadkCoreApplication.getInst().syncHasFinish) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
            }
            requestFirstFloorFunAd();
            requestPBCommentFunAd();
        }
    }

    private void initPbModel(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, bundle) == null) {
            if (bundle != null) {
                this.mPbModel = new PbModel(this, bundle, this.onLoadPbDataCallback);
            } else {
                this.mPbModel = new PbModel(this, getIntent(), this.onLoadPbDataCallback);
            }
            setForceInterceptStimeStat(this.mPbModel.v1());
            this.mPbModel.D2(getShowFloorNum());
            this.mPbModel.r2(getImmersionVideoCommentSource());
        }
    }

    private void initViewModel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(this).get(VideoPbViewModel.class);
            this.mVideoPbViewModel = videoPbViewModel;
            videoPbViewModel.l(getIntent());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void isShowDeleteResumeEditorTips(View view2, m25 m25Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65552, this, view2, m25Var, str) == null) {
            new WriteTipBubbleController(getPageContext(), new c(this, view2, m25Var)).d(view2, getString(R.string.obfuscated_res_0x7f0f0cc6), str, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_PB_REPLY);
        }
    }

    private void requestFirstFloorFunAd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            boolean z = true;
            if (((TbadkCoreApplication.getCurrentAccountInfo() == null || TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() != 1) ? false : false) || !UbsABTestHelper.isPbPageBannerFunAdSdkTest()) {
                return;
            }
            Activity e2 = x8.f().e(0);
            if (this.loadListener == null) {
                this.loadListener = new d(this);
            }
            FunAdRecordHttpMessage.uploadRequestRecord("a005", null, this.mPbModel.T0().Q(), this.mPbModel.T0().m(), null);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("tid", this.mPbModel.T0().Q()).param("fid", this.mPbModel.T0().m()).param("obj_type", "a005").param("obj_param1", "1"));
            String d2 = ks6.e().d("pb_banner");
            es6 j = es6.j();
            if (e2 == null) {
                e2 = this;
            }
            j.q(e2, d2, this.loadListener, es6.b("pb", UbsABTestHelper.isPbPageBannerFunAdSdkTest() ? "1" : "0"));
        }
    }

    private void requestPBCommentFunAd() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65554, this) == null) && !ls6.f() && UbsABTestHelper.isPbCommentFunAdABTest()) {
            es6 j = es6.j();
            es6.g b2 = es6.b("pb", UbsABTestHelper.isPbPageBannerFunAdSdkTest() ? "1" : "0");
            PbModel pbModel = this.mPbModel;
            String Q = (pbModel == null || pbModel.T0() == null) ? "" : this.mPbModel.T0().Q();
            PbModel pbModel2 = this.mPbModel;
            j.F(this, "6051002523-210422477", b2, Q, (pbModel2 == null || pbModel2.T0() == null) ? "" : this.mPbModel.T0().m());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveSearchRecForumParams(bs7 bs7Var) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65555, this, bs7Var) == null) || bs7Var == null || bs7Var.l() == null || (intent = getIntent()) == null) {
            return;
        }
        vd8.d().g((Uri) intent.getParcelableExtra(IntentConfig.KEY_URI), bs7Var.l().getId());
    }

    public Fragment createFragment(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (VIDEO_PB_FRAGMENT_TAG.equals(str)) {
                return new VideoPbFragment();
            }
            return PbFragment.C5();
        }
        return (Fragment) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            this.touchInfoCollector.a(motionEvent);
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (getIntent().getParcelableExtra("video_origin_area") == null && !this.mIsFromSchema) {
                super.enterExitAnimation();
            } else {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            }
        }
    }

    public Fragment findFragment() {
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        cw7 cw7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ju7 ju7Var = this.mBackController;
            if (ju7Var != null && !ju7Var.b(this.mPbModel) && this.mIsFromSchema) {
                if (TbSingleton.getInstance().isNeedShowInterestGuide()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new InterestGuideActivityConfig(this)));
                } else {
                    sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
                }
            }
            if (!TbSingleton.getInstance().isNeedShowInterestGuide() && (cw7Var = this.mPbToHomeUpdateController) != null) {
                cw7Var.a(this.mPbModel);
            }
            Fragment findFragment = findFragment();
            if (findFragment instanceof jz7) {
                ((jz7) findFragment).finish();
            } else {
                super.finish();
            }
        }
    }

    public abstract int getContentViewId();

    public long getCreateTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.createTime : invokeV.longValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.repackage.v75
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "a005" : (String) invokeV.objValue;
    }

    @Override // com.repackage.ot7
    public kx7 getEventController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mEvent : (kx7) invokeV.objValue;
    }

    @Override // com.repackage.ot7
    public String getFromForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PbModel pbModel = this.mPbModel;
            if (pbModel != null) {
                return pbModel.s0();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean getGpuSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? TbadkCoreApplication.getInst().isGpuOpen() : invokeV.booleanValue;
    }

    public abstract int getImmersionVideoCommentSource();

    @Override // com.repackage.lt4
    public String getLatestRelatedFid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            PbModel pbModel = this.mPbModel;
            if (pbModel != null) {
                return pbModel.getForumId();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.lt4
    public String getLatestRelatedTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            PbModel pbModel = this.mPbModel;
            if (pbModel != null) {
                return pbModel.l1();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public y75 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            y75 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                PbModel pbModel = this.mPbModel;
                if (pbModel != null) {
                    if (pbModel.T0() != null) {
                        ThreadData O = this.mPbModel.T0().O();
                        pageStayDurationItem.u(O.getNid());
                        if (O.isNormalThreadType()) {
                            pageStayDurationItem.t = "1";
                        } else if (O.isVideoThreadType()) {
                            pageStayDurationItem.t = "2";
                        } else {
                            pageStayDurationItem.t = "3";
                        }
                    }
                    pageStayDurationItem.C(mg.g(this.mPbModel.l1(), 0L));
                    if (this.mPbModel.T0() != null && this.mPbModel.T0().O() != null) {
                        pageStayDurationItem.u(this.mPbModel.T0().O().getNid());
                        pageStayDurationItem.B(this.mPbModel.T0().O().getThreadType());
                    }
                }
                if (!ni.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    pageStayDurationItem.z(TbadkCoreApplication.getInst().getTaskId());
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                    pageStayDurationItem.q(TbadkCoreApplication.getInst().getAdAdSense().n);
                }
                Fragment findFragment = findFragment();
                if (findFragment instanceof PbFragment) {
                    int i = ((PbFragment) findFragment).p1;
                    if (i == 2) {
                        pageStayDurationItem.v("a002");
                    } else if (i == 1) {
                        pageStayDurationItem.v("a038");
                    } else if (i == 3) {
                        pageStayDurationItem.v("a006");
                    }
                }
                if (!StringUtils.isNull(this.mPbModel.mTopicId)) {
                    pageStayDurationItem.D(this.mPbModel.mTopicId);
                }
                if (!StringUtils.isNull(this.mPbModel.mTopicSubjectName)) {
                    pageStayDurationItem.E(this.mPbModel.mTopicSubjectName);
                }
            }
            return pageStayDurationItem;
        }
        return (y75) invokeV.objValue;
    }

    public PbModel getPbModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mPbModel : (PbModel) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    public View getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mRootView : (View) invokeV.objValue;
    }

    public abstract int getShowFloorNum();

    @NonNull
    public TiePlusEventController getTiePlusEventController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            uc5.b(this.tiePlusEventController);
            return this.tiePlusEventController;
        }
        return (TiePlusEventController) invokeV.objValue;
    }

    @Override // com.repackage.lh0
    @NonNull
    public mh0 getTouchInfoCollector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.touchInfoCollector : (mh0) invokeV.objValue;
    }

    @Override // com.repackage.ot7
    public int getUserIdentify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            PbModel pbModel = this.mPbModel;
            if (pbModel == null || pbModel.T0() == null) {
                return 0;
            }
            return this.mPbModel.T0().V();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mVoiceManager : (VoiceManager) invokeV.objValue;
    }

    @Override // com.repackage.ot7
    public boolean isHost(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            PbModel pbModel = this.mPbModel;
            return pbModel != null && pbModel.J1(str);
        }
        return invokeL.booleanValue;
    }

    public boolean isImage(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, view2)) == null) ? (view2 instanceof TbImageView) || (view2 instanceof TbMemeImageView) || (view2 instanceof GifView) : invokeL.booleanValue;
    }

    @Override // com.repackage.ot7
    public boolean isSimpleForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            PbModel pbModel = this.mPbModel;
            if (pbModel == null) {
                return false;
            }
            return pbModel.I1();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048603, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            Fragment findFragment = findFragment();
            if (findFragment != null) {
                findFragment.onActivityResult(i, i2, intent);
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onBackPressed();
            Fragment findFragment = findFragment();
            if (findFragment instanceof PbFragment) {
                ((PbFragment) findFragment).D5();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            Fragment findFragment = findFragment();
            if (findFragment instanceof BaseFragment) {
                ((BaseFragment) findFragment).onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int intExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, bundle) == null) {
            this.createTime = System.currentTimeMillis();
            initUniqueId();
            boolean z = true;
            if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !x8.f().h("MainTabActivity")) {
                this.mIsFromSchema = true;
            }
            if (this.mIsFromSchema) {
                setIsAddSwipeBackLayout(false);
            }
            initViewModel();
            initPbModel(bundle);
            super.onCreate(bundle);
            setContentView(getContentViewId());
            this.mRootView = findViewById(R.id.obfuscated_res_0x7f0906d2);
            adjustResizeForSoftInput();
            addGlobalLayoutListener();
            initData(bundle);
            VoiceManager voiceManager = new VoiceManager();
            this.mVoiceManager = voiceManager;
            voiceManager.onCreate(getPageContext());
            this.mBackController = new ju7(getPageContext());
            this.mPbToHomeUpdateController = new cw7(getPageContext());
            this.mNEGFeedBackManager = new sh5(getPageContext(), "client_pb_live");
            this.mUserBlockController = new bs8(getPageContext(), getUniqueId());
            if (this.tiePlusEventController == null) {
                if (getIntent() == null || ((intExtra = getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_VIDEO_PAGE_TYPE, 0)) != 1 && intExtra != 2 && intExtra != 3 && intExtra != 4 && intExtra != 5)) {
                    z = false;
                }
                if (z) {
                    this.tiePlusEventController = new TiePlusEventController(this, TiePlusStat.Locate.VIDEO_MIDDLE_COMMENT);
                } else {
                    this.tiePlusEventController = new TiePlusEventController(this, TiePlusStat.Locate.PB);
                }
            }
            getLifecycle().addObserver(this.tiePlusEventController);
            ty4.b(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            super.onDestroy();
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            sh5 sh5Var = this.mNEGFeedBackManager;
            if (sh5Var != null) {
                sh5Var.h();
            }
            bs8 bs8Var = this.mUserBlockController;
            if (bs8Var != null) {
                bs8Var.l();
            }
            TbPageExtraHelper.setPrePageKey(getCurrentPageKey());
            o55.i(new PrePageKeyEvent(getCurrentPageKey()));
            if (this.loadListener != null) {
                this.loadListener = null;
            }
            if (this.tiePlusEventController != null) {
                getLifecycle().removeObserver(this.tiePlusEventController);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048608, this, i, keyEvent)) == null) {
            Fragment findFragment = findFragment();
            if (findFragment instanceof PbFragment) {
                if (((PbFragment) findFragment).E5(i, keyEvent)) {
                    return true;
                }
            } else if ((findFragment instanceof AbsVideoPbFragment) && ((AbsVideoPbFragment) findFragment).S3(i, keyEvent)) {
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            super.onKeyboardVisibilityChanged(z);
            Fragment findFragment = findFragment();
            if (findFragment instanceof AbsVideoPbFragment) {
                ((AbsVideoPbFragment) findFragment).T3(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            super.onNetRefreshButtonClicked();
            if (this.mPbModel != null) {
                this.mVideoPbViewModel.v(true);
                showLoadingView(this.mRootView);
                this.mPbModel.S1();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            super.onPause();
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
            TiePlusEventController tiePlusEventController = this.tiePlusEventController;
            if (tiePlusEventController != null) {
                tiePlusEventController.onPause();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048612, this, i, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i, strArr, iArr);
            if (i == 0) {
                Fragment fragment = this.mCurrentFragment;
                if ((fragment instanceof PbFragment) && ((PbFragment) fragment).L4() != null) {
                    ((PbFragment) this.mCurrentFragment).L4().v0();
                    return;
                }
                Fragment fragment2 = this.mCurrentFragment;
                if (!(fragment2 instanceof AbsVideoPbFragment) || ((AbsVideoPbFragment) fragment2).e3() == null) {
                    return;
                }
                ((AbsVideoPbFragment) this.mCurrentFragment).e3().v0();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.onResume();
            if (this.mPbModel != null) {
                yv7.b().p(this.mPbModel.f0(), this.mPbModel.C0());
            }
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            TiePlusEventController tiePlusEventController = this.tiePlusEventController;
            if (tiePlusEventController != null) {
                tiePlusEventController.onResume();
            }
            Fragment fragment = this.mCurrentFragment;
            if (fragment instanceof BaseFragment) {
                ((BaseFragment) fragment).setPrimary(true);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            PbModel pbModel = this.mPbModel;
            if (pbModel != null) {
                pbModel.m2(bundle);
            }
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onScreenShot(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            super.onScreenShot(str);
            PbModel pbModel = this.mPbModel;
            if (pbModel == null || pbModel.T0() == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_SCREEN_SHOT);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", this.mPbModel.l1());
            statisticItem.param("fid", this.mPbModel.T0().m());
            statisticItem.param("obj_type", 3);
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            super.onStop();
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            Fragment fragment = this.mCurrentFragment;
            if (fragment instanceof BaseFragment) {
                ((BaseFragment) fragment).setPrimary(false);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            super.onWindowFocusChanged(z);
            Fragment fragment = this.mCurrentFragment;
            if (fragment instanceof AbsVideoPbFragment) {
                ((AbsVideoPbFragment) fragment).W3(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean shouldChangeStatusBarIconAndTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? !(this.mCurrentFragment instanceof AbsVideoPbFragment) : invokeV.booleanValue;
    }

    public void showBlockDialog(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, str) == null) || str == null || this.mUserBlockController == null) {
            return;
        }
        this.mUserBlockController.n(mg.g(str, 0L));
    }

    public void stopVoice() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048621, this) == null) || (voiceManager = this.mVoiceManager) == null) {
            return;
        }
        voiceManager.stopPlay();
    }

    public void superCloseActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            super.finish();
        }
    }
}
