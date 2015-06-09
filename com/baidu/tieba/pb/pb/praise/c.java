package com.baidu.tieba.pb.pb.praise;

import com.baidu.tbadk.mvc.b.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c implements m {
    private int bOZ = 0;
    private int bPa = 0;
    private final List<a> bPb = new ArrayList(100);
    private int status;

    public void a(g gVar) {
        List<a> acT = gVar.acT();
        if (acT != null) {
            for (a aVar : acT) {
                this.bPb.add(aVar);
            }
        }
        this.bPa = this.bPb.size();
        this.bOZ = gVar.acS();
    }

    public void hG(int i) {
        this.bOZ = i;
    }

    public int acN() {
        return this.bOZ;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public int getStatus() {
        return this.status;
    }

    public int acO() {
        return this.bPa;
    }

    public List<a> acP() {
        return this.bPb;
    }
}
