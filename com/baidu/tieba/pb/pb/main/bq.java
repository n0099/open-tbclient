package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements a.b {
    final /* synthetic */ bo cNE;
    private final /* synthetic */ PbLotteryHttpResponseMessage cNF;
    private final /* synthetic */ String cfq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bo boVar, PbLotteryHttpResponseMessage pbLotteryHttpResponseMessage, String str) {
        this.cNE = boVar;
        this.cNF = pbLotteryHttpResponseMessage;
        this.cfq = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tbadk.core.dialog.a.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        PbActivity pbActivity;
        cm cmVar;
        PbActivity pbActivity2;
        cm cmVar2;
        PbActivity pbActivity3;
        PbActivity pbActivity4;
        cm cmVar3;
        PbActivity pbActivity5;
        cm cmVar4;
        PbActivity pbActivity6;
        cm cmVar5;
        PbActivity pbActivity7;
        cm cmVar6;
        PbActivity pbActivity8;
        cm cmVar7;
        PbActivity pbActivity9;
        cm cmVar8;
        PbActivity pbActivity10;
        PbActivity pbActivity11;
        cm cmVar9;
        aVar.dismiss();
        pbActivity = this.cNE.cNq;
        cmVar = pbActivity.cMF;
        boolean z = cmVar != null;
        pbActivity2 = this.cNE.cNq;
        cmVar2 = pbActivity2.cMF;
        if (z & (cmVar2.getPbData() != null)) {
            pbActivity8 = this.cNE.cNq;
            cmVar7 = pbActivity8.cMF;
            if (cmVar7.getPbData().aoF() != null) {
                pbActivity9 = this.cNE.cNq;
                cmVar8 = pbActivity9.cMF;
                if (!StringUtils.isNull(cmVar8.getPbData().aoF().getTitle())) {
                    pbActivity10 = this.cNE.cNq;
                    Activity activity = pbActivity10.getActivity();
                    pbActivity11 = this.cNE.cNq;
                    cmVar9 = pbActivity11.cMF;
                    com.baidu.tbadk.browser.f.f(activity, cmVar9.getPbData().aoF().getTitle(), this.cNF.getLotteryInfo().getLink());
                    pbActivity4 = this.cNE.cNq;
                    cmVar3 = pbActivity4.cMF;
                    if (cmVar3 == null) {
                        pbActivity5 = this.cNE.cNq;
                        cmVar4 = pbActivity5.cMF;
                        if (cmVar4.getPbData() != null) {
                            com.baidu.tbadk.core.util.au auVar = new com.baidu.tbadk.core.util.au("c10506");
                            pbActivity6 = this.cNE.cNq;
                            cmVar5 = pbActivity6.cMF;
                            com.baidu.tbadk.core.util.au aa = auVar.aa(ImageViewerConfig.FORUM_ID, cmVar5.getPbData().getForumId());
                            pbActivity7 = this.cNE.cNq;
                            cmVar6 = pbActivity7.cMF;
                            TiebaStatic.log(aa.aa("tid", cmVar6.getPbData().getThreadId()).aa("uid", this.cfq).aa("obj_locate", "1"));
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
        }
        pbActivity3 = this.cNE.cNq;
        com.baidu.tbadk.browser.f.B(pbActivity3.getActivity(), this.cNF.getLotteryInfo().getLink());
        pbActivity4 = this.cNE.cNq;
        cmVar3 = pbActivity4.cMF;
        if (cmVar3 == null) {
        }
    }
}
