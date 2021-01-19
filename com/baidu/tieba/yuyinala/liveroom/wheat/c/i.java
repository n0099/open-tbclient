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
import com.baidu.tieba.yuyinala.liveroom.wheat.model.f;
/* loaded from: classes10.dex */
public class i {
    private String aQm;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g owT;
    private a owU;

    /* loaded from: classes10.dex */
    public interface a {
        void Vo(String str);
    }

    public void a(TbPageContext tbPageContext, String str, String str2) {
        this.aQm = str2;
        if (this.owT == null) {
            this.owT = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g(tbPageContext);
            this.owT.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.i.1
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    i.this.owT = null;
                }
            });
            this.owT.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.i.2
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onCancel() {
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onConfirm() {
                    if (o.ebo().UV(i.this.aQm)) {
                        h.ebd().zK(true);
                    } else {
                        h.ebd().zK(false);
                    }
                    i.this.Vn(i.this.aQm);
                }
            });
        }
        if (!this.owT.isShowing()) {
            this.owT.show();
        }
        this.owT.setText(String.format(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_hang_up_wheat_remind_text), str));
    }

    public void Vn(final String str) {
        this.aQm = str;
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.f(null, new f.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.i.3
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.f.a
            public void a(AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage) {
                if (!alaEndConnectionWheatHttpResponseMessage.isError()) {
                    i.this.a(str, alaEndConnectionWheatHttpResponseMessage);
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.f.a
            public void onFail(int i, String str2) {
            }
        }).gR(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().yv(), this.aQm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage) {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().a(str, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.i.4
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.c.a
            public void zH(boolean z) {
                if (o.ebo().UV(str)) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().eaz().UY("自己挂断自己");
                } else if (z) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().eaz().Vb(str);
                }
            }
        });
        if (!o.ebo().eaE()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501027, "hide_dot"));
        }
        if (o.ebo().UV(str)) {
            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_hung_up_text)).show();
        }
        if (this.owT != null) {
            this.owT.dismiss();
        }
        h.ebd().a(o.ebo().ebu(), alaEndConnectionWheatHttpResponseMessage);
        if (this.owU != null) {
            this.owU.Vo(str);
        }
        SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.i.5
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
            }
        }, 200L);
    }

    public i a(a aVar) {
        this.owU = aVar;
        return this;
    }
}
