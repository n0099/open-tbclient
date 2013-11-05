package com.baidu.tieba.square;

import android.view.View;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareSearchActivity f2344a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(SquareSearchActivity squareSearchActivity) {
        this.f2344a = squareSearchActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!z) {
            UtilHelper.a(this.f2344a, view);
        }
    }
}
