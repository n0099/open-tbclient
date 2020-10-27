package com.baidu.tieba.personExtra;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.SmartApp;
/* loaded from: classes24.dex */
public class j {
    private k hUs;
    private com.baidu.tbadk.core.dialog.g koO;
    private SmartApp lUH;
    private com.baidu.tbadk.core.dialog.i lUK;
    private a lUL;
    private Context mContext;
    private TbPageContext mPageContext;
    private k.b lUM = new k.b() { // from class: com.baidu.tieba.personExtra.j.1
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (j.this.lUH != null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
                httpMessage.addParam("swan_app_key", j.this.lUH.id);
                MessageManager.getInstance().sendMessage(httpMessage);
                if (j.this.lUL != null) {
                    j.this.lUL.Qk(j.this.lUH.id);
                }
                aq aqVar = new aq("c13436");
                aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.w("obj_id", j.this.lUH.swan_app_id.longValue());
                aqVar.dR("obj_name", j.this.lUH.name);
                TiebaStatic.log(aqVar);
                if (j.this.lUK != null) {
                    j.this.lUK.dismiss();
                }
            }
        }
    };
    private List<com.baidu.tbadk.core.dialog.g> egJ = new ArrayList();

    /* loaded from: classes24.dex */
    public interface a {
        void Qk(String str);
    }

    static {
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_DEL_BROWSE_HISTORY));
    }

    public j(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.hUs = new k(this.mContext);
    }

    public void create() {
        if (this.lUK == null) {
            this.koO = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.hUs);
            this.koO.a(this.lUM);
            this.egJ.add(this.koO);
            this.hUs.bk(this.egJ);
            this.lUK = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.hUs);
        }
    }

    public void a(a aVar) {
        this.lUL = aVar;
    }

    public void b(SmartApp smartApp) {
        this.lUH = smartApp;
    }

    public void show() {
        if (this.lUK != null) {
            this.lUK.PJ();
        }
    }
}
