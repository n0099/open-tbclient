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
public class ak {
    private PbActivity eMB;
    private com.baidu.tieba.d.a eRD;
    private boolean eRE = false;

    public ak(PbActivity pbActivity) {
        this.eMB = pbActivity;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SUBMIT_PB_SHOW_TIP, TbConfig.SERVER_ADDRESS + TbConfig.SUBMIT_SHOW_PB_TIPS);
        tbHttpMessageTask.setResponsedClass(SubmitPbShowTipHttpResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(View view, String str, String str2, String str3) {
        if (!this.eRE && view != null && !StringUtils.isNull(str) && view.getVisibility() == 0) {
            if (this.eRD == null) {
                this.eRD = new com.baidu.tieba.d.a(this.eMB.getPageContext(), view);
                this.eRD.ix(-36);
                this.eRD.iy(-4);
            }
            this.eRD.iv(5000);
            this.eRD.jX(str);
            bD(str2, str3);
            this.eRE = true;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12504"));
        }
    }

    public void destroy() {
        if (this.eRD != null) {
            this.eRD.abQ();
        }
        this.eRE = false;
    }

    private void bD(String str, String str2) {
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SUBMIT_PB_SHOW_TIP);
            httpMessage.addParam("thread_user_id", str);
            httpMessage.addParam("thread_id", str2);
            this.eMB.sendMessage(httpMessage);
        }
    }

    public boolean aTW() {
        return this.eRE;
    }
}
