package com.baidu.tieba.square;

import android.view.KeyEvent;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareSearchActivity f2346a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(SquareSearchActivity squareSearchActivity) {
        this.f2346a = squareSearchActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        int i2;
        String str;
        if (i == 2) {
            i2 = this.f2346a.F;
            if (i2 == 0) {
                this.f2346a.e();
                return true;
            }
            SquareSearchActivity squareSearchActivity = this.f2346a;
            str = this.f2346a.E;
            squareSearchActivity.a(1, str);
            return true;
        }
        return false;
    }
}
