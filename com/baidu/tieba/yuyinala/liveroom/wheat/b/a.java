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
    protected ab hfI;
    protected TbPageContext mPageContext;
    private d oFm;
    private HostConnectionWheatDialog oFn;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.b oFo;
    protected int ouf;
    protected int oug;
    private c oFk = new c();
    protected b oFl = new b();
    protected CustomMessageListener oFp = new CustomMessageListener(2501036) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501036) {
                a.this.ckq();
            }
        }
    };

    protected abstract void Wc(String str);

    protected abstract void Wd(String str);

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @CallSuper
    public void a(ab abVar, AlaWheatInfoData alaWheatInfoData, int i, int i2) {
        this.hfI = abVar;
        this.ccw = alaWheatInfoData;
        this.ouf = i;
        this.oug = i2;
    }

    public void ecS() {
        ecW();
        ecX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ecT() {
        return this.ouf == h.oGk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ecU() {
        return this.ouf == h.oGl;
    }

    private boolean ecV() {
        return this.ouf == h.oGm;
    }

    protected void ecW() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            return;
        }
        String loginUk = getLoginUk();
        if (!TextUtils.isEmpty(loginUk)) {
            if (ecV()) {
                Wc(loginUk);
            } else if (this.ccw == null) {
                Wd(loginUk);
            } else {
                We(loginUk);
            }
        }
    }

    protected void We(String str) {
        if (this.hfI != null && this.hfI.aIz != null) {
            if (TextUtils.equals(this.ccw.uk, str)) {
                this.oFl.a(this.mPageContext, this.hfI);
            } else {
                this.oFl.j(this.ccw);
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

    protected void ecX() {
        if (ecV()) {
            this.oFk.al(this.hfI);
        } else {
            this.oFk.a(this.ccw, this.oug);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ecY() {
        this.oFm = new d(this.mPageContext, this.oug);
        this.oFm.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.this.oFm = null;
            }
        });
        this.oFm.show();
        this.oFm.edF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ecZ() {
        this.oFn = new HostConnectionWheatDialog(this.mPageContext);
        this.oFn.Mz(this.oug);
        this.oFn.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.this.oFn = null;
            }
        });
        if (!this.oFn.isShowing()) {
            this.oFn.show();
        }
        this.oFn.mH(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingDialog(String str) {
        if (this.oFo == null) {
            this.oFo = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.b(this.mPageContext.getPageActivity());
        }
        this.oFo.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.this.oFo = null;
            }
        });
        if (!this.oFo.isShowing()) {
            this.oFo.show();
        }
        this.oFo.setTipString(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckq() {
        if (this.oFo != null) {
            this.oFo.dismiss();
            this.oFo = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eda() {
        com.baidu.tieba.yuyinala.liveroom.wheat.c.c.edg().a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.5
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
            public void ddr() {
                com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("start_connection_wheat_host_1", true);
                a.this.showLoadingDialog(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connecting_wheat_text_3));
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
            public void edc() {
                SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                    }
                });
            }
        }).a(this.mPageContext.getPageActivity(), this.mPageContext.getPageActivity(), "1", "0");
        MessageManager.getInstance().unRegisterListener(this.oFp);
        MessageManager.getInstance().registerListener(this.oFp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void edb() {
        showLoadingDialog(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_switch_text));
        new m(null, new m.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.6
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.m.a
            public void a(AlaWheatSwitchHttpResponseMessage alaWheatSwitchHttpResponseMessage) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                a.this.ckq();
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.m.a
            public void b(AlaWheatSwitchHttpResponseMessage alaWheatSwitchHttpResponseMessage) {
                a.this.ckq();
            }
        }).gY(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ym(), Integer.toString(q.edE().edJ() + 1));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showToast(int i) {
        BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(i)).show();
    }

    public void onDestory() {
        if (this.oFm != null) {
            this.oFm = null;
        }
        if (this.oFn != null) {
            this.oFn = null;
        }
        if (this.oFo != null) {
            this.oFo = null;
        }
        MessageManager.getInstance().unRegisterListener(this.oFp);
    }
}
