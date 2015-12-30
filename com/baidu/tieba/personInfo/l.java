package com.baidu.tieba.personInfo;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.usermute.i;
import tbclient.UserMuteCheck.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements i.a {
    final /* synthetic */ d cWV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(d dVar) {
        this.cWV = dVar;
    }

    @Override // com.baidu.tieba.usermute.i.a
    public void a(DataRes dataRes, int i, String str, Object obj) {
        if (i == 0 && !StringUtils.isNULL(dataRes.is_mute)) {
            if (dataRes.is_mute.equals("0")) {
                this.cWV.cWu = 0;
            } else if (dataRes.is_mute.equals("1")) {
                this.cWV.cWu = 1;
            }
        }
    }
}
