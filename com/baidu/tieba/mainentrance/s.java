package com.baidu.tieba.mainentrance;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.bc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements TextWatcher {
    final /* synthetic */ SquareSearchActivity bta;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(SquareSearchActivity squareSearchActivity) {
        this.bta = squareSearchActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String str;
        int i4;
        int i5;
        FrameLayout frameLayout;
        ListView listView;
        com.baidu.tbadk.core.view.x xVar;
        int i6;
        int i7;
        String str2;
        this.bta.bsN = charSequence.toString();
        str = this.bta.bsN;
        if (str.trim().length() > 0) {
            i6 = this.bta.mMode;
            if (i6 != 0) {
                i7 = this.bta.mMode;
                if (i7 == 1) {
                    SquareSearchActivity squareSearchActivity = this.bta;
                    str2 = this.bta.bsN;
                    squareSearchActivity.y(1, str2);
                    return;
                }
                return;
            }
            this.bta.Ug();
            return;
        }
        this.bta.ru();
        i4 = this.bta.mMode;
        if (i4 != 0) {
            i5 = this.bta.mMode;
            if (i5 != 3) {
                this.bta.Ue();
            } else {
                this.bta.Uf();
            }
        } else {
            this.bta.Ud();
        }
        frameLayout = this.bta.bsB;
        frameLayout.setVisibility(0);
        listView = this.bta.bsC;
        listView.setVisibility(0);
        xVar = this.bta.mNoDataView;
        xVar.setVisibility(8);
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
            button2 = this.bta.bsw;
            button2.setVisibility(8);
        } else {
            button = this.bta.bsw;
            button.setVisibility(0);
        }
        textView = this.bta.bsx;
        bc.b(textView, com.baidu.tieba.t.cp_cont_i, 1);
    }
}
