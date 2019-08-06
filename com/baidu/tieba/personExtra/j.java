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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.SmartApp;
/* loaded from: classes6.dex */
public class j {
    private k eES;
    private SmartApp ipA;
    private com.baidu.tbadk.core.dialog.i ipD;
    private com.baidu.tbadk.core.dialog.g ipE;
    private a ipF;
    private Context mContext;
    private TbPageContext mPageContext;
    private k.b ipG = new k.b() { // from class: com.baidu.tieba.personExtra.j.1
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (j.this.ipA != null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
                httpMessage.addParam("swan_app_key", j.this.ipA.id);
                MessageManager.getInstance().sendMessage(httpMessage);
                if (j.this.ipF != null) {
                    j.this.ipF.CN(j.this.ipA.id);
                }
                an anVar = new an("c13436");
                anVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.l(VideoPlayActivityConfig.OBJ_ID, j.this.ipA.swan_app_id.longValue());
                anVar.bT("obj_name", j.this.ipA.name);
                TiebaStatic.log(anVar);
                if (j.this.ipD != null) {
                    j.this.ipD.dismiss();
                }
            }
        }
    };
    private List<com.baidu.tbadk.core.dialog.g> bwN = new ArrayList();

    /* loaded from: classes6.dex */
    public interface a {
        void CN(String str);
    }

    static {
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_DEL_BROWSE_HISTORY));
    }

    public j(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.eES = new k(this.mContext);
    }

    public void create() {
        if (this.ipD == null) {
            this.ipE = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.eES);
            this.ipE.a(this.ipG);
            this.bwN.add(this.ipE);
            this.eES.W(this.bwN);
            this.ipD = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.eES.ahd());
        }
    }

    public void a(a aVar) {
        this.ipF = aVar;
    }

    public void c(SmartApp smartApp) {
        this.ipA = smartApp;
    }

    public void show() {
        if (this.ipD != null) {
            this.ipD.showDialog();
        }
    }
}
