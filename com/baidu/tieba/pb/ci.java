package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ci implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bo f1538a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(bo boVar) {
        this.f1538a = boVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        com.baidu.tieba.g gVar;
        if (!z) {
            gVar = this.f1538a.b;
            UtilHelper.a(gVar, view);
        }
    }
}
