package com.baidu.tieba.pb.praise;

import com.baidu.tbadk.mvc.b.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c implements l {
    private int bFd = 0;
    private int bFe = 0;
    private final List<a> bFf = new ArrayList(100);
    private int status;

    public void a(g gVar) {
        List<a> ZD = gVar.ZD();
        if (ZD != null) {
            for (a aVar : ZD) {
                this.bFf.add(aVar);
            }
        }
        this.bFe = this.bFf.size();
        this.bFd = gVar.ZC();
    }

    public void hg(int i) {
        this.bFd = i;
    }

    public int Zx() {
        return this.bFd;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public int getStatus() {
        return this.status;
    }

    public int Zy() {
        return this.bFe;
    }

    public List<a> Zz() {
        return this.bFf;
    }
}
