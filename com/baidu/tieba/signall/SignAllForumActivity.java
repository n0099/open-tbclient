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
import com.baidu.tbadk.core.view.r;
import com.baidu.tieba.signall.f;
import com.baidu.tieba.signall.w;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements r.a {
    private com.baidu.tbadk.core.dialog.a Ms;
    private af dNA;
    private f dNB;
    private w dNC;
    private boolean dND;
    private boolean dNE;
    private final CustomMessageListener mMemListener = new j(this, CmdConfigCustom.CMD_RESPONSE_MEM);
    private final CustomMessageListener dNF = new k(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
    private f.a dNG = new l(this);
    private w.a dNH = new m(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            String Tc = cVar.Tc();
            String Gs = cVar.Gs();
            boolean aIM = cVar.aIM();
            if (cVar.aIB()) {
                this.dNA.gE(0);
                new Handler().postDelayed(new n(this, Tc, Gs, aIM), 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mo(String str) {
        if (this.dND) {
            c aJv = this.dNA.aJv();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(t.j.signallforum_back_finish, new Object[]{0, Integer.valueOf(aJv.aIL().size())});
            a(str, activity, false);
            if (this.dNE) {
                return;
            }
        }
        showToast(str);
        this.dNA.aJt().aJo();
        ArrayList<e> aIL = this.dNA.aJv().aIL();
        int size = aIL.size();
        for (int i = 0; i < size; i++) {
            e eVar = aIL.get(i);
            eVar.hI(true);
            eVar.hJ(false);
            eVar.hH(false);
        }
        this.dNA.aJw().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), t.f.singnallforum_progress, getPageContext().getString(t.j.app_name), str, str, pendingIntent, z);
    }

    private void yR() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), t.f.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        yR();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.dNF);
        initData();
        qD();
    }

    private void qD() {
        this.dNA = new af(this);
        this.dNA.a(this);
        this.dNA.setOnItemClickListener(this);
        if (this.dNC.qc) {
            this.dNG.a(this.dNC.aJm());
            this.dNA.aJt().setSigning(90);
            return;
        }
        this.dNA.ns();
    }

    private void initData() {
        this.dNB = new f(this);
        this.dNB.a(this.dNG);
        this.dNC = new w(this);
        this.dNC.a(this.dNH);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dNA.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.r.a
    public void az(boolean z) {
        if (!com.baidu.adp.lib.util.i.iZ()) {
            showToast(t.j.neterror);
            this.dNA.MB();
        } else if (!this.dNB.LoadData()) {
            this.dNA.MB();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c aJv = this.dNA.aJv();
        if (view == this.dNA.getProgressBar()) {
            if (this.dNA.aJt().getCurrentStatus() == 2) {
                showToast(t.j.signallforum_finished);
                return;
            }
            if (aJv.aIG() != 0) {
                mp(aJv.aIH());
                this.Ms.uj();
            } else if (com.baidu.adp.lib.util.i.iZ()) {
                aJd();
            } else {
                showToast(t.j.neterror);
            }
            TiebaStatic.log("signall_click");
        } else if (view == this.dNA.aJx()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        }
    }

    private void aJd() {
        c aJv = this.dNA.aJv();
        this.dNA.aJt().setDuration(Math.max(aJv.aIL().size() * 50, 2000));
        this.dNA.aJt().setSigning(0);
        this.dNC.d(aJv);
        this.dNC.LoadData();
        this.dNA.aJw().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        e eVar;
        if (this.dNA.aJw().getItemViewType(i) == 0 && this.dNA.aJv() != null && this.dNA.aJv().aII() != null && this.dNA.aJv().aII().size() > i && (eVar = this.dNA.aJv().aII().get(i)) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(eVar.getForumName(), "signallforum")));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mp(String str) {
        this.Ms = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).cE(str).a(t.j.signallforum_signnow, new o(this));
        this.Ms.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dNC != null && this.dNC.qc) {
            aJe();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dNE = true;
        if (this.Ms != null && this.Ms.isShowing()) {
            this.Ms.dismiss();
        }
        if (this.dNB != null) {
            this.dNB.cancelLoadData();
            this.dNB = null;
        }
        if (this.dNA != null && this.dNA.aJw() != null) {
            this.dNA.aJw().aJf();
        }
        if (this.dNC != null) {
            if (this.dNC.qc) {
                aJe();
            }
            this.dNC.cancelMessage();
            this.dNC = null;
        }
        if (this.dNB != null) {
            this.dNB.cancelLoadData();
            this.dNB = null;
        }
    }

    private void aJe() {
        this.dND = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(t.j.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.dNA.aJu();
    }
}
