package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {
    protected h gFN = new h();
    protected i gFO = new i();
    private LinkedList<e> CX = new LinkedList<>();
    private e gFP = null;

    public h bsW() {
        return this.gFN;
    }

    public i bsX() {
        return this.gFO;
    }

    public List<e> jr() {
        return Collections.unmodifiableList(this.CX);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.CX.add(eVar);
        }
    }

    public void b(e eVar) {
        this.gFP = eVar;
    }
}
