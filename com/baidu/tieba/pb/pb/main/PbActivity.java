package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class PbActivity extends BaseFragmentActivity implements VoiceManager.c, com.baidu.tieba.pb.pb.a<PbActivity> {
    private Fragment aln;
    private VoiceManager giZ;
    private PbModel iyT;
    private com.baidu.tieba.pb.videopb.e iyU;
    public final com.baidu.tieba.pb.pb.main.b.a iyV = new com.baidu.tieba.pb.pb.main.b.a(this);
    private boolean iyW;
    private View mRootView;

    /* loaded from: classes6.dex */
    public static class a {
        public ArrayList<String> iyY;
        public ConcurrentHashMap<String, ImageUrlData> iyZ;
        public boolean izb;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public String postId = null;
        public boolean iza = false;
        public boolean izc = false;
        public String lastId = "";
        public int index = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        initUniqueId();
        as(bundle);
        super.onCreate(bundle);
        setContentView(R.layout.pb_layout);
        this.mRootView = findViewById(R.id.container);
        Intent intent = getIntent();
        if (intent != null && intent.getData() != null) {
            Uri data = intent.getData();
            String queryParameter = data.getQueryParameter("obj_source");
            if ("shoubai".equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter)) {
                String queryParameter2 = data.getQueryParameter("obj_locate");
                String queryParameter3 = data.getQueryParameter("obj_type");
                String queryParameter4 = data.getQueryParameter("obj_param1");
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13561");
                anVar.cp("obj_locate", queryParameter2);
                anVar.cp("obj_type", queryParameter3);
                anVar.cp("obj_param1", queryParameter4);
                anVar.cp("obj_source", queryParameter);
                TiebaStatic.log(anVar);
            }
        }
        adjustResizeForSoftInput();
        addGlobalLayoutListener();
        cjh();
        initData(bundle);
        this.giZ = new VoiceManager();
        this.giZ.onCreate(getPageContext());
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.aln instanceof VideoPbFragment) {
            ((VideoPbFragment) this.aln).onWindowFocusChanged(z);
        }
    }

    public void cjg() {
        if (this.mRootView != null && !TbSingleton.getInstance().isNotchScreen(this) && !TbSingleton.getInstance().isCutoutScreen(this)) {
            this.mRootView.setSystemUiVisibility(4);
        }
    }

    private void cjh() {
        this.iyU = (com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(this).l(com.baidu.tieba.pb.videopb.e.class);
        this.iyU.init(getIntent());
    }

    private void as(Bundle bundle) {
        this.iyT = new PbModel(this);
        if (bundle != null) {
            this.iyT.initWithBundle(bundle);
            return;
        }
        this.iyT.initWithIntent(getIntent());
    }

    private void initData(Bundle bundle) {
        this.iyU.g(this.iyT);
        ak.cmq().au(this.iyT.ckR(), this.iyT.getIsFromMark());
        this.iyT.a(new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
                PbActivity.this.iyU.setIsLoading(false);
                PbActivity.this.hideLoadingView(PbActivity.this.mRootView);
                if (!z) {
                    if (!PbActivity.this.iyW && !PbActivity.this.iyT.ckQ()) {
                        PbActivity.this.showNetRefreshView(PbActivity.this.mRootView, PbActivity.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                        PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbActivity.this.getActivity(), R.dimen.ds360));
                    }
                } else if (fVar != null) {
                    PbActivity.this.hideNetRefreshView(PbActivity.this.mRootView);
                }
                Fragment cji = PbActivity.this.cji();
                if (cji == null) {
                    if (z) {
                        PbActivity.this.iyU.b(fVar, 3);
                        if (PbActivity.this.aln == null) {
                            PbActivity.this.c(fVar);
                        }
                    }
                } else if ((cji instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) cji).ckd() != null) {
                    ((com.baidu.tieba.pb.videopb.b) cji).ckd().a(z, i, i2, i3, fVar, str, i4);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void e(com.baidu.tieba.pb.data.f fVar) {
                Fragment cji = PbActivity.this.cji();
                if ((cji instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) cji).ckd() != null) {
                    ((com.baidu.tieba.pb.videopb.b) cji).ckd().e(fVar);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
                Fragment cji = PbActivity.this.cji();
                if ((cji instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) cji).ckd() != null) {
                    ((com.baidu.tieba.pb.videopb.b) cji).ckd().a(i, z, responsedMessage, z2, j);
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
                        PbActivity.this.iyW = false;
                        return;
                    }
                    PbActivity.this.iyW = true;
                    PbActivity.this.iyU.setIsLoading(false);
                    Fragment cji = PbActivity.this.cji();
                    if (cji == null) {
                        PbActivity.this.iyU.b(pbData, 2);
                        if (PbActivity.this.aln == null) {
                            PbActivity.this.c(pbData);
                        }
                    } else if (cji instanceof PbFragment) {
                        PbActivity.this.iyT.a(pbData, pbPageReadLocalResponseMessage.getUpdateType(), pbPageReadLocalResponseMessage.getErrorString());
                    }
                }
            }
        });
        this.iyT.clg();
        if (this.iyT.ckQ()) {
            com.baidu.tieba.pb.data.f aC = this.iyT.aC(com.baidu.tieba.frs.i.bAW());
            if (aC != null) {
                aC.yo(3);
                if (cji() == null) {
                    this.iyU.b(aC, 1);
                    if (this.aln == null) {
                        c(aC);
                    }
                }
            }
            this.iyU.setIsLoading(false);
            return;
        }
        showLoadingView(findViewById(R.id.container), true);
        this.iyU.setIsLoading(true);
    }

    public Fragment cji() {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (com.baidu.tbadk.core.util.v.isEmpty(fragments)) {
            return null;
        }
        return fragments.get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.pb.data.f fVar) {
        String d = d(fVar);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager.findFragmentByTag(d) == null) {
            this.aln = Fm(d);
            supportFragmentManager.beginTransaction().add(R.id.container, this.aln, d).commitAllowingStateLoss();
        }
    }

    private String d(com.baidu.tieba.pb.data.f fVar) {
        return (fVar == null || !fVar.cih()) ? "pb_fragment_tag" : "video_pb_fragment_tag";
    }

    private Fragment Fm(String str) {
        return "video_pb_fragment_tag".equals(str) ? VideoPbFragment.cpZ() : PbFragment.cjL();
    }

    public PbModel ciU() {
        return this.iyT;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        Fragment cji = cji();
        if (cji instanceof BaseFragment) {
            ((BaseFragment) cji).onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Fragment cji = cji();
        if (cji != null) {
            cji.onActivityResult(i, i2, intent);
        }
    }

    public void cjj() {
        super.finish();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Fragment cji = cji();
        if (cji instanceof com.baidu.tieba.pb.videopb.b) {
            ((com.baidu.tieba.pb.videopb.b) cji).finish();
        } else {
            super.finish();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        Fragment cji = cji();
        if (cji instanceof PbFragment) {
            ((PbFragment) cji).onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Fragment cji = cji();
        if (cji instanceof PbFragment) {
            if (((PbFragment) cji).onKeyDown(i, keyEvent)) {
                return true;
            }
        } else if ((cji instanceof VideoPbFragment) && ((VideoPbFragment) cji).onKeyDown(i, keyEvent)) {
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
        if (this.iyT != null) {
            this.iyT.au(bundle);
        }
        if (this.giZ != null) {
            this.giZ.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.giZ != null) {
            this.giZ.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.giZ != null) {
            this.giZ.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.giZ != null) {
            this.giZ.onResume(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.giZ != null) {
            this.giZ.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.giZ != null) {
            this.giZ.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        return 0L;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a ciI() {
        return this.iyV;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean ciJ() {
        if (this.iyT == null) {
            return false;
        }
        return this.iyT.ciJ();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String ciK() {
        if (this.iyT != null) {
            return this.iyT.ciK();
        }
        return null;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int ciL() {
        if (this.iyT == null || this.iyT.getPbData() == null) {
            return 0;
        }
        return this.iyT.getPbData().chW();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean Fl(String str) {
        return this.iyT != null && this.iyT.Fx(str);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.PB;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            if (this.iyT != null) {
                if (this.iyT.getPbData() != null) {
                    pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.iyT.getPbData().getForumId(), 0L));
                }
                pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.iyT.ckU(), 0L));
            }
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.vf(TbadkCoreApplication.getInst().getAdAdSense().dhF);
            }
            Fragment cji = cji();
            if (cji instanceof PbFragment) {
                if (((PbFragment) cji).iCW == 2) {
                    pageStayDurationItem.vg(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                } else if (((PbFragment) cji).iCW == 1) {
                    pageStayDurationItem.vg(PageStayDurationConstants.PageName.HOMEPAGE_CONCERN);
                } else if (((PbFragment) cji).iCW == 3) {
                    pageStayDurationItem.vg(PageStayDurationConstants.PageName.FRS);
                }
            }
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        if (getIntent().getParcelableExtra(PbActivityConfig.VIDEO_ORIGIN_AREA) != null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            super.enterExitAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        if (this.iyT != null) {
            this.iyU.setIsLoading(true);
            showLoadingView(this.mRootView);
            this.iyT.clg();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.giZ;
    }

    public void bBD() {
        if (this.giZ != null) {
            this.giZ.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public View getRootView() {
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        Fragment cji = cji();
        if (cji instanceof VideoPbFragment) {
            ((VideoPbFragment) cji).onKeyboardVisibilityChanged(z);
        }
    }
}
