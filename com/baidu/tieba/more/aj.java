package com.baidu.tieba.more;

import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class aj implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SignRemindActivity f1088a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(SignRemindActivity signRemindActivity) {
        this.f1088a = signRemindActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1088a.showDialog(R.id.sign_remind);
    }
}
