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
    final /* synthetic */ g cAo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.cAo = gVar;
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
        pbActivity = this.cAo.cCy;
        if (pbActivity.checkUpIsLogin()) {
            cVar = this.cAo.cAm;
            if (cVar != null) {
                cVar6 = this.cAo.cAm;
                if (cVar6.ajz() != null) {
                    cVar7 = this.cAo.cAm;
                    if (cVar7.ajz().sX() == 1) {
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        av avVar = new av("c10400");
                        cVar8 = this.cAo.cAm;
                        av ab = avVar.ab(ImageViewerConfig.FORUM_ID, cVar8.getForumId());
                        cVar9 = this.cAo.cAm;
                        TiebaStatic.log(ab.ab("tid", cVar9.getThreadId()).ab("uid", currentAccount));
                        cVar10 = this.cAo.cAm;
                        if (cVar10.ajy() != null) {
                            cVar11 = this.cAo.cAm;
                            if (cVar11.ajy().isLike() == 1) {
                                this.cAo.ajV();
                                return;
                            }
                        }
                        this.cAo.ajW();
                        return;
                    }
                }
            }
            cVar2 = this.cAo.cAm;
            if (cVar2 != null) {
                cVar3 = this.cAo.cAm;
                if (cVar3.ajz() != null) {
                    cVar4 = this.cAo.cAm;
                    if (cVar4.ajz().ta() != null) {
                        context = this.cAo.mContext;
                        cVar5 = this.cAo.cAm;
                        com.baidu.tbadk.browser.f.B(context, cVar5.ajz().ta());
                        context2 = this.cAo.mContext;
                        TiebaStatic.eventStat(context2, "show_picture", "click", 1, "page", "pb");
                    }
                }
            }
        }
    }
}
