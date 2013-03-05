package com.baidu.tieba.pb;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements View.OnClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        com.baidu.tieba.b.q qVar;
        b bVar;
        AlertDialog alertDialog2;
        AlertDialog alertDialog3;
        View view2;
        LinearLayout linearLayout;
        AlertDialog alertDialog4;
        AlertDialog alertDialog5;
        b bVar2;
        com.baidu.tieba.b.q qVar2;
        b bVar3;
        AlertDialog alertDialog6;
        View view3;
        com.baidu.tieba.b.q qVar3;
        boolean z;
        b bVar4;
        alertDialog = this.a.y;
        if (alertDialog == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
            this.a.y = builder.create();
            alertDialog6 = this.a.y;
            alertDialog6.setCanceledOnTouchOutside(true);
            LayoutInflater layoutInflater = this.a.getLayoutInflater();
            this.a.B = layoutInflater.inflate(R.layout.dialog_more, (ViewGroup) null);
            view3 = this.a.B;
            ListView listView = (ListView) view3.findViewById(R.id.list);
            PbActivity pbActivity = this.a;
            PbActivity pbActivity2 = this.a;
            qVar3 = this.a.p;
            z = this.a.ao;
            pbActivity.ae = new b(pbActivity2, qVar3, z);
            bVar4 = this.a.ae;
            listView.setAdapter((ListAdapter) bVar4);
            listView.setOnItemClickListener(new br(this));
        }
        qVar = this.a.p;
        if (qVar.a() != null) {
            bVar = this.a.ae;
            if (bVar != null) {
                bVar2 = this.a.ae;
                qVar2 = this.a.p;
                bVar2.a(qVar2.e());
                bVar3 = this.a.ae;
                bVar3.notifyDataSetInvalidated();
            }
            alertDialog2 = this.a.y;
            alertDialog2.show();
            alertDialog3 = this.a.y;
            view2 = this.a.B;
            alertDialog3.setContentView(view2);
            linearLayout = this.a.E;
            int height = linearLayout.getHeight();
            alertDialog4 = this.a.y;
            WindowManager.LayoutParams attributes = alertDialog4.getWindow().getAttributes();
            attributes.gravity = 85;
            attributes.x = 2;
            attributes.y = height;
            attributes.alpha = 1.0f;
            attributes.width = com.baidu.tieba.c.ai.a(this.a, 120.0f);
            attributes.height = -2;
            alertDialog5 = this.a.y;
            alertDialog5.getWindow().setAttributes(attributes);
        }
    }
}
