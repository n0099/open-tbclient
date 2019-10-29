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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.SmartApp;
/* loaded from: classes6.dex */
public class j {
    private k ePi;
    private SmartApp ipZ;
    private com.baidu.tbadk.core.dialog.i iqc;
    private com.baidu.tbadk.core.dialog.g iqd;
    private a iqe;
    private Context mContext;
    private TbPageContext mPageContext;
    private k.b iqf = new k.b() { // from class: com.baidu.tieba.personExtra.j.1
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (j.this.ipZ != null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
                httpMessage.addParam("swan_app_key", j.this.ipZ.id);
                MessageManager.getInstance().sendMessage(httpMessage);
                if (j.this.iqe != null) {
                    j.this.iqe.BF(j.this.ipZ.id);
                }
                an anVar = new an("c13436");
                anVar.p("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.p("obj_id", j.this.ipZ.swan_app_id.longValue());
                anVar.bS("obj_name", j.this.ipZ.name);
                TiebaStatic.log(anVar);
                if (j.this.iqc != null) {
                    j.this.iqc.dismiss();
                }
            }
        }
    };
    private List<com.baidu.tbadk.core.dialog.g> bPS = new ArrayList();

    /* loaded from: classes6.dex */
    public interface a {
        void BF(String str);
    }

    static {
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_DEL_BROWSE_HISTORY));
    }

    public j(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.ePi = new k(this.mContext);
    }

    public void create() {
        if (this.iqc == null) {
            this.iqd = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.ePi);
            this.iqd.a(this.iqf);
            this.bPS.add(this.iqd);
            this.ePi.at(this.bPS);
            this.iqc = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.ePi);
        }
    }

    public void a(a aVar) {
        this.iqe = aVar;
    }

    public void c(SmartApp smartApp) {
        this.ipZ = smartApp;
    }

    public void show() {
        if (this.iqc != null) {
            this.iqc.showDialog();
        }
    }
}
