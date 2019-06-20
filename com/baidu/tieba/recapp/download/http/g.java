package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {
    protected h iAA = new h();
    protected i iAB = new i();
    private LinkedList<e> AD = new LinkedList<>();
    private e iAC = null;

    public h cfc() {
        return this.iAA;
    }

    public i cfd() {
        return this.iAB;
    }

    public List<e> im() {
        return Collections.unmodifiableList(this.AD);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.AD.add(eVar);
        }
    }

    public void b(e eVar) {
        this.iAC = eVar;
    }
}
