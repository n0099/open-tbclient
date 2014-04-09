package com.baidu.tieba.mainentrance;

import android.text.Selection;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
/* loaded from: classes.dex */
final class o implements AdapterView.OnItemClickListener {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        a aVar;
        a aVar2;
        EditText editText;
        EditText editText2;
        EditText editText3;
        String str = (String) ((ListView) adapterView).getAdapter().getItem(i);
        i2 = this.a.z;
        if (i2 == 0) {
            com.baidu.tieba.util.k.f(str);
            this.a.sendMessage(new com.baidu.adp.framework.message.a(2003000, new com.baidu.tbadk.core.b.l(this.a).a(str, "tb_searchlist")));
        } else if (str != null && str.length() > 0) {
            aVar = this.a.l;
            aVar.a(i);
            aVar2 = this.a.l;
            aVar2.notifyDataSetChanged();
            this.a.a(1, str);
            editText = this.a.c;
            editText.setText(str);
            editText2 = this.a.c;
            editText2.requestFocus();
            editText3 = this.a.c;
            Selection.setSelection(editText3.getText(), str.length());
        }
    }
}
