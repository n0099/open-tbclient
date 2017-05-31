package com.baidu.tieba.pb.pb.main.emotion.view;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.pb.main.emotion.data.EmotionImageData;
import com.baidu.tieba.pb.pb.main.emotion.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    private final /* synthetic */ EmotionImageData evF;
    final /* synthetic */ a ewn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, EmotionImageData emotionImageData) {
        this.ewn = aVar;
        this.evF = emotionImageData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0072a interfaceC0072a;
        a.InterfaceC0072a interfaceC0072a2;
        if (((FrameLayout.LayoutParams) this.ewn.getLayoutParams()).leftMargin <= 0) {
            interfaceC0072a = this.ewn.ewl;
            if (interfaceC0072a != null) {
                interfaceC0072a2 = this.ewn.ewl;
                interfaceC0072a2.c(this.evF);
            }
            TiebaStatic.log("c12176");
        }
    }
}
