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
    private Fragment aoo;
    private VoiceManager goy;
    private PbModel iEu;
    private com.baidu.tieba.pb.videopb.e iEv;
    private boolean iEx;
    private View mRootView;
    public final com.baidu.tieba.pb.pb.main.b.a iEw = new com.baidu.tieba.pb.pb.main.b.a(this);
    private boolean mIsFromSchema = false;

    /* loaded from: classes9.dex */
    public static class a {
        public ConcurrentHashMap<String, ImageUrlData> iEA;
        public boolean iEC;
        public ArrayList<String> iEz;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public String postId = null;
        public boolean iEB = false;
        public boolean iED = false;
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
                String queryParameter8 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.cIl);
                String queryParameter9 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.cIm);
                String queryParameter10 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.cIn);
                String queryParameter11 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.cIo);
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13561");
                anVar.cy("obj_locate", queryParameter2);
                anVar.cy("obj_type", queryParameter3);
                anVar.cy("obj_param1", queryParameter4);
                anVar.cy(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                anVar.cy("tid", queryParameter6);
                anVar.cy("fname", queryParameter7);
                anVar.cy(com.baidu.tbadk.BdToken.f.cIl, queryParameter8);
                anVar.cy(com.baidu.tbadk.BdToken.f.cIm, queryParameter9);
                anVar.cy(com.baidu.tbadk.BdToken.f.cIn, queryParameter10);
                anVar.cy(com.baidu.tbadk.BdToken.f.cIo, queryParameter11);
                anVar.cy("obj_source", queryParameter);
                TiebaStatic.log(anVar);
            }
        }
        adjustResizeForSoftInput();
        addGlobalLayoutListener();
        clN();
        initData(bundle);
        this.goy = new VoiceManager();
        this.goy.onCreate(getPageContext());
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.aoo instanceof VideoPbFragment) {
            ((VideoPbFragment) this.aoo).onWindowFocusChanged(z);
        }
    }

    private void clN() {
        this.iEv = (com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(this).l(com.baidu.tieba.pb.videopb.e.class);
        this.iEv.init(getIntent());
    }

    private void as(Bundle bundle) {
        this.iEu = new PbModel(this);
        if (bundle != null) {
            this.iEu.initWithBundle(bundle);
            return;
        }
        this.iEu.initWithIntent(getIntent());
    }

    private void initData(Bundle bundle) {
        this.iEv.g(this.iEu);
        ah.coR().au(this.iEu.cnw(), this.iEu.getIsFromMark());
        this.iEu.a(new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
                PbActivity.this.iEv.setIsLoading(false);
                PbActivity.this.hideLoadingView(PbActivity.this.mRootView);
                if (!z) {
                    if (!PbActivity.this.iEx && !PbActivity.this.iEu.cnv()) {
                        PbActivity.this.showNetRefreshView(PbActivity.this.mRootView, PbActivity.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                        PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbActivity.this.getActivity(), R.dimen.ds360));
                    }
                } else if (eVar != null) {
                    PbActivity.this.hideNetRefreshView(PbActivity.this.mRootView);
                }
                Fragment clO = PbActivity.this.clO();
                if (clO == null) {
                    if (z) {
                        PbActivity.this.iEv.b(eVar, 3);
                        if (PbActivity.this.aoo == null) {
                            PbActivity.this.c(eVar);
                        }
                    }
                } else if ((clO instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) clO).cmI() != null) {
                    ((com.baidu.tieba.pb.videopb.b) clO).cmI().a(z, i, i2, i3, eVar, str, i4);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void e(com.baidu.tieba.pb.data.e eVar) {
                Fragment clO = PbActivity.this.clO();
                if ((clO instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) clO).cmI() != null) {
                    ((com.baidu.tieba.pb.videopb.b) clO).cmI().e(eVar);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
                Fragment clO = PbActivity.this.clO();
                if ((clO instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) clO).cmI() != null) {
                    ((com.baidu.tieba.pb.videopb.b) clO).cmI().a(i, z, responsedMessage, z2, j);
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
                        PbActivity.this.iEx = false;
                        return;
                    }
                    PbActivity.this.iEx = true;
                    PbActivity.this.iEv.setIsLoading(false);
                    Fragment clO = PbActivity.this.clO();
                    if (clO == null) {
                        PbActivity.this.iEv.b(pbData, 2);
                        if (PbActivity.this.aoo == null) {
                            PbActivity.this.c(pbData);
                        }
                    } else if (clO instanceof PbFragment) {
                        PbActivity.this.iEu.a(pbData, pbPageReadLocalResponseMessage.getUpdateType(), pbPageReadLocalResponseMessage.getErrorString());
                    }
                }
            }
        });
        this.iEu.cnL();
        if (this.iEu.cnv()) {
            com.baidu.tieba.pb.data.e aG = this.iEu.aG(com.baidu.tieba.frs.i.bDE());
            if (aG != null) {
                aG.yA(3);
                if (clO() == null) {
                    this.iEv.b(aG, 1);
                    if (this.aoo == null) {
                        c(aG);
                    }
                }
            }
            this.iEv.setIsLoading(false);
            return;
        }
        showLoadingView(findViewById(R.id.container), true);
        this.iEv.setIsLoading(true);
    }

    public Fragment clO() {
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
            this.aoo = FM(d);
            supportFragmentManager.beginTransaction().add(R.id.container, this.aoo, d).commitAllowingStateLoss();
        }
    }

    private String d(com.baidu.tieba.pb.data.e eVar) {
        return (eVar == null || !eVar.aHL()) ? "pb_fragment_tag" : "video_pb_fragment_tag";
    }

    private Fragment FM(String str) {
        return "video_pb_fragment_tag".equals(str) ? VideoPbFragment.csA() : PbFragment.cmq();
    }

    public PbModel clC() {
        return this.iEu;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        Fragment clO = clO();
        if (clO instanceof BaseFragment) {
            ((BaseFragment) clO).onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Fragment clO = clO();
        if (clO != null) {
            clO.onActivityResult(i, i2, intent);
        }
    }

    public void clP() {
        super.finish();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.mIsFromSchema) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        }
        Fragment clO = clO();
        if (clO instanceof com.baidu.tieba.pb.videopb.b) {
            ((com.baidu.tieba.pb.videopb.b) clO).finish();
        } else {
            super.finish();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        Fragment clO = clO();
        if (clO instanceof PbFragment) {
            ((PbFragment) clO).onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Fragment clO = clO();
        if (clO instanceof PbFragment) {
            if (((PbFragment) clO).onKeyDown(i, keyEvent)) {
                return true;
            }
        } else if ((clO instanceof VideoPbFragment) && ((VideoPbFragment) clO).onKeyDown(i, keyEvent)) {
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
        if (this.iEu != null) {
            this.iEu.au(bundle);
        }
        if (this.goy != null) {
            this.goy.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.goy != null) {
            this.goy.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.goy != null) {
            this.goy.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.goy != null) {
            this.goy.onResume(getPageContext());
        }
        if (this.aoo instanceof BaseFragment) {
            ((BaseFragment) this.aoo).setPrimary(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.goy != null) {
            this.goy.onStop(getPageContext());
        }
        if (this.aoo instanceof BaseFragment) {
            ((BaseFragment) this.aoo).setPrimary(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.goy != null) {
            this.goy.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        return 0L;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a clr() {
        return this.iEw;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean cls() {
        if (this.iEu == null) {
            return false;
        }
        return this.iEu.cls();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String clt() {
        if (this.iEu != null) {
            return this.iEu.clt();
        }
        return null;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int clu() {
        if (this.iEu == null || this.iEu.getPbData() == null) {
            return 0;
        }
        return this.iEu.getPbData().ckH();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean FL(String str) {
        return this.iEu != null && this.iEu.FW(str);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.PB;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            if (this.iEu != null) {
                if (this.iEu.getPbData() != null) {
                    pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.iEu.getPbData().getForumId(), 0L));
                }
                pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.iEu.cnz(), 0L));
            }
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.vF(TbadkCoreApplication.getInst().getAdAdSense().dml);
            }
            Fragment clO = clO();
            if (clO instanceof PbFragment) {
                if (((PbFragment) clO).iIs == 2) {
                    pageStayDurationItem.vG(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                } else if (((PbFragment) clO).iIs == 1) {
                    pageStayDurationItem.vG(PageStayDurationConstants.PageName.HOMEPAGE_CONCERN);
                } else if (((PbFragment) clO).iIs == 3) {
                    pageStayDurationItem.vG(PageStayDurationConstants.PageName.FRS);
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
        if (this.iEu != null) {
            this.iEv.setIsLoading(true);
            showLoadingView(this.mRootView);
            this.iEu.cnL();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.goy;
    }

    public void bEl() {
        if (this.goy != null) {
            this.goy.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected boolean shouldChangeStatusBarIconAndTextColor() {
        return !(this.aoo instanceof VideoPbFragment);
    }

    public View getRootView() {
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        Fragment clO = clO();
        if (clO instanceof VideoPbFragment) {
            ((VideoPbFragment) clO).onKeyboardVisibilityChanged(z);
        }
    }
}
