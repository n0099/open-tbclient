package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class g {
    protected h mOb = new h();
    protected i mOc = new i();
    private LinkedList<e> Mw = new LinkedList<>();
    private e mOd = null;

    public h dFl() {
        return this.mOb;
    }

    public i dFm() {
        return this.mOc;
    }

    public List<e> lX() {
        return Collections.unmodifiableList(this.Mw);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.Mw.add(eVar);
        }
    }

    public void b(e eVar) {
        this.mOd = eVar;
    }
}
