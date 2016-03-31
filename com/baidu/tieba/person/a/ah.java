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
public class ah implements View.OnClickListener {
    final /* synthetic */ ag dvG;
    private final /* synthetic */ com.baidu.tieba.person.data.m dvH;
    private final /* synthetic */ com.baidu.tieba.person.b.b dvI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar, com.baidu.tieba.person.data.m mVar, com.baidu.tieba.person.b.b bVar) {
        this.dvG = agVar;
        this.dvH = mVar;
        this.dvI = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean aBH;
        boolean z;
        String str;
        BaseFragmentActivity baseFragmentActivity;
        BaseFragmentActivity baseFragmentActivity2;
        BaseFragmentActivity baseFragmentActivity3;
        BaseFragmentActivity baseFragmentActivity4;
        String str2;
        BaseFragmentActivity baseFragmentActivity5;
        aBH = this.dvG.aBH();
        if (!aBH) {
            baseFragmentActivity5 = this.dvG.duj;
            baseFragmentActivity5.showToast(t.j.membership_load_fail);
            return;
        }
        if (this.dvH.getUserData() != null && !ay.isEmpty(this.dvH.getUserData().getUserId())) {
            com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("membership_first_launch" + this.dvH.getUserData().getUserId(), false);
        }
        this.dvI.dyd.setVisibility(8);
        z = this.dvG.bJj;
        if (z) {
            str2 = this.dvG.dvE;
            TiebaStatic.log(str2);
        } else {
            str = this.dvG.dvF;
            TiebaStatic.log(str);
        }
        baseFragmentActivity = this.dvG.duj;
        if (bl.ad(baseFragmentActivity.getActivity())) {
            String vipLink = this.dvH.getVipLink();
            if (!StringUtils.isNull(vipLink) && !vipLink.startsWith("vipcenter:") && !vipLink.startsWith("membercenter:")) {
                baseFragmentActivity3 = this.dvG.duj;
                Activity activity = baseFragmentActivity3.getActivity();
                baseFragmentActivity4 = this.dvG.duj;
                com.baidu.tbadk.browser.f.c(activity, baseFragmentActivity4.getResources().getString(t.j.person_member_center), vipLink);
                return;
            }
            MessageManager messageManager = MessageManager.getInstance();
            baseFragmentActivity2 = this.dvG.duj;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MembercenterActivityConfig(baseFragmentActivity2.getActivity())));
        }
    }
}
