package com.baidu.tieba.write;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.WriteUrlActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.GridLayout;
import com.baidu.tieba.frs.ForumWriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ e gdS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(e eVar) {
        this.gdS = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        GridLayout gridLayout;
        TbImageView tbImageView;
        ForumWriteData forumWriteData;
        TbPageContext tbPageContext;
        String str;
        String str2;
        ForumWriteData forumWriteData2;
        ForumWriteData forumWriteData3;
        e eVar = this.gdS;
        gridLayout = this.gdS.gdK;
        tbImageView = this.gdS.gdJ;
        eVar.d(gridLayout, tbImageView);
        String str3 = "0";
        String str4 = null;
        forumWriteData = this.gdS.gdN;
        if (forumWriteData != null) {
            forumWriteData2 = this.gdS.gdN;
            str3 = forumWriteData2.forumId;
            forumWriteData3 = this.gdS.gdN;
            str4 = forumWriteData3.forumName;
        }
        tbPageContext = this.gdS.aat;
        Activity pageActivity = tbPageContext.getPageActivity();
        str = this.gdS.gdO;
        WriteUrlActivityConfig writeUrlActivityConfig = new WriteUrlActivityConfig(pageActivity, str3, str4, str);
        writeUrlActivityConfig.setRequestCode(13003);
        writeUrlActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeUrlActivityConfig));
        au auVar = new au("c12162");
        str2 = this.gdS.gdO;
        TiebaStatic.log(auVar.Z("obj_locate", str2));
    }
}
