package com.baidu.tieba.square;

import android.view.View;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareSearchActivity f2406a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(SquareSearchActivity squareSearchActivity) {
        this.f2406a = squareSearchActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!z) {
            UtilHelper.a(this.f2406a, view);
        }
    }
}
