package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.tieba.person.PersonInfoActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class bc implements View.OnClickListener {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str = (String) view.getTag(R.id.tag_photo_userid);
        String str2 = (String) view.getTag(R.id.tag_photo_username);
        if (str != null && str2 != null) {
            PersonInfoActivity.a(this.a, str, str2);
        }
    }
}
