package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes13.dex */
public class g {
    protected h kKE = new h();
    protected i kKF = new i();
    private LinkedList<e> Ku = new LinkedList<>();
    private e kKG = null;

    public h cUB() {
        return this.kKE;
    }

    public i cUC() {
        return this.kKF;
    }

    public List<e> kF() {
        return Collections.unmodifiableList(this.Ku);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.Ku.add(eVar);
        }
    }

    public void b(e eVar) {
        this.kKG = eVar;
    }
}
