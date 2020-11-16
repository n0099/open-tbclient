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
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes21.dex */
public class PbActivity extends BaseFragmentActivity implements VoiceManager.c, com.baidu.tieba.pb.pb.a<PbActivity> {
    private Fragment bcG;
    private com.baidu.tieba.NEGFeedBack.a iIS;
    private VoiceManager iIc;
    private PbModel lqh;
    private com.baidu.tieba.pb.videopb.e lqi;
    private boolean lql;
    private com.baidu.tieba.pb.pb.main.a lqm;
    private aw lqn;
    private View mRootView;
    public final com.baidu.tieba.pb.pb.main.b.a lqj = new com.baidu.tieba.pb.pb.main.b.a(this);
    public final com.baidu.tieba.pb.pb.main.b.c lqk = new com.baidu.tieba.pb.pb.main.b.c(getPageContext());
    private boolean mIsFromSchema = false;

    /* loaded from: classes21.dex */
    public static class a {
        public ConcurrentHashMap<String, ImageUrlData> evM;
        public ArrayList<String> lqp;
        public boolean lqq;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public String postId = null;
        public boolean evK = false;
        public boolean lqr = false;
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
        djg();
        initData(bundle);
        this.iIc = new VoiceManager();
        this.iIc.onCreate(getPageContext());
        this.lqm = new com.baidu.tieba.pb.pb.main.a(getPageContext());
        this.lqn = new aw(getPageContext());
        this.iIS = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "client_pb_live");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.bcG instanceof VideoPbFragment) {
            ((VideoPbFragment) this.bcG).onWindowFocusChanged(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i == 0) {
            if ((this.bcG instanceof PbFragment) && ((PbFragment) this.bcG).djH() != null) {
                ((PbFragment) this.bcG).djH().bzw();
                return;
            } else if ((this.bcG instanceof VideoPbFragment) && ((VideoPbFragment) this.bcG).djH() != null) {
                ((VideoPbFragment) this.bcG).djH().bzw();
                return;
            } else {
                return;
            }
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    private void djg() {
        this.lqi = (com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(this).l(com.baidu.tieba.pb.videopb.e.class);
        this.lqi.init(getIntent());
    }

    private void aA(Bundle bundle) {
        this.lqh = new PbModel(this);
        if (bundle != null) {
            this.lqh.initWithBundle(bundle);
            return;
        }
        this.lqh.initWithIntent(getIntent());
    }

    private void initData(Bundle bundle) {
        this.lqi.i(this.lqh);
        as.dmr().aX(this.lqh.dkR(), this.lqh.getIsFromMark());
        this.lqh.a(new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
                PbActivity.this.lqi.setIsLoading(false);
                PbActivity.this.hideLoadingView(PbActivity.this.mRootView);
                if (!z) {
                    if (!PbActivity.this.lql && !PbActivity.this.lqh.dkQ()) {
                        PbActivity.this.showNetRefreshView(PbActivity.this.mRootView, PbActivity.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                        PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbActivity.this.getActivity(), R.dimen.ds360));
                    }
                } else if (fVar != null) {
                    PbActivity.this.hideNetRefreshView(PbActivity.this.mRootView);
                }
                Fragment djh = PbActivity.this.djh();
                if (djh == null) {
                    if (z) {
                        PbActivity.this.lqi.b(fVar, 3);
                        if (PbActivity.this.bcG == null) {
                            PbActivity.this.c(fVar);
                        }
                    }
                } else if ((djh instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) djh).djZ() != null) {
                    ((com.baidu.tieba.pb.videopb.b) djh).djZ().a(z, i, i2, i3, fVar, str, i4);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void e(com.baidu.tieba.pb.data.f fVar) {
                Fragment djh = PbActivity.this.djh();
                if ((djh instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) djh).djZ() != null) {
                    ((com.baidu.tieba.pb.videopb.b) djh).djZ().e(fVar);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
                Fragment djh = PbActivity.this.djh();
                if ((djh instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) djh).djZ() != null) {
                    ((com.baidu.tieba.pb.videopb.b) djh).djZ().a(i, z, responsedMessage, z2, j);
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
                        PbActivity.this.lql = false;
                        return;
                    }
                    PbActivity.this.lql = true;
                    PbActivity.this.lqi.setIsLoading(false);
                    Fragment djh = PbActivity.this.djh();
                    if (djh == null) {
                        PbActivity.this.lqi.b(pbData, 2);
                        if (PbActivity.this.bcG == null) {
                            PbActivity.this.c(pbData);
                        }
                    } else if (djh instanceof PbFragment) {
                        PbActivity.this.lqh.a(pbData, pbPageReadLocalResponseMessage.getUpdateType(), pbPageReadLocalResponseMessage.getErrorString());
                    }
                }
            }
        });
        this.lqh.dlh();
        if (this.lqh.dkQ()) {
            com.baidu.tieba.pb.data.f aK = this.lqh.aK(com.baidu.tieba.frs.l.cxC());
            if (aK != null) {
                aK.Ga(3);
                if (djh() == null) {
                    this.lqi.b(aK, 1);
                    if (this.bcG == null) {
                        c(aK);
                    }
                }
            }
            this.lqi.setIsLoading(false);
        } else {
            showLoadingView(findViewById(R.id.container), true);
            this.lqi.setIsLoading(true);
        }
        if (com.baidu.adp.lib.util.l.isNetOk() && !TbadkCoreApplication.getInst().syncHasFinish) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        }
    }

    public Fragment djh() {
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
            this.bcG = OR(d);
            supportFragmentManager.beginTransaction().add(R.id.container, this.bcG, d).commitAllowingStateLoss();
        }
    }

    private String d(com.baidu.tieba.pb.data.f fVar) {
        return (fVar == null || !fVar.dih()) ? "pb_fragment_tag" : "video_pb_fragment_tag";
    }

    private Fragment OR(String str) {
        return "video_pb_fragment_tag".equals(str) ? VideoPbFragment.dqi() : PbFragment.djI();
    }

    public PbModel diV() {
        return this.lqh;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        Fragment djh = djh();
        if (djh instanceof BaseFragment) {
            ((BaseFragment) djh).onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Fragment djh = djh();
        if (djh != null) {
            djh.onActivityResult(i, i2, intent);
        }
    }

    public void dji() {
        super.finish();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.lqm != null && !this.lqm.a(this.lqh) && this.mIsFromSchema) {
            if (TbadkApplication.getInst().isNeedNewUserLead() && TbadkApplication.getInst().getIsFirstUse()) {
                sendMessage(new CustomMessage(2921454, new IntentConfig(this)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
        }
        if ((!TbadkApplication.getInst().isNeedNewUserLead() || !TbadkApplication.getInst().getIsFirstUse()) && this.lqn != null) {
            this.lqn.h(this.lqh);
        }
        Fragment djh = djh();
        if (djh instanceof com.baidu.tieba.pb.videopb.b) {
            ((com.baidu.tieba.pb.videopb.b) djh).finish();
        } else {
            super.finish();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        Fragment djh = djh();
        if (djh instanceof PbFragment) {
            ((PbFragment) djh).onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Fragment djh = djh();
        if (djh instanceof PbFragment) {
            if (((PbFragment) djh).onKeyDown(i, keyEvent)) {
                return true;
            }
        } else if ((djh instanceof VideoPbFragment) && ((VideoPbFragment) djh).onKeyDown(i, keyEvent)) {
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
        if (this.lqh != null) {
            this.lqh.aC(bundle);
        }
        if (this.iIc != null) {
            this.iIc.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.iIc != null) {
            this.iIc.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.iIc != null) {
            this.iIc.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.lqh != null) {
            as.dmr().aX(this.lqh.dkR(), this.lqh.getIsFromMark());
        }
        if (this.iIc != null) {
            this.iIc.onResume(getPageContext());
        }
        if (this.bcG instanceof BaseFragment) {
            ((BaseFragment) this.bcG).setPrimary(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.iIc != null) {
            this.iIc.onStop(getPageContext());
        }
        if (this.bcG instanceof BaseFragment) {
            ((BaseFragment) this.bcG).setPrimary(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iIc != null) {
            this.iIc.onDestory(getPageContext());
        }
        if (this.iIS != null) {
            this.iIS.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        return 0L;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a diM() {
        return this.lqj;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean diN() {
        if (this.lqh == null) {
            return false;
        }
        return this.lqh.diN();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String diO() {
        if (this.lqh != null) {
            return this.lqh.diO();
        }
        return null;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int diP() {
        if (this.lqh == null || this.lqh.getPbData() == null) {
            return 0;
        }
        return this.lqh.getPbData().dhW();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean OQ(String str) {
        return this.lqh != null && this.lqh.Pc(str);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.PB;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            if (this.lqh != null) {
                if (this.lqh.getPbData() != null) {
                    pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.lqh.getPbData().getForumId(), 0L));
                }
                pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.lqh.dkU(), 0L));
                if (this.lqh.getPbData() != null && this.lqh.getPbData().dhH() != null) {
                    pageStayDurationItem.setNid(this.lqh.getPbData().dhH().getNid());
                }
            }
            if (!com.baidu.tbadk.core.util.au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.DJ(TbadkCoreApplication.getInst().getAdAdSense().fbE);
            }
            Fragment djh = djh();
            if (djh instanceof PbFragment) {
                if (((PbFragment) djh).luJ == 2) {
                    pageStayDurationItem.DK(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                } else if (((PbFragment) djh).luJ == 1) {
                    pageStayDurationItem.DK(PageStayDurationConstants.PageName.HOMEPAGE_CONCERN);
                } else if (((PbFragment) djh).luJ == 3) {
                    pageStayDurationItem.DK(PageStayDurationConstants.PageName.FRS);
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
        if (this.lqh != null) {
            this.lqi.setIsLoading(true);
            showLoadingView(this.mRootView);
            this.lqh.dlh();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.iIc;
    }

    public void cyn() {
        if (this.iIc != null) {
            this.iIc.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected boolean shouldChangeStatusBarIconAndTextColor() {
        return !(this.bcG instanceof VideoPbFragment);
    }

    public View getRootView() {
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        Fragment djh = djh();
        if (djh instanceof VideoPbFragment) {
            ((VideoPbFragment) djh).onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onScreenShot(String str) {
        super.onScreenShot(str);
        if (this.lqh != null && this.lqh.getPbData() != null) {
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13848");
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.dR("tid", this.lqh.dkU());
            arVar.dR("fid", this.lqh.getPbData().getForumId());
            arVar.ak("obj_type", 3);
            TiebaStatic.log(arVar);
        }
    }
}
