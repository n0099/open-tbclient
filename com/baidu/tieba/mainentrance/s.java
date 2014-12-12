package com.baidu.tieba.mainentrance;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ax;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements TextWatcher {
    final /* synthetic */ SquareSearchActivity brF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(SquareSearchActivity squareSearchActivity) {
        this.brF = squareSearchActivity;
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
        this.brF.brr = charSequence.toString();
        str = this.brF.brr;
        if (str.trim().length() > 0) {
            i6 = this.brF.mMode;
            if (i6 != 0) {
                i7 = this.brF.mMode;
                if (i7 == 1) {
                    SquareSearchActivity squareSearchActivity = this.brF;
                    str2 = this.brF.brr;
                    squareSearchActivity.y(1, str2);
                    return;
                }
                return;
            }
            this.brF.TO();
            return;
        }
        this.brF.rp();
        i4 = this.brF.mMode;
        if (i4 != 0) {
            i5 = this.brF.mMode;
            if (i5 != 3) {
                this.brF.TM();
            } else {
                this.brF.TN();
            }
        } else {
            this.brF.TL();
        }
        frameLayout = this.brF.bre;
        frameLayout.setVisibility(0);
        listView = this.brF.brf;
        listView.setVisibility(0);
        xVar = this.brF.mNoDataView;
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
            button2 = this.brF.bqZ;
            button2.setVisibility(8);
        } else {
            button = this.brF.bqZ;
            button.setVisibility(0);
        }
        textView = this.brF.bra;
        ax.b(textView, com.baidu.tieba.t.cp_cont_i, 1);
    }
}
