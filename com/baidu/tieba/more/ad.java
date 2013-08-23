package com.baidu.tieba.more;

import android.widget.RadioGroup;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.DatabaseService;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements RadioGroup.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsgRemindActivity f1434a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(MsgRemindActivity msgRemindActivity) {
        this.f1434a = msgRemindActivity;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.radio_30sec /* 2131100434 */:
                TiebaApplication.g().c(30);
                break;
            case R.id.radio_2min /* 2131100435 */:
                TiebaApplication.g().c(120);
                break;
            case R.id.radio_5min /* 2131100436 */:
                TiebaApplication.g().c(300);
                break;
            case R.id.radio_no /* 2131100437 */:
                TiebaApplication.g().c(0);
                break;
        }
        DatabaseService.u();
        this.f1434a.d();
    }
}
