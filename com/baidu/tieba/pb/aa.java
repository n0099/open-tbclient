package com.baidu.tieba.pb;

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
public class aa implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.tieba.write.p f2038a;
    final /* synthetic */ ImagePbActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(ImagePbActivity imagePbActivity, com.baidu.tieba.write.p pVar) {
        this.b = imagePbActivity;
        this.f2038a = pVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        EditText editText;
        EditText editText2;
        boolean o;
        String a2;
        EditText editText3;
        EditText editText4;
        editText = this.b.m;
        Editable text = editText.getText();
        editText2 = this.b.m;
        if (((ImageSpan[]) text.getSpans(0, editText2.getText().length(), ImageSpan.class)).length < 10) {
            o = this.b.o();
            if (!o && (a2 = this.f2038a.a(i)) != null) {
                editText3 = this.b.m;
                int selectionStart = editText3.getSelectionStart();
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a2);
                Bitmap bitmap = (Bitmap) this.f2038a.getItem(i);
                if (bitmap != null) {
                    com.baidu.tieba.view.au auVar = new com.baidu.tieba.view.au(bitmap);
                    auVar.setBounds(0, 0, bitmap.getWidth() + 1, bitmap.getHeight());
                    auVar.setGravity(3);
                    spannableStringBuilder.setSpan(new ImageSpan(auVar, 0), 0, spannableStringBuilder.length(), 33);
                    editText4 = this.b.m;
                    editText4.getText().insert(selectionStart, spannableStringBuilder);
                    return;
                }
                return;
            }
            return;
        }
        this.b.a(this.b.getString(R.string.too_many_face));
    }
}
