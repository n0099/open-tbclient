package com.baidu.tieba.yuyinala.liveroom.wheat.b;

import android.content.DialogInterface;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdToast;
import com.baidu.tieba.yuyinala.liveroom.wheat.a.c;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.e;
import com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaEndConnectionWheatHttpResponseMessage;
/* loaded from: classes4.dex */
public class h {
    private String aRs;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g nWI;
    private a nWJ;

    /* loaded from: classes4.dex */
    public interface a {
        void Vp(String str);
    }

    public void a(TbPageContext tbPageContext, String str, String str2) {
        this.aRs = str2;
        if (this.nWI == null) {
            this.nWI = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g(tbPageContext);
            this.nWI.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.h.1
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    h.this.nWI = null;
                }
            });
            this.nWI.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.h.2
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onCancel() {
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onConfirm() {
                    if (n.dWB().Vd(h.this.aRs)) {
                        g.dWq().yT(true);
                    } else {
                        g.dWq().yT(false);
                    }
                    h.this.Vo(h.this.aRs);
                }
            });
        }
        if (!this.nWI.isShowing()) {
            this.nWI.show();
        }
        this.nWI.setText(String.format(TbadkCoreApplication.getInst().getString(a.i.yuyin_ala_connection_wheat_hang_up_wheat_remind_text), str));
    }

    public void Vo(final String str) {
        this.aRs = str;
        new com.baidu.tieba.yuyinala.liveroom.wheat.c.e(null, new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.h.3
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.e.a
            public void a(AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage) {
                if (!alaEndConnectionWheatHttpResponseMessage.isError()) {
                    h.this.a(str, alaEndConnectionWheatHttpResponseMessage);
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.e.a
            public void onFail(int i, String str2) {
            }
        }).gN(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dWa(), this.aRs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage) {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().a(str, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.h.4
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.c.a
            public void yQ(boolean z) {
                if (n.dWB().Vd(str)) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dVX().Vi(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dWb());
                } else if (z) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dVX().Vj(str);
                }
            }
        });
        if (!n.dWB().dWd()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501027, "hide_dot"));
        }
        if (n.dWB().Vd(str)) {
            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.i.yuyin_ala_connection_wheat_hung_up_text)).show();
        }
        if (this.nWI != null) {
            this.nWI.dismiss();
        }
        g.dWq().a(n.dWB().dWK(), alaEndConnectionWheatHttpResponseMessage);
        if (this.nWJ != null) {
            this.nWJ.Vp(str);
        }
        SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.h.5
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
            }
        }, 200L);
    }

    public h a(a aVar) {
        this.nWJ = aVar;
        return this;
    }
}
