package com.baidu.tieba.k.a;

import com.baidu.adp.lib.util.f;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class b extends a<com.baidu.tieba.play.b.d> {
    private boolean jJU;

    public b(String str) {
        super(str);
        this.jJU = f.checkSD();
    }

    @Override // com.baidu.tieba.k.a.c
    public String getKey() {
        return "avformat_open_input_json";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.k.a.a
    public void a(com.baidu.tieba.play.b.d dVar) {
        super.a((b) dVar);
        if (cCU() && this.jJU) {
            cCV();
        }
    }

    private boolean cCU() {
        return this.list != null && this.list.size() > 30;
    }

    @Override // com.baidu.tieba.k.a.c
    public void cCV() {
        if (this.list != null && this.list.size() != 0) {
            dU(new ArrayList(this.list));
            this.list.clear();
        }
    }
}
