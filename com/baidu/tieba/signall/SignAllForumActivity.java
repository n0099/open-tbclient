package com.baidu.tieba.signall;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.r;
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
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.n.m;
import com.baidu.tieba.R;
import com.baidu.tieba.signall.GetForumListModel;
import com.baidu.tieba.signall.SignAllForumModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements f.c {
    private com.baidu.tbadk.core.dialog.a Zw;
    private boolean isDestory;
    private j lbS;
    private GetForumListModel lbT;
    private SignAllForumModel lbU;
    private boolean lbV;
    private boolean lbW = false;
    private long beginTime = 0;
    private long creatTime = 0;
    private long kkK = 0;
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.signall.SignAllForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                SignAllForumActivity.this.lbS.dbl().setHasPrivilege(true);
            }
        }
    };
    private final CustomMessageListener lbX = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.signall.SignAllForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c dbn;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (dbn = SignAllForumActivity.this.lbS.dbn()) != null) {
                dbn.b((SignData) customResponsedMessage.getData());
                SignAllForumActivity.this.lbS.dbo().notifyDataSetChanged();
            }
        }
    };
    private GetForumListModel.a lbY = new GetForumListModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3
        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void a(c cVar) {
            long currentTimeMillis = System.currentTimeMillis();
            SignAllForumActivity.this.lbS.completeRefresh();
            a day = cVar.day();
            if (day != null) {
                if (day.getErrorNumber() == 0) {
                    SignAllForumActivity.this.lbS.a(cVar, SignAllForumActivity.this.lbT.daR());
                } else {
                    SignAllForumActivity.this.showToast(day.getUserMsg(), false);
                    SignAllForumActivity.this.finish();
                }
            }
            final long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            final long currentTimeMillis3 = SignAllForumActivity.this.beginTime > 0 ? System.currentTimeMillis() - SignAllForumActivity.this.beginTime : SignAllForumActivity.this.creatTime + (System.currentTimeMillis() - SignAllForumActivity.this.kkK);
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.signall.SignAllForumActivity.3.1
                @Override // android.os.MessageQueue.IdleHandler
                public boolean queueIdle() {
                    SignAllForumActivity.this.G(currentTimeMillis3, currentTimeMillis2);
                    return false;
                }
            });
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.a
        public void Gv(String str) {
            SignAllForumActivity.this.lbS.completeRefresh();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    };
    private SignAllForumModel.a lbZ = new SignAllForumModel.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.4
        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void Gv(String str) {
            SignAllForumActivity.this.Mb(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(h hVar) {
            if (hVar != null) {
                if (hVar.getErrorCode() == 3250013 && SignAllForumActivity.this.lbW) {
                    SignAllForumActivity.this.lbW = false;
                    BdToast.a(TbadkCoreApplication.getInst().getContext(), hVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aSY();
                    if (SignAllForumActivity.this.lbS != null && SignAllForumActivity.this.lbS.dbl() != null) {
                        SignAllForumActivity.this.lbS.dbl().setSignBefore(0);
                        return;
                    }
                    return;
                }
                a day = hVar.day();
                if (day != null) {
                    if (day.getErrorNumber() == 0) {
                        c dbn = SignAllForumActivity.this.lbS.dbn();
                        dbn.a(hVar);
                        if (SignAllForumActivity.this.lbV) {
                            Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                            intent.addFlags(805306368);
                            intent.putExtra("signall_noyify_click", true);
                            SignAllForumActivity.this.a(SignAllForumActivity.this.getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{Integer.valueOf(dbn.daF()), Integer.valueOf(dbn.daG())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                            if (SignAllForumActivity.this.isDestory) {
                                return;
                            }
                        }
                        SignAllForumActivity.this.lbS.dbo().notifyDataSetChanged();
                        SignAllForumProgressView dbl = SignAllForumActivity.this.lbS.dbl();
                        if (!dbn.daE()) {
                            if (hVar.daZ() != 0) {
                                SignAllForumActivity.this.Mc(hVar.daw());
                                SignAllForumActivity.this.Zw.aST();
                            } else if (hVar.dbb() != 0) {
                                SignAllForumActivity.this.showToast(hVar.dbc());
                            } else {
                                SignAllForumActivity.this.showToast(R.string.signallforum_error);
                            }
                        }
                        if (SignAllForumActivity.this.Zw == null || !SignAllForumActivity.this.Zw.isShowing()) {
                            SignAllForumActivity.this.daU();
                        }
                        dbl.setSignSuccess();
                        SignAllForumActivity.this.b(dbn);
                        return;
                    }
                    SignAllForumActivity.this.Mb(day.getUserMsg());
                }
            }
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.signall.SignAllForumActivity.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ag("obj_locate", at.a.LOCATE_SIGN));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ag("obj_locate", at.a.LOCATE_SIGN));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void daU() {
        if (this.lbS != null) {
            com.baidu.tbadk.coreExtra.messageCenter.f.ban().a(getPageContext(), this.lbS.bIL());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            final String dan = cVar.dan();
            final String bgl = cVar.bgl();
            final boolean daB = cVar.daB();
            if (cVar.dam()) {
                this.lbS.setListViewSelection(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SignAllForumActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), dan, bgl, Boolean.valueOf(daB))));
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mb(String str) {
        if (this.lbV) {
            c dbn = this.lbS.dbn();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{0, Integer.valueOf(dbn.daA().size())});
            a(str, activity, false);
            if (this.isDestory) {
                return;
            }
        }
        showToast(str);
        this.lbS.dbl().setSignSuccess();
        ArrayList<d> daA = this.lbS.dbn().daA();
        int size = daA.size();
        for (int i = 0; i < size; i++) {
            d dVar = daA.get(i);
            dVar.uf(true);
            dVar.ug(false);
            dVar.ue(false);
        }
        this.lbS.dbo().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress, getPageContext().getString(R.string.app_name), str, str, pendingIntent, z);
    }

    private void aZp() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.beginTime = System.currentTimeMillis();
        super.onCreate(bundle);
        if (!TbadkCoreApplication.isLogin()) {
            bc.skipToLoginActivity(getActivity());
            finish();
            return;
        }
        aZp();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.lbX);
        initData();
        initUI();
        this.creatTime = System.currentTimeMillis() - this.beginTime;
    }

    private void initUI() {
        this.lbS = new j(this);
        this.lbS.setListPullRefreshListener(this);
        this.lbS.setOnItemClickListener(this);
        if (this.lbU.isRunning) {
            this.lbY.a(this.lbU.dbf());
            this.lbS.dbl().setSigning(90);
            return;
        }
        this.lbS.startPullRefresh();
    }

    private void initData() {
        this.lbT = new GetForumListModel(this);
        this.lbT.a(this.lbY);
        this.lbU = new SignAllForumModel(this);
        this.lbU.a(this.lbZ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lbS.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.kkK = System.currentTimeMillis();
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            this.lbS.completeRefresh();
        } else if (this.lbT == null) {
            showToast(R.string.neterror);
        } else if (!this.lbT.LoadData()) {
            this.lbS.completeRefresh();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c dbn = this.lbS.dbn();
        if (view == this.lbS.getProgressBar()) {
            if (dbn != null) {
                if (dbn.getBlockPopInfoData() != null) {
                    if (dbn.getBlockPopInfoData().appeal_status == 1) {
                        BdToast.a(getPageContext().getPageActivity(), dbn.getBlockPopInfoData().appeal_msg, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aSY();
                    } else if (AntiHelper.a(getPageContext().getPageActivity(), dbn.getBlockPopInfoData(), this.mInjectListener) != null) {
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ag("obj_locate", at.a.LOCATE_SIGN));
                    }
                } else if (this.lbS.dbl().getCurrentStatus() == 2) {
                    showToast(R.string.signallforum_finished);
                } else {
                    if (dbn.dav() != 0) {
                        Mc(dbn.daw());
                        this.Zw.aST();
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.lbW = true;
                        daV();
                    } else {
                        showToast(R.string.neterror);
                    }
                    TiebaStatic.log("signall_click");
                }
            }
        } else if (view == this.lbS.dbp()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
            memberPayActivityConfig.setSceneId("4007001000");
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_A_KEY_TO_SIGN, MemberPayStatistic.CLICK_ZONE_BOTTOM_OPENDE_RENEWALFEE_BUTTON);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        }
    }

    private void daV() {
        c dbn = this.lbS.dbn();
        this.lbS.dbl().setDuration(Math.max(dbn.daA().size() * 50, 2000));
        this.lbS.dbl().setSigning(0);
        this.lbU.d(dbn);
        this.lbU.LoadData();
        this.lbS.dbo().notifyDataSetChanged();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (this.lbS.dbo().getItemViewType(i) == 0 && this.lbS.dbn() != null && this.lbS.dbn().dax() != null && this.lbS.dbn().dax().size() > i && (dVar = this.lbS.dbn().dax().get(i)) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.getForumName(), "signallforum").setCallFrom(6)));
            TiebaStatic.log("signall_frs_click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mc(String str) {
        this.Zw = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).vO(str).a(R.string.signallforum_signnow, new a.b() { // from class: com.baidu.tieba.signall.SignAllForumActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.Zw.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.lbU != null && this.lbU.isRunning) {
            daW();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.isDestory = true;
        if (this.Zw != null && this.Zw.isShowing()) {
            this.Zw.dismiss();
        }
        if (this.lbT != null) {
            this.lbT.cancelLoadData();
            this.lbT = null;
        }
        if (this.lbS != null && this.lbS.dbo() != null) {
            this.lbS.dbo().daX();
        }
        if (this.lbU != null) {
            if (this.lbU.isRunning) {
                daW();
            }
            this.lbU.cancelMessage();
            this.lbU = null;
        }
        if (this.lbT != null) {
            this.lbT.cancelLoadData();
            this.lbT = null;
        }
    }

    private void daW() {
        this.lbV = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        a(getPageContext().getString(R.string.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public r onGetPreLoadListView() {
        if (this.lbS == null || this.lbS.dbm() == null) {
            return null;
        }
        return this.lbS.dbm().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SIGN_ALL_NEW;
    }

    public void G(long j, long j2) {
        if (m.bfI().bfJ() && this.creatTime > 0) {
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(1009, true, this.lbT.daS(), 0L, this.creatTime, j2, false, 0L, 0L, j);
            if (iVar != null) {
                iVar.bfF();
            }
            this.creatTime = 0L;
        }
    }
}
