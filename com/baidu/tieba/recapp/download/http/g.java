package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {
    protected h iid = new h();
    protected i iie = new i();
    private LinkedList<e> CW = new LinkedList<>();
    private e iif = null;

    public h bWW() {
        return this.iid;
    }

    public i bWX() {
        return this.iie;
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
        this.iif = eVar;
    }
}
