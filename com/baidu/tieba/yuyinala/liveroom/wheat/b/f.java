package com.baidu.tieba.yuyinala.liveroom.wheat.b;

import android.content.DialogInterface;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.dialog.BdToast;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.tieba.yuyinala.liveroom.wheat.b.c;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.k;
import com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaWheatSwitchHttpResponseMessage;
/* loaded from: classes4.dex */
public class f {
    public static int nWt = 0;
    public static int nWu = 1;
    public static int nWv = 2;
    public static int nWw = 3;
    private final w alaLiveShowData;
    private TbPageContext nVE;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d nWx;
    private HostConnectionWheatDialog nWy;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.b nWz;
    public int clickType = nWt;
    private CustomMessageListener nWA = new CustomMessageListener(2501036) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.f.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501036) {
                f.this.ceD();
            }
        }
    };

    public f(TbPageContext tbPageContext, w wVar) {
        this.nVE = tbPageContext;
        this.alaLiveShowData = wVar;
    }

    public void show() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            String encryptionUserId = ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID());
            if (this.clickType == nWw) {
                if (n.dWB().dWd()) {
                    dWp();
                } else if (n.dWB().isHost() && n.dWB().iI(encryptionUserId)) {
                    dWp();
                } else if (n.dWB().iI(encryptionUserId)) {
                    e.dWm().h(this.nVE);
                } else {
                    dWo();
                }
            } else if (this.clickType == nWu) {
                if (n.dWB().Vt(encryptionUserId)) {
                    BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.i.yuyin_ala_on_wheat_text)).show();
                    return;
                }
                c.dWj().a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.f.1
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.c.a
                    public void cYn() {
                        com.baidu.tieba.yuyinala.liveroom.wheat.d.d.bh("start_connection_wheat_host_1", true);
                        f.this.showLoadingDialog(TbadkCoreApplication.getInst().getString(a.i.yuyin_ala_connecting_wheat_text_3));
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.c.a
                    public void dWk() {
                        SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.f.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                            }
                        });
                    }
                }).a(this.nVE.getPageActivity(), this.nVE.getPageActivity(), "1");
                MessageManager.getInstance().registerListener(this.nWA);
            } else if (this.clickType == nWv) {
                if (n.dWB().iK(encryptionUserId)) {
                    BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.i.yuyin_ala_on_wheat_text)).show();
                } else if (n.dWB().Vt(encryptionUserId)) {
                    showLoadingDialog(TbadkCoreApplication.getInst().getString(a.i.yuyin_ala_connection_wheat_switch_text));
                    new com.baidu.tieba.yuyinala.liveroom.wheat.c.k(null, new k.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.f.2
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                        public void a(AlaWheatSwitchHttpResponseMessage alaWheatSwitchHttpResponseMessage) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                            f.this.ceD();
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                        public void b(AlaWheatSwitchHttpResponseMessage alaWheatSwitchHttpResponseMessage) {
                            f.this.ceD();
                        }
                    }).gN(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dWa(), Integer.toString(n.dWB().dWJ() + 1));
                } else if (n.dWB().dWd()) {
                    dWp();
                } else {
                    dWo();
                }
            }
        }
    }

    private void dWo() {
        this.nWx = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d(this.nVE);
        this.nWx.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.f.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                f.this.nWx = null;
            }
        });
        this.nWx.show();
        this.nWx.dWC();
    }

    private void dWp() {
        this.nWy = new HostConnectionWheatDialog(this.nVE);
        this.nWy.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.f.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                f.this.nWy = null;
            }
        });
        if (!this.nWy.isShowing()) {
            this.nWy.show();
        }
        this.nWy.lF(true);
    }

    public void setClickType(int i) {
        this.clickType = i;
    }

    public void showLoadingDialog(String str) {
        if (this.nWz == null) {
            this.nWz = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.b(this.nVE.getPageActivity());
        }
        this.nWz.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.f.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                f.this.nWz = null;
            }
        });
        if (!this.nWz.isShowing()) {
            this.nWz.show();
        }
        this.nWz.setTipString(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceD() {
        if (this.nWz != null) {
            this.nWz.dismiss();
            this.nWz = null;
        }
    }

    public void onDestroy() {
        if (this.nWx != null) {
            this.nWx = null;
        }
        if (this.nWy != null) {
            this.nWy = null;
        }
        if (this.nWz != null) {
            this.nWz = null;
        }
        e.dWm().onDestroy();
        MessageManager.getInstance().unRegisterListener(this.nWA);
    }
}
