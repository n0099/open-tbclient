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
/* loaded from: classes9.dex */
public class PbActivity extends BaseFragmentActivity implements VoiceManager.c, com.baidu.tieba.pb.pb.a<PbActivity> {
    private Fragment aPn;
    private VoiceManager hzJ;
    private PbModel kbF;
    private com.baidu.tieba.pb.videopb.e kbG;
    private boolean kbJ;
    private com.baidu.tieba.pb.pb.main.a kbK;
    private as kbL;
    private View mRootView;
    public final com.baidu.tieba.pb.pb.main.b.a kbH = new com.baidu.tieba.pb.pb.main.b.a(this);
    public final com.baidu.tieba.pb.pb.main.b.c kbI = new com.baidu.tieba.pb.pb.main.b.c(getPageContext());
    private boolean mIsFromSchema = false;

    /* loaded from: classes9.dex */
    public static class a {
        public ArrayList<String> kbN;
        public ConcurrentHashMap<String, ImageUrlData> kbO;
        public boolean kbQ;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public String postId = null;
        public boolean kbP = false;
        public boolean kbR = false;
        public String lastId = "";
        public int index = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        initUniqueId();
        aA(bundle);
        if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !com.baidu.adp.base.a.jC().bj("MainTabActivity")) {
            this.mIsFromSchema = true;
            int loadInt = TbadkSettings.getInst().loadInt(SharedPrefConfig.PREFS_SKIN_TYPE, 0);
            if (loadInt != 1) {
                com.baidu.tbadk.core.util.an.y(false, true);
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
        cIq();
        initData(bundle);
        this.hzJ = new VoiceManager();
        this.hzJ.onCreate(getPageContext());
        this.kbK = new com.baidu.tieba.pb.pb.main.a(getPageContext());
        this.kbL = new as(getPageContext());
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.aPn instanceof VideoPbFragment) {
            ((VideoPbFragment) this.aPn).onWindowFocusChanged(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i == 0) {
            if ((this.aPn instanceof PbFragment) && ((PbFragment) this.aPn).cIQ() != null) {
                ((PbFragment) this.aPn).cIQ().bfD();
                return;
            } else if ((this.aPn instanceof VideoPbFragment) && ((VideoPbFragment) this.aPn).cIQ() != null) {
                ((VideoPbFragment) this.aPn).cIQ().bfD();
                return;
            } else {
                return;
            }
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    private void cIq() {
        this.kbG = (com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(this).l(com.baidu.tieba.pb.videopb.e.class);
        this.kbG.init(getIntent());
    }

    private void aA(Bundle bundle) {
        this.kbF = new PbModel(this);
        if (bundle != null) {
            this.kbF.initWithBundle(bundle);
            return;
        }
        this.kbF.initWithIntent(getIntent());
    }

    private void initData(Bundle bundle) {
        this.kbG.i(this.kbF);
        ao.cLu().aP(this.kbF.cJX(), this.kbF.getIsFromMark());
        this.kbF.a(new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
                PbActivity.this.kbG.setIsLoading(false);
                PbActivity.this.hideLoadingView(PbActivity.this.mRootView);
                if (!z) {
                    if (!PbActivity.this.kbJ && !PbActivity.this.kbF.cJW()) {
                        PbActivity.this.showNetRefreshView(PbActivity.this.mRootView, PbActivity.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                        PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbActivity.this.getActivity(), R.dimen.ds360));
                    }
                } else if (eVar != null) {
                    PbActivity.this.hideNetRefreshView(PbActivity.this.mRootView);
                }
                Fragment cIr = PbActivity.this.cIr();
                if (cIr == null) {
                    if (z) {
                        PbActivity.this.kbG.b(eVar, 3);
                        if (PbActivity.this.aPn == null) {
                            PbActivity.this.c(eVar);
                        }
                    }
                } else if ((cIr instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) cIr).cJi() != null) {
                    ((com.baidu.tieba.pb.videopb.b) cIr).cJi().a(z, i, i2, i3, eVar, str, i4);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void e(com.baidu.tieba.pb.data.e eVar) {
                Fragment cIr = PbActivity.this.cIr();
                if ((cIr instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) cIr).cJi() != null) {
                    ((com.baidu.tieba.pb.videopb.b) cIr).cJi().e(eVar);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
                Fragment cIr = PbActivity.this.cIr();
                if ((cIr instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) cIr).cJi() != null) {
                    ((com.baidu.tieba.pb.videopb.b) cIr).cJi().a(i, z, responsedMessage, z2, j);
                }
            }
        });
        registerListener(new CustomMessageListener(CmdConfigCustom.PB_PAGE_CACHE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.getUniqueId()) {
                    PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage;
                    com.baidu.tieba.pb.data.e pbData = pbPageReadLocalResponseMessage.getPbData();
                    if (pbData == null) {
                        PbActivity.this.kbJ = false;
                        return;
                    }
                    PbActivity.this.kbJ = true;
                    PbActivity.this.kbG.setIsLoading(false);
                    Fragment cIr = PbActivity.this.cIr();
                    if (cIr == null) {
                        PbActivity.this.kbG.b(pbData, 2);
                        if (PbActivity.this.aPn == null) {
                            PbActivity.this.c(pbData);
                        }
                    } else if (cIr instanceof PbFragment) {
                        PbActivity.this.kbF.a(pbData, pbPageReadLocalResponseMessage.getUpdateType(), pbPageReadLocalResponseMessage.getErrorString());
                    }
                }
            }
        });
        this.kbF.cKn();
        if (this.kbF.cJW()) {
            com.baidu.tieba.pb.data.e aJ = this.kbF.aJ(com.baidu.tieba.frs.k.bXO());
            if (aJ != null) {
                aJ.AX(3);
                if (cIr() == null) {
                    this.kbG.b(aJ, 1);
                    if (this.aPn == null) {
                        c(aJ);
                    }
                }
            }
            this.kbG.setIsLoading(false);
        } else {
            showLoadingView(findViewById(R.id.container), true);
            this.kbG.setIsLoading(true);
        }
        if (com.baidu.adp.lib.util.l.isNetOk() && !TbadkCoreApplication.getInst().syncHasFinish) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        }
    }

    public Fragment cIr() {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (com.baidu.tbadk.core.util.w.isEmpty(fragments)) {
            return null;
        }
        return fragments.get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.pb.data.e eVar) {
        String d = d(eVar);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager.findFragmentByTag(d) == null) {
            this.aPn = JK(d);
            supportFragmentManager.beginTransaction().add(R.id.container, this.aPn, d).commitAllowingStateLoss();
        }
    }

    private String d(com.baidu.tieba.pb.data.e eVar) {
        return (eVar == null || !eVar.cHn()) ? "pb_fragment_tag" : "video_pb_fragment_tag";
    }

    private Fragment JK(String str) {
        return "video_pb_fragment_tag".equals(str) ? VideoPbFragment.cPf() : PbFragment.cIR();
    }

    public PbModel cIf() {
        return this.kbF;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        Fragment cIr = cIr();
        if (cIr instanceof BaseFragment) {
            ((BaseFragment) cIr).onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Fragment cIr = cIr();
        if (cIr != null) {
            cIr.onActivityResult(i, i2, intent);
        }
    }

    public void cIs() {
        super.finish();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (!this.kbK.a(this.kbF) && this.mIsFromSchema) {
            if (TbadkApplication.getInst().isNeedNewUserLead() && TbadkApplication.getInst().getIsFirstUse()) {
                sendMessage(new CustomMessage(2921454, new IntentConfig(this)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
        }
        if (!TbadkApplication.getInst().isNeedNewUserLead() || !TbadkApplication.getInst().getIsFirstUse()) {
            this.kbL.h(this.kbF);
        }
        Fragment cIr = cIr();
        if (cIr instanceof com.baidu.tieba.pb.videopb.b) {
            ((com.baidu.tieba.pb.videopb.b) cIr).finish();
        } else {
            super.finish();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        Fragment cIr = cIr();
        if (cIr instanceof PbFragment) {
            ((PbFragment) cIr).onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Fragment cIr = cIr();
        if (cIr instanceof PbFragment) {
            if (((PbFragment) cIr).onKeyDown(i, keyEvent)) {
                return true;
            }
        } else if ((cIr instanceof VideoPbFragment) && ((VideoPbFragment) cIr).onKeyDown(i, keyEvent)) {
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
        if (this.kbF != null) {
            this.kbF.aC(bundle);
        }
        if (this.hzJ != null) {
            this.hzJ.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.hzJ != null) {
            this.hzJ.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hzJ != null) {
            this.hzJ.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hzJ != null) {
            this.hzJ.onResume(getPageContext());
        }
        if (this.aPn instanceof BaseFragment) {
            ((BaseFragment) this.aPn).setPrimary(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hzJ != null) {
            this.hzJ.onStop(getPageContext());
        }
        if (this.aPn instanceof BaseFragment) {
            ((BaseFragment) this.aPn).setPrimary(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hzJ != null) {
            this.hzJ.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        return 0L;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a cHU() {
        return this.kbH;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean cHV() {
        if (this.kbF == null) {
            return false;
        }
        return this.kbF.cHV();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String cHW() {
        if (this.kbF != null) {
            return this.kbF.cHW();
        }
        return null;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int cHX() {
        if (this.kbF == null || this.kbF.getPbData() == null) {
            return 0;
        }
        return this.kbF.getPbData().cHd();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean JJ(String str) {
        return this.kbF != null && this.kbF.JU(str);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.PB;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            if (this.kbF != null) {
                if (this.kbF.getPbData() != null) {
                    pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.kbF.getPbData().getForumId(), 0L));
                }
                pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.kbF.cKa(), 0L));
                if (this.kbF.getPbData() != null && this.kbF.getPbData().cGO() != null) {
                    pageStayDurationItem.setNid(this.kbF.getPbData().cGO().getNid());
                }
            }
            if (!com.baidu.tbadk.core.util.ar.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.yX(TbadkCoreApplication.getInst().getAdAdSense().ejy);
            }
            Fragment cIr = cIr();
            if (cIr instanceof PbFragment) {
                if (((PbFragment) cIr).kfT == 2) {
                    pageStayDurationItem.yY(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                } else if (((PbFragment) cIr).kfT == 1) {
                    pageStayDurationItem.yY(PageStayDurationConstants.PageName.HOMEPAGE_CONCERN);
                } else if (((PbFragment) cIr).kfT == 3) {
                    pageStayDurationItem.yY(PageStayDurationConstants.PageName.FRS);
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
        if (this.kbF != null) {
            this.kbG.setIsLoading(true);
            showLoadingView(this.mRootView);
            this.kbF.cKn();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.hzJ;
    }

    public void bYx() {
        if (this.hzJ != null) {
            this.hzJ.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected boolean shouldChangeStatusBarIconAndTextColor() {
        return !(this.aPn instanceof VideoPbFragment);
    }

    public View getRootView() {
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        Fragment cIr = cIr();
        if (cIr instanceof VideoPbFragment) {
            ((VideoPbFragment) cIr).onKeyboardVisibilityChanged(z);
        }
    }
}
