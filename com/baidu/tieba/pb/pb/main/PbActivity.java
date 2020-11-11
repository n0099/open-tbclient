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
/* loaded from: classes22.dex */
public class PbActivity extends BaseFragmentActivity implements VoiceManager.c, com.baidu.tieba.pb.pb.a<PbActivity> {
    private Fragment bes;
    private VoiceManager iHo;
    private com.baidu.tieba.NEGFeedBack.a iIe;
    private PbModel lpS;
    private com.baidu.tieba.pb.videopb.e lpT;
    private boolean lpW;
    private com.baidu.tieba.pb.pb.main.a lpX;
    private aw lpY;
    private View mRootView;
    public final com.baidu.tieba.pb.pb.main.b.a lpU = new com.baidu.tieba.pb.pb.main.b.a(this);
    public final com.baidu.tieba.pb.pb.main.b.c lpV = new com.baidu.tieba.pb.pb.main.b.c(getPageContext());
    private boolean mIsFromSchema = false;

    /* loaded from: classes22.dex */
    public static class a {
        public ConcurrentHashMap<String, ImageUrlData> exw;
        public ArrayList<String> lqa;
        public boolean lqb;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public String postId = null;
        public boolean exu = false;
        public boolean lqc = false;
        public String lastId = "";
        public int index = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        initUniqueId();
        aA(bundle);
        if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !com.baidu.adp.base.a.lg().bq("MainTabActivity")) {
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
        djK();
        initData(bundle);
        this.iHo = new VoiceManager();
        this.iHo.onCreate(getPageContext());
        this.lpX = new com.baidu.tieba.pb.pb.main.a(getPageContext());
        this.lpY = new aw(getPageContext());
        this.iIe = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "client_pb_live");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.bes instanceof VideoPbFragment) {
            ((VideoPbFragment) this.bes).onWindowFocusChanged(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i == 0) {
            if ((this.bes instanceof PbFragment) && ((PbFragment) this.bes).dkk() != null) {
                ((PbFragment) this.bes).dkk().bAg();
                return;
            } else if ((this.bes instanceof VideoPbFragment) && ((VideoPbFragment) this.bes).dkk() != null) {
                ((VideoPbFragment) this.bes).dkk().bAg();
                return;
            } else {
                return;
            }
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    private void djK() {
        this.lpT = (com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(this).l(com.baidu.tieba.pb.videopb.e.class);
        this.lpT.init(getIntent());
    }

    private void aA(Bundle bundle) {
        this.lpS = new PbModel(this);
        if (bundle != null) {
            this.lpS.initWithBundle(bundle);
            return;
        }
        this.lpS.initWithIntent(getIntent());
    }

    private void initData(Bundle bundle) {
        this.lpT.i(this.lpS);
        as.dmS().aX(this.lpS.dlu(), this.lpS.getIsFromMark());
        this.lpS.a(new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
                PbActivity.this.lpT.setIsLoading(false);
                PbActivity.this.hideLoadingView(PbActivity.this.mRootView);
                if (!z) {
                    if (!PbActivity.this.lpW && !PbActivity.this.lpS.dlt()) {
                        PbActivity.this.showNetRefreshView(PbActivity.this.mRootView, PbActivity.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                        PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbActivity.this.getActivity(), R.dimen.ds360));
                    }
                } else if (fVar != null) {
                    PbActivity.this.hideNetRefreshView(PbActivity.this.mRootView);
                }
                Fragment djL = PbActivity.this.djL();
                if (djL == null) {
                    if (z) {
                        PbActivity.this.lpT.b(fVar, 3);
                        if (PbActivity.this.bes == null) {
                            PbActivity.this.c(fVar);
                        }
                    }
                } else if ((djL instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) djL).dkC() != null) {
                    ((com.baidu.tieba.pb.videopb.b) djL).dkC().a(z, i, i2, i3, fVar, str, i4);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void e(com.baidu.tieba.pb.data.f fVar) {
                Fragment djL = PbActivity.this.djL();
                if ((djL instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) djL).dkC() != null) {
                    ((com.baidu.tieba.pb.videopb.b) djL).dkC().e(fVar);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
                Fragment djL = PbActivity.this.djL();
                if ((djL instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) djL).dkC() != null) {
                    ((com.baidu.tieba.pb.videopb.b) djL).dkC().a(i, z, responsedMessage, z2, j);
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
                        PbActivity.this.lpW = false;
                        return;
                    }
                    PbActivity.this.lpW = true;
                    PbActivity.this.lpT.setIsLoading(false);
                    Fragment djL = PbActivity.this.djL();
                    if (djL == null) {
                        PbActivity.this.lpT.b(pbData, 2);
                        if (PbActivity.this.bes == null) {
                            PbActivity.this.c(pbData);
                        }
                    } else if (djL instanceof PbFragment) {
                        PbActivity.this.lpS.a(pbData, pbPageReadLocalResponseMessage.getUpdateType(), pbPageReadLocalResponseMessage.getErrorString());
                    }
                }
            }
        });
        this.lpS.dlK();
        if (this.lpS.dlt()) {
            com.baidu.tieba.pb.data.f aI = this.lpS.aI(com.baidu.tieba.frs.l.cxZ());
            if (aI != null) {
                aI.FC(3);
                if (djL() == null) {
                    this.lpT.b(aI, 1);
                    if (this.bes == null) {
                        c(aI);
                    }
                }
            }
            this.lpT.setIsLoading(false);
        } else {
            showLoadingView(findViewById(R.id.container), true);
            this.lpT.setIsLoading(true);
        }
        if (com.baidu.adp.lib.util.l.isNetOk() && !TbadkCoreApplication.getInst().syncHasFinish) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        }
    }

    public Fragment djL() {
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
            this.bes = Pv(d);
            supportFragmentManager.beginTransaction().add(R.id.container, this.bes, d).commitAllowingStateLoss();
        }
    }

    private String d(com.baidu.tieba.pb.data.f fVar) {
        return (fVar == null || !fVar.diK()) ? "pb_fragment_tag" : "video_pb_fragment_tag";
    }

    private Fragment Pv(String str) {
        return "video_pb_fragment_tag".equals(str) ? VideoPbFragment.dqI() : PbFragment.dkl();
    }

    public PbModel djz() {
        return this.lpS;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        Fragment djL = djL();
        if (djL instanceof BaseFragment) {
            ((BaseFragment) djL).onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Fragment djL = djL();
        if (djL != null) {
            djL.onActivityResult(i, i2, intent);
        }
    }

    public void djM() {
        super.finish();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.lpX != null && !this.lpX.a(this.lpS) && this.mIsFromSchema) {
            if (TbadkApplication.getInst().isNeedNewUserLead() && TbadkApplication.getInst().getIsFirstUse()) {
                sendMessage(new CustomMessage(2921454, new IntentConfig(this)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
        }
        if ((!TbadkApplication.getInst().isNeedNewUserLead() || !TbadkApplication.getInst().getIsFirstUse()) && this.lpY != null) {
            this.lpY.h(this.lpS);
        }
        Fragment djL = djL();
        if (djL instanceof com.baidu.tieba.pb.videopb.b) {
            ((com.baidu.tieba.pb.videopb.b) djL).finish();
        } else {
            super.finish();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        Fragment djL = djL();
        if (djL instanceof PbFragment) {
            ((PbFragment) djL).onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Fragment djL = djL();
        if (djL instanceof PbFragment) {
            if (((PbFragment) djL).onKeyDown(i, keyEvent)) {
                return true;
            }
        } else if ((djL instanceof VideoPbFragment) && ((VideoPbFragment) djL).onKeyDown(i, keyEvent)) {
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
        if (this.lpS != null) {
            this.lpS.aC(bundle);
        }
        if (this.iHo != null) {
            this.iHo.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.iHo != null) {
            this.iHo.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.iHo != null) {
            this.iHo.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.lpS != null) {
            as.dmS().aX(this.lpS.dlu(), this.lpS.getIsFromMark());
        }
        if (this.iHo != null) {
            this.iHo.onResume(getPageContext());
        }
        if (this.bes instanceof BaseFragment) {
            ((BaseFragment) this.bes).setPrimary(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.iHo != null) {
            this.iHo.onStop(getPageContext());
        }
        if (this.bes instanceof BaseFragment) {
            ((BaseFragment) this.bes).setPrimary(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iHo != null) {
            this.iHo.onDestory(getPageContext());
        }
        if (this.iIe != null) {
            this.iIe.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        return 0L;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a djp() {
        return this.lpU;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean djq() {
        if (this.lpS == null) {
            return false;
        }
        return this.lpS.djq();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String djr() {
        if (this.lpS != null) {
            return this.lpS.djr();
        }
        return null;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int djs() {
        if (this.lpS == null || this.lpS.getPbData() == null) {
            return 0;
        }
        return this.lpS.getPbData().diz();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean Pu(String str) {
        return this.lpS != null && this.lpS.PG(str);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.PB;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            if (this.lpS != null) {
                if (this.lpS.getPbData() != null) {
                    pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.lpS.getPbData().getForumId(), 0L));
                }
                pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.lpS.dlx(), 0L));
                if (this.lpS.getPbData() != null && this.lpS.getPbData().dik() != null) {
                    pageStayDurationItem.setNid(this.lpS.getPbData().dik().getNid());
                }
            }
            if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.Ek(TbadkCoreApplication.getInst().getAdAdSense().fcx);
            }
            Fragment djL = djL();
            if (djL instanceof PbFragment) {
                if (((PbFragment) djL).lut == 2) {
                    pageStayDurationItem.El(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                } else if (((PbFragment) djL).lut == 1) {
                    pageStayDurationItem.El(PageStayDurationConstants.PageName.HOMEPAGE_CONCERN);
                } else if (((PbFragment) djL).lut == 3) {
                    pageStayDurationItem.El(PageStayDurationConstants.PageName.FRS);
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
        if (this.lpS != null) {
            this.lpT.setIsLoading(true);
            showLoadingView(this.mRootView);
            this.lpS.dlK();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.iHo;
    }

    public void cyK() {
        if (this.iHo != null) {
            this.iHo.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected boolean shouldChangeStatusBarIconAndTextColor() {
        return !(this.bes instanceof VideoPbFragment);
    }

    public View getRootView() {
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        Fragment djL = djL();
        if (djL instanceof VideoPbFragment) {
            ((VideoPbFragment) djL).onKeyboardVisibilityChanged(z);
        }
    }
}
