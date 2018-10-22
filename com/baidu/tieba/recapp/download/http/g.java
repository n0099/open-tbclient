package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {
    protected h gEm = new h();
    protected i gEn = new i();
    private LinkedList<e> CT = new LinkedList<>();
    private e gEo = null;

    public h btA() {
        return this.gEm;
    }

    public i btB() {
        return this.gEn;
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
        this.gEo = eVar;
    }
}
