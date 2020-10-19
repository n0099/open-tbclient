package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes26.dex */
public class g {
    protected h mbU = new h();
    protected i mbV = new i();
    private LinkedList<e> Md = new LinkedList<>();
    private e mbW = null;

    public h duU() {
        return this.mbU;
    }

    public i duV() {
        return this.mbV;
    }

    public List<e> mz() {
        return Collections.unmodifiableList(this.Md);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.Md.add(eVar);
        }
    }

    public void b(e eVar) {
        this.mbW = eVar;
    }
}
