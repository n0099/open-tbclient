package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.android.imrtc.utils.IStatusListener;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaAcceptConnectionWheatHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.a;
/* loaded from: classes4.dex */
public class a {
    private static a oeW;
    private InterfaceC0924a oeV;
    com.baidu.tieba.yuyinala.liveroom.wheat.a.e oeX = new com.baidu.tieba.yuyinala.liveroom.wheat.a.e() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.a.3
        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
        public void onError(int i, int i2, String str) {
            if (a.this.oeV != null) {
                a.this.oeV.onFail();
            }
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
        public void MV(int i) {
            if (a.this.oeV != null) {
                a.this.oeV.onSuccess();
            }
        }
    };

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.wheat.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0924a {
        void Vr(String str);

        void onFail();

        void onSuccess();
    }

    public static a dZd() {
        if (oeW == null) {
            oeW = new a();
        }
        return oeW;
    }

    public void b(final String str, final String str2, final String str3, final long j, String str4) {
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.a(null, new a.InterfaceC0927a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.a.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.a.InterfaceC0927a
            public void a(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage) {
                if (!alaAcceptConnectionWheatHttpResponseMessage.isError()) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("auth_success_anchor_2", false);
                    a.this.b(str, str2, str3, j, alaAcceptConnectionWheatHttpResponseMessage.getPushUrl(), alaAcceptConnectionWheatHttpResponseMessage.eaf());
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.a.InterfaceC0927a
            public void b(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage) {
                if (a.this.oeV != null) {
                    a.this.oeV.onFail();
                }
            }
        }).aN(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().Br(), str, str4);
    }

    public void b(String str, String str2, String str3, long j, String str4, String str5) {
        if (o.dZz().Vf(str)) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().b(this.oeX).M(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().dYP(), TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), str4, str5);
            return;
        }
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().dYM().a(str, str2, str3, j, com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().dYP(), true, str4, str5, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.a.2
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str6) {
                if (i == 0 && a.this.oeV != null) {
                    a.this.oeV.onFail();
                }
            }
        });
        if (this.oeV != null) {
            this.oeV.Vr(str);
        }
    }

    public void a(InterfaceC0924a interfaceC0924a) {
        this.oeV = interfaceC0924a;
    }
}
