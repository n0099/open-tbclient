package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {
    protected h ihY = new h();
    protected i ihZ = new i();
    private LinkedList<e> CW = new LinkedList<>();
    private e iia = null;

    public h bWZ() {
        return this.ihY;
    }

    public i bXa() {
        return this.ihZ;
    }

    public List<e> jt() {
        return Collections.unmodifiableList(this.CW);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.CW.add(eVar);
        }
    }

    public void b(e eVar) {
        this.iia = eVar;
    }
}
