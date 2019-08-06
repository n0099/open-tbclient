package com.baidu.tieba.j.a;

import com.baidu.adp.lib.util.f;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class b extends a<com.baidu.tieba.play.b.d> {
    private boolean hxd;

    public b(String str) {
        super(str);
        this.hxd = f.gB();
    }

    @Override // com.baidu.tieba.j.a.c
    public String getKey() {
        return "avformat_open_input_json";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.j.a.a
    public void a(com.baidu.tieba.play.b.d dVar) {
        super.a((b) dVar);
        if (bPo() && this.hxd) {
            bPp();
        }
    }

    private boolean bPo() {
        return this.list != null && this.list.size() > 30;
    }

    @Override // com.baidu.tieba.j.a.c
    public void bPp() {
        if (this.list != null && this.list.size() != 0) {
            dx(new ArrayList(this.list));
            this.list.clear();
        }
    }
}
