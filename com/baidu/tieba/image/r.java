package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class r {
    private ArrayList<com.baidu.tieba.tbadkCore.data.c> bxf = new ArrayList<>();
    private ArrayList<com.baidu.tieba.tbadkCore.data.c> bxN = new ArrayList<>();

    public void setContent(ArrayList<com.baidu.tieba.tbadkCore.data.c> arrayList) {
        this.bxf = arrayList;
    }

    public void aA(Context context) {
        int i;
        int i2;
        int i3;
        if (this.bxf != null) {
            int i4 = -1;
            int size = this.bxN.size();
            if (size > 0) {
                try {
                    i4 = this.bxN.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i5 = 0;
            int i6 = i4;
            while (i5 < this.bxf.size()) {
                com.baidu.tieba.tbadkCore.data.c cVar = this.bxf.get(i5);
                if (com.baidu.tieba.tbadkCore.data.c.ah(i6, cVar.getType())) {
                    this.bxN.get(size - 1).a(cVar.aH(context));
                    i3 = size;
                    i2 = i6;
                } else {
                    if (cVar.getType() == 3) {
                        this.bxN.add(cVar);
                        i = 3;
                    } else if (cVar.getType() == 11) {
                        this.bxN.add(cVar);
                        i = 11;
                    } else {
                        com.baidu.tieba.tbadkCore.data.c cVar2 = new com.baidu.tieba.tbadkCore.data.c();
                        cVar2.setType(0);
                        cVar2.a(cVar.aH(context));
                        this.bxN.add(cVar2);
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
