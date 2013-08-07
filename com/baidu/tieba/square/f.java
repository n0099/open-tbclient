package com.baidu.tieba.square;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.util.au;
/* loaded from: classes.dex */
class f implements au {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f1722a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, String str) {
        this.f1722a = eVar;
        this.b = str;
    }

    @Override // com.baidu.tieba.util.au
    public boolean a(View view) {
        if ((view instanceof ImageView) && this.b != null && this.b.equals(view.getTag())) {
            ((ImageView) view).invalidate();
            return false;
        }
        return false;
    }
}
