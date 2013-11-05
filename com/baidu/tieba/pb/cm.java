package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cm implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bt f2100a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(bt btVar) {
        this.f2100a = btVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        NewPbActivity newPbActivity;
        if (!z) {
            newPbActivity = this.f2100a.c;
            UtilHelper.a(newPbActivity, view);
        }
    }
}
