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
import com.baidu.tieba.yuyinala.liveroom.wheat.model.i;
/* loaded from: classes11.dex */
public class h {
    private static h oBt;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.i oAR;
    private TbPageContext oAf;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e oBu;
    private boolean oBv;
    private boolean oBw;

    public static h eeU() {
        if (oBt == null) {
            oBt = new h();
        }
        return oBt;
    }

    public void a(TbPageContext tbPageContext, AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
        if (tbPageContext != null && alaLinkCallBackHttpResponseMessage != null && alaLinkCallBackHttpResponseMessage.efW() && eeU().eeV()) {
            Activity pageActivity = tbPageContext.getPageActivity();
            if (Build.VERSION.SDK_INT >= 17) {
                if (pageActivity == null || pageActivity.isFinishing() || pageActivity.isDestroyed()) {
                    return;
                }
            } else if (pageActivity == null || pageActivity.isFinishing()) {
                return;
            }
            if (tbPageContext != null && tbPageContext != this.oAf) {
                this.oAf = tbPageContext;
                hide();
            }
            if (this.oBu == null) {
                this.oBv = false;
                this.oBu = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e(tbPageContext);
                this.oBu.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.h.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        h.this.oBv = false;
                        h.this.oBu = null;
                    }
                });
            }
            this.oBu.show();
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                this.oBu.d(currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), alaLinkCallBackHttpResponseMessage.efX(), alaLinkCallBackHttpResponseMessage.dbh(), alaLinkCallBackHttpResponseMessage.efY());
            }
        }
    }

    public void a(TbPageContext tbPageContext, AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage) {
        if (tbPageContext != null && alaEndConnectionWheatHttpResponseMessage != null && alaEndConnectionWheatHttpResponseMessage.efW() && eeU().eeV()) {
            Activity pageActivity = tbPageContext.getPageActivity();
            if (Build.VERSION.SDK_INT >= 17) {
                if (pageActivity == null || pageActivity.isFinishing() || pageActivity.isDestroyed()) {
                    return;
                }
            } else if (pageActivity == null || pageActivity.isFinishing()) {
                return;
            }
            if (tbPageContext != null && tbPageContext != this.oAf) {
                this.oAf = tbPageContext;
                hide();
            }
            if (this.oBu == null) {
                this.oBv = false;
                this.oBu = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e(tbPageContext);
                this.oBu.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.h.2
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        h.this.oBv = false;
                        h.this.oBu = null;
                    }
                });
            }
            this.oBu.show();
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                this.oBu.d(currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), alaEndConnectionWheatHttpResponseMessage.efX(), alaEndConnectionWheatHttpResponseMessage.dbh(), alaEndConnectionWheatHttpResponseMessage.efY());
            }
        }
    }

    public void zN(boolean z) {
        this.oBw = z;
        if (o.eff().jm(o.eff().aar())) {
            if (this.oAR == null) {
                this.oAR = new com.baidu.tieba.yuyinala.liveroom.wheat.model.i(null, new i.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.h.3
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.i.a
                    public void a(AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
                        h.this.a(o.eff().efl(), alaLinkCallBackHttpResponseMessage);
                        if (h.this.oBw) {
                            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_hung_up_text)).show();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                        h.this.onDestroy();
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.i.a
                    public void b(AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                        h.this.onDestroy();
                    }
                });
            }
            this.oAR.request("end");
        }
    }

    public void hide() {
        if (this.oBu != null) {
            this.oBu.dismiss();
            this.oBu = null;
        }
    }

    public h zO(boolean z) {
        this.oBv = z;
        return this;
    }

    public boolean eeV() {
        return this.oBv;
    }

    public void onDestroy() {
        e.eeO().onDestroy();
    }
}
