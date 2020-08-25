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
/* loaded from: classes16.dex */
public class PbActivity extends BaseFragmentActivity implements VoiceManager.c, com.baidu.tieba.pb.pb.a<PbActivity> {
    private Fragment aVU;
    private VoiceManager hSO;
    private com.baidu.tieba.NEGFeedBack.a hTE;
    private PbModel kzD;
    private com.baidu.tieba.pb.videopb.e kzE;
    private boolean kzH;
    private com.baidu.tieba.pb.pb.main.a kzI;
    private aw kzJ;
    private View mRootView;
    public final com.baidu.tieba.pb.pb.main.b.a kzF = new com.baidu.tieba.pb.pb.main.b.a(this);
    public final com.baidu.tieba.pb.pb.main.b.c kzG = new com.baidu.tieba.pb.pb.main.b.c(getPageContext());
    private boolean mIsFromSchema = false;

    /* loaded from: classes16.dex */
    public static class a {
        public ConcurrentHashMap<String, ImageUrlData> dUO;
        public ArrayList<String> kzL;
        public boolean kzM;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public String postId = null;
        public boolean dUM = false;
        public boolean kzN = false;
        public String lastId = "";
        public int index = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        initUniqueId();
        aA(bundle);
        if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !com.baidu.adp.base.a.lb().bo("MainTabActivity")) {
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
        cWO();
        initData(bundle);
        this.hSO = new VoiceManager();
        this.hSO.onCreate(getPageContext());
        this.kzI = new com.baidu.tieba.pb.pb.main.a(getPageContext());
        this.kzJ = new aw(getPageContext());
        this.hTE = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "client_pb_live");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.aVU instanceof VideoPbFragment) {
            ((VideoPbFragment) this.aVU).onWindowFocusChanged(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i == 0) {
            if ((this.aVU instanceof PbFragment) && ((PbFragment) this.aVU).cXo() != null) {
                ((PbFragment) this.aVU).cXo().brZ();
                return;
            } else if ((this.aVU instanceof VideoPbFragment) && ((VideoPbFragment) this.aVU).cXo() != null) {
                ((VideoPbFragment) this.aVU).cXo().brZ();
                return;
            } else {
                return;
            }
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    private void cWO() {
        this.kzE = (com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(this).l(com.baidu.tieba.pb.videopb.e.class);
        this.kzE.init(getIntent());
    }

    private void aA(Bundle bundle) {
        this.kzD = new PbModel(this);
        if (bundle != null) {
            this.kzD.initWithBundle(bundle);
            return;
        }
        this.kzD.initWithIntent(getIntent());
    }

    private void initData(Bundle bundle) {
        this.kzE.i(this.kzD);
        as.cZW().aR(this.kzD.cYy(), this.kzD.getIsFromMark());
        this.kzD.a(new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
                PbActivity.this.kzE.setIsLoading(false);
                PbActivity.this.hideLoadingView(PbActivity.this.mRootView);
                if (!z) {
                    if (!PbActivity.this.kzH && !PbActivity.this.kzD.cYx()) {
                        PbActivity.this.showNetRefreshView(PbActivity.this.mRootView, PbActivity.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                        PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbActivity.this.getActivity(), R.dimen.ds360));
                    }
                } else if (fVar != null) {
                    PbActivity.this.hideNetRefreshView(PbActivity.this.mRootView);
                }
                Fragment cWP = PbActivity.this.cWP();
                if (cWP == null) {
                    if (z) {
                        PbActivity.this.kzE.b(fVar, 3);
                        if (PbActivity.this.aVU == null) {
                            PbActivity.this.c(fVar);
                        }
                    }
                } else if ((cWP instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) cWP).cXG() != null) {
                    ((com.baidu.tieba.pb.videopb.b) cWP).cXG().a(z, i, i2, i3, fVar, str, i4);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void e(com.baidu.tieba.pb.data.f fVar) {
                Fragment cWP = PbActivity.this.cWP();
                if ((cWP instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) cWP).cXG() != null) {
                    ((com.baidu.tieba.pb.videopb.b) cWP).cXG().e(fVar);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
                Fragment cWP = PbActivity.this.cWP();
                if ((cWP instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) cWP).cXG() != null) {
                    ((com.baidu.tieba.pb.videopb.b) cWP).cXG().a(i, z, responsedMessage, z2, j);
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
                        PbActivity.this.kzH = false;
                        return;
                    }
                    PbActivity.this.kzH = true;
                    PbActivity.this.kzE.setIsLoading(false);
                    Fragment cWP = PbActivity.this.cWP();
                    if (cWP == null) {
                        PbActivity.this.kzE.b(pbData, 2);
                        if (PbActivity.this.aVU == null) {
                            PbActivity.this.c(pbData);
                        }
                    } else if (cWP instanceof PbFragment) {
                        PbActivity.this.kzD.a(pbData, pbPageReadLocalResponseMessage.getUpdateType(), pbPageReadLocalResponseMessage.getErrorString());
                    }
                }
            }
        });
        this.kzD.cYO();
        if (this.kzD.cYx()) {
            com.baidu.tieba.pb.data.f aH = this.kzD.aH(com.baidu.tieba.frs.l.clG());
            if (aH != null) {
                aH.DP(3);
                if (cWP() == null) {
                    this.kzE.b(aH, 1);
                    if (this.aVU == null) {
                        c(aH);
                    }
                }
            }
            this.kzE.setIsLoading(false);
        } else {
            showLoadingView(findViewById(R.id.container), true);
            this.kzE.setIsLoading(true);
        }
        if (com.baidu.adp.lib.util.l.isNetOk() && !TbadkCoreApplication.getInst().syncHasFinish) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        }
    }

    public Fragment cWP() {
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
            this.aVU = Np(d);
            supportFragmentManager.beginTransaction().add(R.id.container, this.aVU, d).commitAllowingStateLoss();
        }
    }

    private String d(com.baidu.tieba.pb.data.f fVar) {
        return (fVar == null || !fVar.cVL()) ? "pb_fragment_tag" : "video_pb_fragment_tag";
    }

    private Fragment Np(String str) {
        return "video_pb_fragment_tag".equals(str) ? VideoPbFragment.ddK() : PbFragment.cXp();
    }

    public PbModel cWD() {
        return this.kzD;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        Fragment cWP = cWP();
        if (cWP instanceof BaseFragment) {
            ((BaseFragment) cWP).onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Fragment cWP = cWP();
        if (cWP != null) {
            cWP.onActivityResult(i, i2, intent);
        }
    }

    public void cWQ() {
        super.finish();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.kzI != null && !this.kzI.a(this.kzD) && this.mIsFromSchema) {
            if (TbadkApplication.getInst().isNeedNewUserLead() && TbadkApplication.getInst().getIsFirstUse()) {
                sendMessage(new CustomMessage(2921454, new IntentConfig(this)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
        }
        if ((!TbadkApplication.getInst().isNeedNewUserLead() || !TbadkApplication.getInst().getIsFirstUse()) && this.kzJ != null) {
            this.kzJ.h(this.kzD);
        }
        Fragment cWP = cWP();
        if (cWP instanceof com.baidu.tieba.pb.videopb.b) {
            ((com.baidu.tieba.pb.videopb.b) cWP).finish();
        } else {
            super.finish();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        Fragment cWP = cWP();
        if (cWP instanceof PbFragment) {
            ((PbFragment) cWP).onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Fragment cWP = cWP();
        if (cWP instanceof PbFragment) {
            if (((PbFragment) cWP).onKeyDown(i, keyEvent)) {
                return true;
            }
        } else if ((cWP instanceof VideoPbFragment) && ((VideoPbFragment) cWP).onKeyDown(i, keyEvent)) {
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
        if (this.kzD != null) {
            this.kzD.aC(bundle);
        }
        if (this.hSO != null) {
            this.hSO.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.hSO != null) {
            this.hSO.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hSO != null) {
            this.hSO.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kzD != null) {
            as.cZW().aR(this.kzD.cYy(), this.kzD.getIsFromMark());
        }
        if (this.hSO != null) {
            this.hSO.onResume(getPageContext());
        }
        if (this.aVU instanceof BaseFragment) {
            ((BaseFragment) this.aVU).setPrimary(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hSO != null) {
            this.hSO.onStop(getPageContext());
        }
        if (this.aVU instanceof BaseFragment) {
            ((BaseFragment) this.aVU).setPrimary(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hSO != null) {
            this.hSO.onDestory(getPageContext());
        }
        if (this.hTE != null) {
            this.hTE.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        return 0L;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a cWs() {
        return this.kzF;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean cWt() {
        if (this.kzD == null) {
            return false;
        }
        return this.kzD.cWt();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String cWu() {
        if (this.kzD != null) {
            return this.kzD.cWu();
        }
        return null;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int cWv() {
        if (this.kzD == null || this.kzD.getPbData() == null) {
            return 0;
        }
        return this.kzD.getPbData().cVA();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean No(String str) {
        return this.kzD != null && this.kzD.NA(str);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.PB;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            if (this.kzD != null) {
                if (this.kzD.getPbData() != null) {
                    pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.kzD.getPbData().getForumId(), 0L));
                }
                pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.kzD.cYB(), 0L));
                if (this.kzD.getPbData() != null && this.kzD.getPbData().cVl() != null) {
                    pageStayDurationItem.setNid(this.kzD.getPbData().cVl().getNid());
                }
            }
            if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.Cu(TbadkCoreApplication.getInst().getAdAdSense().ezW);
            }
            Fragment cWP = cWP();
            if (cWP instanceof PbFragment) {
                if (((PbFragment) cWP).kEb == 2) {
                    pageStayDurationItem.Cv(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                } else if (((PbFragment) cWP).kEb == 1) {
                    pageStayDurationItem.Cv(PageStayDurationConstants.PageName.HOMEPAGE_CONCERN);
                } else if (((PbFragment) cWP).kEb == 3) {
                    pageStayDurationItem.Cv(PageStayDurationConstants.PageName.FRS);
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
        if (this.kzD != null) {
            this.kzE.setIsLoading(true);
            showLoadingView(this.mRootView);
            this.kzD.cYO();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.hSO;
    }

    public void cmr() {
        if (this.hSO != null) {
            this.hSO.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected boolean shouldChangeStatusBarIconAndTextColor() {
        return !(this.aVU instanceof VideoPbFragment);
    }

    public View getRootView() {
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        Fragment cWP = cWP();
        if (cWP instanceof VideoPbFragment) {
            ((VideoPbFragment) cWP).onKeyboardVisibilityChanged(z);
        }
    }
}
