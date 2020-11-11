package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Build;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.dialog.BdToast;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaEndConnectionWheatHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaLinkCallBackHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.h;
/* loaded from: classes4.dex */
public class h {
    private static h oec;
    private TbPageContext ocV;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.h odA;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e oed;
    private boolean oee;
    private boolean oef;

    public static h dZp() {
        if (oec == null) {
            oec = new h();
        }
        return oec;
    }

    public void a(TbPageContext tbPageContext, AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
        if (tbPageContext != null && alaLinkCallBackHttpResponseMessage != null && alaLinkCallBackHttpResponseMessage.eai() && dZp().dZq()) {
            Activity pageActivity = tbPageContext.getPageActivity();
            if (Build.VERSION.SDK_INT >= 17) {
                if (pageActivity == null || pageActivity.isFinishing() || pageActivity.isDestroyed()) {
                    return;
                }
            } else if (pageActivity == null || pageActivity.isFinishing()) {
                return;
            }
            if (tbPageContext != null && tbPageContext != this.ocV) {
                this.ocV = tbPageContext;
                hide();
            }
            if (this.oed == null) {
                this.oee = false;
                this.oed = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e(tbPageContext);
                this.oed.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.h.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        h.this.oee = false;
                        h.this.oed = null;
                    }
                });
            }
            this.oed.show();
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                this.oed.c(currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), alaLinkCallBackHttpResponseMessage.eaj(), alaLinkCallBackHttpResponseMessage.cWL(), alaLinkCallBackHttpResponseMessage.eak());
            }
        }
    }

    public void a(TbPageContext tbPageContext, AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage) {
        if (tbPageContext != null && alaEndConnectionWheatHttpResponseMessage != null && alaEndConnectionWheatHttpResponseMessage.eai() && dZp().dZq()) {
            Activity pageActivity = tbPageContext.getPageActivity();
            if (Build.VERSION.SDK_INT >= 17) {
                if (pageActivity == null || pageActivity.isFinishing() || pageActivity.isDestroyed()) {
                    return;
                }
            } else if (pageActivity == null || pageActivity.isFinishing()) {
                return;
            }
            if (tbPageContext != null && tbPageContext != this.ocV) {
                this.ocV = tbPageContext;
                hide();
            }
            if (this.oed == null) {
                this.oee = false;
                this.oed = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e(tbPageContext);
                this.oed.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.h.2
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        h.this.oee = false;
                        h.this.oed = null;
                    }
                });
            }
            this.oed.show();
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                this.oed.c(currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), alaEndConnectionWheatHttpResponseMessage.eaj(), alaEndConnectionWheatHttpResponseMessage.cWL(), alaEndConnectionWheatHttpResponseMessage.eak());
            }
        }
    }

    public void za(boolean z) {
        this.oef = z;
        if (this.odA == null) {
            this.odA = new com.baidu.tieba.yuyinala.liveroom.wheat.model.h(null, new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.h.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.h.a
                public void a(AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
                    h.this.a(o.dZA().dZF(), alaLinkCallBackHttpResponseMessage);
                    if (h.this.oef) {
                        BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_hung_up_text)).show();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                    h.this.onDestroy();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.h.a
                public void b(AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                    h.this.onDestroy();
                }
            });
        }
        this.odA.request("end");
    }

    public void hide() {
        if (this.oed != null) {
            this.oed.dismiss();
            this.oed = null;
        }
    }

    public h zb(boolean z) {
        this.oee = z;
        return this;
    }

    public boolean dZq() {
        return this.oee;
    }

    public void onDestroy() {
        e.dZk().onDestroy();
    }
}
