package com.baidu.tieba.more;

import android.widget.RadioGroup;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements RadioGroup.OnCheckedChangeListener {
    final /* synthetic */ MsgRemindActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(MsgRemindActivity msgRemindActivity) {
        this.a = msgRemindActivity;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.radio_30sec /* 2131231091 */:
                TiebaApplication.a().d(30);
                break;
            case R.id.radio_2min /* 2131231092 */:
                TiebaApplication.a().d(120);
                break;
            case R.id.radio_5min /* 2131231093 */:
                TiebaApplication.a().d(300);
                break;
            case R.id.radio_no /* 2131231094 */:
                TiebaApplication.a().d(0);
                break;
        }
        com.baidu.tieba.c.k.t();
        this.a.i();
    }
}
