package com.baidu.tieba.personPolymeric.b;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class j {
    private BdUniqueId bIy;
    private com.baidu.tbadk.core.dialog.f gpe;
    private ArrayList<com.baidu.tbadk.core.dialog.h> gpf;
    private String gpg;
    private String gph;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.b mWaitingDialog;
    private HttpMessageListener gpi = new HttpMessageListener(CmdConfigHttp.CMD_USER_REPORT) { // from class: com.baidu.tieba.personPolymeric.b.j.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof JsonHttpResponsedMessage) {
                j.this.agg();
                JsonHttpResponsedMessage jsonHttpResponsedMessage = (JsonHttpResponsedMessage) httpResponsedMessage;
                String errorString = jsonHttpResponsedMessage.getErrorString();
                if (StringUtils.isNull(errorString)) {
                    errorString = j.this.mPageContext.getString(jsonHttpResponsedMessage.getError() == 0 ? d.j.report_success : d.j.neterror);
                }
                if (jsonHttpResponsedMessage.getError() == 0) {
                    j.this.gpd.q(errorString);
                } else {
                    j.this.gpd.r(errorString);
                }
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personPolymeric.b.j.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            com.baidu.tbadk.core.dialog.h hVar = (com.baidu.tbadk.core.dialog.h) v.f(j.this.gpf, i);
            if (hVar != null) {
                j.this.gpg = hVar.getTag();
                j.this.gpe.setPositiveButtonEnable(true);
            }
            j.this.gpe.refresh(i);
        }
    };
    private View.OnClickListener aRM = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.j.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_USER_REPORT, j.this.bIy);
            httpMessage.addParam("complaint_type", j.this.gpg);
            httpMessage.addParam("complaint_uid", j.this.gph);
            MessageManager.getInstance().sendMessage(httpMessage);
            j.this.showLoadingDialog();
            j.this.gpe.dismiss();
        }
    };
    private View.OnClickListener gpj = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.j.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j.this.gpe.dismiss();
        }
    };
    private com.baidu.tbadk.core.view.e gpd = new com.baidu.tbadk.core.view.e();

    public j(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.bIy = bdUniqueId;
        aki();
    }

    private void bkr() {
        this.gpf = new ArrayList<>();
        this.gpf.add(new com.baidu.tbadk.core.dialog.h(this.mPageContext.getString(d.j.report_bad_account_nickname), null, false, "0"));
        this.gpf.add(new com.baidu.tbadk.core.dialog.h(this.mPageContext.getString(d.j.report_illegal_content), null, false, "1"));
        this.gpf.add(new com.baidu.tbadk.core.dialog.h(this.mPageContext.getString(d.j.report_photo_problem), null, false, "2"));
        this.gpf.add(new com.baidu.tbadk.core.dialog.h(this.mPageContext.getString(d.j.report_bad_tail), null, false, "3"));
    }

    private void aki() {
        this.gpi.setTag(this.bIy);
        this.gpi.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.gpi);
    }

    public void jJ(String str) {
        bkr();
        this.gph = str;
        this.gpe = new com.baidu.tbadk.core.dialog.f(this.mPageContext);
        this.gpe.fk(d.j.report_dialog_title);
        this.gpe.a(this.gpf, this.mOnItemClickListener);
        this.gpe.a(d.j.confirm, this.aRM);
        this.gpe.b(d.j.cancel, this.gpj);
        this.gpe.AZ().Ba();
        this.gpe.setPositiveButtonEnable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingDialog() {
        if (this.mWaitingDialog == null) {
            this.mWaitingDialog = new com.baidu.tbadk.core.view.b(this.mPageContext);
            this.mWaitingDialog.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personPolymeric.b.j.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    MessageManager.getInstance().removeMessage(j.this.bIy);
                }
            });
        }
        this.mWaitingDialog.bq(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agg() {
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.bq(false);
        }
    }
}
