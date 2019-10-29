package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {
    protected h iJj = new h();
    protected i iJk = new i();
    private LinkedList<e> pl = new LinkedList<>();
    private e iJl = null;

    public h cgb() {
        return this.iJj;
    }

    public i cgc() {
        return this.iJk;
    }

    public List<e> fL() {
        return Collections.unmodifiableList(this.pl);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.pl.add(eVar);
        }
    }

    public void b(e eVar) {
        this.iJl = eVar;
    }
}
