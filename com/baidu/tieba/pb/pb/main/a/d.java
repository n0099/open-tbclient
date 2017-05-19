package com.baidu.tieba.pb.pb.main.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a epE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.epE = aVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        PbActivity pbActivity3;
        PbActivity pbActivity4;
        pbActivity = this.epE.efF;
        if (pbActivity.checkUpIsLogin()) {
            String str = null;
            if (view.getTag() != null) {
                str = (String) view.getTag();
            }
            pbActivity2 = this.epE.efF;
            if (bg.aN(pbActivity2.getActivity()) && str != null) {
                bb vB = bb.vB();
                pbActivity4 = this.epE.efF;
                vB.c(pbActivity4.getPageContext(), new String[]{str});
            }
            pbActivity3 = this.epE.efF;
            TiebaStatic.eventStat(pbActivity3.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
        }
    }
}
