package com.baidu.tieba.pb;

import android.app.AlertDialog;
import android.content.Context;
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
public class bf implements View.OnClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        com.baidu.tieba.b.n nVar;
        b bVar;
        AlertDialog alertDialog2;
        AlertDialog alertDialog3;
        View view2;
        LinearLayout linearLayout;
        AlertDialog alertDialog4;
        AlertDialog alertDialog5;
        b bVar2;
        com.baidu.tieba.b.n nVar2;
        b bVar3;
        AlertDialog alertDialog6;
        View view3;
        com.baidu.tieba.b.n nVar3;
        b bVar4;
        alertDialog = this.a.v;
        if (alertDialog == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
            this.a.v = builder.create();
            alertDialog6 = this.a.v;
            alertDialog6.setCanceledOnTouchOutside(true);
            LayoutInflater layoutInflater = this.a.getLayoutInflater();
            this.a.y = layoutInflater.inflate(R.layout.dialog_more, (ViewGroup) null);
            view3 = this.a.y;
            ListView listView = (ListView) view3.findViewById(R.id.list);
            PbActivity pbActivity = this.a;
            PbActivity pbActivity2 = this.a;
            nVar3 = this.a.n;
            pbActivity.ab = new b(pbActivity2, nVar3);
            bVar4 = this.a.ab;
            listView.setAdapter((ListAdapter) bVar4);
            listView.setOnItemClickListener(new bg(this));
        }
        nVar = this.a.n;
        if (nVar.a() != null) {
            bVar = this.a.ab;
            if (bVar != null) {
                bVar2 = this.a.ab;
                nVar2 = this.a.n;
                bVar2.a(nVar2.e());
                bVar3 = this.a.ab;
                bVar3.notifyDataSetInvalidated();
            }
            alertDialog2 = this.a.v;
            alertDialog2.show();
            alertDialog3 = this.a.v;
            view2 = this.a.y;
            alertDialog3.setContentView(view2);
            linearLayout = this.a.A;
            int height = linearLayout.getHeight();
            alertDialog4 = this.a.v;
            WindowManager.LayoutParams attributes = alertDialog4.getWindow().getAttributes();
            attributes.gravity = 85;
            attributes.x = 2;
            attributes.y = height;
            attributes.alpha = 1.0f;
            attributes.width = com.baidu.tieba.c.ag.a((Context) this.a, 120.0f);
            attributes.height = -2;
            alertDialog5 = this.a.v;
            alertDialog5.getWindow().setAttributes(attributes);
        }
    }
}
