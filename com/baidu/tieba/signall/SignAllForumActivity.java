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
    private j jYv;
    private GetForumListModel jYw;
    private SignAllForumModel jYx;
    private boolean jYy;
    private boolean jYz = false;
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.jYv.cJi().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener jYA = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c cJk;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (cJk = SignAllForumActivity.this.jYv.cJk()) != null) {
                cJk.b((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.jYv.cJl().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a jYB = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            SignAllForumActivity.this.jYv.completeRefresh();
            a cIw = cVar.cIw();
            if (cIw != null && cIw.getErrorNumber() == 0) {
                SignAllForumActivity.this.jYv.a(cVar, SignAllForumActivity.this.jYw.cIP());
                return;
            }
            SignAllForumActivity.this.showToast(cIw.getUserMsg(), false);
            SignAllForumActivity.this.finish();
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void Da(String str) {
            SignAllForumActivity.this.jYv.completeRefresh();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a jYC = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void Da(String str) {
            SignAllForumActivity.this.II(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            if (hVar != null && hVar.getErrorCode() == 3250013 && SignAllForumActivity.this.jYz) {
                SignAllForumActivity.this.jYz = false;
                BdToast.a(TbadkCoreApplication.getInst().getContext(), hVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aEF();
                if (SignAllForumActivity.this.jYv != null && SignAllForumActivity.this.jYv.cJi() != null) {
                    SignAllForumActivity.this.jYv.cJi().setSignBefore(0);
                    return;
                }
                return;
            }
            a cIw = hVar.cIw();
            if (cIw == null || cIw.getErrorNumber() != 0) {
                SignAllForumActivity.this.II(cIw.getUserMsg());
                return;
            }
            c cJk = SignAllForumActivity.this.jYv.cJk();
            cJk.a(hVar);
            if (SignAllForumActivity.this.jYy) {
                Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{Integer.valueOf(cJk.cID()), Integer.valueOf(cJk.cIE())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                if (SignAllForumActivity.this.isDestory) {
                    return;
                }
            }
            SignAllForumActivity.this.jYv.cJl().notifyDataSetChanged();
            SignAllForumProgressView cJi = SignAllForumActivity.this.jYv.cJi();
            if (!cJk.cIC()) {
                if (hVar.cIW() != 0) {
                    SignAllForumActivity.this.IJ(hVar.cIu());
                    SignAllForumActivity.this.FR.aEA();
                } else if (hVar.cIY() != 0) {
                    SignAllForumActivity.this.showToast(hVar.cIZ());
                } else {
                    SignAllForumActivity.this.showToast(R.string.signallforum_error);
                }
            }
            if (SignAllForumActivity.this.FR == null || !SignAllForumActivity.this.FR.isShowing()) {
                SignAllForumActivity.this.cIR();
            }
            cJi.setSignSuccess();
            SignAllForumActivity.this.b(cJk);
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
    public void cIR() {
        if (this.jYv != null) {
            com.baidu.tbadk.coreExtra.messageCenter.f.aLE().a(getPageContext(), this.jYv.bsC());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String cIl = cVar.cIl();
            final String aRN = cVar.aRN();
            final boolean cIz = cVar.cIz();
            if (cVar.cIk()) {
                this.jYv.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), cIl, aRN, Boolean.valueOf(cIz))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void II(String str) {
        if (this.jYy) {
            c cJk = this.jYv.cJk();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{0, Integer.valueOf(cJk.cIy().size())});
            a(str, activity, false);
            if (this.isDestory) {
                return;
            }
        }
        showToast(str);
        this.jYv.cJi().setSignSuccess();
        ArrayList<d> cIy = this.jYv.cJk().cIy();
        int size = cIy.size();
        for (int i = 0; i < size; i++) {
            d dVar = cIy.get(i);
            dVar.sA(true);
            dVar.sB(false);
            dVar.sz(false);
        }
        this.jYv.cJl().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress, getPageContext().getString(R.string.app_name), str, str, pendingIntent, z);
    }

    private void aKG() {
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
        aKG();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.jYA);
        initData();
        initUI();
    }

    private void initUI() {
        this.jYv = new j(this);
        this.jYv.setListPullRefreshListener(this);
        this.jYv.setOnItemClickListener(this);
        if (this.jYx.isRunning) {
            this.jYB.a(this.jYx.cJc());
            this.jYv.cJi().setSigning(90);
            return;
        }
        this.jYv.startPullRefresh();
    }

    private void initData() {
        this.jYw = new GetForumListModel(this);
        this.jYw.a(this.jYB);
        this.jYx = new SignAllForumModel(this);
        this.jYx.a(this.jYC);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jYv.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            this.jYv.completeRefresh();
        } else if (this.jYw == null) {
            showToast(R.string.neterror);
        } else if (!this.jYw.LoadData()) {
            this.jYv.completeRefresh();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c cJk = this.jYv.cJk();
        if (view == this.jYv.getProgressBar()) {
            if (cJk != null) {
                if (cJk.getBlockPopInfoData() != null) {
                    if (cJk.getBlockPopInfoData().appeal_status == 1) {
                        BdToast.a(getPageContext().getPageActivity(), cJk.getBlockPopInfoData().appeal_msg, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aEF();
                    } else if (AntiHelper.a(getPageContext().getPageActivity(), cJk.getBlockPopInfoData(), this.mInjectListener) != null) {
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).X("obj_locate", at.a.LOCATE_SIGN));
                    }
                } else if (this.jYv.cJi().getCurrentStatus() == 2) {
                    showToast(R.string.signallforum_finished);
                } else {
                    if (cJk.cIt() != 0) {
                        IJ(cJk.cIu());
                        this.FR.aEA();
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.jYz = true;
                        cIS();
                    } else {
                        showToast(R.string.neterror);
                    }
                    TiebaStatic.log("signall_click");
                }
            }
        } else if (view == this.jYv.cJm()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_A_KEY_TO_SIGN, MemberPayStatistic.CLICK_ZONE_BOTTOM_OPENDE_RENEWALFEE_BUTTON);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        }
    }

    private void cIS() {
        c cJk = this.jYv.cJk();
        this.jYv.cJi().setDuration(Math.max(cJk.cIy().size() * 50, 2000));
        this.jYv.cJi().setSigning(0);
        this.jYx.d(cJk);
        this.jYx.LoadData();
        this.jYv.cJl().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.jYv.cJl().getItemViewType(i) == 0 && this.jYv.cJk() != null && this.jYv.cJk().cIv() != null && this.jYv.cJk().cIv().size() > i && (dVar = this.jYv.cJk().cIv().get(i)) != null) {
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
        if (this.jYx != null && this.jYx.isRunning) {
            cIT();
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
        if (this.jYw != null) {
            this.jYw.cancelLoadData();
            this.jYw = null;
        }
        if (this.jYv != null && this.jYv.cJl() != null) {
            this.jYv.cJl().cIU();
        }
        if (this.jYx != null) {
            if (this.jYx.isRunning) {
                cIT();
            }
            this.jYx.cancelMessage();
            this.jYx = null;
        }
        if (this.jYw != null) {
            this.jYw.cancelLoadData();
            this.jYw = null;
        }
    }

    private void cIT() {
        this.jYy = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(R.string.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public p onGetPreLoadListView() {
        if (this.jYv == null || this.jYv.cJj() == null) {
            return null;
        }
        return this.jYv.cJj().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SIGN_ALL_NEW;
    }
}
