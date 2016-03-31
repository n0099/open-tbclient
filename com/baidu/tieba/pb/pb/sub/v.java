package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.t;
import java.text.MessageFormat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements a.InterfaceC0041a {
    final /* synthetic */ NewSubPbActivity doF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(NewSubPbActivity newSubPbActivity) {
        this.doF = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0041a
    public void a(boolean z, boolean z2, String str) {
        com.baidu.tbadk.baseEditMark.a aVar;
        com.baidu.tbadk.baseEditMark.a aVar2;
        ap apVar;
        ap apVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        ap apVar3;
        ap apVar4;
        ap apVar5;
        com.baidu.tbadk.baseEditMark.a aVar4;
        if (z) {
            aVar = this.doF.cOZ;
            if (aVar != null) {
                aVar4 = this.doF.cOZ;
                aVar4.X(z2);
            }
            aVar2 = this.doF.cOZ;
            MarkData px = aVar2.px();
            com.baidu.tieba.pb.f fVar = new com.baidu.tieba.pb.f();
            fVar.setType(2);
            if (z2) {
                fVar.setData(px);
                aVar3 = this.doF.cOZ;
                if (aVar3 != null) {
                    if (px != null) {
                        apVar3 = this.doF.dou;
                        apVar3.gk(true);
                        apVar4 = this.doF.dou;
                        apVar5 = this.doF.dou;
                        apVar4.mj(apVar5.DH());
                        this.doF.showToast(MessageFormat.format(this.doF.getPageContext().getString(t.j.add_mark_on_pb), Integer.valueOf(px.getFloor())));
                    } else {
                        this.doF.showToast(this.doF.getPageContext().getString(t.j.add_mark));
                    }
                }
            } else {
                fVar.setData(null);
                apVar = this.doF.dou;
                apVar.gk(false);
                apVar2 = this.doF.dou;
                apVar2.mj(null);
                this.doF.showToast(this.doF.getPageContext().getString(t.j.remove_mark));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, fVar));
            return;
        }
        this.doF.showToast(this.doF.getPageContext().getString(t.j.update_mark_failed));
    }
}
