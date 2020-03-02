package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes13.dex */
public class g {
    protected h jHj = new h();
    protected i jHk = new i();
    private LinkedList<e> rf = new LinkedList<>();
    private e jHl = null;

    public h cCK() {
        return this.jHj;
    }

    public i cCL() {
        return this.jHk;
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
        this.jHl = eVar;
    }
}
