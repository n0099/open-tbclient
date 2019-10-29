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
    private com.baidu.tbadk.core.dialog.a Do;
    private boolean isDestory;
    private j jak;
    private GetForumListModel jal;
    private SignAllForumModel jam;
    private boolean jan;
    private boolean jao = false;
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.jak.cmq().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener jap = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c cms;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (cms = SignAllForumActivity.this.jak.cms()) != null) {
                cms.a((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.jak.cmt().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a jaq = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            SignAllForumActivity.this.jak.completeRefresh();
            a clE = cVar.clE();
            if (clE != null && clE.getErrorNumber() == 0) {
                SignAllForumActivity.this.jak.a(cVar, SignAllForumActivity.this.jal.clX());
                return;
            }
            SignAllForumActivity.this.showToast(clE.getUserMsg(), false);
            SignAllForumActivity.this.finish();
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void xR(String str) {
            SignAllForumActivity.this.jak.completeRefresh();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a jar = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void xR(String str) {
            SignAllForumActivity.this.Dx(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            if (hVar != null && hVar.getErrorCode() == 3250013 && SignAllForumActivity.this.jao) {
                SignAllForumActivity.this.jao = false;
                BdToast.a(TbadkCoreApplication.getInst().getContext(), hVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake_n_svg, 3000, true).akT();
                if (SignAllForumActivity.this.jak != null && SignAllForumActivity.this.jak.cmq() != null) {
                    SignAllForumActivity.this.jak.cmq().setSignBefore(0);
                    return;
                }
                return;
            }
            a clE = hVar.clE();
            if (clE == null || clE.getErrorNumber() != 0) {
                SignAllForumActivity.this.Dx(clE.getUserMsg());
                return;
            }
            c cms = SignAllForumActivity.this.jak.cms();
            cms.a(hVar);
            if (SignAllForumActivity.this.jan) {
                Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{Integer.valueOf(cms.clL()), Integer.valueOf(cms.clM())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                if (SignAllForumActivity.this.isDestory) {
                    return;
                }
            }
            SignAllForumActivity.this.jak.cmt().notifyDataSetChanged();
            SignAllForumProgressView cmq = SignAllForumActivity.this.jak.cmq();
            if (!cms.clK()) {
                if (hVar.cme() != 0) {
                    SignAllForumActivity.this.Dy(hVar.clC());
                    SignAllForumActivity.this.Do.akO();
                } else if (hVar.cmg() != 0) {
                    SignAllForumActivity.this.showToast(hVar.cmh());
                } else {
                    SignAllForumActivity.this.showToast(R.string.signallforum_error);
                }
            }
            if (SignAllForumActivity.this.Do == null || !SignAllForumActivity.this.Do.isShowing()) {
                SignAllForumActivity.this.clZ();
            }
            cmq.setSignSuccess();
            SignAllForumActivity.this.b(cms);
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
    public void clZ() {
        if (this.jak != null) {
            com.baidu.tbadk.coreExtra.messageCenter.f.arv().a(getPageContext(), this.jak.aYd());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String clt = cVar.clt();
            final String axs = cVar.axs();
            final boolean clH = cVar.clH();
            if (cVar.cls()) {
                this.jak.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), clt, axs, Boolean.valueOf(clH))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dx(String str) {
        if (this.jan) {
            c cms = this.jak.cms();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{0, Integer.valueOf(cms.clG().size())});
            a(str, activity, false);
            if (this.isDestory) {
                return;
            }
        }
        showToast(str);
        this.jak.cmq().setSignSuccess();
        ArrayList<d> clG = this.jak.cms().clG();
        int size = clG.size();
        for (int i = 0; i < size; i++) {
            d dVar = clG.get(i);
            dVar.qC(true);
            dVar.qD(false);
            dVar.qB(false);
        }
        this.jak.cmt().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress, getPageContext().getString(R.string.app_name), str, str, pendingIntent, z);
    }

    private void aqx() {
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
        aqx();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.jap);
        initData();
        initUI();
    }

    private void initUI() {
        this.jak = new j(this);
        this.jak.setListPullRefreshListener(this);
        this.jak.setOnItemClickListener(this);
        if (this.jam.isRunning) {
            this.jaq.a(this.jam.cmk());
            this.jak.cmq().setSigning(90);
            return;
        }
        this.jak.startPullRefresh();
    }

    private void initData() {
        this.jal = new GetForumListModel(this);
        this.jal.a(this.jaq);
        this.jam = new SignAllForumModel(this);
        this.jam.a(this.jar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jak.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void onListPullRefresh(boolean z) {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            this.jak.completeRefresh();
        } else if (this.jal == null) {
            showToast(R.string.neterror);
        } else if (!this.jal.LoadData()) {
            this.jak.completeRefresh();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c cms = this.jak.cms();
        if (view == this.jak.getProgressBar()) {
            if (cms != null) {
                if (cms.getBlockPopInfoData() != null) {
                    if (cms.getBlockPopInfoData().appeal_status == 1) {
                        BdToast.a(getPageContext().getPageActivity(), cms.getBlockPopInfoData().appeal_msg, R.drawable.icon_pure_toast_mistake_n_svg, 3000, true).akT();
                    } else if (AntiHelper.a(getPageContext().getPageActivity(), cms.getBlockPopInfoData(), this.mInjectListener) != null) {
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).O("obj_locate", at.a.LOCATE_SIGN));
                    }
                } else if (this.jak.cmq().getCurrentStatus() == 2) {
                    showToast(R.string.signallforum_finished);
                } else {
                    if (cms.clB() != 0) {
                        Dy(cms.clC());
                        this.Do.akO();
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.jao = true;
                        cma();
                    } else {
                        showToast(R.string.neterror);
                    }
                    TiebaStatic.log("signall_click");
                }
            }
        } else if (view == this.jak.cmu()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_A_KEY_TO_SIGN, MemberPayStatistic.CLICK_ZONE_BOTTOM_OPENDE_RENEWALFEE_BUTTON);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        }
    }

    private void cma() {
        c cms = this.jak.cms();
        this.jak.cmq().setDuration(Math.max(cms.clG().size() * 50, 2000));
        this.jak.cmq().setSigning(0);
        this.jam.d(cms);
        this.jam.LoadData();
        this.jak.cmt().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.jak.cmt().getItemViewType(i) == 0 && this.jak.cms() != null && this.jak.cms().clD() != null && this.jak.cms().clD().size() > i && (dVar = this.jak.cms().clD().get(i)) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum").setCallFrom(6)));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dy(String str) {
        this.Do = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).nn(str).a(R.string.signallforum_signnow, new a.b() { // from class: com.baidu.tieba.signall.SignAllForumActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.Do.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.jam != null && this.jam.isRunning) {
            cmb();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.isDestory = true;
        if (this.Do != null && this.Do.isShowing()) {
            this.Do.dismiss();
        }
        if (this.jal != null) {
            this.jal.cancelLoadData();
            this.jal = null;
        }
        if (this.jak != null && this.jak.cmt() != null) {
            this.jak.cmt().cmc();
        }
        if (this.jam != null) {
            if (this.jam.isRunning) {
                cmb();
            }
            this.jam.cancelMessage();
            this.jam = null;
        }
        if (this.jal != null) {
            this.jal.cancelLoadData();
            this.jal = null;
        }
    }

    private void cmb() {
        this.jan = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(R.string.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public p onGetPreLoadListView() {
        if (this.jak == null || this.jak.cmr() == null) {
            return null;
        }
        return this.jak.cmr().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SIGN_ALL_NEW;
    }
}
