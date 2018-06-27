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
public class an {
    private com.baidu.tieba.c.d fDV;
    private PbActivity fxh;

    public an(PbActivity pbActivity) {
        this.fxh = pbActivity;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SUBMIT_PB_SHOW_TIP, TbConfig.SERVER_ADDRESS + TbConfig.SUBMIT_SHOW_PB_TIPS);
        tbHttpMessageTask.setResponsedClass(SubmitPbShowTipHttpResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(View view, String str, String str2, String str3) {
        if (view != null && !StringUtils.isNull(str) && view.getVisibility() == 0 && view.getAlpha() >= 0.4d) {
            if (this.fDV == null) {
                this.fDV = new com.baidu.tieba.c.d(this.fxh.getPageContext(), view);
                this.fDV.jd(d.f.bg_tip_blue_up_left);
                this.fDV.jc(16);
                this.fDV.eK(true);
                this.fDV.jg(57);
                this.fDV.jh(-10);
            }
            this.fDV.je(5000);
            this.fDV.lm(str);
            bT(str2, str3);
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12504"));
        }
    }

    public void destroy() {
        if (this.fDV != null) {
            this.fDV.akn();
        }
    }

    private void bT(String str, String str2) {
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SUBMIT_PB_SHOW_TIP);
            httpMessage.addParam("thread_user_id", str);
            httpMessage.addParam("thread_id", str2);
            this.fxh.sendMessage(httpMessage);
        }
    }
}
