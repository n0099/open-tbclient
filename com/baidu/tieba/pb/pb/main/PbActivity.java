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
/* loaded from: classes7.dex */
public class PbActivity extends BaseFragmentActivity implements VoiceManager.c, com.baidu.tieba.pb.pb.a<PbActivity> {
    private Fragment ama;
    private VoiceManager gmi;
    private boolean iCA;
    private PbModel iCx;
    private com.baidu.tieba.pb.videopb.e iCy;
    public final com.baidu.tieba.pb.pb.main.b.a iCz = new com.baidu.tieba.pb.pb.main.b.a(this);
    private View mRootView;

    /* loaded from: classes7.dex */
    public static class a {
        public ArrayList<String> iCC;
        public ConcurrentHashMap<String, ImageUrlData> iCD;
        public boolean iCF;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public String postId = null;
        public boolean iCE = false;
        public boolean iCG = false;
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
        ckp();
        initData(bundle);
        this.gmi = new VoiceManager();
        this.gmi.onCreate(getPageContext());
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.ama instanceof VideoPbFragment) {
            ((VideoPbFragment) this.ama).onWindowFocusChanged(z);
        }
    }

    public void cko() {
        if (this.mRootView != null && !TbSingleton.getInstance().isNotchScreen(this) && !TbSingleton.getInstance().isCutoutScreen(this)) {
            this.mRootView.setSystemUiVisibility(4);
        }
    }

    private void ckp() {
        this.iCy = (com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(this).l(com.baidu.tieba.pb.videopb.e.class);
        this.iCy.init(getIntent());
    }

    private void as(Bundle bundle) {
        this.iCx = new PbModel(this);
        if (bundle != null) {
            this.iCx.initWithBundle(bundle);
            return;
        }
        this.iCx.initWithIntent(getIntent());
    }

    private void initData(Bundle bundle) {
        this.iCy.g(this.iCx);
        ak.cnx().au(this.iCx.clZ(), this.iCx.getIsFromMark());
        this.iCx.a(new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
                PbActivity.this.iCy.setIsLoading(false);
                PbActivity.this.hideLoadingView(PbActivity.this.mRootView);
                if (!z) {
                    if (!PbActivity.this.iCA && !PbActivity.this.iCx.clY()) {
                        PbActivity.this.showNetRefreshView(PbActivity.this.mRootView, PbActivity.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                        PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbActivity.this.getActivity(), R.dimen.ds360));
                    }
                } else if (fVar != null) {
                    PbActivity.this.hideNetRefreshView(PbActivity.this.mRootView);
                }
                Fragment ckq = PbActivity.this.ckq();
                if (ckq == null) {
                    if (z) {
                        PbActivity.this.iCy.b(fVar, 3);
                        if (PbActivity.this.ama == null) {
                            PbActivity.this.c(fVar);
                        }
                    }
                } else if ((ckq instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) ckq).cll() != null) {
                    ((com.baidu.tieba.pb.videopb.b) ckq).cll().a(z, i, i2, i3, fVar, str, i4);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void e(com.baidu.tieba.pb.data.f fVar) {
                Fragment ckq = PbActivity.this.ckq();
                if ((ckq instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) ckq).cll() != null) {
                    ((com.baidu.tieba.pb.videopb.b) ckq).cll().e(fVar);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
                Fragment ckq = PbActivity.this.ckq();
                if ((ckq instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) ckq).cll() != null) {
                    ((com.baidu.tieba.pb.videopb.b) ckq).cll().a(i, z, responsedMessage, z2, j);
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
                        PbActivity.this.iCA = false;
                        return;
                    }
                    PbActivity.this.iCA = true;
                    PbActivity.this.iCy.setIsLoading(false);
                    Fragment ckq = PbActivity.this.ckq();
                    if (ckq == null) {
                        PbActivity.this.iCy.b(pbData, 2);
                        if (PbActivity.this.ama == null) {
                            PbActivity.this.c(pbData);
                        }
                    } else if (ckq instanceof PbFragment) {
                        PbActivity.this.iCx.a(pbData, pbPageReadLocalResponseMessage.getUpdateType(), pbPageReadLocalResponseMessage.getErrorString());
                    }
                }
            }
        });
        this.iCx.cmo();
        if (this.iCx.clY()) {
            com.baidu.tieba.pb.data.f aD = this.iCx.aD(com.baidu.tieba.frs.i.bBY());
            if (aD != null) {
                aD.yt(3);
                if (ckq() == null) {
                    this.iCy.b(aD, 1);
                    if (this.ama == null) {
                        c(aD);
                    }
                }
            }
            this.iCy.setIsLoading(false);
            return;
        }
        showLoadingView(findViewById(R.id.container), true);
        this.iCy.setIsLoading(true);
    }

    public Fragment ckq() {
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
            this.ama = Fw(d);
            supportFragmentManager.beginTransaction().add(R.id.container, this.ama, d).commitAllowingStateLoss();
        }
    }

    private String d(com.baidu.tieba.pb.data.f fVar) {
        return (fVar == null || !fVar.cjp()) ? "pb_fragment_tag" : "video_pb_fragment_tag";
    }

    private Fragment Fw(String str) {
        return "video_pb_fragment_tag".equals(str) ? VideoPbFragment.crg() : PbFragment.ckT();
    }

    public PbModel ckc() {
        return this.iCx;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        Fragment ckq = ckq();
        if (ckq instanceof BaseFragment) {
            ((BaseFragment) ckq).onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Fragment ckq = ckq();
        if (ckq != null) {
            ckq.onActivityResult(i, i2, intent);
        }
    }

    public void ckr() {
        super.finish();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Fragment ckq = ckq();
        if (ckq instanceof com.baidu.tieba.pb.videopb.b) {
            ((com.baidu.tieba.pb.videopb.b) ckq).finish();
        } else {
            super.finish();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        Fragment ckq = ckq();
        if (ckq instanceof PbFragment) {
            ((PbFragment) ckq).onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Fragment ckq = ckq();
        if (ckq instanceof PbFragment) {
            if (((PbFragment) ckq).onKeyDown(i, keyEvent)) {
                return true;
            }
        } else if ((ckq instanceof VideoPbFragment) && ((VideoPbFragment) ckq).onKeyDown(i, keyEvent)) {
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
        if (this.iCx != null) {
            this.iCx.au(bundle);
        }
        if (this.gmi != null) {
            this.gmi.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.gmi != null) {
            this.gmi.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gmi != null) {
            this.gmi.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gmi != null) {
            this.gmi.onResume(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.gmi != null) {
            this.gmi.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gmi != null) {
            this.gmi.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        return 0L;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a cjQ() {
        return this.iCz;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean cjR() {
        if (this.iCx == null) {
            return false;
        }
        return this.iCx.cjR();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String cjS() {
        if (this.iCx != null) {
            return this.iCx.cjS();
        }
        return null;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int cjT() {
        if (this.iCx == null || this.iCx.getPbData() == null) {
            return 0;
        }
        return this.iCx.getPbData().cje();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean Fv(String str) {
        return this.iCx != null && this.iCx.FH(str);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.PB;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            if (this.iCx != null) {
                if (this.iCx.getPbData() != null) {
                    pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.iCx.getPbData().getForumId(), 0L));
                }
                pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.iCx.cmc(), 0L));
            }
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.vk(TbadkCoreApplication.getInst().getAdAdSense().dhR);
            }
            Fragment ckq = ckq();
            if (ckq instanceof PbFragment) {
                if (((PbFragment) ckq).iGA == 2) {
                    pageStayDurationItem.vl(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                } else if (((PbFragment) ckq).iGA == 1) {
                    pageStayDurationItem.vl(PageStayDurationConstants.PageName.HOMEPAGE_CONCERN);
                } else if (((PbFragment) ckq).iGA == 3) {
                    pageStayDurationItem.vl(PageStayDurationConstants.PageName.FRS);
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
        if (this.iCx != null) {
            this.iCy.setIsLoading(true);
            showLoadingView(this.mRootView);
            this.iCx.cmo();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.gmi;
    }

    public void bCF() {
        if (this.gmi != null) {
            this.gmi.stopPlay();
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
        Fragment ckq = ckq();
        if (ckq instanceof VideoPbFragment) {
            ((VideoPbFragment) ckq).onKeyboardVisibilityChanged(z);
        }
    }
}
