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
    final /* synthetic */ SquareSearchActivity btb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(SquareSearchActivity squareSearchActivity) {
        this.btb = squareSearchActivity;
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
        this.btb.bsO = charSequence.toString();
        str = this.btb.bsO;
        if (str.trim().length() > 0) {
            i6 = this.btb.mMode;
            if (i6 != 0) {
                i7 = this.btb.mMode;
                if (i7 == 1) {
                    SquareSearchActivity squareSearchActivity = this.btb;
                    str2 = this.btb.bsO;
                    squareSearchActivity.y(1, str2);
                    return;
                }
                return;
            }
            this.btb.Ul();
            return;
        }
        this.btb.rA();
        i4 = this.btb.mMode;
        if (i4 != 0) {
            i5 = this.btb.mMode;
            if (i5 != 3) {
                this.btb.Uj();
            } else {
                this.btb.Uk();
            }
        } else {
            this.btb.Ui();
        }
        frameLayout = this.btb.bsC;
        frameLayout.setVisibility(0);
        listView = this.btb.bsD;
        listView.setVisibility(0);
        xVar = this.btb.mNoDataView;
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
            button2 = this.btb.bsx;
            button2.setVisibility(8);
        } else {
            button = this.btb.bsx;
            button.setVisibility(0);
        }
        textView = this.btb.bsy;
        bc.b(textView, com.baidu.tieba.t.cp_cont_i, 1);
    }
}
