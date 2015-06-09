package com.baidu.tieba.pb.pb.main.a;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a bOO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bOO = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        PbActivity pbActivity3;
        PbActivity pbActivity4;
        pbActivity = this.bOO.bLa;
        if (pbActivity.checkUpIsLogin()) {
            pbActivity2 = this.bOO.bLa;
            pbActivity3 = this.bOO.bLa;
            pbActivity2.sendMessage(new CustomMessage(2002001, new MemberPrivilegeActivityConfig(pbActivity3.getPageContext().getPageActivity())));
            pbActivity4 = this.bOO.bLa;
            TiebaStatic.eventStat(pbActivity4.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
        }
    }
}
