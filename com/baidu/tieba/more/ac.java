package com.baidu.tieba.more;

import android.widget.RadioGroup;
import com.baidu.mapapi.MKEvent;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
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
            case R.id.radio_30sec /* 2131100204 */:
                TiebaApplication.d().f(30);
                break;
            case R.id.radio_2min /* 2131100205 */:
                TiebaApplication.d().f(120);
                break;
            case R.id.radio_5min /* 2131100206 */:
                TiebaApplication.d().f(MKEvent.ERROR_PERMISSION_DENIED);
                break;
            case R.id.radio_no /* 2131100207 */:
                TiebaApplication.d().f(0);
                break;
        }
        com.baidu.tieba.d.k.u();
        this.a.d();
    }
}
