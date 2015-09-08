package com.baidu.tieba.personInfo;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.usermute.i;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes.dex */
class b implements i.a {
    final /* synthetic */ PersonInfoActivity cmR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PersonInfoActivity personInfoActivity) {
        this.cmR = personInfoActivity;
    }

    @Override // com.baidu.tieba.usermute.i.a
    public void a(DataRes dataRes, int i, String str, Object obj) {
        if (i == 0 && !StringUtils.isNULL(dataRes.is_mute)) {
            if (dataRes.is_mute.equals("0")) {
                this.cmR.cmC = 0;
            } else if (dataRes.is_mute.equals("1")) {
                this.cmR.cmC = 1;
            }
        }
    }
}
