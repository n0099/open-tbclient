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
public class be implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareSearchActivity f2501a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(SquareSearchActivity squareSearchActivity) {
        this.f2501a = squareSearchActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        com.baidu.tieba.home.av avVar;
        com.baidu.tieba.home.av avVar2;
        EditText editText;
        EditText editText2;
        EditText editText3;
        com.baidu.tieba.home.av avVar3;
        com.baidu.tieba.home.av avVar4;
        String str = (String) ((ListView) adapterView).getAdapter().getItem(i);
        i2 = this.f2501a.C;
        if (i2 == 0) {
            DatabaseService.k(str);
            FrsActivity.a(this.f2501a, str, "tb_searchlist");
            avVar3 = this.f2501a.o;
            avVar3.a(i);
            avVar4 = this.f2501a.o;
            avVar4.notifyDataSetChanged();
            this.f2501a.finish();
        } else if (str != null && str.length() > 0) {
            avVar = this.f2501a.o;
            avVar.a(i);
            avVar2 = this.f2501a.o;
            avVar2.notifyDataSetChanged();
            this.f2501a.a(1, str);
            editText = this.f2501a.c;
            editText.setText(str);
            editText2 = this.f2501a.c;
            editText2.requestFocus();
            editText3 = this.f2501a.c;
            Selection.setSelection(editText3.getText(), str.length());
        }
    }
}
