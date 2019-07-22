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
    private j iWT;
    private GetForumListModel iWU;
    private SignAllForumModel iWV;
    private boolean iWW;
    private boolean isDestory;
    private boolean iWX = false;
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.iWT.cnv().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener iWY = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c cnx;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (cnx = SignAllForumActivity.this.iWT.cnx()) != null) {
                cnx.a((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.iWT.cny().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a iWZ = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            SignAllForumActivity.this.iWT.oT();
            a cmJ = cVar.cmJ();
            if (cmJ != null && cmJ.getErrorNumber() == 0) {
                SignAllForumActivity.this.iWT.a(cVar, SignAllForumActivity.this.iWU.cnc());
                return;
            }
            SignAllForumActivity.this.showToast(cmJ.getUserMsg(), false);
            SignAllForumActivity.this.finish();
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void yZ(String str) {
            SignAllForumActivity.this.iWT.oT();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a iXa = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void yZ(String str) {
            SignAllForumActivity.this.Er(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            if (hVar != null && hVar.getErrorCode() == 3250013 && SignAllForumActivity.this.iWX) {
                SignAllForumActivity.this.iWX = false;
                BdToast.b(TbadkCoreApplication.getInst().getContext(), hVar.getErrorMsg(), R.drawable.icon_toast_game_error, 3000).agQ();
                if (SignAllForumActivity.this.iWT != null && SignAllForumActivity.this.iWT.cnv() != null) {
                    SignAllForumActivity.this.iWT.cnv().setSignBefore(0);
                    return;
                }
                return;
            }
            a cmJ = hVar.cmJ();
            if (cmJ == null || cmJ.getErrorNumber() != 0) {
                SignAllForumActivity.this.Er(cmJ.getUserMsg());
                return;
            }
            c cnx = SignAllForumActivity.this.iWT.cnx();
            cnx.a(hVar);
            if (SignAllForumActivity.this.iWW) {
                Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{Integer.valueOf(cnx.cmQ()), Integer.valueOf(cnx.cmR())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                if (SignAllForumActivity.this.isDestory) {
                    return;
                }
            }
            SignAllForumActivity.this.iWT.cny().notifyDataSetChanged();
            SignAllForumProgressView cnv = SignAllForumActivity.this.iWT.cnv();
            if (!cnx.cmP()) {
                if (hVar.cnj() != 0) {
                    SignAllForumActivity.this.Es(hVar.cmH());
                    SignAllForumActivity.this.TX.agI();
                } else if (hVar.cnl() != 0) {
                    SignAllForumActivity.this.showToast(hVar.cnm());
                } else {
                    SignAllForumActivity.this.showToast(R.string.signallforum_error);
                }
            }
            if (SignAllForumActivity.this.TX == null || !SignAllForumActivity.this.TX.isShowing()) {
                SignAllForumActivity.this.cne();
            }
            cnv.setSignSuccess();
            SignAllForumActivity.this.b(cnx);
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12536").P("obj_locate", au.a.bUf));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12535").P("obj_locate", au.a.bUf));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void cne() {
        if (this.iWT != null) {
            com.baidu.tbadk.coreExtra.messageCenter.f.aoF().a(getPageContext(), this.iWT.aXy());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String cmy = cVar.cmy();
            final String avZ = cVar.avZ();
            final boolean cmM = cVar.cmM();
            if (cVar.cmx()) {
                this.iWT.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage(2002001, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), cmy, avZ, Boolean.valueOf(cmM))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Er(String str) {
        if (this.iWW) {
            c cnx = this.iWT.cnx();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{0, Integer.valueOf(cnx.cmL().size())});
            a(str, activity, false);
            if (this.isDestory) {
                return;
            }
        }
        showToast(str);
        this.iWT.cnv().setSignSuccess();
        ArrayList<d> cmL = this.iWT.cnx().cmL();
        int size = cmL.size();
        for (int i = 0; i < size; i++) {
            d dVar = cmL.get(i);
            dVar.qP(true);
            dVar.qQ(false);
            dVar.qO(false);
        }
        this.iWT.cny().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress, getPageContext().getString(R.string.app_name), str, str, pendingIntent, z);
    }

    private void anH() {
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
        anH();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.iWY);
        initData();
        initUI();
    }

    private void initUI() {
        this.iWT = new j(this);
        this.iWT.setListPullRefreshListener(this);
        this.iWT.setOnItemClickListener(this);
        if (this.iWV.isRunning) {
            this.iWZ.a(this.iWV.cnp());
            this.iWT.cnv().setSigning(90);
            return;
        }
        this.iWT.startPullRefresh();
    }

    private void initData() {
        this.iWU = new GetForumListModel(this);
        this.iWU.a(this.iWZ);
        this.iWV = new SignAllForumModel(this);
        this.iWV.a(this.iXa);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iWT.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void er(boolean z) {
        if (!com.baidu.adp.lib.util.j.kc()) {
            showToast(R.string.neterror);
            this.iWT.oT();
        } else if (this.iWU == null) {
            showToast(R.string.neterror);
        } else if (!this.iWU.LoadData()) {
            this.iWT.oT();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c cnx = this.iWT.cnx();
        if (view == this.iWT.getProgressBar()) {
            if (cnx != null) {
                if (cnx.getBlockPopInfoData() != null) {
                    if (cnx.getBlockPopInfoData().appeal_status == 1) {
                        BdToast.b(getPageContext().getPageActivity(), cnx.getBlockPopInfoData().appeal_msg, R.drawable.icon_toast_game_error, 3000).agQ();
                    } else if (AntiHelper.a(getPageContext().getPageActivity(), cnx.getBlockPopInfoData(), this.mInjectListener) != null) {
                        TiebaStatic.log(new an("c12534").P("obj_locate", au.a.bUf));
                    }
                } else if (this.iWT.cnv().getCurrentStatus() == 2) {
                    showToast(R.string.signallforum_finished);
                } else {
                    if (cnx.cmG() != 0) {
                        Es(cnx.cmH());
                        this.TX.agI();
                    } else if (com.baidu.adp.lib.util.j.kc()) {
                        this.iWX = true;
                        cnf();
                    } else {
                        showToast(R.string.neterror);
                    }
                    TiebaStatic.log("signall_click");
                }
            }
        } else if (view == this.iWT.cnz()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone("a_key_to_sign_V8.9", "bottom_opende/renewalfee_button_V8.9");
            sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    private void cnf() {
        c cnx = this.iWT.cnx();
        this.iWT.cnv().setDuration(Math.max(cnx.cmL().size() * 50, 2000));
        this.iWT.cnv().setSigning(0);
        this.iWV.d(cnx);
        this.iWV.LoadData();
        this.iWT.cny().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.iWT.cny().getItemViewType(i) == 0 && this.iWT.cnx() != null && this.iWT.cnx().cmI() != null && this.iWT.cnx().cmI().size() > i && (dVar = this.iWT.cnx().cmI().get(i)) != null) {
            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum").setCallFrom(6)));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Es(String str) {
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
        if (this.iWV != null && this.iWV.isRunning) {
            cng();
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
        if (this.iWU != null) {
            this.iWU.cancelLoadData();
            this.iWU = null;
        }
        if (this.iWT != null && this.iWT.cny() != null) {
            this.iWT.cny().cnh();
        }
        if (this.iWV != null) {
            if (this.iWV.isRunning) {
                cng();
            }
            this.iWV.cancelMessage();
            this.iWV = null;
        }
        if (this.iWU != null) {
            this.iWU.cancelLoadData();
            this.iWU = null;
        }
    }

    private void cng() {
        this.iWW = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(R.string.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public p onGetPreLoadListView() {
        if (this.iWT == null || this.iWT.cnw() == null) {
            return null;
        }
        return this.iWT.cnw().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a022";
    }
}
