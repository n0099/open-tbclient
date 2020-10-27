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
    private Fragment bcY;
    private VoiceManager iBr;
    private com.baidu.tieba.NEGFeedBack.a iCh;
    private PbModel ljR;
    private com.baidu.tieba.pb.videopb.e ljS;
    private boolean ljV;
    private com.baidu.tieba.pb.pb.main.a ljW;
    private aw ljX;
    private View mRootView;
    public final com.baidu.tieba.pb.pb.main.b.a ljT = new com.baidu.tieba.pb.pb.main.b.a(this);
    public final com.baidu.tieba.pb.pb.main.b.c ljU = new com.baidu.tieba.pb.pb.main.b.c(getPageContext());
    private boolean mIsFromSchema = false;

    /* loaded from: classes22.dex */
    public static class a {
        public ConcurrentHashMap<String, ImageUrlData> erD;
        public ArrayList<String> ljZ;
        public boolean lka;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public String postId = null;
        public boolean erB = false;
        public boolean lkb = false;
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
        dhi();
        initData(bundle);
        this.iBr = new VoiceManager();
        this.iBr.onCreate(getPageContext());
        this.ljW = new com.baidu.tieba.pb.pb.main.a(getPageContext());
        this.ljX = new aw(getPageContext());
        this.iCh = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "client_pb_live");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.bcY instanceof VideoPbFragment) {
            ((VideoPbFragment) this.bcY).onWindowFocusChanged(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i == 0) {
            if ((this.bcY instanceof PbFragment) && ((PbFragment) this.bcY).dhI() != null) {
                ((PbFragment) this.bcY).dhI().bxH();
                return;
            } else if ((this.bcY instanceof VideoPbFragment) && ((VideoPbFragment) this.bcY).dhI() != null) {
                ((VideoPbFragment) this.bcY).dhI().bxH();
                return;
            } else {
                return;
            }
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    private void dhi() {
        this.ljS = (com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(this).l(com.baidu.tieba.pb.videopb.e.class);
        this.ljS.init(getIntent());
    }

    private void aA(Bundle bundle) {
        this.ljR = new PbModel(this);
        if (bundle != null) {
            this.ljR.initWithBundle(bundle);
            return;
        }
        this.ljR.initWithIntent(getIntent());
    }

    private void initData(Bundle bundle) {
        this.ljS.i(this.ljR);
        as.dkq().aX(this.ljR.diS(), this.ljR.getIsFromMark());
        this.ljR.a(new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
                PbActivity.this.ljS.setIsLoading(false);
                PbActivity.this.hideLoadingView(PbActivity.this.mRootView);
                if (!z) {
                    if (!PbActivity.this.ljV && !PbActivity.this.ljR.diR()) {
                        PbActivity.this.showNetRefreshView(PbActivity.this.mRootView, PbActivity.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                        PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbActivity.this.getActivity(), R.dimen.ds360));
                    }
                } else if (fVar != null) {
                    PbActivity.this.hideNetRefreshView(PbActivity.this.mRootView);
                }
                Fragment dhj = PbActivity.this.dhj();
                if (dhj == null) {
                    if (z) {
                        PbActivity.this.ljS.b(fVar, 3);
                        if (PbActivity.this.bcY == null) {
                            PbActivity.this.c(fVar);
                        }
                    }
                } else if ((dhj instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) dhj).dia() != null) {
                    ((com.baidu.tieba.pb.videopb.b) dhj).dia().a(z, i, i2, i3, fVar, str, i4);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void e(com.baidu.tieba.pb.data.f fVar) {
                Fragment dhj = PbActivity.this.dhj();
                if ((dhj instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) dhj).dia() != null) {
                    ((com.baidu.tieba.pb.videopb.b) dhj).dia().e(fVar);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
                Fragment dhj = PbActivity.this.dhj();
                if ((dhj instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) dhj).dia() != null) {
                    ((com.baidu.tieba.pb.videopb.b) dhj).dia().a(i, z, responsedMessage, z2, j);
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
                        PbActivity.this.ljV = false;
                        return;
                    }
                    PbActivity.this.ljV = true;
                    PbActivity.this.ljS.setIsLoading(false);
                    Fragment dhj = PbActivity.this.dhj();
                    if (dhj == null) {
                        PbActivity.this.ljS.b(pbData, 2);
                        if (PbActivity.this.bcY == null) {
                            PbActivity.this.c(pbData);
                        }
                    } else if (dhj instanceof PbFragment) {
                        PbActivity.this.ljR.a(pbData, pbPageReadLocalResponseMessage.getUpdateType(), pbPageReadLocalResponseMessage.getErrorString());
                    }
                }
            }
        });
        this.ljR.dji();
        if (this.ljR.diR()) {
            com.baidu.tieba.pb.data.f aI = this.ljR.aI(com.baidu.tieba.frs.l.cvy());
            if (aI != null) {
                aI.Fp(3);
                if (dhj() == null) {
                    this.ljS.b(aI, 1);
                    if (this.bcY == null) {
                        c(aI);
                    }
                }
            }
            this.ljS.setIsLoading(false);
        } else {
            showLoadingView(findViewById(R.id.container), true);
            this.ljS.setIsLoading(true);
        }
        if (com.baidu.adp.lib.util.l.isNetOk() && !TbadkCoreApplication.getInst().syncHasFinish) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        }
    }

    public Fragment dhj() {
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
            this.bcY = Pe(d);
            supportFragmentManager.beginTransaction().add(R.id.container, this.bcY, d).commitAllowingStateLoss();
        }
    }

    private String d(com.baidu.tieba.pb.data.f fVar) {
        return (fVar == null || !fVar.dgi()) ? "pb_fragment_tag" : "video_pb_fragment_tag";
    }

    private Fragment Pe(String str) {
        return "video_pb_fragment_tag".equals(str) ? VideoPbFragment.dog() : PbFragment.dhJ();
    }

    public PbModel dgX() {
        return this.ljR;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        Fragment dhj = dhj();
        if (dhj instanceof BaseFragment) {
            ((BaseFragment) dhj).onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Fragment dhj = dhj();
        if (dhj != null) {
            dhj.onActivityResult(i, i2, intent);
        }
    }

    public void dhk() {
        super.finish();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.ljW != null && !this.ljW.a(this.ljR) && this.mIsFromSchema) {
            if (TbadkApplication.getInst().isNeedNewUserLead() && TbadkApplication.getInst().getIsFirstUse()) {
                sendMessage(new CustomMessage(2921454, new IntentConfig(this)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
        }
        if ((!TbadkApplication.getInst().isNeedNewUserLead() || !TbadkApplication.getInst().getIsFirstUse()) && this.ljX != null) {
            this.ljX.h(this.ljR);
        }
        Fragment dhj = dhj();
        if (dhj instanceof com.baidu.tieba.pb.videopb.b) {
            ((com.baidu.tieba.pb.videopb.b) dhj).finish();
        } else {
            super.finish();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        Fragment dhj = dhj();
        if (dhj instanceof PbFragment) {
            ((PbFragment) dhj).onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Fragment dhj = dhj();
        if (dhj instanceof PbFragment) {
            if (((PbFragment) dhj).onKeyDown(i, keyEvent)) {
                return true;
            }
        } else if ((dhj instanceof VideoPbFragment) && ((VideoPbFragment) dhj).onKeyDown(i, keyEvent)) {
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
        if (this.ljR != null) {
            this.ljR.aC(bundle);
        }
        if (this.iBr != null) {
            this.iBr.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.iBr != null) {
            this.iBr.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.iBr != null) {
            this.iBr.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.ljR != null) {
            as.dkq().aX(this.ljR.diS(), this.ljR.getIsFromMark());
        }
        if (this.iBr != null) {
            this.iBr.onResume(getPageContext());
        }
        if (this.bcY instanceof BaseFragment) {
            ((BaseFragment) this.bcY).setPrimary(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.iBr != null) {
            this.iBr.onStop(getPageContext());
        }
        if (this.bcY instanceof BaseFragment) {
            ((BaseFragment) this.bcY).setPrimary(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iBr != null) {
            this.iBr.onDestory(getPageContext());
        }
        if (this.iCh != null) {
            this.iCh.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        return 0L;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a dgN() {
        return this.ljT;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean dgO() {
        if (this.ljR == null) {
            return false;
        }
        return this.ljR.dgO();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String dgP() {
        if (this.ljR != null) {
            return this.ljR.dgP();
        }
        return null;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int dgQ() {
        if (this.ljR == null || this.ljR.getPbData() == null) {
            return 0;
        }
        return this.ljR.getPbData().dfX();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean Pd(String str) {
        return this.ljR != null && this.ljR.Pp(str);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.PB;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            if (this.ljR != null) {
                if (this.ljR.getPbData() != null) {
                    pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.ljR.getPbData().getForumId(), 0L));
                }
                pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.ljR.diV(), 0L));
                if (this.ljR.getPbData() != null && this.ljR.getPbData().dfI() != null) {
                    pageStayDurationItem.setNid(this.ljR.getPbData().dfI().getNid());
                }
            }
            if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.DW(TbadkCoreApplication.getInst().getAdAdSense().eWH);
            }
            Fragment dhj = dhj();
            if (dhj instanceof PbFragment) {
                if (((PbFragment) dhj).lov == 2) {
                    pageStayDurationItem.DX(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                } else if (((PbFragment) dhj).lov == 1) {
                    pageStayDurationItem.DX(PageStayDurationConstants.PageName.HOMEPAGE_CONCERN);
                } else if (((PbFragment) dhj).lov == 3) {
                    pageStayDurationItem.DX(PageStayDurationConstants.PageName.FRS);
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
        if (this.ljR != null) {
            this.ljS.setIsLoading(true);
            showLoadingView(this.mRootView);
            this.ljR.dji();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.iBr;
    }

    public void cwj() {
        if (this.iBr != null) {
            this.iBr.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected boolean shouldChangeStatusBarIconAndTextColor() {
        return !(this.bcY instanceof VideoPbFragment);
    }

    public View getRootView() {
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        Fragment dhj = dhj();
        if (dhj instanceof VideoPbFragment) {
            ((VideoPbFragment) dhj).onKeyboardVisibilityChanged(z);
        }
    }
}
