package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditHeadActivity f2254a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(EditHeadActivity editHeadActivity) {
        this.f2254a = editHeadActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2254a.setResult(0);
        this.f2254a.finish();
    }
}
