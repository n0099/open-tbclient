package com.baidu.tieba.pb.pb.praise;

import com.baidu.tbadk.mvc.b.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c implements m {
    private int bOY = 0;
    private int bOZ = 0;
    private final List<a> bPa = new ArrayList(100);
    private int status;

    public void a(g gVar) {
        List<a> acS = gVar.acS();
        if (acS != null) {
            for (a aVar : acS) {
                this.bPa.add(aVar);
            }
        }
        this.bOZ = this.bPa.size();
        this.bOY = gVar.acR();
    }

    public void hG(int i) {
        this.bOY = i;
    }

    public int acM() {
        return this.bOY;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public int getStatus() {
        return this.status;
    }

    public int acN() {
        return this.bOZ;
    }

    public List<a> acO() {
        return this.bPa;
    }
}
