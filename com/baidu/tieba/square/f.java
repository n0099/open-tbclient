package com.baidu.tieba.square;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.bt;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
class f implements bt {
    final /* synthetic */ e a;
    private final /* synthetic */ String b;
    private final /* synthetic */ com.baidu.adp.widget.a.a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, String str, com.baidu.adp.widget.a.a aVar) {
        this.a = eVar;
        this.b = str;
        this.c = aVar;
    }

    @Override // com.baidu.tbadk.core.util.bt
    public boolean a(View view) {
        if ((view instanceof ImageView) && this.b != null && this.b.equals(view.getTag())) {
            HeadImageView headImageView = (HeadImageView) view;
            headImageView.setImageBitmap(this.c.h());
            headImageView.invalidate();
            return false;
        }
        return false;
    }
}
