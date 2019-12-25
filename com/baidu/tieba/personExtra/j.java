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
/* loaded from: classes8.dex */
public class j {
    private k fGf;
    private com.baidu.tbadk.core.dialog.i jhC;
    private com.baidu.tbadk.core.dialog.g jhD;
    private a jhE;
    private SmartApp jhz;
    private Context mContext;
    private TbPageContext mPageContext;
    private k.b jhF = new k.b() { // from class: com.baidu.tieba.personExtra.j.1
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (j.this.jhz != null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
                httpMessage.addParam("swan_app_key", j.this.jhz.id);
                MessageManager.getInstance().sendMessage(httpMessage);
                if (j.this.jhE != null) {
                    j.this.jhE.Gr(j.this.jhz.id);
                }
                an anVar = new an("c13436");
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.s("obj_id", j.this.jhz.swan_app_id.longValue());
                anVar.cp("obj_name", j.this.jhz.name);
                TiebaStatic.log(anVar);
                if (j.this.jhC != null) {
                    j.this.jhC.dismiss();
                }
            }
        }
    };
    private List<com.baidu.tbadk.core.dialog.g> cAV = new ArrayList();

    /* loaded from: classes8.dex */
    public interface a {
        void Gr(String str);
    }

    static {
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_DEL_BROWSE_HISTORY));
    }

    public j(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.fGf = new k(this.mContext);
    }

    public void create() {
        if (this.jhC == null) {
            this.jhD = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.fGf);
            this.jhD.a(this.jhF);
            this.cAV.add(this.jhD);
            this.fGf.aA(this.cAV);
            this.jhC = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.fGf);
        }
    }

    public void a(a aVar) {
        this.jhE = aVar;
    }

    public void c(SmartApp smartApp) {
        this.jhz = smartApp;
    }

    public void show() {
        if (this.jhC != null) {
            this.jhC.showDialog();
        }
    }
}
