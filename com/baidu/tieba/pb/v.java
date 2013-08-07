package com.baidu.tieba.pb;

import android.widget.Button;
import android.widget.LinearLayout;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class v implements com.baidu.tieba.view.ar {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f1544a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(ImagePbActivity imagePbActivity) {
        this.f1544a = imagePbActivity;
    }

    @Override // com.baidu.tieba.view.ar
    public void a(int i) {
        LinearLayout linearLayout;
        Button button;
        if (i == -2) {
            linearLayout = this.f1544a.r;
            linearLayout.setVisibility(8);
            this.f1544a.s.setVisibility(0);
            button = this.f1544a.o;
            button.setBackgroundResource(R.drawable.sub_pb_face);
        }
    }
}
