package com.baidu.tieba.pb.praise;

import com.baidu.tbadk.mvc.b.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c implements l {
    private int bDt = 0;
    private int bDu = 0;
    private final List<a> bDv = new ArrayList(100);
    private int status;

    public void a(g gVar) {
        List<a> Zd = gVar.Zd();
        if (Zd != null) {
            for (a aVar : Zd) {
                this.bDv.add(aVar);
            }
        }
        this.bDu = this.bDv.size();
        this.bDt = gVar.Zc();
    }

    public void gX(int i) {
        this.bDt = i;
    }

    public int YX() {
        return this.bDt;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public int getStatus() {
        return this.status;
    }

    public int YY() {
        return this.bDu;
    }

    public List<a> YZ() {
        return this.bDv;
    }
}
