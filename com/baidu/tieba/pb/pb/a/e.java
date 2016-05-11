package com.baidu.tieba.pb.pb.a;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    private final /* synthetic */ int bzn;
    final /* synthetic */ d dgb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, int i) {
        this.dgb = dVar;
        this.bzn = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        com.baidu.tieba.pb.data.e eVar;
        com.baidu.tieba.pb.data.e eVar2;
        com.baidu.tieba.pb.data.e eVar3;
        Context context;
        com.baidu.tieba.pb.data.e eVar4;
        Context context2;
        com.baidu.tieba.pb.data.e eVar5;
        com.baidu.tieba.pb.data.e eVar6;
        com.baidu.tieba.pb.data.e eVar7;
        com.baidu.tieba.pb.data.e eVar8;
        com.baidu.tieba.pb.data.e eVar9;
        PbActivity pbActivity3;
        PbActivity pbActivity4;
        if (!com.baidu.tbadk.util.d.isFastDoubleClick()) {
            pbActivity = this.dgb.dhY;
            if (pbActivity.checkUpIsLogin()) {
                pbActivity2 = this.dgb.dhY;
                if (pbActivity2.awt() != null) {
                    pbActivity3 = this.dgb.dhY;
                    pbActivity3.awt().amQ();
                    pbActivity4 = this.dgb.dhY;
                    pbActivity4.awt().ayH();
                }
                if (this.bzn == 1) {
                    eVar5 = this.dgb.dfY;
                    if (eVar5.avA() != null) {
                        eVar9 = this.dgb.dfY;
                        if (eVar9.avA().isLike() == 1) {
                            this.dgb.lF(0);
                            eVar6 = this.dgb.dfY;
                            if (eVar6 == null) {
                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                aw awVar = new aw("c10396");
                                eVar7 = this.dgb.dfY;
                                aw ac = awVar.ac("fid", eVar7.getForumId());
                                eVar8 = this.dgb.dfY;
                                TiebaStatic.log(ac.ac("tid", eVar8.getThreadId()).ac("uid", currentAccount));
                                return;
                            }
                            return;
                        }
                    }
                    this.dgb.apg();
                    eVar6 = this.dgb.dfY;
                    if (eVar6 == null) {
                    }
                } else {
                    eVar = this.dgb.dfY;
                    if (eVar != null) {
                        eVar2 = this.dgb.dfY;
                        if (eVar2.avB() != null) {
                            eVar3 = this.dgb.dfY;
                            if (eVar3.avB().ri() != null) {
                                context = this.dgb.mContext;
                                eVar4 = this.dgb.dfY;
                                com.baidu.tbadk.browser.f.t(context, eVar4.avB().ri());
                                context2 = this.dgb.mContext;
                                TiebaStatic.eventStat(context2, "lottery", "click", 1, "page", "pb");
                            }
                        }
                    }
                }
            }
        }
    }
}
