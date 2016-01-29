package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ i daj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.daj = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        String str;
        String str2;
        String str3;
        com.baidu.adp.widget.ListView.v vVar;
        z = this.daj.isSelf;
        if (!z) {
            str = this.daj.userId;
            if (str != null) {
                if (view.getId() == t.g.bar_head) {
                    au r = new au("c10619").r("obj_type", 1);
                    str3 = this.daj.userId;
                    TiebaStatic.log(r.aa("obj_id", str3));
                } else if (view.getId() == t.g.bar_none) {
                    au r2 = new au("c10619").r("obj_type", 3);
                    str2 = this.daj.userId;
                    TiebaStatic.log(r2.aa("obj_id", str2));
                }
            }
        } else if (view.getId() == t.g.bar_head) {
            TiebaStatic.log(new au("c10593").r("obj_type", 1));
        } else if (view.getId() == t.g.bar_none) {
            TiebaStatic.log(new au("c10593").r("obj_type", 3));
        }
        vVar = this.daj.dai;
        vVar.a(view, null, com.baidu.tieba.person.data.f.dbK, null, 0, view.getId());
    }
}
