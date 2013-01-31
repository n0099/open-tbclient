package com.baidu.tieba.nearby;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.a.aa;
import com.baidu.tieba.a.ab;
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
        this.a.n();
        mVar = this.a.h;
        Object item = mVar.getItem(i);
        if (item != null) {
            if (item instanceof aa) {
                FrsActivity.a(this.a, ((aa) item).a(), "radar");
            } else if (item instanceof ab) {
                PbActivity.a(this.a, ((ab) item).b(), "radar");
            }
        }
    }
}
