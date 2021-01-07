package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import android.net.http.Headers;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaManagerMikeHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.j;
/* loaded from: classes11.dex */
public class m {
    private String mikeStatus;
    private a oBK;

    /* loaded from: classes11.dex */
    public interface a {
        void efe();

        void zP(boolean z);
    }

    public void gO(final String str, final String str2) {
        this.mikeStatus = str2;
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.j(null, new j.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.m.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.j.a
            public void a(AlaManagerMikeHttpResponseMessage alaManagerMikeHttpResponseMessage) {
                if (!alaManagerMikeHttpResponseMessage.isError()) {
                    m.this.gP(str, str2);
                } else if (m.this.oBK != null) {
                    m.this.oBK.efe();
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.j.a
            public void b(AlaManagerMikeHttpResponseMessage alaManagerMikeHttpResponseMessage) {
                if (m.this.oBK != null) {
                    m.this.oBK.efe();
                }
            }
        }).aU(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().Cq(), str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gP(String str, String str2) {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.b eer = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer();
        if (eer != null) {
            if (o.efg().Wc(str)) {
                eer.zI(Wx(str2));
                if (this.oBK != null) {
                    this.oBK.zP(true);
                }
            } else {
                eer.bg(str, Wx(str2));
                if (this.oBK != null) {
                    this.oBK.zP(false);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009, Headers.REFRESH));
        }
    }

    private boolean Wx(String str) {
        return "1".equals(str);
    }

    public void a(a aVar) {
        this.oBK = aVar;
    }

    /* loaded from: classes11.dex */
    public static abstract class b implements a {
        private String mikeStatus;

        public void Wy(String str) {
            this.mikeStatus = str;
        }

        public String eff() {
            return this.mikeStatus;
        }
    }
}
