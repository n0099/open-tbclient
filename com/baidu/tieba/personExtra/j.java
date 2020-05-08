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
/* loaded from: classes11.dex */
public class j {
    private k grw;
    private SmartApp jYf;
    private com.baidu.tbadk.core.dialog.i jYi;
    private com.baidu.tbadk.core.dialog.g jYj;
    private a jYk;
    private Context mContext;
    private TbPageContext mPageContext;
    private k.b jYl = new k.b() { // from class: com.baidu.tieba.personExtra.j.1
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (j.this.jYf != null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
                httpMessage.addParam("swan_app_key", j.this.jYf.id);
                MessageManager.getInstance().sendMessage(httpMessage);
                if (j.this.jYk != null) {
                    j.this.jYk.IA(j.this.jYf.id);
                }
                an anVar = new an("c13436");
                anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.t("obj_id", j.this.jYf.swan_app_id.longValue());
                anVar.cI("obj_name", j.this.jYf.name);
                TiebaStatic.log(anVar);
                if (j.this.jYi != null) {
                    j.this.jYi.dismiss();
                }
            }
        }
    };
    private List<com.baidu.tbadk.core.dialog.g> dex = new ArrayList();

    /* loaded from: classes11.dex */
    public interface a {
        void IA(String str);
    }

    static {
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_DEL_BROWSE_HISTORY));
    }

    public j(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.grw = new k(this.mContext);
    }

    public void create() {
        if (this.jYi == null) {
            this.jYj = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.grw);
            this.jYj.a(this.jYl);
            this.dex.add(this.jYj);
            this.grw.aI(this.dex);
            this.jYi = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.grw);
        }
    }

    public void a(a aVar) {
        this.jYk = aVar;
    }

    public void b(SmartApp smartApp) {
        this.jYf = smartApp;
    }

    public void show() {
        if (this.jYi != null) {
            this.jYi.showDialog();
        }
    }
}
