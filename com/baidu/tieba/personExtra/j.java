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
    private SmartApp jlb;
    private com.baidu.tbadk.core.dialog.i jle;
    private com.baidu.tbadk.core.dialog.g jlf;
    private a jlg;
    private Context mContext;
    private TbPageContext mPageContext;
    private k.b jlh = new k.b() { // from class: com.baidu.tieba.personExtra.j.1
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (j.this.jlb != null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
                httpMessage.addParam("swan_app_key", j.this.jlb.id);
                MessageManager.getInstance().sendMessage(httpMessage);
                if (j.this.jlg != null) {
                    j.this.jlg.GB(j.this.jlb.id);
                }
                an anVar = new an("c13436");
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.s("obj_id", j.this.jlb.swan_app_id.longValue());
                anVar.cp("obj_name", j.this.jlb.name);
                TiebaStatic.log(anVar);
                if (j.this.jle != null) {
                    j.this.jle.dismiss();
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
        if (this.jle == null) {
            this.jlf = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.fJp);
            this.jlf.a(this.jlh);
            this.cBg.add(this.jlf);
            this.fJp.az(this.cBg);
            this.jle = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.fJp);
        }
    }

    public void a(a aVar) {
        this.jlg = aVar;
    }

    public void c(SmartApp smartApp) {
        this.jlb = smartApp;
    }

    public void show() {
        if (this.jle != null) {
            this.jle.showDialog();
        }
    }
}
