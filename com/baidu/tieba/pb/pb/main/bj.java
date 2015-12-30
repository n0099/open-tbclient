package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements a.b {
    final /* synthetic */ bh cGg;
    private final /* synthetic */ PbLotteryHttpResponseMessage cGh;
    private final /* synthetic */ String caQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(bh bhVar, PbLotteryHttpResponseMessage pbLotteryHttpResponseMessage, String str) {
        this.cGg = bhVar;
        this.cGh = pbLotteryHttpResponseMessage;
        this.caQ = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tbadk.core.dialog.a.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        PbActivity pbActivity;
        cf cfVar;
        PbActivity pbActivity2;
        cf cfVar2;
        PbActivity pbActivity3;
        PbActivity pbActivity4;
        cf cfVar3;
        PbActivity pbActivity5;
        cf cfVar4;
        PbActivity pbActivity6;
        cf cfVar5;
        PbActivity pbActivity7;
        cf cfVar6;
        PbActivity pbActivity8;
        cf cfVar7;
        PbActivity pbActivity9;
        cf cfVar8;
        PbActivity pbActivity10;
        PbActivity pbActivity11;
        cf cfVar9;
        aVar.dismiss();
        pbActivity = this.cGg.cFS;
        cfVar = pbActivity.cFl;
        boolean z = cfVar != null;
        pbActivity2 = this.cGg.cFS;
        cfVar2 = pbActivity2.cFl;
        if (z & (cfVar2.getPbData() != null)) {
            pbActivity8 = this.cGg.cFS;
            cfVar7 = pbActivity8.cFl;
            if (cfVar7.getPbData().akH() != null) {
                pbActivity9 = this.cGg.cFS;
                cfVar8 = pbActivity9.cFl;
                if (!StringUtils.isNull(cfVar8.getPbData().akH().getTitle())) {
                    pbActivity10 = this.cGg.cFS;
                    Activity activity = pbActivity10.getActivity();
                    pbActivity11 = this.cGg.cFS;
                    cfVar9 = pbActivity11.cFl;
                    com.baidu.tbadk.browser.f.f(activity, cfVar9.getPbData().akH().getTitle(), this.cGh.getLotteryInfo().getLink());
                    pbActivity4 = this.cGg.cFS;
                    cfVar3 = pbActivity4.cFl;
                    if (cfVar3 == null) {
                        pbActivity5 = this.cGg.cFS;
                        cfVar4 = pbActivity5.cFl;
                        if (cfVar4.getPbData() != null) {
                            com.baidu.tbadk.core.util.av avVar = new com.baidu.tbadk.core.util.av("c10506");
                            pbActivity6 = this.cGg.cFS;
                            cfVar5 = pbActivity6.cFl;
                            com.baidu.tbadk.core.util.av aa = avVar.aa(ImageViewerConfig.FORUM_ID, cfVar5.getPbData().getForumId());
                            pbActivity7 = this.cGg.cFS;
                            cfVar6 = pbActivity7.cFl;
                            TiebaStatic.log(aa.aa("tid", cfVar6.getPbData().getThreadId()).aa("uid", this.caQ).aa("obj_locate", "1"));
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
        }
        pbActivity3 = this.cGg.cFS;
        com.baidu.tbadk.browser.f.B(pbActivity3.getActivity(), this.cGh.getLotteryInfo().getLink());
        pbActivity4 = this.cGg.cFS;
        cfVar3 = pbActivity4.cFl;
        if (cfVar3 == null) {
        }
    }
}
