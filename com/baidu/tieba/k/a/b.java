package com.baidu.tieba.k.a;

import com.baidu.adp.lib.util.f;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class b extends a<com.baidu.tieba.play.b.d> {
    private boolean jrx;

    public b(String str) {
        super(str);
        this.jrx = f.checkSD();
    }

    @Override // com.baidu.tieba.k.a.c
    public String getKey() {
        return "avformat_open_input_json";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.k.a.a
    public void a(com.baidu.tieba.play.b.d dVar) {
        super.a((b) dVar);
        if (cyF() && this.jrx) {
            cyG();
        }
    }

    private boolean cyF() {
        return this.list != null && this.list.size() > 30;
    }

    @Override // com.baidu.tieba.k.a.c
    public void cyG() {
        if (this.list != null && this.list.size() != 0) {
            dE(new ArrayList(this.list));
            this.list.clear();
        }
    }
}
