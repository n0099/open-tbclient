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
/* loaded from: classes10.dex */
public abstract class a {
    protected AlaWheatInfoData bYs;
    protected x hcZ;
    protected TbPageContext mPageContext;
    protected int okn;
    protected int oko;
    private d ovW;
    private HostConnectionWheatDialog ovX;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.b ovY;
    private c ovU = new c();
    protected b ovV = new b();
    protected CustomMessageListener ovZ = new CustomMessageListener(2501036) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501036) {
                a.this.cjr();
            }
        }
    };

    protected abstract void Vf(String str);

    protected abstract void Vg(String str);

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @CallSuper
    public void a(x xVar, AlaWheatInfoData alaWheatInfoData, int i, int i2) {
        this.hcZ = xVar;
        this.bYs = alaWheatInfoData;
        this.okn = i;
        this.oko = i2;
    }

    public void eaG() {
        eaK();
        eaL();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean eaH() {
        return this.okn == g.owL;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean eaI() {
        return this.okn == g.owM;
    }

    private boolean eaJ() {
        return this.okn == g.owN;
    }

    protected void eaK() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            return;
        }
        String loginUk = getLoginUk();
        if (!TextUtils.isEmpty(loginUk)) {
            if (eaJ()) {
                Vf(loginUk);
            } else if (this.bYs == null) {
                Vg(loginUk);
            } else {
                Vh(loginUk);
            }
        }
    }

    protected void Vh(String str) {
        if (this.hcZ != null && this.hcZ.aGd != null) {
            if (TextUtils.equals(this.bYs.uk, str)) {
                this.ovV.a(this.mPageContext, this.hcZ);
            } else {
                this.ovV.j(this.bYs);
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

    protected void eaL() {
        if (eaJ()) {
            this.ovU.al(this.hcZ);
        } else {
            this.ovU.a(this.bYs, this.oko);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eaM() {
        this.ovW = new d(this.mPageContext, this.oko);
        this.ovW.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.this.ovW = null;
            }
        });
        this.ovW.show();
        this.ovW.ebp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eaN() {
        this.ovX = new HostConnectionWheatDialog(this.mPageContext);
        this.ovX.Md(this.oko);
        this.ovX.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.this.ovX = null;
            }
        });
        if (!this.ovX.isShowing()) {
            this.ovX.show();
        }
        this.ovX.mD(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingDialog(String str) {
        if (this.ovY == null) {
            this.ovY = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.b(this.mPageContext.getPageActivity());
        }
        this.ovY.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.this.ovY = null;
            }
        });
        if (!this.ovY.isShowing()) {
            this.ovY.show();
        }
        this.ovY.setTipString(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjr() {
        if (this.ovY != null) {
            this.ovY.dismiss();
            this.ovY = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eaO() {
        com.baidu.tieba.yuyinala.liveroom.wheat.c.c.eaV().a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.5
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
            public void dbt() {
                com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("start_connection_wheat_host_1", true);
                a.this.showLoadingDialog(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connecting_wheat_text_3));
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
            public void eaQ() {
                SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                    }
                });
            }
        }).a(this.mPageContext.getPageActivity(), this.mPageContext.getPageActivity(), "1", "0");
        MessageManager.getInstance().unRegisterListener(this.ovZ);
        MessageManager.getInstance().registerListener(this.ovZ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eaP() {
        showLoadingDialog(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_switch_text));
        new l(null, new l.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.6
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.l.a
            public void a(AlaWheatSwitchHttpResponseMessage alaWheatSwitchHttpResponseMessage) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                a.this.cjr();
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.l.a
            public void b(AlaWheatSwitchHttpResponseMessage alaWheatSwitchHttpResponseMessage) {
                a.this.cjr();
            }
        }).gR(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().yv(), Integer.toString(o.ebo().ebt() + 1));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showToast(int i) {
        BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(i)).show();
    }

    public void onDestory() {
        if (this.ovW != null) {
            this.ovW = null;
        }
        if (this.ovX != null) {
            this.ovX = null;
        }
        if (this.ovY != null) {
            this.ovY = null;
        }
        MessageManager.getInstance().unRegisterListener(this.ovZ);
    }
}
