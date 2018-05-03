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
public class k {
    private BdUniqueId aTr;
    private com.baidu.tbadk.core.dialog.f fJD;
    private ArrayList<com.baidu.tbadk.core.dialog.h> fJE;
    private String fJF;
    private String fJG;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.a mWaitingDialog;
    private HttpMessageListener fJH = new HttpMessageListener(CmdConfigHttp.CMD_USER_REPORT) { // from class: com.baidu.tieba.personPolymeric.b.k.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof JsonHttpResponsedMessage) {
                k.this.aas();
                JsonHttpResponsedMessage jsonHttpResponsedMessage = (JsonHttpResponsedMessage) httpResponsedMessage;
                String errorString = jsonHttpResponsedMessage.getErrorString();
                if (StringUtils.isNull(errorString)) {
                    errorString = k.this.mPageContext.getString(jsonHttpResponsedMessage.getError() == 0 ? d.k.report_success : d.k.neterror);
                }
                if (jsonHttpResponsedMessage.getError() == 0) {
                    k.this.fJC.i(errorString);
                } else {
                    k.this.fJC.j(errorString);
                }
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personPolymeric.b.k.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            com.baidu.tbadk.core.dialog.h hVar = (com.baidu.tbadk.core.dialog.h) v.c(k.this.fJE, i);
            if (hVar != null) {
                k.this.fJF = hVar.getTag();
                k.this.fJD.setPositiveButtonEnable(true);
            }
            k.this.fJD.refresh(i);
        }
    };
    private View.OnClickListener adj = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.k.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_USER_REPORT, k.this.aTr);
            httpMessage.addParam("complaint_type", k.this.fJF);
            httpMessage.addParam("complaint_uid", k.this.fJG);
            MessageManager.getInstance().sendMessage(httpMessage);
            k.this.showLoadingDialog();
            k.this.fJD.dismiss();
        }
    };
    private View.OnClickListener fJI = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.k.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            k.this.fJD.dismiss();
        }
    };
    private com.baidu.tbadk.core.view.b fJC = new com.baidu.tbadk.core.view.b();

    public k(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.aTr = bdUniqueId;
        aen();
    }

    private void bfv() {
        this.fJE = new ArrayList<>();
        this.fJE.add(new com.baidu.tbadk.core.dialog.h(this.mPageContext.getString(d.k.report_bad_account_nickname), null, false, "0"));
        this.fJE.add(new com.baidu.tbadk.core.dialog.h(this.mPageContext.getString(d.k.report_illegal_content), null, false, "1"));
        this.fJE.add(new com.baidu.tbadk.core.dialog.h(this.mPageContext.getString(d.k.report_photo_problem), null, false, "2"));
        this.fJE.add(new com.baidu.tbadk.core.dialog.h(this.mPageContext.getString(d.k.report_bad_tail), null, false, "3"));
    }

    private void aen() {
        this.fJH.setTag(this.aTr);
        this.fJH.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.fJH);
    }

    public void jN(String str) {
        bfv();
        this.fJG = str;
        this.fJD = new com.baidu.tbadk.core.dialog.f(this.mPageContext);
        this.fJD.ci(d.k.report_dialog_title);
        this.fJD.a(this.fJE, this.mOnItemClickListener);
        this.fJD.a(d.k.confirm, this.adj);
        this.fJD.b(d.k.cancel, this.fJI);
        this.fJD.tH().tI();
        this.fJD.setPositiveButtonEnable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingDialog() {
        if (this.mWaitingDialog == null) {
            this.mWaitingDialog = new com.baidu.tbadk.core.view.a(this.mPageContext);
            this.mWaitingDialog.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personPolymeric.b.k.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    MessageManager.getInstance().removeMessage(k.this.aTr);
                }
            });
        }
        this.mWaitingDialog.aI(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aas() {
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.aI(false);
        }
    }
}
