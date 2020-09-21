package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes21.dex */
public class PbActivity extends BaseFragmentActivity implements VoiceManager.c, com.baidu.tieba.pb.pb.a<PbActivity> {
    private Fragment aYq;
    private VoiceManager hZU;
    private com.baidu.tieba.NEGFeedBack.a iaK;
    private PbModel kIh;
    private com.baidu.tieba.pb.videopb.e kIi;
    private boolean kIl;
    private com.baidu.tieba.pb.pb.main.a kIm;
    private aw kIn;
    private View mRootView;
    public final com.baidu.tieba.pb.pb.main.b.a kIj = new com.baidu.tieba.pb.pb.main.b.a(this);
    public final com.baidu.tieba.pb.pb.main.b.c kIk = new com.baidu.tieba.pb.pb.main.b.c(getPageContext());
    private boolean mIsFromSchema = false;

    /* loaded from: classes21.dex */
    public static class a {
        public ConcurrentHashMap<String, ImageUrlData> dXc;
        public ArrayList<String> kIp;
        public boolean kIq;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public String postId = null;
        public boolean dXa = false;
        public boolean kIr = false;
        public String lastId = "";
        public int index = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        initUniqueId();
        aA(bundle);
        if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !com.baidu.adp.base.a.lf().bq("MainTabActivity")) {
            this.mIsFromSchema = true;
            int loadInt = TbadkSettings.getInst().loadInt(SharedPrefConfig.PREFS_SKIN_TYPE, 0);
            if (loadInt != 1) {
                com.baidu.tbadk.core.util.ap.C(false, true);
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
        das();
        initData(bundle);
        this.hZU = new VoiceManager();
        this.hZU.onCreate(getPageContext());
        this.kIm = new com.baidu.tieba.pb.pb.main.a(getPageContext());
        this.kIn = new aw(getPageContext());
        this.iaK = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "client_pb_live");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.aYq instanceof VideoPbFragment) {
            ((VideoPbFragment) this.aYq).onWindowFocusChanged(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i == 0) {
            if ((this.aYq instanceof PbFragment) && ((PbFragment) this.aYq).daS() != null) {
                ((PbFragment) this.aYq).daS().bte();
                return;
            } else if ((this.aYq instanceof VideoPbFragment) && ((VideoPbFragment) this.aYq).daS() != null) {
                ((VideoPbFragment) this.aYq).daS().bte();
                return;
            } else {
                return;
            }
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    private void das() {
        this.kIi = (com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(this).l(com.baidu.tieba.pb.videopb.e.class);
        this.kIi.init(getIntent());
    }

    private void aA(Bundle bundle) {
        this.kIh = new PbModel(this);
        if (bundle != null) {
            this.kIh.initWithBundle(bundle);
            return;
        }
        this.kIh.initWithIntent(getIntent());
    }

    private void initData(Bundle bundle) {
        this.kIi.i(this.kIh);
        as.ddA().aR(this.kIh.dcc(), this.kIh.getIsFromMark());
        this.kIh.a(new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
                PbActivity.this.kIi.setIsLoading(false);
                PbActivity.this.hideLoadingView(PbActivity.this.mRootView);
                if (!z) {
                    if (!PbActivity.this.kIl && !PbActivity.this.kIh.dcb()) {
                        PbActivity.this.showNetRefreshView(PbActivity.this.mRootView, PbActivity.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                        PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbActivity.this.getActivity(), R.dimen.ds360));
                    }
                } else if (fVar != null) {
                    PbActivity.this.hideNetRefreshView(PbActivity.this.mRootView);
                }
                Fragment dat = PbActivity.this.dat();
                if (dat == null) {
                    if (z) {
                        PbActivity.this.kIi.b(fVar, 3);
                        if (PbActivity.this.aYq == null) {
                            PbActivity.this.c(fVar);
                        }
                    }
                } else if ((dat instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) dat).dbk() != null) {
                    ((com.baidu.tieba.pb.videopb.b) dat).dbk().a(z, i, i2, i3, fVar, str, i4);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void e(com.baidu.tieba.pb.data.f fVar) {
                Fragment dat = PbActivity.this.dat();
                if ((dat instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) dat).dbk() != null) {
                    ((com.baidu.tieba.pb.videopb.b) dat).dbk().e(fVar);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
                Fragment dat = PbActivity.this.dat();
                if ((dat instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) dat).dbk() != null) {
                    ((com.baidu.tieba.pb.videopb.b) dat).dbk().a(i, z, responsedMessage, z2, j);
                }
            }
        });
        registerListener(new CustomMessageListener(CmdConfigCustom.PB_PAGE_CACHE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.getUniqueId()) {
                    PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage;
                    com.baidu.tieba.pb.data.f pbData = pbPageReadLocalResponseMessage.getPbData();
                    if (pbData == null) {
                        PbActivity.this.kIl = false;
                        return;
                    }
                    PbActivity.this.kIl = true;
                    PbActivity.this.kIi.setIsLoading(false);
                    Fragment dat = PbActivity.this.dat();
                    if (dat == null) {
                        PbActivity.this.kIi.b(pbData, 2);
                        if (PbActivity.this.aYq == null) {
                            PbActivity.this.c(pbData);
                        }
                    } else if (dat instanceof PbFragment) {
                        PbActivity.this.kIh.a(pbData, pbPageReadLocalResponseMessage.getUpdateType(), pbPageReadLocalResponseMessage.getErrorString());
                    }
                }
            }
        });
        this.kIh.dcs();
        if (this.kIh.dcb()) {
            com.baidu.tieba.pb.data.f aI = this.kIh.aI(com.baidu.tieba.frs.l.coT());
            if (aI != null) {
                aI.Eq(3);
                if (dat() == null) {
                    this.kIi.b(aI, 1);
                    if (this.aYq == null) {
                        c(aI);
                    }
                }
            }
            this.kIi.setIsLoading(false);
        } else {
            showLoadingView(findViewById(R.id.container), true);
            this.kIi.setIsLoading(true);
        }
        if (com.baidu.adp.lib.util.l.isNetOk() && !TbadkCoreApplication.getInst().syncHasFinish) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        }
    }

    public Fragment dat() {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (com.baidu.tbadk.core.util.y.isEmpty(fragments)) {
            return null;
        }
        return fragments.get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.pb.data.f fVar) {
        String d = d(fVar);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager.findFragmentByTag(d) == null) {
            this.aYq = NR(d);
            supportFragmentManager.beginTransaction().add(R.id.container, this.aYq, d).commitAllowingStateLoss();
        }
    }

    private String d(com.baidu.tieba.pb.data.f fVar) {
        return (fVar == null || !fVar.cZr()) ? "pb_fragment_tag" : "video_pb_fragment_tag";
    }

    private Fragment NR(String str) {
        return "video_pb_fragment_tag".equals(str) ? VideoPbFragment.dhp() : PbFragment.daT();
    }

    public PbModel dah() {
        return this.kIh;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        Fragment dat = dat();
        if (dat instanceof BaseFragment) {
            ((BaseFragment) dat).onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Fragment dat = dat();
        if (dat != null) {
            dat.onActivityResult(i, i2, intent);
        }
    }

    public void dau() {
        super.finish();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.kIm != null && !this.kIm.a(this.kIh) && this.mIsFromSchema) {
            if (TbadkApplication.getInst().isNeedNewUserLead() && TbadkApplication.getInst().getIsFirstUse()) {
                sendMessage(new CustomMessage(2921454, new IntentConfig(this)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
        }
        if ((!TbadkApplication.getInst().isNeedNewUserLead() || !TbadkApplication.getInst().getIsFirstUse()) && this.kIn != null) {
            this.kIn.h(this.kIh);
        }
        Fragment dat = dat();
        if (dat instanceof com.baidu.tieba.pb.videopb.b) {
            ((com.baidu.tieba.pb.videopb.b) dat).finish();
        } else {
            super.finish();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        Fragment dat = dat();
        if (dat instanceof PbFragment) {
            ((PbFragment) dat).onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Fragment dat = dat();
        if (dat instanceof PbFragment) {
            if (((PbFragment) dat).onKeyDown(i, keyEvent)) {
                return true;
            }
        } else if ((dat instanceof VideoPbFragment) && ((VideoPbFragment) dat).onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.kIh != null) {
            this.kIh.aC(bundle);
        }
        if (this.hZU != null) {
            this.hZU.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.hZU != null) {
            this.hZU.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hZU != null) {
            this.hZU.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kIh != null) {
            as.ddA().aR(this.kIh.dcc(), this.kIh.getIsFromMark());
        }
        if (this.hZU != null) {
            this.hZU.onResume(getPageContext());
        }
        if (this.aYq instanceof BaseFragment) {
            ((BaseFragment) this.aYq).setPrimary(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hZU != null) {
            this.hZU.onStop(getPageContext());
        }
        if (this.aYq instanceof BaseFragment) {
            ((BaseFragment) this.aYq).setPrimary(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hZU != null) {
            this.hZU.onDestory(getPageContext());
        }
        if (this.iaK != null) {
            this.iaK.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        return 0L;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a cZW() {
        return this.kIj;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean cZX() {
        if (this.kIh == null) {
            return false;
        }
        return this.kIh.cZX();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String cZY() {
        if (this.kIh != null) {
            return this.kIh.cZY();
        }
        return null;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int cZZ() {
        if (this.kIh == null || this.kIh.getPbData() == null) {
            return 0;
        }
        return this.kIh.getPbData().cZg();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean NQ(String str) {
        return this.kIh != null && this.kIh.Oc(str);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.PB;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            if (this.kIh != null) {
                if (this.kIh.getPbData() != null) {
                    pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.kIh.getPbData().getForumId(), 0L));
                }
                pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.kIh.dcf(), 0L));
                if (this.kIh.getPbData() != null && this.kIh.getPbData().cYR() != null) {
                    pageStayDurationItem.setNid(this.kIh.getPbData().cYR().getNid());
                }
            }
            if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.CR(TbadkCoreApplication.getInst().getAdAdSense().eCe);
            }
            Fragment dat = dat();
            if (dat instanceof PbFragment) {
                if (((PbFragment) dat).kMH == 2) {
                    pageStayDurationItem.CS(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                } else if (((PbFragment) dat).kMH == 1) {
                    pageStayDurationItem.CS(PageStayDurationConstants.PageName.HOMEPAGE_CONCERN);
                } else if (((PbFragment) dat).kMH == 3) {
                    pageStayDurationItem.CS(PageStayDurationConstants.PageName.FRS);
                }
            }
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        if (getIntent().getParcelableExtra(PbActivityConfig.VIDEO_ORIGIN_AREA) != null || this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            super.enterExitAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        if (this.kIh != null) {
            this.kIi.setIsLoading(true);
            showLoadingView(this.mRootView);
            this.kIh.dcs();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.hZU;
    }

    public void cpE() {
        if (this.hZU != null) {
            this.hZU.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected boolean shouldChangeStatusBarIconAndTextColor() {
        return !(this.aYq instanceof VideoPbFragment);
    }

    public View getRootView() {
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        Fragment dat = dat();
        if (dat instanceof VideoPbFragment) {
            ((VideoPbFragment) dat).onKeyboardVisibilityChanged(z);
        }
    }
}
