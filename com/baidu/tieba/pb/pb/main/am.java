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
    private PbActivity fgM;
    private com.baidu.tieba.d.c fnw;

    public am(PbActivity pbActivity) {
        this.fgM = pbActivity;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SUBMIT_PB_SHOW_TIP, TbConfig.SERVER_ADDRESS + TbConfig.SUBMIT_SHOW_PB_TIPS);
        tbHttpMessageTask.setResponsedClass(SubmitPbShowTipHttpResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(View view2, String str, String str2, String str3) {
        if (view2 != null && !StringUtils.isNull(str) && view2.getVisibility() == 0 && view2.getAlpha() >= 0.4d) {
            if (this.fnw == null) {
                this.fnw = new com.baidu.tieba.d.c(this.fgM.getPageContext(), view2);
                this.fnw.jd(d.f.bg_tip_blue_up_left);
                this.fnw.jc(16);
                this.fnw.eF(true);
                this.fnw.jg(57);
                this.fnw.jh(-10);
            }
            this.fnw.je(5000);
            this.fnw.kJ(str);
            bH(str2, str3);
            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12504"));
        }
    }

    public void destroy() {
        if (this.fnw != null) {
            this.fnw.ahf();
        }
    }

    private void bH(String str, String str2) {
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SUBMIT_PB_SHOW_TIP);
            httpMessage.addParam("thread_user_id", str);
            httpMessage.addParam("thread_id", str2);
            this.fgM.sendMessage(httpMessage);
        }
    }
}
