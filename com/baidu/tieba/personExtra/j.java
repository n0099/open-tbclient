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
    private k fLO;
    private SmartApp jmb;
    private com.baidu.tbadk.core.dialog.i jme;
    private com.baidu.tbadk.core.dialog.g jmf;
    private a jmg;
    private Context mContext;
    private TbPageContext mPageContext;
    private k.b jmh = new k.b() { // from class: com.baidu.tieba.personExtra.j.1
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (j.this.jmb != null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
                httpMessage.addParam("swan_app_key", j.this.jmb.id);
                MessageManager.getInstance().sendMessage(httpMessage);
                if (j.this.jmg != null) {
                    j.this.jmg.GP(j.this.jmb.id);
                }
                an anVar = new an("c13436");
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.s("obj_id", j.this.jmb.swan_app_id.longValue());
                anVar.cy("obj_name", j.this.jmb.name);
                TiebaStatic.log(anVar);
                if (j.this.jme != null) {
                    j.this.jme.dismiss();
                }
            }
        }
    };
    private List<com.baidu.tbadk.core.dialog.g> cFf = new ArrayList();

    /* loaded from: classes11.dex */
    public interface a {
        void GP(String str);
    }

    static {
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_DEL_BROWSE_HISTORY));
    }

    public j(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.fLO = new k(this.mContext);
    }

    public void create() {
        if (this.jme == null) {
            this.jmf = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.fLO);
            this.jmf.a(this.jmh);
            this.cFf.add(this.jmf);
            this.fLO.az(this.cFf);
            this.jme = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.fLO);
        }
    }

    public void a(a aVar) {
        this.jmg = aVar;
    }

    public void c(SmartApp smartApp) {
        this.jmb = smartApp;
    }

    public void show() {
        if (this.jme != null) {
            this.jme.showDialog();
        }
    }
}
