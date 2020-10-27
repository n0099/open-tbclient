package com.baidu.tieba.yuyinala.liveroom.wheat.b;

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
import com.baidu.tieba.yuyinala.liveroom.wheat.c.h;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaEndConnectionWheatHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaLinkCallBackHttpResponseMessage;
/* loaded from: classes4.dex */
public class g {
    private static g nWD;
    private TbPageContext nVE;
    private com.baidu.tieba.yuyinala.liveroom.wheat.c.h nVZ;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e nWE;
    private boolean nWF;
    private boolean nWG;

    public static g dWq() {
        if (nWD == null) {
            nWD = new g();
        }
        return nWD;
    }

    public void a(TbPageContext tbPageContext, AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
        if (tbPageContext != null && alaLinkCallBackHttpResponseMessage != null && alaLinkCallBackHttpResponseMessage.dWY() && dWq().dWr()) {
            Activity pageActivity = tbPageContext.getPageActivity();
            if (Build.VERSION.SDK_INT >= 17) {
                if (pageActivity == null || pageActivity.isFinishing() || pageActivity.isDestroyed()) {
                    return;
                }
            } else if (pageActivity == null || pageActivity.isFinishing()) {
                return;
            }
            if (tbPageContext != null && tbPageContext != this.nVE) {
                this.nVE = tbPageContext;
                hide();
            }
            if (this.nWE == null) {
                this.nWF = false;
                this.nWE = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e(tbPageContext);
                this.nWE.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.g.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        g.this.nWF = false;
                        g.this.nWE = null;
                    }
                });
            }
            this.nWE.show();
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                this.nWE.c(currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), alaLinkCallBackHttpResponseMessage.dWZ(), alaLinkCallBackHttpResponseMessage.cUk(), alaLinkCallBackHttpResponseMessage.dXa());
            }
        }
    }

    public void a(TbPageContext tbPageContext, AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage) {
        if (tbPageContext != null && alaEndConnectionWheatHttpResponseMessage != null && alaEndConnectionWheatHttpResponseMessage.dWY() && dWq().dWr()) {
            Activity pageActivity = tbPageContext.getPageActivity();
            if (Build.VERSION.SDK_INT >= 17) {
                if (pageActivity == null || pageActivity.isFinishing() || pageActivity.isDestroyed()) {
                    return;
                }
            } else if (pageActivity == null || pageActivity.isFinishing()) {
                return;
            }
            if (tbPageContext != null && tbPageContext != this.nVE) {
                this.nVE = tbPageContext;
                hide();
            }
            if (this.nWE == null) {
                this.nWF = false;
                this.nWE = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e(tbPageContext);
                this.nWE.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.g.2
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        g.this.nWF = false;
                        g.this.nWE = null;
                    }
                });
            }
            this.nWE.show();
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                this.nWE.c(currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), alaEndConnectionWheatHttpResponseMessage.dWZ(), alaEndConnectionWheatHttpResponseMessage.cUk(), alaEndConnectionWheatHttpResponseMessage.dXa());
            }
        }
    }

    public void yS(boolean z) {
        this.nWG = z;
        if (this.nVZ == null) {
            this.nVZ = new com.baidu.tieba.yuyinala.liveroom.wheat.c.h(null, new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.g.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.h.a
                public void a(AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
                    g.this.a(n.dWB().dWK(), alaLinkCallBackHttpResponseMessage);
                    if (g.this.nWG) {
                        BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.i.yuyin_ala_connection_wheat_hung_up_text)).show();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                    g.this.onDestroy();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.h.a
                public void b(AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                    g.this.onDestroy();
                }
            });
        }
        this.nVZ.request("end");
    }

    public void hide() {
        if (this.nWE != null) {
            this.nWE.dismiss();
            this.nWE = null;
        }
    }

    public g yT(boolean z) {
        this.nWF = z;
        return this;
    }

    public boolean dWr() {
        return this.nWF;
    }

    public void onDestroy() {
        e.dWm().onDestroy();
    }
}
