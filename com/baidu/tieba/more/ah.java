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
            case R.id.radio_30sec /* 2131231169 */:
                TiebaApplication.b().d(30);
                break;
            case R.id.radio_2min /* 2131231170 */:
                TiebaApplication.b().d(120);
                break;
            case R.id.radio_5min /* 2131231171 */:
                TiebaApplication.b().d(300);
                break;
            case R.id.radio_no /* 2131231172 */:
                TiebaApplication.b().d(0);
                break;
        }
        com.baidu.tieba.c.k.v();
        this.a.k();
    }
}
