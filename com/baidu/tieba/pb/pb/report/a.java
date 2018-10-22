package com.baidu.tieba.pb.pb.report;

import android.content.Context;
import android.content.DialogInterface;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.view.d;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class a implements com.baidu.tieba.ueg.a {
    private BdUniqueId axF;
    private HttpMessageListener axH = new HttpMessageListener(CmdConfigHttp.CMD_UEG_REPORT) { // from class: com.baidu.tieba.pb.pb.report.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof UEGReportResponsedMessage) {
                if (a.this.mWaitingDialog != null) {
                    a.this.mWaitingDialog.bj(false);
                }
                UEGReportResponsedMessage uEGReportResponsedMessage = (UEGReportResponsedMessage) httpResponsedMessage;
                String url = uEGReportResponsedMessage.getUrl();
                if (!StringUtils.isNull(url)) {
                    a.this.sK(url);
                    return;
                }
                String errorString = uEGReportResponsedMessage.getErrorString();
                if (StringUtils.isNull(errorString)) {
                    errorString = a.this.mContext.getString(e.j.neterror);
                }
                a.this.fZk.f(errorString);
            }
        }
    };
    private b fZj = new b();
    private g fZk = new g();
    private Context mContext;
    private d mWaitingDialog;

    public a(Context context) {
        this.mContext = context;
        this.fZk.aCM = 1000L;
    }

    @Override // com.baidu.tieba.ueg.a
    public void o(BdUniqueId bdUniqueId) {
        this.axF = bdUniqueId;
        this.fZj.setTag(bdUniqueId);
        this.axH.setTag(bdUniqueId);
        this.axH.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.axH);
    }

    public void sJ(String str) {
        showLoadingDialog();
        this.fZj.sJ(str);
    }

    @Override // com.baidu.tieba.ueg.a
    public void lK(String str) {
        showLoadingDialog();
        this.fZj.lK(str);
    }

    private void showLoadingDialog() {
        TbPageContext tbPageContext;
        if (this.mWaitingDialog == null) {
            com.baidu.adp.base.e<?> aK = i.aK(this.mContext);
            if (!(aK instanceof TbPageContext)) {
                tbPageContext = null;
            } else {
                tbPageContext = (TbPageContext) aK;
            }
            if (tbPageContext != null) {
                this.mWaitingDialog = new d(tbPageContext);
                this.mWaitingDialog.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.report.a.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        MessageManager.getInstance().removeMessage(a.this.axF);
                    }
                });
            } else {
                return;
            }
        }
        this.mWaitingDialog.bj(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sK(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.mContext, this.mContext.getString(e.j.pb_web_view_report_title), str, true)));
    }
}
