package com.baidu.tieba.person.a;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.personInfo.bp;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements AdapterView.OnItemClickListener {
    final /* synthetic */ ai dvJ;
    private final /* synthetic */ af dvL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ai aiVar, af afVar) {
        this.dvJ = aiVar;
        this.dvL = afVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        bp.a item = this.dvL.getItem(i);
        if (item == null) {
            return;
        }
        this.dvJ.mp(item.aCa());
    }
}
