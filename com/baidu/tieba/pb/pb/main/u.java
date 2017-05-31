package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class u implements CheckRealNameModel.a {
    final /* synthetic */ PbActivity enc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PbActivity pbActivity) {
        this.enc = pbActivity;
    }

    @Override // com.baidu.tieba.model.CheckRealNameModel.a
    public void a(int i, String str, String str2, Object obj) {
        fx fxVar;
        Integer num;
        fxVar = this.enc.elU;
        fxVar.Pe();
        if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
            if (i == 0) {
                if (!(obj instanceof Integer)) {
                    num = 0;
                } else {
                    num = (Integer) obj;
                }
                this.enc.ot(num.intValue());
            } else if (i == 1990055) {
                TiebaStatic.log("c12142");
                com.baidu.tieba.h.a.agz();
            } else {
                if (StringUtils.isNull(str)) {
                    str = this.enc.getResources().getString(w.l.neterror);
                }
                this.enc.showToast(str);
            }
        }
    }
}
