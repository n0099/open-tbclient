package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.baseEditMark.MarkData;
import java.text.MessageFormat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.baseEditMark.b {
    final /* synthetic */ NewSubPbActivity bPw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(NewSubPbActivity newSubPbActivity) {
        this.bPw = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.b
    public void a(boolean z, boolean z2, String str) {
        com.baidu.tbadk.baseEditMark.a aVar;
        com.baidu.tbadk.baseEditMark.a aVar2;
        ak akVar;
        ak akVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        ak akVar3;
        ak akVar4;
        ak akVar5;
        com.baidu.tbadk.baseEditMark.a aVar4;
        if (z) {
            aVar = this.bPw.bKw;
            if (aVar != null) {
                aVar4 = this.bPw.bKw;
                aVar4.Z(z2);
            }
            aVar2 = this.bPw.bKw;
            MarkData pt = aVar2.pt();
            an anVar = new an();
            anVar.setType(2);
            if (z2) {
                anVar.setData(pt);
                aVar3 = this.bPw.bKw;
                if (aVar3 != null) {
                    if (pt != null) {
                        akVar3 = this.bPw.bPn;
                        akVar3.en(true);
                        akVar4 = this.bPw.bPn;
                        akVar5 = this.bPw.bPn;
                        akVar4.iz(akVar5.ZP());
                        this.bPw.showToast(MessageFormat.format(this.bPw.getPageContext().getString(com.baidu.tieba.t.add_mark_on_pb), Integer.valueOf(pt.getFloor())));
                    } else {
                        this.bPw.showToast(this.bPw.getPageContext().getString(com.baidu.tieba.t.add_mark));
                    }
                }
            } else {
                anVar.setData(null);
                akVar = this.bPw.bPn;
                akVar.en(false);
                akVar2 = this.bPw.bPn;
                akVar2.iz(null);
                this.bPw.showToast(this.bPw.getPageContext().getString(com.baidu.tieba.t.remove_mark));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, anVar));
            return;
        }
        this.bPw.showToast(this.bPw.getPageContext().getString(com.baidu.tieba.t.update_mark_failed));
    }
}
