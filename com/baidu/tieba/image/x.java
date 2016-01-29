package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class x {
    private ArrayList<com.baidu.tieba.tbadkCore.data.k> cov = new ArrayList<>();
    private ArrayList<com.baidu.tieba.tbadkCore.data.k> cpl = new ArrayList<>();

    public void setContent(ArrayList<com.baidu.tieba.tbadkCore.data.k> arrayList) {
        this.cov = arrayList;
    }

    public void aA(Context context) {
        int i;
        int i2;
        int i3;
        if (this.cov != null) {
            int i4 = -1;
            int size = this.cpl.size();
            if (size > 0) {
                try {
                    i4 = this.cpl.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i5 = 0;
            int i6 = i4;
            while (i5 < this.cov.size()) {
                com.baidu.tieba.tbadkCore.data.k kVar = this.cov.get(i5);
                if (com.baidu.tieba.tbadkCore.data.k.bb(i6, kVar.getType())) {
                    this.cpl.get(size - 1).b(kVar.aR(context));
                    i3 = size;
                    i2 = i6;
                } else {
                    if (kVar.getType() == 3) {
                        this.cpl.add(kVar);
                        i = 3;
                    } else if (kVar.getType() == 11) {
                        this.cpl.add(kVar);
                        i = 11;
                    } else {
                        com.baidu.tieba.tbadkCore.data.k kVar2 = new com.baidu.tieba.tbadkCore.data.k();
                        kVar2.setType(0);
                        kVar2.b(kVar.aR(context));
                        this.cpl.add(kVar2);
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
