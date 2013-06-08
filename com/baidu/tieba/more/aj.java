package com.baidu.tieba.more;

import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class aj implements View.OnClickListener {
    final /* synthetic */ SignRemindActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(SignRemindActivity signRemindActivity) {
        this.a = signRemindActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.showDialog(R.id.sign_remind);
    }
}
