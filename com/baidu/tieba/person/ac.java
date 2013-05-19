package com.baidu.tieba.person;

import android.widget.RadioGroup;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements RadioGroup.OnCheckedChangeListener {
    final /* synthetic */ MyPostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(MyPostActivity myPostActivity) {
        this.a = myPostActivity;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.all_tab /* 2131100178 */:
                this.a.a("all", AllPostActivity.class);
                return;
            case R.id.thread_tab /* 2131100179 */:
            case R.id.reply_tab /* 2131100180 */:
            default:
                return;
        }
    }
}
