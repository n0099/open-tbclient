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
    private static h ouI;
    private TbPageContext otA;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e ouJ;
    private boolean ouK;
    private boolean ouL;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.h ouf;

    public static h eeT() {
        if (ouI == null) {
            ouI = new h();
        }
        return ouI;
    }

    public void a(TbPageContext tbPageContext, AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
        if (tbPageContext != null && alaLinkCallBackHttpResponseMessage != null && alaLinkCallBackHttpResponseMessage.efN() && eeT().eeU()) {
            Activity pageActivity = tbPageContext.getPageActivity();
            if (Build.VERSION.SDK_INT >= 17) {
                if (pageActivity == null || pageActivity.isFinishing() || pageActivity.isDestroyed()) {
                    return;
                }
            } else if (pageActivity == null || pageActivity.isFinishing()) {
                return;
            }
            if (tbPageContext != null && tbPageContext != this.otA) {
                this.otA = tbPageContext;
                hide();
            }
            if (this.ouJ == null) {
                this.ouK = false;
                this.ouJ = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e(tbPageContext);
                this.ouJ.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.h.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        h.this.ouK = false;
                        h.this.ouJ = null;
                    }
                });
            }
            this.ouJ.show();
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                this.ouJ.c(currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), alaLinkCallBackHttpResponseMessage.efO(), alaLinkCallBackHttpResponseMessage.dbE(), alaLinkCallBackHttpResponseMessage.efP());
            }
        }
    }

    public void a(TbPageContext tbPageContext, AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage) {
        if (tbPageContext != null && alaEndConnectionWheatHttpResponseMessage != null && alaEndConnectionWheatHttpResponseMessage.efN() && eeT().eeU()) {
            Activity pageActivity = tbPageContext.getPageActivity();
            if (Build.VERSION.SDK_INT >= 17) {
                if (pageActivity == null || pageActivity.isFinishing() || pageActivity.isDestroyed()) {
                    return;
                }
            } else if (pageActivity == null || pageActivity.isFinishing()) {
                return;
            }
            if (tbPageContext != null && tbPageContext != this.otA) {
                this.otA = tbPageContext;
                hide();
            }
            if (this.ouJ == null) {
                this.ouK = false;
                this.ouJ = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e(tbPageContext);
                this.ouJ.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.h.2
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        h.this.ouK = false;
                        h.this.ouJ = null;
                    }
                });
            }
            this.ouJ.show();
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                this.ouJ.c(currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), alaEndConnectionWheatHttpResponseMessage.efO(), alaEndConnectionWheatHttpResponseMessage.dbE(), alaEndConnectionWheatHttpResponseMessage.efP());
            }
        }
    }

    public void zL(boolean z) {
        this.ouL = z;
        if (this.ouf == null) {
            this.ouf = new com.baidu.tieba.yuyinala.liveroom.wheat.model.h(null, new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.h.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.h.a
                public void a(AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
                    h.this.a(o.efe().efj(), alaLinkCallBackHttpResponseMessage);
                    if (h.this.ouL) {
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
        this.ouf.request("end");
    }

    public void hide() {
        if (this.ouJ != null) {
            this.ouJ.dismiss();
            this.ouJ = null;
        }
    }

    public h zM(boolean z) {
        this.ouK = z;
        return this;
    }

    public boolean eeU() {
        return this.ouK;
    }

    public void onDestroy() {
        e.eeO().onDestroy();
    }
}
