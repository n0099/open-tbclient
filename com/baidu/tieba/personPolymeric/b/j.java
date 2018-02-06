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
    private BdUniqueId bII;
    private com.baidu.tbadk.core.dialog.f goZ;
    private ArrayList<com.baidu.tbadk.core.dialog.h> gpa;
    private String gpb;
    private String gpc;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.b mWaitingDialog;
    private HttpMessageListener gpd = new HttpMessageListener(CmdConfigHttp.CMD_USER_REPORT) { // from class: com.baidu.tieba.personPolymeric.b.j.1
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
                    j.this.goY.q(errorString);
                } else {
                    j.this.goY.r(errorString);
                }
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personPolymeric.b.j.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            com.baidu.tbadk.core.dialog.h hVar = (com.baidu.tbadk.core.dialog.h) v.f(j.this.gpa, i);
            if (hVar != null) {
                j.this.gpb = hVar.getTag();
                j.this.goZ.setPositiveButtonEnable(true);
            }
            j.this.goZ.refresh(i);
        }
    };
    private View.OnClickListener aRV = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.j.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_USER_REPORT, j.this.bII);
            httpMessage.addParam("complaint_type", j.this.gpb);
            httpMessage.addParam("complaint_uid", j.this.gpc);
            MessageManager.getInstance().sendMessage(httpMessage);
            j.this.showLoadingDialog();
            j.this.goZ.dismiss();
        }
    };
    private View.OnClickListener gpe = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.j.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j.this.goZ.dismiss();
        }
    };
    private com.baidu.tbadk.core.view.e goY = new com.baidu.tbadk.core.view.e();

    public j(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.bII = bdUniqueId;
        aki();
    }

    private void bkr() {
        this.gpa = new ArrayList<>();
        this.gpa.add(new com.baidu.tbadk.core.dialog.h(this.mPageContext.getString(d.j.report_bad_account_nickname), null, false, "0"));
        this.gpa.add(new com.baidu.tbadk.core.dialog.h(this.mPageContext.getString(d.j.report_illegal_content), null, false, "1"));
        this.gpa.add(new com.baidu.tbadk.core.dialog.h(this.mPageContext.getString(d.j.report_photo_problem), null, false, "2"));
        this.gpa.add(new com.baidu.tbadk.core.dialog.h(this.mPageContext.getString(d.j.report_bad_tail), null, false, "3"));
    }

    private void aki() {
        this.gpd.setTag(this.bII);
        this.gpd.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.gpd);
    }

    public void jJ(String str) {
        bkr();
        this.gpc = str;
        this.goZ = new com.baidu.tbadk.core.dialog.f(this.mPageContext);
        this.goZ.fk(d.j.report_dialog_title);
        this.goZ.a(this.gpa, this.mOnItemClickListener);
        this.goZ.a(d.j.confirm, this.aRV);
        this.goZ.b(d.j.cancel, this.gpe);
        this.goZ.AY().AZ();
        this.goZ.setPositiveButtonEnable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingDialog() {
        if (this.mWaitingDialog == null) {
            this.mWaitingDialog = new com.baidu.tbadk.core.view.b(this.mPageContext);
            this.mWaitingDialog.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personPolymeric.b.j.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    MessageManager.getInstance().removeMessage(j.this.bII);
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
