package com.baidu.tieba.more;

import android.widget.CompoundButton;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class ad implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ MsgRemindActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(MsgRemindActivity msgRemindActivity) {
        this.a = msgRemindActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        switch (compoundButton.getId()) {
            case R.id.check_replyme /* 2131165841 */:
                if (z) {
                    TiebaApplication.f().n(true);
                    break;
                } else {
                    TiebaApplication.f().n(false);
                    break;
                }
            case R.id.check_atme /* 2131165842 */:
                if (z) {
                    TiebaApplication.f().m(true);
                    break;
                } else {
                    TiebaApplication.f().m(false);
                    break;
                }
            case R.id.check_newfans /* 2131165843 */:
                if (z) {
                    TiebaApplication.f().l(true);
                    break;
                } else {
                    TiebaApplication.f().l(false);
                    break;
                }
        }
        DatabaseService.w();
    }
}
