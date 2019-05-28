package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {
    protected h iAz = new h();
    protected i iAA = new i();
    private LinkedList<e> AE = new LinkedList<>();
    private e iAB = null;

    public h cfb() {
        return this.iAz;
    }

    public i cfc() {
        return this.iAA;
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
        this.iAB = eVar;
    }
}
