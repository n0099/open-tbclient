package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import android.net.http.Headers;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaManagerMikeHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.k;
/* loaded from: classes11.dex */
public class o {
    private String mikeStatus;
    private a oGH;

    /* loaded from: classes11.dex */
    public interface a {
        void Ae(boolean z);

        void edz();
    }

    public void gU(final String str, final String str2) {
        this.mikeStatus = str2;
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.k(null, new k.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.k.a
            public void a(AlaManagerMikeHttpResponseMessage alaManagerMikeHttpResponseMessage) {
                if (!alaManagerMikeHttpResponseMessage.isError()) {
                    o.this.gV(str, str2);
                } else if (o.this.oGH != null) {
                    o.this.oGH.edz();
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.k.a
            public void b(AlaManagerMikeHttpResponseMessage alaManagerMikeHttpResponseMessage) {
                if (o.this.oGH != null) {
                    o.this.oGH.edz();
                }
            }
        }).aU(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ym(), str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gV(String str, String str2) {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.b ecL = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ecL();
        if (ecL != null) {
            if (q.edE().VT(str)) {
                ecL.Aa(Wn(str2));
                if (this.oGH != null) {
                    this.oGH.Ae(true);
                }
            } else {
                ecL.bg(str, Wn(str2));
                if (this.oGH != null) {
                    this.oGH.Ae(false);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009, Headers.REFRESH));
        }
    }

    private boolean Wn(String str) {
        return "1".equals(str);
    }

    public void a(a aVar) {
        this.oGH = aVar;
    }

    /* loaded from: classes11.dex */
    public static abstract class b implements a {
        private String mikeStatus;

        public void Wo(String str) {
            this.mikeStatus = str;
        }

        public String edA() {
            return this.mikeStatus;
        }
    }
}
