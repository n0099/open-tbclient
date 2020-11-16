package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import android.net.http.Headers;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaManagerMikeHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.i;
/* loaded from: classes4.dex */
public class m {
    private String mikeStatus;
    private a ofX;

    /* loaded from: classes4.dex */
    public interface a {
        void dZx();

        void zj(boolean z);
    }

    public void gL(final String str, final String str2) {
        this.mikeStatus = str2;
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.i(null, new i.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.m.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.i.a
            public void a(AlaManagerMikeHttpResponseMessage alaManagerMikeHttpResponseMessage) {
                if (!alaManagerMikeHttpResponseMessage.isError()) {
                    m.this.gM(str, str2);
                } else if (m.this.ofX != null) {
                    m.this.ofX.dZx();
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.i.a
            public void b(AlaManagerMikeHttpResponseMessage alaManagerMikeHttpResponseMessage) {
                if (m.this.ofX != null) {
                    m.this.ofX.dZx();
                }
            }
        }).aN(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().Br(), str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gM(String str, String str2) {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.b dYM = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().dYM();
        if (dYM != null) {
            if (o.dZz().Vf(str)) {
                dYM.zc(Vz(str2));
                if (this.ofX != null) {
                    this.ofX.zj(true);
                }
            } else {
                dYM.bg(str, Vz(str2));
                if (this.ofX != null) {
                    this.ofX.zj(false);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009, Headers.REFRESH));
        }
    }

    private boolean Vz(String str) {
        return "1".equals(str);
    }

    public void a(a aVar) {
        this.ofX = aVar;
    }

    /* loaded from: classes4.dex */
    public static abstract class b implements a {
        private String mikeStatus;

        public void VA(String str) {
            this.mikeStatus = str;
        }

        public String dZy() {
            return this.mikeStatus;
        }
    }
}
