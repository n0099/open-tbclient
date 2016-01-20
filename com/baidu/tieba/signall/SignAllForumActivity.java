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
import com.baidu.tieba.n;
import com.baidu.tieba.signall.f;
import com.baidu.tieba.signall.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements r.a {
    private com.baidu.tbadk.core.dialog.a Md;
    private boolean dxA;
    private ae dxw;
    private f dxx;
    private w dxy;
    private boolean dxz;
    private final CustomMessageListener mMemListener = new j(this, CmdConfigCustom.CMD_RESPONSE_MEM);
    private final CustomMessageListener dxB = new k(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
    private f.a dxC = new l(this);
    private w.a dxD = new m(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            String QV = cVar.QV();
            String Fa = cVar.Fa();
            boolean aBF = cVar.aBF();
            if (cVar.aBu()) {
                this.dxw.gh(0);
                new Handler().postDelayed(new n(this, QV, Fa, aBF), 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lY(String str) {
        if (this.dxz) {
            c aCn = this.dxw.aCn();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(n.j.signallforum_back_finish, new Object[]{0, Integer.valueOf(aCn.aBE().size())});
            a(str, activity, false);
            if (this.dxA) {
                return;
            }
        }
        showToast(str);
        this.dxw.aCl().aCh();
        ArrayList<e> aBE = this.dxw.aCn().aBE();
        int size = aBE.size();
        for (int i = 0; i < size; i++) {
            e eVar = aBE.get(i);
            eVar.hi(true);
            eVar.hj(false);
            eVar.hh(false);
        }
        this.dxw.aCo().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), n.f.singnallforum_progress, getPageContext().getString(n.j.app_name), str, str, pendingIntent, z);
    }

    private void xz() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), n.f.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        xz();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.dxB);
        initData();
        initUI();
    }

    private void initUI() {
        this.dxw = new ae(this);
        this.dxw.a(this);
        this.dxw.setOnItemClickListener(this);
        if (this.dxy.pZ) {
            this.dxC.a(this.dxy.aCf());
            this.dxw.aCl().setSigning(90);
            return;
        }
        this.dxw.nb();
    }

    private void initData() {
        this.dxx = new f(this);
        this.dxx.a(this.dxC);
        this.dxy = new w(this);
        this.dxy.a(this.dxD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dxw.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.r.a
    public void onListPullRefresh(boolean z) {
        if (!com.baidu.adp.lib.util.i.iQ()) {
            showToast(n.j.neterror);
            this.dxw.KK();
        } else if (!this.dxx.LoadData()) {
            this.dxw.KK();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c aCn = this.dxw.aCn();
        if (view == this.dxw.getProgressBar()) {
            if (this.dxw.aCl().getCurrentStatus() == 2) {
                showToast(n.j.signallforum_finished);
                return;
            }
            if (aCn.aBz() != 0) {
                lZ(aCn.aBA());
                this.Md.tf();
            } else if (com.baidu.adp.lib.util.i.iQ()) {
                aBW();
            } else {
                showToast(n.j.neterror);
            }
            TiebaStatic.log("signall_click");
        } else if (view == this.dxw.aCp()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        }
    }

    private void aBW() {
        c aCn = this.dxw.aCn();
        this.dxw.aCl().setDuration(Math.max(aCn.aBE().size() * 50, 2000));
        this.dxw.aCl().setSigning(0);
        this.dxy.d(aCn);
        this.dxy.LoadData();
        this.dxw.aCo().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        e eVar;
        if (this.dxw.aCo().getItemViewType(i) == 0 && this.dxw.aCn() != null && this.dxw.aCn().aBB() != null && this.dxw.aCn().aBB().size() > i && (eVar = this.dxw.aCn().aBB().get(i)) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(eVar.getForumName(), "signallforum")));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lZ(String str) {
        this.Md = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).cF(str).a(n.j.signallforum_signnow, new o(this));
        this.Md.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dxy != null && this.dxy.pZ) {
            aBX();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dxA = true;
        if (this.Md != null && this.Md.isShowing()) {
            this.Md.dismiss();
        }
        if (this.dxx != null) {
            this.dxx.cancelLoadData();
            this.dxx = null;
        }
        if (this.dxw != null && this.dxw.aCo() != null) {
            this.dxw.aCo().aBY();
        }
        if (this.dxy != null) {
            if (this.dxy.pZ) {
                aBX();
            }
            this.dxy.cancelMessage();
            this.dxy = null;
        }
        if (this.dxx != null) {
            this.dxx.cancelLoadData();
            this.dxx = null;
        }
    }

    private void aBX() {
        this.dxz = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(n.j.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.dxw.aCm();
    }
}
