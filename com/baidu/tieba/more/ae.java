package com.baidu.tieba.more;

import android.widget.CompoundButton;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.DatabaseService;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class ae implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsgRemindActivity f1400a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(MsgRemindActivity msgRemindActivity) {
        this.f1400a = msgRemindActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        switch (compoundButton.getId()) {
            case R.id.check_replyme /* 2131100397 */:
                if (z) {
                    TiebaApplication.f().p(true);
                    break;
                } else {
                    TiebaApplication.f().p(false);
                    break;
                }
            case R.id.check_atme /* 2131100398 */:
                if (z) {
                    TiebaApplication.f().o(true);
                    break;
                } else {
                    TiebaApplication.f().o(false);
                    break;
                }
            case R.id.check_newfans /* 2131100399 */:
                if (z) {
                    TiebaApplication.f().n(true);
                    break;
                } else {
                    TiebaApplication.f().n(false);
                    break;
                }
        }
        DatabaseService.w();
    }
}
