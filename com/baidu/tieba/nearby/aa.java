package com.baidu.tieba.nearby;

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
public class aa implements AdapterView.OnItemClickListener {
    final /* synthetic */ NearbyPbActivity a;
    private final /* synthetic */ com.baidu.tieba.write.m b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(NearbyPbActivity nearbyPbActivity, com.baidu.tieba.write.m mVar) {
        this.a = nearbyPbActivity;
        this.b = mVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        EditText editText;
        EditText editText2;
        boolean s;
        String a;
        EditText editText3;
        EditText editText4;
        editText = this.a.i;
        Editable text = editText.getText();
        editText2 = this.a.i;
        if (((ImageSpan[]) text.getSpans(0, editText2.getText().length(), ImageSpan.class)).length >= 10) {
            this.a.b(this.a.getString(R.string.too_many_face));
            return;
        }
        s = this.a.s();
        if (!s && (a = this.b.a(i)) != null) {
            editText3 = this.a.i;
            int selectionStart = editText3.getSelectionStart();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a);
            Bitmap bitmap = (Bitmap) this.b.getItem(i);
            if (bitmap != null) {
                com.baidu.tieba.view.af afVar = new com.baidu.tieba.view.af(bitmap);
                afVar.setBounds(0, 0, bitmap.getWidth() + 1, bitmap.getHeight());
                afVar.setGravity(3);
                spannableStringBuilder.setSpan(new ImageSpan(afVar, 0), 0, spannableStringBuilder.length(), 33);
                editText4 = this.a.i;
                editText4.getText().insert(selectionStart, spannableStringBuilder);
            }
        }
    }
}
