package com.baidu.tieba.more;

import android.widget.CompoundButton;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class ai implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ MsgRemindActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(MsgRemindActivity msgRemindActivity) {
        this.a = msgRemindActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        switch (compoundButton.getId()) {
            case R.id.check_replyme /* 2131231096 */:
                if (!z) {
                    TiebaApplication.a().l(false);
                    break;
                } else {
                    TiebaApplication.a().l(true);
                    break;
                }
            case R.id.check_atme /* 2131231097 */:
                if (!z) {
                    TiebaApplication.a().k(false);
                    break;
                } else {
                    TiebaApplication.a().k(true);
                    break;
                }
            case R.id.check_newfans /* 2131231098 */:
                if (!z) {
                    TiebaApplication.a().j(false);
                    break;
                } else {
                    TiebaApplication.a().j(true);
                    break;
                }
        }
        com.baidu.tieba.c.k.t();
    }
}
