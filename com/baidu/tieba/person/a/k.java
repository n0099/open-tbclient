package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ i cQF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.cQF = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        String str;
        String str2;
        String str3;
        com.baidu.adp.widget.ListView.v vVar;
        z = this.cQF.isSelf;
        if (!z) {
            str = this.cQF.userId;
            if (str != null) {
                if (view.getId() == n.g.bar_head) {
                    av r = new av("c10619").r("obj_type", 1);
                    str3 = this.cQF.userId;
                    TiebaStatic.log(r.aa("obj_id", str3));
                } else if (view.getId() == n.g.bar_none) {
                    av r2 = new av("c10619").r("obj_type", 3);
                    str2 = this.cQF.userId;
                    TiebaStatic.log(r2.aa("obj_id", str2));
                }
            }
        } else if (view.getId() == n.g.bar_head) {
            TiebaStatic.log(new av("c10593").r("obj_type", 1));
        } else if (view.getId() == n.g.bar_none) {
            TiebaStatic.log(new av("c10593").r("obj_type", 3));
        }
        vVar = this.cQF.cQE;
        vVar.a(view, null, com.baidu.tieba.person.data.f.cRW, null, 0, view.getId());
    }
}
