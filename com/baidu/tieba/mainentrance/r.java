package com.baidu.tieba.mainentrance;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aw;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements TextWatcher {
    final /* synthetic */ SquareSearchActivity bnc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(SquareSearchActivity squareSearchActivity) {
        this.bnc = squareSearchActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String str;
        int i4;
        int i5;
        FrameLayout frameLayout;
        ListView listView;
        com.baidu.tbadk.core.view.o oVar;
        int i6;
        int i7;
        String str2;
        this.bnc.bmO = charSequence.toString();
        str = this.bnc.bmO;
        if (str.trim().length() > 0) {
            i6 = this.bnc.mMode;
            if (i6 != 0) {
                i7 = this.bnc.mMode;
                if (i7 == 1) {
                    SquareSearchActivity squareSearchActivity = this.bnc;
                    str2 = this.bnc.bmO;
                    squareSearchActivity.o(1, str2);
                    return;
                }
                return;
            }
            this.bnc.SJ();
            return;
        }
        this.bnc.oo();
        i4 = this.bnc.mMode;
        if (i4 != 0) {
            i5 = this.bnc.mMode;
            if (i5 != 3) {
                this.bnc.SH();
            } else {
                this.bnc.SI();
            }
        } else {
            this.bnc.SG();
        }
        frameLayout = this.bnc.bmB;
        frameLayout.setVisibility(0);
        listView = this.bnc.bmC;
        listView.setVisibility(0);
        oVar = this.bnc.ahX;
        oVar.setVisibility(8);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Button button;
        TextView textView;
        Button button2;
        if (editable.toString().trim().length() == 0) {
            button2 = this.bnc.bmw;
            button2.setVisibility(8);
        } else {
            button = this.bnc.bmw;
            button.setVisibility(0);
        }
        textView = this.bnc.bmx;
        aw.b(textView, com.baidu.tieba.s.common_page_title, 1);
    }
}
