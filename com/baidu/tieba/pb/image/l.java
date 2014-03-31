package com.baidu.tieba.pb.image;

import android.widget.Button;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
final class l implements com.baidu.tieba.view.u {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // com.baidu.tieba.view.u
    public final void a(int i) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Button button;
        if (i == -2) {
            linearLayout = this.a.q;
            linearLayout.setVisibility(8);
            linearLayout2 = this.a.r;
            linearLayout2.setVisibility(0);
            button = this.a.n;
            button.setBackgroundResource(com.baidu.tieba.a.g.sub_pb_face);
        }
    }
}
