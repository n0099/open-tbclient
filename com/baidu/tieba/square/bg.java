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
public class bg implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareSearchActivity f2401a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(SquareSearchActivity squareSearchActivity) {
        this.f2401a = squareSearchActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        com.baidu.tieba.home.ba baVar;
        com.baidu.tieba.home.ba baVar2;
        EditText editText;
        EditText editText2;
        EditText editText3;
        com.baidu.tieba.home.ba baVar3;
        com.baidu.tieba.home.ba baVar4;
        String str = (String) ((ListView) adapterView).getAdapter().getItem(i);
        i2 = this.f2401a.C;
        if (i2 == 0) {
            DatabaseService.m(str);
            FrsActivity.a(this.f2401a, str, "tb_searchlist");
            baVar3 = this.f2401a.o;
            baVar3.a(i);
            baVar4 = this.f2401a.o;
            baVar4.notifyDataSetChanged();
            this.f2401a.finish();
        } else if (str != null && str.length() > 0) {
            baVar = this.f2401a.o;
            baVar.a(i);
            baVar2 = this.f2401a.o;
            baVar2.notifyDataSetChanged();
            this.f2401a.a(1, str);
            editText = this.f2401a.c;
            editText.setText(str);
            editText2 = this.f2401a.c;
            editText2.requestFocus();
            editText3 = this.f2401a.c;
            Selection.setSelection(editText3.getText(), str.length());
        }
    }
}
