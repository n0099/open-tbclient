package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class y {
    private ArrayList<com.baidu.tieba.tbadkCore.data.d> bPk = new ArrayList<>();
    private ArrayList<com.baidu.tieba.tbadkCore.data.d> bPX = new ArrayList<>();

    public void setContent(ArrayList<com.baidu.tieba.tbadkCore.data.d> arrayList) {
        this.bPk = arrayList;
    }

    public void aA(Context context) {
        int i;
        int i2;
        int i3;
        if (this.bPk != null) {
            int i4 = -1;
            int size = this.bPX.size();
            if (size > 0) {
                try {
                    i4 = this.bPX.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i5 = 0;
            int i6 = i4;
            while (i5 < this.bPk.size()) {
                com.baidu.tieba.tbadkCore.data.d dVar = this.bPk.get(i5);
                if (com.baidu.tieba.tbadkCore.data.d.aE(i6, dVar.getType())) {
                    this.bPX.get(size - 1).b(dVar.aQ(context));
                    i3 = size;
                    i2 = i6;
                } else {
                    if (dVar.getType() == 3) {
                        this.bPX.add(dVar);
                        i = 3;
                    } else if (dVar.getType() == 11) {
                        this.bPX.add(dVar);
                        i = 11;
                    } else {
                        com.baidu.tieba.tbadkCore.data.d dVar2 = new com.baidu.tieba.tbadkCore.data.d();
                        dVar2.setType(0);
                        dVar2.b(dVar.aQ(context));
                        this.bPX.add(dVar2);
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
