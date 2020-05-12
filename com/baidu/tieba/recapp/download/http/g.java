package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes13.dex */
public class g {
    protected h ksK = new h();
    protected i ksL = new i();
    private LinkedList<e> Kj = new LinkedList<>();
    private e ksM = null;

    public h cNB() {
        return this.ksK;
    }

    public i cNC() {
        return this.ksL;
    }

    public List<e> kD() {
        return Collections.unmodifiableList(this.Kj);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.Kj.add(eVar);
        }
    }

    public void b(e eVar) {
        this.ksM = eVar;
    }
}
