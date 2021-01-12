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
    private static h owN;
    private TbPageContext ovz;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e owO;
    private boolean owP;
    private boolean owQ;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.i owl;

    public static h ebd() {
        if (owN == null) {
            owN = new h();
        }
        return owN;
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
            if (tbPageContext != null && tbPageContext != this.ovz) {
                this.ovz = tbPageContext;
                hide();
            }
            if (this.owO == null) {
                this.owP = false;
                this.owO = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e(tbPageContext);
                this.owO.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.h.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        h.this.owP = false;
                        h.this.owO = null;
                    }
                });
            }
            this.owO.show();
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                this.owO.d(currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), alaLinkCallBackHttpResponseMessage.ecg(), alaLinkCallBackHttpResponseMessage.cXq(), alaLinkCallBackHttpResponseMessage.ech());
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
            if (tbPageContext != null && tbPageContext != this.ovz) {
                this.ovz = tbPageContext;
                hide();
            }
            if (this.owO == null) {
                this.owP = false;
                this.owO = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e(tbPageContext);
                this.owO.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.h.2
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        h.this.owP = false;
                        h.this.owO = null;
                    }
                });
            }
            this.owO.show();
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                this.owO.d(currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), alaEndConnectionWheatHttpResponseMessage.ecg(), alaEndConnectionWheatHttpResponseMessage.cXq(), alaEndConnectionWheatHttpResponseMessage.ech());
            }
        }
    }

    public void zJ(boolean z) {
        this.owQ = z;
        if (o.ebo().ib(o.ebo().Wz())) {
            if (this.owl == null) {
                this.owl = new com.baidu.tieba.yuyinala.liveroom.wheat.model.i(null, new i.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.h.3
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.i.a
                    public void a(AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
                        h.this.a(o.ebo().ebu(), alaLinkCallBackHttpResponseMessage);
                        if (h.this.owQ) {
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
            this.owl.request("end");
        }
    }

    public void hide() {
        if (this.owO != null) {
            this.owO.dismiss();
            this.owO = null;
        }
    }

    public h zK(boolean z) {
        this.owP = z;
        return this;
    }

    public boolean ebe() {
        return this.owP;
    }

    public void onDestroy() {
        e.eaX().onDestroy();
    }
}
