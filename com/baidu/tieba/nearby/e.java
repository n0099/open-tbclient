package com.baidu.tieba.nearby;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.a.aa;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.pb.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements AdapterView.OnItemClickListener {
    final /* synthetic */ LbsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(LbsActivity lbsActivity) {
        this.a = lbsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        m mVar;
        this.a.l();
        mVar = this.a.g;
        Object item = mVar.getItem(i);
        if (item == null) {
            return;
        }
        if (item instanceof com.baidu.tieba.a.z) {
            FrsActivity.a(this.a, ((com.baidu.tieba.a.z) item).a(), "radar");
        } else if (item instanceof aa) {
            PbActivity.a(this.a, ((aa) item).b(), "radar");
        }
    }
}
