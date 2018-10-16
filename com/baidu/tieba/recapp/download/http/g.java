package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {
    protected h gEl = new h();
    protected i gEm = new i();
    private LinkedList<e> CT = new LinkedList<>();
    private e gEn = null;

    public h btA() {
        return this.gEl;
    }

    public i btB() {
        return this.gEm;
    }

    public List<e> jt() {
        return Collections.unmodifiableList(this.CT);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.CT.add(eVar);
        }
    }

    public void b(e eVar) {
        this.gEn = eVar;
    }
}
