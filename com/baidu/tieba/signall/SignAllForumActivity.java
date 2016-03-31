package com.baidu.tieba.signall;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.s;
import com.baidu.tieba.signall.f;
import com.baidu.tieba.signall.w;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements s.a {
    private com.baidu.tbadk.core.dialog.a My;
    private af efZ;
    private f ega;
    private w egb;
    private boolean egc;
    private boolean egd;
    private final CustomMessageListener mMemListener = new j(this, CmdConfigCustom.CMD_RESPONSE_MEM);
    private final CustomMessageListener ege = new k(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
    private f.a egf = new l(this);
    private w.a egg = new m(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            String UT = cVar.UT();
            String Ho = cVar.Ho();
            boolean aPC = cVar.aPC();
            if (cVar.aPr()) {
                this.efZ.gV(0);
                new Handler().postDelayed(new n(this, UT, Ho, aPC), 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nz(String str) {
        if (this.egc) {
            c aQm = this.efZ.aQm();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(t.j.signallforum_back_finish, new Object[]{0, Integer.valueOf(aQm.aPB().size())});
            a(str, activity, false);
            if (this.egd) {
                return;
            }
        }
        showToast(str);
        this.efZ.aQk().aQe();
        ArrayList<e> aPB = this.efZ.aQm().aPB();
        int size = aPB.size();
        for (int i = 0; i < size; i++) {
            e eVar = aPB.get(i);
            eVar.ix(true);
            eVar.iy(false);
            eVar.iw(false);
        }
        this.efZ.aQn().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), t.f.singnallforum_progress, getPageContext().getString(t.j.app_name), str, str, pendingIntent, z);
    }

    private void zt() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), t.f.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zt();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.ege);
        initData();
        pU();
    }

    private void pU() {
        this.efZ = new af(this);
        this.efZ.a(this);
        this.efZ.setOnItemClickListener(this);
        if (this.egb.qg) {
            this.egf.a(this.egb.aQc());
            this.efZ.aQk().setSigning(90);
            return;
        }
        this.efZ.nk();
    }

    private void initData() {
        this.ega = new f(this);
        this.ega.a(this.egf);
        this.egb = new w(this);
        this.egb.a(this.egg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.efZ.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.s.a
    public void aB(boolean z) {
        if (!com.baidu.adp.lib.util.i.jf()) {
            showToast(t.j.neterror);
            this.efZ.Op();
        } else if (!this.ega.LoadData()) {
            this.efZ.Op();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c aQm = this.efZ.aQm();
        if (view == this.efZ.getProgressBar()) {
            if (this.efZ.aQk().getCurrentStatus() == 2) {
                showToast(t.j.signallforum_finished);
                return;
            }
            if (aQm.aPw() != 0) {
                nA(aQm.aPx());
                this.My.up();
            } else if (com.baidu.adp.lib.util.i.jf()) {
                aPT();
            } else {
                showToast(t.j.neterror);
            }
            TiebaStatic.log("signall_click");
        } else if (view == this.efZ.aQo()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        }
    }

    private void aPT() {
        c aQm = this.efZ.aQm();
        this.efZ.aQk().setDuration(Math.max(aQm.aPB().size() * 50, 2000));
        this.efZ.aQk().setSigning(0);
        this.egb.d(aQm);
        this.egb.LoadData();
        this.efZ.aQn().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        e eVar;
        if (this.efZ.aQn().getItemViewType(i) == 0 && this.efZ.aQm() != null && this.efZ.aQm().aPy() != null && this.efZ.aQm().aPy().size() > i && (eVar = this.efZ.aQm().aPy().get(i)) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(eVar.getForumName(), "signallforum")));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nA(String str) {
        this.My = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).cC(str).a(t.j.signallforum_signnow, new o(this));
        this.My.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.egb != null && this.egb.qg) {
            aPU();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.egd = true;
        if (this.My != null && this.My.isShowing()) {
            this.My.dismiss();
        }
        if (this.ega != null) {
            this.ega.cancelLoadData();
            this.ega = null;
        }
        if (this.efZ != null && this.efZ.aQn() != null) {
            this.efZ.aQn().aPV();
        }
        if (this.egb != null) {
            if (this.egb.qg) {
                aPU();
            }
            this.egb.cancelMessage();
            this.egb = null;
        }
        if (this.ega != null) {
            this.ega.cancelLoadData();
            this.ega = null;
        }
    }

    private void aPU() {
        this.egc = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(t.j.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.efZ.aQl();
    }
}
