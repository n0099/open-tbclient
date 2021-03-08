package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class g {
    protected h mVn = new h();
    protected i mVo = new i();
    private LinkedList<e> NT = new LinkedList<>();
    private e mVp = null;

    public h dDS() {
        return this.mVn;
    }

    public i dDT() {
        return this.mVo;
    }

    public List<e> lW() {
        return Collections.unmodifiableList(this.NT);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.NT.add(eVar);
        }
    }

    public void b(e eVar) {
        this.mVp = eVar;
    }
}
