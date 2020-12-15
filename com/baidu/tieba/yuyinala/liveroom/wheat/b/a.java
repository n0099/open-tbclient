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
    protected w gVS;
    protected TbPageContext mPageContext;
    protected AlaWheatInfoData olX;
    protected int olY;
    protected int olZ;
    private d otP;
    private HostConnectionWheatDialog otQ;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.b otR;
    private c otN = new c();
    protected b otO = new b();
    protected CustomMessageListener otS = new CustomMessageListener(2501036) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501036) {
                a.this.cku();
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
        this.gVS = wVar;
        this.olX = alaWheatInfoData;
        this.olY = i;
        this.olZ = i2;
    }

    public void eex() {
        eeB();
        eeC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean eey() {
        return this.olY == g.ouF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean eez() {
        return this.olY == g.ouG;
    }

    private boolean eeA() {
        return this.olY == g.ouH;
    }

    protected void eeB() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            return;
        }
        String loginUk = getLoginUk();
        if (!TextUtils.isEmpty(loginUk)) {
            if (eeA()) {
                WD(loginUk);
            } else if (this.olX == null) {
                WE(loginUk);
            } else {
                WF(loginUk);
            }
        }
    }

    protected void WF(String str) {
        if (this.gVS != null && this.gVS.aKr != null) {
            if (TextUtils.equals(this.olX.uk, str)) {
                this.otO.a(this.mPageContext, this.gVS);
            } else {
                this.otO.l(this.olX);
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
            this.otN.ah(this.gVS);
        } else {
            this.otN.a(this.olX, this.olZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eeD() {
        this.otP = new d(this.mPageContext, this.olZ);
        this.otP.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.this.otP = null;
            }
        });
        this.otP.show();
        this.otP.eff();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eeE() {
        this.otQ = new HostConnectionWheatDialog(this.mPageContext);
        this.otQ.NT(this.olZ);
        this.otQ.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.this.otQ = null;
            }
        });
        if (!this.otQ.isShowing()) {
            this.otQ.show();
        }
        this.otQ.mk(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingDialog(String str) {
        if (this.otR == null) {
            this.otR = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.b(this.mPageContext.getPageActivity());
        }
        this.otR.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.this.otR = null;
            }
        });
        if (!this.otR.isShowing()) {
            this.otR.show();
        }
        this.otR.setTipString(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cku() {
        if (this.otR != null) {
            this.otR.dismiss();
            this.otR = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eeF() {
        com.baidu.tieba.yuyinala.liveroom.wheat.c.c.eeM().a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.5
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
            public void dfy() {
                com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bk("start_connection_wheat_host_1", true);
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
        MessageManager.getInstance().unRegisterListener(this.otS);
        MessageManager.getInstance().registerListener(this.otS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eeG() {
        showLoadingDialog(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_switch_text));
        new k(null, new k.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.6
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.k.a
            public void a(AlaWheatSwitchHttpResponseMessage alaWheatSwitchHttpResponseMessage) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                a.this.cku();
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.k.a
            public void b(AlaWheatSwitchHttpResponseMessage alaWheatSwitchHttpResponseMessage) {
                a.this.cku();
            }
        }).gU(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().CZ(), Integer.toString(o.efe().efi() + 1));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showToast(int i) {
        BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(i)).show();
    }

    public void onDestory() {
        if (this.otP != null) {
            this.otP = null;
        }
        if (this.otQ != null) {
            this.otQ = null;
        }
        if (this.otR != null) {
            this.otR = null;
        }
        MessageManager.getInstance().unRegisterListener(this.otS);
    }
}
