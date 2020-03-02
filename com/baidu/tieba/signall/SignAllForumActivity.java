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
    private boolean jYA;
    private j jYx;
    private GetForumListModel jYy;
    private SignAllForumModel jYz;
    private boolean jYB = false;
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.jYx.cJk().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener jYC = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c cJm;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (cJm = SignAllForumActivity.this.jYx.cJm()) != null) {
                cJm.b((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.jYx.cJn().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a jYD = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            SignAllForumActivity.this.jYx.completeRefresh();
            a cIy = cVar.cIy();
            if (cIy != null && cIy.getErrorNumber() == 0) {
                SignAllForumActivity.this.jYx.a(cVar, SignAllForumActivity.this.jYy.cIR());
                return;
            }
            SignAllForumActivity.this.showToast(cIy.getUserMsg(), false);
            SignAllForumActivity.this.finish();
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void Da(String str) {
            SignAllForumActivity.this.jYx.completeRefresh();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a jYE = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void Da(String str) {
            SignAllForumActivity.this.II(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            if (hVar != null && hVar.getErrorCode() == 3250013 && SignAllForumActivity.this.jYB) {
                SignAllForumActivity.this.jYB = false;
                BdToast.a(TbadkCoreApplication.getInst().getContext(), hVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aEH();
                if (SignAllForumActivity.this.jYx != null && SignAllForumActivity.this.jYx.cJk() != null) {
                    SignAllForumActivity.this.jYx.cJk().setSignBefore(0);
                    return;
                }
                return;
            }
            a cIy = hVar.cIy();
            if (cIy == null || cIy.getErrorNumber() != 0) {
                SignAllForumActivity.this.II(cIy.getUserMsg());
                return;
            }
            c cJm = SignAllForumActivity.this.jYx.cJm();
            cJm.a(hVar);
            if (SignAllForumActivity.this.jYA) {
                Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{Integer.valueOf(cJm.cIF()), Integer.valueOf(cJm.cIG())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                if (SignAllForumActivity.this.isDestory) {
                    return;
                }
            }
            SignAllForumActivity.this.jYx.cJn().notifyDataSetChanged();
            SignAllForumProgressView cJk = SignAllForumActivity.this.jYx.cJk();
            if (!cJm.cIE()) {
                if (hVar.cIY() != 0) {
                    SignAllForumActivity.this.IJ(hVar.cIw());
                    SignAllForumActivity.this.FR.aEC();
                } else if (hVar.cJa() != 0) {
                    SignAllForumActivity.this.showToast(hVar.cJb());
                } else {
                    SignAllForumActivity.this.showToast(R.string.signallforum_error);
                }
            }
            if (SignAllForumActivity.this.FR == null || !SignAllForumActivity.this.FR.isShowing()) {
                SignAllForumActivity.this.cIT();
            }
            cJk.setSignSuccess();
            SignAllForumActivity.this.b(cJm);
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
    public void cIT() {
        if (this.jYx != null) {
            com.baidu.tbadk.coreExtra.messageCenter.f.aLG().a(getPageContext(), this.jYx.bsE());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String cIn = cVar.cIn();
            final String aRP = cVar.aRP();
            final boolean cIB = cVar.cIB();
            if (cVar.cIm()) {
                this.jYx.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), cIn, aRP, Boolean.valueOf(cIB))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void II(String str) {
        if (this.jYA) {
            c cJm = this.jYx.cJm();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{0, Integer.valueOf(cJm.cIA().size())});
            a(str, activity, false);
            if (this.isDestory) {
                return;
            }
        }
        showToast(str);
        this.jYx.cJk().setSignSuccess();
        ArrayList<d> cIA = this.jYx.cJm().cIA();
        int size = cIA.size();
        for (int i = 0; i < size; i++) {
            d dVar = cIA.get(i);
            dVar.sA(true);
            dVar.sB(false);
            dVar.sz(false);
        }
        this.jYx.cJn().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress, getPageContext().getString(R.string.app_name), str, str, pendingIntent, z);
    }

    private void aKI() {
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
        aKI();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.jYC);
        initData();
        initUI();
    }

    private void initUI() {
        this.jYx = new j(this);
        this.jYx.setListPullRefreshListener(this);
        this.jYx.setOnItemClickListener(this);
        if (this.jYz.isRunning) {
            this.jYD.a(this.jYz.cJe());
            this.jYx.cJk().setSigning(90);
            return;
        }
        this.jYx.startPullRefresh();
    }

    private void initData() {
        this.jYy = new GetForumListModel(this);
        this.jYy.a(this.jYD);
        this.jYz = new SignAllForumModel(this);
        this.jYz.a(this.jYE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jYx.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            this.jYx.completeRefresh();
        } else if (this.jYy == null) {
            showToast(R.string.neterror);
        } else if (!this.jYy.LoadData()) {
            this.jYx.completeRefresh();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c cJm = this.jYx.cJm();
        if (view == this.jYx.getProgressBar()) {
            if (cJm != null) {
                if (cJm.getBlockPopInfoData() != null) {
                    if (cJm.getBlockPopInfoData().appeal_status == 1) {
                        BdToast.a(getPageContext().getPageActivity(), cJm.getBlockPopInfoData().appeal_msg, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aEH();
                    } else if (AntiHelper.a(getPageContext().getPageActivity(), cJm.getBlockPopInfoData(), this.mInjectListener) != null) {
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).X("obj_locate", at.a.LOCATE_SIGN));
                    }
                } else if (this.jYx.cJk().getCurrentStatus() == 2) {
                    showToast(R.string.signallforum_finished);
                } else {
                    if (cJm.cIv() != 0) {
                        IJ(cJm.cIw());
                        this.FR.aEC();
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.jYB = true;
                        cIU();
                    } else {
                        showToast(R.string.neterror);
                    }
                    TiebaStatic.log("signall_click");
                }
            }
        } else if (view == this.jYx.cJo()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_A_KEY_TO_SIGN, MemberPayStatistic.CLICK_ZONE_BOTTOM_OPENDE_RENEWALFEE_BUTTON);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        }
    }

    private void cIU() {
        c cJm = this.jYx.cJm();
        this.jYx.cJk().setDuration(Math.max(cJm.cIA().size() * 50, 2000));
        this.jYx.cJk().setSigning(0);
        this.jYz.d(cJm);
        this.jYz.LoadData();
        this.jYx.cJn().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.jYx.cJn().getItemViewType(i) == 0 && this.jYx.cJm() != null && this.jYx.cJm().cIx() != null && this.jYx.cJm().cIx().size() > i && (dVar = this.jYx.cJm().cIx().get(i)) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum").setCallFrom(6)));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IJ(String str) {
        this.FR = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).sS(str).a(R.string.signallforum_signnow, new a.b() { // from class: com.baidu.tieba.signall.SignAllForumActivity.7
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
        if (this.jYz != null && this.jYz.isRunning) {
            cIV();
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
        if (this.jYy != null) {
            this.jYy.cancelLoadData();
            this.jYy = null;
        }
        if (this.jYx != null && this.jYx.cJn() != null) {
            this.jYx.cJn().cIW();
        }
        if (this.jYz != null) {
            if (this.jYz.isRunning) {
                cIV();
            }
            this.jYz.cancelMessage();
            this.jYz = null;
        }
        if (this.jYy != null) {
            this.jYy.cancelLoadData();
            this.jYy = null;
        }
    }

    private void cIV() {
        this.jYA = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(R.string.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public p onGetPreLoadListView() {
        if (this.jYx == null || this.jYx.cJl() == null) {
            return null;
        }
        return this.jYx.cJl().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SIGN_ALL_NEW;
    }
}
