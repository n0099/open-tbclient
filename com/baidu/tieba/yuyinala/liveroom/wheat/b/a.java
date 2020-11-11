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
    protected w gMW;
    protected TbPageContext mPageContext;
    protected AlaWheatInfoData nVu;
    protected int nVv;
    protected int nVw;
    private d odk;
    private HostConnectionWheatDialog odl;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.b odm;
    private c odi = new c();
    protected b odj = new b();
    protected CustomMessageListener odn = new CustomMessageListener(2501036) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501036) {
                a.this.chg();
            }
        }
    };

    protected abstract void VD(String str);

    protected abstract void VE(String str);

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @CallSuper
    public void a(w wVar, AlaWheatInfoData alaWheatInfoData, int i, int i2) {
        this.gMW = wVar;
        this.nVu = alaWheatInfoData;
        this.nVv = i;
        this.nVw = i2;
    }

    public void dYT() {
        dYX();
        dYY();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dYU() {
        return this.nVv == g.odZ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dYV() {
        return this.nVv == g.oea;
    }

    private boolean dYW() {
        return this.nVv == g.oeb;
    }

    protected void dYX() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            return;
        }
        String loginUk = getLoginUk();
        if (!TextUtils.isEmpty(loginUk)) {
            if (dYW()) {
                VD(loginUk);
            } else if (this.nVu == null) {
                VE(loginUk);
            } else {
                VF(loginUk);
            }
        }
    }

    protected void VF(String str) {
        if (this.gMW != null && this.gMW.aJr != null) {
            if (TextUtils.equals(this.nVu.uk, str)) {
                this.odj.a(this.mPageContext, this.gMW);
            } else {
                this.odj.l(this.nVu);
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

    protected void dYY() {
        if (dYW()) {
            this.odi.ac(this.gMW);
        } else {
            this.odi.a(this.nVu, this.nVw);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dYZ() {
        this.odk = new d(this.mPageContext, this.nVw);
        this.odk.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.this.odk = null;
            }
        });
        this.odk.show();
        this.odk.dZB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dZa() {
        this.odl = new HostConnectionWheatDialog(this.mPageContext);
        this.odl.My(this.nVw);
        this.odl.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.this.odl = null;
            }
        });
        if (!this.odl.isShowing()) {
            this.odl.show();
        }
        this.odl.lO(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingDialog(String str) {
        if (this.odm == null) {
            this.odm = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.b(this.mPageContext.getPageActivity());
        }
        this.odm.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.this.odm = null;
            }
        });
        if (!this.odm.isShowing()) {
            this.odm.show();
        }
        this.odm.setTipString(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chg() {
        if (this.odm != null) {
            this.odm.dismiss();
            this.odm = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dZb() {
        com.baidu.tieba.yuyinala.liveroom.wheat.c.c.dZi().a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.5
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
            public void daO() {
                com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("start_connection_wheat_host_1", true);
                a.this.showLoadingDialog(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connecting_wheat_text_3));
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
            public void dZd() {
                SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                    }
                });
            }
        }).a(this.mPageContext.getPageActivity(), this.mPageContext.getPageActivity(), "1", "0");
        MessageManager.getInstance().unRegisterListener(this.odn);
        MessageManager.getInstance().registerListener(this.odn);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dZc() {
        showLoadingDialog(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_switch_text));
        new k(null, new k.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.6
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.k.a
            public void a(AlaWheatSwitchHttpResponseMessage alaWheatSwitchHttpResponseMessage) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                a.this.chg();
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.k.a
            public void b(AlaWheatSwitchHttpResponseMessage alaWheatSwitchHttpResponseMessage) {
                a.this.chg();
            }
        }).gP(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().Ca(), Integer.toString(o.dZA().dZE() + 1));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showToast(int i) {
        BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(i)).show();
    }

    public void onDestory() {
        if (this.odk != null) {
            this.odk = null;
        }
        if (this.odl != null) {
            this.odl = null;
        }
        if (this.odm != null) {
            this.odm = null;
        }
        MessageManager.getInstance().unRegisterListener(this.odn);
    }
}
