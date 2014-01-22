package com.baidu.tieba.square;

import android.text.Selection;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.util.DatabaseService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements AdapterView.OnItemClickListener {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        com.baidu.tieba.home.aw awVar;
        com.baidu.tieba.home.aw awVar2;
        EditText editText;
        EditText editText2;
        EditText editText3;
        com.baidu.tieba.home.aw awVar3;
        com.baidu.tieba.home.aw awVar4;
        String str = (String) ((ListView) adapterView).getAdapter().getItem(i);
        i2 = this.a.D;
        if (i2 == 0) {
            DatabaseService.m(str);
            FrsActivity.a(this.a, str, "tb_searchlist");
            awVar3 = this.a.p;
            awVar3.a(i);
            awVar4 = this.a.p;
            awVar4.notifyDataSetChanged();
            this.a.finish();
        } else if (str != null && str.length() > 0) {
            awVar = this.a.p;
            awVar.a(i);
            awVar2 = this.a.p;
            awVar2.notifyDataSetChanged();
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
