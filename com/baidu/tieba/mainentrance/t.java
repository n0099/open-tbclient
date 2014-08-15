package com.baidu.tieba.mainentrance;

import android.text.Selection;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import com.baidu.adp.framework.message.CustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements AdapterView.OnItemClickListener {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        int i3;
        a aVar;
        a aVar2;
        EditText editText;
        EditText editText2;
        EditText editText3;
        String str = (String) ((ListView) adapterView).getAdapter().getItem(i);
        i2 = this.a.z;
        if (i2 != 0) {
            i3 = this.a.z;
            if (i3 == 3) {
                this.a.a(str);
                return;
            } else if (str != null && str.length() > 0) {
                aVar = this.a.k;
                aVar.a(i);
                aVar2 = this.a.k;
                aVar2.notifyDataSetChanged();
                this.a.a(1, str);
                editText = this.a.c;
                editText.setText(str);
                editText2 = this.a.c;
                editText2.requestFocus();
                editText3 = this.a.c;
                Selection.setSelection(editText3.getText(), str.length());
                return;
            } else {
                return;
            }
        }
        com.baidu.tieba.util.k.e(str);
        this.a.sendMessage(new CustomMessage(2003000, new com.baidu.tbadk.core.atomData.s(this.a).a(str, "tb_searchlist")));
    }
}
