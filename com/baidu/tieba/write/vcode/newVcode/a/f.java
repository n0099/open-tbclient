package com.baidu.tieba.write.vcode.newVcode.a;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.u;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements a.d {
    final /* synthetic */ d fFP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.fFP = dVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, p pVar, WriteData writeData, AntiData antiData) {
        NewVcodeView newVcodeView;
        NewVcodeView newVcodeView2;
        NewVcodeView newVcodeView3;
        NewVcodeView newVcodeView4;
        NewVcodeView newVcodeView5;
        NewVcodeView newVcodeView6;
        NewVcodeView newVcodeView7;
        NewVcodeView newVcodeView8;
        NewVcodeView newVcodeView9;
        NewVcodeView newVcodeView10;
        NewVcodeView newVcodeView11;
        NewVcodeView newVcodeView12;
        NewVcodeView newVcodeView13;
        newVcodeView = this.fFP.fFH;
        newVcodeView.showPostThreadLoadingView(false);
        if (z) {
            if (writeData != null && writeData.getVideoReviewType() == 1) {
                newVcodeView12 = this.fFP.fFH;
                newVcodeView13 = this.fFP.fFH;
                newVcodeView12.showToast(true, newVcodeView13.getContext().getResources().getString(u.j.video_send_success_under_review));
            } else if (writeData == null || writeData.getVideoReviewType() != 2) {
                newVcodeView5 = this.fFP.fFH;
                newVcodeView6 = this.fFP.fFH;
                newVcodeView5.showToast(true, newVcodeView6.getContext().getResources().getString(u.j.send_success));
            } else {
                newVcodeView7 = this.fFP.fFH;
                newVcodeView8 = this.fFP.fFH;
                newVcodeView7.showToast(true, newVcodeView8.getContext().getResources().getString(u.j.video_send_success));
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
            intent.putExtras(bundle);
            newVcodeView9 = this.fFP.fFH;
            BaseActivity context = newVcodeView9.getContext();
            newVcodeView10 = this.fFP.fFH;
            newVcodeView10.getContext();
            context.setResult(-1, intent);
            newVcodeView11 = this.fFP.fFH;
            newVcodeView11.getContext().finish();
        } else if (postWriteCallBackData != null) {
            if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                newVcodeView3 = this.fFP.fFH;
                newVcodeView4 = this.fFP.fFH;
                newVcodeView3.showToast(false, newVcodeView4.getContext().getResources().getString(u.j.input_vcode_error));
            } else {
                newVcodeView2 = this.fFP.fFH;
                newVcodeView2.showToast(false, postWriteCallBackData.getErrorString());
            }
            this.fFP.afu();
        }
    }
}
