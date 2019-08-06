package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {
    protected h iHW = new h();
    protected i iHX = new i();
    private LinkedList<e> AJ = new LinkedList<>();
    private e iHY = null;

    public h cil() {
        return this.iHW;
    }

    public i cim() {
        return this.iHX;
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
        this.iHY = eVar;
    }
}
