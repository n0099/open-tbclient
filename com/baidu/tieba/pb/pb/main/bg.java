package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements a.b {
    private final /* synthetic */ String bWR;
    final /* synthetic */ be cCv;
    private final /* synthetic */ PbLotteryHttpResponseMessage cCw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(be beVar, PbLotteryHttpResponseMessage pbLotteryHttpResponseMessage, String str) {
        this.cCv = beVar;
        this.cCw = pbLotteryHttpResponseMessage;
        this.bWR = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tbadk.core.dialog.a.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        PbActivity pbActivity;
        cc ccVar;
        PbActivity pbActivity2;
        cc ccVar2;
        PbActivity pbActivity3;
        PbActivity pbActivity4;
        cc ccVar3;
        PbActivity pbActivity5;
        cc ccVar4;
        PbActivity pbActivity6;
        cc ccVar5;
        PbActivity pbActivity7;
        cc ccVar6;
        PbActivity pbActivity8;
        cc ccVar7;
        PbActivity pbActivity9;
        cc ccVar8;
        PbActivity pbActivity10;
        PbActivity pbActivity11;
        cc ccVar9;
        aVar.dismiss();
        pbActivity = this.cCv.cCm;
        ccVar = pbActivity.cBG;
        boolean z = ccVar != null;
        pbActivity2 = this.cCv.cCm;
        ccVar2 = pbActivity2.cBG;
        if (z & (ccVar2.getPbData() != null)) {
            pbActivity8 = this.cCv.cCm;
            ccVar7 = pbActivity8.cBG;
            if (ccVar7.getPbData().ajz() != null) {
                pbActivity9 = this.cCv.cCm;
                ccVar8 = pbActivity9.cBG;
                if (!StringUtils.isNull(ccVar8.getPbData().ajz().getTitle())) {
                    pbActivity10 = this.cCv.cCm;
                    Activity activity = pbActivity10.getActivity();
                    pbActivity11 = this.cCv.cCm;
                    ccVar9 = pbActivity11.cBG;
                    com.baidu.tbadk.browser.f.f(activity, ccVar9.getPbData().ajz().getTitle(), this.cCw.getLotteryInfo().getLink());
                    pbActivity4 = this.cCv.cCm;
                    ccVar3 = pbActivity4.cBG;
                    if (ccVar3 == null) {
                        pbActivity5 = this.cCv.cCm;
                        ccVar4 = pbActivity5.cBG;
                        if (ccVar4.getPbData() != null) {
                            com.baidu.tbadk.core.util.av avVar = new com.baidu.tbadk.core.util.av("c10506");
                            pbActivity6 = this.cCv.cCm;
                            ccVar5 = pbActivity6.cBG;
                            com.baidu.tbadk.core.util.av ab = avVar.ab(ImageViewerConfig.FORUM_ID, ccVar5.getPbData().getForumId());
                            pbActivity7 = this.cCv.cCm;
                            ccVar6 = pbActivity7.cBG;
                            TiebaStatic.log(ab.ab("tid", ccVar6.getPbData().getThreadId()).ab("uid", this.bWR).ab("obj_locate", "1"));
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
        }
        pbActivity3 = this.cCv.cCm;
        com.baidu.tbadk.browser.f.B(pbActivity3.getActivity(), this.cCw.getLotteryInfo().getLink());
        pbActivity4 = this.cCv.cCm;
        ccVar3 = pbActivity4.cBG;
        if (ccVar3 == null) {
        }
    }
}
