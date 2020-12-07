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
    private k ilN;
    private com.baidu.tbadk.core.dialog.g kIO;
    private Context mContext;
    private TbPageContext mPageContext;
    private SmartApp mpe;
    private com.baidu.tbadk.core.dialog.i mph;
    private a mpi;
    private k.b mpj = new k.b() { // from class: com.baidu.tieba.personExtra.j.1
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (j.this.mpe != null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
                httpMessage.addParam("swan_app_key", j.this.mpe.id);
                MessageManager.getInstance().sendMessage(httpMessage);
                if (j.this.mpi != null) {
                    j.this.mpi.Rf(j.this.mpe.id);
                }
                ar arVar = new ar("c13436");
                arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                arVar.w("obj_id", j.this.mpe.swan_app_id.longValue());
                arVar.dY("obj_name", j.this.mpe.name);
                TiebaStatic.log(arVar);
                if (j.this.mph != null) {
                    j.this.mph.dismiss();
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
        this.ilN = new k(this.mContext);
    }

    public void create() {
        if (this.mph == null) {
            this.kIO = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.ilN);
            this.kIO.a(this.mpj);
            this.erW.add(this.kIO);
            this.ilN.bu(this.erW);
            this.mph = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.ilN);
        }
    }

    public void a(a aVar) {
        this.mpi = aVar;
    }

    public void b(SmartApp smartApp) {
        this.mpe = smartApp;
    }

    public void show() {
        if (this.mph != null) {
            this.mph.RU();
        }
    }
}
