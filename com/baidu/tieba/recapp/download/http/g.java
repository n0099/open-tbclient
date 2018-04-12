package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {
    protected h fXU = new h();
    protected i fXV = new i();
    private LinkedList<e> tQ = new LinkedList<>();
    private e fXW = null;

    public h bjA() {
        return this.fXU;
    }

    public i bjB() {
        return this.fXV;
    }

    public List<e> fg() {
        return Collections.unmodifiableList(this.tQ);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.tQ.add(eVar);
        }
    }

    public void b(e eVar) {
        this.fXW = eVar;
    }
}
