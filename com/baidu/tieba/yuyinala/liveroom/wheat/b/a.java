package com.baidu.tieba.yuyinala.liveroom.wheat.b;

import android.content.DialogInterface;
import android.support.annotation.CallSuper;
import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.w;
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
import com.baidu.tieba.yuyinala.liveroom.wheat.model.k;
/* loaded from: classes4.dex */
public abstract class a {
    protected w gVQ;
    protected TbPageContext mPageContext;
    protected AlaWheatInfoData olV;
    protected int olW;
    protected int olX;
    private d otN;
    private HostConnectionWheatDialog otO;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.b otP;
    private c otL = new c();
    protected b otM = new b();
    protected CustomMessageListener otQ = new CustomMessageListener(2501036) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501036) {
                a.this.ckt();
            }
        }
    };

    protected abstract void WD(String str);

    protected abstract void WE(String str);

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @CallSuper
    public void a(w wVar, AlaWheatInfoData alaWheatInfoData, int i, int i2) {
        this.gVQ = wVar;
        this.olV = alaWheatInfoData;
        this.olW = i;
        this.olX = i2;
    }

    public void eew() {
        eeA();
        eeB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean eex() {
        return this.olW == g.ouD;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean eey() {
        return this.olW == g.ouE;
    }

    private boolean eez() {
        return this.olW == g.ouF;
    }

    protected void eeA() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            return;
        }
        String loginUk = getLoginUk();
        if (!TextUtils.isEmpty(loginUk)) {
            if (eez()) {
                WD(loginUk);
            } else if (this.olV == null) {
                WE(loginUk);
            } else {
                WF(loginUk);
            }
        }
    }

    protected void WF(String str) {
        if (this.gVQ != null && this.gVQ.aKr != null) {
            if (TextUtils.equals(this.olV.uk, str)) {
                this.otM.a(this.mPageContext, this.gVQ);
            } else {
                this.otM.l(this.olV);
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

    protected void eeB() {
        if (eez()) {
            this.otL.ah(this.gVQ);
        } else {
            this.otL.a(this.olV, this.olX);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eeC() {
        this.otN = new d(this.mPageContext, this.olX);
        this.otN.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.this.otN = null;
            }
        });
        this.otN.show();
        this.otN.efe();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eeD() {
        this.otO = new HostConnectionWheatDialog(this.mPageContext);
        this.otO.NT(this.olX);
        this.otO.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.this.otO = null;
            }
        });
        if (!this.otO.isShowing()) {
            this.otO.show();
        }
        this.otO.mk(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingDialog(String str) {
        if (this.otP == null) {
            this.otP = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.b(this.mPageContext.getPageActivity());
        }
        this.otP.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.this.otP = null;
            }
        });
        if (!this.otP.isShowing()) {
            this.otP.show();
        }
        this.otP.setTipString(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckt() {
        if (this.otP != null) {
            this.otP.dismiss();
            this.otP = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eeE() {
        com.baidu.tieba.yuyinala.liveroom.wheat.c.c.eeL().a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.5
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
            public void dfx() {
                com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bk("start_connection_wheat_host_1", true);
                a.this.showLoadingDialog(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connecting_wheat_text_3));
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
            public void eeG() {
                SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                    }
                });
            }
        }).a(this.mPageContext.getPageActivity(), this.mPageContext.getPageActivity(), "1", "0");
        MessageManager.getInstance().unRegisterListener(this.otQ);
        MessageManager.getInstance().registerListener(this.otQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eeF() {
        showLoadingDialog(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_switch_text));
        new k(null, new k.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.6
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.k.a
            public void a(AlaWheatSwitchHttpResponseMessage alaWheatSwitchHttpResponseMessage) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                a.this.ckt();
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.k.a
            public void b(AlaWheatSwitchHttpResponseMessage alaWheatSwitchHttpResponseMessage) {
                a.this.ckt();
            }
        }).gU(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().CZ(), Integer.toString(o.efd().efh() + 1));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showToast(int i) {
        BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(i)).show();
    }

    public void onDestory() {
        if (this.otN != null) {
            this.otN = null;
        }
        if (this.otO != null) {
            this.otO = null;
        }
        if (this.otP != null) {
            this.otP = null;
        }
        MessageManager.getInstance().unRegisterListener(this.otQ);
    }
}
