package com.baidu.tieba.pb;

import android.widget.Button;
import android.widget.LinearLayout;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class s implements com.baidu.tieba.view.aq {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f2281a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ImagePbActivity imagePbActivity) {
        this.f2281a = imagePbActivity;
    }

    @Override // com.baidu.tieba.view.aq
    public void a(int i) {
        LinearLayout linearLayout;
        Button button;
        if (i == -2) {
            linearLayout = this.f2281a.q;
            linearLayout.setVisibility(8);
            this.f2281a.r.setVisibility(0);
            button = this.f2281a.n;
            button.setBackgroundResource(R.drawable.sub_pb_face);
        }
    }
}
