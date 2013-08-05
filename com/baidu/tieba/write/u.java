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

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f1916a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(WriteActivity writeActivity) {
        this.f1916a = writeActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        EditText editText;
        EditText editText2;
        m mVar;
        EditText editText3;
        m mVar2;
        EditText editText4;
        editText = this.f1916a.f;
        Editable text = editText.getText();
        editText2 = this.f1916a.f;
        if (((ImageSpan[]) text.getSpans(0, editText2.getText().length(), ImageSpan.class)).length < 10) {
            mVar = this.f1916a.t;
            String a2 = mVar.a(i);
            if (a2 != null) {
                editText3 = this.f1916a.f;
                int selectionStart = editText3.getSelectionStart();
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a2);
                mVar2 = this.f1916a.t;
                Bitmap bitmap = (Bitmap) mVar2.getItem(i);
                if (bitmap != null) {
                    com.baidu.tieba.view.ax axVar = new com.baidu.tieba.view.ax(bitmap);
                    axVar.setBounds(0, 0, bitmap.getWidth() + 1, bitmap.getHeight());
                    axVar.setGravity(3);
                    spannableStringBuilder.setSpan(new ImageSpan(axVar, 0), 0, spannableStringBuilder.length(), 33);
                    editText4 = this.f1916a.f;
                    editText4.getText().insert(selectionStart, spannableStringBuilder);
                    return;
                }
                return;
            }
            return;
        }
        this.f1916a.a(this.f1916a.getString(R.string.too_many_face));
    }
}
