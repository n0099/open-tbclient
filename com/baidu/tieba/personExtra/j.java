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
    private com.baidu.tbadk.core.dialog.g jpL;
    private SmartApp kUf;
    private com.baidu.tbadk.core.dialog.i kUi;
    private a kUj;
    private Context mContext;
    private TbPageContext mPageContext;
    private k.b kUk = new k.b() { // from class: com.baidu.tieba.personExtra.j.1
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (j.this.kUf != null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
                httpMessage.addParam("swan_app_key", j.this.kUf.id);
                MessageManager.getInstance().sendMessage(httpMessage);
                if (j.this.kUj != null) {
                    j.this.kUj.LC(j.this.kUf.id);
                }
                ap apVar = new ap("c13436");
                apVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                apVar.t("obj_id", j.this.kUf.swan_app_id.longValue());
                apVar.dn("obj_name", j.this.kUf.name);
                TiebaStatic.log(apVar);
                if (j.this.kUi != null) {
                    j.this.kUi.dismiss();
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
        if (this.kUi == null) {
            this.jpL = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.gZb);
            this.jpL.a(this.kUk);
            this.dAT.add(this.jpL);
            this.gZb.aS(this.dAT);
            this.kUi = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.gZb);
        }
    }

    public void a(a aVar) {
        this.kUj = aVar;
    }

    public void b(SmartApp smartApp) {
        this.kUf = smartApp;
    }

    public void show() {
        if (this.kUi != null) {
            this.kUi.showDialog();
        }
    }
}
