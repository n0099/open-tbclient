package com.baidu.tieba.person;

import android.content.Intent;
import android.widget.RadioGroup;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements RadioGroup.OnCheckedChangeListener {
    final /* synthetic */ MyPostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(MyPostActivity myPostActivity) {
        this.a = myPostActivity;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        String str;
        int i2;
        String str2;
        switch (i) {
            case R.id.all_tab /* 2131100706 */:
                Intent intent = new Intent(this.a, AllPostActivity.class);
                str = this.a.i;
                if (str != null) {
                    str2 = this.a.i;
                    intent.putExtra("user", str2);
                }
                i2 = this.a.j;
                intent.putExtra("user_sex", i2);
                this.a.a("all", intent);
                return;
            case R.id.thread_tab /* 2131100707 */:
            case R.id.reply_tab /* 2131100708 */:
            default:
                return;
        }
    }
}
