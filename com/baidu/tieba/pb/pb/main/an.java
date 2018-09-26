package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.e;
/* loaded from: classes2.dex */
public class an {
    private PbActivity fFd;
    private com.baidu.tieba.c.d fLL;

    public an(PbActivity pbActivity) {
        this.fFd = pbActivity;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SUBMIT_PB_SHOW_TIP, TbConfig.SERVER_ADDRESS + TbConfig.SUBMIT_SHOW_PB_TIPS);
        tbHttpMessageTask.setResponsedClass(SubmitPbShowTipHttpResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(View view, String str, String str2, String str3) {
        if (view != null && !StringUtils.isNull(str) && view.getVisibility() == 0 && view.getAlpha() >= 0.4d) {
            if (this.fLL == null) {
                this.fLL = new com.baidu.tieba.c.d(this.fFd.getPageContext(), view);
                this.fLL.jN(e.f.bg_tip_blue_up_left);
                this.fLL.jM(16);
                this.fLL.fc(true);
                this.fLL.jQ(57);
                this.fLL.jR(-10);
            }
            this.fLL.jO(5000);
            this.fLL.lP(str);
            bX(str2, str3);
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12504"));
        }
    }

    public void destroy() {
        if (this.fLL != null) {
            this.fLL.amz();
        }
    }

    private void bX(String str, String str2) {
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SUBMIT_PB_SHOW_TIP);
            httpMessage.addParam("thread_user_id", str);
            httpMessage.addParam("thread_id", str2);
            this.fFd.sendMessage(httpMessage);
        }
    }
}
