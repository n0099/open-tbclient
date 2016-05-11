package com.baidu.tieba.recommendfrs.personalize.a;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.recommendfrs.personalize.a.v;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements AdapterView.OnItemClickListener {
    final /* synthetic */ v.a ebH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v.a aVar) {
        this.ebH = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        u uVar;
        u uVar2;
        v vVar;
        u uVar3;
        v vVar2;
        Context context;
        if (!com.baidu.adp.lib.util.i.fq()) {
            vVar2 = v.this;
            context = vVar2.mContext;
            com.baidu.adp.lib.util.k.showToast(context, t.j.neterror);
            return;
        }
        uVar = this.ebH.ebE;
        com.baidu.tieba.recommendfrs.data.j item = uVar.getItem(i);
        item.dZY = !item.dZY;
        uVar2 = this.ebH.ebE;
        uVar2.notifyDataSetChanged();
        vVar = v.this;
        uVar3 = this.ebH.ebE;
        vVar.b(uVar3.aML());
        TiebaStatic.log(new aw("c10986").ac("obj_name", item.dZX));
    }
}
