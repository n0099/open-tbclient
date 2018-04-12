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
    private com.baidu.tbadk.core.dialog.f fJG;
    private ArrayList<com.baidu.tbadk.core.dialog.h> fJH;
    private String fJI;
    private String fJJ;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.a mWaitingDialog;
    private HttpMessageListener fJK = new HttpMessageListener(CmdConfigHttp.CMD_USER_REPORT) { // from class: com.baidu.tieba.personPolymeric.b.k.1
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
                    k.this.fJF.i(errorString);
                } else {
                    k.this.fJF.j(errorString);
                }
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personPolymeric.b.k.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            com.baidu.tbadk.core.dialog.h hVar = (com.baidu.tbadk.core.dialog.h) v.c(k.this.fJH, i);
            if (hVar != null) {
                k.this.fJI = hVar.getTag();
                k.this.fJG.setPositiveButtonEnable(true);
            }
            k.this.fJG.refresh(i);
        }
    };
    private View.OnClickListener adj = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.k.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_USER_REPORT, k.this.aTr);
            httpMessage.addParam("complaint_type", k.this.fJI);
            httpMessage.addParam("complaint_uid", k.this.fJJ);
            MessageManager.getInstance().sendMessage(httpMessage);
            k.this.showLoadingDialog();
            k.this.fJG.dismiss();
        }
    };
    private View.OnClickListener fJL = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.k.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            k.this.fJG.dismiss();
        }
    };
    private com.baidu.tbadk.core.view.b fJF = new com.baidu.tbadk.core.view.b();

    public k(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.aTr = bdUniqueId;
        aen();
    }

    private void bfv() {
        this.fJH = new ArrayList<>();
        this.fJH.add(new com.baidu.tbadk.core.dialog.h(this.mPageContext.getString(d.k.report_bad_account_nickname), null, false, "0"));
        this.fJH.add(new com.baidu.tbadk.core.dialog.h(this.mPageContext.getString(d.k.report_illegal_content), null, false, "1"));
        this.fJH.add(new com.baidu.tbadk.core.dialog.h(this.mPageContext.getString(d.k.report_photo_problem), null, false, "2"));
        this.fJH.add(new com.baidu.tbadk.core.dialog.h(this.mPageContext.getString(d.k.report_bad_tail), null, false, "3"));
    }

    private void aen() {
        this.fJK.setTag(this.aTr);
        this.fJK.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.fJK);
    }

    public void jN(String str) {
        bfv();
        this.fJJ = str;
        this.fJG = new com.baidu.tbadk.core.dialog.f(this.mPageContext);
        this.fJG.cj(d.k.report_dialog_title);
        this.fJG.a(this.fJH, this.mOnItemClickListener);
        this.fJG.a(d.k.confirm, this.adj);
        this.fJG.b(d.k.cancel, this.fJL);
        this.fJG.tH().tI();
        this.fJG.setPositiveButtonEnable(false);
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
