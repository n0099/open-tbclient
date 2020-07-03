package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes13.dex */
public class g {
    protected h lfH = new h();
    protected i lfI = new i();
    private LinkedList<e> KV = new LinkedList<>();
    private e lfJ = null;

    public h cZh() {
        return this.lfH;
    }

    public i cZi() {
        return this.lfI;
    }

    public List<e> kV() {
        return Collections.unmodifiableList(this.KV);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.KV.add(eVar);
        }
    }

    public void b(e eVar) {
        this.lfJ = eVar;
    }
}
