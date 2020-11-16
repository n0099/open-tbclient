package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes25.dex */
public class g {
    protected h muG = new h();
    protected i muH = new i();
    private LinkedList<e> Me = new LinkedList<>();
    private e muI = null;

    public h dAd() {
        return this.muG;
    }

    public i dAe() {
        return this.muH;
    }

    public List<e> mz() {
        return Collections.unmodifiableList(this.Me);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.Me.add(eVar);
        }
    }

    public void b(e eVar) {
        this.muI = eVar;
    }
}
