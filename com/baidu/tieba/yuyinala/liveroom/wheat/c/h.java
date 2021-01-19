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
/* loaded from: classes10.dex */
public class h {
    private static h owO;
    private TbPageContext ovA;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e owP;
    private boolean owQ;
    private boolean owR;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.i owm;

    public static h ebd() {
        if (owO == null) {
            owO = new h();
        }
        return owO;
    }

    public void a(TbPageContext tbPageContext, AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
        if (tbPageContext != null && alaLinkCallBackHttpResponseMessage != null && alaLinkCallBackHttpResponseMessage.ecf() && ebd().ebe()) {
            Activity pageActivity = tbPageContext.getPageActivity();
            if (Build.VERSION.SDK_INT >= 17) {
                if (pageActivity == null || pageActivity.isFinishing() || pageActivity.isDestroyed()) {
                    return;
                }
            } else if (pageActivity == null || pageActivity.isFinishing()) {
                return;
            }
            if (tbPageContext != null && tbPageContext != this.ovA) {
                this.ovA = tbPageContext;
                hide();
            }
            if (this.owP == null) {
                this.owQ = false;
                this.owP = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e(tbPageContext);
                this.owP.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.h.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        h.this.owQ = false;
                        h.this.owP = null;
                    }
                });
            }
            this.owP.show();
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                this.owP.d(currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), alaLinkCallBackHttpResponseMessage.ecg(), alaLinkCallBackHttpResponseMessage.cXq(), alaLinkCallBackHttpResponseMessage.ech());
            }
        }
    }

    public void a(TbPageContext tbPageContext, AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage) {
        if (tbPageContext != null && alaEndConnectionWheatHttpResponseMessage != null && alaEndConnectionWheatHttpResponseMessage.ecf() && ebd().ebe()) {
            Activity pageActivity = tbPageContext.getPageActivity();
            if (Build.VERSION.SDK_INT >= 17) {
                if (pageActivity == null || pageActivity.isFinishing() || pageActivity.isDestroyed()) {
                    return;
                }
            } else if (pageActivity == null || pageActivity.isFinishing()) {
                return;
            }
            if (tbPageContext != null && tbPageContext != this.ovA) {
                this.ovA = tbPageContext;
                hide();
            }
            if (this.owP == null) {
                this.owQ = false;
                this.owP = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e(tbPageContext);
                this.owP.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.h.2
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        h.this.owQ = false;
                        h.this.owP = null;
                    }
                });
            }
            this.owP.show();
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                this.owP.d(currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), alaEndConnectionWheatHttpResponseMessage.ecg(), alaEndConnectionWheatHttpResponseMessage.cXq(), alaEndConnectionWheatHttpResponseMessage.ech());
            }
        }
    }

    public void zJ(boolean z) {
        this.owR = z;
        if (o.ebo().ib(o.ebo().Wz())) {
            if (this.owm == null) {
                this.owm = new com.baidu.tieba.yuyinala.liveroom.wheat.model.i(null, new i.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.h.3
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.i.a
                    public void a(AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
                        h.this.a(o.ebo().ebu(), alaLinkCallBackHttpResponseMessage);
                        if (h.this.owR) {
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
            this.owm.request("end");
        }
    }

    public void hide() {
        if (this.owP != null) {
            this.owP.dismiss();
            this.owP = null;
        }
    }

    public h zK(boolean z) {
        this.owQ = z;
        return this;
    }

    public boolean ebe() {
        return this.owQ;
    }

    public void onDestroy() {
        e.eaX().onDestroy();
    }
}
