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
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.i0.f0.h;
import d.a.j0.d2.k.e.m0;
import d.a.j0.d2.k.e.p0;
import d.a.j0.d2.o.i;
import d.a.j0.r0.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class PbActivity extends BaseFragmentActivity implements d.a.j0.d2.k.a<PbActivity>, VoiceManager.j {
    public static final String PB_FRAGMENT_TAG = "pb_fragment_tag";
    public static final String VIDEO_PB_FRAGMENT_TAG = "video_pb_fragment_tag";
    public boolean hasRemindedEditorTips;
    public a.e loadListener;
    public d.a.j0.d2.k.e.c mBackController;
    public Fragment mCurrentFragment;
    public boolean mIsHasCache;
    public d.a.j0.h.a mNEGFeedBackManager;
    public PbModel mPbModel;
    public p0 mPbToHomeUpdateController;
    public View mRootView;
    public d.a.j0.n3.b mUserBlockController;
    public VideoPbViewModel mVideoPbViewModel;
    public VoiceManager mVoiceManager;
    public final d.a.j0.d2.k.e.b1.a mEvent = new d.a.j0.d2.k.e.b1.a(this);
    public final d.a.j0.d2.k.e.b1.c mPostShareController = new d.a.j0.d2.k.e.b1.c(getPageContext());
    public boolean mIsFromSchema = false;

    /* loaded from: classes3.dex */
    public class a implements PbModel.g {

        /* renamed from: com.baidu.tieba.pb.pb.main.PbActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0215a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f19646e;

            public RunnableC0215a(String str) {
                this.f19646e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!(PbActivity.this.mCurrentFragment instanceof PbFragment) || ((PbFragment) PbActivity.this.mCurrentFragment).J4() == null || ((PbFragment) PbActivity.this.mCurrentFragment).J4().l0() == null) {
                    if (!(PbActivity.this.mCurrentFragment instanceof VideoPbFragment) || ((VideoPbFragment) PbActivity.this.mCurrentFragment).O2() == null) {
                        return;
                    }
                    PbActivity pbActivity = PbActivity.this;
                    pbActivity.isShowDeleteResumeEditorTips(((VideoPbFragment) pbActivity.mCurrentFragment).O2(), ((VideoPbFragment) PbActivity.this.mCurrentFragment).b3(), this.f19646e);
                    PbActivity.this.hasRemindedEditorTips = true;
                    return;
                }
                PbActivity pbActivity2 = PbActivity.this;
                pbActivity2.isShowDeleteResumeEditorTips(((PbFragment) pbActivity2.mCurrentFragment).J4().l0(), ((PbFragment) PbActivity.this.mCurrentFragment).G4(), this.f19646e);
                PbActivity.this.hasRemindedEditorTips = true;
            }
        }

        public a() {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void a(int i2, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            Fragment findFragment = PbActivity.this.findFragment();
            if (findFragment instanceof i) {
                i iVar = (i) findFragment;
                if (iVar.W() != null) {
                    iVar.W().a(i2, z, responsedMessage, z2, j);
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void b(d.a.j0.d2.h.e eVar) {
            Fragment findFragment = PbActivity.this.findFragment();
            if (findFragment instanceof i) {
                i iVar = (i) findFragment;
                if (iVar.W() != null) {
                    iVar.W().b(eVar);
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void c(boolean z, int i2, int i3, int i4, d.a.j0.d2.h.e eVar, String str, int i5) {
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
                pbActivity3.showNetRefreshView(pbActivity3.mRootView, PbActivity.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i2)), true);
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
            } else if (findFragment instanceof i) {
                i iVar = (i) findFragment;
                if (iVar.W() != null) {
                    iVar.W().c(z, i2, i3, i4, eVar, str, i5);
                }
            }
            String stringExtra = PbActivity.this.getIntent().getStringExtra("key_open_editor_tips");
            if (TextUtils.isEmpty(stringExtra) || PbActivity.this.hasRemindedEditorTips) {
                return;
            }
            d.a.c.e.m.e.a().postDelayed(new RunnableC0215a(stringExtra), 100L);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getOrginalMessage().getTag() != PbActivity.this.getUniqueId()) {
                return;
            }
            PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage;
            d.a.j0.d2.h.e pbData = pbPageReadLocalResponseMessage.getPbData();
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

    /* loaded from: classes3.dex */
    public class c implements WriteTipBubbleController.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f19649a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.w.w.e f19650b;

        public c(View view, d.a.i0.w.w.e eVar) {
            this.f19649a = view;
            this.f19650b = eVar;
        }

        @Override // com.baidu.tbadk.core.dialog.WriteTipBubbleController.b
        public void a(View view, String str) {
            this.f19649a.performClick();
            this.f19650b.l();
            this.f19650b.v().i().setText(str);
            Editable text = this.f19650b.v().i().getText();
            if (TextUtils.isEmpty(text)) {
                return;
            }
            this.f19650b.v().i().setSelection(text.length());
        }
    }

    /* loaded from: classes3.dex */
    public class d implements a.e {
        public d() {
        }

        @Override // d.a.j0.r0.a.e
        public void a(String str, int i2) {
            if (PbActivity.this.mCurrentFragment instanceof PbFragment) {
                PbFragment pbFragment = (PbFragment) PbActivity.this.mCurrentFragment;
                if (pbFragment.J4() != null && pbFragment.J4().k0() != null) {
                    pbFragment.J4().k0().r0();
                }
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a005").param("obj_locate", 0).param(TiebaStatic.Params.RESOURCE_ID, i2));
        }

        @Override // d.a.j0.r0.a.e
        public void onError(String str) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a005").param("obj_locate", 1).param(TiebaStatic.Params.RESOURCE_ID, 0));
        }
    }

    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<String> f19653a;

        /* renamed from: b  reason: collision with root package name */
        public ConcurrentHashMap<String, ImageUrlData> f19654b;

        /* renamed from: h  reason: collision with root package name */
        public boolean f19660h;

        /* renamed from: c  reason: collision with root package name */
        public String f19655c = null;

        /* renamed from: d  reason: collision with root package name */
        public String f19656d = null;

        /* renamed from: e  reason: collision with root package name */
        public String f19657e = null;

        /* renamed from: f  reason: collision with root package name */
        public String f19658f = null;

        /* renamed from: g  reason: collision with root package name */
        public boolean f19659g = false;

        /* renamed from: i  reason: collision with root package name */
        public String f19661i = "";
        public int j = 0;
    }

    private Fragment createFragment(String str) {
        if (VIDEO_PB_FRAGMENT_TAG.equals(str)) {
            return VideoPbFragment.T3();
        }
        return PbFragment.r5();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fillFragment(d.a.j0.d2.h.e eVar) {
        String fragmentTag = getFragmentTag(eVar);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager.findFragmentByTag(fragmentTag) == null) {
            this.mCurrentFragment = createFragment(fragmentTag);
            supportFragmentManager.beginTransaction().add(R.id.container, this.mCurrentFragment, fragmentTag).commitAllowingStateLoss();
        }
    }

    private String getFragmentTag(d.a.j0.d2.h.e eVar) {
        return (eVar == null || !eVar.f0()) ? PB_FRAGMENT_TAG : VIDEO_PB_FRAGMENT_TAG;
    }

    private void initData(Bundle bundle) {
        this.mVideoPbViewModel.a(this.mPbModel);
        m0.b().p(this.mPbModel.N(), this.mPbModel.i0());
        this.mPbModel.M1(new a());
        registerListener(new b(2004003));
        this.mPbModel.n1();
        if (this.mPbModel.a1()) {
            d.a.j0.d2.h.e M = this.mPbModel.M(d.a.j0.q0.l.a());
            if (M != null) {
                if (this.mPbModel.y0() != null) {
                    this.mPbModel.y0().v0(M.L());
                }
                M.k0(3);
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
        if (l.D() && !TbadkCoreApplication.getInst().syncHasFinish) {
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
    public void isShowDeleteResumeEditorTips(View view, d.a.i0.w.w.e eVar, String str) {
        new WriteTipBubbleController(getPageContext(), new c(view, eVar)).d(view, getString(R.string.open_editor_tips), str, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_PB_REPLY);
    }

    private void requestFunAd() {
        boolean z = true;
        if (((TbadkCoreApplication.getCurrentAccountInfo() == null || TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() != 1) ? false : false) || !d.a.i0.b.d.B()) {
            return;
        }
        Activity e2 = d.a.c.a.b.f().e(0);
        if (this.loadListener == null) {
            this.loadListener = new d();
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("tid", this.mPbModel.y0().N()).param("fid", this.mPbModel.y0().m()).param("obj_type", "a005"));
        String d2 = d.a.j0.r0.d.c.e().d("pb_banner");
        d.a.j0.r0.a h2 = d.a.j0.r0.a.h();
        if (e2 == null) {
            e2 = this;
        }
        h2.m(e2, d2, this.loadListener, d.a.j0.r0.a.a("pb", d.a.i0.b.d.B() ? "1" : "0"));
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
        p0 p0Var;
        d.a.j0.d2.k.e.c cVar = this.mBackController;
        if (cVar != null && !cVar.b(this.mPbModel) && this.mIsFromSchema) {
            if (TbadkApplication.getInst().isNeedNewUserLead() && TbadkApplication.getInst().getIsFirstUse()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new InterestGuideActivityConfig(this)));
            } else {
                sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
        }
        if ((!TbadkApplication.getInst().isNeedNewUserLead() || !TbadkApplication.getInst().getIsFirstUse()) && (p0Var = this.mPbToHomeUpdateController) != null) {
            p0Var.a(this.mPbModel);
        }
        Fragment findFragment = findFragment();
        if (findFragment instanceof i) {
            ((i) findFragment).finish();
        } else {
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, d.a.i0.k0.a
    public String getCurrentPageKey() {
        return "a005";
    }

    @Override // d.a.j0.d2.k.a
    public d.a.j0.d2.k.e.b1.a getEventController() {
        return this.mEvent;
    }

    @Override // d.a.j0.d2.k.a
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
    public d.a.i0.k0.d getPageStayDurationItem() {
        d.a.i0.k0.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            PbModel pbModel = this.mPbModel;
            if (pbModel != null) {
                if (pbModel.y0() != null) {
                    pageStayDurationItem.q(d.a.c.e.m.b.f(this.mPbModel.y0().m(), 0L));
                }
                pageStayDurationItem.y(d.a.c.e.m.b.f(this.mPbModel.O0(), 0L));
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
                int i2 = ((PbFragment) findFragment).m1;
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

    @Override // d.a.j0.d2.k.a
    public int getUserIdentify() {
        PbModel pbModel = this.mPbModel;
        if (pbModel == null || pbModel.y0() == null) {
            return 0;
        }
        return this.mPbModel.y0().S();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        return this.mVoiceManager;
    }

    @Override // d.a.j0.d2.k.a
    public boolean isHost(String str) {
        PbModel pbModel = this.mPbModel;
        return pbModel != null && pbModel.f1(str);
    }

    public boolean isImage(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    @Override // d.a.j0.d2.k.a
    public boolean isSimpleForum() {
        PbModel pbModel = this.mPbModel;
        if (pbModel == null) {
            return false;
        }
        return pbModel.e1();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        Fragment findFragment = findFragment();
        if (findFragment != null) {
            findFragment.onActivityResult(i2, i3, intent);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        Fragment findFragment = findFragment();
        if (findFragment instanceof PbFragment) {
            ((PbFragment) findFragment).onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Fragment findFragment = findFragment();
        if (findFragment instanceof BaseFragment) {
            ((BaseFragment) findFragment).onChangeSkinType(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        initUniqueId();
        initPbModel(bundle);
        if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !d.a.c.a.b.f().h("MainTabActivity")) {
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
        this.mBackController = new d.a.j0.d2.k.e.c(getPageContext());
        this.mPbToHomeUpdateController = new p0(getPageContext());
        this.mNEGFeedBackManager = new d.a.j0.h.a(getPageContext(), "client_pb_live");
        this.mUserBlockController = new d.a.j0.n3.b(getPageContext(), getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        VoiceManager voiceManager = this.mVoiceManager;
        if (voiceManager != null) {
            voiceManager.onDestory(getPageContext());
        }
        d.a.j0.h.a aVar = this.mNEGFeedBackManager;
        if (aVar != null) {
            aVar.g();
        }
        d.a.j0.n3.b bVar = this.mUserBlockController;
        if (bVar != null) {
            bVar.l();
        }
        TbPageExtraHelper.u(getCurrentPageKey());
        h.i(new PrePageKeyEvent(getCurrentPageKey()));
        if (this.loadListener != null) {
            this.loadListener = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        Fragment findFragment = findFragment();
        if (findFragment instanceof PbFragment) {
            if (((PbFragment) findFragment).onKeyDown(i2, keyEvent)) {
                return true;
            }
        } else if ((findFragment instanceof VideoPbFragment) && ((VideoPbFragment) findFragment).onKeyDown(i2, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        Fragment findFragment = findFragment();
        if (findFragment instanceof VideoPbFragment) {
            ((VideoPbFragment) findFragment).U3(z);
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
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i2 == 0) {
            Fragment fragment = this.mCurrentFragment;
            if ((fragment instanceof PbFragment) && ((PbFragment) fragment).G4() != null) {
                ((PbFragment) this.mCurrentFragment).G4().v0();
                return;
            }
            Fragment fragment2 = this.mCurrentFragment;
            if (!(fragment2 instanceof VideoPbFragment) || ((VideoPbFragment) fragment2).b3() == null) {
                return;
            }
            ((VideoPbFragment) this.mCurrentFragment).b3().v0();
            return;
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mPbModel != null) {
            m0.b().p(this.mPbModel.N(), this.mPbModel.i0());
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

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
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
            ((VideoPbFragment) fragment).X3(z);
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
        this.mUserBlockController.n(d.a.c.e.m.b.f(str, 0L));
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
