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
    private Fragment aVW;
    private VoiceManager hSU;
    private com.baidu.tieba.NEGFeedBack.a hTK;
    private PbModel kzK;
    private com.baidu.tieba.pb.videopb.e kzL;
    private boolean kzO;
    private com.baidu.tieba.pb.pb.main.a kzP;
    private aw kzQ;
    private View mRootView;
    public final com.baidu.tieba.pb.pb.main.b.a kzM = new com.baidu.tieba.pb.pb.main.b.a(this);
    public final com.baidu.tieba.pb.pb.main.b.c kzN = new com.baidu.tieba.pb.pb.main.b.c(getPageContext());
    private boolean mIsFromSchema = false;

    /* loaded from: classes16.dex */
    public static class a {
        public ConcurrentHashMap<String, ImageUrlData> dUS;
        public ArrayList<String> kzS;
        public boolean kzT;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public String postId = null;
        public boolean dUQ = false;
        public boolean kzU = false;
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
        cWP();
        initData(bundle);
        this.hSU = new VoiceManager();
        this.hSU.onCreate(getPageContext());
        this.kzP = new com.baidu.tieba.pb.pb.main.a(getPageContext());
        this.kzQ = new aw(getPageContext());
        this.hTK = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "client_pb_live");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.aVW instanceof VideoPbFragment) {
            ((VideoPbFragment) this.aVW).onWindowFocusChanged(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i == 0) {
            if ((this.aVW instanceof PbFragment) && ((PbFragment) this.aVW).cXp() != null) {
                ((PbFragment) this.aVW).cXp().bsa();
                return;
            } else if ((this.aVW instanceof VideoPbFragment) && ((VideoPbFragment) this.aVW).cXp() != null) {
                ((VideoPbFragment) this.aVW).cXp().bsa();
                return;
            } else {
                return;
            }
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    private void cWP() {
        this.kzL = (com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(this).l(com.baidu.tieba.pb.videopb.e.class);
        this.kzL.init(getIntent());
    }

    private void aA(Bundle bundle) {
        this.kzK = new PbModel(this);
        if (bundle != null) {
            this.kzK.initWithBundle(bundle);
            return;
        }
        this.kzK.initWithIntent(getIntent());
    }

    private void initData(Bundle bundle) {
        this.kzL.i(this.kzK);
        as.cZX().aR(this.kzK.cYz(), this.kzK.getIsFromMark());
        this.kzK.a(new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
                PbActivity.this.kzL.setIsLoading(false);
                PbActivity.this.hideLoadingView(PbActivity.this.mRootView);
                if (!z) {
                    if (!PbActivity.this.kzO && !PbActivity.this.kzK.cYy()) {
                        PbActivity.this.showNetRefreshView(PbActivity.this.mRootView, PbActivity.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                        PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbActivity.this.getActivity(), R.dimen.ds360));
                    }
                } else if (fVar != null) {
                    PbActivity.this.hideNetRefreshView(PbActivity.this.mRootView);
                }
                Fragment cWQ = PbActivity.this.cWQ();
                if (cWQ == null) {
                    if (z) {
                        PbActivity.this.kzL.b(fVar, 3);
                        if (PbActivity.this.aVW == null) {
                            PbActivity.this.c(fVar);
                        }
                    }
                } else if ((cWQ instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) cWQ).cXH() != null) {
                    ((com.baidu.tieba.pb.videopb.b) cWQ).cXH().a(z, i, i2, i3, fVar, str, i4);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void e(com.baidu.tieba.pb.data.f fVar) {
                Fragment cWQ = PbActivity.this.cWQ();
                if ((cWQ instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) cWQ).cXH() != null) {
                    ((com.baidu.tieba.pb.videopb.b) cWQ).cXH().e(fVar);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
                Fragment cWQ = PbActivity.this.cWQ();
                if ((cWQ instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) cWQ).cXH() != null) {
                    ((com.baidu.tieba.pb.videopb.b) cWQ).cXH().a(i, z, responsedMessage, z2, j);
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
                        PbActivity.this.kzO = false;
                        return;
                    }
                    PbActivity.this.kzO = true;
                    PbActivity.this.kzL.setIsLoading(false);
                    Fragment cWQ = PbActivity.this.cWQ();
                    if (cWQ == null) {
                        PbActivity.this.kzL.b(pbData, 2);
                        if (PbActivity.this.aVW == null) {
                            PbActivity.this.c(pbData);
                        }
                    } else if (cWQ instanceof PbFragment) {
                        PbActivity.this.kzK.a(pbData, pbPageReadLocalResponseMessage.getUpdateType(), pbPageReadLocalResponseMessage.getErrorString());
                    }
                }
            }
        });
        this.kzK.cYP();
        if (this.kzK.cYy()) {
            com.baidu.tieba.pb.data.f aH = this.kzK.aH(com.baidu.tieba.frs.l.clH());
            if (aH != null) {
                aH.DP(3);
                if (cWQ() == null) {
                    this.kzL.b(aH, 1);
                    if (this.aVW == null) {
                        c(aH);
                    }
                }
            }
            this.kzL.setIsLoading(false);
        } else {
            showLoadingView(findViewById(R.id.container), true);
            this.kzL.setIsLoading(true);
        }
        if (com.baidu.adp.lib.util.l.isNetOk() && !TbadkCoreApplication.getInst().syncHasFinish) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        }
    }

    public Fragment cWQ() {
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
            this.aVW = Nq(d);
            supportFragmentManager.beginTransaction().add(R.id.container, this.aVW, d).commitAllowingStateLoss();
        }
    }

    private String d(com.baidu.tieba.pb.data.f fVar) {
        return (fVar == null || !fVar.cVM()) ? "pb_fragment_tag" : "video_pb_fragment_tag";
    }

    private Fragment Nq(String str) {
        return "video_pb_fragment_tag".equals(str) ? VideoPbFragment.ddL() : PbFragment.cXq();
    }

    public PbModel cWE() {
        return this.kzK;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        Fragment cWQ = cWQ();
        if (cWQ instanceof BaseFragment) {
            ((BaseFragment) cWQ).onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Fragment cWQ = cWQ();
        if (cWQ != null) {
            cWQ.onActivityResult(i, i2, intent);
        }
    }

    public void cWR() {
        super.finish();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.kzP != null && !this.kzP.a(this.kzK) && this.mIsFromSchema) {
            if (TbadkApplication.getInst().isNeedNewUserLead() && TbadkApplication.getInst().getIsFirstUse()) {
                sendMessage(new CustomMessage(2921454, new IntentConfig(this)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
        }
        if ((!TbadkApplication.getInst().isNeedNewUserLead() || !TbadkApplication.getInst().getIsFirstUse()) && this.kzQ != null) {
            this.kzQ.h(this.kzK);
        }
        Fragment cWQ = cWQ();
        if (cWQ instanceof com.baidu.tieba.pb.videopb.b) {
            ((com.baidu.tieba.pb.videopb.b) cWQ).finish();
        } else {
            super.finish();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        Fragment cWQ = cWQ();
        if (cWQ instanceof PbFragment) {
            ((PbFragment) cWQ).onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Fragment cWQ = cWQ();
        if (cWQ instanceof PbFragment) {
            if (((PbFragment) cWQ).onKeyDown(i, keyEvent)) {
                return true;
            }
        } else if ((cWQ instanceof VideoPbFragment) && ((VideoPbFragment) cWQ).onKeyDown(i, keyEvent)) {
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
        if (this.kzK != null) {
            this.kzK.aC(bundle);
        }
        if (this.hSU != null) {
            this.hSU.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.hSU != null) {
            this.hSU.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hSU != null) {
            this.hSU.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kzK != null) {
            as.cZX().aR(this.kzK.cYz(), this.kzK.getIsFromMark());
        }
        if (this.hSU != null) {
            this.hSU.onResume(getPageContext());
        }
        if (this.aVW instanceof BaseFragment) {
            ((BaseFragment) this.aVW).setPrimary(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hSU != null) {
            this.hSU.onStop(getPageContext());
        }
        if (this.aVW instanceof BaseFragment) {
            ((BaseFragment) this.aVW).setPrimary(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hSU != null) {
            this.hSU.onDestory(getPageContext());
        }
        if (this.hTK != null) {
            this.hTK.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        return 0L;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a cWt() {
        return this.kzM;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean cWu() {
        if (this.kzK == null) {
            return false;
        }
        return this.kzK.cWu();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String cWv() {
        if (this.kzK != null) {
            return this.kzK.cWv();
        }
        return null;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int cWw() {
        if (this.kzK == null || this.kzK.getPbData() == null) {
            return 0;
        }
        return this.kzK.getPbData().cVB();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean Np(String str) {
        return this.kzK != null && this.kzK.NB(str);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.PB;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            if (this.kzK != null) {
                if (this.kzK.getPbData() != null) {
                    pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.kzK.getPbData().getForumId(), 0L));
                }
                pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.kzK.cYC(), 0L));
                if (this.kzK.getPbData() != null && this.kzK.getPbData().cVm() != null) {
                    pageStayDurationItem.setNid(this.kzK.getPbData().cVm().getNid());
                }
            }
            if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.Cv(TbadkCoreApplication.getInst().getAdAdSense().eAa);
            }
            Fragment cWQ = cWQ();
            if (cWQ instanceof PbFragment) {
                if (((PbFragment) cWQ).kEi == 2) {
                    pageStayDurationItem.Cw(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                } else if (((PbFragment) cWQ).kEi == 1) {
                    pageStayDurationItem.Cw(PageStayDurationConstants.PageName.HOMEPAGE_CONCERN);
                } else if (((PbFragment) cWQ).kEi == 3) {
                    pageStayDurationItem.Cw(PageStayDurationConstants.PageName.FRS);
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
        if (this.kzK != null) {
            this.kzL.setIsLoading(true);
            showLoadingView(this.mRootView);
            this.kzK.cYP();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.hSU;
    }

    public void cms() {
        if (this.hSU != null) {
            this.hSU.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected boolean shouldChangeStatusBarIconAndTextColor() {
        return !(this.aVW instanceof VideoPbFragment);
    }

    public View getRootView() {
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        Fragment cWQ = cWQ();
        if (cWQ instanceof VideoPbFragment) {
            ((VideoPbFragment) cWQ).onKeyboardVisibilityChanged(z);
        }
    }
}
