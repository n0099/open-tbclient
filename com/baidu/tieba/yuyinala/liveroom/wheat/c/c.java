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
    private static c oul;
    private a oum;

    /* loaded from: classes4.dex */
    public interface a {
        void dfx();

        void eeG();
    }

    public static c eeL() {
        if (oul == null) {
            oul = new c();
        }
        return oul;
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
        d.eeM().a(context, activity, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.c.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.d.a
            public void zK(boolean z) {
                if (z) {
                    if (c.this.oum != null) {
                        c.this.oum.dfx();
                    }
                    new com.baidu.tieba.yuyinala.liveroom.wheat.model.c(null, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.c.1.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.c.a
                        public void b(AlaApplyWheatHttpResponseMessage alaApplyWheatHttpResponseMessage) {
                            l.eeZ().NQ(2);
                            c.this.a(alaApplyWheatHttpResponseMessage);
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.c.a
                        public void c(AlaApplyWheatHttpResponseMessage alaApplyWheatHttpResponseMessage) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, false));
                        }
                    }).L(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().CZ(), str, "", "");
                }
            }
        });
    }

    private void b(Context context, Activity activity, final String str, final String str2) {
        d.eeM().a(context, activity, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.c.2
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.d.a
            public void zK(boolean z) {
                if (z) {
                    new com.baidu.tieba.yuyinala.liveroom.wheat.model.c(null, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.c.2.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.c.a
                        public void b(AlaApplyWheatHttpResponseMessage alaApplyWheatHttpResponseMessage) {
                            if (!alaApplyWheatHttpResponseMessage.isError() && c.this.oum != null) {
                                c.this.oum.eeG();
                            }
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.c.a
                        public void c(AlaApplyWheatHttpResponseMessage alaApplyWheatHttpResponseMessage) {
                        }
                    }).L(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().CZ(), str, str2, "");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaApplyWheatHttpResponseMessage alaApplyWheatHttpResponseMessage) {
        if (alaApplyWheatHttpResponseMessage.efL() == 1) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq().M(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eet(), TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), alaApplyWheatHttpResponseMessage.getPushUrl(), alaApplyWheatHttpResponseMessage.efK());
        }
    }

    private boolean WH(String str) {
        return "1".equals(str);
    }

    public void onDestroy() {
        oul = null;
    }

    public c a(a aVar) {
        this.oum = aVar;
        return this;
    }
}
