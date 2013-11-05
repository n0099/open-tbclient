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
public class ah implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareSearchActivity f2340a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(SquareSearchActivity squareSearchActivity) {
        this.f2340a = squareSearchActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        com.baidu.tieba.home.ar arVar;
        com.baidu.tieba.home.ar arVar2;
        EditText editText;
        EditText editText2;
        EditText editText3;
        com.baidu.tieba.home.ar arVar3;
        com.baidu.tieba.home.ar arVar4;
        String str = (String) ((ListView) adapterView).getAdapter().getItem(i);
        i2 = this.f2340a.F;
        if (i2 == 0) {
            DatabaseService.l(str);
            FrsActivity.a(this.f2340a, str, "tb_searchlist");
            arVar3 = this.f2340a.r;
            arVar3.a(i);
            arVar4 = this.f2340a.r;
            arVar4.notifyDataSetChanged();
            this.f2340a.finish();
        } else if (str != null && str.length() > 0) {
            arVar = this.f2340a.r;
            arVar.a(i);
            arVar2 = this.f2340a.r;
            arVar2.notifyDataSetChanged();
            this.f2340a.a(1, str);
            editText = this.f2340a.c;
            editText.setText(str);
            editText2 = this.f2340a.c;
            editText2.requestFocus();
            editText3 = this.f2340a.c;
            Selection.setSelection(editText3.getText(), str.length());
        }
    }
}
