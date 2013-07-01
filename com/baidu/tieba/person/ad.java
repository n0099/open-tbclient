package com.baidu.tieba.person;

import android.content.Intent;
import android.widget.RadioGroup;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements RadioGroup.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MyPostActivity f1311a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(MyPostActivity myPostActivity) {
        this.f1311a = myPostActivity;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        String str;
        String str2;
        switch (i) {
            case R.id.all_tab /* 2131100270 */:
                Intent intent = new Intent(this.f1311a, AllPostActivity.class);
                str = this.f1311a.i;
                if (str != null) {
                    str2 = this.f1311a.i;
                    intent.putExtra("user", str2);
                }
                this.f1311a.a("all", intent);
                return;
            case R.id.thread_tab /* 2131100271 */:
            case R.id.reply_tab /* 2131100272 */:
            default:
                return;
        }
    }
}
