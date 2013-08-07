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

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f1870a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(WriteActivity writeActivity) {
        this.f1870a = writeActivity;
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
        gridView = this.f1870a.r;
        if (gridView.getVisibility() == 0) {
            editText3 = this.f1870a.f;
            editText3.requestFocus();
            gridView2 = this.f1870a.r;
            gridView2.setVisibility(8);
            WriteActivity writeActivity = this.f1870a;
            inputMethodManager3 = this.f1870a.d;
            editText4 = this.f1870a.f;
            writeActivity.b(inputMethodManager3, editText4);
            imageView2 = this.f1870a.k;
            imageView2.setImageDrawable(this.f1870a.getResources().getDrawable(R.drawable.write_face));
            return;
        }
        WriteActivity writeActivity2 = this.f1870a;
        inputMethodManager = this.f1870a.d;
        editText = this.f1870a.e;
        writeActivity2.a(inputMethodManager, editText);
        WriteActivity writeActivity3 = this.f1870a;
        inputMethodManager2 = this.f1870a.d;
        editText2 = this.f1870a.f;
        writeActivity3.a(inputMethodManager2, editText2);
        handler = this.f1870a.z;
        runnable = this.f1870a.M;
        handler.postDelayed(runnable, 200L);
        imageView = this.f1870a.k;
        imageView.setImageDrawable(this.f1870a.getResources().getDrawable(R.drawable.write_keyboard));
    }
}
