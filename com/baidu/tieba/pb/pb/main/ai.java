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
    private PbActivity eDo;
    private com.baidu.tieba.d.a eIw;
    private boolean eIx = false;

    public ai(PbActivity pbActivity) {
        this.eDo = pbActivity;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SUBMIT_PB_SHOW_TIP, TbConfig.SERVER_ADDRESS + TbConfig.SUBMIT_SHOW_PB_TIPS);
        tbHttpMessageTask.setResponsedClass(SubmitPbShowTipHttpResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(View view, String str, String str2, String str3) {
        if (!this.eIx && view != null && !StringUtils.isNull(str) && view.getVisibility() == 0) {
            if (this.eIw == null) {
                this.eIw = new com.baidu.tieba.d.a(this.eDo.getPageContext(), view);
                this.eIw.ig(-36);
                this.eIw.ih(-4);
            }
            this.eIw.ie(5000);
            this.eIw.jy(str);
            bG(str2, str3);
            this.eIx = true;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12504"));
        }
    }

    public void destroy() {
        if (this.eIw != null) {
            this.eIw.Zv();
        }
        this.eIx = false;
    }

    private void bG(String str, String str2) {
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SUBMIT_PB_SHOW_TIP);
            httpMessage.addParam("thread_user_id", str);
            httpMessage.addParam("thread_id", str2);
            this.eDo.sendMessage(httpMessage);
        }
    }

    public boolean aQH() {
        return this.eIx;
    }
}
