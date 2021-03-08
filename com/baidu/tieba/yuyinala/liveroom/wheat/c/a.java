package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.android.imrtc.utils.IStatusListener;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaAcceptConnectionWheatHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.a;
/* loaded from: classes10.dex */
public class a {
    private static a oIa;
    private InterfaceC0950a oHZ;
    com.baidu.tieba.yuyinala.liveroom.wheat.a.e oIb = new com.baidu.tieba.yuyinala.liveroom.wheat.a.e() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.a.3
        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
        public void onError(int i, int i2, String str) {
            if (a.this.oHZ != null) {
                a.this.oHZ.onFail();
            }
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
        public void My(int i) {
            if (a.this.oHZ != null) {
                a.this.oHZ.onSuccess();
            }
        }
    };

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.wheat.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0950a {
        void Wy(String str);

        void onFail();

        void onSuccess();
    }

    public static a edt() {
        if (oIa == null) {
            oIa = new a();
        }
        return oIa;
    }

    public void a(final String str, final String str2, final String str3, final long j, String str4) {
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.a(null, new a.InterfaceC0953a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.a.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.a.InterfaceC0953a
            public void a(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage) {
                if (!alaAcceptConnectionWheatHttpResponseMessage.isError()) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("auth_success_anchor_2", false);
                    a.this.a(str, str2, str3, j, alaAcceptConnectionWheatHttpResponseMessage.getPushUrl(), alaAcceptConnectionWheatHttpResponseMessage.eeH());
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.a.InterfaceC0953a
            public void b(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage) {
                if (a.this.oHZ != null) {
                    a.this.oHZ.onFail();
                }
            }
        }).aU(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().yp(), str, str4);
    }

    public void a(String str, String str2, String str3, long j, String str4, String str5) {
        if (q.edU().Wm(str)) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().b(this.oIb).J(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().ede(), TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), str4, str5);
            return;
        }
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().edb().a(str, str2, str3, j, com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().ede(), true, str4, str5, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.a.2
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str6) {
                if (i != 0 && a.this.oHZ != null) {
                    a.this.oHZ.onFail();
                }
            }
        });
        if (this.oHZ != null) {
            this.oHZ.Wy(str);
        }
    }

    public void a(InterfaceC0950a interfaceC0950a) {
        this.oHZ = interfaceC0950a;
    }
}
