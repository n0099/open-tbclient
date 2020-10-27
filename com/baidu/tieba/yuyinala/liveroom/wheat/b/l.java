package com.baidu.tieba.yuyinala.liveroom.wheat.b;

import android.net.http.Headers;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.i;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaManagerMikeHttpResponseMessage;
/* loaded from: classes4.dex */
public class l {
    private String mikeStatus;
    private a nWU;

    /* loaded from: classes4.dex */
    public interface a {
        void dWz();

        void yU(boolean z);
    }

    public void gL(final String str, final String str2) {
        this.mikeStatus = str2;
        new com.baidu.tieba.yuyinala.liveroom.wheat.c.i(null, new i.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.l.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.i.a
            public void a(AlaManagerMikeHttpResponseMessage alaManagerMikeHttpResponseMessage) {
                if (!alaManagerMikeHttpResponseMessage.isError()) {
                    l.this.gM(str, str2);
                } else if (l.this.nWU != null) {
                    l.this.nWU.dWz();
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.i.a
            public void b(AlaManagerMikeHttpResponseMessage alaManagerMikeHttpResponseMessage) {
                if (l.this.nWU != null) {
                    l.this.nWU.dWz();
                }
            }
        }).aL(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dWa(), str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gM(String str, String str2) {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.b dVX = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dVX();
        if (dVX != null) {
            if (n.dWB().Vd(str)) {
                dVX.yN(Vr(str2));
                if (this.nWU != null) {
                    this.nWU.yU(true);
                }
            } else {
                dVX.bg(str, Vr(str2));
                if (this.nWU != null) {
                    this.nWU.yU(false);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009, Headers.REFRESH));
        }
    }

    private boolean Vr(String str) {
        return "1".equals(str);
    }

    public void a(a aVar) {
        this.nWU = aVar;
    }

    /* loaded from: classes4.dex */
    public static abstract class b implements a {
        private String mikeStatus;

        public void Vs(String str) {
            this.mikeStatus = str;
        }

        public String dWA() {
            return this.mikeStatus;
        }
    }
}
