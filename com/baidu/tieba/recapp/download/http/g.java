package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {
    protected h gMD = new h();
    protected i gME = new i();
    private LinkedList<e> CX = new LinkedList<>();
    private e gMF = null;

    public h buO() {
        return this.gMD;
    }

    public i buP() {
        return this.gME;
    }

    public List<e> jr() {
        return Collections.unmodifiableList(this.CX);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.CX.add(eVar);
        }
    }

    public void b(e eVar) {
        this.gMF = eVar;
    }
}
