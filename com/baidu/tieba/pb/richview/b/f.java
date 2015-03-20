package com.baidu.tieba.pb.richview.b;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.s;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.adp.lib.e.c<TextView> {
    final /* synthetic */ e bOs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.bOs = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: d */
    public TextView l(TextView textView) {
        return textView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: c */
    public void k(TextView textView) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: DP */
    public TextView hA() {
        Context context;
        Context context2;
        float f;
        context = this.bOs.context;
        TextView textView = new TextView(context);
        context2 = this.bOs.context;
        textView.setTextSize(0, context2.getResources().getDimensionPixelSize(t.fontsize32));
        f = this.bOs.asH;
        textView.setLineSpacing(0.0f, f);
        ba.b(textView, s.cp_cont_b, 1);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return textView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: e */
    public TextView m(TextView textView) {
        return textView;
    }
}
