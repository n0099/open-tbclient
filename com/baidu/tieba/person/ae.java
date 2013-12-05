package com.baidu.tieba.person;

import android.content.Intent;
import android.widget.RadioGroup;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements RadioGroup.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MyPostActivity f2303a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(MyPostActivity myPostActivity) {
        this.f2303a = myPostActivity;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        String str;
        int i2;
        String str2;
        switch (i) {
            case R.id.all_tab /* 2131100698 */:
                Intent intent = new Intent(this.f2303a, AllPostActivity.class);
                str = this.f2303a.i;
                if (str != null) {
                    str2 = this.f2303a.i;
                    intent.putExtra("user", str2);
                }
                i2 = this.f2303a.j;
                intent.putExtra("user_sex", i2);
                this.f2303a.a("all", intent);
                return;
            case R.id.thread_tab /* 2131100699 */:
            case R.id.reply_tab /* 2131100700 */:
            default:
                return;
        }
    }
}
