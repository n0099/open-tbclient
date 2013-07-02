package com.baidu.tieba.more;

import android.widget.RadioGroup;
import com.baidu.mapapi.MKEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.DatabaseService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements RadioGroup.OnCheckedChangeListener {
    final /* synthetic */ MsgRemindActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(MsgRemindActivity msgRemindActivity) {
        this.a = msgRemindActivity;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.radio_30sec /* 2131165836 */:
                TiebaApplication.f().f(30);
                break;
            case R.id.radio_2min /* 2131165837 */:
                TiebaApplication.f().f(120);
                break;
            case R.id.radio_5min /* 2131165838 */:
                TiebaApplication.f().f(MKEvent.ERROR_PERMISSION_DENIED);
                break;
            case R.id.radio_no /* 2131165839 */:
                TiebaApplication.f().f(0);
                break;
        }
        DatabaseService.w();
        this.a.d();
    }
}
