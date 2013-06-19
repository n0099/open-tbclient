package com.baidu.tieba.more;

import android.widget.CompoundButton;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
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
            case R.id.check_replyme /* 2131100218 */:
                if (z) {
                    TiebaApplication.e().o(true);
                    break;
                } else {
                    TiebaApplication.e().o(false);
                    break;
                }
            case R.id.check_atme /* 2131100219 */:
                if (z) {
                    TiebaApplication.e().n(true);
                    break;
                } else {
                    TiebaApplication.e().n(false);
                    break;
                }
            case R.id.check_newfans /* 2131100220 */:
                if (z) {
                    TiebaApplication.e().m(true);
                    break;
                } else {
                    TiebaApplication.e().m(false);
                    break;
                }
        }
        com.baidu.tieba.d.k.u();
    }
}
