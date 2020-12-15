package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.android.imrtc.utils.IStatusListener;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaAcceptConnectionWheatHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.a;
/* loaded from: classes4.dex */
public class a {
    private static a otY;
    private InterfaceC0941a otX;
    com.baidu.tieba.yuyinala.liveroom.wheat.a.e otZ = new com.baidu.tieba.yuyinala.liveroom.wheat.a.e() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.a.3
        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
        public void onError(int i, int i2, String str) {
            if (a.this.otX != null) {
                a.this.otX.onFail();
            }
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
        public void NN(int i) {
            if (a.this.otX != null) {
                a.this.otX.onSuccess();
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

    public static a eeI() {
        if (otY == null) {
            otY = new a();
        }
        return otY;
    }

    public void b(final String str, final String str2, final String str3, final long j, String str4) {
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.a(null, new a.InterfaceC0944a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.a.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.a.InterfaceC0944a
            public void a(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage) {
                if (!alaAcceptConnectionWheatHttpResponseMessage.isError()) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bk("auth_success_anchor_2", false);
                    a.this.b(str, str2, str3, j, alaAcceptConnectionWheatHttpResponseMessage.getPushUrl(), alaAcceptConnectionWheatHttpResponseMessage.efL());
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.a.InterfaceC0944a
            public void b(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage) {
                if (a.this.otX != null) {
                    a.this.otX.onFail();
                }
            }
        }).aQ(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().CZ(), str, str4);
    }

    public void b(String str, String str2, String str3, long j, String str4, String str5) {
        if (o.efe().Wu(str)) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().b(this.otZ).M(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eeu(), TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), str4, str5);
            return;
        }
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer().a(str, str2, str3, j, com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eeu(), true, str4, str5, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.a.2
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str6) {
                if (i == 0 && a.this.otX != null) {
                    a.this.otX.onFail();
                }
            }
        });
        if (this.otX != null) {
            this.otX.WG(str);
        }
    }

    public void a(InterfaceC0941a interfaceC0941a) {
        this.otX = interfaceC0941a;
    }
}
