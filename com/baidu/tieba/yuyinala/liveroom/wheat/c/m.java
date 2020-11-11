package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import android.net.http.Headers;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaManagerMikeHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.i;
/* loaded from: classes4.dex */
public class m {
    private String mikeStatus;
    private a oet;

    /* loaded from: classes4.dex */
    public interface a {
        void dZy();

        void zc(boolean z);
    }

    public void gL(final String str, final String str2) {
        this.mikeStatus = str2;
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.i(null, new i.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.m.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.i.a
            public void a(AlaManagerMikeHttpResponseMessage alaManagerMikeHttpResponseMessage) {
                if (!alaManagerMikeHttpResponseMessage.isError()) {
                    m.this.gM(str, str2);
                } else if (m.this.oet != null) {
                    m.this.oet.dZy();
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.i.a
            public void b(AlaManagerMikeHttpResponseMessage alaManagerMikeHttpResponseMessage) {
                if (m.this.oet != null) {
                    m.this.oet.dZy();
                }
            }
        }).aN(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().Ca(), str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gM(String str, String str2) {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.b dYN = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().dYN();
        if (dYN != null) {
            if (o.dZA().Vu(str)) {
                dYN.yV(VO(str2));
                if (this.oet != null) {
                    this.oet.zc(true);
                }
            } else {
                dYN.bg(str, VO(str2));
                if (this.oet != null) {
                    this.oet.zc(false);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009, Headers.REFRESH));
        }
    }

    private boolean VO(String str) {
        return "1".equals(str);
    }

    public void a(a aVar) {
        this.oet = aVar;
    }

    /* loaded from: classes4.dex */
    public static abstract class b implements a {
        private String mikeStatus;

        public void VP(String str) {
            this.mikeStatus = str;
        }

        public String dZz() {
            return this.mikeStatus;
        }
    }
}
