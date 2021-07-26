package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.InterestGuideActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
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
import d.a.d.e.p.k;
import d.a.d.e.p.l;
import d.a.p0.h0.h;
import d.a.q0.h2.k.e.m0;
import d.a.q0.h2.k.e.p0;
import d.a.q0.v0.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public abstract class AbsPbActivity extends BaseFragmentActivity implements d.a.q0.h2.k.a<PbActivity>, VoiceManager.j {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PB_FRAGMENT_TAG = "pb_fragment_tag";
    public static final String VIDEO_PB_FRAGMENT_TAG = "video_pb_fragment_tag";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasRemindedEditorTips;
    public a.g loadListener;
    public d.a.q0.h2.k.e.c mBackController;
    public Fragment mCurrentFragment;
    public final d.a.q0.h2.k.e.d1.a mEvent;
    public boolean mIsFromSchema;
    public boolean mIsHasCache;
    public d.a.q0.h.a mNEGFeedBackManager;
    public PbModel mPbModel;
    public p0 mPbToHomeUpdateController;
    public final d.a.q0.h2.k.e.d1.c mPostShareController;
    public View mRootView;
    public d.a.q0.r3.b mUserBlockController;
    public VideoPbViewModel mVideoPbViewModel;
    public VoiceManager mVoiceManager;

    /* loaded from: classes4.dex */
    public class a implements PbModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsPbActivity f19253a;

        /* renamed from: com.baidu.tieba.pb.pb.main.AbsPbActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0230a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f19254e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f19255f;

            public RunnableC0230a(a aVar, String str) {
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
                this.f19255f = aVar;
                this.f19254e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Fragment fragment = this.f19255f.f19253a.mCurrentFragment;
                    if ((fragment instanceof PbFragment) && ((PbFragment) fragment).V4() != null && ((PbFragment) this.f19255f.f19253a.mCurrentFragment).V4().m0() != null) {
                        AbsPbActivity absPbActivity = this.f19255f.f19253a;
                        absPbActivity.isShowDeleteResumeEditorTips(((PbFragment) absPbActivity.mCurrentFragment).V4().m0(), ((PbFragment) this.f19255f.f19253a.mCurrentFragment).R4(), this.f19254e);
                        this.f19255f.f19253a.hasRemindedEditorTips = true;
                        return;
                    }
                    Fragment fragment2 = this.f19255f.f19253a.mCurrentFragment;
                    if (!(fragment2 instanceof AbsVideoPbFragment) || ((AbsVideoPbFragment) fragment2).Y2() == null) {
                        return;
                    }
                    AbsPbActivity absPbActivity2 = this.f19255f.f19253a;
                    absPbActivity2.isShowDeleteResumeEditorTips(((AbsVideoPbFragment) absPbActivity2.mCurrentFragment).Y2(), ((AbsVideoPbFragment) this.f19255f.f19253a.mCurrentFragment).n3(), this.f19254e);
                    this.f19255f.f19253a.hasRemindedEditorTips = true;
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
            this.f19253a = absPbActivity;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void a(int i2, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), responsedMessage, Boolean.valueOf(z2), Long.valueOf(j)}) == null) {
                Fragment findFragment = this.f19253a.findFragment();
                if (findFragment instanceof d.a.q0.h2.o.b) {
                    d.a.q0.h2.o.b bVar = (d.a.q0.h2.o.b) findFragment;
                    if (bVar.a0() != null) {
                        bVar.a0().a(i2, z, responsedMessage, z2, j);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void b(d.a.q0.h2.h.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
                Fragment findFragment = this.f19253a.findFragment();
                if (findFragment instanceof d.a.q0.h2.o.b) {
                    d.a.q0.h2.o.b bVar = (d.a.q0.h2.o.b) findFragment;
                    if (bVar.a0() != null) {
                        bVar.a0().b(eVar);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void c(boolean z, int i2, int i3, int i4, d.a.q0.h2.h.e eVar, String str, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eVar, str, Integer.valueOf(i5)}) == null) {
                this.f19253a.mVideoPbViewModel.u(false);
                AbsPbActivity absPbActivity = this.f19253a;
                absPbActivity.hideLoadingView(absPbActivity.mRootView);
                if (z) {
                    if (eVar != null) {
                        AbsPbActivity absPbActivity2 = this.f19253a;
                        absPbActivity2.hideNetRefreshView(absPbActivity2.mRootView);
                    }
                } else if (!this.f19253a.mIsHasCache && !this.f19253a.mPbModel.n1()) {
                    AbsPbActivity absPbActivity3 = this.f19253a;
                    absPbActivity3.showNetRefreshView(absPbActivity3.mRootView, this.f19253a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i2)), null, null, true, this.f19253a.getNetRefreshListener());
                    AbsPbActivity absPbActivity4 = this.f19253a;
                    absPbActivity4.setNetRefreshViewEmotionMarginTop(l.g(absPbActivity4.getActivity(), R.dimen.ds360));
                }
                Fragment findFragment = this.f19253a.findFragment();
                if (findFragment == null) {
                    if (z) {
                        this.f19253a.mVideoPbViewModel.r(eVar, 3);
                        AbsPbActivity absPbActivity5 = this.f19253a;
                        if (absPbActivity5.mCurrentFragment == null) {
                            absPbActivity5.fillFragment(eVar);
                        }
                    }
                } else if (findFragment instanceof d.a.q0.h2.o.b) {
                    d.a.q0.h2.o.b bVar = (d.a.q0.h2.o.b) findFragment;
                    if (bVar.a0() != null) {
                        bVar.a0().c(z, i2, i3, i4, eVar, str, i5);
                    }
                }
                String stringExtra = this.f19253a.getIntent().getStringExtra("key_open_editor_tips");
                if (TextUtils.isEmpty(stringExtra) || this.f19253a.hasRemindedEditorTips) {
                    return;
                }
                d.a.d.e.m.e.a().postDelayed(new RunnableC0230a(this, stringExtra), 100L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsPbActivity f19256a;

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
            this.f19256a = absPbActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getOrginalMessage().getTag() == this.f19256a.getUniqueId()) {
                PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage;
                d.a.q0.h2.h.e pbData = pbPageReadLocalResponseMessage.getPbData();
                if (pbData == null) {
                    this.f19256a.mIsHasCache = false;
                    return;
                }
                this.f19256a.mIsHasCache = true;
                this.f19256a.mVideoPbViewModel.u(false);
                Fragment findFragment = this.f19256a.findFragment();
                if (findFragment == null) {
                    this.f19256a.mVideoPbViewModel.r(pbData, 2);
                    AbsPbActivity absPbActivity = this.f19256a;
                    if (absPbActivity.mCurrentFragment == null) {
                        absPbActivity.fillFragment(pbData);
                    }
                } else if (findFragment instanceof PbFragment) {
                    this.f19256a.mPbModel.E1(pbData, pbPageReadLocalResponseMessage.getUpdateType(), pbPageReadLocalResponseMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements WriteTipBubbleController.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f19257a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.x.w.e f19258b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AbsPbActivity f19259c;

        public c(AbsPbActivity absPbActivity, View view, d.a.p0.x.w.e eVar) {
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
            this.f19259c = absPbActivity;
            this.f19257a = view;
            this.f19258b = eVar;
        }

        @Override // com.baidu.tbadk.core.dialog.WriteTipBubbleController.b
        public void a(View view, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, str) == null) {
                this.f19257a.performClick();
                this.f19258b.l();
                this.f19258b.w().i().setText(str);
                Editable text = this.f19258b.w().i().getText();
                if (TextUtils.isEmpty(text)) {
                    return;
                }
                this.f19258b.w().i().setSelection(text.length());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsPbActivity f19260a;

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
            this.f19260a = absPbActivity;
        }

        @Override // d.a.q0.v0.a.g
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                Fragment fragment = this.f19260a.mCurrentFragment;
                if (fragment instanceof PbFragment) {
                    PbFragment pbFragment = (PbFragment) fragment;
                    if (pbFragment.V4() != null && pbFragment.V4().l0() != null) {
                        pbFragment.V4().l0().t0();
                    }
                }
                FunAdRecordHttpMessage.uploadRequestRecord("a005", "0", this.f19260a.mPbModel.L0().P(), this.f19260a.mPbModel.L0().n(), null);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a005").param("obj_locate", 0).param(TiebaStatic.Params.RESOURCE_ID, i2));
            }
        }

        @Override // d.a.q0.v0.a.g
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                FunAdRecordHttpMessage.uploadRequestRecord("a005", "1", this.f19260a.mPbModel.L0().P(), this.f19260a.mPbModel.L0().n(), "0");
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a005").param("obj_locate", 1).param(TiebaStatic.Params.RESOURCE_ID, 0));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<String> f19261a;

        /* renamed from: b  reason: collision with root package name */
        public ConcurrentHashMap<String, ImageUrlData> f19262b;

        /* renamed from: c  reason: collision with root package name */
        public String f19263c;

        /* renamed from: d  reason: collision with root package name */
        public String f19264d;

        /* renamed from: e  reason: collision with root package name */
        public String f19265e;

        /* renamed from: f  reason: collision with root package name */
        public String f19266f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f19267g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f19268h;

        /* renamed from: i  reason: collision with root package name */
        public String f19269i;
        public int j;

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
            this.f19263c = null;
            this.f19264d = null;
            this.f19265e = null;
            this.f19266f = null;
            this.f19267g = false;
            this.f19269i = "";
            this.j = 0;
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
        this.mEvent = new d.a.q0.h2.k.e.d1.a(this);
        this.mPostShareController = new d.a.q0.h2.k.e.d1.c(getPageContext());
        this.mIsFromSchema = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fillFragment(d.a.q0.h2.h.e eVar) {
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

    private String getFragmentTag(d.a.q0.h2.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, this, eVar)) == null) ? (eVar == null || !eVar.l0()) ? PB_FRAGMENT_TAG : VIDEO_PB_FRAGMENT_TAG : (String) invokeL.objValue;
    }

    private void initData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, bundle) == null) {
            this.mVideoPbViewModel.a(this.mPbModel);
            m0.b().p(this.mPbModel.a0(), this.mPbModel.v0());
            this.mPbModel.a2(new a(this));
            registerListener(new b(this, 2004003));
            this.mPbModel.A1();
            if (this.mPbModel.n1()) {
                d.a.q0.h2.h.e Y = this.mPbModel.Y(d.a.q0.u0.l.a());
                if (Y != null) {
                    if (this.mPbModel.L0() != null) {
                        this.mPbModel.L0().C0(Y.N());
                    }
                    Y.q0(3);
                    if (findFragment() == null) {
                        this.mVideoPbViewModel.r(Y, 1);
                        if (this.mCurrentFragment == null) {
                            fillFragment(Y);
                        }
                    }
                }
                if (getImmersionVideoCommentSource() == 0) {
                    this.mVideoPbViewModel.u(false);
                } else {
                    showLoadingView(findViewById(R.id.container), true);
                    this.mVideoPbViewModel.u(true);
                }
            } else {
                showLoadingView(findViewById(R.id.container), true);
                this.mVideoPbViewModel.u(true);
            }
            if (l.D() && !TbadkCoreApplication.getInst().syncHasFinish) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
            }
            requestFunAd();
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
            this.mPbModel.f2(getShowFloorNum());
            this.mPbModel.W1(getImmersionVideoCommentSource());
        }
    }

    private void initViewModel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(this).get(VideoPbViewModel.class);
            this.mVideoPbViewModel = videoPbViewModel;
            videoPbViewModel.k(getIntent());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void isShowDeleteResumeEditorTips(View view, d.a.p0.x.w.e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, this, view, eVar, str) == null) {
            new WriteTipBubbleController(getPageContext(), new c(this, view, eVar)).d(view, getString(R.string.open_editor_tips), str, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_PB_REPLY);
        }
    }

    private void requestFunAd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            boolean z = true;
            if (((TbadkCoreApplication.getCurrentAccountInfo() == null || TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() != 1) ? false : false) || !d.a.p0.b.d.Q()) {
                return;
            }
            Activity e2 = d.a.d.a.b.f().e(0);
            if (this.loadListener == null) {
                this.loadListener = new d(this);
            }
            FunAdRecordHttpMessage.uploadRequestRecord("a005", null, this.mPbModel.L0().P(), this.mPbModel.L0().n(), null);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("tid", this.mPbModel.L0().P()).param("fid", this.mPbModel.L0().n()).param("obj_type", "a005"));
            String d2 = d.a.q0.v0.d.c.e().d("pb_banner");
            d.a.q0.v0.a i2 = d.a.q0.v0.a.i();
            if (e2 == null) {
                e2 = this;
            }
            i2.o(e2, d2, this.loadListener, d.a.q0.v0.a.b("pb", d.a.p0.b.d.Q() ? "1" : "0"));
        }
    }

    public Fragment createFragment(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (VIDEO_PB_FRAGMENT_TAG.equals(str)) {
                return new VideoPbFragment();
            }
            return PbFragment.E5();
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
        p0 p0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d.a.q0.h2.k.e.c cVar = this.mBackController;
            if (cVar != null && !cVar.b(this.mPbModel) && this.mIsFromSchema) {
                if (TbSingleton.getInstance().isNeedShowInterestGuide()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new InterestGuideActivityConfig(this)));
                } else {
                    sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
                }
            }
            if (!TbSingleton.getInstance().isNeedShowInterestGuide() && (p0Var = this.mPbToHomeUpdateController) != null) {
                p0Var.a(this.mPbModel);
            }
            Fragment findFragment = findFragment();
            if (findFragment instanceof d.a.q0.h2.o.b) {
                ((d.a.q0.h2.o.b) findFragment).finish();
            } else {
                super.finish();
            }
        }
    }

    public abstract int getContentViewId();

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, d.a.p0.m0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "a005" : (String) invokeV.objValue;
    }

    @Override // d.a.q0.h2.k.a
    public d.a.q0.h2.k.e.d1.a getEventController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mEvent : (d.a.q0.h2.k.e.d1.a) invokeV.objValue;
    }

    @Override // d.a.q0.h2.k.a
    public String getFromForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            PbModel pbModel = this.mPbModel;
            if (pbModel != null) {
                return pbModel.n0();
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
    public d.a.p0.m0.d getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            d.a.p0.m0.d pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                PbModel pbModel = this.mPbModel;
                if (pbModel != null) {
                    if (pbModel.L0() != null) {
                        pageStayDurationItem.q(d.a.d.e.m.b.f(this.mPbModel.L0().n(), 0L));
                    }
                    pageStayDurationItem.y(d.a.d.e.m.b.f(this.mPbModel.b1(), 0L));
                    if (this.mPbModel.L0() != null && this.mPbModel.L0().N() != null) {
                        pageStayDurationItem.r(this.mPbModel.L0().N().B0());
                    }
                }
                if (!k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    pageStayDurationItem.w(TbadkCoreApplication.getInst().getTaskId());
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                    pageStayDurationItem.n(TbadkCoreApplication.getInst().getAdAdSense().r);
                }
                Fragment findFragment = findFragment();
                if (findFragment instanceof PbFragment) {
                    int i2 = ((PbFragment) findFragment).n1;
                    if (i2 == 2) {
                        pageStayDurationItem.s("a002");
                    } else if (i2 == 1) {
                        pageStayDurationItem.s("a038");
                    } else if (i2 == 3) {
                        pageStayDurationItem.s("a006");
                    }
                }
            }
            return pageStayDurationItem;
        }
        return (d.a.p0.m0.d) invokeV.objValue;
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

    @Override // d.a.q0.h2.k.a
    public int getUserIdentify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            PbModel pbModel = this.mPbModel;
            if (pbModel == null || pbModel.L0() == null) {
                return 0;
            }
            return this.mPbModel.L0().U();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mVoiceManager : (VoiceManager) invokeV.objValue;
    }

    @Override // d.a.q0.h2.k.a
    public boolean isHost(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            PbModel pbModel = this.mPbModel;
            return pbModel != null && pbModel.s1(str);
        }
        return invokeL.booleanValue;
    }

    public boolean isImage(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, view)) == null) ? (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView) : invokeL.booleanValue;
    }

    @Override // d.a.q0.h2.k.a
    public boolean isSimpleForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            PbModel pbModel = this.mPbModel;
            if (pbModel == null) {
                return false;
            }
            return pbModel.r1();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048597, this, i2, i3, intent) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
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
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            Fragment findFragment = findFragment();
            if (findFragment instanceof BaseFragment) {
                ((BaseFragment) findFragment).onChangeSkinType(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bundle) == null) {
            initUniqueId();
            initPbModel(bundle);
            if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !d.a.d.a.b.f().h("MainTabActivity")) {
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
            this.mBackController = new d.a.q0.h2.k.e.c(getPageContext());
            this.mPbToHomeUpdateController = new p0(getPageContext());
            this.mNEGFeedBackManager = new d.a.q0.h.a(getPageContext(), "client_pb_live");
            this.mUserBlockController = new d.a.q0.r3.b(getPageContext(), getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onDestroy();
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            d.a.q0.h.a aVar = this.mNEGFeedBackManager;
            if (aVar != null) {
                aVar.h();
            }
            d.a.q0.r3.b bVar = this.mUserBlockController;
            if (bVar != null) {
                bVar.l();
            }
            TbPageExtraHelper.u(getCurrentPageKey());
            h.i(new PrePageKeyEvent(getCurrentPageKey()));
            if (this.loadListener != null) {
                this.loadListener = null;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048602, this, i2, keyEvent)) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            super.onKeyboardVisibilityChanged(z);
            Fragment findFragment = findFragment();
            if (findFragment instanceof AbsVideoPbFragment) {
                ((AbsVideoPbFragment) findFragment).Z3(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onNetRefreshButtonClicked();
            if (this.mPbModel != null) {
                this.mVideoPbViewModel.u(true);
                showLoadingView(this.mRootView);
                this.mPbModel.A1();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
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
        if (interceptable == null || interceptable.invokeILL(1048606, this, i2, strArr, iArr) == null) {
            if (i2 == 0) {
                Fragment fragment = this.mCurrentFragment;
                if ((fragment instanceof PbFragment) && ((PbFragment) fragment).R4() != null) {
                    ((PbFragment) this.mCurrentFragment).R4().w0();
                    return;
                }
                Fragment fragment2 = this.mCurrentFragment;
                if (!(fragment2 instanceof AbsVideoPbFragment) || ((AbsVideoPbFragment) fragment2).n3() == null) {
                    return;
                }
                ((AbsVideoPbFragment) this.mCurrentFragment).n3().w0();
                return;
            }
            super.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            super.onResume();
            if (this.mPbModel != null) {
                m0.b().p(this.mPbModel.a0(), this.mPbModel.v0());
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
        if (interceptable == null || interceptable.invokeL(1048608, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            PbModel pbModel = this.mPbModel;
            if (pbModel != null) {
                pbModel.R1(bundle);
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
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            super.onScreenShot(str);
            PbModel pbModel = this.mPbModel;
            if (pbModel == null || pbModel.L0() == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_SCREEN_SHOT);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", this.mPbModel.b1());
            statisticItem.param("fid", this.mPbModel.L0().n());
            statisticItem.param("obj_type", 3);
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            super.onWindowFocusChanged(z);
            Fragment fragment = this.mCurrentFragment;
            if (fragment instanceof AbsVideoPbFragment) {
                ((AbsVideoPbFragment) fragment).c4(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean shouldChangeStatusBarIconAndTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? !(this.mCurrentFragment instanceof AbsVideoPbFragment) : invokeV.booleanValue;
    }

    public void showBlockDialog(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048614, this, str) == null) || str == null || this.mUserBlockController == null) {
            return;
        }
        this.mUserBlockController.n(d.a.d.e.m.b.f(str, 0L));
    }

    public void stopVoice() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || (voiceManager = this.mVoiceManager) == null) {
            return;
        }
        voiceManager.stopPlay();
    }

    public void superCloseActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            super.finish();
        }
    }
}
