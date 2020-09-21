package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes25.dex */
public class g {
    protected h lMD = new h();
    protected i lME = new i();
    private LinkedList<e> LK = new LinkedList<>();
    private e lMF = null;

    public h drj() {
        return this.lMD;
    }

    public i drk() {
        return this.lME;
    }

    public List<e> my() {
        return Collections.unmodifiableList(this.LK);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.LK.add(eVar);
        }
    }

    public void b(e eVar) {
        this.lMF = eVar;
    }
}
