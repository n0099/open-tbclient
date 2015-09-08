package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class n {
    private ArrayList<com.baidu.tieba.tbadkCore.data.b> bLD = new ArrayList<>();
    private ArrayList<com.baidu.tieba.tbadkCore.data.b> bMk = new ArrayList<>();

    public void setContent(ArrayList<com.baidu.tieba.tbadkCore.data.b> arrayList) {
        this.bLD = arrayList;
    }

    public void aB(Context context) {
        int i;
        int i2;
        int i3;
        if (this.bLD != null) {
            int i4 = -1;
            int size = this.bMk.size();
            if (size > 0) {
                try {
                    i4 = this.bMk.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i5 = 0;
            int i6 = i4;
            while (i5 < this.bLD.size()) {
                com.baidu.tieba.tbadkCore.data.b bVar = this.bLD.get(i5);
                if (com.baidu.tieba.tbadkCore.data.b.aF(i6, bVar.getType())) {
                    this.bMk.get(size - 1).b(bVar.aR(context));
                    i3 = size;
                    i2 = i6;
                } else {
                    if (bVar.getType() == 3) {
                        this.bMk.add(bVar);
                        i = 3;
                    } else if (bVar.getType() == 11) {
                        this.bMk.add(bVar);
                        i = 11;
                    } else {
                        com.baidu.tieba.tbadkCore.data.b bVar2 = new com.baidu.tieba.tbadkCore.data.b();
                        bVar2.setType(0);
                        bVar2.b(bVar.aR(context));
                        this.bMk.add(bVar2);
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
