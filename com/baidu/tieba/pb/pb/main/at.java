package com.baidu.tieba.pb.pb.main;

import android.widget.Toast;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.b.a;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class at extends CustomMessageListener {
    final /* synthetic */ PbActivity ejU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public at(PbActivity pbActivity, int i) {
        super(i);
        this.ejU = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ey eyVar;
        ey eyVar2;
        ey eyVar3;
        ey eyVar4;
        ey eyVar5;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
            com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
            boolean z = aVar.Ti == this.ejU.getUniqueId();
            if (aVar instanceof a.C0031a) {
                if (aVar.Tj != null && !aVar.Tj.hasError() && aVar.Tj.getError() == 0) {
                    eyVar4 = this.ejU.eiS;
                    if (eyVar4 != null) {
                        eyVar5 = this.ejU.eiS;
                        eyVar5.x(((a.C0031a) aVar).channelId, 1);
                    }
                    if (z) {
                        this.ejU.aKU();
                    }
                } else if (z) {
                    if (aVar.Tj != null && aVar.Tj.getErrorString() != null) {
                        this.ejU.showToast(aVar.Tj.getErrorString());
                    } else {
                        this.ejU.showToast(w.l.fail_order_video_channel);
                    }
                }
            } else if (aVar instanceof a.c) {
                if (aVar.Tj != null && !aVar.Tj.hasError() && aVar.Tj.getError() == 0) {
                    eyVar = this.ejU.eiS;
                    if (eyVar != null) {
                        eyVar2 = this.ejU.eiS;
                        if (eyVar2 != null) {
                            eyVar3 = this.ejU.eiS;
                            eyVar3.x(((a.C0031a) aVar).channelId, 2);
                        }
                    }
                } else if (z) {
                    if (aVar.Tj != null && aVar.Tj.getErrorString() != null) {
                        this.ejU.showToast(aVar.Tj.getErrorString());
                    } else {
                        this.ejU.showToast(w.l.fail_cancle_order_video_channel);
                    }
                }
            } else if (aVar instanceof a.b) {
                if (aVar.Tj == null || aVar.Tj.hasError() || aVar.Tj.getError() != 0) {
                    if (z) {
                        if (aVar.Tj != null && aVar.Tj.getErrorString() != null) {
                            this.ejU.showToast(aVar.Tj.getErrorString());
                        } else {
                            this.ejU.showToast(w.l.fail_open_channel_push);
                        }
                    }
                } else if (z) {
                    Toast.makeText(this.ejU.getPageContext().getPageActivity(), this.ejU.getPageContext().getResources().getString(w.l.channel_need_push), 1).show();
                }
            }
        }
    }
}
