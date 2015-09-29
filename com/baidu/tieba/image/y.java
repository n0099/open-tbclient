package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class y {
    private ArrayList<com.baidu.tieba.tbadkCore.data.d> bOZ = new ArrayList<>();
    private ArrayList<com.baidu.tieba.tbadkCore.data.d> bPM = new ArrayList<>();

    public void setContent(ArrayList<com.baidu.tieba.tbadkCore.data.d> arrayList) {
        this.bOZ = arrayList;
    }

    public void aA(Context context) {
        int i;
        int i2;
        int i3;
        if (this.bOZ != null) {
            int i4 = -1;
            int size = this.bPM.size();
            if (size > 0) {
                try {
                    i4 = this.bPM.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i5 = 0;
            int i6 = i4;
            while (i5 < this.bOZ.size()) {
                com.baidu.tieba.tbadkCore.data.d dVar = this.bOZ.get(i5);
                if (com.baidu.tieba.tbadkCore.data.d.aE(i6, dVar.getType())) {
                    this.bPM.get(size - 1).b(dVar.aQ(context));
                    i3 = size;
                    i2 = i6;
                } else {
                    if (dVar.getType() == 3) {
                        this.bPM.add(dVar);
                        i = 3;
                    } else if (dVar.getType() == 11) {
                        this.bPM.add(dVar);
                        i = 11;
                    } else {
                        com.baidu.tieba.tbadkCore.data.d dVar2 = new com.baidu.tieba.tbadkCore.data.d();
                        dVar2.setType(0);
                        dVar2.b(dVar.aQ(context));
                        this.bPM.add(dVar2);
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
