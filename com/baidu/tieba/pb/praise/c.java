package com.baidu.tieba.pb.praise;

import com.baidu.tbadk.mvc.b.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c implements k {
    private int bzn = 0;
    private int bzo = 0;
    private final List<a> bzp = new ArrayList(100);
    private int status;

    public void a(g gVar) {
        List<a> YC = gVar.YC();
        if (YC != null) {
            for (a aVar : YC) {
                this.bzp.add(aVar);
            }
        }
        this.bzo = this.bzp.size();
        this.bzn = gVar.YB();
    }

    public void gR(int i) {
        this.bzn = i;
    }

    public int Yw() {
        return this.bzn;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public int getStatus() {
        return this.status;
    }

    public int Yx() {
        return this.bzo;
    }

    public List<a> Yy() {
        return this.bzp;
    }
}
