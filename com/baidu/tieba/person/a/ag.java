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
public class ag implements View.OnClickListener {
    final /* synthetic */ af cRt;
    private final /* synthetic */ com.baidu.tieba.person.data.l cRu;
    private final /* synthetic */ com.baidu.tieba.person.b.a cRv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar, com.baidu.tieba.person.data.l lVar, com.baidu.tieba.person.b.a aVar) {
        this.cRt = afVar;
        this.cRu = lVar;
        this.cRv = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean apk;
        boolean z;
        String str;
        BaseFragmentActivity baseFragmentActivity;
        BaseFragmentActivity baseFragmentActivity2;
        BaseFragmentActivity baseFragmentActivity3;
        BaseFragmentActivity baseFragmentActivity4;
        String str2;
        BaseFragmentActivity baseFragmentActivity5;
        apk = this.cRt.apk();
        if (!apk) {
            baseFragmentActivity5 = this.cRt.mActivity;
            baseFragmentActivity5.showToast(n.j.membership_load_fail);
            return;
        }
        if (this.cRu.getUserData() != null && !ax.isEmpty(this.cRu.getUserData().getUserId())) {
            com.baidu.tbadk.core.sharedPref.b.tJ().putBoolean("membership_first_launch" + this.cRu.getUserData().getUserId(), false);
        }
        this.cRv.cSs.setVisibility(8);
        z = this.cRt.bAA;
        if (z) {
            str2 = this.cRt.cRr;
            TiebaStatic.log(str2);
        } else {
            str = this.cRt.cRs;
            TiebaStatic.log(str);
        }
        baseFragmentActivity = this.cRt.mActivity;
        if (bj.ah(baseFragmentActivity.getActivity())) {
            String vipLink = this.cRu.getVipLink();
            if (!StringUtils.isNull(vipLink) && !vipLink.startsWith("vipcenter:") && !vipLink.startsWith("membercenter:")) {
                baseFragmentActivity3 = this.cRt.mActivity;
                Activity activity = baseFragmentActivity3.getActivity();
                baseFragmentActivity4 = this.cRt.mActivity;
                com.baidu.tbadk.browser.f.f(activity, baseFragmentActivity4.getResources().getString(n.j.person_member_center), vipLink);
                return;
            }
            MessageManager messageManager = MessageManager.getInstance();
            baseFragmentActivity2 = this.cRt.mActivity;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MembercenterActivityConfig(baseFragmentActivity2.getActivity())));
        }
    }
}
