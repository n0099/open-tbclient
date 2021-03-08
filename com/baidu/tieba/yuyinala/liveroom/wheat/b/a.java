package com.baidu.tieba.yuyinala.liveroom.wheat.b;

import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.CallSuper;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.dialog.BdToast;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.c;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.h;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.q;
import com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog;
import com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaWheatSwitchHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.m;
/* loaded from: classes10.dex */
public abstract class a {
    protected AlaWheatInfoData cdY;
    protected ab hhF;
    protected TbPageContext mPageContext;
    private d oHR;
    private HostConnectionWheatDialog oHS;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.b oHT;
    protected int owL;
    protected int owM;
    private c oHP = new c();
    protected b oHQ = new b();
    protected CustomMessageListener oHU = new CustomMessageListener(2501036) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501036) {
                a.this.ckD();
            }
        }
    };

    protected abstract void Wv(String str);

    protected abstract void Ww(String str);

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @CallSuper
    public void a(ab abVar, AlaWheatInfoData alaWheatInfoData, int i, int i2) {
        this.hhF = abVar;
        this.cdY = alaWheatInfoData;
        this.owL = i;
        this.owM = i2;
    }

    public void edi() {
        edm();
        edn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean edj() {
        return this.owL == h.oIP;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean edk() {
        return this.owL == h.oIQ;
    }

    private boolean edl() {
        return this.owL == h.oIR;
    }

    protected void edm() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            return;
        }
        String loginUk = getLoginUk();
        if (!TextUtils.isEmpty(loginUk)) {
            if (edl()) {
                Wv(loginUk);
            } else if (this.cdY == null) {
                Ww(loginUk);
            } else {
                Wx(loginUk);
            }
        }
    }

    protected void Wx(String str) {
        if (this.hhF != null && this.hhF.aJZ != null) {
            if (TextUtils.equals(this.cdY.uk, str)) {
                this.oHQ.a(this.mPageContext, this.hhF);
            } else {
                this.oHQ.j(this.cdY);
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

    protected void edn() {
        if (edl()) {
            this.oHP.al(this.hhF);
        } else {
            this.oHP.a(this.cdY, this.owM);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void edo() {
        this.oHR = new d(this.mPageContext, this.owM);
        this.oHR.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.this.oHR = null;
            }
        });
        this.oHR.show();
        this.oHR.edV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void edp() {
        this.oHS = new HostConnectionWheatDialog(this.mPageContext);
        this.oHS.ME(this.owM);
        this.oHS.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.this.oHS = null;
            }
        });
        if (!this.oHS.isShowing()) {
            this.oHS.show();
        }
        this.oHS.mH(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingDialog(String str) {
        if (this.oHT == null) {
            this.oHT = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.b(this.mPageContext.getPageActivity());
        }
        this.oHT.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.this.oHT = null;
            }
        });
        if (!this.oHT.isShowing()) {
            this.oHT.show();
        }
        this.oHT.setTipString(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckD() {
        if (this.oHT != null) {
            this.oHT.dismiss();
            this.oHT = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void edq() {
        com.baidu.tieba.yuyinala.liveroom.wheat.c.c.edw().a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.5
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
            public void ddH() {
                com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("start_connection_wheat_host_1", true);
                a.this.showLoadingDialog(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connecting_wheat_text_3));
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
            public void eds() {
                SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                    }
                });
            }
        }).a(this.mPageContext.getPageActivity(), this.mPageContext.getPageActivity(), "1", "0");
        MessageManager.getInstance().unRegisterListener(this.oHU);
        MessageManager.getInstance().registerListener(this.oHU);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void edr() {
        showLoadingDialog(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_switch_text));
        new m(null, new m.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.6
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.m.a
            public void a(AlaWheatSwitchHttpResponseMessage alaWheatSwitchHttpResponseMessage) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                a.this.ckD();
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.m.a
            public void b(AlaWheatSwitchHttpResponseMessage alaWheatSwitchHttpResponseMessage) {
                a.this.ckD();
            }
        }).ha(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().yp(), Integer.toString(q.edU().edZ() + 1));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showToast(int i) {
        BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(i)).show();
    }

    public void onDestory() {
        if (this.oHR != null) {
            this.oHR = null;
        }
        if (this.oHS != null) {
            this.oHS = null;
        }
        if (this.oHT != null) {
            this.oHT = null;
        }
        MessageManager.getInstance().unRegisterListener(this.oHU);
    }
}
