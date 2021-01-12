package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import android.net.http.Headers;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaManagerMikeHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.j;
/* loaded from: classes10.dex */
public class m {
    private String mikeStatus;
    private a oxf;

    /* loaded from: classes10.dex */
    public interface a {
        void ebm();

        void zL(boolean z);
    }

    public void gN(final String str, final String str2) {
        this.mikeStatus = str2;
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.j(null, new j.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.m.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.j.a
            public void a(AlaManagerMikeHttpResponseMessage alaManagerMikeHttpResponseMessage) {
                if (!alaManagerMikeHttpResponseMessage.isError()) {
                    m.this.gO(str, str2);
                } else if (m.this.oxf != null) {
                    m.this.oxf.ebm();
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.j.a
            public void b(AlaManagerMikeHttpResponseMessage alaManagerMikeHttpResponseMessage) {
                if (m.this.oxf != null) {
                    m.this.oxf.ebm();
                }
            }
        }).aT(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().yv(), str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gO(String str, String str2) {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.b eaz = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().eaz();
        if (eaz != null) {
            if (o.ebo().UU(str)) {
                eaz.zE(Vp(str2));
                if (this.oxf != null) {
                    this.oxf.zL(true);
                }
            } else {
                eaz.bg(str, Vp(str2));
                if (this.oxf != null) {
                    this.oxf.zL(false);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009, Headers.REFRESH));
        }
    }

    private boolean Vp(String str) {
        return "1".equals(str);
    }

    public void a(a aVar) {
        this.oxf = aVar;
    }

    /* loaded from: classes10.dex */
    public static abstract class b implements a {
        private String mikeStatus;

        public void Vq(String str) {
            this.mikeStatus = str;
        }

        public String ebn() {
            return this.mikeStatus;
        }
    }
}
