package com.baidu.tieba.themeCenter;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ MemberRecommendView dfS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(MemberRecommendView memberRecommendView) {
        this.dfS = memberRecommendView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2;
        com.baidu.tieba.themeCenter.dressCenter.k kVar;
        Context context;
        i = this.dfS.fromType;
        switch (i) {
            case 1:
                TiebaStatic.log("c10261");
                i2 = 8;
                break;
            case 2:
            case 3:
                TiebaStatic.log("c10266");
                i2 = 9;
                break;
            case 4:
            case 5:
                TiebaStatic.log("c10278");
                i2 = 12;
                break;
            default:
                i2 = 0;
                break;
        }
        kVar = this.dfS.dfR;
        if (kVar != null) {
            context = this.dfS.mContext;
            TbPageContext tbPageContext = (TbPageContext) com.baidu.adp.base.l.C(context);
            if (tbPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(tbPageContext.getPageActivity(), TbadkCoreApplication.getCurrentMemberType(), "", i2)));
            }
        }
    }
}
