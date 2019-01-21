package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {
    protected h gQz = new h();
    protected i gQA = new i();
    private LinkedList<e> CX = new LinkedList<>();
    private e gQB = null;

    public h bwj() {
        return this.gQz;
    }

    public i bwk() {
        return this.gQA;
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
        this.gQB = eVar;
    }
}
