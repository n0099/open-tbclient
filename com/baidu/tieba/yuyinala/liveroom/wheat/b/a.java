package com.baidu.tieba.yuyinala.liveroom.wheat.b;

import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.CallSuper;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.dialog.BdToast;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.c;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.g;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
import com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog;
import com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaWheatSwitchHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.l;
/* loaded from: classes11.dex */
public abstract class a {
    protected AlaWheatInfoData cdg;
    protected x hhF;
    protected TbPageContext mPageContext;
    private d oAB;
    private HostConnectionWheatDialog oAC;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.b oAD;
    protected int ooT;
    protected int ooU;
    private c oAz = new c();
    protected b oAA = new b();
    protected CustomMessageListener oAE = new CustomMessageListener(2501036) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501036) {
                a.this.cni();
            }
        }
    };

    protected abstract void Wn(String str);

    protected abstract void Wo(String str);

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @CallSuper
    public void a(x xVar, AlaWheatInfoData alaWheatInfoData, int i, int i2) {
        this.hhF = xVar;
        this.cdg = alaWheatInfoData;
        this.ooT = i;
        this.ooU = i2;
    }

    public void eex() {
        eeB();
        eeC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean eey() {
        return this.ooT == g.oBq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean eez() {
        return this.ooT == g.oBr;
    }

    private boolean eeA() {
        return this.ooT == g.oBs;
    }

    protected void eeB() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            return;
        }
        String loginUk = getLoginUk();
        if (!TextUtils.isEmpty(loginUk)) {
            if (eeA()) {
                Wn(loginUk);
            } else if (this.cdg == null) {
                Wo(loginUk);
            } else {
                Wp(loginUk);
            }
        }
    }

    protected void Wp(String str) {
        if (this.hhF != null && this.hhF.aKQ != null) {
            if (TextUtils.equals(this.cdg.uk, str)) {
                this.oAA.a(this.mPageContext, this.hhF);
            } else {
                this.oAA.j(this.cdg);
            }
        }
    }

    protected String getLoginUk() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo == null) {
            return "";
        }
        return ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID());
    }

    protected void eeC() {
        if (eeA()) {
            this.oAz.al(this.hhF);
        } else {
            this.oAz.a(this.cdg, this.ooU);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eeD() {
        this.oAB = new d(this.mPageContext, this.ooU);
        this.oAB.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.this.oAB = null;
            }
        });
        this.oAB.show();
        this.oAB.efg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eeE() {
        this.oAC = new HostConnectionWheatDialog(this.mPageContext);
        this.oAC.NK(this.ooU);
        this.oAC.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.this.oAC = null;
            }
        });
        if (!this.oAC.isShowing()) {
            this.oAC.show();
        }
        this.oAC.mH(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingDialog(String str) {
        if (this.oAD == null) {
            this.oAD = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.b(this.mPageContext.getPageActivity());
        }
        this.oAD.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.this.oAD = null;
            }
        });
        if (!this.oAD.isShowing()) {
            this.oAD.show();
        }
        this.oAD.setTipString(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cni() {
        if (this.oAD != null) {
            this.oAD.dismiss();
            this.oAD = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eeF() {
        com.baidu.tieba.yuyinala.liveroom.wheat.c.c.eeM().a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.5
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
            public void dfk() {
                com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("start_connection_wheat_host_1", true);
                a.this.showLoadingDialog(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connecting_wheat_text_3));
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
            public void eeH() {
                SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                    }
                });
            }
        }).a(this.mPageContext.getPageActivity(), this.mPageContext.getPageActivity(), "1", "0");
        MessageManager.getInstance().unRegisterListener(this.oAE);
        MessageManager.getInstance().registerListener(this.oAE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eeG() {
        showLoadingDialog(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_switch_text));
        new l(null, new l.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.6
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.l.a
            public void a(AlaWheatSwitchHttpResponseMessage alaWheatSwitchHttpResponseMessage) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                a.this.cni();
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.l.a
            public void b(AlaWheatSwitchHttpResponseMessage alaWheatSwitchHttpResponseMessage) {
                a.this.cni();
            }
        }).gS(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().Cq(), Integer.toString(o.eff().efk() + 1));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showToast(int i) {
        BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(i)).show();
    }

    public void onDestory() {
        if (this.oAB != null) {
            this.oAB = null;
        }
        if (this.oAC != null) {
            this.oAC = null;
        }
        if (this.oAD != null) {
            this.oAD = null;
        }
        MessageManager.getInstance().unRegisterListener(this.oAE);
    }
}
