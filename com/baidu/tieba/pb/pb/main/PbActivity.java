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
    private Fragment aGX;
    private VoiceManager gYv;
    private PbModel jqg;
    private com.baidu.tieba.pb.videopb.e jqh;
    private boolean jqj;
    private View mRootView;
    public final com.baidu.tieba.pb.pb.main.b.a jqi = new com.baidu.tieba.pb.pb.main.b.a(this);
    private boolean mIsFromSchema = false;

    /* loaded from: classes9.dex */
    public static class a {
        public ArrayList<String> jql;
        public ConcurrentHashMap<String, ImageUrlData> jqm;
        public boolean jqo;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public String postId = null;
        public boolean jqn = false;
        public boolean jqp = false;
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
        cwM();
        initData(bundle);
        this.gYv = new VoiceManager();
        this.gYv.onCreate(getPageContext());
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.aGX instanceof VideoPbFragment) {
            ((VideoPbFragment) this.aGX).onWindowFocusChanged(z);
        }
    }

    private void cwM() {
        this.jqh = (com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(this).l(com.baidu.tieba.pb.videopb.e.class);
        this.jqh.init(getIntent());
    }

    private void as(Bundle bundle) {
        this.jqg = new PbModel(this);
        if (bundle != null) {
            this.jqg.initWithBundle(bundle);
            return;
        }
        this.jqg.initWithIntent(getIntent());
    }

    private void initData(Bundle bundle) {
        this.jqh.g(this.jqg);
        ah.czQ().aA(this.jqg.cyv(), this.jqg.getIsFromMark());
        this.jqg.a(new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
                PbActivity.this.jqh.setIsLoading(false);
                PbActivity.this.hideLoadingView(PbActivity.this.mRootView);
                if (!z) {
                    if (!PbActivity.this.jqj && !PbActivity.this.jqg.cyu()) {
                        PbActivity.this.showNetRefreshView(PbActivity.this.mRootView, PbActivity.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                        PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbActivity.this.getActivity(), R.dimen.ds360));
                    }
                } else if (eVar != null) {
                    PbActivity.this.hideNetRefreshView(PbActivity.this.mRootView);
                }
                Fragment cwN = PbActivity.this.cwN();
                if (cwN == null) {
                    if (z) {
                        PbActivity.this.jqh.b(eVar, 3);
                        if (PbActivity.this.aGX == null) {
                            PbActivity.this.c(eVar);
                        }
                    }
                } else if ((cwN instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) cwN).cxH() != null) {
                    ((com.baidu.tieba.pb.videopb.b) cwN).cxH().a(z, i, i2, i3, eVar, str, i4);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void e(com.baidu.tieba.pb.data.e eVar) {
                Fragment cwN = PbActivity.this.cwN();
                if ((cwN instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) cwN).cxH() != null) {
                    ((com.baidu.tieba.pb.videopb.b) cwN).cxH().e(eVar);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
                Fragment cwN = PbActivity.this.cwN();
                if ((cwN instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) cwN).cxH() != null) {
                    ((com.baidu.tieba.pb.videopb.b) cwN).cxH().a(i, z, responsedMessage, z2, j);
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
                        PbActivity.this.jqj = false;
                        return;
                    }
                    PbActivity.this.jqj = true;
                    PbActivity.this.jqh.setIsLoading(false);
                    Fragment cwN = PbActivity.this.cwN();
                    if (cwN == null) {
                        PbActivity.this.jqh.b(pbData, 2);
                        if (PbActivity.this.aGX == null) {
                            PbActivity.this.c(pbData);
                        }
                    } else if (cwN instanceof PbFragment) {
                        PbActivity.this.jqg.a(pbData, pbPageReadLocalResponseMessage.getUpdateType(), pbPageReadLocalResponseMessage.getErrorString());
                    }
                }
            }
        });
        this.jqg.cyK();
        if (this.jqg.cyu()) {
            com.baidu.tieba.pb.data.e aI = this.jqg.aI(com.baidu.tieba.frs.i.bOk());
            if (aI != null) {
                aI.zj(3);
                if (cwN() == null) {
                    this.jqh.b(aI, 1);
                    if (this.aGX == null) {
                        c(aI);
                    }
                }
            }
            this.jqh.setIsLoading(false);
            return;
        }
        showLoadingView(findViewById(R.id.container), true);
        this.jqh.setIsLoading(true);
    }

    public Fragment cwN() {
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
            this.aGX = Hw(d);
            supportFragmentManager.beginTransaction().add(R.id.container, this.aGX, d).commitAllowingStateLoss();
        }
    }

    private String d(com.baidu.tieba.pb.data.e eVar) {
        return (eVar == null || !eVar.aQe()) ? "pb_fragment_tag" : "video_pb_fragment_tag";
    }

    private Fragment Hw(String str) {
        return "video_pb_fragment_tag".equals(str) ? VideoPbFragment.cDz() : PbFragment.cxp();
    }

    public PbModel cwB() {
        return this.jqg;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        Fragment cwN = cwN();
        if (cwN instanceof BaseFragment) {
            ((BaseFragment) cwN).onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Fragment cwN = cwN();
        if (cwN != null) {
            cwN.onActivityResult(i, i2, intent);
        }
    }

    public void cwO() {
        super.finish();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.mIsFromSchema) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        }
        Fragment cwN = cwN();
        if (cwN instanceof com.baidu.tieba.pb.videopb.b) {
            ((com.baidu.tieba.pb.videopb.b) cwN).finish();
        } else {
            super.finish();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        Fragment cwN = cwN();
        if (cwN instanceof PbFragment) {
            ((PbFragment) cwN).onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Fragment cwN = cwN();
        if (cwN instanceof PbFragment) {
            if (((PbFragment) cwN).onKeyDown(i, keyEvent)) {
                return true;
            }
        } else if ((cwN instanceof VideoPbFragment) && ((VideoPbFragment) cwN).onKeyDown(i, keyEvent)) {
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
        if (this.jqg != null) {
            this.jqg.au(bundle);
        }
        if (this.gYv != null) {
            this.gYv.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.gYv != null) {
            this.gYv.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gYv != null) {
            this.gYv.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gYv != null) {
            this.gYv.onResume(getPageContext());
        }
        if (this.aGX instanceof BaseFragment) {
            ((BaseFragment) this.aGX).setPrimary(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.gYv != null) {
            this.gYv.onStop(getPageContext());
        }
        if (this.aGX instanceof BaseFragment) {
            ((BaseFragment) this.aGX).setPrimary(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gYv != null) {
            this.gYv.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        return 0L;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a cwq() {
        return this.jqi;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean cwr() {
        if (this.jqg == null) {
            return false;
        }
        return this.jqg.cwr();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String cws() {
        if (this.jqg != null) {
            return this.jqg.cws();
        }
        return null;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int cwt() {
        if (this.jqg == null || this.jqg.getPbData() == null) {
            return 0;
        }
        return this.jqg.getPbData().cvE();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean Hv(String str) {
        return this.jqg != null && this.jqg.HG(str);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.PB;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            if (this.jqg != null) {
                if (this.jqg.getPbData() != null) {
                    pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.jqg.getPbData().getForumId(), 0L));
                }
                pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.jqg.cyy(), 0L));
            }
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.wY(TbadkCoreApplication.getInst().getAdAdSense().dMx);
            }
            Fragment cwN = cwN();
            if (cwN instanceof PbFragment) {
                if (((PbFragment) cwN).jue == 2) {
                    pageStayDurationItem.wZ(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                } else if (((PbFragment) cwN).jue == 1) {
                    pageStayDurationItem.wZ(PageStayDurationConstants.PageName.HOMEPAGE_CONCERN);
                } else if (((PbFragment) cwN).jue == 3) {
                    pageStayDurationItem.wZ(PageStayDurationConstants.PageName.FRS);
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
        if (this.jqg != null) {
            this.jqh.setIsLoading(true);
            showLoadingView(this.mRootView);
            this.jqg.cyK();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.gYv;
    }

    public void bOS() {
        if (this.gYv != null) {
            this.gYv.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected boolean shouldChangeStatusBarIconAndTextColor() {
        return !(this.aGX instanceof VideoPbFragment);
    }

    public View getRootView() {
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        Fragment cwN = cwN();
        if (cwN instanceof VideoPbFragment) {
            ((VideoPbFragment) cwN).onKeyboardVisibilityChanged(z);
        }
    }
}
