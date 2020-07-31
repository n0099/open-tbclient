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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.SmartApp;
/* loaded from: classes18.dex */
public class j {
    private k gZb;
    private com.baidu.tbadk.core.dialog.g jpJ;
    private SmartApp kUd;
    private com.baidu.tbadk.core.dialog.i kUg;
    private a kUh;
    private Context mContext;
    private TbPageContext mPageContext;
    private k.b kUi = new k.b() { // from class: com.baidu.tieba.personExtra.j.1
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (j.this.kUd != null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
                httpMessage.addParam("swan_app_key", j.this.kUd.id);
                MessageManager.getInstance().sendMessage(httpMessage);
                if (j.this.kUh != null) {
                    j.this.kUh.LC(j.this.kUd.id);
                }
                ap apVar = new ap("c13436");
                apVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                apVar.t("obj_id", j.this.kUd.swan_app_id.longValue());
                apVar.dn("obj_name", j.this.kUd.name);
                TiebaStatic.log(apVar);
                if (j.this.kUg != null) {
                    j.this.kUg.dismiss();
                }
            }
        }
    };
    private List<com.baidu.tbadk.core.dialog.g> dAT = new ArrayList();

    /* loaded from: classes18.dex */
    public interface a {
        void LC(String str);
    }

    static {
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_DEL_BROWSE_HISTORY));
    }

    public j(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.gZb = new k(this.mContext);
    }

    public void create() {
        if (this.kUg == null) {
            this.jpJ = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.gZb);
            this.jpJ.a(this.kUi);
            this.dAT.add(this.jpJ);
            this.gZb.aS(this.dAT);
            this.kUg = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.gZb);
        }
    }

    public void a(a aVar) {
        this.kUh = aVar;
    }

    public void b(SmartApp smartApp) {
        this.kUd = smartApp;
    }

    public void show() {
        if (this.kUg != null) {
            this.kUg.showDialog();
        }
    }
}
