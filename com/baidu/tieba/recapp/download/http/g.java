package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {
    protected h iAx = new h();
    protected i iAy = new i();
    private LinkedList<e> AE = new LinkedList<>();
    private e iAz = null;

    public h ceZ() {
        return this.iAx;
    }

    public i cfa() {
        return this.iAy;
    }

    public List<e> im() {
        return Collections.unmodifiableList(this.AE);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.AE.add(eVar);
        }
    }

    public void b(e eVar) {
        this.iAz = eVar;
    }
}
