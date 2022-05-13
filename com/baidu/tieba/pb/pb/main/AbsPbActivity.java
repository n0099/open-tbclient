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
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b35;
import com.repackage.bs7;
import com.repackage.bw7;
import com.repackage.e65;
import com.repackage.er6;
import com.repackage.gz7;
import com.repackage.hx7;
import com.repackage.hz4;
import com.repackage.iu7;
import com.repackage.jx7;
import com.repackage.kg;
import com.repackage.kr6;
import com.repackage.lc8;
import com.repackage.li;
import com.repackage.li5;
import com.repackage.lr6;
import com.repackage.md5;
import com.repackage.mi;
import com.repackage.ng;
import com.repackage.oh0;
import com.repackage.ot7;
import com.repackage.p85;
import com.repackage.ph0;
import com.repackage.qc6;
import com.repackage.x8;
import com.repackage.xv7;
import com.repackage.yq8;
import com.repackage.yt4;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public abstract class AbsPbActivity extends BaseFragmentActivity implements ot7<PbActivity>, VoiceManager.j, yt4, oh0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PB_FRAGMENT_TAG = "pb_fragment_tag";
    public static final String VIDEO_PB_FRAGMENT_TAG = "video_pb_fragment_tag";
    public transient /* synthetic */ FieldHolder $fh;
    public long createTime;
    public boolean hasRemindedEditorTips;
    public er6.h loadListener;
    public iu7 mBackController;
    public Fragment mCurrentFragment;
    public final hx7 mEvent;
    public boolean mIsFromSchema;
    public boolean mIsHasCache;
    public boolean mIsPushLaunchAndNoMaintab;
    public li5 mNEGFeedBackManager;
    public PbModel mPbModel;
    public bw7 mPbToHomeUpdateController;
    public final jx7 mPostShareController;
    public View mRootView;
    public yq8 mUserBlockController;
    public VideoPbViewModel mVideoPbViewModel;
    public VoiceManager mVoiceManager;
    public PbModel.h onLoadPbDataCallback;
    @Nullable
    public TiePlusEventController tiePlusEventController;
    public final ph0 touchInfoCollector;

    /* loaded from: classes3.dex */
    public class a implements PbModel.h {
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
                    if ((fragment instanceof PbFragment) && ((PbFragment) fragment).Q4() != null && ((PbFragment) this.b.a.mCurrentFragment).Q4().x0() != null) {
                        AbsPbActivity absPbActivity = this.b.a;
                        absPbActivity.isShowDeleteResumeEditorTips(((PbFragment) absPbActivity.mCurrentFragment).Q4().x0(), ((PbFragment) this.b.a.mCurrentFragment).M4(), this.a);
                        this.b.a.hasRemindedEditorTips = true;
                        return;
                    }
                    Fragment fragment2 = this.b.a.mCurrentFragment;
                    if (!(fragment2 instanceof AbsVideoPbFragment) || ((AbsVideoPbFragment) fragment2).Q2() == null) {
                        return;
                    }
                    AbsPbActivity absPbActivity2 = this.b.a;
                    absPbActivity2.isShowDeleteResumeEditorTips(((AbsVideoPbFragment) absPbActivity2.mCurrentFragment).Q2(), ((AbsVideoPbFragment) this.b.a.mCurrentFragment).f3(), this.a);
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

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), responsedMessage, Boolean.valueOf(z2), Long.valueOf(j)}) == null) {
                Fragment findFragment = this.a.findFragment();
                if (findFragment instanceof gz7) {
                    gz7 gz7Var = (gz7) findFragment;
                    if (gz7Var.U() != null) {
                        gz7Var.U().a(i, z, responsedMessage, z2, j);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void b(bs7 bs7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bs7Var) == null) {
                Fragment findFragment = this.a.findFragment();
                if (findFragment instanceof gz7) {
                    gz7 gz7Var = (gz7) findFragment;
                    if (gz7Var.U() != null) {
                        gz7Var.U().b(bs7Var);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, bs7 bs7Var, String str, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), bs7Var, str, Integer.valueOf(i4)}) == null) {
                this.a.saveSearchRecForumParams(bs7Var);
                this.a.mVideoPbViewModel.y(this.a.mPbModel.F1());
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
                } else if (!this.a.mIsHasCache && !this.a.mPbModel.A2()) {
                    AbsPbActivity absPbActivity3 = this.a;
                    absPbActivity3.showNetRefreshView(absPbActivity3.mRootView, this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c2c, str, Integer.valueOf(i)), null, null, true, this.a.getNetRefreshListener());
                    AbsPbActivity absPbActivity4 = this.a;
                    absPbActivity4.setNetRefreshViewEmotionMarginTop(mi.f(absPbActivity4.getActivity(), R.dimen.obfuscated_res_0x7f0702ad));
                }
                Fragment findFragment = this.a.findFragment();
                if (findFragment == null) {
                    if (z) {
                        this.a.mVideoPbViewModel.s(bs7Var, 3);
                        PbModel pbModel = this.a.mPbModel;
                        if (pbModel != null) {
                            pbModel.cancelLoadData();
                            this.a.mPbModel.K3(bs7Var);
                        }
                        AbsPbActivity absPbActivity5 = this.a;
                        if (absPbActivity5.mCurrentFragment == null) {
                            absPbActivity5.fillFragment(bs7Var);
                        }
                    } else if (PbLoadingViewOptimizeSwitch.isSwitchOn()) {
                        AbsPbActivity absPbActivity6 = this.a;
                        absPbActivity6.hideLoadingView(absPbActivity6.mRootView);
                    }
                } else if (findFragment instanceof gz7) {
                    gz7 gz7Var = (gz7) findFragment;
                    if (gz7Var.U() != null) {
                        gz7Var.U().c(z, i, i2, i3, bs7Var, str, i4);
                    }
                }
                String stringExtra = this.a.getIntent().getStringExtra("key_open_editor_tips");
                if (TextUtils.isEmpty(stringExtra) || this.a.hasRemindedEditorTips) {
                    return;
                }
                ng.a().postDelayed(new RunnableC0222a(this, stringExtra), 100L);
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
                    return;
                }
                ThreadData O = pbData.O();
                if (O != null) {
                    this.a.mPbModel.a1(O);
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
                    this.a.mPbModel.U2(pbData, pbPageReadLocalResponseMessage.getUpdateType(), pbPageReadLocalResponseMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements WriteTipBubbleController.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ b35 b;
        public final /* synthetic */ AbsPbActivity c;

        public c(AbsPbActivity absPbActivity, View view2, b35 b35Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absPbActivity, view2, b35Var};
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
            this.b = b35Var;
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
    public class d implements er6.h {
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

        @Override // com.repackage.er6.h
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                Fragment fragment = this.a.mCurrentFragment;
                if (fragment instanceof PbFragment) {
                    PbFragment pbFragment = (PbFragment) fragment;
                    if (pbFragment.Q4() != null && pbFragment.Q4().w0() != null) {
                        pbFragment.Q4().w0().B0();
                    }
                }
                FunAdRecordHttpMessage.uploadRequestRecord("a005", "0", this.a.mPbModel.P1().Q(), this.a.mPbModel.P1().m(), null);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a005").param("obj_locate", 0).param(TiebaStatic.Params.RESOURCE_ID, i).param("obj_param1", "1"));
            }
        }

        @Override // com.repackage.er6.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                FunAdRecordHttpMessage.uploadRequestRecord("a005", "1", this.a.mPbModel.P1().Q(), this.a.mPbModel.P1().m(), "0");
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
        this.mEvent = new hx7(this);
        this.mPostShareController = new jx7(getPageContext());
        this.mIsFromSchema = false;
        this.mIsPushLaunchAndNoMaintab = false;
        this.touchInfoCollector = new ph0();
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
                supportFragmentManager.beginTransaction().add(R.id.obfuscated_res_0x7f0906cd, this.mCurrentFragment, fragmentTag).commitAllowingStateLoss();
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
            xv7.b().p(this.mPbModel.b1(), this.mPbModel.y1());
            registerListener(new b(this, 2004003));
            if (!this.mPbModel.S2()) {
                this.mPbModel.O2();
            }
            if (this.mPbModel.A2()) {
                bs7 Z0 = this.mPbModel.Z0(qc6.a());
                if (Z0 != null) {
                    if (this.mPbModel.P1() != null) {
                        this.mPbModel.P1().K0(Z0.O());
                    }
                    Z0.y0(3);
                    if (findFragment() == null) {
                        this.mVideoPbViewModel.s(Z0, 1);
                        if (this.mCurrentFragment == null) {
                            fillFragment(Z0);
                        }
                    }
                }
                if (getImmersionVideoCommentSource() == 0) {
                    this.mVideoPbViewModel.v(false);
                } else {
                    showLoadingView(findViewById(R.id.obfuscated_res_0x7f0906cd), true);
                    this.mVideoPbViewModel.v(true);
                }
            } else {
                showLoadingView(findViewById(R.id.obfuscated_res_0x7f0906cd), true);
                this.mVideoPbViewModel.v(true);
            }
            if (mi.C() && !TbadkCoreApplication.getInst().syncHasFinish) {
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
            setForceInterceptStimeStat(this.mPbModel.r2());
            this.mPbModel.z3(getShowFloorNum());
            this.mPbModel.n3(getImmersionVideoCommentSource());
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
    public void isShowDeleteResumeEditorTips(View view2, b35 b35Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65552, this, view2, b35Var, str) == null) {
            new WriteTipBubbleController(getPageContext(), new c(this, view2, b35Var)).d(view2, getString(R.string.obfuscated_res_0x7f0f0ce1), str, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_PB_REPLY);
        }
    }

    private void requestFirstFloorFunAd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            boolean z = true;
            if (((TbadkCoreApplication.getCurrentAccountInfo() == null || TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() != 1) ? false : false) || !UbsABTestHelper.isPbPageBannerFunAdSdkTest()) {
                return;
            }
            Activity f = x8.g().f(0);
            if (this.loadListener == null) {
                this.loadListener = new d(this);
            }
            FunAdRecordHttpMessage.uploadRequestRecord("a005", null, this.mPbModel.P1().Q(), this.mPbModel.P1().m(), null);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("tid", this.mPbModel.P1().Q()).param("fid", this.mPbModel.P1().m()).param("obj_type", "a005").param("obj_param1", "1"));
            String d2 = kr6.e().d("pb_banner");
            er6 j = er6.j();
            if (f == null) {
                f = this;
            }
            j.q(f, d2, this.loadListener, er6.b("pb", UbsABTestHelper.isPbPageBannerFunAdSdkTest() ? "1" : "0"));
        }
    }

    private void requestPBCommentFunAd() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65554, this) == null) && !lr6.f() && UbsABTestHelper.isPbCommentFunAdABTest()) {
            er6 j = er6.j();
            er6.g b2 = er6.b("pb", UbsABTestHelper.isPbPageBannerFunAdSdkTest() ? "1" : "0");
            PbModel pbModel = this.mPbModel;
            String Q = (pbModel == null || pbModel.P1() == null) ? "" : this.mPbModel.P1().Q();
            PbModel pbModel2 = this.mPbModel;
            j.F(this, "6051002523-210422477", b2, Q, (pbModel2 == null || pbModel2.P1() == null) ? "" : this.mPbModel.P1().m());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveSearchRecForumParams(bs7 bs7Var) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65555, this, bs7Var) == null) || bs7Var == null || bs7Var.l() == null || (intent = getIntent()) == null) {
            return;
        }
        lc8.d().g((Uri) intent.getParcelableExtra(IntentConfig.KEY_URI), bs7Var.l().getId());
    }

    public Fragment createFragment(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (VIDEO_PB_FRAGMENT_TAG.equals(str)) {
                return new VideoPbFragment();
            }
            return PbFragment.D5();
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
            if (getIntent().getParcelableExtra("video_origin_area") == null && !this.mIsFromSchema && !this.mIsPushLaunchAndNoMaintab) {
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
        bw7 bw7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!TbSingleton.getInstance().isNeedShowInterestGuide() && (bw7Var = this.mPbToHomeUpdateController) != null) {
                bw7Var.a(this.mPbModel);
            }
            Fragment findFragment = findFragment();
            if (findFragment instanceof gz7) {
                ((gz7) findFragment).finish();
            } else {
                super.finish();
            }
            iu7 iu7Var = this.mBackController;
            if (iu7Var == null || iu7Var.b(this.mPbModel)) {
                return;
            }
            if (this.mIsFromSchema || this.mIsPushLaunchAndNoMaintab) {
                if (TbSingleton.getInstance().isNeedShowInterestGuide()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new InterestGuideActivityConfig(this)));
                } else {
                    sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
                }
            }
        }
    }

    public abstract int getContentViewId();

    public long getCreateTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.createTime : invokeV.longValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.repackage.m85
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "a005" : (String) invokeV.objValue;
    }

    @Override // com.repackage.ot7
    public hx7 getEventController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mEvent : (hx7) invokeV.objValue;
    }

    @Override // com.repackage.ot7
    public String getFromForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PbModel pbModel = this.mPbModel;
            if (pbModel != null) {
                return pbModel.o1();
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

    @Override // com.repackage.yt4
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

    @Override // com.repackage.yt4
    public String getLatestRelatedTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            PbModel pbModel = this.mPbModel;
            if (pbModel != null) {
                return pbModel.h2();
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
    public p85 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            p85 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                PbModel pbModel = this.mPbModel;
                if (pbModel != null) {
                    if (pbModel.P1() != null) {
                        ThreadData O = this.mPbModel.P1().O();
                        pageStayDurationItem.u(O.getNid());
                        if (O.isNormalThreadType()) {
                            pageStayDurationItem.t = "1";
                        } else if (O.isVideoThreadType()) {
                            pageStayDurationItem.t = "2";
                        } else {
                            pageStayDurationItem.t = "3";
                        }
                    }
                    pageStayDurationItem.C(kg.g(this.mPbModel.h2(), 0L));
                    if (this.mPbModel.P1() != null && this.mPbModel.P1().O() != null) {
                        pageStayDurationItem.u(this.mPbModel.P1().O().getNid());
                        pageStayDurationItem.B(this.mPbModel.P1().O().getThreadType());
                    }
                }
                if (!li.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    pageStayDurationItem.z(TbadkCoreApplication.getInst().getTaskId());
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                    pageStayDurationItem.q(TbadkCoreApplication.getInst().getAdAdSense().k);
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
        return (p85) invokeV.objValue;
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
            md5.b(this.tiePlusEventController);
            return this.tiePlusEventController;
        }
        return (TiePlusEventController) invokeV.objValue;
    }

    @Override // com.repackage.oh0
    @NonNull
    public ph0 getTouchInfoCollector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.touchInfoCollector : (ph0) invokeV.objValue;
    }

    @Override // com.repackage.ot7
    public int getUserIdentify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            PbModel pbModel = this.mPbModel;
            if (pbModel == null || pbModel.P1() == null) {
                return 0;
            }
            return this.mPbModel.P1().V();
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
            return pbModel != null && pbModel.F2(str);
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
            return pbModel.E2();
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
                ((PbFragment) findFragment).E5();
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
            initViewModel();
            initPbModel(bundle);
            boolean z = true;
            if (!x8.g().i("MainTabActivity")) {
                if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null) {
                    this.mIsFromSchema = true;
                } else if (getPbModel().O1() == 7) {
                    this.mIsPushLaunchAndNoMaintab = true;
                }
            }
            if (this.mIsFromSchema || this.mIsPushLaunchAndNoMaintab) {
                setIsAddSwipeBackLayout(false);
            }
            super.onCreate(bundle);
            setContentView(getContentViewId());
            this.mRootView = findViewById(R.id.obfuscated_res_0x7f0906cd);
            adjustResizeForSoftInput();
            addGlobalLayoutListener();
            initData(bundle);
            VoiceManager voiceManager = new VoiceManager();
            this.mVoiceManager = voiceManager;
            voiceManager.onCreate(getPageContext());
            this.mBackController = new iu7(getPageContext());
            this.mPbToHomeUpdateController = new bw7(getPageContext());
            this.mNEGFeedBackManager = new li5(getPageContext(), "client_pb_live");
            this.mUserBlockController = new yq8(getPageContext(), getUniqueId());
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
            hz4.b(false);
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
            li5 li5Var = this.mNEGFeedBackManager;
            if (li5Var != null) {
                li5Var.h();
            }
            yq8 yq8Var = this.mUserBlockController;
            if (yq8Var != null) {
                yq8Var.l();
            }
            TbPageExtraHelper.setPrePageKey(getCurrentPageKey());
            e65.i(new PrePageKeyEvent(getCurrentPageKey()));
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
                if (((PbFragment) findFragment).F5(i, keyEvent)) {
                    return true;
                }
            } else if ((findFragment instanceof AbsVideoPbFragment) && ((AbsVideoPbFragment) findFragment).T3(i, keyEvent)) {
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
                ((AbsVideoPbFragment) findFragment).U3(z);
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
                this.mPbModel.O2();
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
            SpeedStatsManager.getInstance().setStatsFlag(-1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048612, this, i, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i, strArr, iArr);
            if (i == 0) {
                Fragment fragment = this.mCurrentFragment;
                if ((fragment instanceof PbFragment) && ((PbFragment) fragment).M4() != null) {
                    ((PbFragment) this.mCurrentFragment).M4().v0();
                    return;
                }
                Fragment fragment2 = this.mCurrentFragment;
                if (!(fragment2 instanceof AbsVideoPbFragment) || ((AbsVideoPbFragment) fragment2).f3() == null) {
                    return;
                }
                ((AbsVideoPbFragment) this.mCurrentFragment).f3().v0();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.onResume();
            if (this.mPbModel != null) {
                xv7.b().p(this.mPbModel.b1(), this.mPbModel.y1());
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
                pbModel.i3(bundle);
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
            if (pbModel == null || pbModel.P1() == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_SCREEN_SHOT);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", this.mPbModel.h2());
            statisticItem.param("fid", this.mPbModel.P1().m());
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
                ((AbsVideoPbFragment) fragment).X3(z);
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
        this.mUserBlockController.n(kg.g(str, 0L));
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
