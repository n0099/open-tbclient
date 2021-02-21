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
import com.baidu.tieba.yuyinala.liveroom.wheat.model.j;
/* loaded from: classes11.dex */
public class i {
    private static i oGN;
    private TbPageContext oGE;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e oGO;
    private boolean oGP;
    private boolean oGQ;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.j oGd;

    public static i edx() {
        if (oGN == null) {
            oGN = new i();
        }
        return oGN;
    }

    public void a(TbPageContext tbPageContext, AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
        if (tbPageContext != null && alaLinkCallBackHttpResponseMessage != null && alaLinkCallBackHttpResponseMessage.eeB() && edx().edy()) {
            Activity pageActivity = tbPageContext.getPageActivity();
            if (Build.VERSION.SDK_INT >= 17) {
                if (pageActivity == null || pageActivity.isFinishing() || pageActivity.isDestroyed()) {
                    return;
                }
            } else if (pageActivity == null || pageActivity.isFinishing()) {
                return;
            }
            if (tbPageContext != null && tbPageContext != this.oGE) {
                this.oGE = tbPageContext;
                hide();
            }
            if (this.oGO == null) {
                this.oGP = false;
                this.oGO = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e(tbPageContext);
                this.oGO.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.i.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        i.this.oGP = false;
                        i.this.oGO = null;
                    }
                });
            }
            this.oGO.show();
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                this.oGO.d(currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), alaLinkCallBackHttpResponseMessage.eeC(), alaLinkCallBackHttpResponseMessage.cZv(), alaLinkCallBackHttpResponseMessage.eeD());
            }
        }
    }

    public void a(TbPageContext tbPageContext, AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage) {
        if (tbPageContext != null && alaEndConnectionWheatHttpResponseMessage != null && alaEndConnectionWheatHttpResponseMessage.eeB() && edx().edy()) {
            Activity pageActivity = tbPageContext.getPageActivity();
            if (Build.VERSION.SDK_INT >= 17) {
                if (pageActivity == null || pageActivity.isFinishing() || pageActivity.isDestroyed()) {
                    return;
                }
            } else if (pageActivity == null || pageActivity.isFinishing()) {
                return;
            }
            if (tbPageContext != null && tbPageContext != this.oGE) {
                this.oGE = tbPageContext;
                hide();
            }
            if (this.oGO == null) {
                this.oGP = false;
                this.oGO = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e(tbPageContext);
                this.oGO.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.i.2
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        i.this.oGP = false;
                        i.this.oGO = null;
                    }
                });
            }
            this.oGO.show();
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                this.oGO.d(currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), alaEndConnectionWheatHttpResponseMessage.eeC(), alaEndConnectionWheatHttpResponseMessage.cZv(), alaEndConnectionWheatHttpResponseMessage.eeD());
            }
        }
    }

    public void Ac(boolean z) {
        this.oGQ = z;
        if (q.edM().iH(q.edM().Yp())) {
            if (this.oGd == null) {
                this.oGd = new com.baidu.tieba.yuyinala.liveroom.wheat.model.j(null, new j.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.i.3
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.j.a
                    public void a(AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
                        i.this.a(q.edM().edS(), alaLinkCallBackHttpResponseMessage);
                        if (i.this.oGQ) {
                            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_hung_up_text)).show();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                        i.this.onDestroy();
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.j.a
                    public void b(AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                        i.this.onDestroy();
                    }
                });
            }
            this.oGd.request("end");
        }
    }

    public void hide() {
        if (this.oGO != null) {
            this.oGO.dismiss();
            this.oGO = null;
        }
    }

    public i Ad(boolean z) {
        this.oGP = z;
        return this;
    }

    public boolean edy() {
        return this.oGP;
    }

    public void onDestroy() {
        f.edr().onDestroy();
    }
}
