package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {
    protected h fYX = new h();
    protected i fYY = new i();
    private LinkedList<e> tP = new LinkedList<>();
    private e fYZ = null;

    public h bjz() {
        return this.fYX;
    }

    public i bjA() {
        return this.fYY;
    }

    public List<e> fg() {
        return Collections.unmodifiableList(this.tP);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.tP.add(eVar);
        }
    }

    public void b(e eVar) {
        this.fYZ = eVar;
    }
}
