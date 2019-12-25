package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes10.dex */
public class g {
    protected h jCJ = new h();
    protected i jCK = new i();
    private LinkedList<e> rg = new LinkedList<>();
    private e jCL = null;

    public h cAd() {
        return this.jCJ;
    }

    public i cAe() {
        return this.jCK;
    }

    public List<e> ga() {
        return Collections.unmodifiableList(this.rg);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.rg.add(eVar);
        }
    }

    public void b(e eVar) {
        this.jCL = eVar;
    }
}
