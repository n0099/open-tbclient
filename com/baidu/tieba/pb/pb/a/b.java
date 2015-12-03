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
public class b implements View.OnClickListener {
    private final /* synthetic */ int bnf;
    final /* synthetic */ a czV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, int i) {
        this.czV = aVar;
        this.bnf = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        PbActivity pbActivity;
        com.baidu.tieba.pb.a.c cVar;
        com.baidu.tieba.pb.a.c cVar2;
        com.baidu.tieba.pb.a.c cVar3;
        Context context;
        com.baidu.tieba.pb.a.c cVar4;
        Context context2;
        com.baidu.tieba.pb.a.c cVar5;
        com.baidu.tieba.pb.a.c cVar6;
        com.baidu.tieba.pb.a.c cVar7;
        com.baidu.tieba.pb.a.c cVar8;
        com.baidu.tieba.pb.a.c cVar9;
        if (!com.baidu.tieba.pb.pb.main.b.isFastDoubleClick()) {
            pbActivity = this.czV.cCy;
            if (pbActivity.checkUpIsLogin()) {
                if (this.bnf == 1) {
                    cVar5 = this.czV.czO;
                    if (cVar5.ajy() != null) {
                        cVar9 = this.czV.czO;
                        if (cVar9.ajy().isLike() == 1) {
                            this.czV.jO(0);
                            cVar6 = this.czV.czO;
                            if (cVar6 == null) {
                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                av avVar = new av("c10396");
                                cVar7 = this.czV.czO;
                                av ab = avVar.ab(ImageViewerConfig.FORUM_ID, cVar7.getForumId());
                                cVar8 = this.czV.czO;
                                TiebaStatic.log(ab.ab("tid", cVar8.getThreadId()).ab("uid", currentAccount));
                                return;
                            }
                            return;
                        }
                    }
                    this.czV.ajU();
                    cVar6 = this.czV.czO;
                    if (cVar6 == null) {
                    }
                } else {
                    cVar = this.czV.czO;
                    if (cVar != null) {
                        cVar2 = this.czV.czO;
                        if (cVar2.ajz() != null) {
                            cVar3 = this.czV.czO;
                            if (cVar3.ajz().ta() != null) {
                                context = this.czV.mContext;
                                cVar4 = this.czV.czO;
                                com.baidu.tbadk.browser.f.B(context, cVar4.ajz().ta());
                                context2 = this.czV.mContext;
                                TiebaStatic.eventStat(context2, "lottery", "click", 1, "page", "pb");
                            }
                        }
                    }
                }
            }
        }
    }
}
