package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.faceshop.FacePackageDetailActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        com.baidu.tieba.data.y yVar;
        com.baidu.tieba.data.y yVar2;
        Context context;
        com.baidu.tieba.data.y yVar3;
        d dVar;
        d dVar2;
        textView = this.a.c;
        if (view == textView) {
            this.a.g = true;
            this.a.setVisibility(8);
            TiebaApplication.g().e(System.currentTimeMillis());
            dVar = this.a.h;
            if (dVar != null) {
                dVar2 = this.a.h;
                dVar2.a(true);
                return;
            }
            return;
        }
        yVar = this.a.f;
        if (yVar != null) {
            yVar2 = this.a.f;
            if (yVar2.a() == 1) {
                context = this.a.d;
                yVar3 = this.a.f;
                FacePackageDetailActivity.a(context, yVar3.c(), false, "banner");
            }
        }
    }
}
