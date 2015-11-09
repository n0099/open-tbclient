package com.baidu.tieba.pb.pb.a;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a chy;
    private final /* synthetic */ int chz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, int i) {
        this.chy = aVar;
        this.chz = i;
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
            pbActivity = this.chy.cjZ;
            if (pbActivity.checkUpIsLogin()) {
                if (this.chz == 1) {
                    cVar5 = this.chy.chr;
                    if (cVar5.afg() != null) {
                        cVar9 = this.chy.chr;
                        if (cVar9.afg().isLike() == 1) {
                            this.chy.iW(0);
                            cVar6 = this.chy.chr;
                            if (cVar6 == null) {
                                aq aqVar = new aq("c10396");
                                cVar7 = this.chy.chr;
                                aq ae = aqVar.ae(ImageViewerConfig.FORUM_ID, cVar7.getForumId());
                                cVar8 = this.chy.chr;
                                TiebaStatic.log(ae.ae("tid", cVar8.getThreadId()).ae("is_like", "1"));
                                return;
                            }
                            return;
                        }
                    }
                    this.chy.afC();
                    cVar6 = this.chy.chr;
                    if (cVar6 == null) {
                    }
                } else {
                    cVar = this.chy.chr;
                    if (cVar != null) {
                        cVar2 = this.chy.chr;
                        if (cVar2.afh() != null) {
                            cVar3 = this.chy.chr;
                            if (cVar3.afh().sz() != null) {
                                context = this.chy.mContext;
                                cVar4 = this.chy.chr;
                                com.baidu.tbadk.browser.g.B(context, cVar4.afh().sz());
                                context2 = this.chy.mContext;
                                TiebaStatic.eventStat(context2, "lottery", "click", 1, "page", "pb");
                            }
                        }
                    }
                }
            }
        }
    }
}
