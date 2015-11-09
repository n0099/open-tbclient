package com.baidu.tieba.person.post;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.person.PersonPostModel;
/* loaded from: classes.dex */
class r implements View.OnClickListener {
    final /* synthetic */ p ctr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.ctr = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseFragmentActivity baseFragmentActivity;
        BaseFragmentActivity baseFragmentActivity2;
        Object tag = view.getTag();
        if (tag instanceof PersonPostModel.PostInfoList) {
            TiebaStatic.log("c10254");
            baseFragmentActivity = this.ctr.mActivity;
            PhotoLiveActivityConfig ri = new PhotoLiveActivityConfig.a(baseFragmentActivity.getPageContext().getContext(), String.valueOf(((PersonPostModel.PostInfoList) tag).thread_id)).cg(PhotoLiveActivityConfig.KEY_FROM_MY_OR_HIS_THREAD).bs(23014).ri();
            baseFragmentActivity2 = this.ctr.mActivity;
            baseFragmentActivity2.getPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, ri));
        }
    }
}
