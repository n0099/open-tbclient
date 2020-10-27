package com.baidu.tieba.yuyinala.liveroom.wheat.b;

import com.baidu.android.imrtc.utils.IStatusListener;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.a;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaAcceptConnectionWheatHttpResponseMessage;
/* loaded from: classes4.dex */
public class a {
    private static a nVS;
    private InterfaceC0905a nVR;
    com.baidu.tieba.yuyinala.liveroom.wheat.a.e nVT = new com.baidu.tieba.yuyinala.liveroom.wheat.a.e() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.3
        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
        public void onError(int i, int i2, String str) {
            if (a.this.nVR != null) {
                a.this.nVR.onFail();
            }
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
        public void Mb(int i) {
            if (a.this.nVR != null) {
                a.this.nVR.onSuccess();
            }
        }
    };

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.wheat.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0905a {
        void Vm(String str);

        void onFail();

        void onSuccess();
    }

    public static a dWf() {
        if (nVS == null) {
            nVS = new a();
        }
        return nVS;
    }

    public void b(final String str, final String str2, final String str3, final long j, String str4) {
        new com.baidu.tieba.yuyinala.liveroom.wheat.c.a(null, new a.InterfaceC0908a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.a.InterfaceC0908a
            public void a(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage) {
                if (!alaAcceptConnectionWheatHttpResponseMessage.isError()) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.d.d.bh("auth_success_anchor_2", false);
                    a.this.b(str, str2, str3, j, alaAcceptConnectionWheatHttpResponseMessage.getPushUrl(), alaAcceptConnectionWheatHttpResponseMessage.dWW());
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.a.InterfaceC0908a
            public void b(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage) {
                if (a.this.nVR != null) {
                    a.this.nVR.onFail();
                }
            }
        }).aL(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dWa(), str, str4);
    }

    public void b(String str, String str2, String str3, long j, String str4, String str5) {
        if (n.dWB().Vd(str)) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().b(this.nVT).M(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dWb(), TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), str4, str5);
            return;
        }
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dVX().a(str, str2, str3, j, com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dWb(), true, str4, str5, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.a.2
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str6) {
                if (i == 0 && a.this.nVR != null) {
                    a.this.nVR.onFail();
                }
            }
        });
        if (this.nVR != null) {
            this.nVR.Vm(str);
        }
    }

    public void a(InterfaceC0905a interfaceC0905a) {
        this.nVR = interfaceC0905a;
    }
}
