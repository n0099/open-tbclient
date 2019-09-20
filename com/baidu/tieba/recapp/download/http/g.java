package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {
    protected h iKs = new h();
    protected i iKt = new i();
    private LinkedList<e> AJ = new LinkedList<>();
    private e iKu = null;

    public h ciZ() {
        return this.iKs;
    }

    public i cja() {
        return this.iKt;
    }

    public List<e> iw() {
        return Collections.unmodifiableList(this.AJ);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.AJ.add(eVar);
        }
    }

    public void b(e eVar) {
        this.iKu = eVar;
    }
}
