package com.baidu.tieba.pb.praise;

import com.baidu.tbadk.mvc.b.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c implements k {
    private int bzB = 0;
    private int bzC = 0;
    private final List<a> bzD = new ArrayList(100);
    private int status;

    public void a(g gVar) {
        List<a> YF = gVar.YF();
        if (YF != null) {
            for (a aVar : YF) {
                this.bzD.add(aVar);
            }
        }
        this.bzC = this.bzD.size();
        this.bzB = gVar.YE();
    }

    public void gR(int i) {
        this.bzB = i;
    }

    public int Yz() {
        return this.bzB;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public int getStatus() {
        return this.status;
    }

    public int YA() {
        return this.bzC;
    }

    public List<a> YB() {
        return this.bzD;
    }
}
