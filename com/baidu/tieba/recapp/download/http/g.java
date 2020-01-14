package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes11.dex */
public class g {
    protected h jGq = new h();
    protected i jGr = new i();
    private LinkedList<e> re = new LinkedList<>();
    private e jGs = null;

    public h cBm() {
        return this.jGq;
    }

    public i cBn() {
        return this.jGr;
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
        this.jGs = eVar;
    }
}
