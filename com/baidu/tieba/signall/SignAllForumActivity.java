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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.d;
import com.baidu.tieba.signall.GetForumListModel;
import com.baidu.tieba.signall.SignAllForumModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements j.b {
    private com.baidu.tbadk.core.dialog.a axJ;
    private k gRL;
    private GetForumListModel gRM;
    private SignAllForumModel gRN;
    private boolean gRO;
    private boolean isDestory;
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.gRL.btQ().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener gRP = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c btS;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (btS = SignAllForumActivity.this.gRL.btS()) != null) {
                btS.a((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.gRL.btT().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a gRQ = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            SignAllForumActivity.this.gRL.sV();
            a btd = cVar.btd();
            if (btd != null && btd.getErrorNumber() == 0) {
                SignAllForumActivity.this.gRL.a(cVar, SignAllForumActivity.this.gRM.btw());
                return;
            }
            SignAllForumActivity.this.showToast(btd.getUserMsg(), false);
            SignAllForumActivity.this.finish();
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void nr(String str) {
            SignAllForumActivity.this.gRL.sV();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a gRR = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void nr(String str) {
            SignAllForumActivity.this.ss(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            a btd = hVar.btd();
            if (btd == null || btd.getErrorNumber() != 0) {
                SignAllForumActivity.this.ss(btd.getUserMsg());
                return;
            }
            c btS = SignAllForumActivity.this.gRL.btS();
            btS.a(hVar);
            if (SignAllForumActivity.this.gRO) {
                Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(d.j.signallforum_back_finish, new Object[]{Integer.valueOf(btS.btk()), Integer.valueOf(btS.btl())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                if (SignAllForumActivity.this.isDestory) {
                    return;
                }
            }
            SignAllForumActivity.this.gRL.btT().notifyDataSetChanged();
            j btQ = SignAllForumActivity.this.gRL.btQ();
            if (!btS.btj()) {
                if (hVar.btC() != 0) {
                    SignAllForumActivity.this.st(hVar.btb());
                    SignAllForumActivity.this.axJ.AU();
                } else if (hVar.btE() != 0) {
                    SignAllForumActivity.this.showToast(hVar.btF());
                } else {
                    SignAllForumActivity.this.showToast(d.j.signallforum_error);
                }
            }
            btQ.btM();
            SignAllForumActivity.this.b(btS);
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12536").s("obj_locate", aq.a.aXz));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12535").s("obj_locate", aq.a.aXz));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String bsS = cVar.bsS();
            final String OT = cVar.OT();
            final boolean btg = cVar.btg();
            if (cVar.bsR()) {
                this.gRL.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage(2002001, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), bsS, OT, Boolean.valueOf(btg))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ss(String str) {
        if (this.gRO) {
            c btS = this.gRL.btS();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(d.j.signallforum_back_finish, new Object[]{0, Integer.valueOf(btS.btf().size())});
            a(str, activity, false);
            if (this.isDestory) {
                return;
            }
        }
        showToast(str);
        this.gRL.btQ().btM();
        ArrayList<d> btf = this.gRL.btS().btf();
        int size = btf.size();
        for (int i = 0; i < size; i++) {
            d dVar = btf.get(i);
            dVar.mv(true);
            dVar.mw(false);
            dVar.mu(false);
        }
        this.gRL.btT().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), d.f.singnallforum_progress, getPageContext().getString(d.j.app_name), str, str, pendingIntent, z);
    }

    private void GM() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), d.f.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!TbadkCoreApplication.isLogin()) {
            ay.aZ(getActivity());
            finish();
            return;
        }
        GM();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.gRP);
        initData();
        initUI();
    }

    private void initUI() {
        this.gRL = new k(this);
        this.gRL.a(this);
        this.gRL.setOnItemClickListener(this);
        if (this.gRN.isRunning) {
            this.gRQ.a(this.gRN.btI());
            this.gRL.btQ().setSigning(90);
            return;
        }
        this.gRL.startPullRefresh();
    }

    private void initData() {
        this.gRM = new GetForumListModel(this);
        this.gRM.a(this.gRQ);
        this.gRN = new SignAllForumModel(this);
        this.gRN.a(this.gRR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gRL.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bw(boolean z) {
        if (!com.baidu.adp.lib.util.j.oJ()) {
            showToast(d.j.neterror);
            this.gRL.sV();
        } else if (this.gRM == null) {
            showToast(d.j.neterror);
        } else if (!this.gRM.LoadData()) {
            this.gRL.sV();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c btS = this.gRL.btS();
        if (view == this.gRL.getProgressBar()) {
            if (btS.getBlockPopInfoData() != null) {
                if (AntiHelper.a(getPageContext().getPageActivity(), btS.getBlockPopInfoData(), this.mInjectListener) != null) {
                    TiebaStatic.log(new ak("c12534").s("obj_locate", aq.a.aXz));
                }
            } else if (this.gRL.btQ().getCurrentStatus() == 2) {
                showToast(d.j.signallforum_finished);
            } else {
                if (btS.bta() != 0) {
                    st(btS.btb());
                    this.axJ.AU();
                } else if (com.baidu.adp.lib.util.j.oJ()) {
                    bty();
                } else {
                    showToast(d.j.neterror);
                }
                TiebaStatic.log("signall_click");
            }
        } else if (view == this.gRL.btU()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone("a_key_to_sign_V8.9", "bottom_opende/renewalfee_button_V8.9");
            sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    private void bty() {
        c btS = this.gRL.btS();
        this.gRL.btQ().setDuration(Math.max(btS.btf().size() * 50, 2000));
        this.gRL.btQ().setSigning(0);
        this.gRN.d(btS);
        this.gRN.LoadData();
        this.gRL.btT().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.gRL.btT().getItemViewType(i) == 0 && this.gRL.btS() != null && this.gRL.btS().btc() != null && this.gRL.btS().btc().size() > i && (dVar = this.gRL.btS().btc().get(i)) != null) {
            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum")));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void st(String str) {
        this.axJ = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).dk(str).a(d.j.signallforum_signnow, new a.b() { // from class: com.baidu.tieba.signall.SignAllForumActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.axJ.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.gRN != null && this.gRN.isRunning) {
            btz();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.isDestory = true;
        if (this.axJ != null && this.axJ.isShowing()) {
            this.axJ.dismiss();
        }
        if (this.gRM != null) {
            this.gRM.cancelLoadData();
            this.gRM = null;
        }
        if (this.gRL != null && this.gRL.btT() != null) {
            this.gRL.btT().btA();
        }
        if (this.gRN != null) {
            if (this.gRN.isRunning) {
                btz();
            }
            this.gRN.cancelMessage();
            this.gRN = null;
        }
        if (this.gRM != null) {
            this.gRM.cancelLoadData();
            this.gRM = null;
        }
    }

    private void btz() {
        this.gRO = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(d.j.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.l onGetPreLoadListView() {
        if (this.gRL == null || this.gRL.btR() == null) {
            return null;
        }
        return this.gRL.btR().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a022";
    }
}
