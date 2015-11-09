package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class y {
    private ArrayList<com.baidu.tieba.tbadkCore.data.h> bPF = new ArrayList<>();
    private ArrayList<com.baidu.tieba.tbadkCore.data.h> bQs = new ArrayList<>();

    public void setContent(ArrayList<com.baidu.tieba.tbadkCore.data.h> arrayList) {
        this.bPF = arrayList;
    }

    public void az(Context context) {
        int i;
        int i2;
        int i3;
        if (this.bPF != null) {
            int i4 = -1;
            int size = this.bQs.size();
            if (size > 0) {
                try {
                    i4 = this.bQs.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i5 = 0;
            int i6 = i4;
            while (i5 < this.bPF.size()) {
                com.baidu.tieba.tbadkCore.data.h hVar = this.bPF.get(i5);
                if (com.baidu.tieba.tbadkCore.data.h.aG(i6, hVar.getType())) {
                    this.bQs.get(size - 1).b(hVar.aP(context));
                    i3 = size;
                    i2 = i6;
                } else {
                    if (hVar.getType() == 3) {
                        this.bQs.add(hVar);
                        i = 3;
                    } else if (hVar.getType() == 11) {
                        this.bQs.add(hVar);
                        i = 11;
                    } else {
                        com.baidu.tieba.tbadkCore.data.h hVar2 = new com.baidu.tieba.tbadkCore.data.h();
                        hVar2.setType(0);
                        hVar2.b(hVar.aP(context));
                        this.bQs.add(hVar2);
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
