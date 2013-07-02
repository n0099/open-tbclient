package com.baidu.tieba.pb;

import android.widget.Button;
import android.widget.LinearLayout;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class v implements com.baidu.tieba.view.af {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // com.baidu.tieba.view.af
    public void a(int i) {
        LinearLayout linearLayout;
        Button button;
        if (i == -2) {
            linearLayout = this.a.r;
            linearLayout.setVisibility(8);
            this.a.s.setVisibility(0);
            button = this.a.o;
            button.setBackgroundResource(R.drawable.sub_pb_face);
        }
    }
}
