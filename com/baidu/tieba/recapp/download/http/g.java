package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {
    protected h gCR = new h();
    protected i gCS = new i();
    private LinkedList<e> ajp = new LinkedList<>();
    private e gCT = null;

    public h bot() {
        return this.gCR;
    }

    public i bou() {
        return this.gCS;
    }

    public List<e> nd() {
        return Collections.unmodifiableList(this.ajp);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.ajp.add(eVar);
        }
    }

    public void b(e eVar) {
        this.gCT = eVar;
    }
}
