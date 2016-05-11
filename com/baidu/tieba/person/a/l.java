package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ j dxJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.dxJ = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        String str;
        String str2;
        String str3;
        com.baidu.adp.widget.ListView.w wVar;
        z = this.dxJ.isSelf;
        if (!z) {
            str = this.dxJ.userId;
            if (str != null) {
                if (view.getId() == t.g.bar_head) {
                    aw s = new aw("c10619").s("obj_type", 1);
                    str3 = this.dxJ.userId;
                    TiebaStatic.log(s.ac("obj_id", str3));
                } else if (view.getId() == t.g.bar_none) {
                    aw s2 = new aw("c10619").s("obj_type", 3);
                    str2 = this.dxJ.userId;
                    TiebaStatic.log(s2.ac("obj_id", str2));
                }
            }
        } else if (view.getId() == t.g.bar_head) {
            TiebaStatic.log(new aw("c10593").s("obj_type", 1));
        } else if (view.getId() == t.g.bar_none) {
            TiebaStatic.log(new aw("c10593").s("obj_type", 3));
        }
        wVar = this.dxJ.dxI;
        wVar.a(view, null, com.baidu.tieba.person.data.g.dzr, null, 0, view.getId());
    }
}
