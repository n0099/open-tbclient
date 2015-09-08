package com.baidu.tieba.signall;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
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
import com.baidu.tbadk.core.view.x;
import com.baidu.tieba.i;
import com.baidu.tieba.signall.f;
import com.baidu.tieba.signall.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements x.a {
    private com.baidu.tbadk.core.dialog.a Lt;
    private z cIV;
    private f cIW;
    private r cIX;
    private boolean cIY;
    private boolean cIZ;
    private final CustomMessageListener mMemListener = new i(this, CmdConfigCustom.CMD_RESPONSE_MEM);
    private final CustomMessageListener cJa = new j(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
    private f.a cJb = new k(this);
    private r.a cJc = new l(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void kH(String str) {
        if (this.cIY) {
            c arH = this.cIV.arH();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(i.h.signallforum_back_finish, new Object[]{0, Integer.valueOf(arH.aqZ().size())});
            a(str, activity, false);
            if (this.cIZ) {
                return;
            }
        }
        showToast(str);
        this.cIV.arF().arB();
        ArrayList<e> aqZ = this.cIV.arH().aqZ();
        int size = aqZ.size();
        for (int i = 0; i < size; i++) {
            e eVar = aqZ.get(i);
            eVar.fW(true);
            eVar.fX(false);
            eVar.fV(false);
        }
        this.cIV.arI().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), i.e.singnallforum_progress, getPageContext().getString(i.h.app_name), str, str, pendingIntent, z);
    }

    private void xd() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), i.e.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        xd();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.cJa);
        initData();
    }

    private void initUI() {
        this.cIV = new z(this);
        this.cIV.a(this);
        this.cIV.setOnItemClickListener(this);
    }

    private void initData() {
        this.cIW = new f(this);
        this.cIW.a(this.cJb);
        this.cIX = new r(this);
        this.cIX.a(this.cJc);
        if (this.cIX.pY) {
            this.cJb.a(this.cIX.arz());
            this.cIV.arF().setSigning(90);
            return;
        }
        this.cIV.nv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cIV.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.x.a
    public void onListPullRefresh(boolean z) {
        if (!com.baidu.adp.lib.util.i.iL()) {
            showToast(i.h.neterror);
            this.cIV.IZ();
        } else if (!this.cIW.LoadData()) {
            this.cIV.IZ();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c arH = this.cIV.arH();
        if (view == this.cIV.getProgressBar()) {
            if (this.cIV.arF().getCurrentStatus() == 2) {
                showToast(i.h.signallforum_finished);
                return;
            }
            if (arH.aqU() != 0) {
                kI(arH.aqV());
                this.Lt.sU();
            } else if (com.baidu.adp.lib.util.i.iL()) {
                arr();
            } else {
                showToast(i.h.neterror);
            }
            TiebaStatic.log("signall_click");
        } else if (view == this.cIV.arJ()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1)));
        }
    }

    private void arr() {
        c arH = this.cIV.arH();
        this.cIV.arF().setDuration(Math.max(arH.aqZ().size() * 50, 2000));
        this.cIV.arF().setSigning(0);
        this.cIX.c(arH);
        this.cIX.LoadData();
        this.cIV.arI().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        e eVar;
        if (this.cIV.arI().getItemViewType(i) == 0 && this.cIV.arH() != null && this.cIV.arH().aqW() != null && this.cIV.arH().aqW().size() > i && (eVar = this.cIV.arH().aqW().get(i)) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(eVar.getForumName(), "signallforum")));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kI(String str) {
        this.Lt = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).ct(str).a(i.h.signallforum_signnow, new m(this));
        this.Lt.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cIX != null && this.cIX.pY) {
            ars();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cIZ = true;
        if (this.Lt != null && this.Lt.isShowing()) {
            this.Lt.dismiss();
        }
        if (this.cIW != null) {
            this.cIW.cancelLoadData();
            this.cIW = null;
        }
        if (this.cIV != null && this.cIV.arI() != null) {
            this.cIV.arI().art();
        }
        if (this.cIX != null) {
            if (this.cIX.pY) {
                ars();
            }
            this.cIX.cancelMessage();
            this.cIX.cancelLoadData();
            this.cIX = null;
        }
        if (this.cIW != null) {
            this.cIW.cancelLoadData();
            this.cIW = null;
        }
    }

    private void ars() {
        this.cIY = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(i.h.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.cIV.arG();
    }
}
