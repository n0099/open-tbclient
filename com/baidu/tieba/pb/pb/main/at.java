package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.b.a;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class at extends CustomMessageListener {
    final /* synthetic */ PbActivity eiV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public at(PbActivity pbActivity, int i) {
        super(i);
        this.eiV = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ez ezVar;
        ez ezVar2;
        ez ezVar3;
        ez ezVar4;
        ez ezVar5;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
            com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
            boolean z = aVar.NM == this.eiV.getUniqueId();
            if (aVar instanceof a.C0033a) {
                if (aVar.NN != null && !aVar.NN.hasError() && aVar.NN.getError() == 0) {
                    ezVar4 = this.eiV.ehV;
                    if (ezVar4 != null) {
                        ezVar5 = this.eiV.ehV;
                        ezVar5.x(((a.C0033a) aVar).channelId, 1);
                    }
                    if (z) {
                        this.eiV.aLt();
                    }
                } else if (z) {
                    if (aVar.NN != null && aVar.NN.getErrorString() != null) {
                        this.eiV.showToast(aVar.NN.getErrorString());
                    } else {
                        this.eiV.showToast(r.l.fail_order_video_channel);
                    }
                }
            } else if (aVar instanceof a.c) {
                if (aVar.NN != null && !aVar.NN.hasError() && aVar.NN.getError() == 0) {
                    ezVar = this.eiV.ehV;
                    if (ezVar != null) {
                        ezVar2 = this.eiV.ehV;
                        if (ezVar2 != null) {
                            ezVar3 = this.eiV.ehV;
                            ezVar3.x(((a.C0033a) aVar).channelId, 2);
                        }
                    }
                } else if (z) {
                    if (aVar.NN != null && aVar.NN.getErrorString() != null) {
                        this.eiV.showToast(aVar.NN.getErrorString());
                    } else {
                        this.eiV.showToast(r.l.fail_cancle_order_video_channel);
                    }
                }
            } else if (aVar instanceof a.b) {
                if (aVar.NN == null || aVar.NN.hasError() || aVar.NN.getError() != 0) {
                    if (z) {
                        if (aVar.NN != null && aVar.NN.getErrorString() != null) {
                            this.eiV.showToast(aVar.NN.getErrorString());
                        } else {
                            this.eiV.showToast(r.l.fail_open_channel_push);
                        }
                    }
                } else if (z) {
                    this.eiV.showToast(r.l.success_open_channel_push);
                }
            }
        }
    }
}
