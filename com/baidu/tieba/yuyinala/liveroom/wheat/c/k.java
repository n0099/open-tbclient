package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import android.content.DialogInterface;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdToast;
import com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaEndConnectionWheatHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.f;
/* loaded from: classes10.dex */
public class k {
    private String aUP;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g oJa;
    private a oJb;

    /* loaded from: classes10.dex */
    public interface a {
        void WE(String str);
    }

    public void a(TbPageContext tbPageContext, String str, String str2) {
        this.aUP = str2;
        if (this.oJa == null) {
            this.oJa = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g(tbPageContext);
            this.oJa.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.k.1
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    k.this.oJa = null;
                }
            });
            this.oJa.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.k.2
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onCancel() {
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onConfirm() {
                    if (q.edU().Wm(k.this.aUP)) {
                        i.edF().Ac(true);
                    } else {
                        i.edF().Ac(false);
                    }
                    k.this.WD(k.this.aUP);
                }
            });
        }
        if (!this.oJa.isShowing()) {
            this.oJa.show();
        }
        this.oJa.setText(String.format(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_hang_up_wheat_remind_text), str));
    }

    public void WD(final String str) {
        this.aUP = str;
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.f(null, new f.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.k.3
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.f.a
            public void a(AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage) {
                if (!alaEndConnectionWheatHttpResponseMessage.isError()) {
                    k.this.a(str, alaEndConnectionWheatHttpResponseMessage);
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.f.a
            public void onFail(int i, String str2) {
            }
        }).ha(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().yp(), this.aUP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage) {
        if (q.edU().Wm(str)) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().edb().Wr("自己挂断自己");
        } else {
            AlaWheatInfoData iQ = q.edU().iQ(str);
            String str2 = "";
            String str3 = "";
            long j = 0;
            if (iQ != null) {
                str2 = iQ.cuid;
                str3 = iQ.clientVersion;
                j = iQ.imAppid;
            }
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().edb().a(str, j, str3, str2);
        }
        if (!q.edU().Yn()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501027, "hide_dot"));
        }
        if (q.edU().Wm(str)) {
            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_hung_up_text)).show();
        }
        if (this.oJa != null) {
            this.oJa.dismiss();
        }
        i.edF().a(q.edU().eea(), alaEndConnectionWheatHttpResponseMessage);
        if (this.oJb != null) {
            this.oJb.WE(str);
        }
        SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.k.4
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
            }
        }, 200L);
    }

    public k a(a aVar) {
        this.oJb = aVar;
        return this;
    }
}
