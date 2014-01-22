package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.faceshop.FacePackageDetailActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {
    final /* synthetic */ ab a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.a = abVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        com.baidu.tieba.data.y yVar;
        com.baidu.tieba.data.y yVar2;
        Context context;
        com.baidu.tieba.data.y yVar3;
        ae aeVar;
        ae aeVar2;
        textView = this.a.c;
        if (view == textView) {
            this.a.g = true;
            this.a.setVisibility(8);
            TiebaApplication.h().e(System.currentTimeMillis());
            aeVar = this.a.h;
            if (aeVar != null) {
                aeVar2 = this.a.h;
                aeVar2.a(true);
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
