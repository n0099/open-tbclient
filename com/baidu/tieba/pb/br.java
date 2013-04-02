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
public class br implements View.OnClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        com.baidu.tieba.b.r rVar;
        b bVar;
        AlertDialog alertDialog2;
        AlertDialog alertDialog3;
        View view2;
        LinearLayout linearLayout;
        AlertDialog alertDialog4;
        AlertDialog alertDialog5;
        b bVar2;
        com.baidu.tieba.b.r rVar2;
        b bVar3;
        AlertDialog alertDialog6;
        View view3;
        com.baidu.tieba.b.r rVar3;
        boolean z;
        b bVar4;
        alertDialog = this.a.x;
        if (alertDialog == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
            this.a.x = builder.create();
            alertDialog6 = this.a.x;
            alertDialog6.setCanceledOnTouchOutside(true);
            LayoutInflater layoutInflater = this.a.getLayoutInflater();
            this.a.A = layoutInflater.inflate(R.layout.dialog_more, (ViewGroup) null);
            view3 = this.a.A;
            ListView listView = (ListView) view3.findViewById(R.id.list);
            PbActivity pbActivity = this.a;
            PbActivity pbActivity2 = this.a;
            rVar3 = this.a.o;
            z = this.a.ap;
            pbActivity.ag = new b(pbActivity2, rVar3, z);
            bVar4 = this.a.ag;
            listView.setAdapter((ListAdapter) bVar4);
            listView.setOnItemClickListener(new bs(this));
        }
        rVar = this.a.o;
        if (rVar.a() != null) {
            bVar = this.a.ag;
            if (bVar != null) {
                bVar2 = this.a.ag;
                rVar2 = this.a.o;
                bVar2.a(rVar2.e());
                bVar3 = this.a.ag;
                bVar3.notifyDataSetInvalidated();
            }
            alertDialog2 = this.a.x;
            alertDialog2.show();
            alertDialog3 = this.a.x;
            view2 = this.a.A;
            alertDialog3.setContentView(view2);
            linearLayout = this.a.D;
            int height = linearLayout.getHeight();
            alertDialog4 = this.a.x;
            WindowManager.LayoutParams attributes = alertDialog4.getWindow().getAttributes();
            attributes.gravity = 85;
            attributes.x = 2;
            attributes.y = height;
            attributes.alpha = 1.0f;
            attributes.width = com.baidu.tieba.c.ai.a(this.a, 120.0f);
            attributes.height = -2;
            alertDialog5 = this.a.x;
            alertDialog5.getWindow().setAttributes(attributes);
        }
    }
}
