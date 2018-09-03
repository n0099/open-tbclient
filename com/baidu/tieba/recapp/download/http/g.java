package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {
    protected h gpt = new h();
    protected i gpu = new i();
    private LinkedList<e> zO = new LinkedList<>();
    private e gpv = null;

    public h bnE() {
        return this.gpt;
    }

    public i bnF() {
        return this.gpu;
    }

    public List<e> hY() {
        return Collections.unmodifiableList(this.zO);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.zO.add(eVar);
        }
    }

    public void b(e eVar) {
        this.gpv = eVar;
    }
}
