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
    private static c odI;
    private a odJ;

    /* loaded from: classes4.dex */
    public interface a {
        void dZd();

        void daO();
    }

    public static c dZi() {
        if (odI == null) {
            odI = new c();
        }
        return odI;
    }

    private c() {
    }

    public void a(Context context, Activity activity, String str, String str2) {
        if (VH(str)) {
            a(context, activity, str);
        } else {
            b(context, activity, str, str2);
        }
    }

    private void a(Context context, Activity activity, final String str) {
        d.dZj().a(context, activity, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.c.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.d.a
            public void yZ(boolean z) {
                if (z) {
                    if (c.this.odJ != null) {
                        c.this.odJ.daO();
                    }
                    new com.baidu.tieba.yuyinala.liveroom.wheat.model.c(null, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.c.1.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.c.a
                        public void b(AlaApplyWheatHttpResponseMessage alaApplyWheatHttpResponseMessage) {
                            l.dZw().Mv(2);
                            c.this.a(alaApplyWheatHttpResponseMessage);
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.c.a
                        public void c(AlaApplyWheatHttpResponseMessage alaApplyWheatHttpResponseMessage) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, false));
                        }
                    }).L(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().Ca(), str, "", "");
                }
            }
        });
    }

    private void b(Context context, Activity activity, final String str, final String str2) {
        d.dZj().a(context, activity, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.c.2
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.d.a
            public void yZ(boolean z) {
                if (z) {
                    new com.baidu.tieba.yuyinala.liveroom.wheat.model.c(null, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.c.2.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.c.a
                        public void b(AlaApplyWheatHttpResponseMessage alaApplyWheatHttpResponseMessage) {
                            if (!alaApplyWheatHttpResponseMessage.isError() && c.this.odJ != null) {
                                c.this.odJ.dZd();
                            }
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.c.a
                        public void c(AlaApplyWheatHttpResponseMessage alaApplyWheatHttpResponseMessage) {
                        }
                    }).L(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().Ca(), str, str2, "");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaApplyWheatHttpResponseMessage alaApplyWheatHttpResponseMessage) {
        if (alaApplyWheatHttpResponseMessage.eah() == 1) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().dYN().M(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().dYQ(), TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), alaApplyWheatHttpResponseMessage.getPushUrl(), alaApplyWheatHttpResponseMessage.eag());
        }
    }

    private boolean VH(String str) {
        return "1".equals(str);
    }

    public void onDestroy() {
        odI = null;
    }

    public c a(a aVar) {
        this.odJ = aVar;
        return this;
    }
}
