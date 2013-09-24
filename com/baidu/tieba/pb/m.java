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
public class m implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f1623a;
    private final /* synthetic */ com.baidu.tieba.write.o b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ImagePbActivity imagePbActivity, com.baidu.tieba.write.o oVar) {
        this.f1623a = imagePbActivity;
        this.b = oVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        EditText editText;
        EditText editText2;
        boolean o;
        String a2;
        EditText editText3;
        EditText editText4;
        editText = this.f1623a.m;
        Editable text = editText.getText();
        editText2 = this.f1623a.m;
        if (((ImageSpan[]) text.getSpans(0, editText2.getText().length(), ImageSpan.class)).length >= 10) {
            this.f1623a.a(this.f1623a.getString(R.string.too_many_face));
            return;
        }
        o = this.f1623a.o();
        if (!o && (a2 = this.b.a(i)) != null) {
            editText3 = this.f1623a.m;
            int selectionStart = editText3.getSelectionStart();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a2);
            Bitmap bitmap = (Bitmap) this.b.getItem(i);
            if (bitmap != null) {
                com.baidu.tieba.view.au auVar = new com.baidu.tieba.view.au(bitmap);
                auVar.setBounds(0, 0, bitmap.getWidth() + 1, bitmap.getHeight());
                auVar.setGravity(3);
                spannableStringBuilder.setSpan(new ImageSpan(auVar, 0), 0, spannableStringBuilder.length(), 33);
                editText4 = this.f1623a.m;
                editText4.getText().insert(selectionStart, spannableStringBuilder);
            }
        }
    }
}
