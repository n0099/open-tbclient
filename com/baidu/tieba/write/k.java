package com.baidu.tieba.write;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.GridLayout;
import com.baidu.tieba.frs.ForumWriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ e gdS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        this.gdS = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        GridLayout gridLayout;
        TbImageView tbImageView;
        ForumWriteData forumWriteData;
        String str;
        int i;
        String str2;
        TbPageContext tbPageContext;
        String str3;
        ForumWriteData forumWriteData2;
        ForumWriteData forumWriteData3;
        ForumWriteData forumWriteData4;
        ForumWriteData forumWriteData5;
        ForumWriteData forumWriteData6;
        ForumWriteData forumWriteData7;
        e eVar = this.gdS;
        gridLayout = this.gdS.gdK;
        tbImageView = this.gdS.gdJ;
        eVar.d(gridLayout, tbImageView);
        String str4 = "0";
        String str5 = null;
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        forumWriteData = this.gdS.gdN;
        if (forumWriteData != null) {
            forumWriteData2 = this.gdS.gdN;
            str4 = forumWriteData2.forumId;
            forumWriteData3 = this.gdS.gdN;
            str5 = forumWriteData3.forumName;
            forumWriteData4 = this.gdS.gdN;
            postPrefixData = forumWriteData4.prefixData;
            forumWriteData5 = this.gdS.gdN;
            antiData = forumWriteData5.antiData;
            forumWriteData6 = this.gdS.gdN;
            int i2 = forumWriteData6.forumLevel;
            forumWriteData7 = this.gdS.gdN;
            str = forumWriteData7.avatar;
            i = i2;
        } else {
            str = null;
            i = -1;
        }
        au auVar = new au("c12257");
        str2 = this.gdS.gdO;
        TiebaStatic.log(auVar.Z("obj_locate", str2));
        tbPageContext = this.gdS.aat;
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(tbPageContext.getPageActivity(), 0, str4, str5, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
        str3 = this.gdS.gdO;
        writeActivityConfig.setCallFrom(str3);
        writeActivityConfig.setForumLevel(i);
        writeActivityConfig.setForumAvatar(str);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
    }
}
