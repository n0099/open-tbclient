package com.baidu.tieba.square;

import android.view.KeyEvent;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareSearchActivity f2390a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(SquareSearchActivity squareSearchActivity) {
        this.f2390a = squareSearchActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        int i2;
        String str;
        if (i == 2) {
            i2 = this.f2390a.C;
            if (i2 == 0) {
                this.f2390a.d();
                return true;
            }
            SquareSearchActivity squareSearchActivity = this.f2390a;
            str = this.f2390a.B;
            squareSearchActivity.a(1, str);
            return true;
        }
        return false;
    }
}
