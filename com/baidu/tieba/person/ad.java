package com.baidu.tieba.person;

import android.content.Intent;
import android.widget.RadioGroup;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements RadioGroup.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MyPostActivity f1599a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(MyPostActivity myPostActivity) {
        this.f1599a = myPostActivity;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        String str;
        int i2;
        String str2;
        switch (i) {
            case R.id.all_tab /* 2131100450 */:
                Intent intent = new Intent(this.f1599a, AllPostActivity.class);
                str = this.f1599a.i;
                if (str != null) {
                    str2 = this.f1599a.i;
                    intent.putExtra("user", str2);
                }
                i2 = this.f1599a.j;
                intent.putExtra("user_sex", i2);
                this.f1599a.a("all", intent);
                return;
            case R.id.thread_tab /* 2131100451 */:
            case R.id.reply_tab /* 2131100452 */:
            default:
                return;
        }
    }
}
