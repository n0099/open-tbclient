package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes20.dex */
public class g {
    protected h lmX = new h();
    protected i lmY = new i();
    private LinkedList<e> KV = new LinkedList<>();
    private e lmZ = null;

    public h dcp() {
        return this.lmX;
    }

    public i dcq() {
        return this.lmY;
    }

    public List<e> kV() {
        return Collections.unmodifiableList(this.KV);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.KV.add(eVar);
        }
    }

    public void b(e eVar) {
        this.lmZ = eVar;
    }
}
