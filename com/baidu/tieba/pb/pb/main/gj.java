package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.pb.pb.main.emotion.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gj implements a.b {
    final /* synthetic */ gg eEv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gj(gg ggVar) {
        this.eEv = ggVar;
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.view.a.b
    public void ag(float f) {
        View view;
        View view2;
        int i;
        int i2;
        int i3;
        ViewGroup viewGroup;
        View view3;
        view = this.eEv.eDn;
        if (view != null) {
            view2 = this.eEv.eDn;
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            i = this.eEv.eDv;
            i2 = this.eEv.eDu;
            i3 = this.eEv.eDu;
            layoutParams.height = (int) (((i - i2) * f) + i3);
            viewGroup = this.eEv.eDp;
            viewGroup.setAlpha(1.0f - f);
            view3 = this.eEv.eDn;
            view3.setLayoutParams(layoutParams);
            this.eEv.eDw = layoutParams.height;
        }
    }
}
