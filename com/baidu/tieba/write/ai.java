package com.baidu.tieba.write;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import com.baidu.tieba.data.WriteData;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class ai implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f1877a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(WriteActivity writeActivity) {
        this.f1877a = writeActivity;
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
        WriteData writeData;
        EditText editText3;
        ImageView imageView5;
        ImageView imageView6;
        ImageView imageView7;
        WriteData writeData2;
        EditText editText4;
        ImageView imageView8;
        Button button;
        editText = this.f1877a.e;
        if (view != editText) {
            imageView8 = this.f1877a.g;
            if (view != imageView8) {
                button = this.f1877a.j;
            }
        }
        if (z) {
            gridView = this.f1877a.r;
            gridView.setVisibility(8);
            imageView = this.f1877a.k;
            imageView.setClickable(false);
            imageView2 = this.f1877a.l;
            imageView2.setClickable(false);
            imageView3 = this.f1877a.m;
            imageView3.setClickable(false);
            imageView4 = this.f1877a.k;
            imageView4.setImageDrawable(this.f1877a.getResources().getDrawable(R.drawable.write_face));
        }
        editText2 = this.f1877a.f;
        if (view == editText2) {
            if (!z) {
                writeData = this.f1877a.f1866a;
                if (writeData.getType() == 0) {
                    editText3 = this.f1877a.f;
                    editText3.setHint(R.string.content);
                    return;
                }
                return;
            }
            imageView5 = this.f1877a.k;
            imageView5.setClickable(true);
            imageView6 = this.f1877a.l;
            imageView6.setClickable(true);
            imageView7 = this.f1877a.m;
            imageView7.setClickable(true);
            writeData2 = this.f1877a.f1866a;
            if (writeData2.getType() == 0) {
                editText4 = this.f1877a.f;
                editText4.setHint((CharSequence) null);
            }
        }
    }
}
