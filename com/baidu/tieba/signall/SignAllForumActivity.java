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
    private j gTM;
    private GetForumListModel gTN;
    private SignAllForumModel gTO;
    private boolean gTP;
    private boolean isDestory;
    private boolean gTQ = false;
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.gTM.byW().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener gTR = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c byY;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (byY = SignAllForumActivity.this.gTM.byY()) != null) {
                byY.a((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.gTM.byZ().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a gTS = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            SignAllForumActivity.this.gTM.pj();
            a byj = cVar.byj();
            if (byj != null && byj.getErrorNumber() == 0) {
                SignAllForumActivity.this.gTM.a(cVar, SignAllForumActivity.this.gTN.byC());
                return;
            }
            SignAllForumActivity.this.showToast(byj.getUserMsg(), false);
            SignAllForumActivity.this.finish();
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void py(String str) {
            SignAllForumActivity.this.gTM.pj();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a gTT = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void py(String str) {
            SignAllForumActivity.this.uD(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            if (hVar != null && hVar.getErrorCode() == 3250013 && SignAllForumActivity.this.gTQ) {
                SignAllForumActivity.this.gTQ = false;
                BdToast.a(TbadkCoreApplication.getInst().getContext(), hVar.getErrorMsg(), e.f.icon_toast_game_error, 3000).AC();
                if (SignAllForumActivity.this.gTM != null && SignAllForumActivity.this.gTM.byW() != null) {
                    SignAllForumActivity.this.gTM.byW().setSignBefore(0);
                    return;
                }
                return;
            }
            a byj = hVar.byj();
            if (byj == null || byj.getErrorNumber() != 0) {
                SignAllForumActivity.this.uD(byj.getUserMsg());
                return;
            }
            c byY = SignAllForumActivity.this.gTM.byY();
            byY.a(hVar);
            if (SignAllForumActivity.this.gTP) {
                Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(e.j.signallforum_back_finish, new Object[]{Integer.valueOf(byY.byq()), Integer.valueOf(byY.byr())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                if (SignAllForumActivity.this.isDestory) {
                    return;
                }
            }
            SignAllForumActivity.this.gTM.byZ().notifyDataSetChanged();
            SignAllForumProgressView byW = SignAllForumActivity.this.gTM.byW();
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
        if (this.gTM != null) {
            com.baidu.tbadk.coreExtra.messageCenter.d.HB().a(getPageContext(), this.gTM.aAI());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String bxY = cVar.bxY();
            final String Ov = cVar.Ov();
            final boolean bym = cVar.bym();
            if (cVar.bxX()) {
                this.gTM.setListViewSelection(0);
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
        if (this.gTP) {
            c byY = this.gTM.byY();
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
        this.gTM.byW().setSignSuccess();
        ArrayList<d> byl = this.gTM.byY().byl();
        int size = byl.size();
        for (int i = 0; i < size; i++) {
            d dVar = byl.get(i);
            dVar.mT(true);
            dVar.mU(false);
            dVar.mS(false);
        }
        this.gTM.byZ().notifyDataSetChanged();
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
        registerListener(this.gTR);
        initData();
        initUI();
    }

    private void initUI() {
        this.gTM = new j(this);
        this.gTM.a(this);
        this.gTM.setOnItemClickListener(this);
        if (this.gTO.isRunning) {
            this.gTS.a(this.gTO.byP());
            this.gTM.byW().setSigning(90);
            return;
        }
        this.gTM.startPullRefresh();
    }

    private void initData() {
        this.gTN = new GetForumListModel(this);
        this.gTN.a(this.gTS);
        this.gTO = new SignAllForumModel(this);
        this.gTO.a(this.gTT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gTM.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bp(boolean z) {
        if (!com.baidu.adp.lib.util.j.kX()) {
            showToast(e.j.neterror);
            this.gTM.pj();
        } else if (this.gTN == null) {
            showToast(e.j.neterror);
        } else if (!this.gTN.LoadData()) {
            this.gTM.pj();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c byY = this.gTM.byY();
        if (view == this.gTM.getProgressBar()) {
            if (byY != null) {
                if (byY.getBlockPopInfoData() != null) {
                    if (byY.getBlockPopInfoData().appeal_status == 1) {
                        BdToast.a(getPageContext().getPageActivity(), byY.getBlockPopInfoData().appeal_msg, e.f.icon_toast_game_error, 3000).AC();
                    } else if (AntiHelper.a(getPageContext().getPageActivity(), byY.getBlockPopInfoData(), this.mInjectListener) != null) {
                        TiebaStatic.log(new am("c12534").x("obj_locate", as.a.ayB));
                    }
                } else if (this.gTM.byW().getCurrentStatus() == 2) {
                    showToast(e.j.signallforum_finished);
                } else {
                    if (byY.byg() != 0) {
                        uE(byY.byh());
                        this.Tb.Au();
                    } else if (com.baidu.adp.lib.util.j.kX()) {
                        this.gTQ = true;
                        byF();
                    } else {
                        showToast(e.j.neterror);
                    }
                    TiebaStatic.log("signall_click");
                }
            }
        } else if (view == this.gTM.bza()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone("a_key_to_sign_V8.9", "bottom_opende/renewalfee_button_V8.9");
            sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    private void byF() {
        c byY = this.gTM.byY();
        this.gTM.byW().setDuration(Math.max(byY.byl().size() * 50, 2000));
        this.gTM.byW().setSigning(0);
        this.gTO.d(byY);
        this.gTO.LoadData();
        this.gTM.byZ().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.gTM.byZ().getItemViewType(i) == 0 && this.gTM.byY() != null && this.gTM.byY().byi() != null && this.gTM.byY().byi().size() > i && (dVar = this.gTM.byY().byi().get(i)) != null) {
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
        if (this.gTO != null && this.gTO.isRunning) {
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
        if (this.gTN != null) {
            this.gTN.cancelLoadData();
            this.gTN = null;
        }
        if (this.gTM != null && this.gTM.byZ() != null) {
            this.gTM.byZ().byH();
        }
        if (this.gTO != null) {
            if (this.gTO.isRunning) {
                byG();
            }
            this.gTO.cancelMessage();
            this.gTO = null;
        }
        if (this.gTN != null) {
            this.gTN.cancelLoadData();
            this.gTN = null;
        }
    }

    private void byG() {
        this.gTP = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(e.j.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (this.gTM == null || this.gTM.byX() == null) {
            return null;
        }
        return this.gTM.byX().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a022";
    }
}
