package com.baidu.tieba.pb.pb.a;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ k dgn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar) {
        this.dgn = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        com.baidu.tieba.pb.data.e eVar;
        com.baidu.tieba.pb.data.e eVar2;
        com.baidu.tieba.pb.data.e eVar3;
        com.baidu.tieba.pb.data.e eVar4;
        Context context;
        com.baidu.tieba.pb.data.e eVar5;
        Context context2;
        com.baidu.tieba.pb.data.e eVar6;
        com.baidu.tieba.pb.data.e eVar7;
        com.baidu.tieba.pb.data.e eVar8;
        com.baidu.tieba.pb.data.e eVar9;
        com.baidu.tieba.pb.data.e eVar10;
        com.baidu.tieba.pb.data.e eVar11;
        pbActivity = this.dgn.dhY;
        if (pbActivity.checkUpIsLogin()) {
            eVar = this.dgn.dfK;
            if (eVar != null) {
                eVar6 = this.dgn.dfK;
                if (eVar6.avB() != null) {
                    eVar7 = this.dgn.dfK;
                    if (eVar7.avB().rf() == 1) {
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        aw awVar = new aw("c10400");
                        eVar8 = this.dgn.dfK;
                        aw ac = awVar.ac("fid", eVar8.getForumId());
                        eVar9 = this.dgn.dfK;
                        TiebaStatic.log(ac.ac("tid", eVar9.getThreadId()).ac("uid", currentAccount));
                        eVar10 = this.dgn.dfK;
                        if (eVar10.avA() != null) {
                            eVar11 = this.dgn.dfK;
                            if (eVar11.avA().isLike() == 1) {
                                this.dgn.avZ();
                                return;
                            }
                        }
                        this.dgn.awa();
                        return;
                    }
                }
            }
            eVar2 = this.dgn.dfK;
            if (eVar2 != null) {
                eVar3 = this.dgn.dfK;
                if (eVar3.avB() != null) {
                    eVar4 = this.dgn.dfK;
                    if (eVar4.avB().ri() != null) {
                        context = this.dgn.mContext;
                        eVar5 = this.dgn.dfK;
                        com.baidu.tbadk.browser.f.t(context, eVar5.avB().ri());
                        context2 = this.dgn.mContext;
                        TiebaStatic.eventStat(context2, "show_picture", "click", 1, "page", "pb");
                    }
                }
            }
        }
    }
}
