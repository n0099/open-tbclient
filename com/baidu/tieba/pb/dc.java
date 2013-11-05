package com.baidu.tieba.pb;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.write.AudioIcon;
/* loaded from: classes.dex */
class dc implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.tieba.more.ac f2116a;
    final /* synthetic */ PbWriteToolView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dc(PbWriteToolView pbWriteToolView, com.baidu.tieba.more.ac acVar) {
        this.b = pbWriteToolView;
        this.f2116a = acVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        AudioIcon audioIcon;
        imageView = this.b.c;
        if (view != imageView) {
            imageView2 = this.b.d;
            if (view != imageView2) {
                imageView3 = this.b.e;
                if (view != imageView3) {
                    audioIcon = this.b.f;
                    if (view == audioIcon.getView()) {
                        this.f2116a.a(3);
                        return;
                    }
                    return;
                }
                this.f2116a.a(2);
                return;
            }
            this.f2116a.a(1);
            return;
        }
        this.f2116a.a(0);
    }
}
