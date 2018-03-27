package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {
    protected h gDh = new h();
    protected i gDi = new i();
    private LinkedList<e> ajp = new LinkedList<>();
    private e gDj = null;

    public h bou() {
        return this.gDh;
    }

    public i bov() {
        return this.gDi;
    }

    public List<e> nd() {
        return Collections.unmodifiableList(this.ajp);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.ajp.add(eVar);
        }
    }

    public void b(e eVar) {
        this.gDj = eVar;
    }
}
