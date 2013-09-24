package com.baidu.tieba.pb;

import android.widget.ImageView;
import com.baidu.tieba.view.KeyboardEventLayout;
/* loaded from: classes.dex */
class cf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ce f1577a;
    private final /* synthetic */ ImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(ce ceVar, ImageView imageView) {
        this.f1577a = ceVar;
        this.b = imageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        br brVar;
        KeyboardEventLayout keyboardEventLayout;
        brVar = this.f1577a.f1576a;
        keyboardEventLayout = brVar.d;
        keyboardEventLayout.removeView(this.b);
    }
}
