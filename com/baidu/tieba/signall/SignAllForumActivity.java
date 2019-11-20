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
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import com.baidu.tieba.signall.GetForumListModel;
import com.baidu.tieba.signall.SignAllForumModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements h.c {
    private com.baidu.tbadk.core.dialog.a CM;
    private j iZt;
    private GetForumListModel iZu;
    private SignAllForumModel iZv;
    private boolean iZw;
    private boolean isDestory;
    private boolean iZx = false;
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.iZt.cmo().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener iZy = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c cmq;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (cmq = SignAllForumActivity.this.iZt.cmq()) != null) {
                cmq.a((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.iZt.cmr().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a iZz = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            SignAllForumActivity.this.iZt.completeRefresh();
            a clC = cVar.clC();
            if (clC != null && clC.getErrorNumber() == 0) {
                SignAllForumActivity.this.iZt.a(cVar, SignAllForumActivity.this.iZu.clV());
                return;
            }
            SignAllForumActivity.this.showToast(clC.getUserMsg(), false);
            SignAllForumActivity.this.finish();
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void xR(String str) {
            SignAllForumActivity.this.iZt.completeRefresh();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a iZA = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void xR(String str) {
            SignAllForumActivity.this.Dx(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            if (hVar != null && hVar.getErrorCode() == 3250013 && SignAllForumActivity.this.iZx) {
                SignAllForumActivity.this.iZx = false;
                BdToast.a(TbadkCoreApplication.getInst().getContext(), hVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake_n_svg, 3000, true).akR();
                if (SignAllForumActivity.this.iZt != null && SignAllForumActivity.this.iZt.cmo() != null) {
                    SignAllForumActivity.this.iZt.cmo().setSignBefore(0);
                    return;
                }
                return;
            }
            a clC = hVar.clC();
            if (clC == null || clC.getErrorNumber() != 0) {
                SignAllForumActivity.this.Dx(clC.getUserMsg());
                return;
            }
            c cmq = SignAllForumActivity.this.iZt.cmq();
            cmq.a(hVar);
            if (SignAllForumActivity.this.iZw) {
                Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{Integer.valueOf(cmq.clJ()), Integer.valueOf(cmq.clK())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                if (SignAllForumActivity.this.isDestory) {
                    return;
                }
            }
            SignAllForumActivity.this.iZt.cmr().notifyDataSetChanged();
            SignAllForumProgressView cmo = SignAllForumActivity.this.iZt.cmo();
            if (!cmq.clI()) {
                if (hVar.cmc() != 0) {
                    SignAllForumActivity.this.Dy(hVar.clA());
                    SignAllForumActivity.this.CM.akM();
                } else if (hVar.cme() != 0) {
                    SignAllForumActivity.this.showToast(hVar.cmf());
                } else {
                    SignAllForumActivity.this.showToast(R.string.signallforum_error);
                }
            }
            if (SignAllForumActivity.this.CM == null || !SignAllForumActivity.this.CM.isShowing()) {
                SignAllForumActivity.this.clX();
            }
            cmo.setSignSuccess();
            SignAllForumActivity.this.b(cmq);
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).O("obj_locate", at.a.LOCATE_SIGN));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).O("obj_locate", at.a.LOCATE_SIGN));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void clX() {
        if (this.iZt != null) {
            com.baidu.tbadk.coreExtra.messageCenter.f.art().a(getPageContext(), this.iZt.aYb());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String clr = cVar.clr();
            final String axq = cVar.axq();
            final boolean clF = cVar.clF();
            if (cVar.clq()) {
                this.iZt.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), clr, axq, Boolean.valueOf(clF))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dx(String str) {
        if (this.iZw) {
            c cmq = this.iZt.cmq();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{0, Integer.valueOf(cmq.clE().size())});
            a(str, activity, false);
            if (this.isDestory) {
                return;
            }
        }
        showToast(str);
        this.iZt.cmo().setSignSuccess();
        ArrayList<d> clE = this.iZt.cmq().clE();
        int size = clE.size();
        for (int i = 0; i < size; i++) {
            d dVar = clE.get(i);
            dVar.qC(true);
            dVar.qD(false);
            dVar.qB(false);
        }
        this.iZt.cmr().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress, getPageContext().getString(R.string.app_name), str, str, pendingIntent, z);
    }

    private void aqv() {
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
        aqv();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.iZy);
        initData();
        initUI();
    }

    private void initUI() {
        this.iZt = new j(this);
        this.iZt.setListPullRefreshListener(this);
        this.iZt.setOnItemClickListener(this);
        if (this.iZv.isRunning) {
            this.iZz.a(this.iZv.cmi());
            this.iZt.cmo().setSigning(90);
            return;
        }
        this.iZt.startPullRefresh();
    }

    private void initData() {
        this.iZu = new GetForumListModel(this);
        this.iZu.a(this.iZz);
        this.iZv = new SignAllForumModel(this);
        this.iZv.a(this.iZA);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iZt.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void onListPullRefresh(boolean z) {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            this.iZt.completeRefresh();
        } else if (this.iZu == null) {
            showToast(R.string.neterror);
        } else if (!this.iZu.LoadData()) {
            this.iZt.completeRefresh();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c cmq = this.iZt.cmq();
        if (view == this.iZt.getProgressBar()) {
            if (cmq != null) {
                if (cmq.getBlockPopInfoData() != null) {
                    if (cmq.getBlockPopInfoData().appeal_status == 1) {
                        BdToast.a(getPageContext().getPageActivity(), cmq.getBlockPopInfoData().appeal_msg, R.drawable.icon_pure_toast_mistake_n_svg, 3000, true).akR();
                    } else if (AntiHelper.a(getPageContext().getPageActivity(), cmq.getBlockPopInfoData(), this.mInjectListener) != null) {
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).O("obj_locate", at.a.LOCATE_SIGN));
                    }
                } else if (this.iZt.cmo().getCurrentStatus() == 2) {
                    showToast(R.string.signallforum_finished);
                } else {
                    if (cmq.clz() != 0) {
                        Dy(cmq.clA());
                        this.CM.akM();
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.iZx = true;
                        clY();
                    } else {
                        showToast(R.string.neterror);
                    }
                    TiebaStatic.log("signall_click");
                }
            }
        } else if (view == this.iZt.cms()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_A_KEY_TO_SIGN, MemberPayStatistic.CLICK_ZONE_BOTTOM_OPENDE_RENEWALFEE_BUTTON);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        }
    }

    private void clY() {
        c cmq = this.iZt.cmq();
        this.iZt.cmo().setDuration(Math.max(cmq.clE().size() * 50, 2000));
        this.iZt.cmo().setSigning(0);
        this.iZv.d(cmq);
        this.iZv.LoadData();
        this.iZt.cmr().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.iZt.cmr().getItemViewType(i) == 0 && this.iZt.cmq() != null && this.iZt.cmq().clB() != null && this.iZt.cmq().clB().size() > i && (dVar = this.iZt.cmq().clB().get(i)) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum").setCallFrom(6)));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dy(String str) {
        this.CM = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).nn(str).a(R.string.signallforum_signnow, new a.b() { // from class: com.baidu.tieba.signall.SignAllForumActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.CM.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.iZv != null && this.iZv.isRunning) {
            clZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.isDestory = true;
        if (this.CM != null && this.CM.isShowing()) {
            this.CM.dismiss();
        }
        if (this.iZu != null) {
            this.iZu.cancelLoadData();
            this.iZu = null;
        }
        if (this.iZt != null && this.iZt.cmr() != null) {
            this.iZt.cmr().cma();
        }
        if (this.iZv != null) {
            if (this.iZv.isRunning) {
                clZ();
            }
            this.iZv.cancelMessage();
            this.iZv = null;
        }
        if (this.iZu != null) {
            this.iZu.cancelLoadData();
            this.iZu = null;
        }
    }

    private void clZ() {
        this.iZw = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(R.string.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public p onGetPreLoadListView() {
        if (this.iZt == null || this.iZt.cmp() == null) {
            return null;
        }
        return this.iZt.cmp().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SIGN_ALL_NEW;
    }
}
