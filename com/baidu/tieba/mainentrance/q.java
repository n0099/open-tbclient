package com.baidu.tieba.mainentrance;

import android.text.Selection;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
final class q implements AdapterView.OnItemClickListener {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        f fVar;
        f fVar2;
        EditText editText;
        EditText editText2;
        EditText editText3;
        f fVar3;
        f fVar4;
        String str = (String) ((ListView) adapterView).getAdapter().getItem(i);
        i2 = this.a.D;
        if (i2 == 0) {
            DatabaseService.h(str);
            FrsActivity.a(this.a, str, "tb_searchlist");
            fVar3 = this.a.p;
            fVar3.a(i);
            fVar4 = this.a.p;
            fVar4.notifyDataSetChanged();
            this.a.finish();
        } else if (str != null && str.length() > 0) {
            fVar = this.a.p;
            fVar.a(i);
            fVar2 = this.a.p;
            fVar2.notifyDataSetChanged();
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
