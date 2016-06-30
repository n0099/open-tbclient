package com.baidu.tieba.person.post;

import android.view.View;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class ag implements View.OnClickListener {
    final /* synthetic */ x eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(x xVar) {
        this.eob = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        this.eob.getBaseFragmentActivity().showLoadingDialog(this.eob.getResources().getString(u.j.loading));
        long longValue = ((Long) view.getTag()).longValue();
        qVar = this.eob.enX;
        qVar.cp(longValue);
    }
}
