package com.baidu.tieba.more;

import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class aq implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SignRemindActivity f1967a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(SignRemindActivity signRemindActivity) {
        this.f1967a = signRemindActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1967a.showDialog(R.id.sign_remind);
    }
}
