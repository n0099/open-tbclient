package com.baidu.tieba.person.post;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.person.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ q enJ;
    private final /* synthetic */ PersonPostModel.PostInfoList enK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar, PersonPostModel.PostInfoList postInfoList) {
        this.enJ = qVar;
        this.enK = postInfoList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseFragmentActivity baseFragmentActivity;
        MessageManager messageManager = MessageManager.getInstance();
        baseFragmentActivity = this.enJ.bfw;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(baseFragmentActivity.getPageContext().getPageActivity(), new StringBuilder(String.valueOf(this.enK.user_id)).toString(), this.enK.user_name)));
    }
}
