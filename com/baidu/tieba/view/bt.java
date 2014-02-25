package com.baidu.tieba.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements aa {
    final /* synthetic */ MultiImageView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(MultiImageView multiImageView) {
        this.a = multiImageView;
    }

    @Override // com.baidu.tieba.view.aa
    public void a(w wVar) {
        av avVar;
        boolean z;
        av avVar2;
        av avVar3;
        avVar = this.a.e;
        if (wVar == avVar.getCurrentView()) {
            z = this.a.l;
            if (z) {
                avVar2 = this.a.e;
                int childCount = avVar2.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    avVar3 = this.a.e;
                    View childAt = avVar3.getChildAt(i);
                    if (childAt != null && (childAt instanceof cx) && ((cx) childAt).getImageView() != wVar) {
                        ((cx) childAt).d();
                    }
                }
            }
            wVar.e();
        }
    }
}
