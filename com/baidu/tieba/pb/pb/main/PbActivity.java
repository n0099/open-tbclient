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
    private Fragment bbK;
    private VoiceManager ioV;
    private com.baidu.tieba.NEGFeedBack.a ipL;
    private PbModel kXs;
    private com.baidu.tieba.pb.videopb.e kXt;
    private boolean kXw;
    private com.baidu.tieba.pb.pb.main.a kXx;
    private aw kXy;
    private View mRootView;
    public final com.baidu.tieba.pb.pb.main.b.a kXu = new com.baidu.tieba.pb.pb.main.b.a(this);
    public final com.baidu.tieba.pb.pb.main.b.c kXv = new com.baidu.tieba.pb.pb.main.b.c(getPageContext());
    private boolean mIsFromSchema = false;

    /* loaded from: classes22.dex */
    public static class a {
        public ConcurrentHashMap<String, ImageUrlData> eje;
        public ArrayList<String> kXA;
        public boolean kXB;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public String postId = null;
        public boolean ejc = false;
        public boolean kXC = false;
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
        deb();
        initData(bundle);
        this.ioV = new VoiceManager();
        this.ioV.onCreate(getPageContext());
        this.kXx = new com.baidu.tieba.pb.pb.main.a(getPageContext());
        this.kXy = new aw(getPageContext());
        this.ipL = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "client_pb_live");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.bbK instanceof VideoPbFragment) {
            ((VideoPbFragment) this.bbK).onWindowFocusChanged(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i == 0) {
            if ((this.bbK instanceof PbFragment) && ((PbFragment) this.bbK).deB() != null) {
                ((PbFragment) this.bbK).deB().bvO();
                return;
            } else if ((this.bbK instanceof VideoPbFragment) && ((VideoPbFragment) this.bbK).deB() != null) {
                ((VideoPbFragment) this.bbK).deB().bvO();
                return;
            } else {
                return;
            }
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    private void deb() {
        this.kXt = (com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(this).l(com.baidu.tieba.pb.videopb.e.class);
        this.kXt.init(getIntent());
    }

    private void aA(Bundle bundle) {
        this.kXs = new PbModel(this);
        if (bundle != null) {
            this.kXs.initWithBundle(bundle);
            return;
        }
        this.kXs.initWithIntent(getIntent());
    }

    private void initData(Bundle bundle) {
        this.kXt.i(this.kXs);
        as.dhj().aV(this.kXs.dfL(), this.kXs.getIsFromMark());
        this.kXs.a(new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
                PbActivity.this.kXt.setIsLoading(false);
                PbActivity.this.hideLoadingView(PbActivity.this.mRootView);
                if (!z) {
                    if (!PbActivity.this.kXw && !PbActivity.this.kXs.dfK()) {
                        PbActivity.this.showNetRefreshView(PbActivity.this.mRootView, PbActivity.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                        PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbActivity.this.getActivity(), R.dimen.ds360));
                    }
                } else if (fVar != null) {
                    PbActivity.this.hideNetRefreshView(PbActivity.this.mRootView);
                }
                Fragment dec = PbActivity.this.dec();
                if (dec == null) {
                    if (z) {
                        PbActivity.this.kXt.b(fVar, 3);
                        if (PbActivity.this.bbK == null) {
                            PbActivity.this.c(fVar);
                        }
                    }
                } else if ((dec instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) dec).deT() != null) {
                    ((com.baidu.tieba.pb.videopb.b) dec).deT().a(z, i, i2, i3, fVar, str, i4);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void e(com.baidu.tieba.pb.data.f fVar) {
                Fragment dec = PbActivity.this.dec();
                if ((dec instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) dec).deT() != null) {
                    ((com.baidu.tieba.pb.videopb.b) dec).deT().e(fVar);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
                Fragment dec = PbActivity.this.dec();
                if ((dec instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) dec).deT() != null) {
                    ((com.baidu.tieba.pb.videopb.b) dec).deT().a(i, z, responsedMessage, z2, j);
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
                        PbActivity.this.kXw = false;
                        return;
                    }
                    PbActivity.this.kXw = true;
                    PbActivity.this.kXt.setIsLoading(false);
                    Fragment dec = PbActivity.this.dec();
                    if (dec == null) {
                        PbActivity.this.kXt.b(pbData, 2);
                        if (PbActivity.this.bbK == null) {
                            PbActivity.this.c(pbData);
                        }
                    } else if (dec instanceof PbFragment) {
                        PbActivity.this.kXs.a(pbData, pbPageReadLocalResponseMessage.getUpdateType(), pbPageReadLocalResponseMessage.getErrorString());
                    }
                }
            }
        });
        this.kXs.dgb();
        if (this.kXs.dfK()) {
            com.baidu.tieba.pb.data.f aI = this.kXs.aI(com.baidu.tieba.frs.l.csr());
            if (aI != null) {
                aI.EW(3);
                if (dec() == null) {
                    this.kXt.b(aI, 1);
                    if (this.bbK == null) {
                        c(aI);
                    }
                }
            }
            this.kXt.setIsLoading(false);
        } else {
            showLoadingView(findViewById(R.id.container), true);
            this.kXt.setIsLoading(true);
        }
        if (com.baidu.adp.lib.util.l.isNetOk() && !TbadkCoreApplication.getInst().syncHasFinish) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        }
    }

    public Fragment dec() {
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
            this.bbK = OG(d);
            supportFragmentManager.beginTransaction().add(R.id.container, this.bbK, d).commitAllowingStateLoss();
        }
    }

    private String d(com.baidu.tieba.pb.data.f fVar) {
        return (fVar == null || !fVar.dda()) ? "pb_fragment_tag" : "video_pb_fragment_tag";
    }

    private Fragment OG(String str) {
        return "video_pb_fragment_tag".equals(str) ? VideoPbFragment.dkY() : PbFragment.deC();
    }

    public PbModel ddQ() {
        return this.kXs;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        Fragment dec = dec();
        if (dec instanceof BaseFragment) {
            ((BaseFragment) dec).onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Fragment dec = dec();
        if (dec != null) {
            dec.onActivityResult(i, i2, intent);
        }
    }

    public void ded() {
        super.finish();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.kXx != null && !this.kXx.a(this.kXs) && this.mIsFromSchema) {
            if (TbadkApplication.getInst().isNeedNewUserLead() && TbadkApplication.getInst().getIsFirstUse()) {
                sendMessage(new CustomMessage(2921454, new IntentConfig(this)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
        }
        if ((!TbadkApplication.getInst().isNeedNewUserLead() || !TbadkApplication.getInst().getIsFirstUse()) && this.kXy != null) {
            this.kXy.h(this.kXs);
        }
        Fragment dec = dec();
        if (dec instanceof com.baidu.tieba.pb.videopb.b) {
            ((com.baidu.tieba.pb.videopb.b) dec).finish();
        } else {
            super.finish();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        Fragment dec = dec();
        if (dec instanceof PbFragment) {
            ((PbFragment) dec).onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Fragment dec = dec();
        if (dec instanceof PbFragment) {
            if (((PbFragment) dec).onKeyDown(i, keyEvent)) {
                return true;
            }
        } else if ((dec instanceof VideoPbFragment) && ((VideoPbFragment) dec).onKeyDown(i, keyEvent)) {
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
        if (this.kXs != null) {
            this.kXs.aC(bundle);
        }
        if (this.ioV != null) {
            this.ioV.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.ioV != null) {
            this.ioV.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.ioV != null) {
            this.ioV.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kXs != null) {
            as.dhj().aV(this.kXs.dfL(), this.kXs.getIsFromMark());
        }
        if (this.ioV != null) {
            this.ioV.onResume(getPageContext());
        }
        if (this.bbK instanceof BaseFragment) {
            ((BaseFragment) this.bbK).setPrimary(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.ioV != null) {
            this.ioV.onStop(getPageContext());
        }
        if (this.bbK instanceof BaseFragment) {
            ((BaseFragment) this.bbK).setPrimary(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ioV != null) {
            this.ioV.onDestory(getPageContext());
        }
        if (this.ipL != null) {
            this.ipL.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        return 0L;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a ddF() {
        return this.kXu;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean ddG() {
        if (this.kXs == null) {
            return false;
        }
        return this.kXs.ddG();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String ddH() {
        if (this.kXs != null) {
            return this.kXs.ddH();
        }
        return null;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int ddI() {
        if (this.kXs == null || this.kXs.getPbData() == null) {
            return 0;
        }
        return this.kXs.getPbData().dcP();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean OF(String str) {
        return this.kXs != null && this.kXs.OR(str);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.PB;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            if (this.kXs != null) {
                if (this.kXs.getPbData() != null) {
                    pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.kXs.getPbData().getForumId(), 0L));
                }
                pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.kXs.dfO(), 0L));
                if (this.kXs.getPbData() != null && this.kXs.getPbData().dcA() != null) {
                    pageStayDurationItem.setNid(this.kXs.getPbData().dcA().getNid());
                }
            }
            if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.DD(TbadkCoreApplication.getInst().getAdAdSense().eOl);
            }
            Fragment dec = dec();
            if (dec instanceof PbFragment) {
                if (((PbFragment) dec).lbT == 2) {
                    pageStayDurationItem.DE(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                } else if (((PbFragment) dec).lbT == 1) {
                    pageStayDurationItem.DE(PageStayDurationConstants.PageName.HOMEPAGE_CONCERN);
                } else if (((PbFragment) dec).lbT == 3) {
                    pageStayDurationItem.DE(PageStayDurationConstants.PageName.FRS);
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
        if (this.kXs != null) {
            this.kXt.setIsLoading(true);
            showLoadingView(this.mRootView);
            this.kXs.dgb();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.ioV;
    }

    public void ctc() {
        if (this.ioV != null) {
            this.ioV.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected boolean shouldChangeStatusBarIconAndTextColor() {
        return !(this.bbK instanceof VideoPbFragment);
    }

    public View getRootView() {
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        Fragment dec = dec();
        if (dec instanceof VideoPbFragment) {
            ((VideoPbFragment) dec).onKeyboardVisibilityChanged(z);
        }
    }
}
