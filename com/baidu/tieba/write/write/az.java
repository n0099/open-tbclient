package com.baidu.tieba.write.write;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.HotTopicChangeActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements View.OnClickListener {
    final /* synthetic */ WriteActivity glP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(WriteActivity writeActivity) {
        this.glP = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WriteData writeData;
        List list;
        writeData = this.glP.mData;
        if (writeData.getType() == 7) {
            TiebaStatic.log("c12016");
        }
        Activity pageActivity = this.glP.getPageContext().getPageActivity();
        list = this.glP.mList;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicChangeActivityConfig(pageActivity, 25005, list)));
    }
}
