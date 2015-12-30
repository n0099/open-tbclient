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
    private final /* synthetic */ int bqV;
    final /* synthetic */ a cDA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, int i) {
        this.cDA = aVar;
        this.bqV = i;
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
            pbActivity = this.cDA.cGj;
            if (pbActivity.checkUpIsLogin()) {
                if (this.bqV == 1) {
                    cVar5 = this.cDA.cDt;
                    if (cVar5.akG() != null) {
                        cVar9 = this.cDA.cDt;
                        if (cVar9.akG().isLike() == 1) {
                            this.cDA.kl(0);
                            cVar6 = this.cDA.cDt;
                            if (cVar6 == null) {
                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                av avVar = new av("c10396");
                                cVar7 = this.cDA.cDt;
                                av aa = avVar.aa(ImageViewerConfig.FORUM_ID, cVar7.getForumId());
                                cVar8 = this.cDA.cDt;
                                TiebaStatic.log(aa.aa("tid", cVar8.getThreadId()).aa("uid", currentAccount));
                                return;
                            }
                            return;
                        }
                    }
                    this.cDA.alb();
                    cVar6 = this.cDA.cDt;
                    if (cVar6 == null) {
                    }
                } else {
                    cVar = this.cDA.cDt;
                    if (cVar != null) {
                        cVar2 = this.cDA.cDt;
                        if (cVar2.akH() != null) {
                            cVar3 = this.cDA.cDt;
                            if (cVar3.akH().sK() != null) {
                                context = this.cDA.mContext;
                                cVar4 = this.cDA.cDt;
                                com.baidu.tbadk.browser.f.B(context, cVar4.akH().sK());
                                context2 = this.cDA.mContext;
                                TiebaStatic.eventStat(context2, "lottery", "click", 1, "page", "pb");
                            }
                        }
                    }
                }
            }
        }
    }
}
