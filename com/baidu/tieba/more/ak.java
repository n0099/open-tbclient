package com.baidu.tieba.more;

import android.app.TimePickerDialog;
import android.widget.TimePicker;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class ak implements TimePickerDialog.OnTimeSetListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f1978a;
    final /* synthetic */ TiebaApplication b;
    final /* synthetic */ MsgRemindActivity c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(MsgRemindActivity msgRemindActivity, int i, TiebaApplication tiebaApplication) {
        this.c = msgRemindActivity;
        this.f1978a = i;
        this.b = tiebaApplication;
    }

    @Override // android.app.TimePickerDialog.OnTimeSetListener
    public void onTimeSet(TimePicker timePicker, int i, int i2) {
        al alVar;
        al alVar2;
        if (this.f1978a == R.id.sign_remind) {
            this.b.a(i, i2);
            alVar2 = this.c.f1961a;
            alVar2.e();
        } else if (this.f1978a == R.id.no_disturb_end_time || this.f1978a == R.id.no_disturb_start_time) {
            String str = ((i < 10 ? SocialConstants.FALSE : "") + i) + ":" + ((i2 < 10 ? SocialConstants.FALSE : "") + i2);
            if (this.f1978a == R.id.no_disturb_start_time) {
                this.b.o(str);
            } else {
                this.b.p(str);
            }
            alVar = this.c.f1961a;
            alVar.f();
        }
    }
}
