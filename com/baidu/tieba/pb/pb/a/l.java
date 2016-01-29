package com.baidu.tieba.pb.pb.a;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ j cKB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.cKB = jVar;
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
        pbActivity = this.cKB.cNL;
        if (pbActivity.checkUpIsLogin()) {
            cVar = this.cKB.cJZ;
            if (cVar != null) {
                cVar6 = this.cKB.cJZ;
                if (cVar6.aoF() != null) {
                    cVar7 = this.cKB.cJZ;
                    if (cVar7.aoF().tD() == 1) {
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        au auVar = new au("c10400");
                        cVar8 = this.cKB.cJZ;
                        au aa = auVar.aa(ImageViewerConfig.FORUM_ID, cVar8.getForumId());
                        cVar9 = this.cKB.cJZ;
                        TiebaStatic.log(aa.aa("tid", cVar9.getThreadId()).aa("uid", currentAccount));
                        cVar10 = this.cKB.cJZ;
                        if (cVar10.aoE() != null) {
                            cVar11 = this.cKB.cJZ;
                            if (cVar11.aoE().isLike() == 1) {
                                this.cKB.aoZ();
                                return;
                            }
                        }
                        this.cKB.apa();
                        return;
                    }
                }
            }
            cVar2 = this.cKB.cJZ;
            if (cVar2 != null) {
                cVar3 = this.cKB.cJZ;
                if (cVar3.aoF() != null) {
                    cVar4 = this.cKB.cJZ;
                    if (cVar4.aoF().tG() != null) {
                        context = this.cKB.mContext;
                        cVar5 = this.cKB.cJZ;
                        com.baidu.tbadk.browser.f.B(context, cVar5.aoF().tG());
                        context2 = this.cKB.mContext;
                        TiebaStatic.eventStat(context2, "show_picture", "click", 1, "page", "pb");
                    }
                }
            }
        }
    }
}
