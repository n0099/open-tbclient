package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class v implements CheckRealNameModel.a {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(PbActivity pbActivity) {
        this.ewh = pbActivity;
    }

    @Override // com.baidu.tieba.model.CheckRealNameModel.a
    public void a(int i, String str, String str2, Object obj) {
        gg ggVar;
        Integer num;
        ggVar = this.ewh.euU;
        ggVar.Qy();
        if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
            if (i == 0) {
                if (!(obj instanceof Integer)) {
                    num = 0;
                } else {
                    num = (Integer) obj;
                }
                this.ewh.oJ(num.intValue());
            } else if (i == 1990055) {
                TiebaStatic.log("c12142");
                com.baidu.tieba.h.a.akj();
            } else {
                if (StringUtils.isNull(str)) {
                    str = this.ewh.getResources().getString(w.l.neterror);
                }
                this.ewh.showToast(str);
            }
        }
    }
}
