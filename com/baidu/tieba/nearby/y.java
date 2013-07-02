package com.baidu.tieba.nearby;

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
public class y implements AdapterView.OnItemClickListener {
    final /* synthetic */ NearbyPbActivity a;
    private final /* synthetic */ com.baidu.tieba.write.m b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(NearbyPbActivity nearbyPbActivity, com.baidu.tieba.write.m mVar) {
        this.a = nearbyPbActivity;
        this.b = mVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        EditText editText;
        EditText editText2;
        boolean t;
        String a;
        EditText editText3;
        EditText editText4;
        editText = this.a.f;
        Editable text = editText.getText();
        editText2 = this.a.f;
        if (((ImageSpan[]) text.getSpans(0, editText2.getText().length(), ImageSpan.class)).length >= 10) {
            this.a.a(this.a.getString(R.string.too_many_face));
            return;
        }
        t = this.a.t();
        if (!t && (a = this.b.a(i)) != null) {
            editText3 = this.a.f;
            int selectionStart = editText3.getSelectionStart();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a);
            Bitmap bitmap = (Bitmap) this.b.getItem(i);
            if (bitmap != null) {
                com.baidu.tieba.view.al alVar = new com.baidu.tieba.view.al(bitmap);
                alVar.setBounds(0, 0, bitmap.getWidth() + 1, bitmap.getHeight());
                alVar.setGravity(3);
                spannableStringBuilder.setSpan(new ImageSpan(alVar, 0), 0, spannableStringBuilder.length(), 33);
                editText4 = this.a.f;
                editText4.getText().insert(selectionStart, spannableStringBuilder);
            }
        }
    }
}
