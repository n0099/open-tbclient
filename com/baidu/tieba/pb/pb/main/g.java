package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ GetLotteryChanceActivity dfT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(GetLotteryChanceActivity getLotteryChanceActivity) {
        this.dfT = getLotteryChanceActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dfT.awc();
    }
}
