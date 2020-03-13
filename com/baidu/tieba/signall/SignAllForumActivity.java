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
    private j jYJ;
    private GetForumListModel jYK;
    private SignAllForumModel jYL;
    private boolean jYM;
    private boolean jYN = false;
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.jYJ.cJl().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener jYO = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c cJn;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (cJn = SignAllForumActivity.this.jYJ.cJn()) != null) {
                cJn.b((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.jYJ.cJo().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a jYP = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            SignAllForumActivity.this.jYJ.completeRefresh();
            a cIz = cVar.cIz();
            if (cIz != null && cIz.getErrorNumber() == 0) {
                SignAllForumActivity.this.jYJ.a(cVar, SignAllForumActivity.this.jYK.cIS());
                return;
            }
            SignAllForumActivity.this.showToast(cIz.getUserMsg(), false);
            SignAllForumActivity.this.finish();
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void Db(String str) {
            SignAllForumActivity.this.jYJ.completeRefresh();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a jYQ = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void Db(String str) {
            SignAllForumActivity.this.IJ(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            if (hVar != null && hVar.getErrorCode() == 3250013 && SignAllForumActivity.this.jYN) {
                SignAllForumActivity.this.jYN = false;
                BdToast.a(TbadkCoreApplication.getInst().getContext(), hVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aEH();
                if (SignAllForumActivity.this.jYJ != null && SignAllForumActivity.this.jYJ.cJl() != null) {
                    SignAllForumActivity.this.jYJ.cJl().setSignBefore(0);
                    return;
                }
                return;
            }
            a cIz = hVar.cIz();
            if (cIz == null || cIz.getErrorNumber() != 0) {
                SignAllForumActivity.this.IJ(cIz.getUserMsg());
                return;
            }
            c cJn = SignAllForumActivity.this.jYJ.cJn();
            cJn.a(hVar);
            if (SignAllForumActivity.this.jYM) {
                Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{Integer.valueOf(cJn.cIG()), Integer.valueOf(cJn.cIH())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                if (SignAllForumActivity.this.isDestory) {
                    return;
                }
            }
            SignAllForumActivity.this.jYJ.cJo().notifyDataSetChanged();
            SignAllForumProgressView cJl = SignAllForumActivity.this.jYJ.cJl();
            if (!cJn.cIF()) {
                if (hVar.cIZ() != 0) {
                    SignAllForumActivity.this.IK(hVar.cIx());
                    SignAllForumActivity.this.FR.aEC();
                } else if (hVar.cJb() != 0) {
                    SignAllForumActivity.this.showToast(hVar.cJc());
                } else {
                    SignAllForumActivity.this.showToast(R.string.signallforum_error);
                }
            }
            if (SignAllForumActivity.this.FR == null || !SignAllForumActivity.this.FR.isShowing()) {
                SignAllForumActivity.this.cIU();
            }
            cJl.setSignSuccess();
            SignAllForumActivity.this.b(cJn);
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
    public void cIU() {
        if (this.jYJ != null) {
            com.baidu.tbadk.coreExtra.messageCenter.f.aLH().a(getPageContext(), this.jYJ.bsF());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String cIo = cVar.cIo();
            final String aRQ = cVar.aRQ();
            final boolean cIC = cVar.cIC();
            if (cVar.cIn()) {
                this.jYJ.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), cIo, aRQ, Boolean.valueOf(cIC))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IJ(String str) {
        if (this.jYM) {
            c cJn = this.jYJ.cJn();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{0, Integer.valueOf(cJn.cIB().size())});
            a(str, activity, false);
            if (this.isDestory) {
                return;
            }
        }
        showToast(str);
        this.jYJ.cJl().setSignSuccess();
        ArrayList<d> cIB = this.jYJ.cJn().cIB();
        int size = cIB.size();
        for (int i = 0; i < size; i++) {
            d dVar = cIB.get(i);
            dVar.sA(true);
            dVar.sB(false);
            dVar.sz(false);
        }
        this.jYJ.cJo().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress, getPageContext().getString(R.string.app_name), str, str, pendingIntent, z);
    }

    private void aKJ() {
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
        aKJ();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.jYO);
        initData();
        initUI();
    }

    private void initUI() {
        this.jYJ = new j(this);
        this.jYJ.setListPullRefreshListener(this);
        this.jYJ.setOnItemClickListener(this);
        if (this.jYL.isRunning) {
            this.jYP.a(this.jYL.cJf());
            this.jYJ.cJl().setSigning(90);
            return;
        }
        this.jYJ.startPullRefresh();
    }

    private void initData() {
        this.jYK = new GetForumListModel(this);
        this.jYK.a(this.jYP);
        this.jYL = new SignAllForumModel(this);
        this.jYL.a(this.jYQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jYJ.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            this.jYJ.completeRefresh();
        } else if (this.jYK == null) {
            showToast(R.string.neterror);
        } else if (!this.jYK.LoadData()) {
            this.jYJ.completeRefresh();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c cJn = this.jYJ.cJn();
        if (view == this.jYJ.getProgressBar()) {
            if (cJn != null) {
                if (cJn.getBlockPopInfoData() != null) {
                    if (cJn.getBlockPopInfoData().appeal_status == 1) {
                        BdToast.a(getPageContext().getPageActivity(), cJn.getBlockPopInfoData().appeal_msg, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aEH();
                    } else if (AntiHelper.a(getPageContext().getPageActivity(), cJn.getBlockPopInfoData(), this.mInjectListener) != null) {
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).X("obj_locate", at.a.LOCATE_SIGN));
                    }
                } else if (this.jYJ.cJl().getCurrentStatus() == 2) {
                    showToast(R.string.signallforum_finished);
                } else {
                    if (cJn.cIw() != 0) {
                        IK(cJn.cIx());
                        this.FR.aEC();
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.jYN = true;
                        cIV();
                    } else {
                        showToast(R.string.neterror);
                    }
                    TiebaStatic.log("signall_click");
                }
            }
        } else if (view == this.jYJ.cJp()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_A_KEY_TO_SIGN, MemberPayStatistic.CLICK_ZONE_BOTTOM_OPENDE_RENEWALFEE_BUTTON);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        }
    }

    private void cIV() {
        c cJn = this.jYJ.cJn();
        this.jYJ.cJl().setDuration(Math.max(cJn.cIB().size() * 50, 2000));
        this.jYJ.cJl().setSigning(0);
        this.jYL.d(cJn);
        this.jYL.LoadData();
        this.jYJ.cJo().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.jYJ.cJo().getItemViewType(i) == 0 && this.jYJ.cJn() != null && this.jYJ.cJn().cIy() != null && this.jYJ.cJn().cIy().size() > i && (dVar = this.jYJ.cJn().cIy().get(i)) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum").setCallFrom(6)));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IK(String str) {
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
        if (this.jYL != null && this.jYL.isRunning) {
            cIW();
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
        if (this.jYK != null) {
            this.jYK.cancelLoadData();
            this.jYK = null;
        }
        if (this.jYJ != null && this.jYJ.cJo() != null) {
            this.jYJ.cJo().cIX();
        }
        if (this.jYL != null) {
            if (this.jYL.isRunning) {
                cIW();
            }
            this.jYL.cancelMessage();
            this.jYL = null;
        }
        if (this.jYK != null) {
            this.jYK.cancelLoadData();
            this.jYK = null;
        }
    }

    private void cIW() {
        this.jYM = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(R.string.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public p onGetPreLoadListView() {
        if (this.jYJ == null || this.jYJ.cJm() == null) {
            return null;
        }
        return this.jYJ.cJm().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SIGN_ALL_NEW;
    }
}
