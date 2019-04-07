package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {
    protected h ihK = new h();
    protected i ihL = new i();
    private LinkedList<e> CW = new LinkedList<>();
    private e ihM = null;

    public h bWV() {
        return this.ihK;
    }

    public i bWW() {
        return this.ihL;
    }

    public List<e> jt() {
        return Collections.unmodifiableList(this.CW);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.CW.add(eVar);
        }
    }

    public void b(e eVar) {
        this.ihM = eVar;
    }
}
