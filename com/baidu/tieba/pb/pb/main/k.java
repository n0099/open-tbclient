package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.data.LotteryActRegularInfo;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ GetLotteryChanceActivity dfT;
    private final /* synthetic */ LotteryActRegularInfo dfU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(GetLotteryChanceActivity getLotteryChanceActivity, LotteryActRegularInfo lotteryActRegularInfo) {
        this.dfT = getLotteryChanceActivity;
        this.dfU = lotteryActRegularInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        long j;
        this.dfT.showToastWithIcon(this.dfT.getResources().getString(t.j.click_done), t.f.icon_toast_game_ok);
        this.dfT.a(this.dfU);
        com.baidu.tbadk.browser.f.s(this.dfT.getActivity(), this.dfU.getUrl());
        com.baidu.tbadk.core.util.aw ac = new com.baidu.tbadk.core.util.aw("c10838").ac("obj_locate", "5");
        str = this.dfT.forumId;
        com.baidu.tbadk.core.util.aw ac2 = ac.ac("fid", str);
        j = this.dfT.threadId;
        TiebaStatic.log(ac2.ac("tid", String.valueOf(j)));
    }
}
