package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.android.imrtc.utils.IStatusListener;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaAcceptConnectionWheatHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.a;
/* loaded from: classes11.dex */
public class a {
    private static a oFV;
    private InterfaceC0944a oFU;
    com.baidu.tieba.yuyinala.liveroom.wheat.a.e oFW = new com.baidu.tieba.yuyinala.liveroom.wheat.a.e() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.a.3
        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
        public void onError(int i, int i2, String str) {
            if (a.this.oFU != null) {
                a.this.oFU.onFail();
            }
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
        public void Mu(int i) {
            if (a.this.oFU != null) {
                a.this.oFU.onSuccess();
            }
        }
    };

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.wheat.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0944a {
        void Wr(String str);

        void onFail();

        void onSuccess();
    }

    public static a edl() {
        if (oFV == null) {
            oFV = new a();
        }
        return oFV;
    }

    public void a(final String str, final String str2, final String str3, final long j, String str4) {
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.a(null, new a.InterfaceC0947a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.a.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.a.InterfaceC0947a
            public void a(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage) {
                if (!alaAcceptConnectionWheatHttpResponseMessage.isError()) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("auth_success_anchor_2", false);
                    a.this.a(str, str2, str3, j, alaAcceptConnectionWheatHttpResponseMessage.getPushUrl(), alaAcceptConnectionWheatHttpResponseMessage.eez());
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.a.InterfaceC0947a
            public void b(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage) {
                if (a.this.oFU != null) {
                    a.this.oFU.onFail();
                }
            }
        }).aU(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ym(), str, str4);
    }

    public void a(String str, String str2, String str3, long j, String str4, String str5) {
        if (q.edM().Wf(str)) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().b(this.oFW).J(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecW(), TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), str4, str5);
            return;
        }
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecT().a(str, str2, str3, j, com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecW(), true, str4, str5, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.a.2
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str6) {
                if (i != 0 && a.this.oFU != null) {
                    a.this.oFU.onFail();
                }
            }
        });
        if (this.oFU != null) {
            this.oFU.Wr(str);
        }
    }

    public void a(InterfaceC0944a interfaceC0944a) {
        this.oFU = interfaceC0944a;
    }
}
