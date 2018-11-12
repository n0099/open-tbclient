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
    private PbActivity fOe;
    private com.baidu.tieba.c.d fUM;

    public an(PbActivity pbActivity) {
        this.fOe = pbActivity;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SUBMIT_PB_SHOW_TIP, TbConfig.SERVER_ADDRESS + TbConfig.SUBMIT_SHOW_PB_TIPS);
        tbHttpMessageTask.setResponsedClass(SubmitPbShowTipHttpResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(View view, String str, String str2, String str3) {
        if (view != null && !StringUtils.isNull(str) && view.getVisibility() == 0 && view.getAlpha() >= 0.4d) {
            if (this.fUM == null) {
                this.fUM = new com.baidu.tieba.c.d(this.fOe.getPageContext(), view);
                this.fUM.kE(e.f.bg_tip_blue_up_left);
                this.fUM.kD(16);
                this.fUM.fF(true);
                this.fUM.kH(57);
                this.fUM.setYOffset(-10);
            }
            this.fUM.kF(UIMsg.m_AppUI.MSG_APP_GPS);
            this.fUM.ms(str);
            cj(str2, str3);
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12504"));
        }
    }

    public void destroy() {
        if (this.fUM != null) {
            this.fUM.apA();
        }
    }

    private void cj(String str, String str2) {
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SUBMIT_PB_SHOW_TIP);
            httpMessage.addParam("thread_user_id", str);
            httpMessage.addParam("thread_id", str2);
            this.fOe.sendMessage(httpMessage);
        }
    }
}
