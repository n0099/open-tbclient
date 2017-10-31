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
    private PbActivity eMh;
    private com.baidu.tieba.d.a eRj;
    private boolean eRk = false;

    public ak(PbActivity pbActivity) {
        this.eMh = pbActivity;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SUBMIT_PB_SHOW_TIP, TbConfig.SERVER_ADDRESS + TbConfig.SUBMIT_SHOW_PB_TIPS);
        tbHttpMessageTask.setResponsedClass(SubmitPbShowTipHttpResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(View view, String str, String str2, String str3) {
        if (!this.eRk && view != null && !StringUtils.isNull(str) && view.getVisibility() == 0) {
            if (this.eRj == null) {
                this.eRj = new com.baidu.tieba.d.a(this.eMh.getPageContext(), view);
                this.eRj.iz(-36);
                this.eRj.iA(-4);
            }
            this.eRj.ix(5000);
            this.eRj.jW(str);
            bC(str2, str3);
            this.eRk = true;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12504"));
        }
    }

    public void destroy() {
        if (this.eRj != null) {
            this.eRj.abE();
        }
        this.eRk = false;
    }

    private void bC(String str, String str2) {
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SUBMIT_PB_SHOW_TIP);
            httpMessage.addParam("thread_user_id", str);
            httpMessage.addParam("thread_id", str2);
            this.eMh.sendMessage(httpMessage);
        }
    }

    public boolean aTO() {
        return this.eRk;
    }
}
