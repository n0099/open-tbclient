package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {
    protected h iie = new h();
    protected i iif = new i();
    private LinkedList<e> CW = new LinkedList<>();
    private e iig = null;

    public h bWX() {
        return this.iie;
    }

    public i bWY() {
        return this.iif;
    }

    public List<e> jt() {
        return Collections.unmodifiableList(this.CW);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.CW.add(eVar);
        }
    }

    public void b(e eVar) {
        this.iig = eVar;
    }
}
