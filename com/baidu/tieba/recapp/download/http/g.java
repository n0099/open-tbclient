package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {
    protected h gog = new h();
    protected i goh = new i();
    private LinkedList<e> zS = new LinkedList<>();
    private e goi = null;

    public h boZ() {
        return this.gog;
    }

    public i bpa() {
        return this.goh;
    }

    public List<e> hX() {
        return Collections.unmodifiableList(this.zS);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.zS.add(eVar);
        }
    }

    public void b(e eVar) {
        this.goi = eVar;
    }
}
