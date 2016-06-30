package com.baidu.tieba.personInfo;

import android.view.View;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnClickListener {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(f fVar) {
        this.this$0 = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        List list;
        List list2;
        List list3;
        if (view != null) {
            list = this.this$0.eoO;
            if (list != null) {
                com.baidu.adp.widget.ListView.v vVar = null;
                if (view.getTag() instanceof com.baidu.tieba.person.b.q) {
                    vVar = ((com.baidu.tieba.person.b.q) view.getTag()).vP();
                } else if (view.getTag() instanceof com.baidu.tieba.person.b.c) {
                    vVar = ((com.baidu.tieba.person.b.c) view.getTag()).vP();
                }
                list2 = this.this$0.eoO;
                int a = com.baidu.tbadk.core.util.y.a(list2, vVar);
                if (a >= 0) {
                    f fVar = this.this$0;
                    list3 = this.this$0.eoO;
                    fVar.a(vVar, list3, a);
                }
            }
        }
    }
}
