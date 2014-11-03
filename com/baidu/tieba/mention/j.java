package com.baidu.tieba.mention;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tieba.data.ar;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask<Object, Integer, String> {
    ArrayList<BasicNameValuePair> bng;
    final /* synthetic */ c bnx;
    private final int bny;
    private String mUrl;
    private String mUserName;
    private com.baidu.tbadk.core.util.ac yV;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        super.onPreExecute();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(Object... objArr) {
        try {
            this.yV = new com.baidu.tbadk.core.util.ac(this.mUrl);
            this.yV.h(this.bng);
            return this.yV.lA();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        Activity activity;
        Activity activity2;
        Activity activity3;
        Activity activity4;
        Activity activity5;
        Activity activity6;
        Activity activity7;
        Activity activity8;
        Activity activity9;
        Activity activity10;
        try {
            if (this.yV != null && this.yV.mc().nb().jq()) {
                if (this.bny == 1) {
                    com.baidu.tieba.data.ah ahVar = new com.baidu.tieba.data.ah();
                    ahVar.parserJson(str);
                    com.baidu.tieba.data.ak akVar = ahVar.zN().get(0);
                    if (akVar != null) {
                        int i = 0;
                        if (ahVar.getUserData() != null) {
                            i = ahVar.getUserData().getIsMem();
                        }
                        if (akVar.getId() != null) {
                            if (ahVar.jZ() == null || ahVar.jZ().getIfpost() != 0) {
                                activity9 = this.bnx.mActivity;
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteActivityConfig(activity9, 2, ahVar.zL().getId(), ahVar.zL().getName(), ahVar.zM().getId(), akVar.getId(), akVar.Ag(), ahVar.jZ(), 13001, false, ahVar.zR(), this.mUserName, false, false, null, null, null, i)));
                            } else {
                                activity10 = this.bnx.mActivity;
                                com.baidu.adp.lib.util.m.showToast(activity10, ahVar.jZ().getForbid_info());
                                return;
                            }
                        } else if (ahVar.jZ() == null || ahVar.jZ().getIfpost() != 0) {
                            activity7 = this.bnx.mActivity;
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteActivityConfig(activity7, 1, ahVar.zL().getId(), ahVar.zL().getName(), ahVar.zM().getId(), null, akVar.Ag(), ahVar.jZ(), 13002, false, ahVar.zR(), this.mUserName, false, false, null, null, null, i)));
                        } else {
                            activity8 = this.bnx.mActivity;
                            com.baidu.adp.lib.util.m.showToast(activity8, ahVar.jZ().getForbid_info());
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (this.bny == 2) {
                    activity2 = this.bnx.mActivity;
                    ar TO = new com.baidu.tieba.model.an(activity2, str).TO();
                    String id = TO.Ay().getId();
                    String name = TO.Ay().getName();
                    String id2 = TO.AA().getId();
                    AntiData Ap = TO.Ap();
                    String id3 = TO.Au().getId();
                    int Ag = TO.Au().Ag();
                    if (id3 != null) {
                        if (Ap == null || Ap.getIfpost() != 0) {
                            activity5 = this.bnx.mActivity;
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteActivityConfig(activity5, 2, id, name, id2, id3, Ag, Ap, 13001, false, true, this.mUserName, false, false, null, null, null, 0)));
                        } else {
                            activity6 = this.bnx.mActivity;
                            com.baidu.adp.lib.util.m.showToast(activity6, Ap.getForbid_info());
                            return;
                        }
                    } else if (Ap == null || Ap.getIfpost() != 0) {
                        activity3 = this.bnx.mActivity;
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteActivityConfig(activity3, 1, id, name, id2, null, Ag, Ap, 13002, false, true, this.mUserName, false, false, null, null, null, 0)));
                    } else {
                        activity4 = this.bnx.mActivity;
                        com.baidu.adp.lib.util.m.showToast(activity4, Ap.getForbid_info());
                        return;
                    }
                }
            } else if (this.yV != null) {
                activity = this.bnx.mActivity;
                com.baidu.adp.lib.util.m.showToast(activity, this.yV.getErrorString());
            }
        } catch (Exception e) {
        }
        this.bnx.bnu = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.yV != null) {
            this.yV.dM();
        }
        super.cancel(true);
    }
}
