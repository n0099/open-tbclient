package com.baidu.tieba.yuyinala.liveroom.wheat.b;

import android.app.Activity;
import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.yuyinala.liveroom.wheat.b.d;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.c;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaApplyWheatHttpResponseMessage;
/* loaded from: classes4.dex */
public class c {
    private static c nWh;
    private a nWi;

    /* loaded from: classes4.dex */
    public interface a {
        void cYn();

        void dWk();
    }

    public static c dWj() {
        if (nWh == null) {
            nWh = new c();
        }
        return nWh;
    }

    private c() {
    }

    public void a(Context context, Activity activity, String str) {
        if (Vn(str)) {
            b(context, activity, str);
        } else {
            c(context, activity, str);
        }
    }

    private void b(Context context, Activity activity, final String str) {
        d.dWl().a(context, activity, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.c.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.d.a
            public void yR(boolean z) {
                if (z) {
                    if (c.this.nWi != null) {
                        c.this.nWi.cYn();
                    }
                    new com.baidu.tieba.yuyinala.liveroom.wheat.c.c(null, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.c.1.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
                        public void b(AlaApplyWheatHttpResponseMessage alaApplyWheatHttpResponseMessage) {
                            k.dWx().Me(2);
                            c.this.a(alaApplyWheatHttpResponseMessage);
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
                        public void c(AlaApplyWheatHttpResponseMessage alaApplyWheatHttpResponseMessage) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, false));
                        }
                    }).aL(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dWa(), str, "");
                }
            }
        });
    }

    private void c(Context context, Activity activity, final String str) {
        d.dWl().a(context, activity, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.c.2
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.d.a
            public void yR(boolean z) {
                if (z) {
                    new com.baidu.tieba.yuyinala.liveroom.wheat.c.c(null, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.c.2.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
                        public void b(AlaApplyWheatHttpResponseMessage alaApplyWheatHttpResponseMessage) {
                            if (!alaApplyWheatHttpResponseMessage.isError() && c.this.nWi != null) {
                                c.this.nWi.dWk();
                            }
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
                        public void c(AlaApplyWheatHttpResponseMessage alaApplyWheatHttpResponseMessage) {
                        }
                    }).aL(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dWa(), str, "");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaApplyWheatHttpResponseMessage alaApplyWheatHttpResponseMessage) {
        if (alaApplyWheatHttpResponseMessage.dWX() == 1) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dVX().M(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dWb(), TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), alaApplyWheatHttpResponseMessage.getPushUrl(), alaApplyWheatHttpResponseMessage.dWW());
        }
    }

    private boolean Vn(String str) {
        return "1".equals(str);
    }

    public void onDestroy() {
        nWh = null;
    }

    public c a(a aVar) {
        this.nWi = aVar;
        return this;
    }
}
