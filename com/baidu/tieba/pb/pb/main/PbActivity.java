package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.InterestGuideActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
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
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import d.b.b.e.p.k;
import d.b.b.e.p.l;
import d.b.h0.f0.g;
import d.b.i0.c2.k.e.k0;
import d.b.i0.c2.k.e.n0;
import d.b.i0.q0.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class PbActivity extends BaseFragmentActivity implements d.b.i0.c2.k.a<PbActivity>, VoiceManager.j {
    public static final String PB_FRAGMENT_TAG = "pb_fragment_tag";
    public static final String VIDEO_PB_FRAGMENT_TAG = "video_pb_fragment_tag";
    public boolean hasRemindedEditorTips;
    public a.d loadListener;
    public d.b.i0.c2.k.e.a mBackController;
    public Fragment mCurrentFragment;
    public boolean mIsHasCache;
    public d.b.i0.h.a mNEGFeedBackManager;
    public PbModel mPbModel;
    public n0 mPbToHomeUpdateController;
    public View mRootView;
    public d.b.i0.m3.b mUserBlockController;
    public VideoPbViewModel mVideoPbViewModel;
    public VoiceManager mVoiceManager;
    public final d.b.i0.c2.k.e.z0.a mEvent = new d.b.i0.c2.k.e.z0.a(this);
    public final d.b.i0.c2.k.e.z0.c mPostShareController = new d.b.i0.c2.k.e.z0.c(getPageContext());
    public boolean mIsFromSchema = false;

    /* loaded from: classes4.dex */
    public class a implements PbModel.g {

        /* renamed from: com.baidu.tieba.pb.pb.main.PbActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0214a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f19499e;

            public RunnableC0214a(String str) {
                this.f19499e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!(PbActivity.this.mCurrentFragment instanceof PbFragment) || ((PbFragment) PbActivity.this.mCurrentFragment).G4() == null || ((PbFragment) PbActivity.this.mCurrentFragment).G4().f0() == null) {
                    if (!(PbActivity.this.mCurrentFragment instanceof VideoPbFragment) || ((VideoPbFragment) PbActivity.this.mCurrentFragment).M2() == null) {
                        return;
                    }
                    PbActivity pbActivity = PbActivity.this;
                    pbActivity.isShowDeleteResumeEditorTips(((VideoPbFragment) pbActivity.mCurrentFragment).M2(), ((VideoPbFragment) PbActivity.this.mCurrentFragment).Z2(), this.f19499e);
                    PbActivity.this.hasRemindedEditorTips = true;
                    return;
                }
                PbActivity pbActivity2 = PbActivity.this;
                pbActivity2.isShowDeleteResumeEditorTips(((PbFragment) pbActivity2.mCurrentFragment).G4().f0(), ((PbFragment) PbActivity.this.mCurrentFragment).D4(), this.f19499e);
                PbActivity.this.hasRemindedEditorTips = true;
            }
        }

        public a() {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            Fragment findFragment = PbActivity.this.findFragment();
            if (findFragment instanceof d.b.i0.c2.o.b) {
                d.b.i0.c2.o.b bVar = (d.b.i0.c2.o.b) findFragment;
                if (bVar.r() != null) {
                    bVar.r().a(i, z, responsedMessage, z2, j);
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void b(d.b.i0.c2.h.e eVar) {
            Fragment findFragment = PbActivity.this.findFragment();
            if (findFragment instanceof d.b.i0.c2.o.b) {
                d.b.i0.c2.o.b bVar = (d.b.i0.c2.o.b) findFragment;
                if (bVar.r() != null) {
                    bVar.r().b(eVar);
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void c(boolean z, int i, int i2, int i3, d.b.i0.c2.h.e eVar, String str, int i4) {
            PbActivity.this.mVideoPbViewModel.u(false);
            PbActivity pbActivity = PbActivity.this;
            pbActivity.hideLoadingView(pbActivity.mRootView);
            if (z) {
                if (eVar != null) {
                    PbActivity pbActivity2 = PbActivity.this;
                    pbActivity2.hideNetRefreshView(pbActivity2.mRootView);
                }
            } else if (!PbActivity.this.mIsHasCache && !PbActivity.this.mPbModel.a1()) {
                PbActivity pbActivity3 = PbActivity.this;
                pbActivity3.showNetRefreshView(pbActivity3.mRootView, PbActivity.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                PbActivity pbActivity4 = PbActivity.this;
                pbActivity4.setNetRefreshViewEmotionMarginTop(l.g(pbActivity4.getActivity(), R.dimen.ds360));
            }
            Fragment findFragment = PbActivity.this.findFragment();
            if (findFragment == null) {
                if (z) {
                    PbActivity.this.mVideoPbViewModel.r(eVar, 3);
                    if (PbActivity.this.mCurrentFragment == null) {
                        PbActivity.this.fillFragment(eVar);
                    }
                }
            } else if (findFragment instanceof d.b.i0.c2.o.b) {
                d.b.i0.c2.o.b bVar = (d.b.i0.c2.o.b) findFragment;
                if (bVar.r() != null) {
                    bVar.r().c(z, i, i2, i3, eVar, str, i4);
                }
            }
            String stringExtra = PbActivity.this.getIntent().getStringExtra("key_open_editor_tips");
            if (TextUtils.isEmpty(stringExtra) || PbActivity.this.hasRemindedEditorTips) {
                return;
            }
            d.b.b.e.m.e.a().postDelayed(new RunnableC0214a(stringExtra), 100L);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getOrginalMessage().getTag() != PbActivity.this.getUniqueId()) {
                return;
            }
            PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage;
            d.b.i0.c2.h.e pbData = pbPageReadLocalResponseMessage.getPbData();
            if (pbData == null) {
                PbActivity.this.mIsHasCache = false;
                return;
            }
            PbActivity.this.mIsHasCache = true;
            PbActivity.this.mVideoPbViewModel.u(false);
            Fragment findFragment = PbActivity.this.findFragment();
            if (findFragment == null) {
                PbActivity.this.mVideoPbViewModel.r(pbData, 2);
                if (PbActivity.this.mCurrentFragment == null) {
                    PbActivity.this.fillFragment(pbData);
                }
            } else if (findFragment instanceof PbFragment) {
                PbActivity.this.mPbModel.r1(pbData, pbPageReadLocalResponseMessage.getUpdateType(), pbPageReadLocalResponseMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements WriteTipBubbleController.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f19502a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.w.w.e f19503b;

        public c(View view, d.b.h0.w.w.e eVar) {
            this.f19502a = view;
            this.f19503b = eVar;
        }

        @Override // com.baidu.tbadk.core.dialog.WriteTipBubbleController.b
        public void a(View view, String str) {
            this.f19502a.performClick();
            this.f19503b.l();
            this.f19503b.v().i().setText(str);
            Editable text = this.f19503b.v().i().getText();
            if (TextUtils.isEmpty(text)) {
                return;
            }
            this.f19503b.v().i().setSelection(text.length());
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.d {
        public d() {
        }

        @Override // d.b.i0.q0.a.d
        public void a(String str, int i) {
            if (PbActivity.this.mCurrentFragment instanceof PbFragment) {
                PbFragment pbFragment = (PbFragment) PbActivity.this.mCurrentFragment;
                if (pbFragment.G4() != null && pbFragment.G4().e0() != null) {
                    pbFragment.G4().e0().r0();
                }
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a005").param("obj_locate", 0).param(TiebaStatic.Params.RESOURCE_ID, i));
        }

        @Override // d.b.i0.q0.a.d
        public void onError(String str) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a005").param("obj_locate", 1).param(TiebaStatic.Params.RESOURCE_ID, 0));
        }
    }

    /* loaded from: classes4.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<String> f19506a;

        /* renamed from: b  reason: collision with root package name */
        public ConcurrentHashMap<String, ImageUrlData> f19507b;

        /* renamed from: h  reason: collision with root package name */
        public boolean f19513h;

        /* renamed from: c  reason: collision with root package name */
        public String f19508c = null;

        /* renamed from: d  reason: collision with root package name */
        public String f19509d = null;

        /* renamed from: e  reason: collision with root package name */
        public String f19510e = null;

        /* renamed from: f  reason: collision with root package name */
        public String f19511f = null;

        /* renamed from: g  reason: collision with root package name */
        public boolean f19512g = false;
        public String i = "";
        public int j = 0;
    }

    private Fragment createFragment(String str) {
        if (VIDEO_PB_FRAGMENT_TAG.equals(str)) {
            return VideoPbFragment.G3();
        }
        return PbFragment.o5();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fillFragment(d.b.i0.c2.h.e eVar) {
        String fragmentTag = getFragmentTag(eVar);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager.findFragmentByTag(fragmentTag) == null) {
            this.mCurrentFragment = createFragment(fragmentTag);
            supportFragmentManager.beginTransaction().add(R.id.container, this.mCurrentFragment, fragmentTag).commitAllowingStateLoss();
        }
    }

    private String getFragmentTag(d.b.i0.c2.h.e eVar) {
        return (eVar == null || !eVar.e0()) ? PB_FRAGMENT_TAG : VIDEO_PB_FRAGMENT_TAG;
    }

    private void initData(Bundle bundle) {
        this.mVideoPbViewModel.a(this.mPbModel);
        k0.b().p(this.mPbModel.N(), this.mPbModel.i0());
        this.mPbModel.M1(new a());
        registerListener(new b(2004003));
        this.mPbModel.n1();
        if (this.mPbModel.a1()) {
            d.b.i0.c2.h.e M = this.mPbModel.M(d.b.i0.p0.l.a());
            if (M != null) {
                if (this.mPbModel.y0() != null) {
                    this.mPbModel.y0().u0(M.L());
                }
                M.j0(3);
                if (findFragment() == null) {
                    this.mVideoPbViewModel.r(M, 1);
                    if (this.mCurrentFragment == null) {
                        fillFragment(M);
                    }
                }
            }
            this.mVideoPbViewModel.u(false);
        } else {
            showLoadingView(findViewById(R.id.container), true);
            this.mVideoPbViewModel.u(true);
        }
        if (l.C() && !TbadkCoreApplication.getInst().syncHasFinish) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
        }
        requestFunAd();
    }

    private void initPbModel(Bundle bundle) {
        PbModel pbModel = new PbModel(this);
        this.mPbModel = pbModel;
        if (bundle != null) {
            pbModel.initWithBundle(bundle);
            return;
        }
        this.mPbModel.initWithIntent(getIntent());
    }

    private void initViewModel() {
        VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(this).get(VideoPbViewModel.class);
        this.mVideoPbViewModel = videoPbViewModel;
        videoPbViewModel.k(getIntent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void isShowDeleteResumeEditorTips(View view, d.b.h0.w.w.e eVar, String str) {
        new WriteTipBubbleController(getPageContext(), new c(view, eVar)).d(view, getString(R.string.open_editor_tips), str, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_PB_REPLY);
    }

    private void requestFunAd() {
        boolean z = true;
        if (((TbadkCoreApplication.getCurrentAccountInfo() == null || TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() != 1) ? false : false) || !d.b.h0.b.d.A()) {
            return;
        }
        Activity e2 = d.b.b.a.b.f().e(0);
        if (this.loadListener == null) {
            this.loadListener = new d();
        }
        d.b.i0.q0.a h2 = d.b.i0.q0.a.h();
        if (e2 == null) {
            e2 = this;
        }
        h2.m(e2, "6051001775-457565154", this.loadListener, d.b.i0.q0.a.a("pb", d.b.h0.b.d.A() ? "1" : "0"));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        if (getIntent().getParcelableExtra(PbActivityConfig.VIDEO_ORIGIN_AREA) == null && !this.mIsFromSchema) {
            super.enterExitAnimation();
        } else {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    public Fragment findFragment() {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (ListUtils.isEmpty(fragments)) {
            return null;
        }
        return fragments.get(0);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        n0 n0Var;
        d.b.i0.c2.k.e.a aVar = this.mBackController;
        if (aVar != null && !aVar.b(this.mPbModel) && this.mIsFromSchema) {
            if (TbadkApplication.getInst().isNeedNewUserLead() && TbadkApplication.getInst().getIsFirstUse()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new InterestGuideActivityConfig(this)));
            } else {
                sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
        }
        if ((!TbadkApplication.getInst().isNeedNewUserLead() || !TbadkApplication.getInst().getIsFirstUse()) && (n0Var = this.mPbToHomeUpdateController) != null) {
            n0Var.a(this.mPbModel);
        }
        Fragment findFragment = findFragment();
        if (findFragment instanceof d.b.i0.c2.o.b) {
            ((d.b.i0.c2.o.b) findFragment).finish();
        } else {
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, d.b.h0.k0.a
    public String getCurrentPageKey() {
        return "a005";
    }

    @Override // d.b.i0.c2.k.a
    public d.b.i0.c2.k.e.z0.a getEventController() {
        return this.mEvent;
    }

    @Override // d.b.i0.c2.k.a
    public String getFromForumName() {
        PbModel pbModel = this.mPbModel;
        if (pbModel != null) {
            return pbModel.a0();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        return 0L;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public d.b.h0.k0.d getPageStayDurationItem() {
        d.b.h0.k0.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            PbModel pbModel = this.mPbModel;
            if (pbModel != null) {
                if (pbModel.y0() != null) {
                    pageStayDurationItem.q(d.b.b.e.m.b.f(this.mPbModel.y0().m(), 0L));
                }
                pageStayDurationItem.y(d.b.b.e.m.b.f(this.mPbModel.O0(), 0L));
                if (this.mPbModel.y0() != null && this.mPbModel.y0().L() != null) {
                    pageStayDurationItem.r(this.mPbModel.y0().L().L0());
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
                int i = ((PbFragment) findFragment).l1;
                if (i == 2) {
                    pageStayDurationItem.s("a002");
                } else if (i == 1) {
                    pageStayDurationItem.s("a038");
                } else if (i == 3) {
                    pageStayDurationItem.s("a006");
                }
            }
        }
        return pageStayDurationItem;
    }

    public PbModel getPbModel() {
        return this.mPbModel;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        return null;
    }

    public View getRootView() {
        return this.mRootView;
    }

    @Override // d.b.i0.c2.k.a
    public int getUserIdentify() {
        PbModel pbModel = this.mPbModel;
        if (pbModel == null || pbModel.y0() == null) {
            return 0;
        }
        return this.mPbModel.y0().R();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        return this.mVoiceManager;
    }

    @Override // d.b.i0.c2.k.a
    public boolean isHost(String str) {
        PbModel pbModel = this.mPbModel;
        return pbModel != null && pbModel.f1(str);
    }

    public boolean isImage(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    @Override // d.b.i0.c2.k.a
    public boolean isSimpleForum() {
        PbModel pbModel = this.mPbModel;
        if (pbModel == null) {
            return false;
        }
        return pbModel.e1();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Fragment findFragment = findFragment();
        if (findFragment != null) {
            findFragment.onActivityResult(i, i2, intent);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        Fragment findFragment = findFragment();
        if (findFragment instanceof PbFragment) {
            ((PbFragment) findFragment).onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Fragment findFragment = findFragment();
        if (findFragment instanceof BaseFragment) {
            ((BaseFragment) findFragment).onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        initUniqueId();
        initPbModel(bundle);
        if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !d.b.b.a.b.f().h("MainTabActivity")) {
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
        setContentView(R.layout.pb_layout);
        this.mRootView = findViewById(R.id.container);
        adjustResizeForSoftInput();
        addGlobalLayoutListener();
        initViewModel();
        initData(bundle);
        VoiceManager voiceManager = new VoiceManager();
        this.mVoiceManager = voiceManager;
        voiceManager.onCreate(getPageContext());
        this.mBackController = new d.b.i0.c2.k.e.a(getPageContext());
        this.mPbToHomeUpdateController = new n0(getPageContext());
        this.mNEGFeedBackManager = new d.b.i0.h.a(getPageContext(), "client_pb_live");
        this.mUserBlockController = new d.b.i0.m3.b(getPageContext(), getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        VoiceManager voiceManager = this.mVoiceManager;
        if (voiceManager != null) {
            voiceManager.onDestory(getPageContext());
        }
        d.b.i0.h.a aVar = this.mNEGFeedBackManager;
        if (aVar != null) {
            aVar.g();
        }
        d.b.i0.m3.b bVar = this.mUserBlockController;
        if (bVar != null) {
            bVar.l();
        }
        TbPageExtraHelper.u(getCurrentPageKey());
        g.g(new PrePageKeyEvent(getCurrentPageKey()));
        if (this.loadListener != null) {
            this.loadListener = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Fragment findFragment = findFragment();
        if (findFragment instanceof PbFragment) {
            if (((PbFragment) findFragment).onKeyDown(i, keyEvent)) {
                return true;
            }
        } else if ((findFragment instanceof VideoPbFragment) && ((VideoPbFragment) findFragment).onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        Fragment findFragment = findFragment();
        if (findFragment instanceof VideoPbFragment) {
            ((VideoPbFragment) findFragment).H3(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        if (this.mPbModel != null) {
            this.mVideoPbViewModel.u(true);
            showLoadingView(this.mRootView);
            this.mPbModel.n1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        VoiceManager voiceManager = this.mVoiceManager;
        if (voiceManager != null) {
            voiceManager.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i == 0) {
            Fragment fragment = this.mCurrentFragment;
            if ((fragment instanceof PbFragment) && ((PbFragment) fragment).D4() != null) {
                ((PbFragment) this.mCurrentFragment).D4().v0();
                return;
            }
            Fragment fragment2 = this.mCurrentFragment;
            if (!(fragment2 instanceof VideoPbFragment) || ((VideoPbFragment) fragment2).Z2() == null) {
                return;
            }
            ((VideoPbFragment) this.mCurrentFragment).Z2().v0();
            return;
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mPbModel != null) {
            k0.b().p(this.mPbModel.N(), this.mPbModel.i0());
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

    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        PbModel pbModel = this.mPbModel;
        if (pbModel != null) {
            pbModel.E1(bundle);
        }
        VoiceManager voiceManager = this.mVoiceManager;
        if (voiceManager != null) {
            voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onScreenShot(String str) {
        super.onScreenShot(str);
        PbModel pbModel = this.mPbModel;
        if (pbModel == null || pbModel.y0() == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_SCREEN_SHOT);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("tid", this.mPbModel.O0());
        statisticItem.param("fid", this.mPbModel.y0().m());
        statisticItem.param("obj_type", 3);
        TiebaStatic.log(statisticItem);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        VoiceManager voiceManager = this.mVoiceManager;
        if (voiceManager != null) {
            voiceManager.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
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

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        Fragment fragment = this.mCurrentFragment;
        if (fragment instanceof VideoPbFragment) {
            ((VideoPbFragment) fragment).K3(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean shouldChangeStatusBarIconAndTextColor() {
        return !(this.mCurrentFragment instanceof VideoPbFragment);
    }

    public void showBlockDialog(String str) {
        if (str == null || this.mUserBlockController == null) {
            return;
        }
        this.mUserBlockController.n(d.b.b.e.m.b.f(str, 0L));
    }

    public void stopVoice() {
        VoiceManager voiceManager = this.mVoiceManager;
        if (voiceManager != null) {
            voiceManager.stopPlay();
        }
    }

    public void superCloseActivity() {
        super.finish();
    }
}
