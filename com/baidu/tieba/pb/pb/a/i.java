package com.baidu.tieba.pb.pb.a;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ g chR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.chR = gVar;
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
        pbActivity = this.chR.cjZ;
        if (pbActivity.checkUpIsLogin()) {
            cVar = this.chR.chP;
            if (cVar != null) {
                cVar6 = this.chR.chP;
                if (cVar6.afh() != null) {
                    cVar7 = this.chR.chP;
                    if (cVar7.afh().sw() == 1) {
                        aq aqVar = new aq("c10400");
                        cVar8 = this.chR.chP;
                        aq ae = aqVar.ae(ImageViewerConfig.FORUM_ID, cVar8.getForumId());
                        cVar9 = this.chR.chP;
                        TiebaStatic.log(ae.ae("tid", cVar9.getThreadId()));
                        cVar10 = this.chR.chP;
                        if (cVar10.afg() != null) {
                            cVar11 = this.chR.chP;
                            if (cVar11.afg().isLike() == 1) {
                                this.chR.afD();
                                return;
                            }
                        }
                        this.chR.afE();
                        return;
                    }
                }
            }
            cVar2 = this.chR.chP;
            if (cVar2 != null) {
                cVar3 = this.chR.chP;
                if (cVar3.afh() != null) {
                    cVar4 = this.chR.chP;
                    if (cVar4.afh().sz() != null) {
                        context = this.chR.mContext;
                        cVar5 = this.chR.chP;
                        com.baidu.tbadk.browser.g.B(context, cVar5.afh().sz());
                        context2 = this.chR.mContext;
                        TiebaStatic.eventStat(context2, "show_picture", "click", 1, "page", "pb");
                    }
                }
            }
        }
    }
}
