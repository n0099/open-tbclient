package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.view.HeadImageView;
/* loaded from: classes.dex */
class bg implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1510a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(NewPbActivity newPbActivity) {
        this.f1510a = newPbActivity;
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
            PersonInfoActivity.a(this.f1510a, str, null);
        }
    }
}
