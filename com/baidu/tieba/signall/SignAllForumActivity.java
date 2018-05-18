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
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.e;
import com.baidu.tieba.d;
import com.baidu.tieba.signall.GetForumListModel;
import com.baidu.tieba.signall.SignAllForumModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements e.b {
    private com.baidu.tbadk.core.dialog.a JR;
    private j gok;
    private GetForumListModel gol;
    private SignAllForumModel gom;
    private boolean gon;
    private boolean isDestory;
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.gok.boX().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener goo = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c boZ;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (boZ = SignAllForumActivity.this.gok.boZ()) != null) {
                boZ.a((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.gok.bpa().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a gop = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            SignAllForumActivity.this.gok.lg();
            a bol = cVar.bol();
            if (bol != null && bol.getErrorNumber() == 0) {
                SignAllForumActivity.this.gok.a(cVar, SignAllForumActivity.this.gol.boE());
                return;
            }
            SignAllForumActivity.this.showToast(bol.getUserMsg(), false);
            SignAllForumActivity.this.finish();
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void ny(String str) {
            SignAllForumActivity.this.gok.lg();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a goq = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void ny(String str) {
            SignAllForumActivity.this.sC(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            a bol = hVar.bol();
            if (bol == null || bol.getErrorNumber() != 0) {
                SignAllForumActivity.this.sC(bol.getUserMsg());
                return;
            }
            c boZ = SignAllForumActivity.this.gok.boZ();
            boZ.a(hVar);
            if (SignAllForumActivity.this.gon) {
                Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(d.k.signallforum_back_finish, new Object[]{Integer.valueOf(boZ.bos()), Integer.valueOf(boZ.bot())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                if (SignAllForumActivity.this.isDestory) {
                    return;
                }
            }
            SignAllForumActivity.this.gok.bpa().notifyDataSetChanged();
            SignAllForumProgressView boX = SignAllForumActivity.this.gok.boX();
            if (!boZ.bor()) {
                if (hVar.boK() != 0) {
                    SignAllForumActivity.this.sD(hVar.boj());
                    SignAllForumActivity.this.JR.tC();
                } else if (hVar.boM() != 0) {
                    SignAllForumActivity.this.showToast(hVar.boN());
                } else {
                    SignAllForumActivity.this.showToast(d.k.signallforum_error);
                }
            }
            boX.setSignSuccess();
            SignAllForumActivity.this.b(boZ);
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new al("c12536").r("obj_locate", ar.a.ajf));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new al("c12535").r("obj_locate", ar.a.ajf));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String boa = cVar.boa();
            final String Hv = cVar.Hv();
            final boolean boo = cVar.boo();
            if (cVar.bnZ()) {
                this.gok.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage(2002001, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), boa, Hv, Boolean.valueOf(boo))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sC(String str) {
        if (this.gon) {
            c boZ = this.gok.boZ();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(d.k.signallforum_back_finish, new Object[]{0, Integer.valueOf(boZ.bon().size())});
            a(str, activity, false);
            if (this.isDestory) {
                return;
            }
        }
        showToast(str);
        this.gok.boX().setSignSuccess();
        ArrayList<d> bon = this.gok.boZ().bon();
        int size = bon.size();
        for (int i = 0; i < size; i++) {
            d dVar = bon.get(i);
            dVar.mc(true);
            dVar.md(false);
            dVar.mb(false);
        }
        this.gok.bpa().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), d.f.singnallforum_progress, getPageContext().getString(d.k.app_name), str, str, pendingIntent, z);
    }

    private void zA() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), d.f.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!TbadkCoreApplication.isLogin()) {
            az.aJ(getActivity());
            finish();
            return;
        }
        zA();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.goo);
        initData();
        initUI();
    }

    private void initUI() {
        this.gok = new j(this);
        this.gok.a(this);
        this.gok.setOnItemClickListener(this);
        if (this.gom.isRunning) {
            this.gop.a(this.gom.boQ());
            this.gok.boX().setSigning(90);
            return;
        }
        this.gok.startPullRefresh();
    }

    private void initData() {
        this.gol = new GetForumListModel(this);
        this.gol.a(this.gop);
        this.gom = new SignAllForumModel(this);
        this.gom.a(this.goq);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gok.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.e.b
    public void aO(boolean z) {
        if (!com.baidu.adp.lib.util.j.gP()) {
            showToast(d.k.neterror);
            this.gok.lg();
        } else if (this.gol == null) {
            showToast(d.k.neterror);
        } else if (!this.gol.LoadData()) {
            this.gok.lg();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        c boZ = this.gok.boZ();
        if (view2 == this.gok.getProgressBar()) {
            if (boZ.getBlockPopInfoData() != null) {
                if (AntiHelper.a(getPageContext().getPageActivity(), boZ.getBlockPopInfoData(), this.mInjectListener) != null) {
                    TiebaStatic.log(new al("c12534").r("obj_locate", ar.a.ajf));
                }
            } else if (this.gok.boX().getCurrentStatus() == 2) {
                showToast(d.k.signallforum_finished);
            } else {
                if (boZ.boi() != 0) {
                    sD(boZ.boj());
                    this.JR.tC();
                } else if (com.baidu.adp.lib.util.j.gP()) {
                    boG();
                } else {
                    showToast(d.k.neterror);
                }
                TiebaStatic.log("signall_click");
            }
        } else if (view2 == this.gok.bpb()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone("a_key_to_sign_V8.9", "bottom_opende/renewalfee_button_V8.9");
            sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    private void boG() {
        c boZ = this.gok.boZ();
        this.gok.boX().setDuration(Math.max(boZ.bon().size() * 50, 2000));
        this.gok.boX().setSigning(0);
        this.gom.d(boZ);
        this.gom.LoadData();
        this.gok.bpa().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        d dVar;
        if (this.gok.bpa().getItemViewType(i) == 0 && this.gok.boZ() != null && this.gok.boZ().bok() != null && this.gok.boZ().bok().size() > i && (dVar = this.gok.boZ().bok().get(i)) != null) {
            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum")));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sD(String str) {
        this.JR = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).dc(str).a(d.k.signallforum_signnow, new a.b() { // from class: com.baidu.tieba.signall.SignAllForumActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.JR.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.gom != null && this.gom.isRunning) {
            boH();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.isDestory = true;
        if (this.JR != null && this.JR.isShowing()) {
            this.JR.dismiss();
        }
        if (this.gol != null) {
            this.gol.cancelLoadData();
            this.gol = null;
        }
        if (this.gok != null && this.gok.bpa() != null) {
            this.gok.bpa().boI();
        }
        if (this.gom != null) {
            if (this.gom.isRunning) {
                boH();
            }
            this.gom.cancelMessage();
            this.gom = null;
        }
        if (this.gol != null) {
            this.gol.cancelLoadData();
            this.gol = null;
        }
    }

    private void boH() {
        this.gon = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(d.k.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (this.gok == null || this.gok.boY() == null) {
            return null;
        }
        return this.gok.boY().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a022";
    }
}
