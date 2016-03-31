package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ GetLotteryChanceActivity dfT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(GetLotteryChanceActivity getLotteryChanceActivity) {
        this.dfT = getLotteryChanceActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.tbadkCore.ah ahVar;
        String str;
        long j;
        String str2;
        String str3;
        com.baidu.tieba.tbadkCore.ah ahVar2;
        String str4;
        String str5;
        ahVar = this.dfT.buI;
        if (ahVar != null) {
            str2 = this.dfT.forumId;
            if (!StringUtils.isNULL(str2)) {
                str3 = this.dfT.forumName;
                if (!StringUtils.isNULL(str3)) {
                    ahVar2 = this.dfT.buI;
                    str4 = this.dfT.forumName;
                    str5 = this.dfT.forumId;
                    ahVar2.bB(str4, str5);
                }
            }
        }
        com.baidu.tbadk.core.util.aw ac = new com.baidu.tbadk.core.util.aw("c10838").ac("obj_locate", "1");
        str = this.dfT.forumId;
        com.baidu.tbadk.core.util.aw ac2 = ac.ac("fid", str);
        j = this.dfT.threadId;
        TiebaStatic.log(ac2.ac("tid", String.valueOf(j)));
    }
}
