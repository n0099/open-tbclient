package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes13.dex */
public class g {
    protected h kLN = new h();
    protected i kLO = new i();
    private LinkedList<e> Ku = new LinkedList<>();
    private e kLP = null;

    public h cUR() {
        return this.kLN;
    }

    public i cUS() {
        return this.kLO;
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
        this.kLP = eVar;
    }
}
