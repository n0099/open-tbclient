package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ GetLotteryChanceActivity dfT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(GetLotteryChanceActivity getLotteryChanceActivity) {
        this.dfT = getLotteryChanceActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        long j;
        Intent intent = new Intent();
        intent.putExtra("key_action", 1);
        this.dfT.setResult(-1, intent);
        this.dfT.closeActivity();
        com.baidu.tbadk.core.util.aw ac = new com.baidu.tbadk.core.util.aw("c10838").ac("obj_locate", "2");
        str = this.dfT.forumId;
        com.baidu.tbadk.core.util.aw ac2 = ac.ac("fid", str);
        j = this.dfT.threadId;
        TiebaStatic.log(ac2.ac("tid", String.valueOf(j)));
    }
}
