package com.baidu.tieba.pb.pb.main;

import android.widget.Toast;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.b.a;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class au extends CustomMessageListener {
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public au(PbActivity pbActivity, int i) {
        super(i);
        this.ehy = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        fm fmVar;
        fm fmVar2;
        fm fmVar3;
        fm fmVar4;
        fm fmVar5;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
            com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
            boolean z = aVar.SD == this.ehy.getUniqueId();
            if (aVar instanceof a.C0036a) {
                if (aVar.SE != null && !aVar.SE.hasError() && aVar.SE.getError() == 0) {
                    fmVar4 = this.ehy.egt;
                    if (fmVar4 != null) {
                        fmVar5 = this.ehy.egt;
                        fmVar5.v(((a.C0036a) aVar).channelId, 1);
                    }
                    if (z) {
                        this.ehy.aJr();
                    }
                } else if (z) {
                    if (aVar.SE != null && aVar.SE.getErrorString() != null) {
                        this.ehy.showToast(aVar.SE.getErrorString());
                    } else {
                        this.ehy.showToast(w.l.fail_order_video_channel);
                    }
                }
            } else if (aVar instanceof a.c) {
                if (aVar.SE != null && !aVar.SE.hasError() && aVar.SE.getError() == 0) {
                    fmVar = this.ehy.egt;
                    if (fmVar != null) {
                        fmVar2 = this.ehy.egt;
                        if (fmVar2 != null) {
                            fmVar3 = this.ehy.egt;
                            fmVar3.v(((a.C0036a) aVar).channelId, 2);
                        }
                    }
                } else if (z) {
                    if (aVar.SE != null && aVar.SE.getErrorString() != null) {
                        this.ehy.showToast(aVar.SE.getErrorString());
                    } else {
                        this.ehy.showToast(w.l.fail_cancle_order_video_channel);
                    }
                }
            } else if (aVar instanceof a.b) {
                if (aVar.SE == null || aVar.SE.hasError() || aVar.SE.getError() != 0) {
                    if (z) {
                        if (aVar.SE != null && aVar.SE.getErrorString() != null) {
                            this.ehy.showToast(aVar.SE.getErrorString());
                        } else {
                            this.ehy.showToast(w.l.fail_open_channel_push);
                        }
                    }
                } else if (z) {
                    Toast.makeText(this.ehy.getPageContext().getPageActivity(), this.ehy.getPageContext().getResources().getString(w.l.channel_need_push), 1).show();
                }
            }
        }
    }
}
