package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class r {
    private ArrayList<com.baidu.tieba.tbadkCore.c.c> buh = new ArrayList<>();
    private ArrayList<com.baidu.tieba.tbadkCore.c.c> buP = new ArrayList<>();

    public void setContent(ArrayList<com.baidu.tieba.tbadkCore.c.c> arrayList) {
        this.buh = arrayList;
    }

    public void av(Context context) {
        int i;
        int i2;
        int i3;
        if (this.buh != null) {
            int i4 = -1;
            int size = this.buP.size();
            if (size > 0) {
                try {
                    i4 = this.buP.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i5 = 0;
            int i6 = i4;
            while (i5 < this.buh.size()) {
                com.baidu.tieba.tbadkCore.c.c cVar = this.buh.get(i5);
                if (com.baidu.tieba.tbadkCore.c.c.ag(i6, cVar.getType())) {
                    this.buP.get(size - 1).a(cVar.aC(context));
                    i3 = size;
                    i2 = i6;
                } else {
                    if (cVar.getType() == 3) {
                        this.buP.add(cVar);
                        i = 3;
                    } else if (cVar.getType() == 11) {
                        this.buP.add(cVar);
                        i = 11;
                    } else {
                        com.baidu.tieba.tbadkCore.c.c cVar2 = new com.baidu.tieba.tbadkCore.c.c();
                        cVar2.setType(0);
                        cVar2.a(cVar.aC(context));
                        this.buP.add(cVar2);
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
