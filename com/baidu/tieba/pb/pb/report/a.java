package com.baidu.tieba.pb.pb.report;

import android.content.Context;
import android.content.DialogInterface;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.e;
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
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class a implements com.baidu.tieba.ueg.a {
    private BdUniqueId aqw;
    private HttpMessageListener aqy = new HttpMessageListener(CmdConfigHttp.CMD_UEG_REPORT) { // from class: com.baidu.tieba.pb.pb.report.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof UEGReportResponsedMessage) {
                if (a.this.mWaitingDialog != null) {
                    a.this.mWaitingDialog.aN(false);
                }
                UEGReportResponsedMessage uEGReportResponsedMessage = (UEGReportResponsedMessage) httpResponsedMessage;
                String url = uEGReportResponsedMessage.getUrl();
                if (!StringUtils.isNull(url)) {
                    a.this.rC(url);
                    return;
                }
                String errorString = uEGReportResponsedMessage.getErrorString();
                if (StringUtils.isNull(errorString)) {
                    errorString = a.this.mContext.getString(f.j.neterror);
                }
                a.this.fKe.f(errorString);
            }
        }
    };
    private b fKd = new b();
    private d fKe = new d();
    private Context mContext;
    private com.baidu.tbadk.core.view.a mWaitingDialog;

    public a(Context context) {
        this.mContext = context;
        this.fKe.auR = 1000L;
    }

    @Override // com.baidu.tieba.ueg.a
    public void o(BdUniqueId bdUniqueId) {
        this.aqw = bdUniqueId;
        this.fKd.setTag(bdUniqueId);
        this.aqy.setTag(bdUniqueId);
        this.aqy.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.aqy);
    }

    public void rB(String str) {
        showLoadingDialog();
        this.fKd.rB(str);
    }

    @Override // com.baidu.tieba.ueg.a
    public void kE(String str) {
        showLoadingDialog();
        this.fKd.kE(str);
    }

    private void showLoadingDialog() {
        TbPageContext tbPageContext;
        if (this.mWaitingDialog == null) {
            e<?> ad = i.ad(this.mContext);
            if (!(ad instanceof TbPageContext)) {
                tbPageContext = null;
            } else {
                tbPageContext = (TbPageContext) ad;
            }
            if (tbPageContext != null) {
                this.mWaitingDialog = new com.baidu.tbadk.core.view.a(tbPageContext);
                this.mWaitingDialog.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.report.a.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        MessageManager.getInstance().removeMessage(a.this.aqw);
                    }
                });
            } else {
                return;
            }
        }
        this.mWaitingDialog.aN(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rC(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.mContext, this.mContext.getString(f.j.pb_web_view_report_title), str, true)));
    }
}
