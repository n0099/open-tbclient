package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import android.content.DialogInterface;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdToast;
import com.baidu.tieba.yuyinala.liveroom.wheat.a.c;
import com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaEndConnectionWheatHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.e;
/* loaded from: classes4.dex */
public class i {
    private String aUa;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g ouL;
    private a ouM;

    /* loaded from: classes4.dex */
    public interface a {
        void WM(String str);
    }

    public void a(TbPageContext tbPageContext, String str, String str2) {
        this.aUa = str2;
        if (this.ouL == null) {
            this.ouL = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g(tbPageContext);
            this.ouL.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.i.1
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    i.this.ouL = null;
                }
            });
            this.ouL.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.i.2
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onCancel() {
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onConfirm() {
                    if (o.efd().Wu(i.this.aUa)) {
                        h.eeS().zM(true);
                    } else {
                        h.eeS().zM(false);
                    }
                    i.this.WL(i.this.aUa);
                }
            });
        }
        if (!this.ouL.isShowing()) {
            this.ouL.show();
        }
        this.ouL.setText(String.format(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_hang_up_wheat_remind_text), str));
    }

    public void WL(final String str) {
        this.aUa = str;
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.e(null, new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.i.3
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
            public void a(AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage) {
                if (!alaEndConnectionWheatHttpResponseMessage.isError()) {
                    i.this.a(str, alaEndConnectionWheatHttpResponseMessage);
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
            public void onFail(int i, String str2) {
            }
        }).gU(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().CZ(), this.aUa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage) {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().a(str, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.i.4
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.c.a
            public void zJ(boolean z) {
                if (o.efd().Wu(str)) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq().edY();
                } else if (z) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq().WA(str);
                }
            }
        });
        if (!o.efd().eev()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501027, "hide_dot"));
        }
        if (o.efd().Wu(str)) {
            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_hung_up_text)).show();
        }
        if (this.ouL != null) {
            this.ouL.dismiss();
        }
        h.eeS().a(o.efd().efi(), alaEndConnectionWheatHttpResponseMessage);
        if (this.ouM != null) {
            this.ouM.WM(str);
        }
        SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.i.5
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
            }
        }, 200L);
    }

    public i a(a aVar) {
        this.ouM = aVar;
        return this;
    }
}
