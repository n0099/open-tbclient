package com.baidu.tieba.pb;

import android.widget.Button;
import android.widget.LinearLayout;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
class u implements com.baidu.tieba.view.aa {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // com.baidu.tieba.view.aa
    public void a(int i) {
        LinearLayout linearLayout;
        Button button;
        if (i == -2) {
            linearLayout = this.a.p;
            linearLayout.setVisibility(8);
            this.a.q.setVisibility(0);
            button = this.a.m;
            button.setBackgroundResource(R.drawable.sub_pb_face);
        }
    }
}
