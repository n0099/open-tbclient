package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import android.view.View;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.audiolive.NewFrameHttpResponseMessage;
import com.baidu.live.audiolive.a;
import com.baidu.live.data.ab;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.FrameNumCallBackHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.g;
/* loaded from: classes11.dex */
public class j {
    public void a(final View view, final BdPageContext bdPageContext, final ab abVar) {
        new com.baidu.live.audiolive.a(null, new a.InterfaceC0164a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.j.1
            @Override // com.baidu.live.audiolive.a.InterfaceC0164a
            public void a(NewFrameHttpResponseMessage newFrameHttpResponseMessage) {
                if (newFrameHttpResponseMessage != null && newFrameHttpResponseMessage.zJ() > 0) {
                    e.edi().a(view, newFrameHttpResponseMessage.zI(), bdPageContext, abVar);
                    j.this.edr();
                }
            }

            @Override // com.baidu.live.audiolive.a.InterfaceC0164a
            public void onFail(int i, String str) {
            }
        }).request();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edr() {
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.g(null, new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.j.2
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.g.a
            public void a(FrameNumCallBackHttpResponseMessage frameNumCallBackHttpResponseMessage) {
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.g.a
            public void onFail(int i, String str) {
            }
        }).request("bubble");
    }
}
