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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bj;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {
    final /* synthetic */ ab cMP;
    private final /* synthetic */ com.baidu.tieba.person.data.j cMQ;
    private final /* synthetic */ com.baidu.tieba.person.b.a cMR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar, com.baidu.tieba.person.data.j jVar, com.baidu.tieba.person.b.a aVar) {
        this.cMP = abVar;
        this.cMQ = jVar;
        this.cMR = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean aoa;
        boolean z;
        String str;
        BaseFragmentActivity baseFragmentActivity;
        BaseFragmentActivity baseFragmentActivity2;
        BaseFragmentActivity baseFragmentActivity3;
        BaseFragmentActivity baseFragmentActivity4;
        String str2;
        BaseFragmentActivity baseFragmentActivity5;
        aoa = this.cMP.aoa();
        if (!aoa) {
            baseFragmentActivity5 = this.cMP.mActivity;
            baseFragmentActivity5.showToast(n.i.membership_load_fail);
            return;
        }
        if (this.cMQ.getUserData() != null && !ax.isEmpty(this.cMQ.getUserData().getUserId())) {
            com.baidu.tbadk.core.sharedPref.b.tZ().putBoolean("membership_first_launch" + this.cMQ.getUserData().getUserId(), false);
        }
        this.cMR.cNM.setVisibility(8);
        z = this.cMP.bwJ;
        if (z) {
            str2 = this.cMP.cMN;
            TiebaStatic.log(str2);
        } else {
            str = this.cMP.cMO;
            TiebaStatic.log(str);
        }
        baseFragmentActivity = this.cMP.mActivity;
        if (bj.ah(baseFragmentActivity.getActivity())) {
            String vipLink = this.cMQ.getVipLink();
            if (!StringUtils.isNull(vipLink) && !vipLink.startsWith("vipcenter:") && !vipLink.startsWith("membercenter:")) {
                baseFragmentActivity3 = this.cMP.mActivity;
                Activity activity = baseFragmentActivity3.getActivity();
                baseFragmentActivity4 = this.cMP.mActivity;
                com.baidu.tbadk.browser.f.f(activity, baseFragmentActivity4.getResources().getString(n.i.person_member_center), vipLink);
                return;
            }
            MessageManager messageManager = MessageManager.getInstance();
            baseFragmentActivity2 = this.cMP.mActivity;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MembercenterActivityConfig(baseFragmentActivity2.getActivity())));
        }
    }
}
