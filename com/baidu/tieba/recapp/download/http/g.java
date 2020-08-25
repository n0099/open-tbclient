package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes20.dex */
public class g {
    protected h lDy = new h();
    protected i lDz = new i();
    private LinkedList<e> Ly = new LinkedList<>();
    private e lDA = null;

    public h dnx() {
        return this.lDy;
    }

    public i dny() {
        return this.lDz;
    }

    public List<e> mu() {
        return Collections.unmodifiableList(this.Ly);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.Ly.add(eVar);
        }
    }

    public void b(e eVar) {
        this.lDA = eVar;
    }
}
