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
public class e implements View.OnClickListener {
    private final /* synthetic */ int bub;
    final /* synthetic */ d cKp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, int i) {
        this.cKp = dVar;
        this.bub = i;
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
            pbActivity = this.cKp.cNL;
            if (pbActivity.checkUpIsLogin()) {
                if (this.bub == 1) {
                    cVar5 = this.cKp.cKn;
                    if (cVar5.aoE() != null) {
                        cVar9 = this.cKp.cKn;
                        if (cVar9.aoE().isLike() == 1) {
                            this.cKp.kL(0);
                            cVar6 = this.cKp.cKn;
                            if (cVar6 == null) {
                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                au auVar = new au("c10396");
                                cVar7 = this.cKp.cKn;
                                au aa = auVar.aa(ImageViewerConfig.FORUM_ID, cVar7.getForumId());
                                cVar8 = this.cKp.cKn;
                                TiebaStatic.log(aa.aa("tid", cVar8.getThreadId()).aa("uid", currentAccount));
                                return;
                            }
                            return;
                        }
                    }
                    this.cKp.aoY();
                    cVar6 = this.cKp.cKn;
                    if (cVar6 == null) {
                    }
                } else {
                    cVar = this.cKp.cKn;
                    if (cVar != null) {
                        cVar2 = this.cKp.cKn;
                        if (cVar2.aoF() != null) {
                            cVar3 = this.cKp.cKn;
                            if (cVar3.aoF().tG() != null) {
                                context = this.cKp.mContext;
                                cVar4 = this.cKp.cKn;
                                com.baidu.tbadk.browser.f.B(context, cVar4.aoF().tG());
                                context2 = this.cKp.mContext;
                                TiebaStatic.eventStat(context2, "lottery", "click", 1, "page", "pb");
                            }
                        }
                    }
                }
            }
        }
    }
}
