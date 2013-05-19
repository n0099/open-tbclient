package com.baidu.tieba.write;

import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        GridView gridView;
        InputMethodManager inputMethodManager;
        EditText editText;
        InputMethodManager inputMethodManager2;
        EditText editText2;
        Handler handler;
        Runnable runnable;
        ImageView imageView;
        EditText editText3;
        GridView gridView2;
        InputMethodManager inputMethodManager3;
        EditText editText4;
        ImageView imageView2;
        gridView = this.a.r;
        if (gridView.getVisibility() == 0) {
            editText3 = this.a.h;
            editText3.requestFocus();
            gridView2 = this.a.r;
            gridView2.setVisibility(8);
            WriteActivity writeActivity = this.a;
            inputMethodManager3 = this.a.f;
            editText4 = this.a.h;
            writeActivity.b(inputMethodManager3, editText4);
            imageView2 = this.a.k;
            imageView2.setImageDrawable(this.a.getResources().getDrawable(R.drawable.write_face));
            return;
        }
        WriteActivity writeActivity2 = this.a;
        inputMethodManager = this.a.f;
        editText = this.a.g;
        writeActivity2.a(inputMethodManager, editText);
        WriteActivity writeActivity3 = this.a;
        inputMethodManager2 = this.a.f;
        editText2 = this.a.h;
        writeActivity3.a(inputMethodManager2, editText2);
        handler = this.a.z;
        runnable = this.a.M;
        handler.postDelayed(runnable, 200L);
        imageView = this.a.k;
        imageView.setImageDrawable(this.a.getResources().getDrawable(R.drawable.write_keyboard));
    }
}
