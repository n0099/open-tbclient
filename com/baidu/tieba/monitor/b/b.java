package com.baidu.tieba.monitor.b;

import com.baidu.adp.lib.util.f;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends a<com.baidu.tieba.play.d.d> {
    private boolean exY;

    public b(String str) {
        super(str);
        this.exY = f.dG();
    }

    @Override // com.baidu.tieba.monitor.b.c
    public String getKey() {
        return "avformat_open_input_json";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.monitor.b.a
    public void a(com.baidu.tieba.play.d.d dVar) {
        super.a((b) dVar);
        if (aNs() && this.exY) {
            aNt();
        }
    }

    private boolean aNs() {
        return this.list != null && this.list.size() > 30;
    }

    @Override // com.baidu.tieba.monitor.b.c
    public void aNt() {
        if (this.list != null && this.list.size() != 0) {
            cl(new ArrayList(this.list));
            this.list.clear();
        }
    }
}
