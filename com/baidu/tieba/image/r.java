package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class r {
    private ArrayList<com.baidu.tieba.tbadkCore.c.c> bux = new ArrayList<>();
    private ArrayList<com.baidu.tieba.tbadkCore.c.c> bvf = new ArrayList<>();

    public void setContent(ArrayList<com.baidu.tieba.tbadkCore.c.c> arrayList) {
        this.bux = arrayList;
    }

    public void av(Context context) {
        int i;
        int i2;
        int i3;
        if (this.bux != null) {
            int i4 = -1;
            int size = this.bvf.size();
            if (size > 0) {
                try {
                    i4 = this.bvf.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i5 = 0;
            int i6 = i4;
            while (i5 < this.bux.size()) {
                com.baidu.tieba.tbadkCore.c.c cVar = this.bux.get(i5);
                if (com.baidu.tieba.tbadkCore.c.c.ag(i6, cVar.getType())) {
                    this.bvf.get(size - 1).a(cVar.aC(context));
                    i3 = size;
                    i2 = i6;
                } else {
                    if (cVar.getType() == 3) {
                        this.bvf.add(cVar);
                        i = 3;
                    } else if (cVar.getType() == 11) {
                        this.bvf.add(cVar);
                        i = 11;
                    } else {
                        com.baidu.tieba.tbadkCore.c.c cVar2 = new com.baidu.tieba.tbadkCore.c.c();
                        cVar2.setType(0);
                        cVar2.a(cVar.aC(context));
                        this.bvf.add(cVar2);
                        i = 0;
                    }
                    i2 = i;
                    i3 = size + 1;
                }
                i5++;
                i6 = i2;
                size = i3;
            }
        }
    }
}
