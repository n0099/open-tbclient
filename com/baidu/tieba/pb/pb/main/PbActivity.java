package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.net.Uri;
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
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
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
/* loaded from: classes9.dex */
public class PbActivity extends BaseFragmentActivity implements VoiceManager.c, com.baidu.tieba.pb.pb.a<PbActivity> {
    private Fragment aoy;
    private VoiceManager gpi;
    private PbModel iFV;
    private com.baidu.tieba.pb.videopb.e iFW;
    private boolean iFY;
    private View mRootView;
    public final com.baidu.tieba.pb.pb.main.b.a iFX = new com.baidu.tieba.pb.pb.main.b.a(this);
    private boolean mIsFromSchema = false;

    /* loaded from: classes9.dex */
    public static class a {
        public ArrayList<String> iGa;
        public ConcurrentHashMap<String, ImageUrlData> iGb;
        public boolean iGd;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public String postId = null;
        public boolean iGc = false;
        public boolean iGe = false;
        public String lastId = "";
        public int index = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        initUniqueId();
        as(bundle);
        Uri uri = null;
        if (getIntent() != null && getIntent().getParcelableExtra("key_uri") != null && !com.baidu.adp.base.a.eH().T("MainTabActivity")) {
            this.mIsFromSchema = true;
            uri = (Uri) getIntent().getParcelableExtra("key_uri");
        }
        if (this.mIsFromSchema) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        setContentView(R.layout.pb_layout);
        this.mRootView = findViewById(R.id.container);
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("obj_source");
            if ("shoubai".equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("obj_locate");
                String queryParameter3 = uri.getQueryParameter("obj_type");
                String queryParameter4 = uri.getQueryParameter("obj_param1");
                String queryParameter5 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                String queryParameter6 = uri.getQueryParameter("tid");
                String queryParameter7 = uri.getQueryParameter("kw");
                String queryParameter8 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.cIw);
                String queryParameter9 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.cIx);
                String queryParameter10 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.cIy);
                String queryParameter11 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.cIz);
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13561");
                anVar.cx("obj_locate", queryParameter2);
                anVar.cx("obj_type", queryParameter3);
                anVar.cx("obj_param1", queryParameter4);
                anVar.cx(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                anVar.cx("tid", queryParameter6);
                anVar.cx("fname", queryParameter7);
                anVar.cx(com.baidu.tbadk.BdToken.f.cIw, queryParameter8);
                anVar.cx(com.baidu.tbadk.BdToken.f.cIx, queryParameter9);
                anVar.cx(com.baidu.tbadk.BdToken.f.cIy, queryParameter10);
                anVar.cx(com.baidu.tbadk.BdToken.f.cIz, queryParameter11);
                anVar.cx("obj_source", queryParameter);
                TiebaStatic.log(anVar);
            }
        }
        adjustResizeForSoftInput();
        addGlobalLayoutListener();
        cmi();
        initData(bundle);
        this.gpi = new VoiceManager();
        this.gpi.onCreate(getPageContext());
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.aoy instanceof VideoPbFragment) {
            ((VideoPbFragment) this.aoy).onWindowFocusChanged(z);
        }
    }

    private void cmi() {
        this.iFW = (com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(this).l(com.baidu.tieba.pb.videopb.e.class);
        this.iFW.init(getIntent());
    }

    private void as(Bundle bundle) {
        this.iFV = new PbModel(this);
        if (bundle != null) {
            this.iFV.initWithBundle(bundle);
            return;
        }
        this.iFV.initWithIntent(getIntent());
    }

    private void initData(Bundle bundle) {
        this.iFW.g(this.iFV);
        ah.cpm().au(this.iFV.cnR(), this.iFV.getIsFromMark());
        this.iFV.a(new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
                PbActivity.this.iFW.setIsLoading(false);
                PbActivity.this.hideLoadingView(PbActivity.this.mRootView);
                if (!z) {
                    if (!PbActivity.this.iFY && !PbActivity.this.iFV.cnQ()) {
                        PbActivity.this.showNetRefreshView(PbActivity.this.mRootView, PbActivity.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                        PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbActivity.this.getActivity(), R.dimen.ds360));
                    }
                } else if (eVar != null) {
                    PbActivity.this.hideNetRefreshView(PbActivity.this.mRootView);
                }
                Fragment cmj = PbActivity.this.cmj();
                if (cmj == null) {
                    if (z) {
                        PbActivity.this.iFW.b(eVar, 3);
                        if (PbActivity.this.aoy == null) {
                            PbActivity.this.c(eVar);
                        }
                    }
                } else if ((cmj instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) cmj).cnd() != null) {
                    ((com.baidu.tieba.pb.videopb.b) cmj).cnd().a(z, i, i2, i3, eVar, str, i4);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void e(com.baidu.tieba.pb.data.e eVar) {
                Fragment cmj = PbActivity.this.cmj();
                if ((cmj instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) cmj).cnd() != null) {
                    ((com.baidu.tieba.pb.videopb.b) cmj).cnd().e(eVar);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
                Fragment cmj = PbActivity.this.cmj();
                if ((cmj instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) cmj).cnd() != null) {
                    ((com.baidu.tieba.pb.videopb.b) cmj).cnd().a(i, z, responsedMessage, z2, j);
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
                        PbActivity.this.iFY = false;
                        return;
                    }
                    PbActivity.this.iFY = true;
                    PbActivity.this.iFW.setIsLoading(false);
                    Fragment cmj = PbActivity.this.cmj();
                    if (cmj == null) {
                        PbActivity.this.iFW.b(pbData, 2);
                        if (PbActivity.this.aoy == null) {
                            PbActivity.this.c(pbData);
                        }
                    } else if (cmj instanceof PbFragment) {
                        PbActivity.this.iFV.a(pbData, pbPageReadLocalResponseMessage.getUpdateType(), pbPageReadLocalResponseMessage.getErrorString());
                    }
                }
            }
        });
        this.iFV.cog();
        if (this.iFV.cnQ()) {
            com.baidu.tieba.pb.data.e aH = this.iFV.aH(com.baidu.tieba.frs.i.bDM());
            if (aH != null) {
                aH.yI(3);
                if (cmj() == null) {
                    this.iFW.b(aH, 1);
                    if (this.aoy == null) {
                        c(aH);
                    }
                }
            }
            this.iFW.setIsLoading(false);
            return;
        }
        showLoadingView(findViewById(R.id.container), true);
        this.iFW.setIsLoading(true);
    }

    public Fragment cmj() {
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
            this.aoy = FM(d);
            supportFragmentManager.beginTransaction().add(R.id.container, this.aoy, d).commitAllowingStateLoss();
        }
    }

    private String d(com.baidu.tieba.pb.data.e eVar) {
        return (eVar == null || !eVar.aHP()) ? "pb_fragment_tag" : "video_pb_fragment_tag";
    }

    private Fragment FM(String str) {
        return "video_pb_fragment_tag".equals(str) ? VideoPbFragment.csV() : PbFragment.cmL();
    }

    public PbModel clX() {
        return this.iFV;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        Fragment cmj = cmj();
        if (cmj instanceof BaseFragment) {
            ((BaseFragment) cmj).onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Fragment cmj = cmj();
        if (cmj != null) {
            cmj.onActivityResult(i, i2, intent);
        }
    }

    public void cmk() {
        super.finish();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.mIsFromSchema) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        }
        Fragment cmj = cmj();
        if (cmj instanceof com.baidu.tieba.pb.videopb.b) {
            ((com.baidu.tieba.pb.videopb.b) cmj).finish();
        } else {
            super.finish();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        Fragment cmj = cmj();
        if (cmj instanceof PbFragment) {
            ((PbFragment) cmj).onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Fragment cmj = cmj();
        if (cmj instanceof PbFragment) {
            if (((PbFragment) cmj).onKeyDown(i, keyEvent)) {
                return true;
            }
        } else if ((cmj instanceof VideoPbFragment) && ((VideoPbFragment) cmj).onKeyDown(i, keyEvent)) {
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
        if (this.iFV != null) {
            this.iFV.au(bundle);
        }
        if (this.gpi != null) {
            this.gpi.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.gpi != null) {
            this.gpi.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gpi != null) {
            this.gpi.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gpi != null) {
            this.gpi.onResume(getPageContext());
        }
        if (this.aoy instanceof BaseFragment) {
            ((BaseFragment) this.aoy).setPrimary(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.gpi != null) {
            this.gpi.onStop(getPageContext());
        }
        if (this.aoy instanceof BaseFragment) {
            ((BaseFragment) this.aoy).setPrimary(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gpi != null) {
            this.gpi.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        return 0L;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a clM() {
        return this.iFX;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean clN() {
        if (this.iFV == null) {
            return false;
        }
        return this.iFV.clN();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String clO() {
        if (this.iFV != null) {
            return this.iFV.clO();
        }
        return null;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int clP() {
        if (this.iFV == null || this.iFV.getPbData() == null) {
            return 0;
        }
        return this.iFV.getPbData().clb();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean FL(String str) {
        return this.iFV != null && this.iFV.FW(str);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.PB;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            if (this.iFV != null) {
                if (this.iFV.getPbData() != null) {
                    pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.iFV.getPbData().getForumId(), 0L));
                }
                pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.iFV.cnU(), 0L));
            }
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.vG(TbadkCoreApplication.getInst().getAdAdSense().dmy);
            }
            Fragment cmj = cmj();
            if (cmj instanceof PbFragment) {
                if (((PbFragment) cmj).iJT == 2) {
                    pageStayDurationItem.vH(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                } else if (((PbFragment) cmj).iJT == 1) {
                    pageStayDurationItem.vH(PageStayDurationConstants.PageName.HOMEPAGE_CONCERN);
                } else if (((PbFragment) cmj).iJT == 3) {
                    pageStayDurationItem.vH(PageStayDurationConstants.PageName.FRS);
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
        if (this.iFV != null) {
            this.iFW.setIsLoading(true);
            showLoadingView(this.mRootView);
            this.iFV.cog();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.gpi;
    }

    public void bEu() {
        if (this.gpi != null) {
            this.gpi.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected boolean shouldChangeStatusBarIconAndTextColor() {
        return !(this.aoy instanceof VideoPbFragment);
    }

    public View getRootView() {
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        Fragment cmj = cmj();
        if (cmj instanceof VideoPbFragment) {
            ((VideoPbFragment) cmj).onKeyboardVisibilityChanged(z);
        }
    }
}
