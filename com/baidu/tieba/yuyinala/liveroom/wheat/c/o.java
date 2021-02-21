package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import android.net.http.Headers;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaManagerMikeHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.k;
/* loaded from: classes11.dex */
public class o {
    private String mikeStatus;
    private a oHh;

    /* loaded from: classes11.dex */
    public interface a {
        void Ae(boolean z);

        void edH();
    }

    public void gW(final String str, final String str2) {
        this.mikeStatus = str2;
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.k(null, new k.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.k.a
            public void a(AlaManagerMikeHttpResponseMessage alaManagerMikeHttpResponseMessage) {
                if (!alaManagerMikeHttpResponseMessage.isError()) {
                    o.this.gX(str, str2);
                } else if (o.this.oHh != null) {
                    o.this.oHh.edH();
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.k.a
            public void b(AlaManagerMikeHttpResponseMessage alaManagerMikeHttpResponseMessage) {
                if (o.this.oHh != null) {
                    o.this.oHh.edH();
                }
            }
        }).aU(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ym(), str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gX(String str, String str2) {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.b ecT = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecT();
        if (ecT != null) {
            if (q.edM().Wf(str)) {
                ecT.Aa(Wz(str2));
                if (this.oHh != null) {
                    this.oHh.Ae(true);
                }
            } else {
                ecT.bg(str, Wz(str2));
                if (this.oHh != null) {
                    this.oHh.Ae(false);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009, Headers.REFRESH));
        }
    }

    private boolean Wz(String str) {
        return "1".equals(str);
    }

    public void a(a aVar) {
        this.oHh = aVar;
    }

    /* loaded from: classes11.dex */
    public static abstract class b implements a {
        private String mikeStatus;

        public void WA(String str) {
            this.mikeStatus = str;
        }

        public String edI() {
            return this.mikeStatus;
        }
    }
}
