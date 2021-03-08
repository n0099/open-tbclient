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
/* loaded from: classes10.dex */
public class i {
    private static i oIS;
    private TbPageContext oIJ;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e oIT;
    private boolean oIU;
    private boolean oIV;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.j oIi;

    public static i edF() {
        if (oIS == null) {
            oIS = new i();
        }
        return oIS;
    }

    public void a(TbPageContext tbPageContext, AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
        if (tbPageContext != null && alaLinkCallBackHttpResponseMessage != null && alaLinkCallBackHttpResponseMessage.eeJ() && edF().edG()) {
            Activity pageActivity = tbPageContext.getPageActivity();
            if (Build.VERSION.SDK_INT >= 17) {
                if (pageActivity == null || pageActivity.isFinishing() || pageActivity.isDestroyed()) {
                    return;
                }
            } else if (pageActivity == null || pageActivity.isFinishing()) {
                return;
            }
            if (tbPageContext != null && tbPageContext != this.oIJ) {
                this.oIJ = tbPageContext;
                hide();
            }
            if (this.oIT == null) {
                this.oIU = false;
                this.oIT = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e(tbPageContext);
                this.oIT.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.i.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        i.this.oIU = false;
                        i.this.oIT = null;
                    }
                });
            }
            this.oIT.show();
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                this.oIT.d(currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), alaLinkCallBackHttpResponseMessage.eeK(), alaLinkCallBackHttpResponseMessage.cZC(), alaLinkCallBackHttpResponseMessage.eeL());
            }
        }
    }

    public void a(TbPageContext tbPageContext, AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage) {
        if (tbPageContext != null && alaEndConnectionWheatHttpResponseMessage != null && alaEndConnectionWheatHttpResponseMessage.eeJ() && edF().edG()) {
            Activity pageActivity = tbPageContext.getPageActivity();
            if (Build.VERSION.SDK_INT >= 17) {
                if (pageActivity == null || pageActivity.isFinishing() || pageActivity.isDestroyed()) {
                    return;
                }
            } else if (pageActivity == null || pageActivity.isFinishing()) {
                return;
            }
            if (tbPageContext != null && tbPageContext != this.oIJ) {
                this.oIJ = tbPageContext;
                hide();
            }
            if (this.oIT == null) {
                this.oIU = false;
                this.oIT = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e(tbPageContext);
                this.oIT.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.i.2
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        i.this.oIU = false;
                        i.this.oIT = null;
                    }
                });
            }
            this.oIT.show();
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                this.oIT.d(currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), alaEndConnectionWheatHttpResponseMessage.eeK(), alaEndConnectionWheatHttpResponseMessage.cZC(), alaEndConnectionWheatHttpResponseMessage.eeL());
            }
        }
    }

    public void Ab(boolean z) {
        this.oIV = z;
        if (q.edU().iN(q.edU().Ys())) {
            if (this.oIi == null) {
                this.oIi = new com.baidu.tieba.yuyinala.liveroom.wheat.model.j(null, new j.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.i.3
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.j.a
                    public void a(AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
                        i.this.a(q.edU().eea(), alaLinkCallBackHttpResponseMessage);
                        if (i.this.oIV) {
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
            this.oIi.request("end");
        }
    }

    public void hide() {
        if (this.oIT != null) {
            this.oIT.dismiss();
            this.oIT = null;
        }
    }

    public i Ac(boolean z) {
        this.oIU = z;
        return this;
    }

    public boolean edG() {
        return this.oIU;
    }

    public void onDestroy() {
        f.edz().onDestroy();
    }
}
