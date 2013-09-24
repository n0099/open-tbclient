package com.baidu.tieba.more;

import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class ao implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SignRemindActivity f1485a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(SignRemindActivity signRemindActivity) {
        this.f1485a = signRemindActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1485a.showDialog(R.id.sign_remind);
    }
}
