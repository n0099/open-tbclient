package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
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
    private Fragment aGR;
    private VoiceManager gYp;
    private PbModel jqc;
    private com.baidu.tieba.pb.videopb.e jqd;
    private boolean jqf;
    private View mRootView;
    public final com.baidu.tieba.pb.pb.main.b.a jqe = new com.baidu.tieba.pb.pb.main.b.a(this);
    private boolean mIsFromSchema = false;

    /* loaded from: classes9.dex */
    public static class a {
        public ArrayList<String> jqh;
        public ConcurrentHashMap<String, ImageUrlData> jqi;
        public boolean jqk;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public String postId = null;
        public boolean jqj = false;
        public boolean jql = false;
        public String lastId = "";
        public int index = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        initUniqueId();
        as(bundle);
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
        cwO();
        initData(bundle);
        this.gYp = new VoiceManager();
        this.gYp.onCreate(getPageContext());
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.aGR instanceof VideoPbFragment) {
            ((VideoPbFragment) this.aGR).onWindowFocusChanged(z);
        }
    }

    private void cwO() {
        this.jqd = (com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(this).l(com.baidu.tieba.pb.videopb.e.class);
        this.jqd.init(getIntent());
    }

    private void as(Bundle bundle) {
        this.jqc = new PbModel(this);
        if (bundle != null) {
            this.jqc.initWithBundle(bundle);
            return;
        }
        this.jqc.initWithIntent(getIntent());
    }

    private void initData(Bundle bundle) {
        this.jqd.g(this.jqc);
        ah.czS().aA(this.jqc.cyx(), this.jqc.getIsFromMark());
        this.jqc.a(new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
                PbActivity.this.jqd.setIsLoading(false);
                PbActivity.this.hideLoadingView(PbActivity.this.mRootView);
                if (!z) {
                    if (!PbActivity.this.jqf && !PbActivity.this.jqc.cyw()) {
                        PbActivity.this.showNetRefreshView(PbActivity.this.mRootView, PbActivity.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                        PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbActivity.this.getActivity(), R.dimen.ds360));
                    }
                } else if (eVar != null) {
                    PbActivity.this.hideNetRefreshView(PbActivity.this.mRootView);
                }
                Fragment cwP = PbActivity.this.cwP();
                if (cwP == null) {
                    if (z) {
                        PbActivity.this.jqd.b(eVar, 3);
                        if (PbActivity.this.aGR == null) {
                            PbActivity.this.c(eVar);
                        }
                    }
                } else if ((cwP instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) cwP).cxJ() != null) {
                    ((com.baidu.tieba.pb.videopb.b) cwP).cxJ().a(z, i, i2, i3, eVar, str, i4);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void e(com.baidu.tieba.pb.data.e eVar) {
                Fragment cwP = PbActivity.this.cwP();
                if ((cwP instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) cwP).cxJ() != null) {
                    ((com.baidu.tieba.pb.videopb.b) cwP).cxJ().e(eVar);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
                Fragment cwP = PbActivity.this.cwP();
                if ((cwP instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) cwP).cxJ() != null) {
                    ((com.baidu.tieba.pb.videopb.b) cwP).cxJ().a(i, z, responsedMessage, z2, j);
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
                        PbActivity.this.jqf = false;
                        return;
                    }
                    PbActivity.this.jqf = true;
                    PbActivity.this.jqd.setIsLoading(false);
                    Fragment cwP = PbActivity.this.cwP();
                    if (cwP == null) {
                        PbActivity.this.jqd.b(pbData, 2);
                        if (PbActivity.this.aGR == null) {
                            PbActivity.this.c(pbData);
                        }
                    } else if (cwP instanceof PbFragment) {
                        PbActivity.this.jqc.a(pbData, pbPageReadLocalResponseMessage.getUpdateType(), pbPageReadLocalResponseMessage.getErrorString());
                    }
                }
            }
        });
        this.jqc.cyM();
        if (this.jqc.cyw()) {
            com.baidu.tieba.pb.data.e aI = this.jqc.aI(com.baidu.tieba.frs.i.bOl());
            if (aI != null) {
                aI.zj(3);
                if (cwP() == null) {
                    this.jqd.b(aI, 1);
                    if (this.aGR == null) {
                        c(aI);
                    }
                }
            }
            this.jqd.setIsLoading(false);
            return;
        }
        showLoadingView(findViewById(R.id.container), true);
        this.jqd.setIsLoading(true);
    }

    public Fragment cwP() {
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
            this.aGR = Ht(d);
            supportFragmentManager.beginTransaction().add(R.id.container, this.aGR, d).commitAllowingStateLoss();
        }
    }

    private String d(com.baidu.tieba.pb.data.e eVar) {
        return (eVar == null || !eVar.aQh()) ? "pb_fragment_tag" : "video_pb_fragment_tag";
    }

    private Fragment Ht(String str) {
        return "video_pb_fragment_tag".equals(str) ? VideoPbFragment.cDB() : PbFragment.cxr();
    }

    public PbModel cwD() {
        return this.jqc;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        Fragment cwP = cwP();
        if (cwP instanceof BaseFragment) {
            ((BaseFragment) cwP).onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Fragment cwP = cwP();
        if (cwP != null) {
            cwP.onActivityResult(i, i2, intent);
        }
    }

    public void cwQ() {
        super.finish();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.mIsFromSchema) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        }
        Fragment cwP = cwP();
        if (cwP instanceof com.baidu.tieba.pb.videopb.b) {
            ((com.baidu.tieba.pb.videopb.b) cwP).finish();
        } else {
            super.finish();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        Fragment cwP = cwP();
        if (cwP instanceof PbFragment) {
            ((PbFragment) cwP).onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Fragment cwP = cwP();
        if (cwP instanceof PbFragment) {
            if (((PbFragment) cwP).onKeyDown(i, keyEvent)) {
                return true;
            }
        } else if ((cwP instanceof VideoPbFragment) && ((VideoPbFragment) cwP).onKeyDown(i, keyEvent)) {
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
        if (this.jqc != null) {
            this.jqc.au(bundle);
        }
        if (this.gYp != null) {
            this.gYp.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.gYp != null) {
            this.gYp.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gYp != null) {
            this.gYp.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gYp != null) {
            this.gYp.onResume(getPageContext());
        }
        if (this.aGR instanceof BaseFragment) {
            ((BaseFragment) this.aGR).setPrimary(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.gYp != null) {
            this.gYp.onStop(getPageContext());
        }
        if (this.aGR instanceof BaseFragment) {
            ((BaseFragment) this.aGR).setPrimary(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gYp != null) {
            this.gYp.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        return 0L;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a cws() {
        return this.jqe;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean cwt() {
        if (this.jqc == null) {
            return false;
        }
        return this.jqc.cwt();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String cwu() {
        if (this.jqc != null) {
            return this.jqc.cwu();
        }
        return null;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int cwv() {
        if (this.jqc == null || this.jqc.getPbData() == null) {
            return 0;
        }
        return this.jqc.getPbData().cvG();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean Hs(String str) {
        return this.jqc != null && this.jqc.HD(str);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.PB;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            if (this.jqc != null) {
                if (this.jqc.getPbData() != null) {
                    pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.jqc.getPbData().getForumId(), 0L));
                }
                pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.jqc.cyA(), 0L));
            }
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.wV(TbadkCoreApplication.getInst().getAdAdSense().dMt);
            }
            Fragment cwP = cwP();
            if (cwP instanceof PbFragment) {
                if (((PbFragment) cwP).jua == 2) {
                    pageStayDurationItem.wW(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                } else if (((PbFragment) cwP).jua == 1) {
                    pageStayDurationItem.wW(PageStayDurationConstants.PageName.HOMEPAGE_CONCERN);
                } else if (((PbFragment) cwP).jua == 3) {
                    pageStayDurationItem.wW(PageStayDurationConstants.PageName.FRS);
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
        if (this.jqc != null) {
            this.jqd.setIsLoading(true);
            showLoadingView(this.mRootView);
            this.jqc.cyM();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.gYp;
    }

    public void bOT() {
        if (this.gYp != null) {
            this.gYp.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected boolean shouldChangeStatusBarIconAndTextColor() {
        return !(this.aGR instanceof VideoPbFragment);
    }

    public View getRootView() {
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        Fragment cwP = cwP();
        if (cwP instanceof VideoPbFragment) {
            ((VideoPbFragment) cwP).onKeyboardVisibilityChanged(z);
        }
    }
}
