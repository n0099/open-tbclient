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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.MemberPayStatistic;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.signall.GetForumListModel;
import com.baidu.tieba.signall.SignAllForumModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements g.c {
    private com.baidu.tbadk.core.dialog.a FR;
    private boolean isDestory;
    private j kal;
    private GetForumListModel kam;
    private SignAllForumModel kan;
    private boolean kao;
    private boolean kap = false;
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.kal.cJF().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener kaq = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c cJH;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (cJH = SignAllForumActivity.this.kal.cJH()) != null) {
                cJH.b((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.kal.cJI().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a kar = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            SignAllForumActivity.this.kal.completeRefresh();
            a cIT = cVar.cIT();
            if (cIT != null && cIT.getErrorNumber() == 0) {
                SignAllForumActivity.this.kal.a(cVar, SignAllForumActivity.this.kam.cJm());
                return;
            }
            SignAllForumActivity.this.showToast(cIT.getUserMsg(), false);
            SignAllForumActivity.this.finish();
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void Da(String str) {
            SignAllForumActivity.this.kal.completeRefresh();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a kas = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void Da(String str) {
            SignAllForumActivity.this.II(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            if (hVar != null && hVar.getErrorCode() == 3250013 && SignAllForumActivity.this.kap) {
                SignAllForumActivity.this.kap = false;
                BdToast.a(TbadkCoreApplication.getInst().getContext(), hVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aEL();
                if (SignAllForumActivity.this.kal != null && SignAllForumActivity.this.kal.cJF() != null) {
                    SignAllForumActivity.this.kal.cJF().setSignBefore(0);
                    return;
                }
                return;
            }
            a cIT = hVar.cIT();
            if (cIT == null || cIT.getErrorNumber() != 0) {
                SignAllForumActivity.this.II(cIT.getUserMsg());
                return;
            }
            c cJH = SignAllForumActivity.this.kal.cJH();
            cJH.a(hVar);
            if (SignAllForumActivity.this.kao) {
                Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{Integer.valueOf(cJH.cJa()), Integer.valueOf(cJH.cJb())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                if (SignAllForumActivity.this.isDestory) {
                    return;
                }
            }
            SignAllForumActivity.this.kal.cJI().notifyDataSetChanged();
            SignAllForumProgressView cJF = SignAllForumActivity.this.kal.cJF();
            if (!cJH.cIZ()) {
                if (hVar.cJt() != 0) {
                    SignAllForumActivity.this.IJ(hVar.cIR());
                    SignAllForumActivity.this.FR.aEG();
                } else if (hVar.cJv() != 0) {
                    SignAllForumActivity.this.showToast(hVar.cJw());
                } else {
                    SignAllForumActivity.this.showToast(R.string.signallforum_error);
                }
            }
            if (SignAllForumActivity.this.FR == null || !SignAllForumActivity.this.FR.isShowing()) {
                SignAllForumActivity.this.cJo();
            }
            cJF.setSignSuccess();
            SignAllForumActivity.this.b(cJH);
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).X("obj_locate", at.a.LOCATE_SIGN));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).X("obj_locate", at.a.LOCATE_SIGN));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void cJo() {
        if (this.kal != null) {
            com.baidu.tbadk.coreExtra.messageCenter.f.aLL().a(getPageContext(), this.kal.bsL());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String cII = cVar.cII();
            final String aRU = cVar.aRU();
            final boolean cIW = cVar.cIW();
            if (cVar.cIH()) {
                this.kal.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), cII, aRU, Boolean.valueOf(cIW))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void II(String str) {
        if (this.kao) {
            c cJH = this.kal.cJH();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{0, Integer.valueOf(cJH.cIV().size())});
            a(str, activity, false);
            if (this.isDestory) {
                return;
            }
        }
        showToast(str);
        this.kal.cJF().setSignSuccess();
        ArrayList<d> cIV = this.kal.cJH().cIV();
        int size = cIV.size();
        for (int i = 0; i < size; i++) {
            d dVar = cIV.get(i);
            dVar.sG(true);
            dVar.sH(false);
            dVar.sF(false);
        }
        this.kal.cJI().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress, getPageContext().getString(R.string.app_name), str, str, pendingIntent, z);
    }

    private void aKN() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!TbadkCoreApplication.isLogin()) {
            bc.skipToLoginActivity(getActivity());
            finish();
            return;
        }
        aKN();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.kaq);
        initData();
        initUI();
    }

    private void initUI() {
        this.kal = new j(this);
        this.kal.setListPullRefreshListener(this);
        this.kal.setOnItemClickListener(this);
        if (this.kan.isRunning) {
            this.kar.a(this.kan.cJz());
            this.kal.cJF().setSigning(90);
            return;
        }
        this.kal.startPullRefresh();
    }

    private void initData() {
        this.kam = new GetForumListModel(this);
        this.kam.a(this.kar);
        this.kan = new SignAllForumModel(this);
        this.kan.a(this.kas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kal.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            this.kal.completeRefresh();
        } else if (this.kam == null) {
            showToast(R.string.neterror);
        } else if (!this.kam.LoadData()) {
            this.kal.completeRefresh();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c cJH = this.kal.cJH();
        if (view == this.kal.getProgressBar()) {
            if (cJH != null) {
                if (cJH.getBlockPopInfoData() != null) {
                    if (cJH.getBlockPopInfoData().appeal_status == 1) {
                        BdToast.a(getPageContext().getPageActivity(), cJH.getBlockPopInfoData().appeal_msg, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aEL();
                    } else if (AntiHelper.a(getPageContext().getPageActivity(), cJH.getBlockPopInfoData(), this.mInjectListener) != null) {
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).X("obj_locate", at.a.LOCATE_SIGN));
                    }
                } else if (this.kal.cJF().getCurrentStatus() == 2) {
                    showToast(R.string.signallforum_finished);
                } else {
                    if (cJH.cIQ() != 0) {
                        IJ(cJH.cIR());
                        this.FR.aEG();
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.kap = true;
                        cJp();
                    } else {
                        showToast(R.string.neterror);
                    }
                    TiebaStatic.log("signall_click");
                }
            }
        } else if (view == this.kal.cJJ()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_A_KEY_TO_SIGN, MemberPayStatistic.CLICK_ZONE_BOTTOM_OPENDE_RENEWALFEE_BUTTON);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        }
    }

    private void cJp() {
        c cJH = this.kal.cJH();
        this.kal.cJF().setDuration(Math.max(cJH.cIV().size() * 50, 2000));
        this.kal.cJF().setSigning(0);
        this.kan.d(cJH);
        this.kan.LoadData();
        this.kal.cJI().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.kal.cJI().getItemViewType(i) == 0 && this.kal.cJH() != null && this.kal.cJH().cIS() != null && this.kal.cJH().cIS().size() > i && (dVar = this.kal.cJH().cIS().get(i)) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum").setCallFrom(6)));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IJ(String str) {
        this.FR = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).sR(str).a(R.string.signallforum_signnow, new a.b() { // from class: com.baidu.tieba.signall.SignAllForumActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.FR.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.kan != null && this.kan.isRunning) {
            cJq();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.isDestory = true;
        if (this.FR != null && this.FR.isShowing()) {
            this.FR.dismiss();
        }
        if (this.kam != null) {
            this.kam.cancelLoadData();
            this.kam = null;
        }
        if (this.kal != null && this.kal.cJI() != null) {
            this.kal.cJI().cJr();
        }
        if (this.kan != null) {
            if (this.kan.isRunning) {
                cJq();
            }
            this.kan.cancelMessage();
            this.kan = null;
        }
        if (this.kam != null) {
            this.kam.cancelLoadData();
            this.kam = null;
        }
    }

    private void cJq() {
        this.kao = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(R.string.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public p onGetPreLoadListView() {
        if (this.kal == null || this.kal.cJG() == null) {
            return null;
        }
        return this.kal.cJG().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SIGN_ALL_NEW;
    }
}
