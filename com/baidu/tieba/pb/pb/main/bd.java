package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements a.b {
    final /* synthetic */ PbActivity dht;
    private final /* synthetic */ PbLotteryHttpResponseMessage dhv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(PbActivity pbActivity, PbLotteryHttpResponseMessage pbLotteryHttpResponseMessage) {
        this.dht = pbActivity;
        this.dhv = pbLotteryHttpResponseMessage;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tbadk.core.dialog.a.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        df dfVar;
        df dfVar2;
        df dfVar3;
        df dfVar4;
        df dfVar5;
        df dfVar6;
        df dfVar7;
        df dfVar8;
        df dfVar9;
        aVar.dismiss();
        dfVar = this.dht.dfV;
        boolean z = dfVar != null;
        dfVar2 = this.dht.dfV;
        if (z & (dfVar2.getPbData() != null)) {
            dfVar7 = this.dht.dfV;
            if (dfVar7.getPbData().avv() != null) {
                dfVar8 = this.dht.dfV;
                if (!StringUtils.isNull(dfVar8.getPbData().avv().getTitle())) {
                    Activity activity = this.dht.getActivity();
                    dfVar9 = this.dht.dfV;
                    com.baidu.tbadk.browser.f.c(activity, dfVar9.getPbData().avv().getTitle(), this.dhv.getLotteryInfo().avp().getLink());
                    dfVar3 = this.dht.dfV;
                    if (dfVar3 == null) {
                        dfVar4 = this.dht.dfV;
                        if (dfVar4.getPbData() != null) {
                            com.baidu.tbadk.core.util.aw awVar = new com.baidu.tbadk.core.util.aw("c10506");
                            dfVar5 = this.dht.dfV;
                            com.baidu.tbadk.core.util.aw ac = awVar.ac("fid", dfVar5.getPbData().getForumId());
                            dfVar6 = this.dht.dfV;
                            TiebaStatic.log(ac.ac("tid", dfVar6.getPbData().getThreadId()).ac("obj_locate", "1"));
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
        }
        com.baidu.tbadk.browser.f.s(this.dht.getActivity(), this.dhv.getLotteryInfo().avp().getLink());
        dfVar3 = this.dht.dfV;
        if (dfVar3 == null) {
        }
    }
}
