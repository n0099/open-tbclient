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
    private VoiceManager hns;
    private PbModel jHV;
    private com.baidu.tieba.pb.videopb.e jHW;
    private boolean jHZ;
    private com.baidu.tieba.pb.pb.main.a jIa;
    private as jIb;
    private View mRootView;
    public final com.baidu.tieba.pb.pb.main.b.a jHX = new com.baidu.tieba.pb.pb.main.b.a(this);
    public final com.baidu.tieba.pb.pb.main.b.c jHY = new com.baidu.tieba.pb.pb.main.b.c(getPageContext());
    private boolean mIsFromSchema = false;

    /* loaded from: classes9.dex */
    public static class a {
        public ArrayList<String> jId;
        public ConcurrentHashMap<String, ImageUrlData> jIe;
        public boolean jIg;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public String postId = null;
        public boolean jIf = false;
        public boolean jIh = false;
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
        cDZ();
        initData(bundle);
        this.hns = new VoiceManager();
        this.hns.onCreate(getPageContext());
        this.jIa = new com.baidu.tieba.pb.pb.main.a(getPageContext());
        this.jIb = new as(getPageContext());
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.aMH instanceof VideoPbFragment) {
            ((VideoPbFragment) this.aMH).onWindowFocusChanged(z);
        }
    }

    private void cDZ() {
        this.jHW = (com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(this).l(com.baidu.tieba.pb.videopb.e.class);
        this.jHW.init(getIntent());
    }

    private void ay(Bundle bundle) {
        this.jHV = new PbModel(this);
        if (bundle != null) {
            this.jHV.initWithBundle(bundle);
            return;
        }
        this.jHV.initWithIntent(getIntent());
    }

    private void initData(Bundle bundle) {
        this.jHW.i(this.jHV);
        ao.cHc().aN(this.jHV.cFG(), this.jHV.getIsFromMark());
        this.jHV.a(new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
                PbActivity.this.jHW.setIsLoading(false);
                PbActivity.this.hideLoadingView(PbActivity.this.mRootView);
                if (!z) {
                    if (!PbActivity.this.jHZ && !PbActivity.this.jHV.cFF()) {
                        PbActivity.this.showNetRefreshView(PbActivity.this.mRootView, PbActivity.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                        PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbActivity.this.getActivity(), R.dimen.ds360));
                    }
                } else if (eVar != null) {
                    PbActivity.this.hideNetRefreshView(PbActivity.this.mRootView);
                }
                Fragment cEa = PbActivity.this.cEa();
                if (cEa == null) {
                    if (z) {
                        PbActivity.this.jHW.c(eVar, 3);
                        if (PbActivity.this.aMH == null) {
                            PbActivity.this.c(eVar);
                        }
                    }
                } else if ((cEa instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) cEa).cER() != null) {
                    ((com.baidu.tieba.pb.videopb.b) cEa).cER().a(z, i, i2, i3, eVar, str, i4);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void e(com.baidu.tieba.pb.data.e eVar) {
                Fragment cEa = PbActivity.this.cEa();
                if ((cEa instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) cEa).cER() != null) {
                    ((com.baidu.tieba.pb.videopb.b) cEa).cER().e(eVar);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
                Fragment cEa = PbActivity.this.cEa();
                if ((cEa instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) cEa).cER() != null) {
                    ((com.baidu.tieba.pb.videopb.b) cEa).cER().a(i, z, responsedMessage, z2, j);
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
                        PbActivity.this.jHZ = false;
                        return;
                    }
                    PbActivity.this.jHZ = true;
                    PbActivity.this.jHW.setIsLoading(false);
                    Fragment cEa = PbActivity.this.cEa();
                    if (cEa == null) {
                        PbActivity.this.jHW.c(pbData, 2);
                        if (PbActivity.this.aMH == null) {
                            PbActivity.this.c(pbData);
                        }
                    } else if (cEa instanceof PbFragment) {
                        PbActivity.this.jHV.a(pbData, pbPageReadLocalResponseMessage.getUpdateType(), pbPageReadLocalResponseMessage.getErrorString());
                    }
                }
            }
        });
        this.jHV.cFW();
        if (this.jHV.cFF()) {
            com.baidu.tieba.pb.data.e aI = this.jHV.aI(com.baidu.tieba.frs.i.bUH());
            if (aI != null) {
                aI.zV(3);
                if (cEa() == null) {
                    this.jHW.c(aI, 1);
                    if (this.aMH == null) {
                        c(aI);
                    }
                }
            }
            this.jHW.setIsLoading(false);
        } else {
            showLoadingView(findViewById(R.id.container), true);
            this.jHW.setIsLoading(true);
        }
        if (com.baidu.adp.lib.util.l.isNetOk() && !TbadkCoreApplication.getInst().syncHasFinish) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        }
    }

    public Fragment cEa() {
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
            this.aMH = Ji(d);
            supportFragmentManager.beginTransaction().add(R.id.container, this.aMH, d).commitAllowingStateLoss();
        }
    }

    private String d(com.baidu.tieba.pb.data.e eVar) {
        return (eVar == null || !eVar.aWj()) ? "pb_fragment_tag" : "video_pb_fragment_tag";
    }

    private Fragment Ji(String str) {
        return "video_pb_fragment_tag".equals(str) ? VideoPbFragment.cKN() : PbFragment.cEA();
    }

    public PbModel cDO() {
        return this.jHV;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        Fragment cEa = cEa();
        if (cEa instanceof BaseFragment) {
            ((BaseFragment) cEa).onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Fragment cEa = cEa();
        if (cEa != null) {
            cEa.onActivityResult(i, i2, intent);
        }
    }

    public void cEb() {
        super.finish();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (!this.jIa.a(this.jHV) && this.mIsFromSchema) {
            if (TbadkApplication.getInst().isNeedNewUserLead() && TbadkApplication.getInst().getIsFirstUse()) {
                sendMessage(new CustomMessage(2921454, new IntentConfig(this)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
        }
        if (!TbadkApplication.getInst().isNeedNewUserLead() || !TbadkApplication.getInst().getIsFirstUse()) {
            this.jIb.h(this.jHV);
        }
        Fragment cEa = cEa();
        if (cEa instanceof com.baidu.tieba.pb.videopb.b) {
            ((com.baidu.tieba.pb.videopb.b) cEa).finish();
        } else {
            super.finish();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        Fragment cEa = cEa();
        if (cEa instanceof PbFragment) {
            ((PbFragment) cEa).onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Fragment cEa = cEa();
        if (cEa instanceof PbFragment) {
            if (((PbFragment) cEa).onKeyDown(i, keyEvent)) {
                return true;
            }
        } else if ((cEa instanceof VideoPbFragment) && ((VideoPbFragment) cEa).onKeyDown(i, keyEvent)) {
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
        if (this.jHV != null) {
            this.jHV.aA(bundle);
        }
        if (this.hns != null) {
            this.hns.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.hns != null) {
            this.hns.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hns != null) {
            this.hns.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hns != null) {
            this.hns.onResume(getPageContext());
        }
        if (this.aMH instanceof BaseFragment) {
            ((BaseFragment) this.aMH).setPrimary(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hns != null) {
            this.hns.onStop(getPageContext());
        }
        if (this.aMH instanceof BaseFragment) {
            ((BaseFragment) this.aMH).setPrimary(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hns != null) {
            this.hns.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        return 0L;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a cDD() {
        return this.jHX;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean cDE() {
        if (this.jHV == null) {
            return false;
        }
        return this.jHV.cDE();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String cDF() {
        if (this.jHV != null) {
            return this.jHV.cDF();
        }
        return null;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int cDG() {
        if (this.jHV == null || this.jHV.getPbData() == null) {
            return 0;
        }
        return this.jHV.getPbData().cCN();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean Jh(String str) {
        return this.jHV != null && this.jHV.Js(str);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.PB;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            if (this.jHV != null) {
                if (this.jHV.getPbData() != null) {
                    pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.jHV.getPbData().getForumId(), 0L));
                }
                pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.jHV.cFJ(), 0L));
                if (this.jHV.getPbData() != null && this.jHV.getPbData().cCy() != null) {
                    pageStayDurationItem.setNid(this.jHV.getPbData().cCy().getNid());
                }
            }
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.yE(TbadkCoreApplication.getInst().getAdAdSense().eaO);
            }
            Fragment cEa = cEa();
            if (cEa instanceof PbFragment) {
                if (((PbFragment) cEa).jMi == 2) {
                    pageStayDurationItem.yF(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                } else if (((PbFragment) cEa).jMi == 1) {
                    pageStayDurationItem.yF(PageStayDurationConstants.PageName.HOMEPAGE_CONCERN);
                } else if (((PbFragment) cEa).jMi == 3) {
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
        if (this.jHV != null) {
            this.jHW.setIsLoading(true);
            showLoadingView(this.mRootView);
            this.jHV.cFW();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.hns;
    }

    public void bVp() {
        if (this.hns != null) {
            this.hns.stopPlay();
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
        Fragment cEa = cEa();
        if (cEa instanceof VideoPbFragment) {
            ((VideoPbFragment) cEa).onKeyboardVisibilityChanged(z);
        }
    }
}
