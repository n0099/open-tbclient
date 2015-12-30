package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class y {
    private ArrayList<com.baidu.tieba.tbadkCore.data.k> cjV = new ArrayList<>();
    private ArrayList<com.baidu.tieba.tbadkCore.data.k> ckK = new ArrayList<>();

    public void setContent(ArrayList<com.baidu.tieba.tbadkCore.data.k> arrayList) {
        this.cjV = arrayList;
    }

    public void az(Context context) {
        int i;
        int i2;
        int i3;
        if (this.cjV != null) {
            int i4 = -1;
            int size = this.ckK.size();
            if (size > 0) {
                try {
                    i4 = this.ckK.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i5 = 0;
            int i6 = i4;
            while (i5 < this.cjV.size()) {
                com.baidu.tieba.tbadkCore.data.k kVar = this.cjV.get(i5);
                if (com.baidu.tieba.tbadkCore.data.k.aY(i6, kVar.getType())) {
                    this.ckK.get(size - 1).b(kVar.aP(context));
                    i3 = size;
                    i2 = i6;
                } else {
                    if (kVar.getType() == 3) {
                        this.ckK.add(kVar);
                        i = 3;
                    } else if (kVar.getType() == 11) {
                        this.ckK.add(kVar);
                        i = 11;
                    } else {
                        com.baidu.tieba.tbadkCore.data.k kVar2 = new com.baidu.tieba.tbadkCore.data.k();
                        kVar2.setType(0);
                        kVar2.b(kVar.aP(context));
                        this.ckK.add(kVar2);
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
