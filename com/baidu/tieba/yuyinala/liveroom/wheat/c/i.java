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
/* loaded from: classes11.dex */
public class i {
    private String aUZ;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g oBx;
    private a oBy;

    /* loaded from: classes11.dex */
    public interface a {
        void Wv(String str);
    }

    public void a(TbPageContext tbPageContext, String str, String str2) {
        this.aUZ = str2;
        if (this.oBx == null) {
            this.oBx = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g(tbPageContext);
            this.oBx.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.i.1
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    i.this.oBx = null;
                }
            });
            this.oBx.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.i.2
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onCancel() {
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onConfirm() {
                    if (o.efg().Wc(i.this.aUZ)) {
                        h.eeV().zO(true);
                    } else {
                        h.eeV().zO(false);
                    }
                    i.this.Wu(i.this.aUZ);
                }
            });
        }
        if (!this.oBx.isShowing()) {
            this.oBx.show();
        }
        this.oBx.setText(String.format(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_hang_up_wheat_remind_text), str));
    }

    public void Wu(final String str) {
        this.aUZ = str;
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
        }).gS(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().Cq(), this.aUZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage) {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().a(str, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.i.4
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.c.a
            public void zL(boolean z) {
                if (o.efg().Wc(str)) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer().Wf("自己挂断自己");
                } else if (z) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer().Wi(str);
                }
            }
        });
        if (!o.efg().eew()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501027, "hide_dot"));
        }
        if (o.efg().Wc(str)) {
            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_hung_up_text)).show();
        }
        if (this.oBx != null) {
            this.oBx.dismiss();
        }
        h.eeV().a(o.efg().efm(), alaEndConnectionWheatHttpResponseMessage);
        if (this.oBy != null) {
            this.oBy.Wv(str);
        }
        SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.i.5
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
            }
        }, 200L);
    }

    public i a(a aVar) {
        this.oBy = aVar;
        return this;
    }
}
