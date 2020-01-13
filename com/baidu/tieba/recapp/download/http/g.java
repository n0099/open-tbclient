package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes11.dex */
public class g {
    protected h jGl = new h();
    protected i jGm = new i();
    private LinkedList<e> re = new LinkedList<>();
    private e jGn = null;

    public h cBk() {
        return this.jGl;
    }

    public i cBl() {
        return this.jGm;
    }

    public List<e> fZ() {
        return Collections.unmodifiableList(this.re);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.re.add(eVar);
        }
    }

    public void b(e eVar) {
        this.jGn = eVar;
    }
}
