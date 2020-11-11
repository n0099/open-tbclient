package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.android.imrtc.utils.IStatusListener;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdToast;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaInviteConnectionWheatHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.g;
/* loaded from: classes4.dex */
public class j {
    public void a(final com.baidu.live.data.m mVar, int i) {
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.g(null, new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.j.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.g.a
            public void a(AlaInviteConnectionWheatHttpResponseMessage alaInviteConnectionWheatHttpResponseMessage) {
                if (alaInviteConnectionWheatHttpResponseMessage.eao()) {
                    a.dZe().b(mVar.uk, mVar.cuid, mVar.aHO, mVar.aHQ, alaInviteConnectionWheatHttpResponseMessage.getPushUrl(), alaInviteConnectionWheatHttpResponseMessage.eag());
                    return;
                }
                com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("auth_success_anchor_2", false);
                j.this.a(mVar, alaInviteConnectionWheatHttpResponseMessage);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.g.a
            public void b(AlaInviteConnectionWheatHttpResponseMessage alaInviteConnectionWheatHttpResponseMessage) {
            }
        }).aN(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().Ca(), mVar.uk, String.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.m mVar, AlaInviteConnectionWheatHttpResponseMessage alaInviteConnectionWheatHttpResponseMessage) {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().dYN().a(mVar.uk, mVar.cuid, mVar.aHO, mVar.aHQ, com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().dYQ(), false, alaInviteConnectionWheatHttpResponseMessage.getPushUrl(), alaInviteConnectionWheatHttpResponseMessage.eag(), new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.j.2
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                if (i == 0) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("invite_succ_anchor_4", false);
                }
                j.this.Mu(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mu(final int i) {
        SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.j.3
            @Override // java.lang.Runnable
            public void run() {
                if (i != 0) {
                    BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_invite_error_text)).show();
                }
            }
        });
    }
}
