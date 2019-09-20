package com.baidu.tieba.signall;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.p;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import com.baidu.tieba.signall.GetForumListModel;
import com.baidu.tieba.signall.SignAllForumModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements h.c {
    private com.baidu.tbadk.core.dialog.a TW;
    private boolean isDestory;
    private j jas;
    private GetForumListModel jat;
    private SignAllForumModel jau;
    private boolean jav;
    private boolean jaw = false;
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.jas.coA().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener jax = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c coC;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (coC = SignAllForumActivity.this.jas.coC()) != null) {
                coC.a((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.jas.coD().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a jay = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            SignAllForumActivity.this.jas.oU();
            a cnO = cVar.cnO();
            if (cnO != null && cnO.getErrorNumber() == 0) {
                SignAllForumActivity.this.jas.a(cVar, SignAllForumActivity.this.jat.coh());
                return;
            }
            SignAllForumActivity.this.showToast(cnO.getUserMsg(), false);
            SignAllForumActivity.this.finish();
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void zz(String str) {
            SignAllForumActivity.this.jas.oU();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a jaz = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void zz(String str) {
            SignAllForumActivity.this.ES(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            if (hVar != null && hVar.getErrorCode() == 3250013 && SignAllForumActivity.this.jaw) {
                SignAllForumActivity.this.jaw = false;
                BdToast.a(TbadkCoreApplication.getInst().getContext(), hVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake_n_svg, 3000, true).agW();
                if (SignAllForumActivity.this.jas != null && SignAllForumActivity.this.jas.coA() != null) {
                    SignAllForumActivity.this.jas.coA().setSignBefore(0);
                    return;
                }
                return;
            }
            a cnO = hVar.cnO();
            if (cnO == null || cnO.getErrorNumber() != 0) {
                SignAllForumActivity.this.ES(cnO.getUserMsg());
                return;
            }
            c coC = SignAllForumActivity.this.jas.coC();
            coC.a(hVar);
            if (SignAllForumActivity.this.jav) {
                Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{Integer.valueOf(coC.cnV()), Integer.valueOf(coC.cnW())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                if (SignAllForumActivity.this.isDestory) {
                    return;
                }
            }
            SignAllForumActivity.this.jas.coD().notifyDataSetChanged();
            SignAllForumProgressView coA = SignAllForumActivity.this.jas.coA();
            if (!coC.cnU()) {
                if (hVar.coo() != 0) {
                    SignAllForumActivity.this.ET(hVar.cnM());
                    SignAllForumActivity.this.TW.agO();
                } else if (hVar.coq() != 0) {
                    SignAllForumActivity.this.showToast(hVar.cor());
                } else {
                    SignAllForumActivity.this.showToast(R.string.signallforum_error);
                }
            }
            if (SignAllForumActivity.this.TW == null || !SignAllForumActivity.this.TW.isShowing()) {
                SignAllForumActivity.this.coj();
            }
            coA.setSignSuccess();
            SignAllForumActivity.this.b(coC);
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12536").P("obj_locate", at.a.bUO));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12535").P("obj_locate", at.a.bUO));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void coj() {
        if (this.jas != null) {
            com.baidu.tbadk.coreExtra.messageCenter.f.aoT().a(getPageContext(), this.jas.aYe());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String cnD = cVar.cnD();
            final String awn = cVar.awn();
            final boolean cnR = cVar.cnR();
            if (cVar.cnC()) {
                this.jas.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage(2002001, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), cnD, awn, Boolean.valueOf(cnR))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ES(String str) {
        if (this.jav) {
            c coC = this.jas.coC();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{0, Integer.valueOf(coC.cnQ().size())});
            a(str, activity, false);
            if (this.isDestory) {
                return;
            }
        }
        showToast(str);
        this.jas.coA().setSignSuccess();
        ArrayList<d> cnQ = this.jas.coC().cnQ();
        int size = cnQ.size();
        for (int i = 0; i < size; i++) {
            d dVar = cnQ.get(i);
            dVar.qT(true);
            dVar.qU(false);
            dVar.qS(false);
        }
        this.jas.coD().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress, getPageContext().getString(R.string.app_name), str, str, pendingIntent, z);
    }

    private void anV() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!TbadkCoreApplication.isLogin()) {
            bc.cE(getActivity());
            finish();
            return;
        }
        anV();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.jax);
        initData();
        initUI();
    }

    private void initUI() {
        this.jas = new j(this);
        this.jas.setListPullRefreshListener(this);
        this.jas.setOnItemClickListener(this);
        if (this.jau.isRunning) {
            this.jay.a(this.jau.cou());
            this.jas.coA().setSigning(90);
            return;
        }
        this.jas.startPullRefresh();
    }

    private void initData() {
        this.jat = new GetForumListModel(this);
        this.jat.a(this.jay);
        this.jau = new SignAllForumModel(this);
        this.jau.a(this.jaz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jas.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void eu(boolean z) {
        if (!com.baidu.adp.lib.util.j.kc()) {
            showToast(R.string.neterror);
            this.jas.oU();
        } else if (this.jat == null) {
            showToast(R.string.neterror);
        } else if (!this.jat.LoadData()) {
            this.jas.oU();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c coC = this.jas.coC();
        if (view == this.jas.getProgressBar()) {
            if (coC != null) {
                if (coC.getBlockPopInfoData() != null) {
                    if (coC.getBlockPopInfoData().appeal_status == 1) {
                        BdToast.a(getPageContext().getPageActivity(), coC.getBlockPopInfoData().appeal_msg, R.drawable.icon_pure_toast_mistake_n_svg, 3000, true).agW();
                    } else if (AntiHelper.a(getPageContext().getPageActivity(), coC.getBlockPopInfoData(), this.mInjectListener) != null) {
                        TiebaStatic.log(new an("c12534").P("obj_locate", at.a.bUO));
                    }
                } else if (this.jas.coA().getCurrentStatus() == 2) {
                    showToast(R.string.signallforum_finished);
                } else {
                    if (coC.cnL() != 0) {
                        ET(coC.cnM());
                        this.TW.agO();
                    } else if (com.baidu.adp.lib.util.j.kc()) {
                        this.jaw = true;
                        cok();
                    } else {
                        showToast(R.string.neterror);
                    }
                    TiebaStatic.log("signall_click");
                }
            }
        } else if (view == this.jas.coE()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone("a_key_to_sign_V8.9", "bottom_opende/renewalfee_button_V8.9");
            sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    private void cok() {
        c coC = this.jas.coC();
        this.jas.coA().setDuration(Math.max(coC.cnQ().size() * 50, 2000));
        this.jas.coA().setSigning(0);
        this.jau.d(coC);
        this.jau.LoadData();
        this.jas.coD().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.jas.coD().getItemViewType(i) == 0 && this.jas.coC() != null && this.jas.coC().cnN() != null && this.jas.coC().cnN().size() > i && (dVar = this.jas.coC().cnN().get(i)) != null) {
            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum").setCallFrom(6)));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ET(String str) {
        this.TW = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).mQ(str).a(R.string.signallforum_signnow, new a.b() { // from class: com.baidu.tieba.signall.SignAllForumActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.TW.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.jau != null && this.jau.isRunning) {
            col();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.isDestory = true;
        if (this.TW != null && this.TW.isShowing()) {
            this.TW.dismiss();
        }
        if (this.jat != null) {
            this.jat.cancelLoadData();
            this.jat = null;
        }
        if (this.jas != null && this.jas.coD() != null) {
            this.jas.coD().com();
        }
        if (this.jau != null) {
            if (this.jau.isRunning) {
                col();
            }
            this.jau.cancelMessage();
            this.jau = null;
        }
        if (this.jat != null) {
            this.jat.cancelLoadData();
            this.jat = null;
        }
    }

    private void col() {
        this.jav = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(R.string.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public p onGetPreLoadListView() {
        if (this.jas == null || this.jas.coB() == null) {
            return null;
        }
        return this.jas.coB().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a022";
    }
}
