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
    private static h ouG;
    private TbPageContext oty;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e ouH;
    private boolean ouI;
    private boolean ouJ;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.h oud;

    public static h eeS() {
        if (ouG == null) {
            ouG = new h();
        }
        return ouG;
    }

    public void a(TbPageContext tbPageContext, AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
        if (tbPageContext != null && alaLinkCallBackHttpResponseMessage != null && alaLinkCallBackHttpResponseMessage.efM() && eeS().eeT()) {
            Activity pageActivity = tbPageContext.getPageActivity();
            if (Build.VERSION.SDK_INT >= 17) {
                if (pageActivity == null || pageActivity.isFinishing() || pageActivity.isDestroyed()) {
                    return;
                }
            } else if (pageActivity == null || pageActivity.isFinishing()) {
                return;
            }
            if (tbPageContext != null && tbPageContext != this.oty) {
                this.oty = tbPageContext;
                hide();
            }
            if (this.ouH == null) {
                this.ouI = false;
                this.ouH = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e(tbPageContext);
                this.ouH.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.h.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        h.this.ouI = false;
                        h.this.ouH = null;
                    }
                });
            }
            this.ouH.show();
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                this.ouH.c(currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), alaLinkCallBackHttpResponseMessage.efN(), alaLinkCallBackHttpResponseMessage.dbD(), alaLinkCallBackHttpResponseMessage.efO());
            }
        }
    }

    public void a(TbPageContext tbPageContext, AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage) {
        if (tbPageContext != null && alaEndConnectionWheatHttpResponseMessage != null && alaEndConnectionWheatHttpResponseMessage.efM() && eeS().eeT()) {
            Activity pageActivity = tbPageContext.getPageActivity();
            if (Build.VERSION.SDK_INT >= 17) {
                if (pageActivity == null || pageActivity.isFinishing() || pageActivity.isDestroyed()) {
                    return;
                }
            } else if (pageActivity == null || pageActivity.isFinishing()) {
                return;
            }
            if (tbPageContext != null && tbPageContext != this.oty) {
                this.oty = tbPageContext;
                hide();
            }
            if (this.ouH == null) {
                this.ouI = false;
                this.ouH = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e(tbPageContext);
                this.ouH.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.h.2
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        h.this.ouI = false;
                        h.this.ouH = null;
                    }
                });
            }
            this.ouH.show();
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                this.ouH.c(currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), alaEndConnectionWheatHttpResponseMessage.efN(), alaEndConnectionWheatHttpResponseMessage.dbD(), alaEndConnectionWheatHttpResponseMessage.efO());
            }
        }
    }

    public void zL(boolean z) {
        this.ouJ = z;
        if (this.oud == null) {
            this.oud = new com.baidu.tieba.yuyinala.liveroom.wheat.model.h(null, new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.h.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.h.a
                public void a(AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
                    h.this.a(o.efd().efi(), alaLinkCallBackHttpResponseMessage);
                    if (h.this.ouJ) {
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
        this.oud.request("end");
    }

    public void hide() {
        if (this.ouH != null) {
            this.ouH.dismiss();
            this.ouH = null;
        }
    }

    public h zM(boolean z) {
        this.ouI = z;
        return this;
    }

    public boolean eeT() {
        return this.ouI;
    }

    public void onDestroy() {
        e.eeN().onDestroy();
    }
}
