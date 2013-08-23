package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditHeadActivity f1650a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(EditHeadActivity editHeadActivity) {
        this.f1650a = editHeadActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1650a.setResult(0);
        this.f1650a.finish();
    }
}
