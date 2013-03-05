package com.baidu.tieba.person;

import android.view.View;
import android.widget.Button;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ EditMarkActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(EditMarkActivity editMarkActivity) {
        this.a = editMarkActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.home.af afVar;
        com.baidu.tieba.home.af afVar2;
        com.baidu.tieba.b.i iVar;
        com.baidu.tieba.home.af afVar3;
        com.baidu.tieba.home.af afVar4;
        com.baidu.tieba.home.af afVar5;
        Button button;
        Button button2;
        com.baidu.tieba.home.af afVar6;
        int intValue = ((Integer) view.getTag()).intValue();
        afVar = this.a.c;
        if (afVar.b() != null) {
            afVar2 = this.a.c;
            if (com.baidu.tieba.c.k.m(((com.baidu.tieba.a.ac) afVar2.b().get(intValue)).d())) {
                iVar = this.a.d;
                ArrayList a = iVar.a();
                if (a != null) {
                    a.remove(intValue);
                    afVar3 = this.a.c;
                    afVar3.a(a);
                    afVar4 = this.a.c;
                    afVar4.a();
                    if (a.size() == 0) {
                        button = this.a.g;
                        button.setText(R.string.edit);
                        button2 = this.a.g;
                        button2.setVisibility(4);
                        afVar6 = this.a.c;
                        afVar6.b(false);
                    }
                    afVar5 = this.a.c;
                    afVar5.notifyDataSetChanged();
                }
                this.a.b(this.a.getString(R.string.success));
                return;
            }
            this.a.b(this.a.getString(R.string.fail));
        }
    }
}
