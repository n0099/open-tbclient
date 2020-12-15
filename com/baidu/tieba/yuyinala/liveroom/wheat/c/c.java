package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import android.app.Activity;
import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.d;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaApplyWheatHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.c;
/* loaded from: classes4.dex */
public class c {
    private static c oun;
    private a ouo;

    /* loaded from: classes4.dex */
    public interface a {
        void dfy();

        void eeH();
    }

    public static c eeM() {
        if (oun == null) {
            oun = new c();
        }
        return oun;
    }

    private c() {
    }

    public void a(Context context, Activity activity, String str, String str2) {
        if (WH(str)) {
            a(context, activity, str);
        } else {
            b(context, activity, str, str2);
        }
    }

    private void a(Context context, Activity activity, final String str) {
        d.eeN().a(context, activity, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.c.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.d.a
            public void zK(boolean z) {
                if (z) {
                    if (c.this.ouo != null) {
                        c.this.ouo.dfy();
                    }
                    new com.baidu.tieba.yuyinala.liveroom.wheat.model.c(null, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.c.1.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.c.a
                        public void b(AlaApplyWheatHttpResponseMessage alaApplyWheatHttpResponseMessage) {
                            l.efa().NQ(2);
                            c.this.a(alaApplyWheatHttpResponseMessage);
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.c.a
                        public void c(AlaApplyWheatHttpResponseMessage alaApplyWheatHttpResponseMessage) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, false));
                        }
                    }).L(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().CZ(), str, "", "");
                }
            }
        });
    }

    private void b(Context context, Activity activity, final String str, final String str2) {
        d.eeN().a(context, activity, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.c.2
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.d.a
            public void zK(boolean z) {
                if (z) {
                    new com.baidu.tieba.yuyinala.liveroom.wheat.model.c(null, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.c.2.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.c.a
                        public void b(AlaApplyWheatHttpResponseMessage alaApplyWheatHttpResponseMessage) {
                            if (!alaApplyWheatHttpResponseMessage.isError() && c.this.ouo != null) {
                                c.this.ouo.eeH();
                            }
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.c.a
                        public void c(AlaApplyWheatHttpResponseMessage alaApplyWheatHttpResponseMessage) {
                        }
                    }).L(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().CZ(), str, str2, "");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaApplyWheatHttpResponseMessage alaApplyWheatHttpResponseMessage) {
        if (alaApplyWheatHttpResponseMessage.efM() == 1) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer().M(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eeu(), TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), alaApplyWheatHttpResponseMessage.getPushUrl(), alaApplyWheatHttpResponseMessage.efL());
        }
    }

    private boolean WH(String str) {
        return "1".equals(str);
    }

    public void onDestroy() {
        oun = null;
    }

    public c a(a aVar) {
        this.ouo = aVar;
        return this;
    }
}
