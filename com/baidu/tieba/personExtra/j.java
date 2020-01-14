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
/* loaded from: classes9.dex */
public class j {
    private k fJp;
    private SmartApp jlg;
    private com.baidu.tbadk.core.dialog.i jlj;
    private com.baidu.tbadk.core.dialog.g jlk;
    private a jll;
    private Context mContext;
    private TbPageContext mPageContext;
    private k.b jlm = new k.b() { // from class: com.baidu.tieba.personExtra.j.1
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (j.this.jlg != null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
                httpMessage.addParam("swan_app_key", j.this.jlg.id);
                MessageManager.getInstance().sendMessage(httpMessage);
                if (j.this.jll != null) {
                    j.this.jll.GB(j.this.jlg.id);
                }
                an anVar = new an("c13436");
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.s("obj_id", j.this.jlg.swan_app_id.longValue());
                anVar.cp("obj_name", j.this.jlg.name);
                TiebaStatic.log(anVar);
                if (j.this.jlj != null) {
                    j.this.jlj.dismiss();
                }
            }
        }
    };
    private List<com.baidu.tbadk.core.dialog.g> cBg = new ArrayList();

    /* loaded from: classes9.dex */
    public interface a {
        void GB(String str);
    }

    static {
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_DEL_BROWSE_HISTORY));
    }

    public j(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.fJp = new k(this.mContext);
    }

    public void create() {
        if (this.jlj == null) {
            this.jlk = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.fJp);
            this.jlk.a(this.jlm);
            this.cBg.add(this.jlk);
            this.fJp.az(this.cBg);
            this.jlj = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.fJp);
        }
    }

    public void a(a aVar) {
        this.jll = aVar;
    }

    public void c(SmartApp smartApp) {
        this.jlg = smartApp;
    }

    public void show() {
        if (this.jlj != null) {
            this.jlj.showDialog();
        }
    }
}
