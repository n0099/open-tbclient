package com.baidu.tieba.person.post;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.person.PersonPostModel;
/* loaded from: classes.dex */
class s implements View.OnClickListener {
    final /* synthetic */ q dBG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar) {
        this.dBG = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseFragmentActivity baseFragmentActivity;
        BaseFragmentActivity baseFragmentActivity2;
        Object tag = view.getTag();
        if (tag instanceof PersonPostModel.PostInfoList) {
            TiebaStatic.log("c10254");
            baseFragmentActivity = this.dBG.duj;
            PhotoLiveActivityConfig qT = new PhotoLiveActivityConfig.a(baseFragmentActivity.getPageContext().getContext(), String.valueOf(((PersonPostModel.PostInfoList) tag).thread_id)).cl(PhotoLiveActivityConfig.KEY_FROM_MY_OR_HIS_THREAD).bC(23014).qT();
            baseFragmentActivity2 = this.dBG.duj;
            baseFragmentActivity2.getPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, qT));
        }
    }
}
