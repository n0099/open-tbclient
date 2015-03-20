package com.baidu.tieba.pb.pb.praise;

import com.baidu.tbadk.mvc.b.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c implements m {
    private int bMK = 0;
    private int bML = 0;
    private final List<a> bMM = new ArrayList(100);
    private int status;

    public void a(g gVar) {
        List<a> abL = gVar.abL();
        if (abL != null) {
            for (a aVar : abL) {
                this.bMM.add(aVar);
            }
        }
        this.bML = this.bMM.size();
        this.bMK = gVar.abK();
    }

    public void hq(int i) {
        this.bMK = i;
    }

    public int abF() {
        return this.bMK;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public int getStatus() {
        return this.status;
    }

    public int abG() {
        return this.bML;
    }

    public List<a> abH() {
        return this.bMM;
    }
}
