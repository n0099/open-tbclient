package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.person.data.h;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ l eqg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.eqg = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        String str;
        String str2;
        String str3;
        com.baidu.adp.widget.ListView.w wVar;
        z = this.eqg.isSelf;
        if (!z) {
            str = this.eqg.userId;
            if (str != null) {
                if (view.getId() == u.g.bar_head) {
                    ay s = new ay("c10619").s("obj_type", 1);
                    str3 = this.eqg.userId;
                    TiebaStatic.log(s.ab("obj_id", str3));
                } else if (view.getId() == u.g.bar_none) {
                    ay s2 = new ay("c10619").s("obj_type", 3);
                    str2 = this.eqg.userId;
                    TiebaStatic.log(s2.ab("obj_id", str2));
                }
            }
        } else if (view.getId() == u.g.bar_head) {
            TiebaStatic.log(new ay("c10593").s("obj_type", 1));
        } else if (view.getId() == u.g.bar_none) {
            TiebaStatic.log(new ay("c10593").s("obj_type", 3));
        }
        wVar = this.eqg.eqf;
        wVar.a(view, null, h.esb, null, 0, view.getId());
    }
}
