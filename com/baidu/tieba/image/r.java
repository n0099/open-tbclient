package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class r {
    private ArrayList<com.baidu.tieba.tbadkCore.b.c> bry = new ArrayList<>();
    private ArrayList<com.baidu.tieba.tbadkCore.b.c> bse = new ArrayList<>();

    public void setContent(ArrayList<com.baidu.tieba.tbadkCore.b.c> arrayList) {
        this.bry = arrayList;
    }

    public void as(Context context) {
        int i;
        int i2;
        int i3;
        if (this.bry != null) {
            int i4 = -1;
            int size = this.bse.size();
            if (size > 0) {
                try {
                    i4 = this.bse.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i5 = 0;
            int i6 = i4;
            while (i5 < this.bry.size()) {
                com.baidu.tieba.tbadkCore.b.c cVar = this.bry.get(i5);
                if (com.baidu.tieba.tbadkCore.b.c.ac(i6, cVar.getType())) {
                    this.bse.get(size - 1).a(cVar.aw(context));
                    i3 = size;
                    i2 = i6;
                } else {
                    if (cVar.getType() == 3) {
                        this.bse.add(cVar);
                        i = 3;
                    } else if (cVar.getType() == 11) {
                        this.bse.add(cVar);
                        i = 11;
                    } else {
                        com.baidu.tieba.tbadkCore.b.c cVar2 = new com.baidu.tieba.tbadkCore.b.c();
                        cVar2.setType(0);
                        cVar2.a(cVar.aw(context));
                        this.bse.add(cVar2);
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
