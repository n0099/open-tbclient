package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {
    protected h gDg = new h();
    protected i gDh = new i();
    private LinkedList<e> ajv = new LinkedList<>();
    private e gDi = null;

    public h bou() {
        return this.gDg;
    }

    public i bov() {
        return this.gDh;
    }

    public List<e> nd() {
        return Collections.unmodifiableList(this.ajv);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.ajv.add(eVar);
        }
    }

    public void b(e eVar) {
        this.gDi = eVar;
    }
}
