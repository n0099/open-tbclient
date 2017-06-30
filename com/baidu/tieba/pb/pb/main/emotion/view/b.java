package com.baidu.tieba.pb.pb.main.emotion.view;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.pb.main.emotion.data.EmotionImageData;
import com.baidu.tieba.pb.pb.main.emotion.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    private final /* synthetic */ EmotionImageData eEV;
    final /* synthetic */ a eFJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, EmotionImageData emotionImageData) {
        this.eFJ = aVar;
        this.eEV = emotionImageData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0075a interfaceC0075a;
        a.InterfaceC0075a interfaceC0075a2;
        if (((FrameLayout.LayoutParams) this.eFJ.getLayoutParams()).leftMargin <= 0) {
            interfaceC0075a = this.eFJ.eFz;
            if (interfaceC0075a != null) {
                interfaceC0075a2 = this.eFJ.eFz;
                interfaceC0075a2.c(this.eEV);
            }
            TiebaStatic.log("c12176");
        }
    }
}
