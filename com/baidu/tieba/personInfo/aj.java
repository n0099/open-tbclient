package com.baidu.tieba.personInfo;

import android.view.View;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnClickListener {
    final /* synthetic */ h this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(h hVar) {
        this.this$0 = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        List list;
        List list2;
        List list3;
        if (view != null) {
            list = this.this$0.eAE;
            if (list != null) {
                com.baidu.adp.widget.ListView.v vVar = null;
                if (view.getTag() instanceof com.baidu.tieba.person.holder.q) {
                    vVar = ((com.baidu.tieba.person.holder.q) view.getTag()).vP();
                } else if (view.getTag() instanceof com.baidu.tieba.person.holder.e) {
                    vVar = ((com.baidu.tieba.person.holder.e) view.getTag()).vP();
                }
                list2 = this.this$0.eAE;
                int a = com.baidu.tbadk.core.util.y.a(list2, vVar);
                if (a >= 0) {
                    h hVar = this.this$0;
                    list3 = this.this$0.eAE;
                    hVar.a(vVar, list3, a);
                }
            }
        }
    }
}
