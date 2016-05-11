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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {
    final /* synthetic */ an dyI;
    private final /* synthetic */ com.baidu.tieba.person.data.n dyJ;
    private final /* synthetic */ com.baidu.tieba.person.b.b dyK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(an anVar, com.baidu.tieba.person.data.n nVar, com.baidu.tieba.person.b.b bVar) {
        this.dyI = anVar;
        this.dyJ = nVar;
        this.dyK = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean aBY;
        boolean z;
        String str;
        BaseFragmentActivity baseFragmentActivity;
        BaseFragmentActivity baseFragmentActivity2;
        BaseFragmentActivity baseFragmentActivity3;
        BaseFragmentActivity baseFragmentActivity4;
        String str2;
        BaseFragmentActivity baseFragmentActivity5;
        aBY = this.dyI.aBY();
        if (!aBY) {
            baseFragmentActivity5 = this.dyI.cSp;
            baseFragmentActivity5.showToast(t.j.membership_load_fail);
            return;
        }
        if (this.dyJ.getUserData() != null && !ay.isEmpty(this.dyJ.getUserData().getUserId())) {
            com.baidu.tbadk.core.sharedPref.b.sQ().putBoolean("membership_first_launch" + this.dyJ.getUserData().getUserId(), false);
        }
        this.dyK.dBi.setVisibility(8);
        z = this.dyI.bJq;
        if (z) {
            str2 = this.dyI.dyG;
            TiebaStatic.log(str2);
        } else {
            str = this.dyI.dyH;
            TiebaStatic.log(str);
        }
        baseFragmentActivity = this.dyI.cSp;
        if (bl.ac(baseFragmentActivity.getActivity())) {
            String vipLink = this.dyJ.getVipLink();
            if (!StringUtils.isNull(vipLink) && !vipLink.startsWith("vipcenter:") && !vipLink.startsWith("membercenter:")) {
                baseFragmentActivity3 = this.dyI.cSp;
                Activity activity = baseFragmentActivity3.getActivity();
                baseFragmentActivity4 = this.dyI.cSp;
                com.baidu.tbadk.browser.f.c(activity, baseFragmentActivity4.getResources().getString(t.j.person_member_center), vipLink);
                return;
            }
            MessageManager messageManager = MessageManager.getInstance();
            baseFragmentActivity2 = this.dyI.cSp;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MembercenterActivityConfig(baseFragmentActivity2.getActivity())));
        }
    }
}
