package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.os.Bundle;
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
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbadkApplication;
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
    private Fragment aMH;
    private VoiceManager hnh;
    private PbModel jGP;
    private com.baidu.tieba.pb.videopb.e jGQ;
    private boolean jGT;
    private com.baidu.tieba.pb.pb.main.a jGU;
    private as jGV;
    private View mRootView;
    public final com.baidu.tieba.pb.pb.main.b.a jGR = new com.baidu.tieba.pb.pb.main.b.a(this);
    public final com.baidu.tieba.pb.pb.main.b.c jGS = new com.baidu.tieba.pb.pb.main.b.c(getPageContext());
    private boolean mIsFromSchema = false;

    /* loaded from: classes9.dex */
    public static class a {
        public ArrayList<String> jGX;
        public ConcurrentHashMap<String, ImageUrlData> jGY;
        public boolean jHa;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public String postId = null;
        public boolean jGZ = false;
        public boolean jHb = false;
        public String lastId = "";
        public int index = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        initUniqueId();
        ay(bundle);
        if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !com.baidu.adp.base.a.jm().bi("MainTabActivity")) {
            this.mIsFromSchema = true;
        }
        if (this.mIsFromSchema) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        setContentView(R.layout.pb_layout);
        this.mRootView = findViewById(R.id.container);
        adjustResizeForSoftInput();
        addGlobalLayoutListener();
        cDJ();
        initData(bundle);
        this.hnh = new VoiceManager();
        this.hnh.onCreate(getPageContext());
        this.jGU = new com.baidu.tieba.pb.pb.main.a(getPageContext());
        this.jGV = new as(getPageContext());
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.aMH instanceof VideoPbFragment) {
            ((VideoPbFragment) this.aMH).onWindowFocusChanged(z);
        }
    }

    private void cDJ() {
        this.jGQ = (com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(this).l(com.baidu.tieba.pb.videopb.e.class);
        this.jGQ.init(getIntent());
    }

    private void ay(Bundle bundle) {
        this.jGP = new PbModel(this);
        if (bundle != null) {
            this.jGP.initWithBundle(bundle);
            return;
        }
        this.jGP.initWithIntent(getIntent());
    }

    private void initData(Bundle bundle) {
        this.jGQ.i(this.jGP);
        ao.cGM().aN(this.jGP.cFq(), this.jGP.getIsFromMark());
        this.jGP.a(new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
                PbActivity.this.jGQ.setIsLoading(false);
                PbActivity.this.hideLoadingView(PbActivity.this.mRootView);
                if (!z) {
                    if (!PbActivity.this.jGT && !PbActivity.this.jGP.cFp()) {
                        PbActivity.this.showNetRefreshView(PbActivity.this.mRootView, PbActivity.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                        PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbActivity.this.getActivity(), R.dimen.ds360));
                    }
                } else if (eVar != null) {
                    PbActivity.this.hideNetRefreshView(PbActivity.this.mRootView);
                }
                Fragment cDK = PbActivity.this.cDK();
                if (cDK == null) {
                    if (z) {
                        PbActivity.this.jGQ.c(eVar, 3);
                        if (PbActivity.this.aMH == null) {
                            PbActivity.this.c(eVar);
                        }
                    }
                } else if ((cDK instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) cDK).cEB() != null) {
                    ((com.baidu.tieba.pb.videopb.b) cDK).cEB().a(z, i, i2, i3, eVar, str, i4);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void e(com.baidu.tieba.pb.data.e eVar) {
                Fragment cDK = PbActivity.this.cDK();
                if ((cDK instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) cDK).cEB() != null) {
                    ((com.baidu.tieba.pb.videopb.b) cDK).cEB().e(eVar);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
                Fragment cDK = PbActivity.this.cDK();
                if ((cDK instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) cDK).cEB() != null) {
                    ((com.baidu.tieba.pb.videopb.b) cDK).cEB().a(i, z, responsedMessage, z2, j);
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
                        PbActivity.this.jGT = false;
                        return;
                    }
                    PbActivity.this.jGT = true;
                    PbActivity.this.jGQ.setIsLoading(false);
                    Fragment cDK = PbActivity.this.cDK();
                    if (cDK == null) {
                        PbActivity.this.jGQ.c(pbData, 2);
                        if (PbActivity.this.aMH == null) {
                            PbActivity.this.c(pbData);
                        }
                    } else if (cDK instanceof PbFragment) {
                        PbActivity.this.jGP.a(pbData, pbPageReadLocalResponseMessage.getUpdateType(), pbPageReadLocalResponseMessage.getErrorString());
                    }
                }
            }
        });
        this.jGP.cFG();
        if (this.jGP.cFp()) {
            com.baidu.tieba.pb.data.e aI = this.jGP.aI(com.baidu.tieba.frs.i.bUF());
            if (aI != null) {
                aI.zT(3);
                if (cDK() == null) {
                    this.jGQ.c(aI, 1);
                    if (this.aMH == null) {
                        c(aI);
                    }
                }
            }
            this.jGQ.setIsLoading(false);
        } else {
            showLoadingView(findViewById(R.id.container), true);
            this.jGQ.setIsLoading(true);
        }
        if (com.baidu.adp.lib.util.l.isNetOk() && !TbadkCoreApplication.getInst().syncHasFinish) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        }
    }

    public Fragment cDK() {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (com.baidu.tbadk.core.util.v.isEmpty(fragments)) {
            return null;
        }
        return fragments.get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.pb.data.e eVar) {
        String d = d(eVar);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager.findFragmentByTag(d) == null) {
            this.aMH = Jh(d);
            supportFragmentManager.beginTransaction().add(R.id.container, this.aMH, d).commitAllowingStateLoss();
        }
    }

    private String d(com.baidu.tieba.pb.data.e eVar) {
        return (eVar == null || !eVar.aWi()) ? "pb_fragment_tag" : "video_pb_fragment_tag";
    }

    private Fragment Jh(String str) {
        return "video_pb_fragment_tag".equals(str) ? VideoPbFragment.cKx() : PbFragment.cEk();
    }

    public PbModel cDy() {
        return this.jGP;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        Fragment cDK = cDK();
        if (cDK instanceof BaseFragment) {
            ((BaseFragment) cDK).onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Fragment cDK = cDK();
        if (cDK != null) {
            cDK.onActivityResult(i, i2, intent);
        }
    }

    public void cDL() {
        super.finish();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (!this.jGU.a(this.jGP) && this.mIsFromSchema) {
            if (TbadkApplication.getInst().isNeedNewUserLead() && TbadkApplication.getInst().getIsFirstUse()) {
                sendMessage(new CustomMessage(2921454, new IntentConfig(this)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
        }
        if (!TbadkApplication.getInst().isNeedNewUserLead() || !TbadkApplication.getInst().getIsFirstUse()) {
            this.jGV.h(this.jGP);
        }
        Fragment cDK = cDK();
        if (cDK instanceof com.baidu.tieba.pb.videopb.b) {
            ((com.baidu.tieba.pb.videopb.b) cDK).finish();
        } else {
            super.finish();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        Fragment cDK = cDK();
        if (cDK instanceof PbFragment) {
            ((PbFragment) cDK).onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Fragment cDK = cDK();
        if (cDK instanceof PbFragment) {
            if (((PbFragment) cDK).onKeyDown(i, keyEvent)) {
                return true;
            }
        } else if ((cDK instanceof VideoPbFragment) && ((VideoPbFragment) cDK).onKeyDown(i, keyEvent)) {
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
        if (this.jGP != null) {
            this.jGP.aA(bundle);
        }
        if (this.hnh != null) {
            this.hnh.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.hnh != null) {
            this.hnh.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hnh != null) {
            this.hnh.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hnh != null) {
            this.hnh.onResume(getPageContext());
        }
        if (this.aMH instanceof BaseFragment) {
            ((BaseFragment) this.aMH).setPrimary(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hnh != null) {
            this.hnh.onStop(getPageContext());
        }
        if (this.aMH instanceof BaseFragment) {
            ((BaseFragment) this.aMH).setPrimary(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hnh != null) {
            this.hnh.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        return 0L;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a cDn() {
        return this.jGR;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean cDo() {
        if (this.jGP == null) {
            return false;
        }
        return this.jGP.cDo();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String cDp() {
        if (this.jGP != null) {
            return this.jGP.cDp();
        }
        return null;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int cDq() {
        if (this.jGP == null || this.jGP.getPbData() == null) {
            return 0;
        }
        return this.jGP.getPbData().cCx();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean Jg(String str) {
        return this.jGP != null && this.jGP.Jr(str);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.PB;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            if (this.jGP != null) {
                if (this.jGP.getPbData() != null) {
                    pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.jGP.getPbData().getForumId(), 0L));
                }
                pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.jGP.cFt(), 0L));
                if (this.jGP.getPbData() != null && this.jGP.getPbData().cCi() != null) {
                    pageStayDurationItem.setNid(this.jGP.getPbData().cCi().getNid());
                }
            }
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.yE(TbadkCoreApplication.getInst().getAdAdSense().eaO);
            }
            Fragment cDK = cDK();
            if (cDK instanceof PbFragment) {
                if (((PbFragment) cDK).jLc == 2) {
                    pageStayDurationItem.yF(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                } else if (((PbFragment) cDK).jLc == 1) {
                    pageStayDurationItem.yF(PageStayDurationConstants.PageName.HOMEPAGE_CONCERN);
                } else if (((PbFragment) cDK).jLc == 3) {
                    pageStayDurationItem.yF(PageStayDurationConstants.PageName.FRS);
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
        if (this.jGP != null) {
            this.jGQ.setIsLoading(true);
            showLoadingView(this.mRootView);
            this.jGP.cFG();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.hnh;
    }

    public void bVn() {
        if (this.hnh != null) {
            this.hnh.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected boolean shouldChangeStatusBarIconAndTextColor() {
        return !(this.aMH instanceof VideoPbFragment);
    }

    public View getRootView() {
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        Fragment cDK = cDK();
        if (cDK instanceof VideoPbFragment) {
            ((VideoPbFragment) cDK).onKeyboardVisibilityChanged(z);
        }
    }
}
