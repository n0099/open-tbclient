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
    private Fragment bdw;
    private VoiceManager jaA;
    private com.baidu.tieba.NEGFeedBack.a jbp;
    private a.d lEA;
    private PbModel lEs;
    private VideoPbViewModel lEt;
    private boolean lEw;
    private com.baidu.tieba.pb.pb.main.a lEx;
    private am lEy;
    private boolean lEz;
    private View mRootView;
    public final com.baidu.tieba.pb.pb.main.b.a lEu = new com.baidu.tieba.pb.pb.main.b.a(this);
    public final com.baidu.tieba.pb.pb.main.b.c lEv = new com.baidu.tieba.pb.pb.main.b.c(getPageContext());
    private boolean mIsFromSchema = false;

    /* loaded from: classes2.dex */
    public static class a {
        public ConcurrentHashMap<String, ImageUrlData> eHG;
        public ArrayList<String> lEG;
        public boolean lEH;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public String postId = null;
        public boolean eHE = false;
        public boolean lEI = false;
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
        dko();
        initData(bundle);
        this.jaA = new VoiceManager();
        this.jaA.onCreate(getPageContext());
        this.lEx = new com.baidu.tieba.pb.pb.main.a(getPageContext());
        this.lEy = new am(getPageContext());
        this.jbp = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "client_pb_live");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.bdw instanceof VideoPbFragment) {
            ((VideoPbFragment) this.bdw).onWindowFocusChanged(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i == 0) {
            if ((this.bdw instanceof PbFragment) && ((PbFragment) this.bdw).dkR() != null) {
                ((PbFragment) this.bdw).dkR().bBy();
                return;
            } else if ((this.bdw instanceof VideoPbFragment) && ((VideoPbFragment) this.bdw).dkR() != null) {
                ((VideoPbFragment) this.bdw).dkR().bBy();
                return;
            } else {
                return;
            }
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    private void dko() {
        this.lEt = (VideoPbViewModel) ViewModelProviders.of(this).get(VideoPbViewModel.class);
        this.lEt.init(getIntent());
    }

    private void aB(Bundle bundle) {
        this.lEs = new PbModel(this);
        if (bundle != null) {
            this.lEs.initWithBundle(bundle);
            return;
        }
        this.lEs.initWithIntent(getIntent());
    }

    private void initData(Bundle bundle) {
        this.lEt.i(this.lEs);
        aj.dnE().aY(this.lEs.dmb(), this.lEs.getIsFromMark());
        this.lEs.a(new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
                PbActivity.this.lEt.setIsLoading(false);
                PbActivity.this.hideLoadingView(PbActivity.this.mRootView);
                if (!z) {
                    if (!PbActivity.this.lEw && !PbActivity.this.lEs.dma()) {
                        PbActivity.this.showNetRefreshView(PbActivity.this.mRootView, PbActivity.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                        PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbActivity.this.getActivity(), R.dimen.ds360));
                    }
                } else if (fVar != null) {
                    PbActivity.this.hideNetRefreshView(PbActivity.this.mRootView);
                }
                Fragment dkp = PbActivity.this.dkp();
                if (dkp == null) {
                    if (z) {
                        PbActivity.this.lEt.b(fVar, 3);
                        if (PbActivity.this.bdw == null) {
                            PbActivity.this.c(fVar);
                        }
                    }
                } else if ((dkp instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) dkp).dlj() != null) {
                    ((com.baidu.tieba.pb.videopb.b) dkp).dlj().a(z, i, i2, i3, fVar, str, i4);
                }
                final String stringExtra = PbActivity.this.getIntent().getStringExtra("key_open_editor_tips");
                if (!TextUtils.isEmpty(stringExtra) && !PbActivity.this.lEz) {
                    com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!(PbActivity.this.bdw instanceof PbFragment) || ((PbFragment) PbActivity.this.bdw).dkW() == null || ((PbFragment) PbActivity.this.bdw).dkW().dpo() == null) {
                                if ((PbActivity.this.bdw instanceof VideoPbFragment) && ((VideoPbFragment) PbActivity.this.bdw).dpo() != null) {
                                    PbActivity.this.a(((VideoPbFragment) PbActivity.this.bdw).dpo(), ((VideoPbFragment) PbActivity.this.bdw).dkR(), stringExtra);
                                    PbActivity.this.lEz = true;
                                    return;
                                }
                                return;
                            }
                            PbActivity.this.a(((PbFragment) PbActivity.this.bdw).dkW().dpo(), ((PbFragment) PbActivity.this.bdw).dkR(), stringExtra);
                            PbActivity.this.lEz = true;
                        }
                    }, 100L);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void e(com.baidu.tieba.pb.data.f fVar) {
                Fragment dkp = PbActivity.this.dkp();
                if ((dkp instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) dkp).dlj() != null) {
                    ((com.baidu.tieba.pb.videopb.b) dkp).dlj().e(fVar);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
                Fragment dkp = PbActivity.this.dkp();
                if ((dkp instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) dkp).dlj() != null) {
                    ((com.baidu.tieba.pb.videopb.b) dkp).dlj().a(i, z, responsedMessage, z2, j);
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
                        PbActivity.this.lEw = false;
                        return;
                    }
                    PbActivity.this.lEw = true;
                    PbActivity.this.lEt.setIsLoading(false);
                    Fragment dkp = PbActivity.this.dkp();
                    if (dkp == null) {
                        PbActivity.this.lEt.b(pbData, 2);
                        if (PbActivity.this.bdw == null) {
                            PbActivity.this.c(pbData);
                        }
                    } else if (dkp instanceof PbFragment) {
                        PbActivity.this.lEs.a(pbData, pbPageReadLocalResponseMessage.getUpdateType(), pbPageReadLocalResponseMessage.getErrorString());
                    }
                }
            }
        });
        this.lEs.dms();
        dkq();
        if (this.lEs.dma()) {
            com.baidu.tieba.pb.data.f aL = this.lEs.aL(com.baidu.tieba.frs.l.cAW());
            if (aL != null) {
                aL.Fb(3);
                if (dkp() == null) {
                    this.lEt.b(aL, 1);
                    if (this.bdw == null) {
                        c(aL);
                    }
                }
            }
            this.lEt.setIsLoading(false);
        } else {
            showLoadingView(findViewById(R.id.container), true);
            this.lEt.setIsLoading(true);
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
                eVar.bBJ();
                eVar.bBv().getInputView().setText(str2);
                Editable text = eVar.bBv().getInputView().getText();
                if (!TextUtils.isEmpty(text)) {
                    eVar.bBv().getInputView().setSelection(text.length());
                }
            }
        }).a(view, getString(R.string.open_editor_tips), str, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_PB_REPLY);
    }

    public Fragment dkp() {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (com.baidu.tbadk.core.util.x.isEmpty(fragments)) {
            return null;
        }
        return fragments.get(0);
    }

    private void dkq() {
        boolean z = true;
        if (TbadkApplication.getCurrentAccountInfo() == null || TbadkApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() != 1) {
            z = false;
        }
        if (!z && com.baidu.tbadk.a.d.biI() && com.baidu.tbadk.core.util.x.isEmpty(com.baidu.tieba.h.a.cLv().KD("6051001537-901554884"))) {
            Activity aa = com.baidu.adp.base.b.kC().aa(0);
            if (this.lEA == null) {
                this.lEA = new a.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
                    @Override // com.baidu.tieba.h.a.d
                    public void bb(String str, int i) {
                        if (PbActivity.this.bdw instanceof PbFragment) {
                            PbFragment pbFragment = (PbFragment) PbActivity.this.bdw;
                            if (pbFragment.dkW() != null && pbFragment.dkW().dop() != null) {
                                pbFragment.dkW().dop().dkA();
                            }
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c14005").an("obj_source", 6).dW("obj_type", PageStayDurationConstants.PageName.PB).an("obj_locate", 0).an("resource_id", i));
                    }

                    @Override // com.baidu.tieba.h.a.d
                    public void onError(String str) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c14005").an("obj_source", 6).dW("obj_type", PageStayDurationConstants.PageName.PB).an("obj_locate", 1).an("resource_id", 0));
                    }
                };
            }
            com.baidu.tieba.h.a cLv = com.baidu.tieba.h.a.cLv();
            if (aa == null) {
                aa = this;
            }
            cLv.b(aa, "6051001537-901554884", this.lEA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.pb.data.f fVar) {
        String d = d(fVar);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager.findFragmentByTag(d) == null) {
            this.bdw = Ox(d);
            supportFragmentManager.beginTransaction().add(R.id.container, this.bdw, d).commitAllowingStateLoss();
        }
    }

    private String d(com.baidu.tieba.pb.data.f fVar) {
        return (fVar == null || !fVar.djn()) ? "pb_fragment_tag" : "video_pb_fragment_tag";
    }

    private Fragment Ox(String str) {
        return "video_pb_fragment_tag".equals(str) ? VideoPbFragment.drA() : PbFragment.dkS();
    }

    public PbModel dkd() {
        return this.lEs;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        Fragment dkp = dkp();
        if (dkp instanceof BaseFragment) {
            ((BaseFragment) dkp).onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Fragment dkp = dkp();
        if (dkp != null) {
            dkp.onActivityResult(i, i2, intent);
        }
    }

    public void dkr() {
        super.finish();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.lEx != null && !this.lEx.a(this.lEs) && this.mIsFromSchema) {
            if (TbadkApplication.getInst().isNeedNewUserLead() && TbadkApplication.getInst().getIsFirstUse()) {
                sendMessage(new CustomMessage(2921454, new IntentConfig(this)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
        }
        if ((!TbadkApplication.getInst().isNeedNewUserLead() || !TbadkApplication.getInst().getIsFirstUse()) && this.lEy != null) {
            this.lEy.h(this.lEs);
        }
        Fragment dkp = dkp();
        if (dkp instanceof com.baidu.tieba.pb.videopb.b) {
            ((com.baidu.tieba.pb.videopb.b) dkp).finish();
        } else {
            super.finish();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        Fragment dkp = dkp();
        if (dkp instanceof PbFragment) {
            ((PbFragment) dkp).onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Fragment dkp = dkp();
        if (dkp instanceof PbFragment) {
            if (((PbFragment) dkp).onKeyDown(i, keyEvent)) {
                return true;
            }
        } else if ((dkp instanceof VideoPbFragment) && ((VideoPbFragment) dkp).onKeyDown(i, keyEvent)) {
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
        if (this.lEs != null) {
            this.lEs.aD(bundle);
        }
        if (this.jaA != null) {
            this.jaA.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.jaA != null) {
            this.jaA.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.jaA != null) {
            this.jaA.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.lEs != null) {
            aj.dnE().aY(this.lEs.dmb(), this.lEs.getIsFromMark());
        }
        if (this.jaA != null) {
            this.jaA.onResume(getPageContext());
        }
        if (this.bdw instanceof BaseFragment) {
            ((BaseFragment) this.bdw).setPrimary(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.jaA != null) {
            this.jaA.onStop(getPageContext());
        }
        if (this.bdw instanceof BaseFragment) {
            ((BaseFragment) this.bdw).setPrimary(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jaA != null) {
            this.jaA.onDestory(getPageContext());
        }
        if (this.jbp != null) {
            this.jbp.onDestroy();
        }
        com.baidu.tbadk.pageExtra.d.CY(getCurrentPageKey());
        com.baidu.tbadk.mutiprocess.g.publishEvent(new PrePageKeyEvent(getCurrentPageKey()));
        if (this.lEA != null) {
            com.baidu.tieba.h.a.cLv().KC("6051001537-901554884");
            this.lEA = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        return 0L;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a djU() {
        return this.lEu;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean djV() {
        if (this.lEs == null) {
            return false;
        }
        return this.lEs.djV();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String djW() {
        if (this.lEs != null) {
            return this.lEs.djW();
        }
        return null;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int djX() {
        if (this.lEs == null || this.lEs.getPbData() == null) {
            return 0;
        }
        return this.lEs.getPbData().djc();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean Ow(String str) {
        return this.lEs != null && this.lEs.OI(str);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.PB;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            if (this.lEs != null) {
                if (this.lEs.getPbData() != null) {
                    pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.lEs.getPbData().getForumId(), 0L));
                }
                pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.lEs.dme(), 0L));
                if (this.lEs.getPbData() != null && this.lEs.getPbData().diN() != null) {
                    pageStayDurationItem.setNid(this.lEs.getPbData().diN().blV());
                }
            }
            if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.Df(TbadkCoreApplication.getInst().getAdAdSense().foc);
            }
            Fragment dkp = dkp();
            if (dkp instanceof PbFragment) {
                if (((PbFragment) dkp).lJi == 2) {
                    pageStayDurationItem.Dg(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                } else if (((PbFragment) dkp).lJi == 1) {
                    pageStayDurationItem.Dg(PageStayDurationConstants.PageName.HOMEPAGE_CONCERN);
                } else if (((PbFragment) dkp).lJi == 3) {
                    pageStayDurationItem.Dg(PageStayDurationConstants.PageName.FRS);
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
        if (this.lEs != null) {
            this.lEt.setIsLoading(true);
            showLoadingView(this.mRootView);
            this.lEs.dms();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.jaA;
    }

    public void cBI() {
        if (this.jaA != null) {
            this.jaA.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected boolean shouldChangeStatusBarIconAndTextColor() {
        return !(this.bdw instanceof VideoPbFragment);
    }

    public View getRootView() {
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        Fragment dkp = dkp();
        if (dkp instanceof VideoPbFragment) {
            ((VideoPbFragment) dkp).onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onScreenShot(String str) {
        super.onScreenShot(str);
        if (this.lEs != null && this.lEs.getPbData() != null) {
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13848");
            aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dW("tid", this.lEs.dme());
            aqVar.dW("fid", this.lEs.getPbData().getForumId());
            aqVar.an("obj_type", 3);
            TiebaStatic.log(aqVar);
        }
    }
}
