package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes13.dex */
public class g {
    protected h jIU = new h();
    protected i jIV = new i();
    private LinkedList<e> rf = new LinkedList<>();
    private e jIW = null;

    public h cDf() {
        return this.jIU;
    }

    public i cDg() {
        return this.jIV;
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
        this.jIW = eVar;
    }
}
