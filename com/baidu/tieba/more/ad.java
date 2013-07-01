package com.baidu.tieba.more;

import android.widget.CompoundButton;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.DatabaseService;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class ad implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsgRemindActivity f1082a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(MsgRemindActivity msgRemindActivity) {
        this.f1082a = msgRemindActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        switch (compoundButton.getId()) {
            case R.id.check_replyme /* 2131100259 */:
                if (z) {
                    TiebaApplication.f().o(true);
                    break;
                } else {
                    TiebaApplication.f().o(false);
                    break;
                }
            case R.id.check_atme /* 2131100260 */:
                if (z) {
                    TiebaApplication.f().n(true);
                    break;
                } else {
                    TiebaApplication.f().n(false);
                    break;
                }
            case R.id.check_newfans /* 2131100261 */:
                if (z) {
                    TiebaApplication.f().m(true);
                    break;
                } else {
                    TiebaApplication.f().m(false);
                    break;
                }
        }
        DatabaseService.w();
    }
}
