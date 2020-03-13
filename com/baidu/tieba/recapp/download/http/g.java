package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes13.dex */
public class g {
    protected h jHv = new h();
    protected i jHw = new i();
    private LinkedList<e> rf = new LinkedList<>();
    private e jHx = null;

    public h cCL() {
        return this.jHv;
    }

    public i cCM() {
        return this.jHw;
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
        this.jHx = eVar;
    }
}
