package com.baidu.tieba.pb.pb.praise;

import com.baidu.tbadk.mvc.b.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c implements m {
    private int bNa = 0;
    private int bNb = 0;
    private final List<a> bNc = new ArrayList(100);
    private int status;

    public void a(g gVar) {
        List<a> aca = gVar.aca();
        if (aca != null) {
            for (a aVar : aca) {
                this.bNc.add(aVar);
            }
        }
        this.bNb = this.bNc.size();
        this.bNa = gVar.abZ();
    }

    public void hs(int i) {
        this.bNa = i;
    }

    public int abU() {
        return this.bNa;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public int getStatus() {
        return this.status;
    }

    public int abV() {
        return this.bNb;
    }

    public List<a> abW() {
        return this.bNc;
    }
}
