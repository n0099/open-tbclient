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
    private Fragment aon;
    private VoiceManager gol;
    private PbModel iEi;
    private com.baidu.tieba.pb.videopb.e iEj;
    private boolean iEl;
    private View mRootView;
    public final com.baidu.tieba.pb.pb.main.b.a iEk = new com.baidu.tieba.pb.pb.main.b.a(this);
    private boolean mIsFromSchema = false;

    /* loaded from: classes9.dex */
    public static class a {
        public ArrayList<String> iEn;
        public ConcurrentHashMap<String, ImageUrlData> iEo;
        public boolean iEq;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public String postId = null;
        public boolean iEp = false;
        public boolean iEr = false;
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
                String queryParameter8 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.cIk);
                String queryParameter9 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.cIl);
                String queryParameter10 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.cIm);
                String queryParameter11 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.cIn);
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13561");
                anVar.cy("obj_locate", queryParameter2);
                anVar.cy("obj_type", queryParameter3);
                anVar.cy("obj_param1", queryParameter4);
                anVar.cy(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                anVar.cy("tid", queryParameter6);
                anVar.cy("fname", queryParameter7);
                anVar.cy(com.baidu.tbadk.BdToken.f.cIk, queryParameter8);
                anVar.cy(com.baidu.tbadk.BdToken.f.cIl, queryParameter9);
                anVar.cy(com.baidu.tbadk.BdToken.f.cIm, queryParameter10);
                anVar.cy(com.baidu.tbadk.BdToken.f.cIn, queryParameter11);
                anVar.cy("obj_source", queryParameter);
                TiebaStatic.log(anVar);
            }
        }
        adjustResizeForSoftInput();
        addGlobalLayoutListener();
        clM();
        initData(bundle);
        this.gol = new VoiceManager();
        this.gol.onCreate(getPageContext());
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.aon instanceof VideoPbFragment) {
            ((VideoPbFragment) this.aon).onWindowFocusChanged(z);
        }
    }

    private void clM() {
        this.iEj = (com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(this).l(com.baidu.tieba.pb.videopb.e.class);
        this.iEj.init(getIntent());
    }

    private void as(Bundle bundle) {
        this.iEi = new PbModel(this);
        if (bundle != null) {
            this.iEi.initWithBundle(bundle);
            return;
        }
        this.iEi.initWithIntent(getIntent());
    }

    private void initData(Bundle bundle) {
        this.iEj.g(this.iEi);
        ah.coQ().au(this.iEi.cnv(), this.iEi.getIsFromMark());
        this.iEi.a(new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
                PbActivity.this.iEj.setIsLoading(false);
                PbActivity.this.hideLoadingView(PbActivity.this.mRootView);
                if (!z) {
                    if (!PbActivity.this.iEl && !PbActivity.this.iEi.cnu()) {
                        PbActivity.this.showNetRefreshView(PbActivity.this.mRootView, PbActivity.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                        PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbActivity.this.getActivity(), R.dimen.ds360));
                    }
                } else if (eVar != null) {
                    PbActivity.this.hideNetRefreshView(PbActivity.this.mRootView);
                }
                Fragment clN = PbActivity.this.clN();
                if (clN == null) {
                    if (z) {
                        PbActivity.this.iEj.b(eVar, 3);
                        if (PbActivity.this.aon == null) {
                            PbActivity.this.c(eVar);
                        }
                    }
                } else if ((clN instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) clN).cmH() != null) {
                    ((com.baidu.tieba.pb.videopb.b) clN).cmH().a(z, i, i2, i3, eVar, str, i4);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void e(com.baidu.tieba.pb.data.e eVar) {
                Fragment clN = PbActivity.this.clN();
                if ((clN instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) clN).cmH() != null) {
                    ((com.baidu.tieba.pb.videopb.b) clN).cmH().e(eVar);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
                Fragment clN = PbActivity.this.clN();
                if ((clN instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) clN).cmH() != null) {
                    ((com.baidu.tieba.pb.videopb.b) clN).cmH().a(i, z, responsedMessage, z2, j);
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
                        PbActivity.this.iEl = false;
                        return;
                    }
                    PbActivity.this.iEl = true;
                    PbActivity.this.iEj.setIsLoading(false);
                    Fragment clN = PbActivity.this.clN();
                    if (clN == null) {
                        PbActivity.this.iEj.b(pbData, 2);
                        if (PbActivity.this.aon == null) {
                            PbActivity.this.c(pbData);
                        }
                    } else if (clN instanceof PbFragment) {
                        PbActivity.this.iEi.a(pbData, pbPageReadLocalResponseMessage.getUpdateType(), pbPageReadLocalResponseMessage.getErrorString());
                    }
                }
            }
        });
        this.iEi.cnK();
        if (this.iEi.cnu()) {
            com.baidu.tieba.pb.data.e aG = this.iEi.aG(com.baidu.tieba.frs.i.bDD());
            if (aG != null) {
                aG.yA(3);
                if (clN() == null) {
                    this.iEj.b(aG, 1);
                    if (this.aon == null) {
                        c(aG);
                    }
                }
            }
            this.iEj.setIsLoading(false);
            return;
        }
        showLoadingView(findViewById(R.id.container), true);
        this.iEj.setIsLoading(true);
    }

    public Fragment clN() {
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
            this.aon = FL(d);
            supportFragmentManager.beginTransaction().add(R.id.container, this.aon, d).commitAllowingStateLoss();
        }
    }

    private String d(com.baidu.tieba.pb.data.e eVar) {
        return (eVar == null || !eVar.aHK()) ? "pb_fragment_tag" : "video_pb_fragment_tag";
    }

    private Fragment FL(String str) {
        return "video_pb_fragment_tag".equals(str) ? VideoPbFragment.csz() : PbFragment.cmp();
    }

    public PbModel clB() {
        return this.iEi;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        Fragment clN = clN();
        if (clN instanceof BaseFragment) {
            ((BaseFragment) clN).onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Fragment clN = clN();
        if (clN != null) {
            clN.onActivityResult(i, i2, intent);
        }
    }

    public void clO() {
        super.finish();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.mIsFromSchema) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        }
        Fragment clN = clN();
        if (clN instanceof com.baidu.tieba.pb.videopb.b) {
            ((com.baidu.tieba.pb.videopb.b) clN).finish();
        } else {
            super.finish();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        Fragment clN = clN();
        if (clN instanceof PbFragment) {
            ((PbFragment) clN).onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Fragment clN = clN();
        if (clN instanceof PbFragment) {
            if (((PbFragment) clN).onKeyDown(i, keyEvent)) {
                return true;
            }
        } else if ((clN instanceof VideoPbFragment) && ((VideoPbFragment) clN).onKeyDown(i, keyEvent)) {
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
        if (this.iEi != null) {
            this.iEi.au(bundle);
        }
        if (this.gol != null) {
            this.gol.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.gol != null) {
            this.gol.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gol != null) {
            this.gol.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gol != null) {
            this.gol.onResume(getPageContext());
        }
        if (this.aon instanceof BaseFragment) {
            ((BaseFragment) this.aon).setPrimary(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.gol != null) {
            this.gol.onStop(getPageContext());
        }
        if (this.aon instanceof BaseFragment) {
            ((BaseFragment) this.aon).setPrimary(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gol != null) {
            this.gol.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        return 0L;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a clq() {
        return this.iEk;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean clr() {
        if (this.iEi == null) {
            return false;
        }
        return this.iEi.clr();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String cls() {
        if (this.iEi != null) {
            return this.iEi.cls();
        }
        return null;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int clt() {
        if (this.iEi == null || this.iEi.getPbData() == null) {
            return 0;
        }
        return this.iEi.getPbData().ckG();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean FK(String str) {
        return this.iEi != null && this.iEi.FV(str);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.PB;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            if (this.iEi != null) {
                if (this.iEi.getPbData() != null) {
                    pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.iEi.getPbData().getForumId(), 0L));
                }
                pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.iEi.cny(), 0L));
            }
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.vE(TbadkCoreApplication.getInst().getAdAdSense().dlY);
            }
            Fragment clN = clN();
            if (clN instanceof PbFragment) {
                if (((PbFragment) clN).iIg == 2) {
                    pageStayDurationItem.vF(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                } else if (((PbFragment) clN).iIg == 1) {
                    pageStayDurationItem.vF(PageStayDurationConstants.PageName.HOMEPAGE_CONCERN);
                } else if (((PbFragment) clN).iIg == 3) {
                    pageStayDurationItem.vF(PageStayDurationConstants.PageName.FRS);
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
        if (this.iEi != null) {
            this.iEj.setIsLoading(true);
            showLoadingView(this.mRootView);
            this.iEi.cnK();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.gol;
    }

    public void bEk() {
        if (this.gol != null) {
            this.gol.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected boolean shouldChangeStatusBarIconAndTextColor() {
        return !(this.aon instanceof VideoPbFragment);
    }

    public View getRootView() {
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        Fragment clN = clN();
        if (clN instanceof VideoPbFragment) {
            ((VideoPbFragment) clN).onKeyboardVisibilityChanged(z);
        }
    }
}
