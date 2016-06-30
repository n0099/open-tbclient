package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ j egf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.egf = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        String str;
        String str2;
        String str3;
        com.baidu.adp.widget.ListView.w wVar;
        z = this.egf.isSelf;
        if (!z) {
            str = this.egf.userId;
            if (str != null) {
                if (view.getId() == u.g.bar_head) {
                    ay s = new ay("c10619").s("obj_type", 1);
                    str3 = this.egf.userId;
                    TiebaStatic.log(s.ab("obj_id", str3));
                } else if (view.getId() == u.g.bar_none) {
                    ay s2 = new ay("c10619").s("obj_type", 3);
                    str2 = this.egf.userId;
                    TiebaStatic.log(s2.ab("obj_id", str2));
                }
            }
        } else if (view.getId() == u.g.bar_head) {
            TiebaStatic.log(new ay("c10593").s("obj_type", 1));
        } else if (view.getId() == u.g.bar_none) {
            TiebaStatic.log(new ay("c10593").s("obj_type", 3));
        }
        wVar = this.egf.ege;
        wVar.a(view, null, com.baidu.tieba.person.data.g.ehV, null, 0, view.getId());
    }
}
