package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.android.imrtc.utils.IStatusListener;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.data.r;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdToast;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaInviteConnectionWheatHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.i;
/* loaded from: classes11.dex */
public class l {
    public void a(final r rVar, int i) {
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.i(null, new i.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.l.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.i.a
            public void a(AlaInviteConnectionWheatHttpResponseMessage alaInviteConnectionWheatHttpResponseMessage) {
                if (alaInviteConnectionWheatHttpResponseMessage.eeI()) {
                    a.edl().a(rVar.uk, rVar.cuid, rVar.aGi, rVar.aGk, alaInviteConnectionWheatHttpResponseMessage.getPushUrl(), alaInviteConnectionWheatHttpResponseMessage.eez());
                    return;
                }
                com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("auth_success_anchor_2", false);
                l.this.a(rVar, alaInviteConnectionWheatHttpResponseMessage);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.i.a
            public void b(AlaInviteConnectionWheatHttpResponseMessage alaInviteConnectionWheatHttpResponseMessage) {
            }
        }).aU(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ym(), rVar.uk, String.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(r rVar, AlaInviteConnectionWheatHttpResponseMessage alaInviteConnectionWheatHttpResponseMessage) {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecT().a(rVar.uk, rVar.cuid, rVar.aGi, rVar.aGk, com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecW(), false, alaInviteConnectionWheatHttpResponseMessage.getPushUrl(), alaInviteConnectionWheatHttpResponseMessage.eez(), new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.l.2
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                if (i == 0) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("invite_succ_anchor_4", false);
                }
                l.this.W(i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(final int i, String str) {
        SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.l.3
            @Override // java.lang.Runnable
            public void run() {
                if (i != 0) {
                    BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_invite_error_text)).show();
                }
            }
        });
    }
}
