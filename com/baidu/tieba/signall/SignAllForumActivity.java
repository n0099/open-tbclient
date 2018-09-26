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
    private com.baidu.tbadk.core.dialog.a SK;
    private j gMp;
    private GetForumListModel gMq;
    private SignAllForumModel gMr;
    private boolean gMs;
    private boolean isDestory;
    private boolean gMt = false;
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.gMp.bvH().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener gMu = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c bvJ;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (bvJ = SignAllForumActivity.this.gMp.bvJ()) != null) {
                bvJ.a((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.gMp.bvK().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a gMv = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            SignAllForumActivity.this.gMp.pb();
            a buU = cVar.buU();
            if (buU != null && buU.getErrorNumber() == 0) {
                SignAllForumActivity.this.gMp.a(cVar, SignAllForumActivity.this.gMq.bvn());
                return;
            }
            SignAllForumActivity.this.showToast(buU.getUserMsg(), false);
            SignAllForumActivity.this.finish();
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void oW(String str) {
            SignAllForumActivity.this.gMp.pb();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a gMw = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void oW(String str) {
            SignAllForumActivity.this.ub(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            if (hVar != null && hVar.getErrorCode() == 3250013 && SignAllForumActivity.this.gMt) {
                SignAllForumActivity.this.gMt = false;
                BdToast.a(TbadkCoreApplication.getInst().getContext(), hVar.getErrorMsg(), e.f.icon_toast_game_error, 3000).yt();
                if (SignAllForumActivity.this.gMp != null && SignAllForumActivity.this.gMp.bvH() != null) {
                    SignAllForumActivity.this.gMp.bvH().setSignBefore(0);
                    return;
                }
                return;
            }
            a buU = hVar.buU();
            if (buU == null || buU.getErrorNumber() != 0) {
                SignAllForumActivity.this.ub(buU.getUserMsg());
                return;
            }
            c bvJ = SignAllForumActivity.this.gMp.bvJ();
            bvJ.a(hVar);
            if (SignAllForumActivity.this.gMs) {
                Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(e.j.signallforum_back_finish, new Object[]{Integer.valueOf(bvJ.bvb()), Integer.valueOf(bvJ.bvc())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                if (SignAllForumActivity.this.isDestory) {
                    return;
                }
            }
            SignAllForumActivity.this.gMp.bvK().notifyDataSetChanged();
            SignAllForumProgressView bvH = SignAllForumActivity.this.gMp.bvH();
            if (!bvJ.bva()) {
                if (hVar.bvu() != 0) {
                    SignAllForumActivity.this.uc(hVar.buS());
                    SignAllForumActivity.this.SK.yl();
                } else if (hVar.bvw() != 0) {
                    SignAllForumActivity.this.showToast(hVar.bvx());
                } else {
                    SignAllForumActivity.this.showToast(e.j.signallforum_error);
                }
            }
            if (SignAllForumActivity.this.SK == null || !SignAllForumActivity.this.SK.isShowing()) {
                SignAllForumActivity.this.bvp();
            }
            bvH.setSignSuccess();
            SignAllForumActivity.this.b(bvJ);
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").w("obj_locate", as.a.atQ));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").w("obj_locate", as.a.atQ));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bvp() {
        if (this.gMp != null) {
            com.baidu.tbadk.coreExtra.messageCenter.d.FA().a(getPageContext(), this.gMp.axn());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String buJ = cVar.buJ();
            final String Mx = cVar.Mx();
            final boolean buX = cVar.buX();
            if (cVar.buI()) {
                this.gMp.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage(2002001, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), buJ, Mx, Boolean.valueOf(buX))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ub(String str) {
        if (this.gMs) {
            c bvJ = this.gMp.bvJ();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(e.j.signallforum_back_finish, new Object[]{0, Integer.valueOf(bvJ.buW().size())});
            a(str, activity, false);
            if (this.isDestory) {
                return;
            }
        }
        showToast(str);
        this.gMp.bvH().setSignSuccess();
        ArrayList<d> buW = this.gMp.bvJ().buW();
        int size = buW.size();
        for (int i = 0; i < size; i++) {
            d dVar = buW.get(i);
            dVar.mB(true);
            dVar.mC(false);
            dVar.mA(false);
        }
        this.gMp.bvK().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), e.f.singnallforum_progress, getPageContext().getString(e.j.app_name), str, str, pendingIntent, z);
    }

    private void EC() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), e.f.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!TbadkCoreApplication.isLogin()) {
            ba.bz(getActivity());
            finish();
            return;
        }
        EC();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.gMu);
        initData();
        initUI();
    }

    private void initUI() {
        this.gMp = new j(this);
        this.gMp.a(this);
        this.gMp.setOnItemClickListener(this);
        if (this.gMr.isRunning) {
            this.gMv.a(this.gMr.bvA());
            this.gMp.bvH().setSigning(90);
            return;
        }
        this.gMp.startPullRefresh();
    }

    private void initData() {
        this.gMq = new GetForumListModel(this);
        this.gMq.a(this.gMv);
        this.gMr = new SignAllForumModel(this);
        this.gMr.a(this.gMw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gMp.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bf(boolean z) {
        if (!com.baidu.adp.lib.util.j.kK()) {
            showToast(e.j.neterror);
            this.gMp.pb();
        } else if (this.gMq == null) {
            showToast(e.j.neterror);
        } else if (!this.gMq.LoadData()) {
            this.gMp.pb();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c bvJ = this.gMp.bvJ();
        if (view == this.gMp.getProgressBar()) {
            if (bvJ != null) {
                if (bvJ.getBlockPopInfoData() != null) {
                    if (bvJ.getBlockPopInfoData().appeal_status == 1) {
                        BdToast.a(getPageContext().getPageActivity(), bvJ.getBlockPopInfoData().appeal_msg, e.f.icon_toast_game_error, 3000).yt();
                    } else if (AntiHelper.a(getPageContext().getPageActivity(), bvJ.getBlockPopInfoData(), this.mInjectListener) != null) {
                        TiebaStatic.log(new am("c12534").w("obj_locate", as.a.atQ));
                    }
                } else if (this.gMp.bvH().getCurrentStatus() == 2) {
                    showToast(e.j.signallforum_finished);
                } else {
                    if (bvJ.buR() != 0) {
                        uc(bvJ.buS());
                        this.SK.yl();
                    } else if (com.baidu.adp.lib.util.j.kK()) {
                        this.gMt = true;
                        bvq();
                    } else {
                        showToast(e.j.neterror);
                    }
                    TiebaStatic.log("signall_click");
                }
            }
        } else if (view == this.gMp.bvL()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone("a_key_to_sign_V8.9", "bottom_opende/renewalfee_button_V8.9");
            sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    private void bvq() {
        c bvJ = this.gMp.bvJ();
        this.gMp.bvH().setDuration(Math.max(bvJ.buW().size() * 50, 2000));
        this.gMp.bvH().setSigning(0);
        this.gMr.d(bvJ);
        this.gMr.LoadData();
        this.gMp.bvK().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.gMp.bvK().getItemViewType(i) == 0 && this.gMp.bvJ() != null && this.gMp.bvJ().buT() != null && this.gMp.bvJ().buT().size() > i && (dVar = this.gMp.bvJ().buT().get(i)) != null) {
            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum").setCallFrom(6)));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uc(String str) {
        this.SK = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).dT(str).a(e.j.signallforum_signnow, new a.b() { // from class: com.baidu.tieba.signall.SignAllForumActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.SK.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.gMr != null && this.gMr.isRunning) {
            bvr();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.isDestory = true;
        if (this.SK != null && this.SK.isShowing()) {
            this.SK.dismiss();
        }
        if (this.gMq != null) {
            this.gMq.cancelLoadData();
            this.gMq = null;
        }
        if (this.gMp != null && this.gMp.bvK() != null) {
            this.gMp.bvK().bvs();
        }
        if (this.gMr != null) {
            if (this.gMr.isRunning) {
                bvr();
            }
            this.gMr.cancelMessage();
            this.gMr = null;
        }
        if (this.gMq != null) {
            this.gMq.cancelLoadData();
            this.gMq = null;
        }
    }

    private void bvr() {
        this.gMs = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(e.j.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (this.gMp == null || this.gMp.bvI() == null) {
            return null;
        }
        return this.gMp.bvI().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a022";
    }
}
