package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.pb.pb.main.emotion.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ga implements a.b {
    final /* synthetic */ fx evi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ga(fx fxVar) {
        this.evi = fxVar;
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.view.a.b
    public void aa(float f) {
        View view;
        View view2;
        int i;
        int i2;
        int i3;
        ViewGroup viewGroup;
        View view3;
        view = this.evi.euc;
        if (view != null) {
            view2 = this.evi.euc;
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            i = this.evi.euk;
            i2 = this.evi.euj;
            i3 = this.evi.euj;
            layoutParams.height = (int) (((i - i2) * f) + i3);
            viewGroup = this.evi.eue;
            viewGroup.setAlpha(1.0f - f);
            view3 = this.evi.euc;
            view3.setLayoutParams(layoutParams);
            this.evi.eul = layoutParams.height;
        }
    }
}
