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
    final /* synthetic */ k ddT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar) {
        this.ddT = kVar;
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
        pbActivity = this.ddT.dfw;
        if (pbActivity.checkUpIsLogin()) {
            eVar = this.ddT.ddq;
            if (eVar != null) {
                eVar6 = this.ddT.ddq;
                if (eVar6.avv() != null) {
                    eVar7 = this.ddT.ddq;
                    if (eVar7.avv().tH() == 1) {
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        aw awVar = new aw("c10400");
                        eVar8 = this.ddT.ddq;
                        aw ac = awVar.ac("fid", eVar8.getForumId());
                        eVar9 = this.ddT.ddq;
                        TiebaStatic.log(ac.ac("tid", eVar9.getThreadId()).ac("uid", currentAccount));
                        eVar10 = this.ddT.ddq;
                        if (eVar10.avu() != null) {
                            eVar11 = this.ddT.ddq;
                            if (eVar11.avu().isLike() == 1) {
                                this.ddT.avQ();
                                return;
                            }
                        }
                        this.ddT.avR();
                        return;
                    }
                }
            }
            eVar2 = this.ddT.ddq;
            if (eVar2 != null) {
                eVar3 = this.ddT.ddq;
                if (eVar3.avv() != null) {
                    eVar4 = this.ddT.ddq;
                    if (eVar4.avv().tK() != null) {
                        context = this.ddT.mContext;
                        eVar5 = this.ddT.ddq;
                        com.baidu.tbadk.browser.f.s(context, eVar5.avv().tK());
                        context2 = this.ddT.mContext;
                        TiebaStatic.eventStat(context2, "show_picture", "click", 1, "page", "pb");
                    }
                }
            }
        }
    }
}
