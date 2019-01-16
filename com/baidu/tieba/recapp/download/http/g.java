package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {
    protected h gQy = new h();
    protected i gQz = new i();
    private LinkedList<e> CX = new LinkedList<>();
    private e gQA = null;

    public h bwj() {
        return this.gQy;
    }

    public i bwk() {
        return this.gQz;
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
        this.gQA = eVar;
    }
}
