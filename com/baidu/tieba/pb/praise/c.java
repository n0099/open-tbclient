package com.baidu.tieba.pb.praise;

import com.baidu.tbadk.mvc.b.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c implements l {
    private int bFe = 0;
    private int bFf = 0;
    private final List<a> bFg = new ArrayList(100);
    private int status;

    public void a(g gVar) {
        List<a> ZI = gVar.ZI();
        if (ZI != null) {
            for (a aVar : ZI) {
                this.bFg.add(aVar);
            }
        }
        this.bFf = this.bFg.size();
        this.bFe = gVar.ZH();
    }

    public void hg(int i) {
        this.bFe = i;
    }

    public int ZC() {
        return this.bFe;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public int getStatus() {
        return this.status;
    }

    public int ZD() {
        return this.bFf;
    }

    public List<a> ZE() {
        return this.bFg;
    }
}
