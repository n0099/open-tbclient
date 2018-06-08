package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {
    protected h gkp = new h();
    protected i gkq = new i();
    private LinkedList<e> zU = new LinkedList<>();
    private e gkr = null;

    public h boy() {
        return this.gkp;
    }

    public i boz() {
        return this.gkq;
    }

    public List<e> hX() {
        return Collections.unmodifiableList(this.zU);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.zU.add(eVar);
        }
    }

    public void b(e eVar) {
        this.gkr = eVar;
    }
}
