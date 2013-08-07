package com.baidu.tieba.more;

import android.widget.RadioGroup;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.DatabaseService;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements RadioGroup.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsgRemindActivity f1397a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(MsgRemindActivity msgRemindActivity) {
        this.f1397a = msgRemindActivity;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.radio_30sec /* 2131100392 */:
                TiebaApplication.f().d(30);
                break;
            case R.id.radio_2min /* 2131100393 */:
                TiebaApplication.f().d(120);
                break;
            case R.id.radio_5min /* 2131100394 */:
                TiebaApplication.f().d(300);
                break;
            case R.id.radio_no /* 2131100395 */:
                TiebaApplication.f().d(0);
                break;
        }
        DatabaseService.w();
        this.f1397a.d();
    }
}
