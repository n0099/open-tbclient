package com.baidu.tieba.pb.pb.main;

import android.widget.Toast;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.b.a;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class at extends CustomMessageListener {
    final /* synthetic */ PbActivity emk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public at(PbActivity pbActivity, int i) {
        super(i);
        this.emk = pbActivity;
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
            boolean z = aVar.Tk == this.emk.getUniqueId();
            if (aVar instanceof a.C0031a) {
                if (aVar.Tl != null && !aVar.Tl.hasError() && aVar.Tl.getError() == 0) {
                    eyVar4 = this.emk.eli;
                    if (eyVar4 != null) {
                        eyVar5 = this.emk.eli;
                        eyVar5.x(((a.C0031a) aVar).channelId, 1);
                    }
                    if (z) {
                        this.emk.aLU();
                    }
                } else if (z) {
                    if (aVar.Tl != null && aVar.Tl.getErrorString() != null) {
                        this.emk.showToast(aVar.Tl.getErrorString());
                    } else {
                        this.emk.showToast(w.l.fail_order_video_channel);
                    }
                }
            } else if (aVar instanceof a.c) {
                if (aVar.Tl != null && !aVar.Tl.hasError() && aVar.Tl.getError() == 0) {
                    eyVar = this.emk.eli;
                    if (eyVar != null) {
                        eyVar2 = this.emk.eli;
                        if (eyVar2 != null) {
                            eyVar3 = this.emk.eli;
                            eyVar3.x(((a.C0031a) aVar).channelId, 2);
                        }
                    }
                } else if (z) {
                    if (aVar.Tl != null && aVar.Tl.getErrorString() != null) {
                        this.emk.showToast(aVar.Tl.getErrorString());
                    } else {
                        this.emk.showToast(w.l.fail_cancle_order_video_channel);
                    }
                }
            } else if (aVar instanceof a.b) {
                if (aVar.Tl == null || aVar.Tl.hasError() || aVar.Tl.getError() != 0) {
                    if (z) {
                        if (aVar.Tl != null && aVar.Tl.getErrorString() != null) {
                            this.emk.showToast(aVar.Tl.getErrorString());
                        } else {
                            this.emk.showToast(w.l.fail_open_channel_push);
                        }
                    }
                } else if (z) {
                    Toast.makeText(this.emk.getPageContext().getPageActivity(), this.emk.getPageContext().getResources().getString(w.l.channel_need_push), 1).show();
                }
            }
        }
    }
}
