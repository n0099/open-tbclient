package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo implements View.OnClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.commit_top /* 2131231273 */:
                this.a.f(3);
                return;
            case R.id.cancel_top /* 2131231274 */:
                this.a.f(4);
                return;
            case R.id.commit_good /* 2131231275 */:
                this.a.f(5);
                return;
            case R.id.line3 /* 2131231276 */:
            default:
                return;
            case R.id.cancel_good /* 2131231277 */:
                this.a.f(2);
                return;
        }
    }
}
