package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.android.imrtc.utils.IStatusListener;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaAcceptConnectionWheatHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.a;
/* loaded from: classes4.dex */
public class a {
    private static a odt;
    private InterfaceC0921a ods;
    com.baidu.tieba.yuyinala.liveroom.wheat.a.e odu = new com.baidu.tieba.yuyinala.liveroom.wheat.a.e() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.a.3
        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
        public void onError(int i, int i2, String str) {
            if (a.this.ods != null) {
                a.this.ods.onFail();
            }
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
        public void Ms(int i) {
            if (a.this.ods != null) {
                a.this.ods.onSuccess();
            }
        }
    };

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.wheat.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0921a {
        void VG(String str);

        void onFail();

        void onSuccess();
    }

    public static a dZe() {
        if (odt == null) {
            odt = new a();
        }
        return odt;
    }

    public void b(final String str, final String str2, final String str3, final long j, String str4) {
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.a(null, new a.InterfaceC0924a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.a.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.a.InterfaceC0924a
            public void a(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage) {
                if (!alaAcceptConnectionWheatHttpResponseMessage.isError()) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("auth_success_anchor_2", false);
                    a.this.b(str, str2, str3, j, alaAcceptConnectionWheatHttpResponseMessage.getPushUrl(), alaAcceptConnectionWheatHttpResponseMessage.eag());
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.a.InterfaceC0924a
            public void b(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage) {
                if (a.this.ods != null) {
                    a.this.ods.onFail();
                }
            }
        }).aN(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().Ca(), str, str4);
    }

    public void b(String str, String str2, String str3, long j, String str4, String str5) {
        if (o.dZA().Vu(str)) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().b(this.odu).M(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().dYQ(), TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), str4, str5);
            return;
        }
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().dYN().a(str, str2, str3, j, com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().dYQ(), true, str4, str5, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.a.2
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str6) {
                if (i == 0 && a.this.ods != null) {
                    a.this.ods.onFail();
                }
            }
        });
        if (this.ods != null) {
            this.ods.VG(str);
        }
    }

    public void a(InterfaceC0921a interfaceC0921a) {
        this.ods = interfaceC0921a;
    }
}
