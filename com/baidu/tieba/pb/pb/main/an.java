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
    private PbActivity fYJ;
    private com.baidu.tieba.c.d gfy;

    public an(PbActivity pbActivity) {
        this.fYJ = pbActivity;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SUBMIT_PB_SHOW_TIP, TbConfig.SERVER_ADDRESS + TbConfig.SUBMIT_SHOW_PB_TIPS);
        tbHttpMessageTask.setResponsedClass(SubmitPbShowTipHttpResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(View view, String str, String str2, String str3) {
        if (view != null && !StringUtils.isNull(str) && view.getVisibility() == 0 && view.getAlpha() >= 0.4d) {
            if (this.gfy == null) {
                this.gfy = new com.baidu.tieba.c.d(this.fYJ.getPageContext(), view);
                this.gfy.li(e.f.bg_tip_blue_up_left);
                this.gfy.lh(16);
                this.gfy.fL(true);
                this.gfy.ll(57);
                this.gfy.setYOffset(-10);
            }
            this.gfy.lj(UIMsg.m_AppUI.MSG_APP_GPS);
            this.gfy.nk(str);
            cp(str2, str3);
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12504"));
        }
    }

    public void destroy() {
        if (this.gfy != null) {
            this.gfy.asz();
        }
    }

    private void cp(String str, String str2) {
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SUBMIT_PB_SHOW_TIP);
            httpMessage.addParam("thread_user_id", str);
            httpMessage.addParam("thread_id", str2);
            this.fYJ.sendMessage(httpMessage);
        }
    }
}
