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
    private k fLM;
    private SmartApp jlZ;
    private com.baidu.tbadk.core.dialog.i jmc;
    private com.baidu.tbadk.core.dialog.g jmd;
    private a jme;
    private Context mContext;
    private TbPageContext mPageContext;
    private k.b jmf = new k.b() { // from class: com.baidu.tieba.personExtra.j.1
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (j.this.jlZ != null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
                httpMessage.addParam("swan_app_key", j.this.jlZ.id);
                MessageManager.getInstance().sendMessage(httpMessage);
                if (j.this.jme != null) {
                    j.this.jme.GP(j.this.jlZ.id);
                }
                an anVar = new an("c13436");
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.s("obj_id", j.this.jlZ.swan_app_id.longValue());
                anVar.cy("obj_name", j.this.jlZ.name);
                TiebaStatic.log(anVar);
                if (j.this.jmc != null) {
                    j.this.jmc.dismiss();
                }
            }
        }
    };
    private List<com.baidu.tbadk.core.dialog.g> cFe = new ArrayList();

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
        this.fLM = new k(this.mContext);
    }

    public void create() {
        if (this.jmc == null) {
            this.jmd = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.fLM);
            this.jmd.a(this.jmf);
            this.cFe.add(this.jmd);
            this.fLM.az(this.cFe);
            this.jmc = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.fLM);
        }
    }

    public void a(a aVar) {
        this.jme = aVar;
    }

    public void c(SmartApp smartApp) {
        this.jlZ = smartApp;
    }

    public void show() {
        if (this.jmc != null) {
            this.jmc.showDialog();
        }
    }
}
