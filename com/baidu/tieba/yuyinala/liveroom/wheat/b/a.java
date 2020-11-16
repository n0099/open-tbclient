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
    protected w gMD;
    protected TbPageContext mPageContext;
    protected AlaWheatInfoData nWX;
    protected int nWY;
    protected int nWZ;
    private d oeN;
    private HostConnectionWheatDialog oeO;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.b oeP;
    private c oeL = new c();
    protected b oeM = new b();
    protected CustomMessageListener oeQ = new CustomMessageListener(2501036) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501036) {
                a.this.cgz();
            }
        }
    };

    protected abstract void Vo(String str);

    protected abstract void Vp(String str);

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @CallSuper
    public void a(w wVar, AlaWheatInfoData alaWheatInfoData, int i, int i2) {
        this.gMD = wVar;
        this.nWX = alaWheatInfoData;
        this.nWY = i;
        this.nWZ = i2;
    }

    public void dYS() {
        dYW();
        dYX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dYT() {
        return this.nWY == g.ofD;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dYU() {
        return this.nWY == g.ofE;
    }

    private boolean dYV() {
        return this.nWY == g.ofF;
    }

    protected void dYW() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            return;
        }
        String loginUk = getLoginUk();
        if (!TextUtils.isEmpty(loginUk)) {
            if (dYV()) {
                Vo(loginUk);
            } else if (this.nWX == null) {
                Vp(loginUk);
            } else {
                Vq(loginUk);
            }
        }
    }

    protected void Vq(String str) {
        if (this.gMD != null && this.gMD.aHG != null) {
            if (TextUtils.equals(this.nWX.uk, str)) {
                this.oeM.a(this.mPageContext, this.gMD);
            } else {
                this.oeM.l(this.nWX);
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

    protected void dYX() {
        if (dYV()) {
            this.oeL.ac(this.gMD);
        } else {
            this.oeL.a(this.nWX, this.nWZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dYY() {
        this.oeN = new d(this.mPageContext, this.nWZ);
        this.oeN.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.this.oeN = null;
            }
        });
        this.oeN.show();
        this.oeN.dZA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dYZ() {
        this.oeO = new HostConnectionWheatDialog(this.mPageContext);
        this.oeO.Nb(this.nWZ);
        this.oeO.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.this.oeO = null;
            }
        });
        if (!this.oeO.isShowing()) {
            this.oeO.show();
        }
        this.oeO.lP(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingDialog(String str) {
        if (this.oeP == null) {
            this.oeP = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.b(this.mPageContext.getPageActivity());
        }
        this.oeP.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.this.oeP = null;
            }
        });
        if (!this.oeP.isShowing()) {
            this.oeP.show();
        }
        this.oeP.setTipString(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgz() {
        if (this.oeP != null) {
            this.oeP.dismiss();
            this.oeP = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dZa() {
        com.baidu.tieba.yuyinala.liveroom.wheat.c.c.dZh().a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.5
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
            public void dal() {
                com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("start_connection_wheat_host_1", true);
                a.this.showLoadingDialog(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connecting_wheat_text_3));
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
            public void dZc() {
                SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                    }
                });
            }
        }).a(this.mPageContext.getPageActivity(), this.mPageContext.getPageActivity(), "1", "0");
        MessageManager.getInstance().unRegisterListener(this.oeQ);
        MessageManager.getInstance().registerListener(this.oeQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dZb() {
        showLoadingDialog(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_switch_text));
        new k(null, new k.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.6
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.k.a
            public void a(AlaWheatSwitchHttpResponseMessage alaWheatSwitchHttpResponseMessage) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                a.this.cgz();
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.k.a
            public void b(AlaWheatSwitchHttpResponseMessage alaWheatSwitchHttpResponseMessage) {
                a.this.cgz();
            }
        }).gP(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().Br(), Integer.toString(o.dZz().dZD() + 1));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showToast(int i) {
        BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(i)).show();
    }

    public void onDestory() {
        if (this.oeN != null) {
            this.oeN = null;
        }
        if (this.oeO != null) {
            this.oeO = null;
        }
        if (this.oeP != null) {
            this.oeP = null;
        }
        MessageManager.getInstance().unRegisterListener(this.oeQ);
    }
}
