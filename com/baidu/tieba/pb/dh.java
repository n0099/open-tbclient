package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dh implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cp f2140a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dh(cp cpVar) {
        this.f2140a = cpVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        NewPbActivity newPbActivity;
        if (!z) {
            newPbActivity = this.f2140a.g;
            UtilHelper.a(newPbActivity, view);
        }
    }
}
