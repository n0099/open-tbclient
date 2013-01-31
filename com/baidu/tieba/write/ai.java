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
        ImageView imageView4;
        EditText editText2;
        com.baidu.tieba.b.w wVar;
        EditText editText3;
        ImageView imageView5;
        ImageView imageView6;
        ImageView imageView7;
        com.baidu.tieba.b.w wVar2;
        EditText editText4;
        Button button;
        Button button2;
        editText = this.a.g;
        if (view != editText) {
            button = this.a.i;
            if (view != button) {
                button2 = this.a.j;
            }
        }
        if (z) {
            gridView = this.a.q;
            gridView.setVisibility(8);
            imageView = this.a.k;
            imageView.setClickable(false);
            imageView2 = this.a.l;
            imageView2.setClickable(false);
            imageView3 = this.a.m;
            imageView3.setClickable(false);
            imageView4 = this.a.k;
            imageView4.setImageDrawable(this.a.getResources().getDrawable(R.drawable.write_face));
        }
        editText2 = this.a.h;
        if (view == editText2) {
            if (!z) {
                wVar = this.a.c;
                if (wVar.a() == 0) {
                    editText3 = this.a.h;
                    editText3.setHint(R.string.content);
                    return;
                }
                return;
            }
            imageView5 = this.a.k;
            imageView5.setClickable(true);
            imageView6 = this.a.l;
            imageView6.setClickable(true);
            imageView7 = this.a.m;
            imageView7.setClickable(true);
            wVar2 = this.a.c;
            if (wVar2.a() == 0) {
                editText4 = this.a.h;
                editText4.setHint((CharSequence) null);
            }
        }
    }
}
