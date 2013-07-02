package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements AdapterView.OnItemClickListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        EditText editText;
        EditText editText2;
        m mVar;
        EditText editText3;
        m mVar2;
        EditText editText4;
        editText = this.a.f;
        Editable text = editText.getText();
        editText2 = this.a.f;
        if (((ImageSpan[]) text.getSpans(0, editText2.getText().length(), ImageSpan.class)).length < 10) {
            mVar = this.a.t;
            String a = mVar.a(i);
            if (a != null) {
                editText3 = this.a.f;
                int selectionStart = editText3.getSelectionStart();
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a);
                mVar2 = this.a.t;
                Bitmap bitmap = (Bitmap) mVar2.getItem(i);
                if (bitmap != null) {
                    com.baidu.tieba.view.al alVar = new com.baidu.tieba.view.al(bitmap);
                    alVar.setBounds(0, 0, bitmap.getWidth() + 1, bitmap.getHeight());
                    alVar.setGravity(3);
                    spannableStringBuilder.setSpan(new ImageSpan(alVar, 0), 0, spannableStringBuilder.length(), 33);
                    editText4 = this.a.f;
                    editText4.getText().insert(selectionStart, spannableStringBuilder);
                    return;
                }
                return;
            }
            return;
        }
        this.a.a(this.a.getString(R.string.too_many_face));
    }
}
