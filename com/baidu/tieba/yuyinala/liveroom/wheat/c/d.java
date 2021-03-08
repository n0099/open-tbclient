package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import android.app.Activity;
import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes10.dex */
public class d {
    public static d oIv;
    private a oIw;
    private CustomMessageListener oIx = new CustomMessageListener(2501046) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501046) {
                if (d.this.oIw != null) {
                    d.this.oIw.Aa(true);
                }
                MessageManager.getInstance().unRegisterListener(d.this.oIx);
            }
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void Aa(boolean z);
    }

    public static d edx() {
        if (oIv == null) {
            oIv = new d();
        }
        return oIv;
    }

    public void a(Context context, Activity activity, a aVar) {
        if (com.baidu.tieba.yuyinala.liveroom.wheat.e.f.a(context, activity)) {
            if (aVar != null) {
                aVar.Aa(true);
                return;
            }
            return;
        }
        this.oIw = aVar;
        MessageManager.getInstance().registerListener(this.oIx);
    }
}
