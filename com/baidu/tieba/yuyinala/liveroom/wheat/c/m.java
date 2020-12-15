package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import android.net.http.Headers;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaManagerMikeHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.i;
/* loaded from: classes4.dex */
public class m {
    private String mikeStatus;
    private a ouZ;

    /* loaded from: classes4.dex */
    public interface a {
        void efc();

        void zN(boolean z);
    }

    public void gQ(final String str, final String str2) {
        this.mikeStatus = str2;
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.i(null, new i.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.m.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.i.a
            public void a(AlaManagerMikeHttpResponseMessage alaManagerMikeHttpResponseMessage) {
                if (!alaManagerMikeHttpResponseMessage.isError()) {
                    m.this.gR(str, str2);
                } else if (m.this.ouZ != null) {
                    m.this.ouZ.efc();
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.i.a
            public void b(AlaManagerMikeHttpResponseMessage alaManagerMikeHttpResponseMessage) {
                if (m.this.ouZ != null) {
                    m.this.ouZ.efc();
                }
            }
        }).aQ(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().CZ(), str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gR(String str, String str2) {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.b eer = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer();
        if (eer != null) {
            if (o.efe().Wu(str)) {
                eer.zG(WO(str2));
                if (this.ouZ != null) {
                    this.ouZ.zN(true);
                }
            } else {
                eer.bh(str, WO(str2));
                if (this.ouZ != null) {
                    this.ouZ.zN(false);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009, Headers.REFRESH));
        }
    }

    private boolean WO(String str) {
        return "1".equals(str);
    }

    public void a(a aVar) {
        this.ouZ = aVar;
    }

    /* loaded from: classes4.dex */
    public static abstract class b implements a {
        private String mikeStatus;

        public void WP(String str) {
            this.mikeStatus = str;
        }

        public String efd() {
            return this.mikeStatus;
        }
    }
}
