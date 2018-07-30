package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {
    protected h gpq = new h();
    protected i gpr = new i();
    private LinkedList<e> zN = new LinkedList<>();
    private e gps = null;

    public h bnD() {
        return this.gpq;
    }

    public i bnE() {
        return this.gpr;
    }

    public List<e> hY() {
        return Collections.unmodifiableList(this.zN);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.zN.add(eVar);
        }
    }

    public void b(e eVar) {
        this.gps = eVar;
    }
}
