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
/* loaded from: classes11.dex */
public class k {
    private String aTp;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g oGV;
    private a oGW;

    /* loaded from: classes11.dex */
    public interface a {
        void Wx(String str);
    }

    public void a(TbPageContext tbPageContext, String str, String str2) {
        this.aTp = str2;
        if (this.oGV == null) {
            this.oGV = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g(tbPageContext);
            this.oGV.g(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.k.1
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    k.this.oGV = null;
                }
            });
            this.oGV.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.k.2
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onCancel() {
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onConfirm() {
                    if (q.edM().Wf(k.this.aTp)) {
                        i.edx().Ad(true);
                    } else {
                        i.edx().Ad(false);
                    }
                    k.this.Ww(k.this.aTp);
                }
            });
        }
        if (!this.oGV.isShowing()) {
            this.oGV.show();
        }
        this.oGV.setText(String.format(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_hang_up_wheat_remind_text), str));
    }

    public void Ww(final String str) {
        this.aTp = str;
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
        }).ha(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ym(), this.aTp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage) {
        if (q.edM().Wf(str)) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecT().Wk("自己挂断自己");
        } else {
            AlaWheatInfoData iK = q.edM().iK(str);
            String str2 = "";
            String str3 = "";
            long j = 0;
            if (iK != null) {
                str2 = iK.cuid;
                str3 = iK.clientVersion;
                j = iK.imAppid;
            }
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecT().a(str, j, str3, str2);
        }
        if (!q.edM().Yk()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501027, "hide_dot"));
        }
        if (q.edM().Wf(str)) {
            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_hung_up_text)).show();
        }
        if (this.oGV != null) {
            this.oGV.dismiss();
        }
        i.edx().a(q.edM().edS(), alaEndConnectionWheatHttpResponseMessage);
        if (this.oGW != null) {
            this.oGW.Wx(str);
        }
        SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.k.4
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
            }
        }, 200L);
    }

    public k a(a aVar) {
        this.oGW = aVar;
        return this;
    }
}
