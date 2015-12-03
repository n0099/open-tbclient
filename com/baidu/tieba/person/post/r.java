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
    final /* synthetic */ p cRd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.cRd = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseFragmentActivity baseFragmentActivity;
        BaseFragmentActivity baseFragmentActivity2;
        Object tag = view.getTag();
        if (tag instanceof PersonPostModel.PostInfoList) {
            TiebaStatic.log("c10254");
            baseFragmentActivity = this.cRd.mActivity;
            PhotoLiveActivityConfig rw = new PhotoLiveActivityConfig.a(baseFragmentActivity.getPageContext().getContext(), String.valueOf(((PersonPostModel.PostInfoList) tag).thread_id)).cn(PhotoLiveActivityConfig.KEY_FROM_MY_OR_HIS_THREAD).bv(23014).rw();
            baseFragmentActivity2 = this.cRd.mActivity;
            baseFragmentActivity2.getPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, rw));
        }
    }
}
