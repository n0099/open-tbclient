package com.baidu.tieba.write;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
class ai implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0018, code lost:
        if (r5 == r0) goto L22;
     */
    @Override // android.view.View.OnFocusChangeListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onFocusChange(View view, boolean z) {
        EditText editText;
        GridView gridView;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        EditText editText2;
        com.baidu.tieba.b.u uVar;
        EditText editText3;
        ImageView imageView4;
        ImageView imageView5;
        ImageView imageView6;
        com.baidu.tieba.b.u uVar2;
        EditText editText4;
        Button button;
        Button button2;
        editText = this.a.f;
        if (view != editText) {
            button = this.a.h;
            if (view != button) {
                button2 = this.a.i;
            }
        }
        if (z) {
            gridView = this.a.p;
            gridView.setVisibility(8);
            imageView = this.a.j;
            imageView.setClickable(false);
            imageView2 = this.a.k;
            imageView2.setClickable(false);
            imageView3 = this.a.l;
            imageView3.setClickable(false);
        }
        editText2 = this.a.g;
        if (view == editText2) {
            if (!z) {
                uVar = this.a.b;
                if (uVar.a() == 0) {
                    editText3 = this.a.g;
                    editText3.setHint(R.string.content);
                    return;
                }
                return;
            }
            imageView4 = this.a.j;
            imageView4.setClickable(true);
            imageView5 = this.a.k;
            imageView5.setClickable(true);
            imageView6 = this.a.l;
            imageView6.setClickable(true);
            uVar2 = this.a.b;
            if (uVar2.a() == 0) {
                editText4 = this.a.g;
                editText4.setHint((CharSequence) null);
            }
        }
    }
}
