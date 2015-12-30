package com.baidu.tieba.pb.pb.a;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ g cDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.cDT = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        com.baidu.tieba.pb.a.c cVar;
        com.baidu.tieba.pb.a.c cVar2;
        com.baidu.tieba.pb.a.c cVar3;
        com.baidu.tieba.pb.a.c cVar4;
        Context context;
        com.baidu.tieba.pb.a.c cVar5;
        Context context2;
        com.baidu.tieba.pb.a.c cVar6;
        com.baidu.tieba.pb.a.c cVar7;
        com.baidu.tieba.pb.a.c cVar8;
        com.baidu.tieba.pb.a.c cVar9;
        com.baidu.tieba.pb.a.c cVar10;
        com.baidu.tieba.pb.a.c cVar11;
        pbActivity = this.cDT.cGj;
        if (pbActivity.checkUpIsLogin()) {
            cVar = this.cDT.cDR;
            if (cVar != null) {
                cVar6 = this.cDT.cDR;
                if (cVar6.akH() != null) {
                    cVar7 = this.cDT.cDR;
                    if (cVar7.akH().sH() == 1) {
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        av avVar = new av("c10400");
                        cVar8 = this.cDT.cDR;
                        av aa = avVar.aa(ImageViewerConfig.FORUM_ID, cVar8.getForumId());
                        cVar9 = this.cDT.cDR;
                        TiebaStatic.log(aa.aa("tid", cVar9.getThreadId()).aa("uid", currentAccount));
                        cVar10 = this.cDT.cDR;
                        if (cVar10.akG() != null) {
                            cVar11 = this.cDT.cDR;
                            if (cVar11.akG().isLike() == 1) {
                                this.cDT.alc();
                                return;
                            }
                        }
                        this.cDT.ald();
                        return;
                    }
                }
            }
            cVar2 = this.cDT.cDR;
            if (cVar2 != null) {
                cVar3 = this.cDT.cDR;
                if (cVar3.akH() != null) {
                    cVar4 = this.cDT.cDR;
                    if (cVar4.akH().sK() != null) {
                        context = this.cDT.mContext;
                        cVar5 = this.cDT.cDR;
                        com.baidu.tbadk.browser.f.B(context, cVar5.akH().sK());
                        context2 = this.cDT.mContext;
                        TiebaStatic.eventStat(context2, "show_picture", "click", 1, "page", "pb");
                    }
                }
            }
        }
    }
}
