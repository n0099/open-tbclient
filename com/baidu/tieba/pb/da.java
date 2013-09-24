package com.baidu.tieba.pb;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.write.AudioIcon;
/* loaded from: classes.dex */
class da implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PbWriteToolView f1598a;
    private final /* synthetic */ com.baidu.tieba.more.aa b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public da(PbWriteToolView pbWriteToolView, com.baidu.tieba.more.aa aaVar) {
        this.f1598a = pbWriteToolView;
        this.b = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        AudioIcon audioIcon;
        imageView = this.f1598a.c;
        if (view == imageView) {
            this.b.a(0);
            return;
        }
        imageView2 = this.f1598a.d;
        if (view == imageView2) {
            this.b.a(1);
            return;
        }
        imageView3 = this.f1598a.e;
        if (view == imageView3) {
            this.b.a(2);
            return;
        }
        audioIcon = this.f1598a.f;
        if (view == audioIcon.getView()) {
            this.b.a(3);
        }
    }
}
