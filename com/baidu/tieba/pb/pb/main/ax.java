package com.baidu.tieba.pb.pb.main;

import android.widget.Toast;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.b.a;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class ax extends CustomMessageListener {
    final /* synthetic */ PbActivity enc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ax(PbActivity pbActivity, int i) {
        super(i);
        this.enc = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        fx fxVar;
        fx fxVar2;
        fx fxVar3;
        fx fxVar4;
        fx fxVar5;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
            com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
            boolean z = aVar.Sq == this.enc.getUniqueId();
            if (aVar instanceof a.C0036a) {
                if (aVar.Sr != null && !aVar.Sr.hasError() && aVar.Sr.getError() == 0) {
                    fxVar4 = this.enc.elU;
                    if (fxVar4 != null) {
                        fxVar5 = this.enc.elU;
                        fxVar5.v(((a.C0036a) aVar).channelId, 1);
                    }
                    if (z) {
                        this.enc.aKj();
                    }
                } else if (z) {
                    if (aVar.Sr != null && aVar.Sr.getErrorString() != null) {
                        this.enc.showToast(aVar.Sr.getErrorString());
                    } else {
                        this.enc.showToast(w.l.fail_order_video_channel);
                    }
                }
            } else if (aVar instanceof a.c) {
                if (aVar.Sr != null && !aVar.Sr.hasError() && aVar.Sr.getError() == 0) {
                    fxVar = this.enc.elU;
                    if (fxVar != null) {
                        fxVar2 = this.enc.elU;
                        if (fxVar2 != null) {
                            fxVar3 = this.enc.elU;
                            fxVar3.v(((a.C0036a) aVar).channelId, 2);
                        }
                    }
                } else if (z) {
                    if (aVar.Sr != null && aVar.Sr.getErrorString() != null) {
                        this.enc.showToast(aVar.Sr.getErrorString());
                    } else {
                        this.enc.showToast(w.l.fail_cancle_order_video_channel);
                    }
                }
            } else if (aVar instanceof a.b) {
                if (aVar.Sr == null || aVar.Sr.hasError() || aVar.Sr.getError() != 0) {
                    if (z) {
                        if (aVar.Sr != null && aVar.Sr.getErrorString() != null) {
                            this.enc.showToast(aVar.Sr.getErrorString());
                        } else {
                            this.enc.showToast(w.l.fail_open_channel_push);
                        }
                    }
                } else if (z) {
                    Toast.makeText(this.enc.getPageContext().getPageActivity(), this.enc.getPageContext().getResources().getString(w.l.channel_need_push), 1).show();
                }
            }
        }
    }
}
