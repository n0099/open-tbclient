package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ i duN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.duN = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        String str;
        String str2;
        String str3;
        com.baidu.adp.widget.ListView.v vVar;
        z = this.duN.isSelf;
        if (!z) {
            str = this.duN.userId;
            if (str != null) {
                if (view.getId() == t.g.bar_head) {
                    aw r = new aw("c10619").r("obj_type", 1);
                    str3 = this.duN.userId;
                    TiebaStatic.log(r.ac("obj_id", str3));
                } else if (view.getId() == t.g.bar_none) {
                    aw r2 = new aw("c10619").r("obj_type", 3);
                    str2 = this.duN.userId;
                    TiebaStatic.log(r2.ac("obj_id", str2));
                }
            }
        } else if (view.getId() == t.g.bar_head) {
            TiebaStatic.log(new aw("c10593").r("obj_type", 1));
        } else if (view.getId() == t.g.bar_none) {
            TiebaStatic.log(new aw("c10593").r("obj_type", 3));
        }
        vVar = this.duN.duM;
        vVar.a(view, null, com.baidu.tieba.person.data.f.dwn, null, 0, view.getId());
    }
}
