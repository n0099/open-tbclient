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
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g ouN;
    private a ouO;

    /* loaded from: classes4.dex */
    public interface a {
        void WM(String str);
    }

    public void a(TbPageContext tbPageContext, String str, String str2) {
        this.aUa = str2;
        if (this.ouN == null) {
            this.ouN = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g(tbPageContext);
            this.ouN.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.i.1
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    i.this.ouN = null;
                }
            });
            this.ouN.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.i.2
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onCancel() {
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onConfirm() {
                    if (o.efe().Wu(i.this.aUa)) {
                        h.eeT().zM(true);
                    } else {
                        h.eeT().zM(false);
                    }
                    i.this.WL(i.this.aUa);
                }
            });
        }
        if (!this.ouN.isShowing()) {
            this.ouN.show();
        }
        this.ouN.setText(String.format(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_hang_up_wheat_remind_text), str));
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
        }).gU(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().CZ(), this.aUa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage) {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().a(str, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.i.4
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.c.a
            public void zJ(boolean z) {
                if (o.efe().Wu(str)) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer().edZ();
                } else if (z) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer().WA(str);
                }
            }
        });
        if (!o.efe().eew()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501027, "hide_dot"));
        }
        if (o.efe().Wu(str)) {
            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_hung_up_text)).show();
        }
        if (this.ouN != null) {
            this.ouN.dismiss();
        }
        h.eeT().a(o.efe().efj(), alaEndConnectionWheatHttpResponseMessage);
        if (this.ouO != null) {
            this.ouO.WM(str);
        }
        SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.i.5
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
            }
        }, 200L);
    }

    public i a(a aVar) {
        this.ouO = aVar;
        return this;
    }
}
