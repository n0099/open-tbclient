package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
/* loaded from: classes.dex */
public class aa extends bg {
    public static final BdUniqueId frh = BdUniqueId.gen();
    private String fortune_desc;
    private boolean fri;
    private q frj;

    public boolean bil() {
        return this.fri;
    }

    public void kI(boolean z) {
        this.fri = z;
    }

    public String bim() {
        return this.fortune_desc;
    }

    public void qS(String str) {
        this.fortune_desc = str;
    }

    public q bin() {
        return this.frj;
    }

    public void b(q qVar) {
        this.frj = qVar;
    }

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return frh;
    }
}
