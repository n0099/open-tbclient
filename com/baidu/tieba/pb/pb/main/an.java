package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class an {
    private PbActivity fUU;
    private com.baidu.tieba.c.d gbC;

    public an(PbActivity pbActivity) {
        this.fUU = pbActivity;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SUBMIT_PB_SHOW_TIP, TbConfig.SERVER_ADDRESS + TbConfig.SUBMIT_SHOW_PB_TIPS);
        tbHttpMessageTask.setResponsedClass(SubmitPbShowTipHttpResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(View view, String str, String str2, String str3) {
        if (view != null && !StringUtils.isNull(str) && view.getVisibility() == 0 && view.getAlpha() >= 0.4d) {
            if (this.gbC == null) {
                this.gbC = new com.baidu.tieba.c.d(this.fUU.getPageContext(), view);
                this.gbC.kU(e.f.bg_tip_blue_up_left);
                this.gbC.kT(16);
                this.gbC.fG(true);
                this.gbC.kX(57);
                this.gbC.setYOffset(-10);
            }
            this.gbC.kV(UIMsg.m_AppUI.MSG_APP_GPS);
            this.gbC.mR(str);
            co(str2, str3);
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12504"));
        }
    }

    public void destroy() {
        if (this.gbC != null) {
            this.gbC.arm();
        }
    }

    private void co(String str, String str2) {
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SUBMIT_PB_SHOW_TIP);
            httpMessage.addParam("thread_user_id", str);
            httpMessage.addParam("thread_id", str2);
            this.fUU.sendMessage(httpMessage);
        }
    }
}
