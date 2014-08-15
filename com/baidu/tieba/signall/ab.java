package com.baidu.tieba.signall;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ aa a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.a = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseActivity baseActivity;
        baseActivity = this.a.b;
        baseActivity.finish();
    }
}
