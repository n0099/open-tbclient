package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes26.dex */
public class g {
    protected h muq = new h();
    protected i mur = new i();
    private LinkedList<e> Me = new LinkedList<>();
    private e mus = null;

    public h dAD() {
        return this.muq;
    }

    public i dAE() {
        return this.mur;
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
        this.mus = eVar;
    }
}
