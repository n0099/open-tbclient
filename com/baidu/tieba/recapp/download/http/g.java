package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes13.dex */
public class g {
    protected h jHh = new h();
    protected i jHi = new i();
    private LinkedList<e> rf = new LinkedList<>();
    private e jHj = null;

    public h cCI() {
        return this.jHh;
    }

    public i cCJ() {
        return this.jHi;
    }

    public List<e> fZ() {
        return Collections.unmodifiableList(this.rf);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.rf.add(eVar);
        }
    }

    public void b(e eVar) {
        this.jHj = eVar;
    }
}
