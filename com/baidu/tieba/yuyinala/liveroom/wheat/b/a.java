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
    private d oAA;
    private HostConnectionWheatDialog oAB;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.b oAC;
    protected int ooS;
    protected int ooT;
    private c oAy = new c();
    protected b oAz = new b();
    protected CustomMessageListener oAD = new CustomMessageListener(2501036) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501036) {
                a.this.cnj();
            }
        }
    };

    protected abstract void Wm(String str);

    protected abstract void Wn(String str);

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @CallSuper
    public void a(x xVar, AlaWheatInfoData alaWheatInfoData, int i, int i2) {
        this.hhF = xVar;
        this.cdg = alaWheatInfoData;
        this.ooS = i;
        this.ooT = i2;
    }

    public void eey() {
        eeC();
        eeD();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean eez() {
        return this.ooS == g.oBp;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean eeA() {
        return this.ooS == g.oBq;
    }

    private boolean eeB() {
        return this.ooS == g.oBr;
    }

    protected void eeC() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            return;
        }
        String loginUk = getLoginUk();
        if (!TextUtils.isEmpty(loginUk)) {
            if (eeB()) {
                Wm(loginUk);
            } else if (this.cdg == null) {
                Wn(loginUk);
            } else {
                Wo(loginUk);
            }
        }
    }

    protected void Wo(String str) {
        if (this.hhF != null && this.hhF.aKQ != null) {
            if (TextUtils.equals(this.cdg.uk, str)) {
                this.oAz.a(this.mPageContext, this.hhF);
            } else {
                this.oAz.j(this.cdg);
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

    protected void eeD() {
        if (eeB()) {
            this.oAy.al(this.hhF);
        } else {
            this.oAy.a(this.cdg, this.ooT);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eeE() {
        this.oAA = new d(this.mPageContext, this.ooT);
        this.oAA.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.this.oAA = null;
            }
        });
        this.oAA.show();
        this.oAA.efh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eeF() {
        this.oAB = new HostConnectionWheatDialog(this.mPageContext);
        this.oAB.NK(this.ooT);
        this.oAB.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.this.oAB = null;
            }
        });
        if (!this.oAB.isShowing()) {
            this.oAB.show();
        }
        this.oAB.mH(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingDialog(String str) {
        if (this.oAC == null) {
            this.oAC = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.b(this.mPageContext.getPageActivity());
        }
        this.oAC.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.this.oAC = null;
            }
        });
        if (!this.oAC.isShowing()) {
            this.oAC.show();
        }
        this.oAC.setTipString(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnj() {
        if (this.oAC != null) {
            this.oAC.dismiss();
            this.oAC = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eeG() {
        com.baidu.tieba.yuyinala.liveroom.wheat.c.c.eeN().a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.5
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
            public void dfl() {
                com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("start_connection_wheat_host_1", true);
                a.this.showLoadingDialog(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connecting_wheat_text_3));
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
            public void eeI() {
                SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                    }
                });
            }
        }).a(this.mPageContext.getPageActivity(), this.mPageContext.getPageActivity(), "1", "0");
        MessageManager.getInstance().unRegisterListener(this.oAD);
        MessageManager.getInstance().registerListener(this.oAD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eeH() {
        showLoadingDialog(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_switch_text));
        new l(null, new l.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.6
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.l.a
            public void a(AlaWheatSwitchHttpResponseMessage alaWheatSwitchHttpResponseMessage) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                a.this.cnj();
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.l.a
            public void b(AlaWheatSwitchHttpResponseMessage alaWheatSwitchHttpResponseMessage) {
                a.this.cnj();
            }
        }).gS(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().Cq(), Integer.toString(o.efg().efl() + 1));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showToast(int i) {
        BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(i)).show();
    }

    public void onDestory() {
        if (this.oAA != null) {
            this.oAA = null;
        }
        if (this.oAB != null) {
            this.oAB = null;
        }
        if (this.oAC != null) {
            this.oAC = null;
        }
        MessageManager.getInstance().unRegisterListener(this.oAD);
    }
}
