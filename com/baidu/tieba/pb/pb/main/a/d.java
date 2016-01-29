package com.baidu.tieba.pb.pb.main.a;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.browser.f;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a cSH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.cSH = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        PbActivity pbActivity3;
        PbActivity pbActivity4;
        PbActivity pbActivity5;
        PbActivity pbActivity6;
        pbActivity = this.cSH.cNL;
        if (pbActivity.checkUpIsLogin()) {
            String str = null;
            if (view.getTag() != null) {
                str = (String) view.getTag();
            }
            pbActivity2 = this.cSH.cNL;
            if (bi.ah(pbActivity2.getActivity())) {
                if (!StringUtils.isNull(str) && !str.startsWith("vipcenter:") && !str.startsWith("membercenter:")) {
                    pbActivity5 = this.cSH.cNL;
                    Activity activity = pbActivity5.getActivity();
                    pbActivity6 = this.cSH.cNL;
                    f.f(activity, pbActivity6.getResources().getString(t.j.membercenter_title), str);
                } else {
                    MessageManager messageManager = MessageManager.getInstance();
                    pbActivity4 = this.cSH.cNL;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MembercenterActivityConfig(pbActivity4.getActivity())));
                }
            }
            pbActivity3 = this.cSH.cNL;
            TiebaStatic.eventStat(pbActivity3.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
        }
    }
}
