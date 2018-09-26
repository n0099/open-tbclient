package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {
    protected h gwL = new h();
    protected i gwM = new i();
    private LinkedList<e> Cj = new LinkedList<>();
    private e gwN = null;

    public h bql() {
        return this.gwL;
    }

    public i bqm() {
        return this.gwM;
    }

    public List<e> je() {
        return Collections.unmodifiableList(this.Cj);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.Cj.add(eVar);
        }
    }

    public void b(e eVar) {
        this.gwN = eVar;
    }
}
