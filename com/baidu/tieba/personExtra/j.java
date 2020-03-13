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
    private k fMb;
    private SmartApp jmn;
    private com.baidu.tbadk.core.dialog.i jmr;
    private com.baidu.tbadk.core.dialog.g jms;
    private a jmt;
    private Context mContext;
    private TbPageContext mPageContext;
    private k.b jmu = new k.b() { // from class: com.baidu.tieba.personExtra.j.1
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (j.this.jmn != null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
                httpMessage.addParam("swan_app_key", j.this.jmn.id);
                MessageManager.getInstance().sendMessage(httpMessage);
                if (j.this.jmt != null) {
                    j.this.jmt.GQ(j.this.jmn.id);
                }
                an anVar = new an("c13436");
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.s("obj_id", j.this.jmn.swan_app_id.longValue());
                anVar.cy("obj_name", j.this.jmn.name);
                TiebaStatic.log(anVar);
                if (j.this.jmr != null) {
                    j.this.jmr.dismiss();
                }
            }
        }
    };
    private List<com.baidu.tbadk.core.dialog.g> cFg = new ArrayList();

    /* loaded from: classes11.dex */
    public interface a {
        void GQ(String str);
    }

    static {
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_DEL_BROWSE_HISTORY));
    }

    public j(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.fMb = new k(this.mContext);
    }

    public void create() {
        if (this.jmr == null) {
            this.jms = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.fMb);
            this.jms.a(this.jmu);
            this.cFg.add(this.jms);
            this.fMb.az(this.cFg);
            this.jmr = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.fMb);
        }
    }

    public void a(a aVar) {
        this.jmt = aVar;
    }

    public void c(SmartApp smartApp) {
        this.jmn = smartApp;
    }

    public void show() {
        if (this.jmr != null) {
            this.jmr.showDialog();
        }
    }
}
