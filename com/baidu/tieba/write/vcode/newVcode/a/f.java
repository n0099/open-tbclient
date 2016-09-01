package com.baidu.tieba.write.vcode.newVcode.a;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.s;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.b;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements b.d {
    final /* synthetic */ d gbV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.gbV = dVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.b.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, s sVar, WriteData writeData, AntiData antiData) {
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
        NewVcodeView newVcodeView14;
        NewVcodeView newVcodeView15;
        NewVcodeView newVcodeView16;
        newVcodeView = this.gbV.gbO;
        newVcodeView.showPostThreadLoadingView(false);
        newVcodeView2 = this.gbV.gbO;
        if (newVcodeView2 != null) {
            if (z) {
                if (writeData != null && writeData.getVideoReviewType() == 1) {
                    newVcodeView15 = this.gbV.gbO;
                    newVcodeView16 = this.gbV.gbO;
                    newVcodeView15.showToast(true, newVcodeView16.getContext().getResources().getString(t.j.video_send_success_under_review));
                } else if (writeData == null || writeData.getVideoReviewType() != 2) {
                    newVcodeView8 = this.gbV.gbO;
                    newVcodeView9 = this.gbV.gbO;
                    newVcodeView8.showToast(true, newVcodeView9.getContext().getResources().getString(t.j.send_success));
                } else {
                    newVcodeView10 = this.gbV.gbO;
                    newVcodeView11 = this.gbV.gbO;
                    newVcodeView10.showToast(true, newVcodeView11.getContext().getResources().getString(t.j.video_send_success));
                }
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                newVcodeView12 = this.gbV.gbO;
                BaseActivity context = newVcodeView12.getContext();
                newVcodeView13 = this.gbV.gbO;
                newVcodeView13.getContext();
                context.setResult(-1, intent);
                newVcodeView14 = this.gbV.gbO;
                newVcodeView14.getContext().finish();
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                newVcodeView6 = this.gbV.gbO;
                newVcodeView6.getContext().setVisible(false);
                MessageManager messageManager = MessageManager.getInstance();
                newVcodeView7 = this.gbV.gbO;
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(newVcodeView7.getContext().getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
            } else if (postWriteCallBackData != null) {
                if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    newVcodeView4 = this.gbV.gbO;
                    newVcodeView5 = this.gbV.gbO;
                    newVcodeView4.showToast(false, newVcodeView5.getContext().getResources().getString(t.j.input_vcode_error));
                } else {
                    newVcodeView3 = this.gbV.gbO;
                    newVcodeView3.showToast(false, postWriteCallBackData.getErrorString());
                }
                this.gbV.akI();
            }
        }
    }
}
