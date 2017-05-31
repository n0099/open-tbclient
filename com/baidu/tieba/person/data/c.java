package com.baidu.tieba.person.data;

import com.baidu.adp.widget.ListView.v;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c {
    private ArrayList<v> aaI;
    private int eGV = 0;
    private boolean eGW = true;

    public void al(ArrayList<v> arrayList) {
        this.aaI = arrayList;
    }

    public void po(int i) {
        this.eGV = i;
    }

    public boolean aPV() {
        return this.eGW;
    }

    public void jp(boolean z) {
        this.eGW = z;
    }

    public ArrayList<v> aPW() {
        return this.aaI;
    }
}
