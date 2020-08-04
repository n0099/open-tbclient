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
    private Fragment aQG;
    private VoiceManager hFy;
    private com.baidu.tieba.NEGFeedBack.a hGo;
    private PbModel kkl;
    private com.baidu.tieba.pb.videopb.e kkm;
    private boolean kkp;
    private com.baidu.tieba.pb.pb.main.a kkq;
    private aw kkr;
    private View mRootView;
    public final com.baidu.tieba.pb.pb.main.b.a kkn = new com.baidu.tieba.pb.pb.main.b.a(this);
    public final com.baidu.tieba.pb.pb.main.b.c kko = new com.baidu.tieba.pb.pb.main.b.c(getPageContext());
    private boolean mIsFromSchema = false;

    /* loaded from: classes16.dex */
    public static class a {
        public ConcurrentHashMap<String, ImageUrlData> dLG;
        public ArrayList<String> kkt;
        public boolean kku;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public String postId = null;
        public boolean dLE = false;
        public boolean kkv = false;
        public String lastId = "";
        public int index = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        initUniqueId();
        aB(bundle);
        if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !com.baidu.adp.base.a.jC().bj("MainTabActivity")) {
            this.mIsFromSchema = true;
            int loadInt = TbadkSettings.getInst().loadInt(SharedPrefConfig.PREFS_SKIN_TYPE, 0);
            if (loadInt != 1) {
                com.baidu.tbadk.core.util.ao.z(false, true);
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
        cMa();
        initData(bundle);
        this.hFy = new VoiceManager();
        this.hFy.onCreate(getPageContext());
        this.kkq = new com.baidu.tieba.pb.pb.main.a(getPageContext());
        this.kkr = new aw(getPageContext());
        this.hGo = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "client_pb_live");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.aQG instanceof VideoPbFragment) {
            ((VideoPbFragment) this.aQG).onWindowFocusChanged(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i == 0) {
            if ((this.aQG instanceof PbFragment) && ((PbFragment) this.aQG).cMA() != null) {
                ((PbFragment) this.aQG).cMA().bjn();
                return;
            } else if ((this.aQG instanceof VideoPbFragment) && ((VideoPbFragment) this.aQG).cMA() != null) {
                ((VideoPbFragment) this.aQG).cMA().bjn();
                return;
            } else {
                return;
            }
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    private void cMa() {
        this.kkm = (com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(this).l(com.baidu.tieba.pb.videopb.e.class);
        this.kkm.init(getIntent());
    }

    private void aB(Bundle bundle) {
        this.kkl = new PbModel(this);
        if (bundle != null) {
            this.kkl.initWithBundle(bundle);
            return;
        }
        this.kkl.initWithIntent(getIntent());
    }

    private void initData(Bundle bundle) {
        this.kkm.i(this.kkl);
        as.cPg().aN(this.kkl.cNI(), this.kkl.getIsFromMark());
        this.kkl.a(new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
                PbActivity.this.kkm.setIsLoading(false);
                PbActivity.this.hideLoadingView(PbActivity.this.mRootView);
                if (!z) {
                    if (!PbActivity.this.kkp && !PbActivity.this.kkl.cNH()) {
                        PbActivity.this.showNetRefreshView(PbActivity.this.mRootView, PbActivity.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                        PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbActivity.this.getActivity(), R.dimen.ds360));
                    }
                } else if (fVar != null) {
                    PbActivity.this.hideNetRefreshView(PbActivity.this.mRootView);
                }
                Fragment cMb = PbActivity.this.cMb();
                if (cMb == null) {
                    if (z) {
                        PbActivity.this.kkm.b(fVar, 3);
                        if (PbActivity.this.aQG == null) {
                            PbActivity.this.c(fVar);
                        }
                    }
                } else if ((cMb instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) cMb).cMS() != null) {
                    ((com.baidu.tieba.pb.videopb.b) cMb).cMS().a(z, i, i2, i3, fVar, str, i4);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void e(com.baidu.tieba.pb.data.f fVar) {
                Fragment cMb = PbActivity.this.cMb();
                if ((cMb instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) cMb).cMS() != null) {
                    ((com.baidu.tieba.pb.videopb.b) cMb).cMS().e(fVar);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
                Fragment cMb = PbActivity.this.cMb();
                if ((cMb instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) cMb).cMS() != null) {
                    ((com.baidu.tieba.pb.videopb.b) cMb).cMS().a(i, z, responsedMessage, z2, j);
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
                        PbActivity.this.kkp = false;
                        return;
                    }
                    PbActivity.this.kkp = true;
                    PbActivity.this.kkm.setIsLoading(false);
                    Fragment cMb = PbActivity.this.cMb();
                    if (cMb == null) {
                        PbActivity.this.kkm.b(pbData, 2);
                        if (PbActivity.this.aQG == null) {
                            PbActivity.this.c(pbData);
                        }
                    } else if (cMb instanceof PbFragment) {
                        PbActivity.this.kkl.a(pbData, pbPageReadLocalResponseMessage.getUpdateType(), pbPageReadLocalResponseMessage.getErrorString());
                    }
                }
            }
        });
        this.kkl.cNY();
        if (this.kkl.cNH()) {
            com.baidu.tieba.pb.data.f aG = this.kkl.aG(com.baidu.tieba.frs.k.cbk());
            if (aG != null) {
                aG.Bw(3);
                if (cMb() == null) {
                    this.kkm.b(aG, 1);
                    if (this.aQG == null) {
                        c(aG);
                    }
                }
            }
            this.kkm.setIsLoading(false);
        } else {
            showLoadingView(findViewById(R.id.container), true);
            this.kkm.setIsLoading(true);
        }
        if (com.baidu.adp.lib.util.l.isNetOk() && !TbadkCoreApplication.getInst().syncHasFinish) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        }
    }

    public Fragment cMb() {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (com.baidu.tbadk.core.util.x.isEmpty(fragments)) {
            return null;
        }
        return fragments.get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.pb.data.f fVar) {
        String d = d(fVar);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager.findFragmentByTag(d) == null) {
            this.aQG = Kw(d);
            supportFragmentManager.beginTransaction().add(R.id.container, this.aQG, d).commitAllowingStateLoss();
        }
    }

    private String d(com.baidu.tieba.pb.data.f fVar) {
        return (fVar == null || !fVar.cKX()) ? "pb_fragment_tag" : "video_pb_fragment_tag";
    }

    private Fragment Kw(String str) {
        return "video_pb_fragment_tag".equals(str) ? VideoPbFragment.cSS() : PbFragment.cMB();
    }

    public PbModel cLP() {
        return this.kkl;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        Fragment cMb = cMb();
        if (cMb instanceof BaseFragment) {
            ((BaseFragment) cMb).onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Fragment cMb = cMb();
        if (cMb != null) {
            cMb.onActivityResult(i, i2, intent);
        }
    }

    public void cMc() {
        super.finish();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (!this.kkq.a(this.kkl) && this.mIsFromSchema) {
            if (TbadkApplication.getInst().isNeedNewUserLead() && TbadkApplication.getInst().getIsFirstUse()) {
                sendMessage(new CustomMessage(2921454, new IntentConfig(this)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
        }
        if (!TbadkApplication.getInst().isNeedNewUserLead() || !TbadkApplication.getInst().getIsFirstUse()) {
            this.kkr.h(this.kkl);
        }
        Fragment cMb = cMb();
        if (cMb instanceof com.baidu.tieba.pb.videopb.b) {
            ((com.baidu.tieba.pb.videopb.b) cMb).finish();
        } else {
            super.finish();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        Fragment cMb = cMb();
        if (cMb instanceof PbFragment) {
            ((PbFragment) cMb).onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Fragment cMb = cMb();
        if (cMb instanceof PbFragment) {
            if (((PbFragment) cMb).onKeyDown(i, keyEvent)) {
                return true;
            }
        } else if ((cMb instanceof VideoPbFragment) && ((VideoPbFragment) cMb).onKeyDown(i, keyEvent)) {
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
        if (this.kkl != null) {
            this.kkl.aD(bundle);
        }
        if (this.hFy != null) {
            this.hFy.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.hFy != null) {
            this.hFy.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hFy != null) {
            this.hFy.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hFy != null) {
            this.hFy.onResume(getPageContext());
        }
        if (this.aQG instanceof BaseFragment) {
            ((BaseFragment) this.aQG).setPrimary(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hFy != null) {
            this.hFy.onStop(getPageContext());
        }
        if (this.aQG instanceof BaseFragment) {
            ((BaseFragment) this.aQG).setPrimary(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hFy != null) {
            this.hFy.onDestory(getPageContext());
        }
        if (this.hGo != null) {
            this.hGo.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        return 0L;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a cLE() {
        return this.kkn;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean cLF() {
        if (this.kkl == null) {
            return false;
        }
        return this.kkl.cLF();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String cLG() {
        if (this.kkl != null) {
            return this.kkl.cLG();
        }
        return null;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int cLH() {
        if (this.kkl == null || this.kkl.getPbData() == null) {
            return 0;
        }
        return this.kkl.getPbData().cKM();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean Kv(String str) {
        return this.kkl != null && this.kkl.KH(str);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.PB;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            if (this.kkl != null) {
                if (this.kkl.getPbData() != null) {
                    pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.kkl.getPbData().getForumId(), 0L));
                }
                pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.kkl.cNL(), 0L));
                if (this.kkl.getPbData() != null && this.kkl.getPbData().cKx() != null) {
                    pageStayDurationItem.setNid(this.kkl.getPbData().cKx().getNid());
                }
            }
            if (!com.baidu.tbadk.core.util.as.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.Ae(TbadkCoreApplication.getInst().getAdAdSense().epK);
            }
            Fragment cMb = cMb();
            if (cMb instanceof PbFragment) {
                if (((PbFragment) cMb).koK == 2) {
                    pageStayDurationItem.Af(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                } else if (((PbFragment) cMb).koK == 1) {
                    pageStayDurationItem.Af(PageStayDurationConstants.PageName.HOMEPAGE_CONCERN);
                } else if (((PbFragment) cMb).koK == 3) {
                    pageStayDurationItem.Af(PageStayDurationConstants.PageName.FRS);
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
        if (this.kkl != null) {
            this.kkm.setIsLoading(true);
            showLoadingView(this.mRootView);
            this.kkl.cNY();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.hFy;
    }

    public void cbU() {
        if (this.hFy != null) {
            this.hFy.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected boolean shouldChangeStatusBarIconAndTextColor() {
        return !(this.aQG instanceof VideoPbFragment);
    }

    public View getRootView() {
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        Fragment cMb = cMb();
        if (cMb instanceof VideoPbFragment) {
            ((VideoPbFragment) cMb).onKeyboardVisibilityChanged(z);
        }
    }
}
