package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class g {
    protected h mOc = new h();
    protected i mOd = new i();
    private LinkedList<e> Mw = new LinkedList<>();
    private e mOe = null;

    public h dFk() {
        return this.mOc;
    }

    public i dFl() {
        return this.mOd;
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
        this.mOe = eVar;
    }
}
