package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;
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
import com.baidu.tbadk.core.dialog.WriteTipBubbleController;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.mutiprocess.prePageKey.PrePageKeyEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.h.a;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class PbActivity extends BaseFragmentActivity implements VoiceManager.c, com.baidu.tieba.pb.pb.a<PbActivity> {
    private Fragment bip;
    private com.baidu.tieba.NEGFeedBack.a jfW;
    private VoiceManager jfh;
    private PbModel lIY;
    private VideoPbViewModel lIZ;
    private boolean lJc;
    private com.baidu.tieba.pb.pb.main.a lJd;
    private am lJe;
    private boolean lJf;
    private View mRootView;
    public final com.baidu.tieba.pb.pb.main.b.a lJa = new com.baidu.tieba.pb.pb.main.b.a(this);
    public final com.baidu.tieba.pb.pb.main.b.c lJb = new com.baidu.tieba.pb.pb.main.b.c(getPageContext());
    private boolean mIsFromSchema = false;

    /* loaded from: classes2.dex */
    public static class a {
        public ConcurrentHashMap<String, ImageUrlData> eMr;
        public ArrayList<String> lJl;
        public boolean lJm;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public String postId = null;
        public boolean eMp = false;
        public boolean lJn = false;
        public String lastId = "";
        public int index = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        initUniqueId();
        aB(bundle);
        if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !com.baidu.adp.base.b.kC().bo("MainTabActivity")) {
            this.mIsFromSchema = true;
            int loadInt = TbadkSettings.getInst().loadInt(SharedPrefConfig.PREFS_SKIN_TYPE, 0);
            if (loadInt != 1) {
                com.baidu.tbadk.core.util.ao.C(false, true);
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
        dog();
        initData(bundle);
        this.jfh = new VoiceManager();
        this.jfh.onCreate(getPageContext());
        this.lJd = new com.baidu.tieba.pb.pb.main.a(getPageContext());
        this.lJe = new am(getPageContext());
        this.jfW = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "client_pb_live");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.bip instanceof VideoPbFragment) {
            ((VideoPbFragment) this.bip).onWindowFocusChanged(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i == 0) {
            if ((this.bip instanceof PbFragment) && ((PbFragment) this.bip).doJ() != null) {
                ((PbFragment) this.bip).doJ().bFr();
                return;
            } else if ((this.bip instanceof VideoPbFragment) && ((VideoPbFragment) this.bip).doJ() != null) {
                ((VideoPbFragment) this.bip).doJ().bFr();
                return;
            } else {
                return;
            }
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    private void dog() {
        this.lIZ = (VideoPbViewModel) ViewModelProviders.of(this).get(VideoPbViewModel.class);
        this.lIZ.init(getIntent());
    }

    private void aB(Bundle bundle) {
        this.lIY = new PbModel(this);
        if (bundle != null) {
            this.lIY.initWithBundle(bundle);
            return;
        }
        this.lIY.initWithIntent(getIntent());
    }

    private void initData(Bundle bundle) {
        this.lIZ.i(this.lIY);
        aj.drv().aY(this.lIY.dpT(), this.lIY.getIsFromMark());
        this.lIY.a(new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
                PbActivity.this.lIZ.setIsLoading(false);
                PbActivity.this.hideLoadingView(PbActivity.this.mRootView);
                if (!z) {
                    if (!PbActivity.this.lJc && !PbActivity.this.lIY.dpS()) {
                        PbActivity.this.showNetRefreshView(PbActivity.this.mRootView, PbActivity.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                        PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbActivity.this.getActivity(), R.dimen.ds360));
                    }
                } else if (fVar != null) {
                    PbActivity.this.hideNetRefreshView(PbActivity.this.mRootView);
                }
                Fragment doh = PbActivity.this.doh();
                if (doh == null) {
                    if (z) {
                        PbActivity.this.lIZ.b(fVar, 3);
                        if (PbActivity.this.bip == null) {
                            PbActivity.this.c(fVar);
                        }
                    }
                } else if ((doh instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) doh).dpb() != null) {
                    ((com.baidu.tieba.pb.videopb.b) doh).dpb().a(z, i, i2, i3, fVar, str, i4);
                }
                final String stringExtra = PbActivity.this.getIntent().getStringExtra("key_open_editor_tips");
                if (!TextUtils.isEmpty(stringExtra) && !PbActivity.this.lJf) {
                    com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!(PbActivity.this.bip instanceof PbFragment) || ((PbFragment) PbActivity.this.bip).doO() == null || ((PbFragment) PbActivity.this.bip).doO().dtf() == null) {
                                if ((PbActivity.this.bip instanceof VideoPbFragment) && ((VideoPbFragment) PbActivity.this.bip).dtf() != null) {
                                    PbActivity.this.a(((VideoPbFragment) PbActivity.this.bip).dtf(), ((VideoPbFragment) PbActivity.this.bip).doJ(), stringExtra);
                                    PbActivity.this.lJf = true;
                                    return;
                                }
                                return;
                            }
                            PbActivity.this.a(((PbFragment) PbActivity.this.bip).doO().dtf(), ((PbFragment) PbActivity.this.bip).doJ(), stringExtra);
                            PbActivity.this.lJf = true;
                        }
                    }, 100L);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void e(com.baidu.tieba.pb.data.f fVar) {
                Fragment doh = PbActivity.this.doh();
                if ((doh instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) doh).dpb() != null) {
                    ((com.baidu.tieba.pb.videopb.b) doh).dpb().e(fVar);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
                Fragment doh = PbActivity.this.doh();
                if ((doh instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) doh).dpb() != null) {
                    ((com.baidu.tieba.pb.videopb.b) doh).dpb().a(i, z, responsedMessage, z2, j);
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
                        PbActivity.this.lJc = false;
                        return;
                    }
                    PbActivity.this.lJc = true;
                    PbActivity.this.lIZ.setIsLoading(false);
                    Fragment doh = PbActivity.this.doh();
                    if (doh == null) {
                        PbActivity.this.lIZ.b(pbData, 2);
                        if (PbActivity.this.bip == null) {
                            PbActivity.this.c(pbData);
                        }
                    } else if (doh instanceof PbFragment) {
                        PbActivity.this.lIY.a(pbData, pbPageReadLocalResponseMessage.getUpdateType(), pbPageReadLocalResponseMessage.getErrorString());
                    }
                }
            }
        });
        this.lIY.dqk();
        doi();
        if (this.lIY.dpS()) {
            com.baidu.tieba.pb.data.f aL = this.lIY.aL(com.baidu.tieba.frs.l.cEN());
            if (aL != null) {
                aL.GH(3);
                if (doh() == null) {
                    this.lIZ.b(aL, 1);
                    if (this.bip == null) {
                        c(aL);
                    }
                }
            }
            this.lIZ.setIsLoading(false);
        } else {
            showLoadingView(findViewById(R.id.container), true);
            this.lIZ.setIsLoading(true);
        }
        if (com.baidu.adp.lib.util.l.isNetOk() && !TbadkCoreApplication.getInst().syncHasFinish) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final View view, final com.baidu.tbadk.editortools.pb.e eVar, String str) {
        new WriteTipBubbleController(getPageContext(), new WriteTipBubbleController.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.3
            @Override // com.baidu.tbadk.core.dialog.WriteTipBubbleController.a
            public void f(View view2, String str2) {
                view.performClick();
                eVar.bFC();
                eVar.bFo().getInputView().setText(str2);
                Editable text = eVar.bFo().getInputView().getText();
                if (!TextUtils.isEmpty(text)) {
                    eVar.bFo().getInputView().setSelection(text.length());
                }
            }
        }).a(view, getString(R.string.open_editor_tips), str, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_PB_REPLY);
    }

    public Fragment doh() {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (com.baidu.tbadk.core.util.x.isEmpty(fragments)) {
            return null;
        }
        return fragments.get(0);
    }

    private void doi() {
        boolean z = true;
        if (!((TbadkApplication.getCurrentAccountInfo() == null || TbadkApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() != 1) ? false : false) && com.baidu.tbadk.a.d.bmB() && com.baidu.tbadk.core.util.x.isEmpty(com.baidu.tieba.h.a.cPm().LN("6051001308-627527144"))) {
            com.baidu.tieba.h.a.cPm().b(this, "6051001308-627527144", new a.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
                @Override // com.baidu.tieba.h.a.d
                public void a(String str, com.baidu.tieba.tbadkCore.data.n nVar) {
                    if (PbActivity.this.bip instanceof PbFragment) {
                        PbFragment pbFragment = (PbFragment) PbActivity.this.bip;
                        if (pbFragment.doO() != null && pbFragment.doO().dsg() != null) {
                            pbFragment.doO().dsg().dos();
                        }
                    }
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c14005").an("obj_source", 6).dX("obj_type", PageStayDurationConstants.PageName.PB).an("obj_locate", 0));
                }

                @Override // com.baidu.tieba.h.a.d
                public void onError(String str) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c14005").an("obj_source", 6).dX("obj_type", PageStayDurationConstants.PageName.PB).an("obj_locate", 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.pb.data.f fVar) {
        String d = d(fVar);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager.findFragmentByTag(d) == null) {
            this.bip = PF(d);
            supportFragmentManager.beginTransaction().add(R.id.container, this.bip, d).commitAllowingStateLoss();
        }
    }

    private String d(com.baidu.tieba.pb.data.f fVar) {
        return (fVar == null || !fVar.dne()) ? "pb_fragment_tag" : "video_pb_fragment_tag";
    }

    private Fragment PF(String str) {
        return "video_pb_fragment_tag".equals(str) ? VideoPbFragment.dvr() : PbFragment.doK();
    }

    public PbModel dnV() {
        return this.lIY;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        Fragment doh = doh();
        if (doh instanceof BaseFragment) {
            ((BaseFragment) doh).onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Fragment doh = doh();
        if (doh != null) {
            doh.onActivityResult(i, i2, intent);
        }
    }

    public void doj() {
        super.finish();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.lJd != null && !this.lJd.a(this.lIY) && this.mIsFromSchema) {
            if (TbadkApplication.getInst().isNeedNewUserLead() && TbadkApplication.getInst().getIsFirstUse()) {
                sendMessage(new CustomMessage(2921454, new IntentConfig(this)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
        }
        if ((!TbadkApplication.getInst().isNeedNewUserLead() || !TbadkApplication.getInst().getIsFirstUse()) && this.lJe != null) {
            this.lJe.h(this.lIY);
        }
        Fragment doh = doh();
        if (doh instanceof com.baidu.tieba.pb.videopb.b) {
            ((com.baidu.tieba.pb.videopb.b) doh).finish();
        } else {
            super.finish();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        Fragment doh = doh();
        if (doh instanceof PbFragment) {
            ((PbFragment) doh).onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Fragment doh = doh();
        if (doh instanceof PbFragment) {
            if (((PbFragment) doh).onKeyDown(i, keyEvent)) {
                return true;
            }
        } else if ((doh instanceof VideoPbFragment) && ((VideoPbFragment) doh).onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.lIY != null) {
            this.lIY.aD(bundle);
        }
        if (this.jfh != null) {
            this.jfh.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.jfh != null) {
            this.jfh.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.jfh != null) {
            this.jfh.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.lIY != null) {
            aj.drv().aY(this.lIY.dpT(), this.lIY.getIsFromMark());
        }
        if (this.jfh != null) {
            this.jfh.onResume(getPageContext());
        }
        if (this.bip instanceof BaseFragment) {
            ((BaseFragment) this.bip).setPrimary(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.jfh != null) {
            this.jfh.onStop(getPageContext());
        }
        if (this.bip instanceof BaseFragment) {
            ((BaseFragment) this.bip).setPrimary(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jfh != null) {
            this.jfh.onDestory(getPageContext());
        }
        if (this.jfW != null) {
            this.jfW.onDestroy();
        }
        com.baidu.tbadk.pageExtra.d.Ek(getCurrentPageKey());
        com.baidu.tbadk.mutiprocess.g.publishEvent(new PrePageKeyEvent(getCurrentPageKey()));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        return 0L;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a dnM() {
        return this.lJa;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean dnN() {
        if (this.lIY == null) {
            return false;
        }
        return this.lIY.dnN();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String dnO() {
        if (this.lIY != null) {
            return this.lIY.dnO();
        }
        return null;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int dnP() {
        if (this.lIY == null || this.lIY.getPbData() == null) {
            return 0;
        }
        return this.lIY.getPbData().dmT();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean PE(String str) {
        return this.lIY != null && this.lIY.PQ(str);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.PB;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            if (this.lIY != null) {
                if (this.lIY.getPbData() != null) {
                    pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.lIY.getPbData().getForumId(), 0L));
                }
                pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.lIY.dpW(), 0L));
                if (this.lIY.getPbData() != null && this.lIY.getPbData().dmE() != null) {
                    pageStayDurationItem.setNid(this.lIY.getPbData().dmE().bpO());
                }
            }
            if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.Er(TbadkCoreApplication.getInst().getAdAdSense().fsN);
            }
            Fragment doh = doh();
            if (doh instanceof PbFragment) {
                if (((PbFragment) doh).lNN == 2) {
                    pageStayDurationItem.Es(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                } else if (((PbFragment) doh).lNN == 1) {
                    pageStayDurationItem.Es(PageStayDurationConstants.PageName.HOMEPAGE_CONCERN);
                } else if (((PbFragment) doh).lNN == 3) {
                    pageStayDurationItem.Es(PageStayDurationConstants.PageName.FRS);
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
        if (this.lIY != null) {
            this.lIZ.setIsLoading(true);
            showLoadingView(this.mRootView);
            this.lIY.dqk();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.jfh;
    }

    public void cFz() {
        if (this.jfh != null) {
            this.jfh.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected boolean shouldChangeStatusBarIconAndTextColor() {
        return !(this.bip instanceof VideoPbFragment);
    }

    public View getRootView() {
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        Fragment doh = doh();
        if (doh instanceof VideoPbFragment) {
            ((VideoPbFragment) doh).onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onScreenShot(String str) {
        super.onScreenShot(str);
        if (this.lIY != null && this.lIY.getPbData() != null) {
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13848");
            aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dX("tid", this.lIY.dpW());
            aqVar.dX("fid", this.lIY.getPbData().getForumId());
            aqVar.an("obj_type", 3);
            TiebaStatic.log(aqVar);
        }
    }
}
