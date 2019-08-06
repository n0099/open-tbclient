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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import com.baidu.tieba.signall.GetForumListModel;
import com.baidu.tieba.signall.SignAllForumModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements h.c {
    private com.baidu.tbadk.core.dialog.a TX;
    private j iXX;
    private GetForumListModel iXY;
    private SignAllForumModel iXZ;
    private boolean iYa;
    private boolean isDestory;
    private boolean iYb = false;
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.iXX.cnN().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener iYc = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c cnP;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (cnP = SignAllForumActivity.this.iXX.cnP()) != null) {
                cnP.a((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.iXX.cnQ().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a iYd = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            SignAllForumActivity.this.iXX.oT();
            a cnb = cVar.cnb();
            if (cnb != null && cnb.getErrorNumber() == 0) {
                SignAllForumActivity.this.iXX.a(cVar, SignAllForumActivity.this.iXY.cnu());
                return;
            }
            SignAllForumActivity.this.showToast(cnb.getUserMsg(), false);
            SignAllForumActivity.this.finish();
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void za(String str) {
            SignAllForumActivity.this.iXX.oT();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a iYe = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void za(String str) {
            SignAllForumActivity.this.Es(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            if (hVar != null && hVar.getErrorCode() == 3250013 && SignAllForumActivity.this.iYb) {
                SignAllForumActivity.this.iYb = false;
                BdToast.b(TbadkCoreApplication.getInst().getContext(), hVar.getErrorMsg(), R.drawable.icon_toast_game_error, 3000).agS();
                if (SignAllForumActivity.this.iXX != null && SignAllForumActivity.this.iXX.cnN() != null) {
                    SignAllForumActivity.this.iXX.cnN().setSignBefore(0);
                    return;
                }
                return;
            }
            a cnb = hVar.cnb();
            if (cnb == null || cnb.getErrorNumber() != 0) {
                SignAllForumActivity.this.Es(cnb.getUserMsg());
                return;
            }
            c cnP = SignAllForumActivity.this.iXX.cnP();
            cnP.a(hVar);
            if (SignAllForumActivity.this.iYa) {
                Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{Integer.valueOf(cnP.cni()), Integer.valueOf(cnP.cnj())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                if (SignAllForumActivity.this.isDestory) {
                    return;
                }
            }
            SignAllForumActivity.this.iXX.cnQ().notifyDataSetChanged();
            SignAllForumProgressView cnN = SignAllForumActivity.this.iXX.cnN();
            if (!cnP.cnh()) {
                if (hVar.cnB() != 0) {
                    SignAllForumActivity.this.Et(hVar.cmZ());
                    SignAllForumActivity.this.TX.agK();
                } else if (hVar.cnD() != 0) {
                    SignAllForumActivity.this.showToast(hVar.cnE());
                } else {
                    SignAllForumActivity.this.showToast(R.string.signallforum_error);
                }
            }
            if (SignAllForumActivity.this.TX == null || !SignAllForumActivity.this.TX.isShowing()) {
                SignAllForumActivity.this.cnw();
            }
            cnN.setSignSuccess();
            SignAllForumActivity.this.b(cnP);
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12536").P("obj_locate", au.a.bUl));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12535").P("obj_locate", au.a.bUl));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void cnw() {
        if (this.iXX != null) {
            com.baidu.tbadk.coreExtra.messageCenter.f.aoH().a(getPageContext(), this.iXX.aXA());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String cmQ = cVar.cmQ();
            final String awb = cVar.awb();
            final boolean cne = cVar.cne();
            if (cVar.cmP()) {
                this.iXX.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage(2002001, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), cmQ, awb, Boolean.valueOf(cne))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Es(String str) {
        if (this.iYa) {
            c cnP = this.iXX.cnP();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{0, Integer.valueOf(cnP.cnd().size())});
            a(str, activity, false);
            if (this.isDestory) {
                return;
            }
        }
        showToast(str);
        this.iXX.cnN().setSignSuccess();
        ArrayList<d> cnd = this.iXX.cnP().cnd();
        int size = cnd.size();
        for (int i = 0; i < size; i++) {
            d dVar = cnd.get(i);
            dVar.qQ(true);
            dVar.qR(false);
            dVar.qP(false);
        }
        this.iXX.cnQ().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress, getPageContext().getString(R.string.app_name), str, str, pendingIntent, z);
    }

    private void anJ() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!TbadkCoreApplication.isLogin()) {
            bd.cE(getActivity());
            finish();
            return;
        }
        anJ();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.iYc);
        initData();
        initUI();
    }

    private void initUI() {
        this.iXX = new j(this);
        this.iXX.setListPullRefreshListener(this);
        this.iXX.setOnItemClickListener(this);
        if (this.iXZ.isRunning) {
            this.iYd.a(this.iXZ.cnH());
            this.iXX.cnN().setSigning(90);
            return;
        }
        this.iXX.startPullRefresh();
    }

    private void initData() {
        this.iXY = new GetForumListModel(this);
        this.iXY.a(this.iYd);
        this.iXZ = new SignAllForumModel(this);
        this.iXZ.a(this.iYe);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iXX.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void er(boolean z) {
        if (!com.baidu.adp.lib.util.j.kc()) {
            showToast(R.string.neterror);
            this.iXX.oT();
        } else if (this.iXY == null) {
            showToast(R.string.neterror);
        } else if (!this.iXY.LoadData()) {
            this.iXX.oT();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c cnP = this.iXX.cnP();
        if (view == this.iXX.getProgressBar()) {
            if (cnP != null) {
                if (cnP.getBlockPopInfoData() != null) {
                    if (cnP.getBlockPopInfoData().appeal_status == 1) {
                        BdToast.b(getPageContext().getPageActivity(), cnP.getBlockPopInfoData().appeal_msg, R.drawable.icon_toast_game_error, 3000).agS();
                    } else if (AntiHelper.a(getPageContext().getPageActivity(), cnP.getBlockPopInfoData(), this.mInjectListener) != null) {
                        TiebaStatic.log(new an("c12534").P("obj_locate", au.a.bUl));
                    }
                } else if (this.iXX.cnN().getCurrentStatus() == 2) {
                    showToast(R.string.signallforum_finished);
                } else {
                    if (cnP.cmY() != 0) {
                        Et(cnP.cmZ());
                        this.TX.agK();
                    } else if (com.baidu.adp.lib.util.j.kc()) {
                        this.iYb = true;
                        cnx();
                    } else {
                        showToast(R.string.neterror);
                    }
                    TiebaStatic.log("signall_click");
                }
            }
        } else if (view == this.iXX.cnR()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone("a_key_to_sign_V8.9", "bottom_opende/renewalfee_button_V8.9");
            sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    private void cnx() {
        c cnP = this.iXX.cnP();
        this.iXX.cnN().setDuration(Math.max(cnP.cnd().size() * 50, 2000));
        this.iXX.cnN().setSigning(0);
        this.iXZ.d(cnP);
        this.iXZ.LoadData();
        this.iXX.cnQ().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.iXX.cnQ().getItemViewType(i) == 0 && this.iXX.cnP() != null && this.iXX.cnP().cna() != null && this.iXX.cnP().cna().size() > i && (dVar = this.iXX.cnP().cna().get(i)) != null) {
            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum").setCallFrom(6)));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Et(String str) {
        this.TX = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).mO(str).a(R.string.signallforum_signnow, new a.b() { // from class: com.baidu.tieba.signall.SignAllForumActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.TX.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.iXZ != null && this.iXZ.isRunning) {
            cny();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.isDestory = true;
        if (this.TX != null && this.TX.isShowing()) {
            this.TX.dismiss();
        }
        if (this.iXY != null) {
            this.iXY.cancelLoadData();
            this.iXY = null;
        }
        if (this.iXX != null && this.iXX.cnQ() != null) {
            this.iXX.cnQ().cnz();
        }
        if (this.iXZ != null) {
            if (this.iXZ.isRunning) {
                cny();
            }
            this.iXZ.cancelMessage();
            this.iXZ = null;
        }
        if (this.iXY != null) {
            this.iXY.cancelLoadData();
            this.iXY = null;
        }
    }

    private void cny() {
        this.iYa = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(R.string.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public p onGetPreLoadListView() {
        if (this.iXX == null || this.iXX.cnO() == null) {
            return null;
        }
        return this.iXX.cnO().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a022";
    }
}
