package com.baidu.tieba.person;

import android.view.View;
import android.widget.Button;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    final /* synthetic */ EditMarkActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(EditMarkActivity editMarkActivity) {
        this.a = editMarkActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.home.y yVar;
        com.baidu.tieba.home.y yVar2;
        com.baidu.tieba.b.h hVar;
        com.baidu.tieba.home.y yVar3;
        com.baidu.tieba.home.y yVar4;
        com.baidu.tieba.home.y yVar5;
        Button button;
        Button button2;
        com.baidu.tieba.home.y yVar6;
        int intValue = ((Integer) view.getTag()).intValue();
        yVar = this.a.b;
        if (yVar.b() != null) {
            yVar2 = this.a.b;
            if (!com.baidu.tieba.c.k.l(((com.baidu.tieba.a.ae) yVar2.b().get(intValue)).d())) {
                this.a.b(this.a.getString(R.string.fail));
                return;
            }
            hVar = this.a.c;
            ArrayList a = hVar.a();
            if (a != null) {
                a.remove(intValue);
                yVar3 = this.a.b;
                yVar3.a(a);
                yVar4 = this.a.b;
                yVar4.a();
                if (a.size() == 0) {
                    button = this.a.f;
                    button.setText(R.string.edit);
                    button2 = this.a.f;
                    button2.setVisibility(4);
                    yVar6 = this.a.b;
                    yVar6.b(false);
                }
                yVar5 = this.a.b;
                yVar5.notifyDataSetChanged();
            }
            this.a.b(this.a.getString(R.string.success));
        }
    }
}
