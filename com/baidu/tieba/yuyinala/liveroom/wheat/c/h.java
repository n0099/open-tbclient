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
    private static h ofG;
    private TbPageContext oey;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e ofH;
    private boolean ofI;
    private boolean ofJ;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.h ofd;

    public static h dZo() {
        if (ofG == null) {
            ofG = new h();
        }
        return ofG;
    }

    public void a(TbPageContext tbPageContext, AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
        if (tbPageContext != null && alaLinkCallBackHttpResponseMessage != null && alaLinkCallBackHttpResponseMessage.eah() && dZo().dZp()) {
            Activity pageActivity = tbPageContext.getPageActivity();
            if (Build.VERSION.SDK_INT >= 17) {
                if (pageActivity == null || pageActivity.isFinishing() || pageActivity.isDestroyed()) {
                    return;
                }
            } else if (pageActivity == null || pageActivity.isFinishing()) {
                return;
            }
            if (tbPageContext != null && tbPageContext != this.oey) {
                this.oey = tbPageContext;
                hide();
            }
            if (this.ofH == null) {
                this.ofI = false;
                this.ofH = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e(tbPageContext);
                this.ofH.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.h.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        h.this.ofI = false;
                        h.this.ofH = null;
                    }
                });
            }
            this.ofH.show();
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                this.ofH.c(currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), alaLinkCallBackHttpResponseMessage.eai(), alaLinkCallBackHttpResponseMessage.cWr(), alaLinkCallBackHttpResponseMessage.eaj());
            }
        }
    }

    public void a(TbPageContext tbPageContext, AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage) {
        if (tbPageContext != null && alaEndConnectionWheatHttpResponseMessage != null && alaEndConnectionWheatHttpResponseMessage.eah() && dZo().dZp()) {
            Activity pageActivity = tbPageContext.getPageActivity();
            if (Build.VERSION.SDK_INT >= 17) {
                if (pageActivity == null || pageActivity.isFinishing() || pageActivity.isDestroyed()) {
                    return;
                }
            } else if (pageActivity == null || pageActivity.isFinishing()) {
                return;
            }
            if (tbPageContext != null && tbPageContext != this.oey) {
                this.oey = tbPageContext;
                hide();
            }
            if (this.ofH == null) {
                this.ofI = false;
                this.ofH = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e(tbPageContext);
                this.ofH.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.h.2
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        h.this.ofI = false;
                        h.this.ofH = null;
                    }
                });
            }
            this.ofH.show();
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                this.ofH.c(currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), alaEndConnectionWheatHttpResponseMessage.eai(), alaEndConnectionWheatHttpResponseMessage.cWr(), alaEndConnectionWheatHttpResponseMessage.eaj());
            }
        }
    }

    public void zh(boolean z) {
        this.ofJ = z;
        if (this.ofd == null) {
            this.ofd = new com.baidu.tieba.yuyinala.liveroom.wheat.model.h(null, new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.h.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.h.a
                public void a(AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
                    h.this.a(o.dZz().dZE(), alaLinkCallBackHttpResponseMessage);
                    if (h.this.ofJ) {
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
        this.ofd.request("end");
    }

    public void hide() {
        if (this.ofH != null) {
            this.ofH.dismiss();
            this.ofH = null;
        }
    }

    public h zi(boolean z) {
        this.ofI = z;
        return this;
    }

    public boolean dZp() {
        return this.ofI;
    }

    public void onDestroy() {
        e.dZj().onDestroy();
    }
}
