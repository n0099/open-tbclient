package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ i cMn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.cMn = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        String str;
        String str2;
        String str3;
        com.baidu.adp.widget.ListView.v vVar;
        z = this.cMn.isSelf;
        if (!z) {
            str = this.cMn.userId;
            if (str != null) {
                if (view.getId() == n.f.bar_head) {
                    av r = new av("c10619").r("obj_type", 1);
                    str3 = this.cMn.userId;
                    TiebaStatic.log(r.ab("obj_id", str3));
                } else if (view.getId() == n.f.bar_none) {
                    av r2 = new av("c10619").r("obj_type", 3);
                    str2 = this.cMn.userId;
                    TiebaStatic.log(r2.ab("obj_id", str2));
                }
            }
        } else if (view.getId() == n.f.bar_head) {
            TiebaStatic.log(new av("c10593").r("obj_type", 1));
        } else if (view.getId() == n.f.bar_none) {
            TiebaStatic.log(new av("c10593").r("obj_type", 3));
        }
        vVar = this.cMn.cMm;
        vVar.a(view, null, com.baidu.tieba.person.data.f.cNs, null, 0, view.getId());
    }
}
