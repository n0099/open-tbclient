package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.base.g {
    final /* synthetic */ GetLotteryChanceActivity dfT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(GetLotteryChanceActivity getLotteryChanceActivity) {
        this.dfT = getLotteryChanceActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        String str;
        SignData signData;
        boolean z;
        com.baidu.tieba.tbadkCore.ah ahVar;
        com.baidu.tieba.tbadkCore.ah ahVar2;
        com.baidu.tieba.tbadkCore.ah ahVar3;
        com.baidu.tieba.tbadkCore.ah ahVar4;
        TextView textView;
        long j;
        int i;
        TextView textView2;
        TextView textView3;
        com.baidu.tieba.tbadkCore.ah ahVar5;
        String str2;
        String str3;
        str = this.dfT.forumName;
        if (obj == null || !(obj instanceof SignData)) {
            signData = null;
            z = false;
        } else {
            z = true;
            signData = (SignData) obj;
            com.baidu.tieba.tbadkCore.c.aRC().J(str, false);
            str3 = this.dfT.forumId;
            signData.setForumId(str3);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
        }
        if (!z) {
            ahVar = this.dfT.buI;
            if (AntiHelper.pB(ahVar.getErrorCode())) {
                Activity pageActivity = this.dfT.getPageContext().getPageActivity();
                ahVar3 = this.dfT.buI;
                AntiHelper.O(pageActivity, ahVar3.getErrorString());
                return;
            }
            GetLotteryChanceActivity getLotteryChanceActivity = this.dfT;
            ahVar2 = this.dfT.buI;
            getLotteryChanceActivity.showToastWithIcon(ahVar2.getErrorString(), t.f.icon_toast_game_error);
            return;
        }
        if (signData != null) {
            TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
            str2 = this.dfT.forumName;
            m411getInst.addSignedForum(str2, signData.getBonusPoint(), -1);
        }
        ahVar4 = this.dfT.buI;
        if (!AntiHelper.pB(ahVar4.getErrorCode())) {
            this.dfT.showToastWithIcon(this.dfT.getResources().getString(t.j.sign_success), t.f.icon_toast_game_ok);
            textView = this.dfT.dfQ;
            if (textView != null) {
                textView2 = this.dfT.dfQ;
                textView2.setText(this.dfT.getResources().getString(t.j.already_signed));
                textView3 = this.dfT.dfQ;
                textView3.setEnabled(false);
            }
            GetLotteryChanceActivity getLotteryChanceActivity2 = this.dfT;
            j = this.dfT.dfK;
            i = this.dfT.dfR;
            getLotteryChanceActivity2.lR((int) (j - i));
            return;
        }
        Activity pageActivity2 = this.dfT.getPageContext().getPageActivity();
        ahVar5 = this.dfT.buI;
        AntiHelper.O(pageActivity2, ahVar5.getErrorString());
    }
}
