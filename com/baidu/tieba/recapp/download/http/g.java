package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class g {
    protected h mTg = new h();
    protected i mTh = new i();
    private LinkedList<e> Ms = new LinkedList<>();
    private e mTi = null;

    public h dDK() {
        return this.mTg;
    }

    public i dDL() {
        return this.mTh;
    }

    public List<e> lW() {
        return Collections.unmodifiableList(this.Ms);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.Ms.add(eVar);
        }
    }

    public void b(e eVar) {
        this.mTi = eVar;
    }
}
