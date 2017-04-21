package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ b euT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar) {
        this.euT = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseActivity baseActivity;
        baseActivity = this.euT.bdG;
        baseActivity.finish();
    }
}
