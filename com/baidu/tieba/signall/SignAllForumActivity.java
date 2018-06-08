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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.d;
import com.baidu.tieba.signall.GetForumListModel;
import com.baidu.tieba.signall.SignAllForumModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements f.b {
    private com.baidu.tbadk.core.dialog.a Qk;
    private j gzI;
    private GetForumListModel gzJ;
    private SignAllForumModel gzK;
    private boolean gzL;
    private boolean isDestory;
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.gzI.btX().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener gzM = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c btZ;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (btZ = SignAllForumActivity.this.gzI.btZ()) != null) {
                btZ.a((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.gzI.bua().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a gzN = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            SignAllForumActivity.this.gzI.nW();
            a btl = cVar.btl();
            if (btl != null && btl.getErrorNumber() == 0) {
                SignAllForumActivity.this.gzI.a(cVar, SignAllForumActivity.this.gzJ.btE());
                return;
            }
            SignAllForumActivity.this.showToast(btl.getUserMsg(), false);
            SignAllForumActivity.this.finish();
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void ol(String str) {
            SignAllForumActivity.this.gzI.nW();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a gzO = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void ol(String str) {
            SignAllForumActivity.this.tt(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            a btl = hVar.btl();
            if (btl == null || btl.getErrorNumber() != 0) {
                SignAllForumActivity.this.tt(btl.getUserMsg());
                return;
            }
            c btZ = SignAllForumActivity.this.gzI.btZ();
            btZ.a(hVar);
            if (SignAllForumActivity.this.gzL) {
                Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(d.k.signallforum_back_finish, new Object[]{Integer.valueOf(btZ.bts()), Integer.valueOf(btZ.btt())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                if (SignAllForumActivity.this.isDestory) {
                    return;
                }
            }
            SignAllForumActivity.this.gzI.bua().notifyDataSetChanged();
            SignAllForumProgressView btX = SignAllForumActivity.this.gzI.btX();
            if (!btZ.btr()) {
                if (hVar.btK() != 0) {
                    SignAllForumActivity.this.tu(hVar.btj());
                    SignAllForumActivity.this.Qk.xa();
                } else if (hVar.btM() != 0) {
                    SignAllForumActivity.this.showToast(hVar.btN());
                } else {
                    SignAllForumActivity.this.showToast(d.k.signallforum_error);
                }
            }
            btX.setSignSuccess();
            SignAllForumActivity.this.b(btZ);
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").r("obj_locate", as.a.arn));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").r("obj_locate", as.a.arn));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String bta = cVar.bta();
            final String KP = cVar.KP();
            final boolean bto = cVar.bto();
            if (cVar.bsZ()) {
                this.gzI.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage(2002001, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), bta, KP, Boolean.valueOf(bto))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(String str) {
        if (this.gzL) {
            c btZ = this.gzI.btZ();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(d.k.signallforum_back_finish, new Object[]{0, Integer.valueOf(btZ.btn().size())});
            a(str, activity, false);
            if (this.isDestory) {
                return;
            }
        }
        showToast(str);
        this.gzI.btX().setSignSuccess();
        ArrayList<d> btn = this.gzI.btZ().btn();
        int size = btn.size();
        for (int i = 0; i < size; i++) {
            d dVar = btn.get(i);
            dVar.mi(true);
            dVar.mj(false);
            dVar.mh(false);
        }
        this.gzI.bua().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), d.f.singnallforum_progress, getPageContext().getString(d.k.app_name), str, str, pendingIntent, z);
    }

    private void Db() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), d.f.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!TbadkCoreApplication.isLogin()) {
            ba.aT(getActivity());
            finish();
            return;
        }
        Db();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.gzM);
        initData();
        initUI();
    }

    private void initUI() {
        this.gzI = new j(this);
        this.gzI.a(this);
        this.gzI.setOnItemClickListener(this);
        if (this.gzK.isRunning) {
            this.gzN.a(this.gzK.btQ());
            this.gzI.btX().setSigning(90);
            return;
        }
        this.gzI.startPullRefresh();
    }

    private void initData() {
        this.gzJ = new GetForumListModel(this);
        this.gzJ.a(this.gzN);
        this.gzK = new SignAllForumModel(this);
        this.gzK.a(this.gzO);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gzI.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.f.b
    public void aS(boolean z) {
        if (!com.baidu.adp.lib.util.j.jD()) {
            showToast(d.k.neterror);
            this.gzI.nW();
        } else if (this.gzJ == null) {
            showToast(d.k.neterror);
        } else if (!this.gzJ.LoadData()) {
            this.gzI.nW();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c btZ = this.gzI.btZ();
        if (view == this.gzI.getProgressBar()) {
            if (btZ.getBlockPopInfoData() != null) {
                if (AntiHelper.a(getPageContext().getPageActivity(), btZ.getBlockPopInfoData(), this.mInjectListener) != null) {
                    TiebaStatic.log(new am("c12534").r("obj_locate", as.a.arn));
                }
            } else if (this.gzI.btX().getCurrentStatus() == 2) {
                showToast(d.k.signallforum_finished);
            } else {
                if (btZ.bti() != 0) {
                    tu(btZ.btj());
                    this.Qk.xa();
                } else if (com.baidu.adp.lib.util.j.jD()) {
                    btG();
                } else {
                    showToast(d.k.neterror);
                }
                TiebaStatic.log("signall_click");
            }
        } else if (view == this.gzI.bub()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone("a_key_to_sign_V8.9", "bottom_opende/renewalfee_button_V8.9");
            sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    private void btG() {
        c btZ = this.gzI.btZ();
        this.gzI.btX().setDuration(Math.max(btZ.btn().size() * 50, 2000));
        this.gzI.btX().setSigning(0);
        this.gzK.d(btZ);
        this.gzK.LoadData();
        this.gzI.bua().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.gzI.bua().getItemViewType(i) == 0 && this.gzI.btZ() != null && this.gzI.btZ().btk() != null && this.gzI.btZ().btk().size() > i && (dVar = this.gzI.btZ().btk().get(i)) != null) {
            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum")));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tu(String str) {
        this.Qk = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).dB(str).a(d.k.signallforum_signnow, new a.b() { // from class: com.baidu.tieba.signall.SignAllForumActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.Qk.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.gzK != null && this.gzK.isRunning) {
            btH();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.isDestory = true;
        if (this.Qk != null && this.Qk.isShowing()) {
            this.Qk.dismiss();
        }
        if (this.gzJ != null) {
            this.gzJ.cancelLoadData();
            this.gzJ = null;
        }
        if (this.gzI != null && this.gzI.bua() != null) {
            this.gzI.bua().btI();
        }
        if (this.gzK != null) {
            if (this.gzK.isRunning) {
                btH();
            }
            this.gzK.cancelMessage();
            this.gzK = null;
        }
        if (this.gzJ != null) {
            this.gzJ.cancelLoadData();
            this.gzJ = null;
        }
    }

    private void btH() {
        this.gzL = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(d.k.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (this.gzI == null || this.gzI.btY() == null) {
            return null;
        }
        return this.gzI.btY().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a022";
    }
}
