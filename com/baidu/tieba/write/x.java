package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Toast;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2131a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(WriteActivity writeActivity) {
        this.f2131a = writeActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        EditText editText;
        EditText editText2;
        o oVar;
        EditText editText3;
        o oVar2;
        EditText editText4;
        Toast toast;
        Toast toast2;
        editText = this.f2131a.g;
        Editable text = editText.getText();
        editText2 = this.f2131a.g;
        if (((ImageSpan[]) text.getSpans(0, editText2.getText().length(), ImageSpan.class)).length < 10) {
            oVar = this.f2131a.w;
            String a2 = oVar.a(i);
            if (a2 != null) {
                editText3 = this.f2131a.g;
                int selectionStart = editText3.getSelectionStart();
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a2);
                oVar2 = this.f2131a.w;
                Bitmap bitmap = (Bitmap) oVar2.getItem(i);
                if (bitmap != null) {
                    com.baidu.tieba.view.au auVar = new com.baidu.tieba.view.au(bitmap);
                    auVar.setBounds(0, 0, bitmap.getWidth() + 1, bitmap.getHeight());
                    auVar.setGravity(3);
                    spannableStringBuilder.setSpan(new ImageSpan(auVar, 0), 0, spannableStringBuilder.length(), 33);
                    editText4 = this.f2131a.g;
                    editText4.getText().insert(selectionStart, spannableStringBuilder);
                    return;
                }
                return;
            }
            return;
        }
        toast = this.f2131a.M;
        if (toast == null) {
            this.f2131a.M = Toast.makeText(this.f2131a, (int) R.string.too_many_face, 0);
        }
        toast2 = this.f2131a.M;
        toast2.show();
    }
}
