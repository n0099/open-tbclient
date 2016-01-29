package com.baidu.tieba.person.a;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ ag dbe;
    private final /* synthetic */ com.baidu.tieba.person.data.m dbf;
    private final /* synthetic */ com.baidu.tieba.person.b.b dbg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar, com.baidu.tieba.person.data.m mVar, com.baidu.tieba.person.b.b bVar) {
        this.dbe = agVar;
        this.dbf = mVar;
        this.dbg = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean auc;
        boolean z;
        String str;
        BaseFragmentActivity baseFragmentActivity;
        BaseFragmentActivity baseFragmentActivity2;
        BaseFragmentActivity baseFragmentActivity3;
        BaseFragmentActivity baseFragmentActivity4;
        String str2;
        BaseFragmentActivity baseFragmentActivity5;
        auc = this.dbe.auc();
        if (!auc) {
            baseFragmentActivity5 = this.dbe.cZG;
            baseFragmentActivity5.showToast(t.j.membership_load_fail);
            return;
        }
        if (this.dbf.getUserData() != null && !aw.isEmpty(this.dbf.getUserData().getUserId())) {
            com.baidu.tbadk.core.sharedPref.b.uO().putBoolean("membership_first_launch" + this.dbf.getUserData().getUserId(), false);
        }
        this.dbg.ddC.setVisibility(8);
        z = this.dbe.bDM;
        if (z) {
            str2 = this.dbe.dbc;
            TiebaStatic.log(str2);
        } else {
            str = this.dbe.dbd;
            TiebaStatic.log(str);
        }
        baseFragmentActivity = this.dbe.cZG;
        if (bi.ah(baseFragmentActivity.getActivity())) {
            String vipLink = this.dbf.getVipLink();
            if (!StringUtils.isNull(vipLink) && !vipLink.startsWith("vipcenter:") && !vipLink.startsWith("membercenter:")) {
                baseFragmentActivity3 = this.dbe.cZG;
                Activity activity = baseFragmentActivity3.getActivity();
                baseFragmentActivity4 = this.dbe.cZG;
                com.baidu.tbadk.browser.f.f(activity, baseFragmentActivity4.getResources().getString(t.j.person_member_center), vipLink);
                return;
            }
            MessageManager messageManager = MessageManager.getInstance();
            baseFragmentActivity2 = this.dbe.cZG;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MembercenterActivityConfig(baseFragmentActivity2.getActivity())));
        }
    }
}
