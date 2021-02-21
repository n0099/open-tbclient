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
/* loaded from: classes11.dex */
public abstract class a {
    protected AlaWheatInfoData ccw;
    protected ab hfW;
    protected TbPageContext mPageContext;
    private d oFM;
    private HostConnectionWheatDialog oFN;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.b oFO;
    protected int ouG;
    protected int ouH;
    private c oFK = new c();
    protected b oFL = new b();
    protected CustomMessageListener oFP = new CustomMessageListener(2501036) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501036) {
                a.this.ckx();
            }
        }
    };

    protected abstract void Wo(String str);

    protected abstract void Wp(String str);

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @CallSuper
    public void a(ab abVar, AlaWheatInfoData alaWheatInfoData, int i, int i2) {
        this.hfW = abVar;
        this.ccw = alaWheatInfoData;
        this.ouG = i;
        this.ouH = i2;
    }

    public void eda() {
        ede();
        edf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean edb() {
        return this.ouG == h.oGK;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean edc() {
        return this.ouG == h.oGL;
    }

    private boolean edd() {
        return this.ouG == h.oGM;
    }

    protected void ede() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            return;
        }
        String loginUk = getLoginUk();
        if (!TextUtils.isEmpty(loginUk)) {
            if (edd()) {
                Wo(loginUk);
            } else if (this.ccw == null) {
                Wp(loginUk);
            } else {
                Wq(loginUk);
            }
        }
    }

    protected void Wq(String str) {
        if (this.hfW != null && this.hfW.aIz != null) {
            if (TextUtils.equals(this.ccw.uk, str)) {
                this.oFL.a(this.mPageContext, this.hfW);
            } else {
                this.oFL.j(this.ccw);
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

    protected void edf() {
        if (edd()) {
            this.oFK.al(this.hfW);
        } else {
            this.oFK.a(this.ccw, this.ouH);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void edg() {
        this.oFM = new d(this.mPageContext, this.ouH);
        this.oFM.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.this.oFM = null;
            }
        });
        this.oFM.show();
        this.oFM.edN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void edh() {
        this.oFN = new HostConnectionWheatDialog(this.mPageContext);
        this.oFN.MA(this.ouH);
        this.oFN.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.this.oFN = null;
            }
        });
        if (!this.oFN.isShowing()) {
            this.oFN.show();
        }
        this.oFN.mH(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingDialog(String str) {
        if (this.oFO == null) {
            this.oFO = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.b(this.mPageContext.getPageActivity());
        }
        this.oFO.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.this.oFO = null;
            }
        });
        if (!this.oFO.isShowing()) {
            this.oFO.show();
        }
        this.oFO.setTipString(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckx() {
        if (this.oFO != null) {
            this.oFO.dismiss();
            this.oFO = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void edi() {
        com.baidu.tieba.yuyinala.liveroom.wheat.c.c.edo().a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.5
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
            public void ddy() {
                com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("start_connection_wheat_host_1", true);
                a.this.showLoadingDialog(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connecting_wheat_text_3));
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
            public void edk() {
                SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                    }
                });
            }
        }).a(this.mPageContext.getPageActivity(), this.mPageContext.getPageActivity(), "1", "0");
        MessageManager.getInstance().unRegisterListener(this.oFP);
        MessageManager.getInstance().registerListener(this.oFP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void edj() {
        showLoadingDialog(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_switch_text));
        new m(null, new m.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.6
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.m.a
            public void a(AlaWheatSwitchHttpResponseMessage alaWheatSwitchHttpResponseMessage) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                a.this.ckx();
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.m.a
            public void b(AlaWheatSwitchHttpResponseMessage alaWheatSwitchHttpResponseMessage) {
                a.this.ckx();
            }
        }).ha(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ym(), Integer.toString(q.edM().edR() + 1));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showToast(int i) {
        BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(i)).show();
    }

    public void onDestory() {
        if (this.oFM != null) {
            this.oFM = null;
        }
        if (this.oFN != null) {
            this.oFN = null;
        }
        if (this.oFO != null) {
            this.oFO = null;
        }
        MessageManager.getInstance().unRegisterListener(this.oFP);
    }
}
