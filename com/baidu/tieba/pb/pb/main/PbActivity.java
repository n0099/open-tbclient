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
    private Fragment bgG;
    private VoiceManager jgu;
    private com.baidu.tieba.NEGFeedBack.a jhj;
    private boolean lNA;
    private com.baidu.tieba.pb.pb.main.a lNB;
    private am lNC;
    private boolean lND;
    private a.d lNE;
    private PbModel lNw;
    private VideoPbViewModel lNx;
    public final com.baidu.tieba.pb.pb.main.b.a lNy = new com.baidu.tieba.pb.pb.main.b.a(this);
    public final com.baidu.tieba.pb.pb.main.b.c lNz = new com.baidu.tieba.pb.pb.main.b.c(getPageContext());
    private boolean mIsFromSchema = false;
    private View mRootView;

    /* loaded from: classes2.dex */
    public static class a {
        public ConcurrentHashMap<String, ImageUrlData> eJM;
        public ArrayList<String> lNK;
        public boolean lNL;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public String postId = null;
        public boolean eJK = false;
        public boolean lNM = false;
        public String lastId = "";
        public int index = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        initUniqueId();
        aB(bundle);
        if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !com.baidu.adp.base.b.kB().bo("MainTabActivity")) {
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
        dmI();
        initData(bundle);
        this.jgu = new VoiceManager();
        this.jgu.onCreate(getPageContext());
        this.lNB = new com.baidu.tieba.pb.pb.main.a(getPageContext());
        this.lNC = new am(getPageContext());
        this.jhj = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "client_pb_live");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.bgG instanceof VideoPbFragment) {
            ((VideoPbFragment) this.bgG).onWindowFocusChanged(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i == 0) {
            if ((this.bgG instanceof PbFragment) && ((PbFragment) this.bgG).dnm() != null) {
                ((PbFragment) this.bgG).dnm().bBQ();
                return;
            } else if ((this.bgG instanceof VideoPbFragment) && ((VideoPbFragment) this.bgG).dnm() != null) {
                ((VideoPbFragment) this.bgG).dnm().bBQ();
                return;
            } else {
                return;
            }
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    private void dmI() {
        this.lNx = (VideoPbViewModel) ViewModelProviders.of(this).get(VideoPbViewModel.class);
        this.lNx.init(getIntent());
    }

    private void aB(Bundle bundle) {
        this.lNw = new PbModel(this);
        if (bundle != null) {
            this.lNw.initWithBundle(bundle);
            return;
        }
        this.lNw.initWithIntent(getIntent());
    }

    private void initData(Bundle bundle) {
        this.lNx.i(this.lNw);
        aj.dpZ().aX(this.lNw.dox(), this.lNw.getIsFromMark());
        this.lNw.a(new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
                PbActivity.this.lNx.setIsLoading(false);
                PbActivity.this.hideLoadingView(PbActivity.this.mRootView);
                if (!z) {
                    if (!PbActivity.this.lNA && !PbActivity.this.lNw.dow()) {
                        PbActivity.this.showNetRefreshView(PbActivity.this.mRootView, PbActivity.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                        PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbActivity.this.getActivity(), R.dimen.ds360));
                    }
                } else if (fVar != null) {
                    PbActivity.this.hideNetRefreshView(PbActivity.this.mRootView);
                }
                Fragment dmJ = PbActivity.this.dmJ();
                if (dmJ == null) {
                    if (z) {
                        PbActivity.this.lNx.b(fVar, 3);
                        if (PbActivity.this.bgG == null) {
                            PbActivity.this.c(fVar);
                        }
                    }
                } else if ((dmJ instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) dmJ).dnF() != null) {
                    ((com.baidu.tieba.pb.videopb.b) dmJ).dnF().a(z, i, i2, i3, fVar, str, i4);
                }
                final String stringExtra = PbActivity.this.getIntent().getStringExtra("key_open_editor_tips");
                if (!TextUtils.isEmpty(stringExtra) && !PbActivity.this.lND) {
                    com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!(PbActivity.this.bgG instanceof PbFragment) || ((PbFragment) PbActivity.this.bgG).dnr() == null || ((PbFragment) PbActivity.this.bgG).dnr().drJ() == null) {
                                if ((PbActivity.this.bgG instanceof VideoPbFragment) && ((VideoPbFragment) PbActivity.this.bgG).drJ() != null) {
                                    PbActivity.this.a(((VideoPbFragment) PbActivity.this.bgG).drJ(), ((VideoPbFragment) PbActivity.this.bgG).dnm(), stringExtra);
                                    PbActivity.this.lND = true;
                                    return;
                                }
                                return;
                            }
                            PbActivity.this.a(((PbFragment) PbActivity.this.bgG).dnr().drJ(), ((PbFragment) PbActivity.this.bgG).dnm(), stringExtra);
                            PbActivity.this.lND = true;
                        }
                    }, 100L);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void e(com.baidu.tieba.pb.data.f fVar) {
                Fragment dmJ = PbActivity.this.dmJ();
                if ((dmJ instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) dmJ).dnF() != null) {
                    ((com.baidu.tieba.pb.videopb.b) dmJ).dnF().e(fVar);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.PbModel.a
            public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
                Fragment dmJ = PbActivity.this.dmJ();
                if ((dmJ instanceof com.baidu.tieba.pb.videopb.b) && ((com.baidu.tieba.pb.videopb.b) dmJ).dnF() != null) {
                    ((com.baidu.tieba.pb.videopb.b) dmJ).dnF().a(i, z, responsedMessage, z2, j);
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
                        PbActivity.this.lNA = false;
                        return;
                    }
                    PbActivity.this.lNA = true;
                    PbActivity.this.lNx.setIsLoading(false);
                    Fragment dmJ = PbActivity.this.dmJ();
                    if (dmJ == null) {
                        PbActivity.this.lNx.b(pbData, 2);
                        if (PbActivity.this.bgG == null) {
                            PbActivity.this.c(pbData);
                        }
                    } else if (dmJ instanceof PbFragment) {
                        PbActivity.this.lNw.a(pbData, pbPageReadLocalResponseMessage.getUpdateType(), pbPageReadLocalResponseMessage.getErrorString());
                    }
                }
            }
        });
        this.lNw.doO();
        dmK();
        if (this.lNw.dow()) {
            com.baidu.tieba.pb.data.f aM = this.lNw.aM(com.baidu.tieba.frs.l.cCp());
            if (aM != null) {
                aM.Fu(3);
                if (dmJ() == null) {
                    this.lNx.b(aM, 1);
                    if (this.bgG == null) {
                        c(aM);
                    }
                }
            }
            this.lNx.setIsLoading(false);
        } else {
            showLoadingView(findViewById(R.id.container), true);
            this.lNx.setIsLoading(true);
        }
        if (com.baidu.adp.lib.util.l.isNetOk() && !TbadkCoreApplication.getInst().syncHasFinish) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final View view, final com.baidu.tbadk.editortools.pb.e eVar, String str) {
        new WriteTipBubbleController(getPageContext(), new WriteTipBubbleController.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.3
            @Override // com.baidu.tbadk.core.dialog.WriteTipBubbleController.a
            public void g(View view2, String str2) {
                view.performClick();
                eVar.bCb();
                eVar.bBN().getInputView().setText(str2);
                Editable text = eVar.bBN().getInputView().getText();
                if (!TextUtils.isEmpty(text)) {
                    eVar.bBN().getInputView().setSelection(text.length());
                }
            }
        }).a(view, getString(R.string.open_editor_tips), str, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_PB_REPLY);
    }

    public Fragment dmJ() {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (com.baidu.tbadk.core.util.y.isEmpty(fragments)) {
            return null;
        }
        return fragments.get(0);
    }

    private void dmK() {
        boolean z = true;
        if (TbadkApplication.getCurrentAccountInfo() == null || TbadkApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() != 1) {
            z = false;
        }
        if (!z && com.baidu.tbadk.a.d.biU() && com.baidu.tbadk.core.util.y.isEmpty(com.baidu.tieba.h.a.cNq().Lr("6051001641-1251655838"))) {
            Activity aa = com.baidu.adp.base.b.kB().aa(0);
            if (this.lNE == null) {
                this.lNE = new a.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
                    @Override // com.baidu.tieba.h.a.d
                    public void bb(String str, int i) {
                        if (PbActivity.this.bgG instanceof PbFragment) {
                            PbFragment pbFragment = (PbFragment) PbActivity.this.bgG;
                            if (pbFragment.dnr() != null && pbFragment.dnr().dqK() != null) {
                                pbFragment.dnr().dqK().dmU();
                            }
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c14005").ap("obj_source", 6).dR("obj_type", PageStayDurationConstants.PageName.PB).ap("obj_locate", 0).ap("resource_id", i));
                    }

                    @Override // com.baidu.tieba.h.a.d
                    public void onError(String str) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c14005").ap("obj_source", 6).dR("obj_type", PageStayDurationConstants.PageName.PB).ap("obj_locate", 1).ap("resource_id", 0));
                    }
                };
            }
            com.baidu.tieba.h.a cNq = com.baidu.tieba.h.a.cNq();
            if (aa == null) {
                aa = this;
            }
            cNq.b(aa, "6051001641-1251655838", this.lNE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.pb.data.f fVar) {
        String d = d(fVar);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager.findFragmentByTag(d) == null) {
            this.bgG = Pp(d);
            supportFragmentManager.beginTransaction().add(R.id.container, this.bgG, d).commitAllowingStateLoss();
        }
    }

    private String d(com.baidu.tieba.pb.data.f fVar) {
        return (fVar == null || !fVar.dlG()) ? "pb_fragment_tag" : "video_pb_fragment_tag";
    }

    private Fragment Pp(String str) {
        return "video_pb_fragment_tag".equals(str) ? VideoPbFragment.dtU() : PbFragment.dnn();
    }

    public PbModel dmx() {
        return this.lNw;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        Fragment dmJ = dmJ();
        if (dmJ instanceof BaseFragment) {
            ((BaseFragment) dmJ).onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Fragment dmJ = dmJ();
        if (dmJ != null) {
            dmJ.onActivityResult(i, i2, intent);
        }
    }

    public void dmL() {
        super.finish();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.lNB != null && !this.lNB.a(this.lNw) && this.mIsFromSchema) {
            if (TbadkApplication.getInst().isNeedNewUserLead() && TbadkApplication.getInst().getIsFirstUse()) {
                sendMessage(new CustomMessage(2921454, new IntentConfig(this)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
        }
        if ((!TbadkApplication.getInst().isNeedNewUserLead() || !TbadkApplication.getInst().getIsFirstUse()) && this.lNC != null) {
            this.lNC.h(this.lNw);
        }
        Fragment dmJ = dmJ();
        if (dmJ instanceof com.baidu.tieba.pb.videopb.b) {
            ((com.baidu.tieba.pb.videopb.b) dmJ).finish();
        } else {
            super.finish();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        Fragment dmJ = dmJ();
        if (dmJ instanceof PbFragment) {
            ((PbFragment) dmJ).onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Fragment dmJ = dmJ();
        if (dmJ instanceof PbFragment) {
            if (((PbFragment) dmJ).onKeyDown(i, keyEvent)) {
                return true;
            }
        } else if ((dmJ instanceof VideoPbFragment) && ((VideoPbFragment) dmJ).onKeyDown(i, keyEvent)) {
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
        if (this.lNw != null) {
            this.lNw.aD(bundle);
        }
        if (this.jgu != null) {
            this.jgu.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.jgu != null) {
            this.jgu.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.jgu != null) {
            this.jgu.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.lNw != null) {
            aj.dpZ().aX(this.lNw.dox(), this.lNw.getIsFromMark());
        }
        if (this.jgu != null) {
            this.jgu.onResume(getPageContext());
        }
        if (this.bgG instanceof BaseFragment) {
            ((BaseFragment) this.bgG).setPrimary(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.jgu != null) {
            this.jgu.onStop(getPageContext());
        }
        if (this.bgG instanceof BaseFragment) {
            ((BaseFragment) this.bgG).setPrimary(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jgu != null) {
            this.jgu.onDestory(getPageContext());
        }
        if (this.jhj != null) {
            this.jhj.onDestroy();
        }
        com.baidu.tbadk.pageExtra.d.Dn(getCurrentPageKey());
        com.baidu.tbadk.mutiprocess.g.publishEvent(new PrePageKeyEvent(getCurrentPageKey()));
        if (this.lNE != null) {
            com.baidu.tieba.h.a.cNq().Lq("6051001641-1251655838");
            this.lNE = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        return 0L;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a dmo() {
        return this.lNy;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean dmp() {
        if (this.lNw == null) {
            return false;
        }
        return this.lNw.dmp();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String dmq() {
        if (this.lNw != null) {
            return this.lNw.dmq();
        }
        return null;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int dmr() {
        if (this.lNw == null || this.lNw.getPbData() == null) {
            return 0;
        }
        return this.lNw.getPbData().dlv();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean Po(String str) {
        return this.lNw != null && this.lNw.PA(str);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.PB;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            if (this.lNw != null) {
                if (this.lNw.getPbData() != null) {
                    pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.lNw.getPbData().getForumId(), 0L));
                }
                pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.lNw.doA(), 0L));
                if (this.lNw.getPbData() != null && this.lNw.getPbData().dlg() != null) {
                    pageStayDurationItem.setNid(this.lNw.getPbData().dlg().bmo());
                }
            }
            if (!com.baidu.tbadk.core.util.au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.Du(TbadkCoreApplication.getInst().getAdAdSense().fqv);
            }
            Fragment dmJ = dmJ();
            if (dmJ instanceof PbFragment) {
                if (((PbFragment) dmJ).lSu == 2) {
                    pageStayDurationItem.Dv(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                } else if (((PbFragment) dmJ).lSu == 1) {
                    pageStayDurationItem.Dv(PageStayDurationConstants.PageName.HOMEPAGE_CONCERN);
                } else if (((PbFragment) dmJ).lSu == 3) {
                    pageStayDurationItem.Dv(PageStayDurationConstants.PageName.FRS);
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
        if (this.lNw != null) {
            this.lNx.setIsLoading(true);
            showLoadingView(this.mRootView);
            this.lNw.doO();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.jgu;
    }

    public void cDb() {
        if (this.jgu != null) {
            this.jgu.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected boolean shouldChangeStatusBarIconAndTextColor() {
        return !(this.bgG instanceof VideoPbFragment);
    }

    public View getRootView() {
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        Fragment dmJ = dmJ();
        if (dmJ instanceof VideoPbFragment) {
            ((VideoPbFragment) dmJ).onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onScreenShot(String str) {
        super.onScreenShot(str);
        if (this.lNw != null && this.lNw.getPbData() != null) {
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13848");
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.dR("tid", this.lNw.doA());
            arVar.dR("fid", this.lNw.getPbData().getForumId());
            arVar.ap("obj_type", 3);
            TiebaStatic.log(arVar);
        }
    }
}
