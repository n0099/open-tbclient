package com.baidu.tieba.pb.pb.main.emotion;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.pb.main.emotion.data.EmotionImageData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ l evI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.evI = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        a aVar2;
        Object tag = view.getTag(view.getId());
        if (tag != null && (tag instanceof EmotionImageData)) {
            aVar = this.evI.emx;
            if (aVar != null) {
                aVar2 = this.evI.emx;
                aVar2.b((EmotionImageData) tag);
            }
            TiebaStatic.log("c12180");
        }
    }
}
