package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {
    protected h iIs = new h();
    protected i iIt = new i();
    private LinkedList<e> oJ = new LinkedList<>();
    private e iIu = null;

    public h cfZ() {
        return this.iIs;
    }

    public i cga() {
        return this.iIt;
    }

    public List<e> fL() {
        return Collections.unmodifiableList(this.oJ);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.oJ.add(eVar);
        }
    }

    public void b(e eVar) {
        this.iIu = eVar;
    }
}
