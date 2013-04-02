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
            case R.id.check_replyme /* 2131231193 */:
                if (z) {
                    TiebaApplication.b().m(true);
                    break;
                } else {
                    TiebaApplication.b().m(false);
                    break;
                }
            case R.id.check_atme /* 2131231194 */:
                if (z) {
                    TiebaApplication.b().l(true);
                    break;
                } else {
                    TiebaApplication.b().l(false);
                    break;
                }
            case R.id.check_newfans /* 2131231195 */:
                if (z) {
                    TiebaApplication.b().k(true);
                    break;
                } else {
                    TiebaApplication.b().k(false);
                    break;
                }
        }
        com.baidu.tieba.c.k.v();
    }
}
