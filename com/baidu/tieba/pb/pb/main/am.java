package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class am {
    private PbActivity fNg;
    private com.baidu.tieba.d.c fTx;

    public am(PbActivity pbActivity) {
        this.fNg = pbActivity;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SUBMIT_PB_SHOW_TIP, TbConfig.SERVER_ADDRESS + TbConfig.SUBMIT_SHOW_PB_TIPS);
        tbHttpMessageTask.setResponsedClass(SubmitPbShowTipHttpResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(View view, String str, String str2, String str3) {
        if (view != null && !StringUtils.isNull(str) && view.getVisibility() == 0 && view.getAlpha() >= 0.4d) {
            if (this.fTx == null) {
                this.fTx = new com.baidu.tieba.d.c(this.fNg.getPageContext(), view);
                this.fTx.lS(d.f.bg_tip_blue_up_left);
                this.fTx.lR(16);
                this.fTx.fa(true);
                this.fTx.lV(57);
                this.fTx.lW(-10);
            }
            this.fTx.lT(5000);
            this.fTx.kG(str);
            bH(str2, str3);
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12504"));
        }
    }

    public void destroy() {
        if (this.fTx != null) {
            this.fTx.anh();
        }
    }

    private void bH(String str, String str2) {
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SUBMIT_PB_SHOW_TIP);
            httpMessage.addParam("thread_user_id", str);
            httpMessage.addParam("thread_id", str2);
            this.fNg.sendMessage(httpMessage);
        }
    }
}
