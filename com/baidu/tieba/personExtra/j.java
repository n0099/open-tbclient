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
    private k grq;
    private SmartApp jYb;
    private com.baidu.tbadk.core.dialog.i jYe;
    private com.baidu.tbadk.core.dialog.g jYf;
    private a jYg;
    private Context mContext;
    private TbPageContext mPageContext;
    private k.b jYh = new k.b() { // from class: com.baidu.tieba.personExtra.j.1
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (j.this.jYb != null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
                httpMessage.addParam("swan_app_key", j.this.jYb.id);
                MessageManager.getInstance().sendMessage(httpMessage);
                if (j.this.jYg != null) {
                    j.this.jYg.Ix(j.this.jYb.id);
                }
                an anVar = new an("c13436");
                anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.t("obj_id", j.this.jYb.swan_app_id.longValue());
                anVar.cI("obj_name", j.this.jYb.name);
                TiebaStatic.log(anVar);
                if (j.this.jYe != null) {
                    j.this.jYe.dismiss();
                }
            }
        }
    };
    private List<com.baidu.tbadk.core.dialog.g> der = new ArrayList();

    /* loaded from: classes11.dex */
    public interface a {
        void Ix(String str);
    }

    static {
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_DEL_BROWSE_HISTORY));
    }

    public j(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.grq = new k(this.mContext);
    }

    public void create() {
        if (this.jYe == null) {
            this.jYf = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.grq);
            this.jYf.a(this.jYh);
            this.der.add(this.jYf);
            this.grq.aI(this.der);
            this.jYe = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.grq);
        }
    }

    public void a(a aVar) {
        this.jYg = aVar;
    }

    public void b(SmartApp smartApp) {
        this.jYb = smartApp;
    }

    public void show() {
        if (this.jYe != null) {
            this.jYe.showDialog();
        }
    }
}
