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
    final /* synthetic */ SquareSearchActivity bmO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(SquareSearchActivity squareSearchActivity) {
        this.bmO = squareSearchActivity;
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
        this.bmO.bmA = charSequence.toString();
        str = this.bmO.bmA;
        if (str.trim().length() > 0) {
            i6 = this.bmO.mMode;
            if (i6 != 0) {
                i7 = this.bmO.mMode;
                if (i7 == 1) {
                    SquareSearchActivity squareSearchActivity = this.bmO;
                    str2 = this.bmO.bmA;
                    squareSearchActivity.o(1, str2);
                    return;
                }
                return;
            }
            this.bmO.SG();
            return;
        }
        this.bmO.oo();
        i4 = this.bmO.mMode;
        if (i4 != 0) {
            i5 = this.bmO.mMode;
            if (i5 != 3) {
                this.bmO.SE();
            } else {
                this.bmO.SF();
            }
        } else {
            this.bmO.SD();
        }
        frameLayout = this.bmO.bmn;
        frameLayout.setVisibility(0);
        listView = this.bmO.bmo;
        listView.setVisibility(0);
        oVar = this.bmO.ahO;
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
            button2 = this.bmO.bmi;
            button2.setVisibility(8);
        } else {
            button = this.bmO.bmi;
            button.setVisibility(0);
        }
        textView = this.bmO.bmj;
        aw.b(textView, com.baidu.tieba.s.common_page_title, 1);
    }
}
