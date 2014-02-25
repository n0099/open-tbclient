package com.baidu.tieba.mainentrance;

import android.text.Selection;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.util.DatabaseService;
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
        i iVar;
        i iVar2;
        EditText editText;
        EditText editText2;
        EditText editText3;
        i iVar3;
        i iVar4;
        String str = (String) ((ListView) adapterView).getAdapter().getItem(i);
        i2 = this.a.D;
        if (i2 == 0) {
            DatabaseService.j(str);
            FrsActivity.a(this.a, str, "tb_searchlist");
            iVar3 = this.a.p;
            iVar3.a(i);
            iVar4 = this.a.p;
            iVar4.notifyDataSetChanged();
            this.a.finish();
        } else if (str != null && str.length() > 0) {
            iVar = this.a.p;
            iVar.a(i);
            iVar2 = this.a.p;
            iVar2.notifyDataSetChanged();
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
