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
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a implements com.baidu.tieba.ueg.a {
    private BdUniqueId aqv;
    private HttpMessageListener aqx = new HttpMessageListener(CmdConfigHttp.CMD_UEG_REPORT) { // from class: com.baidu.tieba.pb.pb.report.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof UEGReportResponsedMessage) {
                if (a.this.mWaitingDialog != null) {
                    a.this.mWaitingDialog.aM(false);
                }
                UEGReportResponsedMessage uEGReportResponsedMessage = (UEGReportResponsedMessage) httpResponsedMessage;
                String url = uEGReportResponsedMessage.getUrl();
                if (!StringUtils.isNull(url)) {
                    a.this.rz(url);
                    return;
                }
                String errorString = uEGReportResponsedMessage.getErrorString();
                if (StringUtils.isNull(errorString)) {
                    errorString = a.this.mContext.getString(d.j.neterror);
                }
                a.this.fKl.f(errorString);
            }
        }
    };
    private b fKk = new b();
    private com.baidu.tbadk.core.view.d fKl = new com.baidu.tbadk.core.view.d();
    private Context mContext;
    private com.baidu.tbadk.core.view.a mWaitingDialog;

    public a(Context context) {
        this.mContext = context;
        this.fKl.auS = 1000L;
    }

    @Override // com.baidu.tieba.ueg.a
    public void o(BdUniqueId bdUniqueId) {
        this.aqv = bdUniqueId;
        this.fKk.setTag(bdUniqueId);
        this.aqx.setTag(bdUniqueId);
        this.aqx.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.aqx);
    }

    public void ry(String str) {
        showLoadingDialog();
        this.fKk.ry(str);
    }

    @Override // com.baidu.tieba.ueg.a
    public void kD(String str) {
        showLoadingDialog();
        this.fKk.kD(str);
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
                        MessageManager.getInstance().removeMessage(a.this.aqv);
                    }
                });
            } else {
                return;
            }
        }
        this.mWaitingDialog.aM(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rz(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.mContext, this.mContext.getString(d.j.pb_web_view_report_title), str, true)));
    }
}
