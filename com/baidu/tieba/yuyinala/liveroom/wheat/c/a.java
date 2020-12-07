package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.android.imrtc.utils.IStatusListener;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaAcceptConnectionWheatHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.a;
/* loaded from: classes4.dex */
public class a {
    private static a otW;
    private InterfaceC0941a otV;
    com.baidu.tieba.yuyinala.liveroom.wheat.a.e otX = new com.baidu.tieba.yuyinala.liveroom.wheat.a.e() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.a.3
        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
        public void onError(int i, int i2, String str) {
            if (a.this.otV != null) {
                a.this.otV.onFail();
            }
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
        public void NN(int i) {
            if (a.this.otV != null) {
                a.this.otV.onSuccess();
            }
        }
    };

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.wheat.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0941a {
        void WG(String str);

        void onFail();

        void onSuccess();
    }

    public static a eeH() {
        if (otW == null) {
            otW = new a();
        }
        return otW;
    }

    public void b(final String str, final String str2, final String str3, final long j, String str4) {
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.a(null, new a.InterfaceC0944a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.a.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.a.InterfaceC0944a
            public void a(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage) {
                if (!alaAcceptConnectionWheatHttpResponseMessage.isError()) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bk("auth_success_anchor_2", false);
                    a.this.b(str, str2, str3, j, alaAcceptConnectionWheatHttpResponseMessage.getPushUrl(), alaAcceptConnectionWheatHttpResponseMessage.efK());
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.a.InterfaceC0944a
            public void b(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage) {
                if (a.this.otV != null) {
                    a.this.otV.onFail();
                }
            }
        }).aQ(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().CZ(), str, str4);
    }

    public void b(String str, String str2, String str3, long j, String str4, String str5) {
        if (o.efd().Wu(str)) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().b(this.otX).M(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eet(), TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), str4, str5);
            return;
        }
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq().a(str, str2, str3, j, com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eet(), true, str4, str5, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.a.2
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str6) {
                if (i == 0 && a.this.otV != null) {
                    a.this.otV.onFail();
                }
            }
        });
        if (this.otV != null) {
            this.otV.WG(str);
        }
    }

    public void a(InterfaceC0941a interfaceC0941a) {
        this.otV = interfaceC0941a;
    }
}
