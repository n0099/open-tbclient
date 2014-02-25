package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.tieba.view.HeadImageView;
/* loaded from: classes.dex */
class ca implements View.OnClickListener {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        if (view instanceof HeadImageView) {
            str = ((HeadImageView) view).getUserId();
        } else {
            str = (String) view.getTag();
        }
        if (str != null) {
            com.baidu.tieba.person.cm.a(this.a, str, null);
        }
    }
}
