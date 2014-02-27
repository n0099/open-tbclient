package com.baidu.tieba.pb;

import android.widget.Button;
import android.widget.LinearLayout;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class u implements com.baidu.tieba.view.bo {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // com.baidu.tieba.view.bo
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
            button.setBackgroundResource(R.drawable.sub_pb_face);
        }
    }
}
