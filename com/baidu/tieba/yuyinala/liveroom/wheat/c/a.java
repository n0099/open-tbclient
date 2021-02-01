package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.android.imrtc.utils.IStatusListener;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaAcceptConnectionWheatHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.a;
/* loaded from: classes11.dex */
public class a {
    private static a oFv;
    private InterfaceC0942a oFu;
    com.baidu.tieba.yuyinala.liveroom.wheat.a.e oFw = new com.baidu.tieba.yuyinala.liveroom.wheat.a.e() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.a.3
        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
        public void onError(int i, int i2, String str) {
            if (a.this.oFu != null) {
                a.this.oFu.onFail();
            }
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
        public void Mt(int i) {
            if (a.this.oFu != null) {
                a.this.oFu.onSuccess();
            }
        }
    };

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.wheat.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0942a {
        void Wf(String str);

        void onFail();

        void onSuccess();
    }

    public static a edd() {
        if (oFv == null) {
            oFv = new a();
        }
        return oFv;
    }

    public void a(final String str, final String str2, final String str3, final long j, String str4) {
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.a(null, new a.InterfaceC0945a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.a.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.a.InterfaceC0945a
            public void a(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage) {
                if (!alaAcceptConnectionWheatHttpResponseMessage.isError()) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("auth_success_anchor_2", false);
                    a.this.a(str, str2, str3, j, alaAcceptConnectionWheatHttpResponseMessage.getPushUrl(), alaAcceptConnectionWheatHttpResponseMessage.eer());
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.a.InterfaceC0945a
            public void b(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage) {
                if (a.this.oFu != null) {
                    a.this.oFu.onFail();
                }
            }
        }).aU(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ym(), str, str4);
    }

    public void a(String str, String str2, String str3, long j, String str4, String str5) {
        if (q.edE().VT(str)) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().b(this.oFw).J(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ecO(), TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), str4, str5);
            return;
        }
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ecL().a(str, str2, str3, j, com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ecO(), true, str4, str5, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.a.2
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str6) {
                if (i != 0 && a.this.oFu != null) {
                    a.this.oFu.onFail();
                }
            }
        });
        if (this.oFu != null) {
            this.oFu.Wf(str);
        }
    }

    public void a(InterfaceC0942a interfaceC0942a) {
        this.oFu = interfaceC0942a;
    }
}
