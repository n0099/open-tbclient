package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class ai {
    private PbActivity eDC;
    private com.baidu.tieba.d.a eIK;
    private boolean eIL = false;

    public ai(PbActivity pbActivity) {
        this.eDC = pbActivity;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SUBMIT_PB_SHOW_TIP, TbConfig.SERVER_ADDRESS + TbConfig.SUBMIT_SHOW_PB_TIPS);
        tbHttpMessageTask.setResponsedClass(SubmitPbShowTipHttpResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(View view, String str, String str2, String str3) {
        if (!this.eIL && view != null && !StringUtils.isNull(str) && view.getVisibility() == 0) {
            if (this.eIK == null) {
                this.eIK = new com.baidu.tieba.d.a(this.eDC.getPageContext(), view);
                this.eIK.ih(-36);
                this.eIK.ii(-4);
            }
            this.eIK.m11if(5000);
            this.eIK.jz(str);
            bH(str2, str3);
            this.eIL = true;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12504"));
        }
    }

    public void destroy() {
        if (this.eIK != null) {
            this.eIK.Zz();
        }
        this.eIL = false;
    }

    private void bH(String str, String str2) {
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SUBMIT_PB_SHOW_TIP);
            httpMessage.addParam("thread_user_id", str);
            httpMessage.addParam("thread_id", str2);
            this.eDC.sendMessage(httpMessage);
        }
    }

    public boolean aQM() {
        return this.eIL;
    }
}
