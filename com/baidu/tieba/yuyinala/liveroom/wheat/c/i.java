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
    private static i oGn;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.j oFD;
    private TbPageContext oGe;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e oGo;
    private boolean oGp;
    private boolean oGq;

    public static i edp() {
        if (oGn == null) {
            oGn = new i();
        }
        return oGn;
    }

    public void a(TbPageContext tbPageContext, AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
        if (tbPageContext != null && alaLinkCallBackHttpResponseMessage != null && alaLinkCallBackHttpResponseMessage.eet() && edp().edq()) {
            Activity pageActivity = tbPageContext.getPageActivity();
            if (Build.VERSION.SDK_INT >= 17) {
                if (pageActivity == null || pageActivity.isFinishing() || pageActivity.isDestroyed()) {
                    return;
                }
            } else if (pageActivity == null || pageActivity.isFinishing()) {
                return;
            }
            if (tbPageContext != null && tbPageContext != this.oGe) {
                this.oGe = tbPageContext;
                hide();
            }
            if (this.oGo == null) {
                this.oGp = false;
                this.oGo = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e(tbPageContext);
                this.oGo.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.i.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        i.this.oGp = false;
                        i.this.oGo = null;
                    }
                });
            }
            this.oGo.show();
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                this.oGo.d(currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), alaLinkCallBackHttpResponseMessage.eeu(), alaLinkCallBackHttpResponseMessage.cZo(), alaLinkCallBackHttpResponseMessage.eev());
            }
        }
    }

    public void a(TbPageContext tbPageContext, AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage) {
        if (tbPageContext != null && alaEndConnectionWheatHttpResponseMessage != null && alaEndConnectionWheatHttpResponseMessage.eet() && edp().edq()) {
            Activity pageActivity = tbPageContext.getPageActivity();
            if (Build.VERSION.SDK_INT >= 17) {
                if (pageActivity == null || pageActivity.isFinishing() || pageActivity.isDestroyed()) {
                    return;
                }
            } else if (pageActivity == null || pageActivity.isFinishing()) {
                return;
            }
            if (tbPageContext != null && tbPageContext != this.oGe) {
                this.oGe = tbPageContext;
                hide();
            }
            if (this.oGo == null) {
                this.oGp = false;
                this.oGo = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e(tbPageContext);
                this.oGo.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.i.2
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        i.this.oGp = false;
                        i.this.oGo = null;
                    }
                });
            }
            this.oGo.show();
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                this.oGo.d(currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), alaEndConnectionWheatHttpResponseMessage.eeu(), alaEndConnectionWheatHttpResponseMessage.cZo(), alaEndConnectionWheatHttpResponseMessage.eev());
            }
        }
    }

    public void Ac(boolean z) {
        this.oGq = z;
        if (q.edE().iH(q.edE().Yp())) {
            if (this.oFD == null) {
                this.oFD = new com.baidu.tieba.yuyinala.liveroom.wheat.model.j(null, new j.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.i.3
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.j.a
                    public void a(AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
                        i.this.a(q.edE().edK(), alaLinkCallBackHttpResponseMessage);
                        if (i.this.oGq) {
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
            this.oFD.request("end");
        }
    }

    public void hide() {
        if (this.oGo != null) {
            this.oGo.dismiss();
            this.oGo = null;
        }
    }

    public i Ad(boolean z) {
        this.oGp = z;
        return this;
    }

    public boolean edq() {
        return this.oGp;
    }

    public void onDestroy() {
        f.edj().onDestroy();
    }
}
