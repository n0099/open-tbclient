package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
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
    private Fragment bii;
    private com.baidu.tieba.NEGFeedBack.a jiT;
    private VoiceManager jie;
    private boolean lPC;
    private com.baidu.tieba.pb.pb.main.a lPD;
    private am lPE;
    private boolean lPF;
    private a.b lPG;
    private PbModel lPy;
    private VideoPbViewModel lPz;
    private View mRootView;
    public final com.baidu.tieba.pb.pb.main.b.a lPA = new com.baidu.tieba.pb.pb.main.b.a(this);
    public final com.baidu.tieba.pb.pb.main.b.c lPB = new com.baidu.tieba.pb.pb.main.b.c(getPageContext());
    private boolean mIsFromSchema = false;

    /* loaded from: classes2.dex */
    public static class a {
        public ConcurrentHashMap<String, ImageUrlData> eLn;
        public ArrayList<String> lPM;
        public boolean lPN;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public String postId = null;
        public boolean eLl = false;
        public boolean lPO = false;
        public String lastId = "";
        public int index = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        initUniqueId();
        aB(bundle);
        if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !com.baidu.adp.base.b.kB().bs("MainTabActivity")) {
            this.mIsFromSchema = true;
            int loadInt = TbadkSettings.getInst().loadInt(SharedPrefConfig.PREFS_SKIN_TYPE, 0);
            if (loadInt != 1) {
                com.baidu.tbadk.core.util.ap.B(false, true);
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
        dmR();
        initData(bundle);
        this.jie = new VoiceManager();
        this.jie.onCreate(getPageContext());
        this.lPD = new com.baidu.tieba.pb.pb.main.a(getPageContext());
        this.lPE = new am(getPageContext());
        this.jiT = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "client_pb_live");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.bii instanceof VideoPbFragment) {
            ((VideoPbFragment) this.bii).onWindowFocusChanged(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i == 0) {
            if ((this.bii instanceof PbFragment) && ((PbFragment) this.bii).dnw() != null) {
                ((PbFragment) this.bii).dnw().bBT();
                return;
            } else if ((this.bii instanceof VideoPbFragment) && ((VideoPbFragment) this.bii).dnw() != null) {
                ((VideoPbFragment) this.bii).dnw().bBT();
                return;
            } else {
                return;
            }
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    private void dmR() {
        this.lPz = (VideoPbViewModel) ViewModelProviders.of(this).get(VideoPbViewModel.class);
        this.lPz.init(getIntent());
    }

    private void aB(Bundle bundle) {
        this.lPy = new PbModel(this);
        if (bundle != null) {
            this.lPy.initWithBundle(bundle);
            return;
        }
        this.lPy.initWithIntent(getIntent());
    }

    private void initData(Bundle bundle) {
        this.lPz.i(this.lPy);
        aj.dqi().aX(this.lPy.doG(), this.lPy.getIsFromMark());
        this.lPy.a(new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
                PbActivity.this.lPz.setIsLoading(false);
                PbActivity.this.hideLoadingView(PbActivity.this.mRootView);
                if (!z) {
                    if (!PbActivity.this.lPC && !PbActivity.this.lPy.doF()) {
                        PbActivity.this.showNetRefreshView(PbActivity.this.mRootView, PbActivity.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                        PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbActivity.this.getActivity(), R.dimen.ds360));
                    }
                } else if (fVar != null) {
                    PbActivity.this.hideNetRefreshView(PbActivity.this.mRootView);
                }
                Fragment dmS = PbActivity.this.dmS();
                if (dmS == null) {
                    if (z) {
                        PbActivity.this.lPz.b(fVar, 3);
                        if (PbActivity.this.bii == null) {
                            PbActivity.this.c(fVar);
                        }
                    }
                } else if ((dmS instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) dmS).dnO() != null) {
                    ((com.baidu.tieba.pb.videopb.b) dmS).dnO().a(z, i, i2, i3, fVar, str, i4);
                }
                final String stringExtra = PbActivity.this.getIntent().getStringExtra("key_open_editor_tips");
                if (!TextUtils.isEmpty(stringExtra) && !PbActivity.this.lPF) {
                    com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!(PbActivity.this.bii instanceof PbFragment) || ((PbFragment) PbActivity.this.bii).dnB() == null || ((PbFragment) PbActivity.this.bii).dnB().drS() == null) {
                                if ((PbActivity.this.bii instanceof VideoPbFragment) && ((VideoPbFragment) PbActivity.this.bii).drS() != null) {
                                    PbActivity.this.a(((VideoPbFragment) PbActivity.this.bii).drS(), ((VideoPbFragment) PbActivity.this.bii).dnw(), stringExtra);
                                    PbActivity.this.lPF = true;
                                    return;
                                }
                                return;
                            }
                            PbActivity.this.a(((PbFragment) PbActivity.this.bii).dnB().drS(), ((PbFragment) PbActivity.this.bii).dnw(), stringExtra);
                            PbActivity.this.lPF = true;
                        }
                    }, 100L);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void e(com.baidu.tieba.pb.data.f fVar) {
                Fragment dmS = PbActivity.this.dmS();
                if ((dmS instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) dmS).dnO() != null) {
                    ((com.baidu.tieba.pb.videopb.b) dmS).dnO().e(fVar);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
                Fragment dmS = PbActivity.this.dmS();
                if ((dmS instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) dmS).dnO() != null) {
                    ((com.baidu.tieba.pb.videopb.b) dmS).dnO().a(i, z, responsedMessage, z2, j);
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
                        PbActivity.this.lPC = false;
                        return;
                    }
                    PbActivity.this.lPC = true;
                    PbActivity.this.lPz.setIsLoading(false);
                    Fragment dmS = PbActivity.this.dmS();
                    if (dmS == null) {
                        PbActivity.this.lPz.b(pbData, 2);
                        if (PbActivity.this.bii == null) {
                            PbActivity.this.c(pbData);
                        }
                    } else if (dmS instanceof PbFragment) {
                        PbActivity.this.lPy.a(pbData, pbPageReadLocalResponseMessage.getUpdateType(), pbPageReadLocalResponseMessage.getErrorString());
                    }
                }
            }
        });
        this.lPy.doX();
        if (this.lPy.doF()) {
            com.baidu.tieba.pb.data.f aM = this.lPy.aM(com.baidu.tieba.frs.l.cCv());
            if (aM != null) {
                aM.Fx(3);
                if (dmS() == null) {
                    this.lPz.b(aM, 1);
                    if (this.bii == null) {
                        c(aM);
                    }
                }
            }
            this.lPz.setIsLoading(false);
        } else {
            showLoadingView(findViewById(R.id.container), true);
            this.lPz.setIsLoading(true);
        }
        if (com.baidu.adp.lib.util.l.isNetOk() && !TbadkCoreApplication.getInst().syncHasFinish) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        }
        dmT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final View view, final com.baidu.tbadk.editortools.pb.e eVar, String str) {
        new WriteTipBubbleController(getPageContext(), new WriteTipBubbleController.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.3
            @Override // com.baidu.tbadk.core.dialog.WriteTipBubbleController.a
            public void g(View view2, String str2) {
                view.performClick();
                eVar.bCe();
                eVar.bBQ().getInputView().setText(str2);
                Editable text = eVar.bBQ().getInputView().getText();
                if (!TextUtils.isEmpty(text)) {
                    eVar.bBQ().getInputView().setSelection(text.length());
                }
            }
        }).a(view, getString(R.string.open_editor_tips), str, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_PB_REPLY);
    }

    public Fragment dmS() {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (com.baidu.tbadk.core.util.y.isEmpty(fragments)) {
            return null;
        }
        return fragments.get(0);
    }

    private void dmT() {
        boolean z = true;
        if (TbadkApplication.getCurrentAccountInfo() == null || TbadkApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() != 1) {
            z = false;
        }
        if (!z && com.baidu.tbadk.a.d.biW()) {
            Activity aa = com.baidu.adp.base.b.kB().aa(0);
            if (this.lPG == null) {
                this.lPG = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
                    @Override // com.baidu.tieba.h.a.b
                    public void aE(String str, int i) {
                        if (PbActivity.this.bii instanceof PbFragment) {
                            PbFragment pbFragment = (PbFragment) PbActivity.this.bii;
                            if (pbFragment.dnB() != null && pbFragment.dnB().dqT() != null) {
                                pbFragment.dnB().dqT().dnd();
                            }
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c14005").aq("obj_source", 6).dR("obj_type", PageStayDurationConstants.PageName.PB).aq("obj_locate", 0).aq("resource_id", i));
                    }

                    @Override // com.baidu.tieba.h.a.b
                    public void onError(String str) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c14005").aq("obj_source", 6).dR("obj_type", PageStayDurationConstants.PageName.PB).aq("obj_locate", 1).aq("resource_id", 0));
                    }
                };
            }
            com.baidu.tieba.h.a cNx = com.baidu.tieba.h.a.cNx();
            if (aa == null) {
                aa = this;
            }
            cNx.b(aa, "6051001775-457565154", this.lPG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.pb.data.f fVar) {
        String d = d(fVar);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager.findFragmentByTag(d) == null) {
            this.bii = Pv(d);
            supportFragmentManager.beginTransaction().add(R.id.container, this.bii, d).commitAllowingStateLoss();
        }
    }

    private String d(com.baidu.tieba.pb.data.f fVar) {
        return (fVar == null || !fVar.dlP()) ? "pb_fragment_tag" : "video_pb_fragment_tag";
    }

    private Fragment Pv(String str) {
        return "video_pb_fragment_tag".equals(str) ? VideoPbFragment.dud() : PbFragment.dnx();
    }

    public PbModel dmG() {
        return this.lPy;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        Fragment dmS = dmS();
        if (dmS instanceof BaseFragment) {
            ((BaseFragment) dmS).onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Fragment dmS = dmS();
        if (dmS != null) {
            dmS.onActivityResult(i, i2, intent);
        }
    }

    public void dmU() {
        super.finish();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.lPD != null && !this.lPD.a(this.lPy) && this.mIsFromSchema) {
            if (TbadkApplication.getInst().isNeedNewUserLead() && TbadkApplication.getInst().getIsFirstUse()) {
                sendMessage(new CustomMessage(2921454, new IntentConfig(this)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
        }
        if ((!TbadkApplication.getInst().isNeedNewUserLead() || !TbadkApplication.getInst().getIsFirstUse()) && this.lPE != null) {
            this.lPE.h(this.lPy);
        }
        Fragment dmS = dmS();
        if (dmS instanceof com.baidu.tieba.pb.videopb.b) {
            ((com.baidu.tieba.pb.videopb.b) dmS).finish();
        } else {
            super.finish();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        Fragment dmS = dmS();
        if (dmS instanceof PbFragment) {
            ((PbFragment) dmS).onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Fragment dmS = dmS();
        if (dmS instanceof PbFragment) {
            if (((PbFragment) dmS).onKeyDown(i, keyEvent)) {
                return true;
            }
        } else if ((dmS instanceof VideoPbFragment) && ((VideoPbFragment) dmS).onKeyDown(i, keyEvent)) {
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
        if (this.lPy != null) {
            this.lPy.aD(bundle);
        }
        if (this.jie != null) {
            this.jie.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.jie != null) {
            this.jie.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.jie != null) {
            this.jie.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.lPy != null) {
            aj.dqi().aX(this.lPy.doG(), this.lPy.getIsFromMark());
        }
        if (this.jie != null) {
            this.jie.onResume(getPageContext());
        }
        if (this.bii instanceof BaseFragment) {
            ((BaseFragment) this.bii).setPrimary(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.jie != null) {
            this.jie.onStop(getPageContext());
        }
        if (this.bii instanceof BaseFragment) {
            ((BaseFragment) this.bii).setPrimary(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jie != null) {
            this.jie.onDestory(getPageContext());
        }
        if (this.jiT != null) {
            this.jiT.onDestroy();
        }
        com.baidu.tbadk.pageExtra.d.Du(getCurrentPageKey());
        com.baidu.tbadk.mutiprocess.g.publishEvent(new PrePageKeyEvent(getCurrentPageKey()));
        if (this.lPG != null) {
            this.lPG = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        return 0L;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a dmx() {
        return this.lPA;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean dmy() {
        if (this.lPy == null) {
            return false;
        }
        return this.lPy.dmy();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String dmz() {
        if (this.lPy != null) {
            return this.lPy.dmz();
        }
        return null;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int dmA() {
        if (this.lPy == null || this.lPy.getPbData() == null) {
            return 0;
        }
        return this.lPy.getPbData().dlE();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean Pu(String str) {
        return this.lPy != null && this.lPy.PG(str);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.PB;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            if (this.lPy != null) {
                if (this.lPy.getPbData() != null) {
                    pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.lPy.getPbData().getForumId(), 0L));
                }
                pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.lPy.doJ(), 0L));
                if (this.lPy.getPbData() != null && this.lPy.getPbData().dlp() != null) {
                    pageStayDurationItem.setNid(this.lPy.getPbData().dlp().bmq());
                }
            }
            if (!com.baidu.tbadk.core.util.au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.DB(TbadkCoreApplication.getInst().getAdAdSense().frW);
            }
            Fragment dmS = dmS();
            if (dmS instanceof PbFragment) {
                if (((PbFragment) dmS).lUw == 2) {
                    pageStayDurationItem.DC(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                } else if (((PbFragment) dmS).lUw == 1) {
                    pageStayDurationItem.DC(PageStayDurationConstants.PageName.HOMEPAGE_CONCERN);
                } else if (((PbFragment) dmS).lUw == 3) {
                    pageStayDurationItem.DC(PageStayDurationConstants.PageName.FRS);
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
        if (this.lPy != null) {
            this.lPz.setIsLoading(true);
            showLoadingView(this.mRootView);
            this.lPy.doX();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.jie;
    }

    public void cDh() {
        if (this.jie != null) {
            this.jie.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected boolean shouldChangeStatusBarIconAndTextColor() {
        return !(this.bii instanceof VideoPbFragment);
    }

    public View getRootView() {
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        Fragment dmS = dmS();
        if (dmS instanceof VideoPbFragment) {
            ((VideoPbFragment) dmS).onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onScreenShot(String str) {
        super.onScreenShot(str);
        if (this.lPy != null && this.lPy.getPbData() != null) {
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13848");
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.dR("tid", this.lPy.doJ());
            arVar.dR("fid", this.lPy.getPbData().getForumId());
            arVar.aq("obj_type", 3);
            TiebaStatic.log(arVar);
        }
    }
}
