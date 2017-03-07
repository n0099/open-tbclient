package com.baidu.tieba.pb.pb.main;

import android.widget.Toast;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.b.a;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class at extends CustomMessageListener {
    final /* synthetic */ PbActivity elO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public at(PbActivity pbActivity, int i) {
        super(i);
        this.elO = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        fa faVar;
        fa faVar2;
        fa faVar3;
        fa faVar4;
        fa faVar5;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
            com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
            boolean z = aVar.SQ == this.elO.getUniqueId();
            if (aVar instanceof a.C0032a) {
                if (aVar.SR != null && !aVar.SR.hasError() && aVar.SR.getError() == 0) {
                    faVar4 = this.elO.ekM;
                    if (faVar4 != null) {
                        faVar5 = this.elO.ekM;
                        faVar5.x(((a.C0032a) aVar).channelId, 1);
                    }
                    if (z) {
                        this.elO.aKO();
                    }
                } else if (z) {
                    if (aVar.SR != null && aVar.SR.getErrorString() != null) {
                        this.elO.showToast(aVar.SR.getErrorString());
                    } else {
                        this.elO.showToast(w.l.fail_order_video_channel);
                    }
                }
            } else if (aVar instanceof a.c) {
                if (aVar.SR != null && !aVar.SR.hasError() && aVar.SR.getError() == 0) {
                    faVar = this.elO.ekM;
                    if (faVar != null) {
                        faVar2 = this.elO.ekM;
                        if (faVar2 != null) {
                            faVar3 = this.elO.ekM;
                            faVar3.x(((a.C0032a) aVar).channelId, 2);
                        }
                    }
                } else if (z) {
                    if (aVar.SR != null && aVar.SR.getErrorString() != null) {
                        this.elO.showToast(aVar.SR.getErrorString());
                    } else {
                        this.elO.showToast(w.l.fail_cancle_order_video_channel);
                    }
                }
            } else if (aVar instanceof a.b) {
                if (aVar.SR == null || aVar.SR.hasError() || aVar.SR.getError() != 0) {
                    if (z) {
                        if (aVar.SR != null && aVar.SR.getErrorString() != null) {
                            this.elO.showToast(aVar.SR.getErrorString());
                        } else {
                            this.elO.showToast(w.l.fail_open_channel_push);
                        }
                    }
                } else if (z) {
                    Toast.makeText(this.elO.getPageContext().getPageActivity(), this.elO.getPageContext().getResources().getString(w.l.channel_need_push), 1).show();
                }
            }
        }
    }
}
