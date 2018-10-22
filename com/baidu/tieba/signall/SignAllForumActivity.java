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
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.e;
import com.baidu.tieba.signall.GetForumListModel;
import com.baidu.tieba.signall.SignAllForumModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements j.b {
    private com.baidu.tbadk.core.dialog.a Tb;
    private j gTN;
    private GetForumListModel gTO;
    private SignAllForumModel gTP;
    private boolean gTQ;
    private boolean isDestory;
    private boolean gTR = false;
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.gTN.byW().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener gTS = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c byY;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (byY = SignAllForumActivity.this.gTN.byY()) != null) {
                byY.a((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.gTN.byZ().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a gTT = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            SignAllForumActivity.this.gTN.pj();
            a byj = cVar.byj();
            if (byj != null && byj.getErrorNumber() == 0) {
                SignAllForumActivity.this.gTN.a(cVar, SignAllForumActivity.this.gTO.byC());
                return;
            }
            SignAllForumActivity.this.showToast(byj.getUserMsg(), false);
            SignAllForumActivity.this.finish();
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void py(String str) {
            SignAllForumActivity.this.gTN.pj();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a gTU = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void py(String str) {
            SignAllForumActivity.this.uD(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            if (hVar != null && hVar.getErrorCode() == 3250013 && SignAllForumActivity.this.gTR) {
                SignAllForumActivity.this.gTR = false;
                BdToast.a(TbadkCoreApplication.getInst().getContext(), hVar.getErrorMsg(), e.f.icon_toast_game_error, 3000).AC();
                if (SignAllForumActivity.this.gTN != null && SignAllForumActivity.this.gTN.byW() != null) {
                    SignAllForumActivity.this.gTN.byW().setSignBefore(0);
                    return;
                }
                return;
            }
            a byj = hVar.byj();
            if (byj == null || byj.getErrorNumber() != 0) {
                SignAllForumActivity.this.uD(byj.getUserMsg());
                return;
            }
            c byY = SignAllForumActivity.this.gTN.byY();
            byY.a(hVar);
            if (SignAllForumActivity.this.gTQ) {
                Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(e.j.signallforum_back_finish, new Object[]{Integer.valueOf(byY.byq()), Integer.valueOf(byY.byr())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                if (SignAllForumActivity.this.isDestory) {
                    return;
                }
            }
            SignAllForumActivity.this.gTN.byZ().notifyDataSetChanged();
            SignAllForumProgressView byW = SignAllForumActivity.this.gTN.byW();
            if (!byY.byp()) {
                if (hVar.byJ() != 0) {
                    SignAllForumActivity.this.uE(hVar.byh());
                    SignAllForumActivity.this.Tb.Au();
                } else if (hVar.byL() != 0) {
                    SignAllForumActivity.this.showToast(hVar.byM());
                } else {
                    SignAllForumActivity.this.showToast(e.j.signallforum_error);
                }
            }
            if (SignAllForumActivity.this.Tb == null || !SignAllForumActivity.this.Tb.isShowing()) {
                SignAllForumActivity.this.byE();
            }
            byW.setSignSuccess();
            SignAllForumActivity.this.b(byY);
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").x("obj_locate", as.a.ayB));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").x("obj_locate", as.a.ayB));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void byE() {
        if (this.gTN != null) {
            com.baidu.tbadk.coreExtra.messageCenter.d.HB().a(getPageContext(), this.gTN.aAJ());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String bxY = cVar.bxY();
            final String Ov = cVar.Ov();
            final boolean bym = cVar.bym();
            if (cVar.bxX()) {
                this.gTN.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage(2002001, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), bxY, Ov, Boolean.valueOf(bym))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uD(String str) {
        if (this.gTQ) {
            c byY = this.gTN.byY();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(e.j.signallforum_back_finish, new Object[]{0, Integer.valueOf(byY.byl().size())});
            a(str, activity, false);
            if (this.isDestory) {
                return;
            }
        }
        showToast(str);
        this.gTN.byW().setSignSuccess();
        ArrayList<d> byl = this.gTN.byY().byl();
        int size = byl.size();
        for (int i = 0; i < size; i++) {
            d dVar = byl.get(i);
            dVar.mT(true);
            dVar.mU(false);
            dVar.mS(false);
        }
        this.gTN.byZ().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), e.f.singnallforum_progress, getPageContext().getString(e.j.app_name), str, str, pendingIntent, z);
    }

    private void GD() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), e.f.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!TbadkCoreApplication.isLogin()) {
            ba.bH(getActivity());
            finish();
            return;
        }
        GD();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.gTS);
        initData();
        initUI();
    }

    private void initUI() {
        this.gTN = new j(this);
        this.gTN.a(this);
        this.gTN.setOnItemClickListener(this);
        if (this.gTP.isRunning) {
            this.gTT.a(this.gTP.byP());
            this.gTN.byW().setSigning(90);
            return;
        }
        this.gTN.startPullRefresh();
    }

    private void initData() {
        this.gTO = new GetForumListModel(this);
        this.gTO.a(this.gTT);
        this.gTP = new SignAllForumModel(this);
        this.gTP.a(this.gTU);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gTN.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bp(boolean z) {
        if (!com.baidu.adp.lib.util.j.kX()) {
            showToast(e.j.neterror);
            this.gTN.pj();
        } else if (this.gTO == null) {
            showToast(e.j.neterror);
        } else if (!this.gTO.LoadData()) {
            this.gTN.pj();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c byY = this.gTN.byY();
        if (view == this.gTN.getProgressBar()) {
            if (byY != null) {
                if (byY.getBlockPopInfoData() != null) {
                    if (byY.getBlockPopInfoData().appeal_status == 1) {
                        BdToast.a(getPageContext().getPageActivity(), byY.getBlockPopInfoData().appeal_msg, e.f.icon_toast_game_error, 3000).AC();
                    } else if (AntiHelper.a(getPageContext().getPageActivity(), byY.getBlockPopInfoData(), this.mInjectListener) != null) {
                        TiebaStatic.log(new am("c12534").x("obj_locate", as.a.ayB));
                    }
                } else if (this.gTN.byW().getCurrentStatus() == 2) {
                    showToast(e.j.signallforum_finished);
                } else {
                    if (byY.byg() != 0) {
                        uE(byY.byh());
                        this.Tb.Au();
                    } else if (com.baidu.adp.lib.util.j.kX()) {
                        this.gTR = true;
                        byF();
                    } else {
                        showToast(e.j.neterror);
                    }
                    TiebaStatic.log("signall_click");
                }
            }
        } else if (view == this.gTN.bza()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone("a_key_to_sign_V8.9", "bottom_opende/renewalfee_button_V8.9");
            sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    private void byF() {
        c byY = this.gTN.byY();
        this.gTN.byW().setDuration(Math.max(byY.byl().size() * 50, 2000));
        this.gTN.byW().setSigning(0);
        this.gTP.d(byY);
        this.gTP.LoadData();
        this.gTN.byZ().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.gTN.byZ().getItemViewType(i) == 0 && this.gTN.byY() != null && this.gTN.byY().byi() != null && this.gTN.byY().byi().size() > i && (dVar = this.gTN.byY().byi().get(i)) != null) {
            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum").setCallFrom(6)));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uE(String str) {
        this.Tb = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).ej(str).a(e.j.signallforum_signnow, new a.b() { // from class: com.baidu.tieba.signall.SignAllForumActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.Tb.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.gTP != null && this.gTP.isRunning) {
            byG();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.isDestory = true;
        if (this.Tb != null && this.Tb.isShowing()) {
            this.Tb.dismiss();
        }
        if (this.gTO != null) {
            this.gTO.cancelLoadData();
            this.gTO = null;
        }
        if (this.gTN != null && this.gTN.byZ() != null) {
            this.gTN.byZ().byH();
        }
        if (this.gTP != null) {
            if (this.gTP.isRunning) {
                byG();
            }
            this.gTP.cancelMessage();
            this.gTP = null;
        }
        if (this.gTO != null) {
            this.gTO.cancelLoadData();
            this.gTO = null;
        }
    }

    private void byG() {
        this.gTQ = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(e.j.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (this.gTN == null || this.gTN.byX() == null) {
            return null;
        }
        return this.gTN.byX().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a022";
    }
}
