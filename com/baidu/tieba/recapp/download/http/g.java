package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes13.dex */
public class g {
    protected h ksG = new h();
    protected i ksH = new i();
    private LinkedList<e> Kg = new LinkedList<>();
    private e ksI = null;

    public h cND() {
        return this.ksG;
    }

    public i cNE() {
        return this.ksH;
    }

    public List<e> kD() {
        return Collections.unmodifiableList(this.Kg);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.Kg.add(eVar);
        }
    }

    public void b(e eVar) {
        this.ksI = eVar;
    }
}
