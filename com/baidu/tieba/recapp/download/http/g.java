package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {
    protected h iGS = new h();
    protected i iGT = new i();
    private LinkedList<e> AJ = new LinkedList<>();
    private e iGU = null;

    public h chT() {
        return this.iGS;
    }

    public i chU() {
        return this.iGT;
    }

    public List<e> iw() {
        return Collections.unmodifiableList(this.AJ);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.AJ.add(eVar);
        }
    }

    public void b(e eVar) {
        this.iGU = eVar;
    }
}
