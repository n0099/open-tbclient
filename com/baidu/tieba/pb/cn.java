package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cn implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ br f1585a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(br brVar) {
        this.f1585a = brVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        NewPbActivity newPbActivity;
        if (!z) {
            newPbActivity = this.f1585a.c;
            UtilHelper.a(newPbActivity, view);
        }
    }
}
