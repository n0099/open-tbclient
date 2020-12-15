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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.SmartApp;
/* loaded from: classes24.dex */
public class j {
    private k ilP;
    private com.baidu.tbadk.core.dialog.g kIQ;
    private Context mContext;
    private TbPageContext mPageContext;
    private SmartApp mpg;
    private com.baidu.tbadk.core.dialog.i mpj;
    private a mpk;
    private k.b mpl = new k.b() { // from class: com.baidu.tieba.personExtra.j.1
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (j.this.mpg != null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
                httpMessage.addParam("swan_app_key", j.this.mpg.id);
                MessageManager.getInstance().sendMessage(httpMessage);
                if (j.this.mpk != null) {
                    j.this.mpk.Rf(j.this.mpg.id);
                }
                ar arVar = new ar("c13436");
                arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                arVar.w("obj_id", j.this.mpg.swan_app_id.longValue());
                arVar.dY("obj_name", j.this.mpg.name);
                TiebaStatic.log(arVar);
                if (j.this.mpj != null) {
                    j.this.mpj.dismiss();
                }
            }
        }
    };
    private List<com.baidu.tbadk.core.dialog.g> erW = new ArrayList();

    /* loaded from: classes24.dex */
    public interface a {
        void Rf(String str);
    }

    static {
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_DEL_BROWSE_HISTORY));
    }

    public j(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.ilP = new k(this.mContext);
    }

    public void create() {
        if (this.mpj == null) {
            this.kIQ = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.ilP);
            this.kIQ.a(this.mpl);
            this.erW.add(this.kIQ);
            this.ilP.bu(this.erW);
            this.mpj = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.ilP);
        }
    }

    public void a(a aVar) {
        this.mpk = aVar;
    }

    public void b(SmartApp smartApp) {
        this.mpg = smartApp;
    }

    public void show() {
        if (this.mpj != null) {
            this.mpj.RU();
        }
    }
}
