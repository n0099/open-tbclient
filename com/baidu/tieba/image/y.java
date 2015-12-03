package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class y {
    private ArrayList<com.baidu.tieba.tbadkCore.data.h> cfS = new ArrayList<>();
    private ArrayList<com.baidu.tieba.tbadkCore.data.h> cgF = new ArrayList<>();

    public void setContent(ArrayList<com.baidu.tieba.tbadkCore.data.h> arrayList) {
        this.cfS = arrayList;
    }

    public void az(Context context) {
        int i;
        int i2;
        int i3;
        if (this.cfS != null) {
            int i4 = -1;
            int size = this.cgF.size();
            if (size > 0) {
                try {
                    i4 = this.cgF.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i5 = 0;
            int i6 = i4;
            while (i5 < this.cfS.size()) {
                com.baidu.tieba.tbadkCore.data.h hVar = this.cfS.get(i5);
                if (com.baidu.tieba.tbadkCore.data.h.aJ(i6, hVar.getType())) {
                    this.cgF.get(size - 1).b(hVar.aO(context));
                    i3 = size;
                    i2 = i6;
                } else {
                    if (hVar.getType() == 3) {
                        this.cgF.add(hVar);
                        i = 3;
                    } else if (hVar.getType() == 11) {
                        this.cgF.add(hVar);
                        i = 11;
                    } else {
                        com.baidu.tieba.tbadkCore.data.h hVar2 = new com.baidu.tieba.tbadkCore.data.h();
                        hVar2.setType(0);
                        hVar2.b(hVar.aO(context));
                        this.cgF.add(hVar2);
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
