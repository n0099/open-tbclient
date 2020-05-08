package com.baidu.tieba.k.a;

import com.baidu.adp.lib.util.f;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class b extends a<com.baidu.tieba.play.b.d> {
    private boolean jcu;

    public b(String str) {
        super(str);
        this.jcu = f.checkSD();
    }

    @Override // com.baidu.tieba.k.a.c
    public String getKey() {
        return "avformat_open_input_json";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.k.a.a
    public void a(com.baidu.tieba.play.b.d dVar) {
        super.a((b) dVar);
        if (csb() && this.jcu) {
            csc();
        }
    }

    private boolean csb() {
        return this.list != null && this.list.size() > 30;
    }

    @Override // com.baidu.tieba.k.a.c
    public void csc() {
        if (this.list != null && this.list.size() != 0) {
            dG(new ArrayList(this.list));
            this.list.clear();
        }
    }
}
