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
    private String aQY;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g ofL;
    private a ofM;

    /* loaded from: classes4.dex */
    public interface a {
        void Vx(String str);
    }

    public void a(TbPageContext tbPageContext, String str, String str2) {
        this.aQY = str2;
        if (this.ofL == null) {
            this.ofL = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g(tbPageContext);
            this.ofL.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.i.1
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    i.this.ofL = null;
                }
            });
            this.ofL.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.i.2
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onCancel() {
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onConfirm() {
                    if (o.dZz().Vf(i.this.aQY)) {
                        h.dZo().zi(true);
                    } else {
                        h.dZo().zi(false);
                    }
                    i.this.Vw(i.this.aQY);
                }
            });
        }
        if (!this.ofL.isShowing()) {
            this.ofL.show();
        }
        this.ofL.setText(String.format(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_hang_up_wheat_remind_text), str));
    }

    public void Vw(final String str) {
        this.aQY = str;
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
        }).gP(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().Br(), this.aQY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage) {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().a(str, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.i.4
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.c.a
            public void zf(boolean z) {
                if (o.dZz().Vf(str)) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().dYM().dYu();
                } else if (z) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().dYM().Vl(str);
                }
            }
        });
        if (!o.dZz().dYR()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501027, "hide_dot"));
        }
        if (o.dZz().Vf(str)) {
            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_hung_up_text)).show();
        }
        if (this.ofL != null) {
            this.ofL.dismiss();
        }
        h.dZo().a(o.dZz().dZE(), alaEndConnectionWheatHttpResponseMessage);
        if (this.ofM != null) {
            this.ofM.Vx(str);
        }
        SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.i.5
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
            }
        }, 200L);
    }

    public i a(a aVar) {
        this.ofM = aVar;
        return this;
    }
}
