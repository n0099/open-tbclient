package com.baidu.tieba.personInfo;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.usermute.k;
import tbclient.UserMuteCheck.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements k.a {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(f fVar) {
        this.this$0 = fVar;
    }

    @Override // com.baidu.tieba.usermute.k.a
    public void a(DataRes dataRes, int i, String str, Object obj) {
        String str2;
        if (i == 0 && !StringUtils.isNULL(dataRes.is_mute)) {
            if (dataRes.is_mute.equals("0")) {
                this.this$0.dFM = 0;
                this.this$0.dFN = dataRes.mute_confirm;
                str2 = this.this$0.dFN;
                if (com.baidu.tbadk.core.util.ay.isEmpty(str2)) {
                    this.this$0.dFN = "确定禁言？";
                }
            } else if (dataRes.is_mute.equals("1")) {
                this.this$0.dFM = 1;
            }
        }
    }
}
