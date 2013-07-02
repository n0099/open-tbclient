package com.baidu.tieba.person;

import android.content.Intent;
import android.widget.RadioGroup;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements RadioGroup.OnCheckedChangeListener {
    final /* synthetic */ MyPostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(MyPostActivity myPostActivity) {
        this.a = myPostActivity;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        String str;
        String str2;
        switch (i) {
            case R.id.all_tab /* 2131165852 */:
                Intent intent = new Intent(this.a, AllPostActivity.class);
                str = this.a.i;
                if (str != null) {
                    str2 = this.a.i;
                    intent.putExtra("user", str2);
                }
                this.a.a("all", intent);
                return;
            case R.id.thread_tab /* 2131165853 */:
            case R.id.reply_tab /* 2131165854 */:
            default:
                return;
        }
    }
}
