package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes20.dex */
public class g {
    protected h lDJ = new h();
    protected i lDK = new i();
    private LinkedList<e> Ly = new LinkedList<>();
    private e lDL = null;

    public h dnA() {
        return this.lDJ;
    }

    public i dnB() {
        return this.lDK;
    }

    public List<e> mu() {
        return Collections.unmodifiableList(this.Ly);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.Ly.add(eVar);
        }
    }

    public void b(e eVar) {
        this.lDL = eVar;
    }
}
