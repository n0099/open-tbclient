package com.baidu.tieba.person;

import android.content.Intent;
import android.widget.RadioGroup;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements RadioGroup.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MyPostActivity f1648a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(MyPostActivity myPostActivity) {
        this.f1648a = myPostActivity;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        String str;
        int i2;
        String str2;
        switch (i) {
            case R.id.all_tab /* 2131100486 */:
                Intent intent = new Intent(this.f1648a, AllPostActivity.class);
                str = this.f1648a.i;
                if (str != null) {
                    str2 = this.f1648a.i;
                    intent.putExtra("user", str2);
                }
                i2 = this.f1648a.j;
                intent.putExtra("user_sex", i2);
                this.f1648a.a("all", intent);
                return;
            case R.id.thread_tab /* 2131100487 */:
            case R.id.reply_tab /* 2131100488 */:
            default:
                return;
        }
    }
}
