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
    private static h oBs;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.i oAQ;
    private TbPageContext oAe;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e oBt;
    private boolean oBu;
    private boolean oBv;

    public static h eeV() {
        if (oBs == null) {
            oBs = new h();
        }
        return oBs;
    }

    public void a(TbPageContext tbPageContext, AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
        if (tbPageContext != null && alaLinkCallBackHttpResponseMessage != null && alaLinkCallBackHttpResponseMessage.efX() && eeV().eeW()) {
            Activity pageActivity = tbPageContext.getPageActivity();
            if (Build.VERSION.SDK_INT >= 17) {
                if (pageActivity == null || pageActivity.isFinishing() || pageActivity.isDestroyed()) {
                    return;
                }
            } else if (pageActivity == null || pageActivity.isFinishing()) {
                return;
            }
            if (tbPageContext != null && tbPageContext != this.oAe) {
                this.oAe = tbPageContext;
                hide();
            }
            if (this.oBt == null) {
                this.oBu = false;
                this.oBt = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e(tbPageContext);
                this.oBt.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.h.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        h.this.oBu = false;
                        h.this.oBt = null;
                    }
                });
            }
            this.oBt.show();
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                this.oBt.d(currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), alaLinkCallBackHttpResponseMessage.efY(), alaLinkCallBackHttpResponseMessage.dbi(), alaLinkCallBackHttpResponseMessage.efZ());
            }
        }
    }

    public void a(TbPageContext tbPageContext, AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage) {
        if (tbPageContext != null && alaEndConnectionWheatHttpResponseMessage != null && alaEndConnectionWheatHttpResponseMessage.efX() && eeV().eeW()) {
            Activity pageActivity = tbPageContext.getPageActivity();
            if (Build.VERSION.SDK_INT >= 17) {
                if (pageActivity == null || pageActivity.isFinishing() || pageActivity.isDestroyed()) {
                    return;
                }
            } else if (pageActivity == null || pageActivity.isFinishing()) {
                return;
            }
            if (tbPageContext != null && tbPageContext != this.oAe) {
                this.oAe = tbPageContext;
                hide();
            }
            if (this.oBt == null) {
                this.oBu = false;
                this.oBt = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e(tbPageContext);
                this.oBt.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.h.2
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        h.this.oBu = false;
                        h.this.oBt = null;
                    }
                });
            }
            this.oBt.show();
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                this.oBt.d(currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), alaEndConnectionWheatHttpResponseMessage.efY(), alaEndConnectionWheatHttpResponseMessage.dbi(), alaEndConnectionWheatHttpResponseMessage.efZ());
            }
        }
    }

    public void zN(boolean z) {
        this.oBv = z;
        if (o.efg().jm(o.efg().aas())) {
            if (this.oAQ == null) {
                this.oAQ = new com.baidu.tieba.yuyinala.liveroom.wheat.model.i(null, new i.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.h.3
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.i.a
                    public void a(AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
                        h.this.a(o.efg().efm(), alaLinkCallBackHttpResponseMessage);
                        if (h.this.oBv) {
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
            this.oAQ.request("end");
        }
    }

    public void hide() {
        if (this.oBt != null) {
            this.oBt.dismiss();
            this.oBt = null;
        }
    }

    public h zO(boolean z) {
        this.oBu = z;
        return this;
    }

    public boolean eeW() {
        return this.oBu;
    }

    public void onDestroy() {
        e.eeP().onDestroy();
    }
}
