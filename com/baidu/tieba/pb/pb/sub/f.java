package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ b exL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar) {
        this.exL = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseActivity baseActivity;
        baseActivity = this.exL.bfa;
        baseActivity.finish();
    }
}
