package com.baidu.tieba.pb;

import android.graphics.Bitmap;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements AdapterView.OnItemClickListener {
    final /* synthetic */ ImagePbActivity a;
    private final /* synthetic */ com.baidu.tieba.write.m b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ImagePbActivity imagePbActivity, com.baidu.tieba.write.m mVar) {
        this.a = imagePbActivity;
        this.b = mVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        EditText editText;
        EditText editText2;
        boolean o;
        String a;
        EditText editText3;
        EditText editText4;
        editText = this.a.m;
        Editable text = editText.getText();
        editText2 = this.a.m;
        if (((ImageSpan[]) text.getSpans(0, editText2.getText().length(), ImageSpan.class)).length >= 10) {
            this.a.b(this.a.getString(R.string.too_many_face));
            return;
        }
        o = this.a.o();
        if (!o && (a = this.b.a(i)) != null) {
            editText3 = this.a.m;
            int selectionStart = editText3.getSelectionStart();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a);
            Bitmap bitmap = (Bitmap) this.b.getItem(i);
            if (bitmap != null) {
                com.baidu.tieba.view.ag agVar = new com.baidu.tieba.view.ag(bitmap);
                agVar.setBounds(0, 0, bitmap.getWidth() + 1, bitmap.getHeight());
                agVar.setGravity(3);
                spannableStringBuilder.setSpan(new ImageSpan(agVar, 0), 0, spannableStringBuilder.length(), 33);
                editText4 = this.a.m;
                editText4.getText().insert(selectionStart, spannableStringBuilder);
            }
        }
    }
}
