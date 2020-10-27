package com.baidu.tieba.yuyinala.liveroom.wheat.b;

import com.baidu.android.imrtc.utils.IStatusListener;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdToast;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.g;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaInviteConnectionWheatHttpResponseMessage;
/* loaded from: classes4.dex */
public class i {
    public void c(final com.baidu.live.data.m mVar) {
        new com.baidu.tieba.yuyinala.liveroom.wheat.c.g(null, new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.i.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.g.a
            public void a(AlaInviteConnectionWheatHttpResponseMessage alaInviteConnectionWheatHttpResponseMessage) {
                if (alaInviteConnectionWheatHttpResponseMessage.dXe()) {
                    a.dWf().b(mVar.uk, mVar.cuid, mVar.aGY, mVar.aGZ, alaInviteConnectionWheatHttpResponseMessage.getPushUrl(), alaInviteConnectionWheatHttpResponseMessage.dWW());
                    return;
                }
                com.baidu.tieba.yuyinala.liveroom.wheat.d.d.bh("auth_success_anchor_2", false);
                i.this.a(mVar, alaInviteConnectionWheatHttpResponseMessage);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.g.a
            public void b(AlaInviteConnectionWheatHttpResponseMessage alaInviteConnectionWheatHttpResponseMessage) {
            }
        }).gN(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dWa(), mVar.uk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.m mVar, AlaInviteConnectionWheatHttpResponseMessage alaInviteConnectionWheatHttpResponseMessage) {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dVX().a(mVar.uk, mVar.cuid, mVar.aGY, mVar.aGZ, com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dWb(), false, alaInviteConnectionWheatHttpResponseMessage.getPushUrl(), alaInviteConnectionWheatHttpResponseMessage.dWW(), new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.i.2
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                if (i == 0) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.d.d.bh("invite_succ_anchor_4", false);
                }
                i.this.Md(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Md(final int i) {
        SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.i.3
            @Override // java.lang.Runnable
            public void run() {
                if (i != 0) {
                    BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.i.yuyin_ala_connection_wheat_invite_error_text)).show();
                }
            }
        });
    }
}
