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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.mutiprocess.prePageKey.PrePageKeyEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes22.dex */
public class PbActivity extends BaseFragmentActivity implements VoiceManager.c, com.baidu.tieba.pb.pb.a<PbActivity> {
    private Fragment bgG;
    private VoiceManager iSW;
    private com.baidu.tieba.NEGFeedBack.a iTL;
    private PbModel lDS;
    private com.baidu.tieba.pb.videopb.e lDT;
    private boolean lDW;
    private com.baidu.tieba.pb.pb.main.a lDX;
    private aw lDY;
    private View mRootView;
    public final com.baidu.tieba.pb.pb.main.b.a lDU = new com.baidu.tieba.pb.pb.main.b.a(this);
    public final com.baidu.tieba.pb.pb.main.b.c lDV = new com.baidu.tieba.pb.pb.main.b.c(getPageContext());
    private boolean mIsFromSchema = false;

    /* loaded from: classes22.dex */
    public static class a {
        public ConcurrentHashMap<String, ImageUrlData> eCN;
        public ArrayList<String> lEa;
        public boolean lEb;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public String postId = null;
        public boolean eCL = false;
        public boolean lEc = false;
        public String lastId = "";
        public int index = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        initUniqueId();
        aB(bundle);
        if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !com.baidu.adp.base.a.lg().bt("MainTabActivity")) {
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
        dow();
        initData(bundle);
        this.iSW = new VoiceManager();
        this.iSW.onCreate(getPageContext());
        this.lDX = new com.baidu.tieba.pb.pb.main.a(getPageContext());
        this.lDY = new aw(getPageContext());
        this.iTL = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "client_pb_live");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.bgG instanceof VideoPbFragment) {
            ((VideoPbFragment) this.bgG).onWindowFocusChanged(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i == 0) {
            if ((this.bgG instanceof PbFragment) && ((PbFragment) this.bgG).doX() != null) {
                ((PbFragment) this.bgG).doX().bCW();
                return;
            } else if ((this.bgG instanceof VideoPbFragment) && ((VideoPbFragment) this.bgG).doX() != null) {
                ((VideoPbFragment) this.bgG).doX().bCW();
                return;
            } else {
                return;
            }
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    private void dow() {
        this.lDT = (com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(this).l(com.baidu.tieba.pb.videopb.e.class);
        this.lDT.init(getIntent());
    }

    private void aB(Bundle bundle) {
        this.lDS = new PbModel(this);
        if (bundle != null) {
            this.lDS.initWithBundle(bundle);
            return;
        }
        this.lDS.initWithIntent(getIntent());
    }

    private void initData(Bundle bundle) {
        this.lDT.i(this.lDS);
        as.drJ().aY(this.lDS.dqh(), this.lDS.getIsFromMark());
        this.lDS.a(new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
                PbActivity.this.lDT.setIsLoading(false);
                PbActivity.this.hideLoadingView(PbActivity.this.mRootView);
                if (!z) {
                    if (!PbActivity.this.lDW && !PbActivity.this.lDS.dqg()) {
                        PbActivity.this.showNetRefreshView(PbActivity.this.mRootView, PbActivity.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                        PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbActivity.this.getActivity(), R.dimen.ds360));
                    }
                } else if (fVar != null) {
                    PbActivity.this.hideNetRefreshView(PbActivity.this.mRootView);
                }
                Fragment dox = PbActivity.this.dox();
                if (dox == null) {
                    if (z) {
                        PbActivity.this.lDT.b(fVar, 3);
                        if (PbActivity.this.bgG == null) {
                            PbActivity.this.c(fVar);
                        }
                    }
                } else if ((dox instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) dox).dpp() != null) {
                    ((com.baidu.tieba.pb.videopb.b) dox).dpp().a(z, i, i2, i3, fVar, str, i4);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void e(com.baidu.tieba.pb.data.f fVar) {
                Fragment dox = PbActivity.this.dox();
                if ((dox instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) dox).dpp() != null) {
                    ((com.baidu.tieba.pb.videopb.b) dox).dpp().e(fVar);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
                Fragment dox = PbActivity.this.dox();
                if ((dox instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) dox).dpp() != null) {
                    ((com.baidu.tieba.pb.videopb.b) dox).dpp().a(i, z, responsedMessage, z2, j);
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
                        PbActivity.this.lDW = false;
                        return;
                    }
                    PbActivity.this.lDW = true;
                    PbActivity.this.lDT.setIsLoading(false);
                    Fragment dox = PbActivity.this.dox();
                    if (dox == null) {
                        PbActivity.this.lDT.b(pbData, 2);
                        if (PbActivity.this.bgG == null) {
                            PbActivity.this.c(pbData);
                        }
                    } else if (dox instanceof PbFragment) {
                        PbActivity.this.lDS.a(pbData, pbPageReadLocalResponseMessage.getUpdateType(), pbPageReadLocalResponseMessage.getErrorString());
                    }
                }
            }
        });
        this.lDS.dqy();
        if (this.lDS.dqg()) {
            com.baidu.tieba.pb.data.f aK = this.lDS.aK(com.baidu.tieba.frs.l.cBT());
            if (aK != null) {
                aK.GP(3);
                if (dox() == null) {
                    this.lDT.b(aK, 1);
                    if (this.bgG == null) {
                        c(aK);
                    }
                }
            }
            this.lDT.setIsLoading(false);
        } else {
            showLoadingView(findViewById(R.id.container), true);
            this.lDT.setIsLoading(true);
        }
        if (com.baidu.adp.lib.util.l.isNetOk() && !TbadkCoreApplication.getInst().syncHasFinish) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        }
    }

    public Fragment dox() {
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
            this.bgG = PZ(d);
            supportFragmentManager.beginTransaction().add(R.id.container, this.bgG, d).commitAllowingStateLoss();
        }
    }

    private String d(com.baidu.tieba.pb.data.f fVar) {
        return (fVar == null || !fVar.dnv()) ? "pb_fragment_tag" : "video_pb_fragment_tag";
    }

    private Fragment PZ(String str) {
        return "video_pb_fragment_tag".equals(str) ? VideoPbFragment.dvC() : PbFragment.doY();
    }

    public PbModel dol() {
        return this.lDS;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        Fragment dox = dox();
        if (dox instanceof BaseFragment) {
            ((BaseFragment) dox).onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Fragment dox = dox();
        if (dox != null) {
            dox.onActivityResult(i, i2, intent);
        }
    }

    public void doy() {
        super.finish();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.lDX != null && !this.lDX.a(this.lDS) && this.mIsFromSchema) {
            if (TbadkApplication.getInst().isNeedNewUserLead() && TbadkApplication.getInst().getIsFirstUse()) {
                sendMessage(new CustomMessage(2921454, new IntentConfig(this)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
        }
        if ((!TbadkApplication.getInst().isNeedNewUserLead() || !TbadkApplication.getInst().getIsFirstUse()) && this.lDY != null) {
            this.lDY.h(this.lDS);
        }
        Fragment dox = dox();
        if (dox instanceof com.baidu.tieba.pb.videopb.b) {
            ((com.baidu.tieba.pb.videopb.b) dox).finish();
        } else {
            super.finish();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        Fragment dox = dox();
        if (dox instanceof PbFragment) {
            ((PbFragment) dox).onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Fragment dox = dox();
        if (dox instanceof PbFragment) {
            if (((PbFragment) dox).onKeyDown(i, keyEvent)) {
                return true;
            }
        } else if ((dox instanceof VideoPbFragment) && ((VideoPbFragment) dox).onKeyDown(i, keyEvent)) {
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
        if (this.lDS != null) {
            this.lDS.aD(bundle);
        }
        if (this.iSW != null) {
            this.iSW.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.iSW != null) {
            this.iSW.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.iSW != null) {
            this.iSW.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.lDS != null) {
            as.drJ().aY(this.lDS.dqh(), this.lDS.getIsFromMark());
        }
        if (this.iSW != null) {
            this.iSW.onResume(getPageContext());
        }
        if (this.bgG instanceof BaseFragment) {
            ((BaseFragment) this.bgG).setPrimary(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.iSW != null) {
            this.iSW.onStop(getPageContext());
        }
        if (this.bgG instanceof BaseFragment) {
            ((BaseFragment) this.bgG).setPrimary(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iSW != null) {
            this.iSW.onDestory(getPageContext());
        }
        if (this.iTL != null) {
            this.iTL.onDestroy();
        }
        com.baidu.tbadk.pageExtra.d.En(getCurrentPageKey());
        com.baidu.tbadk.mutiprocess.g.publishEvent(new PrePageKeyEvent(getCurrentPageKey()));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        return 0L;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a doc() {
        return this.lDU;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean dod() {
        if (this.lDS == null) {
            return false;
        }
        return this.lDS.dod();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String doe() {
        if (this.lDS != null) {
            return this.lDS.doe();
        }
        return null;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int dof() {
        if (this.lDS == null || this.lDS.getPbData() == null) {
            return 0;
        }
        return this.lDS.getPbData().dnj();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean PY(String str) {
        return this.lDS != null && this.lDS.Qk(str);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.PB;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            if (this.lDS != null) {
                if (this.lDS.getPbData() != null) {
                    pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.lDS.getPbData().getForumId(), 0L));
                }
                pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.lDS.dqk(), 0L));
                if (this.lDS.getPbData() != null && this.lDS.getPbData().dmU() != null) {
                    pageStayDurationItem.setNid(this.lDS.getPbData().dmU().getNid());
                }
            }
            if (!com.baidu.tbadk.core.util.au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.Eu(TbadkCoreApplication.getInst().getAdAdSense().fje);
            }
            Fragment dox = dox();
            if (dox instanceof PbFragment) {
                if (((PbFragment) dox).lIy == 2) {
                    pageStayDurationItem.Ev(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                } else if (((PbFragment) dox).lIy == 1) {
                    pageStayDurationItem.Ev(PageStayDurationConstants.PageName.HOMEPAGE_CONCERN);
                } else if (((PbFragment) dox).lIy == 3) {
                    pageStayDurationItem.Ev(PageStayDurationConstants.PageName.FRS);
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
        if (this.lDS != null) {
            this.lDT.setIsLoading(true);
            showLoadingView(this.mRootView);
            this.lDS.dqy();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.iSW;
    }

    public void cCF() {
        if (this.iSW != null) {
            this.iSW.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected boolean shouldChangeStatusBarIconAndTextColor() {
        return !(this.bgG instanceof VideoPbFragment);
    }

    public View getRootView() {
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        Fragment dox = dox();
        if (dox instanceof VideoPbFragment) {
            ((VideoPbFragment) dox).onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onScreenShot(String str) {
        super.onScreenShot(str);
        if (this.lDS != null && this.lDS.getPbData() != null) {
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13848");
            arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.dY("tid", this.lDS.dqk());
            arVar.dY("fid", this.lDS.getPbData().getForumId());
            arVar.al("obj_type", 3);
            TiebaStatic.log(arVar);
        }
    }
}
