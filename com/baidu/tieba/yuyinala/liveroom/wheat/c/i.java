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
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g oBy;
    private a oBz;

    /* loaded from: classes11.dex */
    public interface a {
        void Ww(String str);
    }

    public void a(TbPageContext tbPageContext, String str, String str2) {
        this.aUZ = str2;
        if (this.oBy == null) {
            this.oBy = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g(tbPageContext);
            this.oBy.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.i.1
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    i.this.oBy = null;
                }
            });
            this.oBy.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.i.2
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onCancel() {
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onConfirm() {
                    if (o.eff().Wd(i.this.aUZ)) {
                        h.eeU().zO(true);
                    } else {
                        h.eeU().zO(false);
                    }
                    i.this.Wv(i.this.aUZ);
                }
            });
        }
        if (!this.oBy.isShowing()) {
            this.oBy.show();
        }
        this.oBy.setText(String.format(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_hang_up_wheat_remind_text), str));
    }

    public void Wv(final String str) {
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
        }).gS(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().Cq(), this.aUZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage) {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().a(str, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.i.4
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.c.a
            public void zL(boolean z) {
                if (o.eff().Wd(str)) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq().Wg("自己挂断自己");
                } else if (z) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq().Wj(str);
                }
            }
        });
        if (!o.eff().eev()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501027, "hide_dot"));
        }
        if (o.eff().Wd(str)) {
            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_hung_up_text)).show();
        }
        if (this.oBy != null) {
            this.oBy.dismiss();
        }
        h.eeU().a(o.eff().efl(), alaEndConnectionWheatHttpResponseMessage);
        if (this.oBz != null) {
            this.oBz.Ww(str);
        }
        SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.i.5
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
            }
        }, 200L);
    }

    public i a(a aVar) {
        this.oBz = aVar;
        return this;
    }
}
