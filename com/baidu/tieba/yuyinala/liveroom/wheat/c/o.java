package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import android.net.http.Headers;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaManagerMikeHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.k;
/* loaded from: classes10.dex */
public class o {
    private String mikeStatus;
    private a oJm;

    /* loaded from: classes10.dex */
    public interface a {
        void Ad(boolean z);

        void edP();
    }

    public void gW(final String str, final String str2) {
        this.mikeStatus = str2;
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.k(null, new k.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.k.a
            public void a(AlaManagerMikeHttpResponseMessage alaManagerMikeHttpResponseMessage) {
                if (!alaManagerMikeHttpResponseMessage.isError()) {
                    o.this.gX(str, str2);
                } else if (o.this.oJm != null) {
                    o.this.oJm.edP();
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.k.a
            public void b(AlaManagerMikeHttpResponseMessage alaManagerMikeHttpResponseMessage) {
                if (o.this.oJm != null) {
                    o.this.oJm.edP();
                }
            }
        }).aU(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().yp(), str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gX(String str, String str2) {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.b edb = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().edb();
        if (edb != null) {
            if (q.edU().Wm(str)) {
                edb.zZ(WG(str2));
                if (this.oJm != null) {
                    this.oJm.Ad(true);
                }
            } else {
                edb.bg(str, WG(str2));
                if (this.oJm != null) {
                    this.oJm.Ad(false);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009, Headers.REFRESH));
        }
    }

    private boolean WG(String str) {
        return "1".equals(str);
    }

    public void a(a aVar) {
        this.oJm = aVar;
    }

    /* loaded from: classes10.dex */
    public static abstract class b implements a {
        private String mikeStatus;

        public void WH(String str) {
            this.mikeStatus = str;
        }

        public String edQ() {
            return this.mikeStatus;
        }
    }
}
