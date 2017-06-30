package com.baidu.tieba.pb.pb.main;

import android.widget.Toast;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.b.a;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class bb extends CustomMessageListener {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bb(PbActivity pbActivity, int i) {
        super(i);
        this.ewh = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        gg ggVar;
        gg ggVar2;
        gg ggVar3;
        gg ggVar4;
        gg ggVar5;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
            com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
            boolean z = aVar.Sl == this.ewh.getUniqueId();
            if (aVar instanceof a.C0038a) {
                if (aVar.Sm != null && !aVar.Sm.hasError() && aVar.Sm.getError() == 0) {
                    ggVar4 = this.ewh.euU;
                    if (ggVar4 != null) {
                        ggVar5 = this.ewh.euU;
                        ggVar5.w(((a.C0038a) aVar).channelId, 1);
                    }
                    if (z) {
                        this.ewh.aOg();
                    }
                } else if (z) {
                    if (aVar.Sm != null && aVar.Sm.getErrorString() != null) {
                        this.ewh.showToast(aVar.Sm.getErrorString());
                    } else {
                        this.ewh.showToast(w.l.fail_order_video_channel);
                    }
                }
            } else if (aVar instanceof a.c) {
                if (aVar.Sm != null && !aVar.Sm.hasError() && aVar.Sm.getError() == 0) {
                    ggVar = this.ewh.euU;
                    if (ggVar != null) {
                        ggVar2 = this.ewh.euU;
                        if (ggVar2 != null) {
                            ggVar3 = this.ewh.euU;
                            ggVar3.w(((a.C0038a) aVar).channelId, 2);
                        }
                    }
                } else if (z) {
                    if (aVar.Sm != null && aVar.Sm.getErrorString() != null) {
                        this.ewh.showToast(aVar.Sm.getErrorString());
                    } else {
                        this.ewh.showToast(w.l.fail_cancle_order_video_channel);
                    }
                }
            } else if (aVar instanceof a.b) {
                if (aVar.Sm == null || aVar.Sm.hasError() || aVar.Sm.getError() != 0) {
                    if (z) {
                        if (aVar.Sm != null && aVar.Sm.getErrorString() != null) {
                            this.ewh.showToast(aVar.Sm.getErrorString());
                        } else {
                            this.ewh.showToast(w.l.fail_open_channel_push);
                        }
                    }
                } else if (z) {
                    Toast.makeText(this.ewh.getPageContext().getPageActivity(), this.ewh.getPageContext().getResources().getString(w.l.channel_need_push), 1).show();
                }
            }
        }
    }
}
