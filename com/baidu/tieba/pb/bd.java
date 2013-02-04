package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements View.OnClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.commit_top /* 2131231142 */:
                this.a.d(3);
                return;
            case R.id.cancel_top /* 2131231143 */:
                this.a.d(4);
                return;
            case R.id.commit_good /* 2131231144 */:
                this.a.d(5);
                return;
            case R.id.cancel_good /* 2131231145 */:
                this.a.d(2);
                return;
            default:
                return;
        }
    }
}
