package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {
    protected h gPv = new h();
    protected i gPw = new i();
    private LinkedList<e> CX = new LinkedList<>();
    private e gPx = null;

    public h bvA() {
        return this.gPv;
    }

    public i bvB() {
        return this.gPw;
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
        this.gPx = eVar;
    }
}
