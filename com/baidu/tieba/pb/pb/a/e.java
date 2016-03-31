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
    private final /* synthetic */ int bzj;
    final /* synthetic */ d ddH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, int i) {
        this.ddH = dVar;
        this.bzj = i;
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
            pbActivity = this.ddH.dfw;
            if (pbActivity.checkUpIsLogin()) {
                pbActivity2 = this.ddH.dfw;
                if (pbActivity2.awi() != null) {
                    pbActivity3 = this.ddH.dfw;
                    pbActivity3.awi().amI();
                    pbActivity4 = this.ddH.dfw;
                    pbActivity4.awi().ayk();
                }
                if (this.bzj == 1) {
                    eVar5 = this.ddH.ddF;
                    if (eVar5.avu() != null) {
                        eVar9 = this.ddH.ddF;
                        if (eVar9.avu().isLike() == 1) {
                            this.ddH.lQ(0);
                            eVar6 = this.ddH.ddF;
                            if (eVar6 == null) {
                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                aw awVar = new aw("c10396");
                                eVar7 = this.ddH.ddF;
                                aw ac = awVar.ac("fid", eVar7.getForumId());
                                eVar8 = this.ddH.ddF;
                                TiebaStatic.log(ac.ac("tid", eVar8.getThreadId()).ac("uid", currentAccount));
                                return;
                            }
                            return;
                        }
                    }
                    this.ddH.apb();
                    eVar6 = this.ddH.ddF;
                    if (eVar6 == null) {
                    }
                } else {
                    eVar = this.ddH.ddF;
                    if (eVar != null) {
                        eVar2 = this.ddH.ddF;
                        if (eVar2.avv() != null) {
                            eVar3 = this.ddH.ddF;
                            if (eVar3.avv().tK() != null) {
                                context = this.ddH.mContext;
                                eVar4 = this.ddH.ddF;
                                com.baidu.tbadk.browser.f.s(context, eVar4.avv().tK());
                                context2 = this.ddH.mContext;
                                TiebaStatic.eventStat(context2, "lottery", "click", 1, "page", "pb");
                            }
                        }
                    }
                }
            }
        }
    }
}
