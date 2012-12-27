package com.baidu.tieba.more;

import android.view.View;
import android.widget.Button;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ AccountActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AccountActivity accountActivity) {
        this.a = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        m mVar;
        m mVar2;
        Button button;
        m mVar3;
        m mVar4;
        Button button2;
        m mVar5;
        mVar = this.a.c;
        if (mVar.a()) {
            mVar2 = this.a.c;
            mVar2.a(false);
            button = this.a.f;
            button.setText(R.string.edit);
            mVar3 = this.a.c;
            mVar3.notifyDataSetChanged();
            return;
        }
        mVar4 = this.a.c;
        mVar4.a(true);
        button2 = this.a.f;
        button2.setText(R.string.done);
        mVar5 = this.a.c;
        mVar5.notifyDataSetChanged();
    }
}
