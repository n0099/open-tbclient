package com.baidu.tieba.mainentrance;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
final class k implements TextWatcher {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String str;
        int i4;
        int i5;
        this.a.y = charSequence.toString();
        this.a.A = "";
        str = this.a.y;
        if (str.trim().length() > 0) {
            i5 = this.a.z;
            if (i5 != 0) {
                return;
            }
            this.a.e();
            return;
        }
        this.a.a();
        i4 = this.a.z;
        if (i4 == 0) {
            this.a.c();
        } else {
            this.a.d();
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        Button button;
        TextView textView;
        TextView textView2;
        Button button2;
        if (editable.toString().trim().length() == 0) {
            button2 = this.a.d;
            button2.setVisibility(8);
        } else {
            button = this.a.d;
            button.setVisibility(0);
        }
        if (TbadkApplication.j().l() == 1) {
            textView2 = this.a.e;
            textView2.setTextColor(this.a.getResources().getColorStateList(com.baidu.tieba.a.e.common_new_page_title_1));
            return;
        }
        textView = this.a.e;
        textView.setTextColor(this.a.getResources().getColorStateList(com.baidu.tieba.a.e.white));
    }
}
