package com.baidu.tieba.recapp.download.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes26.dex */
public class g {
    protected h mot = new h();
    protected i mou = new i();
    private LinkedList<e> Me = new LinkedList<>();
    private e mov = null;

    public h dyb() {
        return this.mot;
    }

    public i dyc() {
        return this.mou;
    }

    public List<e> mz() {
        return Collections.unmodifiableList(this.Me);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.Me.add(eVar);
        }
    }

    public void b(e eVar) {
        this.mov = eVar;
    }
}
