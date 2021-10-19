package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.q0.d1.c0;
import c.a.q0.j0.h;
import c.a.q0.s.q.d2;
import c.a.r0.k2.k.e.k0;
import c.a.r0.k2.k.e.o0;
import c.a.r0.y0.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.InterestGuideActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.PbCommentFloatActivityConfig;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.dialog.WriteTipBubbleController;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.mutiprocess.prePageKey.PrePageKeyEvent;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public abstract class AbsPbActivity extends BaseFragmentActivity implements c.a.r0.k2.k.a<PbActivity>, VoiceManager.j {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PB_FRAGMENT_TAG = "pb_fragment_tag";
    public static final String VIDEO_PB_FRAGMENT_TAG = "video_pb_fragment_tag";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasRemindedEditorTips;
    public a.h loadListener;
    public c.a.r0.k2.k.e.a mBackController;
    public Fragment mCurrentFragment;
    public final c.a.r0.k2.k.e.c1.a mEvent;
    public boolean mIsFromSchema;
    public boolean mIsHasCache;
    public c.a.r0.j.a mNEGFeedBackManager;
    public PbModel mPbModel;
    public o0 mPbToHomeUpdateController;
    public final c.a.r0.k2.k.e.c1.c mPostShareController;
    public View mRootView;
    public c.a.r0.u3.b mUserBlockController;
    public VideoPbViewModel mVideoPbViewModel;
    public VoiceManager mVoiceManager;
    @Nullable
    public TiePlusEventController tiePlusEventController;

    /* loaded from: classes7.dex */
    public class a implements PbModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsPbActivity f54976a;

        /* renamed from: com.baidu.tieba.pb.pb.main.AbsPbActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC1792a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f54977e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f54978f;

            public RunnableC1792a(a aVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f54978f = aVar;
                this.f54977e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Fragment fragment = this.f54978f.f54976a.mCurrentFragment;
                    if ((fragment instanceof PbFragment) && ((PbFragment) fragment).getPbView() != null && ((PbFragment) this.f54978f.f54976a.mCurrentFragment).getPbView().q0() != null) {
                        AbsPbActivity absPbActivity = this.f54978f.f54976a;
                        absPbActivity.isShowDeleteResumeEditorTips(((PbFragment) absPbActivity.mCurrentFragment).getPbView().q0(), ((PbFragment) this.f54978f.f54976a.mCurrentFragment).getPbEditor(), this.f54977e);
                        this.f54978f.f54976a.hasRemindedEditorTips = true;
                        return;
                    }
                    Fragment fragment2 = this.f54978f.f54976a.mCurrentFragment;
                    if (!(fragment2 instanceof AbsVideoPbFragment) || ((AbsVideoPbFragment) fragment2).getCommentReplyLayout() == null) {
                        return;
                    }
                    AbsPbActivity absPbActivity2 = this.f54978f.f54976a;
                    absPbActivity2.isShowDeleteResumeEditorTips(((AbsVideoPbFragment) absPbActivity2.mCurrentFragment).getCommentReplyLayout(), ((AbsVideoPbFragment) this.f54978f.f54976a.mCurrentFragment).getPbEditor(), this.f54977e);
                    this.f54978f.f54976a.hasRemindedEditorTips = true;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54976a = absPbActivity;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void a(int i2, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), responsedMessage, Boolean.valueOf(z2), Long.valueOf(j2)}) == null) {
                Fragment findFragment = this.f54976a.findFragment();
                if (findFragment instanceof c.a.r0.k2.o.b) {
                    c.a.r0.k2.o.b bVar = (c.a.r0.k2.o.b) findFragment;
                    if (bVar.getPbFragmentDataCallback() != null) {
                        bVar.getPbFragmentDataCallback().a(i2, z, responsedMessage, z2, j2);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void b(c.a.r0.k2.h.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
                Fragment findFragment = this.f54976a.findFragment();
                if (findFragment instanceof c.a.r0.k2.o.b) {
                    c.a.r0.k2.o.b bVar = (c.a.r0.k2.o.b) findFragment;
                    if (bVar.getPbFragmentDataCallback() != null) {
                        bVar.getPbFragmentDataCallback().b(eVar);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void c(boolean z, int i2, int i3, int i4, c.a.r0.k2.h.e eVar, String str, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eVar, str, Integer.valueOf(i5)}) == null) {
                this.f54976a.mVideoPbViewModel.setIsLoading(false);
                AbsPbActivity absPbActivity = this.f54976a;
                absPbActivity.hideLoadingView(absPbActivity.mRootView);
                if (z) {
                    if (eVar != null) {
                        AbsPbActivity absPbActivity2 = this.f54976a;
                        absPbActivity2.hideNetRefreshView(absPbActivity2.mRootView);
                    }
                } else if (!this.f54976a.mIsHasCache && !this.f54976a.mPbModel.t1()) {
                    AbsPbActivity absPbActivity3 = this.f54976a;
                    absPbActivity3.showNetRefreshView(absPbActivity3.mRootView, this.f54976a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i2)), null, null, true, this.f54976a.getNetRefreshListener());
                    AbsPbActivity absPbActivity4 = this.f54976a;
                    absPbActivity4.setNetRefreshViewEmotionMarginTop(l.g(absPbActivity4.getActivity(), R.dimen.ds360));
                }
                Fragment findFragment = this.f54976a.findFragment();
                if (findFragment == null) {
                    if (z) {
                        this.f54976a.mVideoPbViewModel.saveFirstLoadData(eVar, 3);
                        PbModel pbModel = this.f54976a.mPbModel;
                        if (pbModel != null) {
                            pbModel.cancelLoadData();
                            this.f54976a.mPbModel.x2(eVar);
                        }
                        AbsPbActivity absPbActivity5 = this.f54976a;
                        if (absPbActivity5.mCurrentFragment == null) {
                            absPbActivity5.fillFragment(eVar);
                        }
                    }
                } else if (findFragment instanceof c.a.r0.k2.o.b) {
                    c.a.r0.k2.o.b bVar = (c.a.r0.k2.o.b) findFragment;
                    if (bVar.getPbFragmentDataCallback() != null) {
                        bVar.getPbFragmentDataCallback().c(z, i2, i3, i4, eVar, str, i5);
                    }
                }
                String stringExtra = this.f54976a.getIntent().getStringExtra("key_open_editor_tips");
                if (TextUtils.isEmpty(stringExtra) || this.f54976a.hasRemindedEditorTips) {
                    return;
                }
                c.a.e.e.m.e.a().postDelayed(new RunnableC1792a(this, stringExtra), 100L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsPbActivity f54979a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AbsPbActivity absPbActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absPbActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54979a = absPbActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getOrginalMessage().getTag() == this.f54979a.getUniqueId()) {
                PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage;
                c.a.r0.k2.h.e pbData = pbPageReadLocalResponseMessage.getPbData();
                if (pbData == null) {
                    this.f54979a.mIsHasCache = false;
                    return;
                }
                d2 O = pbData.O();
                if (O != null) {
                    this.f54979a.mPbModel.b0(O);
                }
                this.f54979a.mIsHasCache = true;
                this.f54979a.mVideoPbViewModel.setIsLoading(false);
                Fragment findFragment = this.f54979a.findFragment();
                if (findFragment == null) {
                    this.f54979a.mVideoPbViewModel.saveFirstLoadData(pbData, 2);
                    AbsPbActivity absPbActivity = this.f54979a;
                    if (absPbActivity.mCurrentFragment == null) {
                        absPbActivity.fillFragment(pbData);
                    }
                } else if (findFragment instanceof PbFragment) {
                    this.f54979a.mPbModel.K1(pbData, pbPageReadLocalResponseMessage.getUpdateType(), pbPageReadLocalResponseMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements WriteTipBubbleController.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f54980a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.x.x.e f54981b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AbsPbActivity f54982c;

        public c(AbsPbActivity absPbActivity, View view, c.a.q0.x.x.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absPbActivity, view, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54982c = absPbActivity;
            this.f54980a = view;
            this.f54981b = eVar;
        }

        @Override // com.baidu.tbadk.core.dialog.WriteTipBubbleController.b
        public void a(View view, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, str) == null) {
                this.f54980a.performClick();
                this.f54981b.l();
                this.f54981b.w().i().setText(str);
                Editable text = this.f54981b.w().i().getText();
                if (TextUtils.isEmpty(text)) {
                    return;
                }
                this.f54981b.w().i().setSelection(text.length());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements a.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsPbActivity f54983a;

        public d(AbsPbActivity absPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54983a = absPbActivity;
        }

        @Override // c.a.r0.y0.a.h
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                Fragment fragment = this.f54983a.mCurrentFragment;
                if (fragment instanceof PbFragment) {
                    PbFragment pbFragment = (PbFragment) fragment;
                    if (pbFragment.getPbView() != null && pbFragment.getPbView().p0() != null) {
                        pbFragment.getPbView().p0().v0();
                    }
                }
                FunAdRecordHttpMessage.uploadRequestRecord("a005", "0", this.f54983a.mPbModel.P0().Q(), this.f54983a.mPbModel.P0().n(), null);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a005").param("obj_locate", 0).param(TiebaStatic.Params.RESOURCE_ID, i2).param("obj_param1", "1"));
            }
        }

        @Override // c.a.r0.y0.a.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                FunAdRecordHttpMessage.uploadRequestRecord("a005", "1", this.f54983a.mPbModel.P0().Q(), this.f54983a.mPbModel.P0().n(), "0");
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a005").param("obj_locate", 1).param(TiebaStatic.Params.RESOURCE_ID, 0).param("obj_param1", "1"));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<String> f54984a;

        /* renamed from: b  reason: collision with root package name */
        public ConcurrentHashMap<String, ImageUrlData> f54985b;

        /* renamed from: c  reason: collision with root package name */
        public String f54986c;

        /* renamed from: d  reason: collision with root package name */
        public String f54987d;

        /* renamed from: e  reason: collision with root package name */
        public String f54988e;

        /* renamed from: f  reason: collision with root package name */
        public String f54989f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f54990g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f54991h;

        /* renamed from: i  reason: collision with root package name */
        public String f54992i;

        /* renamed from: j  reason: collision with root package name */
        public int f54993j;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54986c = null;
            this.f54987d = null;
            this.f54988e = null;
            this.f54989f = null;
            this.f54990g = false;
            this.f54992i = "";
            this.f54993j = 0;
        }
    }

    public AbsPbActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mEvent = new c.a.r0.k2.k.e.c1.a(this);
        this.mPostShareController = new c.a.r0.k2.k.e.c1.c(getPageContext());
        this.mIsFromSchema = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fillFragment(c.a.r0.k2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, eVar) == null) {
            String fragmentTag = getFragmentTag(eVar);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            if (supportFragmentManager.findFragmentByTag(fragmentTag) == null) {
                this.mCurrentFragment = createFragment(fragmentTag);
                supportFragmentManager.beginTransaction().add(R.id.container, this.mCurrentFragment, fragmentTag).commitAllowingStateLoss();
            }
        }
    }

    private String getFragmentTag(c.a.r0.k2.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, this, eVar)) == null) ? (eVar == null || !eVar.q0()) ? PB_FRAGMENT_TAG : VIDEO_PB_FRAGMENT_TAG : (String) invokeL.objValue;
    }

    private void initData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, bundle) == null) {
            this.mVideoPbViewModel.bindPbModel(this.mPbModel);
            k0.b().p(this.mPbModel.d0(), this.mPbModel.z0());
            this.mPbModel.h2(new a(this));
            registerListener(new b(this, 2004003));
            this.mPbModel.G1();
            if (this.mPbModel.t1()) {
                c.a.r0.k2.h.e a0 = this.mPbModel.a0(c.a.r0.x0.l.a());
                if (a0 != null) {
                    if (this.mPbModel.P0() != null) {
                        this.mPbModel.P0().I0(a0.O());
                    }
                    a0.w0(3);
                    if (findFragment() == null) {
                        this.mVideoPbViewModel.saveFirstLoadData(a0, 1);
                        if (this.mCurrentFragment == null) {
                            fillFragment(a0);
                        }
                    }
                }
                if (getImmersionVideoCommentSource() == 0) {
                    this.mVideoPbViewModel.setIsLoading(false);
                } else {
                    showLoadingView(findViewById(R.id.container), true);
                    this.mVideoPbViewModel.setIsLoading(true);
                }
            } else {
                showLoadingView(findViewById(R.id.container), true);
                this.mVideoPbViewModel.setIsLoading(true);
            }
            if (l.D() && !TbadkCoreApplication.getInst().syncHasFinish) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
            }
            requestFirstFloorFunAd();
            requestPBCommentFunAd();
        }
    }

    private void initPbModel(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, bundle) == null) {
            PbModel pbModel = new PbModel(this);
            this.mPbModel = pbModel;
            if (bundle != null) {
                pbModel.initWithBundle(bundle);
            } else {
                this.mPbModel.initWithIntent(getIntent());
            }
            setForceInterceptStimeStat(this.mPbModel.o1());
            this.mPbModel.m2(getShowFloorNum());
            this.mPbModel.c2(getImmersionVideoCommentSource());
        }
    }

    private void initViewModel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(this).get(VideoPbViewModel.class);
            this.mVideoPbViewModel = videoPbViewModel;
            videoPbViewModel.init(getIntent());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void isShowDeleteResumeEditorTips(View view, c.a.q0.x.x.e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, this, view, eVar, str) == null) {
            new WriteTipBubbleController(getPageContext(), new c(this, view, eVar)).d(view, getString(R.string.open_editor_tips), str, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_PB_REPLY);
        }
    }

    private void requestFirstFloorFunAd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            boolean z = true;
            if (((TbadkCoreApplication.getCurrentAccountInfo() == null || TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() != 1) ? false : false) || !c.a.q0.b.d.H()) {
                return;
            }
            Activity f2 = c.a.e.a.b.g().f(0);
            if (this.loadListener == null) {
                this.loadListener = new d(this);
            }
            FunAdRecordHttpMessage.uploadRequestRecord("a005", null, this.mPbModel.P0().Q(), this.mPbModel.P0().n(), null);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("tid", this.mPbModel.P0().Q()).param("fid", this.mPbModel.P0().n()).param("obj_type", "a005").param("obj_param1", "1"));
            String d2 = c.a.r0.y0.e.c.e().d("pb_banner");
            c.a.r0.y0.a i2 = c.a.r0.y0.a.i();
            if (f2 == null) {
                f2 = this;
            }
            i2.o(f2, d2, this.loadListener, c.a.r0.y0.a.b("pb", c.a.q0.b.d.H() ? "1" : "0"));
        }
    }

    private void requestPBCommentFunAd() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65553, this) == null) && !c.a.r0.z0.a.f() && c.a.q0.b.d.G()) {
            c.a.r0.y0.a i2 = c.a.r0.y0.a.i();
            a.g b2 = c.a.r0.y0.a.b("pb", c.a.q0.b.d.H() ? "1" : "0");
            PbModel pbModel = this.mPbModel;
            String Q = (pbModel == null || pbModel.P0() == null) ? "" : this.mPbModel.P0().Q();
            PbModel pbModel2 = this.mPbModel;
            i2.D(this, "6051002523-210422477", b2, Q, (pbModel2 == null || pbModel2.P0() == null) ? "" : this.mPbModel.P0().n());
        }
    }

    public Fragment createFragment(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (VIDEO_PB_FRAGMENT_TAG.equals(str)) {
                return new VideoPbFragment();
            }
            return PbFragment.newInstance();
        }
        return (Fragment) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
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
        o0 o0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.r0.k2.k.e.a aVar = this.mBackController;
            if (aVar != null && !aVar.b(this.mPbModel) && this.mIsFromSchema) {
                if (TbSingleton.getInstance().isNeedShowInterestGuide()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new InterestGuideActivityConfig(this)));
                } else {
                    sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
                }
            }
            if (!TbSingleton.getInstance().isNeedShowInterestGuide() && (o0Var = this.mPbToHomeUpdateController) != null) {
                o0Var.a(this.mPbModel);
            }
            Fragment findFragment = findFragment();
            if (findFragment instanceof c.a.r0.k2.o.b) {
                ((c.a.r0.k2.o.b) findFragment).finish();
            } else {
                super.finish();
            }
        }
    }

    public abstract int getContentViewId();

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, c.a.q0.o0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "a005" : (String) invokeV.objValue;
    }

    @Override // c.a.r0.k2.k.a
    public c.a.r0.k2.k.e.c1.a getEventController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mEvent : (c.a.r0.k2.k.e.c1.a) invokeV.objValue;
    }

    @Override // c.a.r0.k2.k.a
    public String getFromForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            PbModel pbModel = this.mPbModel;
            if (pbModel != null) {
                return pbModel.q0();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean getGpuSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? TbadkCoreApplication.getInst().isGpuOpen() : invokeV.booleanValue;
    }

    public abstract int getImmersionVideoCommentSource();

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public c.a.q0.o0.d getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            c.a.q0.o0.d pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                PbModel pbModel = this.mPbModel;
                if (pbModel != null) {
                    if (pbModel.P0() != null) {
                        d2 O = this.mPbModel.P0().O();
                        pageStayDurationItem.u(O.F0());
                        if (O.o2()) {
                            pageStayDurationItem.t = "1";
                        } else if (O.E2()) {
                            pageStayDurationItem.t = "2";
                        } else {
                            pageStayDurationItem.t = "3";
                        }
                    }
                    pageStayDurationItem.C(c.a.e.e.m.b.g(this.mPbModel.f1(), 0L));
                    if (this.mPbModel.P0() != null && this.mPbModel.P0().O() != null) {
                        pageStayDurationItem.u(this.mPbModel.P0().O().F0());
                        pageStayDurationItem.B(this.mPbModel.P0().O().o1());
                    }
                }
                if (!k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    pageStayDurationItem.z(TbadkCoreApplication.getInst().getTaskId());
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                    pageStayDurationItem.q(TbadkCoreApplication.getInst().getAdAdSense().q);
                }
                Fragment findFragment = findFragment();
                if (findFragment instanceof PbFragment) {
                    int i2 = ((PbFragment) findFragment).bjhFrom;
                    if (i2 == 2) {
                        pageStayDurationItem.v("a002");
                    } else if (i2 == 1) {
                        pageStayDurationItem.v("a038");
                    } else if (i2 == 3) {
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
        return (c.a.q0.o0.d) invokeV.objValue;
    }

    public PbModel getPbModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mPbModel : (PbModel) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, voiceData$VoiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    public View getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mRootView : (View) invokeV.objValue;
    }

    public abstract int getShowFloorNum();

    @NonNull
    public TiePlusEventController getTiePlusEventController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            c0.b(this.tiePlusEventController);
            return this.tiePlusEventController;
        }
        return (TiePlusEventController) invokeV.objValue;
    }

    @Override // c.a.r0.k2.k.a
    public int getUserIdentify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            PbModel pbModel = this.mPbModel;
            if (pbModel == null || pbModel.P0() == null) {
                return 0;
            }
            return this.mPbModel.P0().V();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mVoiceManager : (VoiceManager) invokeV.objValue;
    }

    @Override // c.a.r0.k2.k.a
    public boolean isHost(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            PbModel pbModel = this.mPbModel;
            return pbModel != null && pbModel.y1(str);
        }
        return invokeL.booleanValue;
    }

    public boolean isImage(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, view)) == null) ? (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView) : invokeL.booleanValue;
    }

    @Override // c.a.r0.k2.k.a
    public boolean isSimpleForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            PbModel pbModel = this.mPbModel;
            if (pbModel == null) {
                return false;
            }
            return pbModel.x1();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048598, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            Fragment findFragment = findFragment();
            if (findFragment != null) {
                findFragment.onActivityResult(i2, i3, intent);
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onBackPressed();
            Fragment findFragment = findFragment();
            if (findFragment instanceof PbFragment) {
                ((PbFragment) findFragment).onBackPressed();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            Fragment findFragment = findFragment();
            if (findFragment instanceof BaseFragment) {
                ((BaseFragment) findFragment).onChangeSkinType(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int intExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bundle) == null) {
            initUniqueId();
            initPbModel(bundle);
            boolean z = true;
            if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !c.a.e.a.b.g().i("MainTabActivity")) {
                this.mIsFromSchema = true;
                int loadInt = TbadkSettings.getInst().loadInt("skin_", 0);
                if (loadInt != 1) {
                    SkinManager.setDayOrDarkSkinTypeWithSystemMode(false, true);
                } else {
                    TbadkCoreApplication.getInst().setSkinTypeValue(loadInt);
                    TbadkCoreApplication.getInst().SendSkinTypeBroadcast(loadInt);
                }
            }
            if (this.mIsFromSchema) {
                setIsAddSwipeBackLayout(false);
            }
            super.onCreate(bundle);
            setContentView(getContentViewId());
            this.mRootView = findViewById(R.id.container);
            adjustResizeForSoftInput();
            addGlobalLayoutListener();
            initViewModel();
            initData(bundle);
            VoiceManager voiceManager = new VoiceManager();
            this.mVoiceManager = voiceManager;
            voiceManager.onCreate(getPageContext());
            this.mBackController = new c.a.r0.k2.k.e.a(getPageContext());
            this.mPbToHomeUpdateController = new o0(getPageContext());
            this.mNEGFeedBackManager = new c.a.r0.j.a(getPageContext(), "client_pb_live");
            this.mUserBlockController = new c.a.r0.u3.b(getPageContext(), getUniqueId());
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
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onDestroy();
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            c.a.r0.j.a aVar = this.mNEGFeedBackManager;
            if (aVar != null) {
                aVar.h();
            }
            c.a.r0.u3.b bVar = this.mUserBlockController;
            if (bVar != null) {
                bVar.l();
            }
            TbPageExtraHelper.v(getCurrentPageKey());
            h.i(new PrePageKeyEvent(getCurrentPageKey()));
            if (this.loadListener != null) {
                this.loadListener = null;
            }
            if (this.tiePlusEventController != null) {
                getLifecycle().removeObserver(this.tiePlusEventController);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048603, this, i2, keyEvent)) == null) {
            Fragment findFragment = findFragment();
            if (findFragment instanceof PbFragment) {
                if (((PbFragment) findFragment).onKeyDown(i2, keyEvent)) {
                    return true;
                }
            } else if ((findFragment instanceof AbsVideoPbFragment) && ((AbsVideoPbFragment) findFragment).onKeyDown(i2, keyEvent)) {
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            super.onKeyboardVisibilityChanged(z);
            Fragment findFragment = findFragment();
            if (findFragment instanceof AbsVideoPbFragment) {
                ((AbsVideoPbFragment) findFragment).onKeyboardVisibilityChanged(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.onNetRefreshButtonClicked();
            if (this.mPbModel != null) {
                this.mVideoPbViewModel.setIsLoading(true);
                showLoadingView(this.mRootView);
                this.mPbModel.G1();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.onPause();
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048607, this, i2, strArr, iArr) == null) {
            if (i2 == 0) {
                Fragment fragment = this.mCurrentFragment;
                if ((fragment instanceof PbFragment) && ((PbFragment) fragment).getPbEditor() != null) {
                    ((PbFragment) this.mCurrentFragment).getPbEditor().x0();
                    return;
                }
                Fragment fragment2 = this.mCurrentFragment;
                if (!(fragment2 instanceof AbsVideoPbFragment) || ((AbsVideoPbFragment) fragment2).getPbEditor() == null) {
                    return;
                }
                ((AbsVideoPbFragment) this.mCurrentFragment).getPbEditor().x0();
                return;
            }
            super.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            super.onResume();
            if (this.mPbModel != null) {
                k0.b().p(this.mPbModel.d0(), this.mPbModel.z0());
            }
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
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
        if (interceptable == null || interceptable.invokeL(1048609, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            PbModel pbModel = this.mPbModel;
            if (pbModel != null) {
                pbModel.X1(bundle);
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
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            super.onScreenShot(str);
            PbModel pbModel = this.mPbModel;
            if (pbModel == null || pbModel.P0() == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_SCREEN_SHOT);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", this.mPbModel.f1());
            statisticItem.param("fid", this.mPbModel.P0().n());
            statisticItem.param("obj_type", 3);
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            super.onWindowFocusChanged(z);
            Fragment fragment = this.mCurrentFragment;
            if (fragment instanceof AbsVideoPbFragment) {
                ((AbsVideoPbFragment) fragment).onWindowFocusChanged(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean shouldChangeStatusBarIconAndTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? !(this.mCurrentFragment instanceof AbsVideoPbFragment) : invokeV.booleanValue;
    }

    public void showBlockDialog(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048615, this, str) == null) || str == null || this.mUserBlockController == null) {
            return;
        }
        this.mUserBlockController.n(c.a.e.e.m.b.g(str, 0L));
    }

    public void stopVoice() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || (voiceManager = this.mVoiceManager) == null) {
            return;
        }
        voiceManager.stopPlay();
    }

    public void superCloseActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            super.finish();
        }
    }
}
