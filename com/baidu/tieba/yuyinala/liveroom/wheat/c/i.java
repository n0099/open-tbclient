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
    private String aSJ;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g oeh;
    private a oei;

    /* loaded from: classes4.dex */
    public interface a {
        void VM(String str);
    }

    public void a(TbPageContext tbPageContext, String str, String str2) {
        this.aSJ = str2;
        if (this.oeh == null) {
            this.oeh = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g(tbPageContext);
            this.oeh.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.i.1
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    i.this.oeh = null;
                }
            });
            this.oeh.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.i.2
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onCancel() {
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onConfirm() {
                    if (o.dZA().Vu(i.this.aSJ)) {
                        h.dZp().zb(true);
                    } else {
                        h.dZp().zb(false);
                    }
                    i.this.VL(i.this.aSJ);
                }
            });
        }
        if (!this.oeh.isShowing()) {
            this.oeh.show();
        }
        this.oeh.setText(String.format(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_hang_up_wheat_remind_text), str));
    }

    public void VL(final String str) {
        this.aSJ = str;
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
        }).gP(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().Ca(), this.aSJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage) {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().a(str, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.i.4
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.c.a
            public void yY(boolean z) {
                if (o.dZA().Vu(str)) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().dYN().dYv();
                } else if (z) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().dYN().VA(str);
                }
            }
        });
        if (!o.dZA().dYS()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501027, "hide_dot"));
        }
        if (o.dZA().Vu(str)) {
            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_hung_up_text)).show();
        }
        if (this.oeh != null) {
            this.oeh.dismiss();
        }
        h.dZp().a(o.dZA().dZF(), alaEndConnectionWheatHttpResponseMessage);
        if (this.oei != null) {
            this.oei.VM(str);
        }
        SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.i.5
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
            }
        }, 200L);
    }

    public i a(a aVar) {
        this.oei = aVar;
        return this;
    }
}
