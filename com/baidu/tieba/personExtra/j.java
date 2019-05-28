package com.baidu.tieba.personExtra;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.SmartApp;
/* loaded from: classes6.dex */
public class j {
    private k ezP;
    private SmartApp iid;
    private com.baidu.tbadk.core.dialog.i iig;
    private com.baidu.tbadk.core.dialog.g iih;
    private a iii;
    private Context mContext;
    private TbPageContext mPageContext;
    private k.b iij = new k.b() { // from class: com.baidu.tieba.personExtra.j.1
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (j.this.iid != null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
                httpMessage.addParam("swan_app_key", j.this.iid.id);
                MessageManager.getInstance().sendMessage(httpMessage);
                if (j.this.iii != null) {
                    j.this.iii.BX(j.this.iid.id);
                }
                am amVar = new am("c13436");
                amVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                amVar.l(VideoPlayActivityConfig.OBJ_ID, j.this.iid.swan_app_id.longValue());
                amVar.bT("obj_name", j.this.iid.name);
                TiebaStatic.log(amVar);
                if (j.this.iig != null) {
                    j.this.iig.dismiss();
                }
            }
        }
    };
    private List<com.baidu.tbadk.core.dialog.g> bvX = new ArrayList();

    /* loaded from: classes6.dex */
    public interface a {
        void BX(String str);
    }

    static {
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_DEL_BROWSE_HISTORY));
    }

    public j(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.ezP = new k(this.mContext);
    }

    public void create() {
        if (this.iig == null) {
            this.iih = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.ezP);
            this.iih.a(this.iij);
            this.bvX.add(this.iih);
            this.ezP.W(this.bvX);
            this.iig = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.ezP.afZ());
        }
    }

    public void a(a aVar) {
        this.iii = aVar;
    }

    public void c(SmartApp smartApp) {
        this.iid = smartApp;
    }

    public void show() {
        if (this.iig != null) {
            this.iig.showDialog();
        }
    }
}
