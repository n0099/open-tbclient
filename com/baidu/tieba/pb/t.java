package com.baidu.tieba.pb;

import android.widget.Button;
import android.widget.LinearLayout;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class t implements com.baidu.tieba.view.ap {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f2148a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ImagePbActivity imagePbActivity) {
        this.f2148a = imagePbActivity;
    }

    @Override // com.baidu.tieba.view.ap
    public void a(int i) {
        LinearLayout linearLayout;
        Button button;
        if (i == -2) {
            linearLayout = this.f2148a.r;
            linearLayout.setVisibility(8);
            this.f2148a.s.setVisibility(0);
            button = this.f2148a.o;
            button.setBackgroundResource(R.drawable.sub_pb_face);
        }
    }
}
