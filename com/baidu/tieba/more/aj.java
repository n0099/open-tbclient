package com.baidu.tieba.more;

import android.app.TimePickerDialog;
import android.widget.TimePicker;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class aj implements TimePickerDialog.OnTimeSetListener {
    final /* synthetic */ MsgRemindActivity a;
    private final /* synthetic */ int b;
    private final /* synthetic */ TiebaApplication c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(MsgRemindActivity msgRemindActivity, int i, TiebaApplication tiebaApplication) {
        this.a = msgRemindActivity;
        this.b = i;
        this.c = tiebaApplication;
    }

    @Override // android.app.TimePickerDialog.OnTimeSetListener
    public final void onTimeSet(TimePicker timePicker, int i, int i2) {
        ak akVar;
        ak akVar2;
        if (this.b == R.id.sign_remind) {
            this.c.a(i, i2);
            akVar2 = this.a.a;
            akVar2.d();
        } else if (this.b == R.id.no_disturb_end_time || this.b == R.id.no_disturb_start_time) {
            String str = String.valueOf(String.valueOf(i < 10 ? SocialConstants.FALSE : "") + i) + ":" + (String.valueOf(i2 < 10 ? SocialConstants.FALSE : "") + i2);
            if (this.b == R.id.no_disturb_start_time) {
                this.c.o(str);
            } else {
                this.c.p(str);
            }
            akVar = this.a.a;
            akVar.e();
        }
    }
}
