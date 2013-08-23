package com.baidu.tieba.pb;

import android.widget.Button;
import android.widget.LinearLayout;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class v implements com.baidu.tieba.view.ao {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f1582a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(ImagePbActivity imagePbActivity) {
        this.f1582a = imagePbActivity;
    }

    @Override // com.baidu.tieba.view.ao
    public void a(int i) {
        LinearLayout linearLayout;
        Button button;
        if (i == -2) {
            linearLayout = this.f1582a.r;
            linearLayout.setVisibility(8);
            this.f1582a.s.setVisibility(0);
            button = this.f1582a.o;
            button.setBackgroundResource(R.drawable.sub_pb_face);
        }
    }
}
