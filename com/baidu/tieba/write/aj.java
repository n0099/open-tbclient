package com.baidu.tieba.write;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
class aj implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0019, code lost:
        if (r6 == r0) goto L28;
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
        com.baidu.tieba.b.y yVar;
        com.baidu.tieba.b.y yVar2;
        EditText editText3;
        EditText editText4;
        ImageView imageView5;
        ImageView imageView6;
        ImageView imageView7;
        com.baidu.tieba.b.y yVar3;
        EditText editText5;
        com.baidu.tieba.b.y yVar4;
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
            gridView = this.a.r;
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
                yVar = this.a.c;
                if (yVar.a() != 0) {
                    yVar2 = this.a.c;
                    if (yVar2.a() == 3) {
                        editText3 = this.a.h;
                        editText3.setHint(R.string.lbs_post_content_hint);
                        return;
                    }
                    return;
                }
                editText4 = this.a.h;
                editText4.setHint(R.string.content);
                return;
            }
            imageView5 = this.a.k;
            imageView5.setClickable(true);
            imageView6 = this.a.l;
            imageView6.setClickable(true);
            imageView7 = this.a.m;
            imageView7.setClickable(true);
            yVar3 = this.a.c;
            if (yVar3.a() != 0) {
                yVar4 = this.a.c;
                if (yVar4.a() != 3) {
                    return;
                }
            }
            editText5 = this.a.h;
            editText5.setHint((CharSequence) null);
        }
    }
}
