package com.baidu.tieba.write;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.GridLayout;
import com.baidu.tieba.frs.ForumWriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ e gdS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar) {
        this.gdS = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        GridLayout gridLayout;
        TbImageView tbImageView;
        ForumWriteData forumWriteData;
        ForumWriteData forumWriteData2;
        ForumWriteData forumWriteData3;
        e eVar = this.gdS;
        gridLayout = this.gdS.gdK;
        tbImageView = this.gdS.gdJ;
        eVar.d(gridLayout, tbImageView);
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
        String str = "0";
        String str2 = null;
        forumWriteData = this.gdS.gdN;
        if (forumWriteData != null) {
            forumWriteData2 = this.gdS.gdN;
            str = forumWriteData2.forumId;
            forumWriteData3 = this.gdS.gdN;
            str2 = forumWriteData3.forumName;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, new AlaLiveRoomActivityConfig(TbadkCoreApplication.m9getInst().getApplicationContext(), str2, str, TbadkCoreApplication.getCurrentAccount(), true, false)));
    }
}
