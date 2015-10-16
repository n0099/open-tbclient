package com.baidu.tieba.recommendfrs.indicator;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.recommendfrs.b {
    final /* synthetic */ a cJc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cJc = aVar;
    }

    @Override // com.baidu.tieba.recommendfrs.b
    public void Y(String str, int i) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        if (!StringUtils.isNull(str) && i >= 0) {
            arrayList = this.cJc.rK;
            if (arrayList != null) {
                arrayList2 = this.cJc.rK;
                if (arrayList2.size() > 0) {
                    arrayList3 = this.cJc.rK;
                    Iterator it = arrayList3.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.recommendfrs.data.e eVar = (com.baidu.tieba.recommendfrs.data.e) it.next();
                        if (eVar != null && TextUtils.equals(str, eVar.getTag())) {
                            eVar.kp(i);
                            return;
                        }
                    }
                }
            }
        }
    }
}
