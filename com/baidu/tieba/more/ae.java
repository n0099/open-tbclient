package com.baidu.tieba.more;

import android.widget.CompoundButton;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.DatabaseService;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class ae implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsgRemindActivity f1435a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(MsgRemindActivity msgRemindActivity) {
        this.f1435a = msgRemindActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        switch (compoundButton.getId()) {
            case R.id.check_replyme /* 2131100439 */:
                if (z) {
                    TiebaApplication.g().o(true);
                    break;
                } else {
                    TiebaApplication.g().o(false);
                    break;
                }
            case R.id.check_atme /* 2131100440 */:
                if (z) {
                    TiebaApplication.g().n(true);
                    break;
                } else {
                    TiebaApplication.g().n(false);
                    break;
                }
            case R.id.check_newfans /* 2131100441 */:
                if (z) {
                    TiebaApplication.g().m(true);
                    break;
                } else {
                    TiebaApplication.g().m(false);
                    break;
                }
        }
        DatabaseService.u();
    }
}
